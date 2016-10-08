package GameCenter;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ReqLastGameInfo
  extends JceStruct
{
  public byte iVersion;
  public long lUin;
  
  public ReqLastGameInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.iVersion = 1;
  }
  
  public ReqLastGameInfo(byte paramByte, long paramLong)
  {
    this.iVersion = 1;
    this.iVersion = paramByte;
    this.lUin = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iVersion = paramJceInputStream.read(this.iVersion, 0, true);
    this.lUin = paramJceInputStream.read(this.lUin, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iVersion, 0);
    paramJceOutputStream.write(this.lUin, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\GameCenter\ReqLastGameInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */