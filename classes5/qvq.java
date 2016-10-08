import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qvq
  implements View.OnClickListener
{
  public qvq(BusinessCardEditActivity paramBusinessCardEditActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = (qvv)paramView.getTag();
    this.a.a(paramView.jdField_a_of_type_JavaLangString, paramView.b, paramView.jdField_a_of_type_Boolean);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\qvq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */