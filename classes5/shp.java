import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewMusicService;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class shp
  extends BroadcastReceiver
{
  public shp(FileViewMusicService paramFileViewMusicService)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("android.media.AUDIO_BECOMING_NOISY")) {
      this.a.a();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\shp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */