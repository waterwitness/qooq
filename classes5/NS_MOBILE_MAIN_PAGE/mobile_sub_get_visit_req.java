package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class mobile_sub_get_visit_req
  extends JceStruct
{
  public String page;
  public long uin;
  
  public mobile_sub_get_visit_req()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.page = "";
  }
  
  public mobile_sub_get_visit_req(long paramLong, String paramString)
  {
    this.page = "";
    this.uin = paramLong;
    this.page = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    this.page = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    if (this.page != null) {
      paramJceOutputStream.write(this.page, 1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_MAIN_PAGE\mobile_sub_get_visit_req.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */