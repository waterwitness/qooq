package com.facebook.react.modules.debug;

import android.os.Build.VERSION;
import android.view.Choreographer;
import android.widget.Toast;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import java.util.Locale;
import javax.annotation.Nullable;

public class AnimationsDebugModule
  extends ReactContextBaseJavaModule
{
  private final DeveloperSettings mCatalystSettings;
  @Nullable
  private FpsDebugFrameCallback mFrameCallback;
  
  public AnimationsDebugModule(ReactApplicationContext paramReactApplicationContext, DeveloperSettings paramDeveloperSettings)
  {
    super(paramReactApplicationContext);
    this.mCatalystSettings = paramDeveloperSettings;
  }
  
  private static void checkAPILevel()
  {
    if (Build.VERSION.SDK_INT < 16) {
      throw new JSApplicationCausedNativeException("Animation debugging is not supported in API <16");
    }
  }
  
  public String getName()
  {
    return "AnimationsDebugModule";
  }
  
  public void onCatalystInstanceDestroy()
  {
    if (this.mFrameCallback != null)
    {
      this.mFrameCallback.stop();
      this.mFrameCallback = null;
    }
  }
  
  @ReactMethod
  public void startRecordingFps()
  {
    if ((this.mCatalystSettings == null) || (!this.mCatalystSettings.isAnimationFpsDebugEnabled())) {
      return;
    }
    if (this.mFrameCallback != null) {
      throw new JSApplicationCausedNativeException("Already recording FPS!");
    }
    checkAPILevel();
    this.mFrameCallback = new FpsDebugFrameCallback(Choreographer.getInstance(), getReactApplicationContext());
    this.mFrameCallback.startAndRecordFpsAtEachFrame();
  }
  
  @ReactMethod
  public void stopRecordingFps(double paramDouble)
  {
    if (this.mFrameCallback == null) {
      return;
    }
    checkAPILevel();
    this.mFrameCallback.stop();
    Object localObject = this.mFrameCallback.getFpsInfo(paramDouble);
    if (localObject == null) {
      Toast.makeText(getReactApplicationContext(), "Unable to get FPS info", 1);
    }
    for (;;)
    {
      this.mFrameCallback = null;
      return;
      String str1 = String.format(Locale.US, "FPS: %.2f, %d frames (%d expected)", new Object[] { Double.valueOf(((FpsDebugFrameCallback.FpsInfo)localObject).fps), Integer.valueOf(((FpsDebugFrameCallback.FpsInfo)localObject).totalFrames), Integer.valueOf(((FpsDebugFrameCallback.FpsInfo)localObject).totalExpectedFrames) });
      String str2 = String.format(Locale.US, "JS FPS: %.2f, %d frames (%d expected)", new Object[] { Double.valueOf(((FpsDebugFrameCallback.FpsInfo)localObject).jsFps), Integer.valueOf(((FpsDebugFrameCallback.FpsInfo)localObject).totalJsFrames), Integer.valueOf(((FpsDebugFrameCallback.FpsInfo)localObject).totalExpectedFrames) });
      localObject = str1 + "\n" + str2 + "\n" + "Total Time MS: " + String.format(Locale.US, "%d", new Object[] { Integer.valueOf(((FpsDebugFrameCallback.FpsInfo)localObject).totalTimeMs) });
      if (FLog.isLoggable(3)) {
        FLog.d("React", (String)localObject);
      }
      Toast.makeText(getReactApplicationContext(), (CharSequence)localObject, 1).show();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\modules\debug\AnimationsDebugModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */