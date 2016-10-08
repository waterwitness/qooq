package com.tencent.mobileqq.apollo.store;

import android.text.TextUtils;
import com.tencent.av.opengl.utils.IntArray;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;
import prw;
import prx;
import pry;

public class ApolloResDownloader
{
  private static final String a = "ApolloResDownloader";
  public static ConcurrentHashMap a;
  public static final int[] a;
  public static ConcurrentHashMap b;
  public static final int[] b;
  public static final int[] c;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ArrayOfInt = new int[] { 1, 2, 3, 4, 5, 6, 7 };
    jdField_b_of_type_ArrayOfInt = new int[] { 53, 54, 55, 56, 86, 87, 88 };
    c = new int[] { 91, 90, 63, 64, 65, 102, 103 };
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  public static String a(int paramInt)
  {
    Object localObject = new File(a(1, paramInt), "config.json");
    if (!((File)localObject).exists()) {}
    do
    {
      for (;;)
      {
        return null;
        try
        {
          localObject = new JSONObject(FileUtils.b((File)localObject)).optString("bubbleTips");
          return (String)localObject;
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel())
          {
            QLog.d("ApolloResDownloader", 2, "saveResTimestamp ex!" + localException.getMessage());
            return null;
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloResDownloader", 2, "saveResTimestamp OOM!");
    return null;
  }
  
  public static String a(int paramInt1, int paramInt2)
  {
    Object localObject;
    if (paramInt1 == 1) {
      if (paramInt2 == 0) {
        localObject = ApolloConstant.k + "/def/role/0/";
      }
    }
    String str;
    do
    {
      return (String)localObject;
      return ApolloConstant.n + paramInt2 + File.separator;
      if (paramInt1 == 2) {
        return ApolloConstant.m + paramInt2 + File.separator;
      }
      if (paramInt1 == 3) {
        return ApolloConstant.l + paramInt2 + File.separator;
      }
      str = ApolloConstant.j + "/unknow/" + paramInt2 + File.separator;
      localObject = str;
    } while (!QLog.isColorLevel());
    QLog.d("ApolloResDownloader", 2, "getRealResFile unknow Type->" + paramInt1 + " id->" + paramInt2);
    return str;
  }
  
  public static void a(AppInterface paramAppInterface, int paramInt1, int paramInt2)
  {
    Object localObject = new File(a(paramInt1, paramInt2), "config.json");
    if ((!((File)localObject).exists()) || (paramAppInterface == null)) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          localObject = new JSONObject(FileUtils.b((File)localObject));
          long l = ((JSONObject)localObject).optLong("version");
          ((ApolloManager)paramAppInterface.getManager(152)).a(paramInt1, paramInt2, l);
          if (paramInt1 == 1)
          {
            paramAppInterface = ((JSONObject)localObject).optJSONArray("dressIds");
            if ((paramAppInterface != null) && (paramAppInterface.length() > 0))
            {
              int i = paramAppInterface.length();
              localObject = new IntArray();
              paramInt1 = 0;
              while (paramInt1 < i)
              {
                ((IntArray)localObject).a(paramAppInterface.optInt(paramInt1));
                paramInt1 += 1;
              }
              jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt2), localObject);
              return;
            }
          }
        }
        catch (Exception paramAppInterface)
        {
          if (QLog.isColorLevel())
          {
            QLog.d("ApolloResDownloader", 2, "saveResTimestamp ex!" + paramAppInterface.getMessage());
            return;
          }
        }
        catch (OutOfMemoryError paramAppInterface) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloResDownloader", 2, "saveResTimestamp oom!");
  }
  
  public static void a(AppInterface paramAppInterface, String paramString, ApolloResDownloader.OnApolloDownLoadListener paramOnApolloDownLoadListener, int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (paramInt1 >= 0) {
      b(paramAppInterface, paramString, new prw(paramAppInterface, paramArrayOfInt, paramOnApolloDownLoadListener, paramBoolean, paramInt1), paramInt1, null, paramInt2, paramInt3, paramBoolean);
    }
    while (paramAppInterface == null) {
      return;
    }
    b(paramAppInterface, paramString, paramOnApolloDownLoadListener, -1, paramArrayOfInt, paramInt2, paramInt3, paramBoolean);
  }
  
  public static boolean a(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1;
    if (jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(paramInt))) {
      bool1 = ((Boolean)jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt))).booleanValue();
    }
    Object localObject;
    do
    {
      return bool1;
      localObject = new File(a(3, paramInt), "config.json");
      bool1 = bool2;
    } while (!((File)localObject).exists());
    for (;;)
    {
      try
      {
        localObject = new JSONObject(FileUtils.b((File)localObject)).optJSONObject("audio");
        if (localObject == null) {
          break label161;
        }
        bool1 = ((JSONObject)localObject).optBoolean("hasSound");
        jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), Boolean.valueOf(bool1));
        return bool1;
      }
      catch (Exception localException)
      {
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ApolloResDownloader", 2, "saveResTimestamp ex!" + localException.getMessage());
        return false;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        bool1 = bool2;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ApolloResDownloader", 2, "saveResTimestamp OOM!");
      return false;
      label161:
      bool1 = false;
    }
  }
  
  public static int[] a(int paramInt)
  {
    Object localObject4;
    if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(paramInt)))
    {
      localObject4 = ((IntArray)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt))).a(null);
      return (int[])localObject4;
    }
    for (;;)
    {
      try
      {
        Object localObject1 = new File(a(1, paramInt), "config.json");
        if (!((File)localObject1).exists()) {
          break label326;
        }
        localObject1 = new JSONObject(FileUtils.b((File)localObject1)).optJSONArray("dressIds");
        if ((localObject1 == null) || (((JSONArray)localObject1).length() <= 0)) {
          break label326;
        }
        int j = ((JSONArray)localObject1).length();
        localObject4 = new IntArray();
        int i = 0;
        if (i < j)
        {
          ((IntArray)localObject4).a(((JSONArray)localObject1).optInt(i));
          i += 1;
          continue;
        }
        jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), localObject4);
        localObject1 = ((IntArray)localObject4).a(null);
        if (localObject1 != null)
        {
          localObject4 = localObject1;
          if (localObject1.length != 0) {
            break;
          }
        }
        if (paramInt == 1) {
          return jdField_b_of_type_ArrayOfInt;
        }
        if (2 == paramInt) {
          return c;
        }
        return jdField_a_of_type_ArrayOfInt;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloResDownloader", 2, "readRoleDefaultDressIds ex!" + localException.getMessage());
        }
        if ((0 != 0) && (null.length != 0)) {
          break label324;
        }
        if (paramInt == 1) {
          return jdField_b_of_type_ArrayOfInt;
        }
        if (2 == paramInt) {
          return c;
        }
        return jdField_a_of_type_ArrayOfInt;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloResDownloader", 2, "readRoleDefaultDressIds OOM!");
        }
        if ((0 != 0) && (null.length != 0)) {
          break label324;
        }
        if (paramInt == 1) {
          return jdField_b_of_type_ArrayOfInt;
        }
        if (2 == paramInt) {
          return c;
        }
        return jdField_a_of_type_ArrayOfInt;
      }
      finally
      {
        if ((0 == 0) || (null.length == 0))
        {
          if (paramInt != 1) {
            break label305;
          }
          localObject4 = jdField_b_of_type_ArrayOfInt;
        }
      }
      label305:
      if (2 == paramInt)
      {
        localObject4 = c;
      }
      else
      {
        localObject4 = jdField_a_of_type_ArrayOfInt;
        continue;
        label324:
        return null;
        label326:
        Object localObject3 = null;
      }
    }
  }
  
  public static String b(int paramInt1, int paramInt2)
  {
    String str = "";
    if (paramInt1 == 1) {
      str = "http://cmshow.gtimg.cn/qqshow/admindata/comdata/vipApollo_role_" + paramInt2 + "/d.zip";
    }
    do
    {
      return str;
      if (paramInt1 == 2) {
        return "http://cmshow.gtimg.cn/qqshow/admindata/comdata/vipApollo_item_" + paramInt2 + "/d.zip";
      }
      if (paramInt1 == 3) {
        return "http://cmshow.gtimg.cn/qqshow/admindata/comdata/vipApollo_action_" + paramInt2 + "/d.zip";
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloResDownloader", 2, "getRealResUrl recognize Type->" + paramInt1 + " id->" + paramInt2);
    return "";
  }
  
  public static void b(AppInterface paramAppInterface, String paramString, ApolloResDownloader.OnApolloDownLoadListener paramOnApolloDownLoadListener, int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if ((paramAppInterface == null) || (!NetworkUtil.h(paramAppInterface.getApplication())))
    {
      if (paramOnApolloDownLoadListener != null) {
        paramOnApolloDownLoadListener.a(false, paramString, paramInt1, paramArrayOfInt, paramInt2);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloResDownloader", 2, "downloadApolloRes null Parameters!");
      }
    }
    AtomicInteger localAtomicInteger1;
    label515:
    do
    {
      do
      {
        ArrayList localArrayList;
        Object localObject1;
        do
        {
          do
          {
            do
            {
              return;
              localArrayList = new ArrayList();
              if (paramInt1 >= 0) {
                localArrayList.add(new pry(1, paramInt1));
              }
              if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0))
              {
                i = 0;
                while (i < paramArrayOfInt.length)
                {
                  localArrayList.add(new pry(2, paramArrayOfInt[i]));
                  i += 1;
                }
              }
              if (paramInt2 > 0) {
                localArrayList.add(new pry(3, paramInt2));
              }
              if (!localArrayList.isEmpty()) {
                break;
              }
            } while (paramOnApolloDownLoadListener == null);
            paramOnApolloDownLoadListener.a(false, paramString, paramInt1, paramArrayOfInt, paramInt2);
            return;
            localObject1 = (DownloaderFactory)paramAppInterface.getManager(46);
            if (localObject1 != null) {
              break;
            }
          } while (paramOnApolloDownLoadListener == null);
          paramOnApolloDownLoadListener.a(false, paramString, paramInt1, paramArrayOfInt, paramInt2);
          return;
          localObject1 = ((DownloaderFactory)localObject1).a(1);
          if (localObject1 != null) {
            break;
          }
        } while (paramOnApolloDownLoadListener == null);
        paramOnApolloDownLoadListener.a(false, paramString, paramInt1, paramArrayOfInt, paramInt2);
        return;
        localAtomicInteger1 = new AtomicInteger(localArrayList.size());
        AtomicInteger localAtomicInteger2 = new AtomicInteger(0);
        AtomicInteger localAtomicInteger3 = new AtomicInteger(0);
        int j = localArrayList.size();
        int i = 0;
        if (i < j)
        {
          Object localObject2 = (pry)localArrayList.get(i);
          int k = ((pry)localObject2).a;
          int m = ((pry)localObject2).b;
          Object localObject3 = b(k, m);
          if (TextUtils.isEmpty((CharSequence)localObject3))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApolloResDownloader", 2, "downloadApolloRes url is empty resType->" + k + " id->" + m);
            }
            localAtomicInteger1.decrementAndGet();
          }
          for (;;)
          {
            i += 1;
            break;
            if (!paramBoolean)
            {
              boolean bool = false;
              if (k == 1) {
                bool = ApolloUtil.c(m);
              }
              for (;;)
              {
                if (!bool) {
                  break label515;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("ApolloResDownloader", 2, "file exsit resType->" + k + " id->" + m);
                }
                localAtomicInteger1.decrementAndGet();
                break;
                if (k == 2) {
                  bool = ApolloUtil.b(m);
                } else if (k == 3) {
                  bool = ApolloUtil.a(m, paramInt3);
                }
              }
              if (QLog.isColorLevel()) {
                QLog.d("ApolloResDownloader", 2, "file not exsit resType->" + k + " id->" + m);
              }
            }
            localObject2 = new File(a(k, m), "res.zip");
            ((File)localObject2).getParentFile().mkdirs();
            localObject3 = new DownloadTask((String)localObject3, (File)localObject2);
            ((DownloadTask)localObject3).n = false;
            ((DownloadTask)localObject3).l = true;
            ((DownloadTask)localObject3).f = "apollo_res";
            ((DownloadTask)localObject3).A = 1;
            ((DownloaderInterface)localObject1).a((DownloadTask)localObject3, new prx((File)localObject2, paramAppInterface, k, m, localAtomicInteger3, localAtomicInteger2, localAtomicInteger1, paramOnApolloDownLoadListener, paramString, paramInt1, paramArrayOfInt, paramInt2), null);
          }
        }
      } while (localAtomicInteger1.get() != 0);
      if (paramOnApolloDownLoadListener != null) {
        paramOnApolloDownLoadListener.a(true, paramString, paramInt1, paramArrayOfInt, paramInt2);
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloResDownloader", 2, "downloadApolloRes local dress ok uin:" + paramString + ", all cnt: " + localAtomicInteger1.get());
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\apollo\store\ApolloResDownloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */