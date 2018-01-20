package com.timetracker;

import com.facebook.react.ReactActivity;
import android.app.AppOpsManager;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class MainActivity extends ReactActivity {

  private static final int MY_PERMISSIONS_REQUEST_PACKAGE_USAGE_STATS = 100;
    /**
     * Returns the name of the main component registered from JavaScript.
     * This is used to schedule rendering of the component.
     */
    @Override
    protected String getMainComponentName() {
        return "TimeTracker";
    }

    /*@Override
    protected List<ReactPackage> getPackages() {
      return Arrays.<ReactPackage>asList(
          new MainReactPackage(),
          new UsageStatsPackage(),
          new FBSDKPackage(mCallbackManager)
      );*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      fillStats();
    }

     private void fillStats() {
         if (hasPermission()){
            // getStats();
         }else{
             requestPermission();
         }
     }

     @Override
     public void onActivityResult(int requestCode, int resultCode, Intent data) {
      //  super.onActivityResult(requestCode, resultCode, data);
      MainApplication.getCallbackManager().onActivityResult(requestCode, resultCode, data);
         Log.d("MainActivity", "resultCode " + resultCode);
         switch (requestCode){
             case MY_PERMISSIONS_REQUEST_PACKAGE_USAGE_STATS:
                 fillStats();
                 break;
         }
     }

     private void requestPermission() {
         Toast.makeText(this, "Need to request permission", Toast.LENGTH_SHORT).show();
         startActivityForResult(new Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS),
         MY_PERMISSIONS_REQUEST_PACKAGE_USAGE_STATS);
     }

     private boolean hasPermission() {
         AppOpsManager appOps = (AppOpsManager)
                 getSystemService(Context.APP_OPS_SERVICE);
         int mode = appOps.checkOpNoThrow(AppOpsManager.OPSTR_GET_USAGE_STATS,
                 android.os.Process.myUid(), getPackageName());
         return mode == AppOpsManager.MODE_ALLOWED;
     }

}
