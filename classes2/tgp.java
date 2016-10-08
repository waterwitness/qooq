import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.music.IQQPlayerService;
import com.tencent.mobileqq.music.IQQPlayerService.Stub;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.musicgene.MusicPlayerActivity;
import com.tencent.mobileqq.musicgene.MusicPlayerHandler;
import java.util.HashMap;

public class tgp
  implements ServiceConnection
{
  public tgp(MusicPlayerActivity paramMusicPlayerActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    MusicPlayerActivity.a(this.a, IQQPlayerService.Stub.a(paramIBinder));
    try
    {
      MusicPlayerActivity.a(this.a).a(MusicPlayerActivity.a(this.a));
      paramComponentName = MusicPlayerActivity.a(this.a).a();
      paramIBinder = MusicPlayerActivity.a(this.a, MusicPlayerActivity.a(this.a), paramComponentName, -1L);
      if (paramComponentName != null)
      {
        String str = MusicPlayerActivity.a(this.a, paramComponentName);
        if (MusicPlayerActivity.b().containsKey(str)) {
          MusicPlayerActivity.a(this.a, (tgv)MusicPlayerActivity.b().get(str), paramIBinder);
        }
        for (;;)
        {
          int i = MusicPlayerActivity.a(this.a).a();
          Message.obtain(MusicPlayerActivity.a(this.a), 50, i, 0).sendToTarget();
          MusicPlayerActivity.a(this.a).a(this.a.app.getLongAccountUin(), paramComponentName.b, paramComponentName.g, paramComponentName.f, String.valueOf(paramComponentName.a), paramComponentName.c, MusicPlayerActivity.a(this.a).c());
          return;
          MusicPlayerActivity.a(this.a, paramComponentName.b, paramComponentName.g, paramComponentName.d, paramIBinder, false, false);
        }
      }
      return;
    }
    catch (Exception paramComponentName) {}
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    paramComponentName = MusicPlayerActivity.a(this.a);
    if (paramComponentName != null) {}
    try
    {
      paramComponentName.b(MusicPlayerActivity.a(this.a));
      return;
    }
    catch (RemoteException paramComponentName) {}
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tgp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */