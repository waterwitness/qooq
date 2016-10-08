package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ShuoshuoInfoRsp
  extends JceStruct
{
  private static byte[] b;
  public byte[] a = null;
  
  static
  {
    byte[] arrayOfByte = (byte[])new byte[1];
    b = arrayOfByte;
    ((byte[])arrayOfByte)[0] = 0;
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = ((byte[])paramJceInputStream.read(b, 1, true));
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 1);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\FileUpload\ShuoshuoInfoRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */