package NearbyGroup;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class RspTopic
  extends JceStruct
{
  static byte[] cache_strRspTopic;
  public short shShowPos;
  public byte[] strRspTopic;
  
  public RspTopic()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.shShowPos = 4;
  }
  
  public RspTopic(short paramShort, byte[] paramArrayOfByte)
  {
    this.shShowPos = 4;
    this.shShowPos = paramShort;
    this.strRspTopic = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.shShowPos = paramJceInputStream.read(this.shShowPos, 0, true);
    if (cache_strRspTopic == null)
    {
      cache_strRspTopic = (byte[])new byte[1];
      ((byte[])cache_strRspTopic)[0] = 0;
    }
    this.strRspTopic = ((byte[])paramJceInputStream.read(cache_strRspTopic, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.shShowPos, 0);
    paramJceOutputStream.write(this.strRspTopic, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NearbyGroup\RspTopic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */