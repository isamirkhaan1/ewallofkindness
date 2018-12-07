package ekindness.samirk433.com.ekindness;

import android.content.Context;
import android.location.LocationManager;
import android.util.Log;

public class AppLocationManager {
    private final static String TAG = AppLocationManager.class.getSimpleName();

    public static boolean isLocationEnable(Context context) {
        try {
            LocationManager locationManager =
                    (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);

            if (locationManager == null)
                return false;

            return locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER) ||
                    locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);

        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }

        return false;
    }
}
