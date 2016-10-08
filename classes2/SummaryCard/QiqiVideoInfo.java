package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class QiqiVideoInfo
  extends JceStruct
{
  public long uRoomid;
  
  public QiqiVideoInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public QiqiVideoInfo(long paramLong)
  {
    this.uRoomid = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uRoomid = paramJceInputStream.read(this.uRoomid, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uRoomid, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\SummaryCard\QiqiVideoInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */