import android.os.SystemClock;
import com.tencent.biz.pubaccount.VideoPlayMgr;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadinjoyVideoReportData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnInfoListener;

public class hrw
  implements TVK_IMediaPlayer.OnInfoListener
{
  public hrw(VideoPlayMgr paramVideoPlayMgr)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.VideoPlayMgr", 2, "onInfo what=" + paramInt);
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      return false;
      this.a.c();
      if (VideoPlayMgr.a(this.a) != null)
      {
        VideoPlayMgr.a(this.a).e = SystemClock.uptimeMillis();
        continue;
        this.a.e();
        if (VideoPlayMgr.a(this.a) != null)
        {
          paramTVK_IMediaPlayer = VideoPlayMgr.a(this.a);
          paramTVK_IMediaPlayer.f += SystemClock.uptimeMillis() - VideoPlayMgr.a(this.a).e;
          paramTVK_IMediaPlayer = VideoPlayMgr.a(this.a);
          paramTVK_IMediaPlayer.b += 1;
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hrw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */