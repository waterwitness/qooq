import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.filemanager.activity.MPFileFailedView;
import com.tencent.mobileqq.filemanager.activity.MPFileFailedView.MPFileFailedEvent;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarDataLineFile.BaseActionBarDataLineFile;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class sbw
  implements MPFileFailedView.MPFileFailedEvent
{
  public sbw(BaseActionBarDataLineFile paramBaseActionBarDataLineFile)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    this.a.b.setVisibility(8);
    this.a.a.a().removeView(this.a.b);
    BaseActionBarDataLineFile.a(this.a).a();
    BaseActionBarDataLineFile.a(this.a, null);
  }
  
  public void a(long paramLong)
  {
    BaseActionBarDataLineFile.a(this.a, paramLong);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sbw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */