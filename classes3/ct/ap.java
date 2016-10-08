package ct;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public final class ap
{
  private Cipher a;
  private Cipher b;
  
  public ap(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = new SecretKeySpec(paramArrayOfByte, "AES");
      this.a = Cipher.getInstance("AES/ECB/PKCS5Padding");
      this.a.init(1, paramArrayOfByte);
      this.b = Cipher.getInstance("AES/ECB/PKCS5Padding");
      this.b.init(2, paramArrayOfByte);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      throw new RuntimeException(paramArrayOfByte);
    }
  }
  
  public final byte[] a(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = this.a.doFinal(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      throw new RuntimeException(paramArrayOfByte);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ct\ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */