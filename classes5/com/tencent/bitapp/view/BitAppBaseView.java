package com.tencent.bitapp.view;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import com.facebook.common.logging.FLog;
import com.facebook.react.ReactRootView;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.uimanager.TouchTargetHelper;
import com.tencent.bitapp.Const;
import com.tencent.bitapp.R.styleable;
import com.tencent.bitapp.bundle.BundleFacade;
import com.tencent.bitapp.bundle.BundleListener;
import com.tencent.bitapp.bundle.BundleStruct;
import com.tencent.bitapp.bundle.BundleStructCache;
import com.tencent.bitapp.manager.BitAppInstanceManager;
import com.tencent.bitapp.manager.BitAppInstanceManager.LoadBundleCallBack;
import com.tencent.bitapp.pre.binder.client.IJava2jniClient;
import com.tencent.bitapp.pre.binder.client.Java2jniClientFactory;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicInteger;

public class BitAppBaseView
  extends ReactRootView
  implements DefaultHardwareBackBtnHandler
{
  private static final int MAX_CLICK_DURATION = 200;
  private static final String TAG = BitAppBaseView.class.getSimpleName();
  private static final int TOUCH_SLOP = 20;
  public static final AtomicInteger ids = new AtomicInteger();
  private boolean isMoved;
  android.os.Bundle mExtra = null;
  String mFile = "";
  Handler mHandler = null;
  private int mLastMotionX;
  private int mLastMotionY;
  IBitAppBaseViewListener mListener = null;
  private Runnable mLongPressRunnable;
  String mModuleData = null;
  int mModuleId = 0;
  int mModuleVersion = 1;
  private View.OnTouchListener mOnTouchListener = null;
  private long startClickTime;
  
  public BitAppBaseView(Context paramContext)
  {
    super(paramContext);
  }
  
  public BitAppBaseView(Context paramContext, int paramInt)
    throws BitAppViewCreateExcepton
  {
    this(paramContext, paramInt, 1, "", "");
  }
  
  public BitAppBaseView(Context paramContext, int paramInt1, int paramInt2, String paramString)
    throws BitAppViewCreateExcepton
  {
    this(paramContext, paramInt1, paramInt2, paramString, "");
  }
  
  public BitAppBaseView(Context paramContext, int paramInt1, int paramInt2, String paramString1, android.os.Bundle paramBundle, IBitAppBaseViewListener paramIBitAppBaseViewListener, String paramString2)
    throws BitAppViewCreateExcepton
  {
    super(paramContext);
    this.mModuleId = paramInt1;
    this.mModuleVersion = paramInt2;
    this.mModuleData = paramString1;
    this.mExtra = paramBundle;
    this.mListener = paramIBitAppBaseViewListener;
    this.mFile = paramString2;
    initView(paramContext);
  }
  
  public BitAppBaseView(Context paramContext, int paramInt1, int paramInt2, String paramString1, String paramString2)
    throws BitAppViewCreateExcepton
  {
    this(paramContext, paramInt1, paramInt2, paramString1, null, null, paramString2);
  }
  
  public BitAppBaseView(Context paramContext, AttributeSet paramAttributeSet)
    throws BitAppViewCreateExcepton
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BitAppBaseView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    throws BitAppViewCreateExcepton
  {
    super(paramContext, paramAttributeSet, paramInt);
    setData(paramContext, paramAttributeSet, paramInt);
    initView(paramContext);
  }
  
  private void initView(Context paramContext)
    throws BitAppViewCreateExcepton
  {
    this.mLongPressRunnable = new Runnable()
    {
      public void run()
      {
        BitAppBaseView.this.performLongClick();
      }
    };
    if (Const.isTestPerformance) {
      FLog.i("bitapp_performance", "BitAppBaseView init mModuleId: " + this.mModuleId + " | mModuleVersion: " + this.mModuleVersion + " | mModuleData: " + this.mModuleData);
    }
    if (FLog.isLoggable(3)) {
      FLog.i(TAG, "BitAppBaseView init mModuleId: " + this.mModuleId + " | mModuleVersion: " + this.mModuleVersion + " | mModuleData: " + this.mModuleData);
    }
    if (this.mModuleId < 0)
    {
      if (FLog.isLoggable(3)) {
        FLog.i(TAG, "Create BitAppBaseView fail, because mModuleId is empty");
      }
      return;
    }
    this.mHandler = new Handler();
    int i = this.mModuleId;
    BundleStruct localBundleStruct = BundleStructCache.INSTANCE.get(this.mModuleId);
    paramContext = localBundleStruct;
    if (localBundleStruct.module_version < this.mModuleVersion)
    {
      paramContext = new BundleStruct(this.mModuleId);
      paramContext.module_version = this.mModuleVersion;
    }
    if (!TextUtils.isEmpty(this.mFile)) {
      paramContext.localFile = this.mFile;
    }
    BundleFacade.loadBundle(paramContext, new WeakReference(new BundleListener()
    {
      public void onLoadFail(String paramAnonymousString, int paramAnonymousInt)
      {
        super.onLoadFail(paramAnonymousString, paramAnonymousInt);
        if ((!TextUtils.isEmpty(paramAnonymousString)) && (paramAnonymousString.equals(this.val$key)))
        {
          if (Const.isTestPerformance) {
            FLog.i("bitapp_performance", "Download bundle onLoadFail for " + paramAnonymousString);
          }
          if (BitAppBaseView.this.mListener != null) {
            BitAppBaseView.this.mListener.onLoadFail(this.val$key, paramAnonymousInt);
          }
        }
        while (!FLog.isLoggable(3)) {
          return;
        }
        FLog.i(BitAppBaseView.TAG, "Ingore onLoadFail, because bundleName: " + this.val$key + " isn't same as rkey: " + paramAnonymousString);
      }
      
      public void onLoadSuccess(String paramAnonymousString, final com.tencent.bitapp.bundle.Bundle paramAnonymousBundle)
      {
        super.onLoadSuccess(paramAnonymousString, paramAnonymousBundle);
        if ((!TextUtils.isEmpty(paramAnonymousString)) && (paramAnonymousString.equals(this.val$key)))
        {
          if (Const.isTestPerformance) {
            FLog.i("bitapp_performance", "Download bundle onLoadSuccess for " + paramAnonymousString);
          }
          BitAppBaseView.this.mHandler.post(new Runnable()
          {
            public void run()
            {
              final android.os.Bundle localBundle = new android.os.Bundle();
              if (!TextUtils.isEmpty(BitAppBaseView.this.mModuleData)) {
                localBundle.putString("content", BitAppBaseView.this.mModuleData);
              }
              if (BitAppBaseView.this.mExtra != null) {
                localBundle.putAll(BitAppBaseView.this.mExtra);
              }
              final BitAppInstanceManager localBitAppInstanceManager = BitAppInstanceManager.getInstance();
              if (localBitAppInstanceManager != null) {
                localBitAppInstanceManager.loadBundle(paramAnonymousBundle, new BitAppInstanceManager.LoadBundleCallBack()
                {
                  public void callBack()
                  {
                    BitAppBaseView.this.startReactApplication(localBitAppInstanceManager, this.val$key, localBundle);
                    if (BitAppBaseView.this.mListener != null) {
                      BitAppBaseView.this.mListener.onLoadSuccess(this.val$key);
                    }
                  }
                }, false);
              }
              while (!FLog.isLoggable(3)) {
                return;
              }
              FLog.i(BitAppBaseView.TAG, "BitAppInstanceManager is null");
            }
          });
        }
        while (!FLog.isLoggable(3)) {
          return;
        }
        FLog.i(BitAppBaseView.TAG, "Ingore onLoadSuccess, because bundleName: " + this.val$key + " isn't same as rkey: " + paramAnonymousString);
      }
    }));
  }
  
  private void setData(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.BitAppBaseView, paramInt, 0);
    int i = paramContext.getIndexCount();
    paramInt = 0;
    if (paramInt >= i)
    {
      paramContext.recycle();
      return;
    }
    int j = paramContext.getIndex(paramInt);
    if (j == 0) {
      this.mModuleId = paramContext.getInt(j, 0);
    }
    for (;;)
    {
      paramInt += 1;
      break;
      if (j == 1) {
        this.mModuleVersion = paramContext.getInt(j, 1);
      } else if (j == 2) {
        this.mModuleData = paramContext.getString(j);
      } else if (j == 3) {
        this.mIsInListView = paramContext.getBoolean(j, false);
      }
    }
  }
  
  private void triggerOnClick(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      do
      {
        return;
        this.startClickTime = System.currentTimeMillis();
        return;
      } while (System.currentTimeMillis() - this.startClickTime >= 200L);
      if (FLog.isLoggable(3)) {
        FLog.i(TAG, "trigger click event");
      }
    } while (this.mListener == null);
    this.mListener.onInvalidViewClick();
  }
  
  public void deattachMeasuredRootView()
  {
    super.deattachMeasuredRootView();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      this.mLastMotionX = i;
      this.mLastMotionY = j;
      this.isMoved = false;
      if (this.mOnTouchListener != null) {
        this.mOnTouchListener.onTouch(this, paramMotionEvent);
      }
      postDelayed(this.mLongPressRunnable, ViewConfiguration.getLongPressTimeout());
      continue;
      if ((!this.isMoved) && ((Math.abs(this.mLastMotionX - i) > 20) || (Math.abs(this.mLastMotionY - j) > 20)))
      {
        this.isMoved = true;
        removeCallbacks(this.mLongPressRunnable);
        continue;
        removeCallbacks(this.mLongPressRunnable);
      }
    }
  }
  
  public void firstDraw() {}
  
  public android.os.Bundle getExtra()
  {
    return this.mExtra;
  }
  
  public boolean getIsInListView()
  {
    return this.mIsInListView;
  }
  
  public String getModuleData()
  {
    return this.mModuleData;
  }
  
  public int getModuleId()
  {
    return this.mModuleId;
  }
  
  public int getModuleVersion()
  {
    return this.mModuleVersion;
  }
  
  protected void handleTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = TouchTargetHelper.findTargetTagAndCoordinatesForTouch(paramMotionEvent.getX(), paramMotionEvent.getY(), this, this.mTargetCoordinates);
    if (Java2jniClientFactory.getJava2jniClient().isInvalidView(i))
    {
      triggerOnClick(paramMotionEvent);
      return;
    }
    super.handleTouchEvent(paramMotionEvent);
  }
  
  public void invokeDefaultOnBackPressed() {}
  
  public void setIsInListView(boolean paramBoolean)
  {
    this.mIsInListView = paramBoolean;
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    this.mOnTouchListener = paramOnTouchListener;
    super.setOnTouchListener(paramOnTouchListener);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\bitapp\view\BitAppBaseView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */