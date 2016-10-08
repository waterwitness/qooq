package com.tencent.filter.ttpic;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.HSVColorChannelFilter;
import com.tencent.filter.Param.FloatParam;
import com.tencent.filter.Param.FloatsParam;
import com.tencent.filter.Param.TextureResParam;

public class OceanFilter
  extends BaseFilter
{
  public OceanFilter()
  {
    super(GLSLRender.FILTER_SHADER_NONE);
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    BaseFilter localBaseFilter = new BaseFilter(GLSLRender.FILTER_MIC_CURE_NEW_SHADER);
    localBaseFilter.addParam(new Param.TextureResParam("inputImageTexture2", "sh/ocean_curve2.png", 33986));
    setNextFilter(localBaseFilter, null);
    Object localObject = new BaseFilter(GLSLRender.FILTER_MIC_CURE_NEW_SHADER);
    ((BaseFilter)localObject).addParam(new Param.TextureResParam("inputImageTexture2", "sh/ocean_curve3.png", 33986));
    localBaseFilter.setNextFilter((BaseFilter)localObject, null);
    localBaseFilter = new BaseFilter(GLSLRender.FILTER_SHADER_MULTIPLY_BLEND);
    localBaseFilter.addParam(new Param.FloatsParam("color2", new float[] { 0.84313726F, 0.8784314F, 0.78431374F, 1.0F }));
    localBaseFilter.addParam(new Param.FloatParam("transparency", 0.35F));
    ((BaseFilter)localObject).setNextFilter(localBaseFilter, null);
    localObject = new BaseFilter(GLSLRender.FILTER_SOFTLIGHTBLEND2_SHADER);
    ((BaseFilter)localObject).addParam(new Param.FloatsParam("color2", new float[] { 0.09411765F, 0.19607843F, 0.3019608F, 1.0F }));
    ((BaseFilter)localObject).addParam(new Param.FloatParam("transparency", 0.42F));
    localBaseFilter.setNextFilter((BaseFilter)localObject, null);
    localBaseFilter = new BaseFilter(GLSLRender.FILTER_SHADER_COLOR_BALANCE);
    localBaseFilter.addParam(new Param.FloatsParam("shadowsShift", new float[] { -0.11764706F, 0.0F, 0.11372549F }));
    localBaseFilter.addParam(new Param.FloatsParam("midtonesShift", new float[] { -0.07058824F, 0.0F, 0.039215688F }));
    localBaseFilter.addParam(new Param.FloatsParam("highlightsShift", new float[] { -0.023529412F, 0.0F, 0.019607844F }));
    ((BaseFilter)localObject).setNextFilter(localBaseFilter, null);
    localObject = new HSVColorChannelFilter();
    ((HSVColorChannelFilter)localObject).setInput(0.0F, 9.0F, 9.0F, 307.0F, 336.0F, 6.0F, 37.0F);
    localBaseFilter.setNextFilter((BaseFilter)localObject, null);
    localBaseFilter = new BaseFilter(GLSLRender.FILTER_VIBRANCE);
    localBaseFilter.addParam(new Param.FloatParam("contrast", 1.1F));
    localBaseFilter.addParam(new Param.FloatParam("saturation", 1.0F));
    localBaseFilter.addParam(new Param.FloatParam("brightness", 1.0F));
    ((BaseFilter)localObject).setNextFilter(localBaseFilter, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\filter\ttpic\OceanFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */