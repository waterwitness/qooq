package com.tencent.ttpic.filter;

import android.graphics.PointF;
import android.opengl.GLES20;
import android.util.SparseArray;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.Frame;
import com.tencent.filter.GLSLRender;
import com.tencent.ttpic.model.VideoMaterial;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ttpic.util.VideoUtil;
import java.util.Iterator;
import java.util.List;

public class VideoFilterList
{
  private Frame[] copyFrame = new Frame[2];
  private List<VideoFilterBase> filters;
  private BaseFilter mCopyFilter = new BaseFilter(GLSLRender.FILTER_SHADER_NONE);
  private int[] mCopyTex = new int[2];
  private boolean mProcessSync = true;
  private SparseArray<Frame> mTexFrames;
  private VideoMaterial material;
  private Frame renderFrame = new Frame();
  
  public void ApplyGLSLFilter()
  {
    if (VideoUtil.isEmpty(this.filters)) {
      return;
    }
    init();
    Iterator localIterator = this.filters.iterator();
    while (localIterator.hasNext()) {
      ((VideoFilterBase)localIterator.next()).ApplyGLSLFilter();
    }
    VideoFilterUtil.setRenderMode(this.filters, 1);
  }
  
  public void RenderProcess(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((VideoUtil.isEmpty(this.filters)) || (paramInt1 < 0) || (paramInt2 < 0)) {
      return;
    }
    if (VideoFilterUtil.needBlendMode(this.filters)) {
      VideoFilterUtil.setBlendMode(true);
    }
    if (VideoMaterialUtil.isDistortionFilter(this.material))
    {
      RenderProcessByCopy1(paramInt2, paramInt3, paramInt4, paramInt2);
      VideoFilterUtil.setBlendMode(false);
      return;
    }
    if (this.mProcessSync)
    {
      GLES20.glBindFramebuffer(36160, paramInt1);
      GLES20.glViewport(0, 0, paramInt3, paramInt4);
    }
    for (;;)
    {
      paramInt1 = 0;
      while (paramInt1 < this.filters.size())
      {
        localObject = (VideoFilterBase)this.filters.get(paramInt1);
        ((VideoFilterBase)localObject).OnDrawFrameGLSL();
        ((VideoFilterBase)localObject).renderTexture(paramInt2, paramInt3, paramInt4);
        paramInt1 += 1;
      }
      break;
      Frame localFrame = (Frame)this.mTexFrames.get(paramInt2);
      Object localObject = localFrame;
      if (localFrame == null)
      {
        localObject = new Frame();
        this.mTexFrames.put(paramInt2, localObject);
      }
      ((Frame)localObject).bindFrame(paramInt2, paramInt3, paramInt4, 0.0D);
    }
  }
  
  public void RenderProcessByCopy1(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (VideoUtil.isEmpty(this.filters)) {}
    for (;;)
    {
      return;
      this.mCopyFilter.RenderProcess(paramInt1, paramInt2, paramInt3, this.mCopyTex[0], 0.0D, this.copyFrame[0]);
      Iterator localIterator = this.filters.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (VideoFilterBase)localIterator.next();
        GLES20.glBindFramebuffer(36160, this.copyFrame[0].getFBO());
        GLES20.glViewport(0, 0, paramInt2, paramInt3);
        ((VideoFilterBase)localObject).OnDrawFrameGLSL();
        ((VideoFilterBase)localObject).renderTexture(paramInt1, paramInt2, paramInt3);
        Frame localFrame = (Frame)this.mTexFrames.get(paramInt1);
        localObject = localFrame;
        if (localFrame == null)
        {
          localObject = new Frame();
          this.mTexFrames.put(paramInt1, localObject);
        }
        this.mCopyFilter.RenderProcess(this.mCopyTex[0], paramInt2, paramInt3, paramInt1, 0.0D, (Frame)localObject);
      }
    }
  }
  
  public void RenderProcessByCopy2(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (VideoUtil.isEmpty(this.filters)) {
      return;
    }
    BenchUtil.benchStart("[RenderProcess] mCopyFilter.RenderProcess first");
    GLES20.glActiveTexture(33985);
    GLES20.glBindTexture(3553, this.mCopyTex[0]);
    GLES20.glCopyTexImage2D(3553, 0, 6408, 0, 0, paramInt2, paramInt3, 0);
    GLES20.glBindTexture(3553, this.mCopyTex[1]);
    GLES20.glCopyTexImage2D(3553, 0, 6408, 0, 0, paramInt2, paramInt3, 0);
    BenchUtil.benchEnd("[RenderProcess] mCopyFilter.RenderProcess first");
    BenchUtil.benchStart("[RenderProcess] renderFrame.bindFrame");
    this.renderFrame.bindFrame(this.mCopyTex[0], paramInt2, paramInt3, 0.0D);
    BenchUtil.benchEnd("[RenderProcess] renderFrame.bindFrame");
    paramInt1 = 0;
    label110:
    if (paramInt1 < this.filters.size())
    {
      VideoFilterBase localVideoFilterBase = (VideoFilterBase)this.filters.get(paramInt1);
      BenchUtil.benchStart("[RenderProcess] filter.OnDrawFrameGLSL");
      localVideoFilterBase.OnDrawFrameGLSL();
      BenchUtil.benchEnd("[RenderProcess] filter.OnDrawFrameGLSL", this.filters.size());
      BenchUtil.benchStart("[RenderProcess] filter.renderTexture");
      localVideoFilterBase.renderTexture(this.mCopyTex[1], paramInt2, paramInt3);
      BenchUtil.benchEnd("[RenderProcess] filter.renderTexture", this.filters.size());
      BenchUtil.benchStart("[RenderProcess] mCopyFilter.RenderProcess second");
      GLES20.glActiveTexture(33985);
      if (paramInt1 != this.filters.size() - 1) {
        break label264;
      }
      GLES20.glBindTexture(3553, paramInt4);
    }
    for (;;)
    {
      GLES20.glCopyTexImage2D(3553, 0, 6408, 0, 0, paramInt2, paramInt3, 0);
      BenchUtil.benchEnd("[RenderProcess] mCopyFilter.RenderProcess second", this.filters.size());
      paramInt1 += 1;
      break label110;
      break;
      label264:
      GLES20.glBindTexture(3553, this.mCopyTex[1]);
    }
  }
  
  public void clearFilterTextures()
  {
    if (VideoUtil.isEmpty(this.filters)) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.filters.iterator();
      while (localIterator.hasNext())
      {
        BaseFilter localBaseFilter = (BaseFilter)localIterator.next();
        if ((localBaseFilter instanceof NormalVideoFilter)) {
          ((NormalVideoFilter)localBaseFilter).clearTextureParam();
        }
      }
    }
  }
  
  public void destroy()
  {
    if (VideoUtil.isEmpty(this.filters)) {
      return;
    }
    if (!VideoUtil.isEmpty(this.filters))
    {
      Iterator localIterator = this.filters.iterator();
      while (localIterator.hasNext()) {
        ((VideoFilterBase)localIterator.next()).clearGLSLSelf();
      }
    }
    this.filters.clear();
    this.renderFrame.clear();
    int i = 0;
    while (i < this.copyFrame.length)
    {
      this.copyFrame[i].clear();
      i += 1;
    }
    i = 0;
    while (i < this.mTexFrames.size())
    {
      ((Frame)this.mTexFrames.valueAt(i)).clear();
      i += 1;
    }
    this.mTexFrames.clear();
    this.mCopyFilter.ClearGLSL();
    GLES20.glDeleteTextures(this.mCopyTex.length, this.mCopyTex, 0);
    destroyAudio();
  }
  
  public void destroyAudio()
  {
    if (VideoUtil.isEmpty(this.filters)) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.filters.iterator();
      while (localIterator.hasNext())
      {
        BaseFilter localBaseFilter = (BaseFilter)localIterator.next();
        if ((localBaseFilter instanceof NormalVideoFilter)) {
          ((NormalVideoFilter)localBaseFilter).destroyAudio();
        }
      }
    }
  }
  
  public List<VideoFilterBase> getFilters()
  {
    return this.filters;
  }
  
  public VideoMaterial getMaterial()
  {
    return this.material;
  }
  
  public void init()
  {
    this.mCopyFilter.ApplyGLSLFilter();
    this.mTexFrames = new SparseArray(2);
    int i = 0;
    while (i < this.copyFrame.length)
    {
      this.copyFrame[i] = new Frame();
      i += 1;
    }
    GLES20.glGenTextures(this.mCopyTex.length, this.mCopyTex, 0);
  }
  
  public boolean isValid()
  {
    return !VideoUtil.isEmpty(this.filters);
  }
  
  public void setFilters(List<VideoFilterBase> paramList)
  {
    this.filters = paramList;
  }
  
  public void setMaterial(VideoMaterial paramVideoMaterial)
  {
    this.material = paramVideoMaterial;
  }
  
  public void setProcessSync(boolean paramBoolean)
  {
    this.mProcessSync = paramBoolean;
  }
  
  public void updateAllFilters(List<PointF> paramList, float paramFloat1, float paramFloat2)
  {
    if (VideoUtil.isEmpty(this.filters)) {}
    for (;;)
    {
      return;
      long l = System.currentTimeMillis();
      Iterator localIterator = this.filters.iterator();
      while (localIterator.hasNext()) {
        ((VideoFilterBase)localIterator.next()).updatePreview(paramList, paramFloat1, paramFloat2, l);
      }
    }
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    if (VideoUtil.isEmpty(this.filters)) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.filters.iterator();
      while (localIterator.hasNext())
      {
        BaseFilter localBaseFilter = (BaseFilter)localIterator.next();
        if ((localBaseFilter instanceof VideoFilterBase)) {
          ((VideoFilterBase)localBaseFilter).updateVideoSize(paramInt1, paramInt2, paramDouble);
        }
      }
    }
  }
  
  private class FaceData
  {
    public float mFaceAngle;
    public List<PointF> mFacePoints;
    public float mPhoneAngle;
    public long mTimeStamp;
    
    private FaceData() {}
    
    public void init(List<PointF> paramList, float paramFloat1, float paramFloat2, long paramLong)
    {
      this.mFacePoints = paramList;
      this.mFaceAngle = paramFloat1;
      this.mPhoneAngle = paramFloat2;
      this.mTimeStamp = paramLong;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\ttpic\filter\VideoFilterList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */