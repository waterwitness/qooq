package com.tencent.biz.qqstory.model;

import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.Copyable;
import com.tencent.biz.qqstory.base.OneObjectCacheList;
import com.tencent.biz.qqstory.database.UserEntry;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserManager
  implements IManager
{
  public static final String a = "Q.qqstory.UserManager";
  public static final String b = "0_1000";
  protected OneObjectCacheList a;
  
  public UserManager()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new OneObjectCacheList(300);
  }
  
  private QQStoryContext a()
  {
    return QQStoryContext.a();
  }
  
  public static List a(EntityManager paramEntityManager, Class paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramEntityManager.a(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  public long a(String paramString)
  {
    QQUserUIItem localQQUserUIItem = a(paramString);
    if (localQQUserUIItem != null) {
      return localQQUserUIItem.uid;
    }
    try
    {
      long l = Long.valueOf(paramString).longValue();
      return l;
    }
    catch (NumberFormatException paramString) {}
    return 0L;
  }
  
  public QQUserUIItem a(long paramLong)
  {
    Object localObject = a(a().a().createEntityManager(), UserEntry.class, UserEntry.class.getSimpleName(), UserEntry.getUserSelection(paramLong), null);
    if (localObject == null)
    {
      SLog.d("Q.qqstory.UserManager", "getUserUIItemFromDB null ! uid = " + paramLong);
      return null;
    }
    if (((List)localObject).size() == 0)
    {
      SLog.d("Q.qqstory.UserManager", "getUserUIItemFromDB null ! uid = " + paramLong);
      return null;
    }
    localObject = (UserEntry)((List)localObject).get(0);
    QQUserUIItem localQQUserUIItem = new QQUserUIItem((UserEntry)localObject);
    return (QQUserUIItem)this.a.a(Long.valueOf(((UserEntry)localObject).uid), localQQUserUIItem);
  }
  
  public QQUserUIItem a(QQUserUIItem paramQQUserUIItem)
  {
    long l = paramQQUserUIItem.uid;
    c(l);
    paramQQUserUIItem = (QQUserUIItem)this.a.a(Long.valueOf(l), paramQQUserUIItem);
    a().a().createEntityManager().b(paramQQUserUIItem.convert2UserEntry());
    return paramQQUserUIItem;
  }
  
  public QQUserUIItem a(String paramString)
  {
    Object localObject = a(a().a().createEntityManager(), UserEntry.class, UserEntry.class.getSimpleName(), UserEntry.getUserSelectionByUnionId(), new String[] { paramString });
    if (localObject == null)
    {
      SLog.d("Q.qqstory.UserManager", "getUserUIItemFromDB null ! unionId = " + paramString);
      return null;
    }
    if (((List)localObject).size() == 0)
    {
      SLog.d("Q.qqstory.UserManager", "getUserUIItemFromDB null ! unionId = " + paramString);
      return null;
    }
    paramString = (UserEntry)((List)localObject).get(0);
    localObject = new QQUserUIItem(paramString);
    return (QQUserUIItem)this.a.a(Long.valueOf(paramString.uid), (Copyable)localObject);
  }
  
  public String a(long paramLong)
  {
    QQUserUIItem localQQUserUIItem = c(paramLong);
    if (localQQUserUIItem != null) {
      return localQQUserUIItem.getUnionId();
    }
    return "";
  }
  
  public Set a()
  {
    Set localSet = QvipSpecialCareManager.a(a().a());
    Object localObject = localSet;
    if (localSet == null) {
      localObject = new HashSet(1);
    }
    return (Set)localObject;
  }
  
  public void a() {}
  
  public QQUserUIItem b(long paramLong)
  {
    return (QQUserUIItem)this.a.a(Long.valueOf(paramLong));
  }
  
  public void b() {}
  
  public QQUserUIItem c(long paramLong)
  {
    Object localObject = b(paramLong);
    if (localObject != null) {}
    QQUserUIItem localQQUserUIItem;
    do
    {
      return (QQUserUIItem)localObject;
      localQQUserUIItem = a(paramLong);
      localObject = localQQUserUIItem;
    } while (localQQUserUIItem != null);
    SLog.e("Q.qqstory.UserManager", "what is wrong ? ");
    return localQQUserUIItem;
  }
  
  public void c()
  {
    this.a.a(20);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\model\UserManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */