package com.tencent.ttpic.filterprocess;

import android.annotation.SuppressLint;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.Frame;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.SurfaceTextrueFilter;
import com.tencent.ttpic.filter.VideoFilterList;
import com.tencent.ttpic.filter.VideoFlipFilter;
import com.tencent.ttpic.model.VideoMaterial;
import com.tencent.ttpic.recorder.RenderSrfTex;
import com.tencent.ttpic.util.OnTextureReadyListener;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ttpic.util.VideoUtil;
import com.tencent.ttpic.util.youtu.VideoPreviewFaceOutlineDetector;
import com.tencent.util.ApiHelper;
import com.tencent.util.PhoneProperty;
import com.tencent.view.RendererUtils;
import java.util.List;

@SuppressLint({"NewApi"})
public class VideoFilterProcessBase
{
  private static final String TAG = VideoFilterProcessBase.class.getSimpleName();
  private boolean afterChange = false;
  private final boolean cannotReuseFrameBuffer = PhoneProperty.instance().isCannotReuseFrameBuffer();
  private byte[] data;
  private int height;
  private Frame lastFrame = new Frame();
  private OnTextureReadyListener listener;
  private double mAspectRatio = 0.0D;
  VideoFlipFilter mFlipFilter = VideoFlipFilter.createVideoFlipFilter();
  Frame mFlipFrame = new Frame();
  private SurfaceTexture mInputSurfaceTexture;
  private Frame mLastFrame = new Frame();
  SurfaceTextrueFilter mPreviewFilter = new SurfaceTextrueFilter();
  Frame mPreviewFrame = new Frame();
  private int[] mPreviewTextureId = new int[2];
  private RenderSrfTex mRenderSrfTex;
  Frame mTempFrame = new Frame();
  private int[] mTempTextureId = new int[3];
  private final float[] mTransformMatrix = new float[16];
  VideoFilterList mVideoFilters;
  BaseFilter mViewFilter = new BaseFilter(GLSLRender.FILTER_SHADER_NONE);
  Frame mViewFrame = new Frame();
  private float scaleFact = 1.0F;
  private int width;
  private double windowScale = 1.0D;
  
  private Frame getLastFrameAndRemove(Frame paramFrame)
  {
    if (paramFrame == null) {
      return null;
    }
    Frame localFrame = paramFrame;
    while ((paramFrame.nextFrame != null) && (paramFrame.nextFrame.getTextureId() != 0))
    {
      localFrame = paramFrame;
      paramFrame = paramFrame.nextFrame;
    }
    localFrame.nextFrame = null;
    return paramFrame;
  }
  
  private void setScale(float[] paramArrayOfFloat, double paramDouble1, double paramDouble2)
  {
    paramArrayOfFloat[0] = ((float)(1.0D / paramDouble1));
    paramArrayOfFloat[5] = ((float)(1.0D / paramDouble2));
    paramArrayOfFloat[12] = ((float)(1.0D - 1.0D / paramDouble1) / 2.0F);
    paramArrayOfFloat[13] = ((float)(1.0D - 1.0D / paramDouble2) / 2.0F);
  }
  
  public void changeVideoFilter(VideoFilterList paramVideoFilterList)
  {
    this.afterChange = true;
    this.mLastFrame = getLastFrameAndRemove(this.mPreviewFrame);
    this.mLastFrame.nextFrame = null;
    if (this.mLastFrame != this.mPreviewFrame) {
      this.mPreviewFrame.clear();
    }
    this.mTempFrame.clear();
    this.mFlipFrame.clear();
    if ((this.mVideoFilters != null) && (this.mVideoFilters.isValid()))
    {
      this.mVideoFilters.destroy();
      this.mVideoFilters = null;
    }
    if ((paramVideoFilterList != null) && (paramVideoFilterList.isValid()))
    {
      this.mVideoFilters = paramVideoFilterList;
      this.mVideoFilters.ApplyGLSLFilter();
      this.mVideoFilters.updateVideoSize(this.width, this.height, this.windowScale);
    }
  }
  
  public void clear()
  {
    this.mPreviewFrame.clear();
    this.mViewFrame.clear();
    this.mFlipFrame.clear();
    this.mTempFrame.clear();
    this.mLastFrame.clear();
    GLES20.glDeleteTextures(this.mPreviewTextureId.length, this.mPreviewTextureId, 0);
    GLES20.glDeleteTextures(this.mTempTextureId.length, this.mTempTextureId, 0);
    this.mPreviewFilter.ClearGLSL();
    this.mFlipFilter.ClearGLSL();
    if ((ApiHelper.HAS_RELEASE_SURFACE_TEXTURE) && (this.mInputSurfaceTexture != null))
    {
      this.mInputSurfaceTexture.release();
      this.mInputSurfaceTexture = null;
    }
    if ((this.mVideoFilters != null) && (this.mVideoFilters.isValid())) {
      this.mVideoFilters.destroy();
    }
  }
  
  public void clearVideoFilterTextures()
  {
    if ((this.mVideoFilters != null) && (this.mVideoFilters.isValid())) {
      this.mVideoFilters.clearFilterTextures();
    }
  }
  
  public int getHeight()
  {
    return this.height;
  }
  
  public SurfaceTexture getInputSurfaceTexture()
  {
    return this.mInputSurfaceTexture;
  }
  
  public int getWidth()
  {
    return this.width;
  }
  
  public void initial()
  {
    clear();
    GLES20.glGenTextures(this.mPreviewTextureId.length, this.mPreviewTextureId, 0);
    GLES20.glGenTextures(this.mTempTextureId.length, this.mTempTextureId, 0);
    this.mInputSurfaceTexture = new SurfaceTexture(this.mPreviewTextureId[0]);
    this.mPreviewFilter.setNextFilter(this.mViewFilter, null);
    this.mPreviewFilter.ApplyGLSLFilter(true, this.width, this.height);
    this.mFlipFilter.ApplyGLSLFilter();
  }
  
  public void setOnTextureReadyListener(OnTextureReadyListener paramOnTextureReadyListener)
  {
    this.listener = paramOnTextureReadyListener;
  }
  
  public void setRenderSrfTex(RenderSrfTex paramRenderSrfTex)
  {
    this.mRenderSrfTex = paramRenderSrfTex;
  }
  
  public void showPreview(int paramInt1, int paramInt2)
  {
    this.mPreviewFilter.nativeUpdateMatrix(this.mTransformMatrix);
    if (this.mVideoFilters != null)
    {
      BaseFilter localBaseFilter = this.mPreviewFilter.getmNextFilter();
      this.mPreviewFilter.removeTheFilter(localBaseFilter);
      this.mPreviewFilter.RenderProcess(this.mPreviewTextureId[0], this.width, this.height, this.mTempTextureId[0], this.mAspectRatio, this.mTempFrame);
      int i = (int)(this.width * VideoMaterialUtil.SCALE_FACE_DETECT);
      int j = (int)(this.height * VideoMaterialUtil.SCALE_FACE_DETECT);
      VideoPreviewFaceOutlineDetector.getInstance().init();
      if ((this.data == null) || (this.data.length != i * j * 4)) {
        this.data = new byte[i * j * 4];
      }
      this.mFlipFilter.RenderProcess(this.mTempTextureId[0], i, j, this.mTempTextureId[1], this.mAspectRatio, this.mFlipFrame);
      RendererUtils.saveTextureToRgbBuffer(this.mTempTextureId[1], i, j, this.data, this.mFlipFrame.getFBO());
      VideoPreviewFaceOutlineDetector.getInstance().doTrackProceses(this.data, i, j);
      if (VideoPreviewFaceOutlineDetector.getInstance().needDetectFace()) {
        VideoPreviewFaceOutlineDetector.getInstance().postJob(new Runnable()
        {
          public void run()
          {
            VideoPreviewFaceOutlineDetector.getInstance().doFaceDetect();
          }
        });
      }
      float f = VideoPreviewFaceOutlineDetector.getInstance().getPhotoAngle(this.mVideoFilters.getMaterial().isSupportLandscape());
      j = VideoPreviewFaceOutlineDetector.getInstance().getFaceCount();
      if (j <= 0)
      {
        this.mVideoFilters.updateAllFilters(null, VideoUtil.getFaceAngle(null), f);
        this.mVideoFilters.RenderProcess(this.mTempFrame.getFBO(), this.mTempFrame.getTextureId(), this.width, this.height);
      }
      i = 0;
      while (i < Math.min(j, this.mVideoFilters.getMaterial().getMaxFaceCount()))
      {
        List localList = VideoPreviewFaceOutlineDetector.getInstance().getAllPoints(i);
        this.mVideoFilters.updateAllFilters(localList, VideoUtil.getFaceAngle(localList), f);
        this.mVideoFilters.RenderProcess(this.mTempFrame.getFBO(), this.mTempFrame.getTextureId(), this.width, this.height);
        i += 1;
      }
      localBaseFilter.RenderProcess(this.mTempTextureId[0], this.width, this.height, -2, this.mAspectRatio, this.mPreviewFrame);
      this.mPreviewFilter.setNextFilter(localBaseFilter, null);
      if (this.mRenderSrfTex != null) {
        this.mRenderSrfTex.draw(this.mPreviewFrame.getLastRenderTextureId());
      }
      if (!this.afterChange) {
        break label554;
      }
      this.mViewFilter.RenderProcess(this.mLastFrame.getTextureId(), paramInt1, paramInt2, 0, this.mAspectRatio, this.mViewFrame);
      this.mLastFrame.clear();
      this.afterChange = false;
    }
    for (;;)
    {
      if (this.cannotReuseFrameBuffer)
      {
        this.mPreviewFrame.clear();
        this.mFlipFrame.clear();
        this.mTempFrame.clear();
      }
      return;
      this.mPreviewFilter.RenderProcess(this.mPreviewTextureId[0], this.width, this.height, -2, this.mAspectRatio, this.mPreviewFrame);
      break;
      label554:
      this.mViewFilter.RenderProcess(this.mPreviewFrame.getLastRenderTextureId(), paramInt1, paramInt2, 0, this.mAspectRatio, this.mViewFrame);
    }
  }
  
  public void update()
  {
    try
    {
      if (this.mInputSurfaceTexture != null)
      {
        this.mInputSurfaceTexture.updateTexImage();
        this.mInputSurfaceTexture.getTransformMatrix(this.mTransformMatrix);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void updatePreviewSize(int paramInt1, int paramInt2)
  {
    this.scaleFact = Math.min(720.0F / Math.min(paramInt1, paramInt2), 1.0F);
    this.width = ((int)(paramInt1 * this.scaleFact));
    this.height = ((int)(paramInt2 * this.scaleFact));
    if ((this.mVideoFilters != null) && (this.mVideoFilters.isValid())) {
      this.mVideoFilters.updateVideoSize(this.width, this.height, this.windowScale);
    }
    this.mPreviewFrame.clear();
    this.mTempFrame.clear();
    this.mFlipFrame.clear();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\ttpic\filterprocess\VideoFilterProcessBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */