package com.facebook.react.modules.location;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.SystemClock;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import javax.annotation.Nullable;

public class LocationModule
  extends ReactContextBaseJavaModule
{
  private final LocationListener mLocationListener = new LocationListener()
  {
    public void onLocationChanged(Location paramAnonymousLocation)
    {
      ((DeviceEventManagerModule.RCTDeviceEventEmitter)LocationModule.this.getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("geolocationDidChange", LocationModule.locationToMap(paramAnonymousLocation));
    }
    
    public void onProviderDisabled(String paramAnonymousString) {}
    
    public void onProviderEnabled(String paramAnonymousString) {}
    
    public void onStatusChanged(String paramAnonymousString, int paramAnonymousInt, Bundle paramAnonymousBundle)
    {
      if (paramAnonymousInt == 0) {
        LocationModule.this.emitError("Provider " + paramAnonymousString + " is out of service.");
      }
      while (paramAnonymousInt != 1) {
        return;
      }
      LocationModule.this.emitError("Provider " + paramAnonymousString + " is temporarily unavailable.");
    }
  };
  @Nullable
  private String mWatchedProvider;
  
  public LocationModule(ReactApplicationContext paramReactApplicationContext)
  {
    super(paramReactApplicationContext);
  }
  
  private void emitError(String paramString)
  {
    ((DeviceEventManagerModule.RCTDeviceEventEmitter)getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("geolocationError", paramString);
  }
  
  @Nullable
  private static String getValidProvider(LocationManager paramLocationManager, boolean paramBoolean)
  {
    String str2;
    if (paramBoolean)
    {
      str1 = "gps";
      str2 = str1;
      if (paramLocationManager.isProviderEnabled(str1)) {
        return str2;
      }
      if (!str1.equals("gps")) {
        break label47;
      }
    }
    label47:
    for (String str1 = "network";; str1 = "gps")
    {
      str2 = str1;
      if (paramLocationManager.isProviderEnabled(str1)) {
        return str2;
      }
      return null;
      str1 = "network";
      break;
    }
    return str2;
  }
  
  private static WritableMap locationToMap(Location paramLocation)
  {
    WritableMap localWritableMap1 = Arguments.createMap();
    WritableMap localWritableMap2 = Arguments.createMap();
    localWritableMap2.putDouble("latitude", paramLocation.getLatitude());
    localWritableMap2.putDouble("longitude", paramLocation.getLongitude());
    localWritableMap2.putDouble("altitude", paramLocation.getAltitude());
    localWritableMap2.putDouble("accuracy", paramLocation.getAccuracy());
    localWritableMap2.putDouble("heading", paramLocation.getBearing());
    localWritableMap2.putDouble("speed", paramLocation.getSpeed());
    localWritableMap1.putMap("coords", localWritableMap2);
    localWritableMap1.putDouble("timestamp", paramLocation.getTime());
    return localWritableMap1;
  }
  
  private static void throwLocationPermissionMissing(SecurityException paramSecurityException)
  {
    throw new SecurityException("Looks like the app doesn't have the permission to access location.\nAdd the following line to your app's AndroidManifest.xml:\n<uses-permission android:name=\"android.permission.ACCESS_FINE_LOCATION\" />", paramSecurityException);
  }
  
  @ReactMethod
  public void getCurrentPosition(ReadableMap paramReadableMap, Callback paramCallback1, Callback paramCallback2)
  {
    paramReadableMap = LocationOptions.fromReactMap(paramReadableMap);
    LocationManager localLocationManager;
    String str;
    try
    {
      localLocationManager = (LocationManager)getReactApplicationContext().getSystemService("location");
      str = getValidProvider(localLocationManager, paramReadableMap.highAccuracy);
      if (str == null)
      {
        paramCallback2.invoke(new Object[] { "No available location provider." });
        return;
      }
      Location localLocation = localLocationManager.getLastKnownLocation(str);
      if ((localLocation != null) && (SystemClock.currentTimeMillis() - localLocation.getTime() < paramReadableMap.maximumAge))
      {
        paramCallback1.invoke(new Object[] { locationToMap(localLocation) });
        return;
      }
    }
    catch (SecurityException paramReadableMap)
    {
      throwLocationPermissionMissing(paramReadableMap);
      return;
    }
    new SingleUpdateRequest(localLocationManager, str, paramReadableMap.timeout, paramCallback1, paramCallback2, null).invoke();
  }
  
  public String getName()
  {
    return "LocationObserver";
  }
  
  @ReactMethod
  public void startObserving(ReadableMap paramReadableMap)
  {
    if ("gps".equals(this.mWatchedProvider)) {
      return;
    }
    Object localObject = LocationOptions.fromReactMap(paramReadableMap);
    try
    {
      paramReadableMap = (LocationManager)getReactApplicationContext().getSystemService("location");
      localObject = getValidProvider(paramReadableMap, ((LocationOptions)localObject).highAccuracy);
      if (localObject == null)
      {
        emitError("No location provider available.");
        return;
      }
    }
    catch (SecurityException paramReadableMap)
    {
      throwLocationPermissionMissing(paramReadableMap);
      return;
    }
    if (!((String)localObject).equals(this.mWatchedProvider))
    {
      paramReadableMap.removeUpdates(this.mLocationListener);
      paramReadableMap.requestLocationUpdates((String)localObject, 1000L, 0.0F, this.mLocationListener);
    }
    this.mWatchedProvider = ((String)localObject);
  }
  
  @ReactMethod
  public void stopObserving()
  {
    ((LocationManager)getReactApplicationContext().getSystemService("location")).removeUpdates(this.mLocationListener);
    this.mWatchedProvider = null;
  }
  
  private static class LocationOptions
  {
    private final boolean highAccuracy;
    private final double maximumAge;
    private final long timeout;
    
    private LocationOptions(long paramLong, double paramDouble, boolean paramBoolean)
    {
      this.timeout = paramLong;
      this.maximumAge = paramDouble;
      this.highAccuracy = paramBoolean;
    }
    
    private static LocationOptions fromReactMap(ReadableMap paramReadableMap)
    {
      long l;
      double d;
      if (paramReadableMap.hasKey("timeout"))
      {
        l = paramReadableMap.getDouble("timeout");
        if (!paramReadableMap.hasKey("maximumAge")) {
          break label85;
        }
        d = paramReadableMap.getDouble("maximumAge");
        label41:
        if ((!paramReadableMap.hasKey("enableHighAccuracy")) || (!paramReadableMap.getBoolean("enableHighAccuracy"))) {
          break label92;
        }
      }
      label85:
      label92:
      for (boolean bool = true;; bool = false)
      {
        return new LocationOptions(l, d, bool);
        l = Long.MAX_VALUE;
        break;
        d = Double.POSITIVE_INFINITY;
        break label41;
      }
    }
  }
  
  private static class SingleUpdateRequest
  {
    private final Callback mError;
    private final Handler mHandler = new Handler();
    private final LocationListener mLocationListener = new LocationListener()
    {
      public void onLocationChanged(Location paramAnonymousLocation)
      {
        synchronized (LocationModule.SingleUpdateRequest.this)
        {
          if (!LocationModule.SingleUpdateRequest.this.mTriggered)
          {
            LocationModule.SingleUpdateRequest.this.mSuccess.invoke(new Object[] { LocationModule.locationToMap(paramAnonymousLocation) });
            LocationModule.SingleUpdateRequest.this.mHandler.removeCallbacks(LocationModule.SingleUpdateRequest.this.mTimeoutRunnable);
            LocationModule.SingleUpdateRequest.access$802(LocationModule.SingleUpdateRequest.this, true);
          }
          return;
        }
      }
      
      public void onProviderDisabled(String paramAnonymousString) {}
      
      public void onProviderEnabled(String paramAnonymousString) {}
      
      public void onStatusChanged(String paramAnonymousString, int paramAnonymousInt, Bundle paramAnonymousBundle) {}
    };
    private final LocationManager mLocationManager;
    private final String mProvider;
    private final Callback mSuccess;
    private final long mTimeout;
    private final Runnable mTimeoutRunnable = new Runnable()
    {
      public void run()
      {
        synchronized (LocationModule.SingleUpdateRequest.this)
        {
          if (!LocationModule.SingleUpdateRequest.this.mTriggered)
          {
            LocationModule.SingleUpdateRequest.this.mError.invoke(new Object[] { "Location request timed out" });
            LocationModule.SingleUpdateRequest.this.mLocationManager.removeUpdates(LocationModule.SingleUpdateRequest.this.mLocationListener);
            LocationModule.SingleUpdateRequest.access$802(LocationModule.SingleUpdateRequest.this, true);
          }
          return;
        }
      }
    };
    private boolean mTriggered;
    
    private SingleUpdateRequest(LocationManager paramLocationManager, String paramString, long paramLong, Callback paramCallback1, Callback paramCallback2)
    {
      this.mLocationManager = paramLocationManager;
      this.mProvider = paramString;
      this.mTimeout = paramLong;
      this.mSuccess = paramCallback1;
      this.mError = paramCallback2;
    }
    
    public void invoke()
    {
      this.mLocationManager.requestSingleUpdate(this.mProvider, this.mLocationListener, null);
      this.mHandler.postDelayed(this.mTimeoutRunnable, SystemClock.currentTimeMillis() + this.mTimeout);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\modules\location\LocationModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */