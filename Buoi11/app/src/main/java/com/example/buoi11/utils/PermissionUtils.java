package com.example.buoi11.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

public class PermissionUtils {
    /**
     * check user permissions is granted
     * @param  context current activity or fragment
     * @param  permissions list permissions need check
     *
     * @return True if permissions is granted else denied
     * */
    public static boolean checkPermission(Context context, String[] permissions){
        //Build.VERSION.SDK_INT : Lấy ra version hiện tại
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            for (String p: permissions){
                int result = ContextCompat.checkSelfPermission(context,p);
                if(result == PackageManager.PERMISSION_DENIED){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Request accept Permission
     *
     * @param activity current activity context
     * @param permissions list Permissions need request accept
     * @param requestCode
     *
     * */

    public static void requestPermission(FragmentActivity activity, String[] permissions, int requestCode){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            activity.requestPermissions(permissions,requestCode);
        }
    }
}
