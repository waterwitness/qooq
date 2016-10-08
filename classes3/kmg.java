import android.widget.TextView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityConstants;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class kmg
  implements Runnable
{
  public kmg(BaseChatPie paramBaseChatPie, String paramString1, String paramString2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.setText(this.jdField_a_of_type_JavaLangString);
    if (ChatActivityConstants.I) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.setContentDescription(this.b);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kmg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */