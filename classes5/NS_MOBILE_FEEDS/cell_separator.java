package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class cell_separator
  extends JceStruct
{
  public int action_type;
  public String action_url;
  public int pic_height;
  public String pic_url;
  public int pic_width;
  
  public cell_separator()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.pic_url = "";
    this.action_url = "";
  }
  
  public cell_separator(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    this.pic_url = "";
    this.action_url = "";
    this.pic_url = paramString1;
    this.action_url = paramString2;
    this.action_type = paramInt1;
    this.pic_width = paramInt2;
    this.pic_height = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.pic_url = paramJceInputStream.readString(0, false);
    this.action_url = paramJceInputStream.readString(1, false);
    this.action_type = paramJceInputStream.read(this.action_type, 2, false);
    this.pic_width = paramJceInputStream.read(this.pic_width, 3, false);
    this.pic_height = paramJceInputStream.read(this.pic_height, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.pic_url != null) {
      paramJceOutputStream.write(this.pic_url, 0);
    }
    if (this.action_url != null) {
      paramJceOutputStream.write(this.action_url, 1);
    }
    paramJceOutputStream.write(this.action_type, 2);
    paramJceOutputStream.write(this.pic_width, 3);
    paramJceOutputStream.write(this.pic_height, 4);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_FEEDS\cell_separator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */