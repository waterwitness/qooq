package com.tencent.mobileqq.search.searchengine;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.FTSDBManager;
import com.tencent.mobileqq.app.proxy.fts.FTSMsgOperator;
import com.tencent.mobileqq.filemanager.data.search.FileManagerSearchEngine;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.ftsmsg.FTSMessageSearchEngine;
import com.tencent.mobileqq.search.util.SearchConfigManager;
import com.tencent.mobileqq.search.util.SearchStatisticsConstants;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.fts.SQLiteFTSUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.globalsearch.FavoriteSearchEngine;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import ulz;
import uma;
import umb;
import umc;
import umd;
import ume;
import umf;
import umg;
import umh;
import umi;
import umj;
import umk;
import uml;
import umm;
import umn;
import umo;

public class GroupSearchEngine
  implements ISearchEngine, Observer
{
  private static final String jdField_a_of_type_JavaLangString = "GroupSearchEngine";
  private static final Comparator jdField_a_of_type_JavaUtilComparator = new ulz();
  private static final ThreadPoolExecutor jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor = new umg(3, 5, 5L, TimeUnit.SECONDS, new LinkedBlockingQueue(128), new umf());
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = -1L;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private NetSearchEngine jdField_a_of_type_ComTencentMobileqqSearchSearchengineNetSearchEngine;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private Future jdField_a_of_type_JavaUtilConcurrentFuture;
  private ScheduledFuture jdField_a_of_type_JavaUtilConcurrentScheduledFuture;
  private ScheduledThreadPoolExecutor jdField_a_of_type_JavaUtilConcurrentScheduledThreadPoolExecutor;
  private umn jdField_a_of_type_Umn;
  private umo jdField_a_of_type_Umo;
  private String b;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public GroupSearchEngine(QQAppInterface paramQQAppInterface, int paramInt)
  {
    SearchConfigManager.a(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilArrayList = a();
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineNetSearchEngine = new NetSearchEngine(paramQQAppInterface, jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor, paramInt);
    paramQQAppInterface.a().a().a(this);
  }
  
  private ArrayList a()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_Int == 12)
    {
      localArrayList.add(new umh(this, new PublicAccountSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int), "public_account", 50));
      localArrayList.add(new umi(this, new NetSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor, this.jdField_a_of_type_Int), "net_search", 0));
      Collections.sort(localArrayList, jdField_a_of_type_JavaUtilComparator);
      return localArrayList;
    }
    localArrayList.add(new umj(this, new ContactSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int, 197501, null), "people", 20));
    localArrayList.add(new umk(this, new CreateDiscussionSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int), "create_discussion", 120));
    if ((FTSDBManager.a) && (SQLiteFTSUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a()) && (SQLiteFTSUtils.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
    {
      localArrayList.add(new uml(this, new FTSMessageSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), "fts_message", 40));
      if (QLog.isColorLevel()) {
        QLog.d("GroupSearchEngine", 2, "newSearchEngine() searchEngines add FTSMessageSearchEngine");
      }
      if ((FTSDBManager.a) && (SQLiteFTSUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a()) && (SQLiteFTSUtils.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) != 1) && ((!SQLiteFTSUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || (SQLiteFTSUtils.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))) {
        break label486;
      }
      localArrayList.add(new umm(this, new MessageSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), "message", 40));
      if (QLog.isColorLevel()) {
        QLog.d("GroupSearchEngine", 2, "newSearchEngine() searchEngines add MessageSearchEngine");
      }
    }
    for (;;)
    {
      localArrayList.add(new uma(this, new PublicAccountSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), "public_account", 50));
      localArrayList.add(new umb(this, new FavoriteSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), "favorite", 60));
      localArrayList.add(new umc(this, new FileManagerSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), "file", 100));
      localArrayList.add(new umd(this, new NetSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor, this.jdField_a_of_type_Int), "net_search", 0));
      Collections.sort(localArrayList, jdField_a_of_type_JavaUtilComparator);
      return localArrayList;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("GroupSearchEngine", 2, "newSearchEngine() searchEngines not add FTSMessageSearchEngine");
      break;
      label486:
      if (QLog.isColorLevel()) {
        QLog.d("GroupSearchEngine", 2, "newSearchEngine() searchEngines not add MessageSearchEngine");
      }
    }
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentFuture != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentFuture.cancel(true);
      if ((this.jdField_a_of_type_JavaUtilConcurrentFuture instanceof Runnable)) {
        jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.remove((Runnable)this.jdField_a_of_type_JavaUtilConcurrentFuture);
      }
    }
    if (this.jdField_a_of_type_Umn != null) {
      this.jdField_a_of_type_Umn.a();
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentScheduledFuture != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentScheduledFuture.cancel(true);
      if ((this.jdField_a_of_type_JavaUtilConcurrentScheduledThreadPoolExecutor != null) && ((this.jdField_a_of_type_JavaUtilConcurrentScheduledFuture instanceof Runnable))) {
        this.jdField_a_of_type_JavaUtilConcurrentScheduledThreadPoolExecutor.remove((Runnable)this.jdField_a_of_type_JavaUtilConcurrentScheduledFuture);
      }
    }
    if (this.jdField_a_of_type_Umo != null) {
      this.jdField_a_of_type_Umo.a();
    }
  }
  
  public List a(SearchRequest paramSearchRequest)
  {
    return null;
  }
  
  public void a()
  {
    long l1 = System.currentTimeMillis();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((GroupSearchEngine.SearchEngineEntity)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine.a();
      i += 1;
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("GroupSearchEngine", 2, "GroupSearchEngine.init() cost time : " + (l2 - l1));
    }
    StatisticCollector.a(BaseApplicationImpl.a()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "GroupSearchEngineInit", true, l2 - l1, 0L, SearchUtils.a(null), "", false);
  }
  
  public void a(SearchRequest paramSearchRequest, ISearchListener paramISearchListener)
  {
    this.b = paramSearchRequest.jdField_a_of_type_JavaLangString;
    if (paramSearchRequest.jdField_a_of_type_AndroidOsBundle == null) {
      paramSearchRequest.jdField_a_of_type_AndroidOsBundle = new Bundle();
    }
    paramSearchRequest.jdField_a_of_type_AndroidOsBundle.putBoolean("SEARCH_REQUEST_EXTRA_TIME_LIMIT", true);
    paramSearchRequest.jdField_a_of_type_AndroidOsBundle.putBoolean("searchTroopMember", false);
    h();
    this.jdField_a_of_type_Umn = new umn(this, paramSearchRequest, paramISearchListener);
    this.jdField_a_of_type_JavaUtilConcurrentFuture = jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.submit(this.jdField_a_of_type_Umn);
  }
  
  public void b()
  {
    SearchStatisticsConstants.a();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((GroupSearchEngine.SearchEngineEntity)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine.b();
      i += 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineNetSearchEngine.b();
    h();
  }
  
  public void c()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((GroupSearchEngine.SearchEngineEntity)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine.c();
      i += 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineNetSearchEngine.c();
  }
  
  public void d()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((GroupSearchEngine.SearchEngineEntity)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine.d();
      i += 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineNetSearchEngine.d();
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().b(this);
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((GroupSearchEngine.SearchEngineEntity)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine.e();
      i += 1;
    }
    HashMap localHashMap;
    if (this.jdField_a_of_type_Long != -1L)
    {
      localHashMap = new HashMap();
      i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        localHashMap.put(((GroupSearchEngine.SearchEngineEntity)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString, String.valueOf(((GroupSearchEngine.SearchEngineEntity)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Long));
        localHashMap.put(((GroupSearchEngine.SearchEngineEntity)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString + "_size", String.valueOf(((GroupSearchEngine.SearchEngineEntity)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Int));
        i += 1;
      }
      if (this.b != null) {
        break label257;
      }
      str = "";
      localHashMap.put("keyword", str);
      if (this.b != null) {
        break label265;
      }
    }
    label257:
    label265:
    for (String str = "0";; str = Integer.toString(this.b.trim().split("\\s+").length))
    {
      localHashMap.put("keyword_count", str);
      StatisticCollector.a(BaseApplicationImpl.a()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "GroupSearchEngineSearch", true, this.jdField_a_of_type_Long, 0L, SearchUtils.a(localHashMap), "", false);
      return;
      str = this.b;
      break;
    }
  }
  
  public void f()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      GroupSearchEngine.SearchEngineEntity localSearchEngineEntity = (GroupSearchEngine.SearchEngineEntity)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if ((localSearchEngineEntity.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine instanceof FTSMessageSearchEngine)) {
        ((FTSMessageSearchEngine)localSearchEngineEntity.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine).f();
      }
      i += 1;
    }
  }
  
  public void g()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      GroupSearchEngine.SearchEngineEntity localSearchEngineEntity = (GroupSearchEngine.SearchEngineEntity)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if ((localSearchEngineEntity.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine instanceof FTSMessageSearchEngine)) {
        ((FTSMessageSearchEngine)localSearchEngineEntity.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine).g();
      }
      i += 1;
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((FTSDBManager.a) && ((paramObservable instanceof FTSDBManager)))
    {
      paramObservable = this.jdField_a_of_type_JavaUtilArrayList;
      int i = 0;
      for (;;)
      {
        try
        {
          if (i >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
            break;
          }
          paramObject = (GroupSearchEngine.SearchEngineEntity)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          if ((((GroupSearchEngine.SearchEngineEntity)paramObject).jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine instanceof FTSMessageSearchEngine))
          {
            if (QLog.isColorLevel()) {
              QLog.d("GroupSearchEngine", 2, "update() searchEngines has add FTSMessageSearchEngine");
            }
            return;
          }
          if ((((GroupSearchEngine.SearchEngineEntity)paramObject).jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine instanceof MessageSearchEngine))
          {
            paramObject = new FTSMessageSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            ((FTSMessageSearchEngine)paramObject).a();
            this.jdField_a_of_type_JavaUtilArrayList.add(i, new ume(this, (ISearchEngine)paramObject, "fts message", 40));
            if (SQLiteFTSUtils.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 0) {
              this.jdField_a_of_type_JavaUtilArrayList.remove(i + 1);
            }
            if (QLog.isColorLevel()) {
              QLog.d("GroupSearchEngine", 2, "update() searchEngines add FTSMessageSearchEngine");
            }
            return;
          }
        }
        finally {}
        i += 1;
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("GroupSearchEngine", 2, "update() illegal");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\searchengine\GroupSearchEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */