package com.tencent.biz.common.util;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import tencent.im.troop_search_userinfo.userinfo.AppInfo;
import tencent.im.troop_search_userinfo.userinfo.GPS;
import tencent.im.troop_search_userinfo.userinfo.UserInfo;

public class Util
{
  public Util()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private static char a(int paramInt)
  {
    paramInt &= 0xF;
    if (paramInt < 10) {
      return (char)(paramInt + 48);
    }
    return (char)(paramInt - 10 + 97);
  }
  
  public static final String a(int paramInt)
  {
    String str = "";
    if (paramInt == 0) {
      str = "contact";
    }
    do
    {
      return str;
      if (paramInt == 1) {
        return "group";
      }
    } while (paramInt != 3000);
    return "discussions";
  }
  
  public static String a(InputStream paramInputStream)
  {
    try
    {
      BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream));
      String str;
      InputStream localInputStream;
      for (paramInputStream = "";; paramInputStream = paramInputStream + str)
      {
        str = localBufferedReader.readLine();
        localInputStream = paramInputStream;
        if (str == null) {
          break;
        }
      }
      return localInputStream;
    }
    catch (Exception paramInputStream)
    {
      paramInputStream.printStackTrace();
      localInputStream = null;
    }
  }
  
  public static String a(String paramString)
  {
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramString.getBytes());
      byte[] arrayOfByte = ((MessageDigest)localObject).digest();
      localObject = paramString;
      if (arrayOfByte != null)
      {
        localObject = new StringBuilder();
        int j = arrayOfByte.length;
        int i = 0;
        while (i < j)
        {
          int k = arrayOfByte[i];
          ((StringBuilder)localObject).append(a(k >>> 4));
          ((StringBuilder)localObject).append(a(k));
          i += 1;
        }
        localObject = ((StringBuilder)localObject).toString();
      }
      return (String)localObject;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      localNoSuchAlgorithmException.printStackTrace();
    }
    return paramString;
  }
  
  public static String a(String paramString, int paramInt)
  {
    str2 = "";
    Object localObject1 = str2;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject1 = str2;
      if (paramInt <= 0) {}
    }
    try
    {
      Object localObject2 = Uri.parse(paramString);
      localObject1 = str2;
      if (((Uri)localObject2).isHierarchical())
      {
        localObject2 = ((Uri)localObject2).getHost();
        localObject1 = str2;
        if (localObject2 != null)
        {
          localObject2 = ((String)localObject2).split("\\.");
          localObject1 = str2;
          if (localObject2.length > 0)
          {
            int i = Math.max(0, localObject2.length - (paramInt + 1));
            localObject1 = new StringBuilder(256);
            ((StringBuilder)localObject1).append(localObject2[i]);
            i += 1;
            while (i < localObject2.length)
            {
              ((StringBuilder)localObject1).append('.').append(localObject2[i]);
              i += 1;
            }
            localObject1 = ((StringBuilder)localObject1).toString();
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        String str1 = str2;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QLog", 2, "Get " + paramInt + " level domain= " + (String)localObject1 + " from " + paramString);
    }
    return (String)localObject1;
  }
  
  public static String a(String paramString, String... paramVarArgs)
  {
    String str;
    if (TextUtils.isEmpty(paramString))
    {
      str = paramString;
      return str;
    }
    paramString = paramString.replaceAll("(?<=\\?|#|&)((?i)sid|3g_sid|uin|sec_sig|MOBINFO|originuin)=[^&#]*&", "").replaceAll("[\\?#&]((?i)sid|3g_sid|uin|sec_sig|MOBINFO|originuin)=[^&#]*(?=#|$)", "").replaceAll("(?<=\\?|#|&)((?i)from)=androidqq&", "").replaceAll("[\\?#&]((?i)from)=androidqq(?=#|$)", "");
    int j = paramVarArgs.length;
    int i = 0;
    for (;;)
    {
      str = paramString;
      if (i >= j) {
        break;
      }
      paramString = paramString.replace(paramVarArgs[i], "");
      i += 1;
    }
  }
  
  public static userinfo.UserInfo a(SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    userinfo.UserInfo localUserInfo = new userinfo.UserInfo();
    if (paramSosoLbsInfo != null)
    {
      userinfo.GPS localGPS = new userinfo.GPS();
      localGPS.uint32_lat.set(Double.valueOf(paramSosoLbsInfo.a.a * 1000000.0D).intValue());
      localGPS.uint32_lon.set(Double.valueOf(paramSosoLbsInfo.a.b * 1000000.0D).intValue());
      localUserInfo.gps.set(localGPS);
    }
    paramSosoLbsInfo = new userinfo.AppInfo();
    paramSosoLbsInfo.plat_type.set(2);
    paramSosoLbsInfo.str_app_version.set(DeviceInfoUtil.c());
    localUserInfo.app_info.set(paramSosoLbsInfo);
    return localUserInfo;
  }
  
  public static void a(Context paramContext, int paramInt, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_error_code", paramInt);
    localIntent.putExtra("key_error_msg", paramString1);
    localIntent.putExtra("key_error_detail", paramString2);
    localIntent.putExtra("key_response", "");
    ((Activity)paramContext).setResult(-1, localIntent);
  }
  
  public static final void a(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.addCategory("android.intent.category.BROWSABLE");
    localIntent.setData(Uri.parse(paramString));
    try
    {
      paramContext.startActivity(localIntent);
      return;
    }
    catch (ActivityNotFoundException paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("QLog", 2, paramContext.getMessage());
    }
  }
  
  public static final void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, long paramLong1, long paramLong2, String paramString3)
  {
    a(paramQQAppInterface, paramString1, "connect_share2qq", paramString2, paramLong1, paramLong2, paramString3);
  }
  
  public static final void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, String paramString4)
  {
    if (paramString4 == null) {
      paramString4 = "";
    }
    for (;;)
    {
      if (paramString1 == null) {
        paramString1 = "";
      }
      for (;;)
      {
        String str1 = "";
        if (paramLong2 > 0L) {
          str1 = String.valueOf(paramLong2);
        }
        String str2 = "";
        if (paramLong1 > 0L) {
          str2 = String.valueOf(paramLong1);
        }
        ReportController.b(paramQQAppInterface, "P_CliOper", "qqconnect", paramString1, paramString2, paramString3, 0, 0, str2, str1, paramString4, "");
        return;
      }
    }
  }
  
  public static void a(String paramString)
  {
    if (paramString != null) {}
  }
  
  public static boolean a()
  {
    File localFile = null;
    if (Environment.getExternalStorageState().equals("mounted")) {
      localFile = Environment.getExternalStorageDirectory();
    }
    return localFile != null;
  }
  
  public static boolean a(String paramString)
  {
    int i = 0;
    if (TextUtils.isEmpty(paramString)) {}
    Object localObject;
    do
    {
      do
      {
        return false;
        localObject = paramString;
        if (!paramString.endsWith(File.separator)) {
          localObject = paramString + File.separator;
        }
        paramString = new File((String)localObject);
      } while ((paramString == null) || (!paramString.exists()) || (!paramString.isDirectory()));
      localObject = paramString.listFiles();
    } while (localObject == null);
    if (i < localObject.length)
    {
      if (localObject[i] == null) {}
      for (;;)
      {
        i += 1;
        break;
        if (localObject[i].isFile()) {
          b(localObject[i].getAbsolutePath());
        } else {
          a(localObject[i].getAbsolutePath());
        }
      }
    }
    paramString.delete();
    return true;
  }
  
  public static String b(String paramString)
  {
    if (paramString == null) {
      return "null";
    }
    StringBuilder localStringBuilder = new StringBuilder(1024);
    localStringBuilder.append("\"");
    int j = paramString.length();
    int i = 0;
    if (i < j)
    {
      char c = paramString.charAt(i);
      switch (c)
      {
      default: 
        if (c <= '\037') {
          localStringBuilder.append(String.format("\\u%04x", new Object[] { Integer.valueOf(c) }));
        }
        break;
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append('\\').append(c);
        continue;
        localStringBuilder.append("\\t");
        continue;
        localStringBuilder.append("\\b");
        continue;
        localStringBuilder.append("\\n");
        continue;
        localStringBuilder.append("\\r");
        continue;
        localStringBuilder.append("\\f");
        continue;
        localStringBuilder.append(c);
      }
    }
    localStringBuilder.append("\"");
    return localStringBuilder.toString();
  }
  
  public static String b(String paramString, String... paramVarArgs)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    return paramString.replaceAll("((?i)sid|uin|sec_sig|MOBINFO)=[^&#]+", "$1=****");
  }
  
  public static void b(String paramString)
  {
    if (paramString != null) {}
  }
  
  public static boolean b(String paramString)
  {
    boolean bool2 = false;
    paramString = new File(paramString);
    boolean bool1 = bool2;
    if (paramString.isFile())
    {
      bool1 = bool2;
      if (!paramString.exists()) {}
    }
    try
    {
      paramString.delete();
      bool1 = true;
      return bool1;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  public static String c(String paramString)
  {
    return a(paramString, 1);
  }
  
  public static String c(String paramString, String... paramVarArgs)
  {
    Object localObject = paramString;
    if (!TextUtils.isEmpty(paramString)) {
      if ((paramVarArgs != null) && (paramVarArgs.length != 0)) {
        break label36;
      }
    }
    for (paramVarArgs = "(?<=(a1|a2|key|token|uin|sid|sig|stwxweb)=\\S)[^; ]+(?=[^;$])";; paramVarArgs = String.format("(?<=(a1|a2|key|token|uin|sid|sig|stwxweb%s)=\\S)[^; ]+(?=[^;$])", new Object[] { ((StringBuilder)localObject).toString() }))
    {
      localObject = paramString.toLowerCase().replaceAll(paramVarArgs, "*");
      return (String)localObject;
      label36:
      localObject = new StringBuilder("");
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        String str = paramVarArgs[i];
        if (!TextUtils.isEmpty(str)) {
          ((StringBuilder)localObject).append("|").append(str);
        }
        i += 1;
      }
    }
  }
  
  public static String d(String paramString)
  {
    paramString = paramString.toCharArray();
    int i = 0;
    if (i < paramString.length)
    {
      if (paramString[i] == '　') {
        paramString[i] = 32;
      }
      for (;;)
      {
        i += 1;
        break;
        if ((paramString[i] > 65280) && (paramString[i] < 65375)) {
          paramString[i] = ((char)(paramString[i] - 65248));
        }
      }
    }
    return new String(paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\common\util\Util.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */