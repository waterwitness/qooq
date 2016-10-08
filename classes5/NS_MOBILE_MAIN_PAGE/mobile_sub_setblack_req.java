package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class mobile_sub_setblack_req
  extends JceStruct
{
  static s_black cache_black;
  public int action;
  public s_black black;
  
  public mobile_sub_setblack_req()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public mobile_sub_setblack_req(int paramInt, s_black params_black)
  {
    this.action = paramInt;
    this.black = params_black;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.action = paramJceInputStream.read(this.action, 0, false);
    if (cache_black == null) {
      cache_black = new s_black();
    }
    this.black = ((s_black)paramJceInputStream.read(cache_black, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.action, 0);
    if (this.black != null) {
      paramJceOutputStream.write(this.black, 1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_MAIN_PAGE\mobile_sub_setblack_req.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */