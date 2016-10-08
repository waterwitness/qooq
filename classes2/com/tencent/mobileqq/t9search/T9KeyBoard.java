package com.tencent.mobileqq.t9search;

import android.content.Context;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.EditText;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.phone.PhoneNumberUtil;
import com.tencent.qphone.base.util.QLog;
import uye;
import uyf;

public class T9KeyBoard
  extends RelativeLayout
  implements View.OnClickListener, View.OnLongClickListener
{
  public static final String a = "PASTE";
  public final Handler a;
  public EditText a;
  private KeyboardButton jdField_a_of_type_ComTencentMobileqqT9searchKeyboardButton;
  private T9KeyBoard.onDialBtnClickListener jdField_a_of_type_ComTencentMobileqqT9searchT9KeyBoard$onDialBtnClickListener;
  public T9KeyBoard.onKeyClickListener a;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  public StringBuilder a;
  private KeyboardButton b;
  private KeyboardButton c;
  private KeyboardButton d;
  private KeyboardButton e;
  private KeyboardButton f;
  private KeyboardButton g;
  private KeyboardButton h;
  private KeyboardButton i;
  private KeyboardButton j;
  private KeyboardButton k;
  private KeyboardButton l;
  
  public T9KeyBoard(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_JavaLangRunnable = new uye(this);
    a(paramContext);
  }
  
  public T9KeyBoard(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_JavaLangRunnable = new uye(this);
    a(paramContext);
  }
  
  private void a(int paramInt)
  {
    int m;
    String str;
    if (this.jdField_a_of_type_AndroidWidgetEditText != null)
    {
      m = this.jdField_a_of_type_AndroidWidgetEditText.getSelectionStart();
      switch (paramInt)
      {
      default: 
        str = this.jdField_a_of_type_JavaLangStringBuilder.toString();
        this.jdField_a_of_type_AndroidWidgetEditText.setText(str);
      }
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_AndroidWidgetEditText.setSelection(m + 1);
        if (!PhoneNumberUtil.a(str))
        {
          paramInt = PhoneNumberUtil.a(str);
          if (paramInt > 0)
          {
            a(this.jdField_a_of_type_JavaLangStringBuilder, paramInt, " ");
            this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_a_of_type_JavaLangStringBuilder.toString());
            this.jdField_a_of_type_AndroidWidgetEditText.setSelection(paramInt + 1);
          }
        }
        if (this.jdField_a_of_type_AndroidWidgetEditText.getSelectionStart() == this.jdField_a_of_type_JavaLangStringBuilder.length()) {
          this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
        }
        a(true);
        return;
        a(this.jdField_a_of_type_JavaLangStringBuilder, m, "0");
        break;
        a(this.jdField_a_of_type_JavaLangStringBuilder, m, "1");
        break;
        a(this.jdField_a_of_type_JavaLangStringBuilder, m, "2");
        break;
        a(this.jdField_a_of_type_JavaLangStringBuilder, m, "3");
        break;
        a(this.jdField_a_of_type_JavaLangStringBuilder, m, "4");
        break;
        a(this.jdField_a_of_type_JavaLangStringBuilder, m, "5");
        break;
        a(this.jdField_a_of_type_JavaLangStringBuilder, m, "6");
        break;
        a(this.jdField_a_of_type_JavaLangStringBuilder, m, "7");
        break;
        a(this.jdField_a_of_type_JavaLangStringBuilder, m, "8");
        break;
        a(this.jdField_a_of_type_JavaLangStringBuilder, m, "9");
        break;
        a("PASTE", true);
        return;
        a(true, m - 1);
        return;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("T9Keyboard", 2, "click() IndexOutOfBoundsException.");
        }
        this.jdField_a_of_type_AndroidWidgetEditText.setSelection(str.length());
        continue;
      }
      switch (paramInt)
      {
      default: 
        break;
      case 2131297061: 
        this.jdField_a_of_type_JavaLangStringBuilder.append("1");
        break;
      case 2131299435: 
        this.jdField_a_of_type_JavaLangStringBuilder.append("0");
        break;
      case 2131297062: 
        this.jdField_a_of_type_JavaLangStringBuilder.append("2");
        break;
      case 2131298122: 
        this.jdField_a_of_type_JavaLangStringBuilder.append("3");
        break;
      case 2131298123: 
        this.jdField_a_of_type_JavaLangStringBuilder.append("4");
        break;
      case 2131299427: 
        this.jdField_a_of_type_JavaLangStringBuilder.append("5");
        break;
      case 2131299428: 
        this.jdField_a_of_type_JavaLangStringBuilder.append("6");
        break;
      case 2131299430: 
        this.jdField_a_of_type_JavaLangStringBuilder.append("7");
        break;
      case 2131299431: 
        this.jdField_a_of_type_JavaLangStringBuilder.append("8");
        break;
      case 2131299432: 
        this.jdField_a_of_type_JavaLangStringBuilder.append("9");
      }
    }
    a("PASTE", true);
    return;
    a(true);
  }
  
  private void a(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2130903612, this);
    this.jdField_a_of_type_ComTencentMobileqqT9searchKeyboardButton = ((KeyboardButton)findViewById(2131299435));
    this.b = ((KeyboardButton)findViewById(2131297061));
    this.c = ((KeyboardButton)findViewById(2131297062));
    this.d = ((KeyboardButton)findViewById(2131298122));
    this.e = ((KeyboardButton)findViewById(2131298123));
    this.f = ((KeyboardButton)findViewById(2131299427));
    this.g = ((KeyboardButton)findViewById(2131299428));
    this.h = ((KeyboardButton)findViewById(2131299430));
    this.i = ((KeyboardButton)findViewById(2131299431));
    this.j = ((KeyboardButton)findViewById(2131299432));
    this.k = ((KeyboardButton)findViewById(2131299434));
    this.l = ((KeyboardButton)findViewById(2131299436));
    this.l.setImgSrc(2130839001);
    this.jdField_a_of_type_ComTencentMobileqqT9searchKeyboardButton.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.i.setOnClickListener(this);
    this.j.setOnClickListener(this);
    this.k.setOnClickListener(this);
    this.l.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqT9searchKeyboardButton.setOnLongClickListener(this);
    this.l.setOnTouchListener(new uyf(this, null));
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqT9searchT9KeyBoard$onKeyClickListener != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqT9searchT9KeyBoard$onKeyClickListener.a(paramString, paramBoolean);
      int m = paramString.length() - 1;
      if (m >= 0) {
        this.jdField_a_of_type_ComTencentMobileqqT9searchT9KeyBoard$onKeyClickListener.a(paramString.charAt(m));
      }
    }
  }
  
  private void a(StringBuilder paramStringBuilder, int paramInt, String paramString)
  {
    if ((paramStringBuilder == null) || (paramInt < 0) || (paramStringBuilder.length() >= 100)) {
      return;
    }
    int m = paramInt;
    if (paramInt > paramStringBuilder.length()) {
      m = paramStringBuilder.length();
    }
    paramStringBuilder.insert(m, paramString);
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqT9searchT9KeyBoard$onKeyClickListener != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqT9searchT9KeyBoard$onKeyClickListener.a(this.jdField_a_of_type_JavaLangStringBuilder.toString().replaceAll(" ", ""), paramBoolean);
      int m = this.jdField_a_of_type_JavaLangStringBuilder.length() - 1;
      if (m >= 0) {
        this.jdField_a_of_type_ComTencentMobileqqT9searchT9KeyBoard$onKeyClickListener.a(this.jdField_a_of_type_JavaLangStringBuilder.charAt(m));
      }
    }
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangStringBuilder.toString();
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangStringBuilder.delete(0, this.jdField_a_of_type_JavaLangStringBuilder.length());
    if (this.jdField_a_of_type_AndroidWidgetEditText != null)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText("");
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(0);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqT9searchT9KeyBoard$onKeyClickListener != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqT9searchT9KeyBoard$onKeyClickListener.a("", true);
      this.jdField_a_of_type_ComTencentMobileqqT9searchT9KeyBoard$onKeyClickListener.a('\000');
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if ((paramInt > this.jdField_a_of_type_JavaLangStringBuilder.length()) || (paramInt < 0) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetEditText != null)
    {
      int m = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().length();
      String str = paramString;
      if (paramString.length() + m > 100) {
        str = paramString.substring(0, 100 - m);
      }
      this.jdField_a_of_type_JavaLangStringBuilder.insert(paramInt, str);
      this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_a_of_type_JavaLangStringBuilder.toString());
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(str.length() + paramInt);
    }
    a(true);
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetEditText != null)
    {
      int m = this.jdField_a_of_type_AndroidWidgetEditText.getSelectionStart();
      int n = paramString.length();
      this.jdField_a_of_type_JavaLangStringBuilder.insert(this.jdField_a_of_type_AndroidWidgetEditText.getSelectionStart(), paramString);
      this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_a_of_type_JavaLangStringBuilder.toString());
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(m + n);
    }
    for (;;)
    {
      a(true);
      return;
      this.jdField_a_of_type_JavaLangStringBuilder.append(paramString);
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    int m = this.jdField_a_of_type_JavaLangStringBuilder.length() - 1;
    if (m < 0) {
      return false;
    }
    this.jdField_a_of_type_JavaLangStringBuilder.deleteCharAt(m);
    a(paramBoolean);
    return true;
  }
  
  public boolean a(boolean paramBoolean, int paramInt)
  {
    boolean bool = true;
    if ((paramInt < 0) || (paramInt > this.jdField_a_of_type_JavaLangStringBuilder.length() - 1)) {
      paramBoolean = false;
    }
    do
    {
      return paramBoolean;
      try
      {
        int m = this.jdField_a_of_type_JavaLangStringBuilder.charAt(paramInt);
        this.jdField_a_of_type_JavaLangStringBuilder.deleteCharAt(paramInt);
        if (this.jdField_a_of_type_AndroidWidgetEditText != null)
        {
          this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_a_of_type_JavaLangStringBuilder.toString());
          this.jdField_a_of_type_AndroidWidgetEditText.setSelection(paramInt);
          if (!PhoneNumberUtil.a(this.jdField_a_of_type_JavaLangStringBuilder.toString()))
          {
            int n = PhoneNumberUtil.a(this.jdField_a_of_type_JavaLangStringBuilder.toString());
            if ((n > 0) && (m != 32))
            {
              a(this.jdField_a_of_type_JavaLangStringBuilder, n, " ");
              this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_a_of_type_JavaLangStringBuilder.toString());
              this.jdField_a_of_type_AndroidWidgetEditText.setSelection(n + 1);
            }
          }
          if (this.jdField_a_of_type_AndroidWidgetEditText.getSelectionStart() == this.jdField_a_of_type_JavaLangStringBuilder.length()) {
            this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
          }
        }
        a(paramBoolean);
        return true;
      }
      catch (StringIndexOutOfBoundsException localStringIndexOutOfBoundsException)
      {
        paramBoolean = bool;
      }
    } while (!QLog.isColorLevel());
    QLog.d("T9Keyboard", 2, new Object[] { "index:%d, len:%d", Integer.valueOf(paramInt), Integer.valueOf(this.jdField_a_of_type_JavaLangStringBuilder.length()) });
    return true;
  }
  
  public void onClick(View paramView)
  {
    paramView.getId();
    a(paramView.getId());
  }
  
  public boolean onLongClick(View paramView)
  {
    if (paramView.getId() == 2131299435)
    {
      if (this.jdField_a_of_type_AndroidWidgetEditText == null) {
        break label149;
      }
      if (this.jdField_a_of_type_AndroidWidgetEditText.getText().length() < 100) {}
    }
    else
    {
      return false;
    }
    int m = this.jdField_a_of_type_AndroidWidgetEditText.getSelectionStart();
    a(this.jdField_a_of_type_JavaLangStringBuilder, m, "+");
    this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_a_of_type_JavaLangStringBuilder.toString());
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(m + 1);
    if (!PhoneNumberUtil.a(this.jdField_a_of_type_JavaLangStringBuilder.toString()))
    {
      m = PhoneNumberUtil.a(this.jdField_a_of_type_JavaLangStringBuilder.toString());
      if (m > 0)
      {
        a(this.jdField_a_of_type_JavaLangStringBuilder, m, " ");
        this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_a_of_type_JavaLangStringBuilder.toString());
        this.jdField_a_of_type_AndroidWidgetEditText.setSelection(m + 1);
      }
    }
    for (;;)
    {
      a(true);
      return true;
      label149:
      this.jdField_a_of_type_JavaLangStringBuilder.append("+");
    }
  }
  
  public void setAttachEditText(EditText paramEditText)
  {
    this.jdField_a_of_type_AndroidWidgetEditText = paramEditText;
  }
  
  public void setOnDialBtnClickListener(T9KeyBoard.onDialBtnClickListener paramonDialBtnClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqT9searchT9KeyBoard$onDialBtnClickListener = paramonDialBtnClickListener;
  }
  
  public void setOnKeyClickListener(T9KeyBoard.onKeyClickListener paramonKeyClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqT9searchT9KeyBoard$onKeyClickListener = paramonKeyClickListener;
  }
  
  public void setString(String paramString)
  {
    if (paramString != null)
    {
      this.jdField_a_of_type_JavaLangStringBuilder.delete(0, this.jdField_a_of_type_JavaLangStringBuilder.length());
      String str = paramString;
      if (paramString.length() > 100) {
        str = paramString.substring(0, 100);
      }
      this.jdField_a_of_type_JavaLangStringBuilder.append(str);
      if (this.jdField_a_of_type_AndroidWidgetEditText != null)
      {
        this.jdField_a_of_type_AndroidWidgetEditText.setText(str);
        this.jdField_a_of_type_AndroidWidgetEditText.setSelection(str.length());
      }
      a(true);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\t9search\T9KeyBoard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */