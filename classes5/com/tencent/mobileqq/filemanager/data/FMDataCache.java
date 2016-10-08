package com.tencent.mobileqq.filemanager.data;

import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FMDataCache
{
  private static int jdField_a_of_type_Int;
  private static long jdField_a_of_type_Long;
  private static ArrayList jdField_a_of_type_JavaUtilArrayList;
  private static Map jdField_a_of_type_JavaUtilMap = new HashMap();
  private static ArrayList jdField_b_of_type_JavaUtilArrayList;
  private static Map jdField_b_of_type_JavaUtilMap = new HashMap();
  private static ArrayList c;
  private static ArrayList d;
  private static ArrayList e;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    c = new ArrayList();
    d = new ArrayList();
    jdField_a_of_type_Int = 20;
    e = new ArrayList();
  }
  
  public static long a()
  {
    return jdField_a_of_type_JavaUtilArrayList.size() + d.size() + c.size() + jdField_b_of_type_JavaUtilArrayList.size();
  }
  
  public static WeiYunFileInfo a(String paramString)
  {
    return (WeiYunFileInfo)jdField_a_of_type_JavaUtilMap.remove(paramString);
  }
  
  public static ArrayList a()
  {
    return e;
  }
  
  public static void a()
  {
    e.clear();
  }
  
  public static void a(int paramInt)
  {
    jdField_a_of_type_Int = paramInt;
  }
  
  public static void a(long paramLong)
  {
    jdField_a_of_type_Long = paramLong;
  }
  
  public static void a(FileInfo paramFileInfo)
  {
    if (!a(paramFileInfo.a())) {
      return;
    }
    jdField_a_of_type_JavaUtilArrayList.add(paramFileInfo);
  }
  
  public static void a(FileManagerEntity paramFileManagerEntity)
  {
    if (!a(paramFileManagerEntity.fileSize)) {
      return;
    }
    d.add(paramFileManagerEntity);
  }
  
  public static void a(OfflineFileInfo paramOfflineFileInfo)
  {
    if (!a(paramOfflineFileInfo.b)) {
      return;
    }
    c.add(paramOfflineFileInfo);
  }
  
  public static void a(WeiYunFileInfo paramWeiYunFileInfo)
  {
    if (!a(paramWeiYunFileInfo.jdField_a_of_type_Long)) {
      return;
    }
    jdField_b_of_type_JavaUtilArrayList.add(paramWeiYunFileInfo);
  }
  
  public static void a(String paramString)
  {
    jdField_b_of_type_JavaUtilMap.remove(paramString);
  }
  
  public static void a(String paramString, WeiYunFileInfo paramWeiYunFileInfo)
  {
    jdField_a_of_type_JavaUtilMap.put(paramString, paramWeiYunFileInfo);
  }
  
  public static void a(String paramString, byte[] paramArrayOfByte)
  {
    FMDataCache.TmpSignature localTmpSignature = new FMDataCache.TmpSignature();
    localTmpSignature.jdField_a_of_type_JavaLangString = paramString;
    localTmpSignature.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    jdField_b_of_type_JavaUtilMap.put(paramString, localTmpSignature);
  }
  
  public static void a(ArrayList paramArrayList)
  {
    e.clear();
    e.addAll(paramArrayList);
  }
  
  public static boolean a()
  {
    long l = b();
    return (l > 3145728L) || (l < 0L);
  }
  
  private static boolean a(long paramLong)
  {
    if ((jdField_a_of_type_Int > 0) && (a() >= jdField_a_of_type_Int))
    {
      FMToastUtil.a(0, String.format(BaseApplicationImpl.a().getResources().getString(2131362939), new Object[] { Integer.valueOf(jdField_a_of_type_Int) }), 0);
      return false;
    }
    if ((jdField_a_of_type_Long > 0L) && (c() + paramLong > jdField_a_of_type_Long))
    {
      String str = BaseApplicationImpl.a().getResources().getString(2131362940);
      FMToastUtil.a(0, str + FileUtil.a(jdField_a_of_type_Long), 0);
      return false;
    }
    return true;
  }
  
  public static boolean a(FileInfo paramFileInfo)
  {
    return jdField_a_of_type_JavaUtilArrayList.contains(paramFileInfo);
  }
  
  public static boolean a(FileManagerEntity paramFileManagerEntity)
  {
    return d.contains(paramFileManagerEntity);
  }
  
  public static boolean a(OfflineFileInfo paramOfflineFileInfo)
  {
    Iterator localIterator = c.iterator();
    while (localIterator.hasNext()) {
      if (((OfflineFileInfo)localIterator.next()).jdField_a_of_type_JavaLangString.equals(paramOfflineFileInfo.jdField_a_of_type_JavaLangString)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(WeiYunFileInfo paramWeiYunFileInfo)
  {
    Iterator localIterator = jdField_b_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      if (((WeiYunFileInfo)localIterator.next()).jdField_a_of_type_JavaLangString.equals(paramWeiYunFileInfo.jdField_a_of_type_JavaLangString)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(String paramString)
  {
    return jdField_a_of_type_JavaUtilMap.containsKey(paramString);
  }
  
  public static byte[] a(String paramString)
  {
    paramString = (FMDataCache.TmpSignature)jdField_b_of_type_JavaUtilMap.get(paramString);
    if (paramString != null) {
      return paramString.jdField_a_of_type_ArrayOfByte;
    }
    return null;
  }
  
  public static long b()
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
    for (long l = 0L; localIterator.hasNext(); l += ((FileInfo)localIterator.next()).a()) {}
    localIterator = d.iterator();
    while (localIterator.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
      if (localFileManagerEntity.getCloudType() == 3) {
        l += FileUtil.a(localFileManagerEntity.getFilePath());
      }
    }
    return l;
  }
  
  public static ArrayList b()
  {
    return jdField_a_of_type_JavaUtilArrayList;
  }
  
  public static void b()
  {
    jdField_a_of_type_JavaUtilArrayList.clear();
    d.clear();
    c.clear();
    jdField_b_of_type_JavaUtilArrayList.clear();
  }
  
  public static void b(FileInfo paramFileInfo)
  {
    jdField_a_of_type_JavaUtilArrayList.remove(paramFileInfo);
  }
  
  public static void b(FileManagerEntity paramFileManagerEntity)
  {
    d.remove(paramFileManagerEntity);
  }
  
  public static void b(OfflineFileInfo paramOfflineFileInfo)
  {
    Iterator localIterator = c.iterator();
    while (localIterator.hasNext())
    {
      OfflineFileInfo localOfflineFileInfo = (OfflineFileInfo)localIterator.next();
      if (localOfflineFileInfo.jdField_a_of_type_JavaLangString.equals(paramOfflineFileInfo.jdField_a_of_type_JavaLangString)) {
        c.remove(localOfflineFileInfo);
      }
    }
  }
  
  public static void b(WeiYunFileInfo paramWeiYunFileInfo)
  {
    Iterator localIterator = jdField_b_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      WeiYunFileInfo localWeiYunFileInfo = (WeiYunFileInfo)localIterator.next();
      if (localWeiYunFileInfo.jdField_a_of_type_JavaLangString.equals(paramWeiYunFileInfo.jdField_a_of_type_JavaLangString)) {
        jdField_b_of_type_JavaUtilArrayList.remove(localWeiYunFileInfo);
      }
    }
  }
  
  public static long c()
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
    for (long l = 0L; localIterator.hasNext(); l += ((FileInfo)localIterator.next()).a()) {}
    localIterator = jdField_b_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      l += ((WeiYunFileInfo)localIterator.next()).jdField_a_of_type_Long;
    }
    localIterator = c.iterator();
    while (localIterator.hasNext()) {
      l += ((OfflineFileInfo)localIterator.next()).b;
    }
    localIterator = d.iterator();
    while (localIterator.hasNext()) {
      l += ((FileManagerEntity)localIterator.next()).fileSize;
    }
    return l;
  }
  
  public static ArrayList c()
  {
    return d;
  }
  
  public static void c()
  {
    jdField_b_of_type_JavaUtilMap.clear();
  }
  
  public static long d()
  {
    Iterator localIterator = jdField_b_of_type_JavaUtilArrayList.iterator();
    for (long l = 0L; localIterator.hasNext(); l += ((WeiYunFileInfo)localIterator.next()).jdField_a_of_type_Long) {}
    localIterator = c.iterator();
    while (localIterator.hasNext()) {
      l += ((OfflineFileInfo)localIterator.next()).b;
    }
    localIterator = d.iterator();
    while (localIterator.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
      switch (localFileManagerEntity.getCloudType())
      {
      default: 
        break;
      case 1: 
      case 2: 
        l += localFileManagerEntity.fileSize;
      }
    }
    return l;
  }
  
  public static ArrayList d()
  {
    return c;
  }
  
  public static ArrayList e()
  {
    return jdField_b_of_type_JavaUtilArrayList;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\data\FMDataCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */