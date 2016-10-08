package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class s_droplist_option
  extends JceStruct
{
  public int actiontype;
  public String iconurl;
  public String jumpurl;
  public String optext;
  public String reportattach;
  public int reporttype;
  
  public s_droplist_option()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.iconurl = "";
    this.optext = "";
    this.jumpurl = "";
    this.reportattach = "";
  }
  
  public s_droplist_option(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, String paramString4)
  {
    this.iconurl = "";
    this.optext = "";
    this.jumpurl = "";
    this.reportattach = "";
    this.iconurl = paramString1;
    this.optext = paramString2;
    this.actiontype = paramInt1;
    this.jumpurl = paramString3;
    this.reporttype = paramInt2;
    this.reportattach = paramString4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iconurl = paramJceInputStream.readString(0, false);
    this.optext = paramJceInputStream.readString(1, false);
    this.actiontype = paramJceInputStream.read(this.actiontype, 2, false);
    this.jumpurl = paramJceInputStream.readString(3, false);
    this.reporttype = paramJceInputStream.read(this.reporttype, 4, false);
    this.reportattach = paramJceInputStream.readString(5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.iconurl != null) {
      paramJceOutputStream.write(this.iconurl, 0);
    }
    if (this.optext != null) {
      paramJceOutputStream.write(this.optext, 1);
    }
    paramJceOutputStream.write(this.actiontype, 2);
    if (this.jumpurl != null) {
      paramJceOutputStream.write(this.jumpurl, 3);
    }
    paramJceOutputStream.write(this.reporttype, 4);
    if (this.reportattach != null) {
      paramJceOutputStream.write(this.reportattach, 5);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_FEEDS\s_droplist_option.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */