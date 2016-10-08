package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ResponseVerifyWTLogin
  extends JceStruct
{
  public long preBindUin;
  
  public ResponseVerifyWTLogin()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ResponseVerifyWTLogin(long paramLong)
  {
    this.preBindUin = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.preBindUin = paramJceInputStream.read(this.preBindUin, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.preBindUin, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\SecurityAccountServer\ResponseVerifyWTLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */