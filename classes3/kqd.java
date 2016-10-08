import android.text.Editable;
import android.view.View;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.data.DraftTextInfo;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.text.ReplyedMessageSpan;
import com.tencent.widget.XEditTextEx;

class kqd
  implements Runnable
{
  kqd(kqc paramkqc, DraftTextInfo paramDraftTextInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (BaseChatPie.a(this.jdField_a_of_type_Kqc.a).getVisibility() == 0) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataDraftTextInfo.sourceMsgSeq != 0L)
    {
      this.jdField_a_of_type_Kqc.a.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo = new MessageForReplyText.SourceMsgInfo();
      this.jdField_a_of_type_Kqc.a.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgSeq = this.jdField_a_of_type_ComTencentMobileqqDataDraftTextInfo.sourceMsgSeq;
      this.jdField_a_of_type_Kqc.a.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgText = this.jdField_a_of_type_ComTencentMobileqqDataDraftTextInfo.sourceMsgText;
      this.jdField_a_of_type_Kqc.a.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgSenderUin = this.jdField_a_of_type_ComTencentMobileqqDataDraftTextInfo.sourceSenderUin;
      this.jdField_a_of_type_Kqc.a.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgTime = this.jdField_a_of_type_ComTencentMobileqqDataDraftTextInfo.mSourceMsgTime;
      this.jdField_a_of_type_Kqc.a.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceSummaryFlag = this.jdField_a_of_type_ComTencentMobileqqDataDraftTextInfo.mSourceSummaryFlag;
      this.jdField_a_of_type_Kqc.a.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mType = this.jdField_a_of_type_ComTencentMobileqqDataDraftTextInfo.mSourceType;
      this.jdField_a_of_type_Kqc.a.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mRichMsg = this.jdField_a_of_type_ComTencentMobileqqDataDraftTextInfo.mSourceRichMsg;
      i = this.jdField_a_of_type_Kqc.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.getWidth();
      int j = this.jdField_a_of_type_Kqc.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingLeft();
      int k = this.jdField_a_of_type_Kqc.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingRight();
      localObject = ReplyedMessageSpan.a(this.jdField_a_of_type_Kqc.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Kqc.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_Kqc.a.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo, i - j - k, this.jdField_a_of_type_Kqc.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaint(), this.jdField_a_of_type_Kqc.a.jdField_a_of_type_AndroidViewView$OnClickListener);
      if (localObject != null)
      {
        this.jdField_a_of_type_Kqc.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.setCompoundDrawables(null, ((ReplyedMessageSpan)localObject).getDrawable(), null, null);
        this.jdField_a_of_type_Kqc.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTag(2131296537, localObject);
      }
    }
    Editable localEditable = this.jdField_a_of_type_Kqc.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText();
    int i = this.jdField_a_of_type_Kqc.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length();
    if (BaseChatPie.a(this.jdField_a_of_type_Kqc.a) == null) {}
    for (Object localObject = "";; localObject = BaseChatPie.a(this.jdField_a_of_type_Kqc.a))
    {
      localEditable.insert(i, (CharSequence)localObject);
      this.jdField_a_of_type_Kqc.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(this.jdField_a_of_type_Kqc.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString().length());
      this.jdField_a_of_type_Kqc.a.n = false;
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kqd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */