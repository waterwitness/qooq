package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ProfIncInfoRes
  extends JceStruct
{
  public int uOnlineTime;
  public int uRemainTime;
  public short wLevel;
  
  public ProfIncInfoRes()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ProfIncInfoRes(short paramShort, int paramInt1, int paramInt2)
  {
    this.wLevel = paramShort;
    this.uOnlineTime = paramInt1;
    this.uRemainTime = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.wLevel = paramJceInputStream.read(this.wLevel, 1, true);
    this.uOnlineTime = paramJceInputStream.read(this.uOnlineTime, 2, true);
    this.uRemainTime = paramJceInputStream.read(this.uRemainTime, 3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.wLevel, 1);
    paramJceOutputStream.write(this.uOnlineTime, 2);
    paramJceOutputStream.write(this.uRemainTime, 3);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\KQQ\ProfIncInfoRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */