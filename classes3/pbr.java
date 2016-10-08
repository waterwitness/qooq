import android.widget.ProgressBar;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;

class pbr
  implements Runnable
{
  pbr(pbp parampbp)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    QQToast.a(this.a.a.a, "音乐下载失败，请稍后重试", 1).a();
    NewFlowCameraActivity.a(this.a.a.a).setVisibility(8);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pbr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */