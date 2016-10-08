package com.tencent.mobileqq.nearby.flat.canvas;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.BoringLayout;
import android.text.BoringLayout.Metrics;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.Spannable;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.FloatMath;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.dating.widget.DatingCommentTextView.TouchableSpan;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class TextElement
  extends AbstractUIElement
{
  static final BoringLayout.Metrics jdField_b_of_type_AndroidTextBoringLayout$Metrics = new BoringLayout.Metrics();
  static final String jdField_b_of_type_JavaLangString = "TextElement";
  static final String jdField_c_of_type_JavaLangString = "TextElement";
  float jdField_a_of_type_Float = 1.0F;
  ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  BoringLayout.Metrics jdField_a_of_type_AndroidTextBoringLayout$Metrics;
  BoringLayout jdField_a_of_type_AndroidTextBoringLayout;
  Layout.Alignment jdField_a_of_type_AndroidTextLayout$Alignment = Layout.Alignment.ALIGN_NORMAL;
  Layout jdField_a_of_type_AndroidTextLayout;
  final TextPaint jdField_a_of_type_AndroidTextTextPaint;
  TextUtils.TruncateAt jdField_a_of_type_AndroidTextTextUtils$TruncateAt;
  DatingCommentTextView.TouchableSpan jdField_a_of_type_ComTencentMobileqqDatingWidgetDatingCommentTextView$TouchableSpan;
  CharSequence jdField_a_of_type_JavaLangCharSequence;
  float jdField_b_of_type_Float = 0.0F;
  boolean jdField_b_of_type_Boolean = true;
  boolean jdField_c_of_type_Boolean;
  int e;
  int f = Integer.MAX_VALUE;
  int g = Integer.MAX_VALUE;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public TextElement(UIElementHost paramUIElementHost)
  {
    this(paramUIElementHost, null);
  }
  
  public TextElement(UIElementHost paramUIElementHost, AttributeSet paramAttributeSet)
  {
    super(paramUIElementHost, paramAttributeSet);
    if (!a()) {
      throw new IllegalStateException("Construct TextElement error,mHost is null!");
    }
    this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint(1);
    this.jdField_a_of_type_AndroidTextTextPaint.density = a().getDisplayMetrics().density;
    a(ColorStateList.valueOf(-16777216));
    paramUIElementHost = a().obtainStyledAttributes(paramAttributeSet, R.styleable.au, 0, 0);
    int j = paramUIElementHost.getIndexCount();
    if (i < j)
    {
      int k = paramUIElementHost.getIndex(i);
      switch (k)
      {
      }
      for (;;)
      {
        i += 1;
        break;
        k = paramUIElementHost.getDimensionPixelSize(k, -1);
        if (k >= 0)
        {
          a(k);
          continue;
          paramAttributeSet = paramUIElementHost.getColorStateList(k);
          if (paramAttributeSet != null)
          {
            a(paramAttributeSet);
            continue;
            k = paramUIElementHost.getInt(k, -1);
            if (k > 0)
            {
              c(k);
              continue;
              switch (paramUIElementHost.getInt(k, -1))
              {
              default: 
                break;
              case 1: 
                a(TextUtils.TruncateAt.START);
                break;
              case 2: 
                a(TextUtils.TruncateAt.MIDDLE);
                break;
              case 3: 
                a(TextUtils.TruncateAt.END);
                break;
              case 4: 
                Log.w("TextElement", "Marquee ellipsize is not supported");
              }
            }
          }
        }
      }
    }
    paramUIElementHost.recycle();
  }
  
  public Layout a()
  {
    return this.jdField_a_of_type_AndroidTextLayout;
  }
  
  Layout a(int paramInt1, BoringLayout.Metrics paramMetrics, int paramInt2, Layout.Alignment paramAlignment, boolean paramBoolean1, TextUtils.TruncateAt paramTruncateAt, boolean paramBoolean2)
  {
    if (paramMetrics == jdField_b_of_type_AndroidTextBoringLayout$Metrics)
    {
      BoringLayout.Metrics localMetrics = BoringLayout.isBoring(this.jdField_a_of_type_JavaLangCharSequence, this.jdField_a_of_type_AndroidTextTextPaint, this.jdField_a_of_type_AndroidTextBoringLayout$Metrics);
      paramMetrics = localMetrics;
      if (localMetrics != null)
      {
        this.jdField_a_of_type_AndroidTextBoringLayout$Metrics = localMetrics;
        paramMetrics = localMetrics;
      }
    }
    for (;;)
    {
      if (paramMetrics != null)
      {
        if ((paramMetrics.width <= paramInt1) && ((paramTruncateAt == null) || (paramMetrics.width <= paramInt2)))
        {
          if (this.jdField_a_of_type_AndroidTextBoringLayout != null) {}
          for (paramMetrics = this.jdField_a_of_type_AndroidTextBoringLayout.replaceOrMake(this.jdField_a_of_type_JavaLangCharSequence, this.jdField_a_of_type_AndroidTextTextPaint, paramInt1, paramAlignment, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, paramMetrics, this.jdField_b_of_type_Boolean); paramBoolean2; paramMetrics = BoringLayout.make(this.jdField_a_of_type_JavaLangCharSequence, this.jdField_a_of_type_AndroidTextTextPaint, paramInt1, paramAlignment, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, paramMetrics, this.jdField_b_of_type_Boolean))
          {
            this.jdField_a_of_type_AndroidTextBoringLayout = ((BoringLayout)paramMetrics);
            return paramMetrics;
          }
        }
        if ((paramBoolean1) && (paramMetrics.width <= paramInt1))
        {
          if ((paramBoolean2) && (this.jdField_a_of_type_AndroidTextBoringLayout != null)) {
            return this.jdField_a_of_type_AndroidTextBoringLayout.replaceOrMake(this.jdField_a_of_type_JavaLangCharSequence, this.jdField_a_of_type_AndroidTextTextPaint, paramInt1, paramAlignment, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, paramMetrics, this.jdField_b_of_type_Boolean, paramTruncateAt, paramInt2);
          }
          return BoringLayout.make(this.jdField_a_of_type_JavaLangCharSequence, this.jdField_a_of_type_AndroidTextTextPaint, paramInt1, paramAlignment, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, paramMetrics, this.jdField_b_of_type_Boolean, paramTruncateAt, paramInt2);
        }
        if (paramBoolean1)
        {
          if (StaticLayoutWithMaxLines.a()) {
            return StaticLayoutWithMaxLines.a(this.jdField_a_of_type_JavaLangCharSequence, 0, this.jdField_a_of_type_JavaLangCharSequence.length(), this.jdField_a_of_type_AndroidTextTextPaint, paramInt1, paramAlignment, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.jdField_b_of_type_Boolean, paramTruncateAt, paramInt2, this.f);
          }
          if (QLog.isColorLevel()) {
            QLog.d("TextElement", 2, "makeSingleLayout not support  StaticLayoutWithMaxLines 1");
          }
          return new StaticLayout(this.jdField_a_of_type_JavaLangCharSequence, 0, this.jdField_a_of_type_JavaLangCharSequence.length(), this.jdField_a_of_type_AndroidTextTextPaint, paramInt1, paramAlignment, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.jdField_b_of_type_Boolean, this.jdField_a_of_type_AndroidTextTextUtils$TruncateAt, paramInt2);
        }
        return new StaticLayout(this.jdField_a_of_type_JavaLangCharSequence, this.jdField_a_of_type_AndroidTextTextPaint, paramInt1, paramAlignment, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.jdField_b_of_type_Boolean);
      }
      if (paramBoolean1)
      {
        if (StaticLayoutWithMaxLines.a()) {
          return StaticLayoutWithMaxLines.a(this.jdField_a_of_type_JavaLangCharSequence, 0, this.jdField_a_of_type_JavaLangCharSequence.length(), this.jdField_a_of_type_AndroidTextTextPaint, paramInt1, paramAlignment, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.jdField_b_of_type_Boolean, paramTruncateAt, paramInt2, this.f);
        }
        if (QLog.isColorLevel()) {
          QLog.d("TextElement", 2, "makeSingleLayout not support  StaticLayoutWithMaxLines 2");
        }
        return new StaticLayout(this.jdField_a_of_type_JavaLangCharSequence, 0, this.jdField_a_of_type_JavaLangCharSequence.length(), this.jdField_a_of_type_AndroidTextTextPaint, paramInt1, paramAlignment, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.jdField_b_of_type_Boolean, this.jdField_a_of_type_AndroidTextTextUtils$TruncateAt, paramInt2);
      }
      return new StaticLayout(this.jdField_a_of_type_JavaLangCharSequence, this.jdField_a_of_type_AndroidTextTextPaint, paramInt1, paramAlignment, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.jdField_b_of_type_Boolean);
      return paramMetrics;
    }
  }
  
  public CharSequence a()
  {
    return this.jdField_a_of_type_JavaLangCharSequence;
  }
  
  public void a(float paramFloat)
  {
    if (this.jdField_a_of_type_AndroidTextTextPaint.getTextSize() == paramFloat) {
      return;
    }
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(paramFloat);
    i();
  }
  
  public void a(int paramInt, float paramFloat)
  {
    Resources localResources = a();
    if (localResources == null) {}
    do
    {
      return;
      paramFloat = TypedValue.applyDimension(paramInt, paramFloat, localResources.getDisplayMetrics());
    } while (this.jdField_a_of_type_AndroidTextTextPaint.getTextSize() == paramFloat);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(paramFloat);
    i();
  }
  
  void a(int paramInt1, BoringLayout.Metrics paramMetrics, int paramInt2, boolean paramBoolean)
  {
    if (paramInt1 < 0) {
      paramInt1 = 0;
    }
    for (;;)
    {
      this.g = this.f;
      if (this.jdField_a_of_type_AndroidTextTextUtils$TruncateAt != null) {}
      for (boolean bool = true;; bool = false)
      {
        if (this.jdField_a_of_type_JavaLangCharSequence != null) {
          this.jdField_a_of_type_AndroidTextLayout = a(paramInt1, paramMetrics, paramInt2, this.jdField_a_of_type_AndroidTextLayout$Alignment, bool, this.jdField_a_of_type_AndroidTextTextUtils$TruncateAt, paramBoolean);
        }
        return;
      }
    }
  }
  
  public void a(ColorStateList paramColorStateList)
  {
    if (paramColorStateList == null) {
      throw new NullPointerException();
    }
    this.jdField_a_of_type_AndroidContentResColorStateList = paramColorStateList;
    j();
  }
  
  public void a(Layout.Alignment paramAlignment)
  {
    if (this.jdField_a_of_type_AndroidTextLayout$Alignment == paramAlignment) {
      return;
    }
    this.jdField_a_of_type_AndroidTextLayout$Alignment = paramAlignment;
    i();
  }
  
  public void a(StaticLayout paramStaticLayout)
  {
    if (paramStaticLayout != null)
    {
      this.c = true;
      this.jdField_a_of_type_AndroidTextLayout = paramStaticLayout;
      a();
      return;
    }
    this.c = false;
  }
  
  public void a(TextUtils.TruncateAt paramTruncateAt)
  {
    if (this.jdField_a_of_type_AndroidTextTextUtils$TruncateAt == paramTruncateAt) {
      return;
    }
    this.jdField_a_of_type_AndroidTextTextUtils$TruncateAt = paramTruncateAt;
    i();
  }
  
  public void a(CharSequence paramCharSequence)
  {
    if (TextUtils.equals(this.jdField_a_of_type_JavaLangCharSequence, paramCharSequence)) {
      return;
    }
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
    h();
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDatingWidgetDatingCommentTextView$TouchableSpan != null) {
      this.jdField_a_of_type_ComTencentMobileqqDatingWidgetDatingCommentTextView$TouchableSpan.a(paramBoolean);
    }
    super.a(paramBoolean);
  }
  
  public void b(float paramFloat)
  {
    a(2, paramFloat);
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidContentResColorStateList = ColorStateList.valueOf(paramInt);
    j();
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.b(paramInt1, paramInt2, paramInt3, paramInt4);
    i();
  }
  
  protected void b(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_AndroidTextLayout == null) {
      return;
    }
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      paramCanvas.save();
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, k() - i(), l() - j());
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      paramCanvas.restore();
    }
    int i = paramCanvas.getSaveCount();
    paramCanvas.save();
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(this.e);
    paramCanvas.clipRect(d(), e(), k() - f(), l() - g());
    paramCanvas.translate(d(), e());
    this.jdField_a_of_type_AndroidTextLayout.draw(paramCanvas);
    paramCanvas.restoreToCount(i);
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasUIElementHost instanceof UIElementView)) {}
    for (AbstractUIElement.OnClickListener localOnClickListener = ((UIElementView)this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasUIElementHost).a;; localOnClickListener = null)
    {
      if (localOnClickListener == null) {
        return false;
      }
      int i = paramMotionEvent.getAction();
      int j = (int)paramMotionEvent.getX();
      int k = (int)paramMotionEvent.getY();
      Layout localLayout = a();
      if (this.c)
      {
        paramMotionEvent = localLayout.getText();
        if (!(paramMotionEvent instanceof Spannable)) {
          break label262;
        }
        paramMotionEvent = (Spannable)paramMotionEvent;
        j = localLayout.getOffsetForHorizontal(localLayout.getLineForVertical(k - j()), j);
        paramMotionEvent = (ClickableSpan[])paramMotionEvent.getSpans(j, j, ClickableSpan.class);
        if ((paramMotionEvent == null) || (paramMotionEvent.length == 0)) {
          break label226;
        }
        if ((i != 1) && (i != 3)) {
          break label185;
        }
        if (i == 1) {
          localOnClickListener.a(this);
        }
        if ((paramMotionEvent[0] instanceof DatingCommentTextView.TouchableSpan)) {
          ((DatingCommentTextView.TouchableSpan)paramMotionEvent[0]).a(false);
        }
        this.jdField_a_of_type_ComTencentMobileqqDatingWidgetDatingCommentTextView$TouchableSpan = null;
        e();
      }
      for (;;)
      {
        return true;
        paramMotionEvent = this.jdField_a_of_type_JavaLangCharSequence;
        break;
        label185:
        if (i == 0)
        {
          if ((paramMotionEvent[0] instanceof DatingCommentTextView.TouchableSpan))
          {
            ((DatingCommentTextView.TouchableSpan)paramMotionEvent[0]).a(true);
            this.jdField_a_of_type_ComTencentMobileqqDatingWidgetDatingCommentTextView$TouchableSpan = ((DatingCommentTextView.TouchableSpan)paramMotionEvent[0]);
          }
          e();
        }
      }
      label226:
      if (((i == 1) || (i == 3)) && (this.jdField_a_of_type_ComTencentMobileqqDatingWidgetDatingCommentTextView$TouchableSpan != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqDatingWidgetDatingCommentTextView$TouchableSpan.a(false);
        this.jdField_a_of_type_ComTencentMobileqqDatingWidgetDatingCommentTextView$TouchableSpan = null;
        e();
      }
      label262:
      return false;
    }
  }
  
  public void c(int paramInt)
  {
    if (this.f == paramInt) {
      return;
    }
    this.f = paramInt;
    a();
    e();
  }
  
  protected void c(int paramInt1, int paramInt2)
  {
    if (this.c) {
      b(this.jdField_a_of_type_AndroidTextLayout.getWidth(), this.jdField_a_of_type_AndroidTextLayout.getHeight());
    }
    do
    {
      return;
      if (this.jdField_a_of_type_JavaLangCharSequence != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TextElement", 2, "mText is null,onMeasure return");
    return;
    int i3 = View.MeasureSpec.getMode(paramInt1);
    int n = View.MeasureSpec.getMode(paramInt2);
    int m = View.MeasureSpec.getSize(paramInt1);
    int k = View.MeasureSpec.getSize(paramInt2);
    int i1 = d();
    int i2 = f();
    Object localObject = jdField_b_of_type_AndroidTextBoringLayout$Metrics;
    paramInt1 = -1;
    int i = 0;
    if (i3 == 1073741824)
    {
      i = -1;
      paramInt2 = 0;
      paramInt1 = m;
    }
    for (;;)
    {
      m = paramInt1 - i1 - i2;
      if (this.jdField_a_of_type_AndroidTextLayout == null) {
        if (this.jdField_a_of_type_JavaLangCharSequence != null)
        {
          a(m, (BoringLayout.Metrics)localObject, m, false);
          label143:
          if (n != 1073741824) {
            break label519;
          }
          paramInt2 = k;
        }
      }
      label228:
      int j;
      for (;;)
      {
        b(paramInt1, paramInt2);
        return;
        paramInt2 = paramInt1;
        if (this.jdField_a_of_type_AndroidTextLayout != null)
        {
          paramInt2 = paramInt1;
          if (this.jdField_a_of_type_AndroidTextTextUtils$TruncateAt == null) {
            paramInt2 = o();
          }
        }
        if (paramInt2 < 0)
        {
          BoringLayout.Metrics localMetrics = BoringLayout.isBoring(this.jdField_a_of_type_JavaLangCharSequence, this.jdField_a_of_type_AndroidTextTextPaint, this.jdField_a_of_type_AndroidTextBoringLayout$Metrics);
          paramInt1 = i;
          localObject = localMetrics;
          if (localMetrics != null)
          {
            this.jdField_a_of_type_AndroidTextBoringLayout$Metrics = localMetrics;
            localObject = localMetrics;
            paramInt1 = i;
          }
          if ((localObject != null) && (localObject != jdField_b_of_type_AndroidTextBoringLayout$Metrics)) {
            break label313;
          }
          i = paramInt2;
          if (paramInt2 < 0) {
            i = (int)FloatMath.ceil(Layout.getDesiredWidth(this.jdField_a_of_type_JavaLangCharSequence, this.jdField_a_of_type_AndroidTextTextPaint));
          }
          j = i;
          paramInt2 = i;
        }
        for (;;)
        {
          j += i1 + i2;
          if (i3 != Integer.MIN_VALUE) {
            break label547;
          }
          j = Math.min(m, j);
          i = paramInt2;
          paramInt2 = paramInt1;
          paramInt1 = j;
          break;
          paramInt1 = 1;
          break label228;
          label313:
          j = ((BoringLayout.Metrics)localObject).width;
        }
        if (!QLog.isColorLevel()) {
          break label143;
        }
        QLog.d("TextElement", 2, "onMeasure mText is NULL !");
        break label143;
        if ((this.jdField_a_of_type_AndroidTextLayout.getWidth() != m) || (this.jdField_a_of_type_AndroidTextLayout.getEllipsizedWidth() != m))
        {
          j = 1;
          label367:
          if ((this.jdField_a_of_type_AndroidTextTextUtils$TruncateAt != null) || (m <= this.jdField_a_of_type_AndroidTextLayout.getWidth()) || ((!(this.jdField_a_of_type_AndroidTextLayout instanceof BoringLayout)) && ((paramInt2 == 0) || (i < 0) || (i > m)))) {
            break label465;
          }
          paramInt2 = 1;
          label414:
          if (this.f == this.g) {
            break label470;
          }
          i = 1;
        }
        for (;;)
        {
          if ((j != 0) || (i != 0))
          {
            if ((i == 0) && (paramInt2 != 0))
            {
              this.jdField_a_of_type_AndroidTextLayout.increaseWidthTo(m);
              break;
              j = 0;
              break label367;
              label465:
              paramInt2 = 0;
              break label414;
              label470:
              i = 0;
              continue;
            }
            a(m, (BoringLayout.Metrics)localObject, m, false);
            break;
          }
        }
        if (this.jdField_a_of_type_AndroidTextLayout.getText().equals(this.jdField_a_of_type_JavaLangCharSequence)) {
          break label143;
        }
        a(m, (BoringLayout.Metrics)localObject, m, false);
        break label143;
        label519:
        i = p();
        paramInt2 = i;
        if (n == Integer.MIN_VALUE) {
          paramInt2 = Math.min(k, i);
        }
      }
      label547:
      i = paramInt2;
      paramInt2 = paramInt1;
      paramInt1 = j;
    }
  }
  
  protected void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void f()
  {
    if ((this.jdField_a_of_type_AndroidContentResColorStateList != null) && (this.jdField_a_of_type_AndroidContentResColorStateList.isStateful())) {
      j();
    }
  }
  
  void g()
  {
    if (((this.jdField_a_of_type_AndroidTextLayout instanceof BoringLayout)) && (this.jdField_a_of_type_AndroidTextBoringLayout == null)) {
      this.jdField_a_of_type_AndroidTextBoringLayout = ((BoringLayout)this.jdField_a_of_type_AndroidTextLayout);
    }
    this.jdField_a_of_type_AndroidTextBoringLayout$Metrics = null;
  }
  
  void h()
  {
    if (this.jdField_a_of_type_AndroidTextLayout == null) {
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = a();
    if (localLayoutParams.width != -2)
    {
      int i = this.jdField_a_of_type_AndroidTextLayout.getHeight();
      int j = this.jdField_a_of_type_AndroidTextLayout.getWidth();
      a(j, jdField_b_of_type_AndroidTextBoringLayout$Metrics, j, false);
      if ((localLayoutParams.height != -2) && (localLayoutParams.height != -1))
      {
        e();
        return;
      }
      if (this.jdField_a_of_type_AndroidTextLayout.getHeight() == i)
      {
        e();
        return;
      }
      a();
      e();
      return;
    }
    i();
  }
  
  void i()
  {
    if (this.jdField_a_of_type_AndroidTextLayout == null) {
      return;
    }
    g();
    a();
    e();
  }
  
  void j()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasUIElementHost != null) && (this.jdField_a_of_type_AndroidContentResColorStateList != null))
    {
      int i = this.jdField_a_of_type_AndroidContentResColorStateList.getColorForState(this.jdField_a_of_type_ComTencentMobileqqNearbyFlatCanvasUIElementHost.getDrawableState(), 0);
      if (i != this.e)
      {
        this.e = i;
        e();
      }
    }
  }
  
  int o()
  {
    int j = 0;
    int k = this.jdField_a_of_type_AndroidTextLayout.getLineCount();
    CharSequence localCharSequence = this.jdField_a_of_type_AndroidTextLayout.getText();
    int i = 0;
    while (i < k - 1)
    {
      if (localCharSequence.charAt(this.jdField_a_of_type_AndroidTextLayout.getLineEnd(i) - 1) != '\n') {
        return -1;
      }
      i += 1;
    }
    float f1 = 0.0F;
    i = j;
    while (i < k)
    {
      f1 = Math.max(f1, this.jdField_a_of_type_AndroidTextLayout.getLineWidth(i));
      i += 1;
    }
    return (int)FloatMath.ceil(f1);
  }
  
  int p()
  {
    if (this.jdField_a_of_type_AndroidTextLayout == null) {
      return 0;
    }
    int i = e();
    int j = g();
    int k = Math.min(this.f, this.jdField_a_of_type_AndroidTextLayout.getLineCount());
    return i + j + this.jdField_a_of_type_AndroidTextLayout.getLineTop(k);
  }
  
  public int q()
  {
    return this.f;
  }
  
  public int r()
  {
    return (int)this.jdField_a_of_type_AndroidTextTextPaint.measureText(String.valueOf(this.jdField_a_of_type_AndroidTextLayout.getText()));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\flat\canvas\TextElement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */