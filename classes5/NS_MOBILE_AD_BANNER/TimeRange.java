package NS_MOBILE_AD_BANNER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class TimeRange
  extends JceStruct
{
  public long iTimeBegin;
  public long iTimeEnd;
  
  public TimeRange()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public TimeRange(long paramLong1, long paramLong2)
  {
    this.iTimeBegin = paramLong1;
    this.iTimeEnd = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iTimeBegin = paramJceInputStream.read(this.iTimeBegin, 0, true);
    this.iTimeEnd = paramJceInputStream.read(this.iTimeEnd, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iTimeBegin, 0);
    paramJceOutputStream.write(this.iTimeEnd, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_AD_BANNER\TimeRange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */