import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ThirdVidoeManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreloadMgr;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreloadReportData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class iao
  implements Runnable
{
  VideoPlayManager.VideoPlayParam jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam;
  VideoPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager;
  VideoPreloadReportData jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreloadReportData;
  
  public iao(VideoPreloadMgr paramVideoPreloadMgr, VideoPlayManager.VideoPlayParam paramVideoPlayParam, VideoPlayManager paramVideoPlayManager, VideoPreloadReportData paramVideoPreloadReportData)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam = paramVideoPlayParam;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager = paramVideoPlayManager;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreloadReportData = paramVideoPreloadReportData;
  }
  
  public void a(VideoPlayerWrapper paramVideoPlayerWrapper, VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    if ((paramVideoPlayerWrapper == null) || (paramVideoPlayParam == null) || (TextUtils.isEmpty(paramVideoPlayParam.jdField_a_of_type_JavaLangString))) {}
    for (;;)
    {
      return;
      VideoPreloadMgr.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreloadMgr, paramVideoPlayerWrapper);
      VideoPreloadMgr.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreloadMgr, paramVideoPlayParam);
      if (QLog.isColorLevel()) {
        QLog.i("Q.readinjoy.video", 2, "[preload]:" + paramVideoPlayParam.jdField_a_of_type_JavaLangString + ", busiType =" + paramVideoPlayParam.e + ", articleID =" + paramVideoPlayParam.jdField_a_of_type_Long);
      }
      paramVideoPlayerWrapper.m();
      paramVideoPlayerWrapper.a(Long.valueOf(paramVideoPlayParam.jdField_a_of_type_Long));
      if (paramVideoPlayParam.e == 2)
      {
        ThirdVidoeManager localThirdVidoeManager = ThirdVidoeManager.a();
        localThirdVidoeManager.a(new iap(this, paramVideoPlayerWrapper));
        localThirdVidoeManager.a(paramVideoPlayParam.jdField_a_of_type_JavaLangString);
      }
      while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreloadReportData != null)
      {
        paramVideoPlayerWrapper = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreloadReportData;
        paramVideoPlayerWrapper.a += 1;
        return;
        paramVideoPlayerWrapper.a(paramVideoPlayParam.jdField_a_of_type_JavaLangString, 2, 0L);
      }
    }
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam != null) {
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\iao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */