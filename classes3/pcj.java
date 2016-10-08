import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class pcj
  extends OrientationEventListener
{
  public pcj(NewFlowCameraActivity paramNewFlowCameraActivity, Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onOrientationChanged(int paramInt)
  {
    if (this.a.j) {}
    do
    {
      return;
      if (paramInt == -1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PTV.NewFlowCameraActivity", 2, "OrientationEventListener unknown");
        }
        this.a.C = 90;
        return;
      }
      if ((paramInt > 315) || (paramInt < 45))
      {
        this.a.C = 90;
        return;
      }
      if ((paramInt > 45) && (paramInt < 135))
      {
        this.a.C = 180;
        return;
      }
      if ((paramInt > 135) && (paramInt < 225))
      {
        this.a.C = 270;
        return;
      }
    } while ((paramInt <= 225) || (paramInt >= 315));
    this.a.C = 0;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pcj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */