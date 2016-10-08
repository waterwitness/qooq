import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class xty
{
  private int a;
  private int b;
  
  private xty()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a()
  {
    return this.a;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public int b()
  {
    return this.b;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\xty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */