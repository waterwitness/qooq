package com.dataline.util;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.EndianUtil;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.Cryptor;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DatalineMathUtil
{
  private static String a = "9u23fh$jkf^%43hj";
  private static String b = "1234567890123456";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static long a()
  {
    WifiManager localWifiManager = (WifiManager)BaseApplication.getContext().getSystemService("wifi");
    if (!localWifiManager.isWifiEnabled()) {
      return 0L;
    }
    return localWifiManager.getConnectionInfo().getIpAddress();
  }
  
  public static String a(long paramLong)
  {
    if (paramLong > 4294967295L) {
      throw new IllegalArgumentException("invalid ip");
    }
    long l = paramLong;
    if (paramLong < 0L)
    {
      paramLong += 4294967296L;
      l = paramLong;
      if (paramLong < 0L) {
        throw new IllegalArgumentException("invalid ip");
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i <= 3)
    {
      int j = i * 8;
      localStringBuilder.append((255 << j & l) >> j);
      if (i < 3) {
        localStringBuilder.append(".");
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String a(long paramLong, byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[18];
    System.arraycopy(EndianUtil.a((short)1), 0, arrayOfByte, 0, 2);
    System.arraycopy(EndianUtil.b(paramLong), 0, arrayOfByte, 2, 8);
    System.arraycopy(EndianUtil.a((int)537035245L), 0, arrayOfByte, 10, 4);
    System.arraycopy(EndianUtil.a(a()), 0, arrayOfByte, 14, 4);
    return Base64Util.encodeToString(new Cryptor().encrypt(arrayOfByte, paramArrayOfByte), 2);
  }
  
  public static byte[] a(long paramLong1, long paramLong2, byte paramByte)
  {
    byte[] arrayOfByte = new byte[29];
    System.arraycopy(b.getBytes(), 0, arrayOfByte, 0, 16);
    System.arraycopy(EndianUtil.a((int)paramLong1), 0, arrayOfByte, 16, 4);
    System.arraycopy(EndianUtil.b(paramLong2), 0, arrayOfByte, 20, 8);
    arrayOfByte[28] = paramByte;
    return new Cryptor().encrypt(arrayOfByte, a.getBytes());
  }
  
  public static byte[] a(String paramString)
  {
    l1 = 10002432L;
    try
    {
      localMessageDigest = MessageDigest.getInstance("MD5");
      localFileInputStream = new FileInputStream(paramString);
      l2 = new File(paramString).length();
      if (l2 <= 10002432L) {
        break label135;
      }
    }
    catch (NoSuchAlgorithmException paramString)
    {
      MessageDigest localMessageDigest;
      FileInputStream localFileInputStream;
      paramString.printStackTrace();
      return null;
      localFileInputStream.close();
      paramString = localMessageDigest.digest();
      return paramString;
    }
    catch (FileNotFoundException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        long l2;
        paramString.printStackTrace();
        continue;
        l1 = l2;
      }
    }
    paramString = new byte['Ѐ'];
    while (l1 > 0L)
    {
      int j = localFileInputStream.read(paramString);
      if (j == -1) {
        break;
      }
      int i = j;
      if (j > l1) {
        i = (int)l1;
      }
      l1 -= i;
      localMessageDigest.update(paramString, 0, i);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\dataline\util\DatalineMathUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */