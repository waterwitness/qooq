package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class s_videourl
  extends JceStruct
{
  public String url;
  
  public s_videourl()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.url = "";
  }
  
  public s_videourl(String paramString)
  {
    this.url = "";
    this.url = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.url = paramJceInputStream.readString(0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.url != null) {
      paramJceOutputStream.write(this.url, 0);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_FEEDS\s_videourl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */