package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class mobile_sub_del_friendreq_req
  extends JceStruct
{
  public long fuin;
  
  public mobile_sub_del_friendreq_req()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public mobile_sub_del_friendreq_req(long paramLong)
  {
    this.fuin = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.fuin = paramJceInputStream.read(this.fuin, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.fuin, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_MAIN_PAGE\mobile_sub_del_friendreq_req.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */