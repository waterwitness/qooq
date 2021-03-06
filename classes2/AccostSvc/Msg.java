package AccostSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class Msg
  extends JceStruct
{
  static int cache_eAccostType;
  static byte[] cache_strMsg;
  public int eAccostType;
  public int iMsgTime;
  public long iPluginID;
  public long lFromMID;
  public long lToMID;
  public short shMsgType;
  public byte[] strMsg;
  public long uMsgID;
  public long uRandID;
  
  public Msg()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Msg(short paramShort, long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, byte[] paramArrayOfByte, long paramLong4, long paramLong5)
  {
    this.shMsgType = paramShort;
    this.uMsgID = paramLong1;
    this.lFromMID = paramLong2;
    this.lToMID = paramLong3;
    this.iMsgTime = paramInt1;
    this.eAccostType = paramInt2;
    this.strMsg = paramArrayOfByte;
    this.iPluginID = paramLong4;
    this.uRandID = paramLong5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.shMsgType = paramJceInputStream.read(this.shMsgType, 0, true);
    this.uMsgID = paramJceInputStream.read(this.uMsgID, 1, true);
    this.lFromMID = paramJceInputStream.read(this.lFromMID, 2, true);
    this.lToMID = paramJceInputStream.read(this.lToMID, 3, true);
    this.iMsgTime = paramJceInputStream.read(this.iMsgTime, 4, true);
    this.eAccostType = paramJceInputStream.read(this.eAccostType, 5, true);
    if (cache_strMsg == null)
    {
      cache_strMsg = (byte[])new byte[1];
      ((byte[])cache_strMsg)[0] = 0;
    }
    this.strMsg = ((byte[])paramJceInputStream.read(cache_strMsg, 6, true));
    this.iPluginID = paramJceInputStream.read(this.iPluginID, 7, false);
    this.uRandID = paramJceInputStream.read(this.uRandID, 8, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.shMsgType, 0);
    paramJceOutputStream.write(this.uMsgID, 1);
    paramJceOutputStream.write(this.lFromMID, 2);
    paramJceOutputStream.write(this.lToMID, 3);
    paramJceOutputStream.write(this.iMsgTime, 4);
    paramJceOutputStream.write(this.eAccostType, 5);
    paramJceOutputStream.write(this.strMsg, 6);
    paramJceOutputStream.write(this.iPluginID, 7);
    paramJceOutputStream.write(this.uRandID, 8);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\AccostSvc\Msg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */