import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ThirdVidoeManager;
import com.tencent.biz.pubaccount.readinjoy.common.ThirdVidoeManager.UUIDToUrlCallback;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

class iaf
  implements ThirdVidoeManager.UUIDToUrlCallback
{
  iaf(iae paramiae, ThirdVidoeManager paramThirdVidoeManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("THIRD_VIDEO_TAG", 2, "UUIDToUrlCallback Callback vid:" + paramString2 + " url:" + paramString1);
      }
      if ((VideoPlayManager.a(this.jdField_a_of_type_Iae.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager) != null) && (this.jdField_a_of_type_Iae.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != null) && (VideoPlayManager.a(this.jdField_a_of_type_Iae.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager) == this.jdField_a_of_type_Iae.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper) && (paramString2.equals(VideoPlayManager.a(this.jdField_a_of_type_Iae.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager).jdField_a_of_type_JavaLangString)))
      {
        VideoPlayManager.a(this.jdField_a_of_type_Iae.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager).f = paramString1;
        VideoPlayManager.a(this.jdField_a_of_type_Iae.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.j = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonThirdVidoeManager.a.longValue();
        this.jdField_a_of_type_Iae.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a(paramString2, paramString1, 2, VideoPlayManager.a(this.jdField_a_of_type_Iae.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager).b, VideoPlayManager.a(this.jdField_a_of_type_Iae.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager).c, VideoPlayManager.a(this.jdField_a_of_type_Iae.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager).jdField_a_of_type_Int);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("THIRD_VIDEO_TAG", 2, "vid2url换回来后，当前视频已经不再播放，vid:" + paramString2 + " url:" + paramString1);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\iaf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */