package com.tencent.filter.ttpic;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.HSVColorChannelFilter;
import com.tencent.filter.Param.FloatParam;
import com.tencent.filter.Param.FloatsParam;
import com.tencent.filter.Param.TextureResParam;

public class LightGreenFilter
  extends BaseFilter
{
  public LightGreenFilter()
  {
    super(GLSLRender.FILTER_SHADER_NONE);
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    Object localObject2 = new HSVColorChannelFilter();
    ((HSVColorChannelFilter)localObject2).setInput(3.0F, 17.0F, 3.0F, 310.0F, 340.0F, 10.0F, 40.0F);
    setNextFilter((BaseFilter)localObject2, null);
    Object localObject1 = new HSVColorChannelFilter();
    ((HSVColorChannelFilter)localObject1).setInput(3.0F, -13.0F, 3.0F, 356.0F, 26.0F, 62.0F, 91.0F);
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
    localObject2 = new BaseFilter(GLSLRender.FILTER_SHADER_DARKEN_BLEND);
    ((BaseFilter)localObject2).addParam(new Param.FloatsParam("color2", new float[] { 0.85882354F, 0.47843137F, 0.9137255F, 1.0F }));
    ((BaseFilter)localObject2).addParam(new Param.FloatParam("transparency", 0.5F));
    ((BaseFilter)localObject1).setNextFilter((BaseFilter)localObject2, null);
    localObject1 = new BaseFilter(GLSLRender.FILTER_MIC_CURE_NEW_SHADER);
    ((BaseFilter)localObject1).addParam(new Param.TextureResParam("inputImageTexture2", "sh/lightgreen_curve.png", 33986));
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
    localObject2 = new BaseFilter(GLSLRender.FILTER_SHADER_COLOR_BALANCE);
    ((BaseFilter)localObject2).addParam(new Param.FloatsParam("shadowsShift", new float[] { -0.019607844F, 0.015686275F, -0.011764706F }));
    ((BaseFilter)localObject2).addParam(new Param.FloatsParam("midtonesShift", new float[] { 0.02745098F, 0.0F, 0.0F }));
    ((BaseFilter)localObject2).addParam(new Param.FloatsParam("highlightsShift", new float[] { -0.047058824F, 0.023529412F, -0.015686275F }));
    ((BaseFilter)localObject1).setNextFilter((BaseFilter)localObject2, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\filter\ttpic\LightGreenFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */