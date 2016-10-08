package com.tencent.mobileqq.search.ftsentity;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.searchengine.ISearchEngine;
import com.tencent.mobileqq.search.searchengine.ISearchListener;
import com.tencent.mobileqq.search.searchengine.SearchRequest;
import java.util.List;

public abstract class FTSEntitySearchEngine
  implements ISearchEngine
{
  protected QQAppInterface a;
  
  public FTSEntitySearchEngine(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramQQAppInterface;
  }
  
  public abstract List a(SearchRequest paramSearchRequest);
  
  public void a() {}
  
  public abstract void a(SearchRequest paramSearchRequest, ISearchListener paramISearchListener);
  
  public abstract void a(String paramString, List paramList);
  
  public void b() {}
  
  public abstract void b(SearchRequest paramSearchRequest, ISearchListener paramISearchListener);
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\ftsentity\FTSEntitySearchEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */