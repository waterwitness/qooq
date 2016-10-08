package com.tencent.mobileqq.earlydownload;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.bitapp.preDownload.RNPreDownloadHandler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.earlydownload.handler.AppleEmojiHandler;
import com.tencent.mobileqq.earlydownload.handler.ArNativeSoDownloadHandler;
import com.tencent.mobileqq.earlydownload.handler.ArkSoDownloadHandler;
import com.tencent.mobileqq.earlydownload.handler.ChirpSoHandler;
import com.tencent.mobileqq.earlydownload.handler.EarlyHandler;
import com.tencent.mobileqq.earlydownload.handler.GifHandler;
import com.tencent.mobileqq.earlydownload.handler.JpegSoDownloadHandler;
import com.tencent.mobileqq.earlydownload.handler.PrecoverHandler;
import com.tencent.mobileqq.earlydownload.handler.PttSilkAndChangeVoiceSoHandler;
import com.tencent.mobileqq.earlydownload.handler.QQDingdongSoundHandler;
import com.tencent.mobileqq.earlydownload.handler.QQShortVideoConstFilterHandler;
import com.tencent.mobileqq.earlydownload.handler.QQShortVideoHandler;
import com.tencent.mobileqq.earlydownload.handler.QQShortVideoHandlerX86;
import com.tencent.mobileqq.earlydownload.handler.QQShortVideoVarFilterHandler;
import com.tencent.mobileqq.earlydownload.handler.QavGAudioSoundHandler;
import com.tencent.mobileqq.earlydownload.handler.QavImageHandler;
import com.tencent.mobileqq.earlydownload.handler.QavSoDownloadHandler;
import com.tencent.mobileqq.earlydownload.handler.QavSoDownloadHandlerV7;
import com.tencent.mobileqq.earlydownload.handler.QavSoRepairHandler;
import com.tencent.mobileqq.earlydownload.handler.QavVideoDownloadHandler;
import com.tencent.mobileqq.earlydownload.handler.SystemFaceHandler;
import com.tencent.mobileqq.earlydownload.handler.WebpSoDownloadHandler;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.INetEngine.IBreakDownFix;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import mqq.manager.Manager;
import mqq.manager.ServerConfigManager;
import mqq.observer.ServerConfigObserver;
import protocol.KQQConfig.GPS;
import protocol.KQQConfig.GetResourceReqInfoV2;
import protocol.KQQConfig.GetResourceRespInfo;
import protocol.KQQConfig.GetResourceRespInfoV2;
import protocol.KQQConfig.GetResourceRespV2;
import protocol.KQQConfig.ReqUserInfo;

public class EarlyDownloadManager
  extends ServerConfigObserver
  implements Handler.Callback, INetEngine.IBreakDownFix, INetEngine.INetEngineListener, Manager
{
  static final int jdField_a_of_type_Int = 131328;
  private static String jdField_a_of_type_JavaLangString;
  public static final Lock a;
  static final String[] jdField_a_of_type_ArrayOfJavaLangString;
  static final int jdField_b_of_type_Int = 131329;
  static final int c = 131330;
  static final int d = 131331;
  static final int e = 131332;
  static final int f = 131333;
  static final int g = 3;
  public static int h;
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  private HashMap jdField_b_of_type_JavaUtilHashMap;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "qq.android.native.short.video", "qq.android.native.short.video.x86", "qq.android.native.short.video.filter.const.v1", "qq.android.native.short.video.filter.var.v1", "qq.android.appleemoji", "qq.android.system.face.gifv4", "qq.android.ar.native.so", "qq.android.qav.so", "qq.android.qav.sov7", "qq.android.qav.sorepair.all", "qq.android.qav.image2", "qq.android.qav.muteaudio", "qq.android.pic.jpeg.so", "qq.android.pic.webp.so", "qq.android.native.gif", "qq.android.qav.video", "qq.android.ptt.so.658", "qq.android.reactnative.system.resource", ArkSoDownloadHandler.b(), "qq.android.system.chirp", "qq.android.dingdong.ring", "qq.android.early.precover" };
    h = 60000;
    jdField_a_of_type_JavaUtilConcurrentLocksLock = new ReentrantLock();
  }
  
  public EarlyDownloadManager(QQAppInterface paramQQAppInterface)
  {
    this.b = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.b(), this);
  }
  
  private static final EarlyHandler a(String paramString, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "createHandler pkgName=" + paramString);
    }
    if ((paramString == null) || (paramString.length() == 0)) {}
    label303:
    do
    {
      boolean bool;
      do
      {
        do
        {
          return null;
          if ("qq.android.system.face.gifv4".equals(paramString)) {
            return new SystemFaceHandler(paramQQAppInterface);
          }
          if ("qq.android.qav.so".equals(paramString)) {
            return new QavSoDownloadHandler(paramQQAppInterface);
          }
          if ("qq.android.qav.sov7".equals(paramString)) {
            return new QavSoDownloadHandlerV7(paramQQAppInterface);
          }
          if ("qq.android.qav.sorepair.all".equals(paramString)) {
            return new QavSoRepairHandler(paramQQAppInterface);
          }
          if ("qq.android.qav.image2".equals(paramString)) {
            return new QavImageHandler(paramQQAppInterface);
          }
          if ("qq.android.qav.muteaudio".equals(paramString)) {
            return new QavGAudioSoundHandler(paramQQAppInterface);
          }
          if ("qq.android.pic.jpeg.so".equals(paramString)) {
            return new JpegSoDownloadHandler(paramQQAppInterface);
          }
          if ("qq.android.pic.webp.so".equals(paramString)) {
            return new WebpSoDownloadHandler(paramQQAppInterface);
          }
          if ("qq.android.native.gif".equals(paramString)) {
            return new GifHandler(paramQQAppInterface);
          }
          if ((!"qq.android.native.short.video".equals(paramString)) && (!"qq.android.native.short.video.x86".equals(paramString))) {
            break label303;
          }
          bool = VideoEnvironment.c();
          if (QLog.isColorLevel()) {
            QLog.e("EarlyDown", 2, "createHandler() can't find Handler for:" + paramString + " mIsX86Platform=" + bool);
          }
          if (!"qq.android.native.short.video.x86".equals(paramString)) {
            break;
          }
        } while (!bool);
        return new QQShortVideoHandlerX86(paramQQAppInterface);
      } while (bool);
      return new QQShortVideoHandler(paramQQAppInterface);
      if ("qq.android.native.short.video.filter.const.v1".equals(paramString)) {
        return new QQShortVideoConstFilterHandler(paramQQAppInterface);
      }
      if ("qq.android.native.short.video.filter.var.v1".equals(paramString)) {
        return new QQShortVideoVarFilterHandler(paramQQAppInterface);
      }
      if ("qq.android.qav.video".equals(paramString)) {
        return new QavVideoDownloadHandler(paramQQAppInterface);
      }
      if ("qq.android.ptt.so.658".equals(paramString)) {
        return new PttSilkAndChangeVoiceSoHandler(paramQQAppInterface);
      }
      if ("qq.android.appleemoji".equals(paramString)) {
        return new AppleEmojiHandler(paramQQAppInterface);
      }
      if ("qq.android.reactnative.system.resource".equals(paramString)) {
        return new RNPreDownloadHandler(paramQQAppInterface);
      }
      if ("qq.android.ar.native.so".equals(paramString)) {
        return new ArNativeSoDownloadHandler(paramQQAppInterface);
      }
      if (ArkSoDownloadHandler.b().equals(paramString)) {
        return new ArkSoDownloadHandler(paramQQAppInterface);
      }
      if ("qq.android.dingdong.ring".equals(paramString)) {
        return new QQDingdongSoundHandler(paramQQAppInterface);
      }
      if ("qq.android.system.chirp".equals(paramString)) {
        return new ChirpSoHandler(paramQQAppInterface);
      }
      if ("qq.android.early.precover".equals(paramString)) {
        return new PrecoverHandler(paramQQAppInterface);
      }
    } while (!QLog.isColorLevel());
    QLog.e("EarlyDown", 2, "createHandler() can't find Handler for:" + paramString);
    return null;
  }
  
  public static String a()
  {
    BaseApplication localBaseApplication;
    if ((jdField_a_of_type_JavaLangString == null) || (jdField_a_of_type_JavaLangString.length() == 0))
    {
      localBaseApplication = BaseApplicationImpl.getContext();
      if (Build.VERSION.SDK_INT <= 10) {
        break label69;
      }
    }
    label69:
    for (int i = 4;; i = 0)
    {
      jdField_a_of_type_JavaLangString = localBaseApplication.getSharedPreferences("Last_Login", i).getString("uin", "");
      if ((jdField_a_of_type_JavaLangString == null) || (jdField_a_of_type_JavaLangString.length() <= 0)) {
        break;
      }
      return jdField_a_of_type_JavaLangString;
    }
    return "10000";
  }
  
  private void a(GetResourceRespV2 paramGetResourceRespV2)
  {
    if (paramGetResourceRespV2 == null) {}
    Object localObject1;
    Object localObject3;
    Object localObject4;
    do
    {
      return;
      if (paramGetResourceRespV2.vecDeletedResInfo != null)
      {
        localObject1 = paramGetResourceRespV2.vecDeletedResInfo.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (GetResourceRespInfoV2)((Iterator)localObject1).next();
          if (localObject2 != null)
          {
            localObject2 = ((GetResourceRespInfoV2)localObject2).strResName;
            localObject3 = (EarlyHandler)this.jdField_a_of_type_JavaUtilHashMap.get(localObject2);
            if (localObject3 != null) {
              ((EarlyHandler)localObject3).e();
            }
            a((String)localObject2);
          }
        }
      }
      if (paramGetResourceRespV2.vecAddedResInfo != null)
      {
        localObject3 = paramGetResourceRespV2.vecAddedResInfo.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject2 = (GetResourceRespInfoV2)((Iterator)localObject3).next();
          if ((localObject2 != null) && (((GetResourceRespInfoV2)localObject2).iPluginType == 512))
          {
            localObject4 = ((GetResourceRespInfoV2)localObject2).strResName;
            localObject1 = a((String)localObject4);
            if (localObject1 != null)
            {
              XmlData localXmlData = EarlyDataFactory.a(((EarlyHandler)localObject1).a(), ((GetResourceRespInfoV2)localObject2).strResName, ((GetResourceRespInfoV2)localObject2).strPkgName, ((GetResourceRespInfoV2)localObject2).strResConf, ((GetResourceRespInfoV2)localObject2).uiNewVer, ((GetResourceRespInfoV2)localObject2).strResURL_big, ((GetResourceRespInfoV2)localObject2).strResURL_small);
              ((EarlyHandler)localObject1).a().updateServerInfo(localXmlData);
              EarlyDataFactory.a(((EarlyHandler)localObject1).a(), new String[0]);
              localObject2 = Message.obtain();
              localObject1 = localObject2;
              if (localObject2 == null) {
                localObject1 = new Message();
              }
              ((Message)localObject1).what = 131332;
              ((Message)localObject1).obj = new Object[] { localObject4, localXmlData };
              if ((((String)localObject4).equals("qq.android.native.short.video")) || (((String)localObject4).equals("qq.android.native.short.video.x86")) || (((String)localObject4).equals("qq.android.native.short.video.filter.const.v1")) || (((String)localObject4).equals("qq.android.native.short.video.filter.var.v1")) || (((String)localObject4).equals("qq.android.ar.native.so"))) {}
              for (h = 0;; h = 60000)
              {
                this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject1, h);
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d("EarlyDown", 2, "doOnGetConfig() resName=" + (String)localObject4 + " updateServerInfo done, doOnServerResp after " + h + "ms");
                break;
              }
            }
          }
        }
      }
    } while (paramGetResourceRespV2.vecUpdatedResInfo == null);
    Object localObject2 = paramGetResourceRespV2.vecUpdatedResInfo.iterator();
    label386:
    while (((Iterator)localObject2).hasNext())
    {
      paramGetResourceRespV2 = (GetResourceRespInfoV2)((Iterator)localObject2).next();
      if ((paramGetResourceRespV2 != null) && (paramGetResourceRespV2.iPluginType == 512))
      {
        localObject3 = paramGetResourceRespV2.strResName;
        localObject1 = a((String)localObject3);
        if (localObject1 != null)
        {
          int i = ((EarlyHandler)localObject1).a().Version;
          localObject4 = EarlyDataFactory.a(((EarlyHandler)localObject1).a(), paramGetResourceRespV2.strResName, paramGetResourceRespV2.strPkgName, paramGetResourceRespV2.strResConf, paramGetResourceRespV2.uiNewVer, paramGetResourceRespV2.strResURL_big, paramGetResourceRespV2.strResURL_small);
          ((EarlyHandler)localObject1).a().updateServerInfo((XmlData)localObject4);
          if (i < paramGetResourceRespV2.uiNewVer) {
            ((EarlyHandler)localObject1).a().loadState = 0;
          }
          EarlyDataFactory.a(((EarlyHandler)localObject1).a(), new String[0]);
          localObject1 = Message.obtain();
          paramGetResourceRespV2 = (GetResourceRespV2)localObject1;
          if (localObject1 == null) {
            paramGetResourceRespV2 = new Message();
          }
          paramGetResourceRespV2.what = 131332;
          paramGetResourceRespV2.obj = new Object[] { localObject3, localObject4 };
          if ((!((String)localObject3).equals("qq.android.native.short.video")) && (!((String)localObject3).equals("qq.android.native.short.video.x86")) && (!((String)localObject3).equals("qq.android.native.short.video.filter.const.v1")) && (!((String)localObject3).equals("qq.android.native.short.video.filter.var.v1")) && (!((String)localObject3).equals("qq.android.ar.native.so"))) {
            break label680;
          }
        }
      }
    }
    label680:
    for (h = 0;; h = 60000)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramGetResourceRespV2, h);
      if (!QLog.isColorLevel()) {
        break label386;
      }
      QLog.d("EarlyDown", 2, "doOnGetConfig() resName=" + (String)localObject3 + " updateServerInfo done, doOnServerResp after " + h + "ms");
      break label386;
      break;
    }
  }
  
  private boolean a(XmlData paramXmlData, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "verifyResource() data=" + paramXmlData.strResName + ", filepath=" + paramString);
    }
    if ((paramXmlData == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    if (TextUtils.isEmpty(paramXmlData.MD5)) {
      return false;
    }
    File localFile = new File(paramString);
    if (!localFile.exists())
    {
      if (QLog.isColorLevel()) {
        QLog.e("EarlyDown", 2, "verifyResource() file[" + paramString + "] not exist..");
      }
      return false;
    }
    Object localObject = null;
    try
    {
      paramString = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString));
      if (QLog.isColorLevel()) {
        QLog.d("EarlyDown", 2, "verifyResource " + paramXmlData.strResName + "data.md5=" + paramXmlData.MD5 + ",file.md5=" + paramString);
      }
      if (paramXmlData.MD5.equalsIgnoreCase(paramString)) {
        return true;
      }
    }
    catch (UnsatisfiedLinkError paramString)
    {
      for (;;)
      {
        try
        {
          paramString = MD5FileUtil.a(localFile);
        }
        catch (Exception paramString)
        {
          paramString = (String)localObject;
        }
        paramXmlData.strLog = (".md5.S:" + paramXmlData.MD5 + ".L:" + paramString + ".");
        return false;
      }
    }
  }
  
  private void b(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("strResName");
    Object localObject2 = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "handleBroadcastReq() resName=" + str + " action=" + (String)localObject2);
    }
    EarlyHandler localEarlyHandler = a(str);
    Object localObject1;
    if (localEarlyHandler == null)
    {
      localObject1 = new Intent(paramIntent.getAction().replace("req.", "resp."));
      ((Intent)localObject1).putExtra("strResName", paramIntent.getStringExtra("strResName"));
      ((Intent)localObject1).putExtra("strPkgName", paramIntent.getStringExtra("strPkgName"));
      ((Intent)localObject1).putExtra("reqResult", false);
      ((Intent)localObject1).putExtra("resultReason", "resName:" + str + " is not valid.");
      BaseApplicationImpl.getContext().sendBroadcast((Intent)localObject1, "com.tencent.qqhead.permission.getheadresp");
    }
    do
    {
      do
      {
        return;
        localObject1 = localEarlyHandler.a();
        if ("req.com.tencent.mobileqq.EARLY_DOWNLOAD".equals(localObject2))
        {
          if (((XmlData)localObject1).loadState == 1)
          {
            paramIntent = new Intent("resp.com.tencent.mobileqq.EARLY_DOWNLOAD");
            paramIntent.putExtra("reqResult", false);
            paramIntent.putExtra("strResName", str);
            paramIntent.putExtra("strPkgName", ((XmlData)localObject1).strPkgName);
            paramIntent.putExtra("loadState", 1);
            paramIntent.putExtra("resultReason", "resource has been success.");
            BaseApplicationImpl.getContext().sendBroadcast(paramIntent, "com.tencent.qqhead.permission.getheadresp");
            return;
          }
          localEarlyHandler.b(true);
          localEarlyHandler.a(paramIntent.getBooleanExtra("userClick", false));
          return;
        }
        if ("req.com.tencent.mobileqq.EARLY_QUERY".equals(localObject2))
        {
          paramIntent = new Intent("resp.com.tencent.mobileqq.EARLY_QUERY");
          paramIntent.putExtra("strResName", str);
          paramIntent.putExtra("strPkgName", ((XmlData)localObject1).strPkgName);
          paramIntent.putExtra("reqResult", true);
          paramIntent.putExtra("loadState", ((XmlData)localObject1).loadState);
          paramIntent.putExtra("totalSize", ((XmlData)localObject1).totalSize);
          paramIntent.putExtra("downSize", ((XmlData)localObject1).downSize);
          BaseApplicationImpl.getContext().sendBroadcast(paramIntent, "com.tencent.qqhead.permission.getheadresp");
          return;
        }
        if ("req.com.tencent.mobileqq.EARLY_CANCEL".equals(localObject2))
        {
          localEarlyHandler.b(true);
          a(localEarlyHandler.a());
          return;
        }
      } while (!"req.com.tencent.mobileqq.EARLY_SET_FAIL".equals(localObject2));
      localEarlyHandler.c(false);
      localObject2 = new Intent("resp.com.tencent.mobileqq.EARLY_SET_FAIL");
      ((Intent)localObject2).putExtra("strResName", str);
      ((Intent)localObject2).putExtra("strPkgName", ((XmlData)localObject1).strPkgName);
      ((Intent)localObject2).putExtra("reqResult", true);
      ((Intent)localObject2).putExtra("loadState", ((XmlData)localObject1).loadState);
      BaseApplicationImpl.getContext().sendBroadcast((Intent)localObject2, "com.tencent.qqhead.permission.getheadresp");
    } while (!paramIntent.getBooleanExtra("restartDownload", false));
    localEarlyHandler.b(true);
    localEarlyHandler.a(paramIntent.getBooleanExtra("userClick", false));
  }
  
  private void b(XmlData paramXmlData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "doOnCancelDownload() name=" + paramXmlData.strResName + ",strResURL_big=" + paramXmlData.strResURL_big + ",strResURL_small=" + paramXmlData.strResURL_small + ",localVer=" + paramXmlData.Version);
    }
    jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    EarlyHandler localEarlyHandler;
    do
    {
      try
      {
        localObject = (NetReq)this.b.remove(paramXmlData.strResName);
        jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        localEarlyHandler = a(paramXmlData.strResName);
        if (localObject != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0).b((NetReq)localObject);
          paramXmlData.tStart = 0L;
          paramXmlData.hasResDownloaded = false;
          paramXmlData.loadState = 0;
          EarlyDataFactory.a(paramXmlData, new String[] { "loadState", "hasResDownloaded", "tStart" });
          if (localEarlyHandler != null) {
            localEarlyHandler.d(paramXmlData);
          }
          return;
        }
      }
      finally
      {
        jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
    } while ((localEarlyHandler == null) || (!localEarlyHandler.e()));
    Object localObject = new Intent("resp.com.tencent.mobileqq.EARLY_CANCEL");
    ((Intent)localObject).putExtra("reqResult", false);
    ((Intent)localObject).putExtra("resultReason", "resName=" + paramXmlData.strResName + " is not loading..");
    ((Intent)localObject).putExtra("strResName", paramXmlData.strResName);
    ((Intent)localObject).putExtra("strPkgName", paramXmlData.strPkgName);
    BaseApplicationImpl.getContext().sendBroadcast((Intent)localObject, "com.tencent.qqhead.permission.getheadresp");
    localEarlyHandler.b(false);
  }
  
  private void b(NetResp paramNetResp)
  {
    XmlData localXmlData = (XmlData)paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.a();
    if (localXmlData == null) {}
    for (;;)
    {
      return;
      if (paramNetResp.e == 3)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("EarlyDown", 2, "doOnResp() resName=" + localXmlData.strResName + " is downloading...");
        return;
      }
      boolean bool1;
      label76:
      long l3;
      long l4;
      long l1;
      if (paramNetResp.e == 0)
      {
        bool1 = true;
        l3 = SystemClock.elapsedRealtime();
        l4 = localXmlData.tStart;
        l1 = 0L;
      }
      try
      {
        long l2 = new File(paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.b).length();
        l1 = l2;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          boolean bool2;
        }
      }
      if (bool1)
      {
        bool2 = a(localXmlData, paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.b);
        if (!bool2)
        {
          paramNetResp.f = -6103066;
          paramNetResp.jdField_a_of_type_JavaLangString = ("md5_not_same.netSize:" + l1 + localXmlData.strLog);
          localXmlData.strLog = "";
          localXmlData.hasResDownloaded = false;
        }
        try
        {
          FileUtils.d(paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.b);
          bool1 = bool2;
          if (QLog.isColorLevel())
          {
            QLog.d("EarlyDown", 2, "doOnResp() verifyResource=" + bool2 + " resName=" + localXmlData.strResName);
            bool1 = bool2;
          }
          int i = localXmlData.reqLoadCount;
          if (((paramNetResp.f == -6103066) || (paramNetResp.f == 56009)) && (i < 3))
          {
            if (QLog.isColorLevel()) {
              QLog.d("EarlyDown", 2, "retry load.resName:" + localXmlData.strResName + ".reqCount=" + localXmlData.reqLoadCount + ".errCode=" + paramNetResp.f);
            }
            a(localXmlData, paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.b);
            return;
            bool1 = false;
            break label76;
          }
          localXmlData.reqLoadCount = 0;
          EarlyHandler localEarlyHandler = a(localXmlData.strResName);
          Object localObject;
          if (bool1)
          {
            localXmlData.tLoadFail = 0L;
            localXmlData.loadState = 1;
            localXmlData.hasResDownloaded = true;
            localObject = null;
            if (QLog.isColorLevel()) {
              localObject = new StringBuffer("onDownloadFinish() resName=" + localXmlData.strResName + " storeBackup=" + localXmlData.StoreBackup);
            }
            if ((!localXmlData.StoreBackup) || (localEarlyHandler == null)) {}
          }
          try
          {
            str = localEarlyHandler.d();
            bool2 = FileUtils.d(paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.b, str);
            if ((QLog.isColorLevel()) && (localObject != null)) {
              ((StringBuffer)localObject).append(" copyResult=" + bool2 + " src=" + paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.b + " dest=" + str);
            }
          }
          catch (Exception localException3)
          {
            String str;
            for (;;) {}
          }
          if ((QLog.isColorLevel()) && (localObject != null)) {
            QLog.d("EarlyDown", 2, ((StringBuffer)localObject).toString());
          }
          EarlyDataFactory.a(localXmlData, new String[] { "Version", "loadState", "tLoadFail", "hasResDownloaded" });
          if (QLog.isColorLevel()) {
            QLog.d("EarlyDown", 2, "doOnResp() result=" + bool1 + " errCode=" + paramNetResp.f + " name=" + localXmlData.strResName + ",strResURL_big=" + localXmlData.strResURL_big);
          }
          jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
          try
          {
            localObject = (NetReq)this.b.remove(localXmlData.strResName);
            jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
            if (localObject != null)
            {
              if (localEarlyHandler != null)
              {
                localEarlyHandler.a(localXmlData, bool1, paramNetResp.f, paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.b);
                localEarlyHandler.d();
              }
              if ((paramNetResp.f == 9366) || (paramNetResp.f == 9037) || (paramNetResp.f == 9004) || (paramNetResp.f == 9040)) {
                continue;
              }
              localObject = new HashMap();
              ((HashMap)localObject).put("param_FailCode", Integer.toString(paramNetResp.f));
              ((HashMap)localObject).put("param_strPkgName", localXmlData.strPkgName);
              ((HashMap)localObject).put("param_reqCount", Integer.toString(i));
              if (!bool1)
              {
                if (paramNetResp.jdField_a_of_type_JavaUtilHashMap != null)
                {
                  str = (String)paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("serverip");
                  if ((str != null) && (str.length() > 0)) {
                    ((HashMap)localObject).put("param_serverIP", str);
                  }
                }
                if ((paramNetResp.jdField_a_of_type_JavaLangString != null) && (paramNetResp.jdField_a_of_type_JavaLangString.length() > 0))
                {
                  ((HashMap)localObject).put("param_desc", paramNetResp.jdField_a_of_type_JavaLangString + localXmlData.strLog);
                  localXmlData.strLog = "";
                }
              }
              if (localEarlyHandler == null) {
                continue;
              }
              paramNetResp = localEarlyHandler.a();
              if ((paramNetResp == null) || (paramNetResp.length() <= 0)) {
                continue;
              }
              return;
              if ((paramNetResp.f != 9366) && (paramNetResp.f != 9369) && (paramNetResp.f != 9367) && (paramNetResp.f != 9037) && (paramNetResp.f != 9004)) {
                localXmlData.tLoadFail = System.currentTimeMillis();
              }
              if (QLog.isColorLevel()) {
                QLog.d("EarlyDown", 2, "set tLoadFail=" + localXmlData.tLoadFail + " strPkgName=" + localXmlData.strResName);
              }
              localEarlyHandler.c(true);
              FileUtils.d(paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.b);
            }
          }
          finally
          {
            jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
          }
          QLog.d("EarlyDown", 2, "doOnResp() resName=" + localXmlData.strResName + " netReq is null. may has been cancelled.");
          return;
        }
        catch (Exception localException1)
        {
          for (;;) {}
        }
      }
    }
  }
  
  public EarlyHandler a(String paramString)
  {
    Object localObject;
    if ((paramString == null) || (paramString.length() == 0)) {
      localObject = null;
    }
    EarlyHandler localEarlyHandler;
    do
    {
      do
      {
        return (EarlyHandler)localObject;
        localEarlyHandler = (EarlyHandler)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
        localObject = localEarlyHandler;
      } while (localEarlyHandler != null);
      localEarlyHandler = a(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      localObject = localEarlyHandler;
    } while (localEarlyHandler == null);
    jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)) {
        this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localEarlyHandler);
      }
      return localEarlyHandler;
    }
    finally
    {
      jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {}
    boolean bool;
    do
    {
      do
      {
        return;
        bool = this.jdField_a_of_type_AndroidOsHandler.hasMessages(131331);
        if ((!this.jdField_a_of_type_Boolean) || (bool)) {
          break;
        }
        Message localMessage2 = Message.obtain();
        Message localMessage1 = localMessage2;
        if (localMessage2 == null) {
          localMessage1 = new Message();
        }
        localMessage1.what = 131330;
        if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(131330)) {
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(131330);
        }
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage1, h);
      } while (!QLog.isColorLevel());
      QLog.d("EarlyDown", 2, "onNetChange() sendMsg:ACTION_NET_CHANGE, delay(ms):" + h);
      return;
    } while (!QLog.isColorLevel());
    QLog.d("EarlyDown", 2, "onNetChanged() return, afterAppStart=" + this.jdField_a_of_type_Boolean + " hasMsg:" + bool);
  }
  
  public void a(Intent paramIntent)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      Message localMessage2 = Message.obtain();
      Message localMessage1 = localMessage2;
      if (localMessage2 == null) {
        localMessage1 = new Message();
      }
      localMessage1.obj = paramIntent;
      localMessage1.what = 131333;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage1);
    }
  }
  
  void a(XmlData paramXmlData)
  {
    if (paramXmlData == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("EarlyDown", 2, "cancelDownload.name=" + paramXmlData.strResName + ",strResURL_big=" + paramXmlData.strResURL_big + ",localVer=" + paramXmlData.Version);
      }
    } while (this.jdField_a_of_type_AndroidOsHandler == null);
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(131329, paramXmlData).sendToTarget();
  }
  
  public void a(XmlData paramXmlData, String paramString)
  {
    if ((paramXmlData == null) || (paramString == null) || (paramString.length() == 0)) {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("downloadResource() return, ");
        if (paramXmlData != null) {
          break label58;
        }
        paramXmlData = "data==null";
        QLog.d("EarlyDown", 2, paramXmlData);
      }
    }
    label58:
    do
    {
      do
      {
        return;
        paramXmlData = "storagePath=" + paramString;
        break;
        if (QLog.isColorLevel()) {
          QLog.d("EarlyDown", 2, "downloadResource() name=" + paramXmlData.strResName + " strResURL_big=" + paramXmlData.strResURL_big + " storagePath=" + paramString);
        }
      } while (TextUtils.isEmpty(paramXmlData.strResURL_big));
      if ((paramXmlData.reqLoadCount != 0) || (!this.b.containsKey(paramXmlData.strResName))) {
        break label233;
      }
      if (paramXmlData.loadState == 0)
      {
        paramXmlData.loadState = 2;
        EarlyDataFactory.a(paramXmlData, new String[] { "loadState" });
      }
    } while (!QLog.isColorLevel());
    QLog.d("EarlyDown", 2, "downloadResource() return, already exist=" + paramXmlData.strResName);
    return;
    label233:
    paramXmlData.tStart = SystemClock.elapsedRealtime();
    paramXmlData.loadState = 2;
    paramXmlData.hasResDownloaded = false;
    EarlyDataFactory.a(paramXmlData, new String[] { "loadState", "hasResDownloaded" });
    Object localObject = a(paramXmlData.getStrResName());
    if ((localObject != null) && (paramXmlData.reqLoadCount == 0)) {
      ((EarlyHandler)localObject).c(paramXmlData);
    }
    paramXmlData.reqLoadCount += 1;
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0);
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = this;
    localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix = this;
    localHttpNetReq.jdField_a_of_type_JavaLangString = paramXmlData.strResURL_big;
    localHttpNetReq.jdField_a_of_type_Boolean = true;
    localHttpNetReq.c = 0;
    localHttpNetReq.a(paramXmlData);
    localHttpNetReq.b = paramString;
    localHttpNetReq.h = true;
    localHttpNetReq.i = true;
    if (paramXmlData.isUserClick) {}
    for (localHttpNetReq.m = 1;; localHttpNetReq.m = 2)
    {
      jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
      try
      {
        this.b.put(paramXmlData.strResName, localHttpNetReq);
        jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        return;
      }
      finally
      {
        jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
    }
  }
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    paramNetReq = (XmlData)paramNetReq.a();
    if (paramNetReq != null)
    {
      paramNetReq.totalSize = paramLong2;
      paramNetReq.downSize = paramLong1;
      paramNetReq = a(paramNetReq.strResName);
      if (paramNetReq != null) {
        paramNetReq.b(paramLong1, paramLong2);
      }
    }
  }
  
  public void a(NetReq paramNetReq, NetResp paramNetResp)
  {
    if ((paramNetReq == null) || (paramNetResp == null)) {}
    StringBuffer localStringBuffer;
    do
    {
      do
      {
        return;
      } while (!(paramNetReq instanceof HttpNetReq));
      HttpNetReq localHttpNetReq = (HttpNetReq)paramNetReq;
      localStringBuffer = new StringBuffer();
      localStringBuffer.append(".start=" + localHttpNetReq.jdField_a_of_type_Long + ".written=" + paramNetResp.c);
      localHttpNetReq.jdField_a_of_type_Long += paramNetResp.c;
      paramNetResp.c = 0L;
      paramNetResp = "bytes=" + localHttpNetReq.jdField_a_of_type_Long + "-";
      localHttpNetReq.jdField_a_of_type_JavaUtilHashMap.put("Range", paramNetResp);
      localStringBuffer.append(".range=");
      localStringBuffer.append(paramNetResp);
    } while (!(paramNetReq.a() instanceof XmlData));
    ((XmlData)paramNetReq.a()).strLog = localStringBuffer.toString();
  }
  
  public void a(NetResp paramNetResp)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.obtainMessage(131328, paramNetResp).sendToTarget();
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "removeHandler() strResName=" + paramString);
    }
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (;;)
    {
      return;
      jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
      try
      {
        paramString = (EarlyHandler)this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
        jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        if (paramString == null) {
          continue;
        }
        paramString.b();
        return;
      }
      finally
      {
        jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
    }
  }
  
  public void a(GetResourceRespInfo paramGetResourceRespInfo)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d("EarlyDown", 2, "onServerResp() afterAppStart=true");
      }
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      Message localMessage2 = Message.obtain();
      Message localMessage1 = localMessage2;
      if (localMessage2 == null) {
        localMessage1 = new Message();
      }
      localMessage1.what = 131332;
      localMessage1.obj = paramGetResourceRespInfo;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage1);
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Long > 0L) && (this.jdField_a_of_type_Long + 7200000 > SystemClock.elapsedRealtime()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EarlyDown", 2, "updateConfigs() timeUpdateSuccess + delay(" + 120 + "min) > now. return.");
      }
      return;
    }
    ReqUserInfo localReqUserInfo = new ReqUserInfo();
    localReqUserInfo.cType = 1;
    localReqUserInfo.stGps = new GPS();
    localReqUserInfo.strAuthName = "B1_QQ_Neighbor_android";
    localReqUserInfo.strAuthPassword = "NzVK_qGE";
    localReqUserInfo.vCells = new ArrayList();
    localReqUserInfo.vMacs = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = arrayOfString[i];
      GetResourceReqInfoV2 localGetResourceReqInfoV2 = null;
      localObject = a((String)localObject);
      if (localObject != null) {
        localGetResourceReqInfoV2 = ((EarlyHandler)localObject).a();
      }
      if (localGetResourceReqInfoV2 != null) {
        localArrayList.add(localGetResourceReqInfoV2);
      }
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "getPluginList: 128 reqInfoV2s.len=" + localArrayList.size());
    }
    ((ServerConfigManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(4)).getPluginConfig(512, localReqUserInfo, localArrayList, this);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      Object localObject;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return false;
                b((NetResp)paramMessage.obj);
                return false;
                b((XmlData)paramMessage.obj);
                return false;
                b();
                return false;
                localObject = null;
                if (paramMessage.obj != null) {
                  localObject = (GetResourceRespV2)paramMessage.obj;
                }
                a((GetResourceRespV2)localObject);
                return false;
                if (!(paramMessage.obj instanceof GetResourceRespInfo)) {
                  break;
                }
                paramMessage = (GetResourceRespInfo)paramMessage.obj;
                if (QLog.isColorLevel()) {
                  QLog.d("EarlyDown", 2, "doOnServerResp() iResult=" + paramMessage.iResult + " resp.strPkgName=" + paramMessage.strPkgName);
                }
              } while (paramMessage.iResult != 0);
              localObject = a(paramMessage.strResName);
            } while (localObject == null);
            ((EarlyHandler)localObject).b(EarlyDataFactory.a(((EarlyHandler)localObject).a(), paramMessage.strResName, paramMessage.strPkgName, paramMessage.strResConf, paramMessage.uiNewVer, paramMessage.strResURL_big, paramMessage.strResURL_small));
            return false;
          } while (!(paramMessage.obj instanceof Object[]));
          localObject = (Object[])paramMessage.obj;
        } while ((localObject.length != 2) || (!(localObject[0] instanceof String)) || (!(localObject[1] instanceof XmlData)));
        paramMessage = (String)localObject[0];
        localObject = (XmlData)localObject[1];
        paramMessage = a(paramMessage);
      } while (paramMessage == null);
      paramMessage.b((XmlData)localObject);
      return false;
    } while (!(paramMessage.obj instanceof Intent));
    b((Intent)paramMessage.obj);
    return false;
  }
  
  public void onDestroy()
  {
    jdField_a_of_type_JavaLangString = null;
    String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = arrayOfString[i];
      localObject2 = (EarlyHandler)this.jdField_a_of_type_JavaUtilHashMap.get(localObject2);
      if (localObject2 != null) {
        ((EarlyHandler)localObject2).b();
      }
      i += 1;
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    this.jdField_a_of_type_AndroidOsHandler = null;
    jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      return;
    }
    finally
    {
      jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  public void onGetPluginConfig(boolean paramBoolean, int paramInt, GetResourceRespV2 paramGetResourceRespV2)
  {
    int i;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuffer();
      ((StringBuffer)localObject1).append("onGetPluginConfig() isSucc=" + paramBoolean + " iPluginType=" + paramInt);
      if (paramGetResourceRespV2 != null)
      {
        ((StringBuffer)localObject1).append(" result=" + paramGetResourceRespV2.result);
        ((StringBuffer)localObject1).append(" uin=" + paramGetResourceRespV2.uin);
        localObject2 = new StringBuilder().append(" add=");
        if (paramGetResourceRespV2.vecAddedResInfo != null)
        {
          i = paramGetResourceRespV2.vecAddedResInfo.size();
          ((StringBuffer)localObject1).append(i);
          localObject2 = new StringBuilder().append(" update=");
          if (paramGetResourceRespV2.vecUpdatedResInfo == null) {
            break label319;
          }
          i = paramGetResourceRespV2.vecUpdatedResInfo.size();
          label191:
          ((StringBuffer)localObject1).append(i);
          localObject2 = new StringBuilder().append(" delete=");
          if (paramGetResourceRespV2.vecDeletedResInfo == null) {
            break label325;
          }
          i = paramGetResourceRespV2.vecDeletedResInfo.size();
          label238:
          ((StringBuffer)localObject1).append(i);
        }
      }
      else
      {
        QLog.d("EarlyDown", 2, ((StringBuffer)localObject1).toString());
        ((StringBuffer)localObject1).setLength(0);
        if ((!this.jdField_a_of_type_Boolean) && (paramInt == 512)) {
          ((StringBuffer)localObject1).append("set afterAppStart=true");
        }
        QLog.d("EarlyDown", 2, ((StringBuffer)localObject1).toString());
      }
    }
    else
    {
      if (paramInt == 512) {
        break label331;
      }
    }
    label319:
    label325:
    label331:
    do
    {
      do
      {
        return;
        i = 0;
        break;
        i = 0;
        break label191;
        i = 0;
        break label238;
        this.jdField_a_of_type_Boolean = true;
      } while ((!paramBoolean) || (paramGetResourceRespV2 == null));
      this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
    } while (this.jdField_a_of_type_AndroidOsHandler == null);
    Object localObject2 = Message.obtain();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new Message();
    }
    ((Message)localObject1).what = 131331;
    ((Message)localObject1).obj = paramGetResourceRespV2;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject1);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\earlydownload\EarlyDownloadManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */