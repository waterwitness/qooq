import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.PokeItemBuilder;
import com.tencent.mobileqq.activity.aio.item.PokeItemBuilder.Holder;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class nna
  implements View.OnClickListener
{
  public nna(PokeItemBuilder paramPokeItemBuilder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getContext() instanceof ChatHistoryForC2C)) {}
    do
    {
      return;
      AIOUtils.l = true;
    } while (PokeItemBuilder.a(this.a));
    paramView = (PokeItemBuilder.Holder)AIOUtils.a(paramView);
    if (QLog.isColorLevel()) {
      QLog.d("poke", 2, "poke msg onClick() is called==pos=" + paramView.b + "+holder.mContent=" + paramView.jdField_a_of_type_AndroidViewView);
    }
    this.a.a(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, paramView, true, null);
    if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend())
    {
      ReportController.b(this.a.b, "CliOper", "", this.a.a.a, "0X800676F", "0X800676F", 1, 0, "", "", "", "");
      return;
    }
    ReportController.b(this.a.b, "CliOper", "", this.a.a.a, "0X800676F", "0X800676F", 2, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nna.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */