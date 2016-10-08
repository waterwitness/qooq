package b;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class a
  extends JceStruct
  implements Cloneable
{
  private static byte[] j;
  private static byte[] k;
  public long a = 0L;
  public int b = 0;
  public int c = 0;
  public byte[] d = null;
  public int e = 0;
  public long f = 0L;
  public long g = 0L;
  public long h = 0L;
  public byte[] i = null;
  
  static
  {
    if (!a.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      l = bool;
      return;
    }
  }
  
  public final Object clone()
  {
    Object localObject1 = null;
    try
    {
      Object localObject2 = super.clone();
      localObject1 = localObject2;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      while (l) {}
      throw new AssertionError();
    }
    return localObject1;
  }
  
  public final void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.a, "uin");
    paramStringBuilder.display(this.b, "format");
    paramStringBuilder.display(this.c, "appid");
    paramStringBuilder.display(this.d, "data");
    paramStringBuilder.display(this.e, "voice_length");
    paramStringBuilder.display(this.f, "client_ip");
    paramStringBuilder.display(this.g, "server_ip");
    paramStringBuilder.display(this.h, "key_type");
    paramStringBuilder.display(this.i, "key_value");
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (a)paramObject;
    } while ((!JceUtil.equals(this.a, ((a)paramObject).a)) || (!JceUtil.equals(this.b, ((a)paramObject).b)) || (!JceUtil.equals(this.c, ((a)paramObject).c)) || (!JceUtil.equals(this.d, ((a)paramObject).d)) || (!JceUtil.equals(this.e, ((a)paramObject).e)) || (!JceUtil.equals(this.f, ((a)paramObject).f)) || (!JceUtil.equals(this.g, ((a)paramObject).g)) || (!JceUtil.equals(this.h, ((a)paramObject).h)) || (!JceUtil.equals(this.i, ((a)paramObject).i)));
    return true;
  }
  
  public final int hashCode()
  {
    try
    {
      throw new Exception("Need define key first!");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.read(this.a, 0, true);
    this.b = paramJceInputStream.read(this.b, 1, true);
    this.c = paramJceInputStream.read(this.c, 2, true);
    byte[] arrayOfByte;
    if (j == null)
    {
      arrayOfByte = new byte[1];
      j = arrayOfByte;
      arrayOfByte[0] = 0;
    }
    this.d = paramJceInputStream.read(j, 3, true);
    this.e = paramJceInputStream.read(this.e, 4, true);
    this.f = paramJceInputStream.read(this.f, 5, false);
    this.g = paramJceInputStream.read(this.g, 6, false);
    this.h = paramJceInputStream.read(this.h, 7, false);
    if (k == null)
    {
      arrayOfByte = new byte[1];
      k = arrayOfByte;
      arrayOfByte[0] = 0;
    }
    this.i = paramJceInputStream.read(k, 8, false);
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
    if (this.i != null) {
      paramJceOutputStream.write(this.i, 8);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */