package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ProfVipqqInfoRes
  extends JceStruct
{
  public short wLevel;
  
  public ProfVipqqInfoRes()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ProfVipqqInfoRes(short paramShort)
  {
    this.wLevel = paramShort;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.wLevel = paramJceInputStream.read(this.wLevel, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.wLevel, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\KQQ\ProfVipqqInfoRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */