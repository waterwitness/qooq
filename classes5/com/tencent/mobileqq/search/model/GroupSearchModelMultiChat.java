package com.tencent.mobileqq.search.model;

import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

public class GroupSearchModelMultiChat
  implements ISearchResultGroupModel
{
  private final String jdField_a_of_type_JavaLangString;
  private final List jdField_a_of_type_JavaUtilList;
  private int c;
  
  public GroupSearchModelMultiChat(List paramList, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public GroupSearchModelMultiChat(List paramList, String paramString, int paramInt)
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
    return "发起多人聊天";
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(View paramView) {}
  
  public int b()
  {
    return 1;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\model\GroupSearchModelMultiChat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */