package vn.cusc.ihs;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import vn.cusc.ihs.ThongTinBenhNhan.ThongTinKhamBenh;

public class DotKhamActivity extends Fragment {
    ProgressDialog progressDialog;

    DotKhamAdapter dotKhamAdapter;
    ArrayList<FileHoSo> hoSo;


    public DotKhamActivity(){}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_dot_kham, container, false);
        new Down().execute();
        return rootView;
    }



   /* @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dot_kham);
        new Down().execute();




        *//*((ListView) findViewById(R.id.lvDanhSachDotKham)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });*//*
    }*/

    class Down extends AsyncTask<String, String, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            if(progressDialog == null){
                progressDialog = new ProgressDialog(getActivity());
                progressDialog.setIndeterminate(true);
            }
            progressDialog.setMessage("Vui lòng chờ giây lác!");
            progressDialog.show();
        }

        @Override
        protected String doInBackground(String... strings) {
            DownLoadXML download = new DownLoadXML();
            hoSo = download.download("http://baocaoxml.somee.com/XML/201607140648_GD4930403800886_GiamDinhBHYT_324.XML").getFileHoSoList();
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            XuLyDuLieu xuly = new XuLyDuLieu();
            xuly.getXMLDetail(hoSo);
            progressDialog.hide();
            Intent i = new Intent(getActivity(), ThongTinKhamBenh.class);
            startActivity(i);
        }
    }

}
