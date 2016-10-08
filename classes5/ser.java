import android.app.Activity;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.CanPreviewOfflineFileView;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewListener;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.TipsClickedInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;

public class ser
  implements FileManagerUtil.TipsClickedInterface
{
  public ser(CanPreviewOfflineFileView paramCanPreviewOfflineFileView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(View paramView)
  {
    CanPreviewOfflineFileView.a(this.a).b(1);
    if (!NetworkUtil.e(BaseApplicationImpl.getContext())) {
      FMToastUtil.a(CanPreviewOfflineFileView.a(this.a).getString(2131362941));
    }
    do
    {
      return;
      CanPreviewOfflineFileView.a(this.a).a(true);
      CanPreviewOfflineFileView.b(this.a).b(false);
    } while (CanPreviewOfflineFileView.b(this.a) == null);
    CanPreviewOfflineFileView.c(this.a).b();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */