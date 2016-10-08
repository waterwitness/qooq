import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.mobileqq.camera.QQCameraActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public final class qyp
  extends OrientationEventListener
{
  public qyp(QQCameraActivity paramQQCameraActivity, Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onOrientationChanged(int paramInt)
  {
    if (paramInt == -1) {}
    do
    {
      return;
      QQCameraActivity.d(this.a, (paramInt + 45) / 90 * 90);
    } while ((QQCameraActivity.e(this.a) >= 0) || (!QLog.isColorLevel()));
    QLog.i("Q.camera.CameraActivity", 2, "[onOrientationChanged] origi: " + paramInt + " new:" + QQCameraActivity.e(this.a));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qyp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */