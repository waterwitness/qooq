package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class mobile_sub_getspaceright_req
  extends JceStruct
{
  public int getDetail;
  public long uin;
  
  public mobile_sub_getspaceright_req()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public mobile_sub_getspaceright_req(long paramLong, int paramInt)
  {
    this.uin = paramLong;
    this.getDetail = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.getDetail = paramJceInputStream.read(this.getDetail, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.getDetail, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_MAIN_PAGE\mobile_sub_getspaceright_req.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */