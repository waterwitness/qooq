import android.graphics.Color;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusHistoryActivity;
import com.tencent.mobileqq.richstatus.StatusHistoryActivity.ItemViewHolder;
import com.tencent.mobileqq.vas.SignatureTemplateInfo;

public class uiw
  implements URLDrawable.URLDrawableListener
{
  public uiw(StatusHistoryActivity paramStatusHistoryActivity, StatusHistoryActivity.ItemViewHolder paramItemViewHolder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    SignatureManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusHistoryActivity.getResources(), this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusHistoryActivity$ItemViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetClickableColorSpanTextView, StatusHistoryActivity.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusHistoryActivity), this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusHistoryActivity$ItemViewHolder.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus, this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusHistoryActivity.app, false);
    paramURLDrawable = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusHistoryActivity.a.a(Integer.toString(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusHistoryActivity$ItemViewHolder.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId));
    if (!TextUtils.isEmpty(paramURLDrawable.p)) {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusHistoryActivity$ItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor(paramURLDrawable.p));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\uiw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */