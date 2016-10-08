package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class mobile_sub_concern_req
  extends JceStruct
{
  public int isconcern;
  public long objuin;
  public int source;
  
  public mobile_sub_concern_req()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public mobile_sub_concern_req(long paramLong, int paramInt1, int paramInt2)
  {
    this.objuin = paramLong;
    this.isconcern = paramInt1;
    this.source = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.objuin = paramJceInputStream.read(this.objuin, 0, true);
    this.isconcern = paramJceInputStream.read(this.isconcern, 1, true);
    this.source = paramJceInputStream.read(this.source, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.objuin, 0);
    paramJceOutputStream.write(this.isconcern, 1);
    paramJceOutputStream.write(this.source, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_MAIN_PAGE\mobile_sub_concern_req.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */