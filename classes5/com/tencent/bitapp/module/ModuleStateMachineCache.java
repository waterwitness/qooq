package com.tencent.bitapp.module;

import com.tencent.bitapp.utils.AbstractBitAppCache;

public class ModuleStateMachineCache
  extends AbstractBitAppCache<ModuleStateMachine>
{
  private static final int DEFAULT_MAP_CAPACITY = 500;
  
  private ModuleStateMachineCache()
  {
    super(500);
  }
  
  public static final ModuleStateMachineCache getInstance()
  {
    return Holder.INSTANCE;
  }
  
  protected ModuleStateMachine create(String paramString, Object... paramVarArgs)
  {
    paramString = new ModuleStateMachine(paramString);
    paramString.init();
    paramString.start();
    return paramString;
  }
  
  private static class Holder
  {
    private static final ModuleStateMachineCache INSTANCE = new ModuleStateMachineCache(null);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\bitapp\module\ModuleStateMachineCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */