package com.tencent.filter.ttpic;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.HSVColorChannelFilter;
import com.tencent.filter.Param.FloatParam;
import com.tencent.filter.Param.FloatsParam;
import com.tencent.filter.Param.TextureResParam;

public class MapleRedFilter
  extends BaseFilter
{
  public MapleRedFilter()
  {
    super(GLSLRender.FILTER_SHADER_NONE);
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    Object localObject2 = new BaseFilter(GLSLRender.FILTER_SHADER_DARKEN_BLEND);
    ((BaseFilter)localObject2).addParam(new Param.FloatsParam("color2", new float[] { 0.93333334F, 0.67058825F, 0.89411765F, 1.0F }));
    ((BaseFilter)localObject2).addParam(new Param.FloatParam("transparency", 0.3F));
    setNextFilter((BaseFilter)localObject2, null);
    Object localObject1 = new BaseFilter(GLSLRender.FILTER_SHADER_COLORBURN_BLEND);
    ((BaseFilter)localObject1).addParam(new Param.FloatsParam("color2", new float[] { 0.89411765F, 0.63529414F, 0.22352941F, 1.0F }));
    ((BaseFilter)localObject1).addParam(new Param.FloatParam("transparency", 0.1F));
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
    localObject2 = new HSVColorChannelFilter();
    ((HSVColorChannelFilter)localObject2).setInput(0.0F, 5.0F, 1.0F, 310.0F, 340.0F, 10.0F, 40.0F);
    ((BaseFilter)localObject1).setNextFilter((BaseFilter)localObject2, null);
    localObject1 = new HSVColorChannelFilter();
    ((HSVColorChannelFilter)localObject1).setInput(0.0F, -22.0F, 15.0F, 355.0F, 18.0F, 58.0F, 79.0F);
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
    localObject2 = new BaseFilter(GLSLRender.FILTER_SHADER_COLOR_BALANCE);
    ((BaseFilter)localObject2).addParam(new Param.FloatsParam("shadowsShift", new float[] { -0.02745098F, -0.05490196F, 0.0F }));
    ((BaseFilter)localObject2).addParam(new Param.FloatsParam("midtonesShift", new float[] { 0.0F, 0.0F, 0.0F }));
    ((BaseFilter)localObject2).addParam(new Param.FloatsParam("highlightsShift", new float[] { 0.0F, -0.047058824F, -0.047058824F }));
    ((BaseFilter)localObject1).setNextFilter((BaseFilter)localObject2, null);
    localObject1 = new BaseFilter(GLSLRender.FILTER_MIC_CURE_NEW_SHADER);
    ((BaseFilter)localObject1).addParam(new Param.TextureResParam("inputImageTexture2", "sh/maplered_curve.png", 33986));
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\filter\ttpic\MapleRedFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */