import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade.SendMsgParams;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import java.util.ArrayList;

public class kqf
  implements View.OnKeyListener, TextView.OnEditorActionListener
{
  private kqf(BaseChatPie paramBaseChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "IME_ACTION_SEND");
      }
      paramKeyEvent = this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
      if (paramKeyEvent.length() > 0)
      {
        Object localObject = this.a.a(paramKeyEvent);
        paramTextView = new ChatActivityFacade.SendMsgParams();
        paramTextView.jdField_b_of_type_Int = BaseChatPie.a(this.a);
        paramTextView.jdField_a_of_type_Int = BaseChatPie.b(this.a);
        paramTextView.jdField_c_of_type_Boolean = BaseChatPie.a(this.a);
        paramTextView.jdField_c_of_type_Int = NetworkUtil.a(BaseApplication.getContext());
        paramTextView.jdField_a_of_type_Long = System.currentTimeMillis();
        if ((localObject != null) && (localObject.length == 3))
        {
          paramTextView.jdField_d_of_type_Int = ((Integer)localObject[0]).intValue();
          paramTextView.jdField_b_of_type_Long = ((Long)localObject[1]).longValue();
          if ((localObject[2] != null) && (PasswdRedBagManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
          {
            paramTextView.jdField_a_of_type_JavaLangString = ((String)localObject[2]);
            paramTextView.jdField_d_of_type_Boolean = this.a.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagManager.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramTextView.jdField_a_of_type_JavaLangString).booleanValue();
          }
          if (QLog.isColorLevel()) {
            QLog.d("msgFold", 2, String.format("Send, get RedBagId, friendUin: %s, senderUin: %d, redBagFlag: %d, foldFlag: %s, redBagId: %s", new Object[] { this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, Long.valueOf(paramTextView.jdField_b_of_type_Long), Integer.valueOf(paramTextView.jdField_d_of_type_Int), Boolean.valueOf(paramTextView.jdField_d_of_type_Boolean), paramTextView.jdField_a_of_type_JavaLangString }));
          }
        }
        if ((this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgText.length() > BaseChatPie.y))
        {
          this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgText = this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgText.substring(0, BaseChatPie.y);
          this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceSummaryFlag = 0;
        }
        paramTextView.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo = this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo;
        if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000)) {
          break label553;
        }
        paramKeyEvent = new ArrayList();
        localObject = AtTroopMemberSpan.a(this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), paramKeyEvent);
        ChatActivityFacade.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (String)localObject, paramKeyEvent, paramTextView);
      }
      for (;;)
      {
        this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
        this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo = null;
        this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.setCompoundDrawables(null, null, null, null);
        this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTag(2131296537, null);
        this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(0);
        BaseChatPie.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Int, -1);
        return true;
        label553:
        ChatActivityFacade.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramKeyEvent, null, paramTextView);
      }
    }
    return false;
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getKeyCode() == 66)
    {
      if (paramKeyEvent.getAction() == 1)
      {
        paramView = this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.BaseChatPie", 2, " sendOnEnterEnabled = " + this.a.k);
        }
        if ((this.a.k) && (paramView.length() > 0)) {
          this.a.c();
        }
      }
      if (this.a.k) {
        return true;
      }
    }
    else if ((paramKeyEvent.getKeyCode() == 67) && (paramKeyEvent.getAction() == 0) && (this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.getSelectionStart() == 0) && (this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.getSelectionEnd() == 0) && (this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.getTag(2131296537) != null))
    {
      paramView = this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.getCompoundDrawables();
      this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.setCompoundDrawables(paramView[0], null, paramView[2], paramView[3]);
      this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTag(2131296537, null);
      this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(0);
      this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo = null;
      return true;
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kqf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */