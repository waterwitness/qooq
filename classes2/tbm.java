import android.os.Handler;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.magicface.service.MagicfaceActionManager.MagicfaceTextUpdateListener;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController;

public class tbm
  implements MagicfaceActionManager.MagicfaceTextUpdateListener
{
  public tbm(MagicfaceViewController paramMagicfaceViewController, int paramInt, TextView paramTextView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController.a.post(new tbn(this, paramString));
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController.a.post(new tbo(this, paramString));
  }
  
  public void c(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController.a.post(new tbp(this, paramString));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tbm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */