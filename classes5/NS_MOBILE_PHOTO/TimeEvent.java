package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class TimeEvent
  extends JceStruct
{
  public String content;
  public long time;
  public long type;
  
  public TimeEvent()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.content = "";
  }
  
  public TimeEvent(long paramLong1, long paramLong2, String paramString)
  {
    this.content = "";
    this.time = paramLong1;
    this.type = paramLong2;
    this.content = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.time = paramJceInputStream.read(this.time, 0, true);
    this.type = paramJceInputStream.read(this.type, 1, true);
    this.content = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.time, 0);
    paramJceOutputStream.write(this.type, 1);
    if (this.content != null) {
      paramJceOutputStream.write(this.content, 2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_PHOTO\TimeEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */