import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;

public class ynd
  implements DialogInterface.OnClickListener
{
  public ynd(QzoneWebMusicJsPlugin paramQzoneWebMusicJsPlugin)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.stopPlay();
    QzoneWebMusicJsPlugin.access$000(this.a, "cancel");
    paramDialogInterface.dismiss();
    QzoneWebMusicJsPlugin.access$302(this.a, false);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ynd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */