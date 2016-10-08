package cooperation.c2b;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.av.ui.AVActivity;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import xzz;
import yaa;
import yab;

public class C2BWebPlugin
  extends WebViewPlugin
{
  public static final int a = 0;
  public static final String a = "mqqc2b";
  public static final int b = 1;
  private static final String b = "C2BWebPlugin";
  private static final String c = "com.tencent.mobileqq:video";
  public static final int d = 0;
  public static final int e = 1;
  private long jdField_a_of_type_Long;
  private yab jdField_a_of_type_Yab;
  public int c;
  
  public C2BWebPlugin()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.c = 1;
    this.mPluginNameSpace = "mqqc2b";
  }
  
  private void a()
  {
    Activity localActivity = this.mRuntime.a();
    Intent localIntent = new Intent(localActivity, AVActivity.class);
    localIntent.setFlags(268566528);
    localActivity.startActivity(localIntent);
    localIntent = new Intent("tencent.c2b.action.C2BBrowser.call.arti");
    localIntent.putExtra("callback_destroy", "window.webc2b.showArtPage(\"\")");
    localIntent.setPackage(localActivity.getPackageName());
    this.mRuntime.a().sendBroadcast(localIntent);
  }
  
  private void a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    paramString1 = String.format("window.%s(\"%s\",%d,\"%s\")", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt), paramString3 });
    paramString2 = this.mRuntime.a();
    if (paramString2 != null) {
      paramString2.c(paramString1);
    }
    if (QLog.isColorLevel()) {
      QLog.d("C2BWebPlugin", 2, "onGetQRCode js:" + paramString1);
    }
  }
  
  private void a(String paramString, Map paramMap, boolean paramBoolean)
  {
    if ((paramBoolean) && (QavCameraUsage.b(BaseApplicationImpl.getContext()))) {
      if (QLog.isColorLevel()) {
        QLog.d("C2BWebPlugin", 2, "uploadImage: camera is using!");
      }
    }
    do
    {
      return;
      ReportController.b(null, "CliOper", "", "", "0X80061C4", "0X80061C4", 0, 0, "", "", "", "");
      if (paramMap.containsKey("callback")) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("C2BWebPlugin", 2, "uploadImage: params no callback. url = " + paramString);
    return;
    float f2 = 0.0F;
    float f1 = f2;
    if (paramMap.containsKey("ratio")) {}
    try
    {
      f1 = Float.parseFloat((String)paramMap.get("ratio"));
      if (paramBoolean)
      {
        paramString = new Intent(this.mRuntime.a(), C2BTakePhotoActivity.class);
        paramString.putExtra("work_mode", 0);
        paramString.putExtra("photo_ratio", f1);
        paramString.putExtra("callback", (String)paramMap.get("callback"));
        paramString.putExtra("destaction", "tencent.c2b.action.upload_image_or_video" + this.jdField_a_of_type_Long);
        paramString.putExtra("caller", a());
        this.mRuntime.a().startActivity(paramString);
        return;
      }
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        f1 = f2;
        if (QLog.isColorLevel())
        {
          QLog.d("C2BWebPlugin", 2, "uploadImage: ratio has wrong format. ratio=" + (String)paramMap.get("ratio"));
          f1 = f2;
          continue;
          paramString = new Intent(this.mRuntime.a(), C2BUploadFileActivity.class);
          paramString.putExtra("qq.process.param.uploadfile.choose", true);
        }
      }
    }
  }
  
  private void a(Map paramMap)
  {
    String str1 = (String)paramMap.get("lbscallback");
    String str2 = (String)paramMap.get("poicallback");
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
      if (NetworkUtil.e(BaseApplication.getContext()))
      {
        localIntent = new Intent("tencent.c2b.action.REQUEST_LOCATION");
        localIntent.putExtra("destaction", "tencent.c2b.action.RESPONSE_LBS" + this.jdField_a_of_type_Long);
        localIntent.putExtra("reqtime", System.currentTimeMillis());
        localIntent.putExtra("seq", (String)paramMap.get("seq"));
        localIntent.putExtra("caller", a());
        localIntent.putExtra("lbscallback", str1);
        localIntent.putExtra("poicallback", str2);
        localIntent.setPackage(this.mRuntime.a().getPackageName());
        this.mRuntime.a().sendBroadcast(localIntent, "com.tencent.qav.permission.broadcast");
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        Intent localIntent;
        return;
        paramMap = this.mRuntime.a();
        if (paramMap != null) {
          paramMap.c(String.format("window.%s('',1,'')", new Object[] { str1 }));
        }
      } while (!QLog.isColorLevel());
      QLog.i("C2BWebPlugin", 2, "queryLBSInfo no network");
      return;
    }
    QLog.i("C2BWebPlugin", 2, "queryLBSInfo no lbscallback or no poicallback");
  }
  
  private boolean a()
  {
    if (this.c == 0) {
      return true;
    }
    List localList = ((ActivityManager)this.mRuntime.a().a().getSystemService("activity")).getRunningAppProcesses();
    if (localList != null)
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext()) {
        if (((ActivityManager.RunningAppProcessInfo)localIterator.next()).processName.equals("com.tencent.mobileqq:video"))
        {
          QQToast.a(this.mRuntime.a(), this.mRuntime.a().getString(2131363947), 0).a();
          localList.clear();
          return false;
        }
      }
    }
    return true;
  }
  
  private void b(String paramString)
  {
    Map localMap = a(paramString);
    if (localMap.containsKey("src"))
    {
      localObject = (String)localMap.get("src");
      if (((String)localObject).equals("camera"))
      {
        a(paramString, localMap, true);
        return;
      }
      if (((String)localObject).equals("album"))
      {
        a(paramString, localMap, false);
        return;
      }
    }
    Object localObject = ActionSheet.c(this.mRuntime.a());
    ((ActionSheet)localObject).c("拍照");
    ((ActionSheet)localObject).c("从相册选择");
    ((ActionSheet)localObject).d("取消");
    ((ActionSheet)localObject).a(new xzz(this, paramString, localMap, (ActionSheet)localObject));
    ((ActionSheet)localObject).show();
  }
  
  private void b(Map paramMap)
  {
    String str = (String)paramMap.get("callback");
    if (str == null) {
      QLog.i("C2BWebPlugin", 2, "launchQRCodeScan callback is null.");
    }
    Activity localActivity;
    do
    {
      return;
      localActivity = this.mRuntime.a();
    } while (localActivity == null);
    Intent localIntent = new Intent(localActivity, C2BScanCodeActivity.class);
    localIntent.putExtra("destaction", "tencent.c2b.action.RESPONSE_QRCODE" + this.jdField_a_of_type_Long);
    Bundle localBundle = new Bundle();
    localBundle.putString("callback", str);
    localBundle.putString("seq", (String)paramMap.get("seq"));
    try
    {
      localBundle.putInt("dimension", Integer.parseInt((String)paramMap.get("dimension")));
      localBundle.putString("tipText", (String)paramMap.get("tipText"));
      localBundle.putString("tipImg", (String)paramMap.get("tipImg"));
      localIntent.putExtras(localBundle);
      localIntent.setPackage(localActivity.getPackageName());
      localIntent.putExtra("caller", a());
      localActivity.startActivity(localIntent);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;) {}
    }
  }
  
  private void c(String paramString)
  {
    if (!a()) {
      if (QLog.isColorLevel()) {
        QLog.d("C2BWebPlugin", 2, "uploadVideo: video process exist! " + paramString);
      }
    }
    Map localMap;
    do
    {
      return;
      localMap = a(paramString);
      if (localMap.containsKey("callback")) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("C2BWebPlugin", 2, "uploadVideo: params no callback. url = " + paramString);
    return;
    ReportController.b(null, "CliOper", "", "", "0X80061C5", "0X80061C5", 0, 0, "", "", "", "");
    if (localMap.containsKey("wording")) {}
    for (paramString = (String)localMap.get("wording");; paramString = null)
    {
      int i = 1;
      int j = i;
      if (localMap.containsKey("camera"))
      {
        j = i;
        if (!((String)localMap.get("camera")).equals("0")) {
          j = 0;
        }
      }
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (localMap.containsKey("allowSwitch"))
      {
        bool1 = bool2;
        if (!((String)localMap.get("allowSwitch")).equals("0")) {
          bool1 = true;
        }
      }
      if (localMap.containsKey("maxDuration")) {}
      label516:
      Intent localIntent2;
      for (;;)
      {
        try
        {
          long l = Long.parseLong((String)localMap.get("maxDuration"));
          int k = (int)l;
          if (k < 5)
          {
            i = 5;
            if (this.c != 0) {
              break label516;
            }
            Intent localIntent1 = new Intent("tencent.c2b.action.REQUEST_MIC_STATE");
            localIntent1.putExtra("destaction", "tencent.c2b.action.RESPONSE_MIC_STATE" + this.jdField_a_of_type_Long);
            localIntent1.putExtra("mic_state_type", "close");
            localIntent1.putExtra("work_mode", 1);
            localIntent1.putExtra("read_wording", paramString);
            localIntent1.putExtra("defalut_camera", j);
            localIntent1.putExtra("allow_switch_camera", bool1);
            localIntent1.putExtra("max_video_duration", i);
            localIntent1.putExtra("callback", (String)localMap.get("callback"));
            localIntent1.putExtra("caller", a());
            if (this.c != 0) {
              break;
            }
            localIntent1.setPackage(this.mRuntime.a().getPackageName());
            this.mRuntime.a().sendBroadcast(localIntent1);
            return;
          }
          i = k;
          if (k <= 120) {
            continue;
          }
          i = 120;
          continue;
          i = 15;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          if (QLog.isColorLevel()) {
            QLog.d("C2BWebPlugin", 2, "uploadImage: maxDuration has wrong format. maxDuration=" + (String)localMap.get("maxDuration"));
          }
        }
        continue;
        localIntent2 = new Intent(this.mRuntime.a(), C2BTakePhotoActivity.class);
        localIntent2.putExtra("destaction", "tencent.c2b.action.upload_image_or_video" + this.jdField_a_of_type_Long);
      }
      this.mRuntime.a().startActivity(localIntent2);
      return;
    }
  }
  
  private void c(Map paramMap)
  {
    String str = (String)paramMap.get("dtmf");
    paramMap = (String)paramMap.get("callback");
    if (!TextUtils.isEmpty(str))
    {
      Intent localIntent = new Intent("tencent.c2b.action.REQUEST_SEND_DTMF");
      localIntent.putExtra("destaction", "tencent.c2b.action.RESPONSE_DTMF" + this.jdField_a_of_type_Long);
      localIntent.putExtra("reqtime", System.currentTimeMillis());
      localIntent.putExtra("dtmf", str);
      localIntent.putExtra("callback", paramMap);
      localIntent.setPackage(this.mRuntime.a().getPackageName());
      this.mRuntime.a().sendBroadcast(localIntent);
    }
  }
  
  public String a()
  {
    return getClass().getName() + this.jdField_a_of_type_Long;
  }
  
  Map a(String paramString)
  {
    localHashMap = new HashMap();
    try
    {
      int i = paramString.indexOf('?');
      int j;
      int k;
      if (i != -1)
      {
        j = i + 1;
        k = paramString.indexOf('=', j);
        if (k != -1) {}
      }
      else
      {
        URLDecoder.decode(paramString, "UTF-8");
        return localHashMap;
      }
      i = paramString.indexOf('&', k + 1);
      String str2 = paramString.substring(j, k);
      if (i == -1) {}
      for (String str1 = paramString.substring(k + 1);; str1 = paramString.substring(k + 1, i))
      {
        localHashMap.put(URLDecoder.decode(str2, "UTF-8"), URLDecoder.decode(str1, "UTF-8"));
        break;
      }
      return localHashMap;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(String paramString)
  {
    paramString = a(paramString);
    if (paramString.containsKey("callback"))
    {
      paramString = (String)paramString.get("callback");
      if (paramString.equals("")) {}
    }
    try
    {
      Object localObject = new JSONObject();
      JSONArray localJSONArray = new JSONArray();
      localJSONArray.put("queryLBSInfo");
      localJSONArray.put("launchQRCodeScan");
      localJSONArray.put("clientSendDtmf");
      localJSONArray.put("uploadImage");
      ((JSONObject)localObject).put("abilityList", localJSONArray);
      paramString = String.format("window.%s('%s')", new Object[] { paramString, ((JSONObject)localObject).toString() });
      localObject = this.mRuntime.a();
      if (localObject != null) {
        ((CustomWebView)localObject).c(paramString);
      }
      if (QLog.isColorLevel()) {
        QLog.d("C2BWebPlugin", 2, "onGetQRCode js:" + paramString);
      }
      return;
    }
    catch (JSONException paramString) {}
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    if (paramString2 == null) {}
    do
    {
      return;
      paramString1 = String.format("window.%s(\"%s\")", new Object[] { paramString1, paramString2 });
      paramString2 = this.mRuntime.a();
      if (paramString2 != null) {
        paramString2.c(paramString1);
      }
    } while (!QLog.isColorLevel());
    QLog.d("C2BWebPlugin", 2, "onGetQRCode js:" + paramString1);
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3)
  {
    if (this.isDestroy) {
      return;
    }
    this.mRuntime.a().runOnUiThread(new yaa(this, paramInt2, paramString3, paramString1, paramInt1, paramString2));
  }
  
  protected boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    if (("mqqc2b".equals(paramString2)) && (paramString1.startsWith("mqqc2b://callcenter")))
    {
      if (!paramString1.contains("mqqc2b://callcenter")) {}
      do
      {
        return false;
        if (this.mRuntime.a() != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("C2BWebPlugin", 2, "handleSchemaRequest mRuntime.getActivity() == null ");
      return false;
      paramString2 = a(paramString1);
      if (paramString1.startsWith("mqqc2b://callcenter/queryLBSInfo")) {
        a(paramString2);
      }
      for (;;)
      {
        return true;
        if (paramString1.startsWith("mqqc2b://callcenter/launchQRCodeScan")) {
          b(paramString2);
        } else if (paramString1.startsWith("mqqc2b://callcenter/clientSendDtmf")) {
          c(paramString2);
        } else if (paramString1.startsWith("mqqc2b://callcenter/uploadImage")) {
          b(paramString1);
        } else if (paramString1.startsWith("mqqc2b://callcenter/uploadVideo")) {
          c(paramString1);
        } else if (paramString1.startsWith("mqqc2b://callcenter/getClientAbilityList")) {
          a(paramString1);
        } else if (paramString1.startsWith("mqqc2b://callcenter/gotoArtificial")) {
          a();
        }
      }
    }
    return super.handleSchemaRequest(paramString1, paramString2);
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.jdField_a_of_type_Yab = new yab(this, null);
    this.jdField_a_of_type_Long = new Random().nextLong();
    Object localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("tencent.c2b.action.RESPONSE_QRCODE" + this.jdField_a_of_type_Long);
    ((IntentFilter)localObject).addAction("tencent.c2b.action.RESPONSE_LBS" + this.jdField_a_of_type_Long);
    ((IntentFilter)localObject).addAction("tencent.c2b.action.RESPONSE_DTMF" + this.jdField_a_of_type_Long);
    ((IntentFilter)localObject).addAction("tencent.c2b.action.upload_image_or_video" + this.jdField_a_of_type_Long);
    ((IntentFilter)localObject).addAction("tencent.c2b.action.RESPONSE_MIC_STATE" + this.jdField_a_of_type_Long);
    ((IntentFilter)localObject).addAction("tencent.c2b.action.select_image ");
    this.mRuntime.a().registerReceiver(this.jdField_a_of_type_Yab, (IntentFilter)localObject);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("C2BWebPlugin onCreate : isMainProcess = ");
      if (Looper.myLooper() != Looper.getMainLooper()) {
        break label241;
      }
    }
    label241:
    for (boolean bool = true;; bool = false)
    {
      QLog.i("C2BWebPlugin", 2, bool);
      return;
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if ((this.jdField_a_of_type_Yab != null) && (this.mRuntime.a() != null)) {
      this.mRuntime.a().unregisterReceiver(this.jdField_a_of_type_Yab);
    }
    if (QLog.isColorLevel()) {
      QLog.i("C2BWebPlugin", 2, "C2BWebPlugin onDestroy");
    }
    if (this.mRuntime.a() != null)
    {
      Intent localIntent = new Intent("tencent.c2b.action.C2B_DESTORY");
      localIntent.setPackage(this.mRuntime.a().getPackageName());
      localIntent.putExtra("caller", a());
      this.mRuntime.a().sendBroadcast(localIntent);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\c2b\C2BWebPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */