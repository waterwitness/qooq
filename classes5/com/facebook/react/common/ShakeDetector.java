package com.facebook.react.common;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.facebook.infer.annotation.Assertions;
import javax.annotation.Nullable;

public class ShakeDetector
  implements SensorEventListener
{
  private static final int MAGNITUDE_THRESHOLD = 25;
  private static final int MAX_SAMPLES = 25;
  private static final int MIN_TIME_BETWEEN_SAMPLES_MS = 20;
  private static final int PERCENT_OVER_THRESHOLD_FOR_SHAKE = 66;
  private static final int VISIBLE_TIME_RANGE_MS = 500;
  private int mCurrentIndex;
  private long mLastTimestamp;
  @Nullable
  private double[] mMagnitudes;
  @Nullable
  private SensorManager mSensorManager;
  private final ShakeListener mShakeListener;
  @Nullable
  private long[] mTimestamps;
  
  public ShakeDetector(ShakeListener paramShakeListener)
  {
    this.mShakeListener = paramShakeListener;
  }
  
  private void maybeDispatchShake(long paramLong)
  {
    Assertions.assertNotNull(this.mTimestamps);
    Assertions.assertNotNull(this.mMagnitudes);
    int k = 0;
    int m = 0;
    int j = 0;
    while (j < 25)
    {
      int i1 = (this.mCurrentIndex - j + 25) % 25;
      int n = k;
      int i = m;
      if (paramLong - this.mTimestamps[i1] < 500L)
      {
        m += 1;
        n = k;
        i = m;
        if (this.mMagnitudes[i1] >= 25.0D)
        {
          n = k + 1;
          i = m;
        }
      }
      j += 1;
      k = n;
      m = i;
    }
    if (k / m > 0.66D) {
      this.mShakeListener.onShake();
    }
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (paramSensorEvent.timestamp - this.mLastTimestamp < 20L) {
      return;
    }
    Assertions.assertNotNull(this.mTimestamps);
    Assertions.assertNotNull(this.mMagnitudes);
    float f1 = paramSensorEvent.values[0];
    float f2 = paramSensorEvent.values[1];
    float f3 = paramSensorEvent.values[2];
    this.mLastTimestamp = paramSensorEvent.timestamp;
    this.mTimestamps[this.mCurrentIndex] = paramSensorEvent.timestamp;
    this.mMagnitudes[this.mCurrentIndex] = Math.sqrt(f1 * f1 + f2 * f2 + f3 * f3);
    maybeDispatchShake(paramSensorEvent.timestamp);
    this.mCurrentIndex = ((this.mCurrentIndex + 1) % 25);
  }
  
  public void start(SensorManager paramSensorManager)
  {
    Assertions.assertNotNull(paramSensorManager);
    Sensor localSensor = paramSensorManager.getDefaultSensor(1);
    if (localSensor != null)
    {
      this.mSensorManager = paramSensorManager;
      this.mLastTimestamp = -1L;
      this.mCurrentIndex = 0;
      this.mMagnitudes = new double[25];
      this.mTimestamps = new long[25];
      this.mSensorManager.registerListener(this, localSensor, 2);
    }
  }
  
  public void stop()
  {
    if (this.mSensorManager != null)
    {
      this.mSensorManager.unregisterListener(this);
      this.mSensorManager = null;
    }
  }
  
  public static abstract interface ShakeListener
  {
    public abstract void onShake();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\common\ShakeDetector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */