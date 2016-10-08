package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ImageSummary
  extends JceStruct
{
  public String bubbleUrl;
  public String imageId;
  public String url;
  
  public ImageSummary()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.imageId = "";
    this.url = "";
    this.bubbleUrl = "";
  }
  
  public ImageSummary(String paramString1, String paramString2, String paramString3)
  {
    this.imageId = "";
    this.url = "";
    this.bubbleUrl = "";
    this.imageId = paramString1;
    this.url = paramString2;
    this.bubbleUrl = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.imageId = paramJceInputStream.readString(0, true);
    this.url = paramJceInputStream.readString(1, false);
    this.bubbleUrl = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.imageId, 0);
    if (this.url != null) {
      paramJceOutputStream.write(this.url, 1);
    }
    if (this.bubbleUrl != null) {
      paramJceOutputStream.write(this.bubbleUrl, 2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_OPERATION\ImageSummary.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */