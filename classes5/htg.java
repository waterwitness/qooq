import android.app.Activity;
import android.view.Window;
import com.tencent.biz.pubaccount.VideoUIController;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

class htg
  implements Runnable
{
  htg(htd paramhtd)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.a.jdField_a_of_type_AndroidAppActivity.getWindow().addFlags(128);
    this.a.a.a(this.a.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getDuration());
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\htg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */