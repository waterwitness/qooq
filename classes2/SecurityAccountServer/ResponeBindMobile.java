package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ResponeBindMobile
  extends JceStruct
{
  static byte[] cache_sessionSid;
  public String alreadyBindedUin;
  public byte[] sessionSid;
  
  public ResponeBindMobile()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.alreadyBindedUin = "";
  }
  
  public ResponeBindMobile(byte[] paramArrayOfByte, String paramString)
  {
    this.alreadyBindedUin = "";
    this.sessionSid = paramArrayOfByte;
    this.alreadyBindedUin = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_sessionSid == null)
    {
      cache_sessionSid = (byte[])new byte[1];
      ((byte[])cache_sessionSid)[0] = 0;
    }
    this.sessionSid = ((byte[])paramJceInputStream.read(cache_sessionSid, 0, true));
    this.alreadyBindedUin = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.sessionSid, 0);
    if (this.alreadyBindedUin != null) {
      paramJceOutputStream.write(this.alreadyBindedUin, 1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\SecurityAccountServer\ResponeBindMobile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */