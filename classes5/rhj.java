import android.os.SystemClock;
import android.view.View;
import com.tencent.mobileqq.emosm.view.DragSortListView;
import com.tencent.mobileqq.emosm.view.DragSortListView.DragScrollProfile;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class rhj
  implements Runnable
{
  public static final int a = -1;
  public static final int b = 0;
  public static final int c = 1;
  private float jdField_a_of_type_Float;
  private long jdField_a_of_type_Long;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  private long c;
  private int d;
  private int e;
  private int f;
  private int g;
  
  public rhj(DragSortListView paramDragSortListView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a()
  {
    if (this.jdField_b_of_type_Boolean) {
      return this.e;
    }
    return -1;
  }
  
  public void a(int paramInt)
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_Boolean = true;
      this.c = SystemClock.uptimeMillis();
      this.jdField_a_of_type_Long = this.c;
      this.e = paramInt;
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.post(this);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.removeCallbacks(this);
      this.jdField_b_of_type_Boolean = false;
      return;
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = false;
      return;
    }
    int j = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.s();
    int i = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.t();
    int m = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.d_();
    int k = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getPaddingTop();
    int n = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getHeight() - k - this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getPaddingBottom();
    int i1 = Math.min(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.n, this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.jdField_a_of_type_Int + this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.m);
    int i2 = Math.max(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.n, this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.jdField_a_of_type_Int - this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.m);
    View localView;
    if (this.e == 0)
    {
      localView = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getChildAt(0);
      if (localView == null)
      {
        this.jdField_b_of_type_Boolean = false;
        return;
      }
      if ((j == 0) && (localView.getTop() == k))
      {
        this.jdField_b_of_type_Boolean = false;
        return;
      }
      this.jdField_b_of_type_Float = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DragScrollProfile.a((this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.jdField_b_of_type_Float - i2) / this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.c, this.jdField_a_of_type_Long);
      this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
      this.jdField_a_of_type_Float = ((float)(this.jdField_b_of_type_Long - this.jdField_a_of_type_Long));
      this.d = Math.round(this.jdField_b_of_type_Float * this.jdField_a_of_type_Float);
      if (this.d < 0) {
        break label468;
      }
      this.d = Math.min(n, this.d);
      i = j;
    }
    for (;;)
    {
      localView = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getChildAt(i - j);
      m = localView.getTop() + this.d;
      j = m;
      if (i == 0)
      {
        j = m;
        if (m > k) {
          j = k;
        }
      }
      DragSortListView.a(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView, true);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setSelectionFromTop(i, j - k);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.v_();
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.invalidate();
      DragSortListView.a(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView, false);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.a(i, localView, false);
      this.jdField_a_of_type_Long = this.jdField_b_of_type_Long;
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.post(this);
      return;
      localView = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getChildAt(i - j);
      if (localView == null)
      {
        this.jdField_b_of_type_Boolean = false;
        return;
      }
      if ((i == m - 1) && (localView.getBottom() <= n + k))
      {
        this.jdField_b_of_type_Boolean = false;
        return;
      }
      this.jdField_b_of_type_Float = (-this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DragScrollProfile.a((i1 - this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.jdField_a_of_type_Float) / this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.d, this.jdField_a_of_type_Long));
      break;
      label468:
      this.d = Math.max(-n, this.d);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rhj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */