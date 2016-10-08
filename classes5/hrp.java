import com.tencent.biz.pubaccount.VideoPlayActivity;
import com.tencent.biz.pubaccount.readinjoy.common.ThirdVidoeManager.UUIDToUrlCallback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

public class hrp
  implements ThirdVidoeManager.UUIDToUrlCallback
{
  public hrp(VideoPlayActivity paramVideoPlayActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(this.a, paramString1, 0L, 0L, this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hrp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */