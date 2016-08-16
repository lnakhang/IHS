package vn.cusc.ihs.TimKiemVanBan;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import vn.cusc.ihs.R;

public class ListVanBanActivity extends Fragment {

    public ListVanBanActivity() {
    }


    ProgressDialog progressDialog;
    private EditText edNoiDungTimKiem;
    private TextView tvHienThiNoiDungTimKiem;
    private ListView lvDanhSachHienThi;
    private ArrayList<VanBan> arrayListVanBan;
    private VanBanAdapter vanBanAdapter;
    String address = "http://van-ban-phap-luat.appspot.com/json/vbpl_yte.json";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_list_van_ban, container, false);


        //setContentView(R.layout.activity_list_van_ban);

        edNoiDungTimKiem = (EditText) rootView.findViewById(R.id.edNoiDungTimKiem);
        lvDanhSachHienThi = (ListView) rootView.findViewById(R.id.lvDanhSachHienThi);
        tvHienThiNoiDungTimKiem = (TextView) rootView.findViewById(R.id.tvHienThiNoiDungTimKiem);


        edNoiDungTimKiem.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                tvHienThiNoiDungTimKiem.setText("Nội dung tìm kiếm: " + edNoiDungTimKiem.getText().toString());
                //Nếu như chuối ký tự tìm rỗng, thì reset lại danh sách;
                //Ngược lại, nó có ký tự thì mình tìm kiếm
                if (charSequence.toString().equals("")) {
                    DownLoad download = new DownLoad();
                    download.execute();
                } else {
                    vanBanAdapter.getFilter().filter(charSequence.toString());
                    lvDanhSachHienThi.setAdapter(vanBanAdapter);
                    // searchContent(charSequence.toString());
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        lvDanhSachHienThi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            //@TargetApi(Build.VERSION_CODES.N)
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intentManHinhHienThiChiTiet = new Intent(getActivity(), VanBanDetail.class);
                String kyHieuVB = arrayListVanBan.get(i).getKyHieuVanBan();
                String ngayKyVB = arrayListVanBan.get(i).getNgayKyVanBan();
                String nguoiKyVB = arrayListVanBan.get(i).getNguoiKyVanBan();
                String tenCoQuan = arrayListVanBan.get(i).getTenCoQuan();
                String trichYeu = arrayListVanBan.get(i).getTrichYeu();
                Integer namBanHanhVB = arrayListVanBan.get(i).getNamBanHanhVanBan();
                String tapTinVB = arrayListVanBan.get(i).getTapTinVanban();
                String date = ngayKyVB.substring(0, 10);
                intentManHinhHienThiChiTiet.putExtra("kyHieuVB", kyHieuVB);
                intentManHinhHienThiChiTiet.putExtra("ngayKyVB", date);
                intentManHinhHienThiChiTiet.putExtra("nguoiKyVB", nguoiKyVB);
                intentManHinhHienThiChiTiet.putExtra("tenCoQuan", tenCoQuan);
                intentManHinhHienThiChiTiet.putExtra("trichYeu", trichYeu);
                intentManHinhHienThiChiTiet.putExtra("namBanHanhVB", namBanHanhVB);
                intentManHinhHienThiChiTiet.putExtra("tapTinVB", tapTinVB);
                startActivity(intentManHinhHienThiChiTiet);

            }
        });
        return rootView;
    }

    class DownLoad extends AsyncTask<String, String, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            if (progressDialog == null) {
                progressDialog = new ProgressDialog(getActivity());
                progressDialog.setIndeterminate(true);
            }
            progressDialog.setMessage("Vui lòng chờ giây lác!");
            progressDialog.show();
        }

        @Override
        protected String doInBackground(String... params) {
            try {
                // mo ket noi de lay du lieu len server web
                URL url = new URL(address);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                InputStream in = con.getInputStream();
                StringBuilder str = new StringBuilder();
                String line = "";
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                while ((line = br.readLine()) != null) {
                    str.append(line);
                    str.append("\n");
                }
                br.close();

                return str.toString();
            } catch (Exception ex) {
                return ex.toString();
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONArray arr = new JSONArray(s);
                arrayListVanBan = new ArrayList<VanBan>();

                for (int i = 0; i < arr.length(); i++) {
                    String columnContains = arr.getJSONObject(i).getString("VB_KYHIEU") + ";" +
                            arr.getJSONObject(i).getString("VB_NGAYKY") + ";" +
                            arr.getJSONObject(i).getString("VB_NGUOIKY") + ";" +
                            arr.getJSONObject(i).getString("VB_TRICHYEU") + ";" +
                            arr.getJSONObject(i).getString("CQBH_TENCQ") + ";" +
                            arr.getJSONObject(i).getString("VB_NAMBH") + ";" +
                            arr.getJSONObject(i).getString("VB_TAPTIN");
                    arrayListVanBan.add(i, new VanBan(arr.getJSONObject(i).getString("VB_KYHIEU"),
                            arr.getJSONObject(i).getString("VB_NGAYKY"),
                            arr.getJSONObject(i).getString("VB_NGUOIKY"),
                            arr.getJSONObject(i).getString("VB_TRICHYEU"),
                            arr.getJSONObject(i).getString("CQBH_TENCQ"),
                            arr.getJSONObject(i).getInt("VB_NAMBH"),
                            arr.getJSONObject(i).getString("VB_TAPTIN"),
                            columnContains));

                    //   str+= "\n"+arr.getJSONObject(i).getString("hoten") +"-hinh:" +arr.getJSONObject(i).getString("hinh");

                }
                vanBanAdapter = new VanBanAdapter(getActivity(), R.layout.activity_van_ban_item, arrayListVanBan, arrayListVanBan);
                vanBanAdapter.notifyDataSetChanged();
                lvDanhSachHienThi.setAdapter(vanBanAdapter);
                progressDialog.hide();
            } catch (Exception ex) {
                progressDialog.hide();
                Toast.makeText(getActivity(), "ERROR:" + ex.toString(), Toast.LENGTH_LONG).show();

            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        DownLoad download = new DownLoad();
        download.execute();
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
