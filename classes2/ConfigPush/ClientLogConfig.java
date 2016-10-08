package ConfigPush;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ClientLogConfig
  extends JceStruct
{
  static TimeStamp cache_time_finish;
  static TimeStamp cache_time_start;
  public int cookie;
  public byte loglevel;
  public long lseq;
  public TimeStamp time_finish;
  public TimeStamp time_start;
  public int type;
  
  public ClientLogConfig()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ClientLogConfig(int paramInt1, TimeStamp paramTimeStamp1, TimeStamp paramTimeStamp2, byte paramByte, int paramInt2, long paramLong)
  {
    this.type = paramInt1;
    this.time_start = paramTimeStamp1;
    this.time_finish = paramTimeStamp2;
    this.loglevel = paramByte;
    this.cookie = paramInt2;
    this.lseq = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.type = paramJceInputStream.read(this.type, 1, true);
    if (cache_time_start == null) {
      cache_time_start = new TimeStamp();
    }
    this.time_start = ((TimeStamp)paramJceInputStream.read(cache_time_start, 2, false));
    if (cache_time_finish == null) {
      cache_time_finish = new TimeStamp();
    }
    this.time_finish = ((TimeStamp)paramJceInputStream.read(cache_time_finish, 3, false));
    this.loglevel = paramJceInputStream.read(this.loglevel, 4, false);
    this.cookie = paramJceInputStream.read(this.cookie, 5, false);
    this.lseq = paramJceInputStream.read(this.lseq, 6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.type, 1);
    if (this.time_start != null) {
      paramJceOutputStream.write(this.time_start, 2);
    }
    if (this.time_finish != null) {
      paramJceOutputStream.write(this.time_finish, 3);
    }
    paramJceOutputStream.write(this.loglevel, 4);
    paramJceOutputStream.write(this.cookie, 5);
    paramJceOutputStream.write(this.lseq, 6);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ConfigPush\ClientLogConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */