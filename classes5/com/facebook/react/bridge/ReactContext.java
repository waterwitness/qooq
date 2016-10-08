package com.facebook.react.bridge;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.view.LayoutInflater;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.queue.CatalystQueueConfiguration;
import com.tencent.bitapp.pre.binder.MessageQueueThread;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.annotation.Nullable;

public class ReactContext
  extends ContextWrapper
{
  private final CopyOnWriteArraySet<ActivityEventListener> mActivityEventListeners = new CopyOnWriteArraySet();
  @Nullable
  private CatalystInstance mCatalystInstance;
  @Nullable
  private LayoutInflater mInflater;
  @Nullable
  private MessageQueueThread mJSMessageQueueThread;
  private final CopyOnWriteArraySet<LifecycleEventListener> mLifecycleEventListeners = new CopyOnWriteArraySet();
  @Nullable
  private NativeModuleCallExceptionHandler mNativeModuleCallExceptionHandler;
  @Nullable
  private MessageQueueThread mNativeModulesMessageQueueThread;
  @Nullable
  private MessageQueueThread mUiMessageQueueThread;
  
  public ReactContext(Context paramContext)
  {
    super(paramContext);
  }
  
  public void addActivityEventListener(ActivityEventListener paramActivityEventListener)
  {
    this.mActivityEventListeners.add(paramActivityEventListener);
  }
  
  public void addLifecycleEventListener(LifecycleEventListener paramLifecycleEventListener)
  {
    this.mLifecycleEventListeners.add(paramLifecycleEventListener);
  }
  
  public void assertOnJSQueueThread()
  {
    ((MessageQueueThread)Assertions.assertNotNull(this.mJSMessageQueueThread)).assertIsOnThread();
  }
  
  public void assertOnNativeModulesQueueThread()
  {
    ((MessageQueueThread)Assertions.assertNotNull(this.mNativeModulesMessageQueueThread)).assertIsOnThread();
  }
  
  public void assertOnUiQueueThread()
  {
    ((MessageQueueThread)Assertions.assertNotNull(this.mUiMessageQueueThread)).assertIsOnThread();
  }
  
  public void executeJSScript(String paramString)
  {
    if (this.mCatalystInstance != null) {
      this.mCatalystInstance.executeJSScript(paramString);
    }
  }
  
  public CatalystInstance getCatalystInstance()
  {
    return (CatalystInstance)Assertions.assertNotNull(this.mCatalystInstance);
  }
  
  public <T extends JavaScriptModule> T getJSModule(Class<T> paramClass)
  {
    if (this.mCatalystInstance == null) {
      throw new RuntimeException("Trying to invoke JS before CatalystInstance has been set!");
    }
    return this.mCatalystInstance.getJSModule(paramClass);
  }
  
  public <T extends NativeModule> T getNativeModule(Class<T> paramClass)
  {
    if (this.mCatalystInstance == null) {
      throw new RuntimeException("Trying to invoke JS before CatalystInstance has been set!");
    }
    return this.mCatalystInstance.getNativeModule(paramClass);
  }
  
  public Object getSystemService(String paramString)
  {
    if ("layout_inflater".equals(paramString))
    {
      if (this.mInflater == null) {
        this.mInflater = LayoutInflater.from(getBaseContext()).cloneInContext(this);
      }
      return this.mInflater;
    }
    return getBaseContext().getSystemService(paramString);
  }
  
  public void handleException(RuntimeException paramRuntimeException)
  {
    if ((this.mCatalystInstance != null) && (!this.mCatalystInstance.isDestroyed()) && (this.mNativeModuleCallExceptionHandler != null))
    {
      this.mNativeModuleCallExceptionHandler.handleException(paramRuntimeException);
      return;
    }
    throw paramRuntimeException;
  }
  
  public boolean hasActiveCatalystInstance()
  {
    return (this.mCatalystInstance != null) && (!this.mCatalystInstance.isDestroyed());
  }
  
  public void initializeWithInstance(CatalystInstance paramCatalystInstance)
  {
    if (paramCatalystInstance == null) {
      throw new IllegalArgumentException("CatalystInstance cannot be null.");
    }
    if (this.mCatalystInstance != null) {
      throw new IllegalStateException("ReactContext has been already initialized");
    }
    this.mCatalystInstance = paramCatalystInstance;
    paramCatalystInstance = paramCatalystInstance.getCatalystQueueConfiguration();
    this.mUiMessageQueueThread = paramCatalystInstance.getUIQueueThread();
    this.mNativeModulesMessageQueueThread = paramCatalystInstance.getNativeModulesQueueThread();
    this.mJSMessageQueueThread = paramCatalystInstance.getJSQueueThread();
  }
  
  public boolean isOnJSQueueThread()
  {
    return ((MessageQueueThread)Assertions.assertNotNull(this.mJSMessageQueueThread)).isOnThread();
  }
  
  public boolean isOnNativeModulesQueueThread()
  {
    return ((MessageQueueThread)Assertions.assertNotNull(this.mNativeModulesMessageQueueThread)).isOnThread();
  }
  
  public boolean isOnUiQueueThread()
  {
    return ((MessageQueueThread)Assertions.assertNotNull(this.mUiMessageQueueThread)).isOnThread();
  }
  
  public void loadBundle(String paramString, String[] paramArrayOfString)
  {
    if (this.mCatalystInstance != null) {}
    try
    {
      this.mCatalystInstance.loadBundle(paramString, paramArrayOfString);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = this.mActivityEventListeners.iterator();
    while (localIterator.hasNext()) {
      ((ActivityEventListener)localIterator.next()).onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onDestroy()
  {
    UiThreadUtil.assertOnUiThread();
    Iterator localIterator = this.mLifecycleEventListeners.iterator();
    while (localIterator.hasNext()) {
      ((LifecycleEventListener)localIterator.next()).onHostDestroy();
    }
    this.mLifecycleEventListeners.clear();
    if (FLog.isLoggable(3)) {
      FLog.d("React", "Reactcontext mCatalystInstance: " + this.mCatalystInstance);
    }
    if (this.mCatalystInstance != null) {
      this.mCatalystInstance.destroy();
    }
  }
  
  public void onPause()
  {
    UiThreadUtil.assertOnUiThread();
    Iterator localIterator = this.mLifecycleEventListeners.iterator();
    while (localIterator.hasNext()) {
      ((LifecycleEventListener)localIterator.next()).onHostPause();
    }
  }
  
  public void onResume()
  {
    UiThreadUtil.assertOnUiThread();
    Iterator localIterator = this.mLifecycleEventListeners.iterator();
    while (localIterator.hasNext()) {
      ((LifecycleEventListener)localIterator.next()).onHostResume();
    }
  }
  
  public void removeActivityEventListener(ActivityEventListener paramActivityEventListener)
  {
    this.mActivityEventListeners.remove(paramActivityEventListener);
  }
  
  public void removeLifecycleEventListener(LifecycleEventListener paramLifecycleEventListener)
  {
    this.mLifecycleEventListeners.remove(paramLifecycleEventListener);
  }
  
  public void runOnJSQueueThread(Runnable paramRunnable)
  {
    ((MessageQueueThread)Assertions.assertNotNull(this.mJSMessageQueueThread)).runOnQueue(paramRunnable);
  }
  
  public void runOnNativeModulesQueueThread(Runnable paramRunnable)
  {
    ((MessageQueueThread)Assertions.assertNotNull(this.mNativeModulesMessageQueueThread)).runOnQueue(paramRunnable);
  }
  
  public void runOnUiQueueThread(Runnable paramRunnable)
  {
    ((MessageQueueThread)Assertions.assertNotNull(this.mUiMessageQueueThread)).runOnQueue(paramRunnable);
  }
  
  public void setNativeModuleCallExceptionHandler(@Nullable NativeModuleCallExceptionHandler paramNativeModuleCallExceptionHandler)
  {
    this.mNativeModuleCallExceptionHandler = paramNativeModuleCallExceptionHandler;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\bridge\ReactContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */