package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class FriendUinInfo
  extends JceStruct
{
  public byte cType;
  public long uFriendTime;
  public long uFriendUin;
  
  public FriendUinInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public FriendUinInfo(byte paramByte, long paramLong1, long paramLong2)
  {
    this.cType = paramByte;
    this.uFriendUin = paramLong1;
    this.uFriendTime = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cType = paramJceInputStream.read(this.cType, 1, true);
    this.uFriendUin = paramJceInputStream.read(this.uFriendUin, 2, true);
    this.uFriendTime = paramJceInputStream.read(this.uFriendTime, 3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cType, 1);
    paramJceOutputStream.write(this.uFriendUin, 2);
    paramJceOutputStream.write(this.uFriendTime, 3);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\KQQ\FriendUinInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */