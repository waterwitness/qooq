package com.tencent.mobileqq.lyric.widget;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.lyric.common.TimerTaskManager;
import com.tencent.mobileqq.lyric.common.TimerTaskManager.TimerTaskRunnable;
import com.tencent.mobileqq.lyric.data.Lyric;
import com.tencent.mobileqq.lyric.data.Sentence;
import com.tencent.mobileqq.lyric.util.LyricContext;
import java.util.ArrayList;
import szr;
import szs;
import szt;
import szu;
import szv;
import szw;
import szx;
import szy;
import szz;
import taa;

public class LyricViewController
{
  protected static final int a = 100;
  public static final String a = "task_name_lyric_draw_";
  private static final String jdField_c_of_type_JavaLangString = "ModuleController";
  public long a;
  protected TimerTaskManager.TimerTaskRunnable a;
  protected TimerTaskManager a;
  public Lyric a;
  protected LyricScrollHelper a;
  public LyricViewInternal a;
  private LyricViewScroll.LyricViewScrollListener jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll$LyricViewScrollListener;
  private LyricViewScroll jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll;
  public volatile boolean a;
  public int b;
  protected final String b;
  public volatile boolean b;
  public int c;
  private boolean jdField_c_of_type_Boolean;
  private volatile int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  
  public LyricViewController(LyricView paramLyricView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_JavaLangString = ("task_name_lyric_draw_" + System.currentTimeMillis());
    this.jdField_a_of_type_ComTencentMobileqqLyricCommonTimerTaskManager = LyricContext.a();
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricScrollHelper = new LyricScrollHelper();
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll$LyricViewScrollListener = new szr(this);
    this.jdField_a_of_type_ComTencentMobileqqLyricCommonTimerTaskManager$TimerTaskRunnable = new szt(this);
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll = paramLyricView.a();
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewInternal = paramLyricView.a();
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll.setScrollListener(this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll$LyricViewScrollListener);
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric = this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewInternal.a();
    Lyric localLyric = this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric;
    if ((localLyric == null) || (localLyric.a()) || (this.jdField_a_of_type_Boolean))
    {
      if (this.jdField_a_of_type_Boolean) {
        Log.d("ModuleController", "onRefresh -> is scrolling");
      }
      return;
    }
    int j = (int)(SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long);
    int i = j;
    if (this.jdField_b_of_type_Boolean)
    {
      i = j;
      if (j >= this.jdField_c_of_type_Int) {
        i = this.jdField_c_of_type_Int;
      }
    }
    this.jdField_d_of_type_Int = i;
    b(localLyric.a(i), i);
  }
  
  public int a()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public void a()
  {
    Log.d("ModuleController", "start");
    LyricContext.a().post(new szv(this));
    this.jdField_a_of_type_ComTencentMobileqqLyricCommonTimerTaskManager.a(this.jdField_b_of_type_JavaLangString, 100L, 100L, this.jdField_a_of_type_ComTencentMobileqqLyricCommonTimerTaskManager$TimerTaskRunnable);
    this.jdField_c_of_type_Boolean = true;
  }
  
  public void a(int paramInt)
  {
    b(paramInt);
    a();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Log.d("ModuleController", "startMoment:" + paramInt1 + "  endMoment:" + paramInt2);
    this.jdField_b_of_type_Boolean = true;
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    LyricContext.a().post(new szz(this, paramInt1, paramInt2));
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewInternal != null) {
      this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewInternal.setIndicator(paramBitmap);
    }
  }
  
  public void a(Lyric paramLyric1, Lyric paramLyric2, Lyric paramLyric3)
  {
    Log.v("ModuleController", "setLyric begin");
    LyricContext.a().post(new szu(this, paramLyric3, paramLyric1, paramLyric2));
  }
  
  public void a(LyricScrollHelper.LyricScrollListener paramLyricScrollListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricScrollHelper.a(paramLyricScrollListener);
  }
  
  public void a(LyricView paramLyricView)
  {
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll = paramLyricView.a();
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewInternal = paramLyricView.a();
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll.setScrollListener(this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll$LyricViewScrollListener);
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll != null) && (this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll.getWindowToken() != null)) {
      this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll.post(new szx(this, paramBoolean));
    }
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void b()
  {
    Log.d("ModuleController", "stop");
    this.jdField_a_of_type_ComTencentMobileqqLyricCommonTimerTaskManager.a(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_Long = 0L;
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void b(int paramInt)
  {
    LyricContext.a().post(new szw(this, paramInt));
  }
  
  protected void b(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewInternal != null) && (this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewInternal.getWindowToken() != null)) {
      this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewInternal.post(new taa(this, paramInt1, paramInt2));
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll != null) && (this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll.getWindowToken() != null)) {
      this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll.post(new szs(this));
    }
  }
  
  public void b(LyricScrollHelper.LyricScrollListener paramLyricScrollListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricScrollHelper.b(paramLyricScrollListener);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewScroll.setScrollEnable(paramBoolean);
  }
  
  public boolean b()
  {
    boolean bool = false;
    if (this.jdField_d_of_type_Int >= this.jdField_c_of_type_Int) {
      bool = true;
    }
    return bool;
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqLyricCommonTimerTaskManager.a(this.jdField_b_of_type_JavaLangString);
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_Boolean = false;
    if ((this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric != null) || (this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewInternal != null))
    {
      paramInt = this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewInternal.b(paramInt);
      if ((this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric == null) || (this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric.a())) {
        Log.w("ModuleController", "onScrollStop -> scroll without measured lyric");
      }
    }
    else
    {
      return;
    }
    Log.d("ModuleController", "onScrollStop -> scroll to lineNo：" + paramInt);
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric.a.size()))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric.a.get(paramInt) == null)
      {
        Log.w("ModuleController", "onScrollStop -> current sentence is null");
        return;
      }
      long l2 = ((Sentence)this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric.a.get(paramInt)).jdField_a_of_type_Long;
      Log.d("ModuleController", "onScrollStop -> start time of current sentence：" + l2);
      long l1 = l2;
      if (this.jdField_b_of_type_Boolean)
      {
        if ((this.jdField_b_of_type_Int < 0) || (l2 >= this.jdField_b_of_type_Int)) {
          break label307;
        }
        l1 = this.jdField_b_of_type_Int;
      }
      for (;;)
      {
        Log.d("ModuleController", "onScrollStop -> correct start time：" + l1);
        l2 = l1;
        if (l1 < 0L) {
          l2 = 0L;
        }
        l1 = (l2 / 10L + 1L) * 10L;
        Log.d("ModuleController", "onScrollStop -> output time：" + l1);
        this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricScrollHelper.a(l1);
        if ((this.jdField_c_of_type_Boolean) || (!this.jdField_d_of_type_Boolean)) {
          break;
        }
        b((int)l1);
        return;
        label307:
        l1 = l2;
        if (this.jdField_c_of_type_Int >= 0)
        {
          l1 = l2;
          if (l2 > this.jdField_c_of_type_Int) {
            l1 = this.jdField_c_of_type_Int;
          }
        }
      }
    }
    Log.w("ModuleController", "onScrollStop -> scroll out of lyric scope");
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewInternal != null) {
      this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewInternal.setLeftAlign(paramBoolean);
    }
  }
  
  public void d()
  {
    a(this.jdField_d_of_type_Int);
  }
  
  public void d(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric != null) || (this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewInternal != null))
    {
      paramInt = this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewInternal.a(paramInt);
      if ((this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric == null) || (this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric.a())) {
        Log.w("ModuleController", "onScrolling -> scroll without measured lyric");
      }
    }
    else
    {
      return;
    }
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric.a.size()))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric.a.get(paramInt) == null)
      {
        Log.w("ModuleController", "onScrollStop -> current sentence is null");
        return;
      }
      long l2 = ((Sentence)this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric.a.get(paramInt)).jdField_a_of_type_Long;
      long l1 = l2;
      if (this.jdField_b_of_type_Boolean)
      {
        if ((this.jdField_b_of_type_Int < 0) || (l2 >= this.jdField_b_of_type_Int)) {
          break label179;
        }
        l1 = this.jdField_b_of_type_Int;
      }
      for (;;)
      {
        l2 = l1;
        if (l1 < 0L) {
          l2 = 0L;
        }
        l1 = l2 / 10L;
        this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricScrollHelper.b((l1 + 1L) * 10L);
        return;
        label179:
        l1 = l2;
        if (this.jdField_c_of_type_Int >= 0)
        {
          l1 = l2;
          if (l2 > this.jdField_c_of_type_Int) {
            l1 = this.jdField_c_of_type_Int;
          }
        }
      }
    }
    Log.w("ModuleController", "onScrollStop -> scroll out of lyric scope");
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void e()
  {
    this.jdField_b_of_type_Boolean = false;
    LyricContext.a().post(new szy(this));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\lyric\widget\LyricViewController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */