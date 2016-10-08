package NS_MOBILE_COMM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class combine_diamond_info
  extends JceStruct
{
  public int iShowType;
  public int iVipLevel;
  public byte isAnnualVip;
  public byte isAnnualVipEver;
  
  public combine_diamond_info()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public combine_diamond_info(int paramInt1, int paramInt2, byte paramByte1, byte paramByte2)
  {
    this.iShowType = paramInt1;
    this.iVipLevel = paramInt2;
    this.isAnnualVip = paramByte1;
    this.isAnnualVipEver = paramByte2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iShowType = paramJceInputStream.read(this.iShowType, 0, false);
    this.iVipLevel = paramJceInputStream.read(this.iVipLevel, 1, false);
    this.isAnnualVip = paramJceInputStream.read(this.isAnnualVip, 2, false);
    this.isAnnualVipEver = paramJceInputStream.read(this.isAnnualVipEver, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iShowType, 0);
    paramJceOutputStream.write(this.iVipLevel, 1);
    paramJceOutputStream.write(this.isAnnualVip, 2);
    paramJceOutputStream.write(this.isAnnualVipEver, 3);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_COMM\combine_diamond_info.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */