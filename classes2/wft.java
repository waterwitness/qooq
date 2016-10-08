import android.os.SystemClock;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.video.VipVideoPlayActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;

public class wft
  implements TVK_IMediaPlayer.OnErrorListener
{
  public wft(VipVideoPlayActivity paramVipVideoPlayActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      paramTVK_IMediaPlayer = new StringBuilder();
      paramTVK_IMediaPlayer.append("video player error model=" + paramInt1);
      paramTVK_IMediaPlayer.append(",what=" + paramInt2);
      paramTVK_IMediaPlayer.append(",extra=" + paramInt3);
      paramTVK_IMediaPlayer.append(",detailInfo=" + paramString);
      QLog.d("VipVideoPlayActivity", 2, paramTVK_IMediaPlayer.toString());
    }
    long l1 = SystemClock.elapsedRealtime();
    long l2 = VipVideoPlayActivity.b(this.a);
    this.a.a("play_error", paramInt1, paramInt2, l1 - l2, paramString);
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wft.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */