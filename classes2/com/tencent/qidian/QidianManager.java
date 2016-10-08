package com.tencent.qidian;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.bmqq.app.BmqqBusinessHandler;
import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.data.BmqqUserSimpleInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qidian.controller.QidianHandler;
import com.tencent.qidian.data.BmqqAccountType;
import com.tencent.qidian.data.QidianCorpInfo;
import com.tencent.qidian.data.QidianExternalInfo;
import com.tencent.qidian.data.QidianInternalInfo;
import com.tencent.qidian.data.QidianPAForWpa;
import com.tencent.qidian.data.QidianProfileUiInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import wya;
import wyb;
import wyc;
import wyd;
import wye;
import wyf;
import wyg;

public class QidianManager
  implements Manager
{
  public static final int a = 1;
  public static final String a;
  public static final AtomicBoolean a;
  public AppInterface a;
  public Map a;
  public Map b;
  public Map c;
  public Map d;
  public Map e;
  public Map f;
  public Map g;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    jdField_a_of_type_JavaLangString = QidianManager.class.getSimpleName();
  }
  
  public QidianManager(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.b = new HashMap();
    this.c = new HashMap();
    this.f = new HashMap();
    this.d = new HashMap();
    this.e = new HashMap();
    this.g = new HashMap();
    ThreadManager.b().post(new wya(this));
  }
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 4, "initial ...");
    }
    localEntityManager = this.jdField_a_of_type_ComTencentCommonAppAppInterface.a().createEntityManager();
    try
    {
      a(localEntityManager);
      b(localEntityManager);
      c(localEntityManager);
      e(localEntityManager);
      f(localEntityManager);
      d(localEntityManager);
      g(localEntityManager);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "QidianManager get data from db error: " + localException.getMessage());
        }
        localEntityManager.a();
      }
    }
    finally
    {
      localEntityManager.a();
    }
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  private void a(EntityManager paramEntityManager)
  {
    paramEntityManager = paramEntityManager.a(BmqqAccountType.class);
    if (paramEntityManager != null)
    {
      paramEntityManager = paramEntityManager.iterator();
      while (paramEntityManager.hasNext())
      {
        BmqqAccountType localBmqqAccountType = (BmqqAccountType)paramEntityManager.next();
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 4, "loadAccountType query from db: " + localBmqqAccountType);
        }
        String str = localBmqqAccountType.getUin();
        int i = localBmqqAccountType.getAccountType();
        this.jdField_a_of_type_JavaUtilMap.put(str, Integer.valueOf(i));
      }
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("isNeedReply=")) && (paramString.contains("QidianKfUin=")))
    {
      bool1 = false;
      bool2 = false;
      str = "";
      localMatcher = Pattern.compile("((?:isNeedReply|isNeedLbs|QidianKfUin))=([^\\?&=]+)").matcher(paramString);
      while (localMatcher.find()) {
        if ("isNeedReply".equals(localMatcher.group(1))) {
          bool2 = "true".equals(localMatcher.group(2));
        } else if ("isNeedLbs".equals(localMatcher.group(1))) {
          bool1 = "true".equals(localMatcher.group(2));
        } else if ("QidianKfUin".equals(localMatcher.group(1))) {
          str = localMatcher.group(2);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "isNeedLbs: " + bool1 + " | isNeedReply: " + bool2 + " | masterUin: " + str);
      }
      if (bool2)
      {
        if (!bool1) {
          break label223;
        }
        SosoInterface.a(new wyf(this, 1, true, true, 0L, true, false, jdField_a_of_type_JavaLangString, paramString, paramInt, str));
      }
    }
    label223:
    while (!QLog.isColorLevel())
    {
      boolean bool1;
      boolean bool2;
      String str;
      Matcher localMatcher;
      return;
      a(paramString, paramInt, bool1, 0.0D, 0.0D, str);
      return;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 2, "key is null or don't contain isNeedReply : " + paramString);
  }
  
  private boolean a(String paramString, int paramInt)
  {
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(50);
    if (localFriendsManager != null)
    {
      paramString = localFriendsManager.c(paramString);
      if ((paramString != null) && (paramString.cSpecialFlag == paramInt)) {
        return true;
      }
    }
    return false;
  }
  
  private boolean a(String paramString, QQAppInterface paramQQAppInterface)
  {
    if (TextUtils.isEmpty(paramQQAppInterface.getAccount())) {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "app.getAccount() is null");
      }
    }
    do
    {
      do
      {
        return false;
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "initParm uin = " + paramString);
        }
        if (!TextUtils.isEmpty(paramString)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i(jdField_a_of_type_JavaLangString, 2, "mAllinone is null");
      return false;
      if (BmqqSegmentUtil.c(paramString)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i(jdField_a_of_type_JavaLangString, 2, "Not bmqq uin: " + paramString);
    return false;
    return true;
  }
  
  private void b(EntityManager paramEntityManager)
  {
    paramEntityManager = paramEntityManager.a(QidianExternalInfo.class);
    if (paramEntityManager != null)
    {
      paramEntityManager = paramEntityManager.iterator();
      while (paramEntityManager.hasNext())
      {
        QidianExternalInfo localQidianExternalInfo = (QidianExternalInfo)paramEntityManager.next();
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 4, "loadExternalInfo query from db: " + localQidianExternalInfo);
        }
        String str = localQidianExternalInfo.uin;
        this.b.put(str, localQidianExternalInfo);
      }
    }
  }
  
  private void c(EntityManager paramEntityManager)
  {
    paramEntityManager = paramEntityManager.a(QidianInternalInfo.class);
    if (paramEntityManager != null)
    {
      paramEntityManager = paramEntityManager.iterator();
      while (paramEntityManager.hasNext())
      {
        QidianInternalInfo localQidianInternalInfo = (QidianInternalInfo)paramEntityManager.next();
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 4, "loadInternalInfo query from db: " + localQidianInternalInfo);
        }
        String str = localQidianInternalInfo.uin;
        this.c.put(str, localQidianInternalInfo);
      }
    }
  }
  
  private String d(String paramString)
  {
    String str = "";
    if (a(paramString))
    {
      QidianExternalInfo localQidianExternalInfo = (QidianExternalInfo)this.b.get(paramString);
      if ((localQidianExternalInfo != null) && (!TextUtils.isEmpty(localQidianExternalInfo.masterUin)))
      {
        paramString = (QidianCorpInfo)this.d.get(localQidianExternalInfo.masterUin);
        if (paramString == null) {
          break label124;
        }
      }
    }
    label124:
    for (paramString = paramString.corpName;; paramString = "")
    {
      str = paramString;
      do
      {
        do
        {
          return str;
        } while (!QLog.isColorLevel());
        QLog.d(jdField_a_of_type_JavaLangString, 4, "QidianExternalInfo is null or masterUin is empty for uin: " + paramString);
        return "";
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 4, "uin is no qidian account");
      return "";
    }
  }
  
  private void d(EntityManager paramEntityManager)
  {
    paramEntityManager = paramEntityManager.a(BmqqUserSimpleInfo.class);
    if (paramEntityManager != null)
    {
      paramEntityManager = paramEntityManager.iterator();
      while (paramEntityManager.hasNext())
      {
        BmqqUserSimpleInfo localBmqqUserSimpleInfo = (BmqqUserSimpleInfo)paramEntityManager.next();
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 4, "loadBmqqExtInfo query from db: " + localBmqqUserSimpleInfo);
        }
        String str = localBmqqUserSimpleInfo.mBmqqUin;
        this.f.put(str, localBmqqUserSimpleInfo);
      }
    }
  }
  
  private void e(EntityManager paramEntityManager)
  {
    paramEntityManager = paramEntityManager.a(QidianCorpInfo.class);
    if (paramEntityManager != null)
    {
      paramEntityManager = paramEntityManager.iterator();
      while (paramEntityManager.hasNext())
      {
        QidianCorpInfo localQidianCorpInfo = (QidianCorpInfo)paramEntityManager.next();
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 4, "loadCorpInfo query from db: " + localQidianCorpInfo);
        }
        String str = localQidianCorpInfo.corpUin;
        this.d.put(str, localQidianCorpInfo);
      }
    }
  }
  
  private void f(EntityManager paramEntityManager)
  {
    paramEntityManager = paramEntityManager.a(QidianProfileUiInfo.class);
    if (paramEntityManager != null)
    {
      paramEntityManager = paramEntityManager.iterator();
      while (paramEntityManager.hasNext())
      {
        QidianProfileUiInfo localQidianProfileUiInfo = (QidianProfileUiInfo)paramEntityManager.next();
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 4, "loadQidianProfileUiInfo query from db: " + localQidianProfileUiInfo);
        }
        this.e.put(localQidianProfileUiInfo.uin, localQidianProfileUiInfo);
      }
    }
  }
  
  private void g(EntityManager paramEntityManager)
  {
    paramEntityManager = paramEntityManager.a(QidianPAForWpa.class);
    if (paramEntityManager != null)
    {
      paramEntityManager = paramEntityManager.iterator();
      while (paramEntityManager.hasNext())
      {
        QidianPAForWpa localQidianPAForWpa = (QidianPAForWpa)paramEntityManager.next();
        this.g.put(localQidianPAForWpa.puin, localQidianPAForWpa);
      }
    }
  }
  
  public int a(String paramString, QQAppInterface paramQQAppInterface)
  {
    int i = 1;
    if (!a(paramString, paramQQAppInterface)) {
      i = 5;
    }
    do
    {
      return i;
      if (CrmUtils.c(paramQQAppInterface, paramString)) {
        return 3;
      }
    } while (a(paramString));
    if (a(paramString, true)) {
      return 0;
    }
    return 4;
  }
  
  public QidianCorpInfo a(String paramString)
  {
    QidianCorpInfo localQidianCorpInfo = null;
    if (this.d.containsKey(paramString)) {
      localQidianCorpInfo = (QidianCorpInfo)this.d.get(paramString);
    }
    return localQidianCorpInfo;
  }
  
  public QidianExternalInfo a(String paramString)
  {
    QidianExternalInfo localQidianExternalInfo = null;
    if (this.b.containsKey(paramString)) {
      localQidianExternalInfo = (QidianExternalInfo)this.b.get(paramString);
    }
    return localQidianExternalInfo;
  }
  
  public QidianInternalInfo a(String paramString)
  {
    QidianInternalInfo localQidianInternalInfo = null;
    if (this.c.containsKey(paramString)) {
      localQidianInternalInfo = (QidianInternalInfo)this.c.get(paramString);
    }
    return localQidianInternalInfo;
  }
  
  public QidianProfileUiInfo a(String paramString)
  {
    QidianProfileUiInfo localQidianProfileUiInfo = null;
    if (this.e.containsKey(paramString)) {
      localQidianProfileUiInfo = (QidianProfileUiInfo)this.e.get(paramString);
    }
    return localQidianProfileUiInfo;
  }
  
  public String a(Context paramContext, String paramString)
  {
    paramString = d(paramString);
    if (!TextUtils.isEmpty(paramString)) {
      return String.format(paramContext.getString(2131370092), new Object[] { paramString });
    }
    return paramContext.getString(2131370091);
  }
  
  public String a(String paramString)
  {
    if (this.c.containsKey(paramString))
    {
      paramString = (QidianInternalInfo)this.c.get(paramString);
      if (paramString != null) {
        return paramString.mobile;
      }
    }
    return "";
  }
  
  public void a(BmqqUserSimpleInfo paramBmqqUserSimpleInfo)
  {
    if (paramBmqqUserSimpleInfo != null) {
      this.f.put(paramBmqqUserSimpleInfo.mBmqqUin, paramBmqqUserSimpleInfo);
    }
    ThreadManager.a(new wyc(this, paramBmqqUserSimpleInfo), 5, null, true);
  }
  
  public void a(BmqqAccountType paramBmqqAccountType)
  {
    if (paramBmqqAccountType != null)
    {
      this.jdField_a_of_type_JavaUtilMap.put(paramBmqqAccountType.getUin(), Integer.valueOf(paramBmqqAccountType.getAccountType()));
      ThreadManager.a(new wyb(this, paramBmqqAccountType), 5, null, true);
    }
  }
  
  public void a(QidianExternalInfo paramQidianExternalInfo, QidianInternalInfo paramQidianInternalInfo, QidianCorpInfo paramQidianCorpInfo, QidianProfileUiInfo paramQidianProfileUiInfo)
  {
    if (paramQidianExternalInfo != null) {
      this.b.put(paramQidianExternalInfo.uin, paramQidianExternalInfo);
    }
    if (paramQidianCorpInfo != null) {
      this.d.put(paramQidianCorpInfo.corpUin, paramQidianCorpInfo);
    }
    if (paramQidianProfileUiInfo != null) {
      this.e.put(paramQidianProfileUiInfo.uin, paramQidianProfileUiInfo);
    }
    if (paramQidianInternalInfo != null) {
      this.c.put(paramQidianInternalInfo.uin, paramQidianInternalInfo);
    }
    ThreadManager.a(new wyd(this, paramQidianExternalInfo, paramQidianInternalInfo, paramQidianCorpInfo, paramQidianProfileUiInfo), 5, null, true);
  }
  
  public void a(String paramString1, int paramInt, boolean paramBoolean, double paramDouble1, double paramDouble2, String paramString2)
  {
    ((QidianHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.a(85)).a(paramString1, paramInt, paramBoolean, 0.0D, 0.0D, paramString2);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.g.containsKey(paramString1)) {}
    for (QidianPAForWpa localQidianPAForWpa = (QidianPAForWpa)this.g.get(paramString1);; localQidianPAForWpa = new QidianPAForWpa())
    {
      localQidianPAForWpa.puin = paramString1;
      localQidianPAForWpa.kfuin = paramString2;
      this.g.put(paramString1, localQidianPAForWpa);
      ThreadManager.a(new wyg(this, localQidianPAForWpa), 5, null, true);
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (TextUtils.isEmpty(paramString2)) {
      if (!TextUtils.isEmpty(paramString3)) {
        break label27;
      }
    }
    for (;;)
    {
      a(paramString4, 1);
      return;
      paramString3 = paramString2;
      break;
      label27:
      paramString4 = paramString3;
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    ((CardHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.a(2)).a(paramString, paramBoolean);
  }
  
  public boolean a(Context paramContext, BmqqAccountType paramBmqqAccountType)
  {
    if (paramBmqqAccountType == null) {}
    for (;;)
    {
      return false;
      paramContext = paramBmqqAccountType.getUin();
      try
      {
        long l = Long.parseLong(paramContext);
        if (BmqqSegmentUtil.a(paramContext))
        {
          switch (paramBmqqAccountType.getAccountType())
          {
          default: 
            return false;
          }
          ((QidianHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.a(85)).b(l);
          return true;
        }
      }
      catch (Exception paramContext) {}
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    return b(paramString, true);
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    boolean bool = true;
    try
    {
      Long.parseLong(paramString);
      if (!BmqqSegmentUtil.a(paramString)) {}
      while ((BmqqSegmentUtil.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (!BmqqSegmentUtil.a(null, paramString))) {
        return false;
      }
      if (this.f.containsKey(paramString)) {}
      for (;;)
      {
        return bool;
        if (!a(paramString, 1))
        {
          if (!paramBoolean) {
            a(paramString, false);
          }
          bool = false;
        }
      }
      return false;
    }
    catch (Exception paramString) {}
  }
  
  public String b(String paramString)
  {
    if (this.b.containsKey(paramString))
    {
      paramString = (QidianExternalInfo)this.b.get(paramString);
      if (paramString != null) {
        return paramString.masterUin;
      }
    }
    return "";
  }
  
  public boolean b(Context paramContext, BmqqAccountType paramBmqqAccountType)
  {
    if (paramBmqqAccountType == null) {}
    for (;;)
    {
      return false;
      paramContext = paramBmqqAccountType.getUin();
      try
      {
        long l = Long.parseLong(paramContext);
        if (BmqqSegmentUtil.a(paramContext))
        {
          switch (paramBmqqAccountType.getAccountType())
          {
          default: 
            return false;
          case 0: 
          case 2: 
            ((BmqqBusinessHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.a(37)).a(paramContext);
            return true;
          }
          ((QidianHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.a(85)).a(l);
          return true;
        }
      }
      catch (Exception paramContext) {}
    }
    return false;
  }
  
  public boolean b(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.b.containsKey(paramString))
    {
      paramString = (QidianExternalInfo)this.b.get(paramString);
      bool1 = bool2;
      if (paramString != null) {
        if (paramString.isShowCall != 1) {
          break label49;
        }
      }
    }
    label49:
    for (bool1 = true;; bool1 = false) {
      return bool1;
    }
  }
  
  public boolean b(String paramString, boolean paramBoolean)
  {
    boolean bool;
    try
    {
      Long.parseLong(paramString);
      if (!BmqqSegmentUtil.a(paramString))
      {
        bool = false;
        return bool;
      }
    }
    catch (Exception paramString)
    {
      return false;
    }
    if ((BmqqSegmentUtil.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (!BmqqSegmentUtil.a(null, paramString))) {
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))
    {
      if (((Integer)this.jdField_a_of_type_JavaUtilMap.get(paramString)).intValue() != 1) {
        break label135;
      }
      paramBoolean = true;
    }
    for (;;)
    {
      bool = paramBoolean;
      if (!paramBoolean) {
        break;
      }
      bool = paramBoolean;
      if (this.b.get(paramString) != null) {
        break;
      }
      ThreadManager.a(new wye(this, paramString), 5, null, true);
      return paramBoolean;
      if (a(paramString, 4))
      {
        paramBoolean = true;
      }
      else
      {
        if (!paramBoolean) {
          a(paramString, false);
        }
        label135:
        paramBoolean = false;
      }
    }
  }
  
  public String c(String paramString)
  {
    paramString = (QidianPAForWpa)this.g.get(paramString);
    if (paramString != null) {
      return paramString.kfuin;
    }
    return null;
  }
  
  public boolean c(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(b(paramString)))
    {
      bool1 = bool2;
      if (b(paramString)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean d(String paramString)
  {
    return this.g.containsKey(paramString);
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 4, "onDestroyd ...");
    }
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\qidian\QidianManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */