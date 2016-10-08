package cooperation.troop;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class TroopBaseProxyActivity
  extends PluginProxyActivity
{
  public TroopBaseProxyActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static Dialog a(Activity paramActivity)
  {
    paramActivity = new QQProgressDialog(paramActivity, paramActivity.getResources().getDimensionPixelSize(2131492908));
    paramActivity.a("正在加载...");
    return paramActivity;
  }
  
  public String getPluginID()
  {
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\troop\TroopBaseProxyActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */