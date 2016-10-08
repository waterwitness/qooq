package com.tencent.mobileqq.activity.aio.tips;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import off;

public class VipFunCallTipsBar
  implements TipsBarTask
{
  private static final String b = "VipFunCallTipsBar";
  private Context jdField_a_of_type_AndroidContentContext;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  public TipsManager a;
  public QQAppInterface a;
  public String a;
  
  public VipFunCallTipsBar(QQAppInterface paramQQAppInterface, TipsManager paramTipsManager, Context paramContext, String paramString, View.OnClickListener paramOnClickListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager = paramTipsManager;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public int a()
  {
    return 36;
  }
  
  public View a(Object... paramVarArgs)
  {
    paramVarArgs = (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903159, null);
    ImageView localImageView1 = (ImageView)paramVarArgs.findViewById(2131297397);
    TextView localTextView = (TextView)paramVarArgs.findViewById(2131297398);
    ImageView localImageView2 = (ImageView)paramVarArgs.findViewById(2131297399);
    localTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131367856));
    localImageView1.setImageResource(2130840541);
    paramVarArgs.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131367856));
    paramVarArgs.setOnClickListener(new off(this));
    localImageView2.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    return paramVarArgs;
  }
  
  public void a(int paramInt, Object... paramVarArgs) {}
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public int[] a()
  {
    return null;
  }
  
  public int b()
  {
    return 10;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\tips\VipFunCallTipsBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */