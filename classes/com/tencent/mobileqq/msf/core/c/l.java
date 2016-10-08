package com.tencent.mobileqq.msf.core.c;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class l
  extends JceStruct
{
  static Map e;
  public String a = "";
  public long b;
  public Map c;
  public boolean d = true;
  
  public l() {}
  
  public l(String paramString, long paramLong, Map paramMap, boolean paramBoolean)
  {
    this.a = paramString;
    this.b = paramLong;
    this.c = paramMap;
    this.d = paramBoolean;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.readString(1, true);
    this.b = paramJceInputStream.read(this.b, 2, true);
    if (e == null)
    {
      e = new HashMap();
      e.put("", "");
    }
    this.c = ((Map)paramJceInputStream.read(e, 3, true));
    this.d = paramJceInputStream.read(this.d, 4, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 1);
    paramJceOutputStream.write(this.b, 2);
    paramJceOutputStream.write(this.c, 3);
    paramJceOutputStream.write(this.d, 4);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\msf\core\c\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */