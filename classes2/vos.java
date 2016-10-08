import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.TVKTroopVideoManager;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;

class vos
  implements Runnable
{
  vos(vor paramvor, TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Vor.a.a != null) {
      this.jdField_a_of_type_Vor.a.a.onCompletion(this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */