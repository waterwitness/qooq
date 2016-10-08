package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class GroupMemberFlag
  extends JceStruct
{
  public byte cUinFlag;
  public long dwUin;
  
  public GroupMemberFlag()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public GroupMemberFlag(long paramLong, byte paramByte)
  {
    this.dwUin = paramLong;
    this.cUinFlag = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.dwUin = paramJceInputStream.read(this.dwUin, 0, true);
    this.cUinFlag = paramJceInputStream.read(this.cUinFlag, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.dwUin, 0);
    paramJceOutputStream.write(this.cUinFlag, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\KQQ\GroupMemberFlag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */