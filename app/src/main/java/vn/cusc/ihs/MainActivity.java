package vn.cusc.ihs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import vn.cusc.ihs.DownloadData.ParseBase64;
import vn.cusc.ihs.TimKiemVanBan.ListVanBanActivity;

public class MainActivity extends AppCompatActivity {

    ParseBase64 par;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ((Button)findViewById(R.id.btnVanbanPhapLuat)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ListVanBanActivity.class);
                startActivity(i);
              //  finish();
            }
        });

        ((Button)findViewById(R.id.btnLichSuKham)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, DotKhamActivity.class);
                startActivity(i);
            }
        });

    }


}
