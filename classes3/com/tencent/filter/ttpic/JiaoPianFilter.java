package com.tencent.filter.ttpic;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.Param.FloatsParam;
import com.tencent.filter.Param.IntParam;
import com.tencent.filter.Param.TextureResParam;

public class JiaoPianFilter
  extends BaseFilter
{
  public JiaoPianFilter()
  {
    super(GLSLRender.FILTER_SHADER_NONE);
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    BaseFilter localBaseFilter1 = new BaseFilter(GLSLRender.FILTER_SHADER_COLOR_BALANCE);
    localBaseFilter1.addParam(new Param.FloatsParam("shadowsShift", new float[] { -0.05882353F, 0.03529412F, -0.023529412F }));
    localBaseFilter1.addParam(new Param.FloatsParam("midtonesShift", new float[] { 0.0F, 0.0F, 0.0F }));
    localBaseFilter1.addParam(new Param.FloatsParam("highlightsShift", new float[] { 0.07450981F, 0.0F, -0.015686275F }));
    localBaseFilter1.addParam(new Param.IntParam("preserveLuminosity", 1));
    setNextFilter(localBaseFilter1, null);
    BaseFilter localBaseFilter2 = new BaseFilter(GLSLRender.FILTER_SHADER_SELECTIVECOLOR);
    localBaseFilter2.addParam(new Param.TextureResParam("inputImageTexture2", "sh/jiaopian.png", 33986));
    localBaseFilter2.addParam(new Param.FloatsParam("channelvec", new float[] { 0.0F, 1.0F, 0.0F }));
    localBaseFilter1.setNextFilter(localBaseFilter2, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\filter\ttpic\JiaoPianFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */