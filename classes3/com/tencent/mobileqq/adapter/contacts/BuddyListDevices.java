package com.tencent.mobileqq.adapter.contacts;

import QQService.EVIPSPEC;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.contact.FriendItemLayout;
import com.tencent.mobileqq.activity.contact.SimpleTextView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.widget.SingleLineTextView;

public class BuddyListDevices
  extends BuddyListFriends
{
  private Drawable a;
  
  public BuddyListDevices(QQAppInterface paramQQAppInterface, Context paramContext, Entity paramEntity)
  {
    super(paramQQAppInterface, paramContext, paramEntity);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    try
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130840575);
      this.h = 0;
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      for (;;) {}
    }
  }
  
  private void a(ImageView paramImageView)
  {
    Object localObject = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).a("100701.100702");
    if (localObject == null) {}
    while (((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag.get() == 0) {
      return;
    }
    localObject = (FrameLayout.LayoutParams)paramImageView.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).width = ((int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 9.0F));
    ((FrameLayout.LayoutParams)localObject).height = ((int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 9.0F));
    ((FrameLayout.LayoutParams)localObject).topMargin = ((int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 11.0F));
    paramImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramImageView.setVisibility(0);
    paramImageView.setBackgroundResource(2130843321);
    BaseApplicationImpl.a().getSharedPreferences("smartdevice_entry", 4).edit().putBoolean("enable_public_device_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), true).commit();
  }
  
  public View a(int paramInt1, int paramInt2, View paramView, ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener)
  {
    Object localObject1;
    Object localObject2;
    if ((paramView == null) || (!(paramView.getTag() instanceof BuddyListFriends.BuddyChildTag)) || (((paramView.getTag() instanceof BuddyListFriends.BuddyChildTag)) && (((BuddyListFriends.BuddyChildTag)paramView.getTag()).jdField_a_of_type_Boolean)))
    {
      paramOnClickListener = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903218, paramViewGroup, false);
      localObject1 = ((FriendItemLayout)paramOnClickListener).a();
      paramOnClickListener.setTag(localObject1);
      ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_ComTencentMobileqqDataFriends;
      ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin;
      paramView = null;
      paramViewGroup = null;
      ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setVisibility(0);
      if (!AppConstants.ai.equals(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin))
      {
        localObject2 = (FrameLayout.LayoutParams)((BuddyListFriends.BuddyChildTag)localObject1).d.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject2).width = ((int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 16.0F));
        ((FrameLayout.LayoutParams)localObject2).height = ((int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 16.0F));
        ((FrameLayout.LayoutParams)localObject2).topMargin = ((int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 8.5F));
        ((BuddyListFriends.BuddyChildTag)localObject1).d.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      if (!AppConstants.aj.equals(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin)) {
        break label592;
      }
      ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.status != 0) {
        break label575;
      }
      paramInt1 = 1;
      label227:
      paramView = this.jdField_a_of_type_AndroidContentContext;
      if (paramInt1 == 0) {
        break label580;
      }
      paramInt2 = 2131370230;
      label239:
      paramViewGroup = paramView.getString(paramInt2);
      ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setText("[" + paramViewGroup + "]");
      localObject2 = ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_AndroidWidgetImageView;
      if (paramInt1 == 0) {
        break label587;
      }
      paramView = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      label295:
      ((ImageView)localObject2).setImageDrawable(paramView);
      paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131362167);
      ((BuddyListFriends.BuddyChildTag)localObject1).jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText(paramView);
      ((BuddyListFriends.BuddyChildTag)localObject1).jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendText("", 1);
      ((BuddyListFriends.BuddyChildTag)localObject1).d.setVisibility(8);
      ((BuddyListFriends.BuddyChildTag)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      ((BuddyListFriends.BuddyChildTag)localObject1).c.setVisibility(8);
      ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(a(this.jdField_a_of_type_AndroidContentContext, 2131428267));
    }
    for (;;)
    {
      label379:
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataFriends.getFriendNickWithAlias();
      ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText((CharSequence)localObject2);
      ((BuddyListFriends.BuddyChildTag)localObject1).jdField_b_of_type_ComTencentWidgetSingleLineTextView.setVisibility(0);
      if (AppSetting.j)
      {
        localObject1 = ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_JavaLangStringBuilder;
        if (localObject1 != null) {
          break label1384;
        }
        localObject1 = new StringBuilder(24);
      }
      for (;;)
      {
        ((StringBuilder)localObject1).append((String)localObject2).append(".").append(paramViewGroup).append(".");
        if ((this.jdField_a_of_type_ComTencentMobileqqDataFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) || (this.jdField_a_of_type_ComTencentMobileqqDataFriends.isServiceEnabled(EVIPSPEC.E_SP_QQVIP))) {
          ((StringBuilder)localObject1).append("QQ会员").append(".");
        }
        if (!TextUtils.isEmpty(paramView)) {
          ((StringBuilder)localObject1).append(paramView).append(".");
        }
        ((StringBuilder)localObject1).append("");
        paramOnClickListener.setContentDescription((CharSequence)localObject1);
        return paramOnClickListener;
        localObject1 = (BuddyListFriends.BuddyChildTag)paramView.getTag();
        ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0);
        ((BuddyListFriends.BuddyChildTag)localObject1).jdField_b_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, null);
        paramOnClickListener = paramView;
        break;
        label575:
        paramInt1 = 0;
        break label227;
        label580:
        paramInt2 = 2131370228;
        break label239;
        label587:
        paramView = null;
        break label295;
        label592:
        if (AppConstants.ak.equals(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin))
        {
          ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setVisibility(0);
          if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.status == 0)
          {
            paramInt1 = 1;
            label629:
            paramView = this.jdField_a_of_type_AndroidContentContext;
            if (paramInt1 == 0) {
              break label790;
            }
            paramInt2 = 2131370230;
            label641:
            paramViewGroup = paramView.getString(paramInt2);
            ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setText("[" + paramViewGroup + "]");
            localObject2 = ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_AndroidWidgetImageView;
            if (paramInt1 == 0) {
              break label797;
            }
          }
          label790:
          label797:
          for (paramView = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;; paramView = null)
          {
            ((ImageView)localObject2).setImageDrawable(paramView);
            paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131362168);
            ((BuddyListFriends.BuddyChildTag)localObject1).jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText(paramView);
            ((BuddyListFriends.BuddyChildTag)localObject1).jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendText("", 1);
            ((BuddyListFriends.BuddyChildTag)localObject1).d.setVisibility(8);
            ((BuddyListFriends.BuddyChildTag)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
            ((BuddyListFriends.BuddyChildTag)localObject1).c.setVisibility(8);
            ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(a(this.jdField_a_of_type_AndroidContentContext, 2131428267));
            break;
            paramInt1 = 0;
            break label629;
            paramInt2 = 2131370228;
            break label641;
          }
        }
        if (AppConstants.aG.equals(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.status == 0)
          {
            paramInt1 = 1;
            label830:
            if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.status != 11) {
              break label976;
            }
            paramInt1 = 0;
            ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setVisibility(8);
            ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setText("");
            paramViewGroup = paramView;
            label867:
            localObject2 = ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_AndroidWidgetImageView;
            if (paramInt1 == 0) {
              break label1116;
            }
          }
          label976:
          label1116:
          for (paramView = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;; paramView = null)
          {
            ((ImageView)localObject2).setImageDrawable(paramView);
            paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131362169);
            ((BuddyListFriends.BuddyChildTag)localObject1).jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText(paramView);
            ((BuddyListFriends.BuddyChildTag)localObject1).jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendText("", 1);
            ((BuddyListFriends.BuddyChildTag)localObject1).d.setVisibility(8);
            ((BuddyListFriends.BuddyChildTag)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
            ((BuddyListFriends.BuddyChildTag)localObject1).c.setVisibility(8);
            ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(a(this.jdField_a_of_type_AndroidContentContext, 2131428267));
            break;
            paramInt1 = 0;
            break label830;
            if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.status == 12)
            {
              ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setVisibility(0);
              paramViewGroup = this.jdField_a_of_type_AndroidContentContext.getString(2131362170);
              ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setText("[" + paramViewGroup + "]");
              break label867;
            }
            ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setVisibility(0);
            paramView = this.jdField_a_of_type_AndroidContentContext;
            if (paramInt1 != 0) {}
            for (paramInt2 = 2131370230;; paramInt2 = 2131370228)
            {
              paramViewGroup = paramView.getString(paramInt2);
              ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setText("[" + paramViewGroup + "]");
              break;
            }
          }
        }
        if (AppConstants.al.equals(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin))
        {
          ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setText("");
          ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setVisibility(8);
          ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
          paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131362163);
          ((BuddyListFriends.BuddyChildTag)localObject1).jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText(paramView);
          ((BuddyListFriends.BuddyChildTag)localObject1).jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendText("", 1);
          ((BuddyListFriends.BuddyChildTag)localObject1).d.setVisibility(8);
          ((BuddyListFriends.BuddyChildTag)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          ((BuddyListFriends.BuddyChildTag)localObject1).c.setVisibility(8);
          ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(a(this.jdField_a_of_type_AndroidContentContext, 2131428267));
          break label379;
        }
        if (!AppConstants.ai.equals(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin)) {
          break label1399;
        }
        ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setText("");
        ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactSimpleTextView.setVisibility(8);
        ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
        paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131362165);
        ((BuddyListFriends.BuddyChildTag)localObject1).jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText(paramView);
        ((BuddyListFriends.BuddyChildTag)localObject1).jdField_b_of_type_ComTencentWidgetSingleLineTextView.setExtendText("", 1);
        ((BuddyListFriends.BuddyChildTag)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        ((BuddyListFriends.BuddyChildTag)localObject1).c.setVisibility(8);
        ((BuddyListFriends.BuddyChildTag)localObject1).d.setVisibility(8);
        ((BuddyListFriends.BuddyChildTag)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(a(this.jdField_a_of_type_AndroidContentContext, 2131428267));
        a(((BuddyListFriends.BuddyChildTag)localObject1).d);
        break label379;
        label1384:
        ((StringBuilder)localObject1).delete(0, ((StringBuilder)localObject1).length());
      }
      label1399:
      paramView = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\adapter\contacts\BuddyListDevices.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */