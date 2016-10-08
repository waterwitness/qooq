package cooperation.photoplus;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import cooperation.photoplus.sticker.Sticker;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import ydj;
import ydk;

public class PhotoPlusManager
  implements Manager
{
  public static final long a = 40960L;
  public static final String a = "PhotoPlusManager";
  public static final String b = AppConstants.bj + "PhotoPlus/";
  public static final String c = ".zip";
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private MqqWeakReferenceHandler jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler;
  private List jdField_a_of_type_JavaUtilList;
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private volatile boolean jdField_a_of_type_Boolean;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public PhotoPlusManager(AppInterface paramAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoPlusManager", 2, "[constructor]");
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    paramAppInterface = this.jdField_a_of_type_ComTencentCommonAppAppInterface.a().createEntityManager();
    this.jdField_a_of_type_JavaUtilList = paramAppInterface.a(Sticker.class, new Sticker().getTableName(), false, null, null, null, null, null, null);
    paramAppInterface.a();
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler = new MqqWeakReferenceHandler(ThreadManager.a(), null);
    a(false);
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    DownloadTask localDownloadTask = (DownloadTask)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString2);
    if (localDownloadTask != null)
    {
      if ((localDownloadTask.a() == 2) || (localDownloadTask.a() == 3))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoPlusManager", 2, "[download] duplicated " + paramString2);
        }
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PhotoPlusManager", 2, "[download] task status error, cancel it " + paramString2);
      }
      localDownloadTask.a(true);
    }
    localDownloadTask = new DownloadTask(paramString1, new File(paramString2));
    localDownloadTask.l = true;
    DownloaderInterface localDownloaderInterface = ((DownloaderFactory)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(46)).a(1);
    if (QLog.isColorLevel()) {
      QLog.d("PhotoPlusManager", 2, "[download] startDownload: " + paramString1 + " path=" + paramString2);
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString2, localDownloadTask);
    localDownloaderInterface.a(localDownloadTask, new ydj(this, paramString2, paramString1, paramString3), null);
  }
  
  private void a(List paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoPlusManager", 2, "[deleteOldResources] start");
    }
    Object localObject1 = new File(b);
    if (((File)localObject1).exists())
    {
      if (!((File)localObject1).isDirectory()) {
        break label458;
      }
      if (paramList != null) {
        break label50;
      }
      FileUtils.a(b);
    }
    label50:
    do
    {
      return;
      localObject1 = ((File)localObject1).listFiles();
    } while (localObject1 == null);
    int k = localObject1.length;
    int i = 0;
    label66:
    Object localObject2;
    if (i < k)
    {
      localObject2 = localObject1[i];
      if (!((File)localObject2).isDirectory()) {
        break label416;
      }
      String str = ((File)localObject2).getName();
      Object localObject3 = paramList.iterator();
      for (;;)
      {
        if (((Iterator)localObject3).hasNext())
        {
          Sticker localSticker = (Sticker)((Iterator)localObject3).next();
          if (str.equals(localSticker.id))
          {
            int m = localSticker.version;
            str = localSticker.version + ".zip";
            localObject3 = ((File)localObject2).listFiles();
            if (localObject3 != null)
            {
              int n = localObject3.length;
              j = 0;
              if (j < n)
              {
                localSticker = localObject3[j];
                if (localSticker.isDirectory()) {
                  if (!localSticker.getName().equals(String.valueOf(m)))
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("PhotoPlusManager", 2, "[updateStickerResource] delete old dir: " + ((File)localObject2).getName() + File.separator + localSticker.getName());
                    }
                    FileUtils.a(localSticker.getAbsolutePath());
                  }
                }
                for (;;)
                {
                  j += 1;
                  break;
                  if (!localSticker.getName().equals(str))
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("PhotoPlusManager", 2, "[updateStickerResource] delete old file: " + ((File)localObject2).getName() + File.separator + localSticker.getName());
                    }
                    localSticker.delete();
                  }
                }
              }
            }
          }
        }
      }
    }
    for (int j = 1;; j = 0)
    {
      if (j == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoPlusManager", 2, "[updateStickerResource] delete old dir: " + ((File)localObject2).getName());
        }
        FileUtils.a(((File)localObject2).getAbsolutePath());
      }
      for (;;)
      {
        i += 1;
        break label66;
        break;
        label416:
        if (QLog.isColorLevel()) {
          QLog.d("PhotoPlusManager", 2, "[updateStickerResource] delete error file: " + ((File)localObject2).getName());
        }
        ((File)localObject2).delete();
      }
      label458:
      if (QLog.isColorLevel()) {
        QLog.d("PhotoPlusManager", 2, "[updateStickerResource] delete photo plus root directory");
      }
      ((File)localObject1).delete();
      return;
    }
  }
  
  public List a()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return null;
    }
    return new ArrayList(this.jdField_a_of_type_JavaUtilList);
  }
  
  public void a(String paramString)
  {
    String str = paramString.substring(0, paramString.indexOf(".zip")) + File.separator;
    try
    {
      FileUtils.a(paramString, str, false);
      if (QLog.isColorLevel()) {
        QLog.d("PhotoPlusManager", 2, "[unzip] success: " + paramString);
      }
      return;
    }
    catch (Exception localException)
    {
      do
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoPlusManager", 2, "[unzip]", localException);
        }
      } while (Utils.b() <= 40960L);
      FileUtils.d(paramString);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoPlusManager", 2, "[updateStickerResource] isDelete=" + paramBoolean);
    }
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.post(new ydk(this, this.jdField_a_of_type_JavaUtilList, paramBoolean));
  }
  
  /* Error */
  public boolean a(String paramString)
  {
    // Byte code:
    //   0: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +29 -> 32
    //   6: ldc 13
    //   8: iconst_2
    //   9: new 31	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 297
    //   19: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_1
    //   23: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokestatic 71	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   32: aload_0
    //   33: getfield 299	cooperation/photoplus/PhotoPlusManager:jdField_a_of_type_Boolean	Z
    //   36: ifeq +5 -> 41
    //   39: iconst_0
    //   40: ireturn
    //   41: aload_0
    //   42: aload_1
    //   43: invokestatic 303	cooperation/photoplus/sticker/Sticker:parse	(Ljava/lang/String;)Ljava/util/List;
    //   46: putfield 97	cooperation/photoplus/PhotoPlusManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   49: aload_0
    //   50: getfield 97	cooperation/photoplus/PhotoPlusManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   53: ifnonnull +40 -> 93
    //   56: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   59: ifeq +12 -> 71
    //   62: ldc 13
    //   64: iconst_2
    //   65: ldc_w 305
    //   68: invokestatic 71	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   71: iconst_1
    //   72: ireturn
    //   73: astore_1
    //   74: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   77: ifeq -28 -> 49
    //   80: ldc 13
    //   82: iconst_2
    //   83: ldc_w 307
    //   86: aload_1
    //   87: invokestatic 310	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   90: goto -41 -> 49
    //   93: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   96: ifeq +61 -> 157
    //   99: aload_0
    //   100: getfield 97	cooperation/photoplus/PhotoPlusManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   103: invokeinterface 199 1 0
    //   108: astore_1
    //   109: aload_1
    //   110: invokeinterface 204 1 0
    //   115: ifeq +42 -> 157
    //   118: aload_1
    //   119: invokeinterface 208 1 0
    //   124: checkcast 86	cooperation/photoplus/sticker/Sticker
    //   127: astore_2
    //   128: ldc 13
    //   130: iconst_2
    //   131: new 31	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   138: ldc_w 312
    //   141: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: aload_2
    //   145: invokevirtual 315	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   148: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokestatic 71	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   154: goto -45 -> 109
    //   157: aload_0
    //   158: getfield 73	cooperation/photoplus/PhotoPlusManager:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   161: invokevirtual 78	com/tencent/common/app/AppInterface:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   164: invokevirtual 84	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   167: astore_2
    //   168: aload_2
    //   169: invokevirtual 318	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   172: astore_1
    //   173: aload_1
    //   174: invokevirtual 321	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   177: aload_2
    //   178: ldc 86
    //   180: invokevirtual 324	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;)Z
    //   183: pop
    //   184: aload_0
    //   185: getfield 97	cooperation/photoplus/PhotoPlusManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   188: invokeinterface 199 1 0
    //   193: astore_3
    //   194: aload_3
    //   195: invokeinterface 204 1 0
    //   200: ifeq +51 -> 251
    //   203: aload_2
    //   204: aload_3
    //   205: invokeinterface 208 1 0
    //   210: checkcast 86	cooperation/photoplus/sticker/Sticker
    //   213: invokevirtual 327	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   216: goto -22 -> 194
    //   219: astore_3
    //   220: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   223: ifeq +13 -> 236
    //   226: ldc 13
    //   228: iconst_2
    //   229: ldc_w 329
    //   232: aload_3
    //   233: invokestatic 310	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   236: aload_1
    //   237: invokevirtual 331	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   240: aload_2
    //   241: invokevirtual 99	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   244: aload_0
    //   245: iconst_1
    //   246: invokevirtual 114	cooperation/photoplus/PhotoPlusManager:a	(Z)V
    //   249: iconst_1
    //   250: ireturn
    //   251: aload_1
    //   252: invokevirtual 333	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   255: aload_1
    //   256: invokevirtual 331	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   259: goto -19 -> 240
    //   262: astore_2
    //   263: aload_1
    //   264: invokevirtual 331	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   267: aload_2
    //   268: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	269	0	this	PhotoPlusManager
    //   0	269	1	paramString	String
    //   127	114	2	localObject1	Object
    //   262	6	2	localObject2	Object
    //   193	12	3	localIterator	Iterator
    //   219	14	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   41	49	73	org/json/JSONException
    //   173	194	219	java/lang/Exception
    //   194	216	219	java/lang/Exception
    //   251	255	219	java/lang/Exception
    //   173	194	262	finally
    //   194	216	262	finally
    //   220	236	262	finally
    //   251	255	262	finally
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void onDestroy() {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\photoplus\PhotoPlusManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */