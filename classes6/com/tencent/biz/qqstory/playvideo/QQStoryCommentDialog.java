package com.tencent.biz.qqstory.playvideo;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.InputMethodLinearLayout;
import com.tencent.mobileqq.widget.InputMethodLinearLayout.onSizeChangeListenner;
import iny;
import inz;
import java.util.HashMap;

public class QQStoryCommentDialog
  extends Dialog
  implements View.OnClickListener, TextView.OnEditorActionListener, InputMethodLinearLayout.onSizeChangeListenner
{
  protected static final String a = "Q.qqstory.player.QQStoryCommentDialog";
  protected static final HashMap a;
  public static final String b = "draftID";
  public static final String c = "maxContentLength";
  protected int a;
  protected EditText a;
  protected inz a;
  protected boolean a;
  protected String d;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public QQStoryCommentDialog(Context paramContext, Bundle paramBundle)
  {
    super(paramContext, 2131558944);
    super.requestWindowFeature(1);
    this.jdField_a_of_type_Int = paramBundle.getInt("maxContentLength", 0);
    this.d = paramBundle.getString("draftID");
    paramContext = LayoutInflater.from(paramContext).inflate(2130904501, null);
    super.setContentView(paramContext);
    paramBundle = super.getWindow();
    paramBundle.setSoftInputMode(21);
    paramBundle.setBackgroundDrawable(new ColorDrawable());
    paramBundle.setGravity(83);
    paramBundle.setLayout(-1, -2);
    paramBundle = (InputMethodLinearLayout)paramContext;
    paramBundle.setOnSizeChangedListenner(this);
    paramBundle.setOnClickListener(this);
    super.setCanceledOnTouchOutside(true);
    super.setCancelable(true);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)paramContext.findViewById(2131299739));
    this.jdField_a_of_type_AndroidWidgetEditText.setImeOptions(4);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(this);
    if (this.jdField_a_of_type_Int > 0) {
      this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new iny(this, this.jdField_a_of_type_Int) });
    }
  }
  
  public int a(CharSequence paramCharSequence)
  {
    int i = 0;
    int k = 0;
    if (TextUtils.isEmpty(paramCharSequence)) {}
    int m;
    int j;
    do
    {
      return k;
      m = paramCharSequence.length();
      j = 0;
      k = i;
    } while (j >= m);
    if (StringUtil.d(paramCharSequence.charAt(j))) {
      i += 3;
    }
    for (;;)
    {
      j += 1;
      break;
      i += 1;
    }
  }
  
  public void a(inz paraminz)
  {
    this.jdField_a_of_type_Inz = paraminz;
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      dismiss();
    }
  }
  
  public void dismiss()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      String str = this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString();
      if (!TextUtils.isEmpty(str)) {
        jdField_a_of_type_JavaUtilHashMap.put(this.d, str);
      }
    }
    super.dismiss();
  }
  
  public void onClick(View paramView)
  {
    dismiss();
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((4 == paramInt) && (this.jdField_a_of_type_Inz != null))
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Inz.a(this, paramTextView.getText().toString());
      return true;
    }
    return false;
  }
  
  public void show()
  {
    String str = (String)jdField_a_of_type_JavaUtilHashMap.get(this.d);
    jdField_a_of_type_JavaUtilHashMap.clear();
    if (!TextUtils.isEmpty(str))
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText(str);
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(str.length());
    }
    this.jdField_a_of_type_Boolean = false;
    super.show();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\playvideo\QQStoryCommentDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */