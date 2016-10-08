import android.widget.ProgressBar;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class pbs
  implements Runnable
{
  pbs(pbp parampbp)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    NewFlowCameraActivity.a(this.a.a.a).setVisibility(8);
    if (this.a.a.a.j)
    {
      NewFlowCameraActivity.b(this.a.a.a, false);
      return;
    }
    NewFlowCameraActivity.c(this.a.a.a, false);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pbs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */