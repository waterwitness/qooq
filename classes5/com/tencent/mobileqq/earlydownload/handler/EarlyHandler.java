package com.tencent.mobileqq.earlydownload.handler;

import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.EarlyDataFactory;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager.EarlyDownLoadListener;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import protocol.KQQConfig.GetResourceReqInfo;
import protocol.KQQConfig.GetResourceReqInfoV2;

public abstract class EarlyHandler
{
  private static final String jdField_a_of_type_JavaLangString = "actEarlyDownUse";
  static final String c = "early";
  static final String d;
  public static final int f = 43200000;
  protected QQAppInterface a;
  private XmlData jdField_a_of_type_ComTencentMobileqqEarlydownloadXmldataXmlData;
  protected ArrayList a;
  protected boolean b;
  protected boolean c;
  protected boolean d;
  protected String e;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_d_of_type_JavaLangString = AppConstants.bj + "early";
  }
  
  public EarlyHandler(String paramString, QQAppInterface paramQQAppInterface)
  {
    this.e = paramString;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public int a()
  {
    int i = 0;
    XmlData localXmlData = a();
    if (localXmlData != null) {
      i = localXmlData.Version;
    }
    return i;
  }
  
  public final XmlData a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEarlydownloadXmldataXmlData == null) {
      this.jdField_a_of_type_ComTencentMobileqqEarlydownloadXmldataXmlData = EarlyDataFactory.a(a());
    }
    return this.jdField_a_of_type_ComTencentMobileqqEarlydownloadXmldataXmlData;
  }
  
  public abstract Class a();
  
  public abstract String a();
  
  public GetResourceReqInfo a()
  {
    Object localObject = null;
    XmlData localXmlData = a();
    if ((localXmlData != null) && (localXmlData.strPkgName != null) && (localXmlData.strPkgName.length() > 0))
    {
      localObject = new GetResourceReqInfo();
      ((GetResourceReqInfo)localObject).uiResID = 0L;
      ((GetResourceReqInfo)localObject).strPkgName = localXmlData.strPkgName;
      ((GetResourceReqInfo)localObject).uiCurVer = a();
      ((GetResourceReqInfo)localObject).sResType = 512;
      ((GetResourceReqInfo)localObject).sLanType = 1;
      ((GetResourceReqInfo)localObject).sReqType = 1;
    }
    while (!QLog.isColorLevel()) {
      return (GetResourceReqInfo)localObject;
    }
    localObject = new StringBuffer("getResourceReqInfo() return null.");
    if (localXmlData == null) {
      ((StringBuffer)localObject).append("data==null");
    }
    for (;;)
    {
      QLog.d("EarlyDown", 2, ((StringBuffer)localObject).toString());
      return null;
      ((StringBuffer)localObject).append("resName=" + localXmlData.strResName);
      ((StringBuffer)localObject).append(".pkgName=" + localXmlData.strPkgName);
    }
  }
  
  public GetResourceReqInfoV2 a()
  {
    Object localObject = null;
    XmlData localXmlData = a();
    if ((localXmlData != null) && (localXmlData.strPkgName != null) && (localXmlData.strPkgName.length() > 0))
    {
      localObject = new GetResourceReqInfoV2();
      ((GetResourceReqInfoV2)localObject).cState = 0;
      ((GetResourceReqInfoV2)localObject).sLanType = 1;
      ((GetResourceReqInfoV2)localObject).sResSubType = 1;
      ((GetResourceReqInfoV2)localObject).strPkgName = localXmlData.strPkgName;
      if (h())
      {
        l = 0L;
        ((GetResourceReqInfoV2)localObject).uiCurVer = l;
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        return (GetResourceReqInfoV2)localObject;
        long l = a();
      }
    }
    localObject = new StringBuffer("getResourceReqInfo() return null.");
    if (localXmlData == null) {
      ((StringBuffer)localObject).append("data==null");
    }
    for (;;)
    {
      QLog.d("EarlyDown", 2, ((StringBuffer)localObject).toString());
      return null;
      ((StringBuffer)localObject).append("resName=" + localXmlData.strResName);
      ((StringBuffer)localObject).append(".pkgName=" + localXmlData.strPkgName);
    }
  }
  
  public void a(EarlyDownloadManager.EarlyDownLoadListener paramEarlyDownLoadListener)
  {
    if (paramEarlyDownLoadListener != null)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(paramEarlyDownLoadListener);
    }
  }
  
  public void a(XmlData paramXmlData) {}
  
  public void a(XmlData paramXmlData, boolean paramBoolean, int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "onDownloadFinish() result=" + paramBoolean + " filePath=" + paramString);
    }
    Object localObject;
    if (paramBoolean)
    {
      paramXmlData.hasResDownloaded = true;
      EarlyDataFactory.a(paramXmlData, new String[] { "hasResDownloaded" });
      if (QLog.isColorLevel()) {
        QLog.d("EarlyDown", 2, "EarlyHandler, onDownloadFinish,download Successful, hasResDownloaded=true, resName=" + this.e);
      }
      a(paramString);
      if (this.jdField_d_of_type_Boolean)
      {
        localObject = new Intent("resp.com.tencent.mobileqq.EARLY_QUERY");
        if (paramInt != 9037) {
          break label352;
        }
        ((Intent)localObject).setAction("resp.com.tencent.mobileqq.EARLY_CANCEL");
      }
    }
    for (;;)
    {
      ((Intent)localObject).putExtra("strResName", this.e);
      ((Intent)localObject).putExtra("strPkgName", a().strPkgName);
      ((Intent)localObject).putExtra("loadState", a().loadState);
      ((Intent)localObject).putExtra("totalSize", paramXmlData.totalSize);
      ((Intent)localObject).putExtra("downSize", paramXmlData.downSize);
      ((Intent)localObject).putExtra("errCode", paramInt);
      ((Intent)localObject).putExtra("resPath", paramString);
      BaseApplicationImpl.getContext().sendBroadcast((Intent)localObject, "com.tencent.qqhead.permission.getheadresp");
      this.jdField_d_of_type_Boolean = false;
      return;
      paramXmlData.hasResDownloaded = false;
      EarlyDataFactory.a(paramXmlData, new String[] { "hasResDownloaded" });
      if (QLog.isColorLevel()) {
        QLog.d("EarlyDown", 2, "EarlyHandler, onDownloadFinish,download failed, hasResDownloaded=false, resName=" + this.e);
      }
      if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
        break;
      }
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((EarlyDownloadManager.EarlyDownLoadListener)((Iterator)localObject).next()).a(paramXmlData, paramBoolean, paramInt, b(), paramString);
      }
      break;
      label352:
      ((Intent)localObject).setAction("resp.com.tencent.mobileqq.EARLY_QUERY");
    }
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((EarlyDownloadManager.EarlyDownLoadListener)localIterator.next()).a(a(), true, 0, b(), paramString);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    new File(c()).delete();
    XmlData localXmlData = a();
    localXmlData.Version = 0;
    localXmlData.tLoadFail = 0L;
    localXmlData.loadState = 0;
    localXmlData.hasResDownloaded = false;
    EarlyDataFactory.a(localXmlData, new String[] { "Version", "loadState", "tLoadFail", "hasResDownloaded" });
    localXmlData.isUserClick = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "restartDownload() resName=" + localXmlData.strResName + " user=" + paramBoolean);
    }
    Intent localIntent = new Intent();
    GetResourceReqInfo localGetResourceReqInfo = a();
    if (localGetResourceReqInfo != null)
    {
      localIntent.putExtra("reqResult", true);
      ((ConfigHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(4)).a(null, new GetResourceReqInfo[] { localGetResourceReqInfo });
    }
    for (;;)
    {
      if (this.jdField_d_of_type_Boolean)
      {
        localIntent.setAction("resp.com.tencent.mobileqq.EARLY_DOWNLOAD");
        localIntent.putExtra("strResName", this.e);
        localIntent.putExtra("strPkgName", localXmlData.strPkgName);
        BaseApplicationImpl.getContext().sendBroadcast(localIntent, "com.tencent.qqhead.permission.getheadresp");
      }
      return;
      localIntent.putExtra("reqResult", false);
      localIntent.putExtra("resultReason", "strPkgName=" + localXmlData.strPkgName);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
  }
  
  public void b(long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      XmlData localXmlData = a();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((EarlyDownloadManager.EarlyDownLoadListener)localIterator.next()).a(localXmlData, paramLong1, paramLong2);
      }
    }
  }
  
  public void b(EarlyDownloadManager.EarlyDownLoadListener paramEarlyDownLoadListener)
  {
    if ((paramEarlyDownLoadListener != null) && (this.jdField_a_of_type_JavaUtilArrayList != null)) {
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramEarlyDownLoadListener);
    }
  }
  
  /* Error */
  public void b(XmlData paramXmlData)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_1
    //   3: ifnonnull +19 -> 22
    //   6: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9: ifeq +12 -> 21
    //   12: ldc 126
    //   14: iconst_2
    //   15: ldc_w 327
    //   18: invokestatic 329	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   21: return
    //   22: aload_0
    //   23: invokevirtual 59	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:a	()Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;
    //   26: astore 7
    //   28: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   31: ifeq +73 -> 104
    //   34: ldc 126
    //   36: iconst_2
    //   37: new 30	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   44: ldc_w 331
    //   47: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: aload_1
    //   51: getfield 135	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strResName	Ljava/lang/String;
    //   54: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: ldc_w 333
    //   60: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: aload_1
    //   64: getfield 64	com/tencent/mobileqq/earlydownload/xmldata/XmlData:Version	I
    //   67: invokevirtual 336	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   70: ldc_w 338
    //   73: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: aload 7
    //   78: getfield 64	com/tencent/mobileqq/earlydownload/xmldata/XmlData:Version	I
    //   81: invokevirtual 336	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   84: ldc_w 340
    //   87: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: aload 7
    //   92: getfield 207	com/tencent/mobileqq/earlydownload/xmldata/XmlData:loadState	I
    //   95: invokevirtual 336	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   98: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokestatic 130	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   104: new 267	java/io/File
    //   107: dup
    //   108: aload_0
    //   109: invokevirtual 269	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:c	()Ljava/lang/String;
    //   112: invokespecial 270	java/io/File:<init>	(Ljava/lang/String;)V
    //   115: astore 5
    //   117: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   120: ifeq +47 -> 167
    //   123: ldc 126
    //   125: iconst_2
    //   126: new 30	java/lang/StringBuilder
    //   129: dup
    //   130: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   133: ldc_w 342
    //   136: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: aload 5
    //   141: invokevirtual 345	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   144: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: ldc_w 347
    //   150: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload 5
    //   155: invokevirtual 350	java/io/File:exists	()Z
    //   158: invokevirtual 171	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   161: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: invokestatic 130	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   167: aload 5
    //   169: invokevirtual 350	java/io/File:exists	()Z
    //   172: ifeq +1438 -> 1610
    //   175: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   178: ifeq +33 -> 211
    //   181: ldc 126
    //   183: iconst_2
    //   184: new 30	java/lang/StringBuilder
    //   187: dup
    //   188: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   191: ldc_w 352
    //   194: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: aload 5
    //   199: invokevirtual 355	java/io/File:length	()J
    //   202: invokevirtual 358	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   205: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: invokestatic 130	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   211: aload 5
    //   213: invokevirtual 345	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   216: invokestatic 364	com/tencent/qphone/base/util/MD5:getFileMd5	(Ljava/lang/String;)[B
    //   219: invokestatic 370	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   222: astore_2
    //   223: aload_2
    //   224: ifnull +494 -> 718
    //   227: aload_1
    //   228: getfield 373	com/tencent/mobileqq/earlydownload/xmldata/XmlData:MD5	Ljava/lang/String;
    //   231: ifnull +487 -> 718
    //   234: aload_2
    //   235: invokevirtual 376	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   238: aload_1
    //   239: getfield 373	com/tencent/mobileqq/earlydownload/xmldata/XmlData:MD5	Ljava/lang/String;
    //   242: invokevirtual 376	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   245: invokevirtual 379	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   248: ifeq +470 -> 718
    //   251: aload_2
    //   252: astore_3
    //   253: aload 5
    //   255: astore_2
    //   256: new 267	java/io/File
    //   259: dup
    //   260: aload_0
    //   261: invokevirtual 381	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:d	()Ljava/lang/String;
    //   264: invokespecial 270	java/io/File:<init>	(Ljava/lang/String;)V
    //   267: astore 6
    //   269: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   272: ifeq +47 -> 319
    //   275: ldc 126
    //   277: iconst_2
    //   278: new 30	java/lang/StringBuilder
    //   281: dup
    //   282: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   285: ldc_w 383
    //   288: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: aload 6
    //   293: invokevirtual 345	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   296: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: ldc_w 347
    //   302: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: aload 6
    //   307: invokevirtual 350	java/io/File:exists	()Z
    //   310: invokevirtual 171	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   313: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   316: invokestatic 130	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   319: aload_2
    //   320: ifnonnull +609 -> 929
    //   323: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   326: ifeq +33 -> 359
    //   329: ldc 126
    //   331: iconst_2
    //   332: new 30	java/lang/StringBuilder
    //   335: dup
    //   336: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   339: ldc_w 385
    //   342: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: aload 6
    //   347: invokevirtual 355	java/io/File:length	()J
    //   350: invokevirtual 358	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   353: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   356: invokestatic 130	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   359: aload 6
    //   361: invokevirtual 350	java/io/File:exists	()Z
    //   364: ifeq +565 -> 929
    //   367: aload 6
    //   369: invokevirtual 345	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   372: invokestatic 364	com/tencent/qphone/base/util/MD5:getFileMd5	(Ljava/lang/String;)[B
    //   375: invokestatic 370	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   378: astore 4
    //   380: aload 4
    //   382: ifnull +541 -> 923
    //   385: aload_1
    //   386: getfield 373	com/tencent/mobileqq/earlydownload/xmldata/XmlData:MD5	Ljava/lang/String;
    //   389: ifnull +534 -> 923
    //   392: aload 4
    //   394: invokevirtual 376	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   397: aload_1
    //   398: getfield 373	com/tencent/mobileqq/earlydownload/xmldata/XmlData:MD5	Ljava/lang/String;
    //   401: invokevirtual 376	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   404: invokevirtual 379	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   407: ifeq +516 -> 923
    //   410: aload 6
    //   412: astore_2
    //   413: aload_2
    //   414: ifnonnull +666 -> 1080
    //   417: aload 7
    //   419: iconst_0
    //   420: putfield 176	com/tencent/mobileqq/earlydownload/xmldata/XmlData:hasResDownloaded	Z
    //   423: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   426: ifeq +32 -> 458
    //   429: ldc 126
    //   431: iconst_2
    //   432: new 30	java/lang/StringBuilder
    //   435: dup
    //   436: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   439: ldc_w 387
    //   442: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: aload_0
    //   446: getfield 53	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:e	Ljava/lang/String;
    //   449: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   455: invokestatic 130	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   458: aload 7
    //   460: iconst_1
    //   461: anewarray 80	java/lang/String
    //   464: dup
    //   465: iconst_0
    //   466: ldc -79
    //   468: aastore
    //   469: invokestatic 180	com/tencent/mobileqq/earlydownload/EarlyDataFactory:a	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;[Ljava/lang/String;)V
    //   472: aload_0
    //   473: invokevirtual 390	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:d_	()Z
    //   476: ifne +456 -> 932
    //   479: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   482: ifeq +32 -> 514
    //   485: ldc 126
    //   487: iconst_2
    //   488: new 30	java/lang/StringBuilder
    //   491: dup
    //   492: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   495: ldc_w 392
    //   498: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: aload_0
    //   502: getfield 53	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:e	Ljava/lang/String;
    //   505: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   511: invokestatic 130	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   514: aload 7
    //   516: aload_1
    //   517: invokevirtual 395	com/tencent/mobileqq/earlydownload/xmldata/XmlData:updateServerInfo	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;)V
    //   520: aload 7
    //   522: iconst_1
    //   523: putfield 207	com/tencent/mobileqq/earlydownload/xmldata/XmlData:loadState	I
    //   526: aload 7
    //   528: iconst_0
    //   529: anewarray 80	java/lang/String
    //   532: invokestatic 180	com/tencent/mobileqq/earlydownload/EarlyDataFactory:a	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;[Ljava/lang/String;)V
    //   535: iconst_0
    //   536: istore 8
    //   538: iload 8
    //   540: ifne -519 -> 21
    //   543: aload_0
    //   544: aload 7
    //   546: invokevirtual 397	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:a	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;)V
    //   549: return
    //   550: astore_2
    //   551: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   554: ifeq +30 -> 584
    //   557: ldc 126
    //   559: iconst_2
    //   560: iconst_2
    //   561: anewarray 4	java/lang/Object
    //   564: dup
    //   565: iconst_0
    //   566: ldc_w 399
    //   569: aastore
    //   570: dup
    //   571: iconst_1
    //   572: aload_2
    //   573: invokevirtual 402	java/lang/UnsatisfiedLinkError:getMessage	()Ljava/lang/String;
    //   576: aastore
    //   577: invokestatic 405	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   580: aload_2
    //   581: invokevirtual 408	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   584: aload 5
    //   586: invokestatic 413	com/tencent/qqprotect/singleupdate/MD5FileUtil:a	(Ljava/io/File;)Ljava/lang/String;
    //   589: astore_2
    //   590: goto -367 -> 223
    //   593: astore_2
    //   594: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   597: ifeq +33 -> 630
    //   600: ldc 126
    //   602: iconst_2
    //   603: new 30	java/lang/StringBuilder
    //   606: dup
    //   607: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   610: ldc_w 415
    //   613: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   616: aload 5
    //   618: invokevirtual 345	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   621: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   627: invokestatic 329	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   630: aconst_null
    //   631: astore_2
    //   632: goto -409 -> 223
    //   635: astore_2
    //   636: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   639: ifeq +30 -> 669
    //   642: ldc 126
    //   644: iconst_2
    //   645: iconst_2
    //   646: anewarray 4	java/lang/Object
    //   649: dup
    //   650: iconst_0
    //   651: ldc_w 417
    //   654: aastore
    //   655: dup
    //   656: iconst_1
    //   657: aload_2
    //   658: invokevirtual 418	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   661: aastore
    //   662: invokestatic 405	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   665: aload_2
    //   666: invokevirtual 419	java/lang/OutOfMemoryError:printStackTrace	()V
    //   669: aload 5
    //   671: invokestatic 413	com/tencent/qqprotect/singleupdate/MD5FileUtil:a	(Ljava/io/File;)Ljava/lang/String;
    //   674: astore_2
    //   675: goto -452 -> 223
    //   678: astore_2
    //   679: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   682: ifeq -52 -> 630
    //   685: ldc 126
    //   687: iconst_2
    //   688: new 30	java/lang/StringBuilder
    //   691: dup
    //   692: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   695: ldc_w 415
    //   698: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   701: aload 5
    //   703: invokevirtual 345	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   706: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   709: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   712: invokestatic 329	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   715: goto -85 -> 630
    //   718: aload 5
    //   720: invokevirtual 273	java/io/File:delete	()Z
    //   723: pop
    //   724: aconst_null
    //   725: astore 4
    //   727: aload_2
    //   728: astore_3
    //   729: aload 4
    //   731: astore_2
    //   732: goto -476 -> 256
    //   735: astore 4
    //   737: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   740: ifeq +32 -> 772
    //   743: ldc 126
    //   745: iconst_2
    //   746: iconst_2
    //   747: anewarray 4	java/lang/Object
    //   750: dup
    //   751: iconst_0
    //   752: ldc_w 421
    //   755: aastore
    //   756: dup
    //   757: iconst_1
    //   758: aload 4
    //   760: invokevirtual 402	java/lang/UnsatisfiedLinkError:getMessage	()Ljava/lang/String;
    //   763: aastore
    //   764: invokestatic 405	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   767: aload 4
    //   769: invokevirtual 408	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   772: aload 6
    //   774: invokestatic 413	com/tencent/qqprotect/singleupdate/MD5FileUtil:a	(Ljava/io/File;)Ljava/lang/String;
    //   777: astore 4
    //   779: goto -399 -> 380
    //   782: astore 4
    //   784: aload_3
    //   785: astore 4
    //   787: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   790: ifeq -410 -> 380
    //   793: ldc 126
    //   795: iconst_2
    //   796: new 30	java/lang/StringBuilder
    //   799: dup
    //   800: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   803: ldc_w 415
    //   806: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   809: aload 6
    //   811: invokevirtual 345	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   814: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   817: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   820: invokestatic 329	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   823: aload_3
    //   824: astore 4
    //   826: goto -446 -> 380
    //   829: astore 4
    //   831: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   834: ifeq +32 -> 866
    //   837: ldc 126
    //   839: iconst_2
    //   840: iconst_2
    //   841: anewarray 4	java/lang/Object
    //   844: dup
    //   845: iconst_0
    //   846: ldc_w 423
    //   849: aastore
    //   850: dup
    //   851: iconst_1
    //   852: aload 4
    //   854: invokevirtual 418	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   857: aastore
    //   858: invokestatic 405	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   861: aload 4
    //   863: invokevirtual 419	java/lang/OutOfMemoryError:printStackTrace	()V
    //   866: aload 6
    //   868: invokestatic 413	com/tencent/qqprotect/singleupdate/MD5FileUtil:a	(Ljava/io/File;)Ljava/lang/String;
    //   871: astore 4
    //   873: goto -493 -> 380
    //   876: astore 4
    //   878: aload_3
    //   879: astore 4
    //   881: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   884: ifeq -504 -> 380
    //   887: ldc 126
    //   889: iconst_2
    //   890: new 30	java/lang/StringBuilder
    //   893: dup
    //   894: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   897: ldc_w 415
    //   900: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   903: aload 6
    //   905: invokevirtual 345	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   908: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   911: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   914: invokestatic 329	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   917: aload_3
    //   918: astore 4
    //   920: goto -540 -> 380
    //   923: aload 6
    //   925: invokevirtual 273	java/io/File:delete	()Z
    //   928: pop
    //   929: goto -516 -> 413
    //   932: aload_1
    //   933: getfield 64	com/tencent/mobileqq/earlydownload/xmldata/XmlData:Version	I
    //   936: aload 7
    //   938: getfield 64	com/tencent/mobileqq/earlydownload/xmldata/XmlData:Version	I
    //   941: if_icmpge +9 -> 950
    //   944: iconst_0
    //   945: istore 8
    //   947: goto -409 -> 538
    //   950: aload_1
    //   951: getfield 64	com/tencent/mobileqq/earlydownload/xmldata/XmlData:Version	I
    //   954: aload 7
    //   956: getfield 64	com/tencent/mobileqq/earlydownload/xmldata/XmlData:Version	I
    //   959: if_icmpne +85 -> 1044
    //   962: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   965: ifeq +46 -> 1011
    //   968: ldc 126
    //   970: iconst_2
    //   971: new 30	java/lang/StringBuilder
    //   974: dup
    //   975: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   978: ldc_w 425
    //   981: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   984: aload 7
    //   986: getfield 207	com/tencent/mobileqq/earlydownload/xmldata/XmlData:loadState	I
    //   989: invokevirtual 336	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   992: ldc_w 427
    //   995: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   998: aload_0
    //   999: getfield 53	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:e	Ljava/lang/String;
    //   1002: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1005: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1008: invokestatic 130	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1011: aload 7
    //   1013: getfield 207	com/tencent/mobileqq/earlydownload/xmldata/XmlData:loadState	I
    //   1016: iconst_1
    //   1017: if_icmpeq +587 -> 1604
    //   1020: aload 7
    //   1022: aload_1
    //   1023: invokevirtual 395	com/tencent/mobileqq/earlydownload/xmldata/XmlData:updateServerInfo	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;)V
    //   1026: aload 7
    //   1028: iconst_0
    //   1029: anewarray 80	java/lang/String
    //   1032: invokestatic 180	com/tencent/mobileqq/earlydownload/EarlyDataFactory:a	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;[Ljava/lang/String;)V
    //   1035: aload_0
    //   1036: invokevirtual 430	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:g	()Z
    //   1039: istore 8
    //   1041: goto -503 -> 538
    //   1044: aload_1
    //   1045: getfield 64	com/tencent/mobileqq/earlydownload/xmldata/XmlData:Version	I
    //   1048: aload 7
    //   1050: getfield 64	com/tencent/mobileqq/earlydownload/xmldata/XmlData:Version	I
    //   1053: if_icmple +551 -> 1604
    //   1056: aload 7
    //   1058: aload_1
    //   1059: invokevirtual 395	com/tencent/mobileqq/earlydownload/xmldata/XmlData:updateServerInfo	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;)V
    //   1062: aload 7
    //   1064: iconst_0
    //   1065: anewarray 80	java/lang/String
    //   1068: invokestatic 180	com/tencent/mobileqq/earlydownload/EarlyDataFactory:a	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;[Ljava/lang/String;)V
    //   1071: aload_0
    //   1072: invokevirtual 430	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:g	()Z
    //   1075: istore 8
    //   1077: goto -539 -> 538
    //   1080: aload 7
    //   1082: aload_1
    //   1083: invokevirtual 395	com/tencent/mobileqq/earlydownload/xmldata/XmlData:updateServerInfo	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;)V
    //   1086: aload 7
    //   1088: aload_1
    //   1089: getfield 64	com/tencent/mobileqq/earlydownload/xmldata/XmlData:Version	I
    //   1092: putfield 64	com/tencent/mobileqq/earlydownload/xmldata/XmlData:Version	I
    //   1095: aload 7
    //   1097: iconst_1
    //   1098: putfield 207	com/tencent/mobileqq/earlydownload/xmldata/XmlData:loadState	I
    //   1101: aload 7
    //   1103: iconst_1
    //   1104: putfield 176	com/tencent/mobileqq/earlydownload/xmldata/XmlData:hasResDownloaded	Z
    //   1107: aload 7
    //   1109: iconst_1
    //   1110: anewarray 80	java/lang/String
    //   1113: dup
    //   1114: iconst_0
    //   1115: ldc -79
    //   1117: aastore
    //   1118: invokestatic 180	com/tencent/mobileqq/earlydownload/EarlyDataFactory:a	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;[Ljava/lang/String;)V
    //   1121: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1124: ifeq +32 -> 1156
    //   1127: ldc 126
    //   1129: iconst_2
    //   1130: new 30	java/lang/StringBuilder
    //   1133: dup
    //   1134: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   1137: ldc_w 432
    //   1140: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1143: aload_0
    //   1144: getfield 53	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:e	Ljava/lang/String;
    //   1147: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1150: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1153: invokestatic 130	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1156: aload 5
    //   1158: invokevirtual 350	java/io/File:exists	()Z
    //   1161: ifne +71 -> 1232
    //   1164: aload_0
    //   1165: invokevirtual 261	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:b	()Z
    //   1168: ifne +64 -> 1232
    //   1171: aload_2
    //   1172: aload 5
    //   1174: invokestatic 437	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/io/File;Ljava/io/File;)V
    //   1177: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1180: ifeq +52 -> 1232
    //   1183: ldc 126
    //   1185: iconst_2
    //   1186: new 30	java/lang/StringBuilder
    //   1189: dup
    //   1190: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   1193: ldc_w 439
    //   1196: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1199: aload_2
    //   1200: invokevirtual 345	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1203: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1206: ldc_w 441
    //   1209: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1212: aload 5
    //   1214: invokevirtual 345	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1217: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1220: ldc_w 443
    //   1223: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1226: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1229: invokestatic 130	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1232: aload 7
    //   1234: iconst_0
    //   1235: anewarray 80	java/lang/String
    //   1238: invokestatic 180	com/tencent/mobileqq/earlydownload/EarlyDataFactory:a	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;[Ljava/lang/String;)V
    //   1241: aload_0
    //   1242: aload_2
    //   1243: invokevirtual 345	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1246: invokevirtual 184	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:a	(Ljava/lang/String;)V
    //   1249: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1252: ifeq +52 -> 1304
    //   1255: ldc 126
    //   1257: iconst_2
    //   1258: new 30	java/lang/StringBuilder
    //   1261: dup
    //   1262: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   1265: ldc_w 331
    //   1268: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1271: aload 7
    //   1273: getfield 135	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strResName	Ljava/lang/String;
    //   1276: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1279: ldc_w 445
    //   1282: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1285: aload_2
    //   1286: invokevirtual 345	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1289: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1292: ldc_w 443
    //   1295: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1298: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1301: invokestatic 130	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1304: aload_0
    //   1305: getfield 186	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:jdField_d_of_type_Boolean	Z
    //   1308: ifeq +128 -> 1436
    //   1311: new 188	android/content/Intent
    //   1314: dup
    //   1315: ldc -66
    //   1317: invokespecial 191	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   1320: astore_3
    //   1321: aload_3
    //   1322: ldc -58
    //   1324: aload_0
    //   1325: getfield 53	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:e	Ljava/lang/String;
    //   1328: invokevirtual 202	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1331: pop
    //   1332: aload_3
    //   1333: ldc -53
    //   1335: aload 7
    //   1337: getfield 78	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strPkgName	Ljava/lang/String;
    //   1340: invokevirtual 202	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1343: pop
    //   1344: aload_3
    //   1345: ldc -51
    //   1347: iconst_1
    //   1348: invokevirtual 210	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1351: pop
    //   1352: aload_3
    //   1353: ldc -44
    //   1355: aload 7
    //   1357: getfield 214	com/tencent/mobileqq/earlydownload/xmldata/XmlData:totalSize	J
    //   1360: invokevirtual 217	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   1363: pop
    //   1364: aload_3
    //   1365: ldc -37
    //   1367: aload 7
    //   1369: getfield 221	com/tencent/mobileqq/earlydownload/xmldata/XmlData:downSize	J
    //   1372: invokevirtual 217	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   1375: pop
    //   1376: aload_3
    //   1377: ldc -31
    //   1379: aload_2
    //   1380: invokevirtual 345	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1383: invokevirtual 202	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1386: pop
    //   1387: invokestatic 231	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1390: aload_3
    //   1391: ldc -23
    //   1393: invokevirtual 239	com/tencent/qphone/base/util/BaseApplication:sendBroadcast	(Landroid/content/Intent;Ljava/lang/String;)V
    //   1396: aload_0
    //   1397: iconst_0
    //   1398: putfield 186	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:jdField_d_of_type_Boolean	Z
    //   1401: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1404: ifeq +32 -> 1436
    //   1407: ldc 126
    //   1409: iconst_2
    //   1410: new 30	java/lang/StringBuilder
    //   1413: dup
    //   1414: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   1417: ldc_w 447
    //   1420: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1423: aload_0
    //   1424: getfield 53	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:e	Ljava/lang/String;
    //   1427: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1430: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1433: invokestatic 130	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1436: new 449	java/util/HashMap
    //   1439: dup
    //   1440: invokespecial 450	java/util/HashMap:<init>	()V
    //   1443: astore_3
    //   1444: aload_3
    //   1445: ldc_w 452
    //   1448: aload 7
    //   1450: getfield 78	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strPkgName	Ljava/lang/String;
    //   1453: invokevirtual 456	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1456: pop
    //   1457: aload_3
    //   1458: ldc_w 458
    //   1461: getstatic 464	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   1464: invokevirtual 465	java/lang/Boolean:toString	()Ljava/lang/String;
    //   1467: invokevirtual 456	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1470: pop
    //   1471: aload_0
    //   1472: invokevirtual 467	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:a	()Ljava/lang/String;
    //   1475: astore 4
    //   1477: aload 4
    //   1479: ifnull +42 -> 1521
    //   1482: aload 4
    //   1484: invokevirtual 83	java/lang/String:length	()I
    //   1487: ifle +34 -> 1521
    //   1490: invokestatic 231	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1493: invokestatic 472	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1496: aload_0
    //   1497: getfield 55	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1500: invokevirtual 473	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   1503: aload 4
    //   1505: iconst_1
    //   1506: ldc2_w 474
    //   1509: aload 5
    //   1511: invokevirtual 355	java/io/File:length	()J
    //   1514: aload_3
    //   1515: ldc_w 477
    //   1518: invokevirtual 480	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   1521: aload 6
    //   1523: invokevirtual 350	java/io/File:exists	()Z
    //   1526: ifne -1505 -> 21
    //   1529: aload_1
    //   1530: getfield 483	com/tencent/mobileqq/earlydownload/xmldata/XmlData:StoreBackup	Z
    //   1533: ifeq -1512 -> 21
    //   1536: aload_2
    //   1537: aload 6
    //   1539: invokestatic 437	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/io/File;Ljava/io/File;)V
    //   1542: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1545: ifeq -1524 -> 21
    //   1548: ldc 126
    //   1550: iconst_2
    //   1551: new 30	java/lang/StringBuilder
    //   1554: dup
    //   1555: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   1558: ldc_w 439
    //   1561: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1564: aload_2
    //   1565: invokevirtual 345	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1568: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1571: ldc_w 441
    //   1574: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1577: aload 6
    //   1579: invokevirtual 345	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1582: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1585: ldc_w 443
    //   1588: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1591: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1594: invokestatic 130	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1597: return
    //   1598: astore_1
    //   1599: return
    //   1600: astore_3
    //   1601: goto -369 -> 1232
    //   1604: iconst_0
    //   1605: istore 8
    //   1607: goto -1069 -> 538
    //   1610: aconst_null
    //   1611: astore_2
    //   1612: goto -1356 -> 256
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1615	0	this	EarlyHandler
    //   0	1615	1	paramXmlData	XmlData
    //   222	192	2	localObject1	Object
    //   550	31	2	localUnsatisfiedLinkError1	UnsatisfiedLinkError
    //   589	1	2	str1	String
    //   593	1	2	localException1	Exception
    //   631	1	2	localObject2	Object
    //   635	31	2	localOutOfMemoryError1	OutOfMemoryError
    //   674	1	2	str2	String
    //   678	50	2	localException2	Exception
    //   731	881	2	localObject3	Object
    //   1	1514	3	localObject4	Object
    //   1600	1	3	localException3	Exception
    //   378	352	4	str3	String
    //   735	33	4	localUnsatisfiedLinkError2	UnsatisfiedLinkError
    //   777	1	4	str4	String
    //   782	1	4	localException4	Exception
    //   785	40	4	localObject5	Object
    //   829	33	4	localOutOfMemoryError2	OutOfMemoryError
    //   871	1	4	str5	String
    //   876	1	4	localException5	Exception
    //   879	625	4	localObject6	Object
    //   115	1395	5	localFile1	File
    //   267	1311	6	localFile2	File
    //   26	1423	7	localXmlData	XmlData
    //   536	1070	8	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   211	223	550	java/lang/UnsatisfiedLinkError
    //   584	590	593	java/lang/Exception
    //   211	223	635	java/lang/OutOfMemoryError
    //   669	675	678	java/lang/Exception
    //   367	380	735	java/lang/UnsatisfiedLinkError
    //   772	779	782	java/lang/Exception
    //   367	380	829	java/lang/OutOfMemoryError
    //   866	873	876	java/lang/Exception
    //   1536	1597	1598	java/lang/Exception
    //   1171	1232	1600	java/lang/Exception
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_d_of_type_Boolean != paramBoolean)
    {
      this.jdField_d_of_type_Boolean = paramBoolean;
      if (QLog.isColorLevel()) {
        QLog.d("EarlyDown", 2, "setIsBroadcast() " + paramBoolean);
      }
    }
  }
  
  public abstract boolean b();
  
  public String c()
  {
    File localFile = BaseApplication.getContext().getDir("early", 0);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile.getAbsolutePath() + File.separator + this.e;
  }
  
  public void c()
  {
    if (!b()) {
      new File(c()).delete();
    }
  }
  
  public void c(XmlData paramXmlData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "onDownloadBegin()");
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((EarlyDownloadManager.EarlyDownLoadListener)localIterator.next()).a(paramXmlData);
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "setFail() resName:" + this.e);
    }
    XmlData localXmlData = a();
    if (localXmlData != null)
    {
      if (localXmlData.loadState != 1) {
        break label92;
      }
      localXmlData.loadState = 0;
      localXmlData.Version = 0;
    }
    for (;;)
    {
      localXmlData.hasResDownloaded = false;
      EarlyDataFactory.a(localXmlData, new String[] { "loadState", "Version", "hasResDownloaded" });
      return;
      label92:
      if ((localXmlData.loadState == 2) && (paramBoolean)) {
        localXmlData.loadState = 0;
      }
    }
  }
  
  public boolean c()
  {
    boolean bool1 = true;
    boolean bool3 = true;
    boolean bool2 = true;
    XmlData localXmlData = a();
    if (localXmlData != null) {
      if (NetworkUtil.i(BaseApplicationImpl.getContext())) {
        if (!localXmlData.loadWifi) {
          break label301;
        }
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("EarlyDown", 2, "isNetValid2Down() return:" + bool2 + " isWifiConn=true, " + localXmlData.strResName + ":loadWifi=" + localXmlData.loadWifi);
        bool1 = bool2;
      }
      return bool1;
      if (NetworkUtil.c(BaseApplicationImpl.getContext())) {
        if (NetworkUtil.d(BaseApplicationImpl.getContext())) {
          if (!localXmlData.load3G) {
            break label296;
          }
        }
      }
      label296:
      for (bool2 = bool1;; bool2 = false)
      {
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("EarlyDown", 2, "isNetValid2Down() return:" + bool2 + " is3Gor4G=true, " + localXmlData.strResName + ":load3G=" + localXmlData.load3G);
        return bool2;
        if (localXmlData.load2G) {}
        for (bool2 = bool3;; bool2 = false)
        {
          bool1 = bool2;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("EarlyDown", 2, "isNetValid2Down() return:" + bool2 + " is2G=true, " + localXmlData.strResName + ":load2G=" + localXmlData.load2G);
          return bool2;
          if (QLog.isColorLevel())
          {
            QLog.d("EarlyDown", 2, "isNetValid2Down() return:false, no wifi and no MobileNet.");
            return false;
            if (QLog.isColorLevel()) {
              QLog.d("EarlyDown", 2, "isNetValid2Download() return false, data == null");
            }
          }
          return false;
        }
      }
      label301:
      bool2 = false;
    }
  }
  
  public String d()
  {
    File localFile = new File(jdField_d_of_type_JavaLangString);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile.getAbsolutePath() + File.separator + this.e;
  }
  
  public void d()
  {
    if (b())
    {
      File localFile = new File(c());
      if (localFile.exists())
      {
        boolean bool = localFile.delete();
        if (QLog.isColorLevel()) {
          QLog.d("EarlyDown", 2, "doAfterFinish() deleteResouceAfterDownload==true, delete storage:" + localFile.getAbsolutePath() + " bool=" + bool);
        }
      }
    }
  }
  
  public void d(XmlData paramXmlData)
  {
    if (QLog.isColorLevel()) {
      QLog.e("EarlyDown", 2, "onDownloadCancel");
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((EarlyDownloadManager.EarlyDownLoadListener)localIterator.next()).b(paramXmlData);
      }
    }
  }
  
  public void d(boolean paramBoolean)
  {
    int i = 0;
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        if (!this.b)
        {
          this.b = true;
          i = 1;
        }
        if (i == 1)
        {
          HashMap localHashMap = new HashMap();
          localHashMap.put("param_strResName", this.e);
          StatisticCollector.a(BaseApplicationImpl.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "actEarlyDownUse", paramBoolean, 0L, 0L, localHashMap, "");
          if (QLog.isColorLevel()) {
            QLog.d("EarlyDown", 2, "statisticUsage() strResName=" + this.e + " inUse=" + paramBoolean);
          }
        }
        return;
      }
      finally {}
      if (!this.c)
      {
        this.c = true;
        i = 1;
      }
    }
  }
  
  public boolean d_()
  {
    return true;
  }
  
  public void e()
  {
    String str = c();
    try
    {
      new File(str).delete();
      EarlyDataFactory.a(a());
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public boolean e()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public boolean f()
  {
    boolean bool2 = false;
    boolean bool3 = false;
    XmlData localXmlData = a();
    if (localXmlData != null)
    {
      long l = System.currentTimeMillis();
      boolean bool1;
      if (localXmlData.tLoadFail != 0L)
      {
        bool1 = bool3;
        if (localXmlData.tLoadFail > 0L)
        {
          bool1 = bool3;
          if (localXmlData.tLoadFail + 43200000L >= l) {}
        }
      }
      else
      {
        bool1 = true;
      }
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("EarlyDown", 2, "isTimeValid() " + bool1 + " res=" + localXmlData.strResName + " tLoadFail=" + localXmlData.tLoadFail);
        bool2 = bool1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "isTimeValid() = false,  data = null");
    }
    return bool2;
  }
  
  public boolean g()
  {
    boolean bool2 = false;
    XmlData localXmlData = a();
    boolean bool3 = c();
    boolean bool1;
    if (!f()) {
      if (NetworkUtil.i(BaseApplicationImpl.getContext()))
      {
        if (!QLog.isColorLevel()) {
          break label142;
        }
        QLog.d("EarlyDown", 2, "wifi connected,reset timeValid=true");
        bool1 = true;
      }
    }
    for (;;)
    {
      if ((bool3) && (bool1))
      {
        ((EarlyDownloadManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(76)).a(localXmlData, c());
        bool2 = true;
      }
      while (!QLog.isColorLevel())
      {
        return bool2;
        bool1 = false;
        break;
      }
      QLog.d("EarlyDown", 2, "downloadResource() return false, netValid=" + bool3 + " timeValid=" + bool1 + " strResName=" + this.e);
      return false;
      label142:
      bool1 = true;
    }
  }
  
  public boolean h()
  {
    boolean bool1 = false;
    boolean bool2 = true;
    boolean bool3 = true;
    XmlData localXmlData = a();
    if (localXmlData == null)
    {
      bool2 = bool3;
      return bool2;
    }
    System.currentTimeMillis();
    if (localXmlData.loadState == 1)
    {
      if (!b())
      {
        if (!new File(c()).exists())
        {
          c(false);
          c();
        }
        bool1 = true;
      }
      label68:
      if (localXmlData.hasResDownloaded) {
        break label214;
      }
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("EarlyDown", 2, "isNeedServerInfo() " + a().strResName + " hasResDownloaded=false, 强制刷新");
        bool1 = bool2;
      }
    }
    label214:
    for (;;)
    {
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("EarlyDown", 2, "isNeedServerInfo() " + a().strResName + " need=" + bool1);
      return bool1;
      if ((localXmlData.Version != 0) && (localXmlData.loadState != 2))
      {
        localXmlData.Version = 0;
        EarlyDataFactory.a(localXmlData, new String[] { "Version" });
      }
      bool1 = true;
      break label68;
    }
  }
  
  public boolean i()
  {
    XmlData localXmlData = a();
    if (localXmlData == null) {
      if (QLog.isColorLevel()) {
        QLog.d("EarlyDown", 2, "enableNetChangedGoOn() return false. data == null");
      }
    }
    do
    {
      return false;
      if (NetworkUtil.i(BaseApplicationImpl.getContext()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("EarlyDown", 2, "enableNetChangedGoOn() isWifi, return " + localXmlData.net_2_wifi + " resName=" + localXmlData.strResName);
        }
        return localXmlData.net_2_wifi;
      }
      if (NetworkUtil.c(BaseApplicationImpl.getContext()))
      {
        if (NetworkUtil.d(BaseApplicationImpl.getContext()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("EarlyDown", 2, "enableNetChangedGoOn() is3Gor4G, return " + localXmlData.net_2_3G + " resName=" + localXmlData.strResName);
          }
          return localXmlData.net_2_3G;
        }
        if (QLog.isColorLevel()) {
          QLog.d("EarlyDown", 2, "enableNetChangedGoOn() is2G, return " + localXmlData.net_2_2G + " resName=" + localXmlData.strResName);
        }
        return localXmlData.net_2_2G;
      }
    } while (!QLog.isColorLevel());
    QLog.d("EarlyDown", 2, "enableNetChangedGoOn() return false. no wifi or mobile net. resName=" + localXmlData.strResName);
    return false;
  }
  
  public boolean j()
  {
    XmlData localXmlData = a();
    if (localXmlData != null) {
      return localXmlData.loadState == 1;
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\earlydownload\handler\EarlyHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */