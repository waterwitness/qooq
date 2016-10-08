package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class CompressedPackage
  extends JceStruct
{
  static byte[] cache_buffer;
  static int cache_command;
  public byte[] buffer;
  public int command;
  public boolean compressed;
  
  public CompressedPackage()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.compressed = true;
  }
  
  public CompressedPackage(boolean paramBoolean, int paramInt, byte[] paramArrayOfByte)
  {
    this.compressed = true;
    this.compressed = paramBoolean;
    this.command = paramInt;
    this.buffer = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.compressed = paramJceInputStream.read(this.compressed, 0, true);
    this.command = paramJceInputStream.read(this.command, 1, true);
    if (cache_buffer == null)
    {
      cache_buffer = (byte[])new byte[1];
      ((byte[])cache_buffer)[0] = 0;
    }
    this.buffer = ((byte[])paramJceInputStream.read(cache_buffer, 2, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.compressed, 0);
    paramJceOutputStream.write(this.command, 1);
    paramJceOutputStream.write(this.buffer, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\SecurityAccountServer\CompressedPackage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */