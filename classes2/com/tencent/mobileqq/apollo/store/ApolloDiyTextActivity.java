package com.tencent.mobileqq.apollo.store;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class ApolloDiyTextActivity
  extends Activity
  implements TextWatcher, View.OnClickListener
{
  public static final int a = 1;
  public static final String a = "extra_key_last_text";
  private static final String jdField_b_of_type_JavaLangString = "ApolloDiyTextActivity";
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  boolean jdField_a_of_type_Boolean;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  boolean jdField_b_of_type_Boolean;
  
  public ApolloDiyTextActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_b_of_type_AndroidWidgetImageView)
    {
      paramView = this.jdField_a_of_type_AndroidWidgetEditText.getText();
      if ((paramView != null) && (paramView.length() > 0))
      {
        if (paramView.length() > 12) {
          QQToast.a(this, "输入文字超出上限", 0).a();
        }
      }
      else {
        VipUtils.a(null, "cmshow", "Apollo", "ConfirmClick", 0, 0, new String[0]);
      }
    }
    do
    {
      return;
      Intent localIntent = new Intent();
      localIntent.putExtra("ret", 1);
      if (this.jdField_a_of_type_AndroidWidgetEditText.getText() != null) {}
      for (paramView = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();; paramView = "")
      {
        localIntent.putExtra("text", paramView);
        setResult(-1, localIntent);
        finish();
        break;
      }
      if (paramView == this.jdField_a_of_type_AndroidWidgetImageView)
      {
        localIntent = new Intent();
        localIntent.putExtra("ret", 0);
        if (this.jdField_a_of_type_AndroidWidgetEditText.getText() != null) {}
        for (paramView = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();; paramView = "")
        {
          localIntent.putExtra("text", paramView);
          setResult(0, localIntent);
          VipUtils.a(null, "cmshow", "Apollo", "CancelClick", 0, 0, new String[0]);
          finish();
          return;
        }
      }
    } while (paramView != this.jdField_a_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_AndroidWidgetEditText.setText("");
    this.jdField_a_of_type_AndroidWidgetEditText.setHint(" ");
    VipUtils.a(null, "cmshow", "Apollo", "ClearClick", 0, 0, new String[0]);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = new RelativeLayout(this);
    super.setContentView(paramBundle);
    paramBundle.setBackgroundColor(-1778384896);
    this.jdField_b_of_type_AndroidWidgetTextView = new TextView(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(14.0F);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
    Object localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(14, -1);
    ((RelativeLayout.LayoutParams)localObject1).addRule(12, -1);
    ((RelativeLayout.LayoutParams)localObject1).bottomMargin = AIOUtils.a(80.0F, getResources());
    paramBundle.addView(this.jdField_b_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new RelativeLayout(this);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout.LayoutParams)localObject2).bottomMargin = AIOUtils.a(44.0F, getResources());
    paramBundle.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    this.jdField_a_of_type_AndroidWidgetEditText = new EditText(this);
    this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(true);
    this.jdField_a_of_type_AndroidWidgetEditText.setTextSize(24.0F);
    this.jdField_a_of_type_AndroidWidgetEditText.setTextColor(-1);
    this.jdField_a_of_type_AndroidWidgetEditText.setHintTextColor(-1);
    this.jdField_a_of_type_AndroidWidgetEditText.setHint("在此输入文字");
    this.jdField_a_of_type_AndroidWidgetEditText.setBackgroundColor(0);
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.setSingleLine(false);
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(0);
    float f = this.jdField_a_of_type_AndroidWidgetEditText.getPaint().measureText("在此输入文字在此输入");
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(13, -1);
    ((RelativeLayout)localObject1).addView(this.jdField_a_of_type_AndroidWidgetEditText, (ViewGroup.LayoutParams)localObject2);
    this.jdField_a_of_type_AndroidWidgetEditText.setMaxWidth((int)(f + 1.0F));
    localObject1 = new RelativeLayout(this);
    localObject2 = new View(this);
    ((View)localObject2).setBackgroundColor(-460552);
    new RelativeLayout.LayoutParams(-1, AIOUtils.a(1.0F, getResources())).addRule(10, -1);
    ((RelativeLayout)localObject1).addView((View)localObject2);
    localObject2 = new View(this);
    ((View)localObject2).setBackgroundColor(-460552);
    new RelativeLayout.LayoutParams(-1, AIOUtils.a(1.0F, getResources())).addRule(12, -1);
    ((RelativeLayout)localObject1).addView((View)localObject2);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837726);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(15);
    ((RelativeLayout.LayoutParams)localObject2).addRule(9);
    ((RelativeLayout.LayoutParams)localObject2).leftMargin = AIOUtils.a(15.0F, getResources());
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    ((RelativeLayout)localObject1).addView(this.jdField_a_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject2);
    this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(15);
    ((RelativeLayout.LayoutParams)localObject2).addRule(11);
    ((RelativeLayout.LayoutParams)localObject2).rightMargin = AIOUtils.a(10.0F, getResources());
    ((RelativeLayout)localObject1).addView(this.jdField_b_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject2);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setText("清空");
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(16.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    localObject2 = new RelativeLayout.LayoutParams(-2, -1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(13);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    ((RelativeLayout)localObject1).addView(this.jdField_a_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new RelativeLayout.LayoutParams(-1, AIOUtils.a(43.0F, getResources()));
    ((RelativeLayout.LayoutParams)localObject2).addRule(12, -1);
    paramBundle.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject1 = getIntent().getStringExtra("extra_key_last_text");
    if (!android.text.TextUtils.isEmpty((CharSequence)localObject1))
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setGravity(17);
      this.jdField_a_of_type_AndroidWidgetEditText.setText((CharSequence)localObject1);
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(((String)localObject1).length());
      int i = 12 - ((String)localObject1).length();
      this.jdField_b_of_type_AndroidWidgetTextView.setText("还可以输入" + i + "个字");
      if (i < 0) {
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-65536);
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130837728);
    }
    for (;;)
    {
      localObject1 = new AlphaAnimation(0.0F, 1.0F);
      ((AlphaAnimation)localObject1).setDuration(500L);
      ((AlphaAnimation)localObject1).setFillAfter(true);
      paramBundle.startAnimation((Animation)localObject1);
      VipUtils.a(null, "cmshow", "Apollo", "PageView", 1, 0, new String[0]);
      return;
      this.jdField_a_of_type_AndroidWidgetEditText.setGravity(3);
      this.jdField_b_of_type_AndroidWidgetTextView.setText("还可以输入12个字");
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130837727);
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    String str;
    if ((paramCharSequence != null) && (paramCharSequence.length() > 0))
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setHint(" ");
      str = paramCharSequence.toString();
      paramCharSequence = com.tencent.mobileqq.text.TextUtils.a(str);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloDiyTextActivity", 2, "onTextChanged:" + str + " newStr:" + paramCharSequence);
      }
      paramInt1 = paramCharSequence.length();
      paramInt2 = this.jdField_a_of_type_AndroidWidgetEditText.getSelectionEnd();
      if (paramInt1 > 50)
      {
        paramCharSequence = paramCharSequence.substring(0, 50);
        if (this.jdField_b_of_type_Boolean) {
          break label407;
        }
        this.jdField_b_of_type_Boolean = true;
        VipUtils.a(null, "cmshow", "Apollo", "reach50", 0, 0, new String[0]);
        paramInt1 = 50;
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText("还可以输入" + (12 - paramInt1) + "个字");
      if (paramInt1 > 12)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-65536);
        if (!this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_Boolean = true;
          VipUtils.a(null, "cmshow", "Apollo", "over12", 0, 0, new String[0]);
        }
        label219:
        if (paramInt2 < paramCharSequence.length()) {
          break label402;
        }
      }
      label273:
      label402:
      for (paramInt1 = paramCharSequence.length();; paramInt1 = paramInt2)
      {
        if (!str.equals(paramCharSequence))
        {
          this.jdField_a_of_type_AndroidWidgetEditText.removeTextChangedListener(this);
          this.jdField_a_of_type_AndroidWidgetEditText.setText(paramCharSequence);
          this.jdField_a_of_type_AndroidWidgetEditText.setSelection(paramInt1);
          this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
        }
        if ((this.jdField_a_of_type_AndroidWidgetEditText.getText() != null) && (this.jdField_a_of_type_AndroidWidgetEditText.getText().length() > 0))
        {
          this.jdField_a_of_type_AndroidWidgetEditText.setGravity(17);
          if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
            this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130837728);
          }
        }
        do
        {
          return;
          if (paramInt1 < 50) {
            this.jdField_b_of_type_Boolean = false;
          }
          break;
          this.jdField_a_of_type_Boolean = false;
          this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
          break label219;
          this.jdField_b_of_type_AndroidWidgetTextView.setText("还可以输入12个字");
          this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
          break label273;
          this.jdField_a_of_type_AndroidWidgetEditText.setGravity(3);
        } while (this.jdField_b_of_type_AndroidWidgetImageView == null);
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130837727);
        return;
      }
      label407:
      paramInt1 = 50;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\apollo\store\ApolloDiyTextActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */