package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class s_one_game
  extends JceStruct
{
  public String strDesc;
  public String strGameUrl;
  public String strIconUrl;
  public long uCount;
  
  public s_one_game()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.strIconUrl = "";
    this.strDesc = "";
    this.strGameUrl = "";
  }
  
  public s_one_game(long paramLong, String paramString1, String paramString2, String paramString3)
  {
    this.strIconUrl = "";
    this.strDesc = "";
    this.strGameUrl = "";
    this.uCount = paramLong;
    this.strIconUrl = paramString1;
    this.strDesc = paramString2;
    this.strGameUrl = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uCount = paramJceInputStream.read(this.uCount, 0, false);
    this.strIconUrl = paramJceInputStream.readString(1, false);
    this.strDesc = paramJceInputStream.readString(2, false);
    this.strGameUrl = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uCount, 0);
    if (this.strIconUrl != null) {
      paramJceOutputStream.write(this.strIconUrl, 1);
    }
    if (this.strDesc != null) {
      paramJceOutputStream.write(this.strDesc, 2);
    }
    if (this.strGameUrl != null) {
      paramJceOutputStream.write(this.strGameUrl, 3);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_MAIN_PAGE\s_one_game.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */