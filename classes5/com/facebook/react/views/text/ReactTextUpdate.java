package com.facebook.react.views.text;

import android.text.Spannable;

public class ReactTextUpdate
{
  private final boolean mContainsImages;
  private final int mJsEventCounter;
  private final Spannable mText;
  
  public ReactTextUpdate(Spannable paramSpannable, int paramInt, boolean paramBoolean)
  {
    this.mText = paramSpannable;
    this.mJsEventCounter = paramInt;
    this.mContainsImages = paramBoolean;
  }
  
  public boolean containsImages()
  {
    return this.mContainsImages;
  }
  
  public int getJsEventCounter()
  {
    return this.mJsEventCounter;
  }
  
  public Spannable getText()
  {
    return this.mText;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\views\text\ReactTextUpdate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */