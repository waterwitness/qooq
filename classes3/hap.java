import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import com.tencent.av.ui.GLVideoView;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class hap
  extends ScaleGestureDetector.SimpleOnScaleGestureListener
{
  public hap(VideoLayerUI paramVideoLayerUI)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoLayerUI", 2, "onScale");
    }
    if (this.a.e < 0) {
      this.a.e = ((int)paramScaleGestureDetector.getFocusX());
    }
    if (this.a.f < 0) {
      this.a.f = ((int)paramScaleGestureDetector.getFocusY());
    }
    float f = paramScaleGestureDetector.getScaleFactor();
    this.a.a[0].a(f, this.a.e, this.a.f);
    return true;
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoLayerUI", 2, "onScaleEnd");
    }
    float f1 = this.a.a[0].c();
    float f2 = this.a.a[0].a();
    float f3 = this.a.a[0].b();
    if (f1 < f2) {
      this.a.a(this.a.a[0], f2 / f1, 60L);
    }
    while (f1 <= f3) {
      return;
    }
    this.a.a(this.a.a[0], f3 / f1, 60L);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\hap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */