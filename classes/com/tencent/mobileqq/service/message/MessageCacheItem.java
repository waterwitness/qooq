package com.tencent.mobileqq.service.message;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class MessageCacheItem
{
  public static final int a = 0;
  public static final String a;
  public static final String[] a;
  public static final int b = 0;
  public static final int c = 1;
  public static final int d = 2;
  public static final int e = 3;
  public static final int f = 3;
  public static final int g = 2;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MessageCache.AsyncEditor jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache$AsyncEditor;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(2);
  private String jdField_b_of_type_JavaLangString;
  private ConcurrentHashMap jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(2);
  private int h;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = MessageCacheItem.class.getSimpleName();
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "msg_cached_max_seq", "msg_cached_min_seq", "msg_readed_seq", "msg_expired_seq" };
  }
  
  public MessageCacheItem(QQAppInterface paramQQAppInterface, int paramInt, String paramString, SharedPreferences paramSharedPreferences, MessageCache.AsyncEditor paramAsyncEditor)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.h = paramInt;
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidContentSharedPreferences = paramSharedPreferences;
    this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache$AsyncEditor = paramAsyncEditor;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(jdField_a_of_type_ArrayOfJavaLangString.length);
    paramInt = 0;
    while (paramInt <= 3)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(new ConcurrentHashMap(2));
      paramInt += 1;
    }
  }
  
  public int a(String paramString)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Integer.valueOf(2));
    }
    return ((Integer)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).intValue();
  }
  
  public long a(int paramInt, String paramString)
  {
    if ((paramInt < 0) || (paramInt > 3) || (TextUtils.isEmpty(paramString))) {
      return 0L;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() == null) {
      return 0L;
    }
    ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if (!localConcurrentHashMap.containsKey(paramString)) {
      localConcurrentHashMap.put(paramString, Long.valueOf(this.jdField_a_of_type_AndroidContentSharedPreferences.getLong(a(paramInt, paramString), 0L)));
    }
    return ((Long)localConcurrentHashMap.get(paramString)).longValue();
  }
  
  public String a(int paramInt, String paramString)
  {
    if ((paramInt < 0) || (paramInt > 3) || (TextUtils.isEmpty(paramString))) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder(50);
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString).append("_").append(jdField_a_of_type_ArrayOfJavaLangString[paramInt]).append("_").append(paramString);
    return localStringBuilder.toString();
  }
  
  public ArrayList a(String paramString)
  {
    return (ArrayList)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public void a()
  {
    int i = 0;
    while (i <= 3)
    {
      ((ConcurrentHashMap)this.jdField_a_of_type_JavaUtilArrayList.get(i)).clear();
      i += 1;
    }
  }
  
  public void a(int paramInt1, String paramString, long paramLong, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 > 3) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    long l1;
    if (paramInt2 == 1) {
      l1 = Math.max(paramLong, a(paramInt1, paramString));
    }
    for (;;)
    {
      ((ConcurrentHashMap)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt1)).put(paramString, Long.valueOf(l1));
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache$AsyncEditor.putLong(a(paramInt1, paramString), l1);
      return;
      l1 = paramLong;
      if (paramInt2 == 2)
      {
        long l2 = a(paramInt1, paramString);
        l1 = paramLong;
        if (l2 != 0L) {
          l1 = Math.min(paramLong, l2);
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Integer.valueOf(paramInt));
  }
  
  public void a(String paramString, Object[] paramArrayOfObject)
  {
    ArrayList localArrayList2 = (ArrayList)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    ArrayList localArrayList1;
    if (localArrayList2 != null)
    {
      localArrayList1 = localArrayList2;
      if (localArrayList2.size() != 0) {}
    }
    else
    {
      localArrayList1 = new ArrayList();
    }
    localArrayList1.add(paramArrayOfObject);
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localArrayList1);
  }
  
  public void b(String paramString)
  {
    int i = 0;
    while (i <= 3)
    {
      ((ConcurrentHashMap)this.jdField_a_of_type_JavaUtilArrayList.get(i)).put(a(i, paramString), Long.valueOf(0L));
      i += 1;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null)
    {
      i = 0;
      while (i <= 3)
      {
        this.jdField_a_of_type_ComTencentMobileqqServiceMessageMessageCache$AsyncEditor.remove(a(i, paramString));
        i += 1;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\service\message\MessageCacheItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */