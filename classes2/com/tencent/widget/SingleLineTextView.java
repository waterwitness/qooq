package com.tencent.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.BoringLayout;
import android.text.BoringLayout.Metrics;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.method.SingleLineTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.qphone.base.util.QLog;
import xuw;
import xux;

public class SingleLineTextView
  extends View
  implements Handler.Callback
{
  public static final int a = 0;
  private static final BoringLayout.Metrics jdField_a_of_type_AndroidTextBoringLayout$Metrics = new BoringLayout.Metrics();
  public static final int b = 1;
  public static final int c = 2;
  private static final int d = 16384;
  private static final int e = 1;
  private static final int f = 168;
  private float jdField_a_of_type_Float = 1.0F;
  private ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private BoringLayout jdField_a_of_type_AndroidTextBoringLayout;
  protected Layout a;
  private final TextPaint jdField_a_of_type_AndroidTextTextPaint;
  private TextUtils.TruncateAt jdField_a_of_type_AndroidTextTextUtils$TruncateAt;
  private TransformationMethod jdField_a_of_type_AndroidTextMethodTransformationMethod;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private xuw jdField_a_of_type_Xuw;
  private boolean jdField_a_of_type_Boolean;
  private final xux[] jdField_a_of_type_ArrayOfXux;
  private float jdField_b_of_type_Float = 0.0F;
  private BoringLayout.Metrics jdField_b_of_type_AndroidTextBoringLayout$Metrics;
  private CharSequence jdField_b_of_type_JavaLangCharSequence;
  private boolean jdField_b_of_type_Boolean = true;
  private int g;
  private int h;
  private int i;
  private int j = Integer.MAX_VALUE;
  private int k = 16;
  private int l;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public SingleLineTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SingleLineTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SingleLineTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Object localObject = getResources();
    this.jdField_a_of_type_JavaLangCharSequence = "";
    this.jdField_b_of_type_JavaLangCharSequence = "";
    this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint(1);
    this.jdField_a_of_type_AndroidTextTextPaint.density = ((Resources)localObject).getDisplayMetrics().density;
    this.jdField_a_of_type_AndroidTextMethodTransformationMethod = SingleLineTransformationMethod.getInstance();
    this.jdField_a_of_type_AndroidTextTextUtils$TruncateAt = TextUtils.TruncateAt.END;
    this.jdField_a_of_type_Boolean = true;
    this.l = -1;
    this.jdField_a_of_type_ArrayOfXux = new xux[3];
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.h = 0;
    this.i = 0;
    this.jdField_a_of_type_AndroidContentResColorStateList = ColorStateList.valueOf(-16777216);
    this.g = this.jdField_a_of_type_AndroidContentResColorStateList.getDefaultColor();
    if (paramAttributeSet != null)
    {
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ao);
      paramInt = paramAttributeSet.getDimensionPixelSize(0, (int)DisplayUtils.a(paramContext, 12.0F));
      paramContext = paramAttributeSet.getColorStateList(1);
      localObject = paramAttributeSet.getString(3);
      this.j = paramAttributeSet.getDimensionPixelSize(2, Integer.MAX_VALUE);
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(paramInt);
      setTextColor(paramContext);
      setText((CharSequence)localObject);
      this.jdField_b_of_type_Boolean = paramAttributeSet.getBoolean(4, true);
      paramAttributeSet.recycle();
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    if (localLayoutParams.width != -2)
    {
      int m = getWidth() - b() - c();
      if (m > 0)
      {
        int n = this.jdField_a_of_type_AndroidTextLayout.getHeight();
        a(this.jdField_a_of_type_AndroidTextLayout.getWidth(), jdField_a_of_type_AndroidTextBoringLayout$Metrics, m);
        if ((localLayoutParams.height != -2) && (localLayoutParams.height != -1))
        {
          invalidate();
          return;
        }
        if (this.jdField_a_of_type_AndroidTextLayout.getHeight() == n)
        {
          invalidate();
          return;
        }
        requestLayout();
        invalidate();
        return;
      }
    }
    c();
    requestLayout();
    invalidate();
  }
  
  private void c()
  {
    if (((this.jdField_a_of_type_AndroidTextLayout instanceof BoringLayout)) && (this.jdField_a_of_type_AndroidTextBoringLayout == null)) {
      this.jdField_a_of_type_AndroidTextBoringLayout = ((BoringLayout)this.jdField_a_of_type_AndroidTextLayout);
    }
    this.jdField_a_of_type_AndroidTextLayout = null;
  }
  
  private void d()
  {
    int[] arrayOfInt = getDrawableState();
    int m = this.jdField_a_of_type_AndroidContentResColorStateList.getColorForState(arrayOfInt, 0);
    if (m != this.g)
    {
      this.g = m;
      invalidate();
    }
  }
  
  private int i()
  {
    int n = 0;
    int i1 = this.k & 0x70;
    Layout localLayout = this.jdField_a_of_type_AndroidTextLayout;
    int m = n;
    int i2;
    int i3;
    if (i1 != 48)
    {
      i2 = getMeasuredHeight() - f() - g();
      i3 = localLayout.getHeight();
      m = n;
      if (i3 < i2)
      {
        if (i1 != 80) {
          break label71;
        }
        m = i2 - i3;
      }
    }
    return m;
    label71:
    return i2 - i3 >> 1;
  }
  
  private int j()
  {
    if (this.l < 0) {
      this.l = ((int)Math.ceil(Layout.getDesiredWidth(this.jdField_b_of_type_JavaLangCharSequence, this.jdField_a_of_type_AndroidTextTextPaint)));
    }
    return this.l;
  }
  
  public float a()
  {
    return this.jdField_a_of_type_AndroidTextTextPaint.getTextSize();
  }
  
  public int a()
  {
    xuw localxuw = this.jdField_a_of_type_Xuw;
    if (localxuw != null) {
      return localxuw.e;
    }
    return 0;
  }
  
  public final Paint a()
  {
    return this.jdField_a_of_type_AndroidTextTextPaint;
  }
  
  public final CharSequence a()
  {
    return this.jdField_a_of_type_JavaLangCharSequence;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
  }
  
  protected void a(int paramInt1, BoringLayout.Metrics paramMetrics, int paramInt2)
  {
    if (paramInt1 < 0) {
      paramInt1 = 0;
    }
    for (;;)
    {
      Layout.Alignment localAlignment;
      switch (this.k & 0x7)
      {
      default: 
        localAlignment = Layout.Alignment.ALIGN_NORMAL;
      }
      while ((this.jdField_a_of_type_JavaLangCharSequence instanceof Spannable))
      {
        this.jdField_a_of_type_AndroidTextLayout = new SingleLineTextView.ExtraDynamicLayout(this.jdField_a_of_type_JavaLangCharSequence, this.jdField_b_of_type_JavaLangCharSequence, this.jdField_a_of_type_AndroidTextTextPaint, paramInt1, localAlignment, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.jdField_b_of_type_Boolean, this.jdField_a_of_type_AndroidTextTextUtils$TruncateAt, paramInt2);
        return;
        localAlignment = Layout.Alignment.ALIGN_CENTER;
        continue;
        localAlignment = Layout.Alignment.ALIGN_OPPOSITE;
      }
      if (paramMetrics == jdField_a_of_type_AndroidTextBoringLayout$Metrics)
      {
        BoringLayout.Metrics localMetrics = BoringLayout.isBoring(this.jdField_b_of_type_JavaLangCharSequence, this.jdField_a_of_type_AndroidTextTextPaint, this.jdField_b_of_type_AndroidTextBoringLayout$Metrics);
        paramMetrics = localMetrics;
        if (localMetrics != null)
        {
          this.jdField_b_of_type_AndroidTextBoringLayout$Metrics = localMetrics;
          paramMetrics = localMetrics;
        }
      }
      for (;;)
      {
        if (paramMetrics != null)
        {
          if ((paramMetrics.width <= paramInt1) && (paramMetrics.width <= paramInt2))
          {
            if (this.jdField_a_of_type_AndroidTextBoringLayout != null) {}
            for (this.jdField_a_of_type_AndroidTextLayout = this.jdField_a_of_type_AndroidTextBoringLayout.replaceOrMake(this.jdField_b_of_type_JavaLangCharSequence, this.jdField_a_of_type_AndroidTextTextPaint, paramInt1, localAlignment, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, paramMetrics, this.jdField_b_of_type_Boolean);; this.jdField_a_of_type_AndroidTextLayout = BoringLayout.make(this.jdField_b_of_type_JavaLangCharSequence, this.jdField_a_of_type_AndroidTextTextPaint, paramInt1, localAlignment, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, paramMetrics, this.jdField_b_of_type_Boolean))
            {
              this.jdField_a_of_type_AndroidTextBoringLayout = ((BoringLayout)this.jdField_a_of_type_AndroidTextLayout);
              return;
            }
          }
          if (paramMetrics.width <= paramInt1)
          {
            if (this.jdField_a_of_type_AndroidTextBoringLayout != null)
            {
              this.jdField_a_of_type_AndroidTextLayout = this.jdField_a_of_type_AndroidTextBoringLayout.replaceOrMake(this.jdField_b_of_type_JavaLangCharSequence, this.jdField_a_of_type_AndroidTextTextPaint, paramInt1, localAlignment, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, paramMetrics, this.jdField_b_of_type_Boolean, this.jdField_a_of_type_AndroidTextTextUtils$TruncateAt, paramInt2);
              return;
            }
            this.jdField_a_of_type_AndroidTextLayout = BoringLayout.make(this.jdField_b_of_type_JavaLangCharSequence, this.jdField_a_of_type_AndroidTextTextPaint, paramInt1, localAlignment, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, paramMetrics, this.jdField_b_of_type_Boolean, this.jdField_a_of_type_AndroidTextTextUtils$TruncateAt, paramInt2);
            return;
          }
          this.jdField_a_of_type_AndroidTextLayout = new SingleLineTextView.ExtraStaticLayout(this.jdField_b_of_type_JavaLangCharSequence, 0, this.jdField_b_of_type_JavaLangCharSequence.length(), this.jdField_a_of_type_AndroidTextTextPaint, paramInt1, localAlignment, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.jdField_b_of_type_Boolean, this.jdField_a_of_type_AndroidTextTextUtils$TruncateAt, paramInt2);
          return;
        }
        this.jdField_a_of_type_AndroidTextLayout = new SingleLineTextView.ExtraStaticLayout(this.jdField_b_of_type_JavaLangCharSequence, 0, this.jdField_b_of_type_JavaLangCharSequence.length(), this.jdField_a_of_type_AndroidTextTextPaint, paramInt1, localAlignment, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.jdField_b_of_type_Boolean, this.jdField_a_of_type_AndroidTextTextUtils$TruncateAt, paramInt2);
        return;
      }
    }
  }
  
  public int b()
  {
    int n = getPaddingLeft();
    Object localObject = this.jdField_a_of_type_Xuw;
    int m = n;
    if (localObject != null)
    {
      m = n;
      if (((xuw)localObject).jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
      {
        m = ((xuw)localObject).e;
        m = n + (((xuw)localObject).jdField_a_of_type_Int + m);
      }
    }
    localObject = this.jdField_a_of_type_ArrayOfXux[1];
    n = m;
    if (localObject != null)
    {
      n = m;
      if (!((xux)localObject).jdField_a_of_type_Boolean)
      {
        n = ((xux)localObject).jdField_b_of_type_Int;
        n = m + (((xux)localObject).a() + n);
      }
    }
    return n;
  }
  
  public int c()
  {
    int n = getPaddingRight();
    Object localObject = this.jdField_a_of_type_Xuw;
    int m = n;
    if (localObject != null)
    {
      m = n;
      if (((xuw)localObject).jdField_b_of_type_AndroidGraphicsDrawableDrawable != null)
      {
        m = ((xuw)localObject).e;
        m = n + (((xuw)localObject).jdField_b_of_type_Int + m);
      }
    }
    localObject = this.jdField_a_of_type_ArrayOfXux[2];
    n = m;
    if (localObject != null)
    {
      n = m;
      if (!((xux)localObject).jdField_a_of_type_Boolean)
      {
        n = ((xux)localObject).jdField_b_of_type_Int;
        n = m + (((xux)localObject).a() + n);
      }
    }
    localObject = this.jdField_a_of_type_ArrayOfXux[0];
    m = n;
    if (localObject != null)
    {
      m = n;
      if (!((xux)localObject).jdField_a_of_type_Boolean)
      {
        m = ((xux)localObject).jdField_b_of_type_Int;
        m = n + (((xux)localObject).a() + m);
      }
    }
    return m;
  }
  
  public int d()
  {
    return getPaddingTop();
  }
  
  protected void drawableStateChanged()
  {
    int n = 0;
    super.drawableStateChanged();
    if ((this.jdField_a_of_type_AndroidContentResColorStateList != null) && (this.jdField_a_of_type_AndroidContentResColorStateList.isStateful())) {
      d();
    }
    int[] arrayOfInt = getDrawableState();
    Object localObject = this.jdField_a_of_type_Xuw;
    if (localObject != null)
    {
      if ((((xuw)localObject).jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (((xuw)localObject).jdField_a_of_type_AndroidGraphicsDrawableDrawable.isStateful())) {
        ((xuw)localObject).jdField_a_of_type_AndroidGraphicsDrawableDrawable.setState(arrayOfInt);
      }
      if ((((xuw)localObject).jdField_b_of_type_AndroidGraphicsDrawableDrawable != null) && (((xuw)localObject).jdField_b_of_type_AndroidGraphicsDrawableDrawable.isStateful())) {
        ((xuw)localObject).jdField_b_of_type_AndroidGraphicsDrawableDrawable.setState(arrayOfInt);
      }
    }
    int m = 0;
    if (m < this.jdField_a_of_type_ArrayOfXux.length)
    {
      localObject = this.jdField_a_of_type_ArrayOfXux[m];
      if (localObject == null) {}
      for (;;)
      {
        m += 1;
        break;
        if (((xux)localObject).a(arrayOfInt)) {
          n = 1;
        }
      }
    }
    if (n != 0) {
      invalidate();
    }
  }
  
  public int e()
  {
    return getPaddingBottom();
  }
  
  public int f()
  {
    int m;
    if (this.jdField_a_of_type_AndroidTextLayout.getLineCount() <= 1) {
      m = d();
    }
    int n;
    int i1;
    int i2;
    int i3;
    do
    {
      do
      {
        return m;
        n = d();
        m = e();
        i1 = getHeight() - n - m;
        i2 = this.jdField_a_of_type_AndroidTextLayout.getLineTop(1);
        m = n;
      } while (i2 >= i1);
      i3 = this.k & 0x70;
      m = n;
    } while (i3 == 48);
    if (i3 == 80) {
      return n + i1 - i2;
    }
    return n + (i1 - i2) / 2;
  }
  
  public int g()
  {
    int m;
    if (this.jdField_a_of_type_AndroidTextLayout.getLineCount() <= 1) {
      m = e();
    }
    int n;
    int i1;
    int i2;
    int i3;
    do
    {
      do
      {
        return m;
        m = d();
        n = e();
        i1 = getHeight() - m - n;
        i2 = this.jdField_a_of_type_AndroidTextLayout.getLineTop(1);
        m = n;
      } while (i2 >= i1);
      i3 = this.k & 0x70;
      if (i3 == 48) {
        return n + i1 - i2;
      }
      m = n;
    } while (i3 == 80);
    return n + (i1 - i2) / 2;
  }
  
  public int h()
  {
    return Math.round(this.jdField_a_of_type_AndroidTextTextPaint.getFontMetricsInt(null) * this.jdField_a_of_type_Float + this.jdField_b_of_type_Float);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (this.jdField_a_of_type_AndroidTextLayout != null) {
        b();
      }
    }
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    Rect localRect;
    int i2;
    int i1;
    xuw localxuw;
    int m;
    int n;
    int i3;
    int i4;
    if (verifyDrawable(paramDrawable))
    {
      localRect = paramDrawable.getBounds();
      i2 = getScrollX();
      i1 = getScrollY();
      localxuw = this.jdField_a_of_type_Xuw;
      m = i1;
      n = i2;
      if (localxuw != null)
      {
        if (paramDrawable != localxuw.jdField_a_of_type_AndroidGraphicsDrawableDrawable) {
          break label133;
        }
        m = d();
        i3 = e();
        i4 = getHeight();
        n = i2 + getPaddingLeft();
        m = i1 + ((i4 - i3 - m - localxuw.c) / 2 + m);
      }
    }
    for (;;)
    {
      invalidate(localRect.left + n, localRect.top + m, n + localRect.right, m + localRect.bottom);
      return;
      label133:
      m = i1;
      n = i2;
      if (paramDrawable == localxuw.jdField_b_of_type_AndroidGraphicsDrawableDrawable)
      {
        m = d();
        i3 = e();
        i4 = getHeight();
        n = i2 + (getWidth() - getPaddingRight() - localxuw.jdField_b_of_type_Int);
        m = i1 + ((i4 - i3 - m - localxuw.d) / 2 + m);
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i2 = b();
    int i3 = d();
    int i8 = c();
    int i1 = e();
    int i4 = getScrollX();
    int i5 = getScrollY();
    int i6 = getRight();
    int i7 = getLeft();
    int i12 = getBottom();
    int i13 = getTop();
    int m;
    if (this.jdField_a_of_type_AndroidTextLayout == null)
    {
      n = i6 - i7 - i2 - i8;
      m = n;
      if (n < 1) {
        m = 0;
      }
      if (!this.jdField_a_of_type_Boolean) {
        break label865;
      }
    }
    label855:
    label858:
    label865:
    for (int n = 16384;; n = m)
    {
      a(n, jdField_a_of_type_AndroidTextBoringLayout$Metrics, m);
      int i9 = f();
      int i14 = g();
      int i11 = i12 - i13 - i1 - i3;
      int i10 = this.jdField_a_of_type_AndroidTextLayout.getLineTop(1) - this.jdField_a_of_type_AndroidTextLayout.getLineDescent(0);
      i1 = 0;
      m = 0;
      n = 0;
      if ((this.k & 0x70) != 48)
      {
        m = i();
        n = i();
      }
      int[] arrayOfInt = getDrawableState();
      Object localObject1 = this.jdField_a_of_type_Xuw;
      if ((localObject1 != null) && (((xuw)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable != null))
      {
        paramCanvas.save();
        int i15 = getPaddingLeft();
        int i16 = (i11 - ((xuw)localObject1).c) / 2;
        paramCanvas.translate(i15 + i4, i5 + i3 + i16);
        ((xuw)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
        paramCanvas.restore();
      }
      Object localObject2 = this.jdField_a_of_type_ArrayOfXux[1];
      Paint.FontMetrics localFontMetrics;
      float f2;
      float f1;
      if ((localObject2 != null) && (!((xux)localObject2).jdField_a_of_type_Boolean))
      {
        paramCanvas.save();
        paramCanvas.translate(i4 + i2 - ((xux)localObject2).a(), i9 + m);
        localFontMetrics = ((xux)localObject2).a();
        f2 = i10;
        f1 = f2;
        if (localFontMetrics != null)
        {
          f1 = f2;
          if (f2 > getMeasuredHeight() - localFontMetrics.bottom) {
            f1 = (int)(getMeasuredHeight() - localFontMetrics.bottom);
          }
        }
        ((xux)localObject2).a(paramCanvas, arrayOfInt, 0.0F, f1);
        paramCanvas.restore();
      }
      localObject2 = this.jdField_a_of_type_AndroidTextLayout;
      this.jdField_a_of_type_AndroidTextTextPaint.setColor(this.g);
      this.jdField_a_of_type_AndroidTextTextPaint.drawableState = getDrawableState();
      paramCanvas.save();
      paramCanvas.clipRect(i2 + i4, i9 + i5, i6 - i7 - i8 + i4, i12 - i13 - i14 + i5);
      paramCanvas.translate(i2, i9 + m);
      ((Layout)localObject2).draw(paramCanvas, null, null, n - m);
      paramCanvas.restore();
      localObject2 = this.jdField_a_of_type_ArrayOfXux[2];
      n = i1;
      if (localObject2 != null)
      {
        n = i1;
        if (!((xux)localObject2).jdField_a_of_type_Boolean)
        {
          paramCanvas.save();
          n = j() + 0 + ((xux)localObject2).jdField_b_of_type_Int;
          i2 = i4 + i6 - i7 - i8 + 0;
          i1 = 0 + (((xux)localObject2).a() + ((xux)localObject2).jdField_b_of_type_Int);
          if (i2 <= n) {
            break label858;
          }
        }
      }
      for (;;)
      {
        paramCanvas.translate(n, i9 + m);
        localFontMetrics = ((xux)localObject2).a();
        f2 = i10;
        f1 = f2;
        if (localFontMetrics != null)
        {
          f1 = f2;
          if (f2 > getMeasuredHeight() - localFontMetrics.bottom) {
            f1 = (int)(((xux)localObject2).b() - localFontMetrics.bottom);
          }
        }
        ((xux)localObject2).a(paramCanvas, arrayOfInt, 0.0F, f1);
        paramCanvas.restore();
        n = i1;
        if ((localObject1 != null) && (((xuw)localObject1).jdField_b_of_type_AndroidGraphicsDrawableDrawable != null))
        {
          paramCanvas.save();
          i1 = j() + n + ((xuw)localObject1).e;
          n = i4 + i6 - i7 - i8 + n + ((xuw)localObject1).e;
          i2 = ((xuw)localObject1).jdField_b_of_type_Int;
          i2 = ((xuw)localObject1).e;
          if (n <= i1) {
            break label855;
          }
          n = i1;
        }
        for (;;)
        {
          i1 = (i11 - ((xuw)localObject1).d) / 2;
          paramCanvas.translate(n, i5 + i3 + i1);
          ((xuw)localObject1).jdField_b_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
          paramCanvas.restore();
          localObject1 = this.jdField_a_of_type_ArrayOfXux[0];
          if ((localObject1 != null) && (!((xux)localObject1).jdField_a_of_type_Boolean))
          {
            paramCanvas.save();
            paramCanvas.translate(i4 + i6 - i7 - ((xux)localObject1).a() - getPaddingRight(), m + i9);
            ((xux)localObject1).a(paramCanvas, arrayOfInt, 0.0F, i10);
            paramCanvas.restore();
          }
          return;
        }
        n = i2;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int m = 0;
    if (Build.VERSION.SDK_INT < 21) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    }
    int i3 = View.MeasureSpec.getMode(paramInt1);
    int i2 = View.MeasureSpec.getMode(paramInt2);
    int i1 = View.MeasureSpec.getSize(paramInt1);
    int n = View.MeasureSpec.getSize(paramInt2);
    Object localObject = jdField_a_of_type_AndroidTextBoringLayout$Metrics;
    if (i3 == 1073741824) {
      paramInt2 = i1;
    }
    label242:
    label419:
    for (;;)
    {
      i1 = paramInt2 - b() - c();
      if (this.jdField_a_of_type_Boolean) {}
      for (paramInt1 = 16384;; paramInt1 = i1)
      {
        if (this.jdField_a_of_type_AndroidTextLayout == null) {
          a(paramInt1, (BoringLayout.Metrics)localObject, i1);
        }
        for (;;)
        {
          if (i2 != 1073741824) {
            break label242;
          }
          paramInt1 = n;
          setMeasuredDimension(paramInt2, paramInt1);
          return;
          localObject = BoringLayout.isBoring(this.jdField_b_of_type_JavaLangCharSequence, this.jdField_a_of_type_AndroidTextTextPaint, this.jdField_b_of_type_AndroidTextBoringLayout$Metrics);
          if (localObject != null) {
            this.jdField_b_of_type_AndroidTextBoringLayout$Metrics = ((BoringLayout.Metrics)localObject);
          }
          if ((localObject == null) || (localObject == jdField_a_of_type_AndroidTextBoringLayout$Metrics)) {}
          for (paramInt1 = j();; paramInt1 = ((BoringLayout.Metrics)localObject).width)
          {
            paramInt2 = Math.max(Math.min(paramInt1 + (b() + c()), this.j), getSuggestedMinimumWidth());
            if (i3 != Integer.MIN_VALUE) {
              break label419;
            }
            paramInt2 = Math.min(i1, paramInt2);
            break;
          }
          if ((this.jdField_a_of_type_AndroidTextLayout.getWidth() != paramInt1) || (this.jdField_a_of_type_AndroidTextLayout.getEllipsizedWidth() != i1)) {
            a(paramInt1, (BoringLayout.Metrics)localObject, i1);
          }
        }
        paramInt1 = d();
        i1 = e() + paramInt1;
        if (this.jdField_a_of_type_AndroidTextLayout != null)
        {
          n = this.jdField_a_of_type_AndroidTextLayout.getLineCount();
          paramInt1 = n;
          if (n > 1) {
            paramInt1 = 1;
          }
        }
        for (paramInt1 = this.jdField_a_of_type_AndroidTextLayout.getLineTop(paramInt1);; paramInt1 = 0)
        {
          n = paramInt1 + i1;
          localObject = this.jdField_a_of_type_Xuw;
          paramInt1 = n;
          if (localObject != null) {
            paramInt1 = Math.max(Math.max(n, ((xuw)localObject).c), ((xuw)localObject).d);
          }
          n = paramInt1;
          if (paramInt1 == i1) {
            for (;;)
            {
              n = paramInt1;
              if (m >= this.jdField_a_of_type_ArrayOfXux.length) {
                break;
              }
              localObject = this.jdField_a_of_type_ArrayOfXux[m];
              n = paramInt1;
              if (localObject != null)
              {
                n = paramInt1;
                if (!((xux)localObject).jdField_a_of_type_Boolean) {
                  n = Math.max(paramInt1, ((xux)localObject).b());
                }
              }
              m += 1;
              paramInt1 = n;
            }
          }
          paramInt1 = Math.max(n, getSuggestedMinimumHeight());
          break;
        }
      }
    }
  }
  
  public void setCompoundDrawablePadding(int paramInt)
  {
    xuw localxuw2 = this.jdField_a_of_type_Xuw;
    if (paramInt == 0) {
      if (localxuw2 == null) {}
    }
    xuw localxuw1;
    for (localxuw2.e = paramInt;; localxuw1.e = paramInt)
    {
      if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(1)) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      }
      return;
      localxuw1 = localxuw2;
      if (localxuw2 == null)
      {
        localxuw1 = new xuw(null);
        this.jdField_a_of_type_Xuw = localxuw1;
      }
    }
  }
  
  public void setCompoundDrawables(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    Object localObject2 = this.jdField_a_of_type_Xuw;
    int m;
    if ((paramDrawable1 != null) || (paramDrawable2 != null))
    {
      m = 1;
      if (m != 0) {
        break label140;
      }
      if (localObject2 != null)
      {
        if (((xuw)localObject2).e != 0) {
          break label67;
        }
        this.jdField_a_of_type_Xuw = null;
      }
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(1)) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      }
      return;
      m = 0;
      break;
      label67:
      if (((xuw)localObject2).jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
        ((xuw)localObject2).jdField_a_of_type_AndroidGraphicsDrawableDrawable.setCallback(null);
      }
      ((xuw)localObject2).jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      if (((xuw)localObject2).jdField_b_of_type_AndroidGraphicsDrawableDrawable != null) {
        ((xuw)localObject2).jdField_b_of_type_AndroidGraphicsDrawableDrawable.setCallback(null);
      }
      ((xuw)localObject2).jdField_b_of_type_AndroidGraphicsDrawableDrawable = null;
      ((xuw)localObject2).c = 0;
      ((xuw)localObject2).jdField_a_of_type_Int = 0;
      ((xuw)localObject2).d = 0;
      ((xuw)localObject2).jdField_b_of_type_Int = 0;
      continue;
      label140:
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new xuw(null);
        this.jdField_a_of_type_Xuw = ((xuw)localObject1);
      }
      if ((((xuw)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable != paramDrawable1) && (((xuw)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)) {
        ((xuw)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable.setCallback(null);
      }
      ((xuw)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable1;
      if ((((xuw)localObject1).jdField_b_of_type_AndroidGraphicsDrawableDrawable != paramDrawable1) && (((xuw)localObject1).jdField_b_of_type_AndroidGraphicsDrawableDrawable != null)) {
        ((xuw)localObject1).jdField_b_of_type_AndroidGraphicsDrawableDrawable.setCallback(null);
      }
      ((xuw)localObject1).jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramDrawable2;
      localObject2 = ((xuw)localObject1).jdField_a_of_type_AndroidGraphicsRect;
      int[] arrayOfInt = getDrawableState();
      if (paramDrawable1 != null)
      {
        paramDrawable1.setState(arrayOfInt);
        paramDrawable1.copyBounds((Rect)localObject2);
        paramDrawable1.setCallback(this);
        ((xuw)localObject1).jdField_a_of_type_Int = ((Rect)localObject2).width();
        ((xuw)localObject1).c = ((Rect)localObject2).height();
      }
      for (;;)
      {
        if (paramDrawable2 == null) {
          break label326;
        }
        paramDrawable2.setState(arrayOfInt);
        paramDrawable2.copyBounds((Rect)localObject2);
        paramDrawable2.setCallback(this);
        ((xuw)localObject1).jdField_b_of_type_Int = ((Rect)localObject2).width();
        ((xuw)localObject1).d = ((Rect)localObject2).height();
        break;
        ((xuw)localObject1).c = 0;
        ((xuw)localObject1).jdField_a_of_type_Int = 0;
      }
      label326:
      ((xuw)localObject1).d = 0;
      ((xuw)localObject1).jdField_b_of_type_Int = 0;
    }
  }
  
  public void setCompoundDrawablesWithIntrinsicBounds(int paramInt1, int paramInt2)
  {
    Drawable localDrawable2 = null;
    if ((this.h == paramInt1) && (this.i == paramInt2)) {
      return;
    }
    this.h = paramInt1;
    this.i = paramInt2;
    Resources localResources = getContext().getResources();
    if (paramInt1 != 0) {}
    for (Drawable localDrawable1 = localResources.getDrawable(paramInt1);; localDrawable1 = null)
    {
      if (paramInt2 != 0) {
        localDrawable2 = localResources.getDrawable(paramInt2);
      }
      setCompoundDrawablesWithIntrinsicBounds(localDrawable1, localDrawable2);
      return;
    }
  }
  
  public void setCompoundDrawablesWithIntrinsicBounds(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    if (paramDrawable1 != null) {
      paramDrawable1.setBounds(0, 0, paramDrawable1.getIntrinsicWidth(), paramDrawable1.getIntrinsicHeight());
    }
    if (paramDrawable2 != null) {
      paramDrawable2.setBounds(0, 0, paramDrawable2.getIntrinsicWidth(), paramDrawable2.getIntrinsicHeight());
    }
    setCompoundDrawables(paramDrawable1, paramDrawable2);
  }
  
  public void setExtendText(String paramString, int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfXux.length)) {}
    xux localxux2;
    boolean bool;
    do
    {
      return;
      localxux2 = this.jdField_a_of_type_ArrayOfXux[paramInt];
      bool = TextUtils.isEmpty(paramString);
    } while ((bool) && ((localxux2 == null) || (localxux2.jdField_a_of_type_Boolean)));
    int m;
    if ((bool) && (localxux2 != null) && (!localxux2.jdField_a_of_type_Boolean))
    {
      localxux2.a();
      m = 1;
    }
    for (;;)
    {
      if ((paramInt == 0) && (m != 0)) {
        postInvalidate();
      }
      if ((m == 0) || (this.jdField_a_of_type_AndroidOsHandler.hasMessages(1))) {
        break;
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      return;
      if (!bool)
      {
        xux localxux1 = localxux2;
        if (localxux2 == null)
        {
          localxux1 = new xux(getResources());
          this.jdField_a_of_type_ArrayOfXux[paramInt] = localxux1;
        }
        if (!paramString.equals(localxux1.jdField_a_of_type_JavaLangString))
        {
          localxux1.jdField_a_of_type_JavaLangString = paramString;
          localxux1.c = -1;
          localxux1.jdField_a_of_type_Boolean = false;
          m = 1;
          continue;
        }
      }
      m = 0;
    }
  }
  
  public void setExtendTextColor(ColorStateList paramColorStateList, int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfXux.length)) {}
    xux localxux1;
    do
    {
      return;
      xux localxux2 = this.jdField_a_of_type_ArrayOfXux[paramInt];
      localxux1 = localxux2;
      if (localxux2 == null)
      {
        localxux1 = new xux(getResources());
        this.jdField_a_of_type_ArrayOfXux[paramInt] = localxux1;
      }
    } while (!localxux1.a(paramColorStateList, getDrawableState()));
    postInvalidate();
  }
  
  public void setExtendTextPadding(int paramInt1, int paramInt2)
  {
    if ((paramInt2 < 0) || (paramInt2 >= this.jdField_a_of_type_ArrayOfXux.length)) {}
    xux localxux2;
    do
    {
      return;
      localxux2 = this.jdField_a_of_type_ArrayOfXux[paramInt2];
    } while ((paramInt1 <= 0) && ((localxux2 == null) || (localxux2.jdField_a_of_type_Boolean)));
    xux localxux1 = localxux2;
    if (localxux2 == null)
    {
      localxux1 = new xux(getResources());
      this.jdField_a_of_type_ArrayOfXux[paramInt2] = localxux1;
    }
    localxux1.jdField_b_of_type_Int = paramInt1;
  }
  
  public void setExtendTextSize(float paramFloat, int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfXux.length)) {}
    xux localxux1;
    do
    {
      return;
      xux localxux2 = this.jdField_a_of_type_ArrayOfXux[paramInt];
      localxux1 = localxux2;
      if (localxux2 == null)
      {
        localxux1 = new xux(getResources());
        this.jdField_a_of_type_ArrayOfXux[paramInt] = localxux1;
      }
    } while ((!localxux1.a(paramFloat, getContext())) || (this.jdField_a_of_type_AndroidOsHandler.hasMessages(1)));
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
  
  public void setGravity(int paramInt)
  {
    if ((paramInt & 0x7) == 0) {
      paramInt |= 0x3;
    }
    for (;;)
    {
      int m = paramInt;
      if ((paramInt & 0x70) == 0) {
        m = paramInt | 0x30;
      }
      paramInt = 0;
      if ((m & 0x7) != (this.k & 0x7)) {
        paramInt = 1;
      }
      if (m != this.k) {
        invalidate();
      }
      this.k = m;
      if ((this.jdField_a_of_type_AndroidTextLayout != null) && (paramInt != 0))
      {
        paramInt = this.jdField_a_of_type_AndroidTextLayout.getWidth();
        m = getWidth();
        int n = b();
        int i1 = c();
        a(paramInt, jdField_a_of_type_AndroidTextBoringLayout$Metrics, m - n - i1);
      }
      return;
    }
  }
  
  public final void setMaxWidth(int paramInt)
  {
    if (this.j != paramInt)
    {
      this.j = paramInt;
      requestLayout();
      invalidate();
    }
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    Object localObject = paramCharSequence;
    if (paramCharSequence == null) {
      localObject = "";
    }
    if (localObject.equals(this.jdField_a_of_type_JavaLangCharSequence)) {
      return;
    }
    if (((CharSequence)localObject).length() > 168) {}
    for (;;)
    {
      try
      {
        paramCharSequence = ((CharSequence)localObject).subSequence(0, 168);
        this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
        this.jdField_b_of_type_JavaLangCharSequence = this.jdField_a_of_type_AndroidTextMethodTransformationMethod.getTransformation(paramCharSequence, this);
        if ((paramCharSequence instanceof Spannable))
        {
          int m = paramCharSequence.length();
          ((Spannable)paramCharSequence).setSpan(this.jdField_a_of_type_AndroidTextMethodTransformationMethod, 0, m, 18);
        }
        this.l = -1;
        if (this.jdField_a_of_type_AndroidTextLayout == null) {
          break;
        }
        b();
        return;
      }
      catch (Exception paramCharSequence)
      {
        if (QLog.isDevelopLevel()) {
          paramCharSequence.printStackTrace();
        }
      }
      paramCharSequence = (CharSequence)localObject;
    }
  }
  
  public void setTextColor(int paramInt)
  {
    this.jdField_a_of_type_AndroidContentResColorStateList = ColorStateList.valueOf(paramInt);
    d();
  }
  
  public void setTextColor(ColorStateList paramColorStateList)
  {
    if (paramColorStateList == null) {
      return;
    }
    this.jdField_a_of_type_AndroidContentResColorStateList = paramColorStateList;
    d();
  }
  
  public void setTextSize(float paramFloat)
  {
    Object localObject = getContext();
    if (localObject == null) {}
    for (localObject = Resources.getSystem();; localObject = ((Context)localObject).getResources())
    {
      paramFloat = TypedValue.applyDimension(1, paramFloat, ((Resources)localObject).getDisplayMetrics());
      if (paramFloat != this.jdField_a_of_type_AndroidTextTextPaint.getTextSize())
      {
        this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(paramFloat);
        this.l = -1;
        if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(1)) {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
        }
      }
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\widget\SingleLineTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */