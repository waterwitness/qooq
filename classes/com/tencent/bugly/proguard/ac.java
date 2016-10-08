package com.tencent.bugly.proguard;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public final class ac
  implements ad
{
  private String a = null;
  
  public final void a(String paramString)
  {
    if (paramString != null) {
      this.a = paramString;
    }
  }
  
  public final byte[] a(byte[] paramArrayOfByte)
    throws Exception
  {
    if ((this.a == null) || (paramArrayOfByte == null)) {
      return null;
    }
    Cipher localCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
    DESKeySpec localDESKeySpec = new DESKeySpec(this.a.getBytes("UTF-8"));
    localCipher.init(2, SecretKeyFactory.getInstance("DES").generateSecret(localDESKeySpec), new IvParameterSpec(this.a.getBytes("UTF-8")));
    return localCipher.doFinal(paramArrayOfByte);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\bugly\proguard\ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */