package com.testproject;

import android.app.Activity;
import android.widget.TextView;
import android.os.Bundle;
import android.content.Context;

import android.widget.Toast;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.views.text.ReactTextView;

import java.util.Map;
import java.util.HashMap;

import heron_systems.jnitestlib.Test_Wrapper;

/**
     * Call native method getting some string from C++
     * @return Some string
     */

public class JNIDemo extends ReactContextBaseJavaModule {
     private static final String DURATION_SHORT_KEY = "SHORT";
     private static final String DURATION_LONG_KEY = "LONG";

     public String getText(){
        Test_Wrapper Wrapper = new Test_Wrapper();
        String str  = Wrapper.GetStringFromNative();
        return str;
     }

    public JNIDemo(ReactApplicationContext reactContext){
        super(reactContext);
    }

    @Override
    public String getName() {
        return "HelloWorld";
    }

    @ReactMethod
    public void show() {
    String str = getText();
    Toast.makeText(getReactApplicationContext(), str, 20).show();
  }
}
