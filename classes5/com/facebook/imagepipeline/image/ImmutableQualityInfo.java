package com.facebook.imagepipeline.image;

public class ImmutableQualityInfo
  implements QualityInfo
{
  public static final QualityInfo FULL_QUALITY = of(Integer.MAX_VALUE, true, true);
  boolean mIsOfFullQuality;
  boolean mIsOfGoodEnoughQuality;
  int mQuality;
  
  private ImmutableQualityInfo(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mQuality = paramInt;
    this.mIsOfGoodEnoughQuality = paramBoolean1;
    this.mIsOfFullQuality = paramBoolean2;
  }
  
  public static QualityInfo of(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    return new ImmutableQualityInfo(paramInt, paramBoolean1, paramBoolean2);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof ImmutableQualityInfo)) {
        return false;
      }
      paramObject = (ImmutableQualityInfo)paramObject;
    } while ((this.mQuality == ((ImmutableQualityInfo)paramObject).mQuality) && (this.mIsOfGoodEnoughQuality == ((ImmutableQualityInfo)paramObject).mIsOfGoodEnoughQuality) && (this.mIsOfFullQuality == ((ImmutableQualityInfo)paramObject).mIsOfFullQuality));
    return false;
  }
  
  public int getQuality()
  {
    return this.mQuality;
  }
  
  public int hashCode()
  {
    int j = 0;
    int k = this.mQuality;
    if (this.mIsOfGoodEnoughQuality) {}
    for (int i = 4194304;; i = 0)
    {
      if (this.mIsOfFullQuality) {
        j = 8388608;
      }
      return i ^ k ^ j;
    }
  }
  
  public boolean isOfFullQuality()
  {
    return this.mIsOfFullQuality;
  }
  
  public boolean isOfGoodEnoughQuality()
  {
    return this.mIsOfGoodEnoughQuality;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\image\ImmutableQualityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */