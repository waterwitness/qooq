package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class RequestReBindMblWTLogin
  extends JceStruct
{
  static byte[] cache_encryptBuffer;
  public byte[] encryptBuffer;
  
  public RequestReBindMblWTLogin()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public RequestReBindMblWTLogin(byte[] paramArrayOfByte)
  {
    this.encryptBuffer = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_encryptBuffer == null)
    {
      cache_encryptBuffer = (byte[])new byte[1];
      ((byte[])cache_encryptBuffer)[0] = 0;
    }
    this.encryptBuffer = ((byte[])paramJceInputStream.read(cache_encryptBuffer, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.encryptBuffer, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\SecurityAccountServer\RequestReBindMblWTLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */