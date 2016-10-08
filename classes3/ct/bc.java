package ct;

public final class bc
{
  private static volatile boolean a = false;
  private static volatile boolean b = false;
  private static volatile boolean c = false;
  
  public static void a()
  {
    boolean bool = a;
    bool = b;
  }
  
  public static void b()
  {
    boolean bool = a;
    bool = b;
  }
  
  public static void c()
  {
    boolean bool = a;
    bool = b;
  }
  
  public static void d()
  {
    boolean bool = a;
    bool = b;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ct\bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */