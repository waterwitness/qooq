package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class login_uin_info
  extends JceStruct
{
  public String nickname;
  
  public login_uin_info()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.nickname = "";
  }
  
  public login_uin_info(String paramString)
  {
    this.nickname = "";
    this.nickname = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.nickname = paramJceInputStream.readString(0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.nickname != null) {
      paramJceOutputStream.write(this.nickname, 0);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_FEEDS\login_uin_info.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */