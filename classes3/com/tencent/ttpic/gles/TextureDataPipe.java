package com.tencent.ttpic.gles;

import android.graphics.PointF;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.filter.Frame;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class TextureDataPipe
{
  public static final int BUFFER_BUSY = 1;
  public static final int BUFFER_FREE = 0;
  public static final int BUFFER_READY = 2;
  private static final int MESSAGE_FRAME_ARRIVED = -32361386;
  public static final String TAG = "TextureDataPipe";
  private static float[] sMtxIdentity = { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F };
  public FrameMetaData mCurrentFrameMeta = new FrameMetaData();
  private EventHandler mEventHandler;
  private OnFrameAvailableListener mOnFrameAvailableListener;
  public float mPhoneAngle;
  public List<List<PointF>> mPoints;
  public final Frame mTexFrame;
  public AtomicInteger mTextureDataFlag = new AtomicInteger(0);
  public int mTextureId;
  public long mTimestamp;
  
  public TextureDataPipe(int paramInt, Frame paramFrame)
  {
    this.mTextureId = paramInt;
    this.mTexFrame = paramFrame;
    this.mPoints = new ArrayList();
    initHandler();
  }
  
  private void initHandler()
  {
    Looper localLooper = Looper.myLooper();
    if (localLooper != null)
    {
      this.mEventHandler = new EventHandler(localLooper);
      return;
    }
    localLooper = Looper.getMainLooper();
    if (localLooper != null)
    {
      this.mEventHandler = new EventHandler(localLooper);
      return;
    }
    this.mEventHandler = null;
  }
  
  public int getTexureCurrentStatus()
  {
    return this.mTextureDataFlag.getAndAdd(0);
  }
  
  public void getTransformMatrix(float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat.length != 16) {
      throw new IllegalArgumentException();
    }
    System.arraycopy(sMtxIdentity, 0, paramArrayOfFloat, 0, sMtxIdentity.length);
  }
  
  public void makeBusy()
  {
    this.mTextureDataFlag.getAndSet(1);
  }
  
  public void makeDataReady()
  {
    this.mTextureDataFlag.getAndSet(2);
  }
  
  public void makeFree()
  {
    this.mTextureDataFlag.getAndSet(0);
  }
  
  public void postEventNotifyFrame(int paramInt, Object paramObject)
  {
    boolean bool = true;
    FrameMetaData localFrameMetaData;
    if (this.mEventHandler != null)
    {
      localFrameMetaData = this.mCurrentFrameMeta;
      if (paramInt != 1) {
        break label58;
      }
    }
    for (;;)
    {
      localFrameMetaData.mIsRecord = bool;
      this.mCurrentFrameMeta.mMetaData = paramObject;
      paramObject = this.mEventHandler.obtainMessage();
      ((Message)paramObject).what = -32361386;
      this.mEventHandler.sendMessage((Message)paramObject);
      return;
      label58:
      bool = false;
    }
  }
  
  public void release()
  {
    this.mTextureId = 0;
  }
  
  public void setOnFrameAvailableListener(OnFrameAvailableListener paramOnFrameAvailableListener)
  {
    this.mOnFrameAvailableListener = paramOnFrameAvailableListener;
  }
  
  private class EventHandler
    extends Handler
  {
    public EventHandler(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      if (paramMessage.what == -32361386)
      {
        if (TextureDataPipe.this.mOnFrameAvailableListener != null) {
          TextureDataPipe.this.mOnFrameAvailableListener.onFrameAvailable();
        }
      }
      else {
        return;
      }
      TextureDataPipe.this.makeFree();
    }
  }
  
  public static class FrameMetaData
  {
    public boolean mIsRecord;
    public Object mMetaData;
  }
  
  public static abstract interface OnFrameAvailableListener
  {
    public abstract void onFrameAvailable();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\ttpic\gles\TextureDataPipe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */