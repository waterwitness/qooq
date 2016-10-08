package FEEDS_RECOM_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class mobile_recom_report_rsp
  extends JceStruct
{
  public String error_msg;
  public int ret_code;
  
  public mobile_recom_report_rsp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.error_msg = "";
  }
  
  public mobile_recom_report_rsp(int paramInt, String paramString)
  {
    this.error_msg = "";
    this.ret_code = paramInt;
    this.error_msg = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret_code = paramJceInputStream.read(this.ret_code, 0, false);
    this.error_msg = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret_code, 0);
    if (this.error_msg != null) {
      paramJceOutputStream.write(this.error_msg, 1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\FEEDS_RECOM_REPORT\mobile_recom_report_rsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */