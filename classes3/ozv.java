import android.view.View;
import com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2;
import com.tencent.mobileqq.activity.richmedia.FlowCameraMqqAction;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.concurrent.atomic.AtomicInteger;

public class ozv
  implements ActionSheet.OnButtonClickListener
{
  public ozv(FlowCameraActivity2 paramFlowCameraActivity2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    if (this.a.a.b.get() == 4) {
      this.a.b(false);
    }
    this.a.a.a("FlowCameraActivity");
    this.a.o();
    FlowCameraMqqAction.b("", "0X800656F", "0");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ozv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */