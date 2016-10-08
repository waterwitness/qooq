package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class CustomCover
  extends JceStruct
{
  public String imageUrl;
  public String thumbUrl;
  
  public CustomCover()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.thumbUrl = "";
    this.imageUrl = "";
  }
  
  public CustomCover(String paramString1, String paramString2)
  {
    this.thumbUrl = "";
    this.imageUrl = "";
    this.thumbUrl = paramString1;
    this.imageUrl = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.thumbUrl = paramJceInputStream.readString(0, false);
    this.imageUrl = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.thumbUrl != null) {
      paramJceOutputStream.write(this.thumbUrl, 0);
    }
    if (this.imageUrl != null) {
      paramJceOutputStream.write(this.imageUrl, 1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_MAIN_PAGE\CustomCover.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */