package com.tencent.msf.service.protocol.security;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class i
  extends JceStruct
{
  static byte[] d;
  public byte[] a;
  public String b = "";
  public String c = "";
  
  public i() {}
  
  public i(byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    this.a = paramArrayOfByte;
    this.b = paramString1;
    this.c = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (d == null)
    {
      d = (byte[])new byte[1];
      ((byte[])d)[0] = 0;
    }
    this.a = ((byte[])paramJceInputStream.read(d, 1, true));
    this.b = paramJceInputStream.readString(2, true);
    this.c = paramJceInputStream.readString(3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 1);
    paramJceOutputStream.write(this.b, 2);
    paramJceOutputStream.write(this.c, 3);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\msf\service\protocol\security\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */