import android.view.View;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.ui.AVActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class gpm
  implements ActionSheet.OnButtonClickListener
{
  public gpm(AVActivity paramAVActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.a.a != null)
    {
      this.a.a.a();
      this.a.a.b();
    }
    this.a.l();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gpm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */