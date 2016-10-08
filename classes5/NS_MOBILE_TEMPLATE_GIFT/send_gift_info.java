package NS_MOBILE_TEMPLATE_GIFT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class send_gift_info
  extends JceStruct
{
  public boolean isTiming;
  public long receiver;
  public String sendTime;
  
  public send_gift_info()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.isTiming = true;
    this.sendTime = "";
  }
  
  public send_gift_info(long paramLong, boolean paramBoolean, String paramString)
  {
    this.isTiming = true;
    this.sendTime = "";
    this.receiver = paramLong;
    this.isTiming = paramBoolean;
    this.sendTime = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.receiver = paramJceInputStream.read(this.receiver, 0, true);
    this.isTiming = paramJceInputStream.read(this.isTiming, 1, true);
    this.sendTime = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.receiver, 0);
    paramJceOutputStream.write(this.isTiming, 1);
    if (this.sendTime != null) {
      paramJceOutputStream.write(this.sendTime, 2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_TEMPLATE_GIFT\send_gift_info.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */