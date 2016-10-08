package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class yellow_info
  extends JceStruct
{
  public int iYellowLevel;
  public int iYellowType;
  public byte isAnnualVip;
  
  public yellow_info()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public yellow_info(int paramInt1, int paramInt2, byte paramByte)
  {
    this.iYellowType = paramInt1;
    this.iYellowLevel = paramInt2;
    this.isAnnualVip = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iYellowType = paramJceInputStream.read(this.iYellowType, 0, false);
    this.iYellowLevel = paramJceInputStream.read(this.iYellowLevel, 1, false);
    this.isAnnualVip = paramJceInputStream.read(this.isAnnualVip, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iYellowType, 0);
    paramJceOutputStream.write(this.iYellowLevel, 1);
    paramJceOutputStream.write(this.isAnnualVip, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_UNDEAL_COUNT\yellow_info.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */