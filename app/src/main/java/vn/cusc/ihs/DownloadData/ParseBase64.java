package vn.cusc.ihs.DownloadData;

import android.util.Base64;

import java.util.ArrayList;

/**
 * Created by lnakhang on 8/3/2016.
 */
public class ParseBase64 {

    public ParseBase64() {
    }

    public String Parse(String s) {
        try {
            byte[] tmp = Base64.decode(s, Base64.NO_WRAP);
            String val = new String(tmp, "UTF-8");
            return val;
        }catch (Exception ex)
        {
            return  null;
        }
    }

}
