package vn.cusc.ihs.ThongTinBenhNhan.ChiDinhCLS;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import vn.cusc.ihs.DownloadData.XML.XMLBang3;
import vn.cusc.ihs.R;

/**
 * Created by lnakhang on 8/15/2016.
 */
public class ChiDinhAdapter extends BaseAdapter {
    Context _context;
    ArrayList<XMLBang3> lstChiDinh = new ArrayList<>();

    public ChiDinhAdapter(Context context, ArrayList<XMLBang3> lst) {
        this._context = context;
        lstChiDinh = lst;
    }

    @Override
    public int getCount() {
        return lstChiDinh.size();
    }

    @Override
    public Object getItem(int i) {
        return lstChiDinh.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ChiDinhItem thuocItem = new ChiDinhItem();
        if (view == null) {
            LayoutInflater inflater = ((Activity) _context).getLayoutInflater();
            view = inflater.inflate(R.layout.activity_chi_dinh_item, viewGroup, false);
            thuocItem.tvStt = (TextView) view.findViewById(R.id.tvStt);
            thuocItem.tvTen = (TextView) view.findViewById(R.id.tvTenChiDinh);
            thuocItem.tvThanhTien = (TextView) view.findViewById(R.id.tvThanhTien);
            view.setTag("");
        } else {
            thuocItem = (ChiDinhItem) view.getTag();
        }
        XMLBang3 xml = lstChiDinh.get(i);
        thuocItem.tvStt.setText(xml.getSTT() + "");
        thuocItem.tvTen.setText(xml.getTEN_DICH_VU() + "");
        thuocItem.tvThanhTien.setText(xml.getTHANH_TIEN() + "");
        return view;
    }

    private class ChiDinhItem {
        TextView tvStt, tvTen, tvThanhTien;
    }
}
