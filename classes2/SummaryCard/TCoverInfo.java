package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class TCoverInfo
  extends JceStruct
{
  static byte[] cache_vTagInfo;
  public byte[] vTagInfo;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_vTagInfo = (byte[])new byte[1];
    ((byte[])cache_vTagInfo)[0] = 0;
  }
  
  public TCoverInfo() {}
  
  public TCoverInfo(byte[] paramArrayOfByte)
  {
    this.vTagInfo = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.vTagInfo = ((byte[])paramJceInputStream.read(cache_vTagInfo, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.vTagInfo != null) {
      paramJceOutputStream.write(this.vTagInfo, 0);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\SummaryCard\TCoverInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */