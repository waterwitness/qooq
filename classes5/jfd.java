import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.troopplugin.PluginJumpManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class jfd
  implements AsyncBack
{
  public jfd(PluginJumpManager paramPluginJumpManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt) {}
  
  public void a(String paramString, int paramInt)
  {
    if (paramInt == 0) {
      HtmlOffline.a("urlplugin.cfg", this.a.mContext, "1007", new jfe(this));
    }
    while (!TextUtils.isEmpty(this.a.mPref.getString("config_file_version", ""))) {
      return;
    }
    this.a.loadConfigFromFile();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jfd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */