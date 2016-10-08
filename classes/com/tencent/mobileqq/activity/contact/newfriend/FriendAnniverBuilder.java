package com.tencent.mobileqq.activity.contact.newfriend;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.adapter.SystemMsgListAdapter;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.FriendAnniver;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.newfriend.FriendAnniverMessage;
import com.tencent.mobileqq.newfriend.NewFriendMessage;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.FaceDrawable;

public class FriendAnniverBuilder
  extends NewFriendBaseBuilder
  implements View.OnClickListener
{
  private int e;
  
  public FriendAnniverBuilder(Context paramContext, QQAppInterface paramQQAppInterface, SystemMsgListAdapter paramSystemMsgListAdapter, NewFriendMessage paramNewFriendMessage)
  {
    super(paramContext, paramQQAppInterface, paramSystemMsgListAdapter, paramNewFriendMessage);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.e = paramContext.getResources().getDisplayMetrics().widthPixels;
  }
  
  public View a(int paramInt, View paramView)
  {
    FriendAnniverBuilder.FriendAnniverHolder localFriendAnniverHolder;
    View localView;
    FriendAnniver localFriendAnniver;
    StringBuilder localStringBuilder;
    Object localObject;
    if ((paramView == null) || (!(paramView.getTag() instanceof FriendAnniverBuilder.FriendAnniverHolder)))
    {
      localFriendAnniverHolder = new FriendAnniverBuilder.FriendAnniverHolder();
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130904182, null);
      localFriendAnniverHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131297123));
      localFriendAnniverHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131297124));
      localFriendAnniverHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131301735));
      localFriendAnniverHolder.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131301736));
      localView.setTag(localFriendAnniverHolder);
      localFriendAnniver = ((FriendAnniverMessage)this.jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendMessage).a;
      localStringBuilder = new StringBuilder(512);
      localFriendAnniverHolder.jdField_a_of_type_JavaLangString = localFriendAnniver.url;
      localObject = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).c(localFriendAnniver.uin);
      paramView = localFriendAnniver.uin;
      if (localObject != null)
      {
        if (!TextUtils.isEmpty(((Friends)localObject).remark)) {
          break label536;
        }
        if (!TextUtils.isEmpty(((Friends)localObject).name)) {
          break label527;
        }
        paramView = localFriendAnniver.uin;
      }
      label193:
      localObject = new StringBuilder(64);
      ((StringBuilder)localObject).append(localFriendAnniver.year).append("年前的今天，你和").append(paramView);
      Paint localPaint = new Paint();
      Rect localRect = new Rect();
      localPaint.setTextSize(AIOUtils.a(14.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      localPaint.getTextBounds(((StringBuilder)localObject).toString(), 0, ((StringBuilder)localObject).length(), localRect);
      if (localRect.width() < this.e - AIOUtils.a(138.0F, this.jdField_a_of_type_AndroidContentContext.getResources())) {
        break label545;
      }
      localFriendAnniverHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localFriendAnniverHolder.jdField_a_of_type_AndroidWidgetTextView.setText(((StringBuilder)localObject).toString());
      localFriendAnniverHolder.jdField_b_of_type_AndroidWidgetTextView.setMaxLines(2);
      localFriendAnniverHolder.jdField_b_of_type_AndroidWidgetTextView.setText("成为好友。" + localFriendAnniver.info);
      label361:
      if (AppSetting.j) {
        localStringBuilder.append(localFriendAnniver.year).append("年前的今天，你和").append(paramView).append("成为好友，双击查看详情");
      }
      paramView = FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
      localFriendAnniverHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
      paramView = FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, String.valueOf(localFriendAnniver.uin));
      localFriendAnniverHolder.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
      if (this.jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendMessage.a()) {
        break label593;
      }
      localView.setBackgroundResource(2130838316);
    }
    for (;;)
    {
      if (AppSetting.j) {
        localView.setContentDescription(localStringBuilder.toString());
      }
      localView.setOnClickListener(this);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800718F", "0X800718F", 0, 0, "", "", "", "");
      return localView;
      localFriendAnniverHolder = (FriendAnniverBuilder.FriendAnniverHolder)paramView.getTag();
      localView = paramView;
      break;
      label527:
      paramView = ((Friends)localObject).name;
      break label193;
      label536:
      paramView = ((Friends)localObject).remark;
      break label193;
      label545:
      localFriendAnniverHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      localFriendAnniverHolder.jdField_b_of_type_AndroidWidgetTextView.setMaxLines(3);
      ((StringBuilder)localObject).append("成为好友。").append(localFriendAnniver.info);
      localFriendAnniverHolder.jdField_b_of_type_AndroidWidgetTextView.setText(((StringBuilder)localObject).toString());
      break label361;
      label593:
      localView.setBackgroundResource(2130838312);
    }
  }
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView != null) && ((paramView instanceof FriendAnniverBuilder.FriendAnniverHolder)))
    {
      paramView = (FriendAnniverBuilder.FriendAnniverHolder)paramView;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007190", "0X8007190", 0, 0, "", "", "", "");
      if (!TextUtils.isEmpty(paramView.jdField_a_of_type_JavaLangString))
      {
        Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
        localIntent.putExtra("url", paramView.jdField_a_of_type_JavaLangString);
        ((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(localIntent, 223);
        ((FriendAnniverMessage)this.jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendMessage).a.isReed = true;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\contact\newfriend\FriendAnniverBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */