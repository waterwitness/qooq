import com.tencent.biz.qqstory.pgc.view.VideoContentView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;

public class inl
  implements TVK_IMediaPlayer.OnCompletionListener
{
  public inl(VideoContentView paramVideoContentView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    this.a.p();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\inl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */