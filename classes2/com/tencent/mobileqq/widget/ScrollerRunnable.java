package com.tencent.mobileqq.widget;

import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.List;
import mqq.os.MqqHandler;
import wog;

public class ScrollerRunnable
  implements Runnable
{
  protected static final String a = "ScrollerRunnable";
  private static final int jdField_b_of_type_Int = 1000;
  private static final int c = 1;
  private static final int d = 2;
  private static final int k = 10;
  int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private boolean jdField_a_of_type_Boolean;
  private boolean jdField_b_of_type_Boolean;
  private int e;
  private int f;
  private int g;
  private int h;
  private final int i;
  private int j;
  private int l;
  
  public ScrollerRunnable(ListView paramListView)
  {
    boolean bool2 = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = true;
    this.j = -1;
    this.jdField_a_of_type_Int = 0;
    this.l = -1;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.i = ViewConfiguration.get(this.jdField_a_of_type_ComTencentWidgetListView.getContext()).getScaledFadingEdgeLength();
    if (DeviceInfoUtil.c() / 1048576L > 512L) {}
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool1;
      return;
      bool1 = false;
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_JavaLangRunnable != null)
    {
      this.jdField_a_of_type_JavaLangRunnable.run();
      this.jdField_a_of_type_JavaLangRunnable = null;
    }
    c();
  }
  
  private void c()
  {
    int n = this.jdField_a_of_type_ComTencentWidgetListView.s();
    if (this.j < n) {
      return;
    }
    Object localObject;
    int i1;
    int m;
    if ((this.l == 3) && (this.jdField_a_of_type_Long > 0L))
    {
      localObject = this.jdField_a_of_type_ComTencentWidgetListView.a();
      if ((localObject instanceof ChatAdapter1))
      {
        localObject = ((ChatAdapter1)localObject).a();
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          i1 = ((List)localObject).size();
          m = 0;
        }
      }
    }
    for (;;)
    {
      if (m < i1)
      {
        if (((ChatMessage)((List)localObject).get(m)).uniseq == this.jdField_a_of_type_Long) {
          this.j = m;
        }
      }
      else
      {
        localObject = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(this.j - n);
        if (localObject == null) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.i("ScrollerRunnable", 2, "FlushMessageItem:" + localObject.hashCode() + "," + ((View)localObject).getParent());
        }
        ((View)localObject).postDelayed(new wog(this, (View)localObject), 300L);
        return;
      }
      m += 1;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentWidgetListView.removeCallbacks(this);
    this.b = false;
    this.jdField_a_of_type_JavaLangRunnable = null;
  }
  
  public void a(int paramInt)
  {
    a(paramInt, 0, null);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, Runnable paramRunnable)
  {
    this.l = paramInt1;
    a(paramInt2, paramInt3, paramRunnable);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, Runnable paramRunnable, MqqHandler paramMqqHandler)
  {
    this.jdField_a_of_type_MqqOsMqqHandler = paramMqqHandler;
    a(paramInt1, paramInt2, paramInt3, paramRunnable);
  }
  
  public void a(int paramInt1, int paramInt2, Runnable paramRunnable)
  {
    a();
    this.j = paramInt2;
    this.f = paramInt1;
    this.jdField_a_of_type_JavaLangRunnable = paramRunnable;
    this.jdField_a_of_type_ComTencentWidgetListView.post(this);
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void run()
  {
    int m;
    label72:
    int i2;
    if (!this.b)
    {
      this.b = true;
      this.jdField_a_of_type_Int = 0;
      m = this.jdField_a_of_type_ComTencentWidgetListView.s();
      n = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount() + m - 1;
      if (this.f <= m)
      {
        m = m - this.f + 1;
        this.e = 2;
        if (m <= 0) {
          break label230;
        }
        this.h = (1000 / m);
        this.g = -1;
      }
    }
    else
    {
      n = this.jdField_a_of_type_ComTencentWidgetListView.getHeight();
      i2 = this.jdField_a_of_type_ComTencentWidgetListView.s();
      switch (this.e)
      {
      }
    }
    label230:
    View localView;
    label358:
    label486:
    do
    {
      int i1;
      do
      {
        do
        {
          return;
          if (this.f >= n)
          {
            m = this.f - n + 1;
            this.e = 1;
            break;
          }
        } while ((this.l != 15) && (this.l != 8) && (this.l != 10) && (this.l != 4) && (this.l != 17) && (this.l != 11) && (this.l != 13) && (this.l != 14) && (this.l != 3));
        c();
        return;
        this.h = 1000;
        break label72;
        i1 = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount() - 1;
        i2 += i1;
      } while (i1 < 0);
      if (i2 == this.g)
      {
        if (this.jdField_a_of_type_Int > 10)
        {
          this.jdField_a_of_type_ComTencentWidgetListView.setSelection(this.f);
          b();
          return;
        }
        this.jdField_a_of_type_ComTencentWidgetListView.post(this);
        this.jdField_a_of_type_Int += 1;
        return;
      }
      localView = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i1);
      int i3 = localView.getHeight();
      int i4 = localView.getTop();
      if (i2 < this.jdField_a_of_type_ComTencentWidgetListView.d_() - 1)
      {
        m = this.i;
        if (!this.jdField_a_of_type_Boolean) {
          break label486;
        }
        this.jdField_a_of_type_ComTencentWidgetListView.f(m + (i3 - (n - i4)), this.h);
      }
      for (;;)
      {
        this.g = i2;
        if (i2 < this.f) {
          this.jdField_a_of_type_ComTencentWidgetListView.post(this);
        }
        if ((this.l != 15) && (this.l != 8) && (this.l != 10) && (this.l != 4) && (this.l != 17) && (this.l != 11) && (this.l != 3)) {
          break;
        }
        c();
        return;
        m = this.jdField_a_of_type_ComTencentWidgetListView.getPaddingBottom();
        break label358;
        if (i2 < this.f) {
          this.jdField_a_of_type_ComTencentWidgetListView.setSelection(i1);
        }
      }
      if (i2 == this.g)
      {
        if (this.jdField_a_of_type_Int > 10)
        {
          this.jdField_a_of_type_ComTencentWidgetListView.setSelection(this.f);
          b();
          return;
        }
        this.jdField_a_of_type_Int += 1;
        this.jdField_a_of_type_ComTencentWidgetListView.post(this);
        return;
      }
      this.jdField_a_of_type_Int = 0;
      if (i2 <= this.f)
      {
        this.jdField_a_of_type_ComTencentWidgetListView.setSelection(this.f);
        b();
      }
      localView = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(0);
    } while (localView == null);
    int n = localView.getTop();
    if (i2 > this.f)
    {
      m = this.i;
      label622:
      if (!this.jdField_a_of_type_Boolean) {
        break label679;
      }
      this.jdField_a_of_type_ComTencentWidgetListView.f(n - m, this.h);
    }
    for (;;)
    {
      this.g = i2;
      if (i2 <= this.f) {
        break;
      }
      this.jdField_a_of_type_ComTencentWidgetListView.post(this);
      return;
      m = this.jdField_a_of_type_ComTencentWidgetListView.getPaddingTop();
      break label622;
      label679:
      if (i2 > this.f) {
        this.jdField_a_of_type_ComTencentWidgetListView.setSelection(0);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\widget\ScrollerRunnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */