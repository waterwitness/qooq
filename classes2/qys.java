import android.hardware.Camera.Parameters;
import android.os.Handler;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import com.tencent.mobileqq.camera.CameraManager.CameraProxy;
import com.tencent.mobileqq.camera.QQCameraActivity;
import com.tencent.mobileqq.camera.ui.QProgressZoomUI;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class qys
  implements ScaleGestureDetector.OnScaleGestureListener
{
  private qys(QQCameraActivity paramQQCameraActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    boolean bool3 = false;
    int i = 0;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (QQCameraActivity.f(this.a))
    {
      bool2 = bool1;
      if (QQCameraActivity.a(this.a) != null)
      {
        bool2 = bool1;
        if (QQCameraActivity.a(this.a) != null)
        {
          if (QQCameraActivity.a(this.a).get()) {
            break label70;
          }
          bool2 = bool1;
        }
      }
    }
    label70:
    do
    {
      return bool2;
      bool2 = bool1;
    } while (QQCameraActivity.a(this.a).get() != 0);
    QQCameraActivity.a(this.a, QQCameraActivity.a(this.a).a());
    int j = QQCameraActivity.a(this.a);
    int k;
    if (paramScaleGestureDetector.getCurrentSpan() >= paramScaleGestureDetector.getPreviousSpan() + QQCameraActivity.b(this.a))
    {
      k = (int)(Math.abs(paramScaleGestureDetector.getCurrentSpan() - paramScaleGestureDetector.getPreviousSpan()) / QQCameraActivity.b(this.a));
      bool1 = bool3;
      if (j + 1 < QQCameraActivity.c(this.a))
      {
        j = Math.max(j + 1, j + k);
        i = j;
        if (j > QQCameraActivity.c(this.a)) {
          i = QQCameraActivity.c(this.a);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.camera.CameraActivity", 4, "[onScale] zoomOut=" + i + " ScaleFactor=" + QQCameraActivity.b(this.a) + " diff=" + k + " old=" + paramScaleGestureDetector.getPreviousSpan() + " new=" + paramScaleGestureDetector.getCurrentSpan() + " factor=" + paramScaleGestureDetector.getScaleFactor());
        }
        QQCameraActivity.a(this.a).setZoom(i);
        QQCameraActivity.a(this.a).a(QQCameraActivity.a(this.a));
        QQCameraActivity.a(this.a).setProgress(i);
        bool1 = true;
      }
    }
    do
    {
      do
      {
        QQCameraActivity.a(this.a, QQCameraActivity.a(this.a).getZoom());
        bool2 = bool1;
        if (!bool1) {
          break;
        }
        bool2 = bool1;
        if (QQCameraActivity.a(this.a).hasMessages(8)) {
          break;
        }
        QQCameraActivity.a(this.a).removeMessages(9);
        QQCameraActivity.a(this.a).sendEmptyMessage(8);
        return bool1;
        bool1 = bool3;
      } while (paramScaleGestureDetector.getCurrentSpan() > paramScaleGestureDetector.getPreviousSpan() - QQCameraActivity.b(this.a));
      k = (int)(Math.abs(paramScaleGestureDetector.getCurrentSpan() - paramScaleGestureDetector.getPreviousSpan()) / QQCameraActivity.b(this.a));
      bool1 = bool3;
    } while (j - 1 < 0);
    j = Math.min(j - 1, j - k);
    if (j < 0) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.camera.CameraActivity", 4, "[onScale] zoomIn=" + i + " ScaleFactor=" + QQCameraActivity.b(this.a) + " diff=" + k + " old=" + paramScaleGestureDetector.getPreviousSpan() + " new=" + paramScaleGestureDetector.getCurrentSpan() + " factor=" + paramScaleGestureDetector.getScaleFactor());
      }
      QQCameraActivity.a(this.a).setZoom(i);
      QQCameraActivity.a(this.a).a(QQCameraActivity.a(this.a));
      QQCameraActivity.a(this.a).setProgress(i);
      break;
      i = j;
    }
  }
  
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    return true;
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector) {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qys.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */