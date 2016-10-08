package com.tencent.mobileqq.search.ftsentity;

import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import java.util.List;

public abstract class FTSGroupSearchModelEntity
  implements ISearchResultGroupModel
{
  protected String a;
  protected List a;
  
  public FTSGroupSearchModelEntity(List paramList, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public int a()
  {
    return 2;
  }
  
  public abstract String a();
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public abstract void a(View paramView);
  
  public int b()
  {
    return 3;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\ftsentity\FTSGroupSearchModelEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */