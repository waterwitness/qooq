package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class mobile_sub_setspecial_req
  extends JceStruct
{
  static s_special cache_special = new s_special();
  public int action;
  public s_special special;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public mobile_sub_setspecial_req() {}
  
  public mobile_sub_setspecial_req(int paramInt, s_special params_special)
  {
    this.action = paramInt;
    this.special = params_special;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.action = paramJceInputStream.read(this.action, 0, false);
    this.special = ((s_special)paramJceInputStream.read(cache_special, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.action, 0);
    if (this.special != null) {
      paramJceOutputStream.write(this.special, 1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_MAIN_PAGE\mobile_sub_setspecial_req.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */