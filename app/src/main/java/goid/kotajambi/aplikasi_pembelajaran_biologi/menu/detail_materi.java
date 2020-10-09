package goid.kotajambi.aplikasi_pembelajaran_biologi.menu;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;

import butterknife.BindView;
import butterknife.ButterKnife;
import goid.kotajambi.aplikasi_pembelajaran_biologi.R;

public class detail_materi extends AppCompatActivity {

    @BindView(R.id.pdfView)
    PDFView pdfView;
    String file,judul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_materi);
        ButterKnife.bind(this);

        Bundle b = getIntent().getExtras();
        file = String.valueOf(b.getCharSequence("file"));
        judul = String.valueOf(b.getCharSequence("judul"));
        this.setTitle(judul);
        Log.i("data", "onCreate: "+file);

        pdfView.fromAsset(file)
                .enableSwipe(true)
                .load();

    }
}