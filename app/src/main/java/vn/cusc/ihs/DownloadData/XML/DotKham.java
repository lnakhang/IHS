package vn.cusc.ihs.DownloadData.XML;

/**
 * Created by lnakhang on 8/3/2016.
 */
public class DotKham {
    public DotKham()
    {}

    public String getDOTKHAM_ID() {
        return DOTKHAM_ID;
    }

    public void setDOTKHAM_ID(String DOTKHAM_ID) {
        this.DOTKHAM_ID = DOTKHAM_ID;
    }

    public String getNGAYVAOVIEN() {
        return NGAYVAOVIEN;
    }

    public void setNGAYVAOVIEN(String NGAYVAOVIEN) {
        this.NGAYVAOVIEN = NGAYVAOVIEN;
    }

    public String getFILE_XML() {
        return FILE_XML;
    }

    public void setFILE_XML(String FILE_XML) {
        this.FILE_XML = FILE_XML;
    }

    String DOTKHAM_ID;

    public DotKham(String DOTKHAM_ID, String NGAYVAOVIEN, String FILE_XML) {
        this.DOTKHAM_ID = DOTKHAM_ID;
        this.NGAYVAOVIEN = NGAYVAOVIEN;
        this.FILE_XML = FILE_XML;
    }

    String NGAYVAOVIEN;
    String FILE_XML;
}
