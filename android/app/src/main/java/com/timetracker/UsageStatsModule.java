package com.timetracker;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.ReadableMap;

import java.util.Arrays;
import java.util.List;

public class UsageStatsModule extends ReactContextBaseJavaModule {

  private Callback pickerSuccessCallback;
  private Callback pickerCancelCallback;

    public UsageStatsModule(ReactApplicationContext reactContext) {
        super(reactContext);
        //reactContext.addActivityEventListener(this);
    }

    @Override
    public String getName() {
        return "UsageStats";
    }

    @ReactMethod
     public void openSelectDialog(Callback successCallback, Callback cancelCallback) {
       String name = "Test";
         if (name == null) {
             cancelCallback.invoke("Activity doesn't exist");
             return;
         }
         else {
           successCallback.invoke(name);
         }
     }

}
