import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.GrayTipsSpan;
import com.tencent.mobileqq.data.MessageForNewGrayTips;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class rbv
  implements View.OnClickListener
{
  public rbv(MessageForNewGrayTips paramMessageForNewGrayTips, GrayTipsSpan paramGrayTipsSpan)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForNewGrayTips.click(paramView, this.jdField_a_of_type_ComTencentMobileqqDataGrayTipsSpan.url);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\rbv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */