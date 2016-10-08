import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AdapterView;
import com.tencent.widget.EdgeEffect;
import com.tencent.widget.OverScroller;

public class xru
  implements Runnable
{
  private static final int b = 40;
  private int jdField_a_of_type_Int;
  private final OverScroller jdField_a_of_type_ComTencentWidgetOverScroller;
  private final Runnable jdField_a_of_type_JavaLangRunnable;
  
  public xru(AbsListView paramAbsListView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangRunnable = new xrv(this);
    this.jdField_a_of_type_ComTencentWidgetOverScroller = new OverScroller(paramAbsListView.getContext());
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentWidgetAbsListView.ag = -1;
    this.jdField_a_of_type_ComTencentWidgetAbsListView.removeCallbacks(this);
    this.jdField_a_of_type_ComTencentWidgetAbsListView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentWidgetAbsListView.b(0);
    AbsListView.a(this.jdField_a_of_type_ComTencentWidgetAbsListView);
    this.jdField_a_of_type_ComTencentWidgetOverScroller.a();
    if (AbsListView.a(this.jdField_a_of_type_ComTencentWidgetAbsListView) != null) {
      AbsListView.a(this.jdField_a_of_type_ComTencentWidgetAbsListView, AbsListView.b(this.jdField_a_of_type_ComTencentWidgetAbsListView, AbsListView.a(this.jdField_a_of_type_ComTencentWidgetAbsListView)));
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt < 0) {}
    for (int i = Integer.MAX_VALUE;; i = 0)
    {
      this.jdField_a_of_type_Int = i;
      this.jdField_a_of_type_ComTencentWidgetOverScroller.a(0, i, 0, paramInt, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
      this.jdField_a_of_type_ComTencentWidgetAbsListView.ag = 4;
      this.jdField_a_of_type_ComTencentWidgetAbsListView.post(this);
      if (AbsListView.a(this.jdField_a_of_type_ComTencentWidgetAbsListView) == null) {
        AbsListView.a(this.jdField_a_of_type_ComTencentWidgetAbsListView, AbsListView.a(this.jdField_a_of_type_ComTencentWidgetAbsListView, "AbsListView-fling"));
      }
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {}
    for (int i = Integer.MAX_VALUE;; i = 0)
    {
      this.jdField_a_of_type_Int = i;
      this.jdField_a_of_type_ComTencentWidgetOverScroller.a(0, i, 0, paramInt1, paramInt2);
      this.jdField_a_of_type_ComTencentWidgetAbsListView.ag = 4;
      this.jdField_a_of_type_ComTencentWidgetAbsListView.post(this);
      return;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentWidgetAbsListView.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 40L);
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentWidgetOverScroller.a(0, this.jdField_a_of_type_ComTencentWidgetAbsListView.getScrollY(), paramInt, paramInt, paramInt, paramInt))
    {
      this.jdField_a_of_type_ComTencentWidgetAbsListView.ag = 6;
      this.jdField_a_of_type_ComTencentWidgetAbsListView.invalidate();
      this.jdField_a_of_type_ComTencentWidgetAbsListView.post(this);
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetAbsListView.ag = -1;
    this.jdField_a_of_type_ComTencentWidgetAbsListView.b(0);
  }
  
  void c(int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetOverScroller.a(0, this.jdField_a_of_type_ComTencentWidgetAbsListView.getScrollY(), 0, paramInt, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, this.jdField_a_of_type_ComTencentWidgetAbsListView.getHeight());
    this.jdField_a_of_type_ComTencentWidgetAbsListView.ag = 6;
    this.jdField_a_of_type_ComTencentWidgetAbsListView.invalidate();
    this.jdField_a_of_type_ComTencentWidgetAbsListView.post(this);
  }
  
  void d(int paramInt)
  {
    int i = 0;
    if (this.jdField_a_of_type_ComTencentWidgetAbsListView.l) {
      i = this.jdField_a_of_type_ComTencentWidgetAbsListView.l();
    }
    OverScroller localOverScroller = this.jdField_a_of_type_ComTencentWidgetOverScroller;
    int j;
    if (paramInt > 0)
    {
      j = this.jdField_a_of_type_ComTencentWidgetAbsListView.b_;
      localOverScroller.b(paramInt, i, j);
      i = this.jdField_a_of_type_ComTencentWidgetAbsListView.getOverScrollMode();
      if ((i != 0) && ((i != 1) || (AbsListView.b(this.jdField_a_of_type_ComTencentWidgetAbsListView)))) {
        break label159;
      }
      this.jdField_a_of_type_ComTencentWidgetAbsListView.ag = 6;
      i = (int)this.jdField_a_of_type_ComTencentWidgetOverScroller.a();
      if (AbsListView.a(this.jdField_a_of_type_ComTencentWidgetAbsListView) != null)
      {
        if (paramInt <= 0) {
          break label145;
        }
        AbsListView.a(this.jdField_a_of_type_ComTencentWidgetAbsListView).a(i);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetAbsListView.invalidate();
      this.jdField_a_of_type_ComTencentWidgetAbsListView.post(this);
      return;
      j = this.jdField_a_of_type_ComTencentWidgetAbsListView.ar;
      break;
      label145:
      AbsListView.b(this.jdField_a_of_type_ComTencentWidgetAbsListView).a(i);
      continue;
      label159:
      this.jdField_a_of_type_ComTencentWidgetAbsListView.ag = -1;
      if (this.jdField_a_of_type_ComTencentWidgetAbsListView.a != null) {
        this.jdField_a_of_type_ComTencentWidgetAbsListView.a.a();
      }
      if (AbsListView.a(this.jdField_a_of_type_ComTencentWidgetAbsListView) != null) {
        AbsListView.a(this.jdField_a_of_type_ComTencentWidgetAbsListView).b();
      }
    }
  }
  
  public void run()
  {
    int k = 1;
    int i;
    int j;
    switch (this.jdField_a_of_type_ComTencentWidgetAbsListView.ag)
    {
    case 5: 
    default: 
      a();
    case 3: 
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentWidgetOverScroller.a());
    case 4: 
      AdapterView.d("AbsListView.FlingRunable.onfling");
      try
      {
        if (this.jdField_a_of_type_ComTencentWidgetAbsListView.r) {
          this.jdField_a_of_type_ComTencentWidgetAbsListView.v_();
        }
        if ((this.jdField_a_of_type_ComTencentWidgetAbsListView.aG == 0) || (this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildCount() == 0))
        {
          a();
          return;
        }
        Object localObject1 = this.jdField_a_of_type_ComTencentWidgetOverScroller;
        boolean bool = ((OverScroller)localObject1).b();
        int m = ((OverScroller)localObject1).b();
        i = this.jdField_a_of_type_Int - m;
        if (i > 0)
        {
          this.jdField_a_of_type_ComTencentWidgetAbsListView.ab = this.jdField_a_of_type_ComTencentWidgetAbsListView.au;
          localObject1 = this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildAt(0);
          this.jdField_a_of_type_ComTencentWidgetAbsListView.ac = ((View)localObject1).getTop();
        }
        for (i = Math.min(this.jdField_a_of_type_ComTencentWidgetAbsListView.getHeight() - AbsListView.f(this.jdField_a_of_type_ComTencentWidgetAbsListView) - AbsListView.g(this.jdField_a_of_type_ComTencentWidgetAbsListView) - 1, i);; i = Math.max(-(this.jdField_a_of_type_ComTencentWidgetAbsListView.getHeight() - AbsListView.h(this.jdField_a_of_type_ComTencentWidgetAbsListView) - AbsListView.i(this.jdField_a_of_type_ComTencentWidgetAbsListView) - 1), i))
        {
          localObject1 = this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildAt(this.jdField_a_of_type_ComTencentWidgetAbsListView.ab - this.jdField_a_of_type_ComTencentWidgetAbsListView.au);
          if (localObject1 == null) {
            break label598;
          }
          j = ((View)localObject1).getTop();
          if ((!this.jdField_a_of_type_ComTencentWidgetAbsListView.a(i, i)) || (i == 0)) {
            break label603;
          }
          label246:
          if (k == 0) {
            break;
          }
          if (localObject1 != null)
          {
            j = -(i - (((View)localObject1).getTop() - j));
            if ((!this.jdField_a_of_type_ComTencentWidgetAbsListView.l) || (j <= 0))
            {
              i = j;
              if (bool)
              {
                d(j);
                i = this.jdField_a_of_type_ComTencentWidgetOverScroller.b();
              }
              this.jdField_a_of_type_ComTencentWidgetAbsListView.overScrollBy(0, i, 0, this.jdField_a_of_type_ComTencentWidgetAbsListView.getScrollY(), 0, 0, 0, this.jdField_a_of_type_ComTencentWidgetAbsListView.a_, false);
            }
          }
          return;
          j = this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildCount() - 1;
          this.jdField_a_of_type_ComTencentWidgetAbsListView.ab = (this.jdField_a_of_type_ComTencentWidgetAbsListView.au + j);
          localObject1 = this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildAt(j);
          this.jdField_a_of_type_ComTencentWidgetAbsListView.ac = ((View)localObject1).getTop();
        }
        if ((bool) && (k == 0))
        {
          this.jdField_a_of_type_ComTencentWidgetAbsListView.invalidate();
          this.jdField_a_of_type_Int = m;
          this.jdField_a_of_type_ComTencentWidgetAbsListView.post(this);
        }
        for (;;)
        {
          return;
          a();
        }
        try
        {
          localOverScroller = this.jdField_a_of_type_ComTencentWidgetOverScroller;
          if (localOverScroller.b())
          {
            j = this.jdField_a_of_type_ComTencentWidgetAbsListView.getScrollY();
            k = localOverScroller.b();
            if (this.jdField_a_of_type_ComTencentWidgetAbsListView.overScrollBy(0, k - j, 0, j, 0, 0, 0, this.jdField_a_of_type_ComTencentWidgetAbsListView.a_, false)) {
              if ((j <= 0) && (k > 0))
              {
                i = 1;
                break label609;
              }
            }
          }
        }
        finally {}
      }
      finally
      {
        AdapterView.D();
      }
    }
    for (;;)
    {
      OverScroller localOverScroller;
      label529:
      k = (int)localOverScroller.a();
      i = k;
      if (j != 0) {
        i = -k;
      }
      localOverScroller.a();
      a(i);
      return;
      i = 0;
      break label609;
      label565:
      j = 0;
      label598:
      label603:
      label609:
      do
      {
        b(0);
        return;
        this.jdField_a_of_type_ComTencentWidgetAbsListView.invalidate();
        this.jdField_a_of_type_ComTencentWidgetAbsListView.post(this);
        return;
        a();
        return;
        j = 0;
        break;
        k = 0;
        break label246;
        if ((j < 0) || (k >= 0)) {
          break label565;
        }
        j = 1;
        if (i != 0) {
          break label529;
        }
      } while (j == 0);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\xru.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */