package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class CheckFriendReq
  extends JceStruct
{
  public long fuin;
  public long uin;
  
  public CheckFriendReq()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public CheckFriendReq(long paramLong1, long paramLong2)
  {
    this.uin = paramLong1;
    this.fuin = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.fuin = paramJceInputStream.read(this.fuin, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.fuin, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\friendlist\CheckFriendReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */