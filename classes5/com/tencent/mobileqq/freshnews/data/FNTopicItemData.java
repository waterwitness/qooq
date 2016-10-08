package com.tencent.mobileqq.freshnews.data;

import android.content.Context;
import android.content.res.Resources;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.freshnews.FreshNewsInfo;
import com.tencent.mobileqq.freshnews.topic.TopicInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

public class FNTopicItemData
  extends FNBaseItemData
{
  public String a;
  public int b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public String d;
  public String f;
  
  public FNTopicItemData(FreshNewsInfo paramFreshNewsInfo)
  {
    super(paramFreshNewsInfo);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  int a(Context paramContext)
  {
    TextPaint localTextPaint = new TextPaint(1);
    localTextPaint.density = paramContext.getResources().getDisplayMetrics().density;
    localTextPaint.setTextSize(paramContext.getResources().getDimension(2131492901));
    localTextPaint.setColor(paramContext.getResources().getColor(2131428297));
    int i = ViewUtils.a();
    i = new StaticLayout(this.f, localTextPaint, i, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false).getLineCount();
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby.freshNews", 2, "calcuForeWordLines  lines = " + i + ",foreWord = " + this.f);
    }
    return i;
  }
  
  protected void a(Context paramContext, AppInterface paramAppInterface)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.topicInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.topicInfo.jdField_a_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby.freshNews", 2, "topic info is null");
      }
      return;
    }
    paramAppInterface = new StringBuilder("");
    paramAppInterface.append("#").append(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.topicInfo.jdField_a_of_type_JavaLangString).append("#");
    this.jdField_a_of_type_JavaLangString = paramAppInterface.toString();
    this.f = this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.topicInfo.jdField_b_of_type_JavaLangString;
    if ((this.f != null) && (this.f.length() > 0)) {
      this.jdField_c_of_type_Int = a(paramContext);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.hotFlag > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_b_of_type_Boolean = bool;
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.topicInfo.d;
      this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.topicInfo.jdField_c_of_type_JavaLangString;
      this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.topicInfo.jdField_c_of_type_Int;
      this.d = this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.topicInfo.e;
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\freshnews\data\FNTopicItemData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */