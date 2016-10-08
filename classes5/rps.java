import com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ActionSheet.OnDismissListener;

public class rps
  implements ActionSheet.OnDismissListener
{
  public rps(UniformDownloadActivity paramUniformDownloadActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss()
  {
    this.a.finish();
    this.a.overridePendingTransition(0, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rps.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */