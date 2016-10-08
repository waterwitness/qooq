package com.tencent.mobileqq.search.model;

import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.activity.ContactSearchActivity;
import com.tencent.mobileqq.search.util.SearchUtils;
import java.util.List;

public class GroupSearchModelLocalContact
  implements ISearchResultGroupModel
{
  private ISearchResultModel jdField_a_of_type_ComTencentMobileqqSearchModelISearchResultModel;
  private String jdField_a_of_type_JavaLangString;
  public List a;
  private int c;
  
  public GroupSearchModelLocalContact(List paramList, String paramString, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.c = paramInt;
  }
  
  public int a()
  {
    return 2;
  }
  
  public ISearchResultModel a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqSearchModelISearchResultModel;
  }
  
  public String a()
  {
    return "联系人";
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(View paramView)
  {
    ContactSearchActivity.a(paramView.getContext(), this.jdField_a_of_type_JavaLangString, this.c, 197501);
    SearchUtils.a(this.jdField_a_of_type_JavaLangString, 20, 0, paramView);
  }
  
  public void a(ISearchResultModel paramISearchResultModel)
  {
    this.jdField_a_of_type_ComTencentMobileqqSearchModelISearchResultModel = paramISearchResultModel;
  }
  
  public int b()
  {
    return 5;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\model\GroupSearchModelLocalContact.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */