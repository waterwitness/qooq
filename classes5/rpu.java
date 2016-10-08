import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.business.viareport.OpenSdkStatic;
import com.tencent.widget.ActionSheet;

public class rpu
  implements View.OnClickListener
{
  public rpu(UniformDownloadActivity paramUniformDownloadActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (this.a.a != null)
    {
      this.a.a.dismiss();
      this.a.a = null;
    }
    if (UniformDownloadActivity.a(this.a)) {
      OpenSdkStatic.a().a(UniformDownloadActivity.a(this.a), "1", "ANDROIDQQ.POPUP.YYBDOWNAPP", "3009", false);
    }
    for (;;)
    {
      this.a.finish();
      this.a.overridePendingTransition(0, 0);
      return;
      OpenSdkStatic.a().a(UniformDownloadActivity.a(this.a), "1", "ANDROIDQQ.POPUP.YYBDOWNAPP", "3006", false);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rpu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */