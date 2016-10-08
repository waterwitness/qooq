package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class GiftInfo
  extends JceStruct
{
  static byte[] cache_vGiftInfo;
  public long uOpenFlag;
  public byte[] vGiftInfo;
  
  public GiftInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public GiftInfo(long paramLong, byte[] paramArrayOfByte)
  {
    this.uOpenFlag = paramLong;
    this.vGiftInfo = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uOpenFlag = paramJceInputStream.read(this.uOpenFlag, 0, false);
    if (cache_vGiftInfo == null)
    {
      cache_vGiftInfo = (byte[])new byte[1];
      ((byte[])cache_vGiftInfo)[0] = 0;
    }
    this.vGiftInfo = ((byte[])paramJceInputStream.read(cache_vGiftInfo, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uOpenFlag, 0);
    if (this.vGiftInfo != null) {
      paramJceOutputStream.write(this.vGiftInfo, 1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\SummaryCard\GiftInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */