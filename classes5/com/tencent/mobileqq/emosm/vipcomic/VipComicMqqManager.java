package com.tencent.mobileqq.emosm.vipcomic;

import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.VipComicFavorEmoStructMsgInfo;
import com.tencent.mobileqq.emosm.favroaming.FavroamingDBManager;
import com.tencent.mobileqq.emosm.favroaming.IPicDownloadListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.pb.mqqcomic.MqqComicPb.ComicFavorEmotIcons;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.manager.Manager;
import rhq;

public class VipComicMqqManager
  implements Manager
{
  private static final String jdField_a_of_type_JavaLangString = "VipComicMqqManager";
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  VipComicMqqHandler jdField_a_of_type_ComTencentMobileqqEmosmVipcomicVipComicMqqHandler;
  EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  
  public VipComicMqqManager(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.a().createEntityManager();
    this.jdField_a_of_type_ComTencentMobileqqEmosmVipcomicVipComicMqqHandler = ((VipComicMqqHandler)paramQQAppInterface.a(80));
  }
  
  public VipComicFavorEmoStructMsgInfo a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a())) {
      return (VipComicFavorEmoStructMsgInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(VipComicFavorEmoStructMsgInfo.class, new String[] { paramString.toUpperCase() });
    }
    return null;
  }
  
  public String a()
  {
    Object localObject = b();
    StringBuilder localStringBuilder = new StringBuilder();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        localStringBuilder.append(str + "_");
      }
    }
    if (localStringBuilder.length() > 0) {
      return localStringBuilder.substring(0, localStringBuilder.length() - 1);
    }
    return "";
  }
  
  public String a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return AppConstants.bs + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "-" + paramString.toUpperCase() + ".jpg";
    }
    return AppConstants.bs + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "-" + paramString + ".jpg";
  }
  
  public List a()
  {
    List localList = null;
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a()) {
      localList = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(VipComicFavorEmoStructMsgInfo.class, true, null, null, null, null, null, null);
    }
    return localList;
  }
  
  public List a(int paramInt)
  {
    List localList = null;
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a()) {
      localList = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(VipComicFavorEmoStructMsgInfo.class, true, "status = ?", new String[] { String.valueOf(paramInt) }, null, null, null, null);
    }
    return localList;
  }
  
  public List a(List paramList)
  {
    List localList = ((FavroamingDBManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(148)).a();
    if ((localList == null) || (localList.size() == 0)) {
      return new ArrayList();
    }
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      CustomEmotionData localCustomEmotionData = (CustomEmotionData)localIterator.next();
      if ((!"needDel".equals(localCustomEmotionData.RomaingType)) && (paramList != null)) {
        paramList.add(localCustomEmotionData);
      }
    }
    return localList;
  }
  
  public Map a()
  {
    Object localObject2 = a();
    Iterator localIterator = null;
    Object localObject1 = localIterator;
    if (localObject2 != null)
    {
      localObject1 = localIterator;
      if (((List)localObject2).size() > 0)
      {
        localObject1 = new HashMap(((List)localObject2).size());
        localIterator = ((List)localObject2).iterator();
        while (localIterator.hasNext())
        {
          localObject2 = (VipComicFavorEmoStructMsgInfo)localIterator.next();
          if (!TextUtils.isEmpty(((VipComicFavorEmoStructMsgInfo)localObject2).picMd5)) {
            ((Map)localObject1).put(((VipComicFavorEmoStructMsgInfo)localObject2).picMd5.toUpperCase(), localObject2);
          }
        }
      }
    }
    return (Map)localObject1;
  }
  
  public void a()
  {
    List localList = a(1);
    a(localList, false);
    if (QLog.isColorLevel()) {
      QLog.i("VipComicMqqManager", 2, "uploadInitComicEmoStructMsgInfo , comicFavorEmoStructMsgInfoList = " + localList);
    }
  }
  
  public void a(Context paramContext, List paramList, Map paramMap, IPicDownloadListener paramIPicDownloadListener)
  {
    if ((paramContext == null) || (paramList == null) || (paramList.isEmpty()) || (paramMap == null) || (paramMap.isEmpty())) {
      if (paramIPicDownloadListener != null) {
        paramIPicDownloadListener.onDone(new ArrayList(), paramList);
      }
    }
    label169:
    label295:
    label333:
    label587:
    do
    {
      EntityManager localEntityManager;
      do
      {
        return;
        localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
        if (!NetworkUtil.h(paramContext)) {
          break label587;
        }
        paramContext = ((DownloaderFactory)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46)).a(1);
        if (paramContext != null) {
          break;
        }
      } while (paramIPicDownloadListener == null);
      paramIPicDownloadListener.onDone(new ArrayList(), paramList);
      return;
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      AtomicInteger localAtomicInteger1 = new AtomicInteger(paramList.size());
      AtomicInteger localAtomicInteger2 = new AtomicInteger(0);
      FavroamingDBManager localFavroamingDBManager = (FavroamingDBManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(148);
      int i = 0;
      CustomEmotionData localCustomEmotionData;
      Object localObject;
      if (i < paramList.size())
      {
        localCustomEmotionData = (CustomEmotionData)paramList.get(i);
        localObject = (VipComicFavorEmoStructMsgInfo)paramMap.get(localCustomEmotionData.md5);
        if (!TextUtils.isEmpty(localCustomEmotionData.url)) {
          break label295;
        }
        localArrayList2.add(localCustomEmotionData);
        localFavroamingDBManager.a(localCustomEmotionData);
        localEntityManager.b((Entity)localObject);
        localAtomicInteger1.decrementAndGet();
        if (paramIPicDownloadListener != null) {
          paramIPicDownloadListener.onFileDone(localCustomEmotionData, false);
        }
      }
      for (;;)
      {
        if ((localAtomicInteger1.get() == 0) && (paramIPicDownloadListener != null)) {
          paramIPicDownloadListener.onDone(localArrayList1, localArrayList2);
        }
        for (;;)
        {
          i += 1;
          break label169;
          break;
          if (paramContext.a(localCustomEmotionData.url) == null) {
            break label333;
          }
          localFavroamingDBManager.a(localCustomEmotionData);
          localEntityManager.b((Entity)localObject);
          localAtomicInteger1.decrementAndGet();
        }
        File localFile = new File(a(localCustomEmotionData.md5));
        if (localFile.exists())
        {
          localAtomicInteger1.decrementAndGet();
          localCustomEmotionData.emoPath = localFile.getAbsolutePath();
          if ("needDownload".equals(localCustomEmotionData.RomaingType)) {
            localCustomEmotionData.RomaingType = "isUpdate";
          }
          if ((QLog.isColorLevel()) && (!TextUtils.isEmpty(localCustomEmotionData.emoPath)))
          {
            localObject = SecUtil.getFileMd5(localCustomEmotionData.emoPath);
            if (!localCustomEmotionData.md5.equals(localObject)) {
              QLog.i("VipComicMqqManager", 2, "init = " + localCustomEmotionData.md5 + " , compute = " + (String)localObject);
            }
          }
          localFavroamingDBManager.b(localCustomEmotionData);
          localArrayList1.add(localCustomEmotionData);
          if (paramIPicDownloadListener != null) {
            paramIPicDownloadListener.onFileDone(localCustomEmotionData, true);
          }
        }
        else
        {
          DownloadTask localDownloadTask = new DownloadTask(localCustomEmotionData.url, localFile);
          localDownloadTask.n = true;
          localDownloadTask.f = "comic_emoticon";
          localDownloadTask.A = 3;
          paramContext.a(localDownloadTask, new rhq(this, localFile, localCustomEmotionData, localFavroamingDBManager, localArrayList1, paramIPicDownloadListener, localArrayList2, localEntityManager, (VipComicFavorEmoStructMsgInfo)localObject, localAtomicInteger2, localAtomicInteger1), null);
        }
      }
    } while (paramIPicDownloadListener == null);
    paramIPicDownloadListener.onDone(new ArrayList(), paramList);
  }
  
  /* Error */
  public void a(List paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 28	com/tencent/mobileqq/emosm/vipcomic/VipComicMqqManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   4: invokevirtual 59	com/tencent/mobileqq/persistence/EntityManager:a	()Z
    //   7: ifeq +74 -> 81
    //   10: aload_1
    //   11: ifnull +70 -> 81
    //   14: aload_1
    //   15: invokeinterface 83 1 0
    //   20: ifle +61 -> 81
    //   23: aload_0
    //   24: getfield 28	com/tencent/mobileqq/emosm/vipcomic/VipComicMqqManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   27: invokevirtual 316	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   30: invokevirtual 320	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   33: aload_1
    //   34: invokeinterface 87 1 0
    //   39: astore_1
    //   40: aload_1
    //   41: invokeinterface 92 1 0
    //   46: ifeq +36 -> 82
    //   49: aload_0
    //   50: aload_1
    //   51: invokeinterface 96 1 0
    //   56: checkcast 61	com/tencent/mobileqq/data/VipComicFavorEmoStructMsgInfo
    //   59: invokevirtual 323	com/tencent/mobileqq/emosm/vipcomic/VipComicMqqManager:a	(Lcom/tencent/mobileqq/data/VipComicFavorEmoStructMsgInfo;)Z
    //   62: pop
    //   63: goto -23 -> 40
    //   66: astore_1
    //   67: aload_1
    //   68: invokevirtual 326	java/lang/Exception:printStackTrace	()V
    //   71: aload_0
    //   72: getfield 28	com/tencent/mobileqq/emosm/vipcomic/VipComicMqqManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   75: invokevirtual 316	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   78: invokevirtual 328	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   81: return
    //   82: aload_0
    //   83: getfield 28	com/tencent/mobileqq/emosm/vipcomic/VipComicMqqManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   86: invokevirtual 316	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   89: invokevirtual 331	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   92: aload_0
    //   93: getfield 28	com/tencent/mobileqq/emosm/vipcomic/VipComicMqqManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   96: invokevirtual 316	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   99: invokevirtual 328	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   102: return
    //   103: astore_1
    //   104: aload_0
    //   105: getfield 28	com/tencent/mobileqq/emosm/vipcomic/VipComicMqqManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   108: invokevirtual 316	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   111: invokevirtual 328	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   114: aload_1
    //   115: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	this	VipComicMqqManager
    //   0	116	1	paramList	List
    // Exception table:
    //   from	to	target	type
    //   23	40	66	java/lang/Exception
    //   40	63	66	java/lang/Exception
    //   82	92	66	java/lang/Exception
    //   23	40	103	finally
    //   40	63	103	finally
    //   67	71	103	finally
    //   82	92	103	finally
  }
  
  public void a(List paramList, boolean paramBoolean)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      if (paramBoolean) {
        a(paramList);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqEmosmVipcomicVipComicMqqHandler != null)
      {
        ArrayList localArrayList = new ArrayList(paramList.size());
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          VipComicFavorEmoStructMsgInfo localVipComicFavorEmoStructMsgInfo = (VipComicFavorEmoStructMsgInfo)localIterator.next();
          MqqComicPb.ComicFavorEmotIcons localComicFavorEmotIcons = new MqqComicPb.ComicFavorEmotIcons();
          localComicFavorEmotIcons.md5.set(localVipComicFavorEmoStructMsgInfo.picMd5);
          localComicFavorEmotIcons.info.set(localVipComicFavorEmoStructMsgInfo.actionData);
          localArrayList.add(localComicFavorEmotIcons);
        }
        this.jdField_a_of_type_ComTencentMobileqqEmosmVipcomicVipComicMqqHandler.a(localArrayList);
        if (QLog.isColorLevel()) {
          QLog.i("VipComicMqqManager", 2, "setMyComicEmoticon,isNeedSaveDb =" + paramBoolean + " , favorEmoStructMsgInfoList = " + paramList);
        }
      }
    }
  }
  
  public boolean a(CustomEmotionData paramCustomEmotionData)
  {
    return (paramCustomEmotionData != null) && (!TextUtils.isEmpty(paramCustomEmotionData.md5)) && (a(paramCustomEmotionData.md5) != null);
  }
  
  public boolean a(VipComicFavorEmoStructMsgInfo paramVipComicFavorEmoStructMsgInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramVipComicFavorEmoStructMsgInfo != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a())
        {
          bool1 = bool2;
          if (!TextUtils.isEmpty(paramVipComicFavorEmoStructMsgInfo.picMd5))
          {
            if (paramVipComicFavorEmoStructMsgInfo.getStatus() != 1000) {
              paramVipComicFavorEmoStructMsgInfo.setStatus(1000);
            }
            paramVipComicFavorEmoStructMsgInfo.picMd5 = paramVipComicFavorEmoStructMsgInfo.picMd5.toUpperCase();
            this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramVipComicFavorEmoStructMsgInfo);
            bool1 = bool2;
            if (paramVipComicFavorEmoStructMsgInfo.getStatus() == 1001) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public boolean a(List paramList)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a()) && (paramList != null) && (paramList.size() > 0)) {
      try
      {
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("status", Integer.valueOf(2));
        String[] arrayOfString = new String[paramList.size()];
        StringBuilder localStringBuilder = new StringBuilder(" ( ");
        int i = 0;
        while (i < paramList.size())
        {
          localStringBuilder.append(" ? ");
          if (i != paramList.size() - 1) {
            localStringBuilder.append(",");
          }
          arrayOfString[i] = SecurityUtile.b(((String)paramList.get(i)).toUpperCase());
          i += 1;
        }
        localStringBuilder.append(" ) ");
        paramList = "picMd5 in " + localStringBuilder.toString();
        boolean bool = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(VipComicFavorEmoStructMsgInfo.class.getSimpleName(), localContentValues, paramList, arrayOfString);
        return bool;
      }
      catch (Exception paramList)
      {
        paramList.printStackTrace();
      }
    }
    return false;
  }
  
  public List b()
  {
    Object localObject1 = new ArrayList();
    a((List)localObject1);
    Map localMap = a();
    ArrayList localArrayList = new ArrayList();
    if (localMap != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (CustomEmotionData)((Iterator)localObject1).next();
        if (!TextUtils.isEmpty(((CustomEmotionData)localObject2).md5))
        {
          localObject2 = ((CustomEmotionData)localObject2).md5.toUpperCase();
          if (localMap.get(localObject2) != null) {
            localArrayList.add(localObject2);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public void b(List paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      Map localMap = a();
      if ((localMap != null) && (localMap.size() > 0))
      {
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          String str = ((String)localIterator.next()).toUpperCase();
          if (localMap.get(str) != null) {
            localArrayList.add(str);
          }
        }
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqEmosmVipcomicVipComicMqqHandler != null) && (localArrayList.size() > 0))
      {
        this.jdField_a_of_type_ComTencentMobileqqEmosmVipcomicVipComicMqqHandler.b(localArrayList);
        if (QLog.isColorLevel()) {
          QLog.i("VipComicMqqManager", 2, "delComicStructMsgInfo , delList = " + paramList);
        }
      }
    }
  }
  
  public boolean b(VipComicFavorEmoStructMsgInfo paramVipComicFavorEmoStructMsgInfo)
  {
    String str = VipComicFavorEmoStructMsgInfo.class.getSimpleName();
    if ((paramVipComicFavorEmoStructMsgInfo != null) && (!TextUtils.isEmpty(str)) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a())) {
      return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramVipComicFavorEmoStructMsgInfo);
    }
    return false;
  }
  
  public boolean c(VipComicFavorEmoStructMsgInfo paramVipComicFavorEmoStructMsgInfo)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a()) && (paramVipComicFavorEmoStructMsgInfo != null) && (!TextUtils.isEmpty(paramVipComicFavorEmoStructMsgInfo.picMd5)))
    {
      paramVipComicFavorEmoStructMsgInfo = SecurityUtile.b(paramVipComicFavorEmoStructMsgInfo.picMd5.toUpperCase());
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a("DELETE FROM VipComicFavorEmoStructMsgInfo WHERE picMd5 = ?", new String[] { paramVipComicFavorEmoStructMsgInfo });
      return true;
    }
    return false;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_ComTencentMobileqqEmosmVipcomicVipComicMqqHandler = null;
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\emosm\vipcomic\VipComicMqqManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */