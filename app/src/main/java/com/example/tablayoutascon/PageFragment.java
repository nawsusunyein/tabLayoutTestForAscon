package com.example.tablayoutascon;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class PageFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";

    private int mPage;
    private String urlList[] = new String[]{"https://www.google.com","https://www.facebook.com","https://twitter.com","https://www.coursera.org","https://www.tutorialspoint.com","https://www.yahoo.com","https://jisho.org","https://mindorks.com/android/store","https://www.tofugu.com","https://docs.python.org","https://www.punipunijapan.com","https://android-arsenal.com"};
    private ProgressBar pgBar;

    public static PageFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE,page);
        PageFragment fragment = new PageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page, container, false);
        WebView webView = (WebView) view.findViewById(R.id.wbWebView);
        pgBar = (ProgressBar) view.findViewById(R.id.pgProgressBar);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(urlList[mPage]);
        webView.setWebViewClient(new WebViewClient());
        return view;
    }

    public class WebViewClient extends android.webkit.WebViewClient{

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            // TODO Auto-generated method stub
            view.loadUrl(url);
            return true;
        }
        @Override
        public void onPageFinished(WebView view, String url) {

            // TODO Auto-generated method stub

            super.onPageFinished(view, url);
            pgBar.setVisibility(View.GONE);

        }
    }
}
