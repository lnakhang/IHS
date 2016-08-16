package vn.cusc.ihs.ThongTinBenhNhan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import vn.cusc.ihs.DownloadData.PhanTich_XML1;
import vn.cusc.ihs.DownloadData.XML.XMLBang1;
import vn.cusc.ihs.DownloadData.XML_Data;
import vn.cusc.ihs.R;
import vn.cusc.ihs.ThongTinBenhNhan.ChiDinhCLS.ListChiDinh;
import vn.cusc.ihs.ThongTinBenhNhan.Thuoc.ListThuoc;

public class ThongTinKhamBenh extends AppCompatActivity {

    TextView hoten, diachi, gioitinh, chandoan, sotienphatsinh, benhnhandong, phantramthanhtoan, sotheBH;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin_kham_benh);
        init();

        XMLBang1 bang1 = XML_Data.phanTich_xml1.getXMLBang1();

        hoten.setText(bang1.getHO_TEN());
        gioitinh.setText(bang1.getGIOI_TINH());
        diachi.setText(bang1.getDIA_CHI());
        chandoan.setText(bang1.getTEN_BENH());
        sotienphatsinh.setText(bang1.getT_TONGCHI());
        benhnhandong.setText(bang1.getT_BNTT());
        phantramthanhtoan.setText(bang1.getMUC_HUONG());
        sotheBH.setText(bang1.getMA_THE());



        ((Button)findViewById(R.id.btnXemChiDinh)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ThongTinKhamBenh.this, ListChiDinh.class);
                startActivity(i);
            }
        });
        ((Button)findViewById(R.id.btnXemDonThuoc)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ThongTinKhamBenh.this, ListThuoc.class);
                startActivity(i);
            }
        });
    }



    void init() {
        hoten = (TextView) findViewById(R.id.hotenBN);
        gioitinh = (TextView) findViewById(R.id.gioiTinhBN);
        diachi = (TextView) findViewById(R.id.diaChiBN);
        chandoan = (TextView) findViewById(R.id.chanDoan);
        sotienphatsinh = (TextView) findViewById(R.id.chiPhiPhatSinh);
        benhnhandong = (TextView) findViewById(R.id.tienBNDong);
        phantramthanhtoan = (TextView) findViewById(R.id.phanTramThanhToan);
        sotheBH = (TextView) findViewById(R.id.soTheBHYT);


    }

}
