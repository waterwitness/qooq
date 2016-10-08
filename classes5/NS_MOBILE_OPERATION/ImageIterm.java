package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ImageIterm
  extends JceStruct
{
  static int cache_type;
  public long height;
  public int type;
  public String url;
  public long width;
  
  public ImageIterm()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.url = "";
    this.type = 0;
  }
  
  public ImageIterm(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    this.url = "";
    this.type = 0;
    this.url = paramString;
    this.width = paramLong1;
    this.height = paramLong2;
    this.type = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.url = paramJceInputStream.readString(0, true);
    this.width = paramJceInputStream.read(this.width, 1, true);
    this.height = paramJceInputStream.read(this.height, 2, true);
    this.type = paramJceInputStream.read(this.type, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.url, 0);
    paramJceOutputStream.write(this.width, 1);
    paramJceOutputStream.write(this.height, 2);
    paramJceOutputStream.write(this.type, 3);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_OPERATION\ImageIterm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */