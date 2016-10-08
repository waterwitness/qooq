package com.tencent.ttpic.recorder;

import android.annotation.TargetApi;
import android.hardware.Camera.Parameters;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.ttpic.util.FrameRateUtil;
import com.tencent.ttpic.util.GlUtil;
import java.nio.FloatBuffer;

@TargetApi(18)
public class RenderSrfTex
{
  private static final String TAG = RenderSrfTex.class.getSimpleName();
  private Handler handler;
  private final int mFboTexH;
  private final int mFboTexW;
  private HandlerThread mGlThread;
  private InputSurface mInputSurface;
  private int mProgram = -1;
  private final MyRecorder mRecorder;
  private final FloatBuffer mVtxBuf = GlUtil.createSquareVtx();
  private int maPositionHandle = -1;
  private int maTexCoordHandle = -1;
  private int muSamplerHandle = -1;
  
  public RenderSrfTex(int paramInt1, int paramInt2, Camera.Parameters paramParameters, String paramString)
  {
    this.mFboTexW = paramInt1;
    this.mFboTexH = paramInt2;
    this.mRecorder = new MyRecorder(paramParameters, paramString);
    this.mRecorder.prepareEncoder();
  }
  
  private void initGL()
  {
    GlUtil.checkGlError("initGL_S");
    this.mProgram = GlUtil.createProgram("attribute vec4 aPosition;\nattribute vec4 aTexCoord;\nvarying   vec2 vTexCoord;\nvoid main() {\n  gl_Position = aPosition;\n  vTexCoord   = aTexCoord.xy;\n}\n", "precision mediump float;\nuniform sampler2D uSampler;\nvarying vec2      vTexCoord;\nvoid main() {\n  gl_FragColor = texture2D(uSampler, vTexCoord);\n}\n");
    this.maPositionHandle = GLES20.glGetAttribLocation(this.mProgram, "aPosition");
    this.maTexCoordHandle = GLES20.glGetAttribLocation(this.mProgram, "aTexCoord");
    this.muSamplerHandle = GLES20.glGetUniformLocation(this.mProgram, "uSampler");
    GLES20.glDisable(2929);
    GLES20.glDisable(2884);
    GLES20.glDisable(3042);
    GlUtil.checkGlError("initGL_E");
  }
  
  public void draw(final int paramInt)
  {
    if (this.mInputSurface == null) {
      initGlThread(EGL14.eglGetCurrentContext());
    }
    if ((paramInt < 0) || (this.mInputSurface == null)) {
      return;
    }
    queue(new Runnable()
    {
      public void run()
      {
        if (FrameRateUtil.mRecordStartTime == -1L)
        {
          FrameRateUtil.mRecordStartTime = System.currentTimeMillis();
          FrameRateUtil.mFrameCount = 0;
        }
        FrameRateUtil.mFrameCount += 1;
        GLES20.glViewport(0, 0, RenderSrfTex.this.mFboTexW, RenderSrfTex.this.mFboTexH);
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
        GLES20.glClear(16640);
        GLES20.glUseProgram(RenderSrfTex.this.mProgram);
        RenderSrfTex.this.mVtxBuf.position(0);
        GLES20.glVertexAttribPointer(RenderSrfTex.this.maPositionHandle, 3, 5126, false, 20, RenderSrfTex.this.mVtxBuf);
        GLES20.glEnableVertexAttribArray(RenderSrfTex.this.maPositionHandle);
        RenderSrfTex.this.mVtxBuf.position(3);
        GLES20.glVertexAttribPointer(RenderSrfTex.this.maTexCoordHandle, 2, 5126, false, 20, RenderSrfTex.this.mVtxBuf);
        GLES20.glEnableVertexAttribArray(RenderSrfTex.this.maTexCoordHandle);
        GLES20.glUniform1i(RenderSrfTex.this.muSamplerHandle, 0);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, paramInt);
        GLES20.glDrawArrays(5, 0, 4);
        RenderSrfTex.this.mRecorder.swapBuffers();
        RenderSrfTex.this.mInputSurface.swapBuffers();
        RenderSrfTex.this.mInputSurface.setPresentationTime(System.nanoTime());
        GlUtil.checkGlError("draw_E");
      }
    });
  }
  
  public void initGlThread(final EGLContext paramEGLContext)
  {
    paramEGLContext = new Runnable()
    {
      public void run()
      {
        if (RenderSrfTex.this.mRecorder.getInputSurface() == null)
        {
          RenderSrfTex.access$802(RenderSrfTex.this, null);
          return;
        }
        RenderSrfTex.access$802(RenderSrfTex.this, new InputSurface(paramEGLContext, RenderSrfTex.this.mRecorder.getInputSurface()));
        RenderSrfTex.this.mInputSurface.makeCurrent();
        RenderSrfTex.this.initGL();
        try
        {
          RenderSrfTex.this.mRecorder.start();
          return;
        }
        catch (Exception localException)
        {
          RenderSrfTex.this.mRecorder.releaseEncoder();
          localException.printStackTrace();
        }
      }
    };
    if (this.mGlThread == null)
    {
      this.mGlThread = new HandlerThread("VideoGlThread")
      {
        protected void onLooperPrepared()
        {
          super.onLooperPrepared();
        }
      };
      this.mGlThread.start();
      this.handler = new Handler(this.mGlThread.getLooper());
      this.handler.post(paramEGLContext);
    }
  }
  
  public void queue(Runnable paramRunnable)
  {
    if (this.handler != null) {
      this.handler.post(paramRunnable);
    }
  }
  
  public void stop(final RecorderListener paramRecorderListener)
  {
    queue(new Runnable()
    {
      public void run()
      {
        if (RenderSrfTex.this.mRecorder != null) {
          RenderSrfTex.this.mRecorder.stop();
        }
        if (RenderSrfTex.this.mInputSurface != null) {
          RenderSrfTex.this.mInputSurface.release();
        }
        if ((paramRecorderListener != null) && (RenderSrfTex.this.mRecorder != null)) {
          paramRecorderListener.onRecordFinish(RenderSrfTex.this.mRecorder.getOutputPath());
        }
        if ((RenderSrfTex.this.mGlThread != null) && (RenderSrfTex.this.mGlThread.isAlive()))
        {
          RenderSrfTex.this.mGlThread.quit();
          RenderSrfTex.access$1002(RenderSrfTex.this, null);
        }
      }
    });
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\ttpic\recorder\RenderSrfTex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */