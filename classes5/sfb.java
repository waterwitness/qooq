import android.graphics.drawable.Drawable;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.BaseActionBar;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalSimpleFileView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalTbsViewManager.LocalTbsViewManagerCallback;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class sfb
  implements LocalTbsViewManager.LocalTbsViewManagerCallback
{
  public sfb(LocalSimpleFileView paramLocalSimpleFileView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(String paramString, Drawable paramDrawable1, Drawable paramDrawable2, View.OnClickListener paramOnClickListener)
  {
    if ((LocalSimpleFileView.a(this.a) instanceof FileBrowserActivity))
    {
      BaseActionBar localBaseActionBar = ((FileBrowserActivity)LocalSimpleFileView.b(this.a)).a();
      if (localBaseActionBar != null)
      {
        localBaseActionBar.a(LocalSimpleFileView.c(this.a), paramString, paramDrawable1, paramDrawable2, paramOnClickListener);
        localBaseActionBar.b(LocalSimpleFileView.d(this.a));
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    LocalSimpleFileView.a(this.a).a(paramBoolean);
  }
  
  public void b(boolean paramBoolean) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sfb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */