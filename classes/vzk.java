import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Comparator;

public final class vzk
  implements Comparator
{
  public vzk()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int compare(Object paramObject1, Object paramObject2)
  {
    long l1 = Long.parseLong(((String[])(String[])paramObject1)[1]);
    long l2 = Long.parseLong(((String[])(String[])paramObject2)[1]);
    if (l1 == l2) {
      return 0;
    }
    if (l1 < l2) {
      return 2;
    }
    return -1;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\vzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */