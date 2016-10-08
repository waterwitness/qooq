package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class DelFriendReq
  extends JceStruct
{
  public byte delType;
  public long deluin;
  public long uin;
  public int version;
  
  public DelFriendReq()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public DelFriendReq(long paramLong1, long paramLong2, byte paramByte, int paramInt)
  {
    this.uin = paramLong1;
    this.deluin = paramLong2;
    this.delType = paramByte;
    this.version = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.deluin = paramJceInputStream.read(this.deluin, 1, true);
    this.delType = paramJceInputStream.read(this.delType, 2, true);
    this.version = paramJceInputStream.read(this.version, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.deluin, 1);
    paramJceOutputStream.write(this.delType, 2);
    paramJceOutputStream.write(this.version, 3);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\friendlist\DelFriendReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */