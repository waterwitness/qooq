import android.view.ScaleGestureDetector;
import com.tencent.mobileqq.activity.PortraitImageview;
import com.tencent.mobileqq.activity.PortraitImageview.SimpleOnScaleGestureListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class mag
  extends PortraitImageview.SimpleOnScaleGestureListener
{
  public mag(PortraitImageview paramPortraitImageview)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    if ((paramScaleGestureDetector != null) && (paramScaleGestureDetector.isInProgress())) {
      try
      {
        float f1 = this.a.a();
        float f2 = paramScaleGestureDetector.getScaleFactor();
        f1 = Math.min(this.a.e(), Math.max(f1 * f2, 0.1F));
        this.a.a(f1, paramScaleGestureDetector.getFocusX(), paramScaleGestureDetector.getFocusY());
        this.a.invalidate();
        return true;
      }
      catch (IllegalArgumentException paramScaleGestureDetector)
      {
        paramScaleGestureDetector.printStackTrace();
      }
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */