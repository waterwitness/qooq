package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ResponeBindMobileV2
  extends JceStruct
{
  static byte[] cache_sessionSid;
  public String alreadyBindedUin = "";
  public boolean bindSuccess;
  public byte[] sessionSid;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_sessionSid = (byte[])new byte[1];
    ((byte[])cache_sessionSid)[0] = 0;
  }
  
  public ResponeBindMobileV2() {}
  
  public ResponeBindMobileV2(byte[] paramArrayOfByte, String paramString, boolean paramBoolean)
  {
    this.sessionSid = paramArrayOfByte;
    this.alreadyBindedUin = paramString;
    this.bindSuccess = paramBoolean;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.sessionSid = ((byte[])paramJceInputStream.read(cache_sessionSid, 0, true));
    this.alreadyBindedUin = paramJceInputStream.readString(1, false);
    this.bindSuccess = paramJceInputStream.read(this.bindSuccess, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.sessionSid, 0);
    if (this.alreadyBindedUin != null) {
      paramJceOutputStream.write(this.alreadyBindedUin, 1);
    }
    paramJceOutputStream.write(this.bindSuccess, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\SecurityAccountServer\ResponeBindMobileV2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */