package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.Selection;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.widget.InputMethodLinearLayout;
import com.tencent.mobileqq.widget.InputMethodLinearLayout.onSizeChangeListenner;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import lhd;
import lhe;
import lhf;
import lhg;
import lhh;
import lhk;
import lhl;
import lhm;

public class EditInfoActivity
  extends IphoneTitleBarActivity
  implements EmoticonCallback, InputMethodLinearLayout.onSizeChangeListenner
{
  public static final int a = 0;
  public static final String a = "support_emotion";
  public static final int b = 1;
  public static final String b = "key_need_hide_couser_when_emoj";
  public static final int c = 2;
  public static final String c = "edit_type";
  public static final int d = 3;
  public static final String d = "title";
  public static final int e = 4;
  public static final String e = "right_btn";
  public static final int f = 149;
  public static final String f = "left_btn";
  public static final int g = 0;
  public static final String g = "default_text";
  public static final int h = 1;
  public static final String h = "max_num";
  public static final int i = 0;
  public static final String i = "isTroopNick";
  public static final int j = 1;
  public static final String j = "troopUin";
  public static final String k = "uin";
  public static final String l = "edit_subtype";
  public static final String m = "count_type";
  public static final String n = "from";
  public static final String o = "canPostNull";
  public static final String p = "default_hint";
  public static final String q = "full_screen";
  public static final String r = "link_text";
  public static final String s = "send_type";
  protected String A;
  String B;
  protected Drawable a;
  public Handler a;
  protected ViewGroup a;
  public EditText a;
  public ImageView a;
  public LinearLayout a;
  public TextView a;
  TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver;
  SystemAndEmojiEmoticonPanel jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel;
  InputMethodLinearLayout jdField_a_of_type_ComTencentMobileqqWidgetInputMethodLinearLayout;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  public QQProgressNotifier a;
  public boolean a;
  protected Drawable b;
  boolean b;
  public boolean c;
  boolean d;
  private boolean e;
  private boolean f;
  public int k;
  public int l;
  public int m;
  public int n;
  public int o;
  public int p;
  protected String t;
  public String u;
  public String v;
  String w;
  public String x;
  public String y;
  String z;
  
  public EditInfoActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.k = -1;
    this.l = -1;
    this.v = "";
    this.m = 0;
    this.n = -1;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.c = false;
    this.d = false;
    this.w = "";
    this.o = 0;
    this.p = 0;
    this.jdField_a_of_type_AndroidOsHandler = new lhd(this);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new lhm(this);
  }
  
  private void a(EditText paramEditText)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131298156));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.v);
    paramEditText.addTextChangedListener(new lhh(this));
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.centerView == null) {
      this.centerView = ((TextView)findViewById(2131297139));
    }
    if (paramBoolean)
    {
      this.rightViewText.setEnabled(false);
      if ((this.t != null) && (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null))
      {
        this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130838321);
        this.centerView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
        ((Animatable)this.jdField_b_of_type_AndroidGraphicsDrawableDrawable).start();
      }
    }
    do
    {
      return;
      this.rightViewText.setEnabled(true);
    } while ((this.t == null) || (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null));
    ((Animatable)this.jdField_b_of_type_AndroidGraphicsDrawableDrawable).stop();
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = null;
    this.centerView.setCompoundDrawables(null, null, null, null);
  }
  
  private void m()
  {
    super.setContentView(2130903331);
    this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodLinearLayout = ((InputMethodLinearLayout)super.findViewById(2131296895));
    this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodLinearLayout.setOnSizeChangedListenner(this);
    n();
    if (!this.d)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.getLayoutParams().height = ((int)DisplayUtils.a(this, 149.0F));
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodLinearLayout.findViewById(2131298154).getLayoutParams();
      localLayoutParams.height = ((int)DisplayUtils.a(this, 151.0F));
      localLayoutParams.weight = 0.0F;
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setEditableFactory(QQTextBuilder.a);
    if (this.jdField_b_of_type_Boolean) {
      h();
    }
  }
  
  private void n()
  {
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)super.findViewById(2131298155));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)super.findViewById(2131296895));
    if (!android.text.TextUtils.isEmpty(this.t)) {
      this.jdField_a_of_type_AndroidWidgetEditText.setContentDescription(this.t);
    }
    if (!android.text.TextUtils.isEmpty(this.w)) {
      this.jdField_a_of_type_AndroidWidgetEditText.setHint(this.w);
    }
    if ((this.u != null) && (this.u.length() > 0)) {
      this.jdField_a_of_type_AndroidWidgetEditText.setText(this.u);
    }
    for (;;)
    {
      try
      {
        if (this.p == 0) {
          i1 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().getBytes("utf-8").length;
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException1)
      {
        i1 = 0;
      }
      try
      {
        this.v = ("" + (this.m - i1));
        if (this.n == 3) {
          break;
        }
        if ((!this.jdField_a_of_type_Boolean) || (i1 > this.m)) {
          break label248;
        }
        this.rightViewText.setEnabled(true);
        a(this.jdField_a_of_type_AndroidWidgetEditText);
        return;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException2)
      {
        for (;;) {}
      }
      int i1 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().length();
      continue;
      localUnsupportedEncodingException1.printStackTrace();
      continue;
      this.v = ("" + this.m);
      i1 = 0;
      continue;
      label248:
      if ((i1 == 0) || (i1 > this.m)) {
        this.rightViewText.setEnabled(false);
      }
    }
    this.rightViewText.setEnabled(true);
  }
  
  public void a()
  {
    ((InputMethodManager)getSystemService("input_method")).showSoftInput(this.jdField_a_of_type_AndroidWidgetEditText, 2);
  }
  
  protected void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this);
    }
    if (paramInt == 0) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a("");
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(getTitleBarHeight());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(paramInt);
    }
  }
  
  public void a(Intent paramIntent) {}
  
  public void a(EmoticonInfo paramEmoticonInfo)
  {
    paramEmoticonInfo.a(this.app, this, this.jdField_a_of_type_AndroidWidgetEditText, null);
  }
  
  public void a(EmoticonInfo paramEmoticonInfo1, EmoticonInfo paramEmoticonInfo2, Drawable paramDrawable) {}
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodLinearLayout == null) {}
    do
    {
      do
      {
        return;
        if (!paramBoolean) {
          break;
        }
      } while ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidWidgetImageView == null));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842146);
      return;
    } while ((!this.e) || (this.jdField_a_of_type_AndroidWidgetLinearLayout == null));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
  }
  
  public boolean a(EmoticonInfo paramEmoticonInfo)
  {
    return false;
  }
  
  public boolean a(String paramString)
  {
    boolean bool = false;
    if (paramString.length() > 20) {
      return true;
    }
    int i2 = paramString.length();
    int i1 = 0;
    while (i1 < i2)
    {
      int i3 = paramString.charAt(i1);
      if ((i3 < 48) || (i3 > 57)) {
        bool = true;
      }
      i1 += 1;
    }
    return bool;
  }
  
  public void b()
  {
    com.tencent.mobileqq.text.TextUtils.a(this.jdField_a_of_type_AndroidWidgetEditText);
  }
  
  public void b(EmoticonInfo paramEmoticonInfo) {}
  
  public void c() {}
  
  public void d() {}
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    i();
    f();
    setContentBackgroundResource(2130837958);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new lhe(this), 500L);
    if (this.c) {
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    }
    return true;
  }
  
  public void e()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    View localView = getWindow().peekDecorView();
    if ((localView != null) && (localView.getWindowToken() != null)) {
      localInputMethodManager.hideSoftInputFromWindow(localView.getWindowToken(), 0);
    }
  }
  
  void f()
  {
    switch (this.k)
    {
    }
    for (;;)
    {
      int i1 = this.jdField_a_of_type_AndroidWidgetEditText.getText().length();
      Selection.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.getEditableText(), i1);
      setTitle(this.t);
      setRightButton(2131368729, new lhf(this));
      if (this.z != null)
      {
        this.rightViewText.setText(this.z);
        this.rightViewText.setContentDescription(getString(2131365196, new Object[] { this.z }));
      }
      if (this.A != null)
      {
        this.leftView.setText(this.A);
        this.leftView.setContentDescription(getString(2131365196, new Object[] { this.A }));
      }
      if (this.B != null)
      {
        TextView localTextView = (TextView)findViewById(2131298158);
        if (localTextView != null)
        {
          localTextView.setVisibility(0);
          localTextView.setText(this.B);
          localTextView.setOnClickListener(new lhg(this));
        }
      }
      return;
      g();
      continue;
      m();
    }
  }
  
  protected void g()
  {
    super.setContentView(2130903332);
    n();
    View localView1 = findViewById(2131298153);
    View localView2 = findViewById(2131298160);
    if ("1103".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId")))
    {
      localView1.setVisibility(8);
      localView2.setVisibility(8);
    }
  }
  
  void h()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131298159));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131298157));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new lhk(this));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel = new SystemAndEmojiEmoticonPanel(this, this);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(new lhl(this));
  }
  
  protected void i()
  {
    Intent localIntent = getIntent();
    this.k = localIntent.getIntExtra("edit_type", -1);
    this.l = localIntent.getIntExtra("edit_subtype", -1);
    this.t = localIntent.getStringExtra("title");
    this.u = localIntent.getStringExtra("default_text");
    this.m = localIntent.getIntExtra("max_num", 0);
    this.c = localIntent.getBooleanExtra("isTroopNick", false);
    this.x = localIntent.getStringExtra("troopUin");
    this.y = localIntent.getStringExtra("uin");
    this.n = localIntent.getIntExtra("from", -1);
    this.jdField_a_of_type_Boolean = localIntent.getBooleanExtra("canPostNull", true);
    this.jdField_b_of_type_Boolean = localIntent.getBooleanExtra("support_emotion", false);
    this.d = localIntent.getBooleanExtra("full_screen", false);
    this.w = localIntent.getStringExtra("default_hint");
    this.o = localIntent.getIntExtra("send_type", 0);
    this.z = localIntent.getStringExtra("right_btn");
    this.p = localIntent.getIntExtra("count_type", 0);
    this.A = localIntent.getStringExtra("left_btn");
    this.B = localIntent.getStringExtra("link_text");
  }
  
  public void j() {}
  
  public void k() {}
  
  protected void l()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  public boolean onBackEvent()
  {
    e();
    return super.onBackEvent();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.c) {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.a();
    }
    try
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setFocusable(false);
      this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
      this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(8);
      this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_AndroidWidgetEditText);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("IphoneTitleBarActivity", 2, "onDestroy" + localException.toString());
    }
  }
  
  protected void onPause()
  {
    e();
    super.onPause();
  }
  
  protected void onResume()
  {
    a();
    super.onResume();
  }
  
  public void setting() {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\EditInfoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */