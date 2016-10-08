package com.tencent.mobileqq.activity.contact.newfriend;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ContactBindedActivity;
import com.tencent.mobileqq.adapter.SystemMsgListAdapter;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.newfriend.ContactBindedMessage;
import com.tencent.mobileqq.newfriend.NewFriendMessage;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.ArrayList;
import java.util.Iterator;

public class ContactBindedBuilder
  extends NewFriendBaseBuilder
  implements View.OnClickListener
{
  private static final int e = 4;
  private PhoneContactManagerImp jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  
  public ContactBindedBuilder(Context paramContext, QQAppInterface paramQQAppInterface, SystemMsgListAdapter paramSystemMsgListAdapter, NewFriendMessage paramNewFriendMessage)
  {
    super(paramContext, paramQQAppInterface, paramSystemMsgListAdapter, paramNewFriendMessage);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp = ((PhoneContactManagerImp)paramQQAppInterface.getManager(10));
    paramSystemMsgListAdapter = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a();
    if ((paramSystemMsgListAdapter != null) && (paramSystemMsgListAdapter.size() > 0))
    {
      paramContext = new ArrayList(paramSystemMsgListAdapter.size());
      paramQQAppInterface = (ArrayList)paramSystemMsgListAdapter.clone();
      paramSystemMsgListAdapter = paramSystemMsgListAdapter.iterator();
      while (paramSystemMsgListAdapter.hasNext())
      {
        paramNewFriendMessage = (PhoneContact)paramSystemMsgListAdapter.next();
        if ((paramNewFriendMessage.isNewRecommend) || (paramNewFriendMessage.highLightTimeStamp != 0L))
        {
          paramContext.add(paramNewFriendMessage);
          paramQQAppInterface.remove(paramNewFriendMessage);
        }
      }
      int k = paramContext.size();
      int j = paramQQAppInterface.size();
      if (k >= 4)
      {
        j = k;
        while ((i < 4) && (j > 0))
        {
          k = (int)(j * Math.random());
          this.jdField_a_of_type_JavaUtilArrayList.add(paramContext.get(k));
          paramContext.remove(k);
          j -= 1;
          i += 1;
        }
      }
      if (k != 0) {
        this.jdField_a_of_type_JavaUtilArrayList.addAll(paramContext);
      }
      k = this.jdField_a_of_type_JavaUtilArrayList.size();
      i = 0;
      while ((i < 4 - k) && (j > 0))
      {
        int m = (int)(j * Math.random());
        this.jdField_a_of_type_JavaUtilArrayList.add(paramQQAppInterface.get(m));
        paramQQAppInterface.remove(m);
        j -= 1;
        i += 1;
      }
    }
  }
  
  public View a(int paramInt, View paramView)
  {
    ContactBindedBuilder.ContactBindedHolder localContactBindedHolder;
    if ((paramView == null) || (!(paramView.getTag() instanceof ContactBindedBuilder.ContactBindedHolder)))
    {
      localContactBindedHolder = new ContactBindedBuilder.ContactBindedHolder();
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130904268, null);
      localContactBindedHolder.e = ((TextView)paramView.findViewById(2131302103));
      localContactBindedHolder.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131302105);
      localContactBindedHolder.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131302108);
      localContactBindedHolder.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131302111);
      localContactBindedHolder.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131302114);
      localContactBindedHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131302106));
      localContactBindedHolder.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131302109));
      localContactBindedHolder.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131302112));
      localContactBindedHolder.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131302115));
      localContactBindedHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131302107));
      localContactBindedHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131302110));
      localContactBindedHolder.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131302113));
      localContactBindedHolder.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131302116));
      paramView.setTag(localContactBindedHolder);
    }
    Object localObject1;
    int j;
    Object localObject2;
    for (;;)
    {
      localObject1 = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a();
      j = ((ArrayList)localObject1).size();
      localContactBindedHolder.e.setText(String.format("还有%d位手机通讯录好友也在使用QQ", new Object[] { Integer.valueOf(j) }));
      localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject2).hasNext()) {
        if (this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.b(((PhoneContact)((Iterator)localObject2).next()).mobileNo) == null) {
          ((Iterator)localObject2).remove();
        }
      }
      localContactBindedHolder = (ContactBindedBuilder.ContactBindedHolder)paramView.getTag();
    }
    paramInt = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i = paramInt;
    if (paramInt < 4)
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      i = paramInt;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (PhoneContact)((Iterator)localObject1).next();
        if (this.jdField_a_of_type_JavaUtilArrayList.contains(localObject2)) {
          break label1163;
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
        paramInt += 1;
      }
    }
    label420:
    label1163:
    for (;;)
    {
      if (paramInt == 4)
      {
        i = paramInt;
        switch (i)
        {
        default: 
          if (AppSetting.j) {
            paramView.setContentDescription(String.format("还有%d位手机通讯录联系人也在使用QQ，点击查看", new Object[] { Integer.valueOf(j) }));
          }
          if (!this.jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendMessage.a()) {
            paramView.setBackgroundResource(2130838316);
          }
          break;
        }
      }
      for (;;)
      {
        paramView.setOnClickListener(this);
        return paramView;
        break;
        localContactBindedHolder.jdField_a_of_type_AndroidViewView.setVisibility(0);
        localContactBindedHolder.jdField_b_of_type_AndroidViewView.setVisibility(4);
        localContactBindedHolder.jdField_c_of_type_AndroidViewView.setVisibility(4);
        localContactBindedHolder.jdField_d_of_type_AndroidViewView.setVisibility(4);
        localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        localContactBindedHolder.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
        localContactBindedHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter.a(11, localContactBindedHolder.jdField_a_of_type_JavaLangString));
        localContactBindedHolder.jdField_a_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
        break label420;
        localContactBindedHolder.jdField_a_of_type_AndroidViewView.setVisibility(0);
        localContactBindedHolder.jdField_b_of_type_AndroidViewView.setVisibility(0);
        localContactBindedHolder.jdField_c_of_type_AndroidViewView.setVisibility(4);
        localContactBindedHolder.jdField_d_of_type_AndroidViewView.setVisibility(4);
        localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        localContactBindedHolder.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
        localContactBindedHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter.a(11, localContactBindedHolder.jdField_a_of_type_JavaLangString));
        localContactBindedHolder.jdField_a_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
        localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(1);
        localContactBindedHolder.jdField_b_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
        localContactBindedHolder.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter.a(11, localContactBindedHolder.jdField_b_of_type_JavaLangString));
        localContactBindedHolder.jdField_b_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
        break label420;
        localContactBindedHolder.jdField_a_of_type_AndroidViewView.setVisibility(0);
        localContactBindedHolder.jdField_b_of_type_AndroidViewView.setVisibility(0);
        localContactBindedHolder.jdField_c_of_type_AndroidViewView.setVisibility(0);
        localContactBindedHolder.jdField_d_of_type_AndroidViewView.setVisibility(4);
        localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        localContactBindedHolder.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
        localContactBindedHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter.a(11, localContactBindedHolder.jdField_a_of_type_JavaLangString));
        localContactBindedHolder.jdField_a_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
        localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(1);
        localContactBindedHolder.jdField_b_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
        localContactBindedHolder.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter.a(11, localContactBindedHolder.jdField_b_of_type_JavaLangString));
        localContactBindedHolder.jdField_b_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
        localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(2);
        localContactBindedHolder.jdField_c_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
        localContactBindedHolder.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter.a(11, localContactBindedHolder.jdField_c_of_type_JavaLangString));
        localContactBindedHolder.jdField_c_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
        break label420;
        localContactBindedHolder.jdField_a_of_type_AndroidViewView.setVisibility(0);
        localContactBindedHolder.jdField_b_of_type_AndroidViewView.setVisibility(0);
        localContactBindedHolder.jdField_c_of_type_AndroidViewView.setVisibility(0);
        localContactBindedHolder.jdField_d_of_type_AndroidViewView.setVisibility(0);
        localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        localContactBindedHolder.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
        localContactBindedHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter.a(11, localContactBindedHolder.jdField_a_of_type_JavaLangString));
        localContactBindedHolder.jdField_a_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
        localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(1);
        localContactBindedHolder.jdField_b_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
        localContactBindedHolder.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter.a(11, localContactBindedHolder.jdField_b_of_type_JavaLangString));
        localContactBindedHolder.jdField_b_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
        localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(2);
        localContactBindedHolder.jdField_c_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
        localContactBindedHolder.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter.a(11, localContactBindedHolder.jdField_c_of_type_JavaLangString));
        localContactBindedHolder.jdField_c_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
        localObject1 = (PhoneContact)this.jdField_a_of_type_JavaUtilArrayList.get(3);
        localContactBindedHolder.jdField_d_of_type_JavaLangString = ((PhoneContact)localObject1).unifiedCode;
        localContactBindedHolder.jdField_d_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter.a(11, localContactBindedHolder.jdField_d_of_type_JavaLangString));
        localContactBindedHolder.jdField_d_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject1).name);
        break label420;
        paramView.setBackgroundResource(2130838312);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      paramView = paramView.getTag();
    } while ((paramView == null) || (!(paramView instanceof ContactBindedBuilder.ContactBindedHolder)));
    paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, ContactBindedActivity.class);
    ((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(paramView, 222);
    ((ContactBindedMessage)this.jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendMessage).a.isReaded = true;
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A70", "0X8006A70", 0, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\contact\newfriend\ContactBindedBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */