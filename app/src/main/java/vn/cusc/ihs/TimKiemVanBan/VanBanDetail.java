package vn.cusc.ihs.TimKiemVanBan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import vn.cusc.ihs.R;

public class VanBanDetail extends AppCompatActivity implements View.OnClickListener{
    TextView tvKyHieu, tvNgayKy, tvNguoiKy, tvCoQuan, tvNamBanHanh, tvTapTin, tvTrichYeu;
    Button btnQuayLai, btnXemVanBan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_van_ban_detail);
        getSupportActionBar().hide();
        init();
        Intent intent = getIntent();
        String kyHieuVB = intent.getStringExtra("kyHieuVB");
        String ngayKyVB = intent.getStringExtra("ngayKyVB");
        String nguoiKyVB = intent.getStringExtra("nguoiKyVB");
        String tenCoQuan = intent.getStringExtra("tenCoQuan");
        String trichYeu = intent.getStringExtra("trichYeu");
        String tapTinVB = intent.getStringExtra("tapTinVB");

        tvKyHieu.setText(kyHieuVB);
        tvNgayKy.setText(ngayKyVB);
        tvNguoiKy.setText(nguoiKyVB);
        tvCoQuan.setText(tenCoQuan);
        tvTrichYeu.setText(trichYeu);

        tvTapTin.setText(tapTinVB);

        btnQuayLai.setOnClickListener(this);
        btnXemVanBan.setOnClickListener(this);
    }

    private void init() {
        tvKyHieu = (TextView) findViewById(R.id.tvKyHieu);
        tvNgayKy = (TextView) findViewById(R.id.tvNgayKy);
        tvNguoiKy = (TextView) findViewById(R.id.tvNguoiKy);
        tvCoQuan = (TextView) findViewById(R.id.tvCoQuan);
        tvTrichYeu = (TextView) findViewById(R.id.tvTrichYeu);

        tvTapTin = (TextView) findViewById(R.id.tvTapTin);

        btnQuayLai = (Button) findViewById(R.id.btnQuayLai);
        btnXemVanBan = (Button) findViewById(R.id.btnXemVanBan);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnQuayLai:
                doBack();
                break;
            case R.id.btnXemVanBan:
                loadContent();
        }
    }

    private void loadContent() {
        Intent intent = new Intent(VanBanDetail.this, ViewVanBanActivity.class);
        startActivity(intent);
        finish();
    }

    private void doBack() {
      /*  Intent intent = new Intent(VanBanDetail.this, ListVanBanActivity.class);
        startActivity(intent);*/
        finish();
    }
}
