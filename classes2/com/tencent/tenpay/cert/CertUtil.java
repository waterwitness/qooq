package com.tencent.tenpay.cert;

import android.content.Context;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.security.MessageDigest;

public class CertUtil
{
  public static final String a = CertUtil.class.getSimpleName();
  private static CertUtil instance;
  private String cert_dir;
  private String cert_id;
  private byte[] certid_buf;
  private byte[] cipher_buf;
  private byte[] csr_buf;
  private String deskey;
  private String iccid;
  private String imei;
  private String imsi;
  private String login_ip;
  private Context mContext;
  private boolean mIsLibraryReady;
  private String mac;
  private String plain_buf;
  private byte[] plain_buf2;
  private String priv_dir;
  private String publ_dir;
  private String qq_id;
  private byte[] sig_buf;
  private String sig_raw_buf;
  private String softid;
  private String svr_cert;
  private String token;
  private byte[] token_buf;
  private String token_dir;
  private int token_len;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private CertUtil()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(a, 4, "CertUtil");
    }
  }
  
  public static CertUtil a()
  {
    if (instance == null) {
      instance = new CertUtil();
    }
    return instance;
  }
  
  private String a()
  {
    return this.mContext.getFilesDir().getParentFile().getAbsolutePath() + "/cert";
  }
  
  /* Error */
  private String a(Context paramContext)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 108
    //   3: invokevirtual 112	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   6: checkcast 114	android/net/wifi/WifiManager
    //   9: astore_1
    //   10: aload_1
    //   11: ifnull +82 -> 93
    //   14: aload_1
    //   15: invokevirtual 118	android/net/wifi/WifiManager:getConnectionInfo	()Landroid/net/wifi/WifiInfo;
    //   18: invokevirtual 123	android/net/wifi/WifiInfo:getMacAddress	()Ljava/lang/String;
    //   21: ifnonnull +72 -> 93
    //   24: aload_1
    //   25: invokevirtual 126	android/net/wifi/WifiManager:isWifiEnabled	()Z
    //   28: istore 4
    //   30: iconst_0
    //   31: istore_3
    //   32: iload_3
    //   33: iconst_3
    //   34: if_icmpge +48 -> 82
    //   37: aload_1
    //   38: iconst_1
    //   39: invokevirtual 130	android/net/wifi/WifiManager:setWifiEnabled	(Z)Z
    //   42: pop
    //   43: aload_1
    //   44: invokevirtual 118	android/net/wifi/WifiManager:getConnectionInfo	()Landroid/net/wifi/WifiInfo;
    //   47: invokevirtual 123	android/net/wifi/WifiInfo:getMacAddress	()Ljava/lang/String;
    //   50: astore_2
    //   51: aload_2
    //   52: ifnull +17 -> 69
    //   55: iload 4
    //   57: ifne +9 -> 66
    //   60: aload_1
    //   61: iconst_0
    //   62: invokevirtual 130	android/net/wifi/WifiManager:setWifiEnabled	(Z)Z
    //   65: pop
    //   66: aload_2
    //   67: areturn
    //   68: astore_2
    //   69: ldc2_w 131
    //   72: invokestatic 138	java/lang/Thread:sleep	(J)V
    //   75: iload_3
    //   76: iconst_1
    //   77: iadd
    //   78: istore_3
    //   79: goto -47 -> 32
    //   82: iload 4
    //   84: ifne +9 -> 93
    //   87: aload_1
    //   88: iconst_0
    //   89: invokevirtual 130	android/net/wifi/WifiManager:setWifiEnabled	(Z)Z
    //   92: pop
    //   93: aconst_null
    //   94: areturn
    //   95: astore_2
    //   96: iload 4
    //   98: ifne +9 -> 107
    //   101: aload_1
    //   102: iconst_0
    //   103: invokevirtual 130	android/net/wifi/WifiManager:setWifiEnabled	(Z)Z
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
    //   0	129	0	this	CertUtil
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
  
  private void a(String paramString, boolean paramBoolean)
  {
    try
    {
      b(paramString);
      if (paramBoolean) {
        new File(paramString.toString()).delete();
      }
      return;
    }
    catch (Exception paramString) {}
  }
  
  private boolean a(Context paramContext)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(a, 4, "loadSo");
    }
    try
    {
      paramContext = paramContext.getFilesDir().getParent() + "/app_lib/qwallet_plugin/libcftutils_v1.1.so";
      File localFile = new File(paramContext);
      if (QLog.isDevelopLevel()) {
        QLog.i(a, 4, "path = " + paramContext);
      }
      if (!localFile.exists())
      {
        QLog.i(a, 4, "file does not exist");
        return false;
      }
      System.load(paramContext);
      return true;
    }
    catch (Exception paramContext)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i(a, 4, "Exception 1 = " + paramContext.getMessage());
      }
      try
      {
        System.loadLibrary("cftutils");
        return false;
      }
      catch (Error paramContext)
      {
        if (!QLog.isDevelopLevel()) {
          break label266;
        }
      }
      QLog.i(a, 4, "error 1 = " + paramContext.getMessage());
      return false;
    }
    catch (Error paramContext)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i(a, 4, "error 2 = " + paramContext.getMessage());
      }
      try
      {
        System.loadLibrary("cftutils");
        return false;
      }
      catch (Error paramContext)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i(a, 4, "error 3 = " + paramContext.getMessage());
        }
      }
    }
    label266:
    return false;
  }
  
  private boolean b(String paramString)
  {
    File localFile = new File(paramString);
    if (!localFile.exists()) {}
    while (!localFile.isDirectory()) {
      return false;
    }
    String[] arrayOfString = localFile.list();
    int i = 0;
    boolean bool = false;
    if (i < arrayOfString.length) {
      if (paramString.endsWith(File.separator))
      {
        localFile = new File(paramString + arrayOfString[i]);
        label82:
        if (!localFile.isFile()) {
          break label141;
        }
        localFile.delete();
      }
    }
    for (;;)
    {
      i += 1;
      break;
      localFile = new File(paramString + File.separator + arrayOfString[i]);
      break label82;
      label141:
      if (localFile.isDirectory())
      {
        b(paramString + File.separator + arrayOfString[i]);
        a(paramString + File.separator + arrayOfString[i], true);
        bool = true;
        continue;
        return bool;
      }
    }
  }
  
  private void c(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(a, 4, "setAndCheckDir cid =" + paramString);
    }
    String str = a();
    paramString = str + "/" + a(new StringBuilder().append(paramString).append(this.imei).toString());
    this.cert_dir = (paramString + "/cert");
    this.priv_dir = (paramString + "/priv");
    this.publ_dir = (paramString + "/publ");
    this.token_dir = (paramString + "/auth");
    e(str);
    e(paramString);
    e(this.token_dir);
  }
  
  private boolean c(String paramString)
  {
    boolean bool = true;
    paramString = new File(paramString);
    if ((!paramString.exists()) || (!paramString.isDirectory()) || (paramString.listFiles() == null)) {
      bool = false;
    }
    return bool;
  }
  
  private void d(String paramString)
  {
    paramString = a() + "/" + a(new StringBuilder().append(paramString).append(this.imei).toString());
    this.cert_dir = (paramString + "/cert");
    this.priv_dir = (paramString + "/priv");
    this.publ_dir = (paramString + "/publ");
    this.token_dir = (paramString + "/auth");
  }
  
  private boolean d(String paramString)
  {
    boolean bool = true;
    paramString = new File(paramString);
    if ((!paramString.exists()) || (!paramString.isDirectory())) {
      bool = false;
    }
    return bool;
  }
  
  private void e(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
    while (paramString.isDirectory()) {
      return;
    }
    paramString.delete();
    paramString.mkdirs();
  }
  
  private native int get_last_error();
  
  private native int get_token_count();
  
  private native boolean is_cert_exist();
  
  private native boolean set_token();
  
  private native boolean usr_sig();
  
  public int a()
  {
    return get_last_error();
  }
  
  public int a(String paramString)
  {
    get_token_count();
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    d(paramString);
    return get_token_count();
  }
  
  public String a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      return null;
      c(paramString1);
    } while ((!c(this.cert_dir)) || (!c(this.publ_dir)) || (!c(this.priv_dir)) || (paramString1 == null) || (paramString2 == null) || (paramString1.length() <= 0) || (paramString2.length() <= 0));
    this.cert_id = paramString1;
    this.sig_raw_buf = paramString2;
    this.sig_buf = null;
    if ((usr_sig()) && (this.sig_buf != null)) {}
    for (;;)
    {
      try
      {
        paramString1 = new String(this.sig_buf, "UTF-8");
        return paramString1;
      }
      catch (Exception paramString1)
      {
        return null;
      }
      paramString1 = null;
    }
  }
  
  public void a()
  {
    this.mIsLibraryReady = false;
    instance = null;
  }
  
  public void a(Context paramContext)
  {
    this.mIsLibraryReady = a(paramContext);
    TelephonyManager localTelephonyManager;
    if (this.mContext == null)
    {
      this.mContext = paramContext.getApplicationContext();
      localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
    }
    try
    {
      this.imsi = localTelephonyManager.getSubscriberId();
      this.iccid = localTelephonyManager.getSimSerialNumber();
      this.imei = localTelephonyManager.getDeviceId();
      this.softid = Settings.System.getString(paramContext.getContentResolver(), "android_id");
      this.mac = a(this.mContext);
      this.deskey = this.imei;
      return;
    }
    catch (Exception paramContext)
    {
      for (;;) {}
    }
  }
  
  public void a(String paramString)
  {
    a(a() + "/" + a(new StringBuilder().append(paramString).append(this.imei).toString()), true);
  }
  
  public boolean a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(a, 4, "isLibraryReady = " + this.mIsLibraryReady);
    }
    return this.mIsLibraryReady;
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      d(paramString);
    } while ((!c(this.cert_dir)) || (!c(this.publ_dir)) || (!c(this.priv_dir)));
    this.cert_id = paramString;
    return is_cert_exist();
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    if (QLog.isDevelopLevel())
    {
      QLog.i(a, 4, "setTokens cid =" + paramString1);
      QLog.i(a, 4, "tokens =" + paramString2);
    }
    boolean bool1;
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      bool1 = bool2;
      if (QLog.isDevelopLevel())
      {
        QLog.i(a, 4, "is empty");
        bool1 = bool2;
      }
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          c(paramString1);
          if (d(this.cert_dir)) {
            break;
          }
          bool1 = bool2;
        } while (!QLog.isDevelopLevel());
        QLog.i(a, 4, "invalid cert_dir =" + this.cert_dir);
        return false;
        if (d(this.token_dir)) {
          break;
        }
        bool1 = bool2;
      } while (!QLog.isDevelopLevel());
      QLog.i(a, 4, "invalid token_dir =" + this.token_dir);
      return false;
      this.cert_id = paramString1;
      this.token = paramString2;
      this.token_len = this.token.length();
      bool2 = set_token();
      bool1 = bool2;
    } while (!QLog.isDevelopLevel());
    QLog.i(a, 4, "setTokens ret=" + bool2);
    return bool2;
  }
  
  public void b()
  {
    a(a(), true);
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    d(paramString);
    a(this.token_dir, true);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\tenpay\cert\CertUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */