package com.tencent.mobileqq.freshnews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.theme.ThemeUtil;

public class FreshNewsDetailCommentDivider
  extends LinearLayout
{
  private static final String jdField_a_of_type_JavaLangString = "FreshNewsDetailCommentDivider";
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  
  public FreshNewsDetailCommentDivider(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = ((BaseActivity)paramContext);
    a(paramContext);
  }
  
  public FreshNewsDetailCommentDivider(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = ((BaseActivity)paramContext);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2130904166, this, true);
    if (ThemeUtil.isInNightMode(this.a.app))
    {
      paramContext.setBackgroundResource(2131427638);
      return;
    }
    paramContext.setBackgroundResource(2131427407);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\freshnews\FreshNewsDetailCommentDivider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */