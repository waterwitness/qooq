package com.tencent.util;

import java.security.Key;
import java.security.spec.KeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;

public class EncryptUtils
{
  private static final String encoding = "utf-8";
  private static final String iv = "68881999";
  
  public static byte[] decode(byte[] paramArrayOfByte)
    throws Exception
  {
    Object localObject = new DESedeKeySpec(Coffee.getSignkey().getBytes());
    localObject = SecretKeyFactory.getInstance("desede").generateSecret((KeySpec)localObject);
    Cipher localCipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
    localCipher.init(2, (Key)localObject, new IvParameterSpec("68881999".getBytes()));
    return localCipher.doFinal(paramArrayOfByte);
  }
  
  public static byte[] encode(byte[] paramArrayOfByte)
    throws Exception
  {
    Object localObject = new DESedeKeySpec(Coffee.getSignkey().getBytes());
    localObject = SecretKeyFactory.getInstance("desede").generateSecret((KeySpec)localObject);
    Cipher localCipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
    localCipher.init(1, (Key)localObject, new IvParameterSpec("68881999".getBytes()));
    return localCipher.doFinal(paramArrayOfByte);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\util\EncryptUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */