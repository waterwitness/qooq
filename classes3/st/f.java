package st;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.hardware.SensorManager;
import android.location.LocationManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.Base64;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
{
  final Context a;
  final TelephonyManager b;
  final SensorManager c;
  final PackageManager d;
  PackageInfo e;
  String f;
  String g;
  String h;
  String i;
  String j;
  String k;
  String l;
  String m;
  int n = 0;
  int o = 0;
  int p = 0;
  int q = 0;
  private final WifiManager r;
  private final LocationManager s;
  private int t = 0;
  private int u = 0;
  private String v = "203";
  private String w = "1.2.1";
  
  public f(Context paramContext)
  {
    this.a = paramContext;
    this.r = ((WifiManager)this.a.getSystemService("wifi"));
    this.s = ((LocationManager)this.a.getSystemService("location"));
    this.b = ((TelephonyManager)this.a.getSystemService("phone"));
    this.c = ((SensorManager)this.a.getSystemService("sensor"));
    this.d = this.a.getPackageManager();
    this.e = new PackageInfo();
    try
    {
      this.e = this.d.getPackageInfo(this.a.getPackageName(), 0);
      return;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  private String a()
  {
    try
    {
      if (this.r == null) {
        break label35;
      }
      Object localObject = this.r.getConnectionInfo();
      if (localObject == null) {
        break label52;
      }
      localObject = ((WifiInfo)localObject).getMacAddress();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return "0123456789ABCDEF";
    }
    catch (Error localError)
    {
      for (;;)
      {
        label35:
        localError.printStackTrace();
      }
    }
    return "0123456789ABCDEF";
    while (localError != null)
    {
      return localError;
      label52:
      String str = "";
    }
  }
  
  private static String a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  private boolean b()
  {
    try
    {
      boolean bool = this.s.isProviderEnabled("gps");
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  @SuppressLint({"NewApi"})
  private boolean c()
  {
    boolean bool1 = false;
    boolean bool2;
    if (this.r != null)
    {
      bool2 = this.r.isWifiEnabled();
      bool1 = bool2;
      if (!bool2) {
        bool1 = bool2;
      }
    }
    try
    {
      if (Build.VERSION.SDK_INT >= 18) {
        bool1 = this.r.isScanAlwaysAvailable();
      }
      return bool1;
    }
    catch (Error localError)
    {
      return bool2;
    }
    catch (Exception localException) {}
    return bool2;
  }
  
  public final String a(byte[] paramArrayOfByte)
  {
    int i2 = 1;
    HashMap localHashMap = new HashMap();
    localHashMap.put("version", this.w);
    localHashMap.put("app_name", a(this.j));
    if (this.k != null)
    {
      localHashMap.put("app_label", a(Base64.encodeToString(this.k.getBytes(), 0)));
      if (!b()) {
        break label352;
      }
      i1 = 1;
      label73:
      this.u = i1;
      if ((this.r == null) || (!this.r.isWifiEnabled())) {
        break label357;
      }
      i1 = 1;
      label97:
      if ((i1 | c()) == 0) {
        break label362;
      }
    }
    label352:
    label357:
    label362:
    for (int i1 = i2;; i1 = 0)
    {
      this.t = i1;
      localHashMap.put("chips", Integer.toBinaryString(this.q | 0x0 | this.p << 1 | this.o << 2 | this.n << 3 | this.u << 4 | this.t << 5));
      localHashMap.put("source", this.v);
      localHashMap.put("query", new String(paramArrayOfByte));
      try
      {
        paramArrayOfByte = new JSONObject(localHashMap);
        localHashMap = new HashMap();
        localHashMap.put("model", a(Base64.encodeToString(this.l.getBytes(), 0)));
        localHashMap.put("version", a(this.m));
        localHashMap.put("imei", a(this.f));
        localHashMap.put("imsi", a(this.g));
        localHashMap.put("phonenum", a(this.h));
        localHashMap.put("qq", a(this.i));
        localHashMap.put("mac", a(a().toLowerCase(Locale.ENGLISH)));
        paramArrayOfByte = paramArrayOfByte.put("attribute", new JSONObject(localHashMap)).toString();
        return paramArrayOfByte;
      }
      catch (JSONException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
      }
      localHashMap.put("app_label", "");
      break;
      i1 = 0;
      break label73;
      i1 = 0;
      break label97;
    }
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\st\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */