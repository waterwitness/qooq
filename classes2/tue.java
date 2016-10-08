import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.portal.PortalManager.TimerConfig;
import java.util.Comparator;

public final class tue
  implements Comparator
{
  public tue()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(PortalManager.TimerConfig paramTimerConfig1, PortalManager.TimerConfig paramTimerConfig2)
  {
    long l = paramTimerConfig1.uiBegin - paramTimerConfig2.uiBegin;
    if (l > 0L) {
      return 1;
    }
    if (l < 0L) {
      return -1;
    }
    return 0;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */