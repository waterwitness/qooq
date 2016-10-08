import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Comparator;

public class qfb
  implements Comparator
{
  public qfb()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(qfa paramqfa1, qfa paramqfa2)
  {
    if (paramqfa1.b < paramqfa2.b) {
      return -1;
    }
    if (paramqfa1.b > paramqfa2.b) {
      return 1;
    }
    return 0;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qfb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */