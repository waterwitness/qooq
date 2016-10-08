package KQQFS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class RefreshVerifyCode
  extends JceStruct
{
  static byte[] cache_vEncryptUsrInfo;
  public byte bType;
  public byte[] vEncryptUsrInfo;
  
  public RefreshVerifyCode()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public RefreshVerifyCode(byte[] paramArrayOfByte, byte paramByte)
  {
    this.vEncryptUsrInfo = paramArrayOfByte;
    this.bType = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vEncryptUsrInfo == null)
    {
      cache_vEncryptUsrInfo = (byte[])new byte[1];
      ((byte[])cache_vEncryptUsrInfo)[0] = 0;
    }
    this.vEncryptUsrInfo = ((byte[])paramJceInputStream.read(cache_vEncryptUsrInfo, 0, true));
    this.bType = paramJceInputStream.read(this.bType, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vEncryptUsrInfo, 0);
    paramJceOutputStream.write(this.bType, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\KQQFS\RefreshVerifyCode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */