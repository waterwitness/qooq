package com.tencent.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import xuz;

public class TCWDatePicker
  extends FrameLayout
{
  private static final int jdField_a_of_type_Int = 1900;
  private static final String jdField_a_of_type_JavaLangString = "MM/dd/yyyy";
  private static final int jdField_b_of_type_Int = 2100;
  private TCWDatePicker.OnDateChangedListener jdField_a_of_type_ComTencentWidgetTCWDatePicker$OnDateChangedListener;
  private final TCWNumberPicker jdField_a_of_type_ComTencentWidgetTCWNumberPicker;
  private final java.text.DateFormat jdField_a_of_type_JavaTextDateFormat = new SimpleDateFormat("MM/dd/yyyy");
  private Calendar jdField_a_of_type_JavaUtilCalendar;
  private Locale jdField_a_of_type_JavaUtilLocale;
  private final TCWNumberPicker jdField_b_of_type_ComTencentWidgetTCWNumberPicker;
  private Calendar jdField_b_of_type_JavaUtilCalendar;
  private final TCWNumberPicker jdField_c_of_type_ComTencentWidgetTCWNumberPicker;
  private Calendar jdField_c_of_type_JavaUtilCalendar;
  private Calendar d;
  
  public TCWDatePicker(Context paramContext)
  {
    this(paramContext, null);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public TCWDatePicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TCWDatePicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(Locale.getDefault());
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130903282, this, true);
    Object localObject1 = new xuz(this);
    this.jdField_a_of_type_ComTencentWidgetTCWNumberPicker = ((TCWNumberPicker)findViewById(2131297971));
    this.jdField_a_of_type_ComTencentWidgetTCWNumberPicker.setFormatter(TCWNumberPicker.a);
    this.jdField_a_of_type_ComTencentWidgetTCWNumberPicker.setSpeed(100L);
    this.jdField_a_of_type_ComTencentWidgetTCWNumberPicker.setOnChangeListener((TCWNumberPicker.OnChangedListener)localObject1);
    this.jdField_b_of_type_ComTencentWidgetTCWNumberPicker = ((TCWNumberPicker)findViewById(2131297970));
    this.jdField_b_of_type_ComTencentWidgetTCWNumberPicker.setFormatter(TCWNumberPicker.a);
    Object localObject2 = new DateFormatSymbols();
    this.jdField_b_of_type_ComTencentWidgetTCWNumberPicker.setRange(1, 12, ((DateFormatSymbols)localObject2).getShortMonths());
    this.jdField_b_of_type_ComTencentWidgetTCWNumberPicker.setSpeed(200L);
    this.jdField_b_of_type_ComTencentWidgetTCWNumberPicker.setOnChangeListener((TCWNumberPicker.OnChangedListener)localObject1);
    this.jdField_c_of_type_ComTencentWidgetTCWNumberPicker = ((TCWNumberPicker)findViewById(2131297972));
    this.jdField_c_of_type_ComTencentWidgetTCWNumberPicker.setSpeed(100L);
    this.jdField_c_of_type_ComTencentWidgetTCWNumberPicker.setOnChangeListener((TCWNumberPicker.OnChangedListener)localObject1);
    if (AppSetting.j)
    {
      localObject1 = (TCWNumberPickerButton)this.jdField_a_of_type_ComTencentWidgetTCWNumberPicker.findViewById(2131298548);
      localObject2 = (TCWNumberPickerButton)this.jdField_a_of_type_ComTencentWidgetTCWNumberPicker.findViewById(2131298550);
      ((TCWNumberPickerButton)localObject1).setContentDescription(getContext().getString(2131371286));
      ((TCWNumberPickerButton)localObject2).setContentDescription(getContext().getString(2131371287));
      localObject1 = (TCWNumberPickerButton)this.jdField_b_of_type_ComTencentWidgetTCWNumberPicker.findViewById(2131298548);
      localObject2 = (TCWNumberPickerButton)this.jdField_b_of_type_ComTencentWidgetTCWNumberPicker.findViewById(2131298550);
      ((TCWNumberPickerButton)localObject1).setContentDescription(getContext().getString(2131371284));
      ((TCWNumberPickerButton)localObject2).setContentDescription(getContext().getString(2131371285));
      localObject1 = (TCWNumberPickerButton)this.jdField_c_of_type_ComTencentWidgetTCWNumberPicker.findViewById(2131298548);
      localObject2 = (TCWNumberPickerButton)this.jdField_c_of_type_ComTencentWidgetTCWNumberPicker.findViewById(2131298550);
      ((TCWNumberPickerButton)localObject1).setContentDescription(getContext().getString(2131371282));
      ((TCWNumberPickerButton)localObject2).setContentDescription(getContext().getString(2131371283));
    }
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ar);
    paramInt = paramContext.getInt(0, 1900);
    int i = paramContext.getInt(1, 2100);
    paramAttributeSet = paramContext.getString(2);
    localObject1 = paramContext.getString(3);
    this.jdField_c_of_type_ComTencentWidgetTCWNumberPicker.setRange(paramInt, i);
    paramContext.recycle();
    this.jdField_b_of_type_JavaUtilCalendar.clear();
    if (!TextUtils.isEmpty(paramAttributeSet))
    {
      if (!a(paramAttributeSet, this.jdField_b_of_type_JavaUtilCalendar)) {
        this.jdField_b_of_type_JavaUtilCalendar.set(paramInt, 0, 1);
      }
      setMinDate(this.jdField_b_of_type_JavaUtilCalendar.getTimeInMillis());
      this.jdField_b_of_type_JavaUtilCalendar.clear();
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label591;
      }
      if (!a((String)localObject1, this.jdField_b_of_type_JavaUtilCalendar)) {
        this.jdField_b_of_type_JavaUtilCalendar.set(i, 11, 31);
      }
    }
    for (;;)
    {
      setMaxDate(this.jdField_b_of_type_JavaUtilCalendar.getTimeInMillis());
      this.jdField_a_of_type_JavaUtilCalendar.setTimeInMillis(System.currentTimeMillis());
      a(this.jdField_a_of_type_JavaUtilCalendar.get(1), this.jdField_a_of_type_JavaUtilCalendar.get(2), this.jdField_a_of_type_JavaUtilCalendar.get(5), null);
      a();
      if (!isEnabled()) {
        setEnabled(false);
      }
      return;
      this.jdField_b_of_type_JavaUtilCalendar.set(paramInt, 0, 1);
      break;
      label591:
      this.jdField_b_of_type_JavaUtilCalendar.set(i, 11, 31);
    }
  }
  
  private Calendar a(Calendar paramCalendar, Locale paramLocale)
  {
    if (paramCalendar == null) {
      return Calendar.getInstance(paramLocale);
    }
    long l = paramCalendar.getTimeInMillis();
    paramCalendar = Calendar.getInstance(paramLocale);
    paramCalendar.setTimeInMillis(l);
    return paramCalendar;
  }
  
  private void a()
  {
    int i = 0;
    char[] arrayOfChar = android.text.format.DateFormat.getDateFormatOrder(getContext());
    if ((arrayOfChar[0] == 'M') && (arrayOfChar[1] == 'd')) {
      return;
    }
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131297969);
    localLinearLayout.removeAllViews();
    int j = arrayOfChar.length;
    label45:
    int k;
    if (i < j)
    {
      k = arrayOfChar[i];
      if (k != 100) {
        break label78;
      }
      localLinearLayout.addView(this.jdField_a_of_type_ComTencentWidgetTCWNumberPicker);
    }
    for (;;)
    {
      i += 1;
      break label45;
      break;
      label78:
      if (k == 77) {
        localLinearLayout.addView(this.jdField_b_of_type_ComTencentWidgetTCWNumberPicker);
      } else {
        localLinearLayout.addView(this.jdField_c_of_type_ComTencentWidgetTCWNumberPicker);
      }
    }
  }
  
  private void a(Locale paramLocale)
  {
    if (paramLocale.equals(this.jdField_a_of_type_JavaUtilLocale)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilLocale = paramLocale;
    this.jdField_b_of_type_JavaUtilCalendar = a(this.jdField_b_of_type_JavaUtilCalendar, paramLocale);
    this.jdField_c_of_type_JavaUtilCalendar = a(this.jdField_c_of_type_JavaUtilCalendar, paramLocale);
    this.d = a(this.d, paramLocale);
    this.jdField_a_of_type_JavaUtilCalendar = a(this.jdField_a_of_type_JavaUtilCalendar, paramLocale);
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    return (this.jdField_a_of_type_JavaUtilCalendar.get(1) != paramInt1) || (this.jdField_a_of_type_JavaUtilCalendar.get(2) != paramInt3) || (this.jdField_a_of_type_JavaUtilCalendar.get(5) != paramInt2);
  }
  
  private boolean a(String paramString, Calendar paramCalendar)
  {
    try
    {
      paramCalendar.setTime(this.jdField_a_of_type_JavaTextDateFormat.parse(paramString));
      return true;
    }
    catch (ParseException paramString) {}
    return false;
  }
  
  private void b()
  {
    c();
    this.jdField_c_of_type_ComTencentWidgetTCWNumberPicker.setCurrent(this.jdField_a_of_type_JavaUtilCalendar.get(1));
    this.jdField_b_of_type_ComTencentWidgetTCWNumberPicker.setCurrent(this.jdField_a_of_type_JavaUtilCalendar.get(2) + 1);
  }
  
  private void b(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_JavaUtilCalendar.set(paramInt1, paramInt2, paramInt3);
    if (this.jdField_a_of_type_JavaUtilCalendar.before(this.jdField_c_of_type_JavaUtilCalendar)) {
      this.jdField_a_of_type_JavaUtilCalendar.setTimeInMillis(this.jdField_c_of_type_JavaUtilCalendar.getTimeInMillis());
    }
    while (!this.jdField_a_of_type_JavaUtilCalendar.after(this.d)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilCalendar.setTimeInMillis(this.d.getTimeInMillis());
  }
  
  private void c()
  {
    int i = this.jdField_a_of_type_JavaUtilCalendar.getActualMaximum(5);
    this.jdField_a_of_type_ComTencentWidgetTCWNumberPicker.setRange(1, i);
    this.jdField_a_of_type_ComTencentWidgetTCWNumberPicker.setCurrent(this.jdField_a_of_type_JavaUtilCalendar.get(5));
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentWidgetTCWDatePicker$OnDateChangedListener != null) {
      this.jdField_a_of_type_ComTencentWidgetTCWDatePicker$OnDateChangedListener.a(this, a(), b(), c());
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilCalendar.get(1);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (!a(paramInt1, paramInt2, paramInt3)) {
      return;
    }
    b(paramInt1, paramInt2, paramInt3);
    b();
    d();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, TCWDatePicker.OnDateChangedListener paramOnDateChangedListener)
  {
    b(paramInt1, paramInt2, paramInt3);
    this.jdField_a_of_type_ComTencentWidgetTCWDatePicker$OnDateChangedListener = paramOnDateChangedListener;
    b();
    d();
  }
  
  public int b()
  {
    return this.jdField_a_of_type_JavaUtilCalendar.get(2);
  }
  
  public int c()
  {
    return this.jdField_a_of_type_JavaUtilCalendar.get(5);
  }
  
  protected void dispatchRestoreInstanceState(SparseArray paramSparseArray)
  {
    dispatchThawSelfOnly(paramSparseArray);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (TCWDatePicker.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    b(TCWDatePicker.SavedState.a(paramParcelable), TCWDatePicker.SavedState.b(paramParcelable), TCWDatePicker.SavedState.c(paramParcelable));
    b();
    d();
  }
  
  protected Parcelable onSaveInstanceState()
  {
    return new TCWDatePicker.SavedState(super.onSaveInstanceState(), a(), b(), c(), null);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    this.jdField_a_of_type_ComTencentWidgetTCWNumberPicker.setEnabled(paramBoolean);
    this.jdField_b_of_type_ComTencentWidgetTCWNumberPicker.setEnabled(paramBoolean);
    this.jdField_c_of_type_ComTencentWidgetTCWNumberPicker.setEnabled(paramBoolean);
  }
  
  public void setMaxDate(long paramLong)
  {
    this.jdField_b_of_type_JavaUtilCalendar.setTimeInMillis(paramLong);
    if ((this.jdField_b_of_type_JavaUtilCalendar.get(1) == this.d.get(1)) && (this.jdField_b_of_type_JavaUtilCalendar.get(6) != this.d.get(6))) {
      return;
    }
    this.d.setTimeInMillis(paramLong);
    if (this.jdField_a_of_type_JavaUtilCalendar.after(this.d))
    {
      this.jdField_a_of_type_JavaUtilCalendar.setTimeInMillis(this.d.getTimeInMillis());
      d();
    }
    b();
  }
  
  public void setMinDate(long paramLong)
  {
    this.jdField_b_of_type_JavaUtilCalendar.setTimeInMillis(paramLong);
    if ((this.jdField_b_of_type_JavaUtilCalendar.get(1) == this.jdField_c_of_type_JavaUtilCalendar.get(1)) && (this.jdField_b_of_type_JavaUtilCalendar.get(6) != this.jdField_c_of_type_JavaUtilCalendar.get(6))) {
      return;
    }
    this.jdField_c_of_type_JavaUtilCalendar.setTimeInMillis(paramLong);
    if (this.jdField_a_of_type_JavaUtilCalendar.before(this.jdField_c_of_type_JavaUtilCalendar))
    {
      this.jdField_a_of_type_JavaUtilCalendar.setTimeInMillis(this.jdField_c_of_type_JavaUtilCalendar.getTimeInMillis());
      d();
    }
    b();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\widget\TCWDatePicker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */