package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class SvcResponseSetConfMsgRead
  extends JceStruct
{
  public byte cReplyCode;
  public long lConfMsgSeq;
  public long lConfUin;
  public long lMemberMsgSeq;
  public String strResult;
  
  public SvcResponseSetConfMsgRead()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.strResult = "";
  }
  
  public SvcResponseSetConfMsgRead(byte paramByte, String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    this.strResult = "";
    this.cReplyCode = paramByte;
    this.strResult = paramString;
    this.lConfUin = paramLong1;
    this.lMemberMsgSeq = paramLong2;
    this.lConfMsgSeq = paramLong3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cReplyCode = paramJceInputStream.read(this.cReplyCode, 0, true);
    this.strResult = paramJceInputStream.readString(1, true);
    this.lConfUin = paramJceInputStream.read(this.lConfUin, 2, true);
    this.lMemberMsgSeq = paramJceInputStream.read(this.lMemberMsgSeq, 3, true);
    this.lConfMsgSeq = paramJceInputStream.read(this.lConfMsgSeq, 4, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cReplyCode, 0);
    paramJceOutputStream.write(this.strResult, 1);
    paramJceOutputStream.write(this.lConfUin, 2);
    paramJceOutputStream.write(this.lMemberMsgSeq, 3);
    paramJceOutputStream.write(this.lConfMsgSeq, 4);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\MessageSvcPack\SvcResponseSetConfMsgRead.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */