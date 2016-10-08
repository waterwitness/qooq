import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class seh
  implements View.OnClickListener
{
  public seh(FileBrowserActivity paramFileBrowserActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    FileBrowserActivity.b(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\seh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */