import com.tencent.biz.pubaccount.readinjoy.common.ThirdVidoeManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class iae
  implements Runnable
{
  public iae(VideoPlayManager paramVideoPlayManager, VideoPlayerWrapper paramVideoPlayerWrapper, VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((VideoPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager) == null) || (VideoPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager) != this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("THIRD_VIDEO_TAG", 2, "busitype:" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.e + " vid:" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.a);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.e != 2) {
        break;
      }
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.a == null);
    ThirdVidoeManager localThirdVidoeManager = ThirdVidoeManager.a();
    localThirdVidoeManager.a(new iaf(this, localThirdVidoeManager));
    localThirdVidoeManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.a);
    for (;;)
    {
      PublicAccountUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.i, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.a, 0, 0);
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.a, 2, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.b);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\iae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */