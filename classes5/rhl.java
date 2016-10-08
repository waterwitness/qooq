import android.graphics.Point;
import android.view.View;
import com.tencent.mobileqq.emosm.view.DragSortListView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class rhl
  extends rhp
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  
  public rhl(DragSortListView paramDragSortListView, float paramFloat, int paramInt)
  {
    super(paramDragSortListView, paramFloat, paramInt);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private int a()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.s();
    int j = (this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.k + this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.x()) / 2;
    View localView = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getChildAt(this.jdField_a_of_type_Int - i);
    if (localView != null)
    {
      if (this.jdField_a_of_type_Int == this.jdField_b_of_type_Int) {
        return localView.getTop();
      }
      if (this.jdField_a_of_type_Int < this.jdField_b_of_type_Int) {
        return localView.getTop() - j;
      }
      return localView.getBottom() + j - this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.l;
    }
    d();
    return -1;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.jdField_b_of_type_Int;
    this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.e;
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.j = 2;
    this.jdField_a_of_type_Float = (this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.a.y - a());
    this.jdField_b_of_type_Float = (this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.a.x - this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getPaddingLeft());
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    int i = a();
    int j = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getPaddingLeft();
    paramFloat1 = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.a.y - i;
    float f = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.a.x - j;
    paramFloat2 = 1.0F - paramFloat2;
    if ((paramFloat2 < Math.abs(paramFloat1 / this.jdField_a_of_type_Float)) || (paramFloat2 < Math.abs(f / this.jdField_b_of_type_Float)))
    {
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.a.y = (i + (int)(this.jdField_a_of_type_Float * paramFloat2));
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.a.x = (this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getPaddingLeft() + (int)(this.jdField_b_of_type_Float * paramFloat2));
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.a(true);
    }
  }
  
  public void b()
  {
    DragSortListView.a(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rhl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */