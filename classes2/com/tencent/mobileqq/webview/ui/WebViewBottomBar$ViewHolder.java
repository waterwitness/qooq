package com.tencent.mobileqq.webview.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class WebViewBottomBar$ViewHolder
{
  private int jdField_a_of_type_Int;
  public ImageView a;
  public TextView a;
  private ImageView b;
  public TextView b;
  private TextView c;
  
  public WebViewBottomBar$ViewHolder(WebViewBottomBar paramWebViewBottomBar, View paramView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131298198));
    this.c = ((TextView)paramView.findViewById(2131305297));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131305296));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131305294));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131305295));
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(paramInt);
  }
  
  public void a(String paramString)
  {
    this.c.setText(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    this.c.setSelected(paramBoolean);
    this.jdField_b_of_type_AndroidWidgetImageView.setSelected(paramBoolean);
  }
  
  public void b(int paramInt)
  {
    ColorStateList localColorStateList = WebViewBottomBar.a(this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewBottomBar).getResources().getColorStateList(paramInt);
    if (localColorStateList != null)
    {
      this.c.setTextColor(localColorStateList);
      return;
    }
    this.c.setTextColor(paramInt);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\webview\ui\WebViewBottomBar$ViewHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */