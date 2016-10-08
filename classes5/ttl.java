import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ttl
{
  public int a;
  public int b;
  
  private ttl()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String toString()
  {
    return "Type [type1=" + this.a + ", type2=" + this.b + "]";
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ttl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */