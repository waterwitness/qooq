package com.tencent.biz.common.util;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.QLog;
import hhp;
import hhq;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class OfflineSecurity
{
  private static final int jdField_a_of_type_Int = 1;
  public static Handler a;
  public static OfflineSecurity.VerifyListener a;
  protected static String a;
  private static char[] jdField_a_of_type_ArrayOfChar = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  private static final int jdField_b_of_type_Int = 2;
  private static String jdField_b_of_type_JavaLangString;
  private static final int jdField_c_of_type_Int = 3;
  private static final String jdField_c_of_type_JavaLangString = "offlneSecurity";
  private static final int d = 4;
  private static final int e = 5;
  private static final int f = 6;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    b = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCrREOFRN9uYS869mOeLmZXFw3djnofd7wbf3ru6zmRB7P6gTpmnvJNnclCcEC7TOmDImvVl+gVPXQ0AmWAI4q042rALV5NPCJiOpIzSgJH2l0F/ZVbj69QztBiKmSHVHqQ8yemqtFljNEJbE9HL3RXE/uwGmHViFl4fGg9am5w7QIDAQAB";
  }
  
  public static String a(BufferedInputStream paramBufferedInputStream)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    byte[] arrayOfByte = new byte['က'];
    for (;;)
    {
      int i = paramBufferedInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      localStringBuffer.append(new String(arrayOfByte, 0, i));
    }
    return localStringBuffer.toString();
  }
  
  public static String a(String paramString)
  {
    try
    {
      paramString = a(paramString, "SHA1");
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  private static String a(String paramString1, String paramString2)
  {
    paramString1 = new BufferedInputStream(new FileInputStream(paramString1));
    byte[] arrayOfByte = new byte['က'];
    paramString2 = MessageDigest.getInstance(paramString2);
    for (;;)
    {
      int i = paramString1.read(arrayOfByte);
      if (i <= 0) {
        break;
      }
      paramString2.update(arrayOfByte, 0, i);
    }
    paramString1.close();
    return a(paramString2.digest());
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      localStringBuilder.append(jdField_a_of_type_ArrayOfChar[((paramArrayOfByte[i] & 0xF0) >>> 4)]);
      localStringBuilder.append(jdField_a_of_type_ArrayOfChar[(paramArrayOfByte[i] & 0xF)]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private static void a(int paramInt)
  {
    int i = 0;
    try
    {
      int j = Integer.valueOf(jdField_a_of_type_JavaLangString).intValue();
      i = j;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;) {}
    }
    ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_sys_14", "lixian_security", i, paramInt, "", "3", "", "");
    if (QLog.isColorLevel()) {
      QLog.d("offlneSecurity", 2, "report:" + paramInt);
    }
  }
  
  private static void a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "0";
    }
    jdField_a_of_type_JavaLangString = str;
  }
  
  public static void a(String paramString1, OfflineSecurity.VerifyListener paramVerifyListener, String paramString2)
  {
    a(paramString2);
    jdField_a_of_type_ComTencentBizCommonUtilOfflineSecurity$VerifyListener = paramVerifyListener;
    jdField_a_of_type_AndroidOsHandler = new hhp();
    new Thread(new hhq(paramString1, paramString2)).start();
  }
  
  private static boolean a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("offlneSecurity", 2, "-->offline:verifySecurity");
    }
    try
    {
      localObject1 = new File(paramString + "/verify.json");
      if (!((File)localObject1).exists())
      {
        if (QLog.isColorLevel())
        {
          QLog.i("offlneSecurity", 2, "-->offline:verifySecurity,verify.json not exist!");
          return false;
        }
      }
      else
      {
        localObject2 = new BufferedInputStream(new FileInputStream((File)localObject1));
        localObject1 = a((BufferedInputStream)localObject2);
        ((BufferedInputStream)localObject2).close();
        paramString = new File(paramString + "/verify.signature");
        if (!paramString.exists())
        {
          if (!QLog.isColorLevel()) {
            break label223;
          }
          QLog.i("offlneSecurity", 2, "-->offline:verifySecurity,verify.signature not exist!");
          return false;
        }
      }
    }
    catch (FileNotFoundException paramString)
    {
      Object localObject1;
      if (QLog.isColorLevel()) {
        QLog.i("offlneSecurity", 2, "-->offline:verifySecurity,file not found error!");
      }
      a(1);
      paramString.printStackTrace();
      return false;
      paramString = new BufferedInputStream(new FileInputStream(paramString));
      Object localObject2 = a(paramString);
      paramString.close();
      boolean bool = a(b, (byte[])localObject1, (byte[])localObject2);
      return bool;
    }
    catch (IOException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.i("offlneSecurity", 2, "-->offline:verifySecurity,io error!");
      }
      a(2);
      paramString.printStackTrace();
    }
    label223:
    return false;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("offlneSecurity", 2, "-->offline:verify");
    }
    a(paramString2);
    if (a(paramString1)) {
      return b(paramString1);
    }
    HtmlOffline.b(paramString1 + "/verify.json", paramString2);
    return false;
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3)
  {
    a(paramString3);
    if (a(paramString1)) {
      return c(paramString1, paramString2);
    }
    return false;
  }
  
  private static boolean a(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("offlneSecurity", 2, "-->offline:verify");
      }
      paramString = Base64Util.decode(paramString.getBytes("UTF-8"), 0);
      KeyFactory localKeyFactory = KeyFactory.getInstance("RSA");
      Signature localSignature = Signature.getInstance("SHA1withRSA");
      localSignature.initVerify(localKeyFactory.generatePublic(new X509EncodedKeySpec(paramString)));
      localSignature.update(paramArrayOfByte1);
      boolean bool = localSignature.verify(paramArrayOfByte2);
      return bool;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.i("offlneSecurity", 2, "-->offline:verify error:" + paramString.toString());
      }
      paramString.printStackTrace();
      a(4);
    }
    return false;
  }
  
  public static byte[] a(BufferedInputStream paramBufferedInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte['က'];
    for (;;)
    {
      int i = paramBufferedInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    paramBufferedInputStream = localByteArrayOutputStream.toByteArray();
    localByteArrayOutputStream.close();
    return paramBufferedInputStream;
  }
  
  private static boolean b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("offlneSecurity", 2, "-->offline:verifySHA1:");
    }
    for (;;)
    {
      try
      {
        localObject = new BufferedInputStream(new FileInputStream(paramString + "/verify.json"));
        localJSONObject = new JSONObject(a((BufferedInputStream)localObject));
        ((BufferedInputStream)localObject).close();
        localObject = localJSONObject.keys();
      }
      catch (FileNotFoundException paramString)
      {
        try
        {
          Object localObject;
          JSONObject localJSONObject;
          if (localJSONObject.getString(str).equals(a(paramString + File.separator + str))) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.i("offlneSecurity", 2, "-->offline:verifySHA1,check md5 fail:" + str);
          }
          a(6);
          HtmlOffline.b(paramString + File.separator + str, jdField_a_of_type_JavaLangString);
          return false;
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
          a(5);
        }
        paramString = paramString;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("offlneSecurity", 2, "-->offline:verifySHA1 error:file not foud!");
        a(1);
        paramString.printStackTrace();
        return false;
      }
      catch (JSONException paramString)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("offlneSecurity", 2, "-->offline:verifySHA1 error:json error!");
        a(3);
        paramString.printStackTrace();
        return false;
      }
      catch (IOException paramString)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("offlneSecurity", 2, "-->offline:verifySHA1 error:io error!");
        a(2);
        paramString.printStackTrace();
        return false;
      }
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      String str = ((Iterator)localObject).next().toString();
      if (QLog.isColorLevel()) {
        QLog.i("offlneSecurity", 2, "-->offline:verifySHA1,JSONException:" + str);
      }
    }
    return true;
  }
  
  public static boolean b(String paramString1, String paramString2)
  {
    a(paramString2);
    return a(paramString1);
  }
  
  public static boolean b(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("OfflineSecurity", 2, "-->offline:verifyIndex");
    }
    a(paramString3);
    if (a(paramString2)) {
      return c(paramString1, paramString2, paramString3);
    }
    HtmlOffline.b(paramString2 + "/verify.json", paramString3);
    return false;
  }
  
  /* Error */
  private static boolean c(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 167	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +39 -> 42
    //   6: ldc 17
    //   8: iconst_2
    //   9: new 125	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 372
    //   19: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_0
    //   23: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: ldc_w 374
    //   29: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_1
    //   33: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 214	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: aload_0
    //   43: invokestatic 380	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   46: ifne +10 -> 56
    //   49: aload_1
    //   50: invokestatic 380	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   53: ifeq +5 -> 58
    //   56: iconst_0
    //   57: ireturn
    //   58: new 216	java/io/File
    //   61: dup
    //   62: new 125	java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   69: aload_0
    //   70: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: getstatic 347	java/io/File:separator	Ljava/lang/String;
    //   76: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload_1
    //   80: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: invokespecial 219	java/io/File:<init>	(Ljava/lang/String;)V
    //   89: invokevirtual 222	java/io/File:exists	()Z
    //   92: ifeq -36 -> 56
    //   95: new 63	java/io/BufferedInputStream
    //   98: dup
    //   99: new 95	java/io/FileInputStream
    //   102: dup
    //   103: new 125	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   110: aload_0
    //   111: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: getstatic 347	java/io/File:separator	Ljava/lang/String;
    //   117: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: ldc_w 382
    //   123: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: invokespecial 98	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   132: invokespecial 101	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   135: astore_3
    //   136: new 324	org/json/JSONObject
    //   139: dup
    //   140: aload_3
    //   141: invokestatic 326	com/tencent/biz/common/util/OfflineSecurity:a	(Ljava/io/BufferedInputStream;)Ljava/lang/String;
    //   144: invokespecial 327	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   147: astore_2
    //   148: aload_3
    //   149: invokevirtual 231	java/io/BufferedInputStream:close	()V
    //   152: aload_2
    //   153: ldc_w 384
    //   156: invokevirtual 388	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   159: astore 4
    //   161: aload_2
    //   162: ldc_w 390
    //   165: invokevirtual 388	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   168: astore 5
    //   170: new 392	java/util/HashMap
    //   173: dup
    //   174: invokespecial 393	java/util/HashMap:<init>	()V
    //   177: astore_3
    //   178: aload 4
    //   180: ifnull +140 -> 320
    //   183: aload 4
    //   185: invokevirtual 331	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   188: astore 6
    //   190: aload 6
    //   192: invokeinterface 336 1 0
    //   197: ifeq +123 -> 320
    //   200: aload 6
    //   202: invokeinterface 340 1 0
    //   207: invokevirtual 341	java/lang/Object:toString	()Ljava/lang/String;
    //   210: astore 7
    //   212: aload 4
    //   214: aload 7
    //   216: invokevirtual 344	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   219: astore_2
    //   220: aload_2
    //   221: invokestatic 380	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   224: ifne -34 -> 190
    //   227: aload_3
    //   228: aload 7
    //   230: aload_2
    //   231: invokeinterface 399 3 0
    //   236: pop
    //   237: goto -47 -> 190
    //   240: astore_0
    //   241: iconst_1
    //   242: invokestatic 239	com/tencent/biz/common/util/OfflineSecurity:a	(I)V
    //   245: aload_0
    //   246: invokevirtual 240	java/io/FileNotFoundException:printStackTrace	()V
    //   249: iconst_0
    //   250: ireturn
    //   251: astore_0
    //   252: iconst_3
    //   253: invokestatic 239	com/tencent/biz/common/util/OfflineSecurity:a	(I)V
    //   256: aload_0
    //   257: invokevirtual 360	org/json/JSONException:printStackTrace	()V
    //   260: iconst_0
    //   261: ireturn
    //   262: astore_0
    //   263: iconst_2
    //   264: invokestatic 239	com/tencent/biz/common/util/OfflineSecurity:a	(I)V
    //   267: aload_0
    //   268: invokevirtual 246	java/io/IOException:printStackTrace	()V
    //   271: iconst_0
    //   272: ireturn
    //   273: astore_2
    //   274: aload_2
    //   275: invokevirtual 360	org/json/JSONException:printStackTrace	()V
    //   278: iconst_5
    //   279: invokestatic 239	com/tencent/biz/common/util/OfflineSecurity:a	(I)V
    //   282: invokestatic 167	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   285: ifeq +30 -> 315
    //   288: ldc 17
    //   290: iconst_2
    //   291: new 125	java/lang/StringBuilder
    //   294: dup
    //   295: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   298: ldc_w 401
    //   301: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: aload 7
    //   306: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   312: invokestatic 214	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   315: aconst_null
    //   316: astore_2
    //   317: goto -97 -> 220
    //   320: aload 5
    //   322: ifnull +544 -> 866
    //   325: aload 5
    //   327: invokevirtual 331	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   330: astore_2
    //   331: aload_2
    //   332: invokeinterface 336 1 0
    //   337: ifeq +529 -> 866
    //   340: aload_2
    //   341: invokeinterface 340 1 0
    //   346: invokevirtual 341	java/lang/Object:toString	()Ljava/lang/String;
    //   349: astore 4
    //   351: aload 4
    //   353: ifnull -22 -> 331
    //   356: aload_1
    //   357: aload 4
    //   359: invokevirtual 353	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   362: ifeq -31 -> 331
    //   365: aload_3
    //   366: aload_1
    //   367: invokeinterface 405 2 0
    //   372: checkcast 69	java/lang/String
    //   375: astore_2
    //   376: new 125	java/lang/StringBuilder
    //   379: dup
    //   380: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   383: aload_0
    //   384: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: getstatic 347	java/io/File:separator	Ljava/lang/String;
    //   390: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: aload_1
    //   394: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   400: invokestatic 349	com/tencent/biz/common/util/OfflineSecurity:a	(Ljava/lang/String;)Ljava/lang/String;
    //   403: astore_1
    //   404: aload_2
    //   405: invokestatic 380	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   408: ifne +11 -> 419
    //   411: aload_2
    //   412: aload_1
    //   413: invokevirtual 353	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   416: ifne +58 -> 474
    //   419: invokestatic 167	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   422: ifeq -366 -> 56
    //   425: ldc 17
    //   427: iconst_2
    //   428: new 125	java/lang/StringBuilder
    //   431: dup
    //   432: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   435: ldc_w 407
    //   438: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: aload 4
    //   443: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: ldc_w 409
    //   449: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: aload_2
    //   453: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: ldc_w 411
    //   459: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: aload_1
    //   463: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   469: invokestatic 214	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   472: iconst_0
    //   473: ireturn
    //   474: invokestatic 167	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   477: ifeq +36 -> 513
    //   480: ldc 17
    //   482: iconst_2
    //   483: new 125	java/lang/StringBuilder
    //   486: dup
    //   487: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   490: ldc_w 413
    //   493: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: aload 4
    //   498: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: ldc_w 415
    //   504: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   507: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   510: invokestatic 214	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   513: aload 5
    //   515: aload 4
    //   517: invokevirtual 419	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   520: astore_2
    //   521: aload_2
    //   522: ifnull +344 -> 866
    //   525: invokestatic 167	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   528: ifeq +43 -> 571
    //   531: ldc 17
    //   533: iconst_2
    //   534: new 125	java/lang/StringBuilder
    //   537: dup
    //   538: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   541: ldc_w 413
    //   544: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   547: aload 4
    //   549: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: ldc_w 421
    //   555: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   558: aload_2
    //   559: invokevirtual 424	org/json/JSONArray:toString	()Ljava/lang/String;
    //   562: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   565: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   568: invokestatic 214	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   571: iconst_0
    //   572: istore 8
    //   574: iload 8
    //   576: aload_2
    //   577: invokevirtual 427	org/json/JSONArray:length	()I
    //   580: if_icmpge +286 -> 866
    //   583: aload_2
    //   584: iload 8
    //   586: invokevirtual 430	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   589: astore_1
    //   590: aload_1
    //   591: invokestatic 380	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   594: ifne +205 -> 799
    //   597: aload_3
    //   598: aload_1
    //   599: invokeinterface 405 2 0
    //   604: checkcast 69	java/lang/String
    //   607: astore 5
    //   609: new 125	java/lang/StringBuilder
    //   612: dup
    //   613: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   616: aload_0
    //   617: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   620: getstatic 347	java/io/File:separator	Ljava/lang/String;
    //   623: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   626: aload_1
    //   627: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   630: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   633: invokestatic 349	com/tencent/biz/common/util/OfflineSecurity:a	(Ljava/lang/String;)Ljava/lang/String;
    //   636: astore 6
    //   638: aload 5
    //   640: invokestatic 380	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   643: ifne +13 -> 656
    //   646: aload 5
    //   648: aload 6
    //   650: invokevirtual 353	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   653: ifne +146 -> 799
    //   656: invokestatic 167	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   659: ifeq -603 -> 56
    //   662: ldc 17
    //   664: iconst_2
    //   665: new 125	java/lang/StringBuilder
    //   668: dup
    //   669: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   672: ldc_w 432
    //   675: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   678: aload 4
    //   680: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   683: ldc_w 434
    //   686: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   689: aload_1
    //   690: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   693: ldc_w 436
    //   696: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   699: aload 5
    //   701: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   704: ldc_w 438
    //   707: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   710: aload 6
    //   712: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   715: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   718: invokestatic 214	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   721: iconst_0
    //   722: ireturn
    //   723: astore_1
    //   724: aload_1
    //   725: invokevirtual 360	org/json/JSONException:printStackTrace	()V
    //   728: iconst_5
    //   729: invokestatic 239	com/tencent/biz/common/util/OfflineSecurity:a	(I)V
    //   732: invokestatic 167	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   735: ifeq +30 -> 765
    //   738: ldc 17
    //   740: iconst_2
    //   741: new 125	java/lang/StringBuilder
    //   744: dup
    //   745: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   748: ldc_w 401
    //   751: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   754: aload 4
    //   756: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   759: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   762: invokestatic 214	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   765: aconst_null
    //   766: astore_2
    //   767: goto -246 -> 521
    //   770: astore_1
    //   771: aload_1
    //   772: invokevirtual 360	org/json/JSONException:printStackTrace	()V
    //   775: iconst_5
    //   776: invokestatic 239	com/tencent/biz/common/util/OfflineSecurity:a	(I)V
    //   779: invokestatic 167	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   782: ifeq +12 -> 794
    //   785: ldc 17
    //   787: iconst_2
    //   788: ldc_w 440
    //   791: invokestatic 214	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   794: aconst_null
    //   795: astore_1
    //   796: goto -206 -> 590
    //   799: invokestatic 167	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   802: ifeq +48 -> 850
    //   805: new 125	java/lang/StringBuilder
    //   808: dup
    //   809: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   812: ldc_w 442
    //   815: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   818: aload 4
    //   820: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   823: ldc_w 444
    //   826: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   829: astore 5
    //   831: aload_1
    //   832: ifnull +27 -> 859
    //   835: ldc 17
    //   837: iconst_2
    //   838: aload 5
    //   840: aload_1
    //   841: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   844: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   847: invokestatic 214	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   850: iload 8
    //   852: iconst_1
    //   853: iadd
    //   854: istore 8
    //   856: goto -282 -> 574
    //   859: ldc_w 446
    //   862: astore_1
    //   863: goto -28 -> 835
    //   866: iconst_1
    //   867: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	868	0	paramString1	String
    //   0	868	1	paramString2	String
    //   147	84	2	localObject1	Object
    //   273	2	2	localJSONException	JSONException
    //   316	451	2	localObject2	Object
    //   135	463	3	localObject3	Object
    //   159	660	4	localObject4	Object
    //   168	671	5	localObject5	Object
    //   188	523	6	localObject6	Object
    //   210	95	7	str	String
    //   572	283	8	i	int
    // Exception table:
    //   from	to	target	type
    //   95	170	240	java/io/FileNotFoundException
    //   95	170	251	org/json/JSONException
    //   95	170	262	java/io/IOException
    //   212	220	273	org/json/JSONException
    //   513	521	723	org/json/JSONException
    //   583	590	770	org/json/JSONException
  }
  
  public static boolean c(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("OfflineSecurity", 2, "-->offline:verifyFile");
    }
    a(paramString3);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {
      return false;
    }
    try
    {
      Object localObject;
      if ((HtmlOffline.a != null) && (HtmlOffline.a.containsKey(paramString3))) {
        localObject = (String)HtmlOffline.a.get(paramString3);
      }
      for (;;)
      {
        localObject = new JSONObject((String)localObject);
        localObject = ((JSONObject)localObject).optString(paramString1);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.i("offlneSecurity", 2, "-->offline:verifyFile,not in verify list!");
        }
        return true;
        BufferedInputStream localBufferedInputStream = new BufferedInputStream(new FileInputStream(paramString2 + "/verify.json"));
        localObject = a(localBufferedInputStream);
        localBufferedInputStream.close();
        HtmlOffline.a.put(paramString3, localObject);
      }
      if (((String)localObject).equals(a(paramString2 + File.separator + paramString1))) {
        break label349;
      }
    }
    catch (FileNotFoundException paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("OfflineSecurity", 2, "-->offline,verifyFile:file not found!");
      }
      a(1);
      paramString1.printStackTrace();
      return false;
    }
    catch (JSONException paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("OfflineSecurity", 2, "-->offline,verifyFile:json error!");
      }
      a(3);
      paramString1.printStackTrace();
      return false;
    }
    catch (IOException paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("OfflineSecurity", 2, "-->offline,verifyFile:io error!");
      }
      a(2);
      paramString1.printStackTrace();
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("offlneSecurity", 2, "-->offline:verifyFile,check md5 fail:" + paramString1);
    }
    a(6);
    HtmlOffline.b(paramString2 + File.separator + paramString1, paramString3);
    return false;
    label349:
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\common\util\OfflineSecurity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */