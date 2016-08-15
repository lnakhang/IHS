package vn.cusc.ihs.DownloadData;

import android.util.Log;

import org.xml.sax.InputSource;

import java.io.StringReader;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import vn.cusc.ihs.DownloadData.XML.XMLBang2;
import vn.cusc.ihs.DownloadData.XML.XMLBang3;

/**
 * Created by LNAKHANG on 8/15/2016.
 */
public class XuLyDuLieu {
    PhanTich_XML phanTich_xml;
    PhanTich_XML1 phanTich_xml1;
    PhanTich_XML2 phanTich_xml2;
    PhanTich_XML3 phanTich_xml3;
    XML_Data sumReadXML = new XML_Data();
    ParseBase64 parse;

    public XuLyDuLieu() {
        parse = new ParseBase64();
    }

    public void getXMLDetail(ArrayList<FileHoSo> fileHoSoArrayList) {
         //= phanTich_xml.getFileHoSoList();
        if (fileHoSoArrayList != null && fileHoSoArrayList.size() > 0) {
            for (FileHoSo fileHoSo : fileHoSoArrayList) {
                String loaiHoSo = fileHoSo.getLoaiHoSo();
                String noiDungHoSo = fileHoSo.getNoiDungHoSo();

                // XML Bang 1
                if (loaiHoSo.equalsIgnoreCase("XML1")) {
                    //Log.d("START READ XML BANG 1", "");

                    String xml1 = parse.Parse(noiDungHoSo);

                    try {
                        InputSource src = new InputSource(new StringReader(xml1));
                        // chuan bi tai nguyen de phan tich xml theo SAX
                        SAXParserFactory fax = SAXParserFactory.newInstance();
                        SAXParser parser = fax.newSAXParser();
                        // tao doi tuong phan tich va nhan du lieu tu webserver
                        phanTich_xml1 = new PhanTich_XML1();
                        // tien hanh phan tich
                        parser.parse(src, phanTich_xml1);

/*
                        Log.d("MA_LK: ", phanTich_xml1.getXMLBang1().getMA_LK());
                        Log.d("STT: ", phanTich_xml1.getXMLBang1().getSTT());
                        Log.d("MA_BN: ", phanTich_xml1.getXMLBang1().getMA_BN());
                        Log.d("HO_TEN: ", phanTich_xml1.getXMLBang1().getHO_TEN());
                        Log.d("NGAY_SINH: ", phanTich_xml1.getXMLBang1().getNGAY_SINH());
                        Log.d("GIOI_TINH: ", phanTich_xml1.getXMLBang1().getGIOI_TINH());
                        Log.d("DIA_CHI: ", phanTich_xml1.getXMLBang1().getDIA_CHI());
                        Log.d("MA_THE: ", phanTich_xml1.getXMLBang1().getMA_THE());
                        Log.d("MA_DKBD: ", phanTich_xml1.getXMLBang1().getMA_DKBD());
                        Log.d("GT_THE_TU: ", phanTich_xml1.getXMLBang1().getGT_THE_TU());
                        Log.d("GT_THE_DEN: ", phanTich_xml1.getXMLBang1().getGT_THE_DEN());
                        Log.d("TEN_BENH: ", phanTich_xml1.getXMLBang1().getTEN_BENH());
                        Log.d("MA_BENH: ", phanTich_xml1.getXMLBang1().getMA_BENH());
                        Log.d("MA_BENHKHAC: ", phanTich_xml1.getXMLBang1().getMA_BENHKHAC());
                        Log.d("MA_LYDO_VVIEN: ", phanTich_xml1.getXMLBang1().getMA_LYDO_VVIEN());*/

                        sumReadXML.setPhanTich_xml1(phanTich_xml1);

                        Log.d("STOP READ XML BANG 1", "");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                // XML Bang 2
                if (loaiHoSo.equalsIgnoreCase("XML2")) {
                    Log.d("START READ XML BANG 2", "");

                    String xml2 = parse.Parse(noiDungHoSo);

                    try {
                        InputSource src = new InputSource(new StringReader(xml2));
                        // chuan bi tai nguyen de phan tich xml theo SAX
                        SAXParserFactory fax = SAXParserFactory.newInstance();
                        SAXParser parser = fax.newSAXParser();
                        // tao doi tuong phan tich va nhan du lieu tu webserver
                        phanTich_xml2 = new PhanTich_XML2();
                        // tien hanh phan tich
                        parser.parse(src, phanTich_xml2);

                        ArrayList<XMLBang2> dsChiTietThuoc = phanTich_xml2.getDSChiTietThuoc();
                       /* for (XMLBang2 xmlBang2 : dsChiTietThuoc)
                        {
                            Log.d("MA_LK: ", xmlBang2.getMA_LK());
                            Log.d("STT: ", xmlBang2.getSTT());
                            Log.d("MA_THUOC: ", xmlBang2.getMA_THUOC());
                            Log.d("MA_NHOM: ", xmlBang2.getMA_NHOM());
                            Log.d("TEN_THUOC: ", xmlBang2.getTEN_THUOC());
                            Log.d("DON_VI_TINH: ", xmlBang2.getDON_VI_TINH());
                            Log.d("HAM_LUONG: ", xmlBang2.getHAM_LUONG());
                            Log.d("DUONG_DUNG: ", xmlBang2.getDUONG_DUNG());
                            Log.d("LIEU_DUNG: ", xmlBang2.getLIEU_DUNG());
                            Log.d("SO_DANG_KY: ", xmlBang2.getSO_DANG_KY());
                            Log.d("SO_LUONG: ", xmlBang2.getSO_LUONG());
                        }*/

                        sumReadXML.setPhanTich_xml2(phanTich_xml2);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                // XML Bang 3
                if (loaiHoSo.equalsIgnoreCase("XML3")) {
                    String xml3 = parse.Parse(noiDungHoSo);

                    try {
                        InputSource src = new InputSource(new StringReader(xml3));
                        // chuan bi tai nguyen de phan tich xml theo SAX
                        SAXParserFactory fax = SAXParserFactory.newInstance();
                        SAXParser parser = fax.newSAXParser();
                        // tao doi tuong phan tich va nhan du lieu tu webserver
                        phanTich_xml3 = new PhanTich_XML3();
                        // tien hanh phan tich
                        parser.parse(src, phanTich_xml3);

                        ArrayList<XMLBang3> dsChiTietDVKT = phanTich_xml3.getDSChiTietDVKT();
                        /*for (XMLBang3 xmlBang3 : dsChiTietDVKT) {
                            Log.d("MA_LK: ", xmlBang3.getMA_LK());
                            Log.d("STT: ", xmlBang3.getSTT());
                            Log.d("MA_DICH_VU: ", xmlBang3.getMA_DICH_VU());
                            Log.d("MA_VAT_TU: ", xmlBang3.getMA_VAT_TU());
                            Log.d("MA_NHOM: ", xmlBang3.getMA_NHOM());
                            Log.d("TEN_DICH_VU: ", xmlBang3.getTEN_DICH_VU());
                            Log.d("DON_VI_TINH: ", xmlBang3.getDON_VI_TINH());
                            Log.d("SO_LUONG: ", xmlBang3.getSO_LUONG());
                            Log.d("DON_GIA: ", xmlBang3.getDON_GIA());
                            Log.d("TYLE_TT: ", xmlBang3.getTYLE_TT());
                            Log.d("THANH_TIEN: ", xmlBang3.getTHANH_TIEN());
                        }*/

                        sumReadXML.setPhanTich_xml3(phanTich_xml3);

                        // Log.d("STOP READ XML BANG 3", "");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
        }

    }
}
