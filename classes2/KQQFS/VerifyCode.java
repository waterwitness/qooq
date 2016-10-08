package KQQFS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class VerifyCode
  extends JceStruct
{
  static byte[] cache_vVerifyCode;
  public byte bType;
  public String strPrompt;
  public byte[] vVerifyCode;
  
  public VerifyCode()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.strPrompt = "";
  }
  
  public VerifyCode(byte paramByte, byte[] paramArrayOfByte, String paramString)
  {
    this.strPrompt = "";
    this.bType = paramByte;
    this.vVerifyCode = paramArrayOfByte;
    this.strPrompt = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.bType = paramJceInputStream.read(this.bType, 0, true);
    if (cache_vVerifyCode == null)
    {
      cache_vVerifyCode = (byte[])new byte[1];
      ((byte[])cache_vVerifyCode)[0] = 0;
    }
    this.vVerifyCode = ((byte[])paramJceInputStream.read(cache_vVerifyCode, 1, true));
    this.strPrompt = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.bType, 0);
    paramJceOutputStream.write(this.vVerifyCode, 1);
    if (this.strPrompt != null) {
      paramJceOutputStream.write(this.strPrompt, 2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\KQQFS\VerifyCode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */