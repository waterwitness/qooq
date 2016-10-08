package com.tencent.ttpic.gles;

import android.annotation.TargetApi;
import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.Frame;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.Param.Float2fParam;
import com.tencent.filter.Param.FloatParam;
import com.tencent.filter.Param.IntParam;
import com.tencent.ttpic.filter.VideoFilterList;
import com.tencent.ttpic.filter.VideoFlipFilter;
import com.tencent.ttpic.model.VideoMaterial;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.ttpic.util.VideoUtil;
import com.tencent.ttpic.util.youtu.VideoPreviewFaceOutlineDetector;
import com.tencent.view.FilterDefault;
import com.tencent.view.RendererUtils;
import java.nio.IntBuffer;
import java.util.List;

@TargetApi(18)
public class OffscreenGLThread
{
  private static final boolean DEBUG = true;
  private OnDataReadyListener listener;
  private BaseFilter mCopyFilter = new BaseFilter(GLSLRender.FILTER_SHADER_NONE);
  private Frame mCopyFrame;
  private EglCore mCore;
  private byte[] mData;
  private VideoFlipFilter mFlipFilter = VideoFlipFilter.createVideoFlipFilter();
  private Frame mFlipFrame;
  private Handler mHandler;
  private int mHeight;
  private OffscreenSurface mOffscreenSurface;
  private int[] mOutputTexId = new int[1];
  private double mScaleFaceDetect;
  private VideoFilterList mVideoFilters;
  private int mWidth;
  private int pbo;
  private byte[] pixelArray;
  private IntBuffer pixelBuffer;
  private GLSharedData sharedData;
  
  public OffscreenGLThread(final EGLContext paramEGLContext, final int paramInt1, final int paramInt2, final double paramDouble)
  {
    HandlerThread localHandlerThread = new HandlerThread("OffscreenGLThread" + (int)(Math.random() * 100.0D));
    localHandlerThread.start();
    this.mHandler = new Handler(localHandlerThread.getLooper());
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        OffscreenGLThread.access$002(OffscreenGLThread.this, new EglCore(paramEGLContext, 0));
        OffscreenGLThread.access$102(OffscreenGLThread.this, new OffscreenSurface(OffscreenGLThread.this.mCore, paramInt1, paramInt2));
        OffscreenGLThread.this.mOffscreenSurface.makeCurrent();
        OffscreenGLThread.this.mFlipFilter.ApplyGLSLFilter();
        OffscreenGLThread.this.mCopyFilter.ApplyGLSLFilter();
        int[] arrayOfInt = new int[2];
        GLES20.glGenTextures(OffscreenGLThread.this.mOutputTexId.length, OffscreenGLThread.this.mOutputTexId, 0);
        GLES20.glGenTextures(arrayOfInt.length, arrayOfInt, 0);
        Frame localFrame1 = new Frame();
        Frame localFrame2 = new Frame();
        OffscreenGLThread.access$502(OffscreenGLThread.this, new GLSharedData(paramEGLContext, arrayOfInt, new Frame[] { localFrame1, localFrame2 }));
        OffscreenGLThread.access$602(OffscreenGLThread.this, new Frame());
        OffscreenGLThread.access$702(OffscreenGLThread.this, new Frame());
        OffscreenGLThread.access$802(OffscreenGLThread.this, paramInt1);
        OffscreenGLThread.access$902(OffscreenGLThread.this, paramInt2);
        OffscreenGLThread.access$1002(OffscreenGLThread.this, paramDouble);
      }
    });
  }
  
  public void changeSize(final int paramInt1, final int paramInt2, final double paramDouble)
  {
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        OffscreenGLThread.access$802(OffscreenGLThread.this, paramInt1);
        OffscreenGLThread.access$902(OffscreenGLThread.this, paramInt2);
        OffscreenGLThread.access$1002(OffscreenGLThread.this, paramDouble);
        if ((OffscreenGLThread.this.mVideoFilters != null) && (OffscreenGLThread.this.mVideoFilters.isValid())) {
          OffscreenGLThread.this.mVideoFilters.updateVideoSize(OffscreenGLThread.this.mWidth, OffscreenGLThread.this.mHeight, OffscreenGLThread.this.mScaleFaceDetect);
        }
      }
    });
  }
  
  public void destroy()
  {
    if (this.mHandler != null) {
      this.mHandler.post(new Runnable()
      {
        public void run()
        {
          OffscreenGLThread.this.sharedData.clear();
          OffscreenGLThread.this.mFlipFrame.clear();
          OffscreenGLThread.this.mCopyFrame.clear();
          OffscreenGLThread.this.mFlipFilter.ClearGLSL();
          OffscreenGLThread.this.mCopyFilter.ClearGLSL();
          GLES20.glDeleteTextures(OffscreenGLThread.this.mOutputTexId.length, OffscreenGLThread.this.mOutputTexId, 0);
          OffscreenGLThread.this.mOffscreenSurface.release();
          OffscreenGLThread.this.mCore.release();
          OffscreenGLThread.this.mHandler.getLooper().quit();
        }
      });
    }
  }
  
  public TextureDataPipe getCurrentDataPipe()
  {
    if (this.sharedData == null) {
      return null;
    }
    return this.sharedData.getCurrentTexturePile();
  }
  
  public boolean hasVideoFilters()
  {
    return VideoFilterUtil.isValid(this.mVideoFilters);
  }
  
  public void postDoFaceDetect(final int paramInt, final float paramFloat)
  {
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        VideoPreviewFaceOutlineDetector.getInstance().init();
        OffscreenGLThread.this.mFlipFilter.addParam(new Param.Float2fParam("canvasSize", OffscreenGLThread.this.mWidth, OffscreenGLThread.this.mHeight));
        OffscreenGLThread.this.mFlipFilter.addParam(new Param.FloatParam("texRotate", -paramFloat));
        OffscreenGLThread.this.mFlipFilter.addParam(new Param.IntParam("texNeedTransform", 1));
        int i = (int)(OffscreenGLThread.this.mWidth * OffscreenGLThread.this.mScaleFaceDetect);
        int j = (int)(OffscreenGLThread.this.mHeight * OffscreenGLThread.this.mScaleFaceDetect);
        int k = i * j * 4;
        if ((OffscreenGLThread.this.mData == null) || (OffscreenGLThread.this.mData.length != k)) {
          OffscreenGLThread.access$1102(OffscreenGLThread.this, new byte[k]);
        }
        if (FilterDefault.currentShareIndex < 0)
        {
          OffscreenGLThread.this.mFlipFilter.RenderProcess(paramInt, i, j, OffscreenGLThread.this.mOutputTexId[0], 0.0D, OffscreenGLThread.this.mFlipFrame);
          RendererUtils.saveTextureToRgbBuffer(OffscreenGLThread.this.mOutputTexId[0], i, j, OffscreenGLThread.this.mData, OffscreenGLThread.this.mFlipFrame.getFBO());
        }
        for (;;)
        {
          VideoPreviewFaceOutlineDetector.getInstance().doTrackProceses(OffscreenGLThread.this.mData, i, j);
          if (VideoPreviewFaceOutlineDetector.getInstance().needDetectFace()) {
            VideoPreviewFaceOutlineDetector.getInstance().postJob(new Runnable()
            {
              public void run()
              {
                VideoPreviewFaceOutlineDetector.getInstance().doFaceDetect();
              }
            });
          }
          return;
          OffscreenGLThread.this.mFlipFilter.RenderProcess(paramInt, i, j, -2, 0.0D, OffscreenGLThread.this.mFlipFrame);
          RendererUtils.saveTextureToRgbBuffer(-1, i, j, OffscreenGLThread.this.mData, -1);
        }
      }
    });
  }
  
  public void postRenderVideoFilters(final int paramInt1, final int paramInt2)
  {
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        if (!VideoFilterUtil.isValid(OffscreenGLThread.this.mVideoFilters)) {}
        TextureDataPipe localTextureDataPipe;
        do
        {
          return;
          localTextureDataPipe = OffscreenGLThread.this.sharedData.getFreeTexturePileMakeBusy();
        } while (localTextureDataPipe == null);
        localTextureDataPipe.mTimestamp = System.currentTimeMillis();
        OffscreenGLThread.this.mCopyFilter.RenderProcess(paramInt2, OffscreenGLThread.this.mWidth, OffscreenGLThread.this.mHeight, localTextureDataPipe.mTextureId, 0.0D, localTextureDataPipe.mTexFrame);
        float f = VideoPreviewFaceOutlineDetector.getInstance().getPhotoAngle(OffscreenGLThread.this.mVideoFilters.getMaterial().isSupportLandscape());
        VideoPreviewFaceOutlineDetector.getInstance().init();
        OffscreenGLThread.this.mFlipFilter.addParam(new Param.Float2fParam("canvasSize", OffscreenGLThread.this.mWidth, OffscreenGLThread.this.mHeight));
        OffscreenGLThread.this.mFlipFilter.addParam(new Param.FloatParam("texRotate", -f));
        OffscreenGLThread.this.mFlipFilter.addParam(new Param.IntParam("texNeedTransform", 1));
        int i = (int)(OffscreenGLThread.this.mWidth * OffscreenGLThread.this.mScaleFaceDetect);
        int j = (int)(OffscreenGLThread.this.mHeight * OffscreenGLThread.this.mScaleFaceDetect);
        int k = i * j * 4;
        if ((OffscreenGLThread.this.mData == null) || (OffscreenGLThread.this.mData.length != k)) {
          OffscreenGLThread.access$1102(OffscreenGLThread.this, new byte[k]);
        }
        if (FilterDefault.currentShareIndex < 0)
        {
          OffscreenGLThread.this.mFlipFilter.RenderProcess(paramInt1, i, j, OffscreenGLThread.this.mOutputTexId[0], 0.0D, OffscreenGLThread.this.mFlipFrame);
          RendererUtils.saveTextureToRgbBuffer(OffscreenGLThread.this.mOutputTexId[0], i, j, OffscreenGLThread.this.mData, OffscreenGLThread.this.mFlipFrame.getFBO());
        }
        for (;;)
        {
          VideoPreviewFaceOutlineDetector.getInstance().doTrackProceses(OffscreenGLThread.this.mData, i, j);
          if (VideoPreviewFaceOutlineDetector.getInstance().needDetectFace()) {
            VideoPreviewFaceOutlineDetector.getInstance().postJob(new Runnable()
            {
              public void run()
              {
                VideoPreviewFaceOutlineDetector.getInstance().doFaceDetect();
              }
            });
          }
          j = VideoPreviewFaceOutlineDetector.getInstance().getFaceCount();
          if (j <= 0)
          {
            OffscreenGLThread.this.mVideoFilters.updateAllFilters(null, VideoUtil.getFaceAngle(null), f);
            OffscreenGLThread.this.mVideoFilters.RenderProcess(localTextureDataPipe.mTexFrame.getFBO(), localTextureDataPipe.mTexFrame.getTextureId(), OffscreenGLThread.this.mWidth, OffscreenGLThread.this.mHeight);
          }
          i = 0;
          while (i < Math.min(j, OffscreenGLThread.this.mVideoFilters.getMaterial().getMaxFaceCount()))
          {
            List localList = VideoPreviewFaceOutlineDetector.getInstance().getAllPoints(i);
            OffscreenGLThread.this.mVideoFilters.updateAllFilters(localList, VideoUtil.getFaceAngle(localList), f);
            OffscreenGLThread.this.mVideoFilters.RenderProcess(localTextureDataPipe.mTexFrame.getFBO(), localTextureDataPipe.mTexFrame.getTextureId(), OffscreenGLThread.this.mWidth, OffscreenGLThread.this.mHeight);
            i += 1;
          }
          OffscreenGLThread.this.mFlipFilter.RenderProcess(paramInt1, i, j, -2, 0.0D, OffscreenGLThread.this.mFlipFrame);
          RendererUtils.saveTextureToRgbBuffer(-1, i, j, OffscreenGLThread.this.mData, -1);
        }
        localTextureDataPipe.makeDataReady();
        if (OffscreenGLThread.this.listener != null)
        {
          OffscreenGLThread.this.listener.onDataReady(localTextureDataPipe);
          return;
        }
        localTextureDataPipe.makeFree();
      }
    });
  }
  
  public void setOnDataReadyListener(OnDataReadyListener paramOnDataReadyListener)
  {
    this.listener = paramOnDataReadyListener;
  }
  
  public void setVideoFilters(final VideoFilterList paramVideoFilterList)
  {
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        if (VideoFilterUtil.isValid(OffscreenGLThread.this.mVideoFilters))
        {
          OffscreenGLThread.this.mVideoFilters.destroy();
          OffscreenGLThread.access$1202(OffscreenGLThread.this, null);
        }
        if (VideoFilterUtil.isValid(paramVideoFilterList))
        {
          OffscreenGLThread.access$1202(OffscreenGLThread.this, paramVideoFilterList);
          OffscreenGLThread.this.mVideoFilters.ApplyGLSLFilter();
          OffscreenGLThread.this.mVideoFilters.updateVideoSize(OffscreenGLThread.this.mWidth, OffscreenGLThread.this.mHeight, OffscreenGLThread.this.mScaleFaceDetect);
          VideoFilterUtil.setRenderMode(OffscreenGLThread.this.mVideoFilters.getFilters(), 1);
          return;
        }
        VideoPreviewFaceOutlineDetector.getInstance().destroy();
      }
    });
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\ttpic\gles\OffscreenGLThread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */