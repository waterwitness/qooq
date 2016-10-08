package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class operation_publishmood_rsp
  extends JceStruct
{
  public String msg;
  public int ret;
  public String tid;
  public String verifyurl;
  
  public operation_publishmood_rsp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.verifyurl = "";
    this.tid = "";
    this.msg = "";
  }
  
  public operation_publishmood_rsp(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.verifyurl = "";
    this.tid = "";
    this.msg = "";
    this.ret = paramInt;
    this.verifyurl = paramString1;
    this.tid = paramString2;
    this.msg = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, false);
    this.verifyurl = paramJceInputStream.readString(1, false);
    this.tid = paramJceInputStream.readString(2, false);
    this.msg = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    if (this.verifyurl != null) {
      paramJceOutputStream.write(this.verifyurl, 1);
    }
    if (this.tid != null) {
      paramJceOutputStream.write(this.tid, 2);
    }
    if (this.msg != null) {
      paramJceOutputStream.write(this.msg, 3);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_OPERATION\operation_publishmood_rsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */