package vn.cusc.ihs.DownloadData;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import vn.cusc.ihs.DownloadData.XML.DotKham;
import vn.cusc.ihs.R;
import vn.cusc.ihs.clsDotKham;

/**
 * Created by lnakhang on 8/3/2016.
 */
public class DotKhamAdapter extends BaseAdapter {
    Context context;
    ArrayList<clsDotKham> lstDotkham;

    public DotKhamAdapter(Context context, ArrayList<clsDotKham> lst) {
        this.context = context;
        lstDotkham = lst;

        if (lstDotkham == null) {
            lstDotkham = new ArrayList<>();
        }
    }

    @Override
    public int getCount() {
        return lstDotkham.size();
    }

    @Override
    public Object getItem(int i) {
        return lstDotkham.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        oneDotKham one_skiarea = new oneDotKham();
        if (view == null) {
            LayoutInflater inflater = ((AppCompatActivity) context).getLayoutInflater();
            view = inflater.inflate(R.layout.activity_dot_kham_item, viewGroup, false);
            one_skiarea.tvNgayKham = (TextView) view.findViewById(R.id.tvNgayKham);
            view.setTag(one_skiarea);
        } else {
            one_skiarea = (oneDotKham) view.getTag();
        }
        clsDotKham position = lstDotkham.get(i);
        one_skiarea.tvNgayKham.setText(position.getNgaykham().toString());
        return view;
    }


    private class oneDotKham{
        TextView tvNgayKham;
    }
}
