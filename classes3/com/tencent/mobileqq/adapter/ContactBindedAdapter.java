package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ContactMatch;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;

public class ContactBindedAdapter
  extends FacePreloadBaseAdapter
  implements View.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List jdField_a_of_type_JavaUtilList;
  
  public ContactBindedAdapter(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView)
  {
    super(paramContext, paramQQAppInterface, paramXListView, 1, true);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)paramQQAppInterface.getManager(50));
    paramXListView.setAdapter(this);
    paramContext = (PhoneContactManagerImp)paramQQAppInterface.getManager(10);
    this.jdField_a_of_type_JavaUtilList = paramContext.a();
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
      notifyDataSetChanged();
    }
    if (paramContext.a() != 0) {
      paramContext.g();
    }
  }
  
  protected Object a(int paramInt)
  {
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList = ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).a();
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
      notifyDataSetChanged();
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size())) {
      return new ContactMatch();
    }
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    PhoneContact localPhoneContact;
    label162:
    StringBuilder localStringBuilder;
    if (paramView == null)
    {
      paramViewGroup = new ContactBindedAdapter.ConactBindedHolder();
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130904369, null);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131300785));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131296932));
      paramViewGroup.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131299657));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131302562));
      paramViewGroup.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131302564));
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131302556));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131302557));
      paramView.setTag(paramViewGroup);
      localPhoneContact = (PhoneContact)getItem(paramInt);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqDataPhoneContact = localPhoneContact;
      if ((!localPhoneContact.isNewRecommend) && (localPhoneContact.highLightTimeStamp == 0L)) {
        break label440;
      }
      paramView.setBackgroundResource(2130838316);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText("手机通讯录");
      localStringBuilder = new StringBuilder(512);
      if (TextUtils.isEmpty(localPhoneContact.name)) {
        break label449;
      }
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(localPhoneContact.name);
      if (AppSetting.j) {
        localStringBuilder.append(localPhoneContact.name);
      }
      label231:
      if (TextUtils.isEmpty(localPhoneContact.mobileNo)) {
        break label461;
      }
      paramViewGroup.c.setVisibility(0);
      paramViewGroup.c.setText(localPhoneContact.mobileNo);
      if (AppSetting.j) {
        localStringBuilder.append(",").append(localPhoneContact.mobileNo);
      }
      label284:
      paramViewGroup.jdField_d_of_type_AndroidWidgetTextView.setText("来源：手机通讯录");
      paramViewGroup.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      if (AppSetting.j) {
        localStringBuilder.append(",来源：手机通讯录");
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(localPhoneContact.unifiedCode, true)) {
        break label473;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      paramViewGroup.e.setVisibility(0);
      paramViewGroup.e.setText("等待验证");
      if (AppSetting.j)
      {
        localStringBuilder.append(",等待验证");
        paramViewGroup.e.setContentDescription("等待验证");
      }
    }
    for (;;)
    {
      if (AppSetting.j) {
        paramView.setContentDescription(localStringBuilder.toString());
      }
      paramViewGroup.jdField_b_of_type_JavaLangString = localPhoneContact.unifiedCode;
      paramViewGroup.jdField_d_of_type_AndroidWidgetImageView.setImageBitmap(a(11, localPhoneContact.unifiedCode));
      paramView.setOnClickListener(this);
      return paramView;
      paramViewGroup = (ContactBindedAdapter.ConactBindedHolder)paramView.getTag();
      break;
      label440:
      paramView.setBackgroundResource(2130838312);
      break label162;
      label449:
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      break label231;
      label461:
      paramViewGroup.c.setVisibility(8);
      break label284;
      label473:
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText("添加");
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setTag(localPhoneContact);
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      paramViewGroup.e.setVisibility(8);
      if (AppSetting.j)
      {
        localStringBuilder.append(",添加");
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setContentDescription("点击添加");
      }
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if (localObject == null) {}
    do
    {
      return;
      switch (paramView.getId())
      {
      default: 
        return;
      case 2131299656: 
        paramView = ((ContactBindedAdapter.ConactBindedHolder)localObject).jdField_a_of_type_ComTencentMobileqqDataPhoneContact;
      }
    } while (paramView == null);
    localObject = new ProfileActivity.AllInOne(paramView.unifiedCode, 34);
    ((ProfileActivity.AllInOne)localObject).h = paramView.name;
    ProfileActivity.b(this.jdField_a_of_type_AndroidContentContext, (ProfileActivity.AllInOne)localObject);
    return;
    paramView = (PhoneContact)localObject;
    paramView = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidContentContext, 2, paramView.unifiedCode, null, 3006, 3, paramView.name, null, null, "手机联系人", null);
    this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A75", "0X8006A75", 0, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\adapter\ContactBindedAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */