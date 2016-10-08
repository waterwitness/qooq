import com.tencent.biz.pubaccount.VideoPlayMgr;
import com.tencent.biz.pubaccount.readinjoy.common.ThirdVidoeManager;
import com.tencent.biz.pubaccount.readinjoy.common.ThirdVidoeManager.UUIDToUrlCallback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

public class hrz
  implements ThirdVidoeManager.UUIDToUrlCallback
{
  public hrz(VideoPlayMgr paramVideoPlayMgr, long paramLong)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.pubaccount.video.VideoPlayMgr", 2, "ThirdVidoeManager UUIDToUrlCallback() url=" + paramString1 + ", vid=" + paramString2);
    }
    if (!VideoPlayMgr.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayMgr, null, null, this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayMgr.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo))
    {
      VideoPlayMgr.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayMgr, false);
      this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayMgr.c();
    }
    if ((VideoPlayMgr.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayMgr) != null) && (VideoPlayMgr.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayMgr) != null)) {
      VideoPlayMgr.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayMgr).j = VideoPlayMgr.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayMgr).a.longValue();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayMgr.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayMgr.jdField_a_of_type_AndroidAppActivity, paramString1, this.jdField_a_of_type_Long, 0L, this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayMgr.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hrz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */