import com.tencent.mobileqq.app.CircleManager;
import com.tencent.mobileqq.data.CircleBuddy;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Comparator;

public class pva
  implements Comparator
{
  public pva(CircleManager paramCircleManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(CircleBuddy paramCircleBuddy1, CircleBuddy paramCircleBuddy2)
  {
    return paramCircleBuddy2.randomCloseness - paramCircleBuddy1.randomCloseness;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pva.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */