package com.tencent.biz.eqq;

import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.text.QQText.LinkSpan;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrmIvrText$CrmIvrLinkSpan
  extends QQText.LinkSpan
{
  public CrmIvrText$CrmIvrLinkSpan(CrmIvrText paramCrmIvrText, String paramString)
  {
    super(paramCrmIvrText, paramString);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (CrmUtils.a.matcher(this.jdField_a_of_type_JavaLangString).find())
    {
      CrmIvrText.a(paramView, this.jdField_a_of_type_ComTencentBizEqqCrmIvrText.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizEqqCrmIvrText.b, this.jdField_a_of_type_ComTencentBizEqqCrmIvrText.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
    super.onClick(paramView);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\eqq\CrmIvrText$CrmIvrLinkSpan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */