import android.graphics.Point;
import android.graphics.Rect;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.FastScroller;
import com.tencent.widget.ListView;
import java.util.HashSet;
import java.util.Iterator;

public class xua
  extends xrq
  implements xvo
{
  public xua(ListView paramListView)
  {
    super(paramListView);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = Integer.MAX_VALUE;
    int j = 0;
    if (paramInt3 >= paramInt2) {
      if (i >= paramInt1) {}
    }
    for (;;)
    {
      if (paramInt3 >= 0)
      {
        paramInt1 = 0;
        for (;;)
        {
          if (paramInt1 <= paramInt3)
          {
            this.a.jdField_a_of_type_Xsa.a(this.a.getChildAt(paramInt1), this.a.au + paramInt1);
            paramInt1 += 1;
            continue;
            localObject = this.a.getChildAt(paramInt3);
            int k = i;
            if (i == Integer.MAX_VALUE) {
              k = ((View)localObject).getBottom();
            }
            i = ((View)localObject).getHeight();
            int m = ListView.a(this.a, (View)localObject, this.a.au + paramInt3, k, false, this.a.c.left, paramInt3);
            j += m;
            i = k - (m + i + this.a.aL);
            paramInt3 -= 1;
            break;
          }
        }
        ListView.e(this.a, 0, paramInt3 + 1);
        Object localObject = this.a;
        ((ListView)localObject).au += paramInt3 + 1;
        return 0;
      }
      return j;
      paramInt3 = -1;
    }
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = 0;
    int i = Integer.MIN_VALUE;
    if (paramInt3 <= paramInt4) {
      if (i <= paramInt2) {}
    }
    for (paramInt2 = paramInt3;; paramInt2 = -1)
    {
      if (paramInt2 >= 0)
      {
        paramInt3 = paramInt2;
        for (;;)
        {
          if (paramInt3 < paramInt1)
          {
            this.a.jdField_a_of_type_Xsa.a(this.a.getChildAt(paramInt3), this.a.au + paramInt3);
            paramInt3 += 1;
            continue;
            View localView = this.a.getChildAt(paramInt3);
            int k = i;
            if (i == Integer.MIN_VALUE) {
              k = localView.getTop();
            }
            i = localView.getHeight();
            int m = ListView.a(this.a, localView, this.a.au + paramInt3, k, true, this.a.c.left, paramInt3);
            j += m;
            i = k + (m + i + this.a.aL);
            paramInt3 += 1;
            break;
          }
        }
        ListView.g(this.a, paramInt2, paramInt1 - paramInt2);
        return 0;
      }
      return j;
    }
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if ((paramInt1 > paramInt5) || (paramInt1 < paramInt4)) {
      paramInt4 = -1;
    }
    do
    {
      return paramInt4;
      paramInt4 = paramInt1;
    } while (paramInt1 < paramInt2);
    return paramInt1 + (paramInt3 - paramInt2 + 1);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 < 0) {}
    do
    {
      int i;
      do
      {
        return;
        if (paramInt3 <= 0) {
          break;
        }
        i = -1;
        if (paramInt2 >= 0)
        {
          localObject = this.a.getChildAt(paramInt2);
          if (((View)localObject).getBottom() - paramInt3 < paramInt1)
          {
            this.a.jdField_a_of_type_Xsa.a((View)localObject, this.a.au + paramInt2);
            j = i;
            if (i >= 0) {}
          }
          for (int j = paramInt2;; j = i)
          {
            paramInt2 -= 1;
            i = j;
            break;
            ((View)localObject).offsetTopAndBottom(-paramInt3);
          }
        }
      } while (i < 0);
      ListView.f(this.a, 0, i + 1);
      Object localObject = this.a;
      ((ListView)localObject).au = (i + 1 + ((ListView)localObject).au);
      return;
    } while (paramInt3 >= 0);
    this.a.d(false);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt4 > 0)
    {
      i = -1;
      if (paramInt3 < paramInt1)
      {
        localView = this.a.getChildAt(paramInt3);
        if (localView.getTop() + paramInt4 > paramInt2)
        {
          this.a.jdField_a_of_type_Xsa.a(localView, this.a.au + paramInt3);
          j = i;
          if (i >= 0) {}
        }
        for (j = paramInt3;; j = i)
        {
          paramInt3 += 1;
          i = j;
          break;
          localView.offsetTopAndBottom(paramInt4);
        }
      }
      if (i >= 0) {
        ListView.h(this.a, i, paramInt1 - i);
      }
    }
    while (paramInt4 >= 0)
    {
      int i;
      View localView;
      int j;
      return;
    }
    while (paramInt3 < paramInt1)
    {
      this.a.getChildAt(paramInt3).offsetTopAndBottom(paramInt4);
      paramInt3 += 1;
    }
    this.a.d(true);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    int i = 0;
    int j = 0;
    View localView;
    Object localObject;
    if (paramBoolean)
    {
      paramInt2 = j;
      while (paramInt2 < paramInt1)
      {
        localView = this.a.getChildAt(paramInt2);
        localObject = new AlphaAnimation(0.0F, 1.0F);
        ((AlphaAnimation)localObject).setDuration(this.a.d());
        localView.setAnimation((Animation)localObject);
        paramInt2 += 1;
      }
    }
    while (i <= paramInt2)
    {
      localView = this.a.getChildAt(i);
      localObject = new TranslateAnimation(0.0F, 0.0F, paramInt3, 0.0F);
      ((TranslateAnimation)localObject).setDuration(this.a.d());
      localView.setAnimation((Animation)localObject);
      i += 1;
    }
    paramInt2 += 1;
    while (paramInt2 < paramInt1)
    {
      localView = this.a.getChildAt(paramInt2);
      localObject = new TranslateAnimation(0.0F, 0.0F, paramInt4, 0.0F);
      ((TranslateAnimation)localObject).setDuration(this.a.d());
      localView.setAnimation((Animation)localObject);
      paramInt2 += 1;
    }
  }
  
  private int b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if ((paramInt1 > paramInt5) || (paramInt1 < paramInt4)) {
      paramInt4 = -1;
    }
    do
    {
      return paramInt4;
      paramInt4 = paramInt1;
    } while (paramInt1 < paramInt2);
    if (paramInt1 <= paramInt3) {
      return -1;
    }
    return paramInt1 - (paramInt3 - paramInt2 + 1);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int k;
    int n;
    int i3;
    int i;
    label286:
    int j;
    int m;
    label431:
    label469:
    label484:
    Object localObject;
    if ((paramInt1 == 0) && (this.a.aG > 0))
    {
      System.nanoTime();
      if (paramInt2 < paramInt1) {
        throw new IllegalArgumentException("lastRow must more than firstRow!");
      }
      if ((paramInt1 < 0) || (paramInt1 > this.a.aG - this.a.m() - this.a.n())) {
        throw new IllegalArgumentException("row index out of bound");
      }
      if ((this.a.p) || (this.a.r)) {
        onChanged();
      }
      int i1;
      int i2;
      do
      {
        do
        {
          return;
        } while (this.a.aG == 0);
        k = paramInt1 + this.a.m();
        paramInt2 += this.a.m();
        n = paramInt2 - k + 1;
        i3 = this.a.getChildCount();
        i1 = this.a.au;
        i2 = this.a.au + i3 - 1;
        if (k == this.a.aG)
        {
          paramInt1 = 1;
          if (this.a.jdField_a_of_type_ComTencentWidgetFastScroller != null) {
            this.a.jdField_a_of_type_ComTencentWidgetFastScroller.a(this.a.aG, this.a.aG - n);
          }
          this.a.aG += n;
          if (this.a.aF < 0) {
            break label431;
          }
          i = a(this.a.aF, k, paramInt2, i1, i2);
          this.a.h(i);
          this.a.i(i);
          if (this.a.ab >= 0) {
            this.a.ab = a(this.a.ab, k, paramInt2, i1, i2);
          }
          if (this.a.jdField_a_of_type_AndroidUtilSparseBooleanArray != null) {
            break label469;
          }
        }
        for (i = 0;; i = this.a.jdField_a_of_type_AndroidUtilSparseBooleanArray.size())
        {
          if (i <= 0) {
            break label484;
          }
          j = 0;
          while (j < i)
          {
            m = this.a.jdField_a_of_type_AndroidUtilSparseBooleanArray.keyAt(j);
            boolean bool = this.a.jdField_a_of_type_AndroidUtilSparseBooleanArray.valueAt(j);
            if (m >= k)
            {
              this.a.jdField_a_of_type_AndroidUtilSparseBooleanArray.delete(m);
              this.a.jdField_a_of_type_AndroidUtilSparseBooleanArray.put(m + (paramInt2 - k + 1), bool);
            }
            j += 1;
          }
          paramInt1 = 0;
          break;
          if (this.a.V < 0) {
            break label286;
          }
          this.a.aF = a(this.a.V, k, paramInt2, i1, i2);
          break label286;
        }
        if (ListView.a(this.a) != null)
        {
          i = 0;
          while (i < ListView.a(this.a).length)
          {
            j = ListView.a(this.a)[i];
            if (j >= k) {
              ListView.a(this.a)[i] = (j + (paramInt2 - k + 1));
            }
            i += 1;
          }
        }
        m = ListView.a(this.a) - ListView.b(this.a) - this.a.c.bottom;
        i3 = this.a.getChildAt(i3 - 1).getBottom();
        if ((this.a.p() == 1) && (paramInt1 != 0) && (i3 <= m)) {}
        for (i = 1; (k <= i1) && (i == 0) && (i3 >= m); i = 0)
        {
          localObject = this.a;
          ((ListView)localObject).au += n;
          return;
        }
      } while ((k > i2) && (i == 0) && (i3 >= m));
      n = this.a.c.top;
      if (this.a.aF >= 0)
      {
        paramInt1 = this.a.aF;
        j = k - i1;
        if (i == 0) {
          break label949;
        }
        paramInt1 = 0;
        i = m;
        label735:
        if (paramInt2 < k) {
          break label1658;
        }
        if (i >= n) {
          break label826;
        }
        paramInt2 += 1;
      }
    }
    for (;;)
    {
      if (paramInt2 >= 0)
      {
        paramInt1 = 0;
        for (;;)
        {
          if (paramInt1 <= j - 1)
          {
            this.a.jdField_a_of_type_Xsa.a(this.a.getChildAt(paramInt1), this.a.au + paramInt1);
            paramInt1 += 1;
            continue;
            if (this.a.o())
            {
              paramInt1 = this.a.V;
              break;
            }
            paramInt1 = -1;
            break;
            label826:
            localObject = this.a.a(paramInt2, this.a.jdField_a_of_type_ArrayOfBoolean);
            ListView.a(this.a, (View)localObject, paramInt2, i, false, this.a.c.left, false, this.a.jdField_a_of_type_ArrayOfBoolean[0], j);
            m = ((View)localObject).getHeight() + this.a.aL;
            i -= m;
            paramInt2 -= 1;
            paramInt1 = m + paramInt1;
            break label735;
          }
        }
        ListView.a(this.a, 0, j);
        this.a.au = paramInt2;
      }
      for (;;)
      {
        ListView.a(this.a);
        return;
        a(n, j - 1, paramInt1);
        continue;
        label949:
        if (((paramInt1 < 0) || (paramInt1 >= k)) && ((paramInt1 >= 0) || (this.a.i))) {
          break label1234;
        }
        i = 0;
        n = -1;
        if (j <= 0) {
          break;
        }
        paramInt1 = this.a.getChildAt(j - 1).getBottom() + this.a.aL;
        j = k;
        k = paramInt1;
        for (;;)
        {
          paramInt1 = n;
          if (j <= paramInt2)
          {
            if (k > m) {
              paramInt1 = j - this.a.au;
            }
          }
          else
          {
            j = this.a.getChildCount();
            if (paramInt1 < 0) {
              break label1205;
            }
            paramInt2 = paramInt1;
            while (paramInt2 < j)
            {
              this.a.jdField_a_of_type_Xsa.a(this.a.getChildAt(paramInt2), this.a.au + paramInt2);
              paramInt2 += 1;
            }
          }
          localObject = this.a.a(j, this.a.jdField_a_of_type_ArrayOfBoolean);
          ListView.a(this.a, (View)localObject, j, k, true, this.a.c.left, false, this.a.jdField_a_of_type_ArrayOfBoolean[0], j - this.a.au);
          paramInt1 = ((View)localObject).getHeight() + this.a.aL;
          k += paramInt1;
          i += paramInt1;
          j += 1;
        }
        ListView.b(this.a, paramInt1, j - paramInt1);
        continue;
        label1205:
        a(this.a.getChildCount(), m, paramInt2 - this.a.au + 1, i);
      }
      label1234:
      if (m > i3) {
        this.a.offsetChildrenTopAndBottom(m - i3);
      }
      i = this.a.getChildAt(j).getTop() - this.a.aL;
      paramInt1 = 0;
      if (paramInt2 >= k) {
        if (i < n) {
          paramInt2 += 1;
        }
      }
      for (;;)
      {
        if (paramInt2 >= 0)
        {
          paramInt1 = 0;
          for (;;)
          {
            if (paramInt1 <= j - 1)
            {
              this.a.jdField_a_of_type_Xsa.a(this.a.getChildAt(paramInt1), this.a.au + paramInt1);
              paramInt1 += 1;
              continue;
              localObject = this.a.a(paramInt2, this.a.jdField_a_of_type_ArrayOfBoolean);
              ListView.a(this.a, (View)localObject, paramInt2, i, false, this.a.c.left, false, this.a.jdField_a_of_type_ArrayOfBoolean[0], j);
              m = ((View)localObject).getHeight() + this.a.aL;
              i -= m;
              paramInt2 -= 1;
              paramInt1 = m + paramInt1;
              break;
            }
          }
          ListView.c(this.a, 0, j);
          this.a.au = paramInt2;
          break;
        }
        a(n, j - 1, paramInt1);
        break;
        if (ListView.a(this.a) == null)
        {
          localObject = new int[paramInt2 - paramInt1 + 1];
          j = 0;
          i = paramInt1;
          paramInt1 = j;
          while (i <= paramInt2)
          {
            localObject[paramInt1] = i;
            i += 1;
            paramInt1 += 1;
          }
          ListView.a(this.a, (int[])localObject);
        }
        for (;;)
        {
          onChanged();
          return;
          localObject = new HashSet();
          while (paramInt1 <= paramInt2)
          {
            ((HashSet)localObject).add(Integer.valueOf(paramInt1));
            paramInt1 += 1;
          }
          int[] arrayOfInt = ListView.a(this.a);
          paramInt2 = arrayOfInt.length;
          paramInt1 = 0;
          while (paramInt1 < paramInt2)
          {
            ((HashSet)localObject).add(Integer.valueOf(arrayOfInt[paramInt1]));
            paramInt1 += 1;
          }
          arrayOfInt = new int[((HashSet)localObject).size()];
          localObject = ((HashSet)localObject).iterator();
          paramInt1 = 0;
          while (((Iterator)localObject).hasNext())
          {
            arrayOfInt[paramInt1] = ((Integer)((Iterator)localObject).next()).intValue();
            paramInt1 += 1;
          }
          ListView.a(this.a, arrayOfInt);
        }
        paramInt2 = -1;
      }
      label1658:
      paramInt2 = -1;
    }
  }
  
  public void a(int... paramVarArgs)
  {
    onChanged();
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    System.nanoTime();
    if (paramInt2 < paramInt1) {
      throw new IllegalArgumentException("lastRow must more than firstRow!");
    }
    if ((paramInt1 < 0) || (paramInt2 >= this.a.aG - this.a.m() - this.a.n())) {
      throw new IllegalArgumentException("row index out of bound");
    }
    if ((this.a.p) || (this.a.r)) {
      onChanged();
    }
    int n;
    int i2;
    int i1;
    int i3;
    boolean bool1;
    int m;
    int k;
    int j;
    int i;
    label473:
    label487:
    label552:
    label640:
    label643:
    Object localObject;
    label711:
    label720:
    label755:
    do
    {
      int i4;
      do
      {
        return;
        n = paramInt1 + this.a.m();
        i2 = paramInt2 + this.a.m();
        paramInt1 = i2 - n + 1;
        i4 = this.a.getChildCount();
        i1 = this.a.au;
        i3 = this.a.au + i4 - 1;
        if (this.a.jdField_a_of_type_ComTencentWidgetFastScroller != null) {
          this.a.jdField_a_of_type_ComTencentWidgetFastScroller.a(this.a.aG, this.a.aG - paramInt1);
        }
        this.a.aG -= paramInt1;
        if (this.a.aF >= 0)
        {
          paramInt1 = b(this.a.aF, n, i2, i1, i3);
          this.a.h(paramInt1);
          this.a.i(paramInt1);
          if (this.a.ab >= 0) {
            this.a.ab = b(this.a.ab, n, i2, i1, i3);
          }
          if (this.a.jdField_a_of_type_AndroidUtilSparseBooleanArray != null) {
            break label473;
          }
        }
        for (paramInt2 = 0;; paramInt2 = this.a.jdField_a_of_type_AndroidUtilSparseBooleanArray.size())
        {
          if (paramInt2 <= 0) {
            break label487;
          }
          paramInt1 = 0;
          while (paramInt1 < paramInt2)
          {
            int i5 = this.a.jdField_a_of_type_AndroidUtilSparseBooleanArray.keyAt(paramInt1);
            bool1 = this.a.jdField_a_of_type_AndroidUtilSparseBooleanArray.valueAt(paramInt1);
            m = paramInt1;
            k = paramInt2;
            if (i5 >= n)
            {
              this.a.jdField_a_of_type_AndroidUtilSparseBooleanArray.delete(i5);
              j = paramInt1;
              i = paramInt2;
              if (i5 <= i2)
              {
                j = paramInt1 - 1;
                i = paramInt2 - 1;
              }
              m = j;
              k = i;
              if (i5 > i2)
              {
                this.a.jdField_a_of_type_AndroidUtilSparseBooleanArray.put(i5 - (i2 - n + 1), bool1);
                k = i;
                m = j;
              }
            }
            paramInt1 = m + 1;
            paramInt2 = k;
          }
          if (this.a.V < 0) {
            break;
          }
          this.a.aF = b(this.a.V, n, i2, i1, i3);
          break;
        }
        if (ListView.a(this.a) != null)
        {
          paramInt1 = 0;
          if (paramInt1 < ListView.a(this.a).length)
          {
            paramInt2 = ListView.a(this.a)[paramInt1];
            if (paramInt2 >= n)
            {
              if (paramInt2 > i2) {
                break label552;
              }
              paramInt2 = -1;
            }
            for (;;)
            {
              ListView.a(this.a)[paramInt1] = paramInt2;
              paramInt1 += 1;
              break;
              paramInt2 -= i2 - n + 1;
            }
          }
        }
      } while ((i2 < i1) || (n > i3));
      m = this.a.c.top;
      k = ListView.c(this.a) - ListView.d(this.a) - this.a.c.bottom;
      if (n < i1)
      {
        paramInt1 = 0;
        if (i2 <= i3) {
          break label711;
        }
        paramInt2 = i4 - 1;
        i = 0;
        if (i >= i4) {
          break label755;
        }
        localObject = this.a.getChildAt(i);
        if ((i < paramInt1) || (i > paramInt2)) {
          break label720;
        }
        this.a.jdField_a_of_type_Xsa.a((View)localObject, i);
        ((View)localObject).setTag(2131230829, null);
      }
      for (;;)
      {
        i += 1;
        break label643;
        paramInt1 = n - i1;
        break;
        paramInt2 = i2 - i1;
        break label640;
        if (ListView.a(this.a)) {
          ((View)localObject).setTag(2131230829, new Point(((View)localObject).getTop(), ((View)localObject).getBottom()));
        }
      }
      ListView.d(this.a, paramInt1, paramInt2 - paramInt1 + 1);
    } while (this.a.aG == 0);
    paramInt2 = this.a.getChildCount();
    boolean bool2 = this.a.o();
    if (this.a.aF >= 0)
    {
      j = this.a.aF;
      if (QLog.isColorLevel()) {
        QLog.d("XListView", 2, "first is:" + n + ",last is:" + i2 + ",firstPosition is:" + i1 + ",lastPosition is:" + i3 + ",newSelectionPosition is:" + j + ",mStackFromBottom is:" + this.a.i);
      }
      if ((n > i1) || (i2 < i3)) {
        break label1172;
      }
      if (this.a.i) {
        break label1139;
      }
      paramInt1 = n;
      if (n > this.a.aG - 1) {
        paramInt1 = this.a.aG - 1;
      }
      ListView.a(this.a, paramInt1, m);
      bool1 = true;
      paramInt1 = -1;
      i = 0;
      paramInt2 = 0;
    }
    for (;;)
    {
      k = this.a.getChildCount();
      if ((j >= 0) && (j < k) && (bool2)) {
        this.a.a(j, this.a.getChildAt(j - this.a.au));
      }
      if (QLog.isColorLevel()) {
        QLog.d("XListView", 2, "upItemsMaxIndex is:" + paramInt1 + ",upItemsMoveDistance is:" + paramInt2 + ",downItemsMoveDistance is:" + i);
      }
      if (ListView.a(this.a)) {
        a(k, paramInt1, paramInt2, i, bool1);
      }
      this.a.invalidate();
      return;
      if (bool2)
      {
        j = this.a.V;
        break;
      }
      j = -1;
      break;
      label1139:
      localObject = this.a;
      if (n - 1 < 0) {}
      for (paramInt1 = 0;; paramInt1 = n - 1)
      {
        ListView.b((ListView)localObject, paramInt1, k);
        break;
      }
      label1172:
      if (n <= i1)
      {
        if ((this.a.i) || (j >= 0))
        {
          this.a.au = n;
          localObject = this.a.getChildAt(paramInt1);
          paramInt2 = ((View)localObject).getTop();
          this.a.d(false);
          ListView.a(this.a);
          paramInt1 = ((View)localObject).getTop();
          i = paramInt2 - paramInt1;
          if (paramInt1 - this.a.aL > 0) {}
          for (paramInt1 = -paramInt1 + this.a.aL;; paramInt1 = 0)
          {
            k = this.a.indexOfChild((View)localObject) - 1;
            paramInt2 = paramInt1;
            bool1 = false;
            paramInt1 = k;
            break;
          }
        }
        localObject = this.a.getChildAt(0);
        paramInt2 = ((View)localObject).getTop();
        this.a.offsetChildrenTopAndBottom(m - ((View)localObject).getTop());
        this.a.au = n;
        this.a.d(true);
        ListView.a(this.a);
        if (((View)localObject).getTop() - this.a.aL > 0) {}
        for (paramInt1 = -((View)localObject).getTop() + this.a.aL;; paramInt1 = 0)
        {
          i = paramInt2 - ((View)localObject).getTop();
          k = this.a.indexOfChild((View)localObject);
          paramInt2 = paramInt1;
          bool1 = false;
          paramInt1 = k;
          break;
        }
      }
      if (i2 >= i3)
      {
        if ((!this.a.i) || (j >= 0))
        {
          localObject = this.a.getChildAt(paramInt2 - 1);
          paramInt2 = ((View)localObject).getBottom();
          this.a.d(true);
          ListView.a(this.a);
          paramInt1 = ((View)localObject).getBottom();
          paramInt2 -= paramInt1;
          if (k - paramInt1 - this.a.aL > 0) {}
          for (paramInt1 = k - paramInt1 - this.a.aL;; paramInt1 = 0)
          {
            k = this.a.indexOfChild((View)localObject);
            i = paramInt1;
            bool1 = false;
            paramInt1 = k;
            break;
          }
        }
        localObject = this.a.getChildAt(paramInt2 - 1);
        paramInt2 = ((View)localObject).getTop();
        this.a.offsetChildrenTopAndBottom(k - ((View)localObject).getBottom());
        this.a.d(false);
        ListView.a(this.a);
        if (k - ((View)localObject).getBottom() - this.a.aL > 0) {}
        for (paramInt1 = k - ((View)localObject).getBottom() - this.a.aL;; paramInt1 = 0)
        {
          paramInt2 -= ((View)localObject).getTop();
          k = this.a.indexOfChild((View)localObject);
          i = paramInt1;
          bool1 = false;
          paramInt1 = k;
          break;
        }
      }
      View localView;
      if (((j >= 0) && (j < n)) || ((j < 0) && (!this.a.i)))
      {
        localObject = this.a.getChildAt(paramInt1 - 1);
        k = ((View)localObject).getTop();
        localView = this.a.getChildAt(paramInt1);
        i = localView.getTop();
        m = localView.getTop();
        i2 = ((View)localObject).getBottom();
        paramInt1 = n - i1;
        while (paramInt1 < paramInt2)
        {
          this.a.getChildAt(paramInt1).offsetTopAndBottom(-(m - i2) + this.a.aL);
          paramInt1 += 1;
        }
        this.a.d(true);
        ListView.a(this.a);
        m = localView.getTop();
        paramInt2 = k - ((View)localObject).getTop();
        paramInt1 = this.a.indexOfChild((View)localObject);
        i -= m;
        bool1 = false;
      }
      else if ((j >= n) || ((j < 0) && (this.a.i)))
      {
        localObject = this.a.getChildAt(paramInt1 - 1);
        paramInt2 = ((View)localObject).getTop();
        localView = this.a.getChildAt(paramInt1);
        i = localView.getTop();
        k = localView.getTop();
        m = this.a.getChildAt(paramInt1 - 1).getBottom();
        paramInt1 = 0;
        while (paramInt1 < n - i1)
        {
          this.a.getChildAt(paramInt1).offsetTopAndBottom(k - m - this.a.aL);
          paramInt1 += 1;
        }
        this.a.d(false);
        ListView.a(this.a);
        k = localView.getTop();
        paramInt2 -= ((View)localObject).getTop();
        paramInt1 = this.a.indexOfChild((View)localObject);
        i -= k;
        bool1 = false;
      }
      else
      {
        paramInt1 = -1;
        i = 0;
        paramInt2 = 0;
        bool1 = false;
      }
    }
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    if (paramInt2 < paramInt1) {
      throw new IllegalArgumentException("lastRow must more than firstRow!");
    }
    if ((paramInt1 < this.a.m()) || (paramInt2 >= this.a.aG - this.a.m() - this.a.n())) {
      throw new IllegalArgumentException("row index out of bound. insert range: " + paramInt1 + "~" + paramInt2 + ". valid range: " + this.a.m() + "~" + (this.a.aG - this.a.m() - this.a.n()));
    }
    if ((this.a.p) || (this.a.r)) {
      onChanged();
    }
    int n;
    int i1;
    int j;
    int i;
    do
    {
      do
      {
        return;
      } while (this.a.aG == 0);
      n = paramInt1 + this.a.m();
      i1 = paramInt2 + this.a.m();
      j = this.a.getChildCount();
      paramInt1 = this.a.au;
      i = this.a.au + j - 1;
    } while ((i1 < paramInt1) || (n > i));
    int k = this.a.c.top;
    int m = ListView.e(this.a) - ListView.f(this.a) - this.a.c.bottom;
    if (n < paramInt1)
    {
      paramInt2 = 0;
      if (i1 <= i) {
        break label392;
      }
      i = j - 1;
      label297:
      if (this.a.aF < 0) {
        break label400;
      }
      paramInt1 = this.a.aF;
      label315:
      if (((paramInt1 < 0) || (paramInt1 > n)) && ((paramInt1 >= 0) || (this.a.i))) {
        break label426;
      }
      paramInt1 = a(j, m, paramInt2, i);
      ListView.a(this.a, this.a.getChildCount());
      a(j, m, i + 1, paramInt1);
    }
    for (;;)
    {
      ListView.a(this.a);
      return;
      paramInt2 = n - paramInt1;
      break;
      label392:
      i = i1 - paramInt1;
      break label297;
      label400:
      if (this.a.o())
      {
        paramInt1 = this.a.V;
        break label315;
      }
      paramInt1 = -1;
      break label315;
      label426:
      if ((paramInt1 >= i1) || ((paramInt1 < 0) && (this.a.i)))
      {
        paramInt1 = a(k, paramInt2, i);
        ListView.b(this.a, this.a.getChildCount());
        a(k, paramInt2 - 1, paramInt1);
      }
      else
      {
        paramInt1 -= this.a.au;
        a(j, m, i + 1, a(j, m, paramInt1, i));
        a(k, paramInt2 - 1, a(k, paramInt2, paramInt1 - 1));
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\xua.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */