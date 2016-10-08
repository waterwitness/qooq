package com.tencent.algo.filter;

import com.microrapid.opencv.OpencvAlgorithm;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.QImage;
import com.tencent.view.RendererUtils;

public class DehazeProcessFilter
  extends BaseFilter
{
  int paramTEXTRUEID = 0;
  float strength = 0.5F;
  
  public DehazeProcessFilter(float paramFloat)
  {
    super(GLSLRender.FILTER_SHADER_NONE);
    this.strength = paramFloat;
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    this.paramTEXTRUEID = RendererUtils.createTexture();
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
  
  public void ClearGLSL()
  {
    RendererUtils.clearTexture(this.paramTEXTRUEID);
    super.ClearGLSL();
  }
  
  public void beforeRender(int paramInt1, int paramInt2, int paramInt3)
  {
    QImage localQImage = RendererUtils.saveTexture2QImage(paramInt1, paramInt2, paramInt3);
    OpencvAlgorithm.nativeDehazeProcess(localQImage, this.strength);
    GLSLRender.nativeTextImage(localQImage, this.paramTEXTRUEID);
    localQImage.Dispose();
  }
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    return super.renderTexture(this.paramTEXTRUEID, paramInt2, paramInt3);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\algo\filter\DehazeProcessFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */