package com.tencent.biz.pubaccount.imageCollection;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import hvo;
import hvp;
import hvq;
import hvr;
import hvs;
import hvt;

public class ImageCollectionCommentActivity
  extends BaseActivity
{
  public static final int a = 100;
  public static final String a = "ImageCollectionCommentActivity";
  public static final int b = 101;
  public static final String b = "comment";
  private static final int c = 200;
  public static final String c = "anonymous";
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private Toast jdField_a_of_type_AndroidWidgetToast;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public ImageCollectionCommentActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 2);
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    String str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    Intent localIntent = new Intent();
    localIntent.putExtra("comment", str);
    localIntent.putExtra("anonymous", this.jdField_a_of_type_Boolean);
    setResult(paramInt, localIntent);
    finish();
  }
  
  private void a(String paramString)
  {
    boolean bool = a(paramString);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(bool);
    if (bool)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#FFFFFF"));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#9D9D9D"));
  }
  
  private boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (paramString.trim().length() == 0) {
      return false;
    }
    return true;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2130903465);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131298707);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131298709));
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new hvo(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(new hvp(this));
    this.jdField_a_of_type_AndroidViewView.findViewById(2131298708).setOnClickListener(new hvq(this));
    this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().addOnGlobalLayoutListener(new hvr(this));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131298710));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new hvs(this));
    this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("anonymous", false);
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131298711));
    this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(new hvt(this));
    paramBundle = getIntent().getStringExtra("comment");
    if (!TextUtils.isEmpty(paramBundle))
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText(paramBundle);
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(paramBundle.length());
      a(paramBundle);
    }
    return true;
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\imageCollection\ImageCollectionCommentActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */