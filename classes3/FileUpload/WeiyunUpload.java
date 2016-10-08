package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class WeiyunUpload
  extends JceStruct
{
  private static byte[] f;
  private static byte[] g;
  private byte[] a = null;
  private byte[] b = null;
  private String c = "";
  private String d = "";
  private long e = 0L;
  
  static
  {
    byte[] arrayOfByte = (byte[])new byte[1];
    f = arrayOfByte;
    ((byte[])arrayOfByte)[0] = 0;
    arrayOfByte = (byte[])new byte[1];
    g = arrayOfByte;
    ((byte[])arrayOfByte)[0] = 0;
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = ((byte[])paramJceInputStream.read(f, 1, false));
    this.b = ((byte[])paramJceInputStream.read(g, 2, false));
    this.c = paramJceInputStream.readString(3, false);
    this.d = paramJceInputStream.readString(4, false);
    this.e = paramJceInputStream.read(this.e, 5, false);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.a != null) {
      paramJceOutputStream.write(this.a, 1);
    }
    if (this.b != null) {
      paramJceOutputStream.write(this.b, 2);
    }
    if (this.c != null) {
      paramJceOutputStream.write(this.c, 3);
    }
    if (this.d != null) {
      paramJceOutputStream.write(this.d, 4);
    }
    paramJceOutputStream.write(this.e, 5);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\FileUpload\WeiyunUpload.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */