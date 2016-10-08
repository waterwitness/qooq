import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.widget.ProgressBar;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class pbt
  implements Runnable
{
  pbt(pbn parampbn)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (NewFlowCameraActivity.a(this.a.a) == null)
    {
      NewFlowCameraActivity.a(this.a.a, (ProgressBar)this.a.a.a(2131301625));
      NewFlowCameraActivity.a(this.a.a).setProgressDrawable(new ClipDrawable(new ColorDrawable(Color.parseColor("#1ab5ee")), 3, 1));
      NewFlowCameraActivity.a(this.a.a).setBackgroundDrawable(new ColorDrawable(Color.parseColor("#4e000000")));
    }
    NewFlowCameraActivity.a(this.a.a).setVisibility(0);
    NewFlowCameraActivity.a(this.a.a).setProgress(0);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pbt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */