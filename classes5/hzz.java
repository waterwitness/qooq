import android.app.Activity;
import android.os.SystemClock;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadinjoyVideoReportData;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class hzz
  implements Runnable
{
  hzz(hzu paramhzu, int paramInt1, int paramInt2, VideoPlayerWrapper paramVideoPlayerWrapper)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (VideoPlayManager.a(this.jdField_a_of_type_Hzu.a) != null)
    {
      VideoPlayManager.a(this.jdField_a_of_type_Hzu.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_b_of_type_JavaLangString = ("model : " + this.jdField_a_of_type_Int + " what : " + this.b);
      if (VideoPlayManager.a(this.jdField_a_of_type_Hzu.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Long > 0L)
      {
        ReadinjoyVideoReportData localReadinjoyVideoReportData = VideoPlayManager.a(this.jdField_a_of_type_Hzu.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData;
        localReadinjoyVideoReportData.jdField_b_of_type_Long += SystemClock.uptimeMillis() - VideoPlayManager.a(this.jdField_a_of_type_Hzu.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Long;
        VideoPlayManager.a(this.jdField_a_of_type_Hzu.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Long = 0L;
      }
      VideoPlayManager.a(this.jdField_a_of_type_Hzu.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Boolean = false;
      ReadInJoyUtils.a(VideoPlayManager.a(this.jdField_a_of_type_Hzu.a).getApplicationContext(), ReadInJoyUtils.a(), false, VideoPlayManager.a(this.jdField_a_of_type_Hzu.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.a());
      this.jdField_a_of_type_Hzu.a.a(VideoPlayManager.a(this.jdField_a_of_type_Hzu.a).jdField_a_of_type_AndroidWidgetFrameLayout);
      if (VideoPlayManager.a(this.jdField_a_of_type_Hzu.a).b != null) {
        VideoPlayManager.a(this.jdField_a_of_type_Hzu.a).b.removeAllViews();
      }
      this.jdField_a_of_type_Hzu.a.a(2, this.jdField_a_of_type_Int, this.b);
    }
    VideoPlayManager.a(this.jdField_a_of_type_Hzu.a, null);
    VideoPlayManager.a(this.jdField_a_of_type_Hzu.a, null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.l();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hzz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */