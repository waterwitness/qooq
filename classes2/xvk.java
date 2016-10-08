import android.widget.Scroller;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.VerticalGallery;

public class xvk
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private Scroller jdField_a_of_type_AndroidWidgetScroller;
  private int b;
  
  public xvk(VerticalGallery paramVerticalGallery)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramVerticalGallery.getContext());
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentWidgetVerticalGallery.removeCallbacks(this);
  }
  
  private void b(boolean paramBoolean)
  {
    VerticalGallery.b(this.jdField_a_of_type_ComTencentWidgetVerticalGallery, false);
    this.jdField_a_of_type_AndroidWidgetScroller.forceFinished(true);
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentWidgetVerticalGallery.d();
    }
    this.jdField_a_of_type_ComTencentWidgetVerticalGallery.h();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentWidgetVerticalGallery.aG == 0)
    {
      b(true);
      return;
    }
    VerticalGallery.c(this.jdField_a_of_type_ComTencentWidgetVerticalGallery, false);
    Scroller localScroller = this.jdField_a_of_type_AndroidWidgetScroller;
    boolean bool = localScroller.computeScrollOffset();
    int j = localScroller.getCurrY();
    int i = this.b - j;
    if (i > 0) {
      VerticalGallery.a(this.jdField_a_of_type_ComTencentWidgetVerticalGallery, this.jdField_a_of_type_ComTencentWidgetVerticalGallery.au);
    }
    for (i = Math.min(this.jdField_a_of_type_ComTencentWidgetVerticalGallery.getHeight() - this.jdField_a_of_type_ComTencentWidgetVerticalGallery.getPaddingTop() - this.jdField_a_of_type_ComTencentWidgetVerticalGallery.getPaddingBottom() - 1, i);; i = Math.max(-(this.jdField_a_of_type_ComTencentWidgetVerticalGallery.getHeight() - this.jdField_a_of_type_ComTencentWidgetVerticalGallery.getPaddingBottom() - this.jdField_a_of_type_ComTencentWidgetVerticalGallery.getPaddingTop() - 1), i))
    {
      this.jdField_a_of_type_ComTencentWidgetVerticalGallery.b(i);
      if ((!bool) || (VerticalGallery.b(this.jdField_a_of_type_ComTencentWidgetVerticalGallery))) {
        break;
      }
      this.b = j;
      this.jdField_a_of_type_ComTencentWidgetVerticalGallery.post(this);
      return;
      int k = this.jdField_a_of_type_ComTencentWidgetVerticalGallery.getChildCount();
      VerticalGallery.a(this.jdField_a_of_type_ComTencentWidgetVerticalGallery, k - 1 + this.jdField_a_of_type_ComTencentWidgetVerticalGallery.au);
    }
    b(true);
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    b();
    if (VerticalGallery.a(this.jdField_a_of_type_ComTencentWidgetVerticalGallery))
    {
      if (paramInt < 0) {}
      for (i = Integer.MAX_VALUE;; i = 0)
      {
        this.b = i;
        this.jdField_a_of_type_AndroidWidgetScroller.fling(0, i, 0, paramInt, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
        this.jdField_a_of_type_ComTencentWidgetVerticalGallery.post(this);
        return;
      }
    }
    if (paramInt < 0) {}
    for (int i = Integer.MAX_VALUE;; i = 0)
    {
      this.jdField_a_of_type_Int = i;
      this.jdField_a_of_type_AndroidWidgetScroller.fling(i, 0, paramInt, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
      this.jdField_a_of_type_ComTencentWidgetVerticalGallery.post(this);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentWidgetVerticalGallery.removeCallbacks(this);
    b(paramBoolean);
  }
  
  public void b(int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    if (VerticalGallery.a(this.jdField_a_of_type_ComTencentWidgetVerticalGallery))
    {
      b();
      VerticalGallery.b(this.jdField_a_of_type_ComTencentWidgetVerticalGallery, true);
      this.b = 0;
      this.jdField_a_of_type_AndroidWidgetScroller.startScroll(0, 0, 0, -paramInt, VerticalGallery.a(this.jdField_a_of_type_ComTencentWidgetVerticalGallery));
      this.jdField_a_of_type_ComTencentWidgetVerticalGallery.post(this);
      return;
    }
    b();
    VerticalGallery.b(this.jdField_a_of_type_ComTencentWidgetVerticalGallery, true);
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidWidgetScroller.startScroll(0, 0, -paramInt, 0, VerticalGallery.a(this.jdField_a_of_type_ComTencentWidgetVerticalGallery));
    this.jdField_a_of_type_ComTencentWidgetVerticalGallery.post(this);
  }
  
  public void run()
  {
    if (VerticalGallery.a(this.jdField_a_of_type_ComTencentWidgetVerticalGallery))
    {
      a();
      return;
    }
    if (this.jdField_a_of_type_ComTencentWidgetVerticalGallery.aG == 0)
    {
      b(true);
      return;
    }
    VerticalGallery.c(this.jdField_a_of_type_ComTencentWidgetVerticalGallery, false);
    Scroller localScroller = this.jdField_a_of_type_AndroidWidgetScroller;
    boolean bool = localScroller.computeScrollOffset();
    int j = localScroller.getCurrX();
    int i = this.jdField_a_of_type_Int - j;
    if (i > 0) {
      VerticalGallery.a(this.jdField_a_of_type_ComTencentWidgetVerticalGallery, this.jdField_a_of_type_ComTencentWidgetVerticalGallery.au);
    }
    for (i = Math.min(this.jdField_a_of_type_ComTencentWidgetVerticalGallery.getWidth() - this.jdField_a_of_type_ComTencentWidgetVerticalGallery.getPaddingLeft() - this.jdField_a_of_type_ComTencentWidgetVerticalGallery.getPaddingRight() - 1, i);; i = Math.max(-(this.jdField_a_of_type_ComTencentWidgetVerticalGallery.getWidth() - this.jdField_a_of_type_ComTencentWidgetVerticalGallery.getPaddingRight() - this.jdField_a_of_type_ComTencentWidgetVerticalGallery.getPaddingLeft() - 1), i))
    {
      this.jdField_a_of_type_ComTencentWidgetVerticalGallery.a(i);
      if ((!bool) || (VerticalGallery.b(this.jdField_a_of_type_ComTencentWidgetVerticalGallery))) {
        break;
      }
      this.jdField_a_of_type_Int = j;
      this.jdField_a_of_type_ComTencentWidgetVerticalGallery.post(this);
      return;
      int k = this.jdField_a_of_type_ComTencentWidgetVerticalGallery.getChildCount();
      VerticalGallery.a(this.jdField_a_of_type_ComTencentWidgetVerticalGallery, k - 1 + this.jdField_a_of_type_ComTencentWidgetVerticalGallery.au);
    }
    b(true);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xvk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */