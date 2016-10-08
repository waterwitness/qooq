package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class GetTroopRemarkReq
  extends JceStruct
{
  public long GroupCode;
  public long GroupUin;
  public long NextUin;
  public long Seq;
  public long uin;
  
  public GetTroopRemarkReq()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public GetTroopRemarkReq(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
  {
    this.uin = paramLong1;
    this.GroupCode = paramLong2;
    this.GroupUin = paramLong3;
    this.Seq = paramLong4;
    this.NextUin = paramLong5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.GroupCode = paramJceInputStream.read(this.GroupCode, 1, true);
    this.GroupUin = paramJceInputStream.read(this.GroupUin, 2, true);
    this.Seq = paramJceInputStream.read(this.Seq, 3, true);
    this.NextUin = paramJceInputStream.read(this.NextUin, 4, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.GroupCode, 1);
    paramJceOutputStream.write(this.GroupUin, 2);
    paramJceOutputStream.write(this.Seq, 3);
    paramJceOutputStream.write(this.NextUin, 4);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\friendlist\GetTroopRemarkReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */