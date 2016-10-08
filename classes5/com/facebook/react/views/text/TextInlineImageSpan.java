package com.facebook.react.views.text;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.Spannable;
import android.text.style.ReplacementSpan;
import android.widget.TextView;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import javax.annotation.Nullable;

public class TextInlineImageSpan
  extends ReplacementSpan
{
  @Nullable
  private final Object mCallerContext;
  @Nullable
  private Drawable mDrawable;
  private final AbstractDraweeControllerBuilder mDraweeControllerBuilder;
  private final DraweeHolder<GenericDraweeHierarchy> mDraweeHolder;
  private int mHeight;
  @Nullable
  private TextView mTextView;
  private Uri mUri;
  private int mWidth;
  
  public TextInlineImageSpan(Resources paramResources, int paramInt1, int paramInt2, @Nullable Uri paramUri, AbstractDraweeControllerBuilder paramAbstractDraweeControllerBuilder, @Nullable Object paramObject)
  {
    this.mDraweeHolder = new DraweeHolder(GenericDraweeHierarchyBuilder.newInstance(paramResources).build());
    this.mDraweeControllerBuilder = paramAbstractDraweeControllerBuilder;
    this.mCallerContext = paramObject;
    this.mHeight = paramInt1;
    this.mWidth = paramInt2;
    if (paramUri != null) {}
    for (;;)
    {
      this.mUri = paramUri;
      return;
      paramUri = Uri.EMPTY;
    }
  }
  
  public static void possiblyUpdateInlineImageSpans(Spannable paramSpannable, TextView paramTextView)
  {
    paramSpannable = (TextInlineImageSpan[])paramSpannable.getSpans(0, paramSpannable.length(), TextInlineImageSpan.class);
    int j = paramSpannable.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramSpannable[i];
      ((TextInlineImageSpan)localObject).onAttachedToWindow();
      ((TextInlineImageSpan)localObject).mTextView = paramTextView;
      i += 1;
    }
  }
  
  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    if (this.mDrawable == null)
    {
      paramCharSequence = ImageRequestBuilder.newBuilderWithSource(this.mUri).build();
      paramCharSequence = this.mDraweeControllerBuilder.reset().setOldController(this.mDraweeHolder.getController()).setCallerContext(this.mCallerContext).setImageRequest(paramCharSequence).build();
      this.mDraweeHolder.setController(paramCharSequence);
      this.mDrawable = this.mDraweeHolder.getTopLevelDrawable();
      this.mDrawable.setBounds(0, 0, this.mWidth, this.mHeight);
      this.mDrawable.setCallback(this.mTextView);
    }
    paramCanvas.save();
    paramCanvas.translate(paramFloat, paramInt5 - this.mDrawable.getBounds().bottom);
    this.mDrawable.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  @Nullable
  public Drawable getDrawable()
  {
    return this.mDrawable;
  }
  
  public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    if (paramFontMetricsInt != null)
    {
      paramFontMetricsInt.ascent = (-this.mHeight);
      paramFontMetricsInt.descent = 0;
      paramFontMetricsInt.top = paramFontMetricsInt.ascent;
      paramFontMetricsInt.bottom = 0;
    }
    return this.mWidth;
  }
  
  public void onAttachedToWindow()
  {
    this.mDraweeHolder.onAttach();
  }
  
  public void onDetachedFromWindow()
  {
    this.mDraweeHolder.onDetach();
  }
  
  public void onFinishTemporaryDetach()
  {
    this.mDraweeHolder.onAttach();
  }
  
  public void onStartTemporaryDetach()
  {
    this.mDraweeHolder.onDetach();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\views\text\TextInlineImageSpan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */