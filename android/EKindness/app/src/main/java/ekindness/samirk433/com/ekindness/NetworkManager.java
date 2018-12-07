package ekindness.samirk433.com.ekindness;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;


public class NetworkManager {
    private static final String TAG = NetworkManager.class.getSimpleName();

    public static boolean isNetworkAvailable(Context context) {
        Log.d(TAG, "isNetworkAvailable(Context)");

        ConnectivityManager connectivityManager = getConnectivityManager(context);

        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private static ConnectivityManager getConnectivityManager(Context context) {
        return (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    }
}
