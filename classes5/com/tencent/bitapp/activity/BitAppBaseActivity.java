package com.tencent.bitapp.activity;

import android.app.Activity;
import android.text.TextUtils;
import com.facebook.common.logging.FLog;
import com.facebook.react.ReactRootView;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.tencent.bitapp.bundle.BundleFacade;
import com.tencent.bitapp.bundle.BundleListener;
import com.tencent.bitapp.bundle.BundleStructCache;
import com.tencent.bitapp.manager.BitAppInstanceManager;
import java.lang.ref.WeakReference;

public abstract class BitAppBaseActivity
  extends Activity
  implements DefaultHardwareBackBtnHandler
{
  private static final String TAG = BitAppBaseActivity.class.getSimpleName();
  private ReactRootView mReactRootView;
  
  protected abstract void addView(ReactRootView paramReactRootView);
  
  protected abstract String getName();
  
  protected abstract int getVersion();
  
  public void invokeDefaultOnBackPressed()
  {
    super.onBackPressed();
  }
  
  protected boolean isDebug()
  {
    return false;
  }
  
  protected void onCreate(android.os.Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getName();
    getVersion();
    BundleFacade.loadBundle(BundleStructCache.INSTANCE.get(0), new WeakReference(new BundleListener()
    {
      public void onLoadFail(String paramAnonymousString, int paramAnonymousInt)
      {
        super.onLoadFail(paramAnonymousString, paramAnonymousInt);
        if ((!TextUtils.isEmpty(this.val$key)) && (this.val$key.equals(paramAnonymousString))) {
          if (FLog.isLoggable(3)) {
            FLog.i(BitAppBaseActivity.TAG, "load file fail");
          }
        }
        while (!FLog.isLoggable(3)) {
          return;
        }
        FLog.i(BitAppBaseActivity.TAG, "Ingore onLoadFail, because bundleName: " + this.val$key + " isn't same as rkey: " + paramAnonymousString);
      }
      
      public void onLoadSuccess(String paramAnonymousString, com.tencent.bitapp.bundle.Bundle paramAnonymousBundle)
      {
        super.onLoadSuccess(paramAnonymousString, paramAnonymousBundle);
        if ((!TextUtils.isEmpty(this.val$key)) && (this.val$key.equals(paramAnonymousString))) {
          BitAppBaseActivity.this.runOnUiThread(new Runnable()
          {
            public void run()
            {
              BitAppBaseActivity.this.mReactRootView = new ReactRootView(BitAppBaseActivity.this);
              if (BitAppInstanceManager.getInstance() != null)
              {
                BitAppBaseActivity.this.mReactRootView.startReactApplication(BitAppInstanceManager.getInstance(), this.val$key, null);
                BitAppBaseActivity.this.addView(BitAppBaseActivity.this.mReactRootView);
              }
            }
          });
        }
        while (!FLog.isLoggable(3)) {
          return;
        }
        FLog.i(BitAppBaseActivity.TAG, "Ingore onLoadSuccess, because bundleName: " + this.val$key + " isn't same as rkey: " + paramAnonymousString);
      }
    }));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\bitapp\activity\BitAppBaseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */