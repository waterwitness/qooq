import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.ISearchable;
import java.util.Comparator;

public final class ukf
  implements Comparator
{
  public ukf()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(ISearchable paramISearchable1, ISearchable paramISearchable2)
  {
    long l1 = paramISearchable1.d();
    long l2 = paramISearchable2.d();
    if (l1 < l2) {
      return 1;
    }
    if (l1 > l2) {
      return -1;
    }
    return 0;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ukf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */