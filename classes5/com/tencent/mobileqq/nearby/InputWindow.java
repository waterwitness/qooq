package com.tencent.mobileqq.nearby;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.devicelib.DeviceLib;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.dating.widget.InputBar;
import com.tencent.mobileqq.dating.widget.InputBar.IIputBarCallback;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.TroopBarPublishUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.ListView;
import com.tencent.widget.XEditTextEx;
import thg;

public abstract class InputWindow
  extends Dialog
  implements TextWatcher, View.OnClickListener, InputBar.IIputBarCallback, EmoticonCallback
{
  public static final int a = 50;
  public static final int b = 0;
  public static final int c = 1;
  public static final int d = 2;
  public static final int e = 1;
  public static final int f = 2;
  public static final int g = -1;
  protected long a;
  protected Handler a;
  protected View a;
  protected Button a;
  protected FrameLayout a;
  protected ImageView a;
  protected BaseActivity a;
  protected InputBar a;
  public SystemAndEmojiEmoticonPanel a;
  protected ListView a;
  protected XEditTextEx a;
  protected boolean a;
  protected View b;
  protected int h;
  protected int i;
  public int j;
  
  public InputWindow(BaseActivity paramBaseActivity, boolean paramBoolean, ListView paramListView, int paramInt)
  {
    super(paramBaseActivity, 2131558990);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.i = 1;
    this.j = -1;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.h = paramInt;
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramBaseActivity).inflate(2130904200, null);
    setContentView(this.jdField_a_of_type_AndroidViewView);
    paramBaseActivity = getWindow().getAttributes();
    paramBaseActivity.x = 0;
    paramBaseActivity.y = 0;
    paramBaseActivity.width = -1;
    paramBaseActivity.windowAnimations = 16973824;
    paramBaseActivity.gravity = 83;
    paramBaseActivity.softInputMode = 21;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297864));
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx = ((XEditTextEx)this.jdField_a_of_type_AndroidViewView.findViewById(2131297412));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131298663));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131299735));
    this.b = this.jdField_a_of_type_AndroidViewView.findViewById(2131299736);
    this.jdField_a_of_type_ComTencentMobileqqDatingWidgetInputBar = ((InputBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131297409));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel = TroopBarPublishUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, this);
    DeviceLib.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.addTextChangedListener(this);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnClickListener(this);
    if (AppSetting.j)
    {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setContentDescription("文本框，正在编辑");
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription("发送按钮");
    }
    DeviceLib.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getContext(), this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
    this.jdField_a_of_type_ComTencentMobileqqDatingWidgetInputBar.setmCallback(this);
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
  
  public void a(String paramString)
  {
    if (android.text.TextUtils.isEmpty(paramString)) {
      return;
    }
    int k = paramString.length();
    if (k == 0)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131364786, 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
      return;
    }
    if (k < 0)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131364787, new Object[] { Integer.valueOf(0) }), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
      return;
    }
    if (k > 50)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131364788, new Object[] { Integer.valueOf(50) }), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
      return;
    }
    if (!HttpUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131367339, 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
    dismiss();
  }
  
  public boolean a(EmoticonInfo paramEmoticonInfo)
  {
    return false;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (NearbyUtils.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString()).length() > 0)
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
  
  public void dismiss()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.a();
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel = null;
    }
    InputMethodUtil.b(this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
    this.jdField_a_of_type_ComTencentMobileqqDatingWidgetInputBar.a();
    if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()) {
      super.dismiss();
    }
  }
  
  public void e()
  {
    if ((this.i == 2) && (this.j != 2)) {
      this.jdField_a_of_type_AndroidOsHandler.post(new thg(this));
    }
    do
    {
      return;
      if ((this.i == 1) && (this.j == 1))
      {
        this.j = -1;
        return;
      }
      if ((this.i == 1) && (this.j == -1))
      {
        this.j = 1;
        return;
      }
    } while ((this.i != 1) || (this.j == 1));
    InputMethodUtil.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
    this.j = 1;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
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
              if (this.j == -1)
              {
                this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.setVisibility(0);
                this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842147);
                if (AppSetting.j) {
                  this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription("键盘按钮");
                }
                this.i = 2;
                this.j = 2;
                return;
              }
              if (this.j != 2) {
                break;
              }
              this.i = 1;
              this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.setVisibility(8);
              this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842146);
            } while (!AppSetting.j);
            this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription("键盘按钮");
            return;
          } while (this.j != 1);
          this.i = 2;
          InputMethodUtil.b(this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842147);
        } while (!AppSetting.j);
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription("表情按钮");
        return;
        if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
        {
          a(NearbyUtils.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString()));
          return;
        }
        if (paramView == this.b)
        {
          dismiss();
          return;
        }
      } while (paramView != this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.getVisibility() != 0) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.setVisibility(8);
      this.i = 1;
      this.j = -1;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842146);
    } while (!AppSetting.j);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription("表情按钮");
    return;
    this.i = 1;
    this.j = 1;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void setting() {}
  
  public void show()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing())
    {
      super.show();
      getWindow().setBackgroundDrawable(new ColorDrawable());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\InputWindow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */