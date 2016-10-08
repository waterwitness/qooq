package photo_share_struct;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class pic_host
  extends JceStruct
{
  public String nick;
  public long uin;
  
  public pic_host()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.nick = "";
  }
  
  public pic_host(long paramLong, String paramString)
  {
    this.nick = "";
    this.uin = paramLong;
    this.nick = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    this.nick = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    if (this.nick != null) {
      paramJceOutputStream.write(this.nick, 1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\photo_share_struct\pic_host.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */