package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class SCRespUploadStreamMsg
  extends JceStruct
{
  static StreamInfo cache_stStreamInfo;
  public int iSeq;
  public int result;
  public int shMsgSeq;
  public short shResetSeq;
  public short shVersion;
  public StreamInfo stStreamInfo;
  public long uDateTime;
  
  public SCRespUploadStreamMsg()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public SCRespUploadStreamMsg(short paramShort1, int paramInt1, StreamInfo paramStreamInfo, short paramShort2, int paramInt2, long paramLong, int paramInt3)
  {
    this.shVersion = paramShort1;
    this.iSeq = paramInt1;
    this.stStreamInfo = paramStreamInfo;
    this.shResetSeq = paramShort2;
    this.shMsgSeq = paramInt2;
    this.uDateTime = paramLong;
    this.result = paramInt3;
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
    this.shMsgSeq = paramJceInputStream.read(this.shMsgSeq, 4, false);
    this.uDateTime = paramJceInputStream.read(this.uDateTime, 5, false);
    this.result = paramJceInputStream.read(this.result, 6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.shVersion, 0);
    paramJceOutputStream.write(this.iSeq, 1);
    paramJceOutputStream.write(this.stStreamInfo, 2);
    paramJceOutputStream.write(this.shResetSeq, 3);
    paramJceOutputStream.write(this.shMsgSeq, 4);
    paramJceOutputStream.write(this.uDateTime, 5);
    paramJceOutputStream.write(this.result, 6);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\QQService\SCRespUploadStreamMsg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */