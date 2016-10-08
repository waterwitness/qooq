package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class medal_banner
  extends JceStruct
{
  public String bannerText;
  public int bannerType;
  public String jumpSchema;
  public String jumpUrl;
  public int retcode;
  
  public medal_banner()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.retcode = -1;
    this.bannerText = "";
    this.jumpSchema = "";
    this.jumpUrl = "";
  }
  
  public medal_banner(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    this.retcode = -1;
    this.bannerText = "";
    this.jumpSchema = "";
    this.jumpUrl = "";
    this.retcode = paramInt1;
    this.bannerType = paramInt2;
    this.bannerText = paramString1;
    this.jumpSchema = paramString2;
    this.jumpUrl = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.retcode = paramJceInputStream.read(this.retcode, 0, false);
    this.bannerType = paramJceInputStream.read(this.bannerType, 1, false);
    this.bannerText = paramJceInputStream.readString(2, false);
    this.jumpSchema = paramJceInputStream.readString(3, false);
    this.jumpUrl = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.retcode, 0);
    paramJceOutputStream.write(this.bannerType, 1);
    if (this.bannerText != null) {
      paramJceOutputStream.write(this.bannerText, 2);
    }
    if (this.jumpSchema != null) {
      paramJceOutputStream.write(this.jumpSchema, 3);
    }
    if (this.jumpUrl != null) {
      paramJceOutputStream.write(this.jumpUrl, 4);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_UNDEAL_COUNT\medal_banner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */