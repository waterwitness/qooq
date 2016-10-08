import com.dataline.util.DLRouterSessionListAdapter;
import com.tencent.litetransfersdk.ProgressInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Comparator;

public class cx
  implements Comparator
{
  public cx(DLRouterSessionListAdapter paramDLRouterSessionListAdapter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a(ProgressInfo paramProgressInfo1, ProgressInfo paramProgressInfo2)
  {
    if (paramProgressInfo1.GetWeight() > paramProgressInfo2.GetWeight()) {}
    do
    {
      return 1;
      if (paramProgressInfo1.GetWeight() < paramProgressInfo2.GetWeight()) {
        return -1;
      }
      if (paramProgressInfo1.GetTime() > paramProgressInfo2.GetTime()) {
        return -1;
      }
    } while (paramProgressInfo1.GetTime() < paramProgressInfo2.GetTime());
    return 0;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */