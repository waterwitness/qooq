import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.conditionsearch.data.BaseAddress;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Comparator;

public class pvn
  implements Comparator
{
  public pvn(ConditionSearchManager paramConditionSearchManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(BaseAddress paramBaseAddress1, BaseAddress paramBaseAddress2)
  {
    int j = paramBaseAddress1.d.compareTo(paramBaseAddress2.d);
    int i = j;
    if (j == 0) {
      i = paramBaseAddress1.c.compareTo(paramBaseAddress2.c);
    }
    return i;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pvn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */