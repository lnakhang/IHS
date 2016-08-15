package vn.cusc.ihs;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import java.io.InputStream;
import java.io.StringReader;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import vn.cusc.ihs.DownloadData.DotKhamAdapter;
import vn.cusc.ihs.DownloadData.DownLoadXML;
import vn.cusc.ihs.DownloadData.FileHoSo;
import vn.cusc.ihs.DownloadData.ParseBase64;
import vn.cusc.ihs.DownloadData.PhanTich_XML;
import vn.cusc.ihs.DownloadData.PhanTich_XML1;
import vn.cusc.ihs.DownloadData.PhanTich_XML2;
import vn.cusc.ihs.DownloadData.PhanTich_XML3;
import vn.cusc.ihs.DownloadData.XML.XMLBang2;
import vn.cusc.ihs.DownloadData.XML.XMLBang3;
import vn.cusc.ihs.DownloadData.XML_Data;
import vn.cusc.ihs.DownloadData.XuLyDuLieu;

public class DotKhamActivity extends AppCompatActivity {

    DotKhamAdapter dotKhamAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dot_kham);

        dotKhamAdapter = new DotKhamAdapter(DotKhamActivity.this, null);
        ((ListView) findViewById(R.id.lvDanhSachDotKham)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DownLoadXML download = new DownLoadXML();
                PhanTich_XML phanTich_xml = download.download("");
                XuLyDuLieu xuLyDuLieu = new XuLyDuLieu();
                xuLyDuLieu.getXMLDetail(phanTich_xml.getFileHoSoList());
            }
        });
    }

}
