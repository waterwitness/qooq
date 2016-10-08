package QQWalletPay;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class RespCheckChangePwdAuth
  extends JceStruct
{
  public int retCode;
  public String retMsg;
  
  public RespCheckChangePwdAuth()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.retMsg = "";
  }
  
  public RespCheckChangePwdAuth(int paramInt, String paramString)
  {
    this.retMsg = "";
    this.retCode = paramInt;
    this.retMsg = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.retCode = paramJceInputStream.read(this.retCode, 0, true);
    this.retMsg = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.retCode, 0);
    if (this.retMsg != null) {
      paramJceOutputStream.write(this.retMsg, 1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\QQWalletPay\RespCheckChangePwdAuth.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */