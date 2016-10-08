package com.tencent.mobileqq.vas;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AvatarPendantManager
  implements Manager
{
  public static final int a = 9999;
  public static final String a;
  public static volatile long b = 0L;
  public static final String b = "pendant_info";
  public static volatile boolean b = false;
  public static final String c = "pendant_local.cfg";
  public static volatile boolean c = false;
  public static final String d = "id";
  public static final String e = "version";
  public long a;
  protected AppInterface a;
  protected AvatarPendantManager.PendantInfoLruCache a;
  List a;
  public boolean a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = AvatarPendantManager.class.getSimpleName();
  }
  
  public AvatarPendantManager(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantManager$PendantInfoLruCache = new AvatarPendantManager.PendantInfoLruCache(this, 10);
    this.jdField_a_of_type_Boolean = false;
  }
  
  private String a(String paramString)
  {
    paramString = new BufferedReader(new FileReader(paramString));
    char[] arrayOfChar = new char['ࠀ'];
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      int i = paramString.read(arrayOfChar);
      if (i <= 0) {
        break;
      }
      localStringBuilder.append(arrayOfChar, 0, i);
    }
    paramString.close();
    return localStringBuilder.toString();
  }
  
  public PendantInfo a(long paramLong)
  {
    PendantInfo localPendantInfo2 = (PendantInfo)this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantManager$PendantInfoLruCache.get(Long.valueOf(paramLong));
    PendantInfo localPendantInfo1;
    if (localPendantInfo2 != null)
    {
      localPendantInfo1 = localPendantInfo2;
      if (QLog.isColorLevel())
      {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getPendantInfo pendantId=" + paramLong + " from cache");
        localPendantInfo1 = localPendantInfo2;
      }
    }
    for (;;)
    {
      localPendantInfo1.a(this.jdField_a_of_type_Boolean);
      return localPendantInfo1;
      localPendantInfo1 = new PendantInfo(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramLong);
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantManager$PendantInfoLruCache.put(Long.valueOf(paramLong), localPendantInfo1);
    }
  }
  
  public File a()
  {
    File localFile = new File(this.jdField_a_of_type_ComTencentCommonAppAppInterface.a().getApplicationContext().getFilesDir(), "pendant_info");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile;
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public JSONArray a()
  {
    Object localObject1 = new File(a(), "pendant_local.cfg");
    if (((File)localObject1).exists()) {}
    for (;;)
    {
      try
      {
        localObject1 = a(((File)localObject1).getAbsolutePath());
        if (localObject1 != null)
        {
          localObject1 = new JSONArray((String)localObject1);
          Object localObject3 = localObject1;
          if (localObject1 == null) {
            localObject3 = new JSONArray();
          }
          return (JSONArray)localObject3;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      Object localObject2 = null;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantManager$PendantInfoLruCache.values().iterator();
    while (localIterator.hasNext()) {
      ((PendantInfo)localIterator.next()).a(true);
    }
  }
  
  public void a(String paramString)
  {
    Context localContext = this.jdField_a_of_type_ComTencentCommonAppAppInterface.a().getApplicationContext();
    try
    {
      b = 0L;
      QQToast.a(localContext, "pendant file" + paramString, 0).a();
      File localFile = new File("/storage/emulated/0/Tencent/pendant_temp/");
      if (!localFile.exists()) {
        localFile.mkdir();
      }
      if (!DownloaderFactory.a(new File(paramString), localFile, false))
      {
        QQToast.a(localContext, "unzip test pendant fail", 0).a();
        return;
      }
      paramString = new File(AppConstants.bY + 9999);
      if (paramString.exists()) {
        FileUtils.a(paramString.getAbsolutePath());
      }
      if (DownloaderFactory.a(new File("/storage/emulated/0/Tencent/pendant_temp/" + "androidPendant.zip"), paramString, false))
      {
        QQToast.a(localContext, "unzip test pendant success", 0).a();
        b = 9999L;
        return;
      }
    }
    catch (Exception paramString)
    {
      b = 0L;
      if (QLog.isColorLevel())
      {
        QLog.d(jdField_a_of_type_JavaLangString, 2, paramString.getMessage());
        QQToast.a(localContext, paramString.getMessage(), 0).a();
        return;
        QQToast.a(localContext, "unzip test pendant fail", 0).a();
      }
    }
  }
  
  public void a(HashMap paramHashMap, ArrayList paramArrayList)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "deletePendants, map=" + paramHashMap + ", excludeList=" + paramArrayList);
    }
    JSONArray localJSONArray = a();
    int k;
    for (int j = 0;; j = k)
    {
      if (i < localJSONArray.length()) {
        try
        {
          JSONObject localJSONObject = localJSONArray.getJSONObject(i);
          String str = localJSONObject.getString("id");
          k = j;
          if (!paramHashMap.containsKey(str)) {
            break label288;
          }
          if ((paramArrayList == null) || (!paramArrayList.contains(str))) {
            FileUtils.a(AppConstants.bY + str);
          }
          for (;;)
          {
            localJSONObject.remove("version");
            localJSONObject.put("version", paramHashMap.get(str));
            k = 1;
            break;
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "deletePendants, resource not deleted, pendantId=" + str);
            }
          }
          if (j == 0) {}
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          k = j;
        }
      }
      try
      {
        paramHashMap = new FileWriter(new File(this.jdField_a_of_type_ComTencentCommonAppAppInterface.a().getApplicationContext().getFilesDir() + "/" + "pendant_info", "pendant_local.cfg"), false);
        paramHashMap.write(localJSONArray.toString());
        paramHashMap.flush();
        paramHashMap.close();
        return;
      }
      catch (IOException paramHashMap)
      {
        return;
      }
      label288:
      i += 1;
    }
  }
  
  public boolean a(long paramLong)
  {
    return this.jdField_a_of_type_Long != paramLong;
  }
  
  public File b()
  {
    File localFile = new File(AppConstants.bY);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile;
  }
  
  public JSONArray b()
  {
    int j = 0;
    JSONArray localJSONArray = a();
    Object localObject2 = new File(AppConstants.bY).listFiles();
    Object localObject1 = new HashSet();
    if ((localObject2 != null) && (localObject2.length > 0))
    {
      int k = localObject2.length;
      i = 0;
      while (i < k)
      {
        Object localObject3 = localObject2[i];
        if (((File)localObject3).isDirectory()) {
          ((HashSet)localObject1).add(((File)localObject3).getName());
        }
        i += 1;
      }
    }
    localObject2 = new HashSet();
    int i = 0;
    for (;;)
    {
      if (i < localJSONArray.length()) {
        try
        {
          ((HashSet)localObject2).add(localJSONArray.getJSONObject(i).getString("id"));
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
      }
    }
    ((HashSet)localObject1).removeAll((Collection)localObject2);
    localObject1 = ((HashSet)localObject1).iterator();
    i = j;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      i = 1;
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("id", localObject2);
        localJSONObject.put("version", 0);
        localJSONArray.put(localJSONObject);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
    if (i != 0) {}
    try
    {
      localObject1 = new FileWriter(new File(this.jdField_a_of_type_ComTencentCommonAppAppInterface.a().getApplicationContext().getFilesDir() + "/" + "pendant_info", "pendant_local.cfg"), false);
      ((FileWriter)localObject1).write(localJSONArray.toString());
      ((FileWriter)localObject1).flush();
      ((FileWriter)localObject1).close();
      return localJSONArray;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    return localJSONArray;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantManager$PendantInfoLruCache.values().iterator();
    while (localIterator.hasNext()) {
      ((PendantInfo)localIterator.next()).a(false);
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantManager$PendantInfoLruCache.values().iterator();
    while (localIterator.hasNext()) {
      ((PendantInfo)localIterator.next()).c();
    }
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantManager$PendantInfoLruCache.clear();
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantManager$PendantInfoLruCache.clear();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vas\AvatarPendantManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */