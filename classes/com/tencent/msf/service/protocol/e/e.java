package com.tencent.msf.service.protocol.e;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class e
  extends JceStruct
{
  static ArrayList f;
  public int a;
  public int b;
  public ArrayList c;
  public int d;
  public int e;
  
  public e() {}
  
  public e(int paramInt1, int paramInt2, ArrayList paramArrayList, int paramInt3, int paramInt4)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramArrayList;
    this.d = paramInt3;
    this.e = paramInt4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.read(this.a, 1, false);
    this.b = paramJceInputStream.read(this.b, 2, false);
    if (f == null)
    {
      f = new ArrayList();
      f.add("");
    }
    this.c = ((ArrayList)paramJceInputStream.read(f, 3, false));
    this.d = paramJceInputStream.read(this.d, 4, false);
    this.e = paramJceInputStream.read(this.e, 5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 1);
    paramJceOutputStream.write(this.b, 2);
    if (this.c != null) {
      paramJceOutputStream.write(this.c, 3);
    }
    paramJceOutputStream.write(this.d, 4);
    paramJceOutputStream.write(this.e, 5);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\msf\service\protocol\e\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */