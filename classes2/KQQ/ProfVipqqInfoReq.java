package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ProfVipqqInfoReq
  extends JceStruct
{
  public int iReloadFlag;
  public int iRetIncomPlete;
  public long iUin;
  
  public ProfVipqqInfoReq()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ProfVipqqInfoReq(long paramLong, int paramInt1, int paramInt2)
  {
    this.iUin = paramLong;
    this.iRetIncomPlete = paramInt1;
    this.iReloadFlag = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iUin = paramJceInputStream.read(this.iUin, 1, true);
    this.iRetIncomPlete = paramJceInputStream.read(this.iRetIncomPlete, 2, false);
    this.iReloadFlag = paramJceInputStream.read(this.iReloadFlag, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iUin, 1);
    paramJceOutputStream.write(this.iRetIncomPlete, 2);
    paramJceOutputStream.write(this.iReloadFlag, 3);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\KQQ\ProfVipqqInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */