import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.t9search.T9SearchResultAdapter;
import com.tencent.mobileqq.t9search.T9SearchableData;
import java.util.Comparator;

public class uyg
  implements Comparator
{
  public uyg(T9SearchResultAdapter paramT9SearchResultAdapter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(T9SearchableData paramT9SearchableData1, T9SearchableData paramT9SearchableData2)
  {
    return -Long.valueOf(paramT9SearchableData1.a).compareTo(Long.valueOf(paramT9SearchableData2.a));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uyg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */