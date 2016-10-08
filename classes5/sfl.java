import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalVideoFileView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class sfl
  implements View.OnClickListener
{
  public sfl(LocalVideoFileView paramLocalVideoFileView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (LocalVideoFileView.a(this.a))
    {
      LocalVideoFileView.a(this.a);
      return;
    }
    LocalVideoFileView.b(this.a);
    new Handler().postDelayed(new sfm(this), 2000L);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sfl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */