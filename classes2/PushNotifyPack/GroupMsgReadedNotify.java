package PushNotifyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class GroupMsgReadedNotify
  extends JceStruct
{
  public long lGroupCode;
  public long lGroupMsgSeq;
  public long lMemberSeq;
  public long lOpType;
  
  public GroupMsgReadedNotify()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public GroupMsgReadedNotify(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    this.lGroupCode = paramLong1;
    this.lOpType = paramLong2;
    this.lMemberSeq = paramLong3;
    this.lGroupMsgSeq = paramLong4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lGroupCode = paramJceInputStream.read(this.lGroupCode, 0, false);
    this.lOpType = paramJceInputStream.read(this.lOpType, 1, false);
    this.lMemberSeq = paramJceInputStream.read(this.lMemberSeq, 2, false);
    this.lGroupMsgSeq = paramJceInputStream.read(this.lGroupMsgSeq, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lGroupCode, 0);
    paramJceOutputStream.write(this.lOpType, 1);
    paramJceOutputStream.write(this.lMemberSeq, 2);
    paramJceOutputStream.write(this.lGroupMsgSeq, 3);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\PushNotifyPack\GroupMsgReadedNotify.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */