import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;

public class yng
  implements DialogInterface.OnClickListener
{
  public yng(QzoneWebMusicJsPlugin paramQzoneWebMusicJsPlugin)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.isFlowWarningVisible = false;
    QzoneWebMusicJsPlugin.access$000(this.a, "cancel");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yng.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */