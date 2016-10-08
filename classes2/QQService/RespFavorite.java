package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class RespFavorite
  extends JceStruct
{
  static RespHead cache_stHeader;
  static byte[] cache_vNotice;
  public byte cOpType;
  public long lMID;
  public RespHead stHeader;
  public byte[] vNotice;
  
  public RespFavorite()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public RespFavorite(RespHead paramRespHead, long paramLong, byte paramByte, byte[] paramArrayOfByte)
  {
    this.stHeader = paramRespHead;
    this.lMID = paramLong;
    this.cOpType = paramByte;
    this.vNotice = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new RespHead();
    }
    this.stHeader = ((RespHead)paramJceInputStream.read(cache_stHeader, 0, true));
    this.lMID = paramJceInputStream.read(this.lMID, 1, true);
    this.cOpType = paramJceInputStream.read(this.cOpType, 2, true);
    if (cache_vNotice == null)
    {
      cache_vNotice = (byte[])new byte[1];
      ((byte[])cache_vNotice)[0] = 0;
    }
    this.vNotice = ((byte[])paramJceInputStream.read(cache_vNotice, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.lMID, 1);
    paramJceOutputStream.write(this.cOpType, 2);
    if (this.vNotice != null) {
      paramJceOutputStream.write(this.vNotice, 3);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\QQService\RespFavorite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */