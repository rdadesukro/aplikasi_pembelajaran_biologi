package goid.kotajambi.aplikasi_pembelajaran_biologi.adapter;



import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import goid.kotajambi.aplikasi_pembelajaran_biologi.R;
import goid.kotajambi.aplikasi_pembelajaran_biologi.menu.detail_vidio;
import goid.kotajambi.aplikasi_pembelajaran_biologi.menu.menu_vidio;
import goid.kotajambi.aplikasi_pembelajaran_biologi.model.model_vidio;


public class adapter_vidio extends RecyclerView.Adapter<adapter_vidio.MyViewHolder> {

    private ArrayList<model_vidio> dataSet;
    private Context context;
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        TextView textViewVersion;
        ImageView imageViewIcon;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewName = (TextView) itemView.findViewById(R.id.txt_nama);
            this.imageViewIcon = (ImageView) itemView.findViewById(R.id.bg_vidio);
        }
    }

    public adapter_vidio(Context context, ArrayList<model_vidio> data) {
        this.dataSet = data;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.model_vidio, parent, false);

        view.setOnClickListener(menu_vidio.myOnClickListener);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        TextView textViewName = holder.textViewName;
        TextView textViewVersion = holder.textViewVersion;
        ImageView imageView = holder.imageViewIcon;

        textViewName.setText(dataSet.get(listPosition).getNama_materi());
        //textViewVersion.setText(dataSet.get(listPosition).getVersion());
        imageView.setImageResource(dataSet.get(listPosition).getImage());


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, detail_vidio.class);
                Bundle b = new Bundle();
                b.putString("file", String.valueOf(dataSet.get(listPosition).getFile()));
                intent.putExtras(b);
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
