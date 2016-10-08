package com.tencent.mobileqq.troop.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.troop.file.TroopFileProtocol;
import com.tencent.biz.troop.file.TroopFileProtocol.GetOneFileInfoObserver;
import com.tencent.biz.troop.file.TroopFileProtocol.ReqCopyToObserver;
import com.tencent.biz.troop.file.TroopFileProtocol.ReqDownloadFileObserver;
import com.tencent.biz.troop.file.TroopFileProtocol.ReqFeedsObserver;
import com.tencent.biz.troop.file.TroopFileProtocol.ReqResendFileObserver;
import com.tencent.biz.troop.file.TroopFileProtocol.ReqUploadFileObserver;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.TroopFileTansferItemEntity;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.IForwardCallBack;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.ProxyIpManager;
import vpu;
import vpw;
import vpx;
import vpz;
import vqa;
import vqc;
import vqe;
import vqf;
import vqh;
import vqi;
import vqj;
import vqk;

public class TroopFileTransferManager
  implements INetInfoHandler
{
  public static final int a = 100;
  public static final String a = "TroopFileTransferManager";
  public static Map a;
  public static final int b = 0;
  public static final int c = 1;
  public static final int d = 1;
  public static final int e = 2;
  public static final int f = 32768;
  public static final long f = 4294967296L;
  public static final int g = 8;
  public static final int h = 16;
  public static final int i = 1007;
  public static final int j = 3;
  public static final int k = 1024;
  public static final int l = 16384;
  public static final int m = 4096;
  public static final int n = 3;
  public static final int o = 30000;
  public static final int p = 30000;
  public static final int q = 300000;
  public static final int r = 128;
  public static final int s = 383;
  public static final int t = 640;
  public static final int u = 1000;
  public static final int v = 5000;
  public static final int w = 10000;
  public long a;
  private Handler jdField_a_of_type_AndroidOsHandler = new vqc(this, Looper.getMainLooper());
  private TroopFileProtocol.GetOneFileInfoObserver jdField_a_of_type_ComTencentBizTroopFileTroopFileProtocol$GetOneFileInfoObserver = new vqi(this);
  private TroopFileProtocol.ReqCopyToObserver jdField_a_of_type_ComTencentBizTroopFileTroopFileProtocol$ReqCopyToObserver = new vpw(this);
  private TroopFileProtocol.ReqDownloadFileObserver jdField_a_of_type_ComTencentBizTroopFileTroopFileProtocol$ReqDownloadFileObserver = new vqk(this);
  private TroopFileProtocol.ReqFeedsObserver jdField_a_of_type_ComTencentBizTroopFileTroopFileProtocol$ReqFeedsObserver = new vqh(this);
  private TroopFileProtocol.ReqResendFileObserver jdField_a_of_type_ComTencentBizTroopFileTroopFileProtocol$ReqResendFileObserver = new vqe(this);
  private TroopFileProtocol.ReqUploadFileObserver jdField_a_of_type_ComTencentBizTroopFileTroopFileProtocol$ReqUploadFileObserver = new vqf(this);
  public QQAppInterface a;
  private TroopFileManager jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager;
  public Timer a;
  private ProxyIpManager jdField_a_of_type_MqqManagerProxyIpManager;
  public boolean a;
  public TroopFileTransferManager.TaskPool[] a;
  public long b;
  private TroopFileProtocol.ReqCopyToObserver b;
  public Map b;
  public boolean b;
  public long c;
  public Map c;
  public long d;
  public volatile long e;
  public long g;
  public long h;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    if (!TroopFileTransferManager.class.desiredAssertionStatus()) {}
    for (bool = true;; bool = false)
    {
      jdField_c_of_type_Boolean = bool;
      return;
    }
  }
  
  public TroopFileTransferManager(QQAppInterface paramQQAppInterface, long paramLong)
  {
    this.jdField_b_of_type_ComTencentBizTroopFileTroopFileProtocol$ReqCopyToObserver = new vpx(this);
    this.jdField_a_of_type_ArrayOfComTencentMobileqqTroopUtilsTroopFileTransferManager$TaskPool = new TroopFileTransferManager.TaskPool[] { new TroopFileTransferManager.TaskPool(1), new TroopFileTransferManager.TaskPool(1), new TroopFileTransferManager.TaskPool(2), new TroopFileTransferManager.TaskPool(2), new TroopFileTransferManager.TaskPool(2) };
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.g = paramLong;
    AppNetConnInfo.registerConnectionChangeReceiver(paramQQAppInterface.getApplication(), this);
  }
  
  public static TroopFileTransferManager a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    try
    {
      if (jdField_a_of_type_JavaUtilMap == null)
      {
        jdField_a_of_type_JavaUtilMap = new HashMap();
        ThreadManager.a(new vpu(), 2, null, true);
      }
      TroopFileUploadingManager.a(paramQQAppInterface);
      TroopFileTransferManager localTroopFileTransferManager2 = (TroopFileTransferManager)jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
      TroopFileTransferManager localTroopFileTransferManager1;
      if (localTroopFileTransferManager2 != null)
      {
        localTroopFileTransferManager1 = localTroopFileTransferManager2;
        if (localTroopFileTransferManager2.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == paramQQAppInterface) {}
      }
      else
      {
        localTroopFileTransferManager1 = new TroopFileTransferManager(paramQQAppInterface, paramLong);
        localTroopFileTransferManager1.c();
        jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramLong), localTroopFileTransferManager1);
      }
      return localTroopFileTransferManager1;
    }
    finally {}
  }
  
  public static void a()
  {
    try
    {
      if (jdField_a_of_type_JavaUtilMap == null) {
        return;
      }
      Iterator localIterator = jdField_a_of_type_JavaUtilMap.values().iterator();
      while (localIterator.hasNext())
      {
        TroopFileTransferManager localTroopFileTransferManager = (TroopFileTransferManager)localIterator.next();
        localTroopFileTransferManager.k();
        AppNetConnInfo.unregisterNetInfoHandler(localTroopFileTransferManager);
      }
      jdField_a_of_type_JavaUtilMap.clear();
    }
    finally {}
  }
  
  public static void a(long paramLong)
  {
    for (;;)
    {
      try
      {
        Iterator localIterator = jdField_a_of_type_JavaUtilMap.values().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        TroopFileTransferManager localTroopFileTransferManager = (TroopFileTransferManager)localIterator.next();
        if (localTroopFileTransferManager.g == paramLong) {
          localTroopFileTransferManager.j();
        } else {
          localTroopFileTransferManager.i();
        }
      }
      finally {}
    }
  }
  
  private void b(TroopFileTransferManager.Item paramItem, int paramInt1, int paramInt2)
  {
    if (paramItem == null) {
      return;
    }
    switch (paramInt1)
    {
    case 4: 
    case 5: 
    case 7: 
    case 8: 
    default: 
      return;
    case 2: 
    case 6: 
      TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "upload", true, paramItem.transferBeginTime, paramItem.UploadIp, this.g + "", FileUtil.a(paramItem.FileName), paramItem.FilePath, paramInt2, paramItem.transferedSize, paramItem.ProgressTotal, paramItem.uploadUrl, paramItem.rspHeadStr, paramItem.retryTimes);
      return;
    case 10: 
      TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "download", false, paramItem.transferBeginTime, paramItem.DownloadIp, this.g + "", FileUtil.a(paramItem.FileName), paramItem.FilePath, paramInt2, paramItem.transferedSize, paramItem.ProgressTotal, paramItem.downUrlStr4Report, paramItem.rspHeadStr, paramItem.retryTimes);
      return;
    case 9: 
    case 11: 
      TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "download", true, paramItem.transferBeginTime, paramItem.DownloadIp, this.g + "", FileUtil.a(paramItem.FileName), paramItem.FilePath, paramInt2, paramItem.transferedSize, paramItem.ProgressTotal, paramItem.downUrlStr4Report, paramItem.rspHeadStr, paramItem.retryTimes);
      return;
    }
    TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "upload", false, paramItem.transferBeginTime, paramItem.UploadIp, this.g + "", FileUtil.a(paramItem.FileName), paramItem.FilePath, paramInt2, paramItem.transferedSize, paramItem.ProgressTotal, paramItem.uploadUrl, paramItem.rspHeadStr, paramItem.retryTimes);
  }
  
  private final void f(TroopFileTransferManager.Item paramItem)
  {
    paramItem.ErrorCode = 0;
    a(paramItem, 12);
  }
  
  public static void g()
  {
    try
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilMap.values().iterator();
      while (localIterator.hasNext()) {
        ((TroopFileTransferManager)localIterator.next()).i();
      }
    }
    finally {}
  }
  
  public static void h()
  {
    try
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilMap.values().iterator();
      while (localIterator.hasNext()) {
        ((TroopFileTransferManager)localIterator.next()).j();
      }
    }
    finally {}
  }
  
  private void k()
  {
    for (;;)
    {
      try
      {
        Iterator localIterator = this.jdField_b_of_type_JavaUtilMap.values().iterator();
        if (localIterator.hasNext())
        {
          TroopFileTransferManager.Item localItem = (TroopFileTransferManager.Item)localIterator.next();
          switch (localItem.Status)
          {
          case 0: 
          case 1: 
          case 8: 
            localItem.Pausing = -1;
            continue;
          }
        }
      }
      finally {}
      return;
    }
  }
  
  public final int a()
  {
    try
    {
      c();
      int i1 = 0;
      Iterator localIterator = this.jdField_b_of_type_JavaUtilMap.values().iterator();
      if (localIterator.hasNext())
      {
        TroopFileTransferManager.Item localItem = (TroopFileTransferManager.Item)localIterator.next();
        if (localItem != null)
        {
          int i2 = localItem.Status;
          switch (i2)
          {
          }
        }
        for (;;)
        {
          break;
          i1 += 1;
        }
      }
      return i1;
    }
    finally {}
  }
  
  public final TroopFileStatusInfo a(FileManagerEntity paramFileManagerEntity, String paramString)
  {
    for (;;)
    {
      synchronized (a())
      {
        try
        {
          TroopFileInfo localTroopFileInfo = ???.a(paramFileManagerEntity.strTroopFilePath, paramFileManagerEntity.fileName, paramFileManagerEntity.fileSize, paramFileManagerEntity.busId);
          if (localTroopFileInfo == null) {
            return null;
          }
          if (QLog.isColorLevel()) {
            QLog.d("TroopFileTransferManager", 2, "startDownload==>" + localTroopFileInfo.toString());
          }
          localTroopFileInfo.jdField_a_of_type_JavaUtilUUID = UUID.fromString(paramFileManagerEntity.strTroopFileID);
          c();
          TroopFileTransferManager.Item localItem = (TroopFileTransferManager.Item)this.jdField_b_of_type_JavaUtilMap.get(localTroopFileInfo.jdField_a_of_type_JavaUtilUUID);
          if (localItem == null)
          {
            localItem = new TroopFileTransferManager.Item(localTroopFileInfo);
            this.jdField_b_of_type_JavaUtilMap.put(localItem.Id, localItem);
            localItem.FileName = paramFileManagerEntity.fileName;
            localItem.ProgressTotal = paramFileManagerEntity.fileSize;
            localItem.ProgressValue = 0L;
            localItem.isZipInnerFile = true;
            localItem.PreviewUrl = paramString;
            new TroopFileTransferManager.TaskHttpDownload(this, localItem);
            a(localItem, 8);
            paramFileManagerEntity = FileUtil.a(paramFileManagerEntity.fileName);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Clk_fileslist_download", 0, 0, "", this.g + "", paramFileManagerEntity, "");
            paramFileManagerEntity = localItem.getInfo(this.g);
            return paramFileManagerEntity;
          }
          if (localItem.Status != 7) {
            return null;
          }
        }
        finally {}
      }
    }
  }
  
  public final TroopFileStatusInfo a(String paramString)
  {
    if (paramString == null) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      try
      {
        c();
        Iterator localIterator = this.jdField_b_of_type_JavaUtilMap.values().iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            TroopFileTransferManager.Item localItem = (TroopFileTransferManager.Item)localIterator.next();
            if (paramString.equals(localItem.FilePath))
            {
              paramString = localItem.getInfo(this.g);
              break;
            }
          }
        }
        paramString = null;
      }
      finally {}
    }
  }
  
  public final TroopFileStatusInfo a(String paramString1, long paramLong1, String paramString2, String paramString3, long paramLong2, int paramInt1, int paramInt2, long paramLong3)
  {
    synchronized (a()) {}
  }
  
  public final TroopFileStatusInfo a(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    for (;;)
    {
      synchronized (a())
      {
        try
        {
          TroopFileInfo localTroopFileInfo = ???.a(paramString1, paramString2, paramLong, paramInt);
          if (localTroopFileInfo == null) {
            return null;
          }
          if (QLog.isColorLevel()) {
            QLog.d("TroopFileTransferManager", 2, "startDownload==>" + localTroopFileInfo.toString());
          }
          c();
          paramString1 = (TroopFileTransferManager.Item)this.jdField_b_of_type_JavaUtilMap.get(localTroopFileInfo.jdField_a_of_type_JavaUtilUUID);
          if (paramString1 == null)
          {
            paramString1 = new TroopFileTransferManager.Item(localTroopFileInfo);
            this.jdField_b_of_type_JavaUtilMap.put(paramString1.Id, paramString1);
            paramString1.FileName = paramString2;
            paramString1.ProgressTotal = paramLong;
            paramString1.ProgressValue = 0L;
            a(paramString1, 0, false);
            paramString2 = FileUtil.a(paramString2);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Clk_fileslist_download", 0, 0, "", this.g + "", paramString2, "");
            paramString1 = paramString1.getInfo(this.g);
            return paramString1;
          }
          if (paramString1.Status != 7) {
            return null;
          }
        }
        finally {}
      }
    }
  }
  
  /* Error */
  public final TroopFileStatusInfo a(String paramString1, String paramString2, String paramString3, long paramLong1, int paramInt1, int paramInt2, long paramLong2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 327	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	()Lcom/tencent/mobileqq/troop/utils/TroopFileManager;
    //   6: aload_1
    //   7: aload_2
    //   8: lload 4
    //   10: bipush 102
    //   12: invokevirtual 469	com/tencent/mobileqq/troop/utils/TroopFileManager:b	(Ljava/lang/String;Ljava/lang/String;JI)Lcom/tencent/mobileqq/troop/data/TroopFileInfo;
    //   15: astore_1
    //   16: aload_1
    //   17: ifnonnull +9 -> 26
    //   20: aconst_null
    //   21: astore_1
    //   22: aload_0
    //   23: monitorexit
    //   24: aload_1
    //   25: areturn
    //   26: aload_0
    //   27: invokevirtual 201	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:c	()V
    //   30: new 247	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item
    //   33: dup
    //   34: aload_1
    //   35: invokespecial 374	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:<init>	(Lcom/tencent/mobileqq/troop/data/TroopFileInfo;)V
    //   38: astore_1
    //   39: aload_0
    //   40: getfield 316	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:jdField_b_of_type_JavaUtilMap	Ljava/util/Map;
    //   43: aload_1
    //   44: getfield 377	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Id	Ljava/util/UUID;
    //   47: aload_1
    //   48: invokeinterface 205 3 0
    //   53: pop
    //   54: aload_1
    //   55: iload 7
    //   57: putfield 419	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:RandomNum	I
    //   60: aload_1
    //   61: lload 8
    //   63: putfield 425	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ForwardTroopuin	J
    //   66: aload_1
    //   67: iload 6
    //   69: putfield 428	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ForwardBusId	I
    //   72: aload_1
    //   73: iconst_4
    //   74: putfield 319	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Status	I
    //   77: aload_1
    //   78: aload_3
    //   79: putfield 431	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   82: aload_0
    //   83: aload_1
    //   84: iconst_4
    //   85: iconst_0
    //   86: invokevirtual 462	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   89: aload_1
    //   90: aload_0
    //   91: getfield 151	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:g	J
    //   94: invokevirtual 405	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:getInfo	(J)Lcom/tencent/mobileqq/troop/data/TroopFileStatusInfo;
    //   97: astore_1
    //   98: goto -76 -> 22
    //   101: astore_1
    //   102: aload_0
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	this	TroopFileTransferManager
    //   0	106	1	paramString1	String
    //   0	106	2	paramString2	String
    //   0	106	3	paramString3	String
    //   0	106	4	paramLong1	long
    //   0	106	6	paramInt1	int
    //   0	106	7	paramInt2	int
    //   0	106	8	paramLong2	long
    // Exception table:
    //   from	to	target	type
    //   2	16	101	finally
    //   26	98	101	finally
  }
  
  /* Error */
  public final TroopFileStatusInfo a(String paramString1, String paramString2, String paramString3, long paramLong1, int paramInt1, int paramInt2, long paramLong2, long paramLong3)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 327	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	()Lcom/tencent/mobileqq/troop/utils/TroopFileManager;
    //   6: aload_2
    //   7: lload 4
    //   9: bipush 102
    //   11: invokevirtual 416	com/tencent/mobileqq/troop/utils/TroopFileManager:a	(Ljava/lang/String;JI)Lcom/tencent/mobileqq/troop/data/TroopFileInfo;
    //   14: astore_1
    //   15: invokestatic 351	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   18: ifeq +32 -> 50
    //   21: ldc 12
    //   23: iconst_2
    //   24: new 255	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 256	java/lang/StringBuilder:<init>	()V
    //   31: ldc_w 472
    //   34: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: aload_1
    //   38: invokevirtual 356	com/tencent/mobileqq/troop/data/TroopFileInfo:toString	()Ljava/lang/String;
    //   41: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: invokevirtual 269	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 359	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   50: aload_1
    //   51: ifnonnull +9 -> 60
    //   54: aconst_null
    //   55: astore_1
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_1
    //   59: areturn
    //   60: aload_0
    //   61: invokevirtual 201	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:c	()V
    //   64: new 247	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item
    //   67: dup
    //   68: aload_1
    //   69: invokespecial 374	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:<init>	(Lcom/tencent/mobileqq/troop/data/TroopFileInfo;)V
    //   72: astore_1
    //   73: aload_0
    //   74: getfield 316	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:jdField_b_of_type_JavaUtilMap	Ljava/util/Map;
    //   77: aload_1
    //   78: getfield 377	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Id	Ljava/util/UUID;
    //   81: aload_1
    //   82: invokeinterface 205 3 0
    //   87: pop
    //   88: aload_1
    //   89: iload 7
    //   91: putfield 419	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:RandomNum	I
    //   94: aload_1
    //   95: lload 8
    //   97: putfield 425	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ForwardTroopuin	J
    //   100: aload_1
    //   101: iload 6
    //   103: putfield 428	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ForwardBusId	I
    //   106: aload_1
    //   107: iconst_4
    //   108: putfield 319	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Status	I
    //   111: aload_1
    //   112: aload_3
    //   113: putfield 431	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   116: aload_1
    //   117: lload 10
    //   119: putfield 434	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:entrySessionID	J
    //   122: aload_0
    //   123: aload_1
    //   124: iconst_4
    //   125: iconst_0
    //   126: invokevirtual 462	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   129: aload_1
    //   130: aload_0
    //   131: getfield 151	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:g	J
    //   134: invokevirtual 405	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:getInfo	(J)Lcom/tencent/mobileqq/troop/data/TroopFileStatusInfo;
    //   137: astore_1
    //   138: goto -82 -> 56
    //   141: astore_1
    //   142: aload_0
    //   143: monitorexit
    //   144: aload_1
    //   145: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	TroopFileTransferManager
    //   0	146	1	paramString1	String
    //   0	146	2	paramString2	String
    //   0	146	3	paramString3	String
    //   0	146	4	paramLong1	long
    //   0	146	6	paramInt1	int
    //   0	146	7	paramInt2	int
    //   0	146	8	paramLong2	long
    //   0	146	10	paramLong3	long
    // Exception table:
    //   from	to	target	type
    //   2	50	141	finally
    //   60	138	141	finally
  }
  
  public final TroopFileStatusInfo a(String paramString, boolean paramBoolean)
  {
    return a(paramString, paramBoolean, Math.abs(new Random().nextInt()));
  }
  
  public final TroopFileStatusInfo a(String paramString, boolean paramBoolean, int paramInt)
  {
    synchronized (a()) {}
    try
    {
      paramString = ???.b(paramString);
      if (paramString == null) {
        return null;
      }
      c();
      paramString = new TroopFileTransferManager.Item(paramString);
      this.jdField_b_of_type_JavaUtilMap.put(paramString.Id, paramString);
      paramString.BusId = 102;
      paramString.isFromAIO = paramBoolean;
      paramString.RandomNum = paramInt;
      if (NetworkUtil.a(BaseApplication.getContext()) == 0)
      {
        a(paramString, 3, 106);
        paramString = paramString.getInfo(this.g);
        return paramString;
        paramString = finally;
        throw paramString;
      }
      new TroopFileTransferManager.TaskScan(this, paramString);
      paramString = paramString.getInfo(this.g);
      return paramString;
    }
    finally {}
  }
  
  /* Error */
  public final TroopFileStatusInfo a(UUID paramUUID)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 201	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:c	()V
    //   6: aload_0
    //   7: getfield 316	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:jdField_b_of_type_JavaUtilMap	Ljava/util/Map;
    //   10: aload_1
    //   11: invokeinterface 197 2 0
    //   16: checkcast 247	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item
    //   19: astore_1
    //   20: aload_1
    //   21: ifnonnull +9 -> 30
    //   24: aconst_null
    //   25: astore_1
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_1
    //   29: areturn
    //   30: aload_1
    //   31: aload_0
    //   32: getfield 151	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:g	J
    //   35: invokevirtual 405	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:getInfo	(J)Lcom/tencent/mobileqq/troop/data/TroopFileStatusInfo;
    //   38: astore_1
    //   39: goto -13 -> 26
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	TroopFileTransferManager
    //   0	47	1	paramUUID	UUID
    // Exception table:
    //   from	to	target	type
    //   2	20	42	finally
    //   30	39	42	finally
  }
  
  public TroopFileManager a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager = TroopFileManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.g);
    }
    return this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager;
  }
  
  public final Collection a()
  {
    try
    {
      c();
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_b_of_type_JavaUtilMap.values().iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((TroopFileTransferManager.Item)localIterator.next()).getInfo(this.g));
      }
    }
    finally {}
    return localCollection;
  }
  
  public final List a()
  {
    try
    {
      c();
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_b_of_type_JavaUtilMap.values().iterator();
      while (localIterator.hasNext())
      {
        TroopFileTransferManager.Item localItem = (TroopFileTransferManager.Item)localIterator.next();
        if ((localItem != null) && (localItem.FilePath != null)) {
          localArrayList.add(localItem.getInfo(this.g));
        }
      }
    }
    finally {}
    return localList;
  }
  
  public ProxyIpManager a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return null;
    }
    if (this.jdField_a_of_type_MqqManagerProxyIpManager == null) {
      this.jdField_a_of_type_MqqManagerProxyIpManager = ((ProxyIpManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(3));
    }
    return this.jdField_a_of_type_MqqManagerProxyIpManager;
  }
  
  public void a(int paramInt, long paramLong)
  {
    try
    {
      if (NetworkUtil.b(BaseApplication.getContext()) == 1)
      {
        if (paramInt == 0) {
          this.jdField_b_of_type_Long += paramLong;
        }
        for (;;)
        {
          return;
          if (paramInt == 1) {
            this.jdField_a_of_type_Long += paramLong;
          }
        }
      }
      if (paramInt != 0) {
        break label75;
      }
    }
    finally {}
    this.d += paramLong;
    for (;;)
    {
      b();
      break;
      label75:
      if (paramInt == 1) {
        this.jdField_c_of_type_Long += paramLong;
      }
    }
  }
  
  public final void a(int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3, String paramString1, String paramString2, long paramLong3, String paramString3, boolean paramBoolean, long paramLong4, IForwardCallBack paramIForwardCallBack)
  {
    int i2 = Math.abs(new Random().nextInt());
    synchronized (a())
    {
      if ((paramInt2 == 102) || (paramInt2 == 104)) {}
    }
    for (;;)
    {
      int i1;
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager == null) {
          this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager = a();
        }
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.a(paramString3);
        if (localObject != null)
        {
          paramInt2 = ((TroopFileInfo)localObject).jdField_a_of_type_Int;
          break label296;
          localObject = ???.a(paramString1, paramLong3, paramInt2);
          if (localObject != null) {}
        }
        else
        {
          paramInt2 = 102;
          break label296;
          if ((paramInt3 != 7) && (paramInt3 != 6003)) {
            break label290;
          }
          i1 = 38;
          continue;
        }
        c();
        localObject = new TroopFileTransferManager.Item((TroopFileInfo)localObject);
        this.jdField_b_of_type_JavaUtilMap.put(((TroopFileTransferManager.Item)localObject).Id, localObject);
        ((TroopFileTransferManager.Item)localObject).RandomNum = i2;
        ((TroopFileTransferManager.Item)localObject).ForwardPath = paramString3;
        ((TroopFileTransferManager.Item)localObject).ForwardTroopuin = paramLong1;
        ((TroopFileTransferManager.Item)localObject).mForwardCallback = paramIForwardCallBack;
        if (!paramBoolean)
        {
          paramLong1 = paramIForwardCallBack.a(String.valueOf(paramLong2), paramInt3, String.valueOf(paramLong1), paramInt2, paramString3, paramString1, paramString2, paramLong3, paramInt1);
          ((TroopFileTransferManager.Item)localObject).ForwardBusId = paramInt2;
          ((TroopFileTransferManager.Item)localObject).BusId = i1;
          TroopFileProtocol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, this.g, (TroopFileTransferManager.Item)localObject, paramLong2, paramLong1, this.jdField_b_of_type_ComTencentBizTroopFileTroopFileProtocol$ReqCopyToObserver);
          return;
          paramString1 = finally;
          throw paramString1;
        }
        paramLong1 = paramLong4;
        continue;
        i1 = 3;
      }
      finally {}
      label290:
      continue;
      label296:
      if (paramInt3 == 3000) {
        i1 = 106;
      }
    }
  }
  
  public final void a(TroopFileStatusInfo paramTroopFileStatusInfo, boolean paramBoolean)
  {
    try
    {
      FileManagerEntity localFileManagerEntity = FileManagerUtil.a(paramTroopFileStatusInfo);
      localFileManagerEntity.isReaded = true;
      localFileManagerEntity.peerUin = String.valueOf(paramTroopFileStatusInfo.jdField_a_of_type_Long);
      localFileManagerEntity.peerNick = ContactUtils.m(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.peerUin);
      localFileManagerEntity.srvTime = (MessageCache.a() * 1000L);
      localFileManagerEntity.setCloudType(3);
      localFileManagerEntity.bSend = paramBoolean;
      localFileManagerEntity.status = 1;
      localFileManagerEntity.fProgress = 1.0F;
      localFileManagerEntity.TroopUin = this.g;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity);
      localFileManagerEntity.status = 1;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localFileManagerEntity);
      return;
    }
    finally
    {
      paramTroopFileStatusInfo = finally;
      throw paramTroopFileStatusInfo;
    }
  }
  
  public final void a(TroopFileTransferManager.Item paramItem)
  {
    try
    {
      long l1 = SystemClock.uptimeMillis() - this.h;
      long l2 = SystemClock.uptimeMillis() - paramItem.StatusUpdateTimeMs;
      if ((this.h == 0L) || (paramItem.StatusUpdateTimeMs == 0L) || (l2 > 5000L) || (l2 < 0L) || (l1 > 1000L) || (l1 < 0L))
      {
        this.h = (l1 + this.h);
        paramItem.StatusUpdateTimeMs += l2;
        ((BizTroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(22)).a(paramItem.getInfo(this.g));
      }
      return;
    }
    finally {}
  }
  
  public final void a(TroopFileTransferManager.Item paramItem, int paramInt)
  {
    a(paramItem, paramInt, 0);
  }
  
  public final void a(TroopFileTransferManager.Item paramItem, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    try
    {
      if (paramItem.Status != paramInt1) {
        bool = true;
      }
      paramItem.IsNewStatus = bool;
      if (paramItem.IsNewStatus) {
        b(paramItem, paramInt1, paramInt2);
      }
      paramItem.Status = paramInt1;
      paramItem.ErrorCode = paramInt2;
      paramItem.Pausing = 0;
      if (paramItem.W2MPause == TroopFileTransferManager.Item.W2MPauseEnum.W2M_PAUSE_NO_RESUME) {
        paramItem.W2MPause = TroopFileTransferManager.Item.W2MPauseEnum.W2M_PAUSE_NONE;
      }
      f();
      paramItem.StatusUpdateTimeMs = 0L;
      a(paramItem);
      paramItem.IsNewStatus = false;
      b(paramItem, paramInt2);
      return;
    }
    finally {}
  }
  
  public final void a(TroopFileTransferManager.Item paramItem, int paramInt, TroopFileError.SimpleErrorInfo paramSimpleErrorInfo)
  {
    boolean bool = false;
    try
    {
      if (paramItem.Status != paramInt) {
        bool = true;
      }
      paramItem.IsNewStatus = bool;
      paramItem.Status = paramInt;
      paramItem.ErrorCode = paramSimpleErrorInfo.jdField_a_of_type_Int;
      paramItem.Pausing = 0;
      if (paramItem.W2MPause == TroopFileTransferManager.Item.W2MPauseEnum.W2M_PAUSE_NO_RESUME) {
        paramItem.W2MPause = TroopFileTransferManager.Item.W2MPauseEnum.W2M_PAUSE_NONE;
      }
      f();
      paramItem.StatusUpdateTimeMs = 0L;
      a(paramItem);
      paramItem.IsNewStatus = false;
      TroopFileError.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramSimpleErrorInfo);
      return;
    }
    finally {}
  }
  
  public final void a(TroopFileTransferManager.Item paramItem, int paramInt, boolean paramBoolean)
  {
    Object localObject;
    try
    {
      localObject = paramItem.FilePath;
      if (localObject == null) {}
      for (;;)
      {
        return;
        if (paramInt == 0) {
          break;
        }
        if ((1 == NetworkUtil.a(BaseApplication.getContext())) || (paramInt != 128)) {
          break label59;
        }
        paramItem.ThumbnailDownloading_Small = false;
        paramItem.ThumbnailFileTimeMS_Small = 0L;
      }
      if (!paramBoolean) {}
    }
    finally {}
    for (;;)
    {
      label59:
      TroopFileProtocol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.g, paramItem, paramInt, paramBoolean, this.jdField_a_of_type_ComTencentBizTroopFileTroopFileProtocol$ReqDownloadFileObserver);
      break;
      a(paramItem, 8);
      localObject = (TroopFileInfo)a().jdField_c_of_type_JavaUtilMap.get(paramItem.FilePath);
      if (localObject != null)
      {
        TroopFileInfo localTroopFileInfo = (TroopFileInfo)a().jdField_c_of_type_JavaUtilMap.get(((TroopFileInfo)localObject).f);
        if (localTroopFileInfo != null)
        {
          ((TroopFileInfo)localObject).e = 8;
          localTroopFileInfo.a((TroopFileInfo)localObject);
        }
      }
    }
  }
  
  public final void a(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    synchronized (a()) {}
    try
    {
      if (TextUtils.isEmpty(paramString1)) {
        return;
      }
      paramString2 = ???.a(paramString2, paramLong, 25);
      if (paramString2 == null)
      {
        return;
        paramString1 = finally;
        throw paramString1;
      }
      c();
      paramString2 = new TroopFileTransferManager.Item(paramString2);
      this.jdField_b_of_type_JavaUtilMap.put(paramString2.Id, paramString2);
      paramString2.ForwardPath = paramString1;
      paramString2.ForwardTroopuin = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).longValue();
      paramString2.ForwardBusId = paramInt;
      paramString2.Status = 4;
      paramString2.BusId = 25;
      TroopFileProtocol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, this.g, paramString2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin(), 0L, this.jdField_b_of_type_ComTencentBizTroopFileTroopFileProtocol$ReqCopyToObserver);
      return;
    }
    finally {}
  }
  
  public final void a(Collection paramCollection, boolean paramBoolean)
  {
    for (;;)
    {
      Object localObject;
      synchronized (a())
      {
        try
        {
          if (NetworkUtil.a(BaseApplication.getContext()) == 0)
          {
            i1 = 1;
            paramCollection = paramCollection.iterator();
            if (!paramCollection.hasNext()) {
              break;
            }
            localObject = ???.b((String)paramCollection.next());
            if (localObject == null) {
              continue;
            }
            c();
            localObject = new TroopFileTransferManager.Item((TroopFileInfo)localObject);
            this.jdField_b_of_type_JavaUtilMap.put(((TroopFileTransferManager.Item)localObject).Id, localObject);
            ((TroopFileTransferManager.Item)localObject).BusId = 102;
            ((TroopFileTransferManager.Item)localObject).isFromAIO = paramBoolean;
            if (i1 == 0) {
              break label135;
            }
            a((TroopFileTransferManager.Item)localObject, 3, 106);
            continue;
            paramCollection = finally;
          }
        }
        finally {}
      }
      int i1 = 0;
      continue;
      label135:
      new TroopFileTransferManager.TaskScan(this, (TroopFileTransferManager.Item)localObject);
    }
  }
  
  /* Error */
  public final void a(UUID paramUUID)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 201	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:c	()V
    //   6: aload_0
    //   7: monitorenter
    //   8: aload_0
    //   9: getfield 316	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:jdField_b_of_type_JavaUtilMap	Ljava/util/Map;
    //   12: aload_1
    //   13: invokeinterface 197 2 0
    //   18: checkcast 247	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item
    //   21: astore_2
    //   22: aload_0
    //   23: monitorexit
    //   24: new 712	vqd
    //   27: dup
    //   28: aload_0
    //   29: aload_2
    //   30: aload_1
    //   31: invokespecial 715	vqd:<init>	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;Ljava/util/UUID;)V
    //   34: iconst_5
    //   35: aconst_null
    //   36: iconst_0
    //   37: invokestatic 180	com/tencent/mobileqq/app/ThreadManager:a	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   40: aload_0
    //   41: monitorexit
    //   42: return
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    //   48: astore_1
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_1
    //   52: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	53	0	this	TroopFileTransferManager
    //   0	53	1	paramUUID	UUID
    //   21	9	2	localItem	TroopFileTransferManager.Item
    // Exception table:
    //   from	to	target	type
    //   8	24	43	finally
    //   44	46	43	finally
    //   2	8	48	finally
    //   24	40	48	finally
    //   46	48	48	finally
  }
  
  public final void a(UUID paramUUID, String paramString)
  {
    try
    {
      paramUUID = (TroopFileTransferManager.Item)this.jdField_b_of_type_JavaUtilMap.get(paramUUID);
      if (paramUUID != null)
      {
        paramUUID.FilePath = paramString;
        paramUUID.BusId = 102;
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public final boolean a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 718	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:jdField_a_of_type_Boolean	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifne +9 -> 17
    //   11: iconst_0
    //   12: istore_2
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_2
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 149	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   21: aload_0
    //   22: getfield 316	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:jdField_b_of_type_JavaUtilMap	Ljava/util/Map;
    //   25: aload_0
    //   26: getfield 151	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:g	J
    //   29: invokestatic 723	com/tencent/mobileqq/troop/utils/SerializableManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/util/Map;J)Z
    //   32: istore_2
    //   33: goto -20 -> 13
    //   36: astore_1
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_1
    //   40: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	this	TroopFileTransferManager
    //   36	4	1	localObject	Object
    //   6	27	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	36	finally
    //   17	33	36	finally
  }
  
  public boolean a(long paramLong, UUID paramUUID, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    synchronized (a()) {}
    for (;;)
    {
      Object localObject;
      try
      {
        if (QLog.isColorLevel())
        {
          localObject = "";
          if (paramUUID != null) {
            localObject = paramUUID.toString();
          }
          QLog.d("TroopFileTransferManager", 2, String.format("finishCopyFrom - sessionId: %s, UUID: %s retCode: %d strNewPath:%s strErrorMsg:%s", new Object[] { paramLong + "", localObject, Integer.valueOf(paramInt), paramString2, paramString3 }));
        }
        localObject = null;
        if (paramUUID != null) {
          localObject = ???.a(paramUUID);
        }
        if (paramString1 == null) {
          break label946;
        }
        paramUUID = ???.a(paramString1);
        if (paramUUID == null) {
          return false;
        }
        c();
        paramString1 = (TroopFileTransferManager.Item)this.jdField_b_of_type_JavaUtilMap.get(paramUUID.jdField_a_of_type_JavaUtilUUID);
        if (paramString1 == null)
        {
          return false;
          paramUUID = finally;
          throw paramUUID;
        }
        if (paramString1.Status != 4) {
          return false;
        }
        if (paramInt >= 0) {
          break label762;
        }
        i1 = 207;
        switch (paramInt)
        {
        default: 
          if (TextUtils.isEmpty(paramString2))
          {
            if (!TextUtils.isEmpty(paramString3)) {
              break label736;
            }
            paramUUID = new TroopFileError.SimpleErrorInfo(paramString1.FileName, this.g, 5, 207);
            a(paramString1, 5, paramUUID);
            return true;
          }
        case -20001: 
        case -20000: 
        case -403: 
          paramUUID = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong);
          if (paramUUID == null)
          {
            if (!TextUtils.isEmpty(paramString3))
            {
              a(paramString1, 5, new TroopFileError.SimpleErrorInfo(paramString1.FileName, this.g, 5, 704, paramString3));
              return false;
            }
            QLog.e("TroopFileTransferManager", 1, "finishCopyFrom, but entity is null!!!sessionId:" + paramLong);
            a(paramString1, 5, i1);
            return true;
          }
          if (paramUUID.busId == 104) {
            continue;
          }
          paramUUID.busId = 104;
          paramString1.BusId = 104;
          if (paramUUID.nOpType == 27)
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramUUID, 27);
            if (QLog.isColorLevel()) {
              QLog.e("TroopFileTransferManager", 2, String.format("retCode:%d is, change busid to 104, try ForwardFromOfflineFile again!", new Object[] { Integer.valueOf(paramInt) }));
            }
            return true;
          }
          if (paramUUID.nOpType != 26) {
            continue;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(104, paramUUID);
          break;
        case -3: 
          i1 = 202;
        }
      }
      finally {}
      continue;
      int i1 = 600;
      continue;
      i1 = 701;
      continue;
      new Handler(Looper.getMainLooper()).postDelayed(new vpz(this, paramString1), 1000L);
      return true;
      if ((!TextUtils.isEmpty(paramString1.LocalFile)) && (new File(paramString1.LocalFile).exists()))
      {
        a(paramString1, 0);
        paramString1.BusId = 102;
        new TroopFileTransferManager.TaskScan(this, paramString1);
        return true;
      }
      i1 = 603;
      continue;
      i1 = 705;
      continue;
      a(paramString1, 5, new TroopFileError.SimpleErrorInfo(paramString1.FileName, this.g, 5, 704, paramString3));
      return true;
      label736:
      paramUUID = new TroopFileError.SimpleErrorInfo(paramString1.FileName, this.g, 5, 704, paramString3);
      continue;
      label762:
      if (TextUtils.isEmpty(paramString2))
      {
        if (TextUtils.isEmpty(paramString3)) {}
        for (paramUUID = new TroopFileError.SimpleErrorInfo(paramString1.FileName, this.g, 5, 207);; paramUUID = new TroopFileError.SimpleErrorInfo(paramString1.FileName, this.g, 5, 704, paramString3))
        {
          a(paramString1, 5, paramUUID);
          return true;
        }
      }
      paramUUID.b = paramString2;
      paramString1.FilePath = paramString2;
      paramString3 = paramString1.getInfo(this.g);
      if (paramString3 != null) {
        paramString3.e = paramString2;
      }
      paramString3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1.entrySessionID);
      if (paramString3 != null) {
        paramString3.strTroopFilePath = paramString2;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.a(paramUUID.b, paramUUID);
      }
      a(paramString1, 6, 0);
      d(paramString1);
      return true;
      label946:
      paramUUID = (UUID)localObject;
    }
  }
  
  /* Error */
  public final boolean a(TroopFileTransferManager.Item paramItem)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_1
    //   5: getfield 322	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Pausing	I
    //   8: ifeq +28 -> 36
    //   11: aload_1
    //   12: getfield 322	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Pausing	I
    //   15: iconst_1
    //   16: if_icmpne +15 -> 31
    //   19: iconst_2
    //   20: istore_2
    //   21: aload_0
    //   22: aload_1
    //   23: iload_2
    //   24: invokevirtual 314	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;I)V
    //   27: aload_0
    //   28: monitorexit
    //   29: iload_3
    //   30: ireturn
    //   31: iconst_3
    //   32: istore_2
    //   33: goto -12 -> 21
    //   36: iconst_0
    //   37: istore_3
    //   38: goto -11 -> 27
    //   41: astore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	this	TroopFileTransferManager
    //   0	46	1	paramItem	TroopFileTransferManager.Item
    //   20	13	2	i1	int
    //   1	37	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   4	19	41	finally
    //   21	27	41	finally
  }
  
  public final boolean a(TroopFileTransferManager.Item paramItem, int paramInt)
  {
    if (paramInt == 128) {}
    for (;;)
    {
      boolean bool;
      try
      {
        paramItem.HasThumbnailFile_Small = new File(paramItem.getThumbnailFile(this.g, paramInt)).exists();
        if (paramItem.HasThumbnailFile_Small) {
          paramItem.ThumbnailFileTimeMS_Small = 0L;
        }
        bool = paramItem.HasThumbnailFile_Small;
        return bool;
      }
      finally {}
      if (paramInt == 640)
      {
        paramItem.HasThumbnailFile_Large = new File(paramItem.getThumbnailFile(this.g, paramInt)).exists();
        if (paramItem.HasThumbnailFile_Large) {
          paramItem.ThumbnailFileTimeMS_Large = 0L;
        }
        bool = paramItem.HasThumbnailFile_Large;
      }
      else if (paramInt == 383)
      {
        paramItem.HasThumbnailFile_Middle = new File(paramItem.getThumbnailFile(this.g, paramInt)).exists();
        if (paramItem.HasThumbnailFile_Middle) {
          paramItem.ThumbnailFileTimeMS_Middle = 0L;
        }
        bool = paramItem.HasThumbnailFile_Middle;
      }
      else
      {
        bool = false;
      }
    }
  }
  
  public final boolean a(String paramString1, String paramString2)
  {
    boolean bool;
    if (paramString1 == null) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      try
      {
        paramString1 = UUID.fromString(paramString1);
        if (paramString1 == null)
        {
          bool = false;
          continue;
        }
        c();
        paramString1 = (TroopFileTransferManager.Item)this.jdField_b_of_type_JavaUtilMap.get(paramString1);
        if (paramString1 == null)
        {
          bool = false;
          continue;
        }
        paramString1.NameForSave = paramString2;
        paramString1.LocalFile = (AppConstants.bv + paramString2);
        a();
        ((BizTroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(22)).a(paramString1.getInfo(this.g));
        bool = true;
      }
      finally {}
    }
  }
  
  public final boolean a(String paramString1, String paramString2, int paramInt)
  {
    synchronized (a())
    {
      try
      {
        TroopFileInfo localTroopFileInfo = ???.a(paramString1, paramString2, 0L, paramInt);
        if (localTroopFileInfo == null) {
          return false;
        }
        c();
        paramString2 = (TroopFileTransferManager.Item)this.jdField_b_of_type_JavaUtilMap.get(localTroopFileInfo.jdField_a_of_type_JavaUtilUUID);
        paramString1 = paramString2;
        if (paramString2 == null)
        {
          paramString1 = new TroopFileTransferManager.Item(localTroopFileInfo);
          this.jdField_b_of_type_JavaUtilMap.put(paramString1.Id, paramString1);
        }
        e(paramString1);
        return true;
      }
      finally {}
    }
  }
  
  public final boolean a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    synchronized (a())
    {
      try
      {
        if (FileManagerUtil.a(FileUtil.a(paramString2)) != 0) {
          return false;
        }
        TroopFileInfo localTroopFileInfo = ???.a(paramString1, paramString2, 0L, paramInt1);
        if (localTroopFileInfo == null) {
          return false;
        }
        c();
        paramString2 = (TroopFileTransferManager.Item)this.jdField_b_of_type_JavaUtilMap.get(localTroopFileInfo.jdField_a_of_type_JavaUtilUUID);
        paramString1 = paramString2;
        if (paramString2 == null)
        {
          paramString1 = new TroopFileTransferManager.Item(localTroopFileInfo);
          this.jdField_b_of_type_JavaUtilMap.put(paramString1.Id, paramString1);
        }
        c(paramString1, paramInt2);
        return true;
      }
      finally {}
    }
  }
  
  public boolean a(String paramString1, String paramString2, long paramLong, int paramInt, TroopFileProtocol.ReqDownloadFileObserver paramReqDownloadFileObserver)
  {
    for (;;)
    {
      synchronized (a())
      {
        try
        {
          TroopFileInfo localTroopFileInfo = ???.a(paramString1, paramString2, paramLong, paramInt);
          if (localTroopFileInfo == null) {
            return false;
          }
          if (QLog.isColorLevel()) {
            QLog.d("TroopFileTransferManager", 2, "startDownload==>" + localTroopFileInfo.toString());
          }
          c();
          paramString1 = (TroopFileTransferManager.Item)this.jdField_b_of_type_JavaUtilMap.get(localTroopFileInfo.jdField_a_of_type_JavaUtilUUID);
          if (paramString1 == null)
          {
            paramString1 = new TroopFileTransferManager.Item(localTroopFileInfo);
            this.jdField_b_of_type_JavaUtilMap.put(paramString1.Id, paramString1);
            paramString1.FileName = paramString2;
            paramString1.ProgressTotal = paramLong;
            paramString1.ProgressValue = 0L;
            TroopFileProtocol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.g, paramString1, 0, false, paramReqDownloadFileObserver);
            return true;
          }
          if (paramString1.Status != 7) {
            return false;
          }
        }
        finally {}
      }
    }
  }
  
  public final boolean a(UUID paramUUID)
  {
    for (;;)
    {
      try
      {
        c();
        paramUUID = (TroopFileTransferManager.Item)this.jdField_b_of_type_JavaUtilMap.get(paramUUID);
        if (paramUUID == null)
        {
          bool = false;
          return bool;
        }
        switch (paramUUID.Status)
        {
        case 4: 
        case 5: 
        case 7: 
        case 8: 
          if (!QLog.isDevelopLevel()) {
            break label314;
          }
          QLog.e("TroopFileTransferManager", 4, "deleteItem error, status:" + paramUUID.Status);
        }
      }
      finally {}
      if (paramUUID.TmpFile != null) {
        new File(paramUUID.TmpFile).delete();
      }
      if (paramUUID.HasThumbnailFile_Small) {
        new File(paramUUID.getThumbnailFile(this.g, 128)).delete();
      }
      if (paramUUID.HasThumbnailFile_Large) {
        new File(paramUUID.getThumbnailFile(this.g, 640)).delete();
      }
      if (paramUUID.HasThumbnailFile_Middle) {
        new File(paramUUID.getThumbnailFile(this.g, 383)).delete();
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopFileTransferManager", 4, "delete " + paramUUID.Id + "[" + paramUUID.FilePath + "]" + paramUUID.Status);
      }
      f(paramUUID);
      boolean bool = true;
      continue;
      continue;
      label314:
      bool = false;
    }
  }
  
  public final boolean a(UUID paramUUID, int paramInt)
  {
    synchronized (a()) {}
    try
    {
      TroopFileInfo localTroopFileInfo = ???.a(paramUUID);
      if (localTroopFileInfo == null) {
        return false;
      }
      if (FileManagerUtil.a(FileUtil.a(localTroopFileInfo.c)) != 0)
      {
        return false;
        paramUUID = finally;
        throw paramUUID;
      }
      ThreadManager.a(new vqj(this, paramUUID, localTroopFileInfo, paramInt), 5, null, true);
      return true;
    }
    finally {}
  }
  
  public final boolean a(UUID paramUUID, int paramInt, String paramString1, String paramString2)
  {
    return a(0L, paramUUID, null, paramInt, paramString1, paramString2);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Long != 0L)
      {
        localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        l1 = this.jdField_a_of_type_Long;
        localQQAppInterface.a(str, new String[] { "param_WIFIGroupFileDownloadFlow", "param_WIFIFlow", "param_Flow" }, l1);
        if (QLog.isDevelopLevel()) {
          QLog.d("param_WIFIGroupFileDownloadFlow", 4, this.jdField_a_of_type_Long + "");
        }
        this.jdField_a_of_type_Long = 0L;
      }
      if (this.jdField_b_of_type_Long != 0L)
      {
        localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        l1 = this.jdField_b_of_type_Long;
        localQQAppInterface.a(str, new String[] { "param_WIFIGroupFileUploadFlow", "param_WIFIFlow", "param_Flow" }, l1);
        if (QLog.isDevelopLevel()) {
          QLog.d("param_WIFIGroupFileUploadFlow", 4, this.jdField_b_of_type_Long + "");
        }
        this.jdField_b_of_type_Long = 0L;
      }
      if ((this.d != 0L) || (this.jdField_c_of_type_Long != 0L))
      {
        localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        l1 = this.jdField_c_of_type_Long;
        long l2 = this.d;
        localQQAppInterface.a(str, new String[] { "param_XGFileFlow", "param_XGFlow", "param_Flow" }, l1 + l2);
        if (QLog.isDevelopLevel()) {
          QLog.d("param_XGFileFlow", 4, this.jdField_c_of_type_Long + this.d + "");
        }
      }
      if (this.jdField_c_of_type_Long != 0L)
      {
        localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        l1 = this.jdField_c_of_type_Long;
        localQQAppInterface.a(str, new String[] { "param_XGGroupFileDownloadFlow", "param_XGFlow", "param_Flow" }, l1);
        if (QLog.isDevelopLevel()) {
          QLog.d("param_XGGroupFileDownloadFlow", 4, this.jdField_c_of_type_Long + "");
        }
        this.jdField_c_of_type_Long = 0L;
      }
    } while (this.d == 0L);
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    long l1 = this.d;
    localQQAppInterface.a(str, new String[] { "param_XGGroupFileUploadFlow", "param_XGFlow", "param_Flow" }, l1);
    if (QLog.isDevelopLevel()) {
      QLog.d("param_XGGroupFileUploadFlow", 4, this.d + "");
    }
    this.d = 0L;
  }
  
  public final void b(TroopFileTransferManager.Item paramItem)
  {
    try
    {
      a(paramItem, 1);
      TroopFileProtocol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.g, paramItem, this.jdField_a_of_type_ComTencentBizTroopFileTroopFileProtocol$ReqUploadFileObserver);
      return;
    }
    finally
    {
      paramItem = finally;
      throw paramItem;
    }
  }
  
  public final void b(TroopFileTransferManager.Item paramItem, int paramInt)
  {
    TroopFileError.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.g, paramItem.FileName, paramItem.Status, paramInt);
  }
  
  public final void b(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    synchronized (a()) {}
    try
    {
      if (TextUtils.isEmpty(paramString1)) {
        return;
      }
      paramString2 = ???.a(paramString2, paramLong, 25);
      if (paramString2 == null)
      {
        return;
        paramString1 = finally;
        throw paramString1;
      }
      c();
      paramString2 = new TroopFileTransferManager.Item(paramString2);
      this.jdField_b_of_type_JavaUtilMap.put(paramString2.Id, paramString2);
      this.jdField_c_of_type_JavaUtilMap.put(paramString2.Id, Integer.valueOf(Integer.MAX_VALUE));
      paramString2.ForwardPath = paramString1;
      paramString2.ForwardTroopuin = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).longValue();
      paramString2.ForwardBusId = paramInt;
      paramString2.Status = 4;
      paramString2.BusId = 25;
      TroopFileProtocol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, this.g, paramString2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin(), 0L, this.jdField_a_of_type_ComTencentBizTroopFileTroopFileProtocol$ReqCopyToObserver);
      return;
    }
    finally {}
  }
  
  /* Error */
  public final boolean b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 718	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:jdField_a_of_type_Boolean	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifne +9 -> 17
    //   11: iconst_0
    //   12: istore_2
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_2
    //   16: ireturn
    //   17: aload_0
    //   18: invokevirtual 910	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:c	()Z
    //   21: istore_2
    //   22: goto -9 -> 13
    //   25: astore_1
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_1
    //   29: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	30	0	this	TroopFileTransferManager
    //   25	4	1	localObject	Object
    //   6	16	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	25	finally
    //   17	22	25	finally
  }
  
  /* Error */
  public final boolean b(TroopFileTransferManager.Item paramItem)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_1
    //   5: getfield 322	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Pausing	I
    //   8: ifeq +30 -> 38
    //   11: aload_1
    //   12: getfield 322	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Pausing	I
    //   15: iconst_1
    //   16: if_icmpne +16 -> 32
    //   19: bipush 9
    //   21: istore_2
    //   22: aload_0
    //   23: aload_1
    //   24: iload_2
    //   25: invokevirtual 314	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;I)V
    //   28: aload_0
    //   29: monitorexit
    //   30: iload_3
    //   31: ireturn
    //   32: bipush 10
    //   34: istore_2
    //   35: goto -13 -> 22
    //   38: iconst_0
    //   39: istore_3
    //   40: goto -12 -> 28
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	TroopFileTransferManager
    //   0	48	1	paramItem	TroopFileTransferManager.Item
    //   21	14	2	i1	int
    //   1	39	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   4	19	43	finally
    //   22	28	43	finally
  }
  
  public final boolean b(UUID paramUUID)
  {
    for (;;)
    {
      try
      {
        c();
        paramUUID = (TroopFileTransferManager.Item)this.jdField_b_of_type_JavaUtilMap.get(paramUUID);
        if (paramUUID == null)
        {
          bool = false;
          return bool;
        }
        switch (paramUUID.Status)
        {
        case 2: 
          if (!QLog.isDevelopLevel()) {
            break label125;
          }
          QLog.d("TroopFileTransferManager", 4, "error status ResumeUpload");
        }
      }
      finally {}
      if (paramUUID.Md5 == null)
      {
        new TroopFileTransferManager.TaskScan(this, paramUUID);
      }
      else if (paramUUID.FilePath == null)
      {
        b(paramUUID);
      }
      else
      {
        c(paramUUID);
        break label130;
        continue;
        label125:
        bool = false;
        continue;
      }
      label130:
      boolean bool = true;
    }
  }
  
  public final void c()
  {
    try
    {
      boolean bool = this.jdField_a_of_type_Boolean;
      if (bool) {
        label11:
        return;
      }
      this.jdField_a_of_type_Boolean = true;
      List localList = SerializableManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.g);
      this.jdField_b_of_type_JavaUtilMap = new ConcurrentHashMap();
      this.jdField_c_of_type_JavaUtilMap = new ConcurrentHashMap();
      if ((!jdField_c_of_type_Boolean) && (localList == null)) {
        throw new AssertionError();
      }
    }
    finally {}
    Object localObject2;
    if (localObject1 != null)
    {
      localIterator = ((List)localObject1).iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (TroopFileTansferItemEntity)localIterator.next();
        if (((TroopFileTansferItemEntity)localObject2).Id != null) {
          this.jdField_b_of_type_JavaUtilMap.put(((TroopFileTansferItemEntity)localObject2).Id, new TroopFileTransferManager.Item((TroopFileTansferItemEntity)localObject2));
        }
      }
    }
    Iterator localIterator = this.jdField_b_of_type_JavaUtilMap.values().iterator();
    for (;;)
    {
      if (localIterator.hasNext()) {
        localObject2 = (TroopFileTransferManager.Item)localIterator.next();
      }
      switch (((TroopFileTransferManager.Item)localObject2).Status)
      {
      case 0: 
      case 1: 
        ((TroopFileTransferManager.Item)localObject2).Status = 3;
        break;
      case 8: 
        ((TroopFileTransferManager.Item)localObject2).Status = 10;
        continue;
        if (!c()) {
          break label11;
        }
        f();
        break label11;
      }
    }
  }
  
  public final void c(TroopFileTransferManager.Item paramItem)
  {
    try
    {
      a(paramItem, 1);
      TroopFileProtocol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.g, paramItem, this.jdField_a_of_type_ComTencentBizTroopFileTroopFileProtocol$ReqResendFileObserver);
      return;
    }
    finally
    {
      paramItem = finally;
      throw paramItem;
    }
  }
  
  public final void c(TroopFileTransferManager.Item paramItem, int paramInt)
  {
    if (!paramItem.canFetchThumbnailFile(paramInt)) {
      return;
    }
    if (a(paramItem, paramInt))
    {
      paramItem.StatusUpdateTimeMs = 0L;
      a(paramItem);
      return;
    }
    if (paramInt == 128)
    {
      paramItem.ThumbnailDownloading_Small = true;
      paramItem.ThumbnailFileTimeMS_Small = SystemClock.uptimeMillis();
    }
    while ((paramItem.LocalFile != null) && (new File(paramItem.LocalFile).exists()))
    {
      new TroopFileTransferManager.TaskGenThumbnail(this, paramItem, paramInt);
      return;
      if (paramInt == 640)
      {
        paramItem.ThumbnailDownloading_Large = true;
        paramItem.ThumbnailFileTimeMS_Large = SystemClock.uptimeMillis();
      }
      else if (paramInt == 383)
      {
        paramItem.ThumbnailDownloading_Middle = true;
        paramItem.ThumbnailFileTimeMS_Middle = SystemClock.uptimeMillis();
      }
    }
    a(paramItem, paramInt, false);
  }
  
  public final boolean c()
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilMap.values().iterator();
    TroopFileTransferManager.Item localItem;
    boolean bool2;
    for (boolean bool1 = false;; bool1 = true) {
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localItem = (TroopFileTransferManager.Item)localIterator.next();
          if ((!localItem.ThumbnailDownloading_Small) && (!localItem.ThumbnailDownloading_Large) && (!localItem.ThumbnailDownloading_Middle)) {
            switch (localItem.Status)
            {
            default: 
              bool2 = bool1;
              if ((!localItem.HasThumbnailFile_Small) || (a(localItem, 128))) {}
              break;
            }
          }
        }
      }
    }
    for (;;)
    {
      break;
      if (!TextUtils.isEmpty(localItem.LocalFile)) {
        if (new File(localItem.LocalFile).exists()) {}
      }
      for (bool1 = true;; bool1 = true)
      {
        bool2 = bool1;
        if (!bool1) {
          break;
        }
        a(localItem, 7);
        bool2 = bool1;
        break;
        if (QLog.isDevelopLevel()) {
          QLog.i("TroopFileTransferManager", 4, "_checkLocalFileExists, item.LocalFile is null, item.FileName" + localItem.FileName);
        }
      }
      if ((localItem.HasThumbnailFile_Large) && (!a(localItem, 640)))
      {
        bool1 = true;
      }
      else if ((localItem.HasThumbnailFile_Middle) && (!a(localItem, 383)))
      {
        bool1 = true;
        continue;
        return bool1;
      }
      else
      {
        bool1 = bool2;
      }
    }
  }
  
  public final boolean c(UUID arg1)
  {
    for (;;)
    {
      TroopFileTransferManager.Item localItem;
      try
      {
        c();
        localItem = (TroopFileTransferManager.Item)this.jdField_b_of_type_JavaUtilMap.get(???);
        if (localItem == null)
        {
          bool = false;
          return bool;
        }
        switch (localItem.Status)
        {
        case 0: 
          if (!QLog.isDevelopLevel()) {
            break label211;
          }
          QLog.d("TroopFileTransferManager", 4, "error status SuspendUpload");
        }
      }
      finally {}
      TroopFileTransferManager.TaskPool[] arrayOfTaskPool = this.jdField_a_of_type_ArrayOfComTencentMobileqqTroopUtilsTroopFileTransferManager$TaskPool;
      int i2 = arrayOfTaskPool.length;
      int i1 = 0;
      if (i1 < i2) {
        synchronized (arrayOfTaskPool[i1])
        {
          Iterator localIterator = ???.a.iterator();
          if (localIterator.hasNext())
          {
            TroopFileTransferManager.Task localTask = (TroopFileTransferManager.Task)localIterator.next();
            if ((localTask.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item != localItem) || (!localTask.jdField_a_of_type_Boolean)) {
              continue;
            }
            ???.a.remove(localTask);
            a(localItem, 2);
            bool = true;
            continue;
          }
          i1 += 1;
        }
      }
      ((TroopFileTransferManager.Item)localObject).Pausing = 1;
      boolean bool = true;
      continue;
      continue;
      label211:
      bool = false;
    }
  }
  
  public final void d()
  {
    if (this.jdField_a_of_type_JavaUtilTimer == null)
    {
      this.jdField_a_of_type_JavaUtilTimer = new Timer();
      this.jdField_a_of_type_JavaUtilTimer.schedule(new vqa(this), 10000L, 10000L);
    }
  }
  
  public final void d(TroopFileTransferManager.Item paramItem)
  {
    try
    {
      TroopFileProtocol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.g, paramItem, this.jdField_a_of_type_ComTencentBizTroopFileTroopFileProtocol$ReqFeedsObserver);
      return;
    }
    finally
    {
      paramItem = finally;
      throw paramItem;
    }
  }
  
  public final boolean d(UUID paramUUID)
  {
    TroopFileInfo localTroopFileInfo;
    TroopFileTransferManager.Item localItem2;
    TroopFileTransferManager.Item localItem1;
    synchronized (a()) {}
  }
  
  public final void e()
  {
    int i1 = 0;
    for (;;)
    {
      try
      {
        boolean bool = this.jdField_a_of_type_Boolean;
        if (!bool) {
          label15:
          return;
        }
        TroopFileTransferManager.TaskPool[] arrayOfTaskPool = this.jdField_a_of_type_ArrayOfComTencentMobileqqTroopUtilsTroopFileTransferManager$TaskPool;
        int i2 = arrayOfTaskPool.length;
        if (i1 >= i2) {
          break;
        }
        if (!arrayOfTaskPool[i1].a.isEmpty()) {
          d();
        } else {
          i1 += 1;
        }
      }
      finally {}
    }
    Iterator localIterator = this.jdField_b_of_type_JavaUtilMap.values().iterator();
    for (;;)
    {
      TroopFileTransferManager.Item localItem;
      if (localIterator.hasNext())
      {
        localItem = (TroopFileTransferManager.Item)localIterator.next();
        if ((localItem.ThumbnailDownloading_Small) || (localItem.ThumbnailDownloading_Large))
        {
          d();
          break;
        }
      }
      switch (localItem.Status)
      {
      case 0: 
      case 1: 
      case 8: 
        d();
        break label15;
        if (!a()) {
          break label15;
        }
        if (QLog.isDevelopLevel()) {
          QLog.i("TroopFileTransferManager", 4, "udmgr release mem");
        }
        this.jdField_b_of_type_JavaUtilMap = null;
        this.jdField_c_of_type_JavaUtilMap = null;
        this.jdField_a_of_type_Boolean = false;
        if (this.jdField_a_of_type_JavaUtilTimer == null) {
          break label15;
        }
        this.jdField_a_of_type_JavaUtilTimer.cancel();
        this.jdField_a_of_type_JavaUtilTimer = null;
        break label15;
      }
    }
  }
  
  public final void e(TroopFileTransferManager.Item paramItem)
  {
    a(paramItem, 0, true);
  }
  
  public final boolean e(UUID paramUUID)
  {
    for (;;)
    {
      try
      {
        c();
        paramUUID = (TroopFileTransferManager.Item)this.jdField_b_of_type_JavaUtilMap.get(paramUUID);
        if (paramUUID == null)
        {
          bool = false;
          return bool;
        }
        switch (paramUUID.Status)
        {
        case 9: 
        case 10: 
          if (paramUUID.isZipInnerFile)
          {
            a(paramUUID, 8);
            new TroopFileTransferManager.TaskHttpDownload(this, paramUUID);
          }
          else
          {
            a(paramUUID, 0, false);
          }
          break;
        }
      }
      finally {}
      boolean bool = false;
      continue;
      bool = true;
    }
  }
  
  /* Error */
  public final void f()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 1005	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:e	J
    //   8: lconst_0
    //   9: lcmp
    //   10: ifne +31 -> 41
    //   13: aload_0
    //   14: invokestatic 626	android/os/SystemClock:uptimeMillis	()J
    //   17: putfield 1005	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:e	J
    //   20: iload_2
    //   21: ifeq +17 -> 38
    //   24: new 1007	vqb
    //   27: dup
    //   28: aload_0
    //   29: invokespecial 1008	vqb:<init>	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;)V
    //   32: iconst_5
    //   33: aconst_null
    //   34: iconst_1
    //   35: invokestatic 180	com/tencent/mobileqq/app/ThreadManager:a	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   38: aload_0
    //   39: monitorexit
    //   40: return
    //   41: iconst_0
    //   42: istore_2
    //   43: goto -30 -> 13
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	TroopFileTransferManager
    //   46	4	1	localObject	Object
    //   1	42	2	i1	int
    // Exception table:
    //   from	to	target	type
    //   4	13	46	finally
    //   13	20	46	finally
    //   24	38	46	finally
  }
  
  public final boolean f(UUID arg1)
  {
    for (;;)
    {
      try
      {
        c();
        TroopFileTransferManager.Item localItem = (TroopFileTransferManager.Item)this.jdField_b_of_type_JavaUtilMap.get(???);
        if (localItem == null)
        {
          bool = false;
          return bool;
        }
        if (localItem.Status != 8)
        {
          bool = false;
          continue;
        }
        TroopFileTransferManager.TaskPool[] arrayOfTaskPool = this.jdField_a_of_type_ArrayOfComTencentMobileqqTroopUtilsTroopFileTransferManager$TaskPool;
        int i2 = arrayOfTaskPool.length;
        int i1 = 0;
        if (i1 < i2) {
          synchronized (arrayOfTaskPool[i1])
          {
            Iterator localIterator = ???.a.iterator();
            if (localIterator.hasNext())
            {
              TroopFileTransferManager.Task localTask = (TroopFileTransferManager.Task)localIterator.next();
              if ((localTask.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item != localItem) || (!localTask.b)) {
                continue;
              }
              ???.a.remove(localTask);
              a(localItem, 9);
              bool = true;
              continue;
            }
            i1 += 1;
          }
        }
        ((TroopFileTransferManager.Item)localObject).Pausing = 1;
      }
      finally {}
      boolean bool = true;
    }
  }
  
  public final void i()
  {
    try
    {
      c();
      Iterator localIterator = this.jdField_b_of_type_JavaUtilMap.values().iterator();
      while (localIterator.hasNext())
      {
        TroopFileTransferManager.Item localItem = (TroopFileTransferManager.Item)localIterator.next();
        if (localItem.W2MPause == TroopFileTransferManager.Item.W2MPauseEnum.W2M_PAUSE_CAN_RESUME) {
          localItem.W2MPause = TroopFileTransferManager.Item.W2MPauseEnum.W2M_PAUSE_NO_RESUME;
        }
      }
    }
    finally {}
  }
  
  public final void j()
  {
    for (;;)
    {
      TroopFileTransferManager.Item localItem;
      try
      {
        c();
        Iterator localIterator = this.jdField_b_of_type_JavaUtilMap.values().iterator();
        if (!localIterator.hasNext()) {
          break label153;
        }
        localItem = (TroopFileTransferManager.Item)localIterator.next();
        if (localItem.W2MPause != TroopFileTransferManager.Item.W2MPauseEnum.W2M_PAUSE_CAN_RESUME) {
          continue;
        }
        localItem.W2MPause = TroopFileTransferManager.Item.W2MPauseEnum.W2M_PAUSE_NONE;
        switch (localItem.Status)
        {
        case 0: 
        case 1: 
        case 8: 
          localItem.Pausing = 0;
          break;
        case 2: 
          b(localItem.Id);
        }
      }
      finally {}
      continue;
      e(localItem.Id);
      continue;
      label153:
      return;
    }
  }
  
  public void onNetMobile2None() {}
  
  public void onNetMobile2Wifi(String paramString) {}
  
  public void onNetNone2Mobile(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopFileTransferManager", 4, "onNetNone2Mobile");
    }
  }
  
  public void onNetNone2Wifi(String paramString) {}
  
  public void onNetWifi2Mobile(String paramString)
  {
    try
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopFileTransferManager", 4, "onNetWifi2Mobile");
      }
      boolean bool = this.jdField_a_of_type_Boolean;
      if (!bool) {
        label28:
        return;
      }
      int i1 = 0;
      paramString = this.jdField_b_of_type_JavaUtilMap.values().iterator();
      for (;;)
      {
        TroopFileTransferManager.Item localItem;
        if (paramString.hasNext()) {
          localItem = (TroopFileTransferManager.Item)paramString.next();
        }
        switch (localItem.Status)
        {
        case 0: 
        case 1: 
        case 8: 
          if (localItem.Pausing == 0)
          {
            localItem.Pausing = 1;
            localItem.W2MPause = TroopFileTransferManager.Item.W2MPauseEnum.W2M_PAUSE_CAN_RESUME;
            i1 = 1;
            break label153;
            if (i1 == 0) {
              break label28;
            }
            TroopFileError.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.g, 107);
            break label28;
          }
          break;
        }
      }
    }
    finally {}
  }
  
  public void onNetWifi2None()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopFileTransferManager", 4, "onNetWifi2None");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\utils\TroopFileTransferManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */