package com.tencent.biz.webviewplugin;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.util.OfflineSecurity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.OfflineWebRes;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.mobileqq.vas.ClubContentJsonTask.TaskInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import jhr;
import jhs;
import org.json.JSONObject;

public class OfflineWebResManager
{
  static final String jdField_a_of_type_JavaLangString = "OfflineWebResManager";
  private static ConcurrentLinkedQueue jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue;
  public static boolean a = false;
  public static final String b = "WebOfflineRes";
  public static boolean b = false;
  public static final String c = "OfflineWebResManager";
  public final long a;
  public AppInterface a;
  public EntityManager a;
  final long b;
  public String d = "";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
    jdField_b_of_type_Boolean = true;
  }
  
  public OfflineWebResManager(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_Long = 86400000L;
    this.jdField_b_of_type_Long = 5242880L;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    paramAppInterface = this.jdField_a_of_type_ComTencentCommonAppAppInterface.a();
    if (paramAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramAppInterface.createEntityManager();
    }
  }
  
  public static void a(String paramString)
  {
    if (!jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.contains(paramString)) {
      jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(paramString);
    }
  }
  
  public static void b()
  {
    try
    {
      Object localObject = new File(BaseApplicationImpl.a().getApplicationContext().getFilesDir(), ClubContentJsonTask.i.b);
      if (((File)localObject).exists())
      {
        localObject = new JSONObject(FileUtils.a((File)localObject));
        if (((JSONObject)localObject).has("offinePkgReadFromDataCache")) {
          jdField_b_of_type_Boolean = ((JSONObject)localObject).getBoolean("offinePkgReadFromDataCache");
        }
      }
      if (!jdField_b_of_type_Boolean) {
        QLog.w("OfflineWebResManager", 1, "can not use offline /data cache mode!");
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("OfflineWebResManager", 2, "parse offline globle config error!", localException);
        }
      }
    }
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("OfflineWebResManager", 2, "now begin check cache size!");
    }
    File localFile1 = new File(BaseApplicationImpl.getContext().getFilesDir(), "WebOfflineRes");
    if ((!localFile1.exists()) || (!localFile1.isDirectory()))
    {
      break label44;
      break label44;
      break label44;
      break label44;
    }
    label44:
    while (!this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.d(OfflineWebRes.class.getSimpleName())) {
      return;
    }
    for (;;)
    {
      int j;
      int i;
      try
      {
        localObject1 = localFile1.listFiles();
        if ((localObject1 == null) || (localObject1.length == 0)) {
          break label44;
        }
        j = localObject1.length;
        i = 0;
        l1 = 0L;
        if (i < j)
        {
          localObject2 = localObject1[i];
          if (!((File)localObject2).isDirectory()) {
            l1 += ((File)localObject2).length();
          } else {
            ((File)localObject2).delete();
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      if (l1 < 4194304.0D)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("OfflineWebResManager", 2, "now /data cache size :" + l1);
        return;
      }
      OfflineWebRes localOfflineWebRes;
      File localFile2;
      if ((l1 >= 4194304.0D) && (l1 < 5242880L))
      {
        if (QLog.isColorLevel()) {
          QLog.i("OfflineWebResManager", 2, "cache data size exceed threshold value ");
        }
        localObject1 = "select * from " + OfflineWebRes.class.getSimpleName() + " where hitcount=1 limit 100";
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(OfflineWebRes.class, (String)localObject1, null);
        if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
          break;
        }
        localObject1 = new StringBuilder(((List)localObject2).size() * 64);
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localOfflineWebRes = (OfflineWebRes)((Iterator)localObject2).next();
          localFile2 = new File(localException, localOfflineWebRes.hashName);
          if (localFile2.exists())
          {
            if (QLog.isColorLevel()) {
              ((StringBuilder)localObject1).append("delete file: ").append(localFile2.getPath()).append("\n");
            }
            localFile2.delete();
          }
          this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localOfflineWebRes);
        }
        if ((!QLog.isColorLevel()) || (TextUtils.isEmpty(((StringBuilder)localObject1).toString()))) {
          break;
        }
        QLog.i("OfflineWebResManager", 2, ((StringBuilder)localObject1).toString());
        return;
      }
      long l2 = (l1 - 4194304.0D);
      if (QLog.isColorLevel()) {
        QLog.i("OfflineWebResManager", 2, "cache data size exceed cache max value " + l2);
      }
      Object localObject1 = "select * from " + OfflineWebRes.class.getSimpleName() + " order by hitcount";
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(OfflineWebRes.class, (String)localObject1, null);
      localObject1 = new StringBuilder("");
      long l1 = l2;
      if (localObject2 != null)
      {
        l1 = l2;
        if (((List)localObject2).size() > 0)
        {
          localObject2 = ((List)localObject2).iterator();
          l1 = l2;
          if (!((Iterator)localObject2).hasNext()) {
            break label760;
          }
          localOfflineWebRes = (OfflineWebRes)((Iterator)localObject2).next();
          if (l1 > 0L) {
            break label653;
          }
        }
      }
      label653:
      label760:
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("OfflineWebResManager", 2, ((StringBuilder)localObject1).toString());
        }
        if (l1 <= 0L) {
          break;
        }
        QLog.w("OfflineWebResManager", 1, "cache data size still exceed cache max value " + l1 + ", now delete folder and database!");
        File[] arrayOfFile = localException.listFiles();
        if ((arrayOfFile == null) || (arrayOfFile.length == 0)) {
          break;
        }
        j = arrayOfFile.length;
        i = 0;
        for (;;)
        {
          if (i < j)
          {
            arrayOfFile[i].delete();
            i += 1;
            continue;
            localFile2 = new File(arrayOfFile, localOfflineWebRes.hashName);
            l2 = l1;
            if (localFile2.exists())
            {
              ((StringBuilder)localObject1).append("delete file: " + localFile2.getPath() + "\n");
              l2 = l1 - localFile2.length();
              localFile2.delete();
            }
            this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localOfflineWebRes);
            l1 = l2;
            break;
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(OfflineWebRes.class.getSimpleName());
        return;
      }
      i += 1;
    }
  }
  
  private void c(String paramString)
  {
    long l = System.currentTimeMillis();
    Object localObject1 = null;
    Object localObject3;
    try
    {
      localObject3 = Uri.parse(paramString).getQueryParameter("_bid");
      Object localObject2 = localObject3;
      localObject1 = localObject3;
      if (TextUtils.isEmpty((CharSequence)localObject3))
      {
        localObject1 = localObject3;
        localObject2 = this.d;
      }
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        return;
      }
      localObject1 = localObject2;
      localObject3 = HtmlOffline.a((String)localObject2);
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject3)) {
        return;
      }
      localObject1 = localObject2;
      localObject3 = (String)localObject3 + (String)localObject2;
      localObject1 = localObject2;
      if (!new File((String)localObject3).exists())
      {
        localObject1 = localObject2;
        b((String)localObject2);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("OfflineWebResManager", 1, "add offline res error! " + paramString);
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        b((String)localObject1);
      }
      localException.printStackTrace();
      return;
    }
    localObject1 = localException;
    Object localObject4 = HtmlOffline.g(paramString);
    localObject1 = localException;
    if (!TextUtils.isEmpty((CharSequence)localObject4))
    {
      localObject1 = localException;
      if (HtmlOffline.a != null)
      {
        localObject1 = localException;
        if (HtmlOffline.a.containsKey(localException))
        {
          localObject1 = localException;
          localObject3 = (String)HtmlOffline.a.get(localException);
        }
      }
      for (;;)
      {
        localObject1 = localException;
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          break;
        }
        localObject1 = localException;
        b(localException);
        return;
        localObject1 = localException;
        localObject5 = new BufferedInputStream(new FileInputStream((String)localObject3 + "/verify.json"));
        localObject1 = localException;
        localObject3 = OfflineSecurity.a((BufferedInputStream)localObject5);
        localObject1 = localException;
        ((BufferedInputStream)localObject5).close();
        localObject1 = localException;
        HtmlOffline.a.put(localException, localObject3);
      }
      localObject1 = localException;
      Object localObject5 = new JSONObject((String)localObject3).optString((String)localObject4);
      localObject1 = localException;
      if (!TextUtils.isEmpty((CharSequence)localObject5))
      {
        localObject1 = localException;
        localObject4 = a((String)localObject5);
        localObject3 = localObject4;
        if (localObject4 == null)
        {
          localObject1 = localException;
          localObject4 = HtmlOffline.g(paramString);
          localObject1 = localException;
          a((String)localObject4, localException);
          localObject1 = localException;
          localObject3 = new OfflineWebRes();
          localObject1 = localException;
          ((OfflineWebRes)localObject3).fileName = ((String)localObject4);
          localObject1 = localException;
          localObject4 = String.valueOf(((OfflineWebRes)localObject3).fileName + String.valueOf(System.currentTimeMillis()) + (String)localObject5);
          localObject1 = localException;
          MessageDigest localMessageDigest = MessageDigest.getInstance("SHA1");
          localObject1 = localException;
          localMessageDigest.update(((String)localObject4).getBytes());
          localObject1 = localException;
          localObject4 = OfflineSecurity.a(localMessageDigest.digest());
          localObject1 = localException;
          if (QLog.isColorLevel())
          {
            localObject1 = localException;
            QLog.i("OfflineWebResManager", 2, "now filePath " + ((OfflineWebRes)localObject3).fileName + ", hashName: " + (String)localObject4);
          }
          localObject1 = localException;
          ((OfflineWebRes)localObject3).hashName = ((String)localObject4);
          localObject1 = localException;
          ((OfflineWebRes)localObject3).md5 = ((String)localObject5);
          localObject1 = localException;
          ((OfflineWebRes)localObject3).bid = localException;
        }
        localObject1 = localException;
        a((OfflineWebRes)localObject3);
        localObject1 = localException;
        if (QLog.isColorLevel())
        {
          localObject1 = localException;
          QLog.i("OfflineWebResManager", 2, "add or update url " + ((OfflineWebRes)localObject3).fileName + ", cost: " + (System.currentTimeMillis() - l));
        }
      }
      else
      {
        localObject1 = localException;
        localObject3 = HtmlOffline.g(paramString);
        localObject1 = localException;
        if (QLog.isColorLevel())
        {
          localObject1 = localException;
          QLog.i("OfflineWebResManager", 2, "now md5 not exits, fileName:" + (String)localObject3);
        }
        localObject1 = localException;
        a((String)localObject3, localException);
      }
    }
  }
  
  public OfflineWebRes a(String paramString)
  {
    if (!jdField_b_of_type_Boolean) {}
    while (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (OfflineWebRes)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(OfflineWebRes.class, paramString);
  }
  
  public void a()
  {
    BaseApplicationImpl.a();
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("OfflineWebResManager", 4);
    long l = localSharedPreferences.getLong("Last_Check_Cache", 0L);
    if (System.currentTimeMillis() - l < 86400000L) {}
    for (int i = 1; i != 0; i = 0) {
      return;
    }
    ThreadManager.a(new jhr(this, localSharedPreferences), 5, null, false);
  }
  
  public void a(int paramInt)
  {
    if (!jdField_b_of_type_Boolean) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("OfflineWebResManager", 2, "now check update url, deley: " + paramInt);
    }
    ThreadManager.a(new jhs(this, paramInt), 5, null, false);
  }
  
  public void a(OfflineWebRes paramOfflineWebRes)
  {
    if (paramOfflineWebRes == null) {}
    Object localObject1;
    do
    {
      do
      {
        return;
        if (paramOfflineWebRes.getStatus() == 1000)
        {
          localObject1 = HtmlOffline.a(paramOfflineWebRes.bid);
          Object localObject2 = (String)localObject1 + paramOfflineWebRes.bid + "/" + paramOfflineWebRes.fileName;
          localObject1 = new File((String)localObject2);
          if (((File)localObject1).exists())
          {
            localObject2 = new File(BaseApplicationImpl.getContext().getFilesDir(), "WebOfflineRes");
            if (!((File)localObject2).exists()) {
              ((File)localObject2).mkdirs();
            }
            FileUtils.a((File)localObject1, new File((File)localObject2, paramOfflineWebRes.hashName));
            if (QLog.isColorLevel()) {
              QLog.i("OfflineWebResManager", 2, "now copy " + paramOfflineWebRes.fileName + " into /data");
            }
            this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramOfflineWebRes);
            return;
          }
          QLog.e("OfflineWebResManager", 2, "bid not exit! " + (String)localObject2);
          return;
        }
      } while ((paramOfflineWebRes.getStatus() != 1001) && (paramOfflineWebRes.getStatus() != 1002));
      localObject1 = new File(BaseApplicationImpl.getContext().getFilesDir(), "WebOfflineRes");
    } while (!((File)localObject1).exists());
    if (new File((File)localObject1, paramOfflineWebRes.hashName).exists())
    {
      paramOfflineWebRes.hitCount += 1;
      if (QLog.isColorLevel()) {
        QLog.i("OfflineWebResManager", 2, "fileName: " + paramOfflineWebRes.bid + "/" + paramOfflineWebRes.fileName + ", hitcount: " + paramOfflineWebRes.hitCount);
      }
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramOfflineWebRes);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramOfflineWebRes);
  }
  
  public void a(String paramString1, String paramString2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(OfflineWebRes.class, false, "bid= ? and fileName= ?", new String[] { paramString2, paramString1 }, null, null, null, null);
    if ((localObject == null) || (((List)localObject).size() == 0)) {}
    for (;;)
    {
      return;
      File localFile1 = new File(BaseApplicationImpl.getContext().getFilesDir(), "WebOfflineRes");
      if (localFile1.exists())
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          OfflineWebRes localOfflineWebRes = (OfflineWebRes)((Iterator)localObject).next();
          File localFile2 = new File(localFile1, localOfflineWebRes.hashName);
          if (localFile2.exists()) {
            localFile2.delete();
          }
          this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(localOfflineWebRes, "bid= ? and fileName= ?", new String[] { paramString2, paramString1 });
          if (QLog.isColorLevel()) {
            QLog.i("OfflineWebResManager", 2, "now delete  record for bid: " + paramString2 + ", fileName: " + paramString1);
          }
        }
      }
    }
  }
  
  public void b(String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(OfflineWebRes.class, false, "bid=?", new String[] { paramString }, null, null, null, null);
    if ((localObject == null) || (((List)localObject).size() == 0)) {}
    for (;;)
    {
      return;
      File localFile1 = new File(BaseApplicationImpl.getContext().getFilesDir(), "WebOfflineRes");
      if (localFile1.exists())
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          OfflineWebRes localOfflineWebRes = (OfflineWebRes)((Iterator)localObject).next();
          File localFile2 = new File(localFile1, localOfflineWebRes.hashName);
          if (localFile2.exists()) {
            localFile2.delete();
          }
          this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(localOfflineWebRes, "bid=?", new String[] { paramString });
          if (QLog.isColorLevel()) {
            QLog.i("OfflineWebResManager", 2, "now delete all record of bid: " + paramString);
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\webviewplugin\OfflineWebResManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */