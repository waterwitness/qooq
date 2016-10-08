package EncounterSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class NeighborBanner
  extends JceStruct
{
  static byte[] cache_description;
  static byte[] cache_pic_url;
  static byte[] cache_skip_url;
  public byte[] description;
  public byte[] pic_url;
  public int postion;
  public byte[] skip_url;
  
  public NeighborBanner()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public NeighborBanner(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt)
  {
    this.description = paramArrayOfByte1;
    this.pic_url = paramArrayOfByte2;
    this.skip_url = paramArrayOfByte3;
    this.postion = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_description == null)
    {
      cache_description = (byte[])new byte[1];
      ((byte[])cache_description)[0] = 0;
    }
    this.description = ((byte[])paramJceInputStream.read(cache_description, 0, true));
    if (cache_pic_url == null)
    {
      cache_pic_url = (byte[])new byte[1];
      ((byte[])cache_pic_url)[0] = 0;
    }
    this.pic_url = ((byte[])paramJceInputStream.read(cache_pic_url, 1, true));
    if (cache_skip_url == null)
    {
      cache_skip_url = (byte[])new byte[1];
      ((byte[])cache_skip_url)[0] = 0;
    }
    this.skip_url = ((byte[])paramJceInputStream.read(cache_skip_url, 2, true));
    this.postion = paramJceInputStream.read(this.postion, 3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.description, 0);
    paramJceOutputStream.write(this.pic_url, 1);
    paramJceOutputStream.write(this.skip_url, 2);
    paramJceOutputStream.write(this.postion, 3);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\EncounterSvc\NeighborBanner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */