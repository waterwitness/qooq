package com.tencent.mobileqq.troop.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.widget.AutoLocationMapView.AutoLocationCallback;
import com.tencent.tencentmap.mapsdk.map.GeoPoint;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopCreateMapViewSupportActivity$AutoLocationJSCallback
  implements AutoLocationMapView.AutoLocationCallback
{
  private String jdField_a_of_type_JavaLangString;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  
  public TroopCreateMapViewSupportActivity$AutoLocationJSCallback(TroopCreateMapViewSupportActivity paramTroopCreateMapViewSupportActivity, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramTroopCreateMapViewSupportActivity);
  }
  
  public void a(int paramInt, GeoPoint paramGeoPoint)
  {
    TroopCreateMapViewSupportActivity localTroopCreateMapViewSupportActivity = (TroopCreateMapViewSupportActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localTroopCreateMapViewSupportActivity == null) {}
    do
    {
      return;
      localTroopCreateMapViewSupportActivity.stopTitleProgress();
    } while ((paramInt != 0) && (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)));
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("result", paramInt);
      if (paramGeoPoint != null)
      {
        double d1 = paramGeoPoint.getLatitudeE6() / 1000000.0D;
        double d2 = paramGeoPoint.getLongitudeE6() / 1000000.0D;
        localJSONObject.put("latitude", d1);
        localJSONObject.put("longitude", d2);
      }
    }
    catch (JSONException paramGeoPoint)
    {
      for (;;)
      {
        paramGeoPoint.printStackTrace();
      }
    }
    localTroopCreateMapViewSupportActivity.b(this.jdField_a_of_type_JavaLangString, localJSONObject.toString());
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\activity\TroopCreateMapViewSupportActivity$AutoLocationJSCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */