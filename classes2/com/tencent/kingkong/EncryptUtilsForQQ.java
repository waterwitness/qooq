package com.tencent.kingkong;

import android.util.Base64;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public class EncryptUtilsForQQ
{
  public static final String a = "EncryptUtils";
  public static final String b = "DES/CBC/NoPadding";
  public static final String c = "RSA/ECB/PKCS1Padding";
  public static String d = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQD3ywzb5M1Acw/gPd4869if4PlW\rhH8ekZvuoW3JYzxzeI1Rb5ENlEErZFUFvQrdTtapycinwjtQUHpgJBkAYxe8fI8k\ralWhJxQAOJZxIVPiZcPzGl4kaPkGHonKhT1md+FwoFGfosNbccQ4RcvUT/iSuqPh\rFd9e4fbNnLf9pPf5LQIDAQAB";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String a(String paramString)
  {
    Object localObject = Base64.decode(d, 0);
    localObject = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec((byte[])localObject));
    Cipher localCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
    localCipher.init(1, (Key)localObject);
    return Base64.encodeToString(localCipher.doFinal(paramString.getBytes()), 2);
  }
  
  public static String a(String paramString, int paramInt)
  {
    int j = paramString.length();
    int i = 0;
    while (i < paramInt - j % paramInt)
    {
      paramString = paramString + " ";
      i += 1;
    }
    return paramString;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    paramString1 = new DESKeySpec(paramString1.getBytes());
    paramString1 = SecretKeyFactory.getInstance("DES").generateSecret(paramString1);
    Cipher localCipher = Cipher.getInstance("DES/CBC/NoPadding");
    localCipher.init(1, paramString1, new IvParameterSpec("12345678".getBytes()));
    return Base64.encodeToString(localCipher.doFinal(a(paramString2, localCipher.getBlockSize()).getBytes()), 2);
  }
  
  public static String b(String paramString)
  {
    paramString = Base64.decode(paramString, 0);
    Object localObject = Base64.decode(d, 0);
    localObject = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec((byte[])localObject));
    Cipher localCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
    localCipher.init(2, (Key)localObject);
    return Base64.encodeToString(localCipher.doFinal(paramString), 2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\kingkong\EncryptUtilsForQQ.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */