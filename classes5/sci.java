import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarLocalFile.ActionBarLocalMusciFile;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class sci
  implements View.OnClickListener
{
  public sci(ActionBarLocalMusciFile paramActionBarLocalMusciFile)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    long l = this.a.a.a().b();
    if (FileManagerUtil.a()) {
      FMDialogUtil.a(this.a.a.getActivity(), 2131362855, 2131362851, new scj(this, l));
    }
    while (this.a.a.f())
    {
      FileManagerReporter.a("0X8004BBB");
      return;
      this.a.a.a().a().a(l);
      this.a.k();
    }
    FileManagerReporter.a("0X8004BD1");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sci.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */