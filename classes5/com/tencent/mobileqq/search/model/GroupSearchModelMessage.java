package com.tencent.mobileqq.search.model;

import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.activity.MessageSearchActivity;
import com.tencent.mobileqq.search.util.SearchUtils;
import java.util.List;

public class GroupSearchModelMessage
  implements ISearchResultGroupModel
{
  private String jdField_a_of_type_JavaLangString;
  private List jdField_a_of_type_JavaUtilList;
  
  public GroupSearchModelMessage(List paramList, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public int a()
  {
    return 2;
  }
  
  public String a()
  {
    return "聊天记录";
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(View paramView)
  {
    SearchUtils.a(this.jdField_a_of_type_JavaLangString, 40, 0, paramView);
    MessageSearchActivity.a(paramView.getContext(), this.jdField_a_of_type_JavaLangString);
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


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\model\GroupSearchModelMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */