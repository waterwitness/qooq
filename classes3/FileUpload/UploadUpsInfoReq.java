package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class UploadUpsInfoReq
  extends JceStruct
{
  private static byte[] o;
  private static Map<String, byte[]> p;
  public String a = "";
  public String b = "";
  public int c = 0;
  public byte[] d = null;
  public int e = 0;
  public int f = 0;
  public byte g = 0;
  public int h = 0;
  public int i = 0;
  public long j = 0L;
  public String k = "";
  public long l = 0L;
  public long m = 0L;
  public Map<String, byte[]> n = null;
  
  static
  {
    byte[] arrayOfByte = (byte[])new byte[1];
    o = arrayOfByte;
    ((byte[])arrayOfByte)[0] = 0;
    p = new HashMap();
    arrayOfByte = (byte[])new byte[1];
    ((byte[])arrayOfByte)[0] = 0;
    p.put("", arrayOfByte);
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.readString(0, true);
    this.b = paramJceInputStream.readString(1, false);
    this.c = paramJceInputStream.read(this.c, 2, true);
    this.d = ((byte[])paramJceInputStream.read(o, 3, false));
    this.e = paramJceInputStream.read(this.e, 4, false);
    this.f = paramJceInputStream.read(this.f, 5, false);
    this.g = paramJceInputStream.read(this.g, 6, false);
    this.h = paramJceInputStream.read(this.h, 7, false);
    this.i = paramJceInputStream.read(this.i, 8, false);
    this.j = paramJceInputStream.read(this.j, 9, false);
    this.k = paramJceInputStream.readString(10, false);
    this.l = paramJceInputStream.read(this.l, 11, false);
    this.m = paramJceInputStream.read(this.m, 12, false);
    this.n = ((Map)paramJceInputStream.read(p, 13, false));
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    if (this.b != null) {
      paramJceOutputStream.write(this.b, 1);
    }
    paramJceOutputStream.write(this.c, 2);
    if (this.d != null) {
      paramJceOutputStream.write(this.d, 3);
    }
    paramJceOutputStream.write(this.e, 4);
    paramJceOutputStream.write(this.f, 5);
    paramJceOutputStream.write(this.g, 6);
    paramJceOutputStream.write(this.h, 7);
    paramJceOutputStream.write(this.i, 8);
    paramJceOutputStream.write(this.j, 9);
    if (this.k != null) {
      paramJceOutputStream.write(this.k, 10);
    }
    paramJceOutputStream.write(this.l, 11);
    paramJceOutputStream.write(this.m, 12);
    if (this.n != null) {
      paramJceOutputStream.write(this.n, 13);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\FileUpload\UploadUpsInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */