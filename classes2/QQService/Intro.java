package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class Intro
  extends JceStruct
{
  static byte[] cache_vContent;
  public short shType;
  public byte[] vContent;
  
  public Intro()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Intro(short paramShort, byte[] paramArrayOfByte)
  {
    this.shType = paramShort;
    this.vContent = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.shType = paramJceInputStream.read(this.shType, 0, true);
    if (cache_vContent == null)
    {
      cache_vContent = (byte[])new byte[1];
      ((byte[])cache_vContent)[0] = 0;
    }
    this.vContent = ((byte[])paramJceInputStream.read(cache_vContent, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.shType, 0);
    paramJceOutputStream.write(this.vContent, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\QQService\Intro.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */