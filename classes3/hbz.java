import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.sharp.jni.TraeAudioSession.ITraeAudioCallback;

public final class hbz
  implements TraeAudioSession.ITraeAudioCallback
{
  public hbz()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(int paramInt, String paramString) {}
  
  public void a(int paramInt, String paramString, boolean paramBoolean) {}
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void a(int paramInt, String[] paramArrayOfString, String paramString1, String paramString2, String paramString3) {}
  
  public void a(String paramString, long paramLong) {}
  
  public void a(String paramString1, String paramString2) {}
  
  public void a(boolean paramBoolean) {}
  
  public void a(String[] paramArrayOfString, String paramString1, String paramString2, String paramString3) {}
  
  public void b(int paramInt) {}
  
  public void b(int paramInt, String paramString) {}
  
  public void b(boolean paramBoolean) {}
  
  public void c(int paramInt, String paramString)
  {
    if (UITools.a != null) {
      UITools.a.onCompletion((MediaPlayer)null);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\hbz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */