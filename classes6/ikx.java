import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import com.tencent.biz.qqstory.pgc.QQStoryDiscoverActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class ikx
  implements Runnable
{
  ikx(ikw paramikw)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.jdField_a_of_type_AndroidViewView.offsetTopAndBottom(-this.a.jdField_a_of_type_Int);
    this.a.jdField_a_of_type_ComTencentBizQqstoryPgcQQStoryDiscoverActivity.b.setVisibility(0);
    this.a.jdField_a_of_type_AndroidViewView.startAnimation(this.a.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
    this.a.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(this.a.jdField_a_of_type_ComTencentBizQqstoryPgcQQStoryDiscoverActivity.getWindow().peekDecorView().getWindowToken(), 0);
    this.a.jdField_a_of_type_ComTencentBizQqstoryPgcQQStoryDiscoverActivity.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ikx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */