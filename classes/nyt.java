import android.app.Dialog;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class nyt
  implements ActionSheet.OnButtonClickListener
{
  public nyt(HotChatPie paramHotChatPie, ActionSheet paramActionSheet, ChatMessage paramChatMessage, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    switch (paramInt)
    {
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin, this.jdField_a_of_type_JavaLangString, false, 1);
      return;
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.BaseTroopChatPie", 2, "del hot chat member onClick, uin=" + this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin);
      }
      if (!NetworkUtil.e(BaseApplication.getContext()))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.a().getString(2131369008), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.a().getTitleBarHeight());
        return;
      }
    } while ((HotChatHandler)this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.a.a(35) == null);
    paramView = new Dialog(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.a(), 2131558973);
    paramView.setContentView(2130903236);
    TextView localTextView = (TextView)paramView.findViewById(2131296852);
    if (localTextView != null)
    {
      localTextView.requestFocus();
      localTextView.setText("删除成员后，该成员将无法再加入你的热聊房间，确认删除吗？");
    }
    localTextView = (TextView)paramView.findViewById(2131297843);
    if (localTextView != null)
    {
      localTextView.setText(2131367262);
      localTextView.setOnClickListener(new nyu(this, paramView));
    }
    localTextView = (TextView)paramView.findViewById(2131297844);
    if (localTextView != null)
    {
      localTextView.setText("确定");
      localTextView.setOnClickListener(new nyv(this, paramView));
    }
    paramView.show();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nyt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */