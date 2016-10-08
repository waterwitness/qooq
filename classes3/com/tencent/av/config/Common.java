package com.tencent.av.config;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.concurrent.ConcurrentHashMap;

public class Common
{
  public static final int a = 201;
  public static final String a = "V2.9.0304.001";
  public static final ConcurrentHashMap a = new ConcurrentHashMap();
  public static final String b = "6.0.0";
  public static final String c = "VideoConfigInfo";
  public static final String d = "ConfigInfo";
  public static final String e = "SharpConfigPayload";
  public static final String f = "0";
  public static final String g = "1";
  public static final String h = "2";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    if (paramInt2 < 0)
    {
      j = 0;
      return j;
    }
    int j = 1;
    int i = paramInt2;
    paramInt2 = j;
    for (;;)
    {
      j = paramInt2;
      if (i <= 0) {
        break;
      }
      paramInt2 *= paramInt1;
      i -= 1;
    }
  }
  
  public static String a(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return "6.0.0";
      try
      {
        paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
        if ((paramContext != null) && (!TextUtils.isEmpty(paramContext.versionName.trim())))
        {
          paramContext = paramContext.versionName.trim();
          return paramContext;
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    return "6.0.0";
  }
  
  public static void a(Context paramContext, String paramString)
  {
    try
    {
      a.remove(paramString);
      paramContext.deleteFile(paramString);
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static void a(Context paramContext, String paramString, byte[] paramArrayOfByte)
  {
    try
    {
      a.put(paramString, paramArrayOfByte);
      paramContext = paramContext.openFileOutput(paramString, 0);
      paramContext.write(paramArrayOfByte);
      paramContext.close();
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static byte[] a(Context paramContext, String paramString)
  {
    byte[] arrayOfByte = (byte[])a.get(paramString);
    Object localObject2 = arrayOfByte;
    if (arrayOfByte == null)
    {
      Object localObject1 = arrayOfByte;
      try
      {
        localObject2 = paramContext.openFileInput(paramString);
        localObject1 = arrayOfByte;
        int i = ((FileInputStream)localObject2).available();
        if (i <= 0)
        {
          localObject1 = arrayOfByte;
          ((FileInputStream)localObject2).close();
          return null;
        }
        localObject1 = arrayOfByte;
        paramContext = new byte[i];
        localObject1 = paramContext;
        ((FileInputStream)localObject2).read(paramContext);
        localObject1 = paramContext;
        ((FileInputStream)localObject2).close();
        localObject1 = paramContext;
        a.put(paramString, paramContext);
        return paramContext;
      }
      catch (Exception paramContext)
      {
        localObject2 = localObject1;
        if (QLog.isColorLevel())
        {
          QLog.e("config", 2, "read file fail: " + paramString);
          localObject2 = localObject1;
        }
      }
    }
    return (byte[])localObject2;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\config\Common.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */