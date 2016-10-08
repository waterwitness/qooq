package com.tencent.mobileqq.activity.selectmember;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopMemberListActivity.ViewHolder;
import com.tencent.mobileqq.adapter.CharDividedFacePreloadBaseAdapter;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ContactUtils;

public class SelectActivityViewHolder
  extends TroopMemberListActivity.ViewHolder
{
  public static final String a = "pstn";
  public View a;
  public CheckBox a;
  public PhoneContact a;
  public boolean a;
  public TextView e;
  public TextView f;
  
  public SelectActivityViewHolder()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ("0".equals(paramString)) {
      return 11;
    }
    return 1;
  }
  
  public static View a(ViewGroup paramViewGroup, LayoutInflater paramLayoutInflater, int paramInt)
  {
    paramViewGroup = paramLayoutInflater.inflate(paramInt, paramViewGroup, false);
    paramLayoutInflater = new SelectActivityViewHolder();
    paramViewGroup.setTag(paramLayoutInflater);
    paramLayoutInflater.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewGroup.findViewById(2131297780));
    paramLayoutInflater.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131297779));
    paramLayoutInflater.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramViewGroup.findViewById(2131297781));
    paramLayoutInflater.d = ((ImageView)paramViewGroup.findViewById(2131296790));
    paramLayoutInflater.e = ((TextView)paramViewGroup.findViewById(2131297782));
    paramLayoutInflater.f = ((TextView)paramViewGroup.findViewById(2131297783));
    paramLayoutInflater.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131296829));
    paramLayoutInflater.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131297784);
    return paramViewGroup;
  }
  
  public static void a(CharDividedFacePreloadBaseAdapter paramCharDividedFacePreloadBaseAdapter, SelectActivityViewHolder paramSelectActivityViewHolder, PhoneContact paramPhoneContact)
  {
    paramSelectActivityViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    paramSelectActivityViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    paramSelectActivityViewHolder.jdField_c_of_type_Int = a(paramPhoneContact.uin);
    if (TextUtils.isEmpty(paramPhoneContact.uin))
    {
      paramSelectActivityViewHolder.b = ("pstn" + paramPhoneContact.mobileNo);
      paramSelectActivityViewHolder.d.setImageResource(2130839106);
      paramSelectActivityViewHolder.e.setVisibility(0);
      paramSelectActivityViewHolder.e.setText(ContactUtils.a(paramPhoneContact.name));
      paramSelectActivityViewHolder.jdField_a_of_type_Boolean = true;
      return;
    }
    if (!"0".equals(paramPhoneContact.uin))
    {
      paramSelectActivityViewHolder.b = paramPhoneContact.uin;
      paramSelectActivityViewHolder.d.setImageBitmap(paramCharDividedFacePreloadBaseAdapter.a(paramSelectActivityViewHolder.b, 1, (byte)0));
      paramSelectActivityViewHolder.e.setVisibility(8);
      paramSelectActivityViewHolder.jdField_a_of_type_Boolean = false;
      return;
    }
    paramSelectActivityViewHolder.b = (paramPhoneContact.nationCode + paramPhoneContact.mobileCode);
    paramSelectActivityViewHolder.d.setImageBitmap(paramCharDividedFacePreloadBaseAdapter.a(paramSelectActivityViewHolder.b, 11, (byte)0));
    paramSelectActivityViewHolder.e.setVisibility(8);
    paramSelectActivityViewHolder.jdField_a_of_type_Boolean = false;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\selectmember\SelectActivityViewHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */