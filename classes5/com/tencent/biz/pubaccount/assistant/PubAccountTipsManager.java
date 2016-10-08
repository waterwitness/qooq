package com.tencent.biz.pubaccount.assistant;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.DisplayUtil;

public class PubAccountTipsManager
{
  public static String a;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private View[] jdField_a_of_type_ArrayOfAndroidViewView = { this.jdField_a_of_type_AndroidViewView };
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = "tag_on_nearby_tips_click";
  }
  
  public PubAccountTipsManager(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public View a(String paramString, View.OnClickListener paramOnClickListener)
  {
    if ((this.jdField_a_of_type_AndroidContentContext == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)this.jdField_a_of_type_AndroidViewView).setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131427407));
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130841684);
      ((TextView)this.jdField_a_of_type_AndroidViewView).setGravity(16);
      this.jdField_a_of_type_AndroidViewView.setTag(jdField_a_of_type_JavaLangString);
      ((TextView)this.jdField_a_of_type_AndroidViewView).setTextSize(this.jdField_a_of_type_AndroidContentContext.getResources().getInteger(2131623939));
    }
    ((TextView)this.jdField_a_of_type_AndroidViewView).setText(paramString);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(paramOnClickListener);
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a(ViewGroup paramViewGroup, View paramView)
  {
    if ((paramViewGroup == null) || (paramView == null)) {}
    do
    {
      return;
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfAndroidViewView.length)
      {
        if ((this.jdField_a_of_type_ArrayOfAndroidViewView[i] != null) && (this.jdField_a_of_type_ArrayOfAndroidViewView[i] != paramView) && (paramViewGroup.indexOfChild(this.jdField_a_of_type_ArrayOfAndroidViewView[i]) != -1)) {
          paramViewGroup.removeView(this.jdField_a_of_type_ArrayOfAndroidViewView[i]);
        }
        i += 1;
      }
    } while (paramViewGroup.indexOfChild(paramView) != -1);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.topMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 18.0F);
    localLayoutParams.addRule(3, 2131297418);
    localLayoutParams.addRule(11);
    localLayoutParams.rightMargin = DisplayUtil.b(this.jdField_a_of_type_AndroidContentContext, 20.0F);
    paramViewGroup.addView(paramView, localLayoutParams);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\assistant\PubAccountTipsManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */