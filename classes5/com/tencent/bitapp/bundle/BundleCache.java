package com.tencent.bitapp.bundle;

import android.text.TextUtils;
import com.facebook.common.logging.FLog;
import com.tencent.bitapp.Const;
import com.tencent.bitapp.module.Module;
import com.tencent.bitapp.module.ModuleCache;
import com.tencent.bitapp.module.ModuleFacade;
import com.tencent.bitapp.module.ModuleListener;
import com.tencent.bitapp.statemachine.StateMachine;
import com.tencent.bitapp.utils.AbstractBitAppCache;

public class BundleCache
  extends AbstractBitAppCache<Bundle>
{
  private static final String TAG = BundleCache.class.getSimpleName();
  
  public static final BundleCache getInstance()
  {
    return Holder.INSTANCE;
  }
  
  public boolean combin(String paramString)
  {
    return Bundle.combin(paramString);
  }
  
  public boolean isExistInCache(String paramString)
  {
    if (Const.isTestPerformance) {
      FLog.i("bitapp_performance", "Check bundle exist or change for " + paramString);
    }
    boolean bool2 = super.isExistInCache(paramString);
    boolean bool1;
    if (bool2) {
      bool1 = ModuleCache.getInstance().isExistInFile(paramString);
    }
    do
    {
      return bool1;
      bool1 = bool2;
    } while (!FLog.isLoggable(3));
    FLog.i(TAG, "bundle key: " + paramString + " is not in cache");
    return bool2;
  }
  
  public void loadModule(BundleStruct paramBundleStruct, final StateMachine paramStateMachine, boolean paramBoolean)
  {
    final String str = paramBundleStruct.getKey();
    if (Const.isTestPerformance) {
      FLog.i("bitapp_performance", "Load module for " + str);
    }
    ModuleFacade.getModule(paramBundleStruct, new ModuleListener()
    {
      public void onLoadFail(String paramAnonymousString, int paramAnonymousInt)
      {
        if ((!TextUtils.isEmpty(paramAnonymousString)) && (paramAnonymousString.equals(str))) {
          paramStateMachine.sendMessage(paramStateMachine.obtainMessage(3));
        }
      }
      
      public void onLoadSuccess(String paramAnonymousString, Module paramAnonymousModule)
      {
        if ((!TextUtils.isEmpty(paramAnonymousString)) && (paramAnonymousString.equals(str))) {
          paramStateMachine.sendMessage(paramStateMachine.obtainMessage(2));
        }
      }
    }, paramBoolean);
  }
  
  private static class Holder
  {
    private static final BundleCache INSTANCE = new BundleCache();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\bitapp\bundle\BundleCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */