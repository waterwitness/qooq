package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class FileUploadControlRsp
  extends JceStruct
{
  private static byte[] g;
  public long a = 0L;
  public int b = 0;
  public long c = 0L;
  private byte[] d = null;
  private String e = "";
  private String f = "";
  
  static
  {
    byte[] arrayOfByte = (byte[])new byte[1];
    g = arrayOfByte;
    ((byte[])arrayOfByte)[0] = 0;
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.read(this.a, 0, false);
    this.b = paramJceInputStream.read(this.b, 1, false);
    this.d = ((byte[])paramJceInputStream.read(g, 2, false));
    this.c = paramJceInputStream.read(this.c, 3, false);
    this.e = paramJceInputStream.readString(4, false);
    this.f = paramJceInputStream.readString(5, false);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    paramJceOutputStream.write(this.b, 1);
    if (this.d != null) {
      paramJceOutputStream.write(this.d, 2);
    }
    paramJceOutputStream.write(this.c, 3);
    if (this.e != null) {
      paramJceOutputStream.write(this.e, 4);
    }
    if (this.f != null) {
      paramJceOutputStream.write(this.f, 5);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\FileUpload\FileUploadControlRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */