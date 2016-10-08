import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import com.tencent.biz.pubaccount.VideoPlayMgr;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadinjoyVideoReportData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class hsl
  implements TVK_IMediaPlayer.OnVideoPreparedListener
{
  public hsl(VideoPlayMgr paramVideoPlayMgr)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.pubaccount.video.VideoPlayMgr", 2, "TVK_IMediaPlayer.OnVideoPreparedListener() onVideoPrepared() ");
    }
    if (!this.a.g) {}
    Properties localProperties;
    do
    {
      StringBuilder localStringBuilder;
      Object localObject2;
      do
      {
        do
        {
          return;
          VideoPlayMgr.a(this.a, false);
          this.a.f = 0;
          this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
          this.a.e();
          if (this.a.jdField_a_of_type_AndroidOsHandler != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e("Q.pubaccount.video.VideoPlayMgr", 2, "TVK_IMediaPlayer.OnVideoPreparedListener(): mHandler == null ");
        return;
        VideoPlayMgr.a(this.a);
        this.a.jdField_a_of_type_AndroidOsHandler.post(new hsm(this));
        if (VideoPlayMgr.a(this.a) != null)
        {
          if (VideoPlayMgr.a(this.a).c > 0L)
          {
            VideoPlayMgr.a(this.a).d = (SystemClock.uptimeMillis() - VideoPlayMgr.a(this.a).c);
            VideoPlayMgr.a(this.a).c = 0L;
          }
          VideoPlayMgr.a(this.a).jdField_a_of_type_Long = SystemClock.uptimeMillis();
          paramTVK_IMediaPlayer = VideoPlayMgr.a(this.a);
          paramTVK_IMediaPlayer.f += VideoPlayMgr.a(this.a).d;
          paramTVK_IMediaPlayer = VideoPlayMgr.a(this.a);
          paramTVK_IMediaPlayer.b += 1;
        }
        localProperties = this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getPlayDetailsTime();
        localStringBuilder = new StringBuilder(256);
        localObject1 = this.a.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID");
        if (VideoPlayMgr.a(this.a) != null)
        {
          localObject2 = localStringBuilder.append("视频vid : ");
          paramTVK_IMediaPlayer = (TVK_IMediaPlayer)localObject1;
          if (localObject1 == null) {
            paramTVK_IMediaPlayer = "";
          }
          ((StringBuilder)localObject2).append(paramTVK_IMediaPlayer).append("首帧耗时 : ").append(VideoPlayMgr.a(this.a).d).append("ms\n");
        }
      } while (localProperties == null);
      paramTVK_IMediaPlayer = new StringBuilder(256);
      Object localObject1 = localProperties.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        paramTVK_IMediaPlayer.append(localObject2).append(" ：").append(localProperties.get(localObject2)).append("\n");
        localStringBuilder.append(localProperties.get(localObject2)).append("ms/");
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "onVideoPrepared : PlayDetailsTime => \n" + paramTVK_IMediaPlayer.toString());
      }
    } while (VideoPlayMgr.a(this.a) == null);
    VideoPlayMgr.a(this.a).g = Long.valueOf(localProperties.getProperty("httpdnsMS")).longValue();
    VideoPlayMgr.a(this.a).h = Long.valueOf(localProperties.getProperty("httpredirectMS")).longValue();
    VideoPlayMgr.a(this.a).i = Long.valueOf(localProperties.getProperty("cacheframeMS")).longValue();
    if (1 == VideoPlayMgr.a(this.a).jdField_a_of_type_Int) {
      VideoPlayMgr.a(this.a).j = Long.valueOf(localProperties.getProperty("vidtourlMS")).longValue();
    }
    VideoPlayMgr.a(this.a).k = Long.valueOf(localProperties.getProperty("httpfirstrecvMS")).longValue();
    VideoPlayMgr.a(this.a).l = Long.valueOf(localProperties.getProperty("getmp4headerMS")).longValue();
    VideoPlayMgr.a(this.a).m = Long.valueOf(localProperties.getProperty("httpconnectMS")).longValue();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hsl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */