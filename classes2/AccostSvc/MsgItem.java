package AccostSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class MsgItem
  extends JceStruct
{
  static byte[] cache_MsgContent;
  public byte[] MsgContent;
  public byte cType;
  
  public MsgItem()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public MsgItem(byte paramByte, byte[] paramArrayOfByte)
  {
    this.cType = paramByte;
    this.MsgContent = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cType = paramJceInputStream.read(this.cType, 0, true);
    if (cache_MsgContent == null)
    {
      cache_MsgContent = (byte[])new byte[1];
      ((byte[])cache_MsgContent)[0] = 0;
    }
    this.MsgContent = ((byte[])paramJceInputStream.read(cache_MsgContent, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cType, 0);
    paramJceOutputStream.write(this.MsgContent, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\AccostSvc\MsgItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */