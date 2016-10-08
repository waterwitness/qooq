package NS_MOBILE_VIDEO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class UrlRsp
  extends JceStruct
{
  public int code;
  public String url;
  public int url_type;
  
  public UrlRsp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.url = "";
  }
  
  public UrlRsp(int paramInt1, String paramString, int paramInt2)
  {
    this.url = "";
    this.code = paramInt1;
    this.url = paramString;
    this.url_type = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.code = paramJceInputStream.read(this.code, 0, false);
    this.url = paramJceInputStream.readString(1, false);
    this.url_type = paramJceInputStream.read(this.url_type, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.code, 0);
    if (this.url != null) {
      paramJceOutputStream.write(this.url, 1);
    }
    paramJceOutputStream.write(this.url_type, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_VIDEO\UrlRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */