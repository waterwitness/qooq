package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class RequestDisableMobileBind
  extends JceStruct
{
  public String mobileNo;
  public String nationCode;
  
  public RequestDisableMobileBind()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.nationCode = "";
    this.mobileNo = "";
  }
  
  public RequestDisableMobileBind(String paramString1, String paramString2)
  {
    this.nationCode = "";
    this.mobileNo = "";
    this.nationCode = paramString1;
    this.mobileNo = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.nationCode = paramJceInputStream.readString(0, true);
    this.mobileNo = paramJceInputStream.readString(1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.nationCode, 0);
    paramJceOutputStream.write(this.mobileNo, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\SecurityAccountServer\RequestDisableMobileBind.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */