package vn.cusc.ihs.DownloadData;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

import vn.cusc.ihs.DownloadData.XML.XMLBang2;

/**
 * Created by cmtien on 8/15/16.
 */
public class PhanTich_XML2  extends DefaultHandler {
    boolean currentElement = false;
    String currentValue = "";

    XMLBang2 chiTietThuoc;
    public XMLBang2 getChiTietThuoc() { return chiTietThuoc; }

    ArrayList<XMLBang2> dsChiTietThuoc;
    public ArrayList<XMLBang2> getDSChiTietThuoc() {
        return dsChiTietThuoc;
    }


    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {

        currentElement = true;

        if (qName.equals("DSACH_CHI_TIET_THUOC")) {
            dsChiTietThuoc = new ArrayList<XMLBang2>();
        } else if (qName.equals("CHI_TIET_THUOC")) {
            chiTietThuoc = new XMLBang2();
        }
    }

    public void endElement(String uri, String localName, String qName)
            throws SAXException {

        currentElement = false;

        if (qName.equalsIgnoreCase("MA_LK"))
            chiTietThuoc.setMA_LK(currentValue.trim());
        else if (qName.equalsIgnoreCase("STT"))
            chiTietThuoc.setSTT(currentValue.trim());
        else if (qName.equalsIgnoreCase("MA_THUOC"))
            chiTietThuoc.setMA_THUOC(currentValue.trim());
        else if (qName.equalsIgnoreCase("MA_NHOM"))
            chiTietThuoc.setMA_NHOM(currentValue.trim());
        else if (qName.equalsIgnoreCase("TEN_THUOC"))
            chiTietThuoc.setTEN_THUOC(currentValue.trim());
        else if (qName.equalsIgnoreCase("DON_VI_TINH"))
            chiTietThuoc.setDON_VI_TINH(currentValue.trim());
        else if (qName.equalsIgnoreCase("HAM_LUONG"))
            chiTietThuoc.setHAM_LUONG(currentValue.trim());
        else if (qName.equalsIgnoreCase("DUONG_DUNG"))
            chiTietThuoc.setDUONG_DUNG(currentValue.trim());
        else if (qName.equalsIgnoreCase("LIEU_DUNG"))
            chiTietThuoc.setLIEU_DUNG(currentValue.trim());
        else if (qName.equalsIgnoreCase("SO_DANG_KY"))
            chiTietThuoc.setSO_DANG_KY(currentValue.trim());
        else if (qName.equalsIgnoreCase("SO_LUONG"))
            chiTietThuoc.setSO_LUONG(currentValue.trim());
        else if (qName.equalsIgnoreCase("DON_GIA"))
            chiTietThuoc.setDON_GIA(currentValue.trim());
        else if (qName.equalsIgnoreCase("TYLE_TT"))
            chiTietThuoc.setTYLE_TT(currentValue.trim());
        else if (qName.equalsIgnoreCase("THANH_TIEN"))
            chiTietThuoc.setTHANH_TIEN(currentValue.trim());
        else if (qName.equalsIgnoreCase("MA_KHOA"))
            chiTietThuoc.setMA_KHOA(currentValue.trim());
        else if (qName.equalsIgnoreCase("MA_BAC_SI"))
            chiTietThuoc.setMA_BAC_SI(currentValue.trim());
        else if (qName.equalsIgnoreCase("MA_BENH"))
            chiTietThuoc.setMA_BENH(currentValue.trim());
        else if (qName.equalsIgnoreCase("NGAY_YL"))
            chiTietThuoc.setNGAY_YL(currentValue.trim());
        else if (qName.equalsIgnoreCase("MA_PTTT"))
            chiTietThuoc.setMA_PTTT(currentValue.trim());
        else if (qName.equalsIgnoreCase("CHI_TIET_THUOC"))
            dsChiTietThuoc.add(chiTietThuoc);

        currentValue = "";
    }

    public void characters(char[] ch, int start, int length)
            throws SAXException {

        if (currentElement) {
            currentValue = currentValue + new String(ch, start, length);
        }
    }
}
