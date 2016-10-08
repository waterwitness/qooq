import com.tencent.biz.pubaccount.VideoPlayMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

public class hsa
  implements Runnable
{
  public hsa(VideoPlayMgr paramVideoPlayMgr, TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hsa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */