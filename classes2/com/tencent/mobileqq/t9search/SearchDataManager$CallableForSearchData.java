package com.tencent.mobileqq.t9search;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class SearchDataManager$CallableForSearchData
  implements Callable
{
  int jdField_a_of_type_Int;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public SearchDataManager$CallableForSearchData(QQAppInterface paramQQAppInterface, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public List a()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_Int == 1) {
      localArrayList.addAll(SearchDataManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    }
    do
    {
      return localArrayList;
      if (this.jdField_a_of_type_Int == 2)
      {
        localArrayList.addAll(SearchDataManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
        return localArrayList;
      }
    } while (this.jdField_a_of_type_Int != 3);
    localArrayList.addAll(SearchDataManager.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    return localArrayList;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\t9search\SearchDataManager$CallableForSearchData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */