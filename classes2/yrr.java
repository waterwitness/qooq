import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.remote.logic.WebEventListener;
import cooperation.qzone.webviewplugin.QzoneQunFeedJsPlugin;

public class yrr
  implements WebEventListener
{
  public yrr(QzoneQunFeedJsPlugin paramQzoneQunFeedJsPlugin)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onWebEvent(String paramString, Bundle paramBundle)
  {
    if ("cmd.troop.download.photo".equals(paramString))
    {
      paramString = paramBundle.getBundle("data");
      paramString.getInt("totalNum");
      int i = paramString.getInt("successNum");
      int j = paramString.getInt("failNum");
      boolean bool = paramString.getBoolean("isDownloadCanceled");
      paramString = paramString.getString("path");
      QzoneQunFeedJsPlugin.a(this.a, i, j, paramString, bool);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yrr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */