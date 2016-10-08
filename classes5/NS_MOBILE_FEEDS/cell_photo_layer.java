package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class cell_photo_layer
  extends JceStruct
{
  public String button_text;
  public String layer_text;
  public String layer_title;
  public int opmask;
  
  public cell_photo_layer()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.layer_title = "";
    this.layer_text = "";
    this.button_text = "";
  }
  
  public cell_photo_layer(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.layer_title = "";
    this.layer_text = "";
    this.button_text = "";
    this.opmask = paramInt;
    this.layer_title = paramString1;
    this.layer_text = paramString2;
    this.button_text = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.opmask = paramJceInputStream.read(this.opmask, 0, false);
    this.layer_title = paramJceInputStream.readString(1, false);
    this.layer_text = paramJceInputStream.readString(2, false);
    this.button_text = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.opmask, 0);
    if (this.layer_title != null) {
      paramJceOutputStream.write(this.layer_title, 1);
    }
    if (this.layer_text != null) {
      paramJceOutputStream.write(this.layer_text, 2);
    }
    if (this.button_text != null) {
      paramJceOutputStream.write(this.button_text, 3);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_FEEDS\cell_photo_layer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */