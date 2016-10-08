package com.facebook.react.views.text;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.Spanned;
import android.widget.TextView;
import com.facebook.react.uimanager.ReactCompoundView;

public class ReactTextView
  extends TextView
  implements ReactCompoundView
{
  private boolean mContainsImages;
  
  public ReactTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    if ((this.mContainsImages) && ((getText() instanceof Spanned)))
    {
      Object localObject = (Spanned)getText();
      localObject = (TextInlineImageSpan[])((Spanned)localObject).getSpans(0, ((Spanned)localObject).length(), TextInlineImageSpan.class);
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        if (localObject[i].getDrawable() == paramDrawable) {
          invalidate();
        }
        i += 1;
      }
    }
    super.invalidateDrawable(paramDrawable);
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if ((this.mContainsImages) && ((getText() instanceof Spanned)))
    {
      Object localObject = (Spanned)getText();
      localObject = (TextInlineImageSpan[])((Spanned)localObject).getSpans(0, ((Spanned)localObject).length(), TextInlineImageSpan.class);
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        localObject[i].onAttachedToWindow();
        i += 1;
      }
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if ((this.mContainsImages) && ((getText() instanceof Spanned)))
    {
      Object localObject = (Spanned)getText();
      localObject = (TextInlineImageSpan[])((Spanned)localObject).getSpans(0, ((Spanned)localObject).length(), TextInlineImageSpan.class);
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        localObject[i].onDetachedFromWindow();
        i += 1;
      }
    }
  }
  
  public void onFinishTemporaryDetach()
  {
    super.onFinishTemporaryDetach();
    if ((this.mContainsImages) && ((getText() instanceof Spanned)))
    {
      Object localObject = (Spanned)getText();
      localObject = (TextInlineImageSpan[])((Spanned)localObject).getSpans(0, ((Spanned)localObject).length(), TextInlineImageSpan.class);
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        localObject[i].onFinishTemporaryDetach();
        i += 1;
      }
    }
  }
  
  public void onStartTemporaryDetach()
  {
    super.onStartTemporaryDetach();
    if ((this.mContainsImages) && ((getText() instanceof Spanned)))
    {
      Object localObject = (Spanned)getText();
      localObject = (TextInlineImageSpan[])((Spanned)localObject).getSpans(0, ((Spanned)localObject).length(), TextInlineImageSpan.class);
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        localObject[i].onStartTemporaryDetach();
        i += 1;
      }
    }
  }
  
  public int reactTagForTouch(float paramFloat1, float paramFloat2)
  {
    Spanned localSpanned = (Spanned)getText();
    int i = getId();
    int j = (int)paramFloat1;
    int k = (int)paramFloat2;
    Object localObject = getLayout();
    int m = i;
    if (localObject != null)
    {
      k = ((Layout)localObject).getLineForVertical(k);
      int n = (int)((Layout)localObject).getLineLeft(k);
      int i1 = (int)((Layout)localObject).getLineRight(k);
      m = i;
      if (j >= n)
      {
        m = i;
        if (j <= i1)
        {
          i1 = ((Layout)localObject).getOffsetForHorizontal(k, j);
          localObject = (ReactTagSpan[])localSpanned.getSpans(i1, i1, ReactTagSpan.class);
          m = i;
          if (localObject != null)
          {
            k = localSpanned.length();
            j = 0;
            for (;;)
            {
              m = i;
              if (j >= localObject.length) {
                break;
              }
              int i2 = localSpanned.getSpanStart(localObject[j]);
              int i3 = localSpanned.getSpanEnd(localObject[j]);
              n = i;
              m = k;
              if (i3 > i1)
              {
                n = i;
                m = k;
                if (i3 - i2 <= k)
                {
                  n = localObject[j].getReactTag();
                  m = i3 - i2;
                }
              }
              j += 1;
              i = n;
              k = m;
            }
          }
        }
      }
    }
    return m;
  }
  
  public void setText(ReactTextUpdate paramReactTextUpdate)
  {
    this.mContainsImages = paramReactTextUpdate.containsImages();
    setText(paramReactTextUpdate.getText());
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    if ((this.mContainsImages) && ((getText() instanceof Spanned)))
    {
      Object localObject = (Spanned)getText();
      localObject = (TextInlineImageSpan[])((Spanned)localObject).getSpans(0, ((Spanned)localObject).length(), TextInlineImageSpan.class);
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        if (localObject[i].getDrawable() == paramDrawable) {
          return true;
        }
        i += 1;
      }
    }
    return super.verifyDrawable(paramDrawable);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\views\text\ReactTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */