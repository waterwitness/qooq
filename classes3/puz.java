import com.tencent.mobileqq.app.CircleManager;
import com.tencent.mobileqq.data.CircleGroup;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Comparator;

public class puz
  implements Comparator
{
  public puz(CircleManager paramCircleManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(CircleGroup paramCircleGroup1, CircleGroup paramCircleGroup2)
  {
    return paramCircleGroup1.showIndex - paramCircleGroup2.showIndex;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\puz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */