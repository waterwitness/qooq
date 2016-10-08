package cooperation.qzone.plugin;

import android.content.Context;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import mqq.app.NewIntent;

public class PluginIntent
  extends NewIntent
{
  PluginIntent.OnResultListner a;
  public ArrayList a;
  
  public PluginIntent(Context paramContext, Class paramClass)
  {
    super(paramContext, paramClass);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public PluginIntent.OnResultListner a()
  {
    return this.a;
  }
  
  public void a(PluginIntent.OnResultListner paramOnResultListner)
  {
    this.a = paramOnResultListner;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\plugin\PluginIntent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */