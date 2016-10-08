package com.tencent.mobileqq.adapter.contacts;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.widget.SingleLineTextView;
import ppl;

public class BuddyListPhone
  extends BuddyListItem
{
  protected BuddyListPhone(QQAppInterface paramQQAppInterface, Context paramContext, Entity paramEntity)
  {
    super(paramQQAppInterface, paramContext, paramEntity);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public View a(int paramInt1, int paramInt2, View paramView, ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener)
  {
    PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
    PhoneContact localPhoneContact;
    if ((paramView == null) || (!(paramView.getTag() instanceof ppl)))
    {
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903220, paramViewGroup, false);
      paramOnClickListener = new ppl();
      paramOnClickListener.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131296790));
      paramOnClickListener.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramViewGroup.findViewById(2131297741));
      paramOnClickListener.c = ((SingleLineTextView)paramViewGroup.findViewById(2131297743));
      paramOnClickListener.b = ((ImageView)paramViewGroup.findViewById(2131297734));
      paramOnClickListener.d = ((SingleLineTextView)paramViewGroup.findViewById(2131297763));
      paramViewGroup.setTag(paramOnClickListener);
      localPhoneContact = (PhoneContact)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntity;
      paramOnClickListener.jdField_a_of_type_JavaLangObject = localPhoneContact;
      paramOnClickListener.jdField_a_of_type_JavaLangString = localPhoneContact.mobileCode;
      paramInt2 = ContactUtils.a(localPhoneContact.detalStatusFlag, localPhoneContact.iTermType);
      paramView = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
      paramInt1 = localPhoneContact.netTypeIconId;
    }
    label281:
    Drawable localDrawable;
    switch (paramInt2)
    {
    case 5: 
    case 6: 
    default: 
      paramView = paramView.a(localPhoneContactManagerImp.a(localPhoneContact.unifiedCode));
      if (paramView == null) {
        paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131370230);
      }
      break;
    case 1: 
    case 2: 
    case 7: 
    case 3: 
    case 4: 
    case 8: 
      for (;;)
      {
        if ((paramInt2 == 0) || (paramInt2 == 6))
        {
          paramInt2 = 1;
          if ((localPhoneContactManagerImp.e & 0x8) != 8L)
          {
            localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840575);
            ImageView localImageView = paramOnClickListener.jdField_a_of_type_AndroidWidgetImageView;
            if (paramInt2 == 0) {
              break label604;
            }
            label322:
            localImageView.setImageDrawable(localDrawable);
          }
          if ((localPhoneContact.highLightTimeStamp == 0L) && (!localPhoneContact.isNewRecommend)) {
            break label610;
          }
          paramViewGroup.setBackgroundColor(-199994);
          paramOnClickListener.d.setVisibility(0);
          label363:
          if ((localPhoneContactManagerImp.e & 0x4) != 4L) {
            break label648;
          }
          paramInt2 = 1;
          label381:
          if (paramInt2 == 0) {
            break label653;
          }
          paramOnClickListener.c.setVisibility(8);
          label395:
          paramOnClickListener.b.setVisibility(8);
          paramOnClickListener.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(a(this.jdField_a_of_type_AndroidContentContext, 2131428267));
          paramOnClickListener.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(localPhoneContact.name);
          if (AppSetting.j)
          {
            paramOnClickListener = paramOnClickListener.jdField_a_of_type_JavaLangStringBuilder;
            if (paramOnClickListener != null) {
              break label697;
            }
            paramOnClickListener = new StringBuilder(24);
            label464:
            paramOnClickListener.append(localPhoneContact.name).append(".").append(paramView).append(".");
            paramOnClickListener.append(ContactUtils.b(paramInt1));
            paramViewGroup.setContentDescription(paramOnClickListener);
          }
          return paramViewGroup;
          paramOnClickListener = (ppl)paramView.getTag();
          paramViewGroup = paramView;
          break;
          paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131370225);
          continue;
          paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131370226);
          continue;
          if ((paramInt2 != 8) || ((localPhoneContact.abilityBits & 1L) != 0L)) {
            break label715;
          }
          if (localPhoneContact.netTypeIconIdIphoneOrWphoneNoWifi != 0) {
            paramInt1 = localPhoneContact.netTypeIconIdIphoneOrWphoneNoWifi;
          }
        }
      }
    }
    label604:
    label610:
    label648:
    label653:
    label697:
    label715:
    for (;;)
    {
      paramView = ContactUtils.a(paramInt1);
      break;
      paramInt1 = localPhoneContact.netTypeIconId;
      continue;
      paramInt2 = 0;
      break label281;
      localDrawable = null;
      break label322;
      paramViewGroup.setBackgroundResource(2130838314);
      paramViewGroup.setPadding(0, 0, (int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), 0);
      paramOnClickListener.d.setVisibility(8);
      break label363;
      paramInt2 = 0;
      break label381;
      paramOnClickListener.c.setText("[" + paramView + "]");
      paramOnClickListener.c.setVisibility(0);
      break label395;
      paramOnClickListener.delete(0, paramOnClickListener.length());
      break label464;
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\adapter\contacts\BuddyListPhone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */