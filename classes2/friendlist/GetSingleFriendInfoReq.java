package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class GetSingleFriendInfoReq
  extends JceStruct
{
  public long frienduin;
  public byte ifReflush;
  public long uin;
  
  public GetSingleFriendInfoReq()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public GetSingleFriendInfoReq(byte paramByte, long paramLong1, long paramLong2)
  {
    this.ifReflush = paramByte;
    this.uin = paramLong1;
    this.frienduin = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ifReflush = paramJceInputStream.read(this.ifReflush, 0, true);
    this.uin = paramJceInputStream.read(this.uin, 1, true);
    this.frienduin = paramJceInputStream.read(this.frienduin, 2, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ifReflush, 0);
    paramJceOutputStream.write(this.uin, 1);
    paramJceOutputStream.write(this.frienduin, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\friendlist\GetSingleFriendInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */