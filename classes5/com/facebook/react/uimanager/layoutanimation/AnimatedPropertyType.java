package com.facebook.react.uimanager.layoutanimation;

 enum AnimatedPropertyType
{
  OPACITY("opacity"),  SCALE_XY("scaleXY");
  
  private final String mName;
  
  private AnimatedPropertyType(String paramString)
  {
    this.mName = paramString;
  }
  
  public static AnimatedPropertyType fromString(String paramString)
  {
    AnimatedPropertyType[] arrayOfAnimatedPropertyType = values();
    int j = arrayOfAnimatedPropertyType.length;
    int i = 0;
    while (i < j)
    {
      AnimatedPropertyType localAnimatedPropertyType = arrayOfAnimatedPropertyType[i];
      if (localAnimatedPropertyType.toString().equalsIgnoreCase(paramString)) {
        return localAnimatedPropertyType;
      }
      i += 1;
    }
    throw new IllegalArgumentException("Unsupported animated property : " + paramString);
  }
  
  public String toString()
  {
    return this.mName;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\uimanager\layoutanimation\AnimatedPropertyType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */