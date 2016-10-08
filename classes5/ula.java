import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.fragment.SelectMemberContactSearchFragment;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.qphone.base.util.BaseApplication;

public class ula
  implements View.OnTouchListener
{
  public ula(SelectMemberContactSearchFragment paramSelectMemberContactSearchFragment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((!SearchUtils.a(SelectMemberContactSearchFragment.a(this.a))) && (!SelectMemberContactSearchFragment.a(this.a)) && (paramMotionEvent.getAction() == 1))
    {
      paramView = this.a.getActivity();
      if (paramView != null) {
        paramView.finish();
      }
      return false;
    }
    ((InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ula.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */