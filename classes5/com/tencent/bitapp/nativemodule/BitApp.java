package com.tencent.bitapp.nativemodule;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.uimanager.NativeViewHierarchyManager;
import com.facebook.react.uimanager.UIImplementation;
import com.facebook.react.uimanager.UIManagerModule;
import com.tencent.bitapp.Const;
import com.tencent.bitapp.manager.BitAppInstanceManager;
import com.tencent.bitapp.utils.ICropBitmapListener;
import com.tencent.bitapp.utils.ViewUtils;
import java.util.HashMap;
import java.util.Map;

public class BitApp
  extends ReactContextBaseJavaModule
{
  private static final String DURATION_LONG_KEY = "LONG";
  private static final String DURATION_SHORT_KEY = "SHORT";
  private static final String TAG = BitApp.class.getSimpleName();
  private OnSaveBitmapListener mOnSaveBitmapListener;
  
  public BitApp(ReactApplicationContext paramReactApplicationContext)
  {
    super(paramReactApplicationContext);
  }
  
  @ReactMethod
  public void createCrop(int paramInt, String paramString)
  {
    label148:
    do
    {
      do
      {
        do
        {
          try
          {
            Thread.sleep(400L);
            if ((paramInt < 0) || (TextUtils.isEmpty(paramString))) {
              break label148;
            }
            Object localObject = BitAppInstanceManager.getInstance();
            if ((localObject == null) || (((BitAppInstanceManager)localObject).getCurrentReactContext() == null)) {
              break;
            }
            localObject = (UIManagerModule)((BitAppInstanceManager)localObject).getCurrentReactContext().getNativeModule(UIManagerModule.class);
            if ((localObject != null) && (((UIManagerModule)localObject).mUIImplementation != null))
            {
              localObject = ((UIManagerModule)localObject).mUIImplementation.mNativeViewHierarchyManager;
              if (localObject != null)
              {
                localObject = ((NativeViewHierarchyManager)localObject).getView(paramInt);
                if (localObject != null) {
                  ViewUtils.getCropBitmap((View)localObject, new CropBitmapListener(paramString));
                }
                return;
              }
            }
          }
          catch (InterruptedException localInterruptedException)
          {
            do
            {
              for (;;)
              {
                localInterruptedException.printStackTrace();
              }
            } while (!FLog.isLoggable(3));
            FLog.i(TAG, "createCrop but NativeViewHierarchyManager is null");
            return;
          }
        } while (!FLog.isLoggable(3));
        FLog.i(TAG, "createCrop but UIManagerModule is null");
        return;
      } while (!FLog.isLoggable(3));
      FLog.i(TAG, "createCrop but BitAppInstanceManager is null");
      return;
    } while (!FLog.isLoggable(3));
    FLog.i(TAG, "createCrop but tag < 0");
  }
  
  public Map<String, Object> getConstants()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("SHORT", Integer.valueOf(0));
    localHashMap.put("LONG", Integer.valueOf(1));
    return localHashMap;
  }
  
  public String getName()
  {
    return "BitApp";
  }
  
  public void setOnSaveBitmapListener(OnSaveBitmapListener paramOnSaveBitmapListener)
  {
    this.mOnSaveBitmapListener = paramOnSaveBitmapListener;
  }
  
  @ReactMethod
  public void show(String paramString, int paramInt)
  {
    Toast.makeText(getReactApplicationContext(), paramString, paramInt).show();
  }
  
  @ReactMethod
  public void showSuccess(int paramInt)
  {
    if (Const.isTestPerformance) {
      FLog.i("bitapp_performance", "Js call show success for " + paramInt);
    }
  }
  
  private class CropBitmapListener
    implements ICropBitmapListener
  {
    private String mName = "";
    
    public CropBitmapListener(String paramString)
    {
      this.mName = paramString;
    }
    
    public void onCropFail(View paramView) {}
    
    public void onCropSuccess(View paramView, Bitmap paramBitmap)
    {
      if (BitApp.this.mOnSaveBitmapListener != null) {
        BitApp.this.mOnSaveBitmapListener.onSaveBitmap(this.mName, paramBitmap);
      }
    }
  }
  
  public static abstract interface OnSaveBitmapListener
  {
    public abstract void onSaveBitmap(String paramString, Bitmap paramBitmap);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\bitapp\nativemodule\BitApp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */