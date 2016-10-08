package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class s_picurl
  extends JceStruct
{
  public int enlarge_rate;
  public int focus_x;
  public int focus_y;
  public int height;
  public String url;
  public int width;
  
  public s_picurl()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.url = "";
    this.enlarge_rate = 200;
  }
  
  public s_picurl(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.url = "";
    this.enlarge_rate = 200;
    this.url = paramString;
    this.width = paramInt1;
    this.height = paramInt2;
    this.focus_x = paramInt3;
    this.focus_y = paramInt4;
    this.enlarge_rate = paramInt5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.url = paramJceInputStream.readString(0, false);
    this.width = paramJceInputStream.read(this.width, 1, false);
    this.height = paramJceInputStream.read(this.height, 2, false);
    this.focus_x = paramJceInputStream.read(this.focus_x, 3, false);
    this.focus_y = paramJceInputStream.read(this.focus_y, 4, false);
    this.enlarge_rate = paramJceInputStream.read(this.enlarge_rate, 5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.url != null) {
      paramJceOutputStream.write(this.url, 0);
    }
    paramJceOutputStream.write(this.width, 1);
    paramJceOutputStream.write(this.height, 2);
    paramJceOutputStream.write(this.focus_x, 3);
    paramJceOutputStream.write(this.focus_y, 4);
    paramJceOutputStream.write(this.enlarge_rate, 5);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_FEEDS\s_picurl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */