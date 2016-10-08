package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class StreamInfo
  extends JceStruct
{
  static int cache_type;
  public String fileKey;
  public int iMsgId;
  public int iSendTime;
  public long lFromUIN;
  public long lToUIN;
  public int msgSeq;
  public long msgTime;
  public long netType;
  public short oprType;
  public long pttFormat;
  public long pttTime;
  public byte pttTransFlag;
  public long random;
  public short shFlowLayer;
  public short shPackNum;
  public int type;
  
  public StreamInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.fileKey = "";
    this.netType = 255L;
  }
  
  public StreamInfo(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, short paramShort1, short paramShort2, short paramShort3, byte paramByte, String paramString, long paramLong3, int paramInt4, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    this.fileKey = "";
    this.netType = 255L;
    this.lFromUIN = paramLong1;
    this.lToUIN = paramLong2;
    this.iMsgId = paramInt1;
    this.type = paramInt2;
    this.iSendTime = paramInt3;
    this.shPackNum = paramShort1;
    this.shFlowLayer = paramShort2;
    this.oprType = paramShort3;
    this.pttTransFlag = paramByte;
    this.fileKey = paramString;
    this.msgTime = paramLong3;
    this.msgSeq = paramInt4;
    this.random = paramLong4;
    this.pttTime = paramLong5;
    this.pttFormat = paramLong6;
    this.netType = paramLong7;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lFromUIN = paramJceInputStream.read(this.lFromUIN, 0, true);
    this.lToUIN = paramJceInputStream.read(this.lToUIN, 1, true);
    this.iMsgId = paramJceInputStream.read(this.iMsgId, 2, true);
    this.type = paramJceInputStream.read(this.type, 3, true);
    this.iSendTime = paramJceInputStream.read(this.iSendTime, 4, true);
    this.shPackNum = paramJceInputStream.read(this.shPackNum, 5, true);
    this.shFlowLayer = paramJceInputStream.read(this.shFlowLayer, 6, true);
    this.oprType = paramJceInputStream.read(this.oprType, 7, false);
    this.pttTransFlag = paramJceInputStream.read(this.pttTransFlag, 8, false);
    this.fileKey = paramJceInputStream.readString(9, false);
    this.msgTime = paramJceInputStream.read(this.msgTime, 10, false);
    this.msgSeq = paramJceInputStream.read(this.msgSeq, 11, false);
    this.random = paramJceInputStream.read(this.random, 12, false);
    this.pttTime = paramJceInputStream.read(this.pttTime, 13, false);
    this.pttFormat = paramJceInputStream.read(this.pttFormat, 14, false);
    this.netType = paramJceInputStream.read(this.netType, 15, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lFromUIN, 0);
    paramJceOutputStream.write(this.lToUIN, 1);
    paramJceOutputStream.write(this.iMsgId, 2);
    paramJceOutputStream.write(this.type, 3);
    paramJceOutputStream.write(this.iSendTime, 4);
    paramJceOutputStream.write(this.shPackNum, 5);
    paramJceOutputStream.write(this.shFlowLayer, 6);
    paramJceOutputStream.write(this.oprType, 7);
    paramJceOutputStream.write(this.pttTransFlag, 8);
    if (this.fileKey != null) {
      paramJceOutputStream.write(this.fileKey, 9);
    }
    paramJceOutputStream.write(this.msgTime, 10);
    paramJceOutputStream.write(this.msgSeq, 11);
    paramJceOutputStream.write(this.random, 12);
    paramJceOutputStream.write(this.pttTime, 13);
    paramJceOutputStream.write(this.pttFormat, 14);
    paramJceOutputStream.write(this.netType, 15);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\QQService\StreamInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */