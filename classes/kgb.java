import com.tencent.mfsdk.collector.DropFrameMonitor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.util.AbstractUnifiedMonitor.ThreadMonitorCallback;

public class kgb
  implements AbstractUnifiedMonitor.ThreadMonitorCallback
{
  public kgb(DropFrameMonitor paramDropFrameMonitor)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onThreadMonitorEnd(int paramInt)
  {
    if (paramInt == 10) {
      DropFrameMonitor.a(this.a);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\kgb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */