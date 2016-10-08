package com.tencent.mobileqq.qcall;

import android.content.Context;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.jumplightalk.CLJumpLightalkConfig;
import com.tencent.mobileqq.util.DisplayUtil;
import java.util.List;
import tyw;

public class PhoneNumberAdapter
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private CLJumpLightalkConfig jdField_a_of_type_ComTencentMobileqqJumplightalkCLJumpLightalkConfig;
  private List jdField_a_of_type_JavaUtilList;
  
  public PhoneNumberAdapter(Context paramContext, List paramList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  private View a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130904105, null);
    tyw localtyw = new tyw(null);
    localtyw.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131301417));
    localtyw.b = ((TextView)paramViewGroup.findViewById(2131301418));
    localtyw.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131301419));
    ViewGroup.LayoutParams localLayoutParams = localtyw.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    localLayoutParams.width = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 18.0F);
    localLayoutParams.height = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 18.0F);
    localtyw.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    paramViewGroup.setTag(localtyw);
    return paramViewGroup;
  }
  
  private void a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = (tyw)paramView.getTag();
    PhoneContact localPhoneContact = (PhoneContact)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    paramInt = localPhoneContact.type;
    paramView = null;
    if (paramInt == 0) {
      paramView = localPhoneContact.label;
    }
    paramView = (String)ContactsContract.CommonDataKinds.Phone.getTypeLabel(this.jdField_a_of_type_AndroidContentContext.getResources(), paramInt, paramView);
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
    paramViewGroup.b.setText(localPhoneContact.mobileNo);
  }
  
  public void a(CLJumpLightalkConfig paramCLJumpLightalkConfig)
  {
    this.jdField_a_of_type_ComTencentMobileqqJumplightalkCLJumpLightalkConfig = paramCLJumpLightalkConfig;
  }
  
  public int getCount()
  {
    int i = this.jdField_a_of_type_JavaUtilList.size();
    if (i > 20) {
      return 20;
    }
    return i;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = a(paramInt, paramViewGroup);
    }
    a(paramInt, localView, paramViewGroup);
    return localView;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\qcall\PhoneNumberAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */