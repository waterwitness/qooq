package PushNotifyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class DisMsgReadedNotify
  extends JceStruct
{
  public long lDisMsgSeq;
  public long lDisUin;
  public long lMemberSeq;
  public long lOpType;
  
  public DisMsgReadedNotify()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public DisMsgReadedNotify(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    this.lDisUin = paramLong1;
    this.lOpType = paramLong2;
    this.lMemberSeq = paramLong3;
    this.lDisMsgSeq = paramLong4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lDisUin = paramJceInputStream.read(this.lDisUin, 0, false);
    this.lOpType = paramJceInputStream.read(this.lOpType, 1, false);
    this.lMemberSeq = paramJceInputStream.read(this.lMemberSeq, 2, false);
    this.lDisMsgSeq = paramJceInputStream.read(this.lDisMsgSeq, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lDisUin, 0);
    paramJceOutputStream.write(this.lOpType, 1);
    paramJceOutputStream.write(this.lMemberSeq, 2);
    paramJceOutputStream.write(this.lDisMsgSeq, 3);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\PushNotifyPack\DisMsgReadedNotify.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */