import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.bitapp.BitAppMsg;
import com.tencent.bitapp.BitAppMsgFactory;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FlashPicHelper;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil.TroopBusinessMessage;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;

public class knm
  implements Runnable
{
  public knm(BaseChatPie paramBaseChatPie, QQMessageFacade.Message paramMessage, Intent paramIntent)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject1;
    StringBuilder localStringBuilder;
    Object localObject2;
    if ((!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.frienduin)) && ((this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.senderuin == null) || (!this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.senderuin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))) && (!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.l))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.e == null)
      {
        BaseChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, new View(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext));
        BaseChatPie.c(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).setId(2131296337);
        BaseChatPie.c(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131428215));
        localObject1 = new RelativeLayout.LayoutParams(-1, 1);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b.addView(BaseChatPie.c(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie), (ViewGroup.LayoutParams)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.e = new TextView(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.e.setId(2131296336);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.e.setSingleLine();
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.e.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838141));
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.e.setGravity(17);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.e.setTextSize(2, 14.0F);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.e.setBackgroundResource(2130838141);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.e.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131428300));
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.e.setPadding((int)(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Float * 10.0F), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.e.getPaddingTop(), (int)(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Float * 10.0F), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.e.getPaddingBottom());
        localObject1 = new RelativeLayout.LayoutParams(-1, (int)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131493102));
        ((RelativeLayout.LayoutParams)localObject1).addRule(3, 2131296337);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b.addView(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.e, (ViewGroup.LayoutParams)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.e.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
      }
      if ((ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) || (ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)))
      {
        BaseChatPie.c(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.e.setVisibility(0);
        if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.msgtype != 63520) {
          break label715;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.msg.split("\\|");
        if ((localObject1 == null) || (localObject1.length <= 0)) {
          break label708;
        }
        localObject1 = localObject1[0].trim();
      }
      for (;;)
      {
        localStringBuilder = new StringBuilder();
        localObject2 = TroopBusinessUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message);
        if (localObject2 != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.nickName = ((TroopBusinessUtil.TroopBusinessMessage)localObject2).c;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.nickName == null) {
          break label1068;
        }
        if (!this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.nickName.equals(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.getString(2131362119))) {
          break label902;
        }
        localObject1 = ((CharSequence)localObject1).toString();
        int i = 0;
        for (;;)
        {
          localObject2 = localObject1;
          if (i >= EmotcationConstants.a.length) {
            break;
          }
          localObject2 = localObject1;
          if (((String)localObject1).indexOf('\024' + EmotcationConstants.a[i]) != -1) {
            localObject2 = ((String)localObject1).replace('\024' + EmotcationConstants.a[i], "\024" + (char)i);
          }
          i += 1;
          localObject1 = localObject2;
        }
        BaseChatPie.c(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).setVisibility(8);
        break;
        label708:
        localObject1 = "";
        continue;
        label715:
        if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.msgtype == 63525)
        {
          localObject1 = StructMsgFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.msgData);
          if (localObject1 != null) {
            localObject1 = ((AbsStructMsg)localObject1).mMsgBrief;
          } else {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.msg;
          }
        }
        else if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.msgtype == 60527)
        {
          localObject1 = BitAppMsgFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.msgData);
          if (localObject1 != null) {
            localObject1 = ((BitAppMsg)localObject1).mMsgBrief;
          } else {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.msg;
          }
        }
        else if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.msgtype == 63536)
        {
          if ((((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59)).b(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.frienduin)) || (FlashPicHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message))) {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getString(2131369797);
          } else {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.getMessageText();
          }
        }
        else
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.getMessageText();
        }
      }
      label902:
      localObject2 = localObject1;
      localStringBuilder.append(this.jdField_a_of_type_AndroidContentIntent.getStringExtra("uinname"));
      localStringBuilder.append("-");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.nickName);
      localObject1 = localObject2;
      localStringBuilder.append(":");
      if (!(localObject1 instanceof QQText)) {
        break label1458;
      }
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.e.setText(((QQText)localObject1).a(localStringBuilder.toString(), true, new int[] { 1, 16 }));
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.e.requestLayout();
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.e.setTag(this.jdField_a_of_type_AndroidContentIntent);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.e.getHandler();
        if (localObject1 != null)
        {
          ((Handler)localObject1).removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_JavaLangRunnable);
          ((Handler)localObject1).postDelayed(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_JavaLangRunnable, 10000L);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.ax();
        return;
        label1068:
        String str2 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("uinname");
        if ((str2 == null) || (str2.length() == 0))
        {
          localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.frienduin);
          break;
        }
        String str1;
        if (7000 == this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.istroop)
        {
          str1 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("subAccountLatestNick");
          if (str1 != null)
          {
            localObject2 = str1;
            if (str1.length() != 0) {}
          }
          else
          {
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.senderuin;
          }
          localStringBuilder.append(str2);
          localStringBuilder.append("-");
          localStringBuilder.append((String)localObject2);
          break;
        }
        if ((1010 == this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.istroop) || (1001 == this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.istroop))
        {
          if (String.valueOf(AppConstants.ar).equals(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.frienduin))
          {
            str1 = ContactUtils.o(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.senderuin);
            localObject2 = str1;
            if (TextUtils.isEmpty(str1)) {
              localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.senderuin;
            }
            localStringBuilder.append(str2);
            localStringBuilder.append("-");
            localStringBuilder.append((String)localObject2);
            if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.msgtype != 64512) {
              break;
            }
            localObject1 = String.format(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getString(2131371810), new Object[] { localObject2 });
            break;
          }
          str1 = ContactUtils.o(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.frienduin);
          localObject2 = str1;
          if (!TextUtils.isEmpty(str1)) {
            continue;
          }
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.frienduin;
          continue;
        }
        if (1024 == this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.istroop)
        {
          localObject2 = CrmUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.frienduin);
          if (TextUtils.isEmpty((CharSequence)localObject2))
          {
            localStringBuilder.append(str2);
            break;
          }
          localStringBuilder.append((String)localObject2);
          break;
        }
        localStringBuilder.append(str2);
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("Q.aio.BaseChatPie", 2, localException.toString());
        continue;
      }
      label1458:
      localStringBuilder.append(localException);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.e.setText(localStringBuilder.toString());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\knm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */