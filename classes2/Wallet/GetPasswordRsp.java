package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class GetPasswordRsp
  extends JceStruct
{
  public int checkInterval;
  public int passInterval;
  public String password;
  public int ret;
  
  public GetPasswordRsp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.password = "";
    this.checkInterval = 300;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, true);
    this.password = paramJceInputStream.readString(1, true);
    this.checkInterval = paramJceInputStream.read(this.checkInterval, 2, true);
    this.passInterval = paramJceInputStream.read(this.passInterval, 3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    paramJceOutputStream.write(this.password, 1);
    paramJceOutputStream.write(this.checkInterval, 2);
    paramJceOutputStream.write(this.passInterval, 3);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\Wallet\GetPasswordRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */