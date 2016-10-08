package cooperation.comic;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import yae;

public class PluginPreloader
{
  private static final String a = "PluginPreloader";
  
  public PluginPreloader()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(PluginPreloadStrategy paramPluginPreloadStrategy)
  {
    if ((paramPluginPreloadStrategy == null) || (paramPluginPreloadStrategy.b == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PluginPreloader", 2, "the preload strategy or target process is null.");
      }
      return;
    }
    ThreadManager.a(new yae(paramPluginPreloadStrategy), 5, null, false);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\comic\PluginPreloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */