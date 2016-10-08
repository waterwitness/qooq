import android.media.MediaPlayer;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalVideoFileView.IGetTotalTime;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewMusicService;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class shn
  implements Runnable
{
  public shn(FileViewMusicService paramFileViewMusicService, String paramString, LocalVideoFileView.IGetTotalTime paramIGetTotalTime)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    MediaPlayer localMediaPlayer = new MediaPlayer();
    try
    {
      FileInputStream localFileInputStream = new FileInputStream(new File(this.jdField_a_of_type_JavaLangString));
      localMediaPlayer.setAudioStreamType(3);
      localMediaPlayer.setDataSource(localFileInputStream.getFD());
      localFileInputStream.close();
      localMediaPlayer.prepareAsync();
      localMediaPlayer.setOnPreparedListener(new sho(this, localMediaPlayer));
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      localIllegalArgumentException.printStackTrace();
      return;
    }
    catch (SecurityException localSecurityException)
    {
      localSecurityException.printStackTrace();
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      localIllegalStateException.printStackTrace();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      localNullPointerException.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\shn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */