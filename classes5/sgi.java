import android.view.View;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.PhotoFileViewBase;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

public class sgi
  implements AdapterView.OnItemClickListener
{
  public sgi(PhotoFileViewBase paramPhotoFileViewBase)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.a;
    if (!this.a.a) {}
    for (boolean bool = true;; bool = false)
    {
      paramAdapterView.a = bool;
      if (PhotoFileViewBase.c(this.a) != null) {
        PhotoFileViewBase.d(this.a).a(this.a.a);
      }
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sgi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */