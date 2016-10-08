package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.StringUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class SecurityUtile
{
  private static int jdField_a_of_type_Int = 4;
  private static final String jdField_a_of_type_JavaLangString = "kc";
  private static byte[] jdField_a_of_type_ArrayOfByte;
  private static volatile char[] jdField_a_of_type_ArrayOfChar;
  private static volatile int b;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ArrayOfChar = new char[] { 0, 1, 0, 1 };
    jdField_a_of_type_ArrayOfByte = new byte[] { 0, 1, 0, 1 };
  }
  
  private static String a(Context paramContext)
  {
    paramContext = paramContext.openFileInput("kc");
    byte[] arrayOfByte = new byte[paramContext.available()];
    paramContext.read(arrayOfByte);
    paramContext.close();
    return new String(arrayOfByte, "UTF-8");
  }
  
  public static String a(String paramString)
  {
    return a(paramString, false);
  }
  
  public static String a(String paramString, boolean paramBoolean)
  {
    return b(paramString, paramBoolean);
  }
  
  public static void a(Context paramContext)
  {
    localObject1 = null;
    for (;;)
    {
      try
      {
        boolean bool = a(paramContext);
        if (!bool) {}
      }
      finally {}
      try
      {
        localObject2 = a(paramContext);
        if (localObject2 != null) {
          localObject1 = localObject2;
        }
      }
      catch (Exception localException1)
      {
        continue;
      }
      try
      {
        if (((String)localObject2).length() < jdField_a_of_type_ArrayOfChar.length)
        {
          Thread.sleep(200L);
          localObject1 = a(paramContext);
        }
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (((String)localObject1).length() >= jdField_a_of_type_ArrayOfChar.length) {}
        }
        else
        {
          localObject1 = paramContext.getSharedPreferences("mobileQQ", 0).getString("security_key", null);
          if (localObject1 != null)
          {
            int i = ((String)localObject1).length();
            int j = jdField_a_of_type_ArrayOfChar.length;
            if (i >= j) {
              break label296;
            }
          }
        }
      }
      catch (Exception localException3)
      {
        localObject1 = localObject2;
        localObject2 = localException3;
        continue;
        continue;
        continue;
      }
      try
      {
        localObject2 = ((TelephonyManager)paramContext.getApplicationContext().getSystemService("phone")).getDeviceId();
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (((String)localObject2).length() >= jdField_a_of_type_ArrayOfChar.length) {
            break label293;
          }
        }
        localObject1 = localObject2;
        localObject2 = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getMacAddress();
      }
      catch (Exception localException2)
      {
        Object localObject3 = localObject1;
        continue;
      }
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((String)localObject2).length() >= jdField_a_of_type_ArrayOfChar.length) {}
      }
      else
      {
        localObject1 = "361910168";
      }
      try
      {
        a(paramContext, (String)localObject1);
        localObject2 = localObject1;
      }
      catch (IOException paramContext)
      {
        QLog.e("KEY", 1, "write key Exception " + paramContext.getMessage());
        localObject2 = localObject1;
        continue;
      }
      jdField_a_of_type_ArrayOfChar = ((String)localObject2).toCharArray();
      b = jdField_a_of_type_ArrayOfChar.length;
      return;
      QLog.e("KEY", 1, "read key Exception " + ((Exception)localObject2).getMessage());
      continue;
      QLog.e("KEY", 1, "isKeyFileExists = false");
      localObject1 = null;
    }
  }
  
  private static void a(Context paramContext, String paramString)
  {
    paramContext = paramContext.openFileOutput("kc", 0);
    paramContext.write(paramString.getBytes("UTF-8"));
    paramContext.close();
  }
  
  public static void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    if ((paramArrayOfByte == null) || (paramLong >= paramInt3)) {
      return;
    }
    paramInt3 = (int)(paramInt3 - paramLong);
    if (paramInt3 > paramInt2) {}
    for (;;)
    {
      paramInt3 = 0;
      while (paramInt3 < paramInt2)
      {
        paramArrayOfByte[(paramInt3 + paramInt1)] = ((byte)(paramArrayOfByte[(paramInt3 + paramInt1)] ^ jdField_a_of_type_ArrayOfByte[((int)((paramInt3 + paramLong) % jdField_a_of_type_Int))]));
        paramInt3 += 1;
      }
      break;
      paramInt2 = paramInt3;
    }
  }
  
  private static boolean a(Context paramContext)
  {
    return (paramContext.getFileStreamPath("kc") != null) && (paramContext.getFileStreamPath("kc").exists());
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramArrayOfByte != null)
    {
      if ((b == 0) || (jdField_a_of_type_ArrayOfChar.length == 4)) {
        a(BaseApplicationImpl.getContext());
      }
      int j = paramArrayOfByte.length;
      arrayOfByte = new byte[j];
      int i = 0;
      while (i < j)
      {
        arrayOfByte[i] = ((byte)(paramArrayOfByte[i] ^ jdField_a_of_type_ArrayOfChar[(i % b)]));
        i += 1;
      }
    }
    return arrayOfByte;
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte != null)
    {
      int i = 0;
      while (i < paramInt)
      {
        paramArrayOfByte[i] = ((byte)(paramArrayOfByte[i] ^ jdField_a_of_type_ArrayOfByte[(i % jdField_a_of_type_Int)]));
        i += 1;
      }
    }
    return paramArrayOfByte;
  }
  
  public static String b(String paramString)
  {
    return b(paramString, false);
  }
  
  private static String b(String paramString, boolean paramBoolean)
  {
    Object localObject1 = null;
    if (paramString == null)
    {
      localObject1 = null;
      return (String)localObject1;
    }
    for (;;)
    {
      int i;
      try
      {
        if ((b == 0) || (jdField_a_of_type_ArrayOfChar.length == 4)) {
          a(BaseApplicationImpl.getContext());
        }
        if (paramBoolean) {
          localObject1 = StringUtils.reflactCharArray(paramString);
        }
        localObject2 = localObject1;
        if (localObject1 != null) {
          break label166;
        }
        localObject2 = new char[paramString.length()];
        paramBoolean = false;
      }
      catch (Exception localException)
      {
        Object localObject2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("XOR", 2, String.format("xor except, str: %s, codeKey: %s, codeKeyLen:%d", new Object[] { paramString, String.valueOf(jdField_a_of_type_ArrayOfChar), Integer.valueOf(b) }), localException);
        return "";
      }
      if (i < paramString.length())
      {
        localObject2[i] = ((char)(paramString.charAt(i) ^ jdField_a_of_type_ArrayOfChar[(i % b)]));
        i += 1;
      }
      else
      {
        if (localObject2.length == 0) {
          return "";
        }
        localObject1 = paramString;
        if (paramBoolean) {
          break;
        }
        localObject1 = StringUtils.newStringWithData((char[])localObject2);
        return (String)localObject1;
        label166:
        i = 0;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\utils\SecurityUtile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */