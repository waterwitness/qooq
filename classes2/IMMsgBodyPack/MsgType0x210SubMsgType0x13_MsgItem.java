package IMMsgBodyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class MsgType0x210SubMsgType0x13_MsgItem
  extends JceStruct
{
  static byte[] cache_bytes_text;
  public byte[] bytes_text;
  public long uint32_type;
  
  public MsgType0x210SubMsgType0x13_MsgItem()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public MsgType0x210SubMsgType0x13_MsgItem(long paramLong, byte[] paramArrayOfByte)
  {
    this.uint32_type = paramLong;
    this.bytes_text = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uint32_type = paramJceInputStream.read(this.uint32_type, 0, false);
    if (cache_bytes_text == null)
    {
      cache_bytes_text = (byte[])new byte[1];
      ((byte[])cache_bytes_text)[0] = 0;
    }
    this.bytes_text = ((byte[])paramJceInputStream.read(cache_bytes_text, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uint32_type, 0);
    if (this.bytes_text != null) {
      paramJceOutputStream.write(this.bytes_text, 1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\IMMsgBodyPack\MsgType0x210SubMsgType0x13_MsgItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */