import android.graphics.drawable.Drawable;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalTbsViewManager.LocalTbsViewManagerCallback;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class sem
  implements LocalTbsViewManager.LocalTbsViewManagerCallback
{
  public sem(FileBrowserActivity paramFileBrowserActivity, IFileViewerAdapter paramIFileViewerAdapter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(String paramString, Drawable paramDrawable1, Drawable paramDrawable2, View.OnClickListener paramOnClickListener) {}
  
  public void a(boolean paramBoolean) {}
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserActivity.runOnUiThread(new sen(this, paramBoolean));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */