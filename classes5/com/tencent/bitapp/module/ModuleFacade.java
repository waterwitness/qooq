package com.tencent.bitapp.module;

import com.facebook.common.logging.FLog;
import com.tencent.bitapp.bundle.BundleStruct;
import com.tencent.bitapp.bundle.BundleStructCache;
import com.tencent.bitapp.thread.ThreadManager;

public class ModuleFacade
{
  private static final String TAG = ModuleFacade.class.getSimpleName();
  
  private static boolean checkIsUpdate(BundleStruct paramBundleStruct, boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (!paramBoolean)
    {
      bool = paramBoolean;
      if (paramBundleStruct != null)
      {
        BundleStruct localBundleStruct = BundleStructCache.INSTANCE.get(paramBundleStruct.module_id);
        int i = -1;
        if (localBundleStruct != null) {
          i = localBundleStruct.module_version;
        }
        int j = paramBundleStruct.module_version;
        if (FLog.isLoggable(3)) {
          FLog.i(TAG, "getModule newModuleVersion: " + j + " | cacheModuleVersion: " + i);
        }
        bool = paramBoolean;
        if (j > i) {
          bool = true;
        }
      }
    }
    return bool;
  }
  
  public static void getModule(BundleStruct paramBundleStruct, final IModuleListener paramIModuleListener, final boolean paramBoolean)
  {
    if (FLog.isLoggable(3)) {
      FLog.i(TAG, "getModule for struct: " + paramBundleStruct + " | listener: " + paramIModuleListener);
    }
    paramBoolean = checkIsUpdate(paramBundleStruct, paramBoolean);
    ThreadManager.INSTANCE.execute(new Runnable()
    {
      public void run()
      {
        if (ModuleFacade.this == null)
        {
          if (paramIModuleListener != null) {
            paramIModuleListener.onLoadFail("", 2);
          }
          while (!FLog.isLoggable(3)) {
            return;
          }
          FLog.i(ModuleFacade.TAG, "getModule input struct is null and listener is null");
          return;
        }
        Object localObject2 = ModuleFacade.this.getKey();
        if ((!paramBoolean) && (ModuleCache.getInstance().isExistInCache((String)localObject2)))
        {
          localObject1 = (Module)ModuleCache.getInstance().get((String)localObject2, new Object[0]);
          paramIModuleListener.onLoadSuccess((String)localObject2, (Module)localObject1);
          return;
        }
        Object localObject1 = (ModuleStateMachine)ModuleStateMachineCache.getInstance().get((String)localObject2, new Object[0]);
        if (FLog.isLoggable(3)) {
          FLog.i(ModuleFacade.TAG, localObject2 + " moduleStateMachine is " + localObject1);
        }
        ((ModuleStateMachine)localObject1).addListener(paramIModuleListener);
        localObject2 = ((ModuleStateMachine)localObject1).getCurrentState();
        if ((localObject2 != null) && ((localObject2.equals(((ModuleStateMachine)localObject1).mInitState)) || (localObject2.equals(((ModuleStateMachine)localObject1).mLoadFail)) || (localObject2.equals(((ModuleStateMachine)localObject1).mLoadSuccess)))) {
          ((ModuleStateMachine)localObject1).setBundleStruct(ModuleFacade.this);
        }
        localObject2 = ((ModuleStateMachine)localObject1).mBundleStruct;
        boolean bool = paramBoolean;
        if ((localObject2 != null) && (ModuleFacade.this != null) && (((BundleStruct)localObject2).module_version < ModuleFacade.this.module_version)) {
          ((ModuleStateMachine)localObject1).setBundleStruct(ModuleFacade.this);
        }
        if ((bool) && (!((ModuleStateMachine)localObject1).mIsUpdate)) {
          ((ModuleStateMachine)localObject1).setUpdate(bool);
        }
        ((ModuleStateMachine)localObject1).sendMessage(((ModuleStateMachine)localObject1).obtainMessage(1));
      }
    });
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\bitapp\module\ModuleFacade.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */