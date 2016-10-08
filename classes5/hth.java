import android.os.Bundle;
import android.os.Handler;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.VideoUIController;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;

public class hth
  implements TVK_IMediaPlayer.OnCompletionListener
{
  public hth(VideoUIController paramVideoUIController)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    long l = 0L;
    this.a.f = false;
    this.a.l = 2;
    this.a.jdField_a_of_type_AndroidOsHandler.post(new hti(this));
    int i = this.a.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_AIO_UIN_TYPE");
    int j = this.a.s;
    paramTVK_IMediaPlayer = this.a.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID");
    if (System.currentTimeMillis() - VideoUIController.a(this.a) < 0L) {}
    for (;;)
    {
      VideoReporter.a("0X80069BE", i, j, paramTVK_IMediaPlayer, Long.toString(l));
      return;
      l = System.currentTimeMillis() - VideoUIController.a(this.a);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hth.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */