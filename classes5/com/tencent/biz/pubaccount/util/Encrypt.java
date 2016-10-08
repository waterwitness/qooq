package com.tencent.biz.pubaccount.util;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.Base64Util;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Cipher;

public class Encrypt
{
  private static final int a = 117;
  protected static final String a = "RSA/ECB/PKCS1Padding";
  private static final int b = 128;
  protected static final String b = "RSA";
  
  public Encrypt()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static byte[] a(boolean paramBoolean, byte[] paramArrayOfByte, String paramString)
  {
    int i = 128;
    Object localObject = "RSA";
    if (paramBoolean)
    {
      localObject = "RSA/ECB/PKCS1Padding";
      i = 117;
    }
    paramString = new X509EncodedKeySpec(Base64Util.decode(paramString, 0));
    paramString = KeyFactory.getInstance("RSA").generatePublic(paramString);
    localObject = Cipher.getInstance((String)localObject);
    ((Cipher)localObject).init(1, paramString);
    int k = paramArrayOfByte.length;
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    int j = 0;
    if (k - j > 0)
    {
      if (k - j > i) {}
      for (paramString = ((Cipher)localObject).doFinal(paramArrayOfByte, j, i);; paramString = ((Cipher)localObject).doFinal(paramArrayOfByte, j, k - j))
      {
        localByteArrayOutputStream.write(paramString, 0, paramString.length);
        j += i;
        break;
      }
    }
    paramArrayOfByte = localByteArrayOutputStream.toByteArray();
    localByteArrayOutputStream.close();
    return paramArrayOfByte;
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    Object localObject2 = null;
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return null;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    Object localObject1 = localObject2;
    try
    {
      GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(localByteArrayOutputStream);
      localObject1 = localObject2;
      localGZIPOutputStream.write(paramArrayOfByte);
      localObject1 = localObject2;
      localGZIPOutputStream.close();
      localObject1 = localObject2;
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      localObject1 = paramArrayOfByte;
      localByteArrayOutputStream.close();
      return paramArrayOfByte;
    }
    catch (IOException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return (byte[])localObject1;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\util\Encrypt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */