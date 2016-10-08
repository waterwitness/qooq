import com.tencent.maxvideo.mediaplay.TMMNativeVideoPlayer;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.mediaplay.TMMSWVideoView;

public class usa
  implements Runnable
{
  public usa(TMMSWVideoView paramTMMSWVideoView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.mIsQQ)
    {
      this.a.mNativeVideoPlayer.nativeStartRealFps(TMMSWVideoView.access$000(this.a), TMMSWVideoView.access$100(this.a));
      return;
    }
    this.a.mNativeVideoPlayer.nativeStart();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\usa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */