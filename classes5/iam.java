import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPluginInstall;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPluginInstall.OnVideoPluginInstallListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class iam
  implements Handler.Callback
{
  public iam(VideoPluginInstall paramVideoPluginInstall)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 0: 
    case 1: 
      do
      {
        do
        {
          return true;
          VideoPluginInstall.a(this.a, false);
          VideoPluginInstall.a(this.a).removeMessages(0);
        } while (VideoPluginInstall.a(this.a) == null);
        VideoPluginInstall.a(this.a).b(true);
        return true;
        VideoPluginInstall.a(this.a, false);
        VideoPluginInstall.a(this.a).removeMessages(1);
      } while (VideoPluginInstall.a(this.a) == null);
      VideoPluginInstall.a(this.a).b(false);
      return true;
    }
    VideoPluginInstall.a(this.a, true);
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\iam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */