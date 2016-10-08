package NearbyGroup;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class RspHotGrp
  extends JceStruct
{
  static byte[] cache_strRspHotGrp;
  public short shShowPos;
  public byte[] strRspHotGrp;
  
  public RspHotGrp()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public RspHotGrp(byte[] paramArrayOfByte, short paramShort)
  {
    this.strRspHotGrp = paramArrayOfByte;
    this.shShowPos = paramShort;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_strRspHotGrp == null)
    {
      cache_strRspHotGrp = (byte[])new byte[1];
      ((byte[])cache_strRspHotGrp)[0] = 0;
    }
    this.strRspHotGrp = ((byte[])paramJceInputStream.read(cache_strRspHotGrp, 0, true));
    this.shShowPos = paramJceInputStream.read(this.shShowPos, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.strRspHotGrp, 0);
    paramJceOutputStream.write(this.shShowPos, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NearbyGroup\RspHotGrp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */