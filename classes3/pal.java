import android.view.View;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.concurrent.atomic.AtomicInteger;

public class pal
  implements ActionSheet.OnButtonClickListener
{
  public pal(NewFlowCameraActivity paramNewFlowCameraActivity)
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
    this.a.a.a("PTV.NewFlowCameraActivity");
    this.a.o();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */