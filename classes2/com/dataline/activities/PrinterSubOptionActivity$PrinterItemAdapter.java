package com.dataline.activities;

import android.content.res.Resources;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import ci;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

public class PrinterSubOptionActivity$PrinterItemAdapter
  extends BaseAdapter
{
  static final int jdField_a_of_type_Int = 0;
  static final int b = 1;
  static final int c = 2;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  
  public PrinterSubOptionActivity$PrinterItemAdapter(PrinterSubOptionActivity paramPrinterSubOptionActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ci(this);
  }
  
  public int getCount()
  {
    if ((this.jdField_a_of_type_ComDatalineActivitiesPrinterSubOptionActivity.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_ComDatalineActivitiesPrinterSubOptionActivity.jdField_a_of_type_JavaUtilList.size() > 0)) {
      return this.jdField_a_of_type_ComDatalineActivitiesPrinterSubOptionActivity.jdField_a_of_type_JavaUtilList.size();
    }
    return 1;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_ComDatalineActivitiesPrinterSubOptionActivity.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComDatalineActivitiesPrinterSubOptionActivity.jdField_a_of_type_JavaUtilList != null) && (paramInt < this.jdField_a_of_type_ComDatalineActivitiesPrinterSubOptionActivity.jdField_a_of_type_JavaUtilList.size())) {
      return this.jdField_a_of_type_ComDatalineActivitiesPrinterSubOptionActivity.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return this.jdField_a_of_type_ComDatalineActivitiesPrinterSubOptionActivity.jdField_a_of_type_JavaLangString;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.jdField_a_of_type_ComDatalineActivitiesPrinterSubOptionActivity.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_ComDatalineActivitiesPrinterSubOptionActivity.jdField_a_of_type_JavaUtilList.size() > 0)) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    String str = (String)getItem(paramInt);
    View localView;
    if (paramView == null) {
      if (getItemViewType(paramInt) == 0)
      {
        localView = this.jdField_a_of_type_ComDatalineActivitiesPrinterSubOptionActivity.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903057, null);
        localView.setBackgroundColor(-1);
        localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramViewGroup = (TextView)localView.findViewById(2131296886);
        paramViewGroup.setTextColor(-16777216);
        paramViewGroup.setGravity(3);
        paramViewGroup.setPadding(50, 1, 50, 1);
        paramViewGroup.setTextSize(19.0F);
        paramViewGroup.setSingleLine(true);
        paramViewGroup.setEllipsize(TextUtils.TruncateAt.END);
        localView.setBackgroundDrawable(this.jdField_a_of_type_ComDatalineActivitiesPrinterSubOptionActivity.getResources().getDrawable(2130837526));
      }
    }
    for (;;)
    {
      paramViewGroup.setText(str);
      return localView;
      localView = this.jdField_a_of_type_ComDatalineActivitiesPrinterSubOptionActivity.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903281, null);
      localView.findViewById(2131297966).setVisibility(8);
      paramViewGroup = (TextView)localView.findViewById(2131297967);
      paramViewGroup.setTextSize(19.0F);
      paramViewGroup.setTextColor(-16777216);
      continue;
      TextView localTextView = (TextView)paramView.findViewById(2131296886);
      paramViewGroup = localTextView;
      localView = paramView;
      if (localTextView == null)
      {
        paramViewGroup = (TextView)paramView.findViewById(2131297967);
        localView = paramView;
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\dataline\activities\PrinterSubOptionActivity$PrinterItemAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */