package vn.cusc.ihs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import vn.cusc.ihs.DownloadData.DotKhamAdapter;

public class DotKhamActivity extends AppCompatActivity {

    DotKhamAdapter dotKhamAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dot_kham);

        dotKhamAdapter = new DotKhamAdapter(DotKhamActivity.this,null);
        ((ListView)findViewById(R.id.lvDanhSachDotKham)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }


}
