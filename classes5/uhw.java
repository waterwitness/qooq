import android.content.Context;
import android.graphics.Color;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richstatus.EditActivity;
import com.tencent.mobileqq.richstatus.RichStatusEditText;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.SignatureTemplateInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import java.net.URL;

public class uhw
  implements URLDrawable.URLDrawableListener
{
  public uhw(EditActivity paramEditActivity, SignatureManager paramSignatureManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (!NetworkUtil.e(BaseApplication.getContext())) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusEditActivity.getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqRichstatusEditActivity.getBaseContext().getString(2131368638), 0).a();
    }
    paramThrowable = this.jdField_a_of_type_ComTencentMobileqqRichstatusEditActivity.a.getBackground();
    if ((paramThrowable instanceof URLDrawable))
    {
      paramThrowable = (URLDrawable)paramThrowable;
      if (paramURLDrawable.getURL().toString().equals(paramThrowable.getURL().toString())) {}
    }
    else
    {
      return;
    }
    EditActivity.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusEditActivity, true);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichstatusEditActivity.a.getBackground();
    if ((localObject instanceof URLDrawable))
    {
      localObject = (URLDrawable)localObject;
      if (paramURLDrawable.getURL().toString().equals(((URLDrawable)localObject).getURL().toString())) {}
    }
    else
    {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppSignatureManager.a != null) {
      EditActivity.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusEditActivity).setTextColor(Color.parseColor(this.jdField_a_of_type_ComTencentMobileqqAppSignatureManager.a.e));
    }
    this.jdField_a_of_type_ComTencentMobileqqRichstatusEditActivity.a.setBackgroundDrawable(null);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusEditActivity.a.setBackgroundDrawable(paramURLDrawable);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\uhw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */