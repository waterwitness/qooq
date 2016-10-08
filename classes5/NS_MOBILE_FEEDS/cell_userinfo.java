package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class cell_userinfo
  extends JceStruct
{
  static s_user cache_user = new s_user();
  public String action_desc = "";
  public int actiontype = 5;
  public s_user user;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public cell_userinfo() {}
  
  public cell_userinfo(s_user params_user, String paramString, int paramInt)
  {
    this.user = params_user;
    this.action_desc = paramString;
    this.actiontype = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.user = ((s_user)paramJceInputStream.read(cache_user, 0, false));
    this.action_desc = paramJceInputStream.readString(1, false);
    this.actiontype = paramJceInputStream.read(this.actiontype, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.user != null) {
      paramJceOutputStream.write(this.user, 0);
    }
    if (this.action_desc != null) {
      paramJceOutputStream.write(this.action_desc, 1);
    }
    paramJceOutputStream.write(this.actiontype, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_FEEDS\cell_userinfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */