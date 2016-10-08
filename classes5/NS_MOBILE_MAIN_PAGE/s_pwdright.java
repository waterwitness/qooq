package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class s_pwdright
  extends JceStruct
{
  static s_user cache_data;
  public s_user data;
  
  public s_pwdright()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public s_pwdright(s_user params_user)
  {
    this.data = params_user;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_data == null) {
      cache_data = new s_user();
    }
    this.data = ((s_user)paramJceInputStream.read(cache_data, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.data != null) {
      paramJceOutputStream.write(this.data, 0);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_MAIN_PAGE\s_pwdright.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */