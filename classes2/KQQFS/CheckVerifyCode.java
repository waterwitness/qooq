package KQQFS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class CheckVerifyCode
  extends JceStruct
{
  static byte[] cache_vEncryptUsrInfo;
  public String strVerifyCode;
  public byte[] vEncryptUsrInfo;
  
  public CheckVerifyCode()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.strVerifyCode = "";
  }
  
  public CheckVerifyCode(byte[] paramArrayOfByte, String paramString)
  {
    this.strVerifyCode = "";
    this.vEncryptUsrInfo = paramArrayOfByte;
    this.strVerifyCode = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vEncryptUsrInfo == null)
    {
      cache_vEncryptUsrInfo = (byte[])new byte[1];
      ((byte[])cache_vEncryptUsrInfo)[0] = 0;
    }
    this.vEncryptUsrInfo = ((byte[])paramJceInputStream.read(cache_vEncryptUsrInfo, 0, true));
    this.strVerifyCode = paramJceInputStream.readString(1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vEncryptUsrInfo, 0);
    paramJceOutputStream.write(this.strVerifyCode, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\KQQFS\CheckVerifyCode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */