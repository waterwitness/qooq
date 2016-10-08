package NS_QZONE_FESTIVAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class FestivalGetReqItem
  extends JceStruct
{
  public long mdays;
  public long month;
  public long time;
  public long type;
  public long year;
  
  public FestivalGetReqItem()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public FestivalGetReqItem(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
  {
    this.time = paramLong1;
    this.year = paramLong2;
    this.month = paramLong3;
    this.mdays = paramLong4;
    this.type = paramLong5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.time = paramJceInputStream.read(this.time, 0, false);
    this.year = paramJceInputStream.read(this.year, 1, false);
    this.month = paramJceInputStream.read(this.month, 2, false);
    this.mdays = paramJceInputStream.read(this.mdays, 3, false);
    this.type = paramJceInputStream.read(this.type, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.time, 0);
    paramJceOutputStream.write(this.year, 1);
    paramJceOutputStream.write(this.month, 2);
    paramJceOutputStream.write(this.mdays, 3);
    paramJceOutputStream.write(this.type, 4);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\NS_QZONE_FESTIVAL\FestivalGetReqItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */