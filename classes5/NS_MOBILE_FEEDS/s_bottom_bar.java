package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class s_bottom_bar
  extends JceStruct
{
  public int actiontype;
  public String desc;
  public String jump_url;
  
  public s_bottom_bar()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.desc = "";
    this.jump_url = "";
  }
  
  public s_bottom_bar(int paramInt, String paramString1, String paramString2)
  {
    this.desc = "";
    this.jump_url = "";
    this.actiontype = paramInt;
    this.desc = paramString1;
    this.jump_url = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.actiontype = paramJceInputStream.read(this.actiontype, 0, false);
    this.desc = paramJceInputStream.readString(1, false);
    this.jump_url = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.actiontype, 0);
    if (this.desc != null) {
      paramJceOutputStream.write(this.desc, 1);
    }
    if (this.jump_url != null) {
      paramJceOutputStream.write(this.jump_url, 2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_FEEDS\s_bottom_bar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */