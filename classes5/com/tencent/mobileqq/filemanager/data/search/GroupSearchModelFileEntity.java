package com.tencent.mobileqq.filemanager.data.search;

import android.view.View;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.util.SearchUtils;
import java.util.List;

public class GroupSearchModelFileEntity
  implements ISearchResultGroupModel
{
  String jdField_a_of_type_JavaLangString;
  List jdField_a_of_type_JavaUtilList;
  
  public GroupSearchModelFileEntity(List paramList, String paramString)
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
    return "文件";
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(View paramView)
  {
    SearchUtils.a(this.jdField_a_of_type_JavaLangString, 100, 0, paramView);
    FileManagerReporter.a("0X8006061");
    FileSearchActivity.a(paramView.getContext(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilList);
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


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\data\search\GroupSearchModelFileEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */