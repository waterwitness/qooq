import com.tencent.mobileqq.emosm.view.DragSortListView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class rhn
  extends rhp
{
  private float jdField_a_of_type_Float;
  private float b;
  
  public rhn(DragSortListView paramDragSortListView, float paramFloat, int paramInt)
  {
    super(paramDragSortListView, paramFloat, paramInt);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Float = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.f;
    this.b = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.m;
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.j != 4)
    {
      d();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.f = ((int)(this.b * paramFloat2 + (1.0F - paramFloat2) * this.jdField_a_of_type_Float));
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.a.y = (this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.n - this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.f);
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.a(true);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rhn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */