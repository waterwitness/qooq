package com.tencent.mobileqq.ark;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.component.network.utils.AssertUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.WeakReferenceHandler;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import qqw;
import qqy;
import qra;
import qrb;
import qrc;
import qre;
import qrg;
import qrh;
import qri;
import qrk;
import qrl;
import qrm;
import qrn;
import qro;
import qrp;
import qrq;
import qrr;
import qrs;
import qrt;
import qru;
import qrv;

public class ArkLocalAppMgr
  implements Handler.Callback
{
  public static final int a = 1380;
  public static final String a;
  private static final boolean jdField_a_of_type_Boolean = false;
  private static final int jdField_b_of_type_Int = 1916;
  private static final String jdField_b_of_type_JavaLangString = "ArkAppUpdateRecord";
  private static boolean jdField_b_of_type_Boolean = false;
  private static final int jdField_c_of_type_Int = 1917;
  private static final String jdField_c_of_type_JavaLangString = "ArkAppUpdatePeriod";
  private static final int jdField_d_of_type_Int = 60000;
  private static final String jdField_d_of_type_JavaLangString = "ArkApp.ArkLocalAppMgr";
  private static final int e = 300;
  private static final int f = 600000;
  private static final int g = 1020;
  private long jdField_a_of_type_Long;
  private final WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private final ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private final HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private long jdField_b_of_type_Long = 300L;
  private final WeakReference jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(this);
  private final ArrayList jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private final HashMap jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private long jdField_c_of_type_Long;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = AppConstants.bj + "ArkApp/Install/";
  }
  
  public ArkLocalAppMgr(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    h();
    a(10000);
  }
  
  private static ArkLocalAppMgr.AppPathInfo a(String paramString)
  {
    Object localObject2 = jdField_a_of_type_JavaLangString + paramString;
    Object localObject1 = localObject2;
    if (!((String)localObject2).endsWith("/")) {
      localObject1 = ((String)localObject2).concat("/");
    }
    File[] arrayOfFile = new File((String)localObject1).listFiles(new qrb());
    if (arrayOfFile == null) {
      localObject2 = null;
    }
    int j;
    int i;
    do
    {
      return (ArkLocalAppMgr.AppPathInfo)localObject2;
      j = arrayOfFile.length;
      localObject1 = null;
      i = 0;
      localObject2 = localObject1;
    } while (i >= j);
    File localFile = arrayOfFile[i];
    localObject2 = localFile.getName();
    int k = ((String)localObject2).lastIndexOf('.');
    if (k < 0) {
      localObject2 = localObject1;
    }
    for (;;)
    {
      i += 1;
      localObject1 = localObject2;
      break;
      String str1 = ((String)localObject2).substring(k);
      String str2 = ((String)localObject2).substring(0, k);
      localObject2 = localObject1;
      if (str1.toLowerCase().equals(".app"))
      {
        localObject2 = localObject1;
        if (d(str2)) {
          if (localObject1 == null)
          {
            localObject2 = new ArkLocalAppMgr.AppPathInfo();
            ((ArkLocalAppMgr.AppPathInfo)localObject2).jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDesc.jdField_a_of_type_JavaLangString = paramString;
            ((ArkLocalAppMgr.AppPathInfo)localObject2).jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDesc.c = str2;
            ((ArkLocalAppMgr.AppPathInfo)localObject2).jdField_a_of_type_JavaLangString = localFile.getAbsolutePath();
          }
          else
          {
            localObject2 = localObject1;
            if (b(str2, ((ArkLocalAppMgr.AppPathInfo)localObject1).jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDesc.c) > 0)
            {
              ((ArkLocalAppMgr.AppPathInfo)localObject1).jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDesc.jdField_a_of_type_JavaLangString = paramString;
              ((ArkLocalAppMgr.AppPathInfo)localObject1).jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDesc.c = str2;
              ((ArkLocalAppMgr.AppPathInfo)localObject1).jdField_a_of_type_JavaLangString = localFile.getAbsolutePath();
              localObject2 = localObject1;
            }
          }
        }
      }
    }
  }
  
  private ArkLocalAppMgr.AppPathInfo a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.length() == 0)) {
      paramString1 = null;
    }
    Object localObject2;
    label87:
    do
    {
      do
      {
        return paramString1;
        synchronized (this.jdField_a_of_type_JavaUtilHashMap)
        {
          localObject2 = (ArkLocalAppMgr.AppPathInfo)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1);
          Object localObject1 = localObject2;
          if (localObject2 != null)
          {
            if (((ArkLocalAppMgr.AppPathInfo)localObject2).jdField_a_of_type_JavaLangString != null) {
              break label87;
            }
            this.jdField_a_of_type_JavaUtilHashMap.remove(paramString1);
            localObject1 = null;
          }
          for (;;)
          {
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = a(paramString1);
            }
            if (localObject2 != null) {
              break;
            }
            return null;
            File localFile = new File(((ArkLocalAppMgr.AppPathInfo)localObject2).jdField_a_of_type_JavaLangString);
            if (localFile.exists())
            {
              localObject1 = localObject2;
              if (localFile.isFile()) {}
            }
            else
            {
              this.jdField_a_of_type_JavaUtilHashMap.remove(paramString1);
              localObject1 = null;
            }
          }
          int i = ArkAppCenter.a(((ArkLocalAppMgr.AppPathInfo)localObject2).jdField_a_of_type_JavaLangString);
          if (i != 1)
          {
            ArkAppCenter.c("ArkApp.ArkLocalAppMgr", String.format("getAppPathByNameFromLocal, arkCheckAppVersion fail, ret=%d, app-name=%s, app-ver=%s", new Object[] { Integer.valueOf(i), paramString1, ((ArkLocalAppMgr.AppPathInfo)localObject2).jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDesc.c }));
            this.jdField_a_of_type_JavaUtilHashMap.remove(paramString1);
            a(paramString1, false);
            return null;
          }
          if (localObject2 != null) {
            this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, localObject2);
          }
          if (localObject2 == null) {
            return null;
          }
        }
        paramString1 = (String)localObject2;
      } while (paramString2 == null);
      paramString1 = (String)localObject2;
    } while (b(((ArkLocalAppMgr.AppPathInfo)localObject2).jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDesc.c, paramString2) >= 0);
    return null;
  }
  
  private static String a(int paramInt)
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    if (localBaseApplication == null) {
      return "";
    }
    switch (paramInt)
    {
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    default: 
      if (paramInt > 0) {
        return localBaseApplication.getString(2131370373);
      }
      break;
    case 0: 
      return localBaseApplication.getString(2131370366);
    case 5: 
      return localBaseApplication.getString(2131370367);
    case 6: 
      return localBaseApplication.getString(2131370368);
    case 7: 
      return localBaseApplication.getString(2131370369);
    case -1: 
      return localBaseApplication.getString(2131370372);
    case -2: 
      return localBaseApplication.getString(2131370371);
    case -3: 
      return localBaseApplication.getString(2131370370);
    }
    return localBaseApplication.getString(2131370374);
  }
  
  public static String a(String paramString)
  {
    return String.format("%s%s", new Object[] { jdField_a_of_type_JavaLangString, paramString });
  }
  
  private String a(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    if ((paramString1 == null) || (paramString1.length() == 0) || (paramString2 == null) || (paramString2.length() == 0) || (paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return null;
    }
    try
    {
      localFile = new File(a(paramString1));
      if (!localFile.exists())
      {
        localFile.delete();
        localFile.mkdirs();
        paramString1 = b(paramString1, paramString2);
        paramString2 = new FileOutputStream(paramString1);
        paramString2.write(paramArrayOfByte);
        paramString2.close();
        return paramString1;
      }
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        File localFile;
        paramString1 = paramString1;
        paramString1.printStackTrace();
        ArkAppCenter.c("ArkApp.ArkLocalAppMgr", "copyAppPackageToAppInstallDir, exception:" + paramString1.getMessage());
        return null;
        if (localFile.isFile())
        {
          localFile.delete();
          localFile.mkdirs();
        }
      }
    }
    finally {}
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, ArkLocalAppMgr.UpdateAppByNameTask paramUpdateAppByNameTask)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    int i = 0;
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        this.jdField_a_of_type_JavaUtilArrayList.remove(paramUpdateAppByNameTask);
        paramUpdateAppByNameTask.jdField_a_of_type_Int = paramInt1;
        paramUpdateAppByNameTask.jdField_b_of_type_Int = paramInt2;
        paramUpdateAppByNameTask.jdField_a_of_type_JavaLangString = paramString;
        if (paramUpdateAppByNameTask.jdField_b_of_type_Int == 0) {
          break;
        }
        if (paramUpdateAppByNameTask.jdField_b_of_type_Int != 0)
        {
          AssertUtil.assertTrue(bool1);
          ArkAppDataReport.a((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), paramUpdateAppByNameTask.jdField_a_of_type_Int, paramUpdateAppByNameTask.jdField_b_of_type_JavaLangString);
          paramUpdateAppByNameTask.jdField_b_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo = null;
          paramInt1 = i;
          if (paramInt1 >= paramUpdateAppByNameTask.jdField_b_of_type_JavaUtilArrayList.size()) {
            return;
          }
          paramString = paramUpdateAppByNameTask.jdField_a_of_type_JavaUtilArrayList.get(paramInt1);
          ??? = (qru)paramUpdateAppByNameTask.jdField_b_of_type_JavaUtilArrayList.get(paramInt1);
          if (??? != null) {
            ((qru)???).a(paramUpdateAppByNameTask, paramString);
          }
          paramInt1 += 1;
        }
      }
      bool1 = false;
    }
    if (paramUpdateAppByNameTask.jdField_b_of_type_Int == 0)
    {
      bool1 = true;
      label183:
      AssertUtil.assertTrue(bool1);
      if ((paramUpdateAppByNameTask.jdField_b_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo == null) || (paramUpdateAppByNameTask.jdField_b_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo.jdField_a_of_type_JavaLangString == null)) {
        break label305;
      }
    }
    label305:
    for (bool1 = bool2;; bool1 = false)
    {
      AssertUtil.assertTrue(bool1);
      ArkAppDataReport.a((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), paramUpdateAppByNameTask.jdField_a_of_type_Int, paramUpdateAppByNameTask.jdField_b_of_type_JavaLangString);
      paramInt1 = 1380;
      if (paramUpdateAppByNameTask.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDownloadInfo != null) {
        paramInt1 = (int)(paramUpdateAppByNameTask.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDownloadInfo.jdField_a_of_type_Int * (1.0D + 0.4D * Math.random() - 0.2D));
      }
      paramInt1 = Math.max(paramInt1, 60);
      a(paramUpdateAppByNameTask.jdField_b_of_type_JavaLangString, paramInt1);
      paramInt1 = i;
      break;
      bool1 = false;
      break label183;
    }
  }
  
  private void a(ArkAppCGI.QueryAppInfoByAppNameBatchResult paramQueryAppInfoByAppNameBatchResult, HashMap paramHashMap)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQAppInterface == null)
    {
      ArkAppCenter.c("ArkApp.ArkLocalAppMgr", String.format("onUpdateApp_QueryAppInfoByAppNameResult app=null, task-count=%d", new Object[] { Integer.valueOf(paramHashMap.size()) }));
      paramQueryAppInfoByAppNameBatchResult = paramHashMap.values().iterator();
      while (paramQueryAppInfoByAppNameBatchResult.hasNext()) {
        a(0, -1, null, (ArkLocalAppMgr.UpdateAppByNameTask)paramQueryAppInfoByAppNameBatchResult.next());
      }
    }
    if (paramQueryAppInfoByAppNameBatchResult.jdField_a_of_type_Int > 0) {
      this.jdField_b_of_type_Long = paramQueryAppInfoByAppNameBatchResult.jdField_a_of_type_Int;
    }
    Iterator localIterator = paramHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ArkLocalAppMgr.UpdateAppByNameTask localUpdateAppByNameTask = (ArkLocalAppMgr.UpdateAppByNameTask)paramHashMap.get(str);
      ArkAppCGI.QueryAppInfoResult localQueryAppInfoResult = (ArkAppCGI.QueryAppInfoResult)paramQueryAppInfoByAppNameBatchResult.jdField_a_of_type_JavaUtilHashMap.get(str);
      if (localQueryAppInfoResult == null)
      {
        ArkAppCenter.c("ArkApp.ArkLocalAppMgr", String.format("onUpdateApp_QueryAppInfoByAppNameResult, info is null, app-name=%s", new Object[] { str }));
        a(0, -2, null, localUpdateAppByNameTask);
      }
      else if (localQueryAppInfoResult.h != 0)
      {
        ArkAppCenter.c("ArkApp.ArkLocalAppMgr", String.format("onUpdateApp_QueryAppInfoByAppNameResult, retCode is not SUCCESS, app-name=%s, ret-code=%d", new Object[] { str, Integer.valueOf(localQueryAppInfoResult.h) }));
        a(0, localQueryAppInfoResult.h, localQueryAppInfoResult.jdField_a_of_type_JavaLangString, localUpdateAppByNameTask);
      }
      else if (localQueryAppInfoResult.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDownloadInfo == null)
      {
        ArkAppCenter.c("ArkApp.ArkLocalAppMgr", String.format("onUpdateApp_QueryAppInfoByAppNameResult, appResult.info is NULL, app-name=%s, ret-code=%d", new Object[] { str, Integer.valueOf(localQueryAppInfoResult.h) }));
        a(0, -1, null, localUpdateAppByNameTask);
      }
      else
      {
        localUpdateAppByNameTask.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDownloadInfo = localQueryAppInfoResult.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDownloadInfo;
        if ((localUpdateAppByNameTask.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo != null) && (b(localUpdateAppByNameTask.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDesc.c, localQueryAppInfoResult.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDownloadInfo.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDesc.c) >= 0))
        {
          ArkAppCenter.c("ArkApp.ArkLocalAppMgr", String.format("onUpdateApp_QueryAppInfoByAppNameResult no update, app-name=%s, local-ver=%s, remote-ver=%s", new Object[] { localQueryAppInfoResult.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDownloadInfo.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDesc.jdField_a_of_type_JavaLangString, localUpdateAppByNameTask.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDesc.c, localQueryAppInfoResult.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDownloadInfo.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDesc.c }));
          localUpdateAppByNameTask.jdField_b_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo = localUpdateAppByNameTask.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo;
          a(2, 0, null, localUpdateAppByNameTask);
        }
        else
        {
          localUpdateAppByNameTask.jdField_b_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo = new ArkLocalAppMgr.AppPathInfo();
          localUpdateAppByNameTask.jdField_b_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDesc = localQueryAppInfoResult.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDownloadInfo.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDesc;
          ((ArkAppCenter)localQQAppInterface.getManager(120)).a().a(localQueryAppInfoResult.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDownloadInfo.jdField_a_of_type_JavaLangString, localQueryAppInfoResult.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDownloadInfo.jdField_a_of_type_ArrayOfByte, localUpdateAppByNameTask, new qrh(this));
        }
      }
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return;
    }
    synchronized (this.jdField_b_of_type_JavaUtilHashMap)
    {
      long l = System.currentTimeMillis();
      this.jdField_b_of_type_JavaUtilHashMap.put(paramString, new qro(l, paramInt));
      a(paramString, l);
      b(paramString, paramInt);
      return;
    }
  }
  
  private static void a(String paramString, long paramLong)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return;
    }
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("ArkAppUpdateRecord", 0).edit();
    localEditor.putLong(paramString, paramLong);
    localEditor.commit();
  }
  
  /* Error */
  private static void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull +23 -> 27
    //   7: aload_0
    //   8: invokevirtual 189	java/lang/String:length	()I
    //   11: ifeq +16 -> 27
    //   14: aload_1
    //   15: ifnull +12 -> 27
    //   18: aload_1
    //   19: invokevirtual 189	java/lang/String:length	()I
    //   22: istore_3
    //   23: iload_3
    //   24: ifne +7 -> 31
    //   27: ldc 2
    //   29: monitorexit
    //   30: return
    //   31: aload_0
    //   32: invokestatic 262	com/tencent/mobileqq/ark/ArkLocalAppMgr:a	(Ljava/lang/String;)Ljava/lang/String;
    //   35: astore_0
    //   36: aload_0
    //   37: ifnull -10 -> 27
    //   40: aload_0
    //   41: invokevirtual 189	java/lang/String:length	()I
    //   44: ifeq -17 -> 27
    //   47: new 134	java/io/File
    //   50: dup
    //   51: aload_0
    //   52: invokespecial 137	java/io/File:<init>	(Ljava/lang/String;)V
    //   55: astore_0
    //   56: aload_0
    //   57: invokevirtual 488	java/io/File:isDirectory	()Z
    //   60: ifeq -33 -> 27
    //   63: aload_0
    //   64: invokevirtual 202	java/io/File:exists	()Z
    //   67: ifeq -40 -> 27
    //   70: aload_0
    //   71: new 490	qrf
    //   74: dup
    //   75: aload_1
    //   76: iload_2
    //   77: invokespecial 492	qrf:<init>	(Ljava/lang/String;Z)V
    //   80: invokevirtual 144	java/io/File:listFiles	(Ljava/io/FileFilter;)[Ljava/io/File;
    //   83: pop
    //   84: goto -57 -> 27
    //   87: astore_0
    //   88: ldc 2
    //   90: monitorexit
    //   91: aload_0
    //   92: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	paramString1	String
    //   0	93	1	paramString2	String
    //   0	93	2	paramBoolean	boolean
    //   22	2	3	i	int
    // Exception table:
    //   from	to	target	type
    //   7	14	87	finally
    //   18	23	87	finally
    //   31	36	87	finally
    //   40	84	87	finally
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    int i = 0;
    paramString = a(paramString);
    if (paramBoolean)
    {
      File localFile = new File(String.format("%s_%d", new Object[] { paramString, Long.valueOf(System.currentTimeMillis()) }));
      new File(paramString).renameTo(localFile);
      a(localFile);
    }
    for (;;)
    {
      return;
      paramString = new File(paramString);
      if (paramString.isFile())
      {
        a(paramString);
        return;
      }
      paramString = paramString.listFiles();
      if (paramString != null)
      {
        int j = paramString.length;
        while (i < j)
        {
          paramString[i].delete();
          i += 1;
        }
      }
    }
  }
  
  private void a(ArrayList paramArrayList, Object paramObject, qru paramqru)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQAppInterface == null)
    {
      ArkAppCenter.c("ArkApp.ArkLocalAppMgr", String.format("updateAppByName, app=null", new Object[0]));
      return;
    }
    HashMap localHashMap = new HashMap();
    paramArrayList = paramArrayList.iterator();
    String str;
    if (paramArrayList.hasNext()) {
      str = (String)paramArrayList.next();
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        ??? = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (!((Iterator)???).hasNext()) {
          break label363;
        }
        ArkLocalAppMgr.UpdateAppByNameTask localUpdateAppByNameTask = (ArkLocalAppMgr.UpdateAppByNameTask)((Iterator)???).next();
        if (!localUpdateAppByNameTask.jdField_b_of_type_JavaLangString.equalsIgnoreCase(str)) {
          continue;
        }
        localUpdateAppByNameTask.jdField_a_of_type_JavaUtilArrayList.add(paramObject);
        localUpdateAppByNameTask.jdField_b_of_type_JavaUtilArrayList.add(paramqru);
        i = 1;
        if (i != 0) {
          ArkAppCenter.c("ArkApp.ArkLocalAppMgr", String.format("updateAppByNameBatch, request merged, appname=%s", new Object[] { str }));
        }
      }
      ??? = a(str);
      ??? = new ArkLocalAppMgr.UpdateAppByNameTask(null);
      ((ArkLocalAppMgr.UpdateAppByNameTask)???).jdField_b_of_type_JavaLangString = str;
      ((ArkLocalAppMgr.UpdateAppByNameTask)???).jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo = ((ArkLocalAppMgr.AppPathInfo)???);
      ((ArkLocalAppMgr.UpdateAppByNameTask)???).jdField_b_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo = null;
      ((ArkLocalAppMgr.UpdateAppByNameTask)???).jdField_a_of_type_JavaUtilArrayList.add(paramObject);
      ((ArkLocalAppMgr.UpdateAppByNameTask)???).jdField_b_of_type_JavaUtilArrayList.add(paramqru);
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(???);
        localHashMap.put(str, ???);
      }
      paramArrayList = new ArrayList();
      paramObject = localHashMap.keySet().iterator();
      while (((Iterator)paramObject).hasNext()) {
        paramArrayList.add((String)((Iterator)paramObject).next());
      }
      ((ArkAppCenter)localQQAppInterface.getManager(120)).a().a(paramArrayList, localHashMap, new qrg(this));
      return;
      label363:
      int i = 0;
    }
  }
  
  private void a(qrr paramqrr)
  {
    if (paramqrr.jdField_a_of_type_Int != 0) {
      paramqrr.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo = null;
    }
    if ((paramqrr.jdField_a_of_type_Int == 0) && ((paramqrr.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo == null) || (paramqrr.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo.jdField_a_of_type_JavaLangString == null)))
    {
      AssertUtil.assertTrue(false);
      paramqrr.jdField_a_of_type_Int = -1;
      ArkAppCenter.c("ArkApp.ArkLocalAppMgr", String.format("notifyGetAppPathByNameTaskResult, retCode is success but task.appPathInfo.path==NULL, retCode=%d, app-name=%s", new Object[] { Integer.valueOf(paramqrr.jdField_a_of_type_Int), paramqrr.jdField_b_of_type_JavaLangString }));
    }
    ArkAppDataReport.a((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), paramqrr.jdField_b_of_type_JavaLangString, paramqrr.jdField_a_of_type_Int, System.currentTimeMillis() - paramqrr.jdField_a_of_type_Long, 0);
    ArkLocalAppMgr.IGetAppPathByNameCallback localIGetAppPathByNameCallback = paramqrr.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr$IGetAppPathByNameCallback;
    if (localIGetAppPathByNameCallback != null)
    {
      if ((paramqrr.jdField_a_of_type_JavaLangString == null) || (paramqrr.jdField_a_of_type_JavaLangString.length() == 0)) {
        paramqrr.jdField_a_of_type_JavaLangString = a(paramqrr.jdField_a_of_type_Int);
      }
      localIGetAppPathByNameCallback.a(paramqrr.jdField_a_of_type_Int, paramqrr.jdField_a_of_type_JavaLangString, paramqrr.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo, paramqrr.jdField_a_of_type_JavaLangObject);
    }
  }
  
  private void a(qrs paramqrs)
  {
    qrp localqrp = new qrp(null);
    localqrp.a = false;
    ThreadManager.a(new qri(this, localqrp, paramqrs), 5, null, true);
  }
  
  private void a(qrt paramqrt)
  {
    ThreadManager.a(new qrc(this, new qrq(null), paramqrt), 5, null, true);
  }
  
  private void a(qrv paramqrv)
  {
    if ((paramqrv == null) || (paramqrv.jdField_a_of_type_JavaUtilArrayList == null) || (paramqrv.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {
      return;
    }
    a(paramqrv.jdField_a_of_type_JavaUtilArrayList, paramqrv, new qra(this));
  }
  
  private void a(boolean paramBoolean, byte[] paramArrayOfByte, ArkLocalAppMgr.UpdateAppByNameTask paramUpdateAppByNameTask)
  {
    if ((!paramBoolean) || (paramArrayOfByte.length == 0))
    {
      ArkAppCenter.c("ArkApp.ArkLocalAppMgr", String.format("onUpdateApp_DownloadAppPackageResult fail, app-name=%s", new Object[] { paramUpdateAppByNameTask.jdField_b_of_type_JavaLangString }));
      a(0, -2, null, paramUpdateAppByNameTask);
      return;
    }
    paramArrayOfByte = a(paramUpdateAppByNameTask.jdField_b_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDesc.jdField_a_of_type_JavaLangString, paramUpdateAppByNameTask.jdField_b_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDesc.c, paramArrayOfByte);
    if (paramArrayOfByte == null)
    {
      ArkAppCenter.c("ArkApp.ArkLocalAppMgr", String.format("onUpdateApp_DownloadAppPackageResult, copyAppPackageToAppInstallDir fail, app-name=%s, app-version=%s", new Object[] { paramUpdateAppByNameTask.jdField_b_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDesc.jdField_a_of_type_JavaLangString, paramUpdateAppByNameTask.jdField_b_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDesc.c }));
      a(0, -3, null, paramUpdateAppByNameTask);
      return;
    }
    int i = ArkAppCenter.a(paramArrayOfByte);
    if (i != 1)
    {
      ArkAppCenter.c("ArkApp.ArkLocalAppMgr", String.format("onUpdateApp_DownloadAppPackageResult, arkCheckAppVersion fail, ret=%d, app-name=%s, app-path=%s", new Object[] { Integer.valueOf(i), paramUpdateAppByNameTask.jdField_b_of_type_JavaLangString, paramArrayOfByte }));
      a(paramUpdateAppByNameTask.jdField_b_of_type_JavaLangString, false);
      a(0, 7, null, paramUpdateAppByNameTask);
      return;
    }
    ArkAppCenter.c("ArkApp.ArkLocalAppMgr", String.format("onUpdateApp_DownloadAppPackageResult, success, app-name=%s, app-version=%s, app-path=%s", new Object[] { paramUpdateAppByNameTask.jdField_b_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDesc.jdField_a_of_type_JavaLangString, paramUpdateAppByNameTask.jdField_b_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDesc.c, paramArrayOfByte }));
    paramUpdateAppByNameTask.jdField_b_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo.jdField_a_of_type_JavaLangString = paramArrayOfByte;
    a(paramUpdateAppByNameTask.jdField_b_of_type_JavaLangString, paramUpdateAppByNameTask.jdField_b_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDesc.c, true);
    a(1, 0, null, paramUpdateAppByNameTask);
  }
  
  private static boolean a(File paramFile)
  {
    int i = 0;
    if (paramFile != null)
    {
      if (!paramFile.isFile()) {
        break label28;
      }
      if (paramFile.delete()) {
        break label26;
      }
      paramFile.deleteOnExit();
    }
    label26:
    label28:
    while (!paramFile.isDirectory())
    {
      return false;
      return true;
    }
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile != null)
    {
      int j = arrayOfFile.length;
      while (i < j)
      {
        a(arrayOfFile[i]);
        i += 1;
      }
    }
    return paramFile.delete();
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!paramString.matches("^[\\w\\d]+(\\.[\\w\\d]+)+$")) {
      return false;
    }
    return true;
  }
  
  private static int b(String paramString1, String paramString2)
  {
    int m = 0;
    paramString1 = paramString1.split("\\.");
    paramString2 = paramString2.split("\\.");
    int i = 0;
    int j = m;
    if (i < 4) {}
    for (;;)
    {
      try
      {
        if (paramString1.length <= i) {
          break label122;
        }
        j = Integer.parseInt(paramString1[i]);
        if (paramString2.length <= i) {
          break label116;
        }
        k = Integer.parseInt(paramString2[i]);
        if (j > k)
        {
          j = 1;
          return j;
        }
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        ArkAppCenter.c("ArkApp.ArkLocalAppMgr", "compareVersionString: Exception:" + paramString1.getMessage());
        return 0;
      }
      if (j < k) {
        return -1;
      }
      i += 1;
      break;
      label116:
      int k = 0;
      continue;
      label122:
      j = 0;
    }
  }
  
  public static String b(String paramString1, String paramString2)
  {
    return String.format("%s/%s.app", new Object[] { a(paramString1), paramString2 });
  }
  
  public static void b()
  {
    jdField_b_of_type_Boolean = true;
  }
  
  private static void b(String paramString, int paramInt)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return;
    }
    paramInt = Math.max(10, paramInt);
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("ArkAppUpdatePeriod", 0).edit();
    localEditor.putInt(paramString, paramInt);
    localEditor.commit();
  }
  
  private static String[] b()
  {
    File[] arrayOfFile = new File(jdField_a_of_type_JavaLangString).listFiles(new qre());
    if ((arrayOfFile == null) || (arrayOfFile.length == 0)) {
      return null;
    }
    String[] arrayOfString = new String[arrayOfFile.length];
    int i = 0;
    while (i < arrayOfFile.length)
    {
      arrayOfString[i] = arrayOfFile[i].getName();
      i += 1;
    }
    return arrayOfString;
  }
  
  private boolean c(String paramString)
  {
    synchronized (this.jdField_b_of_type_JavaUtilHashMap)
    {
      Object localObject = (qro)this.jdField_b_of_type_JavaUtilHashMap.get(paramString);
      long l1;
      int i;
      if (localObject != null)
      {
        l1 = ((qro)localObject).jdField_a_of_type_Long;
        i = ((qro)localObject).jdField_a_of_type_Int;
        long l2 = (System.currentTimeMillis() - l1) / 60000L;
        if (l2 > i)
        {
          ArkAppCenter.c("ArkApp.ArkLocalAppMgr", String.format("isAppNeedUpdate, app need update, name=%s, last-update=%d, delta=%d, update-period=%d", new Object[] { paramString, Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i) }));
          return true;
        }
      }
      else
      {
        localObject = BaseApplication.getContext();
        l1 = ((Context)localObject).getSharedPreferences("ArkAppUpdateRecord", 0).getLong(paramString, 0L);
        i = ((Context)localObject).getSharedPreferences("ArkAppUpdatePeriod", 0).getInt(paramString, 1380);
        this.jdField_b_of_type_JavaUtilHashMap.put(paramString, new qro(l1, i));
      }
    }
    return false;
  }
  
  public static void d()
  {
    String[] arrayOfString = b();
    if (arrayOfString == null) {}
    for (;;)
    {
      return;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        a(arrayOfString[i], true);
        i += 1;
      }
    }
  }
  
  private static boolean d(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    while (!paramString.matches("^\\d+(\\.\\d+){0,3}$")) {
      return false;
    }
    return true;
  }
  
  private void f()
  {
    if (((System.currentTimeMillis() - this.c) / 1000L / 60L < 1020L) && (!jdField_b_of_type_Boolean)) {
      return;
    }
    this.c = System.currentTimeMillis();
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQAppInterface == null)
    {
      ArkAppCenter.c("ArkApp.ArkLocalAppMgr", String.format("_updatePredownloadAppList, app=null", new Object[0]));
      return;
    }
    ((ArkAppCenter)localQQAppInterface.getManager(120)).a().a("http://cdn.ark.qq.com/arkapp/app_config.json", null, new qrl(this));
  }
  
  private void g()
  {
    long l = (System.currentTimeMillis() - this.jdField_a_of_type_Long) / 1000L / 60L;
    if ((this.jdField_a_of_type_Long != 0L) && (l <= this.jdField_b_of_type_Long) && (!jdField_b_of_type_Boolean))
    {
      ArkAppCenter.c("ArkApp.ArkLocalAppMgr", String.format("updateInstalledApps, not update time, delta=%d, interval=%d", new Object[] { Long.valueOf(l), Long.valueOf(this.jdField_b_of_type_Long) }));
      return;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    a(new qrm(this));
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.postDelayed(new qqy(this), 10000L);
  }
  
  private static void i()
  {
    ArkAppCenter.c("ArkApp.ArkLocalAppMgr", "scheduleCleanOldApps");
    String[] arrayOfString = b();
    if (arrayOfString != null)
    {
      int j = arrayOfString.length;
      int i = 0;
      if (i < j)
      {
        String str = arrayOfString[i];
        ArkLocalAppMgr.AppPathInfo localAppPathInfo = a(str);
        if (localAppPathInfo == null) {}
        for (;;)
        {
          i += 1;
          break;
          if (localAppPathInfo.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDesc.c != null) {
            a(str, localAppPathInfo.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDesc.c, false);
          }
        }
      }
    }
  }
  
  public String a(String paramString1, String paramString2)
  {
    paramString1 = a(paramString1, paramString2);
    if (paramString1 != null) {
      return paramString1.jdField_a_of_type_JavaLangString;
    }
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler != null) {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.postDelayed(new qrn(this), paramInt);
  }
  
  public void a(String paramString1, String paramString2, Object paramObject, ArkLocalAppMgr.IGetAppPathByNameCallback paramIGetAppPathByNameCallback)
  {
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      paramString1 = new qrr();
      paramString1.jdField_a_of_type_Int = -1;
      paramString1.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo = null;
      paramString1.jdField_a_of_type_JavaLangObject = paramObject;
      paramString1.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr$IGetAppPathByNameCallback = paramIGetAppPathByNameCallback;
      paramString1.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.myLooper(), this);
      paramString1.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(1916, paramString1).sendToTarget();
      return;
    }
    Object localObject = a(paramString1, paramString2);
    if ((localObject != null) && ((paramString2 == null) || (b(((ArkLocalAppMgr.AppPathInfo)localObject).jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDesc.c, paramString2) >= 0)))
    {
      paramString1 = new qrr();
      paramString1.jdField_a_of_type_Int = 0;
      paramString1.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo = ((ArkLocalAppMgr.AppPathInfo)localObject);
      paramString1.jdField_a_of_type_JavaLangObject = paramObject;
      paramString1.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr$IGetAppPathByNameCallback = paramIGetAppPathByNameCallback;
      paramString1.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.myLooper(), this);
      paramString1.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(1916, paramString1).sendToTarget();
      return;
    }
    ArkAppCenter.c("ArkApp.ArkLocalAppMgr", String.format("getAppPathByName, app not found at local, update app, app-name=%s, min-ver=%s", new Object[] { paramString1, paramString2 }));
    localObject = new qrr();
    ((qrr)localObject).jdField_a_of_type_Int = -1;
    ((qrr)localObject).jdField_b_of_type_JavaLangString = paramString1;
    ((qrr)localObject).c = paramString2;
    ((qrr)localObject).jdField_a_of_type_JavaLangObject = paramObject;
    ((qrr)localObject).jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr$IGetAppPathByNameCallback = paramIGetAppPathByNameCallback;
    ((qrr)localObject).jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr$AppPathInfo = null;
    ((qrr)localObject).jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.myLooper(), this);
    paramString2 = new ArrayList();
    paramString2.add(paramString1);
    a(paramString2, localObject, new qqw(this));
  }
  
  public void c()
  {
    a(new qrk(this));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1916)
    {
      a((qrr)paramMessage.obj);
      return true;
    }
    if (paramMessage.what == 1917)
    {
      c();
      return true;
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\ark\ArkLocalAppMgr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */