import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.emosm.view.DragSortController;
import com.tencent.mobileqq.emosm.view.DragSortListView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class rhe
  extends GestureDetector.SimpleOnGestureListener
{
  public rhe(DragSortController paramDragSortController)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    if ((!this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.b()) && (this.a.m != -1)) {
      this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setTapPos(this.a.m);
    }
    return false;
  }
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.b()) || (Math.abs(paramFloat1) <= Math.abs(paramFloat2)) || (this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.f_()) || (this.a.c) || (Math.abs(paramFloat1) <= this.a.jdField_a_of_type_Float) || ((paramFloat1 < 0.0F) && (this.a.i == 2))) {}
    while ((paramFloat1 > 0.0F) && (this.a.i == 1)) {
      return false;
    }
    int i = this.a.m;
    this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setSrcPos(i);
    this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.d();
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rhe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */