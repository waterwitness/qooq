import com.tencent.mfsdk.collector.DropFrameMonitor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.UnifiedMonitor;

public class uus
  implements Runnable
{
  public uus(UnifiedMonitor paramUnifiedMonitor)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    DropFrameMonitor.a().a();
    if (this.a.whetherReportDuringThisStartup(10)) {
      DropFrameMonitor.a().b();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\uus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */