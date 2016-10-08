package com.tencent.device.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.appcommon.AppClient;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.ToastUtil;
import com.tencent.open.business.base.AppUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import cooperation.plugin.PluginBaseActivity;
import cooperation.smartdevice.SmartDevicePluginLoader;
import cooperation.smartdevice.SmartDevicePluginProxyActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kdz;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.BaseActivity;
import mqq.observer.BusinessObserver;
import org.json.JSONArray;
import org.json.JSONObject;

public class LightAppUtil
{
  public static final int a = 0;
  protected static long a = 0L;
  protected static final String a = "LightAppUtil";
  public static ArrayList a;
  public static volatile ConcurrentHashMap a;
  public static final int b = 1;
  protected static final long b = 15000L;
  protected static final String b = "LightAppUtil";
  public static final int c = 2;
  protected static final String c = "http://qzs.qq.com/open/mobile/qq_download/index.html";
  public static final int d = 3;
  public static final String d = "http://qzs.qq.com/open/mobile/share_device/agreement.html";
  public static final int e = 4;
  public static final int f = 5;
  public static final int g = 6;
  public static final int h = 7;
  public static final int i = 8;
  public static final int j = 9;
  public Activity a;
  public Bundle a;
  public DeviceInfo a;
  public LightAppUtil.GetLightAppSettingListener a;
  public QQProgressDialog a;
  public AppRuntime a;
  private BusinessObserver a;
  protected boolean a;
  protected ArrayList b;
  public boolean b;
  public boolean c;
  public boolean d;
  protected String e;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public LightAppUtil()
  {
    this.jdField_a_of_type_MqqObserverBusinessObserver = new kdz(this);
    this.jdField_a_of_type_MqqAppAppRuntime = BaseApplicationImpl.a().a();
    this.c = false;
  }
  
  public LightAppUtil(Activity paramActivity)
  {
    this.jdField_a_of_type_MqqObserverBusinessObserver = new kdz(this);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof AppActivity))
    {
      this.jdField_a_of_type_MqqAppAppRuntime = ((AppActivity)this.jdField_a_of_type_AndroidAppActivity).getAppRuntime();
      this.c = true;
    }
    while (!(this.jdField_a_of_type_AndroidAppActivity instanceof BaseActivity)) {
      return;
    }
    this.jdField_a_of_type_MqqAppAppRuntime = ((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).getAppRuntime();
    this.c = false;
  }
  
  public LightAppUtil(Activity paramActivity, LightAppUtil.GetLightAppSettingListener paramGetLightAppSettingListener)
  {
    this.jdField_a_of_type_MqqObserverBusinessObserver = new kdz(this);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener = paramGetLightAppSettingListener;
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof AppActivity))
    {
      this.jdField_a_of_type_MqqAppAppRuntime = ((AppActivity)this.jdField_a_of_type_AndroidAppActivity).getAppRuntime();
      this.c = true;
    }
    while (!(this.jdField_a_of_type_AndroidAppActivity instanceof BaseActivity)) {
      return;
    }
    this.jdField_a_of_type_MqqAppAppRuntime = ((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).getAppRuntime();
    this.c = false;
  }
  
  public static String a(Resources paramResources, LightAppSettingInfo paramLightAppSettingInfo, String paramString)
  {
    String str;
    if (!TextUtils.isEmpty(paramString))
    {
      str = paramString;
      if (!paramString.equals("null")) {}
    }
    else
    {
      str = paramResources.getString(2131362365);
    }
    if ((!TextUtils.isEmpty(paramLightAppSettingInfo.b)) && (!TextUtils.isEmpty(paramLightAppSettingInfo.a)) && (AppUtil.a(paramLightAppSettingInfo.b))) {
      return paramResources.getString(2131362364, new Object[] { str });
    }
    return paramResources.getString(2131362363, new Object[] { str });
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (AppUtil.a(paramString1)))
    {
      AppUtil.a(paramActivity, paramString1);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("autoDownload", false);
    localBundle.putString("packageName", paramString1);
    localBundle.putString("appId", paramString2);
    AppClient.b(paramActivity, localBundle);
  }
  
  private void a(Intent paramIntent, LightAppSettingInfo paramLightAppSettingInfo)
  {
    String str = null;
    if (paramLightAppSettingInfo.g == 2) {
      str = "http://qzs.qq.com/open/mobile/iot_public_device_2/html/ipCamera.html";
    }
    for (;;)
    {
      paramIntent.putExtra("url", str);
      return;
      if (paramLightAppSettingInfo.g == 17) {
        str = "http://qzs.qq.com/open/mobile/iot_public_device_2/html/print.html";
      }
    }
  }
  
  public static void a(ArrayList paramArrayList)
  {
    if (paramArrayList == null) {}
    for (;;)
    {
      return;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        LightAppSettingInfo localLightAppSettingInfo = (LightAppSettingInfo)paramArrayList.next();
        if (!jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(localLightAppSettingInfo.f)))
        {
          jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(localLightAppSettingInfo.f), localLightAppSettingInfo);
          jdField_a_of_type_JavaUtilArrayList.add(localLightAppSettingInfo);
        }
      }
    }
  }
  
  public static void c()
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  private void d()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("uin", this.e);
    Object localObject = new StringBuilder();
    if (this.jdField_b_of_type_JavaUtilArrayList != null)
    {
      int k = 0;
      while (k < this.jdField_b_of_type_JavaUtilArrayList.size())
      {
        ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaUtilArrayList.get(k));
        if (k != this.jdField_b_of_type_JavaUtilArrayList.size() - 1) {
          ((StringBuilder)localObject).append(",");
        }
        k += 1;
      }
    }
    localBundle.putString("pids", ((StringBuilder)localObject).toString());
    if ((this.d) && (this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo != null)) {
      localBundle.putLong("din", this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo.din);
    }
    if (this.d) {}
    for (localObject = "get_public_lightapp_info";; localObject = "get_lightapp_info")
    {
      SmartDeviceUtil.a((String)localObject, localBundle, this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_MqqObserverBusinessObserver);
      return;
    }
  }
  
  public LightAppSettingInfo a(DeviceInfo paramDeviceInfo)
  {
    LightAppSettingInfo localLightAppSettingInfo2 = (LightAppSettingInfo)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramDeviceInfo.productId));
    LightAppSettingInfo localLightAppSettingInfo1 = localLightAppSettingInfo2;
    if (localLightAppSettingInfo2 == null)
    {
      localLightAppSettingInfo1 = localLightAppSettingInfo2;
      if (!this.c)
      {
        AppRuntime localAppRuntime = BaseApplicationImpl.a().a();
        localLightAppSettingInfo1 = localLightAppSettingInfo2;
        if ((localAppRuntime instanceof QQAppInterface))
        {
          a(((SmartDeviceProxyMgr)((QQAppInterface)localAppRuntime).a(51)).a());
          localLightAppSettingInfo1 = (LightAppSettingInfo)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramDeviceInfo.productId));
        }
      }
    }
    return localLightAppSettingInfo1;
  }
  
  public HashMap a(JSONArray paramJSONArray)
  {
    localHashMap = new HashMap();
    if (paramJSONArray != null) {
      try
      {
        if (paramJSONArray.length() > 0)
        {
          int k = 0;
          while (k < paramJSONArray.length())
          {
            JSONObject localJSONObject = (JSONObject)paramJSONArray.get(k);
            if (localJSONObject != null) {
              localHashMap.put(Integer.valueOf(localJSONObject.getInt("property_id")), localJSONObject.getString("property_val"));
            }
            k += 1;
          }
        }
        return localHashMap;
      }
      catch (Exception paramJSONArray) {}
    }
  }
  
  public void a()
  {
    Object localObject1 = BaseApplicationImpl.a().a();
    if ((localObject1 instanceof QQAppInterface))
    {
      localObject1 = ((SmartDeviceProxyMgr)((QQAppInterface)localObject1).a(51)).a();
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        ArrayList localArrayList = new ArrayList();
        if (SystemClock.elapsedRealtime() - jdField_a_of_type_Long > 15000L)
        {
          jdField_a_of_type_Long = SystemClock.elapsedRealtime();
          int m = localObject1.length;
          int k = 0;
          while (k < m)
          {
            Object localObject2 = localObject1[k];
            if (!jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(((DeviceInfo)localObject2).productId))) {
              localArrayList.add(Integer.valueOf(((DeviceInfo)localObject2).productId));
            }
            k += 1;
          }
          if (localArrayList.size() > 0) {
            a(localArrayList, false);
          }
        }
      }
    }
  }
  
  public void a(DeviceInfo paramDeviceInfo, Bundle paramBundle, boolean paramBoolean)
  {
    if (paramDeviceInfo == null)
    {
      if (this.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener != null) {
        this.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener.a(false);
      }
      return;
    }
    if (paramBundle != null) {}
    for (boolean bool = paramBundle.getBoolean("showProgress", true);; bool = true)
    {
      this.jdField_b_of_type_Boolean = true;
      this.d = paramBoolean;
      LightAppSettingInfo localLightAppSettingInfo = a(paramDeviceInfo);
      String str;
      Intent localIntent1;
      if (localLightAppSettingInfo != null) {
        if ((localLightAppSettingInfo.h != 3) && (localLightAppSettingInfo.h != 7) && (localLightAppSettingInfo.h != 5) && (localLightAppSettingInfo.h != 4) && (localLightAppSettingInfo.h != 1) && (localLightAppSettingInfo.h != 8) && (localLightAppSettingInfo.h != 9))
        {
          if (QLog.isColorLevel()) {
            QLog.e("LightAppUtil", 2, "bindType=" + localLightAppSettingInfo.h);
          }
          ToastUtil.a().a(2131362362);
          str = null;
          localIntent1 = null;
        }
      }
      for (;;)
      {
        label175:
        if ((str == null) && (localIntent1 == null))
        {
          paramDeviceInfo = new Intent();
          paramDeviceInfo.setClassName("com.tencent.mobileqq", "com.tencent.biz.pubaccount.PublicAccountBrowser");
          paramDeviceInfo.putExtra("url", "http://qzs.qq.com/open/mobile/qq_download/index.html");
          paramDeviceInfo.putExtra("isPublicDevice", paramBoolean);
          SmartDeviceReport.a(null, "Net_LiteApp_Setting", 0, 1, localLightAppSettingInfo.f);
          if (str != null) {
            break label755;
          }
          this.jdField_a_of_type_AndroidAppActivity.startActivity(paramDeviceInfo);
        }
        for (;;)
        {
          if (this.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener == null) {
            break label836;
          }
          this.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener.a(true);
          return;
          if (localLightAppSettingInfo.jdField_d_of_type_Int == 0) {
            switch (localLightAppSettingInfo.g)
            {
            default: 
              if ((TextUtils.isEmpty(localLightAppSettingInfo.c)) && (TextUtils.isEmpty(localLightAppSettingInfo.jdField_d_of_type_JavaLangString))) {
                break label971;
              }
              str = "com.tencent.device.lightapp.LightAppActivity";
              localIntent1 = null;
              break;
            case 2: 
              if ((this.d) && (a()))
              {
                str = "com.tencent.device.lightapp.LightAppActivity";
                localIntent1 = null;
                break;
              }
              str = "com.tencent.device.av.VideoActivity";
              localIntent1 = null;
              break;
            case 9: 
              localIntent1 = new Intent();
              localIntent1.setClassName("com.tencent.mobileqq", "com.dataline.activities.DLRouterActivity");
              localIntent1.putExtra("isBack2Root", true);
              str = null;
              break;
            case 14: 
              str = "com.tencent.device.qqwifi.WiFiStorageActivity";
              localIntent1 = null;
              break;
            case 16: 
              str = "com.tencent.device.av.VisualDoorBellActivity";
              localIntent1 = null;
              break;
            case 17: 
              str = "com.tencent.device.lightapp.LightAppActivity";
              localIntent1 = null;
              break;
            }
          }
          if (localLightAppSettingInfo.jdField_d_of_type_Int == 1)
          {
            if ((TextUtils.isEmpty(localLightAppSettingInfo.c)) && (TextUtils.isEmpty(localLightAppSettingInfo.jdField_d_of_type_JavaLangString))) {
              break label971;
            }
            str = "com.tencent.device.lightapp.LightAppActivity";
            localIntent1 = null;
            break label175;
          }
          ToastUtil.a().a(2131362361);
          if (this.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener == null) {
            break;
          }
          this.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener.a(false);
          return;
          Bundle localBundle = new Bundle();
          localBundle.putParcelable("device_info", paramDeviceInfo);
          localBundle.putParcelable("lightapp_setting", localLightAppSettingInfo);
          if (paramBundle != null) {
            localBundle.putBundle("extras", paramBundle);
          }
          Intent localIntent2 = localIntent1;
          if (localIntent1 == null) {
            localIntent2 = new Intent();
          }
          localIntent2.putExtra("uin", String.valueOf(paramDeviceInfo.din));
          if (!TextUtils.isEmpty(paramDeviceInfo.displayName)) {
            localIntent2.putExtra("uinname", paramDeviceInfo.displayName);
          }
          for (;;)
          {
            localIntent2.putExtra("account", paramDeviceInfo.serialNum);
            localIntent2.putExtra("pid", paramDeviceInfo.productId);
            localIntent2.putExtra("device_info", paramDeviceInfo);
            localIntent2.putExtra("isPublicDevice", paramBoolean);
            if (this.d) {
              a(localIntent2, localLightAppSettingInfo);
            }
            if ((paramBundle != null) && (paramBundle.getBoolean("isFromBindSucc", false))) {
              localIntent2.putExtra("bindSuccTime", System.currentTimeMillis());
            }
            localIntent2.putExtras(localBundle);
            paramDeviceInfo = localIntent2;
            break;
            localIntent2.putExtra("uinname", SmartDeviceUtil.a(paramDeviceInfo));
          }
          label755:
          if ((this.jdField_a_of_type_AndroidAppActivity instanceof PluginBaseActivity))
          {
            paramDeviceInfo.setClassName(this.jdField_a_of_type_AndroidAppActivity, str);
            this.jdField_a_of_type_AndroidAppActivity.startActivity(paramDeviceInfo);
          }
          else
          {
            if ((this.jdField_a_of_type_AndroidAppActivity instanceof ChatActivity)) {
              paramDeviceInfo.putExtra("bFromChatActivity", true);
            }
            SmartDevicePluginLoader.a().a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_MqqAppAppRuntime.getAccount(), paramDeviceInfo, str, -1, null, SmartDevicePluginProxyActivity.class);
          }
        }
        label836:
        break;
        if (this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo == null)
        {
          if (!NetworkUtil.h(this.jdField_a_of_type_AndroidAppActivity))
          {
            ToastUtil.a().a(2131362360);
            if (this.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener == null) {
              break;
            }
            this.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener.a(false);
            return;
          }
          this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo = paramDeviceInfo;
          this.jdField_a_of_type_AndroidOsBundle = paramBundle;
          paramBundle = new ArrayList();
          paramBundle.add(Integer.valueOf(paramDeviceInfo.productId));
          a(paramBundle, bool);
          return;
        }
        ToastUtil.a().a(2131362359);
        if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (!this.jdField_a_of_type_AndroidAppActivity.isFinishing())) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        }
        if (this.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener.a(false);
        return;
        label971:
        str = null;
        localIntent1 = null;
      }
    }
  }
  
  public void a(ArrayList paramArrayList, boolean paramBoolean)
  {
    this.jdField_b_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_Boolean = paramBoolean;
    b();
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_AndroidAppActivity == null) {
      return false;
    }
    Object localObject;
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof PluginBaseActivity))
    {
      localObject = ((PluginBaseActivity)this.jdField_a_of_type_AndroidAppActivity).getOutActivity();
      label30:
      if (localObject == null) {
        break label68;
      }
      localObject = new WebView((Context)localObject);
      if ((localObject == null) || (((WebView)localObject).getX5WebViewExtension() == null)) {
        break label70;
      }
    }
    label68:
    label70:
    for (boolean bool = true;; bool = false)
    {
      ((WebView)localObject).destroy();
      return bool;
      localObject = this.jdField_a_of_type_AndroidAppActivity;
      break label30;
      break;
    }
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_AndroidAppActivity == null) || (this.jdField_a_of_type_AndroidAppActivity.isFinishing())) {
        break label102;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131492908));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131362358);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
    while (this.jdField_a_of_type_MqqAppAppRuntime == null)
    {
      LogUtility.d("LightAppUtil", "app == null when dologin");
      if (this.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener != null) {
        this.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener.a(false);
      }
      return;
      label102:
      this.jdField_a_of_type_Boolean = false;
    }
    this.e = this.jdField_a_of_type_MqqAppAppRuntime.getAccount();
    if (TextUtils.isEmpty(this.e)) {
      ToastUtil.a().a(2131369842);
    }
    d();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\device\utils\LightAppUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */