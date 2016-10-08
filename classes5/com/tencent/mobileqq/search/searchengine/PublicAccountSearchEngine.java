package com.tencent.mobileqq.search.searchengine;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.search.activity.GroupSearchActivity;
import com.tencent.mobileqq.search.model.IContactSearchModel;
import com.tencent.mobileqq.search.model.PublicAccountSearchResultModel;
import com.tencent.mobileqq.search.util.PAOfflineSearchManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import umz;
import una;
import unb;

public class PublicAccountSearchEngine
  implements ISearchEngine, Runnable
{
  private static final String jdField_a_of_type_JavaLangString = "PublicAccountSearchEngine";
  private static final Comparator jdField_a_of_type_JavaUtilComparator = new una();
  private static final Comparator b = new unb();
  private int jdField_a_of_type_Int = -1;
  private PublicAccountDataManager jdField_a_of_type_ComTencentMobileqqAppPublicAccountDataManager;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public PublicAccountSearchEngine(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountDataManager = ((PublicAccountDataManager)paramQQAppInterface.getManager(55));
  }
  
  public PublicAccountSearchEngine(QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountDataManager = ((PublicAccountDataManager)paramQQAppInterface.getManager(55));
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void a(String paramString)
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if ((localBaseActivity != null) && ((localBaseActivity instanceof GroupSearchActivity))) {
      ReportController.b(localBaseActivity.app, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D1B", "0X8005D1B", 0, 1, 0, "", "", paramString, "");
    }
  }
  
  private static int b(IContactSearchModel paramIContactSearchModel1, IContactSearchModel paramIContactSearchModel2)
  {
    int j = 0;
    int i = j;
    if (paramIContactSearchModel2.a() != null)
    {
      i = j;
      if (paramIContactSearchModel1.a() != null) {
        i = paramIContactSearchModel1.a().toString().compareTo(paramIContactSearchModel2.a().toString());
      }
    }
    j = i;
    if (i == 0)
    {
      j = i;
      if (paramIContactSearchModel2.b() != null)
      {
        j = i;
        if (paramIContactSearchModel1.b() != null) {
          j = paramIContactSearchModel1.b().toString().compareTo(paramIContactSearchModel2.b().toString());
        }
      }
    }
    return j;
  }
  
  public List a(SearchRequest paramSearchRequest)
  {
    long l1 = System.currentTimeMillis();
    while (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountDataManager.a()) {}
    long l2 = System.currentTimeMillis();
    Object localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountDataManager.a();
    ArrayList localArrayList = PAOfflineSearchManager.a().a();
    if ((localObject4 == null) || (((List)localObject4).isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountSearchEngine", 2, "all publicAccountInfoList is null or empty");
      }
      return null;
    }
    Object localObject1 = new ArrayList();
    Object localObject2 = new HashMap();
    int j = ((List)localObject4).size();
    int i = 0;
    Object localObject5;
    PublicAccountSearchResultModel localPublicAccountSearchResultModel1;
    if (i < j)
    {
      localObject5 = (Entity)((List)localObject4).get(i);
      if ((localObject5 == null) || (!(localObject5 instanceof PublicAccountInfo))) {}
      for (;;)
      {
        i += 1;
        break;
        localObject5 = (PublicAccountInfo)localObject5;
        if ((this.jdField_a_of_type_Int != 12) || (PublicAccountUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((PublicAccountInfo)localObject5).getUin())))
        {
          localPublicAccountSearchResultModel1 = new PublicAccountSearchResultModel(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (PublicAccountInfo)localObject5, this.jdField_a_of_type_Int);
          localPublicAccountSearchResultModel1.b(paramSearchRequest.a);
          if (localPublicAccountSearchResultModel1.b() != Long.MIN_VALUE)
          {
            PublicAccountSearchResultModel localPublicAccountSearchResultModel2 = (PublicAccountSearchResultModel)((HashMap)localObject2).get(localPublicAccountSearchResultModel1.a());
            if ((localPublicAccountSearchResultModel2 == null) || (localPublicAccountSearchResultModel2.b() < localPublicAccountSearchResultModel1.b())) {
              ((HashMap)localObject2).put(localPublicAccountSearchResultModel1.a(), localPublicAccountSearchResultModel1);
            }
          }
          if ((localObject5 != null) && (((PublicAccountInfo)localObject5).displayNumber != null) && (((PublicAccountInfo)localObject5).displayNumber.equalsIgnoreCase(localPublicAccountSearchResultModel1.b()))) {
            ((List)localObject1).add(localPublicAccountSearchResultModel1);
          }
        }
      }
    }
    if (localArrayList != null) {}
    for (;;)
    {
      try
      {
        j = localArrayList.size();
        i = 0;
        if (i < j)
        {
          localObject4 = (Entity)localArrayList.get(i);
          if ((localObject4 == null) || (!(localObject4 instanceof PublicAccountInfo))) {
            break label742;
          }
          localObject4 = (PublicAccountInfo)localObject4;
          localObject5 = new PublicAccountSearchResultModel(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (PublicAccountInfo)localObject4, this.jdField_a_of_type_Int);
          ((PublicAccountSearchResultModel)localObject5).b(paramSearchRequest.a);
          if (((PublicAccountSearchResultModel)localObject5).b() != Long.MIN_VALUE)
          {
            localPublicAccountSearchResultModel1 = (PublicAccountSearchResultModel)((HashMap)localObject2).get(((PublicAccountSearchResultModel)localObject5).a());
            if ((localPublicAccountSearchResultModel1 == null) || (localPublicAccountSearchResultModel1.b() < ((PublicAccountSearchResultModel)localObject5).b())) {
              ((HashMap)localObject2).put(((PublicAccountSearchResultModel)localObject5).a(), localObject5);
            }
          }
          if ((localObject4 == null) || (((PublicAccountInfo)localObject4).displayNumber == null) || (!((PublicAccountInfo)localObject4).displayNumber.equalsIgnoreCase(((PublicAccountSearchResultModel)localObject5).b())) || (((List)localObject1).size() != 0)) {
            break label742;
          }
          ((List)localObject1).add(localObject5);
        }
      }
      catch (Exception localException)
      {
        QLog.d("PublicAccountSearchEngine", 1, "", localException);
      }
      Object localObject3 = new ArrayList();
      ((List)localObject3).addAll(((HashMap)localObject2).values());
      Collections.sort((List)localObject3, jdField_a_of_type_JavaUtilComparator);
      i = Math.min(((List)localObject3).size(), 30);
      localObject4 = ((List)localObject3).subList(0, i);
      Collections.sort((List)localObject4, b);
      localObject2 = new ArrayList();
      ((List)localObject2).addAll((Collection)localObject4);
      ((List)localObject2).addAll(((List)localObject3).subList(i, ((List)localObject3).size()));
      ((List)localObject2).removeAll((Collection)localObject1);
      ((List)localObject2).addAll(0, (Collection)localObject1);
      localObject1 = ((List)localObject2).iterator();
      i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (PublicAccountSearchResultModel)((Iterator)localObject1).next();
        i += 1;
        ((PublicAccountSearchResultModel)localObject3).a(i);
      }
      if (!((List)localObject2).isEmpty()) {
        a(paramSearchRequest.a);
      }
      long l3 = System.currentTimeMillis();
      if (QLog.isDevelopLevel()) {
        QLog.d("PublicAccountSearchEngine", 4, "pubacc search cost:" + (l3 - l1) + ", pure search cost:" + (l3 - l2));
      }
      return (List)localObject2;
      label742:
      i += 1;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountDataManager == null) {}
    while (this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountDataManager.a) {
      return;
    }
    ThreadManager.a(this, 5, null, true);
  }
  
  public void a(SearchRequest paramSearchRequest, ISearchListener paramISearchListener)
  {
    ThreadManager.a(new umz(this, paramSearchRequest, paramISearchListener), null, true);
    if (!TextUtils.isEmpty(paramSearchRequest.a)) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D1D", "0X8005D1D", 0, 1, 0, "", "", paramSearchRequest.a, "");
    }
  }
  
  public void b() {}
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountDataManager.a();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\searchengine\PublicAccountSearchEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */