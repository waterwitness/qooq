package com.tencent.mobileqq.activity.contact.newfriend;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity;
import com.tencent.mobileqq.adapter.SystemMsgListAdapter;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.app.activateFriends.MessageForActivateFriends;
import com.tencent.mobileqq.data.ActivateFriendItem;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.newfriend.ActivateFriendMessage;
import com.tencent.mobileqq.newfriend.NewFriendMessage;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.List;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.BirthdayNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.OneBirthdayFriend;

public class ActivateFriendsItemBuilder
  extends NewFriendBaseBuilder
  implements View.OnClickListener
{
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean;
  private ArrayList b;
  
  public ActivateFriendsItemBuilder(Context paramContext, QQAppInterface paramQQAppInterface, SystemMsgListAdapter paramSystemMsgListAdapter, NewFriendMessage paramNewFriendMessage)
  {
    super(paramContext, paramQQAppInterface, paramSystemMsgListAdapter, paramNewFriendMessage);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void a(ViewGroup paramViewGroup)
  {
    paramViewGroup.removeAllViews();
    int j = BaseApplicationImpl.getContext().getResources().getDisplayMetrics().widthPixels;
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (localArrayList.size() < 4) {
      localArrayList.addAll(this.b);
    }
    int i = 0;
    while ((i < localArrayList.size()) && (i < 4))
    {
      ActivateFriendItem localActivateFriendItem = (ActivateFriendItem)localArrayList.get(i);
      Object localObject = (LinearLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130904269, null);
      paramViewGroup.addView((View)localObject, new LinearLayout.LayoutParams(j / 4, -1));
      ImageView localImageView = (ImageView)((LinearLayout)localObject).findViewById(2131302106);
      TextView localTextView = (TextView)((LinearLayout)localObject).findViewById(2131302107);
      localObject = (TextView)((LinearLayout)localObject).findViewById(2131297124);
      localImageView.setImageDrawable(FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, String.valueOf(localActivateFriendItem.uin)));
      localTextView.setText(localActivateFriendItem.nickName);
      ((TextView)localObject).setText(localActivateFriendItem.birthdayDesc);
      i += 1;
    }
  }
  
  private void b()
  {
    SubMsgType0x76.MsgBody localMsgBody = ((ActivateFriendMessage)this.jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendMessage).a.getMsgBody();
    if (localMsgBody.uint32_msg_type.get() == 2)
    {
      int j = localMsgBody.msg_birthday_notify.rpt_msg_one_friend.get().size();
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(j);
      this.b = new ArrayList(j);
      FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      int i = 0;
      if (i < j)
      {
        ActivateFriendItem localActivateFriendItem = new ActivateFriendItem(2, ((SubMsgType0x76.OneBirthdayFriend)localMsgBody.msg_birthday_notify.rpt_msg_one_friend.get().get(i)).uint64_uin.get());
        localActivateFriendItem.uin = ((SubMsgType0x76.OneBirthdayFriend)localMsgBody.msg_birthday_notify.rpt_msg_one_friend.get().get(i)).uint64_uin.get();
        if (!localFriendsManager.b(String.valueOf(localActivateFriendItem.uin))) {}
        for (;;)
        {
          i += 1;
          break;
          int k = ((SubMsgType0x76.OneBirthdayFriend)localMsgBody.msg_birthday_notify.rpt_msg_one_friend.get().get(i)).uint32_birth_month.get();
          int m = ((SubMsgType0x76.OneBirthdayFriend)localMsgBody.msg_birthday_notify.rpt_msg_one_friend.get().get(i)).uint32_birth_date.get();
          int n = ActivateFriendsManager.a(((SubMsgType0x76.OneBirthdayFriend)localMsgBody.msg_birthday_notify.rpt_msg_one_friend.get().get(i)).uint32_birth_year.get(), k, m);
          localActivateFriendItem.nickName = ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(localActivateFriendItem.uin), true);
          localActivateFriendItem.birthdayDesc = ActivateFriendsManager.a(n, k, m);
          if (n == 0)
          {
            localActivateFriendItem.birthSendTime = MessageCache.a();
            this.b.add(localActivateFriendItem);
          }
          else if (n == 1)
          {
            localActivateFriendItem.birthSendTime = MessageCache.a();
            this.jdField_a_of_type_JavaUtilArrayList.add(localActivateFriendItem);
          }
          else
          {
            localActivateFriendItem.birthSendTime = ((SubMsgType0x76.OneBirthdayFriend)localMsgBody.msg_birthday_notify.rpt_msg_one_friend.get().get(i)).uint64_msg_send_time.get();
            this.jdField_a_of_type_JavaUtilArrayList.add(localActivateFriendItem);
          }
        }
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800707C", "0X800707C", 0, 0, "", "", "", "");
    }
  }
  
  public View a(int paramInt, View paramView)
  {
    ActivateFriendsItemBuilder.ActivateFriendsHolder localActivateFriendsHolder;
    if ((paramView == null) || (!(paramView.getTag() instanceof ActivateFriendsItemBuilder.ActivateFriendsHolder)))
    {
      localActivateFriendsHolder = new ActivateFriendsItemBuilder.ActivateFriendsHolder();
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130904270, null);
      localActivateFriendsHolder.e = ((TextView)paramView.findViewById(2131302103));
      localActivateFriendsHolder.a = ((LinearLayout)paramView.findViewById(2131302118));
      paramView.setTag(localActivateFriendsHolder);
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = true;
        b();
      }
      a(localActivateFriendsHolder.a);
      localActivateFriendsHolder.e.setText(String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131367591), new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()) }));
      a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendMessage, localActivateFriendsHolder, this);
      if (this.jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendMessage.a()) {
        break label218;
      }
      paramView.setBackgroundResource(2130838316);
    }
    for (;;)
    {
      if (AppSetting.j) {
        paramView.setContentDescription(String.format("有%d位好友即将生日 双击查看详情", new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()) }));
      }
      paramView.setOnClickListener(this);
      return paramView;
      localActivateFriendsHolder = (ActivateFriendsItemBuilder.ActivateFriendsHolder)paramView.getTag();
      break;
      label218:
      paramView.setBackgroundResource(2130838312);
    }
  }
  
  public void onClick(View paramView)
  {
    paramView = new Intent(paramView.getContext(), ActivateFriendActivity.class);
    paramView.putExtra("af_key_from", 1);
    ((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(paramView, 224);
    ((ActivateFriendMessage)this.jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendMessage).a.isread = true;
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800707D", "0X800707D", 0, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\contact\newfriend\ActivateFriendsItemBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */