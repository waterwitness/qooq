package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class feed_host_info
  extends JceStruct
{
  public String actiondesc;
  public String nickname;
  public long uUin;
  
  public feed_host_info()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.nickname = "";
    this.actiondesc = "";
  }
  
  public feed_host_info(long paramLong, String paramString1, String paramString2)
  {
    this.nickname = "";
    this.actiondesc = "";
    this.uUin = paramLong;
    this.nickname = paramString1;
    this.actiondesc = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uUin = paramJceInputStream.read(this.uUin, 0, false);
    this.nickname = paramJceInputStream.readString(1, false);
    this.actiondesc = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uUin, 0);
    if (this.nickname != null) {
      paramJceOutputStream.write(this.nickname, 1);
    }
    if (this.actiondesc != null) {
      paramJceOutputStream.write(this.actiondesc, 2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_UNDEAL_COUNT\feed_host_info.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */