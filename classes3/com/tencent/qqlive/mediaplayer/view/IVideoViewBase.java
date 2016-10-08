package com.tencent.qqlive.mediaplayer.view;

import android.view.SurfaceHolder;
import android.view.View;
import java.nio.ByteBuffer;

public abstract interface IVideoViewBase
{
  public static final int VIEW_ID_GLSURFACEVIEW = 3;
  public static final int VIEW_ID_SURFACEVIEW = 1;
  public static final int VIEW_ID_SURFACEVIEW_HW = 2;
  public static final int VIEW_ID_UNKONW = 0;
  
  public abstract void addViewCallBack(IVideoViewCallBack paramIVideoViewCallBack);
  
  public abstract void chooseDisplayView(int paramInt)
    throws Exception;
  
  public abstract void doRotate(float paramFloat1, float paramFloat2, float paramFloat3);
  
  public abstract void drawFrame(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2, ByteBuffer paramByteBuffer3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat, boolean paramBoolean)
    throws Exception;
  
  public abstract void drawFrame(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, boolean paramBoolean)
    throws Exception;
  
  public abstract View getCurrentDisplayView();
  
  public abstract Object getRenderObject();
  
  public abstract String getSeriableNO();
  
  public abstract int getViewHeight();
  
  public abstract int getViewWidth();
  
  public abstract boolean isSurfaceReady();
  
  public abstract void onResume();
  
  public abstract void removeViewCallBack(IVideoViewCallBack paramIVideoViewCallBack);
  
  public abstract void resetView();
  
  public abstract void setDegree(int paramInt);
  
  public abstract void setFixedSize(int paramInt1, int paramInt2);
  
  public abstract void setScaleParam(int paramInt1, int paramInt2, float paramFloat);
  
  public abstract void setSubtitleString(String paramString);
  
  public abstract void setXYaxis(int paramInt);
  
  public static abstract interface IVideoViewCallBack
  {
    public abstract void onSurfaceChanged(SurfaceHolder paramSurfaceHolder);
    
    public abstract void onSurfaceCreated(SurfaceHolder paramSurfaceHolder);
    
    public abstract void onSurfaceDestory(SurfaceHolder paramSurfaceHolder);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\qqlive\mediaplayer\view\IVideoViewBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */