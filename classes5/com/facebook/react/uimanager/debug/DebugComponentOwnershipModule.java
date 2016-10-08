package com.facebook.react.uimanager.debug;

import android.util.SparseArray;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import javax.annotation.Nullable;

public class DebugComponentOwnershipModule
  extends ReactContextBaseJavaModule
{
  private int mNextRequestId = 0;
  @Nullable
  private RCTDebugComponentOwnership mRCTDebugComponentOwnership;
  private final SparseArray<OwnerHierarchyCallback> mRequestIdToCallback = new SparseArray();
  
  public DebugComponentOwnershipModule(ReactApplicationContext paramReactApplicationContext)
  {
    super(paramReactApplicationContext);
  }
  
  public String getName()
  {
    return "DebugComponentOwnershipModule";
  }
  
  public void initialize()
  {
    super.initialize();
    this.mRCTDebugComponentOwnership = ((RCTDebugComponentOwnership)getReactApplicationContext().getJSModule(RCTDebugComponentOwnership.class));
  }
  
  public void loadComponentOwnerHierarchy(int paramInt, OwnerHierarchyCallback paramOwnerHierarchyCallback)
  {
    try
    {
      int i = this.mNextRequestId;
      this.mNextRequestId += 1;
      this.mRequestIdToCallback.put(i, paramOwnerHierarchyCallback);
      ((RCTDebugComponentOwnership)Assertions.assertNotNull(this.mRCTDebugComponentOwnership)).getOwnerHierarchy(i, paramInt);
      return;
    }
    finally
    {
      paramOwnerHierarchyCallback = finally;
      throw paramOwnerHierarchyCallback;
    }
  }
  
  public void onCatalystInstanceDestroy()
  {
    super.onCatalystInstanceDestroy();
    this.mRCTDebugComponentOwnership = null;
  }
  
  @ReactMethod
  public void receiveOwnershipHierarchy(int paramInt1, int paramInt2, @Nullable ReadableArray paramReadableArray)
  {
    OwnerHierarchyCallback localOwnerHierarchyCallback;
    try
    {
      localOwnerHierarchyCallback = (OwnerHierarchyCallback)this.mRequestIdToCallback.get(paramInt1);
      if (localOwnerHierarchyCallback == null) {
        throw new JSApplicationCausedNativeException("Got receiveOwnershipHierarchy for invalid request id: " + paramInt1);
      }
    }
    finally {}
    this.mRequestIdToCallback.delete(paramInt1);
    localOwnerHierarchyCallback.onOwnerHierarchyLoaded(paramInt2, paramReadableArray);
  }
  
  public static abstract interface OwnerHierarchyCallback
  {
    public abstract void onOwnerHierarchyLoaded(int paramInt, @Nullable ReadableArray paramReadableArray);
  }
  
  public static abstract interface RCTDebugComponentOwnership
    extends JavaScriptModule
  {
    public abstract void getOwnerHierarchy(int paramInt1, int paramInt2);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\uimanager\debug\DebugComponentOwnershipModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */