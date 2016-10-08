import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Comparator;

public final class wcz
  implements Comparator
{
  public wcz()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(wda paramwda1, wda paramwda2)
  {
    return (paramwda1.c - paramwda2.c) * 100 + (paramwda1.e - paramwda2.e) * 10 + (paramwda1.d - paramwda2.d);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\wcz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */