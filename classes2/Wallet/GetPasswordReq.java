package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class GetPasswordReq
  extends JceStruct
{
  public String MQOS;
  
  public GetPasswordReq()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.MQOS = "";
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.MQOS = paramJceInputStream.readString(0, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.MQOS, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\Wallet\GetPasswordReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */