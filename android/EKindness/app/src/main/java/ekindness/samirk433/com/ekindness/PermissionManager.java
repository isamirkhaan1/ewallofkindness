package ekindness.samirk433.com.ekindness;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;

public class PermissionManager {
    public static final String TAG = PermissionManager.class.getSimpleName();

    public static final int REQ_LOCATION = 100;
    public static final int REQ_CALL = 101;
    public static final int REQ_STORAGE = 102;
    public static final int REQ_RECORD = 103;
    public static final int REQ_CAMERA = 104;

    private Context mContext;

    public PermissionManager(Context context) {
        Log.d(TAG, "PermissionManager()");

        this.mContext = context;
    }

    //location permission
    public boolean isPermissionLocationGranted() {
        return isPermissionGranted(Manifest.permission.ACCESS_FINE_LOCATION);
    }

    public boolean shouldShowPermissionLocationDetails() {
        return shouldShowPermissionDetails(Manifest.permission.ACCESS_FINE_LOCATION);
    }

    public void showPermissionLocationDetails() {
        String title = "Location Permission";
        String msg = "To help you";
    }

    public void askForPermissionLocation() {
        askForPermission(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQ_LOCATION);
    }


    //call permission
    public boolean isPermissionCallGranted() {
        return isPermissionGranted(Manifest.permission.CALL_PHONE);
    }

    public boolean shouldShowPermissionCallDetails() {
        return shouldShowPermissionDetails(Manifest.permission.CALL_PHONE);
    }

    public void showPermissionCallDetails() {
        String title = "Location Permission";
        String msg = "To help you";
    }

    public void askForPermissionCall() {
        askForPermission(new String[]{Manifest.permission.CALL_PHONE}, REQ_CALL);
    }


    //storage permission
    public boolean isPermissionStorageGranted() {
        return isPermissionGranted(Manifest.permission.WRITE_EXTERNAL_STORAGE);
    }

    public boolean shouldShowPermissionStorageDetails() {
        return shouldShowPermissionDetails(Manifest.permission.WRITE_EXTERNAL_STORAGE);
    }

    public void showPermissionStorageDetails() {
        String title = "Storage Permission";
        String msg = "To help you";
    }

    public void askForPermissionStorage() {
        askForPermission(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQ_STORAGE);
    }


    //recording permission
    public boolean isPermissionRecordGranted() {
        return isPermissionGranted(Manifest.permission.RECORD_AUDIO);
    }

    public boolean shouldShowPermissionRecordDetails() {
        return shouldShowPermissionDetails(Manifest.permission.RECORD_AUDIO);
    }

    public void showPermissionRecordDetails() {
        String title = "Storage Permission";
        String msg = "To help you";
    }

    public void askForPermissionRecord() {
        askForPermission(new String[]{Manifest.permission.RECORD_AUDIO}, REQ_RECORD);
    }


    //camera permission
    public boolean isPermissionCameraGranted() {
        return isPermissionGranted(Manifest.permission.CAMERA);
    }

    public boolean shouldShowPermissionCameraDetails() {
        return shouldShowPermissionDetails(Manifest.permission.CAMERA);
    }

    public void showPermissionCameraDetails() {
        String title = "Camera Permission";
        String msg = "To help you";
    }

    public void askForPermissionCameraAndStorage() {
        askForPermission(new String[]{Manifest.permission.CAMERA,
                Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQ_CAMERA);
    }


    //default permissions
    private boolean isPermissionGranted(String permissionName) {
        boolean resp;
        if (ContextCompat.checkSelfPermission(mContext,
                permissionName)
                == PackageManager.PERMISSION_GRANTED)
            return true;
        return false;
    }

    private boolean shouldShowPermissionDetails(String permissionName) {
        return ActivityCompat.shouldShowRequestPermissionRationale(((Activity) mContext),
                permissionName);
    }

    private void showPermissionDetails(String title, String msg, String btnText) {

        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.setPositiveButton(btnText == null ? "Okay" : btnText,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        builder.show();
    }

    private void askForPermission(String[] permission, int requestCode) {

        ActivityCompat.requestPermissions(((Activity) mContext),
                permission,
                requestCode);

    }
}
