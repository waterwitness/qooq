import android.graphics.Bitmap;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadinjoyVideoReportData;
import com.tencent.biz.pubaccount.readinjoy.video.VideoAutoPlayController;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper.MediaPlayListenerAdapter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreloadMgr;
import com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeControl;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class hzu
  extends VideoPlayerWrapper.MediaPlayListenerAdapter
{
  public hzu(VideoPlayManager paramVideoPlayManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(VideoPlayerWrapper paramVideoPlayerWrapper)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "video play completion!");
    }
    VideoPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_b_of_type_Boolean = true;
    ReportController.b(null, "dc00899", "Pb_account_lifeservice", "", "0X800709B", "0X800709B", 0, 0, "", "", "", VideoPlayManager.a(this.a).jdField_a_of_type_JavaLangString);
    this.a.a.post(new hzy(this));
  }
  
  public void a(VideoPlayerWrapper paramVideoPlayerWrapper, Object paramObject)
  {
    if (paramObject != null)
    {
      paramVideoPlayerWrapper.a(null);
      if (VideoPlayManager.a(this.a) != null) {
        VideoPlayManager.a(this.a).a(((Long)paramObject).longValue());
      }
    }
    if ((paramObject != null) && (VideoPlayManager.a(this.a) != null) && (((Long)paramObject).longValue() != VideoPlayManager.a(this.a).jdField_a_of_type_Long))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.readinjoy.video", 2, "[preload] video player prepared, tag = " + (Long)paramObject);
      }
      if (VideoPlayManager.a(this.a) != null) {
        VideoPlayManager.a(this.a).a((Long)paramObject, paramVideoPlayerWrapper);
      }
    }
    do
    {
      Properties localProperties;
      do
      {
        return;
        if ((VideoPlayManager.a(this.a) != paramVideoPlayerWrapper) || (VideoPlayManager.a(this.a) == null)) {
          break;
        }
        VideoPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.d = (SystemClock.uptimeMillis() - VideoPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.c);
        paramObject = VideoPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData;
        ((ReadinjoyVideoReportData)paramObject).f += VideoPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.d;
        paramObject = VideoPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData;
        ((ReadinjoyVideoReportData)paramObject).jdField_b_of_type_Int += 1;
        VideoPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Long = SystemClock.uptimeMillis();
        if ((VideoPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData != null) && (QLog.isColorLevel())) {
          QLog.d("Q.readinjoy.video", 2, "video player ready. from open. prepare cost : " + VideoPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.d);
        }
        if ((VideoVolumeControl.a(VideoPlayManager.a(this.a))) || (!GesturePWDUtils.isAppOnForeground(VideoPlayManager.a(this.a))) || (VideoPlayManager.a(this.a) == null) || (!VideoPlayManager.a(this.a).b()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.video", 2, "onVideoPrepared start,in call stop.background:" + GesturePWDUtils.isAppOnForeground(VideoPlayManager.a(this.a)));
          }
          this.a.a.post(new hzv(this));
        }
        for (;;)
        {
          localProperties = paramVideoPlayerWrapper.a().getPlayDetailsTime();
          StringBuilder localStringBuilder = new StringBuilder(256);
          Object localObject;
          if ((VideoPlayManager.a(this.a) != null) && (VideoPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData != null))
          {
            paramObject = VideoPlayManager.a(this.a).jdField_a_of_type_JavaLangString;
            localObject = localStringBuilder.append("视频vid : ");
            paramVideoPlayerWrapper = (VideoPlayerWrapper)paramObject;
            if (paramObject == null) {
              paramVideoPlayerWrapper = "";
            }
            ((StringBuilder)localObject).append(paramVideoPlayerWrapper).append("首帧耗时 : ").append(VideoPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.d).append("ms\n");
          }
          if (localProperties == null) {
            break;
          }
          paramVideoPlayerWrapper = new StringBuilder(256);
          paramObject = localProperties.keySet().iterator();
          while (((Iterator)paramObject).hasNext())
          {
            localObject = ((Iterator)paramObject).next();
            paramVideoPlayerWrapper.append(localObject).append(" ：").append(localProperties.get(localObject)).append("\n");
            localStringBuilder.append(localProperties.get(localObject)).append("ms/");
          }
          paramVideoPlayerWrapper.d();
          this.a.a.post(new hzw(this));
          this.a.a(0, VideoPlayManager.a(this.a));
          if ((VideoPlayManager.a(this.a) != null) && (VideoPlayManager.a(this.a) != null)) {
            VideoPlayManager.a(this.a).a(VideoPlayManager.a(this.a).g);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "onVideoPrepared : PlayDetailsTime => \n" + paramVideoPlayerWrapper.toString());
        }
      } while ((VideoPlayManager.a(this.a) == null) || (VideoPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData == null));
      VideoPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.g = Long.valueOf(localProperties.getProperty("httpdnsMS")).longValue();
      VideoPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.h = Long.valueOf(localProperties.getProperty("httpredirectMS")).longValue();
      VideoPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.i = Long.valueOf(localProperties.getProperty("cacheframeMS")).longValue();
      if (1 == VideoPlayManager.a(this.a).e) {
        VideoPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.j = Long.valueOf(localProperties.getProperty("vidtourlMS")).longValue();
      }
      VideoPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.k = Long.valueOf(localProperties.getProperty("httpfirstrecvMS")).longValue();
      VideoPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.l = Long.valueOf(localProperties.getProperty("getmp4headerMS")).longValue();
      VideoPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.m = Long.valueOf(localProperties.getProperty("httpconnectMS")).longValue();
      return;
    } while (!QLog.isColorLevel());
    QLog.d("Q.readinjoy.video", 2, "video player ready,but has error!");
  }
  
  public void a(VideoPlayerWrapper paramVideoPlayerWrapper, boolean paramBoolean, int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "onCaptureImage , id : " + paramInt2 + " succ : " + paramBoolean + " errCode : " + paramInt1);
    }
    if (VideoPlayManager.a(this.a).size() >= 10)
    {
      paramVideoPlayerWrapper = (Pair)VideoPlayManager.a(this.a).remove(0);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "Capture Image Pool full ! remove first image, id : " + paramVideoPlayerWrapper.first);
      }
    }
    if (paramBoolean) {
      VideoPlayManager.a(this.a).add(new Pair(Integer.valueOf(paramInt2), paramBitmap));
    }
    ((VideoPlayerWrapper)VideoPlayManager.a(this.a).get(Integer.valueOf(paramInt2))).l();
  }
  
  public boolean a(VideoPlayerWrapper paramVideoPlayerWrapper, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("model : ").append(paramInt1).append(" what : ").append(paramInt2).append(" extra : ").append(paramInt3).append("detailInfo : ").append(paramString).append(" obj : ");
    if (paramObject != null)
    {
      paramString = paramObject.toString();
      paramString = paramString;
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "video play has error ! " + paramString);
      }
      if (VideoPlayManager.a(this.a) != null) {
        PublicAccountUtil.a(VideoPlayManager.a(this.a).i, VideoPlayManager.a(this.a).jdField_a_of_type_JavaLangString, 1, paramInt2);
      }
      if (paramVideoPlayerWrapper == VideoPlayManager.a(this.a)) {
        if (paramInt2 != 10001) {
          break label264;
        }
      }
    }
    label264:
    for (paramString = "1";; paramString = "2")
    {
      if ((VideoPlayManager.a(this.a) != null) && (!TextUtils.isEmpty(VideoPlayManager.a(this.a).jdField_a_of_type_JavaLangString))) {
        ReportController.b(null, "CliOper", "", "", "0X8006758", "0X8006758", 0, 0, "", paramString, "", VideoPlayManager.a(this.a).jdField_a_of_type_JavaLangString);
      }
      this.a.a.post(new hzz(this, paramInt1, paramInt2, paramVideoPlayerWrapper));
      return true;
      paramString = "";
      break;
    }
  }
  
  public boolean a(VideoPlayerWrapper paramVideoPlayerWrapper, int paramInt, Object paramObject)
  {
    if (paramVideoPlayerWrapper == VideoPlayManager.a(this.a)) {
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "video start buffering !");
      }
      this.a.a.post(new iaa(this));
      if (VideoPlayManager.a(this.a) != null)
      {
        VideoPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.e = SystemClock.uptimeMillis();
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "video end buffering !");
        }
        this.a.a.post(new iab(this));
        if (VideoPlayManager.a(this.a) != null)
        {
          paramVideoPlayerWrapper = VideoPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData;
          paramVideoPlayerWrapper.f += SystemClock.uptimeMillis() - VideoPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.e;
          paramVideoPlayerWrapper = VideoPlayManager.a(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData;
          paramVideoPlayerWrapper.jdField_b_of_type_Int += 1;
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hzu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */