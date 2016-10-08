package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class GiftMsg
  extends JceStruct
{
  public String giftLogo;
  public String msg;
  public String nick;
  public String userId;
  
  public GiftMsg()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.userId = "";
    this.nick = "";
    this.msg = "";
    this.giftLogo = "";
  }
  
  public GiftMsg(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.userId = "";
    this.nick = "";
    this.msg = "";
    this.giftLogo = "";
    this.userId = paramString1;
    this.nick = paramString2;
    this.msg = paramString3;
    this.giftLogo = paramString4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.userId = paramJceInputStream.readString(0, false);
    this.nick = paramJceInputStream.readString(1, false);
    this.msg = paramJceInputStream.readString(2, false);
    this.giftLogo = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.userId != null) {
      paramJceOutputStream.write(this.userId, 0);
    }
    if (this.nick != null) {
      paramJceOutputStream.write(this.nick, 1);
    }
    if (this.msg != null) {
      paramJceOutputStream.write(this.msg, 2);
    }
    if (this.giftLogo != null) {
      paramJceOutputStream.write(this.giftLogo, 3);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_FEEDS\GiftMsg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */