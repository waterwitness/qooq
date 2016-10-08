package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class UploadInfo
  extends JceStruct
{
  static byte[] cache_vSignature;
  public long lAppID;
  public long lFromMID;
  public long lToMID;
  public short shType;
  public byte[] vSignature;
  
  public UploadInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public UploadInfo(long paramLong1, long paramLong2, long paramLong3, short paramShort, byte[] paramArrayOfByte)
  {
    this.lFromMID = paramLong1;
    this.lToMID = paramLong2;
    this.lAppID = paramLong3;
    this.shType = paramShort;
    this.vSignature = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lFromMID = paramJceInputStream.read(this.lFromMID, 0, true);
    this.lToMID = paramJceInputStream.read(this.lToMID, 1, true);
    this.lAppID = paramJceInputStream.read(this.lAppID, 2, true);
    this.shType = paramJceInputStream.read(this.shType, 3, true);
    if (cache_vSignature == null)
    {
      cache_vSignature = (byte[])new byte[1];
      ((byte[])cache_vSignature)[0] = 0;
    }
    this.vSignature = ((byte[])paramJceInputStream.read(cache_vSignature, 4, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lFromMID, 0);
    paramJceOutputStream.write(this.lToMID, 1);
    paramJceOutputStream.write(this.lAppID, 2);
    paramJceOutputStream.write(this.shType, 3);
    paramJceOutputStream.write(this.vSignature, 4);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\KQQ\UploadInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */