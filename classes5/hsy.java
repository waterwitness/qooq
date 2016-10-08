import android.os.Bundle;
import com.tencent.biz.pubaccount.VideoUIController;
import com.tencent.biz.pubaccount.readinjoy.common.ThirdVidoeManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_UserInfo;

public class hsy
  implements Runnable
{
  public hsy(VideoUIController paramVideoUIController)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) {
      return;
    }
    this.a.f = true;
    String str = this.a.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID");
    Object localObject = new TVK_UserInfo("", "");
    TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo(2, str, "");
    localTVK_PlayerVideoInfo.setConfigMap("keep_last_frame", "true");
    if (this.a.t == 2)
    {
      localObject = ThirdVidoeManager.a();
      ((ThirdVidoeManager)localObject).a(new hsz(this, localTVK_PlayerVideoInfo));
      ((ThirdVidoeManager)localObject).a(str);
    }
    for (;;)
    {
      this.a.b();
      return;
      localTVK_PlayerVideoInfo.setPlayMode("cache_video");
      this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayer(this.a.jdField_a_of_type_AndroidAppActivity, (TVK_UserInfo)localObject, localTVK_PlayerVideoInfo, "", 0L, 0L);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hsy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */