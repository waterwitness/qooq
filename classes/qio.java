import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.automator.step.AfterSyncMsg;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.concurrent.atomic.AtomicBoolean;

public class qio
  implements Runnable
{
  public qio(AfterSyncMsg paramAfterSyncMsg)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (!BmqqSegmentUtil.a.get()) {
      BmqqSegmentUtil.a(BaseApplicationImpl.getContext());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qio.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */