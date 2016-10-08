package NS_MOBILE_COMM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class star_info
  extends JceStruct
{
  public int iStarLevel;
  public int iStarStatus;
  public byte isAnnualVip;
  public byte isHighStarVip;
  
  public star_info()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public star_info(int paramInt1, int paramInt2, byte paramByte1, byte paramByte2)
  {
    this.iStarStatus = paramInt1;
    this.iStarLevel = paramInt2;
    this.isAnnualVip = paramByte1;
    this.isHighStarVip = paramByte2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iStarStatus = paramJceInputStream.read(this.iStarStatus, 0, false);
    this.iStarLevel = paramJceInputStream.read(this.iStarLevel, 1, false);
    this.isAnnualVip = paramJceInputStream.read(this.isAnnualVip, 2, false);
    this.isHighStarVip = paramJceInputStream.read(this.isHighStarVip, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iStarStatus, 0);
    paramJceOutputStream.write(this.iStarLevel, 1);
    paramJceOutputStream.write(this.isAnnualVip, 2);
    paramJceOutputStream.write(this.isHighStarVip, 3);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_COMM\star_info.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */