import android.content.Context;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout.OnChatMessageCheckedChangeListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.widget.QQToast;

public final class ncq
  implements CompoundButton.OnCheckedChangeListener
{
  public ncq()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    Object localObject = (ChatMessage)paramCompoundButton.getTag();
    if (localObject == null) {}
    for (;;)
    {
      return;
      if (paramBoolean != MultiMsgManager.a().a((ChatMessage)localObject))
      {
        if (!paramBoolean) {
          MultiMsgManager.a().a((ChatMessage)localObject, paramBoolean);
        }
        while (BaseChatItemLayout.a != null)
        {
          BaseChatItemLayout.a.a((ChatMessage)localObject, paramBoolean);
          return;
          if (MultiMsgManager.a().b())
          {
            localObject = paramCompoundButton.getContext().getString(2131367666, new Object[] { Integer.valueOf(MultiMsgManager.a().a()) });
            QQToast.a(paramCompoundButton.getContext(), (CharSequence)localObject, 0).b(((BaseActivity)paramCompoundButton.getContext()).getTitleBarHeight());
            paramCompoundButton.setChecked(false);
            return;
          }
          if ((((localObject instanceof MessageForPic)) || ((localObject instanceof MessageForMixedMsg)) || (((ChatMessage)localObject).msgtype == 64500)) && (MultiMsgManager.a().c()))
          {
            localObject = paramCompoundButton.getContext().getString(2131367667, new Object[] { Integer.valueOf(MultiMsgManager.a().b()) });
            QQToast.a(paramCompoundButton.getContext(), (CharSequence)localObject, 0).b(((BaseActivity)paramCompoundButton.getContext()).getTitleBarHeight());
            paramCompoundButton.setChecked(false);
            return;
          }
          MultiMsgManager.a().a((ChatMessage)localObject, paramBoolean);
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ncq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */