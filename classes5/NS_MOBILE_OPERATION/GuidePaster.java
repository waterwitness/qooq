package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class GuidePaster
  extends JceStruct
{
  public String pasterId;
  public String url;
  
  public GuidePaster()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.url = "";
    this.pasterId = "";
  }
  
  public GuidePaster(String paramString1, String paramString2)
  {
    this.url = "";
    this.pasterId = "";
    this.url = paramString1;
    this.pasterId = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.url = paramJceInputStream.readString(0, false);
    this.pasterId = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.url != null) {
      paramJceOutputStream.write(this.url, 0);
    }
    if (this.pasterId != null) {
      paramJceOutputStream.write(this.pasterId, 1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_OPERATION\GuidePaster.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */