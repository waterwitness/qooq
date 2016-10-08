package com.tencent.filter;

public class AlphaAdjustFilter
  extends BaseFilter
{
  public AlphaAdjustFilter(int paramInt)
  {
    super(paramInt);
  }
  
  public void setAdjustParam(float paramFloat)
  {
    addParam(new Param.FloatParam("filterAdjustParam", paramFloat));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\filter\AlphaAdjustFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */