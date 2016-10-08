package com.facebook.react.modules.toast;

import android.widget.Toast;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.MapBuilder;
import java.util.HashMap;
import java.util.Map;

public class ToastModule
  extends ReactContextBaseJavaModule
{
  private static final String DURATION_LONG_KEY = "LONG";
  private static final String DURATION_SHORT_KEY = "SHORT";
  
  public ToastModule(ReactApplicationContext paramReactApplicationContext)
  {
    super(paramReactApplicationContext);
  }
  
  public Map<String, Object> getConstants()
  {
    HashMap localHashMap = MapBuilder.newHashMap();
    localHashMap.put("SHORT", Integer.valueOf(0));
    localHashMap.put("LONG", Integer.valueOf(1));
    return localHashMap;
  }
  
  public String getName()
  {
    return "ToastAndroid";
  }
  
  @ReactMethod
  public void show(final String paramString, final int paramInt)
  {
    UiThreadUtil.runOnUiThread(new Runnable()
    {
      public void run()
      {
        Toast.makeText(ToastModule.this.getReactApplicationContext(), paramString, paramInt).show();
      }
    });
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\modules\toast\ToastModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */