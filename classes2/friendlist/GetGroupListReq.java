package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class GetGroupListReq
  extends JceStruct
{
  public byte flush;
  public byte getgroupCount;
  public byte startIndex;
  public long uin;
  
  public GetGroupListReq()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public GetGroupListReq(long paramLong, byte paramByte1, byte paramByte2, byte paramByte3)
  {
    this.uin = paramLong;
    this.startIndex = paramByte1;
    this.getgroupCount = paramByte2;
    this.flush = paramByte3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.startIndex = paramJceInputStream.read(this.startIndex, 1, true);
    this.getgroupCount = paramJceInputStream.read(this.getgroupCount, 2, true);
    this.flush = paramJceInputStream.read(this.flush, 3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.startIndex, 1);
    paramJceOutputStream.write(this.getgroupCount, 2);
    paramJceOutputStream.write(this.flush, 3);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\friendlist\GetGroupListReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */