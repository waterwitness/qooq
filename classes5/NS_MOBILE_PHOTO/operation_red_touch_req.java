package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class operation_red_touch_req
  extends JceStruct
{
  public long opera_type;
  
  public operation_red_touch_req()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public operation_red_touch_req(long paramLong)
  {
    this.opera_type = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.opera_type = paramJceInputStream.read(this.opera_type, 0, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.opera_type, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_PHOTO\operation_red_touch_req.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */