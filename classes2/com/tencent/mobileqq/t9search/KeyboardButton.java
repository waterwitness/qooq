package com.tencent.mobileqq.t9search;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class KeyboardButton
  extends RelativeLayout
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString;
  private View d;
  
  public KeyboardButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    View.inflate(paramContext, 2130903573, this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299305));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299306));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299307));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131299300);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131299302);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131299301);
    this.d = findViewById(2131299303);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131299308));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131299304));
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.P);
    this.jdField_a_of_type_JavaLangString = paramContext.getString(0);
    this.jdField_b_of_type_JavaLangString = paramContext.getString(1);
    this.jdField_c_of_type_JavaLangString = paramContext.getString(2);
    this.jdField_a_of_type_Float = paramContext.getDimension(3, 28.0F);
    this.jdField_b_of_type_Float = paramContext.getDimension(4, 9.0F);
    this.jdField_c_of_type_Float = paramContext.getDimension(5, 18.0F);
    this.jdField_a_of_type_Int = paramContext.getColor(6, getResources().getColor(2131427703));
    this.jdField_b_of_type_Int = paramContext.getColor(7, getResources().getColor(2131427702));
    this.jdField_c_of_type_Int = paramContext.getColor(8, getResources().getColor(2131427703));
    this.jdField_a_of_type_Boolean = paramContext.getBoolean(9, false);
    paramContext.recycle();
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(this.jdField_a_of_type_Float);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_Int);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(this.jdField_b_of_type_Float);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_b_of_type_Int);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_c_of_type_JavaLangString);
    this.jdField_c_of_type_AndroidWidgetTextView.setTextSize(this.jdField_c_of_type_Float);
    this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(this.jdField_c_of_type_Int);
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    setBorderVisibility(0, 8, 0, 8);
  }
  
  public void setBorderVisibility(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(paramInt1);
    this.jdField_b_of_type_AndroidViewView.setVisibility(paramInt2);
    this.jdField_c_of_type_AndroidViewView.setVisibility(paramInt3);
    this.d.setVisibility(paramInt4);
  }
  
  public void setImgSrc(int paramInt)
  {
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(paramInt);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\t9search\KeyboardButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */