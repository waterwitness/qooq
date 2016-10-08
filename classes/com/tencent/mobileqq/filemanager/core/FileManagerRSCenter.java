package com.tencent.mobileqq.filemanager.core;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.discoperation.DiscFileOperator;
import com.tencent.mobileqq.filemanager.discoperation.IFileHttpBase;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.managers.ShieldMsgManger;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.wstt.SSCM.Utils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import rwt;

public class FileManagerRSCenter
{
  private static final int jdField_a_of_type_Int = 2;
  private static final String jdField_a_of_type_JavaLangString = "FileManagerRSCenter<FileAssistant>";
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver;
  private LinkedHashMap jdField_a_of_type_JavaUtilLinkedHashMap;
  
  public FileManagerRSCenter(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new rwt(this);
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
  }
  
  /* Error */
  public int a(long paramLong1, String paramString, int paramInt, long paramLong2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 36	com/tencent/mobileqq/filemanager/core/FileManagerRSCenter:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   6: lload 5
    //   8: invokestatic 57	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   11: invokevirtual 61	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   14: checkcast 63	com/tencent/mobileqq/filemanager/discoperation/IFileHttpBase
    //   17: astore 7
    //   19: aload 7
    //   21: ifnull +17 -> 38
    //   24: aload 7
    //   26: invokeinterface 67 1 0
    //   31: istore 4
    //   33: aload_0
    //   34: monitorexit
    //   35: iload 4
    //   37: ireturn
    //   38: aload_0
    //   39: getfield 38	com/tencent/mobileqq/filemanager/core/FileManagerRSCenter:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   42: invokevirtual 70	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/filemanager/core/FileManagerDataCenter;
    //   45: lload_1
    //   46: aload_3
    //   47: iload 4
    //   49: lload 5
    //   51: invokevirtual 75	com/tencent/mobileqq/filemanager/core/FileManagerDataCenter:a	(JLjava/lang/String;IJ)Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   54: astore_3
    //   55: aload_3
    //   56: ifnonnull +9 -> 65
    //   59: iconst_m1
    //   60: istore 4
    //   62: goto -29 -> 33
    //   65: aload_0
    //   66: getfield 36	com/tencent/mobileqq/filemanager/core/FileManagerRSCenter:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   69: aload_3
    //   70: getfield 81	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   73: invokestatic 57	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   76: invokevirtual 61	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   79: checkcast 63	com/tencent/mobileqq/filemanager/discoperation/IFileHttpBase
    //   82: ifnull +12 -> 94
    //   85: aload_3
    //   86: getfield 84	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   89: istore 4
    //   91: goto -58 -> 33
    //   94: iconst_m1
    //   95: istore 4
    //   97: goto -64 -> 33
    //   100: astore_3
    //   101: aload_0
    //   102: monitorexit
    //   103: aload_3
    //   104: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	this	FileManagerRSCenter
    //   0	105	1	paramLong1	long
    //   0	105	3	paramString	String
    //   0	105	4	paramInt	int
    //   0	105	5	paramLong2	long
    //   17	8	7	localIFileHttpBase	IFileHttpBase
    // Exception table:
    //   from	to	target	type
    //   2	19	100	finally
    //   24	33	100	finally
    //   38	55	100	finally
    //   65	91	100	finally
  }
  
  /* Error */
  public long a(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 38	com/tencent/mobileqq/filemanager/core/FileManagerRSCenter:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6: invokevirtual 70	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/filemanager/core/FileManagerDataCenter;
    //   9: lload 4
    //   11: aload_1
    //   12: iload 6
    //   14: invokevirtual 88	com/tencent/mobileqq/filemanager/core/FileManagerDataCenter:a	(JLjava/lang/String;I)Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   17: astore 7
    //   19: aload 7
    //   21: ifnull +45 -> 66
    //   24: aload_0
    //   25: getfield 36	com/tencent/mobileqq/filemanager/core/FileManagerRSCenter:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   28: aload 7
    //   30: getfield 81	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   33: invokestatic 57	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   36: invokevirtual 61	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   39: checkcast 63	com/tencent/mobileqq/filemanager/discoperation/IFileHttpBase
    //   42: astore 7
    //   44: aload 7
    //   46: ifnull +20 -> 66
    //   49: aload 7
    //   51: invokeinterface 91 1 0
    //   56: istore 6
    //   58: iload 6
    //   60: i2l
    //   61: lstore_2
    //   62: aload_0
    //   63: monitorexit
    //   64: lload_2
    //   65: lreturn
    //   66: aload_0
    //   67: getfield 38	com/tencent/mobileqq/filemanager/core/FileManagerRSCenter:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   70: invokevirtual 70	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/filemanager/core/FileManagerDataCenter;
    //   73: aload_1
    //   74: lload_2
    //   75: lload 4
    //   77: iload 6
    //   79: invokevirtual 93	com/tencent/mobileqq/filemanager/core/FileManagerDataCenter:a	(Ljava/lang/String;JJI)J
    //   82: lstore_2
    //   83: goto -21 -> 62
    //   86: astore_1
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_1
    //   90: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	FileManagerRSCenter
    //   0	91	1	paramString	String
    //   0	91	2	paramLong1	long
    //   0	91	4	paramLong2	long
    //   0	91	6	paramInt	int
    //   17	33	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	86	finally
    //   24	44	86	finally
    //   49	58	86	finally
    //   66	83	86	finally
  }
  
  /* Error */
  public FileManagerEntity a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 36	com/tencent/mobileqq/filemanager/core/FileManagerRSCenter:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   6: invokevirtual 97	java/util/LinkedHashMap:size	()I
    //   9: istore 4
    //   11: iload 4
    //   13: iconst_1
    //   14: if_icmpge +9 -> 23
    //   17: aconst_null
    //   18: astore_1
    //   19: aload_0
    //   20: monitorexit
    //   21: aload_1
    //   22: areturn
    //   23: aload_0
    //   24: getfield 36	com/tencent/mobileqq/filemanager/core/FileManagerRSCenter:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   27: invokevirtual 101	java/util/LinkedHashMap:keySet	()Ljava/util/Set;
    //   30: invokeinterface 107 1 0
    //   35: astore_2
    //   36: aload_2
    //   37: invokeinterface 113 1 0
    //   42: ifeq +48 -> 90
    //   45: aload_2
    //   46: invokeinterface 117 1 0
    //   51: checkcast 53	java/lang/Long
    //   54: astore_3
    //   55: aload_0
    //   56: getfield 36	com/tencent/mobileqq/filemanager/core/FileManagerRSCenter:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   59: aload_3
    //   60: invokevirtual 61	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   63: checkcast 63	com/tencent/mobileqq/filemanager/discoperation/IFileHttpBase
    //   66: astore_3
    //   67: aload_1
    //   68: aload_3
    //   69: invokeinterface 120 1 0
    //   74: invokevirtual 126	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   77: ifeq -41 -> 36
    //   80: aload_3
    //   81: invokeinterface 129 1 0
    //   86: astore_1
    //   87: goto -68 -> 19
    //   90: aconst_null
    //   91: astore_1
    //   92: goto -73 -> 19
    //   95: astore_1
    //   96: aload_0
    //   97: monitorexit
    //   98: aload_1
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	FileManagerRSCenter
    //   0	100	1	paramString	String
    //   35	11	2	localIterator	Iterator
    //   54	27	3	localObject	Object
    //   9	6	4	i	int
    // Exception table:
    //   from	to	target	type
    //   2	11	95	finally
    //   23	36	95	finally
    //   36	87	95	finally
  }
  
  public void a()
  {
    int i;
    IFileHttpBase localIFileHttpBase;
    try
    {
      i = Utils.a(BaseApplication.getContext());
      if (i == 1) {
        break label443;
      }
      if (i != 2) {
        break label437;
      }
    }
    finally {}
    int[] arrayOfInt = new int[2];
    long[] arrayOfLong = new long[2];
    String str1 = "";
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    String str4 = "";
    label153:
    int j;
    int k;
    while (localIterator.hasNext())
    {
      Long localLong = (Long)localIterator.next();
      localIFileHttpBase = (IFileHttpBase)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localLong);
      if (localIFileHttpBase == null)
      {
        str4 = str4 + "!!!!runRSWorker error, get worker null!!! sessionID[" + localLong + "]\n";
      }
      else
      {
        if (localIFileHttpBase.a() == 0) {
          break label449;
        }
        if (localIFileHttpBase.a() != 6) {
          break label253;
        }
        break label449;
        if (!localIFileHttpBase.a()) {
          break label353;
        }
        if (arrayOfInt[j] >= i) {
          break label434;
        }
        if (j != 1) {
          break label338;
        }
        k = 0;
      }
    }
    for (;;)
    {
      if ((k >= arrayOfInt[j]) || (arrayOfLong[k] == localIFileHttpBase.b()))
      {
        if (k != arrayOfInt[j]) {
          break label470;
        }
        localIFileHttpBase.g();
        for (;;)
        {
          if (!TextUtils.isEmpty(str4)) {
            QLog.e("FileManagerRSCenter<FileAssistant>", 1, str4);
          }
          if (!TextUtils.isEmpty(str1)) {
            QLog.i("FileManagerRSCenter<FileAssistant>", 1, str1);
          }
          return;
          label253:
          if ((localIFileHttpBase.a() == 1) || (localIFileHttpBase.a() == 8) || (localIFileHttpBase.a() == 5)) {
            break label455;
          }
          str1 = str1 + "type[" + localIFileHttpBase.a() + "] is not processed, maxtype is " + 8 + "\n";
          break;
          label338:
          localIFileHttpBase.g();
        }
        label353:
        if (j == 1) {
          if (arrayOfInt[j] >= 2) {
            String str3 = str2 + "type[" + localIFileHttpBase.a() + "] count is " + arrayOfInt[j] + "\n";
          } else {
            arrayOfLong[arrayOfInt[j]] = localIFileHttpBase.b();
          }
        }
        break label473;
        label434:
        break label470;
        label437:
        i = 2;
        break;
        label443:
        i = 1;
        break;
        label449:
        j = 1;
        break label153;
        label455:
        j = 0;
        break label153;
      }
      k += 1;
    }
    for (;;)
    {
      label470:
      break;
      label473:
      arrayOfInt[j] += 1;
    }
  }
  
  public void a(long paramLong)
  {
    try
    {
      IFileHttpBase localIFileHttpBase = (IFileHttpBase)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Long.valueOf(paramLong));
      if (localIFileHttpBase != null) {
        localIFileHttpBase.c();
      }
      if (QLog.isColorLevel()) {
        QLog.d("FileManagerRSCenter<FileAssistant>", 2, "remove worker, sessionId[" + String.valueOf(paramLong) + "]");
      }
      this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(Long.valueOf(paramLong));
      a();
      return;
    }
    finally {}
  }
  
  public void a(long paramLong1, long paramLong2, String paramString, int paramInt1, int paramInt2)
  {
    FileManagerEntity localFileManagerEntity2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong1);
    FileManagerEntity localFileManagerEntity1 = localFileManagerEntity2;
    if (localFileManagerEntity2 == null) {
      localFileManagerEntity1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong2, paramString, paramInt1);
    }
    if (localFileManagerEntity1 == null)
    {
      QLog.e("FileManagerRSCenter<FileAssistant>", 1, "entity is null ,why you can choose!!!");
      return;
    }
    if ((localFileManagerEntity1.cloudType != 2) && (localFileManagerEntity1.cloudType != 0))
    {
      if (FileUtil.b(localFileManagerEntity1.getFilePath()))
      {
        localFileManagerEntity1.status = 1;
        localFileManagerEntity1.cloudType = 3;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localFileManagerEntity1);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 3, null);
        return;
      }
      if (TextUtils.isEmpty(localFileManagerEntity1.Uuid))
      {
        FileManagerUtil.a(BaseApplicationImpl.getContext().getString(2131362871));
        localFileManagerEntity1.status = 16;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localFileManagerEntity1);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 3, null);
        return;
      }
    }
    localFileManagerEntity1.nOpType = paramInt2;
    if (this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(Long.valueOf(paramLong1)) == true)
    {
      QLog.w("FileManagerRSCenter<FileAssistant>", 1, "woker is process!");
      return;
    }
    b(localFileManagerEntity1);
  }
  
  public void a(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity.bDelInFM == true)
    {
      paramFileManagerEntity.bDelInFM = false;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 3, null);
    }
    Object localObject;
    int i;
    if (!FileUtils.b(paramFileManagerEntity.getFilePath()))
    {
      QLog.e("FileManagerRSCenter<FileAssistant>", 1, "nSessionId[" + String.valueOf(paramFileManagerEntity.nSessionId) + "]file is not exist or empty,path[" + paramFileManagerEntity.getFilePath() + "], please check file!");
      localObject = FileManagerUtil.a();
      if ((paramFileManagerEntity.getFilePath() == null) || (paramFileManagerEntity.getFilePath().length() == 0))
      {
        localObject = "filePathNull:" + (String)localObject;
        i = 9005;
      }
    }
    for (;;)
    {
      switch (paramFileManagerEntity.nOpType)
      {
      }
      for (;;)
      {
        paramFileManagerEntity.status = 16;
        paramFileManagerEntity.fProgress = 1.0F;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramFileManagerEntity);
        return;
        if (!FileManagerUtil.b(paramFileManagerEntity.getFilePath()))
        {
          localObject = "fileNotExists:" + (String)localObject;
          i = 9042;
          break;
        }
        if (FileManagerUtil.a(paramFileManagerEntity.getFilePath()) != 0L) {
          break label765;
        }
        localObject = "fileExistsEmpty:" + (String)localObject;
        i = 9071;
        break;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramFileManagerEntity.uniseq, paramFileManagerEntity.nSessionId, paramFileManagerEntity.peerUin, paramFileManagerEntity.peerType, 15, null, 1, null);
        paramFileManagerEntity.status = 0;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramFileManagerEntity);
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity.nSessionId, "actFileUp", 0L, "", paramFileManagerEntity.peerUin, paramFileManagerEntity.Uuid, paramFileManagerEntity.strFileMd5, i, "", 0L, 0L, paramFileManagerEntity.fileSize, "", "", 0, (String)localObject, null);
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity.nSessionId, "actFileUpDetail", 0L, "", paramFileManagerEntity.peerUin, paramFileManagerEntity.Uuid, paramFileManagerEntity.strFileMd5, i, "", 0L, 0L, paramFileManagerEntity.fileSize, "", "", 0, (String)localObject, null);
        continue;
        paramFileManagerEntity.status = 0;
        paramFileManagerEntity.isReaded = false;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramFileManagerEntity);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramFileManagerEntity.uniseq, paramFileManagerEntity.nSessionId, paramFileManagerEntity.peerUin, paramFileManagerEntity.peerType, 38, null, 1, null);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity.nSessionId, "actFileWyUp", 0L, "", paramFileManagerEntity.peerUin, paramFileManagerEntity.Uuid, paramFileManagerEntity.strFileMd5, i, "", 0L, 0L, paramFileManagerEntity.fileSize, "", "", 0, (String)localObject, null);
      }
      if (paramFileManagerEntity.peerType == 3000) {
        localObject = new DiscFileOperator(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity);
      }
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_JavaUtilLinkedHashMap.put(Long.valueOf(paramFileManagerEntity.nSessionId), localObject);
          if (QLog.isColorLevel()) {
            QLog.d("FileManagerRSCenter<FileAssistant>", 2, "Add a New Send Work!, sessionId[" + String.valueOf(paramFileManagerEntity.nSessionId) + "]");
          }
          a();
          return;
        }
        finally {}
        localObject = (ShieldMsgManger)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(15);
        if ((localObject != null) && (((ShieldMsgManger)localObject).a(paramFileManagerEntity.peerUin)))
        {
          paramFileManagerEntity.isReaded = false;
          if (paramFileManagerEntity.status != 16) {}
          for (i = 0;; i = 16)
          {
            paramFileManagerEntity.status = i;
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramFileManagerEntity);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramFileManagerEntity.uniseq, paramFileManagerEntity.nSessionId, paramFileManagerEntity.peerUin, paramFileManagerEntity.peerType, 15, null, -1, "该好友已被屏蔽！请先解除屏蔽！");
            return;
          }
        }
        if (paramFileManagerEntity.nOpType == 0) {
          localObject = new OfflineSendWorker(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity);
        } else {
          localObject = new FileManagerRSWorker(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity);
        }
      }
      label765:
      i = 0;
    }
  }
  
  /* Error */
  public void a(String paramString, long paramLong, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 38	com/tencent/mobileqq/filemanager/core/FileManagerRSCenter:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6: invokevirtual 70	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/filemanager/core/FileManagerDataCenter;
    //   9: lload_2
    //   10: aload_1
    //   11: iload 4
    //   13: ldc2_w 360
    //   16: invokevirtual 75	com/tencent/mobileqq/filemanager/core/FileManagerDataCenter:a	(JLjava/lang/String;IJ)Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   19: astore 5
    //   21: aload 5
    //   23: ifnonnull +50 -> 73
    //   26: ldc 10
    //   28: iconst_1
    //   29: new 144	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   36: ldc_w 363
    //   39: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_1
    //   43: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: ldc_w 365
    //   49: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: lload_2
    //   53: invokestatic 206	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   56: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: ldc -48
    //   61: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokestatic 184	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   70: aload_0
    //   71: monitorexit
    //   72: return
    //   73: aload_0
    //   74: aload 5
    //   76: getfield 81	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   79: invokevirtual 367	com/tencent/mobileqq/filemanager/core/FileManagerRSCenter:a	(J)V
    //   82: goto -12 -> 70
    //   85: astore_1
    //   86: aload_0
    //   87: monitorexit
    //   88: aload_1
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	FileManagerRSCenter
    //   0	90	1	paramString	String
    //   0	90	2	paramLong	long
    //   0	90	4	paramInt	int
    //   19	56	5	localFileManagerEntity	FileManagerEntity
    // Exception table:
    //   from	to	target	type
    //   2	21	85	finally
    //   26	70	85	finally
    //   73	82	85	finally
  }
  
  public void a(boolean paramBoolean)
  {
    for (;;)
    {
      Object localObject2;
      try
      {
        int i = this.jdField_a_of_type_JavaUtilLinkedHashMap.size();
        if (i < 1) {
          return;
        }
        ArrayList localArrayList = new ArrayList();
        localObject2 = this.jdField_a_of_type_JavaUtilLinkedHashMap.values().iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localArrayList.add(0, (IFileHttpBase)((Iterator)localObject2).next());
          continue;
        }
        this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
      }
      finally {}
      Iterator localIterator = ((List)localObject1).iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (IFileHttpBase)localIterator.next();
        ((IFileHttpBase)localObject2).d();
        if (!paramBoolean) {
          ((IFileHttpBase)localObject2).e();
        } else {
          ((IFileHttpBase)localObject2).a(null);
        }
      }
      if (paramBoolean) {
        FileManagerUtil.a(BaseApplicationImpl.getContext().getString(2131362812));
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 3, null);
    }
  }
  
  /* Error */
  public boolean a(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 36	com/tencent/mobileqq/filemanager/core/FileManagerRSCenter:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   6: lload_1
    //   7: invokestatic 57	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   10: invokevirtual 61	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   13: checkcast 63	com/tencent/mobileqq/filemanager/discoperation/IFileHttpBase
    //   16: astore_3
    //   17: aload_3
    //   18: ifnull +25 -> 43
    //   21: aload_3
    //   22: invokeinterface 400 1 0
    //   27: aload_0
    //   28: getfield 36	com/tencent/mobileqq/filemanager/core/FileManagerRSCenter:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   31: lload_1
    //   32: invokestatic 57	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   35: invokevirtual 214	java/util/LinkedHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   38: pop
    //   39: aload_0
    //   40: invokevirtual 216	com/tencent/mobileqq/filemanager/core/FileManagerRSCenter:a	()V
    //   43: aload_0
    //   44: getfield 38	com/tencent/mobileqq/filemanager/core/FileManagerRSCenter:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   47: invokevirtual 70	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/filemanager/core/FileManagerDataCenter;
    //   50: lload_1
    //   51: invokevirtual 220	com/tencent/mobileqq/filemanager/core/FileManagerDataCenter:a	(J)Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   54: astore_3
    //   55: aload_3
    //   56: ifnull +35 -> 91
    //   59: aload_3
    //   60: getfield 84	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   63: iconst_2
    //   64: if_icmpne +27 -> 91
    //   67: aload_3
    //   68: iconst_3
    //   69: putfield 84	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   72: aload_0
    //   73: getfield 38	com/tencent/mobileqq/filemanager/core/FileManagerRSCenter:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   76: invokevirtual 70	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/filemanager/core/FileManagerDataCenter;
    //   79: aload_3
    //   80: invokevirtual 235	com/tencent/mobileqq/filemanager/core/FileManagerDataCenter:c	(Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;)V
    //   83: iconst_1
    //   84: istore 4
    //   86: aload_0
    //   87: monitorexit
    //   88: iload 4
    //   90: ireturn
    //   91: iconst_0
    //   92: istore 4
    //   94: goto -8 -> 86
    //   97: astore_3
    //   98: aload_0
    //   99: monitorexit
    //   100: aload_3
    //   101: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	this	FileManagerRSCenter
    //   0	102	1	paramLong	long
    //   16	64	3	localObject1	Object
    //   97	4	3	localObject2	Object
    //   84	9	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	17	97	finally
    //   21	43	97	finally
    //   43	55	97	finally
    //   59	83	97	finally
  }
  
  /* Error */
  public boolean a(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_0
    //   6: getfield 36	com/tencent/mobileqq/filemanager/core/FileManagerRSCenter:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   9: invokevirtual 97	java/util/LinkedHashMap:size	()I
    //   12: istore_3
    //   13: iload_3
    //   14: iconst_1
    //   15: if_icmpge +8 -> 23
    //   18: aload_0
    //   19: monitorexit
    //   20: iload 4
    //   22: ireturn
    //   23: aload_0
    //   24: getfield 36	com/tencent/mobileqq/filemanager/core/FileManagerRSCenter:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   27: invokevirtual 101	java/util/LinkedHashMap:keySet	()Ljava/util/Set;
    //   30: invokeinterface 107 1 0
    //   35: astore_2
    //   36: aload_2
    //   37: invokeinterface 113 1 0
    //   42: ifeq -24 -> 18
    //   45: aload_2
    //   46: invokeinterface 117 1 0
    //   51: checkcast 53	java/lang/Long
    //   54: astore_2
    //   55: aload_0
    //   56: getfield 36	com/tencent/mobileqq/filemanager/core/FileManagerRSCenter:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   59: aload_2
    //   60: invokevirtual 61	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   63: checkcast 63	com/tencent/mobileqq/filemanager/discoperation/IFileHttpBase
    //   66: invokeinterface 402 1 0
    //   71: astore_2
    //   72: aload_2
    //   73: invokestatic 175	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   76: ifne +49 -> 125
    //   79: aload_1
    //   80: aload_2
    //   81: invokestatic 408	com/tencent/qphone/base/util/MD5:toMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   84: invokevirtual 411	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   87: ifeq +9 -> 96
    //   90: iconst_1
    //   91: istore 4
    //   93: goto -75 -> 18
    //   96: aload_1
    //   97: aload_2
    //   98: ldc_w 413
    //   101: ldc -114
    //   103: invokevirtual 417	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   106: invokestatic 420	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   109: invokevirtual 411	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   112: istore 4
    //   114: iload 4
    //   116: ifeq +9 -> 125
    //   119: iconst_1
    //   120: istore 4
    //   122: goto -104 -> 18
    //   125: iconst_1
    //   126: istore 4
    //   128: goto -110 -> 18
    //   131: astore_1
    //   132: aload_0
    //   133: monitorexit
    //   134: aload_1
    //   135: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	this	FileManagerRSCenter
    //   0	136	1	paramString	String
    //   35	63	2	localObject	Object
    //   12	4	3	i	int
    //   1	126	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   5	13	131	finally
    //   23	36	131	finally
    //   36	90	131	finally
    //   96	114	131	finally
  }
  
  /* Error */
  public boolean a(String paramString, long paramLong, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 38	com/tencent/mobileqq/filemanager/core/FileManagerRSCenter:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6: invokevirtual 70	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/filemanager/core/FileManagerDataCenter;
    //   9: lload_2
    //   10: aload_1
    //   11: iload 4
    //   13: ldc2_w 360
    //   16: invokevirtual 75	com/tencent/mobileqq/filemanager/core/FileManagerDataCenter:a	(JLjava/lang/String;IJ)Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   19: astore_1
    //   20: aload_1
    //   21: ifnonnull +11 -> 32
    //   24: iconst_0
    //   25: istore 5
    //   27: aload_0
    //   28: monitorexit
    //   29: iload 5
    //   31: ireturn
    //   32: aload_0
    //   33: aload_1
    //   34: getfield 81	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   37: invokevirtual 423	com/tencent/mobileqq/filemanager/core/FileManagerRSCenter:a	(J)Z
    //   40: istore 5
    //   42: goto -15 -> 27
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_1
    //   49: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	this	FileManagerRSCenter
    //   0	50	1	paramString	String
    //   0	50	2	paramLong	long
    //   0	50	4	paramInt	int
    //   25	16	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	20	45	finally
    //   32	42	45	finally
  }
  
  /* Error */
  public FileManagerEntity b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 36	com/tencent/mobileqq/filemanager/core/FileManagerRSCenter:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   6: invokevirtual 97	java/util/LinkedHashMap:size	()I
    //   9: istore 4
    //   11: iload 4
    //   13: iconst_1
    //   14: if_icmpge +9 -> 23
    //   17: aconst_null
    //   18: astore_1
    //   19: aload_0
    //   20: monitorexit
    //   21: aload_1
    //   22: areturn
    //   23: aload_0
    //   24: getfield 36	com/tencent/mobileqq/filemanager/core/FileManagerRSCenter:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   27: invokevirtual 101	java/util/LinkedHashMap:keySet	()Ljava/util/Set;
    //   30: invokeinterface 107 1 0
    //   35: astore_2
    //   36: aload_2
    //   37: invokeinterface 113 1 0
    //   42: ifeq +48 -> 90
    //   45: aload_2
    //   46: invokeinterface 117 1 0
    //   51: checkcast 53	java/lang/Long
    //   54: astore_3
    //   55: aload_0
    //   56: getfield 36	com/tencent/mobileqq/filemanager/core/FileManagerRSCenter:jdField_a_of_type_JavaUtilLinkedHashMap	Ljava/util/LinkedHashMap;
    //   59: aload_3
    //   60: invokevirtual 61	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   63: checkcast 63	com/tencent/mobileqq/filemanager/discoperation/IFileHttpBase
    //   66: astore_3
    //   67: aload_1
    //   68: aload_3
    //   69: invokeinterface 402 1 0
    //   74: invokevirtual 426	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   77: ifeq -41 -> 36
    //   80: aload_3
    //   81: invokeinterface 129 1 0
    //   86: astore_1
    //   87: goto -68 -> 19
    //   90: aconst_null
    //   91: astore_1
    //   92: goto -73 -> 19
    //   95: astore_1
    //   96: aload_0
    //   97: monitorexit
    //   98: aload_1
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	FileManagerRSCenter
    //   0	100	1	paramString	String
    //   35	11	2	localIterator	Iterator
    //   54	27	3	localObject	Object
    //   9	6	4	i	int
    // Exception table:
    //   from	to	target	type
    //   2	11	95	finally
    //   23	36	95	finally
    //   36	87	95	finally
  }
  
  public void b(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity.bDelInFM == true)
    {
      paramFileManagerEntity.bDelInFM = false;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 3, null);
    }
    FileManagerRSWorker localFileManagerRSWorker = new FileManagerRSWorker(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity);
    try
    {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(Long.valueOf(paramFileManagerEntity.nSessionId), localFileManagerRSWorker);
      if (QLog.isColorLevel()) {
        QLog.d("FileManagerRSCenter<FileAssistant>", 2, "Add a New Recv Work!, sessionId[" + String.valueOf(paramFileManagerEntity.nSessionId) + "]");
      }
      a();
      return;
    }
    finally {}
  }
  
  public void c(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {}
    for (;;)
    {
      try
      {
        QLog.e("FileManagerRSCenter<FileAssistant>", 1, "entry is null, retry ge mao!");
        return;
      }
      finally {}
      IFileHttpBase localIFileHttpBase = (IFileHttpBase)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Long.valueOf(paramFileManagerEntity.nSessionId));
      if ((localIFileHttpBase == null) || (localIFileHttpBase.a())) {
        break;
      }
      QLog.i("FileManagerRSCenter<FileAssistant>", 1, "uniseq[ " + String.valueOf(paramFileManagerEntity.uniseq) + " ],sessionid[ " + String.valueOf(paramFileManagerEntity.nSessionId) + " ] work,is procressing!");
    }
    switch (paramFileManagerEntity.nOpType)
    {
    }
    for (;;)
    {
      QLog.e("FileManagerRSCenter<FileAssistant>", 1, "Unknow actionType!");
      break;
      a(paramFileManagerEntity);
      break;
      b(paramFileManagerEntity);
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\filemanager\core\FileManagerRSCenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */