package goid.kotajambi.aplikasi_pembelajaran_biologi.menu;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.balysv.materialripple.MaterialRippleLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import goid.kotajambi.aplikasi_pembelajaran_biologi.R;
import goid.kotajambi.aplikasi_pembelajaran_biologi.model.model_image;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.card_quiz)
    CardView cardQuiz;
    @BindView(R.id.card_keluar)
    CardView cardKeluar;
    @BindView(R.id.card_vidio)
    CardView cardVidio;
    @BindView(R.id.card_materi)
    CardView cardMateri;
    @BindView(R.id.card_profil)
    CardView cardProfil;
    @BindView(R.id.card_ki)
    CardView cardKi;
    @BindView(R.id.card_referensi)
    CardView cardReferensi;


    private View parent_view;
    private ViewPager viewPager;
    private LinearLayout layout_dots;
    private AdapterImageSlider adapterImageSlider;
    private Runnable runnable = null;
    private Handler handler = new Handler();

    private static int[] array_image_place = {
            R.drawable.cover,
            R.drawable.cover,
            R.drawable.cover,
            R.drawable.cover,
            R.drawable.cover,
    };

    private static String[] array_title_place = {
            "Dui fringilla ornare finibus, orci odio",
            "Mauris sagittis non elit quis fermentum",
            "Mauris ultricies augue sit amet est sollicitudin",
            "Suspendisse ornare est ac auctor pulvinar",
            "Vivamus laoreet aliquam ipsum eget pretium",
    };

    private static String[] array_brief_place = {
            "Foggy Hill",
            "The Backpacker",
            "River Forest",
            "Mist Mountain",
            "Side Park",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initToolbar();
        initComponent();
    }

    @OnClick({R.id.card_quiz, R.id.card_keluar, R.id.card_vidio, R.id.card_materi,R.id.card_profil,R.id.card_ki,R.id.card_referensi})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.card_quiz:
                Intent intent = new Intent(getApplicationContext(), menu_quiz.class);
                startActivity(intent);
                break;
            case R.id.card_keluar:
                break;
            case R.id.card_vidio:
                 intent = new Intent(getApplicationContext(), menu_vidio.class);
                startActivity(intent);
                break;
            case R.id.card_materi:
                intent = new Intent(getApplicationContext(), menu_materi.class);
                startActivity(intent);
                break;
            case R.id.card_profil:
                break;
            case R.id.card_ki:
                break;
            case R.id.card_referensi:
                break;
        }
    }
    private void initToolbar() {

//        getSupportActionBar().setTitle("Places");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void initComponent() {
        layout_dots = (LinearLayout) findViewById(R.id.layout_dots);
        viewPager = (ViewPager) findViewById(R.id.pager);
        adapterImageSlider = new AdapterImageSlider(this, new ArrayList<model_image>());

        final List<model_image> items = new ArrayList<>();
        for (int i = 0; i < array_image_place.length; i++) {
            model_image obj = new model_image();
            obj.image = array_image_place[i];
            obj.imageDrw = getResources().getDrawable(obj.image);
            obj.name = array_title_place[i];
            obj.brief = array_brief_place[i];
            items.add(obj);
        }

        adapterImageSlider.setItems(items);
        viewPager.setAdapter(adapterImageSlider);

        // displaying selected image first
        viewPager.setCurrentItem(0);
        addBottomDots(layout_dots, adapterImageSlider.getCount(), 0);
        ((TextView) findViewById(R.id.title)).setText(items.get(0).name);
        ((TextView) findViewById(R.id.brief)).setText(items.get(0).brief);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int pos, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int pos) {
                ((TextView) findViewById(R.id.title)).setText(items.get(pos).name);
                ((TextView) findViewById(R.id.brief)).setText(items.get(pos).brief);
                addBottomDots(layout_dots, adapterImageSlider.getCount(), pos);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        startAutoSlider(adapterImageSlider.getCount());
    }

    private void addBottomDots(LinearLayout layout_dots, int size, int current) {
        ImageView[] dots = new ImageView[size];

        layout_dots.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new ImageView(this);
            int width_height = 15;
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(width_height, width_height));
            params.setMargins(10, 0, 10, 0);
            dots[i].setLayoutParams(params);
            dots[i].setImageResource(R.drawable.shape_circle_outline);
            dots[i].setColorFilter(ContextCompat.getColor(this, R.color.grey_40), PorterDuff.Mode.SRC_ATOP);
            layout_dots.addView(dots[i]);
        }

        if (dots.length > 0) {
            dots[current].setImageResource(R.drawable.shape_circle);
            dots[current].setColorFilter(ContextCompat.getColor(this, R.color.grey_40), PorterDuff.Mode.SRC_ATOP);
        }
    }

    private void startAutoSlider(final int count) {
        runnable = new Runnable() {
            @Override
            public void run() {
                int pos = viewPager.getCurrentItem();
                pos = pos + 1;
                if (pos >= count) pos = 0;
                viewPager.setCurrentItem(pos);
                handler.postDelayed(runnable, 3000);
            }
        };
        handler.postDelayed(runnable, 3000);
    }
    private static class AdapterImageSlider extends PagerAdapter {

        private Activity act;
        private List<model_image> items;

        private AdapterImageSlider.OnItemClickListener onItemClickListener;

        private interface OnItemClickListener {
            void onItemClick(View view, Image obj);
        }

        public void setOnItemClickListener(AdapterImageSlider.OnItemClickListener onItemClickListener) {
            this.onItemClickListener = onItemClickListener;
        }

        // constructor
        private AdapterImageSlider(Activity activity, List<model_image> items) {
            this.act = activity;
            this.items = items;
        }

        @Override
        public int getCount() {
            return this.items.size();
        }

        public model_image getItem(int pos) {
            return items.get(pos);
        }

        public void setItems(List<model_image> items) {
            this.items = items;
            notifyDataSetChanged();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == ((RelativeLayout) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            final model_image o = items.get(position);
            LayoutInflater inflater = (LayoutInflater) act.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View v = inflater.inflate(R.layout.item_slider_image, container, false);

            ImageView image = (ImageView) v.findViewById(R.id.image);
            MaterialRippleLayout lyt_parent = (MaterialRippleLayout) v.findViewById(R.id.lyt_parent);
            Tools.displayImageOriginal(act, image, o.image);
//            lyt_parent.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(final View v) {
//                    if (onItemClickListener != null) {
//                        onItemClickListener.onItemClick(v, o);
//                    }
//                }
//            });

            ((ViewPager) container).addView(v);

            return v;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ((ViewPager) container).removeView((RelativeLayout) object);

        }

    }

    @Override
    public void onDestroy() {
        if (runnable != null) handler.removeCallbacks(runnable);
        super.onDestroy();
    }

}