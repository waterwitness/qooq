package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class mobile_set_red_key_data_rsp
  extends JceStruct
{
  public int rsp_code;
  public String rsp_msg;
  
  public mobile_set_red_key_data_rsp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.rsp_msg = "";
  }
  
  public mobile_set_red_key_data_rsp(int paramInt, String paramString)
  {
    this.rsp_msg = "";
    this.rsp_code = paramInt;
    this.rsp_msg = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.rsp_code = paramJceInputStream.read(this.rsp_code, 0, true);
    this.rsp_msg = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.rsp_code, 0);
    if (this.rsp_msg != null) {
      paramJceOutputStream.write(this.rsp_msg, 1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_MAIN_PAGE\mobile_set_red_key_data_rsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */