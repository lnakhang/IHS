package vn.cusc.ihs.ThongTinBenhNhan.ChiDinhCLS;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import vn.cusc.ihs.DownloadData.XML.XMLBang3;
import vn.cusc.ihs.R;

public class ListChiDinh extends AppCompatActivity {
    ChiDinhAdapter chiDinhAdapter;
    ArrayList<XMLBang3> lstChiDinh = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_chi_dinh);

        chiDinhAdapter = new ChiDinhAdapter(ListChiDinh.this, lstChiDinh);
        ((ListView) findViewById(R.id.lstChiDinhCLS)).setAdapter(chiDinhAdapter);
    }
}