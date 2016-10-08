package sm;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class n
  extends JceStruct
  implements Cloneable
{
  public int a = 0;
  public int b = 0;
  public int c = 0;
  
  static
  {
    if (!n.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      d = bool;
      return;
    }
  }
  
  public n()
  {
    a(this.a);
    b(this.b);
    c(this.c);
  }
  
  public n(int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramInt1);
    b(paramInt2);
    c(paramInt3);
  }
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void b(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void c(int paramInt)
  {
    this.c = paramInt;
  }
  
  public Object clone()
  {
    Object localObject1 = null;
    try
    {
      Object localObject2 = super.clone();
      localObject1 = localObject2;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      while (d) {}
      throw new AssertionError();
    }
    return localObject1;
  }
  
  public void display(StringBuilder paramStringBuilder, int paramInt) {}
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (n)paramObject;
    } while ((!JceUtil.equals(this.a, ((n)paramObject).a)) || (!JceUtil.equals(this.b, ((n)paramObject).b)) || (!JceUtil.equals(this.c, ((n)paramObject).c)));
    return true;
  }
  
  public int hashCode()
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
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    a(paramJceInputStream.read(this.a, 1, true));
    b(paramJceInputStream.read(this.b, 2, true));
    c(paramJceInputStream.read(this.c, 3, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 1);
    paramJceOutputStream.write(this.b, 2);
    paramJceOutputStream.write(this.c, 3);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\sm\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */