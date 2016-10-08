import android.view.Choreographer.FrameCallback;
import com.tencent.mfsdk.collector.DropFrameMonitor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class kga
  implements Choreographer.FrameCallback
{
  public kga(DropFrameMonitor paramDropFrameMonitor)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void doFrame(long paramLong)
  {
    this.a.a(paramLong);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\kga.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */