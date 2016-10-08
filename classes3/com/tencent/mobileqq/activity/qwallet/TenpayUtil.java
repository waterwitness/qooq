package com.tencent.mobileqq.activity.qwallet;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QWalletHandler;
import com.tencent.mobileqq.app.QWalletObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qwallet.CodeGenerate.CodeGenerateReq;
import com.tencent.qwallet.CodeGenerate.CodeGenerateRes;
import com.tencent.tenpay.cert.CertUtil;
import java.io.File;
import java.security.MessageDigest;
import java.util.Random;
import ott;

public class TenpayUtil
{
  private static final int jdField_a_of_type_Int = 22;
  private static TenpayUtil jdField_a_of_type_ComTencentMobileqqActivityQwalletTenpayUtil;
  private static final String jdField_a_of_type_JavaLangString = TenpayUtil.class.getSimpleName();
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler = new ott(this, Looper.getMainLooper());
  private QWalletHandler jdField_a_of_type_ComTencentMobileqqAppQWalletHandler;
  private QWalletObserver jdField_a_of_type_ComTencentMobileqqAppQWalletObserver;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  private String d;
  private String e;
  private String f;
  private String g = "";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private TenpayUtil(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 4, "TenpayUtil");
    }
    a(paramQQAppInterface);
  }
  
  public static TenpayUtil a(QQAppInterface paramQQAppInterface)
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityQwalletTenpayUtil == null) {
      jdField_a_of_type_ComTencentMobileqqActivityQwalletTenpayUtil = new TenpayUtil(paramQQAppInterface);
    }
    return jdField_a_of_type_ComTencentMobileqqActivityQwalletTenpayUtil;
  }
  
  /* Error */
  private String a(Context paramContext)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 83
    //   3: invokevirtual 89	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   6: checkcast 91	android/net/wifi/WifiManager
    //   9: astore_1
    //   10: aload_1
    //   11: ifnull +82 -> 93
    //   14: aload_1
    //   15: invokevirtual 95	android/net/wifi/WifiManager:getConnectionInfo	()Landroid/net/wifi/WifiInfo;
    //   18: invokevirtual 100	android/net/wifi/WifiInfo:getMacAddress	()Ljava/lang/String;
    //   21: ifnonnull +72 -> 93
    //   24: aload_1
    //   25: invokevirtual 103	android/net/wifi/WifiManager:isWifiEnabled	()Z
    //   28: istore 4
    //   30: iconst_0
    //   31: istore_3
    //   32: iload_3
    //   33: iconst_3
    //   34: if_icmpge +48 -> 82
    //   37: aload_1
    //   38: iconst_1
    //   39: invokevirtual 107	android/net/wifi/WifiManager:setWifiEnabled	(Z)Z
    //   42: pop
    //   43: aload_1
    //   44: invokevirtual 95	android/net/wifi/WifiManager:getConnectionInfo	()Landroid/net/wifi/WifiInfo;
    //   47: invokevirtual 100	android/net/wifi/WifiInfo:getMacAddress	()Ljava/lang/String;
    //   50: astore_2
    //   51: aload_2
    //   52: ifnull +17 -> 69
    //   55: iload 4
    //   57: ifne +9 -> 66
    //   60: aload_1
    //   61: iconst_0
    //   62: invokevirtual 107	android/net/wifi/WifiManager:setWifiEnabled	(Z)Z
    //   65: pop
    //   66: aload_2
    //   67: areturn
    //   68: astore_2
    //   69: ldc2_w 108
    //   72: invokestatic 115	java/lang/Thread:sleep	(J)V
    //   75: iload_3
    //   76: iconst_1
    //   77: iadd
    //   78: istore_3
    //   79: goto -47 -> 32
    //   82: iload 4
    //   84: ifne +9 -> 93
    //   87: aload_1
    //   88: iconst_0
    //   89: invokevirtual 107	android/net/wifi/WifiManager:setWifiEnabled	(Z)Z
    //   92: pop
    //   93: aconst_null
    //   94: areturn
    //   95: astore_2
    //   96: iload 4
    //   98: ifne +9 -> 107
    //   101: aload_1
    //   102: iconst_0
    //   103: invokevirtual 107	android/net/wifi/WifiManager:setWifiEnabled	(Z)Z
    //   106: pop
    //   107: aload_2
    //   108: athrow
    //   109: astore_1
    //   110: goto -17 -> 93
    //   113: astore_1
    //   114: goto -48 -> 66
    //   117: astore_2
    //   118: goto -43 -> 75
    //   121: astore_1
    //   122: goto -29 -> 93
    //   125: astore_1
    //   126: goto -19 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	this	TenpayUtil
    //   0	129	1	paramContext	Context
    //   50	17	2	str	String
    //   68	1	2	localException	Exception
    //   95	13	2	localObject	Object
    //   117	1	2	localInterruptedException	InterruptedException
    //   31	48	3	i	int
    //   28	69	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   37	51	68	java/lang/Exception
    //   37	51	95	finally
    //   69	75	95	finally
    //   0	10	109	java/lang/Exception
    //   14	30	109	java/lang/Exception
    //   107	109	109	java/lang/Exception
    //   60	66	113	java/lang/Exception
    //   69	75	117	java/lang/InterruptedException
    //   87	93	121	java/lang/Exception
    //   101	107	125	java/lang/Exception
  }
  
  private String a(String paramString)
  {
    int i = 0;
    if (paramString == null) {
      return "";
    }
    char[] arrayOfChar = new char[16];
    char[] tmp16_15 = arrayOfChar;
    tmp16_15[0] = 48;
    char[] tmp21_16 = tmp16_15;
    tmp21_16[1] = 49;
    char[] tmp26_21 = tmp21_16;
    tmp26_21[2] = 50;
    char[] tmp31_26 = tmp26_21;
    tmp31_26[3] = 51;
    char[] tmp36_31 = tmp31_26;
    tmp36_31[4] = 52;
    char[] tmp41_36 = tmp36_31;
    tmp41_36[5] = 53;
    char[] tmp46_41 = tmp41_36;
    tmp46_41[6] = 54;
    char[] tmp52_46 = tmp46_41;
    tmp52_46[7] = 55;
    char[] tmp58_52 = tmp52_46;
    tmp58_52[8] = 56;
    char[] tmp64_58 = tmp58_52;
    tmp64_58[9] = 57;
    char[] tmp70_64 = tmp64_58;
    tmp70_64[10] = 65;
    char[] tmp76_70 = tmp70_64;
    tmp76_70[11] = 66;
    char[] tmp82_76 = tmp76_70;
    tmp82_76[12] = 67;
    char[] tmp88_82 = tmp82_76;
    tmp88_82[13] = 68;
    char[] tmp94_88 = tmp88_82;
    tmp94_88[14] = 69;
    char[] tmp100_94 = tmp94_88;
    tmp100_94[15] = 70;
    tmp100_94;
    for (;;)
    {
      Object localObject;
      int j;
      try
      {
        localObject = MessageDigest.getInstance("MD5");
        ((MessageDigest)localObject).update(paramString.getBytes());
        paramString = ((MessageDigest)localObject).digest();
        localObject = new char[32];
        j = 0;
      }
      catch (Exception paramString)
      {
        return null;
      }
      paramString = new String((char[])localObject);
      return paramString;
      while (i < 16)
      {
        int k = paramString[i];
        int m = j + 1;
        localObject[j] = arrayOfChar[(k >>> 4 & 0xF)];
        j = m + 1;
        localObject[m] = arrayOfChar[(k & 0xF)];
        i += 1;
      }
    }
  }
  
  private String a(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() == 1) {
        localStringBuffer.append("0");
      }
      localStringBuffer.append(str.toUpperCase());
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static void a()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityQwalletTenpayUtil != null) {
      jdField_a_of_type_ComTencentMobileqqActivityQwalletTenpayUtil.b();
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQWalletObserver = new QWalletObserver(this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentMobileqqAppQWalletHandler = ((QWalletHandler)paramQQAppInterface.a(76));
    paramQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppQWalletObserver);
    this.jdField_a_of_type_AndroidContentContext = paramQQAppInterface.getApplication();
    this.g = paramQQAppInterface.a();
    paramQQAppInterface = (TelephonyManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("phone");
    try
    {
      this.c = paramQQAppInterface.getSubscriberId();
      this.d = paramQQAppInterface.getSimSerialNumber();
      this.e = paramQQAppInterface.getDeviceId();
      this.f = Settings.System.getString(this.jdField_a_of_type_AndroidContentContext.getContentResolver(), "android_id");
      this.b = a(this.jdField_a_of_type_AndroidContentContext);
      CertUtil.a().a(this.jdField_a_of_type_AndroidContentContext);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      for (;;) {}
    }
  }
  
  private void a(CodeGenerate.CodeGenerateRes paramCodeGenerateRes)
  {
    CertUtil.a().a(this.jdField_a_of_type_AndroidContentContext);
    if (!CertUtil.a().a()) {}
    do
    {
      String str1;
      String str2;
      String str3;
      String str4;
      String str5;
      String str10;
      do
      {
        String str7;
        String str9;
        do
        {
          return;
          String str6 = paramCodeGenerateRes.retmsg.get();
          str7 = paramCodeGenerateRes.retcode.get();
          str1 = paramCodeGenerateRes.cn.get();
          str2 = paramCodeGenerateRes.code_prefix.get();
          paramCodeGenerateRes.forbid_watch.get();
          str3 = paramCodeGenerateRes.pay_desc.get();
          str4 = paramCodeGenerateRes.pay_type.get();
          String str8 = paramCodeGenerateRes.random.get();
          str9 = paramCodeGenerateRes.token.get();
          str5 = paramCodeGenerateRes.token_md5.get();
          str10 = paramCodeGenerateRes.uin.get();
          paramCodeGenerateRes = paramCodeGenerateRes.valid_end.get();
          if (QLog.isDevelopLevel())
          {
            QLog.i(jdField_a_of_type_JavaLangString, 4, "retmsg=" + str6);
            QLog.i(jdField_a_of_type_JavaLangString, 4, "retcode=" + str7);
            QLog.i(jdField_a_of_type_JavaLangString, 4, "cn=" + str1);
            QLog.i(jdField_a_of_type_JavaLangString, 4, "code_prefix=" + str2);
            QLog.i(jdField_a_of_type_JavaLangString, 4, "forbid_watch=" + str1);
            QLog.i(jdField_a_of_type_JavaLangString, 4, "pay_desc=" + str3);
            QLog.i(jdField_a_of_type_JavaLangString, 4, "pay_type=" + str4);
            QLog.i(jdField_a_of_type_JavaLangString, 4, "random=" + str8);
            QLog.i(jdField_a_of_type_JavaLangString, 4, "token=" + str9);
            QLog.i(jdField_a_of_type_JavaLangString, 4, "token_md5=" + str5);
            QLog.i(jdField_a_of_type_JavaLangString, 4, "uin=" + str10);
            QLog.i(jdField_a_of_type_JavaLangString, 4, "valid_end=" + paramCodeGenerateRes);
          }
        } while (!"0".equals(str7));
        CertUtil.a().b(str1);
        if (CertUtil.a().a(str1, str9)) {
          break;
        }
      } while (!QLog.isDevelopLevel());
      QLog.i(jdField_a_of_type_JavaLangString, 4, "setTokens fail");
      return;
      paramCodeGenerateRes = "qb_tenpay_pay_" + str10;
      paramCodeGenerateRes = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences(paramCodeGenerateRes, 5).edit();
      paramCodeGenerateRes.putString("qrcode_pay_cid", str1);
      paramCodeGenerateRes.putString("qrcode_pay_tokenmd5", str5);
      paramCodeGenerateRes.putString("qrcode_last_pay", str4);
      paramCodeGenerateRes.putString("qrcode_pay_types", str3);
      paramCodeGenerateRes.putString("qrcode_code_prefix", str2);
      paramCodeGenerateRes.commit();
    } while (!QLog.isDevelopLevel());
    QLog.i(jdField_a_of_type_JavaLangString, 4, "setTokens success");
  }
  
  private boolean a(Context paramContext)
  {
    paramContext = new String[5];
    paramContext[0] = "/system/bin/";
    paramContext[1] = "/system/xbin/";
    paramContext[2] = "/system/sbin/";
    paramContext[3] = "/sbin/";
    paramContext[4] = "/vendor/bin/";
    try
    {
      int j = paramContext.length;
      int i = 0;
      while (i < j)
      {
        File localFile = new File(paramContext[i] + "su");
        if (localFile != null)
        {
          boolean bool = localFile.exists();
          if (bool) {
            return true;
          }
        }
        i += 1;
      }
      return false;
    }
    catch (Exception paramContext)
    {
      return false;
    }
  }
  
  private String b()
  {
    return "android_mqq";
  }
  
  private void b()
  {
    CertUtil.a().a();
    this.jdField_a_of_type_ComTencentMobileqqAppQWalletObserver = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQWalletHandler = null;
    jdField_a_of_type_ComTencentMobileqqActivityQwalletTenpayUtil = null;
  }
  
  private String c()
  {
    return Build.MODEL;
  }
  
  private String d()
  {
    StringBuilder localStringBuilder = new StringBuilder(160);
    if (!TextUtils.isEmpty(this.e)) {
      localStringBuilder.append(a(this.e));
    }
    localStringBuilder.append("||");
    localStringBuilder.append(Build.MODEL);
    localStringBuilder.append("|");
    localStringBuilder.append(Build.VERSION.RELEASE);
    localStringBuilder.append(",sdk");
    localStringBuilder.append(Build.VERSION.SDK_INT);
    localStringBuilder.append("|");
    if (!TextUtils.isEmpty(this.b)) {
      localStringBuilder.append(a(this.e + this.b));
    }
    localStringBuilder.append("|");
    try
    {
      if (!TextUtils.isEmpty(this.c)) {
        localStringBuilder.append(a(this.c));
      }
      localStringBuilder.append("|");
      if (a(this.jdField_a_of_type_AndroidContentContext))
      {
        String str1 = "1";
        localStringBuilder.append(str1);
        localStringBuilder.append("|");
        return localStringBuilder.toString();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        continue;
        String str2 = "0";
      }
    }
  }
  
  public boolean a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 4, "checkQrCode");
    }
    if (paramQQAppInterface == null) {
      return false;
    }
    CertUtil.a().a(this.jdField_a_of_type_AndroidContentContext);
    String str1 = paramQQAppInterface.a();
    if (QLog.isDevelopLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 4, "uin = " + str1);
    }
    if (TextUtils.isEmpty(str1)) {
      return false;
    }
    if (!str1.equals(this.g)) {
      a(paramQQAppInterface);
    }
    if (!CertUtil.a().a()) {
      return false;
    }
    String str2 = "qb_tenpay_pay_" + str1;
    Object localObject1 = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences(str2, 5);
    paramQQAppInterface = ((SharedPreferences)localObject1).getString("qrcode_pay_cid", "");
    if (QLog.isDevelopLevel())
    {
      QLog.i(jdField_a_of_type_JavaLangString, 4, "spName = " + str2);
      QLog.i(jdField_a_of_type_JavaLangString, 4, "cid = " + paramQQAppInterface);
      str2 = ((SharedPreferences)localObject1).getString("qrcode_pay_tokenmd5", "");
      QLog.i(jdField_a_of_type_JavaLangString, 4, "token_md5 = " + str2);
      str2 = ((SharedPreferences)localObject1).getString("qrcode_pay_types", "");
      QLog.i(jdField_a_of_type_JavaLangString, 4, "qrcode_pay_types = " + str2);
      str2 = ((SharedPreferences)localObject1).getString("qrcode_code_prefix", "50");
      QLog.i(jdField_a_of_type_JavaLangString, 4, "qrcode_code_prefix = " + str2);
    }
    if ((TextUtils.isEmpty(paramQQAppInterface)) || (!CertUtil.a().a(paramQQAppInterface)))
    {
      if (QLog.isDevelopLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 4, "no valid cid");
      }
      return false;
    }
    int i = CertUtil.a().a(paramQQAppInterface);
    if (QLog.isDevelopLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 4, "tokenCount=" + i);
    }
    if (i == 0)
    {
      str2 = a(NetConnInfoCenter.GUID);
      long l = NetConnInfoCenter.getServerTimeMillis();
      i = AppSetting.a;
      localObject1 = ((SharedPreferences)localObject1).getString("qrcode_pay_tokenmd5", "");
      String str3 = this.e;
      String str4 = b();
      String str5 = c();
      String str6 = Integer.toString(new Random(System.currentTimeMillis()).nextInt());
      Object localObject2 = new StringBuffer();
      ((StringBuffer)localObject2).append(paramQQAppInterface);
      if (!TextUtils.isEmpty(str3))
      {
        ((StringBuffer)localObject2).append("&");
        ((StringBuffer)localObject2).append(str3);
      }
      ((StringBuffer)localObject2).append("&");
      ((StringBuffer)localObject2).append(str4);
      ((StringBuffer)localObject2).append("&");
      ((StringBuffer)localObject2).append(str2);
      ((StringBuffer)localObject2).append("&");
      ((StringBuffer)localObject2).append(str6);
      ((StringBuffer)localObject2).append("&");
      ((StringBuffer)localObject2).append(l);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        ((StringBuffer)localObject2).append("&");
        ((StringBuffer)localObject2).append((String)localObject1);
      }
      ((StringBuffer)localObject2).append("&");
      ((StringBuffer)localObject2).append(str1);
      String str7 = CertUtil.a().a(paramQQAppInterface, ((StringBuffer)localObject2).toString());
      localObject2 = new CodeGenerate.CodeGenerateReq();
      ((CodeGenerate.CodeGenerateReq)localObject2).cn.set(paramQQAppInterface);
      if (!TextUtils.isEmpty(str3)) {
        ((CodeGenerate.CodeGenerateReq)localObject2).device_id.set(str3);
      }
      ((CodeGenerate.CodeGenerateReq)localObject2).device_name.set(str5);
      ((CodeGenerate.CodeGenerateReq)localObject2).device_type.set(str4);
      ((CodeGenerate.CodeGenerateReq)localObject2).guid.set(str2);
      ((CodeGenerate.CodeGenerateReq)localObject2).h_edition.set(d());
      ((CodeGenerate.CodeGenerateReq)localObject2).h_qq_guid.set(str2);
      ((CodeGenerate.CodeGenerateReq)localObject2).h_model.set(Build.MODEL);
      ((CodeGenerate.CodeGenerateReq)localObject2).h_qq_appid.set(String.valueOf(i));
      ((CodeGenerate.CodeGenerateReq)localObject2).random.set(str6);
      ((CodeGenerate.CodeGenerateReq)localObject2).sign.set(str7);
      ((CodeGenerate.CodeGenerateReq)localObject2).timestamp.set(l);
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        ((CodeGenerate.CodeGenerateReq)localObject2).token_md5.set((String)localObject1);
      }
      ((CodeGenerate.CodeGenerateReq)localObject2).uin.set(str1);
      ((CodeGenerate.CodeGenerateReq)localObject2).h_edition.set(String.valueOf(22));
      if (QLog.isDevelopLevel())
      {
        QLog.i(jdField_a_of_type_JavaLangString, 4, "cn=" + paramQQAppInterface);
        QLog.i(jdField_a_of_type_JavaLangString, 4, "device_id=" + str3);
        QLog.i(jdField_a_of_type_JavaLangString, 4, "device_name=" + str5);
        QLog.i(jdField_a_of_type_JavaLangString, 4, "device_type=" + str4);
        QLog.i(jdField_a_of_type_JavaLangString, 4, "guid=" + str2);
        QLog.i(jdField_a_of_type_JavaLangString, 4, "getHlocation()=" + d());
        QLog.i(jdField_a_of_type_JavaLangString, 4, "android.os.Build.MODEL=" + Build.MODEL);
        QLog.i(jdField_a_of_type_JavaLangString, 4, "appid=" + i);
        QLog.i(jdField_a_of_type_JavaLangString, 4, "random=" + str6);
        QLog.i(jdField_a_of_type_JavaLangString, 4, "sign=" + str7);
        QLog.i(jdField_a_of_type_JavaLangString, 4, "timestamp=" + l);
        QLog.i(jdField_a_of_type_JavaLangString, 4, "token_md5=" + (String)localObject1);
        QLog.i(jdField_a_of_type_JavaLangString, 4, "uin=" + str1);
        QLog.i(jdField_a_of_type_JavaLangString, 4, "h_edition=22");
      }
      ((CodeGenerate.CodeGenerateReq)localObject2).cn.setHasFlag(true);
      paramQQAppInterface = ((CodeGenerate.CodeGenerateReq)localObject2).device_id;
      if (!TextUtils.isEmpty(str3))
      {
        bool = true;
        paramQQAppInterface.setHasFlag(bool);
        ((CodeGenerate.CodeGenerateReq)localObject2).device_name.setHasFlag(true);
        ((CodeGenerate.CodeGenerateReq)localObject2).device_type.setHasFlag(true);
        ((CodeGenerate.CodeGenerateReq)localObject2).guid.setHasFlag(true);
        ((CodeGenerate.CodeGenerateReq)localObject2).h_edition.setHasFlag(true);
        ((CodeGenerate.CodeGenerateReq)localObject2).h_qq_guid.setHasFlag(true);
        ((CodeGenerate.CodeGenerateReq)localObject2).h_model.setHasFlag(true);
        ((CodeGenerate.CodeGenerateReq)localObject2).h_qq_appid.setHasFlag(true);
        ((CodeGenerate.CodeGenerateReq)localObject2).random.setHasFlag(true);
        ((CodeGenerate.CodeGenerateReq)localObject2).sign.setHasFlag(true);
        ((CodeGenerate.CodeGenerateReq)localObject2).timestamp.setHasFlag(true);
        paramQQAppInterface = ((CodeGenerate.CodeGenerateReq)localObject2).token_md5;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label1393;
        }
      }
      label1393:
      for (boolean bool = true;; bool = false)
      {
        paramQQAppInterface.setHasFlag(bool);
        ((CodeGenerate.CodeGenerateReq)localObject2).uin.setHasFlag(true);
        ((CodeGenerate.CodeGenerateReq)localObject2).h_edition.setHasFlag(true);
        ((CodeGenerate.CodeGenerateReq)localObject2).setHasFlag(true);
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQWalletHandler.a((CodeGenerate.CodeGenerateReq)localObject2);
          return true;
        }
        catch (Exception paramQQAppInterface)
        {
          return false;
        }
        bool = false;
        break;
      }
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\qwallet\TenpayUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */