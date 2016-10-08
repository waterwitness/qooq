import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalVideoFileView;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class sfm
  implements Runnable
{
  sfm(sfl paramsfl)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    LocalVideoFileView.a(this.a.a).setVisibility(8);
    if ((LocalVideoFileView.a(this.a.a) != null) && (LocalVideoFileView.b(this.a.a) != null))
    {
      LocalVideoFileView.a(this.a.a).setVisibility(8);
      LocalVideoFileView.b(this.a.a).setVisibility(8);
    }
    if (LocalVideoFileView.a(this.a.a) != null) {
      LocalVideoFileView.b(this.a.a).a(true);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sfm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */