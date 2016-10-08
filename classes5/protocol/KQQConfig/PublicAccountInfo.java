package protocol.KQQConfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class PublicAccountInfo
  extends JceStruct
{
  public String strContent;
  public String strLinkURL;
  public String strNeighborContent;
  public String strPicURL;
  public String strTitle;
  
  public PublicAccountInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.strPicURL = "";
    this.strLinkURL = "";
    this.strTitle = "";
    this.strContent = "";
    this.strNeighborContent = "";
  }
  
  public PublicAccountInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.strPicURL = "";
    this.strLinkURL = "";
    this.strTitle = "";
    this.strContent = "";
    this.strNeighborContent = "";
    this.strPicURL = paramString1;
    this.strLinkURL = paramString2;
    this.strTitle = paramString3;
    this.strContent = paramString4;
    this.strNeighborContent = paramString5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strPicURL = paramJceInputStream.readString(1, false);
    this.strLinkURL = paramJceInputStream.readString(2, false);
    this.strTitle = paramJceInputStream.readString(3, false);
    this.strContent = paramJceInputStream.readString(4, false);
    this.strNeighborContent = paramJceInputStream.readString(5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.strPicURL != null) {
      paramJceOutputStream.write(this.strPicURL, 1);
    }
    if (this.strLinkURL != null) {
      paramJceOutputStream.write(this.strLinkURL, 2);
    }
    if (this.strTitle != null) {
      paramJceOutputStream.write(this.strTitle, 3);
    }
    if (this.strContent != null) {
      paramJceOutputStream.write(this.strContent, 4);
    }
    if (this.strNeighborContent != null) {
      paramJceOutputStream.write(this.strNeighborContent, 5);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\protocol\KQQConfig\PublicAccountInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */