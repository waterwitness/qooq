package com.tencent.widget;

import android.database.DataSetObserver;
import android.os.Parcelable;
import android.widget.Adapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class AdapterView$AdapterDataSetObserver
  extends DataSetObserver
{
  private Parcelable jdField_a_of_type_AndroidOsParcelable;
  
  public AdapterView$AdapterDataSetObserver(AdapterView paramAdapterView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsParcelable = null;
  }
  
  public void onChanged()
  {
    this.jdField_a_of_type_ComTencentWidgetAdapterView.r = true;
    this.jdField_a_of_type_ComTencentWidgetAdapterView.aH = this.jdField_a_of_type_ComTencentWidgetAdapterView.aG;
    this.jdField_a_of_type_ComTencentWidgetAdapterView.aG = this.jdField_a_of_type_ComTencentWidgetAdapterView.a().getCount();
    if ((this.jdField_a_of_type_ComTencentWidgetAdapterView.a().hasStableIds()) && (this.jdField_a_of_type_AndroidOsParcelable != null) && (this.jdField_a_of_type_ComTencentWidgetAdapterView.aH == 0) && (this.jdField_a_of_type_ComTencentWidgetAdapterView.aG > 0))
    {
      AdapterView.a(this.jdField_a_of_type_ComTencentWidgetAdapterView, this.jdField_a_of_type_AndroidOsParcelable);
      this.jdField_a_of_type_AndroidOsParcelable = null;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetAdapterView.z();
      this.jdField_a_of_type_ComTencentWidgetAdapterView.requestLayout();
      return;
      this.jdField_a_of_type_ComTencentWidgetAdapterView.t();
    }
  }
  
  public void onInvalidated()
  {
    this.jdField_a_of_type_ComTencentWidgetAdapterView.r = true;
    if (this.jdField_a_of_type_ComTencentWidgetAdapterView.a().hasStableIds()) {
      this.jdField_a_of_type_AndroidOsParcelable = AdapterView.a(this.jdField_a_of_type_ComTencentWidgetAdapterView);
    }
    this.jdField_a_of_type_ComTencentWidgetAdapterView.aH = this.jdField_a_of_type_ComTencentWidgetAdapterView.aG;
    this.jdField_a_of_type_ComTencentWidgetAdapterView.aG = 0;
    this.jdField_a_of_type_ComTencentWidgetAdapterView.aF = -1;
    this.jdField_a_of_type_ComTencentWidgetAdapterView.e = Long.MIN_VALUE;
    this.jdField_a_of_type_ComTencentWidgetAdapterView.aE = -1;
    this.jdField_a_of_type_ComTencentWidgetAdapterView.d = Long.MIN_VALUE;
    this.jdField_a_of_type_ComTencentWidgetAdapterView.p = false;
    this.jdField_a_of_type_ComTencentWidgetAdapterView.z();
    this.jdField_a_of_type_ComTencentWidgetAdapterView.requestLayout();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\widget\AdapterView$AdapterDataSetObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */