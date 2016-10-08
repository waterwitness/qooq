package com.tencent.mobileqq.activity.contact.newfriend;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.adapter.SystemMsgListAdapter;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.newfriend.FriendSystemMessage;
import com.tencent.mobileqq.newfriend.NewFriendMessage;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.systemmsg.FriendSystemMsgController;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.mobileim.structmsg.structmsg.AddFrdSNInfo;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgAction;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;

public class SystemMsgItemBuilder
  extends NewFriendBaseBuilder
  implements View.OnClickListener
{
  private static final String jdField_a_of_type_JavaLangString = "SystemMsgItemBuilder";
  private long jdField_a_of_type_Long;
  private structmsg.StructMsg jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
  
  public SystemMsgItemBuilder(Context paramContext, QQAppInterface paramQQAppInterface, SystemMsgListAdapter paramSystemMsgListAdapter, NewFriendMessage paramNewFriendMessage)
  {
    super(paramContext, paramQQAppInterface, paramSystemMsgListAdapter, paramNewFriendMessage);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = ((FriendSystemMessage)paramNewFriendMessage).a.getSystemMsg();
    this.jdField_a_of_type_Long = ((FriendSystemMessage)paramNewFriendMessage).a.uniseq;
    this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder = a(paramContext);
  }
  
  private void a(SystemMsgItemBuilder.SystemMsgItemHolder paramSystemMsgItemHolder)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.d("SystemMsgItemBuilder", 2, "handleBuddySystemMsg! start " + paramSystemMsgItemHolder.jdField_a_of_type_Long);
    }
    int j = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get();
    switch (j)
    {
    case 11: 
    default: 
      i = 0;
    case 9: 
    case 10: 
    case 1: 
    case 0: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 12: 
      for (;;)
      {
        Object localObject2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get();
        Object localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get());
        }
        localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, AddRequestActivity.class);
        ((Intent)localObject2).putExtra("infoid", paramSystemMsgItemHolder.jdField_a_of_type_Long);
        ((Intent)localObject2).putExtra("infouin", String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
        ((Intent)localObject2).putExtra("infonick", (String)localObject1);
        ((Intent)localObject2).putExtra("infotime", this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_time.get());
        ((Intent)localObject2).putExtra("msg_type", this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get());
        ((Intent)localObject2).putExtra("strNickName", (String)localObject1);
        ((Intent)localObject2).putExtra("verify_msg", this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get());
        ((Intent)localObject2).putExtra("msg_source", this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.get());
        ((Intent)localObject2).putExtra("msg_troopuin", this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
        ((Intent)localObject2).putExtra("system_message_summary", this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get());
        ((Intent)localObject2).putExtra("info_dealwith_msg", this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_detail.get());
        ((Intent)localObject2).putExtra("msg_title", this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_title.get());
        ((Intent)localObject2).putExtra("msg_source_id", this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get());
        if (i > 0) {
          ((Intent)localObject2).putExtra("verify_type", i);
        }
        a((structmsg.StructMsg)this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), this.jdField_a_of_type_Long);
        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
        return;
        i = 1;
        continue;
        i = 0;
      }
    }
    SystemMessageHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get(), j, this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get(), null);
  }
  
  private void a(SystemMsgItemBuilder.SystemMsgItemHolder paramSystemMsgItemHolder, int paramInt, View.OnClickListener paramOnClickListener)
  {
    paramSystemMsgItemHolder.jdField_a_of_type_Long = paramInt;
    paramSystemMsgItemHolder.jdField_e_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get());
    paramSystemMsgItemHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
    Object localObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    String str = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get();
    localObject = ((FriendsManager)localObject).c(String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
    if ((localObject != null) && (!TextUtils.isEmpty(((Friends)localObject).remark))) {
      str = ((Friends)localObject).remark;
    }
    for (;;)
    {
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get());
      }
      paramSystemMsgItemHolder.jdField_e_of_type_AndroidWidgetTextView.setText("好友申请");
      paramSystemMsgItemHolder.f.setText((CharSequence)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("SystemMsgItemBuilder", 2, "name is" + (String)localObject + "source is : " + this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.get());
      }
      this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter.a.a(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg);
      this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter.a(paramSystemMsgItemHolder);
      paramSystemMsgItemHolder.jdField_e_of_type_AndroidWidgetImageView.setTag(paramSystemMsgItemHolder);
      paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      paramSystemMsgItemHolder.g.setSingleLine(true);
      paramSystemMsgItemHolder.g.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.get()))
      {
        paramSystemMsgItemHolder.h.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131367425) + " " + this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.get());
        paramSystemMsgItemHolder.h.setVisibility(0);
        if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg != null)
        {
          if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get() == null) || (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get().equals(""))) {
            break label616;
          }
          if (TextUtils.isEmpty(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_qna.get())) {
            break label593;
          }
          paramSystemMsgItemHolder.g.setText(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_qna.get());
          label429:
          switch (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get())
          {
          }
        }
      }
      for (;;)
      {
        paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setTag(paramSystemMsgItemHolder);
        paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(paramOnClickListener);
        paramOnClickListener = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131428279);
        if (paramOnClickListener != null) {
          paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setTextColor(paramOnClickListener);
        }
        paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130838225);
        return;
        paramSystemMsgItemHolder.h.setVisibility(8);
        paramSystemMsgItemHolder.g.setSingleLine(false);
        paramSystemMsgItemHolder.g.setMaxLines(2);
        break;
        label593:
        paramSystemMsgItemHolder.g.setText(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get());
        break label429;
        label616:
        paramSystemMsgItemHolder.g.setText(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get());
        break label429;
        if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get() != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().size() > 0) && (!TextUtils.isEmpty(((structmsg.SystemMsgAction)this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().get(0)).name.get())))
        {
          paramSystemMsgItemHolder.i.setVisibility(8);
          paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
          str = ((structmsg.SystemMsgAction)this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().get(0)).name.get();
          paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setText(str);
        }
        else if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get() != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().size() == 0))
        {
          paramSystemMsgItemHolder.i.setVisibility(0);
          str = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get();
          paramSystemMsgItemHolder.i.setText(str);
          paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          continue;
          paramSystemMsgItemHolder.i.setVisibility(0);
          str = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get();
          paramSystemMsgItemHolder.i.setText(str);
          paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          continue;
          paramSystemMsgItemHolder.i.setVisibility(0);
          str = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get();
          paramSystemMsgItemHolder.i.setText(str);
          paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          continue;
          paramSystemMsgItemHolder.i.setVisibility(8);
          paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          continue;
          paramSystemMsgItemHolder.i.setVisibility(8);
          paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          continue;
          if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get() != null) && (!this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get().equals("")))
          {
            paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get());
            paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
            paramSystemMsgItemHolder.g.setSingleLine(true);
            paramSystemMsgItemHolder.g.setText(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get());
          }
          for (;;)
          {
            paramSystemMsgItemHolder.h.setVisibility(8);
            paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
            paramSystemMsgItemHolder.i.setVisibility(8);
            break;
            paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
            paramSystemMsgItemHolder.g.setSingleLine(false);
            paramSystemMsgItemHolder.g.setMaxLines(2);
          }
          paramSystemMsgItemHolder.i.setVisibility(0);
          str = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get();
          paramSystemMsgItemHolder.i.setText(str);
          paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          continue;
          paramSystemMsgItemHolder.i.setVisibility(0);
          str = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get();
          paramSystemMsgItemHolder.i.setText(str);
          paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          continue;
          if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get() != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().size() > 0) && (!TextUtils.isEmpty(((structmsg.SystemMsgAction)this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().get(0)).name.get())))
          {
            paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
            paramSystemMsgItemHolder.i.setVisibility(8);
            paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
            str = ((structmsg.SystemMsgAction)this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().get(0)).name.get();
            paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setText(str);
          }
          else
          {
            paramSystemMsgItemHolder.i.setVisibility(0);
            str = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get();
            paramSystemMsgItemHolder.i.setText(str);
            paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
            continue;
            if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get() != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().size() > 0) && (!TextUtils.isEmpty(((structmsg.SystemMsgAction)this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().get(0)).name.get())))
            {
              paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
              paramSystemMsgItemHolder.i.setVisibility(8);
              paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
              str = ((structmsg.SystemMsgAction)this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().get(0)).name.get();
              paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setText(str);
            }
            else
            {
              paramSystemMsgItemHolder.i.setVisibility(0);
              str = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get();
              paramSystemMsgItemHolder.i.setText(str);
              paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
              continue;
              if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.reqsubtype.has()) {
                if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.reqsubtype.get() == 1)
                {
                  paramSystemMsgItemHolder.i.setVisibility(0);
                  str = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get();
                  paramSystemMsgItemHolder.i.setText(str);
                  paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
                }
                else if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.reqsubtype.get() == 2)
                {
                  paramSystemMsgItemHolder.i.setVisibility(8);
                  paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
                  continue;
                  paramSystemMsgItemHolder.i.setVisibility(0);
                  str = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get();
                  paramSystemMsgItemHolder.i.setText(str);
                  paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
                  paramSystemMsgItemHolder.h.setVisibility(8);
                }
              }
            }
          }
        }
      }
    }
  }
  
  private void a(structmsg.StructMsg paramStructMsg, long paramLong)
  {
    if (paramStructMsg != null)
    {
      long l = ((structmsg.StructMsg)paramStructMsg.get()).msg_seq.get() + ((structmsg.StructMsg)paramStructMsg.get()).msg_type.get();
      FriendSystemMsgController.a().a(Long.valueOf(l), (structmsg.StructMsg)paramStructMsg.get());
      FriendSystemMsgController.a().b(l);
      FriendSystemMsgController.a().a(paramLong);
    }
  }
  
  protected int a()
  {
    return ((FriendSystemMessage)this.jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendMessage).a.mSysmsgMenuFlag;
  }
  
  public View a(int paramInt, View paramView)
  {
    SystemMsgItemBuilder.SystemMsgItemHolder localSystemMsgItemHolder;
    if ((paramView == null) || (!(paramView.getTag() instanceof SystemMsgItemBuilder.SystemMsgItemHolder)))
    {
      localSystemMsgItemHolder = new SystemMsgItemBuilder.SystemMsgItemHolder();
      paramView = a(this.jdField_a_of_type_AndroidContentContext, 2130904369, localSystemMsgItemHolder);
      localSystemMsgItemHolder.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131300785));
      localSystemMsgItemHolder.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131299657));
      localSystemMsgItemHolder.f = ((TextView)paramView.findViewById(2131296932));
      localSystemMsgItemHolder.g = ((TextView)paramView.findViewById(2131302562));
      localSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131302563));
      localSystemMsgItemHolder.h = ((TextView)paramView.findViewById(2131302564));
      localSystemMsgItemHolder.i = ((TextView)paramView.findViewById(2131302557));
      localSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131302556));
      paramView.setTag(localSystemMsgItemHolder);
      localSystemMsgItemHolder.jdField_e_of_type_AndroidViewView.setTag(localSystemMsgItemHolder);
      localSystemMsgItemHolder.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
      a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendMessage, localSystemMsgItemHolder, this);
      if (this.jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendMessage.a()) {
        break label245;
      }
      localSystemMsgItemHolder.jdField_e_of_type_AndroidViewView.setBackgroundResource(2130838316);
    }
    for (;;)
    {
      localSystemMsgItemHolder.jdField_e_of_type_AndroidViewView.setTag(-1, Integer.valueOf(paramInt));
      paramView.setTag(-1, Integer.valueOf(paramInt));
      a(localSystemMsgItemHolder, paramInt, this);
      return paramView;
      localSystemMsgItemHolder = (SystemMsgItemBuilder.SystemMsgItemHolder)paramView.getTag();
      break;
      label245:
      localSystemMsgItemHolder.jdField_e_of_type_AndroidViewView.setBackgroundResource(2130838312);
    }
  }
  
  protected void a()
  {
    MessageForSystemMsg localMessageForSystemMsg = ((FriendSystemMessage)this.jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendMessage).a;
    this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter.a.j();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, localMessageForSystemMsg.frienduin, localMessageForSystemMsg.istroop, localMessageForSystemMsg.uniseq);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A74", "0X8006A74", 0, 0, "", "", "", "");
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      a(paramView);
    }
    do
    {
      do
      {
        do
        {
          return;
          paramView = paramView.getTag();
        } while ((paramView == null) || (!(paramView instanceof SystemMsgItemBuilder.SystemMsgItemHolder)));
        paramView = (SystemMsgItemBuilder.SystemMsgItemHolder)paramView;
      } while (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_type.get() != 1);
      a(paramView);
      return;
      paramView = paramView.getTag();
    } while ((paramView == null) || (!(paramView instanceof SystemMsgItemBuilder.SystemMsgItemHolder)));
    if (!NetworkUtil.h(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131367256), 0).b(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter.a.a());
      return;
    }
    Object localObject2 = (SystemMsgItemBuilder.SystemMsgItemHolder)paramView;
    a((structmsg.StructMsg)this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), this.jdField_a_of_type_Long);
    Object localObject1;
    if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get() == 64525)
    {
      FriendListHandler localFriendListHandler = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
      localObject1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get();
      paramView = (View)localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        paramView = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get());
      }
      localFriendListHandler.a(0, this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get(), 0L, null, (byte)0, paramView, this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_time.get(), ((SystemMsgItemBuilder.SystemMsgItemHolder)localObject2).jdField_a_of_type_Long);
    }
    for (int i = 1;; i = 1)
    {
      if (i != 0) {
        this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter.a.a.c();
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "frd_recommend", "Frd_accept", 0, 0, "1", "", "", "");
      return;
      long l1 = FriendSystemMsgController.a().b();
      paramView = FriendSystemMsgController.a().a(Long.valueOf(l1));
      if (paramView == null) {
        break label610;
      }
      i = paramView.msg_type.get();
      l1 = paramView.msg_seq.get();
      long l2 = paramView.req_uin.get();
      int j = paramView.msg.sub_type.get();
      int k = paramView.msg.src_id.get();
      int m = paramView.msg.sub_src_id.get();
      int n = paramView.msg.group_msg_type.get();
      localObject1 = paramView.msg.actions.get();
      if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
        break;
      }
      localObject1 = (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)((List)localObject1).get(0)).action_info.get();
      ((structmsg.SystemMsgActionInfo)localObject1).remark.set("");
      ((structmsg.SystemMsgActionInfo)localObject1).group_id.set(0);
      localObject2 = new structmsg.AddFrdSNInfo();
      ((structmsg.AddFrdSNInfo)localObject2).uint32_not_see_dynamic.set(0);
      ((structmsg.AddFrdSNInfo)localObject2).uint32_set_sn.set(0);
      ((structmsg.SystemMsgActionInfo)localObject1).addFrdSNInfo.set((MessageMicro)localObject2);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(i, l1, l2, j, k, m, n, (structmsg.SystemMsgActionInfo)localObject1, 0, paramView, false);
    }
    paramView = new StringBuilder().append("agree, ");
    if (localObject1 != null)
    {
      i = ((List)localObject1).size();
      label583:
      QLog.d("SystemMsgItemBuilder", 1, i);
    }
    for (;;)
    {
      i = 0;
      break;
      i = -1;
      break label583;
      label610:
      QLog.d("SystemMsgItemBuilder", 1, "agree");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\contact\newfriend\SystemMsgItemBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */