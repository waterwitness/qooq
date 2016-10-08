package cooperation.plugin;

import android.app.Activity;
import android.content.res.Resources;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;

public class PluginBaseActivity
  extends BasePluginActivity
{
  public boolean q;
  
  public PluginBaseActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.q = true;
  }
  
  protected boolean a()
  {
    return false;
  }
  
  protected String b()
  {
    return getString(2131367975);
  }
  
  public final Activity getActivity()
  {
    return this;
  }
  
  public int getTitleBarHeight()
  {
    return getResources().getDimensionPixelSize(2131492908);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\plugin\PluginBaseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */