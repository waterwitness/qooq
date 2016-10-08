package com.tencent.mobileqq.webview.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.ValueAnimation;
import wju;
import wjv;
import wjw;

public class WebViewTitlerBar
{
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  public View.OnClickListener a;
  public View a;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private CustomWebView jdField_a_of_type_ComTencentBizPubaccountCustomWebView;
  public String a;
  private boolean jdField_a_of_type_Boolean;
  private FrameLayout jdField_b_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  
  public WebViewTitlerBar(Activity paramActivity, CustomWebView paramCustomWebView, ViewGroup paramViewGroup)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 255;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = paramCustomWebView;
    a(paramViewGroup);
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131305298));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131305299));
    this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131305301));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297139));
    this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
    this.jdField_a_of_type_AndroidWidgetTextView.setMaxEms(9);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131305300));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297083));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297183));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297392));
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public ImageView a()
  {
    return this.jdField_b_of_type_AndroidWidgetImageView;
  }
  
  public TextView a()
  {
    return this.jdField_b_of_type_AndroidWidgetTextView;
  }
  
  public CharSequence a()
  {
    if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
      return this.jdField_c_of_type_AndroidWidgetTextView.getText();
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Boolean = false;
    }
    if (paramInt2 == 0)
    {
      this.jdField_a_of_type_AndroidViewView.getBackground().mutate().setAlpha(paramInt1);
      this.jdField_a_of_type_Int = paramInt1;
    }
    while (this.jdField_a_of_type_Int == paramInt1) {
      return;
    }
    a(this.jdField_a_of_type_Int, paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 == 0)
    {
      this.jdField_a_of_type_AndroidViewView.getBackground().mutate().setAlpha(paramInt2);
      return;
    }
    ValueAnimation localValueAnimation = new ValueAnimation(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), new wjw(this, paramInt2));
    localValueAnimation.setDuration(paramInt3);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewView.startAnimation(localValueAnimation);
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
  }
  
  public void a(View paramView)
  {
    try
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
      if (paramView.getLayoutParams() == null) {
        paramView.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(paramView);
      return;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
    }
  }
  
  protected void a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2130905102, paramViewGroup, true);
  }
  
  public void a(ImageView paramImageView)
  {
    this.jdField_c_of_type_AndroidWidgetImageView = paramImageView;
  }
  
  public void a(CharSequence paramCharSequence)
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramCharSequence);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    int i = 0;
    if (!TextUtils.isEmpty(paramString2))
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramString2);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.bringToFront();
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundColor(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (!TextUtils.isEmpty(paramString3)) {}
    try
    {
      int j = Color.parseColor(paramString3);
      i = j;
    }
    catch (Exception paramString2)
    {
      for (;;) {}
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(i);
    if (paramString1 != null)
    {
      this.jdField_a_of_type_JavaLangString = paramString1.trim();
      b(new wjv(this));
      return;
    }
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt1, int paramInt2, View.OnClickListener paramOnClickListener)
  {
    if (paramInt1 == 0) {
      a(paramString1, paramString2, paramString3);
    }
    for (;;)
    {
      if (paramBoolean)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        if (this.jdField_c_of_type_AndroidWidgetImageView != null) {
          this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        }
      }
      return;
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      switch (paramInt1)
      {
      case 6: 
      case 7: 
      case 8: 
      case 9: 
      case 10: 
      case 11: 
      default: 
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        label141:
        if (paramInt2 != 0) {
          if (this.jdField_c_of_type_AndroidWidgetImageView == null)
          {
            this.jdField_c_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidAppActivity);
            if (this.jdField_b_of_type_AndroidWidgetFrameLayout != null)
            {
              paramString3 = new FrameLayout.LayoutParams(-2, -2);
              paramString3.setMargins(0, 0, 0, 0);
              this.jdField_c_of_type_AndroidWidgetImageView.setLayoutParams(paramString3);
              paramString3.gravity = 53;
              paramString3.setMargins(0, 0, DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 5.0F), 0);
              this.jdField_b_of_type_AndroidWidgetFrameLayout.addView(this.jdField_c_of_type_AndroidWidgetImageView);
            }
            this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
            switch (paramInt2)
            {
            default: 
              this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
            }
          }
        }
        break;
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(paramString2)) {
          this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(paramString2);
        }
        if (paramOnClickListener == null) {
          break label546;
        }
        c(paramOnClickListener);
        break;
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130840164);
        this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131368938));
        break label141;
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130840163);
        this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131368935));
        break label141;
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838587);
        this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131368932));
        break label141;
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838290);
        this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131368933));
        break label141;
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130840213);
        this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131368936));
        ((AnimationDrawable)this.jdField_b_of_type_AndroidWidgetImageView.getDrawable()).start();
        break label141;
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838089);
        break label141;
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130840077);
        continue;
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130843322);
        continue;
        if (this.jdField_c_of_type_AndroidWidgetImageView != null) {
          this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        }
      }
      label546:
      if (paramString1 != null)
      {
        this.jdField_a_of_type_JavaLangString = paramString1.trim();
        c(new wju(this));
      }
      else
      {
        this.jdField_a_of_type_JavaLangString = null;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    ImageView localImageView = this.jdField_b_of_type_AndroidWidgetImageView;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      return;
    }
  }
  
  public ImageView b()
  {
    return this.jdField_c_of_type_AndroidWidgetImageView;
  }
  
  public TextView b()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  public CharSequence b()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      return this.jdField_a_of_type_AndroidWidgetTextView.getText();
    }
    return null;
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(paramInt);
  }
  
  public void b(View.OnClickListener paramOnClickListener)
  {
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
  }
  
  public void b(View paramView)
  {
    try
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramView, new RelativeLayout.LayoutParams(-2, -1));
      return;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
    }
  }
  
  public void b(CharSequence paramCharSequence)
  {
    if (this.jdField_c_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramCharSequence);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    TextView localTextView;
    if (this.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 4)
    {
      localTextView.setVisibility(i);
      return;
    }
  }
  
  public TextView c()
  {
    return this.jdField_c_of_type_AndroidWidgetTextView;
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void c(View.OnClickListener paramOnClickListener)
  {
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
  }
  
  public void c(View paramView)
  {
    try
    {
      this.jdField_b_of_type_AndroidWidgetFrameLayout.removeAllViews();
      if (paramView.getLayoutParams() == null) {
        paramView.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
      }
      this.jdField_b_of_type_AndroidWidgetFrameLayout.addView(paramView);
      return;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
    }
  }
  
  public void c(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramCharSequence);
  }
  
  public void c(boolean paramBoolean)
  {
    TextView localTextView;
    if (this.jdField_c_of_type_AndroidWidgetTextView != null)
    {
      localTextView = this.jdField_c_of_type_AndroidWidgetTextView;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      return;
    }
  }
  
  public void d(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
  }
  
  public void d(boolean paramBoolean)
  {
    if (this.jdField_c_of_type_AndroidWidgetTextView == null) {
      return;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setEnabled(paramBoolean);
  }
  
  public void e(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
  }
  
  public void e(boolean paramBoolean)
  {
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\webview\ui\WebViewTitlerBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */