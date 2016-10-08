import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class rpq
  implements View.OnClickListener
{
  public rpq(UniformDownloadActivity paramUniformDownloadActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    this.a.finish();
    this.a.overridePendingTransition(0, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rpq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */