package goid.kotajambi.aplikasi_pembelajaran_biologi.menu;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import goid.kotajambi.aplikasi_pembelajaran_biologi.R;

public class detail_vidio extends AppCompatActivity {

    @BindView(R.id.videoView)
    VideoView videoView;
    String file;
    String data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_vidio);
        ButterKnife.bind(this);
        getSupportActionBar().hide();
        Bundle b = getIntent().getExtras();
       file = String.valueOf(b.getCharSequence("file"));

       if (file.equals("vd1")){
           data = String.valueOf(R.raw.vd1);
       }else if (file.equals("vd2")){
           data = String.valueOf(R.raw.vd2);
       }else {
           data = String.valueOf(R.raw.vd3);
       }

        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + data));
        //digunakan untuk mengidentifikasi resource seperti lokasi video
        videoView.setMediaController(new MediaController(this));
        //menampilkan media controller video
        videoView.start();
    }
}