package vn.cusc.ihs;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import java.io.InputStream;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    Connection con;
    String un, pass, db, ip;
    ArrayList<clsDotKham> arrDotKham = new ArrayList<>();
    ArrayList<FileHoSo> hoSo;
    public ListView lvDanhSachDotKham;
    String duongDanXML = "";
    public DotKhamAdapter adapter;

    public DotKhamActivity() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.activity_dot_kham, container, false);

        un = "baocaoxml";
        pass = "lnakhang";
        db = "BAOCAOXML";
        ip = "BAOCAOXML.mssql.somee.com";

        lvDanhSachDotKham = (ListView) rootView.findViewById(R.id.lvDanhSachDotKham);

        ((Button) rootView.findViewById(R.id.btnTimKiemSoTheBHYT)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sotheBHYT = ((TextView) rootView.findViewById(R.id.tvSoTheBH)).getText().toString();
                new ConnectData().execute(sotheBHYT);

                // adapter = new DotKhamAdapter(getActivity(), arrayListDK);

            }
        });
        lvDanhSachDotKham.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                clsDotKham dk = (clsDotKham) adapter.getItem(i);
                duongDanXML = dk.getDuongdanhost() + dk.getDuongdanfile();
                new Down().execute();
            }
        });

        //new Down().execute();
        return rootView;
    }

    class Down extends AsyncTask<String, String, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            if (progressDialog == null) {
                progressDialog = new ProgressDialog(getActivity());
                progressDialog.setIndeterminate(true);
            }
            progressDialog.setMessage("Vui lòng chờ giây lác!");
            progressDialog.show();
        }

        @Override
        protected String doInBackground(String... strings) {
            DownLoadXML download = new DownLoadXML();
            hoSo = download.download(duongDanXML).getFileHoSoList();
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            if (hoSo != null) {
                XuLyDuLieu xuly = new XuLyDuLieu();
                xuly.getXMLDetail(hoSo);
                progressDialog.hide();
                Intent i = new Intent(getActivity(), ThongTinKhamBenh.class);
                startActivity(i);
            } else {
                progressDialog.hide();
                Toast.makeText(getActivity(), "Không lấy được dữ liệu, thử lại! ", Toast.LENGTH_LONG).show();
            }
        }
    }


    class ConnectData extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... strings) {

            try {
                // Connect to database
                con = connectionclass(un, pass, db, ip);
                // Change below query according to your own database.
                String query = "select * from dulieu where SOTHE_BHYT ='" + strings[0] + "'";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    clsDotKham dk = new clsDotKham();
                    dk.setSotheBH(rs.getString("SOTHE_BHYT"));
                    dk.setNgaykham(rs.getString("NGAYKHAM"));
                    dk.setDuongdanfile(rs.getString("DUONGDANFILE"));
                    dk.setDuongdanhost(rs.getString("DUONGDAN_HOST"));
                    arrDotKham.add(dk);
                }
                con.close();
            } catch (Exception ex) {
                ex.getMessage();
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            if (progressDialog == null) {
                progressDialog = new ProgressDialog(getActivity());
                progressDialog.setIndeterminate(true);
            }
            progressDialog.setMessage("Vui lòng chờ giây lác!");
            progressDialog.show();

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (arrDotKham.size() > 0) {
                adapter = new DotKhamAdapter(getActivity(), arrDotKham);
                lvDanhSachDotKham.setAdapter(adapter);
                progressDialog.hide();
            }else
            {
                progressDialog.hide();
            }
        }
    }

    @SuppressLint("NewApi")
    public Connection connectionclass(String user, String password, String database, String server) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection connection = null;
        String ConnectionURL = null;
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            ConnectionURL = "jdbc:jtds:sqlserver://" + server + ";initial catalog=" + database + ";user=" + user + ";password=" + password + ";";
            connection = DriverManager.getConnection(ConnectionURL);
        } catch (SQLException se) {
            Log.e("error here 1 : ", se.getMessage());
        } catch (ClassNotFoundException e) {
            Log.e("error here 2 : ", e.getMessage());
        } catch (Exception e) {
            Log.e("error here 3 : ", e.getMessage());
        }
        return connection;
    }


}
