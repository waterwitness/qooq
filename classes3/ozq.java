import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ozq
  extends OrientationEventListener
{
  public ozq(FlowCameraActivity2 paramFlowCameraActivity2, Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onOrientationChanged(int paramInt)
  {
    this.a.k = paramInt;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ozq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */