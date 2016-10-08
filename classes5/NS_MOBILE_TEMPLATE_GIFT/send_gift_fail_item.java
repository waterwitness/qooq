package NS_MOBILE_TEMPLATE_GIFT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class send_gift_fail_item
  extends JceStruct
{
  public String name;
  public String reason;
  public long uin;
  
  public send_gift_fail_item()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.name = "";
    this.reason = "";
  }
  
  public send_gift_fail_item(long paramLong, String paramString1, String paramString2)
  {
    this.name = "";
    this.reason = "";
    this.uin = paramLong;
    this.name = paramString1;
    this.reason = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.name = paramJceInputStream.readString(1, true);
    this.reason = paramJceInputStream.readString(2, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.name, 1);
    paramJceOutputStream.write(this.reason, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_TEMPLATE_GIFT\send_gift_fail_item.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */