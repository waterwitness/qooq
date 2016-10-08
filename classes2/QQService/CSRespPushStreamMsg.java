package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class CSRespPushStreamMsg
  extends JceStruct
{
  static StreamInfo cache_stStreamInfo;
  public int iSeq;
  public long lKey;
  public short shResetSeq;
  public short shVersion;
  public StreamInfo stStreamInfo;
  
  public CSRespPushStreamMsg()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public CSRespPushStreamMsg(short paramShort1, int paramInt, StreamInfo paramStreamInfo, short paramShort2, long paramLong)
  {
    this.shVersion = paramShort1;
    this.iSeq = paramInt;
    this.stStreamInfo = paramStreamInfo;
    this.shResetSeq = paramShort2;
    this.lKey = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.shVersion = paramJceInputStream.read(this.shVersion, 0, true);
    this.iSeq = paramJceInputStream.read(this.iSeq, 1, true);
    if (cache_stStreamInfo == null) {
      cache_stStreamInfo = new StreamInfo();
    }
    this.stStreamInfo = ((StreamInfo)paramJceInputStream.read(cache_stStreamInfo, 2, true));
    this.shResetSeq = paramJceInputStream.read(this.shResetSeq, 3, true);
    this.lKey = paramJceInputStream.read(this.lKey, 4, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.shVersion, 0);
    paramJceOutputStream.write(this.iSeq, 1);
    paramJceOutputStream.write(this.stStreamInfo, 2);
    paramJceOutputStream.write(this.shResetSeq, 3);
    paramJceOutputStream.write(this.lKey, 4);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\QQService\CSRespPushStreamMsg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */