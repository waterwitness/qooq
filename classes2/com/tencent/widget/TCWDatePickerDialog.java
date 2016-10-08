package com.tencent.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.text.DateFormat;
import java.util.Calendar;

public class TCWDatePickerDialog
  extends AlertDialog
  implements DialogInterface.OnClickListener, TCWDatePicker.OnDateChangedListener
{
  private static final String jdField_a_of_type_JavaLangString = "year";
  private static final String jdField_b_of_type_JavaLangString = "month";
  private static final String jdField_c_of_type_JavaLangString = "day";
  private int jdField_a_of_type_Int;
  private final TCWDatePicker jdField_a_of_type_ComTencentWidgetTCWDatePicker;
  private final TCWDatePickerDialog.OnDateSetListener jdField_a_of_type_ComTencentWidgetTCWDatePickerDialog$OnDateSetListener;
  private final DateFormat jdField_a_of_type_JavaTextDateFormat;
  private final Calendar jdField_a_of_type_JavaUtilCalendar;
  private int jdField_b_of_type_Int;
  private int jdField_c_of_type_Int;
  
  public TCWDatePickerDialog(Context paramContext, int paramInt1, TCWDatePickerDialog.OnDateSetListener paramOnDateSetListener, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramContext, paramInt1);
    this.jdField_a_of_type_ComTencentWidgetTCWDatePickerDialog$OnDateSetListener = paramOnDateSetListener;
    this.jdField_a_of_type_Int = paramInt2;
    this.b = paramInt3;
    this.c = paramInt4;
    this.jdField_a_of_type_JavaTextDateFormat = DateFormat.getDateInstance(0);
    this.jdField_a_of_type_JavaUtilCalendar = Calendar.getInstance();
    b(this.jdField_a_of_type_Int, this.b, this.c);
    setButton(-2, paramContext.getText(17039370), new CustomDIOnClickListener(this));
    setButton(-1, paramContext.getText(17039360), (DialogInterface.OnClickListener)null);
    setIcon(0);
    paramContext = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130903283, null);
    setView(paramContext);
    this.jdField_a_of_type_ComTencentWidgetTCWDatePicker = ((TCWDatePicker)paramContext.findViewById(2131297973));
    this.jdField_a_of_type_ComTencentWidgetTCWDatePicker.a(this.jdField_a_of_type_Int, this.b, this.c, this);
  }
  
  public TCWDatePickerDialog(Context paramContext, TCWDatePickerDialog.OnDateSetListener paramOnDateSetListener, int paramInt1, int paramInt2, int paramInt3)
  {
    this(paramContext, 2131559173, paramOnDateSetListener, paramInt1, paramInt2, paramInt3);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void b(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_JavaUtilCalendar.set(1, paramInt1);
    this.jdField_a_of_type_JavaUtilCalendar.set(2, paramInt2);
    this.jdField_a_of_type_JavaUtilCalendar.set(5, paramInt3);
    setTitle(this.jdField_a_of_type_JavaTextDateFormat.format(this.jdField_a_of_type_JavaUtilCalendar.getTime()));
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.jdField_a_of_type_ComTencentWidgetTCWDatePicker.a(paramInt1, paramInt2, paramInt3);
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_ComTencentWidgetTCWDatePicker.setMinDate(paramLong);
  }
  
  public void a(TCWDatePicker paramTCWDatePicker, int paramInt1, int paramInt2, int paramInt3)
  {
    b(paramInt1, paramInt2, paramInt3);
  }
  
  public void b(long paramLong)
  {
    this.jdField_a_of_type_ComTencentWidgetTCWDatePicker.setMaxDate(paramLong);
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentWidgetTCWDatePickerDialog$OnDateSetListener != null)
    {
      this.jdField_a_of_type_ComTencentWidgetTCWDatePicker.clearFocus();
      this.jdField_a_of_type_ComTencentWidgetTCWDatePickerDialog$OnDateSetListener.a(this.jdField_a_of_type_ComTencentWidgetTCWDatePicker, this.jdField_a_of_type_ComTencentWidgetTCWDatePicker.a(), this.jdField_a_of_type_ComTencentWidgetTCWDatePicker.b(), this.jdField_a_of_type_ComTencentWidgetTCWDatePicker.c());
    }
  }
  
  public void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
    int i = paramBundle.getInt("year");
    int j = paramBundle.getInt("month");
    int k = paramBundle.getInt("day");
    this.jdField_a_of_type_ComTencentWidgetTCWDatePicker.a(i, j, k, this);
    b(i, j, k);
  }
  
  public Bundle onSaveInstanceState()
  {
    Bundle localBundle = super.onSaveInstanceState();
    localBundle.putInt("year", this.jdField_a_of_type_ComTencentWidgetTCWDatePicker.a());
    localBundle.putInt("month", this.jdField_a_of_type_ComTencentWidgetTCWDatePicker.b());
    localBundle.putInt("day", this.jdField_a_of_type_ComTencentWidgetTCWDatePicker.c());
    return localBundle;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\widget\TCWDatePickerDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */