package com.example.mateusz.polistudent;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

public class Fragment1 extends Fragment {
    WebView webView, webView2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment1, container, false);
        webView = view.findViewById(R.id.webView);
        webView.loadUrl(getString(R.string.jakitydzien));
        webView.setInitialScale(70);

        webView2 = view.findViewById(R.id.webView2);
        webView2.loadUrl("https://www.msn.com/pl-pl/pogoda/dzisiaj/wrocławwoj-dolnośląskiepolska/we-city?q=wrocław-woj-dolnośląskie&form=PRWLAS&iso=PL&el=VHfkhvmgPSFW%2bvUFvXELjQ%3d%3d");
        webView2.setInitialScale(70);

        // Inflate the layout for this fragment
        return view;
    }


}
