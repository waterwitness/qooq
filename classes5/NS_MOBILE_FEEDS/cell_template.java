package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class cell_template
  extends JceStruct
{
  static int cache_type = 0;
  public int feeds_action_type = 0;
  public String feeds_jmp_url = "";
  public String id = "";
  public int type;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public cell_template() {}
  
  public cell_template(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    this.id = paramString1;
    this.type = paramInt1;
    this.feeds_action_type = paramInt2;
    this.feeds_jmp_url = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.id = paramJceInputStream.readString(0, true);
    this.type = paramJceInputStream.read(this.type, 1, true);
    this.feeds_action_type = paramJceInputStream.read(this.feeds_action_type, 2, false);
    this.feeds_jmp_url = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.id, 0);
    paramJceOutputStream.write(this.type, 1);
    paramJceOutputStream.write(this.feeds_action_type, 2);
    if (this.feeds_jmp_url != null) {
      paramJceOutputStream.write(this.feeds_jmp_url, 3);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_FEEDS\cell_template.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */