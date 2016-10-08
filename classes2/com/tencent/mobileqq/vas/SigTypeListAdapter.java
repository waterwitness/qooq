package com.tencent.mobileqq.vas;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.os.MqqHandler;

public class SigTypeListAdapter
  extends BaseAdapter
{
  public int a;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  SignatureTemplateConfig.SignatureTemplateType[] jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType;
  
  public SigTypeListAdapter(QQAppInterface paramQQAppInterface, MqqHandler paramMqqHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType = null;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramQQAppInterface.a());
    this.jdField_a_of_type_MqqOsMqqHandler = paramMqqHandler;
  }
  
  public void a(SignatureTemplateConfig.SignatureTemplateType[] paramArrayOfSignatureTemplateType)
  {
    this.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType = paramArrayOfSignatureTemplateType;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType == null) {
      return 0;
    }
    return this.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType.length;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType == null) || (this.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType.length <= paramInt)) {
      return null;
    }
    return this.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType[paramInt];
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130905006, null);
      paramView = new SigTypeListAdapter.Holder(this);
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131305030));
      paramView.jdField_a_of_type_AndroidViewView = localView.findViewById(2131305031);
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType[paramInt].a);
      if (paramInt != this.jdField_a_of_type_Int) {
        break;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#1fbaf3"));
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return localView;
      paramViewGroup = (SigTypeListAdapter.Holder)paramView.getTag();
      localView = paramView;
    }
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#777777"));
    paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
    return localView;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vas\SigTypeListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */