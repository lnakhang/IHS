package vn.cusc.ihs;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import vn.cusc.ihs.DownloadData.DotKhamAdapter;


/**
 * Created by lnakhang on 8/16/2016.
 */
public class ConnectDatabase extends DotKhamActivity {


    public ArrayList<clsDotKham> getListDotKham(String SotheBHYT) {
        new ConnectData().execute(SotheBHYT);
        return arrDotKham;
    }


}
