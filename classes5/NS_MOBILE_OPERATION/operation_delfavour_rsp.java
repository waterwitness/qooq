package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class operation_delfavour_rsp
  extends JceStruct
{
  public String error_msg;
  public int ret;
  
  public operation_delfavour_rsp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.error_msg = "";
  }
  
  public operation_delfavour_rsp(int paramInt, String paramString)
  {
    this.error_msg = "";
    this.ret = paramInt;
    this.error_msg = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, false);
    this.error_msg = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    if (this.error_msg != null) {
      paramJceOutputStream.write(this.error_msg, 1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_OPERATION\operation_delfavour_rsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */