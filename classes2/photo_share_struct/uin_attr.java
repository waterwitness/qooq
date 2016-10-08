package photo_share_struct;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class uin_attr
  extends JceStruct
{
  static int cache_status = 0;
  public long add_time;
  public String nick = "";
  public byte priv = 3;
  public String share_albumid = "";
  public int status = 0;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public uin_attr() {}
  
  public uin_attr(int paramInt, String paramString1, byte paramByte, String paramString2, long paramLong)
  {
    this.status = paramInt;
    this.nick = paramString1;
    this.priv = paramByte;
    this.share_albumid = paramString2;
    this.add_time = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.status = paramJceInputStream.read(this.status, 0, false);
    this.nick = paramJceInputStream.readString(1, false);
    this.priv = paramJceInputStream.read(this.priv, 2, false);
    this.share_albumid = paramJceInputStream.readString(3, false);
    this.add_time = paramJceInputStream.read(this.add_time, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.status, 0);
    if (this.nick != null) {
      paramJceOutputStream.write(this.nick, 1);
    }
    paramJceOutputStream.write(this.priv, 2);
    if (this.share_albumid != null) {
      paramJceOutputStream.write(this.share_albumid, 3);
    }
    paramJceOutputStream.write(this.add_time, 4);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\photo_share_struct\uin_attr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */