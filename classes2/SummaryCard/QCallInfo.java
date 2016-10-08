package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class QCallInfo
  extends JceStruct
{
  static int cache_bStatus;
  public int bStatus;
  public String strNick;
  public long uQCallId;
  
  public QCallInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.strNick = "";
  }
  
  public QCallInfo(int paramInt, String paramString, long paramLong)
  {
    this.strNick = "";
    this.bStatus = paramInt;
    this.strNick = paramString;
    this.uQCallId = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.bStatus = paramJceInputStream.read(this.bStatus, 0, false);
    this.strNick = paramJceInputStream.readString(1, false);
    this.uQCallId = paramJceInputStream.read(this.uQCallId, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.bStatus, 0);
    if (this.strNick != null) {
      paramJceOutputStream.write(this.strNick, 1);
    }
    paramJceOutputStream.write(this.uQCallId, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\SummaryCard\QCallInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */