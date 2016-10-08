package com.tencent.mobileqq.msf.core.net.b;

public abstract class n
{
  protected h[] f = { new i("http://sqimg.qq.com/qq_product_operations/nettest/index.html", "MobileQQ1"), new i("http://sqimg.qq.com/qq_product_operations/nettest/index2.html", "MobileQQ2") };
  
  protected a a(h paramh, int paramInt, a.a parama)
  {
    switch (paramh.d)
    {
    case 0: 
    case 1: 
    default: 
      return null;
    }
    return new b(paramInt, ((i)paramh).f, paramh.e, 10000, parama);
  }
  
  public abstract void a();
  
  public abstract void a(String paramString);
  
  public abstract void b();
  
  public abstract void b(String paramString);
  
  public abstract void c();
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\msf\core\net\b\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */