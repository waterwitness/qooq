package com.tencent.ttpic;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.util.AttributeSet;
import com.tencent.ttpic.filter.VideoFilterList;
import com.tencent.ttpic.model.VideoMaterial;
import com.tencent.ttpic.recorder.RetrieveDataListener;
import com.tencent.ttpic.util.CameraInitListener;
import com.tencent.ttpic.util.FrameRateUtil;
import com.tencent.ttpic.util.VideoFilterUtil;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class CameraViewByte
  extends GLSurfaceView
  implements GLSurfaceView.Renderer
{
  private static final String TAG = CameraViewByte.class.getSimpleName();
  private boolean isDrawing = false;
  private CameraInitListener listener;
  private FilterProcessByte mFilterProcess = new FilterProcessByte();
  private boolean mHaveFrame = false;
  private int mWindowHeight = 480;
  private int mWindowWidth = 320;
  
  public CameraViewByte(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public CameraViewByte(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private void init()
  {
    setEGLContextClientVersion(2);
    setRenderer(this);
    setRenderMode(0);
  }
  
  public void addRetrieveDatalistener(final int paramInt, final RetrieveDataListener paramRetrieveDataListener)
  {
    queueEvent(new Runnable()
    {
      public void run()
      {
        CameraViewByte.this.mFilterProcess.addRetrieveDatalistener(paramInt, paramRetrieveDataListener);
      }
    });
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    if (this.mHaveFrame) {
      if (this.mFilterProcess != null) {
        this.mFilterProcess.showPreview(this.mWindowWidth, this.mWindowHeight);
      }
    }
    for (;;)
    {
      FrameRateUtil.record();
      this.isDrawing = false;
      return;
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
      GLES20.glClear(16384);
      GLES20.glFinish();
    }
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    this.mWindowWidth = paramInt1;
    this.mWindowHeight = paramInt2;
    if (this.mFilterProcess != null) {
      this.mFilterProcess.updatePreviewSize(paramInt1, paramInt2);
    }
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    this.mFilterProcess.clear();
    this.mFilterProcess.initial();
    if (this.listener != null) {
      this.listener.onSurfaceCreated(this.mFilterProcess.getInputSurfaceTexture());
    }
  }
  
  public void removeRetrieveDatalistener(final RetrieveDataListener paramRetrieveDataListener)
  {
    queueEvent(new Runnable()
    {
      public void run()
      {
        CameraViewByte.this.mFilterProcess.removeRetrieveDatalistener(paramRetrieveDataListener);
      }
    });
  }
  
  public void setCameraCallBack(Camera paramCamera)
  {
    final Camera.Size localSize = paramCamera.getParameters().getPreviewSize();
    int i = localSize.width * localSize.height * 3 / 2;
    paramCamera.addCallbackBuffer(new byte[i]);
    paramCamera.addCallbackBuffer(new byte[i]);
    paramCamera.addCallbackBuffer(new byte[i]);
    paramCamera.setPreviewCallbackWithBuffer(new Camera.PreviewCallback()
    {
      public void onPreviewFrame(byte[] paramAnonymousArrayOfByte, Camera paramAnonymousCamera)
      {
        CameraViewByte.access$002(CameraViewByte.this, true);
        paramAnonymousCamera.addCallbackBuffer(paramAnonymousArrayOfByte);
        if (CameraViewByte.this.isDrawing)
        {
          CameraViewByte.this.requestRender();
          return;
        }
        CameraViewByte.this.mFilterProcess.queueYUV(paramAnonymousArrayOfByte, localSize.width, localSize.height);
        CameraViewByte.this.requestRender();
        CameraViewByte.access$102(CameraViewByte.this, true);
      }
    });
  }
  
  public void setCameraInitListener(CameraInitListener paramCameraInitListener)
  {
    this.listener = paramCameraInitListener;
  }
  
  public void setDataSize(final int paramInt1, final int paramInt2)
  {
    queueEvent(new Runnable()
    {
      public void run()
      {
        CameraViewByte.this.mFilterProcess.changeSize(paramInt1, paramInt2);
      }
    });
  }
  
  public void setFilter(final String paramString, final int paramInt1, final int paramInt2)
  {
    queueEvent(new Runnable()
    {
      public void run()
      {
        CameraViewByte.this.mFilterProcess.changeFilter(paramString, paramInt1, paramInt2);
      }
    });
  }
  
  public void setRotationAndFlip(final int paramInt, final boolean paramBoolean1, final boolean paramBoolean2)
  {
    queueEvent(new Runnable()
    {
      public void run()
      {
        CameraViewByte.this.mFilterProcess.updatePreviewRotationAndFlip(paramInt, paramBoolean1, paramBoolean2);
      }
    });
  }
  
  public void setRotationAndFlip(final boolean paramBoolean)
  {
    queueEvent(new Runnable()
    {
      public void run()
      {
        CameraViewByte.this.mFilterProcess.updatePreviewRotationAndFlip(paramBoolean);
      }
    });
  }
  
  public void setVideoFilter(final VideoMaterial paramVideoMaterial)
  {
    if (paramVideoMaterial == null) {}
    for (paramVideoMaterial = null;; paramVideoMaterial = VideoFilterUtil.createFilters(paramVideoMaterial))
    {
      queueEvent(new Runnable()
      {
        public void run()
        {
          CameraViewByte.this.mFilterProcess.changeVideoFilter(paramVideoMaterial);
        }
      });
      return;
    }
  }
  
  public void setupSmoothLevel(final int paramInt)
  {
    queueEvent(new Runnable()
    {
      public void run()
      {
        CameraViewByte.this.mFilterProcess.setupSmoothLevel(paramInt);
      }
    });
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\ttpic\CameraViewByte.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */