package OnlinePushPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class DelMsgInfo
  extends JceStruct
{
  static byte[] cache_vMsgCookies;
  public long lFromUin;
  public short shMsgSeq;
  public long uMsgTime;
  public byte[] vMsgCookies;
  
  public DelMsgInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public DelMsgInfo(long paramLong1, long paramLong2, short paramShort, byte[] paramArrayOfByte)
  {
    this.lFromUin = paramLong1;
    this.uMsgTime = paramLong2;
    this.shMsgSeq = paramShort;
    this.vMsgCookies = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lFromUin = paramJceInputStream.read(this.lFromUin, 0, true);
    this.uMsgTime = paramJceInputStream.read(this.uMsgTime, 1, true);
    this.shMsgSeq = paramJceInputStream.read(this.shMsgSeq, 2, true);
    if (cache_vMsgCookies == null)
    {
      cache_vMsgCookies = (byte[])new byte[1];
      ((byte[])cache_vMsgCookies)[0] = 0;
    }
    this.vMsgCookies = ((byte[])paramJceInputStream.read(cache_vMsgCookies, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lFromUin, 0);
    paramJceOutputStream.write(this.uMsgTime, 1);
    paramJceOutputStream.write(this.shMsgSeq, 2);
    if (this.vMsgCookies != null) {
      paramJceOutputStream.write(this.vMsgCookies, 3);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\OnlinePushPack\DelMsgInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */