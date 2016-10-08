import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ThirdVidoeManager.UUIDToUrlCallback;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreloadMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

class iap
  implements ThirdVidoeManager.UUIDToUrlCallback
{
  iap(iao paramiao, VideoPlayerWrapper paramVideoPlayerWrapper)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(VideoPreloadMgr.a(), 2, "THIRD_VIDEO_TAGUUIDToUrlCallback Callback vid:" + paramString2 + " url:" + paramString1);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a(paramString2, paramString1, 2, 0L, 0L, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\iap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */