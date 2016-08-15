package vn.cusc.ihs.DownloadData;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

/**
 * Created by cmtien on 8/15/16.
 */
public class PhanTich_XML extends DefaultHandler {
    public ArrayList<FileHoSo> fileHoSoList = new ArrayList<>();
    boolean currentElement = false;
    String currentValue = "";


    FileHoSo fileHoSo;
    String maCSKCB = "";
    String ngayLap = "";
    String soLuongHoSo;
    public ArrayList<FileHoSo> getFileHoSoList() {
        return fileHoSoList;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        currentElement = true;

        if (qName.equals("GIAMDINHHS")) {
            fileHoSoList = new ArrayList<FileHoSo>();
        } else if (qName.equals("FILEHOSO")) {
            fileHoSo = new FileHoSo();
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        currentElement = false;

        if (qName.equalsIgnoreCase("MACSKCB"))
            maCSKCB = currentValue.trim();
        else if (qName.equalsIgnoreCase("NGAYLAP"))
            ngayLap = currentValue.trim();
        else if (qName.equalsIgnoreCase("SOLUONGHOSO"))
            soLuongHoSo = currentValue.trim();
        else if (qName.equalsIgnoreCase("LOAIHOSO"))
            fileHoSo.setLoaiHoSo(currentValue.trim());
        else if (qName.equalsIgnoreCase("NOIDUNGFILE"))
            fileHoSo.setNoiDungHoSo(currentValue.trim());
        else if (qName.equalsIgnoreCase("FILEHOSO"))
            fileHoSoList.add(fileHoSo);

        currentValue = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        if (currentElement) {
            currentValue = currentValue + new String(ch, start, length);
        }
    }

}
