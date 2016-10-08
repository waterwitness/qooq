package oicq.wlogin_sdk.request;

import java.net.InetSocketAddress;

public class a
  implements Runnable
{
  private String a;
  private int b;
  private InetSocketAddress c;
  
  public a(String paramString, int paramInt)
  {
    this.a = paramString;
    this.b = paramInt;
  }
  
  public static InetSocketAddress a(String paramString, int paramInt, long paramLong)
  {
    try
    {
      paramString = new a(paramString, paramInt);
      Thread localThread = new Thread(paramString);
      localThread.start();
      localThread.join(paramLong);
      paramString = paramString.a();
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public InetSocketAddress a()
  {
    try
    {
      InetSocketAddress localInetSocketAddress = this.c;
      return localInetSocketAddress;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void a(InetSocketAddress paramInetSocketAddress)
  {
    try
    {
      this.c = paramInetSocketAddress;
      return;
    }
    finally
    {
      paramInetSocketAddress = finally;
      throw paramInetSocketAddress;
    }
  }
  
  public void run()
  {
    try
    {
      a(new InetSocketAddress(this.a, this.b));
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oicq\wlogin_sdk\request\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */