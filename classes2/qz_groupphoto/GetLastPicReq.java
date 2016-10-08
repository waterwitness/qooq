package qz_groupphoto;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class GetLastPicReq
  extends JceStruct
{
  static _LoginInfo cache_stLoginInfo;
  public long cnt;
  public long gid;
  public long lasttime;
  public _LoginInfo stLoginInfo;
  public long uin;
  
  public GetLastPicReq()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public GetLastPicReq(_LoginInfo param_LoginInfo, long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    this.stLoginInfo = param_LoginInfo;
    this.uin = paramLong1;
    this.gid = paramLong2;
    this.cnt = paramLong3;
    this.lasttime = paramLong4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stLoginInfo == null) {
      cache_stLoginInfo = new _LoginInfo();
    }
    this.stLoginInfo = ((_LoginInfo)paramJceInputStream.read(cache_stLoginInfo, 0, false));
    this.uin = paramJceInputStream.read(this.uin, 1, true);
    this.gid = paramJceInputStream.read(this.gid, 2, true);
    this.cnt = paramJceInputStream.read(this.cnt, 3, true);
    this.lasttime = paramJceInputStream.read(this.lasttime, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.stLoginInfo != null) {
      paramJceOutputStream.write(this.stLoginInfo, 0);
    }
    paramJceOutputStream.write(this.uin, 1);
    paramJceOutputStream.write(this.gid, 2);
    paramJceOutputStream.write(this.cnt, 3);
    paramJceOutputStream.write(this.lasttime, 4);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qz_groupphoto\GetLastPicReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */