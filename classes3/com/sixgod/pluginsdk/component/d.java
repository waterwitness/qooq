package com.sixgod.pluginsdk.component;

import com.sixgod.pluginsdk.log.a;

final class d
  implements Runnable
{
  d(c paramc) {}
  
  public final void run()
  {
    if (!this.a.a.i)
    {
      this.a.a.b();
      return;
    }
    a.a("SixGod_Now", "ContainerActivity, 插件加载成功，finish ContainerActivity");
    this.a.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\sixgod\pluginsdk\component\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */