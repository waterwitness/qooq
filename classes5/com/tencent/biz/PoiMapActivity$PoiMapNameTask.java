package com.tencent.biz;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ReverseGeocode;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.map.GeoPoint;
import hfj;
import org.apache.http.client.HttpClient;

public class PoiMapActivity$PoiMapNameTask
  extends AsyncTask
{
  protected GeoPoint a;
  protected HttpClient a;
  protected GeoPoint b;
  
  public PoiMapActivity$PoiMapNameTask(PoiMapActivity paramPoiMapActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected String a(Void... paramVarArgs)
  {
    this.jdField_a_of_type_ComTencentBizPoiMapActivity.q = "Unknown Address";
    int i = 0;
    if (i < 3)
    {
      if ((isCancelled()) || (this.b.getLatitudeE6() != this.jdField_a_of_type_ComTencentBizPoiMapActivity.h) || (this.b.getLongitudeE6() != this.jdField_a_of_type_ComTencentBizPoiMapActivity.i))
      {
        localObject = "Unknown Address";
        label62:
        return (String)localObject;
      }
      paramVarArgs = ReverseGeocode.a(this.jdField_a_of_type_ComTencentBizPoiMapActivity.getApplicationContext(), this.b.getLatitudeE6() / 1000000.0D, this.b.getLongitudeE6() / 1000000.0D, 3, this.jdField_a_of_type_OrgApacheHttpClientHttpClient);
      this.jdField_a_of_type_ComTencentBizPoiMapActivity.a("rec_locate", "call_googlestation", "", "", "", "");
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append(i).append(" time: ReverseGeocode.getFromLocation, address: ");
        if (paramVarArgs != null) {
          break label190;
        }
      }
      label190:
      for (Object localObject = "";; localObject = paramVarArgs)
      {
        QLog.i("fetch_address", 2, (String)localObject);
        if (paramVarArgs != null)
        {
          localObject = paramVarArgs;
          if (paramVarArgs.length() > 0) {
            break label62;
          }
        }
        i += 1;
        break;
      }
    }
    return "Unknown Address";
  }
  
  public void a(GeoPoint paramGeoPoint)
  {
    this.b = paramGeoPoint;
  }
  
  protected void a(String paramString)
  {
    if ((this.b.getLatitudeE6() != this.jdField_a_of_type_ComTencentBizPoiMapActivity.h) || (this.b.getLongitudeE6() != this.jdField_a_of_type_ComTencentBizPoiMapActivity.i)) {
      return;
    }
    if (TextUtils.isEmpty(paramString)) {}
    for (String str = "Unknown Address";; str = paramString)
    {
      this.jdField_a_of_type_ComTencentBizPoiMapActivity.q = paramString;
      this.jdField_a_of_type_ComTencentBizPoiMapActivity.runOnUiThread(new hfj(this, str));
      if (this.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint == null) {
        break;
      }
      paramString = new PoiMapNameTask(this.jdField_a_of_type_ComTencentBizPoiMapActivity);
      paramString.a(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint);
      this.jdField_a_of_type_ComTencentBizPoiMapActivity.a = paramString;
      this.jdField_a_of_type_ComTencentBizPoiMapActivity.a.execute(new Void[0]);
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint = null;
      return;
    }
  }
  
  protected void onCancelled()
  {
    if ((this.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint != null) && (this.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint.getLatitudeE6() == this.jdField_a_of_type_ComTencentBizPoiMapActivity.h) && (this.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint.getLongitudeE6() == this.jdField_a_of_type_ComTencentBizPoiMapActivity.i))
    {
      PoiMapNameTask localPoiMapNameTask = new PoiMapNameTask(this.jdField_a_of_type_ComTencentBizPoiMapActivity);
      localPoiMapNameTask.a(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint);
      this.jdField_a_of_type_ComTencentBizPoiMapActivity.a = localPoiMapNameTask;
      this.jdField_a_of_type_ComTencentBizPoiMapActivity.a.execute(new Void[0]);
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapGeoPoint = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\PoiMapActivity$PoiMapNameTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */