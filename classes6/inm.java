import com.tencent.biz.qqstory.pgc.view.VideoContentView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;

public class inm
  implements TVK_IMediaPlayer.OnErrorListener
{
  public inm(VideoContentView paramVideoContentView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    return this.a.c();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\inm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */