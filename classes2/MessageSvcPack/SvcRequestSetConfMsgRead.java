package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class SvcRequestSetConfMsgRead
  extends JceStruct
{
  public byte cVerifyType;
  public long lConfUin;
  public long lLastReadSeq;
  
  public SvcRequestSetConfMsgRead()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public SvcRequestSetConfMsgRead(long paramLong1, long paramLong2, byte paramByte)
  {
    this.lConfUin = paramLong1;
    this.lLastReadSeq = paramLong2;
    this.cVerifyType = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lConfUin = paramJceInputStream.read(this.lConfUin, 0, true);
    this.lLastReadSeq = paramJceInputStream.read(this.lLastReadSeq, 1, true);
    this.cVerifyType = paramJceInputStream.read(this.cVerifyType, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lConfUin, 0);
    paramJceOutputStream.write(this.lLastReadSeq, 1);
    paramJceOutputStream.write(this.cVerifyType, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\MessageSvcPack\SvcRequestSetConfMsgRead.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */