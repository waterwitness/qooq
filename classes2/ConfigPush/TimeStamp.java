package ConfigPush;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class TimeStamp
  extends JceStruct
{
  public byte day;
  public byte hour;
  public byte month;
  public int year;
  
  public TimeStamp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public TimeStamp(int paramInt, byte paramByte1, byte paramByte2, byte paramByte3)
  {
    this.year = paramInt;
    this.month = paramByte1;
    this.day = paramByte2;
    this.hour = paramByte3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.year = paramJceInputStream.read(this.year, 1, true);
    this.month = paramJceInputStream.read(this.month, 2, true);
    this.day = paramJceInputStream.read(this.day, 3, true);
    this.hour = paramJceInputStream.read(this.hour, 4, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.year, 1);
    paramJceOutputStream.write(this.month, 2);
    paramJceOutputStream.write(this.day, 3);
    paramJceOutputStream.write(this.hour, 4);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ConfigPush\TimeStamp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */