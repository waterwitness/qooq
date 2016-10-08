import com.tencent.maxvideo.mediaplay.TMMNativeVideoPlayer;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.mediaplay.TMMSWVideoView;

public class urw
  implements Runnable
{
  public urw(TMMSWVideoView paramTMMSWVideoView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      this.a.mNativeVideoPlayer.init(this.a);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\urw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */