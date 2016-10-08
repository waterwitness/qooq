package com.tencent.mobileqq.ptt;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.transfile.ServerAddr;
import com.tencent.qphone.base.util.QLog;

public class PttIpSaver
  implements INetInfoHandler
{
  public static final int a = -1;
  public static final String a;
  public static final int b = 0;
  public static final int c = 1;
  public static final int d = 2;
  private boolean a;
  public String b;
  public String c;
  public String d;
  private String e;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = PttIpSaver.class.getSimpleName();
  }
  
  public PttIpSaver()
  {
    this.jdField_a_of_type_Boolean = true;
    AppNetConnInfo.registerConnectionChangeReceiver(BaseApplicationImpl.a(), this);
    a();
  }
  
  public static String a()
  {
    return "XGIdentifier";
  }
  
  public static String a(Context paramContext)
  {
    try
    {
      long l = System.nanoTime();
      paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
      if (paramContext != null)
      {
        paramContext = paramContext.getBSSID();
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "getWifiMac " + paramContext + " time=" + (System.nanoTime() - l) / 1000000L);
        }
        return paramContext;
      }
    }
    catch (Throwable paramContext) {}
    return null;
  }
  
  public String a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "getIp:" + paramInt);
    }
    if (paramInt == 0) {
      return this.b;
    }
    if (paramInt == 1) {
      return this.c;
    }
    if (paramInt == 2) {
      return this.d;
    }
    return null;
  }
  
  public void a()
  {
    try
    {
      this.e = a(BaseApplicationImpl.getContext());
      this.jdField_a_of_type_Boolean = true;
      if (this.e == null)
      {
        this.e = a();
        this.jdField_a_of_type_Boolean = false;
      }
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "onNetMobile2Wifi  " + this.e);
      }
      return;
    }
    finally {}
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "clear ip:" + paramInt);
    }
    if (paramInt == -1)
    {
      this.b = null;
      this.c = null;
      this.d = null;
    }
    do
    {
      return;
      if (paramInt == 0)
      {
        this.b = null;
        return;
      }
      if (paramInt == 1)
      {
        this.c = null;
        return;
      }
    } while (paramInt != 2);
    this.d = null;
  }
  
  public void a(ServerAddr paramServerAddr, int paramInt)
  {
    Object localObject = null;
    if (paramServerAddr != null)
    {
      localObject = new StringBuffer(200);
      ((StringBuffer)localObject).append("http://").append(paramServerAddr.jdField_a_of_type_JavaLangString);
      if (paramServerAddr.b != 80) {
        ((StringBuffer)localObject).append(":").append(paramServerAddr.b);
      }
      ((StringBuffer)localObject).append("/");
      localObject = ((StringBuffer)localObject).toString();
    }
    a((String)localObject, paramInt);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (paramString == null) {}
    do
    {
      return;
      String str = paramString;
      if (!paramString.startsWith("http://")) {
        str = "http://" + paramString;
      }
      paramString = str;
      if (!str.endsWith("/")) {
        paramString = str + "/";
      }
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "saveIp:" + paramInt + " " + paramString);
      }
      if (paramInt == 0)
      {
        this.b = paramString;
        return;
      }
      if (paramInt == 1)
      {
        this.c = paramString;
        return;
      }
    } while (paramInt != 2);
    this.d = paramString;
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = this.jdField_a_of_type_Boolean;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String b()
  {
    try
    {
      String str = this.e;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void b()
  {
    AppNetConnInfo.unregisterNetInfoHandler(this);
  }
  
  public void onNetMobile2None()
  {
    try
    {
      a(-1);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    try
    {
      this.e = a(BaseApplicationImpl.getContext());
      a(-1);
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "onNetMobile2Wifi  " + this.e);
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    try
    {
      this.e = a();
      this.jdField_a_of_type_Boolean = false;
      a(-1);
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "onNetNone2Mobile  " + this.e);
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    try
    {
      this.e = a(BaseApplicationImpl.getContext());
      this.jdField_a_of_type_Boolean = true;
      a(-1);
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "onNetNone2Wifi  " + this.e);
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    try
    {
      this.e = a();
      this.jdField_a_of_type_Boolean = false;
      a(-1);
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "onNetWifi2Mobile  " + this.e);
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void onNetWifi2None()
  {
    try
    {
      a(-1);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\ptt\PttIpSaver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */