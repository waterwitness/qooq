import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import com.tencent.biz.pubaccount.VideoPlayMgr;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadinjoyVideoReportData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;

public class hrs
  implements TVK_IMediaPlayer.OnCompletionListener
{
  public hrs(VideoPlayMgr paramVideoPlayMgr)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.pubaccount.video.VideoPlayMgr", 2, "TVK_IMediaPlayer.OnCompletionListener() onCompletion() ");
    }
    VideoPlayMgr.a(this.a, false);
    this.a.g = false;
    this.a.f = 2;
    this.a.jdField_a_of_type_AndroidOsHandler.post(new hrt(this));
    if (VideoPlayMgr.a(this.a) != null)
    {
      paramTVK_IMediaPlayer = VideoPlayMgr.a(this.a);
      paramTVK_IMediaPlayer.jdField_b_of_type_Long += SystemClock.uptimeMillis() - VideoPlayMgr.a(this.a).jdField_a_of_type_Long;
      VideoPlayMgr.a(this.a).jdField_a_of_type_Boolean = true;
      VideoPlayMgr.a(this.a).jdField_b_of_type_Boolean = true;
      ReadInJoyUtils.a(this.a.jdField_a_of_type_AndroidAppActivity, ReadInJoyUtils.a(), true, VideoPlayMgr.a(this.a).a());
      VideoPlayMgr.a(this.a, null);
    }
    if ((this.a.jdField_a_of_type_AndroidOsBundle.containsKey("isFromKandian")) && (this.a.jdField_a_of_type_AndroidOsBundle.getBoolean("isFromKandian"))) {
      VideoReporter.a(this.a.jdField_a_of_type_AndroidOsBundle.getString("innderId"), (int)this.a.jdField_a_of_type_AndroidOsBundle.getLong("channelID", 0L), (int)this.a.jdField_a_of_type_AndroidOsBundle.getLong("algorithmID", 0L), (int)this.a.jdField_a_of_type_AndroidOsBundle.getLong("strategyId", 0L), 12, Integer.valueOf(this.a.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_TIME")).intValue() * 1000);
    }
    ReportController.b(null, "CliOper", "", "", "0X80069A9", "0X80069A9", 0, 0, "2", "", Long.toString(this.a.jdField_a_of_type_AndroidOsBundle.getLong("VIDEO_TIME", 0L)), this.a.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID"));
    ReportController.b(null, "dc00899", "Pb_account_lifeservice", "", "0X800709B", "0X800709B", 0, 0, "", "", "", this.a.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID"));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hrs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */