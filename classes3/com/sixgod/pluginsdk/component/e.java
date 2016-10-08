package com.sixgod.pluginsdk.component;

import android.os.Looper;
import com.sixgod.pluginsdk.SixGodHelper;
import com.sixgod.pluginsdk.log.a;

final class e
  implements Runnable
{
  e(ContainerActivity paramContainerActivity) {}
  
  public final void run()
  {
    a.a("SixGod_Now", "开始在子线程加载插件");
    Looper.prepare();
    this.a.d.pluginLoadCallBack = this.a.j;
    SixGodHelper.loadPlugin(this.a.getApplicationContext(), this.a.d);
    this.a.runOnUiThread(new f(this));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\sixgod\pluginsdk\component\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */