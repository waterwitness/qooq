package com.facebook.react.uimanager.layoutanimation;

 enum LayoutAnimationType
{
  CREATE("create"),  UPDATE("update");
  
  private final String mName;
  
  private LayoutAnimationType(String paramString)
  {
    this.mName = paramString;
  }
  
  public String toString()
  {
    return this.mName;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\uimanager\layoutanimation\LayoutAnimationType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */