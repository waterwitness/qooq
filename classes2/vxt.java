import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.FPSCalculator;
import com.tencent.qphone.base.util.QLog;

public class vxt
  implements Choreographer.FrameCallback
{
  public vxt(FPSCalculator paramFPSCalculator)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void doFrame(long paramLong)
  {
    paramLong = FPSCalculator.a(paramLong);
    if (FPSCalculator.a(this.a) <= 0L) {
      FPSCalculator.a(this.a, paramLong);
    }
    for (;;)
    {
      FPSCalculator.a(this.a).postFrameCallback(this.a.a);
      return;
      long l = paramLong - FPSCalculator.a(this.a);
      FPSCalculator.a(this.a);
      if (l > FPSCalculator.b(this.a))
      {
        double d = FPSCalculator.c(this.a) * 1000 / l;
        FPSCalculator.a(this.a, paramLong);
        FPSCalculator.a(this.a, 0);
        if (QLog.isColorLevel()) {
          QLog.d("FPSCalculator", 2, "FPS = " + d);
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vxt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */