package com.tencent.bitapp.utils;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import junit.framework.Assert;

public class AES
{
  public static final String KEY_AES = "AES";
  public static final String LOCAL_PASSWD = "MTIzNDU2MTIzNDU2MTIzNA==";
  
  public static byte[] decrypt(byte[] paramArrayOfByte, Key paramKey)
    throws Exception
  {
    Cipher localCipher = Cipher.getInstance("AES");
    localCipher.init(2, paramKey);
    return localCipher.doFinal(paramArrayOfByte);
  }
  
  public static byte[] encrypt(byte[] paramArrayOfByte, Key paramKey)
    throws Exception
  {
    Cipher localCipher = Cipher.getInstance("AES");
    localCipher.init(1, paramKey);
    return localCipher.doFinal(paramArrayOfByte);
  }
  
  public static boolean genDecodedFile(String paramString, Key paramKey)
    throws Exception
  {
    return FileUtils.writeFile(decrypt(FileUtils.readFile(paramString), paramKey), FileUtils.getDecodedFileNameFromEncoded(paramString));
  }
  
  public static Key generateKey()
  {
    try
    {
      Object localObject = KeyGenerator.getInstance("AES");
      ((KeyGenerator)localObject).init(128);
      localObject = new SecretKeySpec(((KeyGenerator)localObject).generateKey().getEncoded(), "AES");
      return (Key)localObject;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {}
    return null;
  }
  
  public static Key getKey(String paramString)
  {
    return new SecretKeySpec(RSA.decryptBase64(paramString), "AES");
  }
  
  public static void main(String[] paramArrayOfString)
  {
    paramArrayOfString = new SecretKeySpec(RSA.decryptBase64("MTIzNDU2MTIzNDU2MTIzNA=="), "AES");
    try
    {
      Assert.assertEquals("Hello,World", new String(decrypt(encrypt("Hello,World".getBytes(), paramArrayOfString), paramArrayOfString)));
      return;
    }
    catch (Exception paramArrayOfString)
    {
      paramArrayOfString.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\bitapp\utils\AES.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */