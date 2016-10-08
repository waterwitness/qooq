package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class mobile_online_report_item
  extends JceStruct
{
  public long downtime;
  public long loginuin;
  public long uptime;
  
  public mobile_online_report_item()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public mobile_online_report_item(long paramLong1, long paramLong2, long paramLong3)
  {
    this.loginuin = paramLong1;
    this.uptime = paramLong2;
    this.downtime = paramLong3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.loginuin = paramJceInputStream.read(this.loginuin, 0, true);
    this.uptime = paramJceInputStream.read(this.uptime, 1, true);
    this.downtime = paramJceInputStream.read(this.downtime, 2, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.loginuin, 0);
    paramJceOutputStream.write(this.uptime, 1);
    paramJceOutputStream.write(this.downtime, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_FEEDS\mobile_online_report_item.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */