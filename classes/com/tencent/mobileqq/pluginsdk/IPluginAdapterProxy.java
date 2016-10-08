package com.tencent.mobileqq.pluginsdk;

public class IPluginAdapterProxy
{
  static IPluginAdapterProxy a;
  private IPluginAdapter b;
  
  private IPluginAdapterProxy(IPluginAdapter paramIPluginAdapter)
  {
    this.b = paramIPluginAdapter;
  }
  
  public static IPluginAdapterProxy getProxy()
  {
    return a;
  }
  
  public static void setProxy(IPluginAdapter paramIPluginAdapter)
  {
    a = new IPluginAdapterProxy(paramIPluginAdapter);
  }
  
  public boolean isNightMode()
  {
    IPluginAdapter localIPluginAdapter = this.b;
    if (localIPluginAdapter == null) {
      return false;
    }
    return ((Boolean)localIPluginAdapter.invoke(1, null)).booleanValue();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\pluginsdk\IPluginAdapterProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */