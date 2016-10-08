package com.tencent.mobileqq.remind.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.remind.TimeHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.AdapterView.OnItemSelectedListener;
import com.tencent.widget.VerticalGallery.OnEndFlingListener;
import com.tencent.widget.VerticalGallery.OnSelectViewDataUpdateListener;
import ufo;
import ufp;
import ufq;
import ufr;

public class IosTimepicker
  extends LinearLayout
{
  public static final float a = -0.1F;
  public static final int a = 20;
  private static String jdField_a_of_type_JavaLangString = "remind";
  public static final float b = 0.1F;
  public static final int b = 25;
  public static final float c = -25.0F;
  public static final int c = 17;
  public static final float d = 0.8F;
  public static final int d = 20;
  public static final int e = 80;
  public static final int f = 80;
  public static final int g = -80;
  public static final int h = 0;
  public static final int i = 1;
  private static final int j = 0;
  private static final int k = 1;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private IosTimepicker.FormatDataListener jdField_a_of_type_ComTencentMobileqqRemindWidgetIosTimepicker$FormatDataListener;
  private IosTimepicker.OnTimePickerSelectListener jdField_a_of_type_ComTencentMobileqqRemindWidgetIosTimepicker$OnTimePickerSelectListener;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private AdapterView.OnItemSelectedListener jdField_a_of_type_ComTencentWidgetAdapterView$OnItemSelectedListener = new ufp(this);
  private VerticalGallery.OnEndFlingListener jdField_a_of_type_ComTencentWidgetVerticalGallery$OnEndFlingListener = new ufr(this);
  private VerticalGallery.OnSelectViewDataUpdateListener jdField_a_of_type_ComTencentWidgetVerticalGallery$OnSelectViewDataUpdateListener = new ufq(this);
  private int[] jdField_a_of_type_ArrayOfInt;
  private BaseAdapter[] jdField_a_of_type_ArrayOfAndroidWidgetBaseAdapter;
  private WheelView[] jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  private long jdField_b_of_type_Long;
  private String[] jdField_b_of_type_ArrayOfJavaLangString;
  private int l;
  private int m;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public IosTimepicker(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public IosTimepicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public IosTimepicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRemindWidgetIosTimepicker$FormatDataListener != null)
    {
      int i1 = this.jdField_a_of_type_ArrayOfInt.length;
      int n = 0;
      while (n < i1)
      {
        this.jdField_a_of_type_ArrayOfInt[n] = this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView[n].r();
        n += 1;
      }
      this.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqRemindWidgetIosTimepicker$FormatDataListener.a(this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView, this.jdField_a_of_type_ArrayOfInt);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRemindWidgetIosTimepicker$OnTimePickerSelectListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqRemindWidgetIosTimepicker$OnTimePickerSelectListener.a(this.jdField_b_of_type_Long);
    }
  }
  
  private void a(View paramView, int paramInt)
  {
    if ((paramView instanceof WheelTextView))
    {
      if (paramInt == 0)
      {
        ((WheelTextView)paramView).setTextSize(20.0F);
        ((WheelTextView)paramView).setTextColor(this.l);
      }
    }
    else {
      return;
    }
    ((WheelTextView)paramView).setTextSize(20.0F);
    ((WheelTextView)paramView).setTextColor(this.m);
  }
  
  public long a()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public void a(Context paramContext, ActionSheet paramActionSheet, IosTimepicker.OnTimePickerSelectListener paramOnTimePickerSelectListener, View.OnClickListener paramOnClickListener, BaseAdapter[] paramArrayOfBaseAdapter, int[] paramArrayOfInt, IosTimepicker.FormatDataListener paramFormatDataListener)
  {
    if ((paramArrayOfBaseAdapter == null) || (paramArrayOfBaseAdapter.length == 0) || (paramArrayOfBaseAdapter.length > 3)) {
      throw new IllegalArgumentException("adapters is null or empty, or its length is larger than 3");
    }
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0)) {
      throw new IllegalArgumentException("selectionPos is null or empty, or its length is larger than 3");
    }
    if (paramArrayOfInt.length != paramArrayOfBaseAdapter.length) {
      throw new IllegalArgumentException("selectionPos.length is not equal to adapters.length");
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentWidgetActionSheet = paramActionSheet;
    this.jdField_a_of_type_ComTencentMobileqqRemindWidgetIosTimepicker$OnTimePickerSelectListener = paramOnTimePickerSelectListener;
    this.jdField_a_of_type_ArrayOfAndroidWidgetBaseAdapter = paramArrayOfBaseAdapter;
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
    int i2 = paramArrayOfBaseAdapter.length;
    int i1 = paramArrayOfInt.length;
    this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView = new WheelView[i2];
    this.jdField_a_of_type_ComTencentMobileqqRemindWidgetIosTimepicker$FormatDataListener = paramFormatDataListener;
    int n = 0;
    while (n < i2)
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView[n] = new WheelView(this.jdField_a_of_type_AndroidContentContext);
      n += 1;
    }
    paramActionSheet = this.jdField_a_of_type_AndroidContentContext.getResources();
    this.l = paramActionSheet.getColor(2131428310);
    this.m = paramActionSheet.getColor(2131428289);
    this.jdField_a_of_type_ArrayOfJavaLangString = TimeHelper.jdField_a_of_type_ArrayOfJavaLangString;
    this.jdField_b_of_type_ArrayOfJavaLangString = TimeHelper.jdField_b_of_type_ArrayOfJavaLangString;
    this.jdField_a_of_type_AndroidViewView = findViewById(2131305323);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131305327));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131305324));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131301808));
    n = paramActionSheet.getColor(2131428320);
    findViewById(2131305325).setBackgroundColor(n);
    findViewById(2131305326).setBackgroundColor(n);
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(paramActionSheet.getColor(2131428291));
    n = paramActionSheet.getColor(2131428319);
    findViewById(2131298986).setBackgroundColor(n);
    findViewById(2131298987).setBackgroundColor(n);
    if (paramOnClickListener != null)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(paramOnClickListener);
      if (i2 != 1) {
        break label514;
      }
      paramContext = new LinearLayout.LayoutParams(-1, -1);
      this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView[0].setLayoutParams(paramContext);
      this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView[0].setAdapter(this.jdField_a_of_type_ArrayOfAndroidWidgetBaseAdapter[0]);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "createTimePicker Time :" + TimeHelper.a(this.jdField_a_of_type_Long));
      }
    }
    for (;;)
    {
      n = 0;
      while (n < i1)
      {
        paramContext = this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView[n];
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramContext);
        paramContext.setAdapter(this.jdField_a_of_type_ArrayOfAndroidWidgetBaseAdapter[n]);
        paramContext.setSelection(this.jdField_a_of_type_ArrayOfInt[n], true);
        paramContext.setOnItemSelectedListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemSelectedListener);
        paramContext.setOnSelectViewDataUpdateListener(this.jdField_a_of_type_ComTencentWidgetVerticalGallery$OnSelectViewDataUpdateListener);
        paramContext.setOnEndFlingListener(this.jdField_a_of_type_ComTencentWidgetVerticalGallery$OnEndFlingListener);
        n += 1;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new ufo(this));
      break;
      label514:
      n = 0;
      if (n < i2)
      {
        paramOnTimePickerSelectListener = this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView[n];
        if (n == 0) {}
        for (paramContext = new LinearLayout.LayoutParams(paramActionSheet.getDimensionPixelSize(2131494689), -1);; paramContext = new LinearLayout.LayoutParams(paramActionSheet.getDimensionPixelSize(2131494690), -1))
        {
          paramContext.setMargins(0, paramActionSheet.getDimensionPixelSize(2131494692), 0, paramActionSheet.getDimensionPixelSize(2131494693));
          paramOnTimePickerSelectListener.setLayoutParams(paramContext);
          if (n != 0)
          {
            paramOnTimePickerSelectListener.setScrollCycle(true);
            paramOnTimePickerSelectListener.setmMaxRotationAngle(80);
            paramOnTimePickerSelectListener.setmMaxSkew(0.1F);
            paramOnTimePickerSelectListener.setNeedTranslate(true);
          }
          n += 1;
          break;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "createTimePicker Time :" + TimeHelper.a(this.jdField_a_of_type_Long));
      }
    }
    a();
  }
  
  public void setFormatDataListener(IosTimepicker.FormatDataListener paramFormatDataListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqRemindWidgetIosTimepicker$FormatDataListener = paramFormatDataListener;
  }
  
  public void setMaxDays(int paramInt)
  {
    TimeHelper.jdField_a_of_type_Int = paramInt;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "setMaxDays days = " + TimeHelper.jdField_a_of_type_Int);
    }
  }
  
  public void setOnTimePickerSelectListener(IosTimepicker.OnTimePickerSelectListener paramOnTimePickerSelectListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqRemindWidgetIosTimepicker$OnTimePickerSelectListener = paramOnTimePickerSelectListener;
  }
  
  public void setTips(String paramString)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\remind\widget\IosTimepicker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */