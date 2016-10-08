package com.tencent.mobileqq.activity.contact.newfriend;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
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
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PushRecommend;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.newfriend.MayKnowMessage;
import com.tencent.mobileqq.newfriend.NewFriendMessage;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.OffsetableImageSpan;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class PushRecommendBuilder
  extends NewFriendBaseBuilder
  implements View.OnClickListener
{
  private static final String jdField_a_of_type_JavaLangString = "PushRecommendBuilder";
  private Resources jdField_a_of_type_AndroidContentResResources;
  private StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  
  public PushRecommendBuilder(Context paramContext, QQAppInterface paramQQAppInterface, SystemMsgListAdapter paramSystemMsgListAdapter, NewFriendMessage paramNewFriendMessage)
  {
    super(paramContext, paramQQAppInterface, paramSystemMsgListAdapter, paramNewFriendMessage);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidContentResResources = paramContext.getResources();
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)paramQQAppInterface.getManager(14));
    this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder = a(paramContext);
  }
  
  private StringBuilder a(PushRecommendBuilder.PushRecommendHolder paramPushRecommendHolder, PushRecommend paramPushRecommend)
  {
    int j = 0;
    paramPushRecommend = paramPushRecommend.getRichStatus();
    paramPushRecommendHolder = paramPushRecommendHolder.h;
    Object localObject1 = paramPushRecommend.toSpannableString(null, this.jdField_a_of_type_AndroidContentResResources.getColor(2131428313), this.jdField_a_of_type_AndroidContentResResources.getColor(2131428313));
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder(512);
      ((StringBuilder)localObject2).append("updateRichStatus , status.actionText : ");
      ((StringBuilder)localObject2).append(paramPushRecommend.actionText);
      ((StringBuilder)localObject2).append(" , actionId : ");
      ((StringBuilder)localObject2).append(paramPushRecommend.actionId);
      ((StringBuilder)localObject2).append(" , status.dataText : " + paramPushRecommend.dataText);
      ((StringBuilder)localObject2).append(" , dataId : ");
      ((StringBuilder)localObject2).append(paramPushRecommend.dataId);
      ((StringBuilder)localObject2).append(" , ss : ");
      ((StringBuilder)localObject2).append((CharSequence)localObject1);
      QLog.d("PushRecommendBuilder", 2, ((StringBuilder)localObject2).toString());
    }
    int i;
    if (!TextUtils.isEmpty(paramPushRecommend.actionText))
    {
      paramPushRecommendHolder.setVisibility(0);
      localObject1 = new SpannableStringBuilder((CharSequence)localObject1);
      ((SpannableStringBuilder)localObject1).insert(0, "[S] ");
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(paramPushRecommend.actionId, 200);
      localObject2 = new StatableBitmapDrawable(this.jdField_a_of_type_AndroidContentResResources, (Bitmap)localObject2, false, false);
      i = (int)(paramPushRecommendHolder.getTextSize() * 1.1F + 0.5F);
      ((BitmapDrawable)localObject2).setBounds(0, 0, i, i);
      localObject2 = new OffsetableImageSpan((Drawable)localObject2, 0);
      ((OffsetableImageSpan)localObject2).a(-0.1F);
      ((SpannableStringBuilder)localObject1).setSpan(localObject2, 0, "[S]".length(), 17);
      paramPushRecommendHolder.setText((CharSequence)localObject1);
      paramPushRecommendHolder = new StringBuilder();
      if (paramPushRecommend.actionText != null) {
        paramPushRecommendHolder.append(paramPushRecommend.actionText);
      }
      if (paramPushRecommend.dataText != null) {
        paramPushRecommendHolder.append(paramPushRecommend.dataText);
      }
      if (paramPushRecommend.plainText == null) {
        break label418;
      }
      i = paramPushRecommend.plainText.size();
    }
    for (;;)
    {
      if (j >= i) {
        return paramPushRecommendHolder;
      }
      localObject1 = (String)paramPushRecommend.plainText.get(j);
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        paramPushRecommendHolder.append((String)localObject1);
      }
      j += 1;
      continue;
      if (((SpannableString)localObject1).length() == 0)
      {
        paramPushRecommendHolder.setVisibility(8);
        break;
      }
      paramPushRecommendHolder.setVisibility(0);
      paramPushRecommendHolder.setText((CharSequence)localObject1);
      break;
      label418:
      i = 0;
    }
    return paramPushRecommendHolder;
  }
  
  protected int a()
  {
    return 1;
  }
  
  public View a(int paramInt, View paramView)
  {
    PushRecommendBuilder.PushRecommendHolder localPushRecommendHolder;
    View localView;
    label227:
    PushRecommend localPushRecommend;
    StringBuilder localStringBuilder;
    label290:
    label328:
    int i;
    if ((paramView == null) || (!(paramView.getTag() instanceof PushRecommendBuilder.PushRecommendHolder)))
    {
      localPushRecommendHolder = new PushRecommendBuilder.PushRecommendHolder();
      localView = a(this.jdField_a_of_type_AndroidContentContext, 2130904369, localPushRecommendHolder);
      localPushRecommendHolder.jdField_e_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131300785));
      localPushRecommendHolder.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131299657));
      localPushRecommendHolder.f = ((TextView)localView.findViewById(2131296932));
      localPushRecommendHolder.g = ((TextView)localView.findViewById(2131302562));
      localPushRecommendHolder.h = ((TextView)localView.findViewById(2131302564));
      localPushRecommendHolder.i = ((TextView)localView.findViewById(2131302557));
      localPushRecommendHolder.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131302556));
      localPushRecommendHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131302560));
      localPushRecommendHolder.b = ((TextView)localView.findViewById(2131302561));
      localView.setTag(localPushRecommendHolder);
      localPushRecommendHolder.jdField_e_of_type_AndroidViewView.setTag(localPushRecommendHolder);
      localPushRecommendHolder.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
      a(this.jdField_a_of_type_AndroidContentContext, localView, paramInt, this.jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendMessage, localPushRecommendHolder, this);
      if (this.jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendMessage.a()) {
        break label746;
      }
      localPushRecommendHolder.jdField_e_of_type_AndroidViewView.setBackgroundResource(2130838316);
      localPushRecommendHolder.jdField_e_of_type_AndroidWidgetTextView.setText("你可能认识");
      localPushRecommend = ((MayKnowMessage)this.jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendMessage).a;
      localStringBuilder = new StringBuilder(512);
      if (!TextUtils.isEmpty(localPushRecommend.remark)) {
        break label769;
      }
      if (!TextUtils.isEmpty(localPushRecommend.nick)) {
        break label760;
      }
      paramView = localPushRecommend.uin;
      if (TextUtils.isEmpty(paramView)) {
        break label778;
      }
      localPushRecommendHolder.f.setVisibility(0);
      localPushRecommendHolder.f.setText(paramView);
      if (AppSetting.j) {
        localStringBuilder.append(paramView);
      }
      switch (localPushRecommend.gender)
      {
      default: 
        localPushRecommendHolder.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130840973);
        i = 0;
      }
    }
    label372:
    label424:
    label450:
    label506:
    label746:
    label760:
    label769:
    label778:
    label908:
    label921:
    label1057:
    label1184:
    label1189:
    for (paramInt = 0;; paramInt = 1)
    {
      if (localPushRecommend.age != 0)
      {
        localPushRecommendHolder.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(localPushRecommend.age));
        if (!AppSetting.j) {
          break label1184;
        }
        localStringBuilder.append(",").append(String.valueOf(localPushRecommend.age));
      }
      for (paramInt = 1;; paramInt = 1)
      {
        localPushRecommendHolder.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
        if (paramInt != 0)
        {
          localPushRecommendHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          if (TextUtils.isEmpty(localPushRecommend.category)) {
            break label908;
          }
          localPushRecommendHolder.b.setVisibility(0);
          localPushRecommendHolder.b.setText(localPushRecommend.category);
          if (AppSetting.j) {
            localStringBuilder.append(",").append(localPushRecommend.category);
          }
          if ((localPushRecommend.hasQZoneUpdate) || (!TextUtils.isEmpty(localPushRecommend.recommendReason))) {
            break label921;
          }
          localPushRecommendHolder.g.setVisibility(8);
        }
        try
        {
          for (;;)
          {
            paramView = a(localPushRecommendHolder, localPushRecommend);
            if (AppSetting.j) {
              localStringBuilder.append(",").append(paramView);
            }
            if (localPushRecommend.friendStatus != 0) {
              break label1057;
            }
            localPushRecommendHolder.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
            localPushRecommendHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
            localPushRecommendHolder.jdField_a_of_type_AndroidWidgetButton.setText("添加");
            localPushRecommendHolder.jdField_a_of_type_AndroidWidgetButton.setTag(localPushRecommend);
            paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131428280);
            if (paramView != null) {
              localPushRecommendHolder.jdField_a_of_type_AndroidWidgetButton.setTextColor(paramView);
            }
            localPushRecommendHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130838232);
            localPushRecommendHolder.i.setVisibility(8);
            if (AppSetting.j)
            {
              localStringBuilder.append(",点击添加");
              localPushRecommendHolder.jdField_a_of_type_AndroidWidgetButton.setContentDescription("添加");
            }
            if (AppSetting.j) {
              localView.setContentDescription(localStringBuilder.toString());
            }
            localPushRecommendHolder.jdField_e_of_type_JavaLangString = localPushRecommend.uin;
            localPushRecommendHolder.jdField_e_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter.a(1, localPushRecommend.uin));
            return localView;
            localPushRecommendHolder = (PushRecommendBuilder.PushRecommendHolder)paramView.getTag();
            localView = paramView;
            break;
            localPushRecommendHolder.jdField_e_of_type_AndroidViewView.setBackgroundResource(2130838312);
            break label227;
            paramView = localPushRecommend.nick;
            break label290;
            paramView = localPushRecommend.remark;
            break label290;
            localPushRecommendHolder.f.setVisibility(8);
            break label328;
            paramInt = 2130838639;
            localPushRecommendHolder.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130840973);
            i = paramInt;
            if (!AppSetting.j) {
              break label1189;
            }
            localStringBuilder.append(",男");
            int j = 1;
            i = paramInt;
            paramInt = j;
            break label372;
            paramInt = 2130838634;
            localPushRecommendHolder.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130840962);
            i = paramInt;
            if (!AppSetting.j) {
              break label1189;
            }
            localStringBuilder.append(",女");
            j = 1;
            i = paramInt;
            paramInt = j;
            break label372;
            localPushRecommendHolder.jdField_a_of_type_AndroidWidgetTextView.setText("");
            break label424;
            localPushRecommendHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
            break label450;
            localPushRecommendHolder.b.setVisibility(8);
            break label506;
            localPushRecommendHolder.g.setVisibility(0);
            if (!TextUtils.isEmpty(localPushRecommend.recommendReason))
            {
              localPushRecommendHolder.g.setText(localPushRecommend.recommendReason);
              if (AppSetting.j) {
                localStringBuilder.append(",").append(localPushRecommend.recommendReason);
              }
            }
            if (localPushRecommend.hasQZoneUpdate) {
              localPushRecommendHolder.g.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130841174, 0);
            } else {
              localPushRecommendHolder.g.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
          }
        }
        catch (Exception paramView)
        {
          for (;;)
          {
            if (QLog.isColorLevel())
            {
              QLog.d("PushRecommendBuilder", 2, "updateRichStatus error uin=" + localPushRecommend.uin);
              continue;
              if (localPushRecommend.friendStatus == 1)
              {
                localPushRecommendHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
                localPushRecommendHolder.i.setVisibility(0);
                localPushRecommendHolder.i.setText(2131367290);
                if (AppSetting.j)
                {
                  localStringBuilder.append(",等待验证");
                  localPushRecommendHolder.i.setContentDescription("等待验证");
                }
              }
              else
              {
                localPushRecommendHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
                localPushRecommendHolder.i.setVisibility(0);
                localPushRecommendHolder.i.setText(2131367279);
                if (AppSetting.j)
                {
                  localStringBuilder.append(",已添加");
                  localPushRecommendHolder.i.setContentDescription("已添加");
                }
              }
            }
          }
        }
      }
    }
  }
  
  protected void a()
  {
    String str = ((MayKnowMessage)this.jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendMessage).a.uin;
    ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).g(str);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A6F", "0X8006A6F", 0, 0, "", "", "", "");
  }
  
  public void onClick(View paramView)
  {
    int i = 1;
    Object localObject;
    switch (paramView.getId())
    {
    default: 
      a(paramView);
    case 2131299656: 
      do
      {
        do
        {
          return;
          paramView = paramView.getTag();
        } while ((paramView == null) || (!(paramView instanceof PushRecommendBuilder.PushRecommendHolder)));
        paramView = ((MayKnowMessage)this.jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendMessage).a;
      } while (paramView == null);
      localObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      if ((localObject == null) || (!((FriendsManager)localObject).b(paramView.uin))) {
        break;
      }
    }
    for (;;)
    {
      localObject = new ProfileActivity.AllInOne(paramView.uin, i);
      if (!TextUtils.isEmpty(paramView.remark)) {
        ((ProfileActivity.AllInOne)localObject).l = paramView.remark;
      }
      if (!TextUtils.isEmpty(paramView.nick)) {
        ((ProfileActivity.AllInOne)localObject).l = paramView.nick;
      }
      ((ProfileActivity.AllInOne)localObject).g = 88;
      ProfileActivity.b(this.jdField_a_of_type_AndroidContentContext, (ProfileActivity.AllInOne)localObject);
      return;
      paramView = paramView.getTag();
      if ((paramView == null) || (!(paramView instanceof PushRecommend))) {
        break;
      }
      if (!NetworkUtil.h(this.jdField_a_of_type_AndroidContentContext))
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131367256), 0).b(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter.a.a());
        return;
      }
      localObject = (PushRecommend)paramView;
      paramView = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      if ((!paramView.b(((PushRecommend)localObject).uin)) && (!paramView.d(((PushRecommend)localObject).uin))) {
        if (TextUtils.isEmpty(((PushRecommend)localObject).remark)) {
          if (TextUtils.isEmpty(((PushRecommend)localObject).nick))
          {
            paramView = ((PushRecommend)localObject).uin;
            paramView = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidContentContext, 1, ((PushRecommend)localObject).uin, null, 3045, 2, paramView, null, null, this.jdField_a_of_type_AndroidContentContext.getString(2131369433), null);
            this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
          }
        }
      }
      for (;;)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A6E", "0X8006A6E", 0, 0, "", "", "", "");
        return;
        paramView = ((PushRecommend)localObject).nick;
        break;
        paramView = ((PushRecommend)localObject).remark;
        break;
        if (paramView.b(((PushRecommend)localObject).uin))
        {
          ((PushRecommend)localObject).friendStatus = 2;
          this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter.notifyDataSetChanged();
        }
        else
        {
          ((PushRecommend)localObject).friendStatus = 1;
          this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter.notifyDataSetChanged();
        }
      }
      i = 83;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\contact\newfriend\PushRecommendBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */