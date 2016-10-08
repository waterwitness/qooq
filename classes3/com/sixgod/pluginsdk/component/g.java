package com.sixgod.pluginsdk.component;

import com.sixgod.pluginsdk.SixGodHelper;

final class g
  implements Runnable
{
  g(ContainerActivity paramContainerActivity) {}
  
  public final void run()
  {
    SixGodHelper.loadPlugin(this.a.getApplicationContext(), this.a.d);
    this.a.runOnUiThread(new h(this));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\sixgod\pluginsdk\component\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */