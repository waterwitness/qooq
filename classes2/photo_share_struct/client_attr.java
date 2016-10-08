package photo_share_struct;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class client_attr
  extends JceStruct
{
  static int cache_action = 0;
  static uin_attr cache_attr;
  public int action;
  public uin_attr attr;
  public String qq_nick = "";
  public long uin;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_attr = new uin_attr();
  }
  
  public client_attr() {}
  
  public client_attr(long paramLong, uin_attr paramuin_attr, String paramString, int paramInt)
  {
    this.uin = paramLong;
    this.attr = paramuin_attr;
    this.qq_nick = paramString;
    this.action = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    this.attr = ((uin_attr)paramJceInputStream.read(cache_attr, 1, false));
    this.qq_nick = paramJceInputStream.readString(2, false);
    this.action = paramJceInputStream.read(this.action, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    if (this.attr != null) {
      paramJceOutputStream.write(this.attr, 1);
    }
    if (this.qq_nick != null) {
      paramJceOutputStream.write(this.qq_nick, 2);
    }
    paramJceOutputStream.write(this.action, 3);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\photo_share_struct\client_attr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */