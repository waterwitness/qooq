package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class cell_recomm_header
  extends JceStruct
{
  public byte btn_type;
  public String custom_icon;
  public String desc;
  public int icon_height;
  public int icon_width;
  public String left_title;
  public String right_title;
  
  public cell_recomm_header()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.left_title = "";
    this.right_title = "";
    this.custom_icon = "";
    this.desc = "";
  }
  
  public cell_recomm_header(String paramString1, byte paramByte, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4)
  {
    this.left_title = "";
    this.right_title = "";
    this.custom_icon = "";
    this.desc = "";
    this.left_title = paramString1;
    this.btn_type = paramByte;
    this.right_title = paramString2;
    this.custom_icon = paramString3;
    this.icon_width = paramInt1;
    this.icon_height = paramInt2;
    this.desc = paramString4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.left_title = paramJceInputStream.readString(0, false);
    this.btn_type = paramJceInputStream.read(this.btn_type, 1, false);
    this.right_title = paramJceInputStream.readString(2, false);
    this.custom_icon = paramJceInputStream.readString(3, false);
    this.icon_width = paramJceInputStream.read(this.icon_width, 4, false);
    this.icon_height = paramJceInputStream.read(this.icon_height, 5, false);
    this.desc = paramJceInputStream.readString(6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.left_title != null) {
      paramJceOutputStream.write(this.left_title, 0);
    }
    paramJceOutputStream.write(this.btn_type, 1);
    if (this.right_title != null) {
      paramJceOutputStream.write(this.right_title, 2);
    }
    if (this.custom_icon != null) {
      paramJceOutputStream.write(this.custom_icon, 3);
    }
    paramJceOutputStream.write(this.icon_width, 4);
    paramJceOutputStream.write(this.icon_height, 5);
    if (this.desc != null) {
      paramJceOutputStream.write(this.desc, 6);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_FEEDS\cell_recomm_header.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */