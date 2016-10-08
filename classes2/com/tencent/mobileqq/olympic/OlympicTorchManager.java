package com.tencent.mobileqq.olympic;

import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class OlympicTorchManager
  implements Handler.Callback
{
  public static final int a = 300000;
  public static final String a;
  public static final int b = 3600000;
  public static final String b = "filename_olympic_torch_list_v1.0";
  public static final int c = 3600000;
  public static final int d = 0;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private Set jdField_a_of_type_JavaUtilSet;
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(ThreadManager.a(), this);
  WeakReference jdField_a_of_type_MqqUtilWeakReference;
  private ConcurrentHashMap b = new ConcurrentHashMap();
  private ConcurrentHashMap c = new ConcurrentHashMap();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = OlympicTorchManager.class.getSimpleName();
  }
  
  public OlympicTorchManager(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  private boolean a()
  {
    return this.jdField_a_of_type_JavaUtilSet != null;
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1000) || (paramInt == 1004) || (paramInt == 1003) || (paramInt == 1021) || (paramInt == 1022) || (paramInt == 1023);
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    return ((paramMessageRecord.extLong & 0x1) == 1) && (!TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("olympic_torch_flg")));
  }
  
  private void c()
  {
    Object localObject = FileUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount() + "filename_olympic_torch_list_v1.0");
    if ((localObject != null) && ((localObject instanceof String[]))) {}
    for (localObject = (String[])localObject;; localObject = null)
    {
      this.jdField_a_of_type_JavaUtilSet = Collections.synchronizedSet(new HashSet());
      if (localObject != null) {
        this.jdField_a_of_type_JavaUtilSet.addAll(Arrays.asList((Object[])localObject));
      }
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "init, size:" + this.jdField_a_of_type_JavaUtilSet.size());
      }
      return;
    }
  }
  
  private void d()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (!a()) {
        c();
      }
      return;
    }
  }
  
  private void e()
  {
    String str;
    if (this.jdField_a_of_type_JavaUtilSet != null)
    {
      str = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount();
      if (TextUtils.isEmpty(str)) {}
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      String[] arrayOfString = new String[this.jdField_a_of_type_JavaUtilSet.size()];
      this.jdField_a_of_type_JavaUtilSet.toArray(arrayOfString);
      FileUtils.a(str + "filename_olympic_torch_list_v1.0", arrayOfString);
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "saveData:" + this.jdField_a_of_type_JavaUtilSet.size());
      }
      return;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    e();
  }
  
  public void a(int paramInt)
  {
    int i = 100;
    Object localObject = (List)this.c.get(Integer.valueOf(paramInt));
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "getOlympicTorchsInternal groupId:" + paramInt + " size:" + ((List)localObject).size());
    }
    ArrayList localArrayList;
    if (((List)localObject).size() > 100)
    {
      localArrayList = new ArrayList(((List)localObject).subList(0, i));
      if (i >= ((List)localObject).size()) {
        break label199;
      }
      localObject = new ArrayList(((List)localObject).subList(i, ((List)localObject).size()));
      if (((List)localObject).size() <= 0) {
        break label177;
      }
      this.c.put(Integer.valueOf(paramInt), localObject);
    }
    for (;;)
    {
      ((OlympicHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.a(94)).a(localArrayList, paramInt);
      return;
      i = ((List)localObject).size();
      break;
      label177:
      this.c.put(Integer.valueOf(paramInt), new ArrayList());
      continue;
      label199:
      this.c.put(Integer.valueOf(paramInt), new ArrayList());
    }
  }
  
  public void a(int paramInt, String paramString, OlympicTorchManager.TorchUpdateListener paramTorchUpdateListener, boolean paramBoolean)
  {
    int i = 30;
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramTorchUpdateListener);
      if (a(paramString, paramBoolean)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i(jdField_a_of_type_JavaLangString, 2, "onResumeAIOWithoutTorch,not timeout,return " + paramString);
    return;
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "onResumeAIOWithoutTorch,start check recent users, has:" + paramBoolean);
    }
    paramTorchUpdateListener = ((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).a().a().a(true);
    ArrayList localArrayList;
    int j;
    label145:
    Object localObject;
    int k;
    if (paramTorchUpdateListener.size() > 30)
    {
      localArrayList = new ArrayList(10);
      j = 0;
      paramInt = 0;
      if (j >= i) {
        break label380;
      }
      localObject = (RecentUser)paramTorchUpdateListener.get(j);
      k = paramInt;
      if (a(((RecentUser)localObject).type))
      {
        if (!TextUtils.isEmpty(((RecentUser)localObject).uin)) {
          break label216;
        }
        k = paramInt;
      }
    }
    label216:
    do
    {
      do
      {
        j += 1;
        paramInt = k;
        break label145;
        i = paramTorchUpdateListener.size();
        break;
        localObject = ((RecentUser)localObject).uin.trim();
        k = paramInt;
      } while (TextUtils.isEmpty((CharSequence)localObject));
      k = paramInt;
    } while (a((String)localObject));
    if (((String)localObject).equals(paramString))
    {
      paramInt = 1;
      if (localArrayList.size() < 9) {
        break label374;
      }
    }
    label374:
    label380:
    for (;;)
    {
      if (paramInt == 0)
      {
        localArrayList.clear();
        localArrayList.add(paramString);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "onResumeAIOWithoutTorch, reqlist=" + localArrayList.size());
        }
        ((OlympicHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.a(94)).a(localArrayList);
        return;
        localArrayList.add(localObject);
        break;
        localArrayList.add(0, paramString);
      }
      k = paramInt;
      break;
    }
  }
  
  public void a(String paramString, boolean paramBoolean, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "onGetTorchFlag,uin:" + paramString + " flag:" + paramBoolean);
    }
    d();
    localObject = this.jdField_a_of_type_JavaLangObject;
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        bool = this.jdField_a_of_type_JavaUtilSet.add(paramString) | false;
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Long.valueOf(paramLong));
        if ((bool) && (!this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(0))) {
          this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(0, 500L);
        }
        if ((this.jdField_a_of_type_MqqUtilWeakReference != null) && (this.jdField_a_of_type_MqqUtilWeakReference.get() != null)) {
          ((OlympicTorchManager.TorchUpdateListener)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(paramString);
        }
        ((FriendListHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.a(1)).a(106, true, Boolean.valueOf(true));
        return;
      }
      finally {}
      boolean bool = this.jdField_a_of_type_JavaUtilSet.remove(paramString) | false;
    }
  }
  
  public void a(List paramList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "getOlympicTorchs," + paramList.size());
    }
    List localList = (List)this.c.get(Integer.valueOf(paramInt));
    if ((localList != null) && (localList.size() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "getOlympicTorchs, reqListGoing not null");
      }
      return;
    }
    this.c.put(Integer.valueOf(paramInt), paramList);
    a(paramInt);
  }
  
  public void a(List paramList, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "onGetTorchFlag list:" + paramList.size() + " complete:" + paramBoolean + " groupId:" + paramInt);
    }
    d();
    long l = System.currentTimeMillis();
    if ((paramBoolean) && (paramInt >= 0)) {
      this.b.put(Integer.valueOf(paramInt), Long.valueOf(l));
    }
    Object localObject = this.jdField_a_of_type_JavaLangObject;
    int i = 0;
    paramInt = 0;
    try
    {
      if (i < paramList.size())
      {
        if (((Boolean)((Pair)paramList.get(i)).second).booleanValue()) {}
        for (paramInt = this.jdField_a_of_type_JavaUtilSet.add(((Pair)paramList.get(i)).first) | paramInt;; paramInt = this.jdField_a_of_type_JavaUtilSet.remove(((Pair)paramList.get(i)).first) | paramInt)
        {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(((Pair)paramList.get(i)).first, Long.valueOf(l));
          i += 1;
          break;
        }
      }
      if ((paramInt != 0) && (!this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(0))) {
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(0, 500L);
      }
      return;
    }
    finally {}
  }
  
  public boolean a(String paramString)
  {
    boolean bool1;
    if (TextUtils.isEmpty(paramString)) {
      bool1 = false;
    }
    for (;;)
    {
      return bool1;
      d();
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        boolean bool2 = this.jdField_a_of_type_JavaUtilSet.contains(paramString);
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i(jdField_a_of_type_JavaLangString, 2, "hasTorch, uin:" + paramString + " " + bool2);
        return bool2;
      }
    }
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    d();
    Long localLong;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      localLong = (Long)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (localLong == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "hasTimeout, uin:" + paramString + " no records" + " has:" + paramBoolean);
        }
        return true;
      }
    }
    long l2 = System.currentTimeMillis() - localLong.longValue();
    long l1;
    if (paramBoolean)
    {
      l1 = 3600000L;
      if ((l2 <= l1) && (l2 >= 0L)) {
        break label190;
      }
    }
    label190:
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "hasTimeout,uin:" + paramString + " " + bool + " has:" + paramBoolean);
      }
      return bool;
      l1 = 300000L;
      break;
    }
  }
  
  public boolean a(List paramList, int paramInt)
  {
    ((List)this.c.get(Integer.valueOf(paramInt))).addAll(0, paramList);
    return ((List)this.c.get(Integer.valueOf(paramInt))).size() == 0;
  }
  
  public void b()
  {
    this.jdField_a_of_type_MqqUtilWeakReference = null;
  }
  
  public void b(int paramInt)
  {
    if (paramInt < 0) {}
    while (((List)this.c.get(Integer.valueOf(paramInt))).size() <= 0) {
      return;
    }
    ((List)this.c.get(Integer.valueOf(paramInt))).clear();
  }
  
  public boolean b(int paramInt)
  {
    long l2 = 0L;
    long l1;
    long l3;
    if (this.b.containsKey(Integer.valueOf(paramInt)))
    {
      l1 = ((Long)this.b.get(Integer.valueOf(paramInt))).longValue();
      if (this.b.containsKey(Integer.valueOf(1000))) {
        l2 = ((Long)this.b.get(Integer.valueOf(1000))).longValue();
      }
      l3 = System.currentTimeMillis();
      if (l3 - l2 >= 3600000L) {
        break label151;
      }
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "isRecentlyGotGroupTorchs, true all");
      }
      paramInt = 1;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "isRecentlyGotGroupTorchs " + paramInt);
      }
      if (paramInt > 0)
      {
        return true;
        l1 = 0L;
        break;
        label151:
        if (l3 - l1 >= 3600000L) {
          break label185;
        }
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "isRecentlyGotGroupTorchs, true group");
        }
        paramInt = 2;
        continue;
      }
      return false;
      label185:
      paramInt = 0;
    }
  }
  
  public boolean b(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilSet != null) && (this.jdField_a_of_type_JavaUtilSet.contains(paramString))) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "hasTorchFast uin:" + paramString + " has:" + bool);
      }
      return bool;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      e();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\olympic\OlympicTorchManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */