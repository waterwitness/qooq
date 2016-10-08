package com.tencent.ttpic;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Environment;
import android.util.AttributeSet;
import com.tencent.ttpic.filter.VideoFilterList;
import com.tencent.ttpic.filterprocess.VideoFilterProcessBase;
import com.tencent.ttpic.model.VideoMaterial;
import com.tencent.ttpic.recorder.MyRecorder;
import com.tencent.ttpic.util.CameraInitListener;
import com.tencent.ttpic.util.VideoFilterUtil;
import java.io.File;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class CameraView
  extends GLSurfaceView
  implements GLSurfaceView.Renderer
{
  private static final String TAG = CameraView.class.getSimpleName();
  private CameraInitListener listener;
  private VideoFilterProcessBase mFilterProcess = new VideoFilterProcessBase();
  private boolean mHaveFrame = false;
  private MyRecorder mRecorder = null;
  private int mWindowHeight = 480;
  private int mWindowWidth = 320;
  
  public CameraView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public CameraView(Context paramContext, AttributeSet paramAttributeSet)
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
  
  public void setCameraInitListener(CameraInitListener paramCameraInitListener)
  {
    this.listener = paramCameraInitListener;
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
          CameraView.this.mFilterProcess.changeVideoFilter(paramVideoMaterial);
        }
      });
      return;
    }
  }
  
  public void showPreview()
  {
    this.mHaveFrame = true;
    queueEvent(new Runnable()
    {
      public void run()
      {
        CameraView.this.mFilterProcess.update();
      }
    });
    requestRender();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\ttpic\CameraView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */