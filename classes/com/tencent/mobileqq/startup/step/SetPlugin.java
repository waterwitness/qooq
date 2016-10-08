package com.tencent.mobileqq.startup.step;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginRecoverReceiver;
import uua;

public class SetPlugin
  extends Step
{
  protected boolean a()
  {
    PluginRecoverReceiver.register(BaseApplicationImpl.a, new uua());
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\startup\step\SetPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */