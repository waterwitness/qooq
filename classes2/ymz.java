import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;

public class ymz
  implements DialogInterface.OnClickListener
{
  public ymz(QzoneWebMusicJsPlugin paramQzoneWebMusicJsPlugin, int paramInt1, int paramInt2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = BaseApplication.getContext().getSharedPreferences("share", 0);
    if (Build.VERSION.SDK_INT >= 9) {
      paramDialogInterface.edit().putBoolean("qzone_bg_music_auto_play_warn_flag", false).apply();
    }
    for (;;)
    {
      QzoneWebMusicJsPlugin.access$200(this.jdField_a_of_type_CooperationQzoneMusicQzoneWebMusicJsPlugin, this.jdField_a_of_type_Int, this.b);
      return;
      paramDialogInterface.edit().putBoolean("qzone_bg_music_auto_play_warn_flag", false).commit();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ymz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */