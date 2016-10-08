import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;

public class ymw
  implements View.OnClickListener
{
  public ymw(QzoneWebMusicJsPlugin paramQzoneWebMusicJsPlugin)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    QzoneWebMusicJsPlugin.access$000(this.a, "buttonclick");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ymw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */