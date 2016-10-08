package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.graphics.drawable.ColorDrawable;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.ListView;
import wcm;
import wcn;

public class QQCustomSingleChoiceDialog
  extends QQCustomDialog
{
  public int a;
  public DialogInterface.OnClickListener a;
  private BaseAdapter jdField_a_of_type_AndroidWidgetBaseAdapter;
  QQCustomMenu jdField_a_of_type_ComTencentMobileqqUtilsDialogutilsQQCustomMenu;
  AdapterView.OnItemClickListener jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener;
  public CharSequence[] a;
  
  public QQCustomSingleChoiceDialog(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidWidgetBaseAdapter = new wcm(this);
    this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener = new wcn(this);
  }
  
  public QQCustomSingleChoiceDialog(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.jdField_a_of_type_AndroidWidgetBaseAdapter = new wcm(this);
    this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener = new wcn(this);
  }
  
  protected QQCustomSingleChoiceDialog(Context paramContext, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    super(paramContext, paramBoolean, paramOnCancelListener);
    this.jdField_a_of_type_AndroidWidgetBaseAdapter = new wcm(this);
    this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener = new wcn(this);
  }
  
  public QQCustomSingleChoiceDialog a(CharSequence[] paramArrayOfCharSequence, int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    this.text.setVisibility(8);
    this.bodyLayout.setVisibility(8);
    this.list.setVisibility(0);
    this.list.setAdapter(this.jdField_a_of_type_AndroidWidgetBaseAdapter);
    this.list.setOnItemClickListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener);
    this.list.setDivider(new ColorDrawable(-4011827));
    this.list.setDividerHeight(1);
    this.jdField_a_of_type_ArrayOfJavaLangCharSequence = paramArrayOfCharSequence;
    this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\utils\QQCustomSingleChoiceDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */