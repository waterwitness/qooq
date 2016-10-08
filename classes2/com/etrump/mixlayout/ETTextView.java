package com.etrump.mixlayout;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.text.Spannable;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.bubble.VipBubbleDrawable;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.AnimationTextView.OnDoubleClick;
import com.tencent.qphone.base.util.QLog;
import te;

public class ETTextView
  extends AnimationTextView
{
  static final String jdField_a_of_type_JavaLangString = "ETTextView";
  public int a;
  private long jdField_a_of_type_Long;
  private MotionEvent jdField_a_of_type_AndroidViewMotionEvent;
  public ETFont a;
  private ETLayout jdField_a_of_type_ComEtrumpMixlayoutETLayout;
  Runnable jdField_a_of_type_JavaLangRunnable;
  public int b;
  private MotionEvent b;
  private float c;
  public int c;
  private float d;
  public int d;
  private float jdField_e_of_type_Float;
  private int jdField_e_of_type_Int;
  private int f;
  private int g;
  private int h;
  
  public ETTextView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangRunnable = new te(this);
  }
  
  public ETTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangRunnable = new te(this);
  }
  
  public ETTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangRunnable = new te(this);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    BubbleInfo localBubbleInfo;
    Object localObject;
    Resources localResources;
    boolean bool;
    if (this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.a(paramInt1, paramInt2) != null)
    {
      localBubbleInfo = (BubbleInfo)getTag(2131296655);
      localObject = (ChatMessage)getTag(2131296656);
      localResources = getResources();
      bool = false;
      if (localObject != null) {
        bool = ((ChatMessage)localObject).isSend();
      }
      localObject = getBackground();
      if ((localObject == null) || (!(localObject instanceof VipBubbleDrawable))) {
        break label83;
      }
      ((VipBubbleDrawable)localObject).jdField_a_of_type_Boolean = true;
    }
    label83:
    while ((localObject == null) || (localBubbleInfo == null)) {
      return;
    }
    if (bool) {}
    for (paramInt1 = 2130843067;; paramInt1 = 2130842999)
    {
      localBubbleInfo.a(this, localResources.getDrawable(paramInt1));
      return;
    }
  }
  
  public ETLayout a()
  {
    return this.jdField_a_of_type_ComEtrumpMixlayoutETLayout;
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_ComEtrumpMixlayoutETFont != null) && (this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId != 0) && (this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontType == 1)) {
      return !ETEngine.getInstance().native_containComplexScript(getText().toString());
    }
    return false;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (!a())
    {
      super.onDraw(paramCanvas);
      return;
    }
    if (this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontColor != getTextColors().getDefaultColor()) {}
    try
    {
      this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontColor = getTextColors().getDefaultColor();
      this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.jdField_b_of_type_ComEtrumpMixlayoutETFont.mFontColor = getLinkTextColors().getDefaultColor();
      this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.c();
      this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.a(paramCanvas, getPaddingLeft(), getPaddingTop());
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ETTextView", 2, "onDraw err" + localThrowable.getMessage());
        }
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (!a())
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    int i1;
    int n;
    int j;
    int k;
    int i;
    for (;;)
    {
      try
      {
        i1 = View.MeasureSpec.getMode(paramInt1);
        n = View.MeasureSpec.getMode(paramInt2);
        j = View.MeasureSpec.getSize(paramInt1);
        k = View.MeasureSpec.getSize(paramInt2);
        if (this.jdField_a_of_type_ComEtrumpMixlayoutETLayout == null) {
          this.jdField_a_of_type_ComEtrumpMixlayoutETLayout = new ETLayout();
        }
        if ((this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.jdField_a_of_type_Long == this.jdField_a_of_type_Long) && ((this.jdField_a_of_type_ComEtrumpMixlayoutETFont == null) || (!this.jdField_a_of_type_ComEtrumpMixlayoutETFont.equals(this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.jdField_a_of_type_ComEtrumpMixlayoutETFont)))) {
          break label491;
        }
        int m = this.f - (getPaddingLeft() + getPaddingRight());
        i = m;
        if (i1 == Integer.MIN_VALUE) {
          i = Math.min(j, m);
        }
        m = getLinkTextColors().getDefaultColor();
        if (this.jdField_a_of_type_ComEtrumpMixlayoutETFont != null)
        {
          this.jdField_a_of_type_ComEtrumpMixlayoutETFont.setColor(getTextColors().getDefaultColor());
          this.jdField_a_of_type_ComEtrumpMixlayoutETFont.setSize(getTextSize());
          if (this.jdField_c_of_type_Float > 0.0F) {
            this.jdField_a_of_type_ComEtrumpMixlayoutETFont.setCrochet(true, this.h, (int)this.jdField_c_of_type_Float);
          }
        }
        else
        {
          this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
          this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.a(this.g);
          this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.a(i, getText(), this.jdField_a_of_type_ComEtrumpMixlayoutETFont, m);
          if ((this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.jdField_a_of_type_Int < 2048) && (this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.jdField_b_of_type_Int < 2048)) {
            break;
          }
          throw new Exception("large bitmap width=" + 0 + ", height=" + 0);
        }
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ETTextView", 2, "measure fail " + localThrowable.getMessage());
        }
        this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId = 0;
        this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.jdField_a_of_type_Long = -1L;
        super.onMeasure(paramInt1, paramInt2);
        return;
      }
      this.jdField_a_of_type_ComEtrumpMixlayoutETFont.setCrochet(false, this.h, 0);
    }
    if (this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.jdField_a_of_type_Boolean) {
      throw new Exception("no text use system measure2");
    }
    for (;;)
    {
      setMeasuredDimension(j, i);
      return;
      label410:
      j = this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.jdField_a_of_type_Int + getPaddingLeft() + getPaddingRight();
      label488:
      label491:
      while (n != 1073741824)
      {
        if (this.jdField_a_of_type_ComEtrumpMixlayoutETLayout != null)
        {
          i = this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.jdField_b_of_type_Int + getPaddingTop() + getPaddingBottom();
          if (n != Integer.MIN_VALUE) {
            break label488;
          }
          i = Math.min(i, k);
          break;
        }
        throw new Exception("measure height fail Layout is null");
        break;
        if (i1 != 1073741824) {
          break label410;
        }
      }
      i = k;
    }
  }
  
  public boolean onPreDraw()
  {
    if (!a()) {
      return super.onPreDraw();
    }
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!a()) {
      return super.onTouchEvent(paramMotionEvent);
    }
    int i;
    int j;
    int k;
    int m;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick != null)
    {
      int n;
      int i1;
      if ((this.jdField_b_of_type_AndroidViewMotionEvent != null) && (paramMotionEvent.getAction() == 0))
      {
        this.jdField_a_of_type_Float = paramMotionEvent.getX();
        this.jdField_b_of_type_Float = paramMotionEvent.getY();
        i = (int)paramMotionEvent.getX();
        j = (int)paramMotionEvent.getY();
        k = getPaddingLeft();
        m = getPaddingTop();
        n = getScrollX();
        i1 = getScrollY();
        this.jdField_a_of_type_Int = -1;
        this.jdField_b_of_type_Int = -1;
        a(i - k + n, j - m + i1);
        this.jdField_a_of_type_AndroidViewMotionEvent = MotionEvent.obtain(paramMotionEvent);
        if ((this.jdField_b_of_type_AndroidViewMotionEvent != null) && (this.jdField_a_of_type_AndroidViewMotionEvent != null) && (a(this.jdField_a_of_type_AndroidViewMotionEvent, this.jdField_b_of_type_AndroidViewMotionEvent, paramMotionEvent)))
        {
          this.jdField_a_of_type_Boolean = false;
          this.jdField_a_of_type_AndroidViewMotionEvent = null;
          this.jdField_b_of_type_AndroidViewMotionEvent = null;
          if (this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick != null)
          {
            this.jdField_b_of_type_Boolean = true;
            this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick.a(this);
            return true;
          }
        }
      }
      else
      {
        if ((this.jdField_b_of_type_AndroidViewMotionEvent != null) || (paramMotionEvent.getAction() != 0)) {
          break label314;
        }
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Float = paramMotionEvent.getX();
        this.jdField_b_of_type_Float = paramMotionEvent.getY();
        i = (int)paramMotionEvent.getX();
        j = (int)paramMotionEvent.getY();
        k = getPaddingLeft();
        m = getPaddingTop();
        n = getScrollX();
        i1 = getScrollY();
        this.jdField_a_of_type_Int = -1;
        this.jdField_b_of_type_Int = -1;
        a(i - k + n, j - m + i1);
        if (QLog.isColorLevel()) {
          QLog.d("ETTextView", 2, "reserve to initial status");
        }
      }
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      label314:
      if (paramMotionEvent.getAction() == 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ETTextView", 2, "action up");
        }
        k = (int)paramMotionEvent.getX();
        i = (int)paramMotionEvent.getY();
        m = getPaddingLeft();
        j = getPaddingTop();
        k = k - m + getScrollX();
        i = i - j + getScrollY();
        this.jdField_c_of_type_Int = k;
        this.jdField_d_of_type_Int = i;
        i = this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.a(k, i) + 1;
        ClickableSpan[] arrayOfClickableSpan = (ClickableSpan[])((Spannable)getText()).getSpans(i, i, ClickableSpan.class);
        if (arrayOfClickableSpan.length != 0)
        {
          arrayOfClickableSpan[0].onClick(this);
          return true;
        }
        this.jdField_b_of_type_AndroidViewMotionEvent = MotionEvent.obtain(paramMotionEvent);
        if (this.jdField_b_of_type_Boolean)
        {
          this.jdField_b_of_type_Boolean = false;
          this.jdField_b_of_type_AndroidViewMotionEvent = null;
        }
        postDelayed(this.jdField_a_of_type_JavaLangRunnable, 200L);
      }
    }
  }
  
  public void setFont(int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_ComEtrumpMixlayoutETFont == null) {
      this.jdField_a_of_type_ComEtrumpMixlayoutETFont = new ETFont(paramInt, "", getTextSize());
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId == 0) {
        setTypeface(null);
      }
      this.jdField_a_of_type_Long = paramLong;
      return;
      this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId = paramInt;
    }
  }
  
  public void setFont(ETFont paramETFont, long paramLong)
  {
    if (this.jdField_a_of_type_ComEtrumpMixlayoutETFont == null)
    {
      this.jdField_a_of_type_ComEtrumpMixlayoutETFont = paramETFont;
      this.jdField_a_of_type_ComEtrumpMixlayoutETFont.setSize(getTextSize());
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontType != 1) && (this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mTypeface != null)) {
        setTypeface(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mTypeface);
      }
      if (this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId == 0) {
        setTypeface(null);
      }
      this.jdField_a_of_type_Long = paramLong;
      return;
      this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId = paramETFont.mFontId;
      this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontType = paramETFont.mFontType;
      if (paramETFont.mFontType != 1) {
        this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mTypeface = paramETFont.mTypeface;
      }
    }
  }
  
  public void setMaxWidth(int paramInt)
  {
    this.f = paramInt;
    super.setMaxWidth(paramInt);
  }
  
  public void setShadowLayer(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
  {
    this.jdField_c_of_type_Float = paramFloat1;
    this.jdField_d_of_type_Float = paramFloat2;
    this.e = paramFloat3;
    this.h = paramInt;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\etrump\mixlayout\ETTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */