package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class UserVideoAbi
  extends JceStruct
{
  public byte bStatus;
  public long uin;
  
  public UserVideoAbi()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public UserVideoAbi(long paramLong, byte paramByte)
  {
    this.uin = paramLong;
    this.bStatus = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.bStatus = paramJceInputStream.read(this.bStatus, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.bStatus, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\friendlist\UserVideoAbi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */