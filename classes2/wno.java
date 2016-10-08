import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;

public class wno
  implements URLDrawable.URLDrawableListener
{
  public wno(ProfileCardMoreInfoView paramProfileCardMoreInfoView, TextView paramTextView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.postInvalidate();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wno.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */