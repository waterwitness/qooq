package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class s_red_info
  extends JceStruct
{
  public String desc;
  public String logo;
  public String summary;
  public long uIsNew;
  public long uin;
  
  public s_red_info()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.logo = "";
    this.summary = "";
    this.desc = "";
  }
  
  public s_red_info(String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2)
  {
    this.logo = "";
    this.summary = "";
    this.desc = "";
    this.logo = paramString1;
    this.summary = paramString2;
    this.desc = paramString3;
    this.uIsNew = paramLong1;
    this.uin = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.logo = paramJceInputStream.readString(0, false);
    this.summary = paramJceInputStream.readString(1, false);
    this.desc = paramJceInputStream.readString(2, false);
    this.uIsNew = paramJceInputStream.read(this.uIsNew, 3, false);
    this.uin = paramJceInputStream.read(this.uin, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.logo != null) {
      paramJceOutputStream.write(this.logo, 0);
    }
    if (this.summary != null) {
      paramJceOutputStream.write(this.summary, 1);
    }
    if (this.desc != null) {
      paramJceOutputStream.write(this.desc, 2);
    }
    paramJceOutputStream.write(this.uIsNew, 3);
    paramJceOutputStream.write(this.uin, 4);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_MAIN_PAGE\s_red_info.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */