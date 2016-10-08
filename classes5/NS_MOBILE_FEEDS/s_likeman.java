package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class s_likeman
  extends JceStruct
{
  static s_user cache_user = new s_user();
  public String refer = "";
  public int superflag;
  public s_user user;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public s_likeman() {}
  
  public s_likeman(s_user params_user, String paramString, int paramInt)
  {
    this.user = params_user;
    this.refer = paramString;
    this.superflag = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.user = ((s_user)paramJceInputStream.read(cache_user, 0, false));
    this.refer = paramJceInputStream.readString(1, false);
    this.superflag = paramJceInputStream.read(this.superflag, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.user != null) {
      paramJceOutputStream.write(this.user, 0);
    }
    if (this.refer != null) {
      paramJceOutputStream.write(this.refer, 1);
    }
    paramJceOutputStream.write(this.superflag, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_FEEDS\s_likeman.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */