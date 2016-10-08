package com.tencent.mobileqq.pluginsdk;

import android.os.Bundle;

public abstract interface IPluginAdapter
{
  public static final int CMD_IS_NIGHT_MODE = 1;
  
  public abstract Object invoke(int paramInt, Bundle paramBundle);
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\pluginsdk\IPluginAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */