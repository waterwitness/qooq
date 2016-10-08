import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ncf
  extends ThreadLocal
{
  private static final int a = 1024;
  
  public ncf()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected char[] a()
  {
    return new char['Ѐ'];
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ncf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */