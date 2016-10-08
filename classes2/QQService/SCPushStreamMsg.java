package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class SCPushStreamMsg
  extends JceStruct
{
  static StreamData cache_stStreamData;
  static StreamInfo cache_stStreamInfo;
  public long bubbleID;
  public int iSeq;
  public long lKey;
  public short shVersion;
  public StreamData stStreamData;
  public StreamInfo stStreamInfo;
  public long uPcQQStatus;
  
  public SCPushStreamMsg()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public SCPushStreamMsg(short paramShort, int paramInt, StreamInfo paramStreamInfo, StreamData paramStreamData, long paramLong1, long paramLong2, long paramLong3)
  {
    this.shVersion = paramShort;
    this.iSeq = paramInt;
    this.stStreamInfo = paramStreamInfo;
    this.stStreamData = paramStreamData;
    this.lKey = paramLong1;
    this.bubbleID = paramLong2;
    this.uPcQQStatus = paramLong3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.shVersion = paramJceInputStream.read(this.shVersion, 0, true);
    this.iSeq = paramJceInputStream.read(this.iSeq, 1, true);
    if (cache_stStreamInfo == null) {
      cache_stStreamInfo = new StreamInfo();
    }
    this.stStreamInfo = ((StreamInfo)paramJceInputStream.read(cache_stStreamInfo, 2, true));
    if (cache_stStreamData == null) {
      cache_stStreamData = new StreamData();
    }
    this.stStreamData = ((StreamData)paramJceInputStream.read(cache_stStreamData, 3, true));
    this.lKey = paramJceInputStream.read(this.lKey, 4, true);
    this.bubbleID = paramJceInputStream.read(this.bubbleID, 5, false);
    this.uPcQQStatus = paramJceInputStream.read(this.uPcQQStatus, 6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.shVersion, 0);
    paramJceOutputStream.write(this.iSeq, 1);
    paramJceOutputStream.write(this.stStreamInfo, 2);
    paramJceOutputStream.write(this.stStreamData, 3);
    paramJceOutputStream.write(this.lKey, 4);
    paramJceOutputStream.write(this.bubbleID, 5);
    paramJceOutputStream.write(this.uPcQQStatus, 6);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\QQService\SCPushStreamMsg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */