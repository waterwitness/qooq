package com.tencent.mobileqq.freshnews;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.devicelib.DeviceLib;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.dating.widget.InputBar;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.TroopBarPublishUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.XEditTextEx;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import srl;
import srm;
import srn;
import sro;

public class QQInputView
  extends RelativeLayout
  implements TextWatcher, View.OnClickListener, EmoticonCallback
{
  private static final int jdField_a_of_type_Int = 50;
  private static final int b = 0;
  private static final int c = -1;
  private static final int d = 0;
  private static final int e = 1;
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private InputBar jdField_a_of_type_ComTencentMobileqqDatingWidgetInputBar;
  private SystemAndEmojiEmoticonPanel jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel;
  private QQInputView.IQQInputCallback jdField_a_of_type_ComTencentMobileqqFreshnewsQQInputView$IQQInputCallback;
  private XEditTextEx jdField_a_of_type_ComTencentWidgetXEditTextEx;
  private boolean jdField_a_of_type_Boolean;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  
  public QQInputView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.f = 0;
    this.j = Integer.MAX_VALUE;
    a(paramContext);
  }
  
  public QQInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.f = 0;
    this.j = Integer.MAX_VALUE;
    a(paramContext);
  }
  
  private void a(int paramInt)
  {
    this.f = paramInt;
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.requestFocus();
    if (this.f == 0)
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new srm(this));
      return;
    }
    InputMethodUtil.b(this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
    if (this.g == this.h)
    {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new srn(this), 50L);
      return;
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void a(Context paramContext)
  {
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130904171, this, true);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = ((BaseActivity)paramContext);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131297864));
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx = ((XEditTextEx)super.findViewById(2131297412));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131298663));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)super.findViewById(2131299735));
    this.jdField_a_of_type_ComTencentMobileqqDatingWidgetInputBar = ((InputBar)super.findViewById(2131297409));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel = TroopBarPublishUtils.a(getContext(), this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.addTextChangedListener(this);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnClickListener(this);
    if (AppSetting.j)
    {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setContentDescription("文本框，正在编辑");
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription("发送按钮");
    }
    DeviceLib.a(getContext(), this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
  }
  
  private void g()
  {
    String str = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
    str = Pattern.compile("\n").matcher(str).replaceAll("");
    str = Pattern.compile("^ +").matcher(str).replaceAll("");
    str = Pattern.compile(" +$").matcher(str).replaceAll("");
    int k = str.length();
    if (k == 0) {
      QQToast.a(getContext(), 2131364786, 0).b(AIOUtils.a(50.0F, getResources()));
    }
    do
    {
      return;
      if (k < 0)
      {
        QQToast.a(getContext(), getContext().getString(2131364787, new Object[] { Integer.valueOf(0) }), 0).b(AIOUtils.a(50.0F, getResources()));
        return;
      }
      if (k > 50)
      {
        QQToast.a(getContext(), getContext().getString(2131364788, new Object[] { Integer.valueOf(50) }), 0).b(AIOUtils.a(50.0F, getResources()));
        return;
      }
      if (!HttpUtil.a(getContext()))
      {
        QQToast.a(getContext(), 2131367339, 0).b(AIOUtils.a(50.0F, getResources()));
        return;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqFreshnewsQQInputView$IQQInputCallback == null);
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsQQInputView$IQQInputCallback.a(str);
  }
  
  private void h()
  {
    this.f = 0;
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842146);
    if (AppSetting.j) {
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription("键盘按钮");
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.setVisibility(8);
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
  }
  
  public void a(EmoticonInfo paramEmoticonInfo)
  {
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText() == null) {}
    for (Object localObject = null;; localObject = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString())
    {
      if ((android.text.TextUtils.isEmpty((CharSequence)localObject)) || ((!android.text.TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).length() < 49))) {
        paramEmoticonInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, null);
      }
      return;
    }
  }
  
  public void a(EmoticonInfo paramEmoticonInfo1, EmoticonInfo paramEmoticonInfo2, Drawable paramDrawable) {}
  
  public boolean a(EmoticonInfo paramEmoticonInfo)
  {
    return false;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
    paramEditable = Pattern.compile("\n").matcher(paramEditable).replaceAll("");
    paramEditable = Pattern.compile("^ +").matcher(paramEditable).replaceAll("");
    if (Pattern.compile(" +$").matcher(paramEditable).replaceAll("").length() > 0)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      this.jdField_a_of_type_AndroidWidgetButton.setSelected(true);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetButton.setSelected(false);
  }
  
  public void b()
  {
    com.tencent.mobileqq.text.TextUtils.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
  }
  
  public void b(EmoticonInfo paramEmoticonInfo) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void c() {}
  
  public void d() {}
  
  public void e()
  {
    a(this.f);
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.clearFocus();
    InputMethodUtil.b(this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
  }
  
  public void onClick(View paramView)
  {
    if (paramView == null) {}
    do
    {
      do
      {
        return;
        if (paramView != this.jdField_a_of_type_AndroidWidgetImageView) {
          break;
        }
      } while (System.currentTimeMillis() - this.jdField_a_of_type_Long < 500L);
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.getVisibility() == 8) {}
      for (this.f = 1;; this.f = 0)
      {
        e();
        return;
      }
      if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
      {
        g();
        return;
      }
    } while (paramView != this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
    a(0);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = this.jdField_a_of_type_ComTencentMobileqqDatingWidgetInputBar.getBottom();
    paramInt2 = this.jdField_a_of_type_ComTencentMobileqqDatingWidgetInputBar.getTop();
    if (paramInt2 <= 0) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("input", 2, "onLayout.bottom=" + paramInt1 + ",top=" + paramInt2 + ",mFistBottom" + this.h + " mLastBottom=" + this.g + ",mFirstTop=" + this.i + ",mLastTop=" + this.j);
    }
    if (this.h == 0) {
      this.h = paramInt1;
    }
    if (this.i == 0) {
      this.i = paramInt2;
    }
    if ((paramBoolean) && (paramInt4 == this.h) && (this.g < paramInt4)) {
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = false;
        post(new sro(this));
      }
    }
    for (;;)
    {
      this.g = paramInt1;
      this.j = paramInt2;
      return;
      String str;
      if ((paramInt2 == this.i) && (paramInt2 > this.j))
      {
        if (QLog.isColorLevel()) {
          QLog.d("input", 2, "inputview hide");
        }
        if (this.jdField_a_of_type_ComTencentMobileqqFreshnewsQQInputView$IQQInputCallback != null)
        {
          str = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
          str = Pattern.compile("\n").matcher(str).replaceAll("");
          str = Pattern.compile("^ +").matcher(str).replaceAll("");
          str = Pattern.compile(" +$").matcher(str).replaceAll("");
          paramInt3 = str.length();
          if ((paramInt3 == 0) || (paramInt3 < 0) || (paramInt3 > 50)) {
            str = "";
          }
          this.jdField_a_of_type_ComTencentMobileqqFreshnewsQQInputView$IQQInputCallback.b(str);
        }
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint("添加评论...");
        h();
      }
      else if ((this.j == this.i) && (paramInt2 != this.j))
      {
        if (QLog.isColorLevel()) {
          QLog.d("input", 2, "inputview show");
        }
        if (android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString()))
        {
          str = null;
          if (this.jdField_a_of_type_ComTencentMobileqqFreshnewsQQInputView$IQQInputCallback != null) {
            str = this.jdField_a_of_type_ComTencentMobileqqFreshnewsQQInputView$IQQInputCallback.b();
          }
          if (!android.text.TextUtils.isEmpty(str))
          {
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(str);
            this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
            this.jdField_a_of_type_AndroidWidgetButton.setSelected(false);
          }
        }
        if (this.jdField_a_of_type_ComTencentMobileqqFreshnewsQQInputView$IQQInputCallback != null) {
          this.jdField_a_of_type_ComTencentMobileqqFreshnewsQQInputView$IQQInputCallback.i();
        }
      }
      else if ((paramInt2 != this.j) && (this.jdField_a_of_type_ComTencentMobileqqFreshnewsQQInputView$IQQInputCallback != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqFreshnewsQQInputView$IQQInputCallback.a(paramInt2);
      }
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void setCallback(QQInputView.IQQInputCallback paramIQQInputCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsQQInputView$IQQInputCallback = paramIQQInputCallback;
    this.jdField_a_of_type_AndroidOsHandler.post(new srl(this));
  }
  
  public void setHintTextColor(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHintTextColor(paramInt);
    }
  }
  
  public void setting() {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\freshnews\QQInputView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */