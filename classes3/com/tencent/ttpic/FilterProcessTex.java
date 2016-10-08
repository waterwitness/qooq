package com.tencent.ttpic;

import android.opengl.GLES20;
import android.util.SparseArray;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.Frame;
import com.tencent.filter.SurfaceTextrueFilter;
import com.tencent.ttpic.filter.VideoFilterList;
import com.tencent.ttpic.filter.VideoFlipFilter;
import com.tencent.ttpic.model.VideoMaterial;
import com.tencent.ttpic.recorder.RetrieveDataListener;
import com.tencent.ttpic.util.RetrieveDataUtil;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ttpic.util.VideoUtil;
import com.tencent.ttpic.util.youtu.VideoPreviewFaceOutlineDetector;
import com.tencent.view.FilterDefault;
import com.tencent.view.RendererUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class FilterProcessTex
  extends FilterProcessBase
{
  private byte[] data;
  
  protected void initPreviewFilter()
  {
    this.mPreviewFilter = new SurfaceTextrueFilter();
  }
  
  public void showPreview(int paramInt1, int paramInt2)
  {
    FilterDefault.currentShareIndex = -1;
    this.mPreviewFilter.nativeUpdateMatrix(this.mTransformMatrix);
    this.mBlendFilter.nativeSetRotationAndFlip(-this.rotation, this.flipX, this.flipY);
    Object localObject1;
    int i;
    int j;
    Object localObject2;
    if (this.mVideoFilters != null)
    {
      localObject1 = this.mPreviewFilter.getmNextFilter();
      this.mPreviewFilter.removeTheFilter((BaseFilter)localObject1);
      this.mPreviewFilter.RenderProcess(this.mPreviewTextureId[0], this.width, this.height, this.mTempTextureId[0], this.mAspectRatio, this.mTempFrame);
      i = (int)(this.width * VideoMaterialUtil.SCALE_FACE_DETECT);
      j = (int)(this.height * VideoMaterialUtil.SCALE_FACE_DETECT);
      if ((this.data == null) || (this.data.length != i * j * 4)) {
        this.data = new byte[i * j * 4];
      }
      if (FilterDefault.currentShareIndex < 0)
      {
        this.mFlipFilter.RenderProcess(this.mTempTextureId[0], i, j, this.mTempTextureId[1], this.mAspectRatio, this.mFlipFrame);
        RendererUtils.saveTextureToRgbBuffer(this.mTempTextureId[1], i, j, this.data, this.mFlipFrame.getFBO());
      }
      for (;;)
      {
        if (needFaceDetect())
        {
          VideoPreviewFaceOutlineDetector.getInstance().init();
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
          localObject2 = VideoPreviewFaceOutlineDetector.getInstance().getAllPoints(i);
          this.mVideoFilters.updateAllFilters((List)localObject2, VideoUtil.getFaceAngle((List)localObject2), f);
          this.mVideoFilters.RenderProcess(this.mTempFrame.getFBO(), this.mTempFrame.getTextureId(), this.width, this.height);
          i += 1;
        }
        this.mFlipFilter.RenderProcess(this.mTempTextureId[0], i, j, -2, this.mAspectRatio, this.mFlipFrame);
        RendererUtils.saveTextureToRgbBuffer(-1, i, j, this.data, -1);
      }
      ((BaseFilter)localObject1).RenderProcess(this.mTempTextureId[0], this.width, this.height, -2, this.mAspectRatio, this.mPreviewFrame);
      if (this.onceTex != 0) {
        ((BaseFilter)localObject1).RenderProcess(this.onceTex, this.width, this.height, -2, this.mAspectRatio, this.mPreviewFrame);
      }
      this.mPreviewFilter.setNextFilter((BaseFilter)localObject1, null);
      if (this.onceTex == 0) {
        break label733;
      }
      this.mViewFilter.RenderProcess(this.onceTex, paramInt1, paramInt2, 0, this.mAspectRatio, this.mViewFrame);
      this.showOnceTexCount += 1;
      if (this.showOnceTexCount >= 1)
      {
        GLES20.glDeleteTextures(1, new int[] { this.onceTex }, 0);
        this.onceTex = 0;
      }
      label608:
      i = 0;
    }
    for (;;)
    {
      if (i >= this.mRetrieveDataListener.size()) {
        break label771;
      }
      j = this.mRetrieveDataListener.keyAt(i);
      localObject1 = RetrieveDataUtil.retrieveData(j, getSecondLastTextureId(this.mPreviewFrame), paramInt1, paramInt2);
      localObject2 = ((Set)this.mRetrieveDataListener.get(j)).iterator();
      for (;;)
      {
        if (((Iterator)localObject2).hasNext())
        {
          ((RetrieveDataListener)((Iterator)localObject2).next()).retrieveData(j, (byte[])localObject1);
          continue;
          this.mPreviewFilter.RenderProcess(this.mPreviewTextureId[0], this.width, this.height, -2, 0.0D, this.mPreviewFrame);
          break;
          label733:
          this.mViewFilter.RenderProcess(getSecondLastTextureId(this.mPreviewFrame), paramInt1, paramInt2, 0, this.mAspectRatio, this.mViewFrame);
          break label608;
        }
      }
      i += 1;
    }
    label771:
    if (this.cannotReuseFrameBuffer)
    {
      this.mPreviewFrame.clear();
      this.mFlipFrame.clear();
      this.mTempFrame.clear();
      this.mViewFrame.clear();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\ttpic\FilterProcessTex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */