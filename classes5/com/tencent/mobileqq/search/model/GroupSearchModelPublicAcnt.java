package com.tencent.mobileqq.search.model;

import android.content.Context;
import android.view.View;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.activity.PublicAcntSearchActivity;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.List;

public class GroupSearchModelPublicAcnt
  implements ISearchResultGroupModel
{
  private final String jdField_a_of_type_JavaLangString;
  private final List jdField_a_of_type_JavaUtilList;
  private int c;
  
  public GroupSearchModelPublicAcnt(List paramList, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public GroupSearchModelPublicAcnt(List paramList, String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.c = paramInt;
  }
  
  public int a()
  {
    return 2;
  }
  
  public String a()
  {
    if (this.c == 12) {
      return "精选" + PublicAccountConfigUtil.a((QQAppInterface)BaseApplicationImpl.a().a(), BaseApplicationImpl.getContext());
    }
    return "公众号";
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(View paramView)
  {
    SearchUtils.a(this.jdField_a_of_type_JavaLangString, 50, 0, paramView);
    Context localContext = paramView.getContext();
    if ((localContext != null) && ((localContext instanceof BaseActivity))) {
      ReportController.b(((BaseActivity)localContext).app, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D1C", "0X8005D1C", 0, 1, 0, "0", "", this.jdField_a_of_type_JavaLangString, "");
    }
    PublicAcntSearchActivity.a(paramView.getContext(), this.jdField_a_of_type_JavaLangString, this.c);
  }
  
  public int b()
  {
    return 3;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\model\GroupSearchModelPublicAcnt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */