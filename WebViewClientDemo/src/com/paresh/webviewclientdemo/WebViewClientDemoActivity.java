package com.paresh.webviewclientdemo;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/*
 * Demo of creating an application to open any URL inside the application and clicking on any link from that URl 
should not open Native browser but  that URL should open in the same screen.
 */
public class WebViewClientDemoActivity extends Activity {
    /** Called when the activity is first created. */
	
	WebView web;
	 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        web = (WebView) findViewById(R.id.webview01);
        web.setWebViewClient(new myWebClient());
        web.getSettings().setJavaScriptEnabled(true);
        web.loadUrl("http://www.google.com");
    }
    
    public class myWebClient extends WebViewClient
    {
    	@Override
    	public void onPageStarted(WebView view, String url, Bitmap favicon) {
    		// TODO Auto-generated method stub
    		super.onPageStarted(view, url, favicon);
    	}
    	
    	@Override
    	public boolean shouldOverrideUrlLoading(WebView view, String url) {
    		// TODO Auto-generated method stub
    		
    		view.loadUrl(url);
    		return true;
    		
    	}
    }
    
    // To handle "Back" key press event for WebView to go back to previous screen.
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) 
	{
		if ((keyCode == KeyEvent.KEYCODE_BACK) && web.canGoBack()) {
			web.goBack();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
}