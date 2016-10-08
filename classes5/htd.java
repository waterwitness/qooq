import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.VideoUIController;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;

public class htd
  implements TVK_IMediaPlayer.OnVideoPreparedListener
{
  public htd(VideoUIController paramVideoUIController)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (!this.a.f) {
      return;
    }
    this.a.l = 0;
    this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
    this.a.d();
    paramTVK_IMediaPlayer = this.a.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298791);
    if ((this.a.jdField_a_of_type_Boolean) && (paramTVK_IMediaPlayer.getVisibility() == 8))
    {
      this.a.jdField_a_of_type_AndroidOsHandler.post(new hte(this));
      this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(new htf(this), 3000L);
    }
    this.a.jdField_a_of_type_Boolean = false;
    this.a.jdField_a_of_type_AndroidOsHandler.post(new htg(this));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\htd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */