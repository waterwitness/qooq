import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewPropertyAnimator;
import com.tencent.biz.qqstory.pgc.view.DiscoverItem;
import com.tencent.biz.qqstory.pgc.view.DiscoverItem.OnItemTouchListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class imd
  implements View.OnTouchListener
{
  public imd(DiscoverItem paramDiscoverItem, DiscoverItem.OnItemTouchListener paramOnItemTouchListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    ViewPropertyAnimator localViewPropertyAnimator;
    if (i == 0)
    {
      localViewPropertyAnimator = this.jdField_a_of_type_ComTencentBizQqstoryPgcViewDiscoverItem.animate().scaleXBy(1.0F).scaleX(0.95F).scaleYBy(1.0F).scaleY(0.95F);
      localViewPropertyAnimator.setListener(this.jdField_a_of_type_ComTencentBizQqstoryPgcViewDiscoverItem.a);
      localViewPropertyAnimator.start();
      localViewPropertyAnimator = this.jdField_a_of_type_ComTencentBizQqstoryPgcViewDiscoverItem.b.animate().alphaBy(this.jdField_a_of_type_ComTencentBizQqstoryPgcViewDiscoverItem.c).alpha(0.8F).setDuration(100L);
      localViewPropertyAnimator.setListener(this.jdField_a_of_type_ComTencentBizQqstoryPgcViewDiscoverItem.a);
      localViewPropertyAnimator.start();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryPgcViewDiscoverItem$OnItemTouchListener != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryPgcViewDiscoverItem$OnItemTouchListener.a(this.jdField_a_of_type_ComTencentBizQqstoryPgcViewDiscoverItem.d, paramView, paramMotionEvent);
      }
      return false;
      if ((i == 3) || (i == 1))
      {
        localViewPropertyAnimator = this.jdField_a_of_type_ComTencentBizQqstoryPgcViewDiscoverItem.animate().scaleXBy(0.95F).scaleX(1.0F).scaleYBy(0.95F).scaleY(1.0F);
        localViewPropertyAnimator.setListener(this.jdField_a_of_type_ComTencentBizQqstoryPgcViewDiscoverItem.a);
        localViewPropertyAnimator.start();
        localViewPropertyAnimator = this.jdField_a_of_type_ComTencentBizQqstoryPgcViewDiscoverItem.b.animate().alphaBy(0.8F).alpha(this.jdField_a_of_type_ComTencentBizQqstoryPgcViewDiscoverItem.c).setDuration(100L);
        localViewPropertyAnimator.setListener(this.jdField_a_of_type_ComTencentBizQqstoryPgcViewDiscoverItem.a);
        localViewPropertyAnimator.start();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\imd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */