package a;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class a
  extends JceStruct
{
  private static byte[] B;
  public String A = "";
  public String a = "";
  public String b = "";
  public int c = 0;
  public String d = "";
  public long e = 0L;
  public int f = 0;
  public String g = "";
  public int h = 0;
  public int i = 0;
  public String j = "";
  public int k = 0;
  public String l = "";
  public String m = "";
  public int n = 0;
  public int o = 0;
  public int p = 0;
  public String q = "";
  public String r = "";
  public String s = "";
  public String t = "";
  public String u = "";
  public String v = "";
  public int w = 0;
  public byte[] x = null;
  public String y = "";
  public String z = "";
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.readString(0, false);
    this.b = paramJceInputStream.readString(1, false);
    this.c = paramJceInputStream.read(this.c, 2, false);
    this.d = paramJceInputStream.readString(3, false);
    this.e = paramJceInputStream.read(this.e, 4, false);
    this.f = paramJceInputStream.read(this.f, 5, false);
    this.g = paramJceInputStream.readString(6, false);
    this.h = paramJceInputStream.read(this.h, 7, false);
    this.i = paramJceInputStream.read(this.i, 8, false);
    this.j = paramJceInputStream.readString(9, false);
    this.k = paramJceInputStream.read(this.k, 10, false);
    this.l = paramJceInputStream.readString(11, false);
    this.m = paramJceInputStream.readString(12, false);
    this.n = paramJceInputStream.read(this.n, 13, false);
    this.o = paramJceInputStream.read(this.o, 14, false);
    this.p = paramJceInputStream.read(this.p, 15, false);
    this.q = paramJceInputStream.readString(16, false);
    this.r = paramJceInputStream.readString(17, false);
    this.s = paramJceInputStream.readString(18, false);
    this.t = paramJceInputStream.readString(19, false);
    this.u = paramJceInputStream.readString(20, false);
    this.v = paramJceInputStream.readString(21, false);
    this.w = paramJceInputStream.read(this.w, 22, false);
    if (B == null)
    {
      byte[] arrayOfByte = (byte[])new byte[1];
      B = arrayOfByte;
      ((byte[])arrayOfByte)[0] = 0;
    }
    this.x = ((byte[])paramJceInputStream.read(B, 23, false));
    this.y = paramJceInputStream.readString(24, false);
    this.z = paramJceInputStream.readString(25, false);
    this.A = paramJceInputStream.readString(26, false);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.a != null) {
      paramJceOutputStream.write(this.a, 0);
    }
    if (this.b != null) {
      paramJceOutputStream.write(this.b, 1);
    }
    paramJceOutputStream.write(this.c, 2);
    if (this.d != null) {
      paramJceOutputStream.write(this.d, 3);
    }
    paramJceOutputStream.write(this.e, 4);
    paramJceOutputStream.write(this.f, 5);
    if (this.g != null) {
      paramJceOutputStream.write(this.g, 6);
    }
    paramJceOutputStream.write(this.h, 7);
    paramJceOutputStream.write(this.i, 8);
    if (this.j != null) {
      paramJceOutputStream.write(this.j, 9);
    }
    paramJceOutputStream.write(this.k, 10);
    if (this.l != null) {
      paramJceOutputStream.write(this.l, 11);
    }
    if (this.m != null) {
      paramJceOutputStream.write(this.m, 12);
    }
    paramJceOutputStream.write(this.n, 13);
    paramJceOutputStream.write(this.o, 14);
    paramJceOutputStream.write(this.p, 15);
    if (this.q != null) {
      paramJceOutputStream.write(this.q, 16);
    }
    if (this.r != null) {
      paramJceOutputStream.write(this.r, 17);
    }
    if (this.s != null) {
      paramJceOutputStream.write(this.s, 18);
    }
    if (this.t != null) {
      paramJceOutputStream.write(this.t, 19);
    }
    if (this.u != null) {
      paramJceOutputStream.write(this.u, 20);
    }
    if (this.v != null) {
      paramJceOutputStream.write(this.v, 21);
    }
    paramJceOutputStream.write(this.w, 22);
    if (this.x != null) {
      paramJceOutputStream.write(this.x, 23);
    }
    if (this.y != null) {
      paramJceOutputStream.write(this.y, 24);
    }
    if (this.z != null) {
      paramJceOutputStream.write(this.z, 25);
    }
    if (this.A != null) {
      paramJceOutputStream.write(this.A, 26);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */