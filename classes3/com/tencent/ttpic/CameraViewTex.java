package com.tencent.ttpic;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Environment;
import android.util.AttributeSet;
import com.tencent.ttpic.filter.VideoFilterList;
import com.tencent.ttpic.model.VideoMaterial;
import com.tencent.ttpic.recorder.MyRecorder;
import com.tencent.ttpic.recorder.RetrieveDataListener;
import com.tencent.ttpic.util.CameraInitListener;
import com.tencent.ttpic.util.VideoFilterUtil;
import java.io.File;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class CameraViewTex
  extends GLSurfaceView
  implements GLSurfaceView.Renderer
{
  private static final String TAG = CameraViewTex.class.getSimpleName();
  private CameraInitListener listener;
  private FilterProcessTex mFilterProcess = new FilterProcessTex();
  private boolean mHaveFrame = false;
  private MyRecorder mRecorder = null;
  private int mWindowHeight = 480;
  private int mWindowWidth = 320;
  
  public CameraViewTex(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public CameraViewTex(Context paramContext, AttributeSet paramAttributeSet)
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
        CameraViewTex.this.mFilterProcess.addRetrieveDatalistener(paramInt, paramRetrieveDataListener);
      }
    });
  }
  
  public String getOutputPath()
  {
    return Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "video.mp4";
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    if (this.mHaveFrame)
    {
      if (this.mFilterProcess != null) {
        this.mFilterProcess.showPreview(this.mWindowWidth, this.mWindowHeight);
      }
      return;
    }
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glClear(16384);
    GLES20.glFinish();
  }
  
  public void onPause()
  {
    super.onPause();
    this.mFilterProcess.clearVideoFilterResource();
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
        CameraViewTex.this.mFilterProcess.removeRetrieveDatalistener(paramRetrieveDataListener);
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
        CameraViewTex.this.mFilterProcess.changeSize(paramInt1, paramInt2);
      }
    });
  }
  
  public void setFilter(final String paramString, final int paramInt1, final int paramInt2)
  {
    queueEvent(new Runnable()
    {
      public void run()
      {
        CameraViewTex.this.mFilterProcess.changeFilter(paramString, paramInt1, paramInt2);
      }
    });
  }
  
  public void setRotationAndFlip(final int paramInt, final boolean paramBoolean1, final boolean paramBoolean2)
  {
    queueEvent(new Runnable()
    {
      public void run()
      {
        CameraViewTex.this.mFilterProcess.updatePreviewRotationAndFlip(paramInt, paramBoolean1, paramBoolean2);
      }
    });
  }
  
  public void setRotationAndFlip(final boolean paramBoolean)
  {
    queueEvent(new Runnable()
    {
      public void run()
      {
        CameraViewTex.this.mFilterProcess.updatePreviewRotationAndFlip(paramBoolean);
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
          CameraViewTex.this.mFilterProcess.changeVideoFilter(paramVideoMaterial);
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
        CameraViewTex.this.mFilterProcess.setupSmoothLevel(paramInt);
      }
    });
  }
  
  public void showPreview()
  {
    this.mHaveFrame = true;
    queueEvent(new Runnable()
    {
      public void run()
      {
        CameraViewTex.this.mFilterProcess.update();
      }
    });
    requestRender();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\ttpic\CameraViewTex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */