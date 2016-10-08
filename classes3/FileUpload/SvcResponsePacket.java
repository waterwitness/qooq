package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class SvcResponsePacket
  extends JceStruct
{
  private static byte[] m;
  private static Map<String, String> n;
  public int a = 0;
  public int b = 0;
  public String c = "";
  public int d = 0;
  public int e = 0;
  public byte[] f = null;
  public String g = "";
  public long h = 0L;
  public String i = "";
  public String j = "";
  public Map<String, String> k = null;
  private String l = "";
  
  static
  {
    byte[] arrayOfByte = (byte[])new byte[1];
    m = arrayOfByte;
    ((byte[])arrayOfByte)[0] = 0;
    n = new HashMap();
    n.put("", "");
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.read(this.a, 0, true);
    this.b = paramJceInputStream.read(this.b, 1, true);
    this.c = paramJceInputStream.readString(2, false);
    this.d = paramJceInputStream.read(this.d, 3, true);
    this.e = paramJceInputStream.read(this.e, 4, true);
    this.f = ((byte[])paramJceInputStream.read(m, 5, false));
    this.g = paramJceInputStream.readString(6, false);
    this.h = paramJceInputStream.read(this.h, 7, false);
    this.i = paramJceInputStream.readString(8, false);
    this.j = paramJceInputStream.readString(9, false);
    this.l = paramJceInputStream.readString(10, false);
    this.k = ((Map)paramJceInputStream.read(n, 11, false));
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    paramJceOutputStream.write(this.b, 1);
    if (this.c != null) {
      paramJceOutputStream.write(this.c, 2);
    }
    paramJceOutputStream.write(this.d, 3);
    paramJceOutputStream.write(this.e, 4);
    if (this.f != null) {
      paramJceOutputStream.write(this.f, 5);
    }
    if (this.g != null) {
      paramJceOutputStream.write(this.g, 6);
    }
    paramJceOutputStream.write(this.h, 7);
    if (this.i != null) {
      paramJceOutputStream.write(this.i, 8);
    }
    if (this.j != null) {
      paramJceOutputStream.write(this.j, 9);
    }
    if (this.l != null) {
      paramJceOutputStream.write(this.l, 10);
    }
    if (this.k != null) {
      paramJceOutputStream.write(this.k, 11);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\FileUpload\SvcResponsePacket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */