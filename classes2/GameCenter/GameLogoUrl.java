package GameCenter;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class GameLogoUrl
  extends JceStruct
{
  public String sAppid;
  public String sGameName;
  public String sLogoMd5;
  public String sLogoName;
  
  public GameLogoUrl()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.sLogoMd5 = "";
    this.sLogoName = "";
    this.sAppid = "";
    this.sGameName = "";
  }
  
  public GameLogoUrl(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.sLogoMd5 = "";
    this.sLogoName = "";
    this.sAppid = "";
    this.sGameName = "";
    this.sLogoMd5 = paramString1;
    this.sLogoName = paramString2;
    this.sAppid = paramString3;
    this.sGameName = paramString4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.sLogoMd5 = paramJceInputStream.readString(0, true);
    this.sLogoName = paramJceInputStream.readString(1, true);
    this.sAppid = paramJceInputStream.readString(2, false);
    this.sGameName = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.sLogoMd5, 0);
    paramJceOutputStream.write(this.sLogoName, 1);
    if (this.sAppid != null) {
      paramJceOutputStream.write(this.sAppid, 2);
    }
    if (this.sGameName != null) {
      paramJceOutputStream.write(this.sGameName, 3);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\GameCenter\GameLogoUrl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */