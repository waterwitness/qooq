import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.biz.lebasearch.LebaSearchPluginManagerActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hiv
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public hiv(LebaSearchPluginManagerActivity paramLebaSearchPluginManagerActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onGlobalLayout()
  {
    this.a.jdField_a_of_type_AndroidViewView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    LebaSearchPluginManagerActivity.jdField_a_of_type_Double = this.a.jdField_a_of_type_AndroidViewView.getHeight() / this.a.d;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hiv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */