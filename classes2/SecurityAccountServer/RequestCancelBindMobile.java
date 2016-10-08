package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class RequestCancelBindMobile
  extends JceStruct
{
  public boolean isFromChangeBind;
  public boolean isFromUni;
  public String mobileNo;
  public String nationCode;
  
  public RequestCancelBindMobile()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.nationCode = "";
    this.mobileNo = "";
  }
  
  public RequestCancelBindMobile(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.nationCode = "";
    this.mobileNo = "";
    this.nationCode = paramString1;
    this.mobileNo = paramString2;
    this.isFromUni = paramBoolean1;
    this.isFromChangeBind = paramBoolean2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.nationCode = paramJceInputStream.readString(0, true);
    this.mobileNo = paramJceInputStream.readString(1, true);
    this.isFromUni = paramJceInputStream.read(this.isFromUni, 2, false);
    this.isFromChangeBind = paramJceInputStream.read(this.isFromChangeBind, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.nationCode, 0);
    paramJceOutputStream.write(this.mobileNo, 1);
    paramJceOutputStream.write(this.isFromUni, 2);
    paramJceOutputStream.write(this.isFromChangeBind, 3);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\SecurityAccountServer\RequestCancelBindMobile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */