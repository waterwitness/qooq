import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.music.QQPlayerService.QQPlayerCallback;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.musicpendant.MusicPendantListener;
import com.tencent.mobileqq.musicpendant.MusicPendantManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class tgw
  implements QQPlayerService.QQPlayerCallback
{
  public tgw(MusicPendantManager paramMusicPendantManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String getToken()
  {
    return MusicPendantManager.a();
  }
  
  public void onPlaySongChanged(SongInfo paramSongInfo)
  {
    try
    {
      Iterator localIterator = MusicPendantManager.a().iterator();
      while (localIterator.hasNext())
      {
        MusicPendantListener localMusicPendantListener = (MusicPendantListener)((WeakReference)localIterator.next()).get();
        if (localMusicPendantListener != null) {
          localMusicPendantListener.a(paramSongInfo);
        }
      }
      return;
    }
    catch (Exception paramSongInfo)
    {
      paramSongInfo.printStackTrace();
    }
  }
  
  public void onPlayStateChanged(int paramInt)
  {
    try
    {
      Iterator localIterator = MusicPendantManager.a().iterator();
      while (localIterator.hasNext())
      {
        MusicPendantListener localMusicPendantListener = (MusicPendantListener)((WeakReference)localIterator.next()).get();
        if (localMusicPendantListener != null) {
          localMusicPendantListener.a(paramInt);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tgw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */