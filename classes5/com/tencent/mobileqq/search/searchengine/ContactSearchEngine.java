package com.tencent.mobileqq.search.searchengine;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.bless.BlessManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.CircleManager;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.FTSDBManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.app.proxy.fts.FTSTroopOperator;
import com.tencent.mobileqq.data.CircleBuddy;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.data.fts.TroopIndex;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.search.IContactSearchable;
import com.tencent.mobileqq.search.model.ContactSearchModelCircleBuddy;
import com.tencent.mobileqq.search.model.ContactSearchModelDiscussion;
import com.tencent.mobileqq.search.model.ContactSearchModelDiscussionMember;
import com.tencent.mobileqq.search.model.ContactSearchModelFriend;
import com.tencent.mobileqq.search.model.ContactSearchModelGlobalTroop;
import com.tencent.mobileqq.search.model.ContactSearchModelGlobalTroop.TroopSearchMemberInfo;
import com.tencent.mobileqq.search.model.ContactSearchModelGlobalTroopMember;
import com.tencent.mobileqq.search.model.ContactSearchModelPhoneContact;
import com.tencent.mobileqq.search.model.ContactSearchModelRecentUser;
import com.tencent.mobileqq.search.model.ContactSearchModelTool;
import com.tencent.mobileqq.search.model.ContactSearchModelTroop;
import com.tencent.mobileqq.search.model.ContactSearchModelTroopMember;
import com.tencent.mobileqq.search.model.IContactSearchModel;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import ulu;
import ulv;
import ulw;
import ulx;
import uly;

public class ContactSearchEngine
  implements ISearchEngine
{
  public static final int a = 1;
  public static final String a = "searchCreateDiscussion";
  private static final Comparator jdField_a_of_type_JavaUtilComparator = new ulu();
  public static boolean a = false;
  public static final int b = 4;
  public static final String b = "searchTroopMember";
  private static final Comparator jdField_b_of_type_JavaUtilComparator = new ulv();
  public static final int c = 8;
  private static final String jdField_c_of_type_JavaLangString = "ContactSearchEngine";
  public static final int d = 16;
  public static final int e = 32;
  public static final int f = 64;
  public static final int g = 256;
  public static final int h = 512;
  public static final int i = 1024;
  public static final int j = 2048;
  public static final int k = 4096;
  public static final int l = 8192;
  public static final int m = 16384;
  public static final int n = 32768;
  public static final int o = 65536;
  public static final int p = 131072;
  public static final int q = 262144;
  public static final int r = 768;
  public static final int s = 29;
  public static final int t = 197501;
  public static final int u = 30;
  private static final int x = 2;
  private long jdField_a_of_type_Long = -1L;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private CreateDiscussionSearchEngine jdField_a_of_type_ComTencentMobileqqSearchSearchengineCreateDiscussionSearchEngine;
  private ISearchListener jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List jdField_a_of_type_JavaUtilList;
  private Map jdField_a_of_type_JavaUtilMap;
  private Queue jdField_a_of_type_JavaUtilQueue = new ConcurrentLinkedQueue();
  private Set jdField_a_of_type_JavaUtilSet;
  private ContactSearchEngine.TypedReportInfo[] jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo = { new ContactSearchEngine.TypedReportInfo(1, "friend"), new ContactSearchEngine.TypedReportInfo(768, "phone_contact"), new ContactSearchEngine.TypedReportInfo(4, "discussion_member"), new ContactSearchEngine.TypedReportInfo(8, "discussion"), new ContactSearchEngine.TypedReportInfo(16, "troop"), new ContactSearchEngine.TypedReportInfo(32, "recent_user"), new ContactSearchEngine.TypedReportInfo(64, "tool"), new ContactSearchEngine.TypedReportInfo(2048, "circle_buddy"), new ContactSearchEngine.TypedReportInfo(131072, "global_troop_member") };
  private long jdField_b_of_type_Long;
  private List jdField_b_of_type_JavaUtilList;
  private Queue jdField_b_of_type_JavaUtilQueue = new ConcurrentLinkedQueue();
  boolean jdField_b_of_type_Boolean = false;
  private long jdField_c_of_type_Long;
  private List jdField_c_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_c_of_type_Boolean;
  private long jdField_d_of_type_Long = -1L;
  private String jdField_d_of_type_JavaLangString;
  private long jdField_e_of_type_Long = -1L;
  private String jdField_e_of_type_JavaLangString;
  private long jdField_f_of_type_Long = -1L;
  private String jdField_f_of_type_JavaLangString;
  private long g = -1L;
  private int v;
  private int w;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ContactSearchEngine(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, String paramString, Set paramSet)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.v = paramInt2;
    this.w = paramInt1;
    this.jdField_a_of_type_JavaUtilSet = paramSet;
    this.jdField_f_of_type_JavaLangString = paramString;
    switch (paramInt2)
    {
    }
    for (;;)
    {
      if (SearchUtils.a(paramInt1)) {
        this.jdField_c_of_type_Boolean = false;
      }
      return;
      this.jdField_e_of_type_JavaLangString = "people";
      continue;
      this.jdField_e_of_type_JavaLangString = "msg";
    }
  }
  
  public ContactSearchEngine(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, Set paramSet)
  {
    this(paramQQAppInterface, paramInt1, paramInt2, null, paramSet);
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 1: 
      return 0;
    case 768: 
      return 1;
    case 4: 
      return 2;
    case 8: 
      return 3;
    case 16: 
      return 4;
    case 32: 
      return 5;
    case 2048: 
      return 7;
    }
    return 8;
  }
  
  public static int a(IContactSearchModel paramIContactSearchModel)
  {
    int i1 = -1;
    if ((paramIContactSearchModel instanceof ContactSearchModelFriend)) {
      i1 = 0;
    }
    do
    {
      return i1;
      if ((paramIContactSearchModel instanceof ContactSearchModelPhoneContact)) {
        return 1;
      }
      if ((paramIContactSearchModel instanceof ContactSearchModelDiscussionMember)) {
        return 2;
      }
      if ((paramIContactSearchModel instanceof ContactSearchModelDiscussion)) {
        return 3;
      }
      if ((paramIContactSearchModel instanceof ContactSearchModelTroop)) {
        return 4;
      }
    } while (!(paramIContactSearchModel instanceof ContactSearchModelRecentUser));
    return 5;
  }
  
  private int a(String paramString)
  {
    paramString = (Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (paramString != null) {
      return paramString.intValue();
    }
    return 0;
  }
  
  private List a()
  {
    g();
    return this.jdField_b_of_type_JavaUtilList;
  }
  
  private List a(String paramString, boolean paramBoolean)
  {
    label243:
    label246:
    for (;;)
    {
      try
      {
        if ((TextUtils.isEmpty(paramString)) || (paramString.trim().contains(" "))) {
          return null;
        }
        int i1 = Integer.MIN_VALUE;
        Object localObject;
        if (paramBoolean)
        {
          localObject = this.jdField_b_of_type_JavaUtilQueue;
          Iterator localIterator = ((Queue)localObject).iterator();
          localObject = null;
          if (localIterator.hasNext())
          {
            uly localuly = (uly)localIterator.next();
            if ((!paramString.contains(localuly.jdField_a_of_type_JavaLangString)) || (localuly.jdField_a_of_type_JavaLangString.length() <= i1)) {
              break label243;
            }
            i1 = localuly.jdField_a_of_type_JavaLangString.length();
            localObject = localuly;
            break label246;
          }
        }
        else
        {
          localObject = this.jdField_a_of_type_JavaUtilQueue;
          continue;
        }
        if ((localObject != null) && (((uly)localObject).jdField_a_of_type_JavaUtilList != null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ContactSearchEngine", 2, "getBestCache hit cache, cur keyword = " + paramString + " , cache keyword = " + ((uly)localObject).jdField_a_of_type_JavaLangString + " , cache size = " + ((uly)localObject).jdField_a_of_type_JavaUtilList.size());
          }
          paramString = ((uly)localObject).jdField_a_of_type_JavaUtilList;
          return paramString;
        }
      }
      finally {}
      if (QLog.isColorLevel()) {
        QLog.d("ContactSearchEngine", 2, "getBestCache miss cache, cur keyword = " + paramString);
      }
      return null;
    }
  }
  
  private List a(ulx paramulx)
  {
    int i1 = 0;
    if (i1 < this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo.length)
    {
      if ("global_troop_member".equals(Integer.valueOf(this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i1].jdField_a_of_type_Int))) {}
      for (;;)
      {
        i1 += 1;
        break;
        this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i1].jdField_b_of_type_Long = -1L;
      }
    }
    String str = this.jdField_d_of_type_JavaLangString;
    List localList = a(str, false);
    if (localList != null)
    {
      if (!QLog.isColorLevel()) {
        break label347;
      }
      QLog.d("ContactSearchEngine", 2, "searchContactWithoutTroopMember use cache, keyword = " + str);
    }
    label347:
    for (;;)
    {
      ArrayList localArrayList = new ArrayList();
      i1 = 0;
      for (;;)
      {
        if (i1 < localList.size())
        {
          if (paramulx.a())
          {
            if (QLog.isColorLevel()) {
              QLog.d("ContactSearchEngine", 2, "searchContactWithoutTroopMember canceled, keyword = " + str);
            }
            return null;
            localList = this.jdField_a_of_type_JavaUtilList;
            break;
          }
          IContactSearchModel localIContactSearchModel = (IContactSearchModel)localList.get(i1);
          long l1 = System.nanoTime();
          try
          {
            localIContactSearchModel.b(str);
            long l2 = System.nanoTime();
            int i2 = a(localIContactSearchModel);
            if (i2 != -1)
            {
              ContactSearchEngine.TypedReportInfo localTypedReportInfo = this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i2];
              localTypedReportInfo.jdField_b_of_type_Long = (l2 - l1 + localTypedReportInfo.jdField_b_of_type_Long);
            }
            if (localIContactSearchModel.b() != Long.MIN_VALUE) {
              localArrayList.add(localIContactSearchModel);
            }
            i1 += 1;
          }
          finally {}
        }
      }
      i1 = 0;
      while (i1 < this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo.length)
      {
        this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i1].jdField_b_of_type_Long /= 1000000L;
        i1 += 1;
      }
      a(str, localArrayList, false);
      return localArrayList;
    }
  }
  
  private Map a()
  {
    g();
    return this.jdField_a_of_type_JavaUtilMap;
  }
  
  private void a(String paramString, List paramList, boolean paramBoolean)
  {
    Queue localQueue;
    for (;;)
    {
      try
      {
        if ((TextUtils.isEmpty(paramString)) || (paramString.trim().contains(" ")) || (paramList == null)) {
          return;
        }
        if (paramBoolean)
        {
          localQueue = this.jdField_b_of_type_JavaUtilQueue;
          if (localQueue.size() <= 2) {
            break;
          }
          localQueue.poll();
          continue;
        }
        localQueue = this.jdField_a_of_type_JavaUtilQueue;
      }
      finally {}
    }
    if (localQueue.size() == 2)
    {
      if (paramList.isEmpty()) {
        break label123;
      }
      localQueue.poll();
    }
    for (;;)
    {
      localQueue.add(new uly(this, paramString, paramList));
      return;
      label123:
      Iterator localIterator = localQueue.iterator();
      while (localIterator.hasNext())
      {
        uly localuly = (uly)localIterator.next();
        if (localuly.jdField_a_of_type_JavaUtilList.isEmpty()) {
          localQueue.remove(localuly);
        }
      }
      if (localQueue.size() == 2) {
        localQueue.poll();
      }
    }
  }
  
  private static int b(IContactSearchModel paramIContactSearchModel1, IContactSearchModel paramIContactSearchModel2)
  {
    int i2 = 0;
    int i1 = i2;
    if (paramIContactSearchModel2.c() != null)
    {
      i1 = i2;
      if (paramIContactSearchModel1.c() != null) {
        i1 = paramIContactSearchModel1.c().toString().compareTo(paramIContactSearchModel2.c().toString());
      }
    }
    i2 = i1;
    if (i1 == 0)
    {
      i2 = i1;
      if (paramIContactSearchModel2.d() != null)
      {
        i2 = i1;
        if (paramIContactSearchModel1.d() != null) {
          i2 = paramIContactSearchModel1.d().toString().compareTo(paramIContactSearchModel2.d().toString());
        }
      }
    }
    return i2;
  }
  
  private List b(SearchRequest paramSearchRequest)
  {
    Object localObject1 = new ulx(this, false);
    boolean bool;
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_c_of_type_JavaUtilList.add(new WeakReference(localObject1));
        this.jdField_d_of_type_JavaLangString = paramSearchRequest.jdField_a_of_type_JavaLangString;
        if (paramSearchRequest.jdField_a_of_type_AndroidOsBundle != null)
        {
          bool = paramSearchRequest.jdField_a_of_type_AndroidOsBundle.getBoolean("searchRequestFromHome", false);
          ??? = this.jdField_d_of_type_JavaLangString;
          if (!((ulx)localObject1).a()) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ContactSearchEngine", 2, "searchContact canceled, keyword = " + (String)???);
          }
          return null;
        }
      }
      bool = false;
    }
    long l1 = System.currentTimeMillis();
    Object localObject3 = new ArrayList();
    List localList = a((ulx)localObject1);
    int i1;
    HashSet localHashSet;
    long l2;
    long l3;
    long l4;
    Iterator localIterator;
    if (((0x10000 & this.v) != 0) || ((0x20000 & this.v) != 0))
    {
      i1 = 1;
      if ((localList != null) && (i1 != 0) && (bool))
      {
        localHashSet = new HashSet();
        l2 = IContactSearchable.p;
        l3 = IContactSearchable.t;
        l4 = IContactSearchable.R;
        localIterator = localList.iterator();
      }
    }
    else
    {
      for (;;)
      {
        if (localIterator.hasNext())
        {
          IContactSearchModel localIContactSearchModel = (IContactSearchModel)localIterator.next();
          if (((ulx)localObject1).a())
          {
            if (QLog.isColorLevel()) {
              QLog.d("ContactSearchEngine", 2, "searchContact canceled, keyword = " + (String)???);
            }
            return null;
            i1 = 0;
            break;
          }
          if (localIContactSearchModel.b() > l2 + l3 + l4) {
            localHashSet.add(localIContactSearchModel.a());
          }
          if (localHashSet.size() > 5)
          {
            int i2 = 0;
            i1 = i2;
            if (QLog.isColorLevel())
            {
              QLog.d("ContactSearchEngine", 2, "searchContact no need to search troop member, keyword = " + (String)???);
              i1 = i2;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (((ulx)localObject1).a())
      {
        if (QLog.isColorLevel()) {
          QLog.d("ContactSearchEngine", 2, "searchContact canceled, keyword = " + (String)???);
        }
        return null;
      }
      if ((paramSearchRequest.jdField_a_of_type_AndroidOsBundle != null) && (paramSearchRequest.jdField_a_of_type_AndroidOsBundle.containsKey("searchTroopMember"))) {}
      for (bool = paramSearchRequest.jdField_a_of_type_AndroidOsBundle.getBoolean("searchTroopMember");; bool = true)
      {
        if (i1 != 0) {
          if (!bool) {}
        }
        for (paramSearchRequest = b((ulx)localObject1); ((ulx)localObject1).a(); paramSearchRequest = null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ContactSearchEngine", 2, "searchContact canceled, keyword = " + (String)???);
          }
          return null;
          paramSearchRequest.jdField_a_of_type_AndroidOsBundle.putBoolean("searchTroopMember", true);
        }
        if (localList != null) {
          ((List)localObject3).addAll(localList);
        }
        if (paramSearchRequest != null) {
          ((List)localObject3).addAll(paramSearchRequest);
        }
        paramSearchRequest = new ArrayList();
        if (a((List)localObject3, paramSearchRequest, (ulx)localObject1, (String)???)) {
          return null;
        }
        l2 = System.currentTimeMillis();
        if (QLog.isColorLevel())
        {
          QLog.d("ContactSearchEngine", 2, "ContactSearchEngine.search() type = " + this.jdField_e_of_type_JavaLangString + " ; cost time : " + (l2 - l1) + " ; size = " + paramSearchRequest.size() + " ; keyword = " + (String)???);
          if (jdField_a_of_type_Boolean)
          {
            i1 = 0;
            while (i1 < this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo.length)
            {
              QLog.d("ContactSearchEngine", 2, "ContactSearchEngine.search() type = " + this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i1].jdField_a_of_type_JavaLangString + " ; cost time : " + this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i1].jdField_b_of_type_Long + " ; size = " + this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i1].jdField_b_of_type_Int + " ; keyword = " + (String)???);
              i1 += 1;
            }
          }
        }
        this.jdField_a_of_type_Long = (l2 - l1);
        this.jdField_b_of_type_Long = paramSearchRequest.size();
        localObject1 = new HashMap();
        ((HashMap)localObject1).put("result_size", String.valueOf(paramSearchRequest.size()));
        i1 = 0;
        if (i1 < 5)
        {
          if (i1 < paramSearchRequest.size()) {
            ((HashMap)localObject1).put("result_top_" + i1, String.valueOf(((IContactSearchModel)paramSearchRequest.get(i1)).b()));
          }
          for (;;)
          {
            i1 += 1;
            break;
            ((HashMap)localObject1).put("result_top_" + i1, "0");
          }
        }
        this.jdField_b_of_type_Boolean = false;
        ??? = paramSearchRequest.iterator();
        while (((Iterator)???).hasNext())
        {
          localObject3 = (IContactSearchModel)((Iterator)???).next();
          ((IContactSearchModel)localObject3).jdField_a_of_type_JavaUtilHashMap = ((HashMap)localObject1);
          if ("9970".equals(((IContactSearchModel)localObject3).a())) {
            this.jdField_b_of_type_Boolean = true;
          }
        }
        return paramSearchRequest;
      }
    }
  }
  
  private List b(ulx paramulx)
  {
    String str;
    Object localObject1;
    Object localObject3;
    long l1;
    int i3;
    long l2;
    int i4;
    int i2;
    Object localObject4;
    label485:
    Object localObject5;
    if (((0x10000 & this.v) != 0) || ((0x20000 & this.v) != 0))
    {
      str = this.jdField_d_of_type_JavaLangString;
      localObject1 = a(str, true);
      if ((localObject1 != null) && (((List)localObject1).size() < 100))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ContactSearchEngine", 2, "searchTroopMember use cache, keyword = " + str);
        }
        localObject3 = new ArrayList();
        i1 = 0;
        if (i1 >= ((List)localObject1).size()) {
          break label1168;
        }
        if (paramulx.a())
        {
          if (QLog.isColorLevel()) {
            QLog.d("ContactSearchEngine", 2, "searchTroopMember canceled, keyword = " + str);
          }
          return null;
        }
      }
      else
      {
        localObject1 = new ArrayList();
        l1 = System.currentTimeMillis();
        i3 = 0;
        ??? = (FTSTroopOperator)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(2);
        localObject3 = ((FTSTroopOperator)???).a(str);
        if (paramulx.a())
        {
          if (QLog.isColorLevel()) {
            QLog.d("ContactSearchEngine", 2, "searchTroopMember canceled, keyword = " + str);
          }
          return null;
        }
        l2 = System.currentTimeMillis() - l1;
        i4 = a(131072);
        this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i4].jdField_b_of_type_Long = (1000000L * l2);
        this.jdField_f_of_type_Long = l2;
        this.jdField_e_of_type_Long = ((FTSTroopOperator)???).a();
        if (localObject3 != null)
        {
          i2 = ((List)localObject3).size();
          if (QLog.isColorLevel()) {
            QLog.d("ContactSearchEngine", 2, "ContactSearchEngine.TroopGlobalquery cost time : " + l2 + "; size : " + i2 + "; keyWord: " + str);
          }
          i1 = i3;
          if (localObject3 != null)
          {
            i1 = i3;
            if (((List)localObject3).size() > 0)
            {
              ??? = new ArrayList();
              i1 = 0;
            }
          }
        }
        else
        {
          for (;;)
          {
            if (i1 >= ((List)localObject3).size()) {
              break label485;
            }
            if (paramulx.a())
            {
              if (QLog.isColorLevel()) {
                QLog.d("ContactSearchEngine", 2, "searchTroopMember canceled, keyword = " + str);
              }
              return null;
              i2 = 0;
              break;
            }
            localObject4 = (TroopIndex)((List)localObject3).get(i1);
            if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(String.valueOf(((TroopIndex)localObject4).mTroopUin)) != 3) {
              ((List)???).add(localObject4);
            }
            i1 += 1;
          }
          i1 = i3;
          if (((List)???).size() > 0)
          {
            if ((0x20000 & this.v) == 0) {
              break label1196;
            }
            localObject3 = new ArrayList();
            localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
            i1 = 0;
            if (i1 < ((List)???).size())
            {
              if (paramulx.a())
              {
                if (QLog.isColorLevel()) {
                  QLog.d("ContactSearchEngine", 2, "searchTroopMember canceled, keyword = " + str);
                }
                return null;
              }
              localObject5 = (TroopIndex)((List)???).get(i1);
              if ((localObject4 != null) && (((String)localObject4).equals(((TroopIndex)localObject5).mMemberUin))) {}
              for (;;)
              {
                i1 += 1;
                break;
                ((List)localObject3).add(new ContactSearchModelGlobalTroopMember(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.w, ((TroopIndex)localObject5).mTroopUin, ((TroopIndex)localObject5).mMemberUin, ((TroopIndex)localObject5).mMemberCard, ((TroopIndex)localObject5).mMemberName));
              }
            }
            ((List)localObject1).addAll((Collection)localObject3);
          }
        }
      }
    }
    label1168:
    label1196:
    for (int i1 = ((List)localObject3).size() + 0;; i1 = 0)
    {
      if ((0x10000 & this.v) != 0)
      {
        localObject3 = new ArrayList();
        localObject4 = new HashMap();
        i3 = 0;
        if (i3 < ((List)???).size())
        {
          if (paramulx.a())
          {
            if (QLog.isColorLevel()) {
              QLog.d("ContactSearchEngine", 2, "searchTroopMember canceled, keyword = " + str);
            }
            return null;
          }
          localObject5 = (TroopIndex)((List)???).get(i3);
          ContactSearchModelGlobalTroop.TroopSearchMemberInfo localTroopSearchMemberInfo = new ContactSearchModelGlobalTroop.TroopSearchMemberInfo(((TroopIndex)localObject5).mMemberCard, ((TroopIndex)localObject5).mMemberName, ((TroopIndex)localObject5).mMemberUin);
          ArrayList localArrayList;
          if (!((HashMap)localObject4).containsKey(((TroopIndex)localObject5).mTroopUin))
          {
            localArrayList = new ArrayList();
            localArrayList.add(localTroopSearchMemberInfo);
            ((HashMap)localObject4).put(((TroopIndex)localObject5).mTroopUin, localArrayList);
          }
          for (;;)
          {
            i3 += 1;
            break;
            localArrayList = (ArrayList)((HashMap)localObject4).get(((TroopIndex)localObject5).mTroopUin);
            localArrayList.add(localTroopSearchMemberInfo);
            ((HashMap)localObject4).put(((TroopIndex)localObject5).mTroopUin, localArrayList);
          }
        }
        ??? = ((HashMap)localObject4).keySet().iterator();
        while (((Iterator)???).hasNext())
        {
          localObject5 = (String)((Iterator)???).next();
          ((List)localObject3).add(new ContactSearchModelGlobalTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.w, (String)localObject5, (List)((HashMap)localObject4).get(localObject5)));
        }
        ((List)localObject1).addAll((Collection)localObject3);
        i1 += ((List)localObject3).size();
      }
      for (;;)
      {
        l2 = System.currentTimeMillis() - l1 - l2;
        this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i4].jdField_b_of_type_Int = i1;
        this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i4].jdField_a_of_type_Long = l2;
        this.g = (System.currentTimeMillis() - l1);
        this.jdField_d_of_type_Long = i2;
        if (QLog.isColorLevel()) {
          QLog.d("ContactSearchEngine", 2, "ContactSearchEngine.troopGlobalDataProcess cost time : " + l2 + "; size : " + i1 + "; keyWord: " + str);
        }
        break;
        synchronized ((IContactSearchModel)((List)localObject1).get(i1))
        {
          ((IContactSearchModel)???).b(str);
          if (((IContactSearchModel)???).b() != Long.MIN_VALUE) {
            ((List)localObject3).add(???);
          }
          i1 += 1;
        }
        if (((List)localObject3).size() < 100) {
          a(str, (List)localObject3, true);
        }
        return (List)localObject3;
        return null;
      }
    }
  }
  
  private List c(SearchRequest paramSearchRequest)
  {
    ulx localulx = new ulx(this, false);
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_c_of_type_JavaUtilList.add(new WeakReference(localulx));
      this.jdField_d_of_type_JavaLangString = paramSearchRequest.jdField_a_of_type_JavaLangString;
      return b(localulx);
    }
  }
  
  private void f()
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(true, true, false);
    if (localList != null)
    {
      int i2 = localList.size();
      int i1 = 0;
      while ((i1 < i2) && (i1 < 999))
      {
        RecentUser localRecentUser = (RecentUser)localList.get(i1);
        this.jdField_a_of_type_JavaUtilHashMap.put(localRecentUser.uin, Integer.valueOf(999 - i1));
        i1 += 1;
      }
    }
  }
  
  private void g()
  {
    Object localObject4 = null;
    label195:
    label200:
    label203:
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_JavaUtilMap == null)
        {
          Object localObject1 = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
          if (localObject1 == null) {
            break label195;
          }
          localObject4 = ((DiscussionManager)localObject1).a();
          String[] arrayOfString = new String[((List)localObject4).size()];
          localObject4 = ((List)localObject4).iterator();
          int i1 = 0;
          if (((Iterator)localObject4).hasNext())
          {
            DiscussionInfo localDiscussionInfo = (DiscussionInfo)((Iterator)localObject4).next();
            if ((localDiscussionInfo != null) && (localDiscussionInfo.uin != null) && (localDiscussionInfo.uin.length() > 0))
            {
              arrayOfString[i1] = localDiscussionInfo.uin;
              i1 += 1;
              break label200;
            }
          }
          else
          {
            localObject1 = ((DiscussionManager)localObject1).a(arrayOfString);
            localObject4 = new ArrayList(arrayOfString.length);
            int i2 = arrayOfString.length;
            i1 = 0;
            if (i1 >= i2) {
              break label203;
            }
            ((List)localObject4).add((ArrayList)((Map)localObject1).get(arrayOfString[i1]));
            i1 += 1;
            continue;
            this.jdField_a_of_type_JavaUtilMap = ((Map)localObject1);
            this.jdField_b_of_type_JavaUtilList = ((List)localObject4);
          }
        }
        else
        {
          return;
        }
      }
      finally {}
      break label200;
      Object localObject3 = null;
      continue;
    }
  }
  
  protected List a(int paramInt)
  {
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo.length)
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i1].jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i1].jdField_a_of_type_Long = 0L;
      i1 += 1;
    }
    f();
    Object localObject2 = new ArrayList();
    long l1;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    long l2;
    if ((paramInt & 0x20) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject1 = new ArrayList();
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(false);
      if (localObject3 != null)
      {
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (RecentUser)((Iterator)localObject3).next();
          if (!TextUtils.isEmpty(((RecentUser)localObject4).uin)) {
            switch (((RecentUser)localObject4).type)
            {
            case 1001: 
            case 1002: 
            case 1003: 
            default: 
              break;
            case 1000: 
            case 1004: 
            case 1005: 
            case 1006: 
              localObject5 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
              if ((localObject5 != null) && (!((FriendsManager)localObject5).b(((RecentUser)localObject4).uin))) {
                ((List)localObject1).add(new ContactSearchModelRecentUser(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.w, (RecentUser)localObject4, a(((RecentUser)localObject4).uin)));
              }
              break;
            }
          }
        }
      }
      ((List)localObject2).addAll((Collection)localObject1);
      l2 = System.currentTimeMillis();
      i1 = a(32);
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i1].jdField_a_of_type_Long = (l2 - l1);
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i1].jdField_b_of_type_Int = ((List)localObject1).size();
    }
    Object localObject6;
    Object localObject7;
    Object localObject8;
    label428:
    Friends localFriends;
    if ((paramInt & 0x1) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject3 = new ArrayList();
      localObject4 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      if (localObject4 != null)
      {
        localObject5 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        localObject1 = ((FriendsManager)localObject4).b();
        if (localObject1 != null)
        {
          localObject6 = ((List)localObject1).iterator();
          while (((Iterator)localObject6).hasNext())
          {
            localObject7 = (Groups)((Iterator)localObject6).next();
            localObject1 = ((FriendsManager)localObject4).a(String.valueOf(((Groups)localObject7).group_id));
            if (localObject1 != null)
            {
              localObject8 = ((List)localObject1).iterator();
              QQAppInterface localQQAppInterface;
              while (((Iterator)localObject8).hasNext())
              {
                localFriends = (Friends)((Iterator)localObject8).next();
                if (!localFriends.uin.equals(localObject5))
                {
                  localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
                  i1 = this.w;
                  if (localFriends.gathtertype != 1) {
                    break label535;
                  }
                }
              }
              label535:
              for (localObject1 = BaseApplicationImpl.a.getResources().getString(2131371906);; localObject1 = ((Groups)localObject7).group_name)
              {
                ((List)localObject3).add(new ContactSearchModelFriend(localQQAppInterface, i1, localFriends, (String)localObject1, a(localFriends.uin)));
                break label428;
                break;
              }
            }
          }
        }
      }
      ((List)localObject2).addAll((Collection)localObject3);
      l2 = System.currentTimeMillis();
      i1 = a(1);
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i1].jdField_a_of_type_Long = (l2 - l1);
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i1].jdField_b_of_type_Int = ((List)localObject3).size();
    }
    if ((paramInt & 0x100) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject1 = new ArrayList();
      localObject3 = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
      if (localObject3 != null)
      {
        localObject3 = ((PhoneContactManager)localObject3).d();
        if (localObject3 != null)
        {
          localObject3 = (List)((List)localObject3).get(0);
          if (localObject3 != null)
          {
            localObject3 = ((List)localObject3).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = (PhoneContact)((Iterator)localObject3).next();
              ((List)localObject1).add(new ContactSearchModelPhoneContact(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.w, (PhoneContact)localObject4));
            }
          }
        }
      }
      ((List)localObject2).addAll((Collection)localObject1);
      l2 = System.currentTimeMillis();
      i1 = a(768);
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i1].jdField_a_of_type_Long = (l2 - l1);
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i1].jdField_b_of_type_Int = ((List)localObject1).size();
    }
    if ((paramInt & 0x200) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject1 = new ArrayList();
      localObject3 = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
      if (localObject3 != null)
      {
        localObject3 = ((PhoneContactManager)localObject3).d();
        if (localObject3 != null)
        {
          localObject3 = (List)((List)localObject3).get(1);
          if (localObject3 != null)
          {
            localObject3 = ((List)localObject3).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = (PhoneContact)((Iterator)localObject3).next();
              ((List)localObject1).add(new ContactSearchModelPhoneContact(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.w, (PhoneContact)localObject4));
            }
          }
        }
      }
      ((List)localObject2).addAll((Collection)localObject1);
      l2 = System.currentTimeMillis();
      i1 = a(768);
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i1].jdField_a_of_type_Long = (l2 - l1);
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i1].jdField_b_of_type_Int = ((List)localObject1).size();
    }
    if ((paramInt & 0x4000) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject1 = new ArrayList();
      localObject3 = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
      if (localObject3 != null)
      {
        localObject3 = ((PhoneContactManager)localObject3).f();
        if (localObject3 != null)
        {
          localObject3 = ((List)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (PhoneContact)((Iterator)localObject3).next();
            ((List)localObject1).add(new ContactSearchModelPhoneContact(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.w, (PhoneContact)localObject4));
          }
        }
      }
      ((List)localObject2).addAll((Collection)localObject1);
      l2 = System.currentTimeMillis();
      i1 = a(768);
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i1].jdField_a_of_type_Long = (l2 - l1);
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i1].jdField_b_of_type_Int = ((List)localObject1).size();
    }
    if ((0x8000 & paramInt) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject1 = new ArrayList();
      localObject3 = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
      if (localObject3 != null)
      {
        localObject3 = ((PhoneContactManager)localObject3).e();
        if ((localObject3 != null) && (localObject3 != null))
        {
          localObject3 = ((List)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (PhoneContact)((Iterator)localObject3).next();
            ((List)localObject1).add(new ContactSearchModelPhoneContact(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.w, (PhoneContact)localObject4));
          }
        }
      }
      ((List)localObject2).addAll((Collection)localObject1);
      l2 = System.currentTimeMillis();
      i1 = a(768);
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i1].jdField_a_of_type_Long = (l2 - l1);
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i1].jdField_b_of_type_Int = ((List)localObject1).size();
    }
    if ((paramInt & 0x4) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject1 = new ArrayList();
      localObject3 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      if (localObject3 != null)
      {
        localObject4 = a();
        localObject5 = new HashSet();
        localObject6 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        i1 = 0;
        while (i1 < ((List)localObject4).size())
        {
          int i2 = 0;
          if (i2 < ((ArrayList)((List)localObject4).get(i1)).size())
          {
            localObject7 = (DiscussionMemberInfo)((ArrayList)((List)localObject4).get(i1)).get(i2);
            localObject8 = ((DiscussionMemberInfo)localObject7).memberUin + ((DiscussionMemberInfo)localObject7).inteRemark + ((DiscussionMemberInfo)localObject7).memberName;
            if (((Set)localObject5).contains(localObject8)) {}
            for (;;)
            {
              i2 += 1;
              break;
              if (!((String)localObject6).equals(((DiscussionMemberInfo)localObject7).memberUin))
              {
                localFriends = ((FriendsManager)localObject3).a(((DiscussionMemberInfo)localObject7).memberUin);
                if ((localFriends == null) || (!localFriends.isFriend()))
                {
                  ((Set)localObject5).add(localObject8);
                  ((List)localObject1).add(new ContactSearchModelDiscussionMember(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.w, (DiscussionMemberInfo)localObject7));
                }
              }
            }
          }
          i1 += 1;
        }
      }
      ((List)localObject2).addAll((Collection)localObject1);
      l2 = System.currentTimeMillis();
      i1 = a(4);
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i1].jdField_a_of_type_Long = (l2 - l1);
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i1].jdField_b_of_type_Int = ((List)localObject1).size();
    }
    if ((paramInt & 0x8) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject3 = new ArrayList();
      localObject1 = ((DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a();
      if (localObject1 != null)
      {
        localObject4 = ((List)localObject1).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (DiscussionInfo)((Iterator)localObject4).next();
          localObject1 = null;
          localObject6 = a();
          if (localObject6 != null) {
            localObject1 = (List)((Map)localObject6).get(((DiscussionInfo)localObject5).uin);
          }
          ((List)localObject3).add(new ContactSearchModelDiscussion(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.w, (DiscussionInfo)localObject5, (List)localObject1, a(((DiscussionInfo)localObject5).uin)));
        }
      }
      ((List)localObject2).addAll((Collection)localObject3);
      l2 = System.currentTimeMillis();
      i1 = a(8);
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i1].jdField_a_of_type_Long = (l2 - l1);
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i1].jdField_b_of_type_Int = ((List)localObject3).size();
    }
    if ((paramInt & 0x10) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject3 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      localObject1 = new ArrayList();
      localObject3 = ((TroopManager)localObject3).a();
      if (localObject3 != null)
      {
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (TroopInfo)((Iterator)localObject3).next();
          ((List)localObject1).add(new ContactSearchModelTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.w, (TroopInfo)localObject4, a(((TroopInfo)localObject4).troopuin)));
        }
      }
      ((List)localObject2).addAll((Collection)localObject1);
      l2 = System.currentTimeMillis();
      i1 = a(16);
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i1].jdField_a_of_type_Long = (l2 - l1);
      this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i1].jdField_b_of_type_Int = ((List)localObject1).size();
    }
    if ((paramInt & 0x40) != 0)
    {
      localObject1 = new ArrayList();
      ((List)localObject1).add(new ContactSearchModelTool(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.w, String.valueOf(9993L), 6000, a(String.valueOf(9993L))));
      ((List)localObject1).add(new ContactSearchModelTool(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.w, String.valueOf(9973L), 9002, a(String.valueOf(9973L))));
      if (ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
      {
        ((List)localObject1).add(new ContactSearchModelTool(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.w, String.valueOf(AppConstants.ba), 7220, a(String.valueOf(AppConstants.ba))));
        ((List)localObject1).add(new ContactSearchModelTool(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.w, String.valueOf(9970L), 7120, a(String.valueOf(9970L))));
        ((List)localObject1).add(new ContactSearchModelTool(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.w, AppConstants.bb, 7230, a(String.valueOf(AppConstants.bb))));
        localObject3 = (BlessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(137);
        if ((localObject3 == null) || (!((BlessManager)localObject3).b())) {
          break label2591;
        }
        ((List)localObject1).add(new ContactSearchModelTool(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.w, String.valueOf(9960L), 9003, a(String.valueOf(9960L))));
        if (QLog.isColorLevel()) {
          QLog.d("ContactSearchEngine", 2, "Bless model is added.");
        }
      }
      for (;;)
      {
        ((List)localObject1).add(new ContactSearchModelTool(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.w, String.valueOf(AppConstants.an), 4000, a(String.valueOf(AppConstants.an))));
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(true);
        if (localObject3 == null) {
          break label2609;
        }
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (RecentUser)((Iterator)localObject3).next();
          switch (((RecentUser)localObject4).type)
          {
          default: 
            break;
          case 1001: 
          case 5000: 
          case 7000: 
          case 7120: 
          case 7230: 
          case 7440: 
          case 9000: 
            if (!TextUtils.isEmpty(((RecentUser)localObject4).uin)) {
              ((List)localObject1).add(new ContactSearchModelTool(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.w, ((RecentUser)localObject4).uin, ((RecentUser)localObject4).type, a(((RecentUser)localObject4).uin)));
            }
            break;
          }
        }
        ((List)localObject1).add(new ContactSearchModelTool(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.w, String.valueOf(9975L), 7210, a(String.valueOf(9975L))));
        ((List)localObject1).add(new ContactSearchModelTool(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.w, AppConstants.aZ, 1008, a(String.valueOf(AppConstants.aZ))));
        break;
        label2591:
        if (QLog.isColorLevel()) {
          QLog.d("ContactSearchEngine", 2, "Bless model is not added.");
        }
      }
      label2609:
      ((List)localObject2).addAll((Collection)localObject1);
    }
    if ((paramInt & 0x1000) != 0)
    {
      localObject3 = new ArrayList();
      localObject1 = a();
      if (localObject1 == null) {
        break label3252;
      }
    }
    label3252:
    for (Object localObject1 = (List)((Map)localObject1).get(this.jdField_f_of_type_JavaLangString);; localObject1 = null)
    {
      if (localObject1 != null)
      {
        localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        i1 = 0;
        if (i1 < ((List)localObject1).size())
        {
          localObject5 = (DiscussionMemberInfo)((List)localObject1).get(i1);
          if (((String)localObject4).equals(((DiscussionMemberInfo)localObject5).memberUin)) {}
          for (;;)
          {
            i1 += 1;
            break;
            ((List)localObject3).add(new ContactSearchModelDiscussionMember(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.w, (DiscussionMemberInfo)localObject5));
          }
        }
        ((List)localObject2).addAll((Collection)localObject3);
      }
      if (((paramInt & 0x2000) != 0) || ((0x40000 & paramInt) != 0))
      {
        localObject1 = new ArrayList();
        localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        localObject5 = ((EntityManager)localObject4).a(TroopMemberInfo.class, false, "troopuin=? ", new String[] { this.jdField_f_of_type_JavaLangString }, null, null, null, null);
        localObject4 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(this.jdField_f_of_type_JavaLangString);
        if (localObject5 != null)
        {
          localObject5 = ((List)localObject5).iterator();
          while (((Iterator)localObject5).hasNext())
          {
            localObject6 = (TroopMemberInfo)((Iterator)localObject5).next();
            if ((Utils.c(((TroopMemberInfo)localObject6).memberuin)) && (((paramInt & 0x2000) == 0) || (!((String)localObject3).equals(((TroopMemberInfo)localObject6).memberuin))) && (((0x40000 & paramInt) == 0) || (localObject4 == null) || (((TroopInfo)localObject4).isTroopAdmin(((TroopMemberInfo)localObject6).memberuin)) || (((TroopInfo)localObject4).isTroopOwner(((TroopMemberInfo)localObject6).memberuin)))) {
              ((List)localObject1).add(new ContactSearchModelTroopMember(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.w, (TroopMemberInfo)localObject6));
            }
          }
        }
        ((List)localObject2).addAll((Collection)localObject1);
      }
      if ((paramInt & 0x800) != 0)
      {
        l1 = System.currentTimeMillis();
        localObject1 = new ArrayList();
        localObject3 = (CircleManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34);
        if (localObject3 != null)
        {
          localObject3 = ((CircleManager)localObject3).a();
          if (localObject3 != null)
          {
            localObject3 = ((List)localObject3).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = (CircleBuddy)((Iterator)localObject3).next();
              ((List)localObject1).add(new ContactSearchModelCircleBuddy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.w, (CircleBuddy)localObject4));
            }
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("ContactSearchEngine", 2, "getCircleContacts(), mApp.getManager return null");
        }
        ((List)localObject2).addAll((Collection)localObject1);
        l2 = System.currentTimeMillis();
        paramInt = a(2048);
        this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[paramInt].jdField_a_of_type_Long = (l2 - l1);
        this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[paramInt].jdField_b_of_type_Int = ((List)localObject1).size();
      }
      if ((this.jdField_a_of_type_JavaUtilSet != null) && (!this.jdField_a_of_type_JavaUtilSet.isEmpty()))
      {
        localObject1 = new ArrayList();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (IContactSearchModel)((Iterator)localObject2).next();
          if (!this.jdField_a_of_type_JavaUtilSet.contains(((IContactSearchModel)localObject3).a())) {
            ((List)localObject1).add(localObject3);
          }
        }
        return (List)localObject1;
      }
      return (List)localObject2;
    }
  }
  
  public List a(SearchRequest paramSearchRequest)
  {
    boolean bool1 = false;
    boolean bool2;
    if (paramSearchRequest.jdField_a_of_type_AndroidOsBundle != null)
    {
      bool2 = paramSearchRequest.jdField_a_of_type_AndroidOsBundle.getBoolean("searchCreateDiscussion", false);
      bool1 = paramSearchRequest.jdField_a_of_type_AndroidOsBundle.getBoolean("searchTroopMember", false);
    }
    for (;;)
    {
      if (bool2)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineCreateDiscussionSearchEngine != null) {
          return this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineCreateDiscussionSearchEngine.a(paramSearchRequest);
        }
      }
      else
      {
        if (bool1) {
          return c(paramSearchRequest);
        }
        return b(paramSearchRequest);
      }
      return new ArrayList();
      bool2 = false;
    }
  }
  
  public void a()
  {
    long l1 = System.currentTimeMillis();
    this.jdField_a_of_type_JavaUtilList = a(this.v);
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineCreateDiscussionSearchEngine = new CreateDiscussionSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.w);
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineCreateDiscussionSearchEngine.a();
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      QLog.d("ContactSearchEngine", 2, "ContactSearchEngine.init() type = " + this.jdField_e_of_type_JavaLangString + " ; cost time : " + (l2 - l1) + " ; size = " + this.jdField_a_of_type_JavaUtilList.size());
      if (jdField_a_of_type_Boolean)
      {
        i1 = 0;
        while (i1 < this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo.length)
        {
          QLog.d("ContactSearchEngine", 2, "ContactSearchEngine.init() type = " + this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i1].jdField_a_of_type_JavaLangString + " ; cost time : " + this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i1].jdField_a_of_type_Long + " ; size = " + this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i1].jdField_b_of_type_Int);
          i1 += 1;
        }
      }
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("type", this.jdField_e_of_type_JavaLangString);
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo.length)
    {
      localHashMap.put("time_" + this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i1].jdField_a_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i1].jdField_a_of_type_Long));
      localHashMap.put("size_" + this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i1].jdField_a_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i1].jdField_b_of_type_Int));
      i1 += 1;
    }
    StatisticCollector.a(BaseApplicationImpl.a()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "ContactSearchEngineInit", true, l2 - l1, this.jdField_a_of_type_JavaUtilList.size(), localHashMap, "", false);
  }
  
  public void a(SearchRequest paramSearchRequest, ISearchListener paramISearchListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener = paramISearchListener;
    ThreadManager.a(new ulw(this, paramSearchRequest), null, true);
  }
  
  public boolean a(List paramList1, List paramList2, ulx arg3, String paramString)
  {
    ulx localulx = ???;
    if (??? == null) {
      localulx = new ulx(this, false);
    }
    IContactSearchModel localIContactSearchModel1;
    for (;;)
    {
      IContactSearchModel localIContactSearchModel2;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_c_of_type_JavaUtilList.add(new WeakReference(localulx));
        ??? = new HashMap();
        paramList1 = paramList1.iterator();
        if (!paramList1.hasNext()) {
          break;
        }
        localIContactSearchModel1 = (IContactSearchModel)paramList1.next();
        localIContactSearchModel2 = (IContactSearchModel)???.get(localIContactSearchModel1.a());
        if (localulx.a())
        {
          if (QLog.isColorLevel()) {
            QLog.d("ContactSearchEngine", 2, "searchContact canceled, keyword = " + paramString);
          }
          return true;
        }
      }
      if ((localIContactSearchModel2 == null) || (localIContactSearchModel2.b() < localIContactSearchModel1.b())) {
        ???.put(localIContactSearchModel1.a(), localIContactSearchModel1);
      }
    }
    paramList1 = new ArrayList();
    ??? = ???.values().iterator();
    while (???.hasNext())
    {
      localIContactSearchModel1 = (IContactSearchModel)???.next();
      if (localulx.a())
      {
        if (QLog.isColorLevel()) {
          QLog.d("ContactSearchEngine", 2, "searchContact canceled, keyword = " + paramString);
        }
        return true;
      }
      localIContactSearchModel1 = (IContactSearchModel)localIContactSearchModel1.clone();
      if (localIContactSearchModel1 != null) {
        paramList1.add(localIContactSearchModel1);
      }
    }
    Collections.sort(paramList1, jdField_a_of_type_JavaUtilComparator);
    int i1 = Math.min(paramList1.size(), 30);
    ??? = paramList1.subList(0, i1);
    Collections.sort(???, jdField_b_of_type_JavaUtilComparator);
    paramList2.addAll(???);
    paramList2.addAll(paramList1.subList(i1, paramList1.size()));
    return false;
  }
  
  public void b()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        ulx localulx = (ulx)localWeakReference.get();
        if (localulx != null)
        {
          localulx.a(true);
          localArrayList.add(localWeakReference);
        }
      }
    }
    this.jdField_c_of_type_JavaUtilList = localList;
    if (this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineCreateDiscussionSearchEngine != null) {
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineCreateDiscussionSearchEngine.b();
    }
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener = null;
  }
  
  public void c() {}
  
  public void d() {}
  
  public void e()
  {
    if (this.jdField_a_of_type_Long != -1L)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("type", this.jdField_e_of_type_JavaLangString);
      if (this.jdField_d_of_type_JavaLangString == null) {}
      for (String str = "";; str = this.jdField_d_of_type_JavaLangString)
      {
        localHashMap.put("keyword", str);
        localHashMap.put("totalSize", String.valueOf(this.jdField_c_of_type_Long));
        int i1 = 0;
        while (i1 < this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo.length)
        {
          localHashMap.put("time_" + this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i1].jdField_a_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i1].jdField_b_of_type_Long));
          localHashMap.put("size_" + this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i1].jdField_a_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchSearchengineContactSearchEngine$TypedReportInfo[i1].jdField_b_of_type_Int));
          i1 += 1;
        }
      }
      localHashMap.put("time_global_troop_member", String.valueOf(this.jdField_f_of_type_Long));
      localHashMap.put("size_global_troop_member", String.valueOf(this.jdField_d_of_type_Long));
      localHashMap.put("time_global_troop_member_total", String.valueOf(this.g));
      localHashMap.put("size_global_troop_member_total", String.valueOf(this.jdField_e_of_type_Long));
      StatisticCollector.a(BaseApplicationImpl.a()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "ContactSearchEngineSearch", true, this.jdField_a_of_type_Long, this.jdField_b_of_type_Long, localHashMap, "", false);
      if (this.jdField_b_of_type_Boolean)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Shop_lifeservice", "", "Shop_folder", "Pv_Searchshopfolder", 0, 0, "", "", "", "");
        this.jdField_b_of_type_Boolean = false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ContactSearchEngineSearch", 2, "troopMemberSearchTime = " + this.g + " ; troopMemberQueryTime = " + this.jdField_f_of_type_Long + " ; troopMemberTotalSize = " + this.jdField_e_of_type_Long + " ; troopMemberResultSize = " + this.jdField_d_of_type_Long);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\searchengine\ContactSearchEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */