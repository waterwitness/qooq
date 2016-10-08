package cooperation.qzone;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.util.NetworkState;

public class PlatformInfor
{
  private static PlatformInfor jdField_a_of_type_CooperationQzonePlatformInfor;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static final String jdField_a_of_type_JavaLangString;
  private static final String d = "wifi";
  private static final String e = "2g";
  private static final String f = "3g";
  private static final String g = "4g";
  private static String h = "";
  private static String i = "";
  private Context jdField_a_of_type_AndroidContentContext = BaseApplication.getContext();
  private TelephonyManager jdField_a_of_type_AndroidTelephonyTelephonyManager = (TelephonyManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("phone");
  private String b = "";
  private String c;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = PlatformInfor.class.getSimpleName();
  }
  
  private PlatformInfor()
  {
    try
    {
      h = this.jdField_a_of_type_AndroidContentContext.getPackageManager().getPackageInfo(this.jdField_a_of_type_AndroidContentContext.getPackageName(), 0).versionName;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static PlatformInfor a()
  {
    if (jdField_a_of_type_CooperationQzonePlatformInfor == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_CooperationQzonePlatformInfor == null) {
        jdField_a_of_type_CooperationQzonePlatformInfor = new PlatformInfor();
      }
      return jdField_a_of_type_CooperationQzonePlatformInfor;
    }
  }
  
  private void a()
  {
    try
    {
      h = this.jdField_a_of_type_AndroidContentContext.getPackageManager().getPackageInfo(this.jdField_a_of_type_AndroidContentContext.getPackageName(), 0).versionName;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private String h()
  {
    switch ()
    {
    default: 
      return "wan";
    case 1: 
      return "wifi";
    case 2: 
      return "3g";
    case 3: 
      return "2g";
    }
    return "4g";
  }
  
  public int a()
  {
    return SharpPDec.a(this.jdField_a_of_type_AndroidContentContext);
  }
  
  public String a()
  {
    if ((h == null) || (h.length() == 0)) {
      a();
    }
    return h;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public String c()
  {
    try
    {
      if (!TextUtils.isEmpty(i)) {
        return i;
      }
      if (this.jdField_a_of_type_AndroidTelephonyTelephonyManager != null)
      {
        i = this.jdField_a_of_type_AndroidTelephonyTelephonyManager.getSubscriberId();
        return i;
      }
      return "";
    }
    catch (Exception localException) {}
    return "";
  }
  
  public String d()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("MANUFACTURER=" + Build.MANUFACTURER + ",SDK=" + Build.VERSION.SDK_INT + ",board=" + Build.BOARD);
    localStringBuffer.append(",device=" + Build.DEVICE);
    localStringBuffer.append(",brand=" + Build.BRAND);
    localStringBuffer.append(",display=" + Build.DISPLAY);
    localStringBuffer.append(",model=" + Build.MODEL);
    localStringBuffer.append(",product=" + Build.PRODUCT);
    return localStringBuffer.toString();
  }
  
  public String e()
  {
    if ((this.c != null) && (this.c.length() > 0))
    {
      localObject = new StringBuilder(this.c);
      ((StringBuilder)localObject).append("n=").append(h());
      return ((StringBuilder)localObject).toString();
    }
    Object localObject = (WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window");
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)localObject).getDefaultDisplay().getMetrics(localDisplayMetrics);
    StringBuilder localStringBuilder = new StringBuilder();
    localObject = "";
    try
    {
      String str = this.jdField_a_of_type_AndroidTelephonyTelephonyManager.getDeviceId();
      localObject = str;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        continue;
        int j = 0;
      }
    }
    localStringBuilder.append("i=").append((String)localObject).append('&');
    localStringBuilder.append("mac=").append(g()).append('&');
    localStringBuilder.append("m=").append(Build.MODEL).append('&');
    localStringBuilder.append("o=").append(Build.VERSION.RELEASE).append('&');
    localStringBuilder.append("a=").append(Build.VERSION.SDK_INT).append('&');
    localObject = localStringBuilder.append("sc=");
    if (Environment.getExternalStorageState().equals("mounted"))
    {
      j = 1;
      ((StringBuilder)localObject).append(j).append('&');
      localStringBuilder.append("sd=").append("0").append('&');
      localStringBuilder.append("p=").append(localDisplayMetrics.widthPixels).append('*').append(localDisplayMetrics.heightPixels).append('&');
      localStringBuilder.append("f=").append(Build.MANUFACTURER).append('&');
      localStringBuilder.append("mm=").append(DeviceInfoUtil.c() / 1048576L).append('&');
      localStringBuilder.append("cf=").append(DeviceInfoUtil.a()).append('&');
      localStringBuilder.append("cc=").append(DeviceInfoUtil.b()).append('&');
      localStringBuilder.append("aid=").append(DeviceInfoUtil.f()).append('&');
      localStringBuilder.append("sharpP=").append(a()).append('&');
      this.c = localStringBuilder.toString();
      localStringBuilder.append("n=").append(h());
      return localStringBuilder.toString();
    }
  }
  
  public String f()
  {
    String str2 = NetworkState.b();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public String g()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidContentContext == null) {
        return "null";
      }
      Object localObject = (WifiManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("wifi");
      if (localObject == null) {
        return "null";
      }
      localObject = ((WifiManager)localObject).getConnectionInfo();
      if (localObject == null) {
        return "null";
      }
      localObject = ((WifiInfo)localObject).getMacAddress();
      return (String)localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "null";
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\PlatformInfor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */