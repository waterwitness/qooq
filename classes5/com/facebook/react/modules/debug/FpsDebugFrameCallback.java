package com.facebook.react.modules.debug;

import android.annotation.TargetApi;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import java.util.Map.Entry;
import java.util.TreeMap;
import javax.annotation.Nullable;

@TargetApi(16)
public class FpsDebugFrameCallback
  implements Choreographer.FrameCallback
{
  private static final double EXPECTED_FRAME_TIME = 16.9D;
  private int m4PlusFrameStutters = 0;
  private final Choreographer mChoreographer;
  private final DidJSUpdateUiDuringFrameDetector mDidJSUpdateUiDuringFrameDetector;
  private int mExpectedNumFramesPrev = 0;
  private long mFirstFrameTime = -1L;
  private boolean mIsRecordingFpsInfoAtEachFrame = false;
  private long mLastFrameTime = -1L;
  private int mNumFrameCallbacks = 0;
  private int mNumFrameCallbacksWithBatchDispatches = 0;
  private final ReactContext mReactContext;
  private boolean mShouldStop = false;
  @Nullable
  private TreeMap<Long, FpsInfo> mTimeToFps;
  private final UIManagerModule mUIManagerModule;
  
  public FpsDebugFrameCallback(Choreographer paramChoreographer, ReactContext paramReactContext)
  {
    this.mChoreographer = paramChoreographer;
    this.mReactContext = paramReactContext;
    this.mUIManagerModule = ((UIManagerModule)paramReactContext.getNativeModule(UIManagerModule.class));
    this.mDidJSUpdateUiDuringFrameDetector = new DidJSUpdateUiDuringFrameDetector();
  }
  
  public void doFrame(long paramLong)
  {
    if (this.mShouldStop) {
      return;
    }
    if (this.mFirstFrameTime == -1L) {
      this.mFirstFrameTime = paramLong;
    }
    long l = this.mLastFrameTime;
    this.mLastFrameTime = paramLong;
    if (this.mDidJSUpdateUiDuringFrameDetector.getDidJSHitFrameAndCleanup(l, paramLong)) {
      this.mNumFrameCallbacksWithBatchDispatches += 1;
    }
    this.mNumFrameCallbacks += 1;
    int i = getExpectedNumFrames();
    if (i - this.mExpectedNumFramesPrev - 1 >= 4) {
      this.m4PlusFrameStutters += 1;
    }
    if (this.mIsRecordingFpsInfoAtEachFrame)
    {
      Assertions.assertNotNull(this.mTimeToFps);
      FpsInfo localFpsInfo = new FpsInfo(getNumFrames(), getNumJSFrames(), i, this.m4PlusFrameStutters, getFPS(), getJSFPS(), getTotalTimeMS());
      this.mTimeToFps.put(Long.valueOf(System.currentTimeMillis()), localFpsInfo);
    }
    this.mExpectedNumFramesPrev = i;
    this.mChoreographer.postFrameCallback(this);
  }
  
  public int get4PlusFrameStutters()
  {
    return this.m4PlusFrameStutters;
  }
  
  public int getExpectedNumFrames()
  {
    return (int)(getTotalTimeMS() / 16.9D + 1.0D);
  }
  
  public double getFPS()
  {
    if (this.mLastFrameTime == this.mFirstFrameTime) {
      return 0.0D;
    }
    return getNumFrames() * 1.0E9D / (this.mLastFrameTime - this.mFirstFrameTime);
  }
  
  @Nullable
  public FpsInfo getFpsInfo(long paramLong)
  {
    if (this.mTimeToFps == null) {
      if (FLog.isLoggable(6)) {
        FLog.e("Exception", "FPS was not recorded at each frame!");
      }
    }
    Map.Entry localEntry;
    do
    {
      return null;
      localEntry = this.mTimeToFps.floorEntry(Long.valueOf(paramLong));
    } while (localEntry == null);
    return (FpsInfo)localEntry.getValue();
  }
  
  public double getJSFPS()
  {
    if (this.mLastFrameTime == this.mFirstFrameTime) {
      return 0.0D;
    }
    return getNumJSFrames() * 1.0E9D / (this.mLastFrameTime - this.mFirstFrameTime);
  }
  
  public int getNumFrames()
  {
    return this.mNumFrameCallbacks - 1;
  }
  
  public int getNumJSFrames()
  {
    return this.mNumFrameCallbacksWithBatchDispatches - 1;
  }
  
  public int getTotalTimeMS()
  {
    return (int)(this.mLastFrameTime - this.mFirstFrameTime) / 1000000;
  }
  
  public void reset()
  {
    this.mFirstFrameTime = -1L;
    this.mLastFrameTime = -1L;
    this.mNumFrameCallbacks = 0;
    this.m4PlusFrameStutters = 0;
    this.mNumFrameCallbacksWithBatchDispatches = 0;
    this.mIsRecordingFpsInfoAtEachFrame = false;
    this.mTimeToFps = null;
  }
  
  public void start()
  {
    this.mShouldStop = false;
    this.mReactContext.getCatalystInstance().addBridgeIdleDebugListener(this.mDidJSUpdateUiDuringFrameDetector);
    this.mUIManagerModule.setViewHierarchyUpdateDebugListener(this.mDidJSUpdateUiDuringFrameDetector);
    this.mChoreographer.postFrameCallback(this);
  }
  
  public void startAndRecordFpsAtEachFrame()
  {
    this.mTimeToFps = new TreeMap();
    this.mIsRecordingFpsInfoAtEachFrame = true;
    start();
  }
  
  public void stop()
  {
    this.mShouldStop = true;
    this.mReactContext.getCatalystInstance().removeBridgeIdleDebugListener(this.mDidJSUpdateUiDuringFrameDetector);
    this.mUIManagerModule.setViewHierarchyUpdateDebugListener(null);
  }
  
  public static class FpsInfo
  {
    public final double fps;
    public final double jsFps;
    public final int total4PlusFrameStutters;
    public final int totalExpectedFrames;
    public final int totalFrames;
    public final int totalJsFrames;
    public final int totalTimeMs;
    
    public FpsInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble1, double paramDouble2, int paramInt5)
    {
      this.totalFrames = paramInt1;
      this.totalJsFrames = paramInt2;
      this.totalExpectedFrames = paramInt3;
      this.total4PlusFrameStutters = paramInt4;
      this.fps = paramDouble1;
      this.jsFps = paramDouble2;
      this.totalTimeMs = paramInt5;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\modules\debug\FpsDebugFrameCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */