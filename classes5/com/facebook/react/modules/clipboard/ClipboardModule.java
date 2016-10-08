package com.facebook.react.modules.clipboard;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.os.Build.VERSION;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class ClipboardModule
  extends ReactContextBaseJavaModule
{
  public ClipboardModule(ReactApplicationContext paramReactApplicationContext)
  {
    super(paramReactApplicationContext);
  }
  
  private ClipboardManager getClipboardService()
  {
    return (ClipboardManager)getReactApplicationContext().getSystemService("clipboard");
  }
  
  public String getName()
  {
    return "Clipboard";
  }
  
  @ReactMethod
  public void getString(Callback paramCallback)
  {
    try
    {
      Object localObject = getClipboardService();
      ClipData localClipData = ((ClipboardManager)localObject).getPrimaryClip();
      if (localClipData == null)
      {
        paramCallback.invoke(new Object[] { "" });
        return;
      }
      if (localClipData.getItemCount() >= 1)
      {
        localObject = ((ClipboardManager)localObject).getPrimaryClip().getItemAt(0);
        paramCallback.invoke(new Object[] { "" + ((ClipData.Item)localObject).getText() });
        return;
      }
    }
    catch (Exception paramCallback)
    {
      if (FLog.isLoggable(5))
      {
        FLog.w("React", "Cannot get clipboard contents: " + paramCallback.getMessage());
        return;
        paramCallback.invoke(new Object[] { "" });
      }
    }
  }
  
  @ReactMethod
  @SuppressLint({"DeprecatedMethod"})
  public void setString(String paramString)
  {
    getReactApplicationContext();
    if (Build.VERSION.SDK_INT >= 11)
    {
      paramString = ClipData.newPlainText(null, paramString);
      getClipboardService().setPrimaryClip(paramString);
      return;
    }
    getClipboardService().setText(paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\modules\clipboard\ClipboardModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */