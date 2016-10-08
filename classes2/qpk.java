import com.tencent.mobileqq.ar.FramePerformanceMonitor;
import com.tencent.mobileqq.ar.FramePerformanceMonitor.FrameRefreshListener;
import com.tencent.mobileqq.ar.GapDataCollector;
import com.tencent.mobileqq.ar.GapDataCollector.RefreshData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qpk
  implements Runnable
{
  public qpk(FramePerformanceMonitor paramFramePerformanceMonitor)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    for (;;)
    {
      try
      {
        if (FramePerformanceMonitor.a(this.a))
        {
          if (FramePerformanceMonitor.a(this.a).a() == 0) {
            Thread.sleep(FramePerformanceMonitor.a(this.a));
          }
        }
        else {
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      GapDataCollector.RefreshData localRefreshData = FramePerformanceMonitor.a(this.a).a();
      FramePerformanceMonitor.a(this.a).a(localRefreshData);
      Thread.sleep(FramePerformanceMonitor.a(this.a));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qpk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */