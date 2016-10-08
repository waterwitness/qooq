package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class RequestResendSmscode
  extends JceStruct
{
  static byte[] cache_sessionSid;
  public byte[] sessionSid;
  
  public RequestResendSmscode()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public RequestResendSmscode(byte[] paramArrayOfByte)
  {
    this.sessionSid = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_sessionSid == null)
    {
      cache_sessionSid = (byte[])new byte[1];
      ((byte[])cache_sessionSid)[0] = 0;
    }
    this.sessionSid = ((byte[])paramJceInputStream.read(cache_sessionSid, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.sessionSid, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\SecurityAccountServer\RequestResendSmscode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */