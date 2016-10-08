package com.facebook.react.views.text;

import com.facebook.react.common.annotations.VisibleForTesting;

public class ReactVirtualTextViewManager
  extends ReactRawTextManager
{
  @VisibleForTesting
  public static final String REACT_CLASS = "RCTVirtualText";
  
  public static String getStaticName()
  {
    return "RCTVirtualText";
  }
  
  public String getName()
  {
    return getStaticName();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\views\text\ReactVirtualTextViewManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */