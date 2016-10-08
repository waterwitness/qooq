package com.tencent.open.adapter;

import android.app.ActivityManager;
import android.app.ActivityManager.RecentTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.base.APNUtil;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.open.business.base.appreport.AppReport;
import com.tencent.open.business.base.appreport.AppUpdate;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class CommonDataAdapter
{
  public static final int a = 200;
  protected static CommonDataAdapter a;
  public static final String a = "photo_size_preference";
  public static final String b = "auto";
  public static final String c = "isrequireqauth";
  protected static final String d = "11";
  protected static String e = "androidqq";
  public static final String l = "scheme";
  public static final String m = "source";
  public static final String n = "app";
  protected static final String o = "AppUpdate";
  protected long a;
  protected Context a;
  protected int b;
  protected long b;
  protected String f = "";
  protected String g = "";
  protected String h = "";
  protected String i = "";
  protected String j = "";
  protected String k = "";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected CommonDataAdapter()
  {
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_AndroidContentContext = BaseApplication.getContext();
  }
  
  public static CommonDataAdapter a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentOpenAdapterCommonDataAdapter == null) {
        jdField_a_of_type_ComTencentOpenAdapterCommonDataAdapter = new CommonDataAdapter();
      }
      CommonDataAdapter localCommonDataAdapter = jdField_a_of_type_ComTencentOpenAdapterCommonDataAdapter;
      return localCommonDataAdapter;
    }
    finally {}
  }
  
  public int a()
  {
    if (this.jdField_b_of_type_Int != -1) {
      return this.jdField_b_of_type_Int;
    }
    a();
    return this.jdField_b_of_type_Int;
  }
  
  public long a()
  {
    Object localObject;
    if (this.jdField_a_of_type_Long <= 0L)
    {
      localObject = DownloadManager.a().a();
      if (localObject == null) {}
    }
    try
    {
      localObject = (AppInterface)((WeakReference)localObject).get();
      if (localObject != null)
      {
        localObject = ((AppInterface)localObject).a();
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          this.jdField_a_of_type_Long = Long.valueOf((String)localObject).longValue();
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    return this.jdField_a_of_type_Long;
  }
  
  public Context a()
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return BaseApplication.getContext();
    }
    return this.jdField_a_of_type_AndroidContentContext;
  }
  
  public String a()
  {
    return this.f;
  }
  
  public String a(int paramInt, Context paramContext)
  {
    Object localObject1 = (ActivityManager)paramContext.getSystemService("activity");
    PackageManager localPackageManager = paramContext.getPackageManager();
    int i2 = paramInt;
    if (paramInt <= 0) {
      i2 = 5;
    }
    localObject1 = ((ActivityManager)localObject1).getRecentTasks(64, 1);
    ArrayList localArrayList = new ArrayList();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{");
    int i5;
    int i3;
    Object localObject2;
    if (localObject1 != null)
    {
      i5 = ((List)localObject1).size();
      i3 = 0;
      paramInt = 0;
      if ((i3 < i5) && (paramInt < i2))
      {
        localObject2 = (ActivityManager.RecentTaskInfo)((List)localObject1).get(i3);
        paramContext = ((ActivityManager.RecentTaskInfo)localObject2).baseIntent;
        localObject2 = ((ActivityManager.RecentTaskInfo)localObject2).origActivity;
        if (localObject2 != null) {
          paramContext = ((ComponentName)localObject2).getPackageName();
        }
      }
    }
    for (;;)
    {
      label132:
      int i1 = paramInt;
      if (paramContext != null)
      {
        if (localArrayList.contains(paramContext)) {}
        for (;;)
        {
          i3 += 1;
          break;
          if (paramContext == null) {
            break label393;
          }
          paramContext = paramContext.getComponent().getPackageName();
          break label132;
          localArrayList.add(paramContext);
          i1 = -1;
          try
          {
            localObject2 = localPackageManager.getPackageInfo(paramContext, 0);
            if (localObject2 != null) {
              break label206;
            }
          }
          catch (PackageManager.NameNotFoundException paramContext)
          {
            paramContext.printStackTrace();
          }
        }
        label206:
        if (localObject2 != null)
        {
          i1 = ((PackageInfo)localObject2).versionCode;
          String str = ((PackageInfo)localObject2).versionName;
        }
        if ((((PackageInfo)localObject2).applicationInfo.flags & 0x1) == 0) {
          break label387;
        }
      }
      label387:
      for (int i4 = 1;; i4 = 0)
      {
        paramInt += 1;
        localStringBuilder.append("\"");
        localStringBuilder.append(paramContext);
        localStringBuilder.append("\"");
        localStringBuilder.append(":");
        localStringBuilder.append("\"");
        localStringBuilder.append(i1);
        localStringBuilder.append(",");
        localStringBuilder.append(i4);
        localStringBuilder.append("\"");
        i1 = paramInt;
        if (i3 < i5 - 1)
        {
          localStringBuilder.append(",");
          i1 = paramInt;
        }
        paramInt = i1;
        break;
        paramInt = localStringBuilder.length();
        if (localStringBuilder.charAt(paramInt - 1) == ',') {
          localStringBuilder.deleteCharAt(paramInt - 1);
        }
        localStringBuilder.append("}");
        return localStringBuilder.toString();
      }
      label393:
      paramContext = null;
    }
  }
  
  protected void a()
  {
    Object localObject = a().a();
    try
    {
      localObject = ((Context)localObject).getPackageManager().getPackageInfo(((Context)localObject).getPackageName(), 0);
      this.g = ((PackageInfo)localObject).versionName;
      this.h = (this.g + "." + ((PackageInfo)localObject).versionCode);
      this.i = this.g.substring(this.g.lastIndexOf('.') + 1, this.g.length());
      this.jdField_b_of_type_Int = ((PackageInfo)localObject).versionCode;
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      localNameNotFoundException.printStackTrace();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(String paramString)
  {
    this.f = paramString;
  }
  
  public void a(String paramString, Context paramContext, WebView paramWebView)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramString);
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("imei", MobileInfoUtil.c());
      localJSONObject2.put("imsi", MobileInfoUtil.d());
      localJSONObject2.put("mac_addr", MobileInfoUtil.a());
      localJSONObject2.put("model_info", Build.MODEL);
      localJSONObject2.put("network_type", APNUtil.a(a().a()));
      localJSONObject2.put("network_operater", "");
      localJSONObject2.put("location", MobileInfoUtil.f());
      localJSONObject2.put("android_id", Settings.Secure.getString(a().a().getContentResolver(), "android_id"));
      localJSONObject2.put("os_api_level", Build.VERSION.SDK_INT);
      JSONObject localJSONObject3 = localJSONObject1.optJSONObject("params");
      if ((localJSONObject3 != null) && (localJSONObject3.length() > 0))
      {
        Iterator localIterator = localJSONObject3.keys();
        while (localIterator.hasNext())
        {
          String str2 = localIterator.next().toString();
          Object localObject = localJSONObject3.get(str2);
          if (!TextUtils.isEmpty(str2)) {
            localJSONObject2.put(str2, localObject);
          }
        }
      }
      String str1;
      return;
    }
    catch (JSONException localJSONException)
    {
      LogUtility.e("AppUpdate", "getUpdateApp parse H5 params error : " + localJSONException.toString());
      if (!paramContext.getSharedPreferences("appcenter_app_report", 0).getBoolean("is_app_last_fullReport_success", false))
      {
        LogUtility.c("AppUpdate", "getUpdateApp will do full report");
        AppReport.a(paramContext, paramString, paramWebView, String.valueOf(a().a()), false);
        return;
        if (localJSONObject3 != null) {
          localJSONObject2.put("latest_used", a(localJSONObject3.optInt("latest_num", 10), paramContext));
        }
        for (;;)
        {
          localJSONException.put("params", localJSONObject2);
          str1 = localJSONException.toString();
          paramString = str1;
          break;
          localJSONObject2.put("latest_used", a(10, paramContext));
        }
      }
      if (new File(paramContext.getFilesDir() + File.separator + "appcenter_app_report_storage_file.txt").exists())
      {
        LogUtility.c("AppUpdate", "getUpdateApp will do incremental report");
        AppReport.a(paramContext, null, 0, paramString, paramWebView, String.valueOf(a().a()));
        return;
      }
      LogUtility.c("AppUpdate", "getUpdateApp will get update app directly");
      AppUpdate.a(paramContext, paramWebView, paramString, true, String.valueOf(a().a()));
    }
  }
  
  public long b()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public String b()
  {
    if (!TextUtils.isEmpty(this.h)) {
      return this.h;
    }
    a();
    return this.h;
  }
  
  public void b(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
  }
  
  public void b(String paramString)
  {
    this.k = paramString;
  }
  
  public String c()
  {
    if (!TextUtils.isEmpty(this.g)) {
      return this.g;
    }
    a();
    return this.g;
  }
  
  public String d()
  {
    return "11";
  }
  
  public String e()
  {
    if (!TextUtils.isEmpty(this.j)) {
      return this.j;
    }
    this.j = ("V1_AND_SQ_" + b());
    return this.j;
  }
  
  public String f()
  {
    if (a() == null) {
      return "";
    }
    return a().getPackageName();
  }
  
  public String g()
  {
    return e;
  }
  
  public String h()
  {
    return this.k;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\adapter\CommonDataAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */