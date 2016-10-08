package IMMsgBodyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class MarketFaceInfo
  extends JceStruct
{
  static byte[] cache_marketFaceBuff;
  public long insertIdx;
  public byte[] marketFaceBuff;
  
  public MarketFaceInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public MarketFaceInfo(long paramLong, byte[] paramArrayOfByte)
  {
    this.insertIdx = paramLong;
    this.marketFaceBuff = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.insertIdx = paramJceInputStream.read(this.insertIdx, 0, true);
    if (cache_marketFaceBuff == null)
    {
      cache_marketFaceBuff = (byte[])new byte[1];
      ((byte[])cache_marketFaceBuff)[0] = 0;
    }
    this.marketFaceBuff = ((byte[])paramJceInputStream.read(cache_marketFaceBuff, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.insertIdx, 0);
    paramJceOutputStream.write(this.marketFaceBuff, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\IMMsgBodyPack\MarketFaceInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */