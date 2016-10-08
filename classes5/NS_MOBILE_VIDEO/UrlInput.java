package NS_MOBILE_VIDEO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class UrlInput
  extends JceStruct
{
  public String url_detail;
  public int url_type;
  
  public UrlInput()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.url_detail = "";
  }
  
  public UrlInput(int paramInt, String paramString)
  {
    this.url_detail = "";
    this.url_type = paramInt;
    this.url_detail = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.url_type = paramJceInputStream.read(this.url_type, 0, false);
    this.url_detail = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.url_type, 0);
    if (this.url_detail != null) {
      paramJceOutputStream.write(this.url_detail, 1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_VIDEO\UrlInput.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */