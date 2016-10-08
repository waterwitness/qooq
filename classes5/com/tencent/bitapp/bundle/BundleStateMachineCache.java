package com.tencent.bitapp.bundle;

import com.tencent.bitapp.utils.AbstractBitAppCache;

public class BundleStateMachineCache
  extends AbstractBitAppCache<BundleStateMachine>
{
  private static final int DEFAULT_MAP_CAPACITY = 50;
  
  private BundleStateMachineCache()
  {
    super(50);
  }
  
  public static final BundleStateMachineCache getInstance()
  {
    return Holder.INSTANCE;
  }
  
  protected BundleStateMachine create(String paramString, Object... paramVarArgs)
  {
    paramString = new BundleStateMachine(paramString);
    paramString.init();
    paramString.start();
    return paramString;
  }
  
  private static class Holder
  {
    private static final BundleStateMachineCache INSTANCE = new BundleStateMachineCache(null);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\bitapp\bundle\BundleStateMachineCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */