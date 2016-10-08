package NearbyGroup;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class RspActivity
  extends JceStruct
{
  static byte[] cache_strRspAct;
  public short shShowPos;
  public byte[] strRspAct;
  
  public RspActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.shShowPos = 2;
  }
  
  public RspActivity(short paramShort, byte[] paramArrayOfByte)
  {
    this.shShowPos = 2;
    this.shShowPos = paramShort;
    this.strRspAct = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.shShowPos = paramJceInputStream.read(this.shShowPos, 0, true);
    if (cache_strRspAct == null)
    {
      cache_strRspAct = (byte[])new byte[1];
      ((byte[])cache_strRspAct)[0] = 0;
    }
    this.strRspAct = ((byte[])paramJceInputStream.read(cache_strRspAct, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.shShowPos, 0);
    paramJceOutputStream.write(this.strRspAct, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NearbyGroup\RspActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */