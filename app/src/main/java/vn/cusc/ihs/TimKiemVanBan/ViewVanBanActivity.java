package vn.cusc.ihs.TimKiemVanBan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import vn.cusc.ihs.R;

public class ViewVanBanActivity extends AppCompatActivity {


    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_van_ban);

        init();

        String myPdfUrl = "2046_BHXH_CSYT.pdf";
        String url = "http://docs.google.com/gview?embedded=true&url=http://vanbanphapluat.somee.com/file/" + myPdfUrl;
//        Log.i(TAG, "Opening PDF: " + url);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setAppCacheEnabled(true);

        webView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        webView.loadUrl(url);
    }
    private void init() {
        webView = (WebView) findViewById(R.id.webView);
    }
}
