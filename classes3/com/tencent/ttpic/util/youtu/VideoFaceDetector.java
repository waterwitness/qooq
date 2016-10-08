package com.tencent.ttpic.util.youtu;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.ttpic.util.VideoGlobalContext;

public class VideoFaceDetector
{
  private Sensor accelerometer;
  private double angle = 0.0D;
  private float[] facePoints;
  private long mNativeObjPtr;
  private SensorEventListener mSensorEventListener = new SensorEventListener()
  {
    public void onAccuracyChanged(Sensor paramAnonymousSensor, int paramAnonymousInt) {}
    
    public void onSensorChanged(SensorEvent paramAnonymousSensorEvent)
    {
      if (paramAnonymousSensorEvent.sensor != VideoFaceDetector.this.accelerometer) {
        return;
      }
      float f1 = paramAnonymousSensorEvent.values[0];
      float f2 = paramAnonymousSensorEvent.values[1];
      VideoFaceDetector.access$102(VideoFaceDetector.this, Math.atan2(f1, f2));
    }
  };
  private SensorManager sensorManager;
  
  public VideoFaceDetector()
  {
    nativeConstructor();
    nativeInit();
    this.facePoints = new float['´'];
    this.sensorManager = ((SensorManager)VideoGlobalContext.getContext().getSystemService("sensor"));
    this.accelerometer = this.sensorManager.getDefaultSensor(1);
    this.sensorManager.registerListener(this.mSensorEventListener, this.accelerometer, 3);
  }
  
  private native void nativeConstructor();
  
  private native void nativeDestructor();
  
  private native boolean nativeDetectExpression(int paramInt);
  
  private native FaceStatus[] nativeDoFaceDetectionByY(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  private native void nativeFaceDetect();
  
  private native float[] nativeGetAllPoints(int paramInt, float[] paramArrayOfFloat);
  
  private native int nativeGetFaceCount();
  
  private static native boolean nativeInit();
  
  private native boolean nativeNeedDetectFace();
  
  public void destroy()
  {
    this.sensorManager.unregisterListener(this.mSensorEventListener);
    nativeDestructor();
  }
  
  public boolean detectExpression(int paramInt)
  {
    return nativeDetectExpression(paramInt);
  }
  
  public FaceStatus[] doDetectFaceProcess(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return nativeDoFaceDetection(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public FaceStatus[] doDetectFaceProcessByY(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return nativeDoFaceDetectionByY(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public FaceStatus[] doDetectFaceProcessWithGrayMat(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    return nativeDoFaceDetectionWithGrayMat(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
  }
  
  public void doFaceDetect()
  {
    nativeFaceDetect();
  }
  
  protected void finalize()
    throws Throwable
  {
    nativeDestructor();
    super.finalize();
  }
  
  public float[] getAllPoints(int paramInt)
  {
    return nativeGetAllPoints(paramInt, this.facePoints);
  }
  
  public int getFaceCount()
  {
    return nativeGetFaceCount();
  }
  
  public float getPhotoAngle()
  {
    return (float)this.angle;
  }
  
  public native FaceStatus[] nativeDoFaceDetection(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public native FaceStatus[] nativeDoFaceDetectionWithGrayMat(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  public boolean needDetectFace()
  {
    return nativeNeedDetectFace();
  }
  
  public static class FaceStatus
  {
    public float[] xys;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\ttpic\util\youtu\VideoFaceDetector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */