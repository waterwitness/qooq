package cooperation.c2b;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.av.service.LBSInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask2;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import xyt;
import xyu;
import xyv;
import xyw;

public class C2BLBSUtil
{
  public static final int a = 10;
  protected static final String a = "refresh_all_poi";
  public static final int b = 0;
  private static final String b = "C2BLBSUtil";
  public static final int c = -1;
  public static final int d = -2;
  public static final int e = -3;
  private xyw a;
  
  public C2BLBSUtil()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String a(LBSInfo paramLBSInfo, JSONArray paramJSONArray)
  {
    if (paramLBSInfo != null)
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("nation", paramLBSInfo.g());
        localJSONObject.put("province", paramLBSInfo.e());
        localJSONObject.put("city", paramLBSInfo.h());
        localJSONObject.put("district", paramLBSInfo.f());
        localJSONObject.put("town", paramLBSInfo.b());
        localJSONObject.put("village", paramLBSInfo.a());
        localJSONObject.put("street", paramLBSInfo.d());
        localJSONObject.put("streetNo", paramLBSInfo.c());
        localJSONObject.put("latitude", paramLBSInfo.b());
        localJSONObject.put("longitude", paramLBSInfo.c());
        localJSONObject.put("nearby", paramJSONArray);
        paramLBSInfo = localJSONObject.toString();
        return paramLBSInfo;
      }
      catch (JSONException paramLBSInfo)
      {
        paramLBSInfo.printStackTrace();
      }
    }
    return "";
  }
  
  private void a(Context paramContext, AppInterface paramAppInterface, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, HttpWebCgiAsyncTask.Callback paramCallback)
  {
    Bundle localBundle1 = new Bundle();
    localBundle1.putString("lat", String.valueOf(paramInt1));
    localBundle1.putString("lon", String.valueOf(paramInt2));
    localBundle1.putString("num", String.valueOf(10));
    localBundle1.putString("start", String.valueOf(paramInt3));
    Bundle localBundle2 = new Bundle();
    if (paramBoolean) {
      localBundle2.putBoolean("refresh_all_poi", paramBoolean);
    }
    if (QLog.isColorLevel()) {
      QLog.d("C2BLBSUtil", 2, "requestPoiList send http request");
    }
    a(paramContext.getApplicationContext(), paramAppInterface.a(), paramString, localBundle1, "http://buluo.qq.com/cgi-bin/bar/user/poilist", 3, localBundle2, paramCallback, "GET");
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, Bundle paramBundle1, String paramString3, int paramInt, Bundle paramBundle2, HttpWebCgiAsyncTask.Callback paramCallback, String paramString4)
  {
    if ((paramBundle1 != null) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      paramBundle1.putString("version", "6.5.5");
      paramBundle1.putString("platform", "android");
      paramBundle1.putString("mType", "qb_troop_bar");
      paramBundle1.putString("Cookie", "uin=" + paramString1 + ";skey=" + paramString2);
      paramBundle1.putString("Referer", "http://buluo.qq.com");
      paramString1 = new HashMap();
      paramString1.put("BUNDLE", paramBundle1);
      paramString1.put("CONTEXT", paramContext.getApplicationContext());
      new HttpWebCgiAsyncTask2(paramString3, paramString4, paramCallback, paramInt, paramBundle2).execute(new HashMap[] { paramString1 });
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.w("C2BLBSUtil", 2, "httpGet skey is null!!!!!!!!!!!!!!!");
  }
  
  public void a(Context paramContext, AppInterface paramAppInterface, String paramString, C2BLBSUtil.C2BLBSObserver paramC2BLBSObserver, LBSInfo paramLBSInfo)
  {
    if (QLog.isColorLevel())
    {
      if (paramLBSInfo == null) {
        QLog.d("C2BLBSUtil", 2, "getPoiList info == null");
      }
    }
    else
    {
      if (paramLBSInfo != null) {
        break label108;
      }
      a(paramContext, new xyt(this, paramContext, paramAppInterface, paramString, paramC2BLBSObserver));
    }
    label108:
    do
    {
      return;
      if (paramLBSInfo.equals(new LBSInfo()))
      {
        QLog.d("C2BLBSUtil", 2, "getPoiList info is empty");
        break;
      }
      QLog.d("C2BLBSUtil", 2, "getPoiList info = " + a(paramLBSInfo, new JSONArray()));
      break;
      if (paramC2BLBSObserver != null)
      {
        if (this.a == null) {
          this.a = new xyw(paramLBSInfo);
        }
        this.a.a(paramC2BLBSObserver);
        paramAppInterface.runOnUiThread(new xyu(this, paramContext, paramAppInterface, paramString, paramLBSInfo));
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("C2BLBSUtil", 2, "Observer is null");
  }
  
  public void a(Context paramContext, C2BLBSUtil.C2BLBSObserver paramC2BLBSObserver)
  {
    if ((paramContext != null) && (paramC2BLBSObserver != null)) {
      SosoInterface.a(new xyv(3, false, false, "c2blbs", paramC2BLBSObserver));
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("C2BLBSUtil", 2, "LBSUtils getLocation but context is null or observer is null");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\c2b\C2BLBSUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */