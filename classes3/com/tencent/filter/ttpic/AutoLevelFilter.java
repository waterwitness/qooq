package com.tencent.filter.ttpic;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.Param.FloatParam;

public class AutoLevelFilter
  extends BaseFilter
{
  public AutoLevelFilter()
  {
    super(GLSLRender.FILTER_SHADER_NONE);
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    if (paramBoolean)
    {
      super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
      return;
    }
    BaseFilter localBaseFilter = new BaseFilter(GLSLRender.VERTEXT_HSVCHANNELSHARPEN_SHADER, GLSLRender.FILTER_HSVNCHANNEL_SHARPEN_SHADER);
    localBaseFilter.addParam(new Param.FloatParam("sharpness", 0.2F));
    localBaseFilter.addParam(new Param.FloatParam("inputH", 1.0F));
    localBaseFilter.addParam(new Param.FloatParam("inputS", 1.2F));
    localBaseFilter.addParam(new Param.FloatParam("inputV", 1.0F));
    localBaseFilter.addParam(new Param.FloatParam("imageWidthFactor", 1.0F / paramFloat1));
    localBaseFilter.addParam(new Param.FloatParam("imageHeightFactor", 1.0F / paramFloat2));
    setNextFilter(localBaseFilter, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\filter\ttpic\AutoLevelFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */