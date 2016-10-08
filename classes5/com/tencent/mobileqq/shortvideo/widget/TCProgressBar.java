package com.tencent.mobileqq.shortvideo.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import utd;
import ute;
import utg;
import uth;

public class TCProgressBar
  extends View
{
  public static final float a = 15.0F;
  public static final int a = 1;
  public static final String a = "TCProgressBar";
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  static final int t = 3;
  long jdField_a_of_type_Long;
  public Bitmap a;
  public Paint a;
  Rect jdField_a_of_type_AndroidGraphicsRect;
  public Handler a;
  TouchDelegate jdField_a_of_type_AndroidViewTouchDelegate;
  public TCProgressBar.DelEvent a;
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  public utd a;
  ute jdField_a_of_type_Ute;
  utg jdField_a_of_type_Utg;
  boolean jdField_a_of_type_Boolean;
  float jdField_b_of_type_Float;
  public Bitmap b;
  public Rect b;
  ArrayList jdField_b_of_type_JavaUtilArrayList;
  boolean jdField_b_of_type_Boolean;
  public int e;
  public int f;
  public int g;
  public int h;
  public int i;
  int j;
  public int k;
  public int l;
  public int m;
  public int n;
  public int o;
  public int p;
  public int q;
  int r;
  int s;
  
  public TCProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.h = 1000;
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect(0, 0, 0, 0);
    this.jdField_a_of_type_AndroidViewTouchDelegate = new TouchDelegate(this.jdField_a_of_type_AndroidGraphicsRect, this);
    this.jdField_b_of_type_Boolean = false;
    this.j = 0;
    this.k = 1310991405;
    this.l = -14408659;
    this.m = -16737062;
    this.n = -65536;
    this.o = -15000805;
    this.p = ScreenUtil.a(1.0F);
    this.q = -1;
    this.r = ScreenUtil.a(5.0F);
    this.jdField_b_of_type_AndroidGraphicsRect = new Rect();
    this.s = 0;
    this.jdField_a_of_type_Utd = new utd(this);
    this.jdField_a_of_type_Ute = new ute(this);
    this.jdField_a_of_type_Utg = new utg(this, true);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(10);
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(10);
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.e = 3;
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(paramContext.getResources(), 2130841248);
      this.jdField_b_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(paramContext.getResources(), 2130841247);
      this.i = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new uth(this), this.h);
      return;
    }
    catch (OutOfMemoryError paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        this.i = 100;
      }
    }
  }
  
  public int a()
  {
    int i1 = this.jdField_a_of_type_JavaUtilArrayList.size();
    if (i1 > 0) {
      return ((utg)this.jdField_a_of_type_JavaUtilArrayList.get(i1 - 1)).jdField_b_of_type_Int;
    }
    return -1;
  }
  
  int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == this.f) {
      return paramInt2;
    }
    paramInt2 = paramInt2 * paramInt1 / this.f;
    paramInt1 = paramInt2;
    if (paramInt2 <= 0) {
      paramInt1 = 1;
    }
    return paramInt1;
  }
  
  public void a()
  {
    a(4);
  }
  
  public void a(int paramInt)
  {
    this.e = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      invalidate();
      return;
      this.jdField_a_of_type_Utd.e = true;
      this.jdField_a_of_type_Ute.e = false;
      continue;
      this.jdField_a_of_type_Utd.e = false;
      this.jdField_a_of_type_Ute.e = true;
      this.jdField_a_of_type_Ute.jdField_a_of_type_Boolean = true;
      continue;
      this.jdField_a_of_type_Utd.e = true;
      this.jdField_a_of_type_Ute.e = false;
      utg localutg = new utg(this, false);
      localutg.jdField_b_of_type_Boolean = false;
      localutg.c = 0;
      localutg.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_JavaUtilArrayList.add(localutg);
      continue;
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_b_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_Boolean = false;
      this.g = 0;
      this.s = 0;
    }
  }
  
  public int b()
  {
    int i2 = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i1 = i2;
    if (i2 > 0)
    {
      this.jdField_a_of_type_JavaUtilArrayList.remove(i2 - 1);
      i1 = this.jdField_a_of_type_JavaUtilArrayList.size();
    }
    if (i1 > 0)
    {
      this.s = c();
      i1 = this.s;
      this.g = i1;
      return i1;
    }
    this.s = 0;
    this.g = 0;
    return 0;
  }
  
  void b()
  {
    int i7 = super.getWidth();
    int i6 = this.i - 3;
    int i4 = i7 - i6;
    int i5 = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i1 = 0;
    while (i1 < i5 - 1)
    {
      localutg = (utg)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
      if (localutg.d)
      {
        localutg.j = a(localutg.c - localutg.jdField_b_of_type_Int, i4);
        localutg.k = a(localutg.jdField_b_of_type_Int, i4);
        localutg.jdField_a_of_type_Boolean = false;
      }
      i1 += 1;
    }
    int i8 = this.jdField_b_of_type_JavaUtilArrayList.size();
    i1 = 0;
    while (i1 < i8)
    {
      localutg = (utg)this.jdField_b_of_type_JavaUtilArrayList.get(i1);
      if (localutg.d)
      {
        localutg.j = a(localutg.c - localutg.jdField_b_of_type_Int, i4);
        localutg.k = a(localutg.jdField_b_of_type_Int, i4);
        localutg.jdField_a_of_type_Boolean = false;
      }
      i1 += 1;
    }
    if (i5 > 0)
    {
      localutg = (utg)this.jdField_a_of_type_JavaUtilArrayList.get(i5 - 1);
      localutg.f = true;
      localutg.jdField_a_of_type_Boolean = false;
      if (!localutg.g)
      {
        localutg.c = this.g;
        localutg.jdField_b_of_type_Int = (this.g - this.s);
      }
      if (localutg.d)
      {
        localutg.j = a(localutg.c - localutg.jdField_b_of_type_Int, i4);
        localutg.k = a(localutg.jdField_b_of_type_Int, i4);
      }
    }
    int i2;
    int i9;
    int i3;
    if (i5 <= 0)
    {
      i2 = i4;
      i1 = 0;
      if ((this.jdField_a_of_type_Utd.e) && (this.jdField_a_of_type_Utd.d))
      {
        this.jdField_a_of_type_Utd.j = i1;
        this.jdField_a_of_type_Utd.k = this.r;
      }
      i9 = this.jdField_a_of_type_Ute.a();
      i3 = i5;
      if (this.jdField_a_of_type_Ute.e)
      {
        i3 = i5;
        if (this.jdField_a_of_type_Ute.d)
        {
          this.jdField_a_of_type_Ute.k = this.i;
          if (!this.jdField_a_of_type_Ute.c) {
            break label838;
          }
          this.jdField_a_of_type_Ute.j = (i1 - 3);
        }
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Ute.j < 0) && (this.jdField_a_of_type_Ute.c)) {
        this.jdField_a_of_type_Ute.j = 0;
      }
      if (this.jdField_a_of_type_Ute.j + this.jdField_a_of_type_Ute.k + 1 >= i7) {
        this.jdField_a_of_type_Ute.j = (i7 - this.jdField_a_of_type_Ute.k);
      }
      if (QLog.isColorLevel()) {
        QLog.d("TCProgressBar", 2, "layout:delete.requestLayout" + this.jdField_a_of_type_Ute.c);
      }
      i3 = i5;
      if (!this.jdField_a_of_type_Ute.c)
      {
        i5 = this.jdField_a_of_type_JavaUtilArrayList.size();
        if (i5 > 0)
        {
          localutg = (utg)this.jdField_a_of_type_JavaUtilArrayList.get(i5 - 1);
          localutg.f = false;
          if (localutg.a(i9))
          {
            if (QLog.isColorLevel()) {
              QLog.d("TCProgressBar", 2, "layout:progress.checkBounds=true");
            }
            localutg.jdField_a_of_type_Int = (this.jdField_a_of_type_Ute.j + 3);
            localutg.jdField_a_of_type_Boolean = true;
          }
        }
        i3 = i5;
        if (i8 > 0)
        {
          localutg = (utg)this.jdField_b_of_type_JavaUtilArrayList.get(i8 - 1);
          i3 = i5;
          if (localutg.a(i9))
          {
            if (QLog.isColorLevel()) {
              QLog.d("TCProgressBar", 2, "layout:deletedList.checkBounds=true");
            }
            localutg.jdField_a_of_type_Int = (this.jdField_a_of_type_Ute.j + 3);
            localutg.jdField_a_of_type_Boolean = true;
            i3 = i5;
          }
        }
      }
      if (i3 > 0)
      {
        localutg = (utg)this.jdField_a_of_type_JavaUtilArrayList.get(i3 - 1);
        if (localutg.h) {
          localutg.k = (i4 - localutg.j);
        }
      }
      if (i8 > 0)
      {
        localutg = (utg)this.jdField_b_of_type_JavaUtilArrayList.get(0);
        if (localutg.h) {
          localutg.k = (i7 - localutg.j);
        }
        i1 = localutg.j + localutg.k;
        i2 = i4 - i1;
      }
      if (this.jdField_a_of_type_Utg.d)
      {
        this.jdField_a_of_type_Utg.j = i1;
        this.jdField_a_of_type_Utg.k = i2;
        if (this.jdField_a_of_type_Utg.k > 1) {
          break label878;
        }
        this.jdField_a_of_type_Utg.e = false;
      }
      return;
      localutg = (utg)this.jdField_a_of_type_JavaUtilArrayList.get(i5 - 1);
      i2 = localutg.j + localutg.k;
      i1 = i2;
      i2 = i4 - i2;
      break;
      label838:
      if ((i8 == 0) && (i9 > i1))
      {
        this.jdField_a_of_type_Ute.j = (i1 - 3);
        this.jdField_a_of_type_Ute.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Ute.c = true;
      }
    }
    label878:
    this.jdField_a_of_type_Utg.e = true;
    utg localutg = this.jdField_a_of_type_Utg;
    localutg.k += i6;
  }
  
  public int c()
  {
    int i1 = 0;
    int i2 = this.jdField_a_of_type_JavaUtilArrayList.size();
    if (i2 > 0) {
      i1 = ((utg)this.jdField_a_of_type_JavaUtilArrayList.get(i2 - 1)).c;
    }
    return i1;
  }
  
  public void c()
  {
    int i1 = this.jdField_a_of_type_JavaUtilArrayList.size();
    if (i1 > 0)
    {
      utg localutg = (utg)this.jdField_a_of_type_JavaUtilArrayList.get(i1 - 1);
      if (this.jdField_a_of_type_Boolean)
      {
        localutg.h = true;
        this.g = this.f;
      }
      localutg.jdField_b_of_type_Boolean = false;
      localutg.c = this.g;
      localutg.jdField_b_of_type_Int = (this.g - this.s);
      localutg.g = true;
      this.s = this.g;
    }
  }
  
  public int d()
  {
    return this.jdField_b_of_type_JavaUtilArrayList.size();
  }
  
  public void d()
  {
    if (this.jdField_b_of_type_JavaUtilArrayList.size() > 0)
    {
      this.jdField_b_of_type_JavaUtilArrayList.clear();
      this.s = c();
      this.g = this.s;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i2 = 0;
    super.onDraw(paramCanvas);
    if (super.isInEditMode()) {}
    do
    {
      return;
      int i1 = super.getWidth();
      int i3 = super.getHeight();
      int i4 = i3 / 7;
      int i5 = i4 * 3;
      b();
      this.jdField_a_of_type_Ute.h = i3;
      this.jdField_b_of_type_AndroidGraphicsRect.left = 0;
      this.jdField_b_of_type_AndroidGraphicsRect.right = i1;
      this.jdField_b_of_type_AndroidGraphicsRect.top = 0;
      this.jdField_b_of_type_AndroidGraphicsRect.bottom = i5;
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(0);
      paramCanvas.drawRect(this.jdField_b_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_b_of_type_AndroidGraphicsRect.top = (i5 + i4);
      this.jdField_b_of_type_AndroidGraphicsRect.bottom = i3;
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(0);
      paramCanvas.drawRect(this.jdField_b_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_b_of_type_AndroidGraphicsRect.top = i5;
      this.jdField_b_of_type_AndroidGraphicsRect.bottom = (i5 + i4);
      i3 = this.jdField_a_of_type_JavaUtilArrayList.size();
      i1 = 0;
      utg localutg;
      while (i1 < i3)
      {
        localutg = (utg)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
        if ((localutg.d) && (localutg.e)) {
          localutg.a(paramCanvas);
        }
        i1 += 1;
      }
      i3 = this.jdField_b_of_type_JavaUtilArrayList.size();
      i1 = i2;
      while (i1 < i3)
      {
        localutg = (utg)this.jdField_b_of_type_JavaUtilArrayList.get(i1);
        if ((localutg.d) && (localutg.e)) {
          localutg.a(paramCanvas);
        }
        i1 += 1;
      }
      if ((this.jdField_a_of_type_Utg.d) && (this.jdField_a_of_type_Utg.e)) {
        this.jdField_a_of_type_Utg.a(paramCanvas);
      }
      if ((this.jdField_a_of_type_Utd.d) && (this.jdField_a_of_type_Utd.e)) {
        this.jdField_a_of_type_Utd.a(paramCanvas);
      }
    } while ((!this.jdField_a_of_type_Ute.d) || (!this.jdField_a_of_type_Ute.e));
    this.jdField_a_of_type_Ute.a(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt1 != this.jdField_a_of_type_AndroidGraphicsRect.left) || (paramInt2 != this.jdField_a_of_type_AndroidGraphicsRect.top + 25) || (paramInt3 != this.jdField_a_of_type_AndroidGraphicsRect.right) || (paramInt4 != this.jdField_a_of_type_AndroidGraphicsRect.bottom - 25))
    {
      this.jdField_a_of_type_AndroidGraphicsRect.left = paramInt1;
      this.jdField_a_of_type_AndroidGraphicsRect.right = paramInt3;
      this.jdField_a_of_type_AndroidGraphicsRect.top = (paramInt2 - 25);
      this.jdField_a_of_type_AndroidGraphicsRect.bottom = (paramInt4 + 25);
      ((View)getParent()).setTouchDelegate(this.jdField_a_of_type_AndroidViewTouchDelegate);
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!super.isEnabled()) {
      return false;
    }
    int i1 = paramMotionEvent.getPointerCount();
    int i2 = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getX();
    switch (i2)
    {
    }
    for (;;)
    {
      return true;
      if (QLog.isColorLevel()) {
        QLog.d("TCProgressBar", 2, "onTouchEvent:action=ACTION_DOWN count=" + i1 + " X=" + f1);
      }
      this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
      this.jdField_b_of_type_Float = paramMotionEvent.getX();
      this.j = this.jdField_a_of_type_JavaUtilArrayList.size();
      this.jdField_b_of_type_Boolean = false;
      if (this.jdField_a_of_type_Ute.a(f1))
      {
        this.jdField_a_of_type_Ute.a(paramMotionEvent);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("TCProgressBar", 2, "onTouchEvent:action=ACTION_MOVE count=" + i1 + " X=" + f1);
        }
        if (this.jdField_a_of_type_Ute.jdField_b_of_type_Boolean)
        {
          this.jdField_a_of_type_Ute.a(paramMotionEvent);
          if (this.jdField_a_of_type_Ute.c())
          {
            i2 = this.jdField_a_of_type_Ute.a();
            if (this.jdField_a_of_type_Ute.f < 0)
            {
              i1 = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
              while (i1 >= 0)
              {
                paramMotionEvent = (utg)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
                if (!paramMotionEvent.b(i2)) {
                  break;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("TCProgressBar", 2, "onTouchEvent:checkDelBounds=true");
                }
                this.jdField_a_of_type_JavaUtilArrayList.remove(i1);
                paramMotionEvent.jdField_b_of_type_Boolean = true;
                this.jdField_b_of_type_JavaUtilArrayList.add(paramMotionEvent);
                i1 -= 1;
              }
            }
            i1 = this.jdField_b_of_type_JavaUtilArrayList.size() - 1;
            while (i1 >= 0)
            {
              paramMotionEvent = (utg)this.jdField_b_of_type_JavaUtilArrayList.get(i1);
              if (!paramMotionEvent.c(i2)) {
                break;
              }
              if (QLog.isColorLevel()) {
                QLog.d("TCProgressBar", 2, "onTouchEvent:checkRecorverBounds=true");
              }
              this.jdField_b_of_type_JavaUtilArrayList.remove(i1);
              paramMotionEvent.jdField_b_of_type_Boolean = false;
              this.jdField_a_of_type_JavaUtilArrayList.add(paramMotionEvent);
              i1 -= 1;
            }
            invalidate();
            continue;
            if (QLog.isColorLevel()) {
              QLog.d("TCProgressBar", 2, "onTouchEvent:action=ACTION_UP count=" + i1 + " X=" + f1);
            }
            if (this.jdField_a_of_type_Ute.jdField_b_of_type_Boolean)
            {
              this.jdField_a_of_type_Ute.a(paramMotionEvent);
              if (this.jdField_a_of_type_Ute.a(f1))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("TCProgressBar", 2, "onTouchEvent:action=ACTION_UP[checkBounds:true] count=" + i1 + " X=" + f1);
                }
                if ((SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long < 400L) && (Math.abs(paramMotionEvent.getX() - this.jdField_b_of_type_Float) < 25.0F))
                {
                  i1 = this.jdField_a_of_type_JavaUtilArrayList.size();
                  if (i1 > 0)
                  {
                    paramMotionEvent = (utg)this.jdField_a_of_type_JavaUtilArrayList.remove(i1 - 1);
                    paramMotionEvent.jdField_b_of_type_Boolean = true;
                    this.jdField_b_of_type_JavaUtilArrayList.add(paramMotionEvent);
                    if (QLog.isColorLevel()) {
                      QLog.d("TCProgressBar", 2, "onTouchEvent:action=ACTION_UP progress:[size]=" + this.jdField_a_of_type_JavaUtilArrayList.size() + " deletedList[size]=" + this.jdField_b_of_type_JavaUtilArrayList.size());
                    }
                  }
                }
              }
              if (this.jdField_b_of_type_JavaUtilArrayList.size() > 0) {}
              for (this.jdField_a_of_type_Ute.jdField_a_of_type_Boolean = false;; this.jdField_a_of_type_Ute.jdField_a_of_type_Boolean = true)
              {
                invalidate();
                if (QLog.isColorLevel()) {
                  QLog.d("TCProgressBar", 2, "[@] [...]delete.enabled=" + this.jdField_a_of_type_Ute.e + "delete.changed=" + this.jdField_a_of_type_Ute.d);
                }
                i1 = this.jdField_a_of_type_JavaUtilArrayList.size();
                if (this.j - i1 > 0) {
                  this.jdField_b_of_type_Boolean = true;
                }
                if (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar$DelEvent == null) {
                  break;
                }
                this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar$DelEvent.g(this.jdField_b_of_type_Boolean);
                break;
              }
              if (QLog.isColorLevel()) {
                QLog.d("TCProgressBar", 2, "onTouchEvent:action=ACTION_CANCEL count=" + i1 + " X=" + f1);
              }
              if (this.jdField_a_of_type_Ute.jdField_b_of_type_Boolean)
              {
                this.jdField_a_of_type_Ute.a(paramMotionEvent);
                invalidate();
                if (QLog.isColorLevel()) {
                  QLog.d("TCProgressBar", 2, "[@] [...]delete.enabled=" + this.jdField_a_of_type_Ute.e + "delete.changed=" + this.jdField_a_of_type_Ute.d);
                }
                i1 = this.jdField_a_of_type_JavaUtilArrayList.size();
                if (this.j - i1 > 0) {
                  this.jdField_b_of_type_Boolean = true;
                }
                if (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar$DelEvent != null) {
                  this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetTCProgressBar$DelEvent.g(this.jdField_b_of_type_Boolean);
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void setMax(int paramInt1, int paramInt2)
  {
    this.f = paramInt2;
  }
  
  public void setProgress(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TCProgressBar", 2, "setProgress, progress = " + paramInt + ",isOver = " + paramBoolean);
    }
    if (paramBoolean)
    {
      this.g = this.f;
      this.jdField_a_of_type_Boolean = true;
    }
    for (;;)
    {
      postInvalidate();
      return;
      this.jdField_a_of_type_Boolean = false;
      this.g = paramInt;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\widget\TCProgressBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */