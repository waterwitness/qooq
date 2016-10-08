package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class mobile_sub_black_rsp
  extends JceStruct
{
  static s_black cache_black;
  public s_black black;
  
  public mobile_sub_black_rsp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public mobile_sub_black_rsp(s_black params_black)
  {
    this.black = params_black;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_black == null) {
      cache_black = new s_black();
    }
    this.black = ((s_black)paramJceInputStream.read(cache_black, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.black != null) {
      paramJceOutputStream.write(this.black, 0);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_MAIN_PAGE\mobile_sub_black_rsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */