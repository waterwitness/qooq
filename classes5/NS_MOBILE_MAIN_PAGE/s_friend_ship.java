package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class s_friend_ship
  extends JceStruct
{
  public int intimacyScore;
  public String url;
  
  public s_friend_ship()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.url = "";
  }
  
  public s_friend_ship(int paramInt, String paramString)
  {
    this.url = "";
    this.intimacyScore = paramInt;
    this.url = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.intimacyScore = paramJceInputStream.read(this.intimacyScore, 0, false);
    this.url = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.intimacyScore, 0);
    if (this.url != null) {
      paramJceOutputStream.write(this.url, 1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_MAIN_PAGE\s_friend_ship.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */