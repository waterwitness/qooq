import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Comparator;
import java.util.Map.Entry;

public final class kfx
  implements Comparator
{
  public kfx()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int compare(Object paramObject1, Object paramObject2)
  {
    int i = ((Integer)((Map.Entry)paramObject1).getValue()).intValue();
    int j = ((Integer)((Map.Entry)paramObject2).getValue()).intValue();
    if (i == j) {
      return 0;
    }
    if (i < j) {
      return 2;
    }
    return -1;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\kfx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */