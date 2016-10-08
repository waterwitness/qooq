package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class SvcRequestHead
  extends JceStruct
{
  private static byte[] J;
  private static byte[] K;
  private static Map<String, byte[]> L;
  private static WeiyunUpload M;
  private static Map<String, String> N;
  public int A = 0;
  public int B = 0;
  public int C = 0;
  public Map<String, String> D = null;
  private String E = "";
  private Map<String, byte[]> F = null;
  private String G = "";
  private WeiyunUpload H = null;
  private int I = 0;
  public short a = 0;
  public long b = 0L;
  public String c = "";
  public int d = 0;
  public byte[] e = null;
  public int f = 0;
  public int g = 0;
  public String h = "";
  public String i = "";
  public long j = 0L;
  public long k = 0L;
  public int l = 0;
  public String m = "";
  public int n = 0;
  public int o = 0;
  public int p = 0;
  public byte[] q = null;
  public int r = 0;
  public String s = "";
  public String t = "";
  public long u = 0L;
  public int v = 0;
  public int w = 0;
  public int x = 0;
  public String y = "";
  public int z = 0;
  
  static
  {
    byte[] arrayOfByte = (byte[])new byte[1];
    J = arrayOfByte;
    ((byte[])arrayOfByte)[0] = 0;
    arrayOfByte = (byte[])new byte[1];
    K = arrayOfByte;
    ((byte[])arrayOfByte)[0] = 0;
    L = new HashMap();
    arrayOfByte = (byte[])new byte[1];
    ((byte[])arrayOfByte)[0] = 0;
    L.put("", arrayOfByte);
    M = new WeiyunUpload();
    N = new HashMap();
    N.put("", "");
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.read(this.a, 0, true);
    this.b = paramJceInputStream.read(this.b, 1, true);
    this.c = paramJceInputStream.readString(2, true);
    this.d = paramJceInputStream.read(this.d, 3, true);
    this.e = ((byte[])paramJceInputStream.read(J, 4, true));
    this.f = paramJceInputStream.read(this.f, 5, true);
    this.g = paramJceInputStream.read(this.g, 6, true);
    this.h = paramJceInputStream.readString(7, true);
    this.i = paramJceInputStream.readString(8, true);
    this.j = paramJceInputStream.read(this.j, 9, true);
    this.k = paramJceInputStream.read(this.k, 10, false);
    this.l = paramJceInputStream.read(this.l, 11, false);
    this.m = paramJceInputStream.readString(12, false);
    this.n = paramJceInputStream.read(this.n, 13, false);
    this.o = paramJceInputStream.read(this.o, 14, false);
    this.p = paramJceInputStream.read(this.p, 15, false);
    this.q = ((byte[])paramJceInputStream.read(K, 16, false));
    this.r = paramJceInputStream.read(this.r, 17, false);
    this.s = paramJceInputStream.readString(18, false);
    this.t = paramJceInputStream.readString(19, false);
    this.u = paramJceInputStream.read(this.u, 20, false);
    this.v = paramJceInputStream.read(this.v, 21, false);
    this.w = paramJceInputStream.read(this.w, 22, false);
    this.x = paramJceInputStream.read(this.x, 23, false);
    this.y = paramJceInputStream.readString(24, false);
    this.z = paramJceInputStream.read(this.z, 25, false);
    this.A = paramJceInputStream.read(this.A, 26, false);
    this.E = paramJceInputStream.readString(27, false);
    this.B = paramJceInputStream.read(this.B, 28, false);
    this.F = ((Map)paramJceInputStream.read(L, 29, false));
    this.C = paramJceInputStream.read(this.C, 30, false);
    this.G = paramJceInputStream.readString(31, false);
    this.H = ((WeiyunUpload)paramJceInputStream.read(M, 32, false));
    this.I = paramJceInputStream.read(this.I, 33, false);
    this.D = ((Map)paramJceInputStream.read(N, 34, false));
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    paramJceOutputStream.write(this.b, 1);
    paramJceOutputStream.write(this.c, 2);
    paramJceOutputStream.write(this.d, 3);
    paramJceOutputStream.write(this.e, 4);
    paramJceOutputStream.write(this.f, 5);
    paramJceOutputStream.write(this.g, 6);
    paramJceOutputStream.write(this.h, 7);
    paramJceOutputStream.write(this.i, 8);
    paramJceOutputStream.write(this.j, 9);
    paramJceOutputStream.write(this.k, 10);
    paramJceOutputStream.write(this.l, 11);
    if (this.m != null) {
      paramJceOutputStream.write(this.m, 12);
    }
    paramJceOutputStream.write(this.n, 13);
    paramJceOutputStream.write(this.o, 14);
    paramJceOutputStream.write(this.p, 15);
    if (this.q != null) {
      paramJceOutputStream.write(this.q, 16);
    }
    paramJceOutputStream.write(this.r, 17);
    if (this.s != null) {
      paramJceOutputStream.write(this.s, 18);
    }
    if (this.t != null) {
      paramJceOutputStream.write(this.t, 19);
    }
    paramJceOutputStream.write(this.u, 20);
    paramJceOutputStream.write(this.v, 21);
    paramJceOutputStream.write(this.w, 22);
    paramJceOutputStream.write(this.x, 23);
    if (this.y != null) {
      paramJceOutputStream.write(this.y, 24);
    }
    paramJceOutputStream.write(this.z, 25);
    paramJceOutputStream.write(this.A, 26);
    if (this.E != null) {
      paramJceOutputStream.write(this.E, 27);
    }
    paramJceOutputStream.write(this.B, 28);
    if (this.F != null) {
      paramJceOutputStream.write(this.F, 29);
    }
    paramJceOutputStream.write(this.C, 30);
    if (this.G != null) {
      paramJceOutputStream.write(this.G, 31);
    }
    if (this.H != null) {
      paramJceOutputStream.write(this.H, 32);
    }
    paramJceOutputStream.write(this.I, 33);
    if (this.D != null) {
      paramJceOutputStream.write(this.D, 34);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\FileUpload\SvcRequestHead.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */