import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.ProfileCardWebviewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebUiMethodInterface;
import com.tencent.util.URLUtil;

public class tuv
  extends BroadcastReceiver
{
  public tuv(ProfileCardWebviewPlugin paramProfileCardWebviewPlugin)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      return;
      paramContext = this.a.mRuntime.a();
    } while ((paramContext == null) || (paramContext.isFinishing()));
    paramIntent = this.a.mRuntime.a(this.a.mRuntime.a());
    if ((paramIntent != null) && ((paramIntent instanceof WebUiUtils.WebUiMethodInterface)))
    {
      paramIntent = ((WebUiUtils.WebUiMethodInterface)paramIntent).getCurrentUrl();
      if ((TextUtils.isEmpty(paramIntent)) || (!paramIntent.contains("entryId"))) {
        break label232;
      }
    }
    label232:
    for (this.a.a = URLUtil.a(URLUtil.a(paramIntent), "entryId", 2);; this.a.a = 2)
    {
      paramContext.finish();
      paramContext = new Intent(this.a.mRuntime.a(), FriendProfileCardActivity.class);
      paramIntent = new ProfileActivity.AllInOne(this.a.mRuntime.a().a(), 0);
      if (this.a.a == 0) {
        paramContext.setFlags(67108864);
      }
      paramContext.putExtra("AllInOne", paramIntent);
      this.a.mRuntime.a().startActivity(paramContext);
      paramContext = new Intent();
      paramContext.putExtra("closeSpecialLogic", true);
      this.a.mRuntime.a().setResult(-1, paramContext);
      this.a.mRuntime.a().finish();
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tuv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */