package com.tencent.mobileqq.activity.contact.newfriend;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.adapter.SystemMsgListAdapter;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ContactMatch;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.newfriend.ContactMatchMessage;
import com.tencent.mobileqq.newfriend.NewFriendMessage;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import mqq.os.MqqHandler;
import ois;

public class ContactMatchBuilder
  extends NewFriendBaseBuilder
  implements View.OnClickListener
{
  private FriendsManager a;
  
  public ContactMatchBuilder(Context paramContext, QQAppInterface paramQQAppInterface, SystemMsgListAdapter paramSystemMsgListAdapter, NewFriendMessage paramNewFriendMessage)
  {
    super(paramContext, paramQQAppInterface, paramSystemMsgListAdapter, paramNewFriendMessage);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)paramQQAppInterface.getManager(50));
    this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder = a(paramContext);
  }
  
  protected int a()
  {
    return 1;
  }
  
  public View a(int paramInt, View paramView)
  {
    ContactMatchBuilder.ContactMatchHolder localContactMatchHolder;
    label181:
    ContactMatch localContactMatch;
    StringBuilder localStringBuilder;
    if ((paramView == null) || (!(paramView.getTag() instanceof ContactMatchBuilder.ContactMatchHolder)))
    {
      localContactMatchHolder = new ContactMatchBuilder.ContactMatchHolder();
      paramView = a(this.jdField_a_of_type_AndroidContentContext, 2130904369, localContactMatchHolder);
      localContactMatchHolder.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131300785));
      localContactMatchHolder.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131299657));
      localContactMatchHolder.f = ((TextView)paramView.findViewById(2131296932));
      localContactMatchHolder.g = ((TextView)paramView.findViewById(2131302562));
      localContactMatchHolder.h = ((TextView)paramView.findViewById(2131302564));
      localContactMatchHolder.i = ((TextView)paramView.findViewById(2131302557));
      localContactMatchHolder.a = ((Button)paramView.findViewById(2131302556));
      paramView.setTag(localContactMatchHolder);
      localContactMatchHolder.jdField_e_of_type_AndroidViewView.setTag(localContactMatchHolder);
      localContactMatchHolder.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
      a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendMessage, localContactMatchHolder, this);
      if (this.jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendMessage.a()) {
        break label480;
      }
      localContactMatchHolder.jdField_e_of_type_AndroidViewView.setBackgroundResource(2130838316);
      localContactMatch = ((ContactMatchMessage)this.jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendMessage).a;
      localStringBuilder = new StringBuilder(512);
      localContactMatchHolder.jdField_e_of_type_AndroidWidgetTextView.setText("手机通讯录");
      if (TextUtils.isEmpty(localContactMatch.name)) {
        break label492;
      }
      localContactMatchHolder.f.setVisibility(0);
      localContactMatchHolder.f.setText(localContactMatch.name);
      if (AppSetting.j) {
        localStringBuilder.append(localContactMatch.name);
      }
      label262:
      if (TextUtils.isEmpty(localContactMatch.mobileNo)) {
        break label504;
      }
      localContactMatchHolder.g.setVisibility(0);
      localContactMatchHolder.g.setText(localContactMatch.mobileNo);
      localContactMatchHolder.g.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      if (AppSetting.j) {
        localStringBuilder.append(",").append(localContactMatch.mobileNo);
      }
      label326:
      localContactMatchHolder.h.setText("来源：手机通讯录");
      localContactMatchHolder.h.setVisibility(0);
      if (AppSetting.j) {
        localStringBuilder.append(",来源：手机通讯录");
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(localContactMatch.unifiedCode, true)) {
        break label516;
      }
      localContactMatchHolder.a.setVisibility(8);
      localContactMatchHolder.i.setVisibility(0);
      localContactMatchHolder.i.setText("等待验证");
      if (AppSetting.j)
      {
        localStringBuilder.append(",等待验证");
        localContactMatchHolder.i.setContentDescription("等待验证");
      }
    }
    for (;;)
    {
      if (AppSetting.j) {
        paramView.setContentDescription(localStringBuilder.toString());
      }
      localContactMatchHolder.jdField_e_of_type_JavaLangString = localContactMatch.unifiedCode;
      localContactMatchHolder.jdField_e_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter.a(11, localContactMatch.unifiedCode));
      return paramView;
      localContactMatchHolder = (ContactMatchBuilder.ContactMatchHolder)paramView.getTag();
      break;
      label480:
      localContactMatchHolder.jdField_e_of_type_AndroidViewView.setBackgroundResource(2130838312);
      break label181;
      label492:
      localContactMatchHolder.f.setVisibility(8);
      break label262;
      label504:
      localContactMatchHolder.g.setVisibility(8);
      break label326;
      label516:
      localContactMatchHolder.a.setVisibility(0);
      localContactMatchHolder.a.setText("添加");
      localContactMatchHolder.a.setTag(localContactMatch);
      localContactMatchHolder.a.setOnClickListener(this);
      ColorStateList localColorStateList = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131428280);
      if (localColorStateList != null) {
        localContactMatchHolder.a.setTextColor(localColorStateList);
      }
      localContactMatchHolder.a.setBackgroundResource(2130838232);
      localContactMatchHolder.i.setVisibility(8);
      if (AppSetting.j)
      {
        localStringBuilder.append(",添加");
        localContactMatchHolder.a.setContentDescription("点击添加");
      }
    }
  }
  
  protected void a()
  {
    ThreadManager.b().post(new ois(this));
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A72", "0X8006A72", 0, 0, "", "", "", "");
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
        } while ((paramView == null) || (!(paramView instanceof ContactMatchBuilder.ContactMatchHolder)));
        paramView = ((ContactMatchMessage)this.jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendMessage).a;
      } while (paramView == null);
      ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(paramView.unifiedCode, 34);
      localAllInOne.h = paramView.name;
      ProfileActivity.b(this.jdField_a_of_type_AndroidContentContext, localAllInOne);
      return;
      paramView = paramView.getTag();
    } while ((paramView == null) || (!(paramView instanceof ContactMatch)));
    if (!NetworkUtil.h(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131367256), 0).b(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter.a.a());
      return;
    }
    paramView = (ContactMatch)paramView;
    if (paramView != null)
    {
      paramView = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidContentContext, 2, paramView.unifiedCode, null, 3006, 3, paramView.name, null, null, "手机联系人", null);
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A71", "0X8006A71", 0, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\contact\newfriend\ContactMatchBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */