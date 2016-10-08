package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Handler;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.devicelib.DeviceLib;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;
import com.tencent.mobileqq.emoticonview.SystemEmoticonPanel;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.text.QzoneTextBuilder;
import com.tencent.util.InputMethodUtil;
import java.lang.ref.SoftReference;
import wca;
import wcb;
import wcc;
import wcd;

public class QQCustomDialogWtihEmoticonInput
  extends QQCustomDialog
  implements View.OnClickListener
{
  protected int a;
  protected Handler a;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  public ImageView a;
  public SystemEmoticonPanel a;
  private SoftReference jdField_a_of_type_JavaLangRefSoftReference;
  
  public QQCustomDialogWtihEmoticonInput(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_JavaLangRefSoftReference = new SoftReference(paramContext);
    getWindow().setSoftInputMode(19);
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_AndroidWidgetEditText == null) {
      return "";
    }
    Object localObject;
    if ((this.jdField_a_of_type_AndroidWidgetEditText.getText() instanceof QzoneTextBuilder))
    {
      localObject = (QzoneTextBuilder)this.jdField_a_of_type_AndroidWidgetEditText.getText();
      if (localObject != null) {
        return ((QzoneTextBuilder)localObject).a();
      }
    }
    else if ((this.jdField_a_of_type_AndroidWidgetEditText.getText() instanceof QQTextBuilder))
    {
      localObject = (QQTextBuilder)this.jdField_a_of_type_AndroidWidgetEditText.getText();
      if (localObject != null) {
        return ((QQTextBuilder)localObject).a();
      }
    }
    return this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidWidgetEditText != null) {
      this.jdField_a_of_type_AndroidWidgetEditText.setEditableFactory(QzoneTextBuilder.b);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected void a(Context paramContext)
  {
    wcb localwcb = new wcb(this);
    if (this.jdField_a_of_type_Int == 7)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel = new SystemAndEmojiEmoticonPanel(paramContext, localwcb);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel = new SystemEmoticonPanel(paramContext, localwcb);
  }
  
  public void a(String paramString)
  {
    if (paramString != null) {
      this.jdField_a_of_type_AndroidWidgetEditText.setText(paramString);
    }
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetEditText != null) {
      this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
    }
  }
  
  public EditText getEditText()
  {
    return this.jdField_a_of_type_AndroidWidgetEditText;
  }
  
  public String getInputValue()
  {
    return this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131297864)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.getVisibility() == 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842146);
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new wcc(this), 200L);
        }
      }
      else {
        return;
      }
      InputMethodUtil.b(this.jdField_a_of_type_AndroidWidgetEditText);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842147);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new wcd(this), 200L);
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.getVisibility() == 0)) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842146);
      return;
      InputMethodUtil.b(this.jdField_a_of_type_AndroidWidgetEditText);
    }
  }
  
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    Object localObject = (RelativeLayout)findViewById(2131297839);
    paramInt = 0;
    while (paramInt < ((RelativeLayout)localObject).getChildCount())
    {
      ((RelativeLayout)localObject).getChildAt(paramInt).setOnClickListener(this);
      paramInt += 1;
    }
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131297412));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297864));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.setEditableFactory(QQTextBuilder.a);
    this.jdField_a_of_type_AndroidWidgetEditText.setSingleLine(false);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnTouchListener(new wca(this));
    localObject = Build.MODEL;
    localObject = (Context)this.jdField_a_of_type_JavaLangRefSoftReference.get();
    if (localObject == null) {
      return;
    }
    DeviceLib.a((Context)localObject, this.jdField_a_of_type_AndroidWidgetEditText);
    a((Context)localObject);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setBackgroundResource(2130837544);
    localObject = new RelativeLayout.LayoutParams(-1, (int)(((Context)localObject).getResources().getDisplayMetrics().density * 150.0F));
    ((FrameLayout)findViewById(2131297865)).addView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel, (ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(8);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\utils\QQCustomDialogWtihEmoticonInput.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */