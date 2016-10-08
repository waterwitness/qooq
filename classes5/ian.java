import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreloadMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

public class ian
  extends Handler
{
  public ian(VideoPreloadMgr paramVideoPreloadMgr, Looper paramLooper)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
    } while ((VideoPreloadMgr.a(this.a) == null) || (VideoPreloadMgr.a(this.a) == null) || (VideoPreloadMgr.a(this.a).a != ((Long)paramMessage.obj).longValue()));
    VideoPreloadMgr.a(this.a).l();
    int i;
    if (VideoPreloadMgr.a(this.a) != null) {
      i = 0;
    }
    for (;;)
    {
      if (i < VideoPreloadMgr.a(this.a).size())
      {
        if (((VideoPlayManager.VideoPlayParam)VideoPreloadMgr.a(this.a).get(i)).a == VideoPreloadMgr.a(this.a).a) {
          VideoPreloadMgr.a(this.a).remove(i);
        }
      }
      else
      {
        VideoPreloadMgr.a(this.a, null);
        VideoPreloadMgr.a(this.a, null);
        VideoPreloadMgr.a(this.a);
        return;
      }
      i += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ian.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */