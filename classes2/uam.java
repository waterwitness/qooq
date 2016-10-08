import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.qzonealbumreddot.QzoneAlbumRedTouchManager;

public class uam
  implements Runnable
{
  public uam(QzoneAlbumRedTouchManager paramQzoneAlbumRedTouchManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    SharedPreferences.Editor localEditor = QzoneAlbumRedTouchManager.a(this.a).edit().putLong("key_photo_guide_has_red_date", System.currentTimeMillis());
    if (Build.VERSION.SDK_INT < 9)
    {
      localEditor.commit();
      return;
    }
    localEditor.apply();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */