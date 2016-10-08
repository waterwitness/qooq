package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class SpecialMsg
  extends JceStruct
{
  static byte[] cache_msg;
  public byte[] msg;
  public int type;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_msg = (byte[])new byte[1];
    ((byte[])cache_msg)[0] = 0;
  }
  
  public SpecialMsg() {}
  
  public SpecialMsg(int paramInt, byte[] paramArrayOfByte)
  {
    this.type = paramInt;
    this.msg = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.type = paramJceInputStream.read(this.type, 0, false);
    this.msg = ((byte[])paramJceInputStream.read(cache_msg, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.type, 0);
    if (this.msg != null) {
      paramJceOutputStream.write(this.msg, 1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_FEEDS\SpecialMsg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */