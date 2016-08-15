package vn.cusc.ihs.DownloadData;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import vn.cusc.ihs.DownloadData.XML.XMLBang1;

/**
 * Created by cmtien on 8/15/16.
 */
public class PhanTich_XML1 extends DefaultHandler {
    boolean currentElement = false;
    String currentValue = "";

    XMLBang1 xmlBang1;
    public XMLBang1 getXMLBang1() { return xmlBang1; }


    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {

        currentElement = true;

        if (qName.equals("TONG_HOP")) {
            xmlBang1 = new XMLBang1();
        }
    }

    public void endElement(String uri, String localName, String qName)
            throws SAXException {

        currentElement = false;

        if (qName.equalsIgnoreCase("MA_LK"))
            xmlBang1.setMA_LK(currentValue.trim());
        else if (qName.equalsIgnoreCase("STT"))
            xmlBang1.setSTT(currentValue.trim());
        else if (qName.equalsIgnoreCase("MA_BN"))
            xmlBang1.setMA_BN(currentValue.trim());
        else if (qName.equalsIgnoreCase("HO_TEN"))
            xmlBang1.setHO_TEN(currentValue.trim());
        else if (qName.equalsIgnoreCase("NGAY_SINH"))
            xmlBang1.setNGAY_SINH(currentValue.trim());
        else if (qName.equalsIgnoreCase("GIOI_TINH"))
            xmlBang1.setGIOI_TINH(currentValue.trim());
        else if (qName.equalsIgnoreCase("DIA_CHI"))
            xmlBang1.setDIA_CHI(currentValue.trim());
        else if (qName.equalsIgnoreCase("MA_THE"))
            xmlBang1.setMA_THE(currentValue.trim());
        else if (qName.equalsIgnoreCase("MA_DKBD"))
            xmlBang1.setMA_DKBD(currentValue.trim());
        else if (qName.equalsIgnoreCase("GT_THE_TU"))
            xmlBang1.setGT_THE_TU(currentValue.trim());
        else if (qName.equalsIgnoreCase("GT_THE_DEN"))
            xmlBang1.setGT_THE_DEN(currentValue.trim());
        else if (qName.equalsIgnoreCase("TEN_BENH"))
            xmlBang1.setTEN_BENH(currentValue.trim());
        else if (qName.equalsIgnoreCase("MA_BENH"))
            xmlBang1.setMA_BENH(currentValue.trim());
        else if (qName.equalsIgnoreCase("MA_BENHKHAC"))
            xmlBang1.setMA_BENHKHAC(currentValue.trim());
        else if (qName.equalsIgnoreCase("MA_LYDO_VVIEN"))
            xmlBang1.setMA_LYDO_VVIEN(currentValue.trim());
        else if (qName.equalsIgnoreCase("MA_NOI_CHUYEN"))
            xmlBang1.setMA_NOI_CHUYEN(currentValue.trim());
        else if (qName.equalsIgnoreCase("MA_TAI_NAN"))
            xmlBang1.setMA_TAI_NAN(currentValue.trim());
        else if (qName.equalsIgnoreCase("NGAY_VAO"))
            xmlBang1.setNGAY_VAO(currentValue.trim());
        else if (qName.equalsIgnoreCase("NGAY_RA"))
            xmlBang1.setNGAY_RA(currentValue.trim());
        else if (qName.equalsIgnoreCase("SO_NGAY_DTRI"))
            xmlBang1.setSO_NGAY_DTRI(currentValue.trim());
        else if (qName.equalsIgnoreCase("KET_QUA_DTRI"))
            xmlBang1.setKET_QUA_DTRI(currentValue.trim());
        else if (qName.equalsIgnoreCase("TINH_TRANG_RV"))
            xmlBang1.setTINH_TRANG_RV(currentValue.trim());
        else if (qName.equalsIgnoreCase("NGAY_TTOAN"))
            xmlBang1.setNGAY_TTOAN(currentValue.trim());
        else if (qName.equalsIgnoreCase("MUC_HUONG"))
            xmlBang1.setMUC_HUONG(currentValue.trim());
        else if (qName.equalsIgnoreCase("T_THUOC"))
            xmlBang1.setT_THUOC(currentValue.trim());
        else if (qName.equalsIgnoreCase("T_VTYT"))
            xmlBang1.setT_VTYT(currentValue.trim());
        else if (qName.equalsIgnoreCase("T_TONGCHI"))
            xmlBang1.setT_TONGCHI(currentValue.trim());
        else if (qName.equalsIgnoreCase("T_BNTT"))
            xmlBang1.setT_BNTT(currentValue.trim());
        else if (qName.equalsIgnoreCase("T_BHTT"))
            xmlBang1.setT_BHTT(currentValue.trim());
        else if (qName.equalsIgnoreCase("T_NGUONKHAC"))
            xmlBang1.setT_NGUONKHAC(currentValue.trim());
        else if (qName.equalsIgnoreCase("T_NGOAIDS"))
            xmlBang1.setT_NGOAIDS(currentValue.trim());
        else if (qName.equalsIgnoreCase("NAM_QT"))
            xmlBang1.setNAM_QT(currentValue.trim());
        else if (qName.equalsIgnoreCase("THANG_QT"))
            xmlBang1.setTHANG_QT(currentValue.trim());
        else if (qName.equalsIgnoreCase("MA_LOAI_KCB"))
            xmlBang1.setMA_LOAI_KCB(currentValue.trim());
        else if (qName.equalsIgnoreCase("MA_KHOA"))
            xmlBang1.setMA_KHOA(currentValue.trim());
        else if (qName.equalsIgnoreCase("MA_CSKCB"))
            xmlBang1.setMA_CSKCB(currentValue.trim());
        else if (qName.equalsIgnoreCase("MA_KHUVUC"))
            xmlBang1.setMA_KHUVUC(currentValue.trim());
        else if (qName.equalsIgnoreCase("MA_PTTT_QT"))
            xmlBang1.setMA_PTTT_QT(currentValue.trim());
        else if (qName.equalsIgnoreCase("CAN_NANG"))
            xmlBang1.setCAN_NANG(currentValue.trim());

        currentValue = "";}
    public void characters(char[] ch, int start, int length)
            throws SAXException {

        if (currentElement) {
            currentValue = currentValue + new String(ch, start, length);
        }
    }
}
