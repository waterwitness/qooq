import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalMusicFileView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class set
  implements View.OnClickListener
{
  public set(LocalMusicFileView paramLocalMusicFileView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (LocalMusicFileView.a(this.a))
    {
      LocalMusicFileView.a(this.a);
      return;
    }
    LocalMusicFileView.b(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\set.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */