package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class HotChatAnnounceDialog
  extends QQCustomDialog
  implements View.OnClickListener
{
  public static final String a = "HotChatAnnounceDialog";
  Context jdField_a_of_type_AndroidContentContext;
  View jdField_a_of_type_AndroidViewView;
  Button jdField_a_of_type_AndroidWidgetButton;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  View jdField_b_of_type_AndroidViewView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  String jdField_b_of_type_JavaLangString;
  String c;
  
  public HotChatAnnounceDialog(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2)
  {
    super(paramContext, 2131558973);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.c = paramString2;
    a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130904192, null);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131297138);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300751));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    if (TextUtils.isEmpty(this.c)) {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131301781));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131300184));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131365248));
    setContentView(this.jdField_a_of_type_AndroidViewView);
    setCancelable(true);
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics();
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.width = ((int)(((DisplayMetrics)localObject).widthPixels - DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 30.0F)));
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    localObject = getWindow().getAttributes();
    ((WindowManager.LayoutParams)localObject).gravity = 48;
    ((WindowManager.LayoutParams)localObject).y = ((int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 10.0F) + AIOUtils.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131300184: 
      dismiss();
      return;
    }
    paramView = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.c);
    if (paramView != null)
    {
      paramView.b();
      return;
    }
    paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    paramView.putExtra("url", this.c);
    this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\widget\HotChatAnnounceDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */