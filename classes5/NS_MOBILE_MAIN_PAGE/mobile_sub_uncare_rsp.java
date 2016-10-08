package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class mobile_sub_uncare_rsp
  extends JceStruct
{
  static s_uncare cache_uncare;
  public s_uncare uncare;
  
  public mobile_sub_uncare_rsp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public mobile_sub_uncare_rsp(s_uncare params_uncare)
  {
    this.uncare = params_uncare;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_uncare == null) {
      cache_uncare = new s_uncare();
    }
    this.uncare = ((s_uncare)paramJceInputStream.read(cache_uncare, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.uncare != null) {
      paramJceOutputStream.write(this.uncare, 0);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_MAIN_PAGE\mobile_sub_uncare_rsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */