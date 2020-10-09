package goid.kotajambi.aplikasi_pembelajaran_biologi.menu;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.ButterKnife;
import goid.kotajambi.aplikasi_pembelajaran_biologi.R;
import goid.kotajambi.aplikasi_pembelajaran_biologi.adapter.adapter_vidio;
import goid.kotajambi.aplikasi_pembelajaran_biologi.data.Data_vidio;
import goid.kotajambi.aplikasi_pembelajaran_biologi.model.model_vidio;

public class menu_vidio extends AppCompatActivity {

    public static View.OnClickListener myOnClickListener;
    private static RecyclerView.Adapter adapter;
    private static   RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private static ArrayList<model_vidio> data;
    private static ArrayList<Integer> removedItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_vidio);
        ButterKnife.bind(this);
       // myOnClickListener = new MyOnClickListener(this);

        recyclerView = (RecyclerView) findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        data = new ArrayList<model_vidio>();
        for (int i = 0; i < Data_vidio.nameArray.length; i++) {
            data.add(new model_vidio(
                    Data_vidio.nameArray[i],
                    Data_vidio.versionArray[i],
                    Data_vidio.id_[i],
                    Data_vidio.drawableArray[i]
            ));
        }

        removedItems = new ArrayList<Integer>();

        adapter = new adapter_vidio(this,data);
        recyclerView.setAdapter(adapter);

    }

//    private static class MyOnClickListener implements View.OnClickListener {
//
//        private final Context context;
//
//        private MyOnClickListener(Context context) {
//            this.context = context;
//        }
//
//        @Override
//        public void onClick(View v) {
//            removeItem(v);
//        }
//
//        private void removeItem(View v) {
//            int selectedItemPosition = recyclerView.getChildPosition(v);
//            RecyclerView.ViewHolder viewHolder
//                    = recyclerView.findViewHolderForPosition(selectedItemPosition);
//            TextView textViewName
//                    = (TextView) viewHolder.itemView.findViewById(R.id.txt_nama);
//            String selectedName = (String) textViewName.getText();
//            int selectedItemId = -1;
//            for (int i = 0; i < MyData.nameArray.length; i++) {
//                if (selectedName.equals(MyData.nameArray[i])) {
//                    selectedItemId = MyData.id_[i];
//                }
//            }
//            removedItems.add(selectedItemId);
//            data.remove(selectedItemPosition);
//            adapter.notifyItemRemoved(selectedItemPosition);
//        }
//    }
}