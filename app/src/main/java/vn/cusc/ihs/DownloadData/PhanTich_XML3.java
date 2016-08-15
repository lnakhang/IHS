package vn.cusc.ihs.DownloadData;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

import vn.cusc.ihs.DownloadData.XML.XMLBang3;

/**
 * Created by cmtien on 8/15/16.
 */
public class PhanTich_XML3 extends DefaultHandler {
    boolean currentElement = false;
    String currentValue = "";

    XMLBang3 chiTietDVKT;
    public XMLBang3 getChiTietDVKT() { return chiTietDVKT; }

    ArrayList<XMLBang3> dsChiTietDVKT;
    public ArrayList<XMLBang3> getDSChiTietDVKT() {
        return dsChiTietDVKT;
    }


    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {

        currentElement = true;

        if (qName.equals("DSACH_CHI_TIET_DVKT")) {
            dsChiTietDVKT = new ArrayList<XMLBang3>();
        } else if (qName.equals("CHI_TIET_DVKT")) {
            chiTietDVKT = new XMLBang3();
        }
    }

    public void endElement(String uri, String localName, String qName)
            throws SAXException {

        currentElement = false;

        if (qName.equalsIgnoreCase("MA_LK"))
            chiTietDVKT.setMA_LK(currentValue.trim());
        else if (qName.equalsIgnoreCase("STT"))
            chiTietDVKT.setSTT(currentValue.trim());
        else if (qName.equalsIgnoreCase("MA_DICH_VU"))
            chiTietDVKT.setMA_DICH_VU(currentValue.trim());
        else if (qName.equalsIgnoreCase("MA_VAT_TU"))
            chiTietDVKT.setMA_VAT_TU(currentValue.trim());
        else if (qName.equalsIgnoreCase("MA_NHOM"))
            chiTietDVKT.setMA_NHOM(currentValue.trim());
        else if (qName.equalsIgnoreCase("TEN_DICH_VU"))
            chiTietDVKT.setTEN_DICH_VU(currentValue.trim());
        else if (qName.equalsIgnoreCase("DON_VI_TINH"))
            chiTietDVKT.setDON_VI_TINH(currentValue.trim());
        else if (qName.equalsIgnoreCase("SO_LUONG"))
            chiTietDVKT.setSO_LUONG(currentValue.trim());
        else if (qName.equalsIgnoreCase("DON_GIA"))
            chiTietDVKT.setDON_GIA(currentValue.trim());
        else if (qName.equalsIgnoreCase("TYLE_TT"))
            chiTietDVKT.setTYLE_TT(currentValue.trim());
        else if (qName.equalsIgnoreCase("THANH_TIEN"))
            chiTietDVKT.setTHANH_TIEN(currentValue.trim());
        else if (qName.equalsIgnoreCase("MA_KHOA"))
            chiTietDVKT.setMA_KHOA(currentValue.trim());
        else if (qName.equalsIgnoreCase("MA_BAC_SI"))
            chiTietDVKT.setMA_BAC_SI(currentValue.trim());
        else if (qName.equalsIgnoreCase("MA_BENH"))
            chiTietDVKT.setMA_BENH(currentValue.trim());
        else if (qName.equalsIgnoreCase("NGAY_YL"))
            chiTietDVKT.setNGAY_YL(currentValue.trim());
        else if (qName.equalsIgnoreCase("NGAY_KQ"))
            chiTietDVKT.setNGAY_KQ(currentValue.trim());
        else if (qName.equalsIgnoreCase("MA_PTTT"))
            chiTietDVKT.setMA_PTTT(currentValue.trim());
        else if (qName.equalsIgnoreCase("CHI_TIET_DVKT"))
            dsChiTietDVKT.add(chiTietDVKT);

        currentValue = "";
    }

    public void characters(char[] ch, int start, int length)
            throws SAXException {

        if (currentElement) {
            currentValue = currentValue + new String(ch, start, length);
        }
    }
}
