package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class stConfNumInfo
  extends JceStruct
{
  public long lConfUin;
  public long uConfMsgSeq;
  public long uMemberMsgSeq;
  
  public stConfNumInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public stConfNumInfo(long paramLong1, long paramLong2, long paramLong3)
  {
    this.lConfUin = paramLong1;
    this.uConfMsgSeq = paramLong2;
    this.uMemberMsgSeq = paramLong3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lConfUin = paramJceInputStream.read(this.lConfUin, 0, true);
    this.uConfMsgSeq = paramJceInputStream.read(this.uConfMsgSeq, 1, true);
    this.uMemberMsgSeq = paramJceInputStream.read(this.uMemberMsgSeq, 2, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lConfUin, 0);
    paramJceOutputStream.write(this.uConfMsgSeq, 1);
    paramJceOutputStream.write(this.uMemberMsgSeq, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\MessageSvcPack\stConfNumInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */