import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;

public class ync
  implements DialogInterface.OnClickListener
{
  public ync(QzoneWebMusicJsPlugin paramQzoneWebMusicJsPlugin)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.resumePlay();
    LocalMultiProcConfig.b("qzbg_music_mobinet_tips", true);
    paramDialogInterface.dismiss();
    QzoneWebMusicJsPlugin.access$302(this.a, false);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ync.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */