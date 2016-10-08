package com.tencent.filter.ttpic;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.BeautysFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.Param.FloatParam;
import com.tencent.filter.Param.FloatsParam;
import com.tencent.filter.Param.IntParam;
import java.util.Map;

public class Fen2Filter
  extends BaseFilter
{
  private int effectindex = 1;
  
  public Fen2Filter()
  {
    super(GLSLRender.FILTER_SHADER_NONE);
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    Object localObject = new BeautysFilter(GLSLRender.FILTER_SHADER_NONE, this.effectindex);
    ((BaseFilter)localObject).setEffectIndex(7);
    ((BaseFilter)localObject).setSrcFilterIndex(this.srcTextureIndex + 1);
    ((BaseFilter)localObject).ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
    setNextFilter((BaseFilter)localObject, null);
    BaseFilter localBaseFilter = ((BaseFilter)localObject).getLastFilter();
    localObject = new BaseFilter(GLSLRender.FILTER_SHADER_COLOR_BALANCE);
    ((BaseFilter)localObject).addParam(new Param.FloatsParam("shadowsShift", new float[] { 0.0F, 0.0F, 0.0F }));
    ((BaseFilter)localObject).addParam(new Param.FloatsParam("midtonesShift", new float[] { 0.0772549F, 0.0F, 0.0F }));
    ((BaseFilter)localObject).addParam(new Param.FloatsParam("highlightsShift", new float[] { 0.039058823F, 0.0F, 0.0F }));
    ((BaseFilter)localObject).addParam(new Param.IntParam("preserveLuminosity", 1));
    localBaseFilter.setNextFilter((BaseFilter)localObject, null);
    localBaseFilter = new BaseFilter(GLSLRender.FILTER_HSVADJUSTER2_SHADER);
    localBaseFilter.addParam(new Param.FloatParam("inputH", 1.0F));
    localBaseFilter.addParam(new Param.FloatParam("inputS", 1.0F));
    localBaseFilter.addParam(new Param.FloatParam("inputV", 0.953F));
    ((BaseFilter)localObject).setNextFilter(localBaseFilter, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
  
  public void setEffectIndex(int paramInt)
  {
    this.effectindex = paramInt;
  }
  
  public void setParameterDic(Map<String, Object> paramMap)
  {
    if (paramMap.containsKey("effectIndex")) {
      this.effectindex = ((Integer)paramMap.get("effectIndex")).intValue();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\filter\ttpic\Fen2Filter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */