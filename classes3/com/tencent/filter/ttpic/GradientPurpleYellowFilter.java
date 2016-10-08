package com.tencent.filter.ttpic;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.Param.FloatParam;
import com.tencent.filter.Param.TextureResParam;

public class GradientPurpleYellowFilter
  extends BaseFilter
{
  public GradientPurpleYellowFilter()
  {
    super(GLSLRender.FILTER_SHADER_NONE);
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    BaseFilter localBaseFilter2 = new BaseFilter(GLSLRender.FILTER_MIC_CURE_NEW_SHADER);
    localBaseFilter2.addParam(new Param.TextureResParam("inputImageTexture2", "sh/purpleyellow_nuan_curve.png", 33986));
    setNextFilter(localBaseFilter2, null);
    BaseFilter localBaseFilter1 = new BaseFilter(GLSLRender.FILTER_SHADER_VIVID_LIGHT_BLEND);
    if (this.needFlipBlend) {}
    for (int i = 1;; i = 0)
    {
      localBaseFilter1.addParam(new Param.TextureResParam("inputImageTexture2", "sh/gradient_purpleyellow_rgb.png", 33986, i));
      localBaseFilter1.addParam(new Param.FloatParam("ralpha", 0.6F));
      localBaseFilter1.addParam(new Param.FloatParam("galpha", 0.6F));
      localBaseFilter1.addParam(new Param.FloatParam("balpha", 0.6F));
      localBaseFilter2.setNextFilter(localBaseFilter1, null);
      localBaseFilter2 = new BaseFilter(GLSLRender.FILTER_MIC_CURE_NEW_SHADER);
      localBaseFilter2.addParam(new Param.TextureResParam("inputImageTexture2", "sh/purpleyellow_anticmos_curve.png", 33986));
      localBaseFilter1.setNextFilter(localBaseFilter2, null);
      super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\filter\ttpic\GradientPurpleYellowFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */