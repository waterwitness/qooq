package com.tencent.mobileqq.filemanager.data;

import android.content.ContentValues;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.BaseProxy;
import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.util.FileCategoryUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.mobileqq.search.IContactSearchable;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import sax;
import say;
import saz;

public class FileManagerProxy
  extends BaseProxy
{
  public static final int a = 30;
  private static final String jdField_a_of_type_JavaLangString = "FileManagerProxy<FileAssistant>";
  SQLiteDatabase jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase;
  SQLiteOpenHelper jdField_a_of_type_ComTencentMobileqqAppSQLiteOpenHelper;
  List jdField_a_of_type_JavaUtilList;
  private Map jdField_a_of_type_JavaUtilMap;
  List b;
  List c;
  private List d;
  
  public FileManagerProxy(QQAppInterface paramQQAppInterface, ProxyManager paramProxyManager)
  {
    super(paramQQAppInterface, paramProxyManager);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilList = null;
    this.b = null;
    this.c = new ArrayList();
  }
  
  private ContentValues a(Entity paramEntity)
  {
    ContentValues localContentValues = new ContentValues();
    List localList = TableBuilder.a(paramEntity.getClass());
    int j = localList.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        Object localObject1 = (Field)localList.get(i);
        String str = ((Field)localObject1).getName();
        if (!((Field)localObject1).isAccessible()) {
          ((Field)localObject1).setAccessible(true);
        }
        try
        {
          localObject1 = ((Field)localObject1).get(paramEntity);
          if ((localObject1 instanceof Integer))
          {
            localContentValues.put(str, (Integer)localObject1);
            i += 1;
          }
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          for (;;)
          {
            localIllegalArgumentException.printStackTrace();
            Object localObject2 = null;
          }
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          for (;;)
          {
            localIllegalAccessException.printStackTrace();
            Object localObject3 = null;
            continue;
            if ((localObject3 instanceof Long)) {
              localContentValues.put(str, (Long)localObject3);
            } else if ((localObject3 instanceof String)) {
              localContentValues.put(str, (String)localObject3);
            } else if ((localObject3 instanceof byte[])) {
              localContentValues.put(str, (byte[])localObject3);
            } else if ((localObject3 instanceof Short)) {
              localContentValues.put(str, (Short)localObject3);
            } else if ((localObject3 instanceof Boolean)) {
              localContentValues.put(str, (Boolean)localObject3);
            } else if ((localObject3 instanceof Double)) {
              localContentValues.put(str, (Double)localObject3);
            } else if ((localObject3 instanceof Float)) {
              localContentValues.put(str, (Float)localObject3);
            } else if ((localObject3 instanceof Byte)) {
              localContentValues.put(str, (Byte)localObject3);
            }
          }
        }
      }
    }
    return localContentValues;
  }
  
  private boolean a(int paramInt)
  {
    for (;;)
    {
      boolean bool;
      FileManagerEntity localFileManagerEntity;
      try
      {
        if (this.d == null) {
          a();
        }
        int i = this.d.size();
        if (i == 0)
        {
          bool = false;
          return bool;
        }
        Object localObject1 = "select * from ( select * from " + FileManagerEntity.tableName() + " where srvTime <= " + String.valueOf(((FileManagerEntity)this.d.get(this.d.size() - 1)).srvTime) + " and " + " nSessionId != " + String.valueOf(((FileManagerEntity)this.d.get(this.d.size() - 1)).nSessionId) + "  order by srvTime desc limit " + paramInt + ") order by srvTime desc";
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager().a(FileManagerEntity.class, (String)localObject1, null);
        if (localObject1 == null)
        {
          bool = false;
          continue;
        }
        if (((List)localObject1).size() == 0)
        {
          bool = false;
          continue;
        }
        List localList = FileCategoryUtil.a(BaseApplicationImpl.getContext());
        Iterator localIterator1 = ((List)localObject1).iterator();
        if (!localIterator1.hasNext()) {
          break label417;
        }
        localFileManagerEntity = (FileManagerEntity)localIterator1.next();
        if ((localFileManagerEntity.nFileType == 5) && (localFileManagerEntity.getCloudType() == 3) && (!FileUtil.a(localFileManagerEntity.getFilePath())) && (localFileManagerEntity.strApkPackageName != null) && (localFileManagerEntity.strApkPackageName.length() > 0))
        {
          Iterator localIterator2 = localList.iterator();
          if (localIterator2.hasNext())
          {
            PackageInfo localPackageInfo = (PackageInfo)localIterator2.next();
            if (!localFileManagerEntity.strApkPackageName.equalsIgnoreCase(localPackageInfo.packageName)) {
              continue;
            }
            localFileManagerEntity.setFilePath(localPackageInfo.applicationInfo.publicSourceDir);
            continue;
          }
        }
        if (this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(localFileManagerEntity.nSessionId)) != null) {
          break label387;
        }
      }
      finally {}
      this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(localFileManagerEntity.nSessionId), localFileManagerEntity);
      label387:
      this.d.add(this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(localFileManagerEntity.nSessionId)));
      continue;
      label417:
      paramInt = ((List)localObject2).size();
      if (paramInt < 30) {
        bool = false;
      } else {
        bool = true;
      }
    }
  }
  
  public long a(int paramInt, long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    if (this.d == null) {
      a();
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(String.valueOf(paramLong3), paramInt);
    Object localObject2;
    int i;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("------->FileManager findUinSeqForCache :msgIsTroop:").append(paramInt).append(",peerUin:").append(FileManagerUtil.e(String.valueOf(paramLong3))).append(",list size:");
      if (localObject1 == null)
      {
        i = 0;
        QLog.i("FileManagerProxy<FileAssistant>", 2, i);
      }
    }
    else
    {
      if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
        break label251;
      }
      localObject1 = ((List)localObject1).iterator();
    }
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MessageRecord)((Iterator)localObject1).next();
        if ((((MessageRecord)localObject2).msgUid != 0L) && (((MessageRecord)localObject2).msgUid == paramLong4))
        {
          return ((MessageRecord)localObject2).uniseq;
          i = ((List)localObject1).size();
          break;
        }
        if ((Math.abs(((MessageRecord)localObject2).time - paramLong2) < 30L) && (((MessageRecord)localObject2).shmsgseq == paramLong1) && (((MessageRecord)localObject2).senderuin.equals(Long.valueOf(paramLong3))))
        {
          if (QLog.isColorLevel()) {
            QLog.d("FileManagerProxy<FileAssistant>", 2, "------->msgFilter-duplicated msg.");
          }
          return ((MessageRecord)localObject2).uniseq;
        }
      }
    }
    label251:
    localObject1 = this.d.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (FileManagerEntity)((Iterator)localObject1).next();
      if ((((FileManagerEntity)localObject2).peerType == paramInt) && (((FileManagerEntity)localObject2).msgSeq == paramLong1) && (((FileManagerEntity)localObject2).msgUid == paramLong4) && (((FileManagerEntity)localObject2).peerUin != null) && (((FileManagerEntity)localObject2).peerUin.equals(Long.valueOf(paramLong3)))) {
        return ((FileManagerEntity)localObject2).uniseq;
      }
    }
    return -1L;
  }
  
  /* Error */
  public FileManagerEntity a(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 138	com/tencent/mobileqq/filemanager/data/FileManagerProxy:d	Ljava/util/List;
    //   6: ifnonnull +7 -> 13
    //   9: aload_0
    //   10: invokevirtual 140	com/tencent/mobileqq/filemanager/data/FileManagerProxy:a	()V
    //   13: aload_0
    //   14: getfield 138	com/tencent/mobileqq/filemanager/data/FileManagerProxy:d	Ljava/util/List;
    //   17: invokeinterface 215 1 0
    //   22: astore 4
    //   24: aload 4
    //   26: invokeinterface 220 1 0
    //   31: ifeq +31 -> 62
    //   34: aload 4
    //   36: invokeinterface 224 1 0
    //   41: checkcast 151	com/tencent/mobileqq/filemanager/data/FileManagerEntity
    //   44: astore_3
    //   45: aload_3
    //   46: getfield 171	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   49: lstore 5
    //   51: lload 5
    //   53: lload_1
    //   54: lcmp
    //   55: ifne -31 -> 24
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_3
    //   61: areturn
    //   62: aload_0
    //   63: getfield 29	com/tencent/mobileqq/filemanager/data/FileManagerProxy:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   66: ifnull +47 -> 113
    //   69: aload_0
    //   70: getfield 29	com/tencent/mobileqq/filemanager/data/FileManagerProxy:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   73: invokeinterface 215 1 0
    //   78: astore 4
    //   80: aload 4
    //   82: invokeinterface 220 1 0
    //   87: ifeq +26 -> 113
    //   90: aload 4
    //   92: invokeinterface 224 1 0
    //   97: checkcast 151	com/tencent/mobileqq/filemanager/data/FileManagerEntity
    //   100: astore_3
    //   101: aload_3
    //   102: getfield 171	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   105: lload_1
    //   106: lcmp
    //   107: ifne -27 -> 80
    //   110: goto -52 -> 58
    //   113: aload_0
    //   114: getfield 267	com/tencent/mobileqq/filemanager/data/FileManagerProxy:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   117: lload_1
    //   118: invokestatic 270	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   121: invokeinterface 273 2 0
    //   126: checkcast 151	com/tencent/mobileqq/filemanager/data/FileManagerEntity
    //   129: astore_3
    //   130: goto -72 -> 58
    //   133: astore_3
    //   134: aload_0
    //   135: monitorexit
    //   136: aload_3
    //   137: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	this	FileManagerProxy
    //   0	138	1	paramLong	long
    //   44	86	3	localFileManagerEntity	FileManagerEntity
    //   133	4	3	localObject	Object
    //   22	69	4	localIterator	Iterator
    //   49	3	5	l	long
    // Exception table:
    //   from	to	target	type
    //   2	13	133	finally
    //   13	24	133	finally
    //   24	51	133	finally
    //   62	80	133	finally
    //   80	110	133	finally
    //   113	130	133	finally
  }
  
  public FileManagerEntity a(long paramLong, String paramString, int paramInt)
  {
    if ((paramLong != -1L) && (paramString != null)) {}
    for (;;)
    {
      FileManagerEntity localFileManagerEntity;
      try
      {
        int i = paramString.length();
        if (i == 0)
        {
          paramString = null;
          return paramString;
        }
        if (this.d == null) {
          a();
        }
        localIterator = this.d.iterator();
        if (localIterator.hasNext())
        {
          localFileManagerEntity = (FileManagerEntity)localIterator.next();
          if ((localFileManagerEntity.peerUin == null) || (localFileManagerEntity.uniseq != paramLong) || (!localFileManagerEntity.peerUin.equals(paramString))) {
            continue;
          }
          paramString = localFileManagerEntity;
          if (localFileManagerEntity.cloudType != 1) {
            continue;
          }
          paramString = localFileManagerEntity;
          if (!FileManagerUtil.a(localFileManagerEntity)) {
            continue;
          }
          localFileManagerEntity.status = 16;
          paramString = localFileManagerEntity;
          continue;
        }
        if (this.jdField_a_of_type_JavaUtilMap == null) {
          break label275;
        }
      }
      finally {}
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localFileManagerEntity = (FileManagerEntity)((Map.Entry)localIterator.next()).getValue();
          if ((localFileManagerEntity.uniseq == paramLong) && (localFileManagerEntity.peerUin != null) && (localFileManagerEntity.peerUin.equals(paramString)) && (paramInt == localFileManagerEntity.peerType))
          {
            paramString = localFileManagerEntity;
            if (localFileManagerEntity.cloudType != 1) {
              break;
            }
            paramString = localFileManagerEntity;
            if (!FileManagerUtil.a(localFileManagerEntity)) {
              break;
            }
            localFileManagerEntity.status = 16;
            paramString = localFileManagerEntity;
            break;
          }
        }
      }
      label275:
      paramString = null;
    }
  }
  
  /* Error */
  public FileManagerEntity a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 138	com/tencent/mobileqq/filemanager/data/FileManagerProxy:d	Ljava/util/List;
    //   6: ifnonnull +7 -> 13
    //   9: aload_0
    //   10: invokevirtual 140	com/tencent/mobileqq/filemanager/data/FileManagerProxy:a	()V
    //   13: aload_0
    //   14: getfield 138	com/tencent/mobileqq/filemanager/data/FileManagerProxy:d	Ljava/util/List;
    //   17: invokeinterface 215 1 0
    //   22: astore_3
    //   23: aload_3
    //   24: invokeinterface 220 1 0
    //   29: ifeq +41 -> 70
    //   32: aload_3
    //   33: invokeinterface 224 1 0
    //   38: checkcast 151	com/tencent/mobileqq/filemanager/data/FileManagerEntity
    //   41: astore_2
    //   42: aload_2
    //   43: invokevirtual 233	com/tencent/mobileqq/filemanager/data/FileManagerEntity:getFilePath	()Ljava/lang/String;
    //   46: ifnull -23 -> 23
    //   49: aload_2
    //   50: invokevirtual 233	com/tencent/mobileqq/filemanager/data/FileManagerEntity:getFilePath	()Ljava/lang/String;
    //   53: aload_1
    //   54: invokevirtual 252	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   57: istore 4
    //   59: iload 4
    //   61: ifeq -38 -> 23
    //   64: aload_2
    //   65: astore_1
    //   66: aload_0
    //   67: monitorexit
    //   68: aload_1
    //   69: areturn
    //   70: aload_0
    //   71: getfield 267	com/tencent/mobileqq/filemanager/data/FileManagerProxy:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   74: invokeinterface 382 1 0
    //   79: invokeinterface 373 1 0
    //   84: astore_3
    //   85: aload_3
    //   86: invokeinterface 220 1 0
    //   91: ifeq +54 -> 145
    //   94: aload_3
    //   95: invokeinterface 224 1 0
    //   100: checkcast 97	java/lang/Long
    //   103: astore_2
    //   104: aload_0
    //   105: getfield 267	com/tencent/mobileqq/filemanager/data/FileManagerProxy:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   108: aload_2
    //   109: invokeinterface 273 2 0
    //   114: checkcast 151	com/tencent/mobileqq/filemanager/data/FileManagerEntity
    //   117: astore_2
    //   118: aload_2
    //   119: invokevirtual 233	com/tencent/mobileqq/filemanager/data/FileManagerEntity:getFilePath	()Ljava/lang/String;
    //   122: ifnull -37 -> 85
    //   125: aload_2
    //   126: invokevirtual 233	com/tencent/mobileqq/filemanager/data/FileManagerEntity:getFilePath	()Ljava/lang/String;
    //   129: aload_1
    //   130: invokevirtual 252	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   133: istore 4
    //   135: iload 4
    //   137: ifeq -52 -> 85
    //   140: aload_2
    //   141: astore_1
    //   142: goto -76 -> 66
    //   145: aconst_null
    //   146: astore_1
    //   147: goto -81 -> 66
    //   150: astore_1
    //   151: aload_0
    //   152: monitorexit
    //   153: aload_1
    //   154: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	155	0	this	FileManagerProxy
    //   0	155	1	paramString	String
    //   41	100	2	localObject	Object
    //   22	73	3	localIterator	Iterator
    //   57	79	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	13	150	finally
    //   13	23	150	finally
    //   23	59	150	finally
    //   70	85	150	finally
    //   85	135	150	finally
  }
  
  public FileManagerEntity a(String paramString, long paramLong)
  {
    for (;;)
    {
      Iterator localIterator;
      FileManagerEntity localFileManagerEntity;
      try
      {
        if (this.d == null) {
          a();
        }
        if ((paramString == null) || (paramLong <= 0L))
        {
          localObject = null;
          return (FileManagerEntity)localObject;
        }
        localIterator = this.d.iterator();
        if (localIterator.hasNext())
        {
          localFileManagerEntity = (FileManagerEntity)localIterator.next();
          if (localFileManagerEntity.nOLfileSessionId == paramLong)
          {
            localObject = localFileManagerEntity;
            if (paramString.equalsIgnoreCase(localFileManagerEntity.peerUin)) {
              continue;
            }
          }
          if ((0L != localFileManagerEntity.nOLfileSessionId) || (paramLong != localFileManagerEntity.nSessionId) || (!paramString.equalsIgnoreCase(localFileManagerEntity.peerUin))) {
            continue;
          }
          localFileManagerEntity.nOLfileSessionId = paramLong;
          d(localFileManagerEntity);
          localObject = localFileManagerEntity;
          continue;
        }
        localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
      }
      finally {}
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localFileManagerEntity = (FileManagerEntity)localIterator.next();
          if (localFileManagerEntity.nOLfileSessionId == paramLong)
          {
            localObject = localFileManagerEntity;
            if (paramString.equalsIgnoreCase(localFileManagerEntity.peerUin)) {
              break;
            }
          }
          if ((0L == localFileManagerEntity.nOLfileSessionId) && (paramLong == localFileManagerEntity.nSessionId) && (paramString.equalsIgnoreCase(localFileManagerEntity.peerUin)))
          {
            localFileManagerEntity.nOLfileSessionId = paramLong;
            d(localFileManagerEntity);
            localObject = localFileManagerEntity;
            break;
          }
        }
      }
      Object localObject = null;
    }
  }
  
  public List a()
  {
    try
    {
      this.jdField_a_of_type_JavaUtilList = a(200);
      if (this.jdField_a_of_type_JavaUtilList == null) {
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
      }
      List localList = this.jdField_a_of_type_JavaUtilList;
      return localList;
    }
    finally {}
  }
  
  public List a(int paramInt)
  {
    FileManagerEntity localFileManagerEntity1 = null;
    for (;;)
    {
      long l1;
      try
      {
        if ((this.d == null) || (this.d.isEmpty())) {
          a();
        }
        Object localObject1 = "select * from ( select * from " + FileManagerEntity.tableName() + " order by srvTime desc limit " + paramInt + ") order by srvTime desc";
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
        l1 = System.currentTimeMillis();
        try
        {
          localObject1 = ((EntityManager)localObject3).a(FileManagerEntity.class, (String)localObject1, null);
          if (QLog.isDevelopLevel())
          {
            if (localObject1 != null) {
              continue;
            }
            QLog.d("FileManagerProxy<FileAssistant>", 4, "QueryMoreEntity[null]");
          }
          localObject3 = localFileManagerEntity1;
          if (localObject1 != null)
          {
            paramInt = ((List)localObject1).size();
            if (paramInt != 0) {
              break label221;
            }
            localObject3 = localFileManagerEntity1;
          }
          return (List)localObject3;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          if (!QLog.isColorLevel()) {
            break label470;
          }
        }
        QLog.e("FileManagerProxy<FileAssistant>", 2, "load " + paramInt + " data,is oom!");
      }
      finally {}
      QLog.d("FileManagerProxy<FileAssistant>", 4, "QueryMoreEntity[" + localOutOfMemoryError.size() + "]");
      continue;
      label221:
      Object localObject3 = new ArrayList();
      Iterator localIterator1 = ((List)localObject2).iterator();
      label236:
      label468:
      for (;;)
      {
        if (localIterator1.hasNext())
        {
          localFileManagerEntity1 = (FileManagerEntity)localIterator1.next();
          if (this.jdField_a_of_type_JavaUtilMap.containsKey(Long.valueOf(localFileManagerEntity1.nSessionId)) == true)
          {
            localFileManagerEntity1 = (FileManagerEntity)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(localFileManagerEntity1.nSessionId));
            FileManagerUtil.a(localFileManagerEntity1);
            ((List)localObject3).add(localFileManagerEntity1);
          }
          else
          {
            Iterator localIterator2 = this.d.iterator();
            while (localIterator2.hasNext())
            {
              FileManagerEntity localFileManagerEntity2 = (FileManagerEntity)localIterator2.next();
              if (localFileManagerEntity2.nSessionId == localFileManagerEntity1.nSessionId)
              {
                FileManagerUtil.a(localFileManagerEntity2);
                ((List)localObject3).add(localFileManagerEntity2);
              }
            }
          }
        }
        else
        {
          for (paramInt = 1;; paramInt = 0)
          {
            if (paramInt != 0) {
              break label468;
            }
            FileManagerUtil.a(localFileManagerEntity1);
            ((List)localObject3).add(localFileManagerEntity1);
            break label236;
            long l2 = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
              QLog.d("FileManagerProxy<FileAssistant>", 2, "QueryMoreEntity cost[" + (l2 - l1) + "], size[" + ((List)localObject3).size() + "]");
            }
            break;
          }
        }
      }
      label470:
      localIterator1 = null;
    }
  }
  
  public List a(int paramInt1, int paramInt2)
  {
    FileManagerEntity localFileManagerEntity1 = null;
    for (;;)
    {
      long l1;
      try
      {
        if ((this.d == null) || (this.d.isEmpty())) {
          a();
        }
        Object localObject1 = "select * from ( select * from " + FileManagerEntity.tableName() + " order by srvTime desc limit " + paramInt1 * paramInt2 + "," + (paramInt2 + 1) * paramInt1 + ") order by srvTime desc";
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
        l1 = System.currentTimeMillis();
        try
        {
          localObject1 = ((EntityManager)localObject3).a(FileManagerEntity.class, (String)localObject1, null);
          if (QLog.isDevelopLevel())
          {
            if (localObject1 != null) {
              continue;
            }
            QLog.d("FileManagerProxy<FileAssistant>", 4, "QueryMoreEntity[null]");
          }
          localObject3 = localFileManagerEntity1;
          if (localObject1 != null)
          {
            paramInt1 = ((List)localObject1).size();
            if (paramInt1 != 0) {
              break label242;
            }
            localObject3 = localFileManagerEntity1;
          }
          return (List)localObject3;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          if (!QLog.isColorLevel()) {
            break label512;
          }
        }
        QLog.e("FileManagerProxy<FileAssistant>", 2, "load " + paramInt1 + " data,is oom!");
      }
      finally {}
      QLog.d("FileManagerProxy<FileAssistant>", 4, "QueryMoreEntity[" + localOutOfMemoryError.size() + "]");
      continue;
      label242:
      Object localObject3 = new ArrayList();
      Iterator localIterator1 = ((List)localObject2).iterator();
      label258:
      label510:
      for (;;)
      {
        if (localIterator1.hasNext())
        {
          localFileManagerEntity1 = (FileManagerEntity)localIterator1.next();
          if (this.jdField_a_of_type_JavaUtilMap.containsKey(Long.valueOf(localFileManagerEntity1.nSessionId)) == true)
          {
            localFileManagerEntity1 = (FileManagerEntity)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(localFileManagerEntity1.nSessionId));
            FileManagerUtil.a(localFileManagerEntity1);
            ((List)localObject3).add(localFileManagerEntity1);
          }
          else
          {
            Iterator localIterator2 = this.d.iterator();
            while (localIterator2.hasNext())
            {
              FileManagerEntity localFileManagerEntity2 = (FileManagerEntity)localIterator2.next();
              if (localFileManagerEntity2.nSessionId == localFileManagerEntity1.nSessionId)
              {
                FileManagerUtil.a(localFileManagerEntity2);
                ((List)localObject3).add(localFileManagerEntity2);
              }
            }
          }
        }
        else
        {
          for (paramInt1 = 1;; paramInt1 = 0)
          {
            if (paramInt1 != 0) {
              break label510;
            }
            FileManagerUtil.a(localFileManagerEntity1);
            ((List)localObject3).add(localFileManagerEntity1);
            break label258;
            long l2 = System.currentTimeMillis();
            if (QLog.isDevelopLevel()) {
              QLog.d("FileManagerProxy<FileAssistant>", 4, "QueryMoreEntity cost[" + (l2 - l1) + "]");
            }
            QLog.d("FileManagerProxy<FileAssistant>", 4, "QueryMoreEntity retList size" + ((List)localObject3).size());
            break;
          }
        }
      }
      label512:
      localIterator1 = null;
    }
  }
  
  /* Error */
  public List a(int paramInt, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 33	java/util/ArrayList
    //   5: dup
    //   6: invokespecial 36	java/util/ArrayList:<init>	()V
    //   9: astore_3
    //   10: aload_3
    //   11: invokeinterface 449 1 0
    //   16: aload_0
    //   17: getfield 29	com/tencent/mobileqq/filemanager/data/FileManagerProxy:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   20: ifnonnull +14 -> 34
    //   23: aload_0
    //   24: new 33	java/util/ArrayList
    //   27: dup
    //   28: invokespecial 36	java/util/ArrayList:<init>	()V
    //   31: putfield 29	com/tencent/mobileqq/filemanager/data/FileManagerProxy:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   34: aload_0
    //   35: getfield 29	com/tencent/mobileqq/filemanager/data/FileManagerProxy:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   38: invokeinterface 215 1 0
    //   43: astore 4
    //   45: aload 4
    //   47: invokeinterface 220 1 0
    //   52: ifeq +85 -> 137
    //   55: aload 4
    //   57: invokeinterface 224 1 0
    //   62: checkcast 151	com/tencent/mobileqq/filemanager/data/FileManagerEntity
    //   65: astore 5
    //   67: aload 5
    //   69: ifnull +50 -> 119
    //   72: aload 5
    //   74: getfield 352	com/tencent/mobileqq/filemanager/data/FileManagerEntity:peerUin	Ljava/lang/String;
    //   77: ifnull +42 -> 119
    //   80: aload 5
    //   82: getfield 352	com/tencent/mobileqq/filemanager/data/FileManagerEntity:peerUin	Ljava/lang/String;
    //   85: aload_2
    //   86: invokevirtual 338	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   89: ifeq +30 -> 119
    //   92: aload 5
    //   94: invokevirtual 230	com/tencent/mobileqq/filemanager/data/FileManagerEntity:getCloudType	()I
    //   97: iconst_2
    //   98: if_icmpne +12 -> 110
    //   101: aload 5
    //   103: getfield 452	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nOpType	I
    //   106: iconst_3
    //   107: if_icmpne +12 -> 119
    //   110: aload_3
    //   111: aload 5
    //   113: invokeinterface 280 2 0
    //   118: pop
    //   119: aload_3
    //   120: invokeinterface 64 1 0
    //   125: istore 6
    //   127: iload 6
    //   129: iload_1
    //   130: if_icmplt -85 -> 45
    //   133: aload_0
    //   134: monitorexit
    //   135: aload_3
    //   136: areturn
    //   137: iconst_0
    //   138: istore 6
    //   140: aload_0
    //   141: sipush 200
    //   144: iload 6
    //   146: invokevirtual 454	com/tencent/mobileqq/filemanager/data/FileManagerProxy:a	(II)Ljava/util/List;
    //   149: astore 4
    //   151: aload 4
    //   153: ifnonnull +6 -> 159
    //   156: goto -23 -> 133
    //   159: aload 4
    //   161: invokeinterface 215 1 0
    //   166: astore 4
    //   168: aload 4
    //   170: invokeinterface 220 1 0
    //   175: ifeq +107 -> 282
    //   178: aload 4
    //   180: invokeinterface 224 1 0
    //   185: checkcast 151	com/tencent/mobileqq/filemanager/data/FileManagerEntity
    //   188: astore 5
    //   190: aload 5
    //   192: ifnull +73 -> 265
    //   195: aload 5
    //   197: getfield 352	com/tencent/mobileqq/filemanager/data/FileManagerEntity:peerUin	Ljava/lang/String;
    //   200: ifnull +65 -> 265
    //   203: aload_3
    //   204: aload 5
    //   206: invokeinterface 457 2 0
    //   211: ifne +54 -> 265
    //   214: aload 5
    //   216: getfield 352	com/tencent/mobileqq/filemanager/data/FileManagerEntity:peerUin	Ljava/lang/String;
    //   219: aload_2
    //   220: invokevirtual 338	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   223: ifeq +42 -> 265
    //   226: aload 5
    //   228: invokevirtual 230	com/tencent/mobileqq/filemanager/data/FileManagerEntity:getCloudType	()I
    //   231: iconst_2
    //   232: if_icmpne +12 -> 244
    //   235: aload 5
    //   237: getfield 452	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nOpType	I
    //   240: iconst_3
    //   241: if_icmpne +24 -> 265
    //   244: aload_3
    //   245: aload 5
    //   247: invokeinterface 280 2 0
    //   252: pop
    //   253: aload_0
    //   254: getfield 29	com/tencent/mobileqq/filemanager/data/FileManagerProxy:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   257: aload 5
    //   259: invokeinterface 280 2 0
    //   264: pop
    //   265: aload_3
    //   266: invokeinterface 64 1 0
    //   271: istore 7
    //   273: iload 7
    //   275: iload_1
    //   276: if_icmplt -108 -> 168
    //   279: goto -146 -> 133
    //   282: iload 6
    //   284: iconst_1
    //   285: iadd
    //   286: istore 6
    //   288: goto -148 -> 140
    //   291: astore_2
    //   292: aload_0
    //   293: monitorexit
    //   294: aload_2
    //   295: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	296	0	this	FileManagerProxy
    //   0	296	1	paramInt	int
    //   0	296	2	paramString	String
    //   9	257	3	localArrayList	ArrayList
    //   43	136	4	localObject	Object
    //   65	193	5	localFileManagerEntity	FileManagerEntity
    //   125	162	6	i	int
    //   271	6	7	j	int
    // Exception table:
    //   from	to	target	type
    //   2	34	291	finally
    //   34	45	291	finally
    //   45	67	291	finally
    //   72	110	291	finally
    //   110	119	291	finally
    //   119	127	291	finally
    //   140	151	291	finally
    //   159	168	291	finally
    //   168	190	291	finally
    //   195	244	291	finally
    //   244	265	291	finally
    //   265	273	291	finally
  }
  
  /* Error */
  public List a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 31	com/tencent/mobileqq/filemanager/data/FileManagerProxy:b	Ljava/util/List;
    //   6: ifnull +33 -> 39
    //   9: aload_0
    //   10: getfield 31	com/tencent/mobileqq/filemanager/data/FileManagerProxy:b	Ljava/util/List;
    //   13: invokeinterface 449 1 0
    //   18: aload_0
    //   19: aload_0
    //   20: sipush 200
    //   23: aload_1
    //   24: invokevirtual 460	com/tencent/mobileqq/filemanager/data/FileManagerProxy:a	(ILjava/lang/String;)Ljava/util/List;
    //   27: putfield 31	com/tencent/mobileqq/filemanager/data/FileManagerProxy:b	Ljava/util/List;
    //   30: aload_0
    //   31: getfield 31	com/tencent/mobileqq/filemanager/data/FileManagerProxy:b	Ljava/util/List;
    //   34: astore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_1
    //   38: areturn
    //   39: aload_0
    //   40: new 33	java/util/ArrayList
    //   43: dup
    //   44: invokespecial 36	java/util/ArrayList:<init>	()V
    //   47: putfield 31	com/tencent/mobileqq/filemanager/data/FileManagerProxy:b	Ljava/util/List;
    //   50: goto -32 -> 18
    //   53: astore_1
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_1
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	FileManagerProxy
    //   0	58	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	18	53	finally
    //   18	35	53	finally
    //   39	50	53	finally
  }
  
  public Map a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      a();
    }
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    FileManagerEntity localFileManagerEntity;
    while (localIterator.hasNext())
    {
      localFileManagerEntity = (FileManagerEntity)localIterator.next();
      if ((!TextUtils.isEmpty(localFileManagerEntity.fileName)) && (localFileManagerEntity.fileName.indexOf(paramString) >= 0))
      {
        if (!localLinkedHashMap.containsKey(localFileManagerEntity.fileName)) {
          localLinkedHashMap.put(localFileManagerEntity.fileName, new ArrayList());
        }
        ((List)localLinkedHashMap.get(localFileManagerEntity.fileName)).add(localFileManagerEntity);
      }
    }
    localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      localFileManagerEntity = (FileManagerEntity)localIterator.next();
      if (!TextUtils.isEmpty(localFileManagerEntity.fileName))
      {
        String str = localFileManagerEntity.fileName;
        if (localLinkedHashMap.containsKey(localFileManagerEntity.fileName) != true) {
          if (SearchUtils.b(paramString, str, IContactSearchable.g) > Long.MIN_VALUE)
          {
            if (!localLinkedHashMap.containsKey(localFileManagerEntity.fileName)) {
              localLinkedHashMap.put(localFileManagerEntity.fileName, new ArrayList());
            }
            ((List)localLinkedHashMap.get(localFileManagerEntity.fileName)).add(localFileManagerEntity);
          }
          else
          {
            str = FileManagerUtil.b(localFileManagerEntity);
            if (TextUtils.isEmpty(str))
            {
              if (QLog.isDevelopLevel()) {
                throw new NullPointerException("get Full String error!!!");
              }
            }
            else if (SearchUtils.b(paramString, str.replace("来自讨论组:", "").replace("发给讨论组:", "").replace("来自群:", "").replace("发给群:", "").replace("来自", "").replace("发给", "").replace("存到", "").trim(), IContactSearchable.g) > Long.MIN_VALUE)
            {
              if (!localLinkedHashMap.containsKey(localFileManagerEntity.fileName)) {
                localLinkedHashMap.put(localFileManagerEntity.fileName, new ArrayList());
              }
              ((List)localLinkedHashMap.get(localFileManagerEntity.fileName)).add(localFileManagerEntity);
            }
          }
        }
      }
    }
    return localLinkedHashMap;
  }
  
  public void a()
  {
    if (this.d != null) {
      return;
    }
    Object localObject2 = "select * from ( select * from " + FileManagerEntity.tableName() + " order by srvTime desc limit " + 30 + ") order by srvTime desc";
    Object localObject3 = "update  " + FileManagerEntity.tableName() + " set bDelInFM = 1 " + " where ( srvTime + " + 604800000L + " ) < " + MessageCache.a() * 1000L + " and cloudType = " + 1;
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    localEntityManager.b((String)localObject3);
    this.d = localEntityManager.a(FileManagerEntity.class, (String)localObject2, null);
    if (this.d == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerProxy<FileAssistant>", 2, "init , buf fmList is null,maybe is not data!,sql[" + (String)localObject2 + "]");
      }
      this.d = new ArrayList();
    }
    try
    {
      if (this.jdField_a_of_type_JavaUtilMap == null)
      {
        this.jdField_a_of_type_JavaUtilMap = new HashMap();
        localObject2 = this.d.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (FileManagerEntity)((Iterator)localObject2).next();
          FileManagerUtil.a((FileManagerEntity)localObject3);
          this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(((FileManagerEntity)localObject3).nSessionId), localObject3);
        }
      }
    }
    finally {}
    ((EntityManager)localObject1).a();
  }
  
  public void a(long paramLong)
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilMap != null)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
        while (localIterator.hasNext()) {
          if (paramLong == ((FileManagerEntity)((Map.Entry)localIterator.next()).getValue()).nSessionId) {
            localIterator.remove();
          }
        }
      }
    }
    finally {}
  }
  
  public void a(long paramLong1, String paramString, long paramLong2)
  {
    if ((paramString == null) || (paramLong1 < 0L) || (paramLong2 <= 0L)) {}
    do
    {
      return;
      if (this.c.size() > 30) {
        this.c.remove(0);
      }
      saz localsaz = new saz(this);
      localsaz.jdField_a_of_type_Long = paramLong1;
      localsaz.jdField_a_of_type_JavaLangString = paramString;
      localsaz.b = paramLong2;
      this.c.add(localsaz);
    } while (!QLog.isColorLevel());
    QLog.i("FileManagerProxy<FileAssistant>", 2, "saveDeletedEntity nSessionId=" + paramLong1 + " nOlSessionId=" + paramLong2);
  }
  
  public void a(FileManagerEntity paramFileManagerEntity)
  {
    try
    {
      a();
      FileManagerUtil.a(paramFileManagerEntity);
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramFileManagerEntity.nSessionId));
      this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramFileManagerEntity.nSessionId), paramFileManagerEntity);
      return;
    }
    finally
    {
      paramFileManagerEntity = finally;
      throw paramFileManagerEntity;
    }
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, int paramInt)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerProxy<FileAssistant>", 2, "why FileManagerEntity is null!!!");
      }
      return;
    }
    paramFileManagerEntity.status = paramInt;
    paramFileManagerEntity = paramFileManagerEntity.clone();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("status", Integer.valueOf(paramInt));
    a(FileManagerEntity.tableName(), localContentValues, "nSessionId=?", new String[] { String.valueOf(paramFileManagerEntity.nSessionId) }, null);
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, int paramInt, float paramFloat)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerProxy<FileAssistant>", 2, "entity is null!");
      }
      return;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("status", Integer.valueOf(paramInt));
    localContentValues.put("fProgress", Float.valueOf(paramFloat));
    a(paramFileManagerEntity.getTableName(), localContentValues, "nSessionId=?", new String[] { String.valueOf(paramFileManagerEntity.nSessionId) }, null);
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, ProxyListener paramProxyListener)
  {
    for (;;)
    {
      try
      {
        paramProxyListener = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
        if (paramProxyListener == null) {
          return;
        }
        paramProxyListener = new FileManagerEntity();
        paramFileManagerEntity.nFileType = FileManagerUtil.a(paramFileManagerEntity.fileName);
        paramProxyListener.copyFrom(paramFileManagerEntity);
        paramProxyListener.nSessionId = paramFileManagerEntity.nSessionId;
        paramProxyListener.bSend = paramFileManagerEntity.bSend;
        paramProxyListener.bDelInAio = paramFileManagerEntity.bDelInAio;
        paramProxyListener.bDelInFM = paramFileManagerEntity.bDelInFM;
        if ((paramProxyListener.status != 1) && (paramProxyListener.status != -1) && (!paramProxyListener.bSend) && (paramProxyListener.status != 4)) {
          paramProxyListener.status = 0;
        }
        if ((paramProxyListener.status == 2) || (paramProxyListener.status == 18)) {
          paramProxyListener.status = 0;
        }
        if (paramProxyListener.getStatus() == 1000)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(String.valueOf(0), 0, paramProxyListener.getTableName(), paramProxyListener, 0, null);
          paramFileManagerEntity.setId(paramProxyListener.getId());
          paramFileManagerEntity.setStatus(paramProxyListener.getStatus());
          continue;
        }
        if (paramProxyListener.getStatus() != 1001) {
          break label219;
        }
      }
      finally {}
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(String.valueOf(0), 0, paramProxyListener.getTableName(), paramProxyListener, 1, null);
      continue;
      label219:
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerProxy<FileAssistant>", 2, "FileManagerEntity status[" + String.valueOf(paramProxyListener.getStatus()) + "] is wrong");
      }
    }
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, String paramString)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerProxy<FileAssistant>", 2, "why FileManagerEntity is null!!!");
      }
      return;
    }
    paramFileManagerEntity.setFilePath(paramString);
    paramFileManagerEntity = paramFileManagerEntity.clone();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("strFilePath", paramString);
    a(FileManagerEntity.tableName(), localContentValues, "nSessionId=?", new String[] { String.valueOf(paramFileManagerEntity.nSessionId) }, null);
  }
  
  public void a(String paramString, int paramInt)
  {
    Object localObject2;
    try
    {
      if (this.d == null) {
        a();
      }
      localObject1 = this.d.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (FileManagerEntity)((Iterator)localObject1).next();
        if ((((FileManagerEntity)localObject2).peerUin != null) && (((FileManagerEntity)localObject2).peerUin.equals(paramString)) && (((FileManagerEntity)localObject2).peerType == paramInt))
        {
          ((FileManagerEntity)localObject2).uniseq = -1L;
          ((FileManagerEntity)localObject2).bDelInAio = true;
        }
      }
      localObject1 = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    }
    finally {}
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Long)((Iterator)localObject1).next();
      localObject2 = (FileManagerEntity)this.jdField_a_of_type_JavaUtilMap.get(localObject2);
      if ((((FileManagerEntity)localObject2).peerUin != null) && (((FileManagerEntity)localObject2).peerUin.equals(paramString)) && (((FileManagerEntity)localObject2).peerType == paramInt))
      {
        ((FileManagerEntity)localObject2).uniseq = -1L;
        ((FileManagerEntity)localObject2).bDelInAio = true;
      }
    }
    Object localObject1 = new ContentValues();
    ((ContentValues)localObject1).put("bDelInAio", Boolean.valueOf(true));
    ((ContentValues)localObject1).put("uniseq", Integer.valueOf(-1));
    a(FileManagerEntity.tableName(), (ContentValues)localObject1, " peerUin = ? and peerType = ? ", new String[] { paramString, String.valueOf(paramInt) }, null);
    a(FileManagerEntity.tableName(), " bDelInAio = ? and bDelInFM = ? ", new String[] { String.valueOf(1), String.valueOf(1) }, null);
  }
  
  public void a(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString, ProxyListener paramProxyListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(String.valueOf(0), 0, paramString1, paramContentValues, paramString2, paramArrayOfString, 1, paramProxyListener);
  }
  
  protected void a(String paramString1, String paramString2, String[] paramArrayOfString, ProxyListener paramProxyListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(String.valueOf(0), 0, paramString1, paramString2, paramArrayOfString, 2, paramProxyListener);
  }
  
  public boolean a()
  {
    return a(30);
  }
  
  public boolean a(long paramLong)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      if (((saz)localIterator.next()).jdField_a_of_type_Long == paramLong) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(FileManagerEntity paramFileManagerEntity, boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramFileManagerEntity == null) {
      bool1 = bool2;
    }
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel())
        {
          QLog.e("FileManagerProxy<FileAssistant>", 2, "if item is null, why can choose???!!!");
          bool1 = bool2;
        }
        return bool1;
      }
      finally {}
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager() != null)
      {
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramFileManagerEntity.peerUin, paramFileManagerEntity.peerType, paramFileManagerEntity.uniseq);
        if ((paramFileManagerEntity.bDelInAio) && (paramFileManagerEntity.bDelInFM) && (localObject == null))
        {
          a(FileManagerEntity.tableName(), "nSessionId = ?", new String[] { String.valueOf(paramFileManagerEntity.nSessionId) }, null);
          this.d.remove(paramFileManagerEntity);
          if (this.jdField_a_of_type_JavaUtilList != null)
          {
            localObject = this.jdField_a_of_type_JavaUtilList.iterator();
            if (((Iterator)localObject).hasNext())
            {
              if (((Iterator)localObject).next() != paramFileManagerEntity) {
                continue;
              }
              ((Iterator)localObject).remove();
              continue;
            }
          }
          localObject = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
          while (((Iterator)localObject).hasNext())
          {
            Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
            if (paramFileManagerEntity.nSessionId == ((FileManagerEntity)localEntry.getValue()).nSessionId) {
              ((Iterator)localObject).remove();
            }
          }
          if (QLog.isColorLevel()) {
            QLog.i("FileManagerProxy<FileAssistant>", 2, "Delete FileManagerEntity[" + String.valueOf(paramFileManagerEntity.nSessionId) + "] for memory and db:" + FileManagerUtil.a(paramFileManagerEntity));
          }
          a(paramFileManagerEntity.nSessionId, paramFileManagerEntity.peerUin, paramFileManagerEntity.nOLfileSessionId);
          bool1 = a(1);
        }
        else
        {
          if (localObject != null) {
            paramFileManagerEntity.bDelInAio = false;
          }
          localObject = new ContentValues();
          ((ContentValues)localObject).put("bDelInAio", Boolean.valueOf(paramFileManagerEntity.bDelInAio));
          ((ContentValues)localObject).put("bDelInFM", Boolean.valueOf(paramFileManagerEntity.bDelInFM));
          ((ContentValues)localObject).put("uniseq", Long.valueOf(paramFileManagerEntity.uniseq));
          a(FileManagerEntity.tableName(), (ContentValues)localObject, "nSessionId = ?", new String[] { String.valueOf(paramFileManagerEntity.nSessionId) }, null);
          if (paramBoolean) {
            this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.c();
          }
          if (QLog.isColorLevel()) {
            QLog.i("FileManagerProxy<FileAssistant>", 2, "Update FileManagerEntity[" + String.valueOf(paramFileManagerEntity.nSessionId) + "] for db:" + FileManagerUtil.a(paramFileManagerEntity));
          }
          bool1 = true;
        }
      }
    }
  }
  
  public boolean a(String paramString, long paramLong)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      saz localsaz = (saz)localIterator.next();
      if ((localsaz.b == paramLong) && (localsaz.jdField_a_of_type_JavaLangString != null) && (localsaz.jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramString))) {
        return true;
      }
    }
    return false;
  }
  
  public FileManagerEntity b(long paramLong, String paramString, int paramInt)
  {
    FileManagerEntity localFileManagerEntity = null;
    for (;;)
    {
      long l;
      try
      {
        paramString = "select * from " + FileManagerEntity.tableName() + " where uniseq = " + String.valueOf(paramLong);
        EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
        if (localEntityManager == null)
        {
          paramString = localFileManagerEntity;
          if (QLog.isColorLevel())
          {
            QLog.e("FileManagerProxy<FileAssistant>", 2, "get EntityManager null!");
            paramString = localFileManagerEntity;
          }
          return paramString;
        }
        paramLong = System.currentTimeMillis();
        paramString = localEntityManager.a(FileManagerEntity.class, paramString, null);
        l = System.currentTimeMillis();
        if (paramString == null)
        {
          paramString = localFileManagerEntity;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("FileManagerProxy<FileAssistant>", 2, "queryOver, but no data!");
          paramString = localFileManagerEntity;
          continue;
        }
        if (!QLog.isColorLevel()) {
          break label190;
        }
      }
      finally {}
      QLog.d("FileManagerProxy<FileAssistant>", 2, "query over,startTime[" + String.valueOf(paramLong) + "], overTime[" + String.valueOf(l) + "]");
      label190:
      if ((paramString.size() > 1) && (QLog.isColorLevel())) {
        QLog.w("FileManagerProxy", 2, "why size[" + String.valueOf(paramString.size()) + "] over 1?");
      }
      localFileManagerEntity = (FileManagerEntity)paramString.get(0);
      this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(localFileManagerEntity.nSessionId), localFileManagerEntity);
      FileCategoryUtil.a(localFileManagerEntity);
      paramString = localFileManagerEntity;
      if (localFileManagerEntity.cloudType == 1)
      {
        paramString = localFileManagerEntity;
        if (FileManagerUtil.a(localFileManagerEntity))
        {
          localFileManagerEntity.status = 16;
          paramString = localFileManagerEntity;
        }
      }
    }
  }
  
  /* Error */
  public FileManagerEntity b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 138	com/tencent/mobileqq/filemanager/data/FileManagerProxy:d	Ljava/util/List;
    //   6: ifnonnull +7 -> 13
    //   9: aload_0
    //   10: invokevirtual 140	com/tencent/mobileqq/filemanager/data/FileManagerProxy:a	()V
    //   13: aload_0
    //   14: getfield 138	com/tencent/mobileqq/filemanager/data/FileManagerProxy:d	Ljava/util/List;
    //   17: invokeinterface 215 1 0
    //   22: astore_3
    //   23: aload_3
    //   24: invokeinterface 220 1 0
    //   29: ifeq +41 -> 70
    //   32: aload_3
    //   33: invokeinterface 224 1 0
    //   38: checkcast 151	com/tencent/mobileqq/filemanager/data/FileManagerEntity
    //   41: astore_2
    //   42: aload_2
    //   43: getfield 720	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strServerPath	Ljava/lang/String;
    //   46: ifnull -23 -> 23
    //   49: aload_2
    //   50: getfield 720	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strServerPath	Ljava/lang/String;
    //   53: aload_1
    //   54: invokevirtual 252	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   57: istore 4
    //   59: iload 4
    //   61: ifeq -38 -> 23
    //   64: aload_2
    //   65: astore_1
    //   66: aload_0
    //   67: monitorexit
    //   68: aload_1
    //   69: areturn
    //   70: aload_0
    //   71: getfield 267	com/tencent/mobileqq/filemanager/data/FileManagerProxy:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   74: invokeinterface 382 1 0
    //   79: invokeinterface 373 1 0
    //   84: astore_3
    //   85: aload_3
    //   86: invokeinterface 220 1 0
    //   91: ifeq +62 -> 153
    //   94: aload_3
    //   95: invokeinterface 224 1 0
    //   100: checkcast 97	java/lang/Long
    //   103: astore_2
    //   104: aload_0
    //   105: getfield 267	com/tencent/mobileqq/filemanager/data/FileManagerProxy:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   108: aload_2
    //   109: invokeinterface 273 2 0
    //   114: checkcast 151	com/tencent/mobileqq/filemanager/data/FileManagerEntity
    //   117: astore_2
    //   118: aload_2
    //   119: getfield 720	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strServerPath	Ljava/lang/String;
    //   122: ifnull -37 -> 85
    //   125: aload_2
    //   126: getfield 616	com/tencent/mobileqq/filemanager/data/FileManagerEntity:bDelInFM	Z
    //   129: iconst_1
    //   130: if_icmpeq -45 -> 85
    //   133: aload_2
    //   134: getfield 720	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strServerPath	Ljava/lang/String;
    //   137: aload_1
    //   138: invokevirtual 252	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   141: istore 4
    //   143: iload 4
    //   145: ifeq -60 -> 85
    //   148: aload_2
    //   149: astore_1
    //   150: goto -84 -> 66
    //   153: aconst_null
    //   154: astore_1
    //   155: goto -89 -> 66
    //   158: astore_1
    //   159: aload_0
    //   160: monitorexit
    //   161: aload_1
    //   162: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	163	0	this	FileManagerProxy
    //   0	163	1	paramString	String
    //   41	108	2	localObject	Object
    //   22	73	3	localIterator	Iterator
    //   57	87	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	13	158	finally
    //   13	23	158	finally
    //   23	59	158	finally
    //   70	85	158	finally
    //   85	143	158	finally
  }
  
  public List b()
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilList == null) {
        a();
      }
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerProxy<FileAssistant>", 2, "queryMaxRecentRecords size[" + this.jdField_a_of_type_JavaUtilList.size() + "]");
      }
      List localList = this.jdField_a_of_type_JavaUtilList;
      return localList;
    }
    finally {}
  }
  
  protected void b() {}
  
  public void b(FileManagerEntity paramFileManagerEntity)
  {
    for (;;)
    {
      Looper localLooper;
      try
      {
        a(paramFileManagerEntity);
        localLooper = Looper.getMainLooper();
        Thread localThread1 = Thread.currentThread();
        Thread localThread2 = localLooper.getThread();
        if (localThread1 == localThread2)
        {
          try
          {
            if (!paramFileManagerEntity.bDelInFM) {
              c(paramFileManagerEntity);
            }
            a(paramFileManagerEntity, null);
          }
          catch (Exception paramFileManagerEntity)
          {
            paramFileManagerEntity.printStackTrace();
            continue;
          }
          return;
        }
      }
      finally {}
      new Handler(localLooper).post(new sax(this, paramFileManagerEntity));
    }
  }
  
  /* Error */
  public FileManagerEntity c(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 138	com/tencent/mobileqq/filemanager/data/FileManagerProxy:d	Ljava/util/List;
    //   6: ifnonnull +7 -> 13
    //   9: aload_0
    //   10: invokevirtual 140	com/tencent/mobileqq/filemanager/data/FileManagerProxy:a	()V
    //   13: aload_0
    //   14: getfield 138	com/tencent/mobileqq/filemanager/data/FileManagerProxy:d	Ljava/util/List;
    //   17: invokeinterface 215 1 0
    //   22: astore_3
    //   23: aload_3
    //   24: invokeinterface 220 1 0
    //   29: ifeq +63 -> 92
    //   32: aload_3
    //   33: invokeinterface 224 1 0
    //   38: checkcast 151	com/tencent/mobileqq/filemanager/data/FileManagerEntity
    //   41: astore_2
    //   42: aload_2
    //   43: getfield 762	com/tencent/mobileqq/filemanager/data/FileManagerEntity:WeiYunFileId	Ljava/lang/String;
    //   46: ifnull -23 -> 23
    //   49: aload_2
    //   50: getfield 762	com/tencent/mobileqq/filemanager/data/FileManagerEntity:WeiYunFileId	Ljava/lang/String;
    //   53: aload_1
    //   54: invokevirtual 252	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   57: ifeq -34 -> 23
    //   60: aload_2
    //   61: getfield 366	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   64: iconst_1
    //   65: if_icmpne -42 -> 23
    //   68: aload_2
    //   69: getfield 765	com/tencent/mobileqq/filemanager/data/FileManagerEntity:imgHeight	I
    //   72: ifle -49 -> 23
    //   75: aload_2
    //   76: getfield 768	com/tencent/mobileqq/filemanager/data/FileManagerEntity:imgWidth	I
    //   79: istore 4
    //   81: iload 4
    //   83: ifle -60 -> 23
    //   86: aload_2
    //   87: astore_1
    //   88: aload_0
    //   89: monitorexit
    //   90: aload_1
    //   91: areturn
    //   92: aload_0
    //   93: getfield 267	com/tencent/mobileqq/filemanager/data/FileManagerProxy:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   96: invokeinterface 382 1 0
    //   101: invokeinterface 373 1 0
    //   106: astore_3
    //   107: aload_3
    //   108: invokeinterface 220 1 0
    //   113: ifeq +76 -> 189
    //   116: aload_3
    //   117: invokeinterface 224 1 0
    //   122: checkcast 97	java/lang/Long
    //   125: astore_2
    //   126: aload_0
    //   127: getfield 267	com/tencent/mobileqq/filemanager/data/FileManagerProxy:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   130: aload_2
    //   131: invokeinterface 273 2 0
    //   136: checkcast 151	com/tencent/mobileqq/filemanager/data/FileManagerEntity
    //   139: astore_2
    //   140: aload_2
    //   141: getfield 762	com/tencent/mobileqq/filemanager/data/FileManagerEntity:WeiYunFileId	Ljava/lang/String;
    //   144: ifnull -37 -> 107
    //   147: aload_2
    //   148: getfield 762	com/tencent/mobileqq/filemanager/data/FileManagerEntity:WeiYunFileId	Ljava/lang/String;
    //   151: aload_1
    //   152: invokevirtual 252	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   155: ifeq -48 -> 107
    //   158: aload_2
    //   159: getfield 366	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   162: iconst_1
    //   163: if_icmpne -56 -> 107
    //   166: aload_2
    //   167: getfield 765	com/tencent/mobileqq/filemanager/data/FileManagerEntity:imgHeight	I
    //   170: ifle -63 -> 107
    //   173: aload_2
    //   174: getfield 768	com/tencent/mobileqq/filemanager/data/FileManagerEntity:imgWidth	I
    //   177: istore 4
    //   179: iload 4
    //   181: ifle -74 -> 107
    //   184: aload_2
    //   185: astore_1
    //   186: goto -98 -> 88
    //   189: aconst_null
    //   190: astore_1
    //   191: goto -103 -> 88
    //   194: astore_1
    //   195: aload_0
    //   196: monitorexit
    //   197: aload_1
    //   198: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	199	0	this	FileManagerProxy
    //   0	199	1	paramString	String
    //   41	144	2	localObject	Object
    //   22	95	3	localIterator	Iterator
    //   79	101	4	i	int
    // Exception table:
    //   from	to	target	type
    //   2	13	194	finally
    //   13	23	194	finally
    //   23	81	194	finally
    //   92	107	194	finally
    //   107	179	194	finally
  }
  
  public List c()
  {
    if ((this.d == null) || (this.d.isEmpty())) {
      a();
    }
    return this.d;
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 138	com/tencent/mobileqq/filemanager/data/FileManagerProxy:d	Ljava/util/List;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 138	com/tencent/mobileqq/filemanager/data/FileManagerProxy:d	Ljava/util/List;
    //   18: invokeinterface 64 1 0
    //   23: iconst_1
    //   24: isub
    //   25: istore_2
    //   26: iload_2
    //   27: bipush 30
    //   29: if_icmplt -18 -> 11
    //   32: aload_0
    //   33: getfield 138	com/tencent/mobileqq/filemanager/data/FileManagerProxy:d	Ljava/util/List;
    //   36: iload_2
    //   37: invokeinterface 558 2 0
    //   42: pop
    //   43: iload_2
    //   44: iconst_1
    //   45: isub
    //   46: istore_2
    //   47: goto -21 -> 26
    //   50: astore_1
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_1
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	FileManagerProxy
    //   6	2	1	localList	List
    //   50	4	1	localObject	Object
    //   25	22	2	i	int
    // Exception table:
    //   from	to	target	type
    //   2	7	50	finally
    //   14	26	50	finally
    //   32	43	50	finally
  }
  
  public void c(FileManagerEntity paramFileManagerEntity)
  {
    int i;
    try
    {
      if (this.d == null) {
        a();
      }
      if ((!this.d.contains(paramFileManagerEntity)) || (!QLog.isColorLevel())) {
        break label333;
      }
      QLog.e("FileManagerProxy<FileAssistant>", 2, "!!!!!!!!!!!fmList has one!!!!!!!!!!!!");
    }
    catch (Exception paramFileManagerEntity)
    {
      for (;;)
      {
        FileManagerEntity localFileManagerEntity;
        label270:
        if (QLog.isColorLevel()) {
          QLog.e("FileManagerProxy<FileAssistant>", 1, paramFileManagerEntity.toString());
        }
      }
    }
    finally {}
    if (i < this.d.size())
    {
      localFileManagerEntity = (FileManagerEntity)this.d.get(i);
      if (paramFileManagerEntity.srvTime >= localFileManagerEntity.srvTime)
      {
        this.d.add(i, paramFileManagerEntity);
        if (this.jdField_a_of_type_JavaUtilList == null) {
          break label338;
        }
        this.jdField_a_of_type_JavaUtilList.add(i, paramFileManagerEntity);
        break label338;
      }
    }
    for (;;)
    {
      if (!bool)
      {
        if (this.d.size() != 0) {
          break label270;
        }
        this.d.add(0, paramFileManagerEntity);
        if (this.jdField_a_of_type_JavaUtilList != null) {
          this.jdField_a_of_type_JavaUtilList.add(0, paramFileManagerEntity);
        }
      }
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("FileManagerProxy<FileAssistant>", 4, "insertToList, is add" + bool + " entityInfo:" + FileManagerUtil.a(paramFileManagerEntity));
        }
        this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramFileManagerEntity.nSessionId), paramFileManagerEntity);
        if (this.d.size() > 30) {
          this.d.remove(this.d.size() - 1);
        }
        return;
        i += 1;
        break;
        this.d.add(paramFileManagerEntity);
        if (this.jdField_a_of_type_JavaUtilList != null) {
          this.jdField_a_of_type_JavaUtilList.add(paramFileManagerEntity);
        }
      }
      boolean bool = false;
      continue;
      label333:
      i = 0;
      break;
      label338:
      bool = true;
    }
  }
  
  public FileManagerEntity d(String paramString)
  {
    for (;;)
    {
      ArrayList localArrayList;
      Object localObject2;
      try
      {
        if (this.d == null) {
          a();
        }
        localArrayList = new ArrayList();
        localObject2 = this.d.iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localObject1 = (FileManagerEntity)((Iterator)localObject2).next();
          if ((((FileManagerEntity)localObject1).WeiYunFileId == null) || (!((FileManagerEntity)localObject1).WeiYunFileId.equalsIgnoreCase(paramString))) {
            continue;
          }
          if (((FileManagerEntity)localObject1).status == 1)
          {
            boolean bool = FileUtil.b(((FileManagerEntity)localObject1).getFilePath());
            if (bool) {
              return (FileManagerEntity)localObject1;
            }
          }
          localArrayList.add(localObject1);
          continue;
        }
        localObject2 = localArrayList.iterator();
      }
      finally {}
      for (;;)
      {
        if (((Iterator)localObject2).hasNext())
        {
          localObject1 = (FileManagerEntity)((Iterator)localObject2).next();
          if (((FileManagerEntity)localObject1).nOpType == 5) {
            break;
          }
        }
      }
      localArrayList.clear();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label250;
        }
        localObject1 = (Long)localIterator.next();
        localObject2 = (FileManagerEntity)this.jdField_a_of_type_JavaUtilMap.get(localObject1);
        if ((((FileManagerEntity)localObject2).WeiYunFileId != null) && (((FileManagerEntity)localObject2).WeiYunFileId.equalsIgnoreCase(paramString)))
        {
          if (((FileManagerEntity)localObject2).status == 1)
          {
            localObject1 = localObject2;
            if (FileUtil.b(((FileManagerEntity)localObject2).getFilePath())) {
              break;
            }
          }
          localArrayList.add(localObject2);
        }
      }
      label250:
      paramString = localArrayList.iterator();
      for (;;)
      {
        if (paramString.hasNext())
        {
          localObject1 = (FileManagerEntity)paramString.next();
          int i = ((FileManagerEntity)localObject1).nOpType;
          if (i == 5) {
            break;
          }
        }
      }
      Object localObject1 = null;
    }
  }
  
  public void d()
  {
    if (this.d == null) {
      a();
    }
    Object localObject2 = this.d.iterator();
    for (Object localObject1 = null; ((Iterator)localObject2).hasNext(); localObject1 = ((FileManagerEntity)localObject1).getTableName())
    {
      localObject1 = (FileManagerEntity)((Iterator)localObject2).next();
      ((FileManagerEntity)localObject1).isReaded = true;
    }
    if (localObject1 != null)
    {
      localObject2 = new ContentValues();
      ((ContentValues)localObject2).put("isReaded", Boolean.valueOf(true));
      a((String)localObject1, (ContentValues)localObject2, "isReaded=?", new String[] { "0" }, null);
    }
  }
  
  public void d(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerProxy<FileAssistant>", 2, "updateFileEntity, Error : entity is null!!!");
      }
      return;
    }
    FileManagerUtil.a(paramFileManagerEntity);
    int i = paramFileManagerEntity.status;
    if (i == 2) {
      paramFileManagerEntity.status = 0;
    }
    ContentValues localContentValues = a(paramFileManagerEntity);
    paramFileManagerEntity.status = i;
    long l = paramFileManagerEntity.nSessionId;
    paramFileManagerEntity = Looper.getMainLooper();
    if (Thread.currentThread() == paramFileManagerEntity.getThread()) {
      try
      {
        a(FileManagerEntity.tableName(), localContentValues, "nSessionId=?", new String[] { String.valueOf(l) }, null);
        return;
      }
      catch (Exception paramFileManagerEntity)
      {
        paramFileManagerEntity.printStackTrace();
        return;
      }
    }
    new Handler(paramFileManagerEntity).post(new say(this, localContentValues, l));
  }
  
  /* Error */
  public void e()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 267	com/tencent/mobileqq/filemanager/data/FileManagerProxy:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 267	com/tencent/mobileqq/filemanager/data/FileManagerProxy:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   18: invokeinterface 370 1 0
    //   23: invokeinterface 373 1 0
    //   28: astore_1
    //   29: aload_1
    //   30: invokeinterface 220 1 0
    //   35: ifeq -24 -> 11
    //   38: aload_1
    //   39: invokeinterface 224 1 0
    //   44: checkcast 375	java/util/Map$Entry
    //   47: astore_2
    //   48: aload_2
    //   49: invokeinterface 378 1 0
    //   54: checkcast 151	com/tencent/mobileqq/filemanager/data/FileManagerEntity
    //   57: astore_3
    //   58: aload_3
    //   59: getfield 366	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   62: iconst_2
    //   63: if_icmpeq -34 -> 29
    //   66: aload_3
    //   67: getfield 366	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   70: bipush 14
    //   72: if_icmpeq -43 -> 29
    //   75: aload_3
    //   76: getfield 366	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   79: bipush 15
    //   81: if_icmpeq -52 -> 29
    //   84: aload_3
    //   85: getfield 366	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   88: iconst_4
    //   89: if_icmpeq -60 -> 29
    //   92: aload_2
    //   93: invokeinterface 805 1 0
    //   98: checkcast 97	java/lang/Long
    //   101: invokevirtual 808	java/lang/Long:longValue	()J
    //   104: lstore 4
    //   106: aload_1
    //   107: invokeinterface 555 1 0
    //   112: invokestatic 294	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   115: ifeq -86 -> 29
    //   118: ldc 10
    //   120: iconst_2
    //   121: new 142	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   128: ldc_w 810
    //   131: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: lload 4
    //   136: invokevirtual 438	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   139: ldc_w 812
    //   142: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: invokestatic 342	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   151: goto -122 -> 29
    //   154: astore_1
    //   155: goto -144 -> 11
    //   158: astore_1
    //   159: aload_0
    //   160: monitorexit
    //   161: aload_1
    //   162: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	163	0	this	FileManagerProxy
    //   6	101	1	localObject1	Object
    //   154	1	1	localException	Exception
    //   158	4	1	localObject2	Object
    //   47	46	2	localEntry	Map.Entry
    //   57	28	3	localFileManagerEntity	FileManagerEntity
    //   104	31	4	l	long
    // Exception table:
    //   from	to	target	type
    //   14	29	154	java/lang/Exception
    //   29	151	154	java/lang/Exception
    //   2	7	158	finally
    //   14	29	158	finally
    //   29	151	158	finally
  }
  
  public void e(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {
      return;
    }
    for (;;)
    {
      ContentValues localContentValues;
      try
      {
        localContentValues = new ContentValues();
        if (paramFileManagerEntity.bDelInFM)
        {
          localContentValues.put("bDelInFM", Boolean.valueOf(true));
          a(FileManagerEntity.tableName(), localContentValues, "nSessionId=?", new String[] { String.valueOf(paramFileManagerEntity.nSessionId) }, null);
          break;
        }
      }
      finally {}
      localContentValues.put("bDelInFM", Boolean.valueOf(false));
    }
  }
  
  public void f()
  {
    String str = "delete from " + FileManagerEntity.tableName();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager().b(str);
  }
  
  public void f(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {}
    for (;;)
    {
      return;
      try
      {
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("msgSeq", Long.valueOf(paramFileManagerEntity.msgSeq));
        localContentValues.put("msgUid", Long.valueOf(paramFileManagerEntity.msgUid));
        localContentValues.put("msgTime", Long.valueOf(paramFileManagerEntity.msgTime));
        a(FileManagerEntity.tableName(), localContentValues, "nSessionId=?", new String[] { String.valueOf(paramFileManagerEntity.nSessionId) }, null);
      }
      finally {}
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\data\FileManagerProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */