package vn.cusc.ihs.DownloadData;

import java.net.URL;

import org.xml.sax.InputSource;


import java.net.URLConnection;


import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;



/**
 * Created by lnakhang on 8/3/2016.
 */
public class DownLoadXML {

    public PhanTich_XML download(String address) {
        try {
            URL url = new URL(address);
            URLConnection con = url.openConnection();
            InputSource src = new InputSource(con.getInputStream());
            // chuan bi tai nguyen de phan tich xml theo SAX
            SAXParserFactory fax = SAXParserFactory.newInstance();
            SAXParser parser = fax.newSAXParser();
            // tao doi tuong phan tich va nhan du lieu tu webserver
            PhanTich_XML obj = new PhanTich_XML();
            // tien hanh phan tich
            parser.parse(src, obj);
            return obj;
        } catch (Exception ex) {
            return null;
        }
    }
}
