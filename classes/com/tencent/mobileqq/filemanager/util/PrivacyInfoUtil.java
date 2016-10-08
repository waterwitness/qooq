package com.tencent.mobileqq.filemanager.util;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class PrivacyInfoUtil
{
  private final byte jdField_a_of_type_Byte;
  private final int jdField_a_of_type_Int;
  private final String jdField_a_of_type_JavaLangString;
  private final ArrayList jdField_a_of_type_JavaUtilArrayList;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private final byte[] jdField_a_of_type_ArrayOfByte;
  private final byte jdField_b_of_type_Byte;
  private final String jdField_b_of_type_JavaLangString;
  private final byte[] jdField_b_of_type_ArrayOfByte;
  private final byte jdField_c_of_type_Byte;
  private final String jdField_c_of_type_JavaLangString;
  private final byte[] jdField_c_of_type_ArrayOfByte;
  private final byte jdField_d_of_type_Byte;
  private final byte[] jdField_d_of_type_ArrayOfByte;
  private final byte[] e;
  private final byte[] f;
  private final byte[] g;
  private final byte[] h;
  private final byte[] i;
  private byte[] j;
  
  public PrivacyInfoUtil()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = "PrivacyInfoUtil";
    this.jdField_b_of_type_JavaLangString = "DESede/ECB/PKCS5Padding";
    this.jdField_c_of_type_JavaLangString = "random";
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(10);
    this.jdField_a_of_type_Byte = 0;
    this.jdField_a_of_type_ArrayOfByte = "gavinhuangdaydayup_happy".getBytes();
    this.jdField_b_of_type_ArrayOfByte = "doscarlettmarryrenzzhang".getBytes();
    this.jdField_c_of_type_ArrayOfByte = "wangpeilin_georgewangson".getBytes();
    this.jdField_d_of_type_ArrayOfByte = "georgebirthdayis19790526".getBytes();
    this.e = "qlinkwillthebestfunction".getBytes();
    this.f = "qqwillbebetterthanwechat".getBytes();
    this.g = "whowillbethenextbigtiger".getBytes();
    this.h = "whenwillwefindmahang_370".getBytes();
    this.i = "whenwillchinagetworldcap".getBytes();
    this.jdField_b_of_type_Byte = 0;
    this.jdField_c_of_type_Byte = 1;
    this.jdField_d_of_type_Byte = 0;
    this.jdField_a_of_type_Int = 20;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ArrayOfByte);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_b_of_type_ArrayOfByte);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_c_of_type_ArrayOfByte);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_d_of_type_ArrayOfByte);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.e);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.f);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.g);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.h);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.i);
  }
  
  private byte a()
  {
    return 0;
  }
  
  private String a(byte paramByte)
  {
    switch (paramByte)
    {
    default: 
      return null;
    case 0: 
      return "DESede/ECB/PKCS5Padding";
    }
    return "random";
  }
  
  private String a(byte paramByte1, byte paramByte2, byte paramByte3, byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder(20);
    Object localObject = a(paramByte1);
    if (localObject == null)
    {
      QLog.e("PrivacyInfoUtil", 1, "createCipherHotspot algorithm is null");
      return null;
    }
    byte[] arrayOfByte = a(paramByte3);
    if (arrayOfByte == null)
    {
      QLog.e("PrivacyInfoUtil", 1, "createCipherHotspot key is null");
      return null;
    }
    int k = 7;
    if (paramArrayOfByte.length < 8) {
      k = paramArrayOfByte.length - 1;
    }
    localObject = b((String)localObject, arrayOfByte, paramArrayOfByte, 1, k);
    if (localObject == null)
    {
      QLog.e("PrivacyInfoUtil", 1, "createCipherHotspot doCipher return null");
      return null;
    }
    k = 0;
    while (k < localObject.length)
    {
      localStringBuilder.append(Integer.toHexString((localObject[k] & 0xF0) >> 4));
      localStringBuilder.append(Integer.toHexString(localObject[k] & 0xF));
      k += 1;
    }
    localStringBuilder.append(Integer.toHexString((paramByte1 << 2) + paramByte2));
    localStringBuilder.append(Integer.toHexString(paramByte3));
    localStringBuilder.append(Integer.toHexString((paramArrayOfByte[0] & 0xF0) >> 4));
    localStringBuilder.append(Integer.toHexString(paramArrayOfByte[0] & 0xF));
    return localStringBuilder.toString();
  }
  
  private byte[] a(byte paramByte)
  {
    return this.j;
  }
  
  private byte[] a(long paramLong)
  {
    byte[] arrayOfByte = new byte[8];
    int k = 0;
    while (k < 8)
    {
      arrayOfByte[k] = ((byte)(int)(paramLong >> (7 - k) * 8 & 0xFF));
      k += 1;
    }
    return arrayOfByte;
  }
  
  private byte[] b(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
  {
    try
    {
      paramArrayOfByte1 = new SecretKeySpec(paramArrayOfByte1, paramString);
      Cipher localCipher = Cipher.getInstance(paramString);
      localCipher.init(1, paramArrayOfByte1);
      paramArrayOfByte1 = localCipher.doFinal(paramArrayOfByte2, paramInt1, paramInt2);
      return paramArrayOfByte1;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte1)
    {
      paramArrayOfByte1.printStackTrace();
      QLog.e("PrivacyInfoUtil", 1, "doCipher NoSuchAlgorithmException exception, algorithm[" + paramString + "]");
      return null;
    }
    catch (NoSuchPaddingException paramArrayOfByte1)
    {
      for (;;)
      {
        paramArrayOfByte1.printStackTrace();
        QLog.e("PrivacyInfoUtil", 1, "doCipher NoSuchPaddingException exception, algorithm[" + paramString + "]");
      }
    }
    catch (Exception paramArrayOfByte1)
    {
      for (;;)
      {
        paramArrayOfByte1.printStackTrace();
        QLog.e("PrivacyInfoUtil", 1, "doCipher lang exception, algorithm[" + paramString + "]");
      }
    }
  }
  
  public long a(String paramString)
  {
    int m = 0;
    long l2;
    if ((paramString == null) || (paramString.length() < 20)) {
      l2 = 0L;
    }
    for (;;)
    {
      return l2;
      try
      {
        k = Integer.valueOf(paramString.substring(16, 17), 16).byteValue();
        if ((byte)(k & 0x3) != 0) {
          return 0L;
        }
      }
      catch (NumberFormatException paramString)
      {
        return 0L;
      }
      Object localObject = a((byte)((k & 0xC) >> 2));
      if (localObject == null) {
        return 0L;
      }
      byte[] arrayOfByte1;
      try
      {
        byte b1 = Integer.valueOf(paramString.substring(17, 18), 16).byteValue();
        arrayOfByte1 = a(b1);
        if (arrayOfByte1 == null) {
          return 0L;
        }
      }
      catch (NumberFormatException paramString)
      {
        return 0L;
      }
      byte[] arrayOfByte2 = new byte[8];
      int k = 0;
      while (k < 8) {
        try
        {
          arrayOfByte2[k] = Integer.valueOf(paramString.substring(k * 2, k * 2 + 2), 16).byteValue();
          k += 1;
        }
        catch (NumberFormatException paramString)
        {
          return 0L;
        }
      }
      localObject = a((String)localObject, arrayOfByte1, arrayOfByte2, 0, arrayOfByte2.length);
      if (localObject == null) {
        return 0L;
      }
      try
      {
        k = Integer.valueOf(paramString.substring(18, 20), 16).byteValue();
        long l1 = k;
        k = m;
        for (;;)
        {
          l2 = l1;
          if (k >= 7) {
            break;
          }
          l1 = ((l1 << 4) + ((localObject[k] & 0xF0) >> 4) << 4) + (localObject[k] & 0xF);
          k += 1;
        }
        return 0L;
      }
      catch (NumberFormatException paramString) {}
    }
  }
  
  public String a(long paramLong)
  {
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
    if (str != null) {
      return str;
    }
    str = a(a(), (byte)0, (byte)0, a(paramLong));
    if (this.jdField_a_of_type_JavaUtilHashMap.size() > 20) {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong), str);
    return str;
  }
  
  public void a(String paramString)
  {
    if (paramString != null) {}
    for (paramString = paramString.getBytes();; paramString = null)
    {
      this.j = paramString;
      return;
    }
  }
  
  public byte[] a(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
  {
    try
    {
      paramArrayOfByte1 = new SecretKeySpec(paramArrayOfByte1, paramString);
      Cipher localCipher = Cipher.getInstance(paramString);
      localCipher.init(2, paramArrayOfByte1);
      paramArrayOfByte1 = localCipher.doFinal(paramArrayOfByte2, paramInt1, paramInt2);
      return paramArrayOfByte1;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte1)
    {
      paramArrayOfByte1.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.e("PrivacyInfoUtil", 2, "doDecrypt NoSuchAlgorithmException exception, algorithm[" + paramString + "]");
      }
      return null;
    }
    catch (NoSuchPaddingException paramArrayOfByte1)
    {
      for (;;)
      {
        paramArrayOfByte1.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e("PrivacyInfoUtil", 2, "doDecrypt NoSuchPaddingException exception, algorithm[" + paramString + "]");
        }
      }
    }
    catch (Exception paramArrayOfByte1)
    {
      for (;;)
      {
        paramArrayOfByte1.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e("PrivacyInfoUtil", 2, "doDecrypt lang exception, algorithm[" + paramString + "]");
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\filemanager\util\PrivacyInfoUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */