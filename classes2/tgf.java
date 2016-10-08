import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.music.IQQPlayerService;
import com.tencent.mobileqq.music.IQQPlayerService.Stub;
import com.tencent.mobileqq.musicgene.MusicGeneWebViewPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import org.json.JSONObject;

public class tgf
  implements ServiceConnection
{
  public tgf(MusicGeneWebViewPlugin paramMusicGeneWebViewPlugin)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    MusicGeneWebViewPlugin.a(this.a, IQQPlayerService.Stub.a(paramIBinder));
    try
    {
      MusicGeneWebViewPlugin.a(this.a).a(MusicGeneWebViewPlugin.a(this.a));
      if (MusicGeneWebViewPlugin.a(this.a) != null)
      {
        paramComponentName = new JSONObject();
        paramComponentName.put("code", "0");
        MusicGeneWebViewPlugin.a(this.a).a(paramComponentName);
        MusicGeneWebViewPlugin.a(this.a, null);
      }
      return;
    }
    catch (Exception paramComponentName)
    {
      paramComponentName.printStackTrace();
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    try
    {
      if (MusicGeneWebViewPlugin.a(this.a) != null) {
        MusicGeneWebViewPlugin.a(this.a).b(MusicGeneWebViewPlugin.a(this.a));
      }
      if (MusicGeneWebViewPlugin.a(this.a) != null)
      {
        paramComponentName = new JSONObject();
        paramComponentName.put("code", "1");
        MusicGeneWebViewPlugin.a(this.a).a(paramComponentName);
        MusicGeneWebViewPlugin.a(this.a, null);
      }
    }
    catch (Exception paramComponentName)
    {
      for (;;)
      {
        paramComponentName.printStackTrace();
      }
    }
    MusicGeneWebViewPlugin.a(this.a, null);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tgf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */