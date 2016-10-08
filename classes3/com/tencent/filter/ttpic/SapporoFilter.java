package com.tencent.filter.ttpic;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.HSVColorChannelFilter;
import com.tencent.filter.Param.FloatsParam;
import com.tencent.filter.Param.TextureResParam;

public class SapporoFilter
  extends BaseFilter
{
  public SapporoFilter()
  {
    super(GLSLRender.FILTER_SHADER_NONE);
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    BaseFilter localBaseFilter = new BaseFilter(GLSLRender.FILTER_MIC_CURE_NEW_SHADER);
    localBaseFilter.addParam(new Param.TextureResParam("inputImageTexture2", "sh/sapporo_curve.png", 33986));
    setNextFilter(localBaseFilter, null);
    HSVColorChannelFilter localHSVColorChannelFilter = new HSVColorChannelFilter();
    ((HSVColorChannelFilter)localHSVColorChannelFilter).setInput(7.0F, 14.0F, 3.0F, 303.0F, 333.0F, 3.0F, 33.0F);
    localBaseFilter.setNextFilter(localHSVColorChannelFilter, null);
    localBaseFilter = new BaseFilter(GLSLRender.FILTER_SHADER_COLOR_BALANCE);
    localBaseFilter.addParam(new Param.FloatsParam("shadowsShift", new float[] { 0.0F, 0.0F, 0.0F }));
    localBaseFilter.addParam(new Param.FloatsParam("midtonesShift", new float[] { 0.0F, 0.06666667F, 0.011764706F }));
    localBaseFilter.addParam(new Param.FloatsParam("highlightsShift", new float[] { 0.0F, 0.0F, 0.0F }));
    localHSVColorChannelFilter.setNextFilter(localBaseFilter, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\filter\ttpic\SapporoFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */