package com.tencent.mobileqq.search.searchengine;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.fms.FullMessageSearchManager;
import com.tencent.mobileqq.app.fms.FullMessageSearchResult;
import com.tencent.mobileqq.app.fms.FullMessageSearchResult.SearchResultItem;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.model.MessageSearchResultModel;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import ump;
import umr;
import ums;
import umt;

public class MessageSearchEngine
  implements ISearchEngine
{
  public static final String a = "SEARCH_REQUEST_EXTRA_TIME_LIMIT";
  private static final String c = "MessageSearchEngine";
  public QQAppInterface a;
  public FullMessageSearchManager a;
  public String b;
  
  public MessageSearchEngine(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchManager = ((FullMessageSearchManager)paramQQAppInterface.getManager(104));
  }
  
  private List a(String paramString, FullMessageSearchResult paramFullMessageSearchResult)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramFullMessageSearchResult != null) && (paramFullMessageSearchResult.a != null))
    {
      int i = 0;
      while (i < paramFullMessageSearchResult.a.size())
      {
        localArrayList.add(new MessageSearchResultModel(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, (FullMessageSearchResult.SearchResultItem)paramFullMessageSearchResult.a.get(i)));
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public List a(SearchRequest paramSearchRequest)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MessageSearchEngine", 2, "========== search message use MessageSearchEngine");
    }
    this.b = paramSearchRequest.jdField_a_of_type_JavaLangString;
    if ((paramSearchRequest.jdField_a_of_type_AndroidOsBundle != null) && (paramSearchRequest.jdField_a_of_type_AndroidOsBundle.getBoolean("SEARCH_REQUEST_EXTRA_TIME_LIMIT", false))) {}
    for (paramSearchRequest = this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchManager.b(this.b);; paramSearchRequest = this.jdField_a_of_type_ComTencentMobileqqAppFmsFullMessageSearchManager.c(this.b)) {
      return a(this.b, paramSearchRequest);
    }
  }
  
  public void a() {}
  
  public void a(SearchRequest paramSearchRequest, ISearchListener paramISearchListener)
  {
    ThreadManager.a(new ump(this, paramISearchListener, paramSearchRequest), 8, null, true);
  }
  
  public void b()
  {
    ThreadManager.a(new umr(this), 8, null, true);
  }
  
  public void c()
  {
    ThreadManager.a(new ums(this, this.b), 8, null, true);
  }
  
  public void d()
  {
    ThreadManager.a(new umt(this, this.b), 8, null, true);
  }
  
  public void e() {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\searchengine\MessageSearchEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */