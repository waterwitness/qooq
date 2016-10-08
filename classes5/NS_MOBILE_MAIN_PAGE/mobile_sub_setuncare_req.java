package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class mobile_sub_setuncare_req
  extends JceStruct
{
  static s_uncare cache_uncare;
  public int action;
  public s_uncare uncare;
  
  public mobile_sub_setuncare_req()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public mobile_sub_setuncare_req(int paramInt, s_uncare params_uncare)
  {
    this.action = paramInt;
    this.uncare = params_uncare;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.action = paramJceInputStream.read(this.action, 0, false);
    if (cache_uncare == null) {
      cache_uncare = new s_uncare();
    }
    this.uncare = ((s_uncare)paramJceInputStream.read(cache_uncare, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.action, 0);
    if (this.uncare != null) {
      paramJceOutputStream.write(this.uncare, 1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_MAIN_PAGE\mobile_sub_setuncare_req.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */