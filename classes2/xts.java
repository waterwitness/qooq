import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.HorizontalListView;

public class xts
  implements Runnable
{
  private static final int jdField_a_of_type_Int = 2000;
  private static final int b = 1;
  private static final int c = 2;
  private static final int d = 3;
  private static final int e = 4;
  private static final int f = 5;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private final int l;
  private int m;
  
  public xts(HorizontalListView paramHorizontalListView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.l = ViewConfiguration.get(paramHorizontalListView.getContext()).getScaledFadingEdgeLength();
  }
  
  void a()
  {
    this.a.removeCallbacks(this);
  }
  
  public void a(int paramInt)
  {
    a(paramInt, 0);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    a();
    if (HorizontalListView.a(this.a)) {
      this.a.jdField_a_of_type_JavaLangRunnable = new xtt(this, paramInt1, paramInt2);
    }
    int i1;
    do
    {
      return;
      i1 = this.a.getChildCount();
    } while (i1 == 0);
    int n;
    int i2;
    if (!this.a.i)
    {
      n = this.a.l;
      i1 = i1 + n - 1;
      i2 = Math.max(0, Math.min(this.a.jdField_a_of_type_AndroidWidgetListAdapter.getCount() - 1, paramInt1));
      if (i2 >= n) {
        break label158;
      }
      paramInt1 = n - i2 + 1;
      label109:
      if (paramInt1 <= 0) {
        break label186;
      }
    }
    label158:
    label186:
    for (this.k = (paramInt1 / (i1 - n) * 2000);; this.k = 2000)
    {
      this.h = i2;
      b(this.h, paramInt2, this.k);
      return;
      n = this.a.m;
      break;
      if (i2 > i1)
      {
        paramInt1 = i2 - i1 + 1;
        break label109;
      }
      b(i2, 2000);
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    a();
    if (HorizontalListView.a(this.a)) {
      this.a.jdField_a_of_type_JavaLangRunnable = new xtu(this, paramInt1, paramInt2, paramInt3);
    }
    int i1;
    do
    {
      return;
      i1 = this.a.getChildCount();
    } while (i1 == 0);
    int n;
    label135:
    label158:
    float f1;
    if (!this.a.i)
    {
      n = this.a.getPaddingLeft();
      paramInt2 += n;
      this.h = Math.max(0, Math.min(this.a.jdField_a_of_type_AndroidWidgetListAdapter.getCount() - 1, paramInt1));
      this.m = paramInt2;
      this.i = -1;
      this.j = -1;
      this.g = 5;
      if (this.a.i) {
        break label201;
      }
      paramInt1 = this.a.l;
      n = paramInt1 + i1 - 1;
      if (this.h >= paramInt1) {
        break label212;
      }
      paramInt1 -= this.h;
      f1 = paramInt1 / i1;
      if (f1 >= 1.0F) {
        break label293;
      }
    }
    for (;;)
    {
      this.k = paramInt3;
      this.j = -1;
      a(this);
      return;
      n = this.a.getPaddingRight();
      break;
      label201:
      paramInt1 = this.a.m;
      break label135;
      label212:
      if (this.h > n)
      {
        paramInt1 = this.h - n;
        break label158;
      }
      View localView = this.a.getChildAt(this.h - paramInt1);
      if (!this.a.i) {}
      for (paramInt1 = -localView.getLeft();; paramInt1 = this.a.getWidth() - localView.getRight())
      {
        this.a.c(paramInt1 - paramInt2, paramInt3);
        return;
      }
      label293:
      paramInt3 = (int)(paramInt3 / f1);
    }
  }
  
  void a(Runnable paramRunnable)
  {
    try
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        this.a.postOnAnimation(paramRunnable);
        return;
      }
      this.a.post(this);
      return;
    }
    catch (Exception paramRunnable)
    {
      paramRunnable.printStackTrace();
    }
  }
  
  void b(int paramInt1, int paramInt2)
  {
    b(paramInt1, 0, paramInt2);
  }
  
  void b(int paramInt1, int paramInt2, int paramInt3)
  {
    int n = this.a.l;
    int i1 = this.a.getChildCount();
    View localView = this.a.getChildAt(0);
    if ((paramInt1 < n) || (paramInt1 > i1 + n - 1)) {}
    for (paramInt1 = (paramInt1 - n) * (this.a.getChildAt(1).getLeft() - localView.getLeft()) + localView.getLeft(); paramInt1 == 0; paramInt1 = this.a.getChildAt(paramInt1 - n).getLeft() - Math.abs(localView.getLeft())) {
      return;
    }
    this.a.c(-(paramInt1 + paramInt2), paramInt3);
  }
  
  public void run()
  {
    this.a.getHeight();
    if (!this.a.i) {}
    for (int i1 = this.a.l;; i1 = this.a.m) {
      switch (this.g)
      {
      default: 
        return;
      }
    }
    if (this.j == i1)
    {
      a(this);
      return;
    }
    this.j = i1;
    int i4 = this.a.getChildCount();
    int i2 = this.h;
    int i3 = i1 + i4 - 1;
    int n = 0;
    float f1;
    if (i2 < i1)
    {
      n = i1 - i2 + 1;
      f1 = Math.min(Math.abs(n / i4), 1.0F);
      if (this.a.i) {
        break label228;
      }
    }
    float f2;
    label228:
    for (n = 1;; n = -1)
    {
      f1 = n * f1;
      if (i2 >= i1) {
        break label234;
      }
      n = (int)(this.a.getWidth() * f1);
      f2 = this.k;
      i1 = (int)(Math.abs(f1) * f2);
      this.a.c(n, i1);
      a(this);
      return;
      if (i2 <= i3) {
        break;
      }
      n = i2 - i3;
      break;
    }
    label234:
    if (i2 > i3)
    {
      n = (int)(-this.a.getWidth() * f1);
      f2 = this.k;
      i1 = (int)(Math.abs(f1) * f2);
      this.a.c(n, i1);
      a(this);
      return;
    }
    View localView = this.a.getChildAt(i2 - i1);
    if (!this.a.i) {}
    for (n = -localView.getLeft();; n = this.a.getWidth() - localView.getRight())
    {
      n -= this.m;
      i1 = (int)(this.k * (Math.abs(n) / this.a.getWidth()));
      this.a.c(n, i1);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */