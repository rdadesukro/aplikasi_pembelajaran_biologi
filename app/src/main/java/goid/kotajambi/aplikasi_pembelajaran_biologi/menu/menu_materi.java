package goid.kotajambi.aplikasi_pembelajaran_biologi.menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

import butterknife.ButterKnife;
import goid.kotajambi.aplikasi_pembelajaran_biologi.R;
import goid.kotajambi.aplikasi_pembelajaran_biologi.adapter.adapter_materi;
import goid.kotajambi.aplikasi_pembelajaran_biologi.adapter.adapter_vidio;
import goid.kotajambi.aplikasi_pembelajaran_biologi.data.Data_materi;
import goid.kotajambi.aplikasi_pembelajaran_biologi.data.Data_vidio;
import goid.kotajambi.aplikasi_pembelajaran_biologi.model.model_materi;
import goid.kotajambi.aplikasi_pembelajaran_biologi.model.model_vidio;

public class menu_materi extends AppCompatActivity {
    public static View.OnClickListener myOnClickListener;
    private static RecyclerView.Adapter adapter;
    private static   RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private static ArrayList<model_materi> data;
    private static ArrayList<Integer> removedItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_materi);

        ButterKnife.bind(this);
        // myOnClickListener = new MyOnClickListener(this);

        recyclerView = (RecyclerView) findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        data = new ArrayList<model_materi>();
        for (int i = 0; i < Data_materi.nameArray.length; i++) {
            data.add(new model_materi(
                    Data_materi.nameArray[i],
                    Data_materi.versionArray[i],
                    Data_materi.id_[i],
                    Data_materi.drawableArray[i]
            ));
        }

        removedItems = new ArrayList<Integer>();

        adapter = new adapter_materi(this,data);
        recyclerView.setAdapter(adapter);

    }
}