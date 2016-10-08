package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class LastLoginInfo
  extends JceStruct
{
  public static final long TYPE_LONG_OFFLINE = 20L;
  public static final long TYPE_OFFLINE = 10L;
  public static final long TYPE_OFFLINE_TO_LEAVE_MSG = 1L;
  public long dwClient;
  public long dwFriendUin;
  public long dwLastLoginType;
  
  public LastLoginInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public LastLoginInfo(long paramLong1, long paramLong2, long paramLong3)
  {
    this.dwFriendUin = paramLong1;
    this.dwLastLoginType = paramLong2;
    this.dwClient = paramLong3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.dwFriendUin = paramJceInputStream.read(this.dwFriendUin, 0, false);
    this.dwLastLoginType = paramJceInputStream.read(this.dwLastLoginType, 1, false);
    this.dwClient = paramJceInputStream.read(this.dwClient, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.dwFriendUin, 0);
    paramJceOutputStream.write(this.dwLastLoginType, 1);
    paramJceOutputStream.write(this.dwClient, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\friendlist\LastLoginInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */