import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoPlayMgr;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadinjoyVideoReportData;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;

public class hru
  implements TVK_IMediaPlayer.OnErrorListener
{
  public hru(VideoPlayMgr paramVideoPlayMgr)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.VideoPlayMgr", 2, "mMediaPlayer onError model=" + paramInt1 + ", what, " + paramInt2 + ", extra=" + paramInt3 + ", detailInfo=" + paramString);
    }
    VideoPlayMgr.a(this.a, false);
    paramTVK_IMediaPlayer = "";
    if (TextUtils.isEmpty(this.a.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID"))) {
      paramTVK_IMediaPlayer = this.a.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID");
    }
    ReportController.b(null, "CliOper", "", "", "0X8006757", "0X8006757", 0, 0, "5", Integer.toString(paramInt2), this.a.d, paramTVK_IMediaPlayer);
    this.a.f = 1;
    this.a.jdField_a_of_type_AndroidOsHandler.post(new hrv(this, paramInt1, paramInt2));
    PublicAccountUtil.a(this.a.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_ARTICLE_ID"), this.a.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID"), 1, paramInt2);
    if (VideoPlayMgr.a(this.a) != null)
    {
      VideoPlayMgr.a(this.a).jdField_a_of_type_Boolean = false;
      VideoPlayMgr.a(this.a).jdField_b_of_type_JavaLangString = ("model : " + paramInt1 + " what : " + paramInt2);
      if (VideoPlayMgr.a(this.a).jdField_a_of_type_Long > 0L)
      {
        paramTVK_IMediaPlayer = VideoPlayMgr.a(this.a);
        paramTVK_IMediaPlayer.jdField_b_of_type_Long += SystemClock.uptimeMillis() - VideoPlayMgr.a(this.a).jdField_a_of_type_Long;
      }
      ReadInJoyUtils.a(this.a.jdField_a_of_type_AndroidAppActivity, ReadInJoyUtils.a(), false, VideoPlayMgr.a(this.a).a());
      VideoPlayMgr.a(this.a, null);
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hru.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */