package vn.cusc.ihs.TimKiemVanBan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;

import vn.cusc.ihs.R;

/**
 * Created by lnakhang on 8/15/2016.
 */
public class VanBanAdapter extends BaseAdapter implements Filterable {

    Context myContext;
    int myLayout;
    ArrayList<VanBan> listVanBan;
    private ArrayList<VanBan> mOriginalValues;
    private ArrayList<VanBan> mDisplayedValues;

    public VanBanAdapter(Context myContext, int myLayout, ArrayList<VanBan> listVanBan ,ArrayList<VanBan> mProductArrayList) {
        this.myContext = myContext;
        this.myLayout = myLayout;
        this.listVanBan = listVanBan;
        this.mOriginalValues = mProductArrayList;
        this.mDisplayedValues = mProductArrayList;
    }

    @Override
    public int getCount() {
        return listVanBan.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = (LayoutInflater) myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = layoutInflater.inflate(myLayout, null);

        TextView textView = (TextView) view.findViewById(R.id.tvTrichYeu);
        textView.setText(listVanBan.get(i).getTrichYeu());
        return view;
    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {

            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint,FilterResults results) {

                listVanBan = (ArrayList<VanBan>) results.values; // has the filtered values
                notifyDataSetChanged();  // notifies the data with new filtered values
            }

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();        // Holds the results of a filtering operation in values
                ArrayList<VanBan> FilteredArrList = new ArrayList<VanBan>();

                if (listVanBan == null) {
                    listVanBan = new ArrayList<VanBan>(listVanBan); // saves the original data in mOriginalValues
                }

                /********
                 *
                 *  If constraint(CharSequence that is received) is null returns the mOriginalValues(Original) values
                 *  else does the Filtering and returns FilteredArrList(Filtered)
                 *
                 ********/
                if (constraint == null || constraint.length() == 0) {

                    // set the Original result to return
                    results.count = mOriginalValues.size();
                    results.values = mOriginalValues;
                } else {
                    constraint = constraint.toString().toLowerCase();
                    for (int i = 0; i < mOriginalValues.size(); i++) {
                        String data = mOriginalValues.get(i).getColumnContains();
                        if (data.toLowerCase().contains(constraint.toString())) {
                            FilteredArrList.add(new VanBan(mOriginalValues.get(i).kyHieuVanBan
                                    ,mOriginalValues.get(i).ngayKyVanBan
                                    ,mOriginalValues.get(i).nguoiKyVanBan
                                    ,mOriginalValues.get(i).trichYeu
                                    ,mOriginalValues.get(i).tenCoQuan
                                    ,mOriginalValues.get(i).namBanHanhVanBan
                                    ,mOriginalValues.get(i).tapTinVanban
                                    ,mOriginalValues.get(i).ColumnContains));
                        }
                    }
                    // set the Filtered result to return
                    results.count = FilteredArrList.size();
                    results.values = FilteredArrList;
                }
                return results;
            }
        };
        return filter;
    }
}
