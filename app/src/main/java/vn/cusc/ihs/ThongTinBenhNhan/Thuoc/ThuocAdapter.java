package vn.cusc.ihs.ThongTinBenhNhan.Thuoc;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import vn.cusc.ihs.DownloadData.XML.XMLBang2;
import vn.cusc.ihs.R;

/**
 * Created by lnakhang on 8/15/2016.
 */
public class ThuocAdapter extends BaseAdapter {

    ArrayList<XMLBang2> lstThuoc = new ArrayList<>();
    Context _context;

    public ThuocAdapter(Context context, ArrayList<XMLBang2> lst) {
        this._context = context;
        lstThuoc = lst;
    }


    @Override
    public int getCount() {
        return lstThuoc.size();
    }

    @Override
    public Object getItem(int i) {
        return lstThuoc.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ThuocItem thuocItem = new ThuocItem();
        if (view == null) {
            LayoutInflater inflater = ((Activity) _context).getLayoutInflater();
            view = inflater.inflate(R.layout.activity_thuoc_item, viewGroup, false);
            thuocItem.tvStt = (TextView) view.findViewById(R.id.stt);
            thuocItem.tvTen = (TextView) view.findViewById(R.id.tvTenThuoc);
            thuocItem.tvSoLuong = (TextView) view.findViewById(R.id.tvSoLuong);
            thuocItem.tvCachDung = (TextView) view.findViewById(R.id.tvCachDung);
            view.setTag("");
        } else {
            thuocItem = (ThuocItem) view.getTag();
        }
        XMLBang2 xml = lstThuoc.get(i);
        thuocItem.tvStt.setText(i + 1 + "");
        thuocItem.tvTen.setText(xml.getTEN_THUOC() + "");
        thuocItem.tvSoLuong.setText(xml.getSO_LUONG() + "");
        thuocItem.tvCachDung.setText(xml.getLIEU_DUNG() + "");
        return view;
    }

    private class ThuocItem {
        TextView tvStt, tvTen, tvSoLuong, tvCachDung;
    }
}
