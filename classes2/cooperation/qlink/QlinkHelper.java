package cooperation.qlink;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.qq.jce.wup.BasicClassTypeUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLDecoder;

public class QlinkHelper
{
  private static final byte jdField_a_of_type_Byte = -94;
  private static final long jdField_a_of_type_Long = 662347895234L;
  private static final String jdField_a_of_type_JavaLangString = "_recvfile_FLAG_";
  private static final byte jdField_b_of_type_Byte = 104;
  private static final long jdField_b_of_type_Long = 456752456285L;
  private static final byte jdField_c_of_type_Byte = 27;
  private static final long jdField_c_of_type_Long = 789454421545L;
  
  public QlinkHelper()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static Intent a()
  {
    Intent localIntent = new Intent();
    QlinkPluginProxyActivity.a(localIntent, "com.tencent.qlink.activity.QlinkProxyActivity");
    return localIntent;
  }
  
  public static AppInterface a(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    if ((paramBaseApplicationImpl == null) || (paramString == null)) {
      return null;
    }
    try
    {
      Class localClass1 = Class.forName("com.tencent.qlink.app.QlinkAppInterface");
      if (localClass1 == null) {
        return null;
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      Class localClass2;
      try
      {
        ClassLoader localClassLoader = QlinkPluginProxyActivity.a(paramBaseApplicationImpl);
        localClass2 = localClassLoader.loadClass("com.tencent.qlink.app.QlinkAppInterface");
        BasicClassTypeUtil.setClassLoader(true, localClassLoader);
      }
      catch (ClassNotFoundException paramBaseApplicationImpl)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
      do
      {
        return null;
        paramBaseApplicationImpl = localClass2.getDeclaredConstructor(new Class[] { paramBaseApplicationImpl.getClass(), paramString.getClass() }).newInstance(new Object[] { paramBaseApplicationImpl, paramString });
      } while ((paramBaseApplicationImpl == null) || (!(paramBaseApplicationImpl instanceof AppInterface)));
      paramBaseApplicationImpl = (AppInterface)paramBaseApplicationImpl;
      return paramBaseApplicationImpl;
    }
    catch (IllegalArgumentException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (IllegalAccessException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (InstantiationException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (InvocationTargetException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (NoSuchMethodException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (Exception paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
  }
  
  public static QlinkHelper.QRScanInfo a(String paramString)
  {
    int i = 0;
    if (paramString == null) {}
    QlinkHelper.QRScanInfo localQRScanInfo;
    Object localObject;
    int j;
    String str2;
    for (;;)
    {
      return null;
      localQRScanInfo = new QlinkHelper.QRScanInfo();
      try
      {
        if (paramString.startsWith("qqf2f://qf/?"))
        {
          localObject = paramString.substring("qqf2f://qf/?".length(), paramString.length()).split("&");
          paramString = new Bundle();
          j = localObject.length;
        }
      }
      catch (Exception paramString)
      {
        int k;
        String str1;
        paramString.printStackTrace();
        return null;
      }
    }
    k = str2.indexOf("=");
    if (-1 != k)
    {
      str1 = str2.substring(0, k + 1);
      str2 = str2.substring(k + 1, str2.length());
      if ((str1 != null) && (str2 != null)) {
        paramString.putString(str1, str2);
      }
    }
    label269:
    for (;;)
    {
      localQRScanInfo.a = paramString.getString("k=");
      localQRScanInfo.b = d(paramString.getString("u="));
      localObject = b(paramString.getString("n="));
      if (localObject != null)
      {
        localQRScanInfo.c = URLDecoder.decode((String)localObject, "UTF-8");
        if (localQRScanInfo.c != null) {}
      }
      for (localQRScanInfo.c = localQRScanInfo.b;; localQRScanInfo.c = localQRScanInfo.b)
      {
        localQRScanInfo.d = paramString.getString("o=");
        localQRScanInfo.e = paramString.getString("p=");
        if ((localQRScanInfo.a == null) || (localQRScanInfo.b == null) || (localQRScanInfo.d == null)) {
          break;
        }
        return localQRScanInfo;
      }
      for (;;)
      {
        if (i >= j) {
          break label269;
        }
        str2 = localObject[i];
        if (str2 != null) {
          break;
        }
        i += 1;
      }
    }
  }
  
  public static String a(String paramString)
  {
    int j = 0;
    if (paramString == null) {
      return null;
    }
    Object localObject = paramString.getBytes();
    paramString = new byte[localObject.length];
    int i = 0;
    while (i < localObject.length)
    {
      paramString[i] = ((byte)((byte)((byte)(localObject[i] ^ 0xFFFFFFA2) ^ 0x68) ^ 0x1B));
      i += 1;
    }
    localObject = new StringBuilder(paramString.length * 2);
    i = j;
    while (i < paramString.length)
    {
      ((StringBuilder)localObject).append(Integer.toHexString((paramString[i] & 0xF0) >> 4));
      ((StringBuilder)localObject).append(Integer.toHexString(paramString[i] & 0xF));
      i += 1;
    }
    return ((StringBuilder)localObject).toString();
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {
      return;
    }
    SharedPreferences.Editor localEditor;
    for (;;)
    {
      try
      {
        localEditor = BaseApplication.getContext().getSharedPreferences("_recvfile_FLAG_", 4).edit();
        if (paramBoolean)
        {
          i = 1;
          localEditor.putInt(paramString, i);
          if (Build.VERSION.SDK_INT >= 9) {
            break;
          }
          localEditor.commit();
          return;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
      int i = 0;
    }
    localEditor.apply();
  }
  
  public static boolean a()
  {
    try
    {
      WifiManager localWifiManager = (WifiManager)BaseApplicationImpl.getContext().getSystemService("wifi");
      Method localMethod = localWifiManager.getClass().getMethod("isWifiApEnabled", new Class[0]);
      localMethod.setAccessible(true);
      boolean bool = ((Boolean)localMethod.invoke(localWifiManager, new Object[0])).booleanValue();
      return bool;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      localNoSuchMethodException.printStackTrace();
      return false;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public static boolean a(String paramString)
  {
    boolean bool = true;
    if (paramString == null) {
      return false;
    }
    try
    {
      int i = BaseApplication.getContext().getSharedPreferences("_recvfile_FLAG_", 4).getInt(paramString, 0);
      if (i == 1) {}
      for (;;)
      {
        return bool;
        bool = false;
      }
      return false;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static String b(String paramString)
  {
    int j = 0;
    if (paramString == null) {
      return null;
    }
    int k = paramString.length() / 2;
    byte[] arrayOfByte = new byte[k];
    int i = 0;
    while (i < k) {
      try
      {
        arrayOfByte[i] = Integer.valueOf(paramString.substring(i * 2, i * 2 + 2), 16).byteValue();
        i += 1;
      }
      catch (NumberFormatException paramString)
      {
        paramString.printStackTrace();
        return null;
      }
    }
    paramString = new byte[k];
    i = j;
    while (i < arrayOfByte.length)
    {
      paramString[i] = ((byte)((byte)((byte)(arrayOfByte[i] ^ 0x1B) ^ 0x68) ^ 0xFFFFFFA2));
      i += 1;
    }
    try
    {
      paramString = new String(paramString, "UTF-8");
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static String c(String paramString)
  {
    try
    {
      long l = Long.valueOf(paramString).longValue();
      return String.valueOf(l ^ 0x9A3702D1C2 ^ 0x6A5891625D ^ 0xB7CF267E29);
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public static String d(String paramString)
  {
    try
    {
      long l = Long.valueOf(paramString).longValue();
      return String.valueOf(l ^ 0xB7CF267E29 ^ 0x6A5891625D ^ 0x9A3702D1C2);
    }
    catch (Exception paramString) {}
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qlink\QlinkHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */