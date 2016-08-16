package vn.cusc.ihs.ThongTinBenhNhan.Thuoc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import vn.cusc.ihs.DownloadData.XML.XMLBang2;
import vn.cusc.ihs.DownloadData.XML_Data;
import vn.cusc.ihs.R;

public class ListThuoc extends AppCompatActivity {
    ThuocAdapter thuocAdapter;
    ArrayList<XMLBang2> lstThuoc = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_thuoc);
        getSupportActionBar().hide();
        lstThuoc = XML_Data.phanTich_xml2.getDSChiTietThuoc();

        thuocAdapter = new ThuocAdapter(ListThuoc.this, lstThuoc);
        ((ListView) findViewById(R.id.lvThuoc)).setAdapter(thuocAdapter);

    }
}
