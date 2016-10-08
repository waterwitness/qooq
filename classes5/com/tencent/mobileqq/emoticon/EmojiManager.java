package com.tencent.mobileqq.emoticon;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.EmoticonHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.magicface.drawable.PngFrameManager;
import com.tencent.mobileqq.magicface.drawable.PngFrameUtil;
import com.tencent.mobileqq.magicface.model.MagicfaceResLoader;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.IndividuationConfigInfo;
import com.tencent.mobileqq.vas.VasReportUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONObject;
import rjd;
import rje;
import rjf;
import rjg;
import rjh;

public class EmojiManager
  implements Manager
{
  public static int a = 0;
  public static long a = 0L;
  public static EmojiListenerManager a;
  public static boolean a = false;
  public static final int b = 4;
  public static final long b = 35000L;
  public static final String b = "h5magic_sp_name";
  public static final int c = 3;
  public static final String c = "h5magic_sp_isplay_key";
  public static final int d = 15000;
  public static final String d = "LAST_ADD_EMO_PACKAGE";
  public static int e = 1;
  public static final String e = "LAST_ADD_EMO_PACKAGE_MAGIC";
  public static int f = e + 1;
  public static final String f = "emoticonPackage";
  private static int g = 0;
  public static final String g = "magic_roaming";
  private static int h = 0;
  public static final String h = "vipEmoticonKey_";
  public static final String i = "newPkgAdd";
  public static final String j = "isUpdate";
  public static final String k = "jsonType";
  public static final String l = "isSmallEmotion";
  public static final String m = "jsonReqParams";
  private static final String n = "fileList";
  public QQAppInterface a;
  private PngFrameManager jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager;
  DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new rje(this, "param_WIFIEmojiStoreDownloadFlow", "param_XGEmojiStoreDownloadFlow");
  private LRULinkedHashMap jdField_a_of_type_ComTencentUtilLRULinkedHashMap = new LRULinkedHashMap(20);
  public String a;
  public HashMap a;
  Map jdField_a_of_type_JavaUtilMap = new HashMap();
  public DownloadListener b = new rjf(this, "param_WIFIEmojiStoreDownloadFlow", "param_XGEmojiStoreDownloadFlow");
  private DownloadListener c = new rjd(this, "param_WIFIEmojiStoreDownloadFlow", "param_XGEmojiStoreDownloadFlow");
  private int i = 3000000;
  private int j;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    h = 1;
  }
  
  public EmojiManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_JavaLangString = EmojiManager.class.getSimpleName();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager = ((PngFrameManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(82));
    jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager = EmojiListenerManager.a();
  }
  
  private int a(EmoticonPackage paramEmoticonPackage, ArrayList paramArrayList, List paramList, Map paramMap, Bundle paramBundle, int paramInt)
  {
    int i1 = 0;
    Emoticon localEmoticon;
    int i2;
    if (i1 < paramArrayList.size())
    {
      localEmoticon = (Emoticon)paramArrayList.get(i1);
      if ((paramInt & 0x2) == 2)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addEmoticonsTask| Emoticon download emo imgPreview.pid=" + localEmoticon.epId + " eid=" + localEmoticon.eId + " type=" + paramInt + " time:" + System.currentTimeMillis());
        }
        localObject = c(localEmoticon);
        if (!FileUtils.a(localObject[1]))
        {
          paramList.add(localObject[0]);
          paramMap.put(localObject[0], new File(localObject[1]));
          localObject = localObject[0];
          if (localEmoticon.jobType != 1) {
            break label349;
          }
          i2 = 15;
          label173:
          paramBundle.putInt((String)localObject, i2);
        }
      }
      if ((paramInt & 0x4) == 4)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addEmoticonsTask| Emoticon download emo gif.pid=" + localEmoticon.epId + " eid=" + localEmoticon.eId + " type=" + paramInt + " time:" + System.currentTimeMillis());
        }
        if (paramEmoticonPackage.jobType == 1) {
          break label832;
        }
        if (!localEmoticon.hasEncryptKey()) {}
      }
    }
    label349:
    label394:
    label452:
    label764:
    label823:
    label832:
    for (Object localObject = a(localEmoticon, paramEmoticonPackage.rscType);; localObject = null)
    {
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addEmoticonsTask| fail Emoticon download emo gif.pid=" + localEmoticon.epId + " eid=" + localEmoticon.eId);
        }
        return 11030;
        i2 = 6;
        break label173;
        return 11009;
      }
      boolean bool = false;
      if (paramEmoticonPackage.rscType == 1)
      {
        if (PngFrameUtil.a(EmoticonUtils.t.replace("[epId]", localEmoticon.epId))) {
          bool = true;
        }
        if (!bool)
        {
          paramList.add(localObject[0]);
          paramMap.put(localObject[0], new File(localObject[1]));
          if (paramEmoticonPackage.rscType != 1) {
            break label764;
          }
          paramBundle.putInt(localObject[0], 16);
        }
        if ((paramInt & 0x1) == 1)
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addEmoticonsTask| Emoticon download emo AIO preview static.pid=" + localEmoticon.epId + " eid=" + localEmoticon.eId + " type=" + paramInt);
          }
          localObject = b(localEmoticon);
          if (!FileUtils.a(localObject[1]))
          {
            paramList.add(localObject[0]);
            paramMap.put(localObject[0], new File(localObject[1]));
            localObject = localObject[0];
            if (localEmoticon.jobType != 1) {
              break label823;
            }
          }
        }
      }
      for (i2 = 15;; i2 = 8)
      {
        paramBundle.putInt((String)localObject, i2);
        if ((localEmoticon.isSound) && ((paramInt & 0x8) == 8))
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addEmoticonsTask| Emoticon download emo sound.pid=" + localEmoticon.epId + " eid=" + localEmoticon.eId + " type=" + paramInt);
          }
          localObject = a(localEmoticon);
          if (!FileUtils.a(localObject[1]))
          {
            paramList.add(localObject[0]);
            paramMap.put(localObject[0], new File(localObject[1]));
            paramBundle.putInt(localObject[0], 9);
          }
        }
        i1 += 1;
        break;
        bool = FileUtils.a(localObject[1]);
        break label394;
        if (paramEmoticonPackage.jobType == 1) {
          break label452;
        }
        paramBundle.putInt(localObject[0], 7);
        synchronized (this.jdField_a_of_type_JavaUtilMap)
        {
          this.jdField_a_of_type_JavaUtilMap.put(localObject[0], localEmoticon.encryptKey);
        }
      }
      return 0;
    }
  }
  
  private int a(EmoticonPackage paramEmoticonPackage, ArrayList paramArrayList, List paramList, Map paramMap, Bundle paramBundle, int paramInt, boolean paramBoolean)
  {
    int i2 = paramArrayList.size();
    int i1 = 0;
    while (i1 < i2)
    {
      Object localObject = (Emoticon)paramArrayList.get(i1);
      if ((paramInt & 0x2) == 2)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addEmoticonsTask| Emoticon download emo imgPreview.pid=" + ((Emoticon)localObject).epId + " eid=" + ((Emoticon)localObject).eId + " type=" + paramInt + " time:" + System.currentTimeMillis());
        }
        String[] arrayOfString = c((Emoticon)localObject);
        if ((!FileUtils.a(arrayOfString[1])) || (paramBoolean))
        {
          paramList.add(arrayOfString[0]);
          paramMap.put(arrayOfString[0], new File(arrayOfString[1]));
          paramBundle.putInt(arrayOfString[0], 6);
        }
      }
      if ((paramInt & 0x4) == 4)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addEmoticonsTask| Emoticon download emo gif.pid=" + ((Emoticon)localObject).epId + " eid=" + ((Emoticon)localObject).eId + " type=" + paramInt + " time:" + System.currentTimeMillis());
        }
        localObject = a((Emoticon)localObject, paramEmoticonPackage.rscType);
        if ((!FileUtils.a(localObject[1])) || (paramBoolean)) {
          paramList.add(localObject[0]);
        }
        paramMap.put(localObject[0], new File(localObject[1]));
        paramBundle.putInt(localObject[0], 7);
      }
      i1 += 1;
    }
    return 0;
  }
  
  private int a(File paramFile, EmoticonPackage paramEmoticonPackage, boolean paramBoolean, List paramList, Map paramMap, Bundle paramBundle, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    ReqInfo localReqInfo = new ReqInfo();
    File localFile = null;
    if (paramFile != null)
    {
      if (paramFile.exists())
      {
        paramFile = FileUtils.a(paramFile);
        localFile = paramFile;
      }
    }
    else {
      if (paramEmoticonPackage.jobType != 4) {
        break label120;
      }
    }
    label120:
    for (paramFile = EmotionJsonUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramEmoticonPackage, e, localFile, localArrayList);; paramFile = EmotionJsonUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramEmoticonPackage, e, localFile, localArrayList, localReqInfo))
    {
      if (paramFile == null) {
        break label141;
      }
      QLog.e(this.jdField_a_of_type_JavaLangString, 1, "addEmotionsTask| parse json error");
      VasReportUtils.a("emotionType", "emotionActionDownload", "4", paramEmoticonPackage.epId, "", "", paramFile, "", "", "");
      return 11008;
      paramFile = null;
      break;
    }
    label141:
    if ((!TextUtils.isEmpty(paramEmoticonPackage.minQQVersion)) && (!IndividuationConfigInfo.a(paramEmoticonPackage.minQQVersion, "6.5.5")))
    {
      QLog.e(this.jdField_a_of_type_JavaLangString, 1, "unavailable in current version, min version=" + paramEmoticonPackage.minQQVersion);
      return 11011;
    }
    paramBundle.putBoolean("isUpdate", paramBoolean);
    paramBundle.putSerializable("emoticonList", localArrayList);
    if ((!localReqInfo.jdField_a_of_type_Boolean) && (paramEmoticonPackage.jobType != 4))
    {
      int i1 = 0;
      int i2;
      do
      {
        localReqInfo.jdField_a_of_type_JavaLangString = null;
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addEmoticonsTask| fetchEncryptKeys count=" + i1);
        }
        a(paramEmoticonPackage.epId, localArrayList, localReqInfo);
        i2 = i1 + 1;
        if (localReqInfo.jdField_a_of_type_Boolean) {
          break;
        }
        i1 = i2;
      } while (i2 < 3);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addEmoticonsTask| fetchEncryptKeys count=" + i2 + " encryptKeysSuccess=" + localReqInfo.jdField_a_of_type_Boolean);
      }
      if (!localReqInfo.jdField_a_of_type_Boolean)
      {
        QLog.e(this.jdField_a_of_type_JavaLangString, 1, "addEmoticonsTask| fetchEncryptKeys fail epId=" + paramEmoticonPackage.epId + " encryptGetKeySeq=" + localReqInfo.jdField_a_of_type_JavaLangString + " encryptKeysResultCode" + localReqInfo.jdField_a_of_type_Int);
        return 11009;
      }
    }
    if (paramEmoticonPackage.jobType == 4) {
      return a(paramEmoticonPackage, localArrayList, paramList, paramMap, paramBundle, paramInt, paramBoolean);
    }
    return a(paramEmoticonPackage, localArrayList, paramList, paramMap, paramBundle, paramInt);
  }
  
  private Bundle a(String paramString, int paramInt)
  {
    int i2 = -1;
    int i1 = 0;
    int i3 = 0;
    int i7 = 0;
    Object localObject = a().b(paramString);
    int i9;
    int i6;
    int i5;
    int i4;
    label196:
    int i8;
    if (localObject != null)
    {
      if (((EmoticonPackage)localObject).valid) {
        i1 = 1;
      }
    }
    else
    {
      i9 = i1;
      if (paramInt == 2) {
        i9 = 1;
      }
      DownloadTask localDownloadTask = a().a("vipEmoticonKey_" + paramString);
      i6 = i7;
      i5 = i3;
      i4 = i2;
      if (localDownloadTask != null)
      {
        i6 = i7;
        i5 = i3;
        i4 = i2;
        if (!localDownloadTask.b())
        {
          i4 = 0;
          i6 = (int)localDownloadTask.jdField_a_of_type_Float;
          i5 = 2;
        }
      }
      if (i4 != -1) {
        break label728;
      }
      i1 = i6;
      i2 = i5;
      i3 = i4;
      switch (paramInt)
      {
      default: 
        i3 = i4;
        i2 = i5;
        i1 = i6;
      case 2: 
        i8 = i1;
        i7 = i2;
        paramInt = i3;
        if (QLog.isColorLevel())
        {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "getPackageStatus| query result in DB or not DB, epId:" + paramString + ",result=" + i3 + " status=" + i2 + " progress=" + i1);
          paramInt = i3;
          i7 = i2;
          i8 = i1;
        }
        break;
      }
    }
    for (;;)
    {
      i1 = paramInt;
      if (paramInt == -1)
      {
        i1 = 0;
        i7 = 0;
        i8 = 0;
      }
      localObject = new Bundle();
      ((Bundle)localObject).putString("id", paramString);
      ((Bundle)localObject).putInt("result", i1);
      ((Bundle)localObject).putInt("status", i7);
      ((Bundle)localObject).putInt("pluginStatus", 0);
      ((Bundle)localObject).putLong("pluginSize", 0L);
      ((Bundle)localObject).putInt("progress", i8);
      ((Bundle)localObject).putInt("dEmojiId", -1);
      ((Bundle)localObject).putInt("flag", i9);
      ((Bundle)localObject).putStringArrayList("srcList", null);
      ((Bundle)localObject).putStringArrayList("urlParamsList", null);
      return (Bundle)localObject;
      i1 = 0;
      break;
      i1 = i6;
      i2 = i5;
      i3 = i4;
      if (localObject == null) {
        break label196;
      }
      i1 = i6;
      i2 = i5;
      i3 = i4;
      if (((EmoticonPackage)localObject).status != 2) {
        break label196;
      }
      if (b(paramString))
      {
        if (EmoticonUtils.a(((EmoticonPackage)localObject).updateFlag))
        {
          i3 = 0;
          i2 = 4;
          i1 = 0;
          break label196;
        }
        i3 = 0;
        i1 = 100;
        i2 = 3;
        break label196;
      }
      i3 = 0;
      i2 = 0;
      i1 = 0;
      break label196;
      i1 = i6;
      i2 = i5;
      i3 = i4;
      if (localObject == null) {
        break label196;
      }
      i1 = i6;
      i2 = i5;
      i3 = i4;
      if (((EmoticonPackage)localObject).status != 2) {
        break label196;
      }
      if (c(paramString))
      {
        if (EmoticonUtils.a(((EmoticonPackage)localObject).updateFlag))
        {
          i3 = 0;
          i2 = 4;
          i1 = 0;
          break label196;
        }
        i3 = 0;
        i1 = 100;
        i2 = 3;
        break label196;
      }
      i3 = 0;
      i2 = 0;
      i1 = 0;
      break label196;
      i1 = i6;
      i2 = i5;
      i3 = i4;
      if (localObject == null) {
        break label196;
      }
      i1 = i6;
      i2 = i5;
      i3 = i4;
      if (((EmoticonPackage)localObject).status != 2) {
        break label196;
      }
      if (a(paramString, Boolean.valueOf(true)))
      {
        i3 = 0;
        i1 = 100;
        i2 = 3;
        break label196;
      }
      i3 = 0;
      i2 = 0;
      i1 = 0;
      break label196;
      i1 = i6;
      i2 = i5;
      i3 = i4;
      if (localObject == null) {
        break label196;
      }
      i1 = i6;
      i2 = i5;
      i3 = i4;
      if (((EmoticonPackage)localObject).status != 2) {
        break label196;
      }
      if (b(paramString, true, true))
      {
        i3 = 0;
        i1 = 100;
        i2 = 3;
        break label196;
      }
      i3 = 0;
      i2 = 0;
      i1 = 0;
      break label196;
      label728:
      i8 = i6;
      i7 = i5;
      paramInt = i4;
      if (QLog.isColorLevel())
      {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "getPackageStatus| query result in running... result=" + i4 + " status=" + i5 + " progress=" + i6);
        i8 = i6;
        i7 = i5;
        paramInt = i4;
      }
    }
  }
  
  private DownloaderInterface a()
  {
    return ((DownloaderFactory)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46)).a(1);
  }
  
  public static void a(int paramInt)
  {
    if (paramInt <= 0) {}
    String str;
    do
    {
      return;
      str = "";
      StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
      int i1 = Math.min(paramInt, arrayOfStackTraceElement.length);
      paramInt = 2;
      while (paramInt < i1)
      {
        Object localObject = arrayOfStackTraceElement[paramInt];
        localObject = ((StackTraceElement)localObject).getClassName() + "." + ((StackTraceElement)localObject).getMethodName();
        str = str + " " + (String)localObject;
        paramInt += 1;
      }
    } while (!QLog.isDevelopLevel());
    QLog.d("Q.emoji.EmoDown", 4, "epId illegal,stacktrace:" + str);
  }
  
  /* Error */
  private void a(DownloadTask paramDownloadTask)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_1
    //   6: invokevirtual 520	com/tencent/mobileqq/vip/DownloadTask:a	()Landroid/os/Bundle;
    //   9: ldc 35
    //   11: invokevirtual 524	android/os/Bundle:getSerializable	(Ljava/lang/String;)Ljava/io/Serializable;
    //   14: checkcast 244	com/tencent/mobileqq/data/EmoticonPackage
    //   17: astore 5
    //   19: aload_1
    //   20: getfield 525	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   23: aload_1
    //   24: getfield 527	com/tencent/mobileqq/vip/DownloadTask:c	Ljava/lang/String;
    //   27: invokeinterface 530 2 0
    //   32: checkcast 222	java/io/File
    //   35: astore 6
    //   37: aload_0
    //   38: getfield 98	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   41: aload_1
    //   42: getfield 527	com/tencent/mobileqq/vip/DownloadTask:c	Ljava/lang/String;
    //   45: invokeinterface 533 2 0
    //   50: ifeq +600 -> 650
    //   53: aload_0
    //   54: getfield 98	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   57: astore_3
    //   58: aload_3
    //   59: monitorenter
    //   60: aload_0
    //   61: getfield 98	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   64: aload_1
    //   65: getfield 527	com/tencent/mobileqq/vip/DownloadTask:c	Ljava/lang/String;
    //   68: invokeinterface 530 2 0
    //   73: checkcast 265	java/lang/String
    //   76: astore_2
    //   77: aload_0
    //   78: getfield 98	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   81: aload_1
    //   82: getfield 527	com/tencent/mobileqq/vip/DownloadTask:c	Ljava/lang/String;
    //   85: invokeinterface 536 2 0
    //   90: pop
    //   91: aload_3
    //   92: monitorexit
    //   93: aload 6
    //   95: ifnull +547 -> 642
    //   98: aload 6
    //   100: invokestatic 298	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/io/File;)[B
    //   103: astore 4
    //   105: aload 6
    //   107: invokevirtual 539	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   110: astore_3
    //   111: aload 6
    //   113: invokevirtual 542	java/io/File:delete	()Z
    //   116: pop
    //   117: goto +538 -> 655
    //   120: aload_1
    //   121: iconst_1
    //   122: putfield 543	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Boolean	Z
    //   125: aload_0
    //   126: getfield 93	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   129: iconst_1
    //   130: ldc_w 545
    //   133: invokestatic 307	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   136: getstatic 148	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager	Lcom/tencent/mobileqq/emoticon/EmojiListenerManager;
    //   139: aload 5
    //   141: sipush 11013
    //   144: aload_0
    //   145: getfield 85	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   148: invokevirtual 548	com/tencent/mobileqq/emoticon/EmojiListenerManager:a	(Lcom/tencent/mobileqq/data/EmoticonPackage;ILcom/tencent/mobileqq/app/QQAppInterface;)V
    //   151: ldc_w 309
    //   154: ldc_w 311
    //   157: ldc_w 550
    //   160: aload 5
    //   162: getfield 314	com/tencent/mobileqq/data/EmoticonPackage:epId	Ljava/lang/String;
    //   165: ldc_w 316
    //   168: ldc_w 316
    //   171: ldc_w 316
    //   174: ldc_w 316
    //   177: ldc_w 316
    //   180: ldc_w 316
    //   183: invokestatic 321	com/tencent/mobileqq/vas/VasReportUtils:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   186: return
    //   187: astore_2
    //   188: aload_2
    //   189: invokevirtual 553	java/lang/Throwable:printStackTrace	()V
    //   192: aload_0
    //   193: getfield 93	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   196: iconst_2
    //   197: new 169	java/lang/StringBuilder
    //   200: dup
    //   201: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   204: ldc_w 555
    //   207: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: aload_2
    //   211: invokevirtual 556	java/lang/Throwable:toString	()Ljava/lang/String;
    //   214: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: ldc -65
    //   219: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: invokestatic 197	java/lang/System:currentTimeMillis	()J
    //   225: invokevirtual 200	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   228: ldc_w 558
    //   231: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: aload_1
    //   235: getfield 527	com/tencent/mobileqq/vip/DownloadTask:c	Ljava/lang/String;
    //   238: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: invokestatic 307	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   247: aload_1
    //   248: iconst_1
    //   249: putfield 543	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Boolean	Z
    //   252: getstatic 148	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager	Lcom/tencent/mobileqq/emoticon/EmojiListenerManager;
    //   255: aload 5
    //   257: sipush 11020
    //   260: aload_0
    //   261: getfield 85	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   264: invokevirtual 548	com/tencent/mobileqq/emoticon/EmojiListenerManager:a	(Lcom/tencent/mobileqq/data/EmoticonPackage;ILcom/tencent/mobileqq/app/QQAppInterface;)V
    //   267: ldc_w 309
    //   270: ldc_w 311
    //   273: ldc_w 560
    //   276: aload 5
    //   278: getfield 314	com/tencent/mobileqq/data/EmoticonPackage:epId	Ljava/lang/String;
    //   281: ldc_w 316
    //   284: ldc_w 316
    //   287: ldc_w 316
    //   290: ldc_w 316
    //   293: ldc_w 316
    //   296: ldc_w 316
    //   299: invokestatic 321	com/tencent/mobileqq/vas/VasReportUtils:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   302: return
    //   303: astore_2
    //   304: aload_3
    //   305: monitorexit
    //   306: aload_2
    //   307: athrow
    //   308: aload 5
    //   310: getfield 245	com/tencent/mobileqq/data/EmoticonPackage:jobType	I
    //   313: iconst_4
    //   314: if_icmpeq +74 -> 388
    //   317: aload_2
    //   318: ifnonnull +70 -> 388
    //   321: aload_1
    //   322: iconst_1
    //   323: putfield 543	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Boolean	Z
    //   326: aload_0
    //   327: getfield 93	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   330: iconst_1
    //   331: ldc_w 562
    //   334: invokestatic 307	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   337: getstatic 148	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager	Lcom/tencent/mobileqq/emoticon/EmojiListenerManager;
    //   340: aload 5
    //   342: sipush 11009
    //   345: aload_0
    //   346: getfield 85	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   349: invokevirtual 548	com/tencent/mobileqq/emoticon/EmojiListenerManager:a	(Lcom/tencent/mobileqq/data/EmoticonPackage;ILcom/tencent/mobileqq/app/QQAppInterface;)V
    //   352: ldc_w 309
    //   355: ldc_w 311
    //   358: ldc_w 564
    //   361: aload 5
    //   363: getfield 314	com/tencent/mobileqq/data/EmoticonPackage:epId	Ljava/lang/String;
    //   366: ldc_w 316
    //   369: ldc_w 316
    //   372: ldc_w 316
    //   375: ldc_w 316
    //   378: ldc_w 316
    //   381: ldc_w 316
    //   384: invokestatic 321	com/tencent/mobileqq/vas/VasReportUtils:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   387: return
    //   388: aload 5
    //   390: getfield 245	com/tencent/mobileqq/data/EmoticonPackage:jobType	I
    //   393: iconst_4
    //   394: if_icmpne +236 -> 630
    //   397: aload 4
    //   399: aload_3
    //   400: invokestatic 569	com/tencent/mobileqq/emosm/EmosmUtils:a	([BLjava/lang/String;)I
    //   403: istore 7
    //   405: iload 7
    //   407: ifeq +163 -> 570
    //   410: aload_0
    //   411: getfield 93	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   414: iconst_2
    //   415: new 169	java/lang/StringBuilder
    //   418: dup
    //   419: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   422: ldc_w 571
    //   425: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: aload_1
    //   429: getfield 527	com/tencent/mobileqq/vip/DownloadTask:c	Ljava/lang/String;
    //   432: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   438: invokestatic 307	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   441: ldc_w 309
    //   444: ldc_w 311
    //   447: ldc_w 573
    //   450: aload 5
    //   452: getfield 314	com/tencent/mobileqq/data/EmoticonPackage:epId	Ljava/lang/String;
    //   455: ldc_w 316
    //   458: ldc_w 316
    //   461: new 169	java/lang/StringBuilder
    //   464: dup
    //   465: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   468: iload 7
    //   470: invokevirtual 189	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   473: ldc_w 316
    //   476: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   482: ldc_w 316
    //   485: ldc_w 316
    //   488: ldc_w 316
    //   491: invokestatic 321	com/tencent/mobileqq/vas/VasReportUtils:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   494: invokestatic 576	com/tencent/mobileqq/util/Utils:b	()Z
    //   497: ifeq +73 -> 570
    //   500: invokestatic 578	com/tencent/mobileqq/util/Utils:b	()J
    //   503: ldc2_w 579
    //   506: lcmp
    //   507: ifle +63 -> 570
    //   510: new 169	java/lang/StringBuilder
    //   513: dup
    //   514: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   517: getstatic 585	com/tencent/mobileqq/app/AppConstants:bj	Ljava/lang/String;
    //   520: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: ldc_w 587
    //   526: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: getstatic 590	java/io/File:separator	Ljava/lang/String;
    //   532: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   535: aload 5
    //   537: getfield 314	com/tencent/mobileqq/data/EmoticonPackage:epId	Ljava/lang/String;
    //   540: invokestatic 593	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   543: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: ldc_w 595
    //   549: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: aload 6
    //   554: invokevirtual 598	java/io/File:getName	()Ljava/lang/String;
    //   557: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   560: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   563: aload 4
    //   565: iconst_0
    //   566: invokestatic 601	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;[BZ)Z
    //   569: pop
    //   570: invokestatic 167	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   573: ifeq -569 -> 4
    //   576: aload_0
    //   577: getfield 93	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   580: iconst_2
    //   581: new 169	java/lang/StringBuilder
    //   584: dup
    //   585: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   588: ldc_w 603
    //   591: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   594: iload 7
    //   596: invokevirtual 189	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   599: ldc -65
    //   601: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   604: invokestatic 197	java/lang/System:currentTimeMillis	()J
    //   607: invokevirtual 200	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   610: ldc_w 558
    //   613: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   616: aload_1
    //   617: getfield 527	com/tencent/mobileqq/vip/DownloadTask:c	Ljava/lang/String;
    //   620: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   623: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   626: invokestatic 206	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   629: return
    //   630: aload 4
    //   632: aload_2
    //   633: aload_3
    //   634: invokestatic 606	com/tencent/mobileqq/emosm/EmosmUtils:a	([BLjava/lang/String;Ljava/lang/String;)I
    //   637: istore 7
    //   639: goto -234 -> 405
    //   642: aconst_null
    //   643: astore_3
    //   644: aconst_null
    //   645: astore 4
    //   647: goto +8 -> 655
    //   650: aconst_null
    //   651: astore_2
    //   652: goto -559 -> 93
    //   655: aload 4
    //   657: ifnull -537 -> 120
    //   660: aload_3
    //   661: ifnonnull -353 -> 308
    //   664: goto -544 -> 120
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	667	0	this	EmojiManager
    //   0	667	1	paramDownloadTask	DownloadTask
    //   76	1	2	str1	String
    //   187	24	2	localThrowable	Throwable
    //   303	330	2	str2	String
    //   651	1	2	localObject1	Object
    //   103	553	4	arrayOfByte	byte[]
    //   17	519	5	localEmoticonPackage	EmoticonPackage
    //   35	518	6	localFile	File
    //   403	235	7	i1	int
    // Exception table:
    //   from	to	target	type
    //   37	60	187	java/lang/Throwable
    //   98	117	187	java/lang/Throwable
    //   120	186	187	java/lang/Throwable
    //   306	308	187	java/lang/Throwable
    //   308	317	187	java/lang/Throwable
    //   321	387	187	java/lang/Throwable
    //   388	405	187	java/lang/Throwable
    //   410	570	187	java/lang/Throwable
    //   570	629	187	java/lang/Throwable
    //   630	639	187	java/lang/Throwable
    //   60	93	303	finally
    //   304	306	303	finally
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    paramString = a().a(paramString);
    if (paramString != null)
    {
      if (!paramBoolean) {
        break label39;
      }
      if (paramString.status != 2)
      {
        paramString.status = 2;
        a().a(paramString);
      }
    }
    label39:
    while (paramString.status == 0) {
      return;
    }
    paramString.status = 0;
    a().a(paramString);
  }
  
  private void a(List paramList, Map paramMap, EmoticonPackage paramEmoticonPackage, Bundle paramBundle)
  {
    String str1 = paramEmoticonPackage.epId;
    int i2;
    int i1;
    if (paramEmoticonPackage.jobType == 2)
    {
      str1 = paramEmoticonPackage.kinId;
      i2 = 13;
      i1 = 14;
    }
    for (;;)
    {
      String str2 = EmosmUtils.b(i2, str1);
      String str3 = EmosmUtils.a(3, paramEmoticonPackage.epId);
      if (!FileUtils.a(str3))
      {
        paramList.add(str2);
        paramMap.put(str2, new File(str3));
        paramBundle.putInt(str2, 3);
      }
      str1 = EmosmUtils.b(i1, str1);
      paramEmoticonPackage = EmosmUtils.a(4, paramEmoticonPackage.epId);
      if (!FileUtils.a(paramEmoticonPackage))
      {
        paramList.add(str1);
        paramMap.put(str1, new File(paramEmoticonPackage));
        paramBundle.putInt(str1, 4);
      }
      return;
      if (paramEmoticonPackage.jobType == 4)
      {
        str1 = paramEmoticonPackage.epId;
        i2 = 17;
        i1 = 18;
      }
      else
      {
        i2 = 3;
        i1 = 4;
      }
    }
  }
  
  private boolean a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localObject1 = (ArrayList)a().a(paramString);
      if (localObject1 != null)
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localObject1 = (Emoticon)((Iterator)localObject1).next();
          if (localObject1 == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkH5MagicFacePackageIntact, one of encrypts is null!" + paramString);
            }
            return false;
          }
          if ((((Emoticon)localObject1).jobType == 4) && ((((Emoticon)localObject1).encryptKey == null) || (((Emoticon)localObject1).encryptKey.length() == 0)))
          {
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkH5MagicFacePackageIntact, encrypt isn't exist.epId=" + paramString + " eId=" + ((Emoticon)localObject1).eId);
            }
            return false;
          }
          if (!new File(EmoticonUtils.l.replace("[epId]", paramString).replace("[eId]", ((Emoticon)localObject1).eId)).exists())
          {
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkH5MagicFacePackageIntact, emo img preview do not be exist! epId=" + paramString + " eId=" + ((Emoticon)localObject1).eId);
            }
            return false;
          }
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkH5MagicFacePackageIntact, emoticons do not be exist.epId=" + paramString);
        }
        return false;
      }
    }
    Object localObject1 = new File(EmoticonUtils.p.replace("[epId]", paramString));
    if ((localObject1 != null) && (!((File)localObject1).exists()))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkH5MagicFacePackageIntact, no root path: " + localObject1);
      }
      return false;
    }
    for (;;)
    {
      int i1;
      try
      {
        if (this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.containsKey(paramString))
        {
          paramString = (ArrayList)this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get(paramString);
          if (paramString != null)
          {
            paramString = paramString.iterator();
            if (paramString.hasNext())
            {
              localObject1 = new File((String)paramString.next());
              if ((localObject1 == null) || (((File)localObject1).exists())) {
                continue;
              }
              if (!QLog.isColorLevel()) {
                break label605;
              }
              QLog.e(this.jdField_a_of_type_JavaLangString, 2, "checkH5MagicFacePackageIntact, file miss: " + localObject1);
              break label605;
            }
          }
        }
        else
        {
          localObject1 = new File(EmoticonUtils.r.replace("[epId]", paramString));
          if (!((File)localObject1).exists()) {
            return false;
          }
          Object localObject2 = new JSONObject(FileUtils.b((File)localObject1));
          localObject1 = new ArrayList();
          localObject2 = ((JSONObject)localObject2).getJSONArray("fileList");
          int i2 = ((JSONArray)localObject2).length();
          i1 = 0;
          if (i1 < i2)
          {
            String str = ((JSONArray)localObject2).getString(i1);
            if (TextUtils.isEmpty(str)) {
              break label607;
            }
            ((ArrayList)localObject1).add(str);
            break label607;
          }
          this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put(paramString, localObject1);
          paramString = (String)localObject1;
          continue;
        }
        return true;
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e(this.jdField_a_of_type_JavaLangString, 2, "checkH5MagicFacePackageIntact, error=" + MsfSdkUtils.getStackTraceString(paramString));
        }
        return false;
      }
      label605:
      return false;
      label607:
      i1 += 1;
    }
  }
  
  private String[] a(Emoticon paramEmoticon)
  {
    return new String[] { EmoticonUtils.d.replace("[eIdSub]", paramEmoticon.eId.substring(0, 2)).replace("[eId]", paramEmoticon.eId), EmoticonUtils.k.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId) };
  }
  
  private String[] a(Emoticon paramEmoticon, int paramInt)
  {
    if (paramEmoticon.jobType == 3) {}
    boolean bool;
    for (String str1 = EmoticonUtils.jdField_a_of_type_JavaLangString.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId);; str1 = EmoticonUtils.e.replace("[eIdSub]", paramEmoticon.eId.substring(0, 2)).replace("[eId]", paramEmoticon.eId))
    {
      str2 = EmoticonUtils.o.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId);
      paramEmoticon = str2;
      if (1 == paramInt)
      {
        paramEmoticon = str2;
        if (!TextUtils.isEmpty(str2)) {
          paramEmoticon = str2 + ".zip";
        }
      }
      return new String[] { str1, paramEmoticon };
      bool = a(paramEmoticon);
      if (1 != paramInt) {
        break;
      }
    }
    String str2 = EmoticonUtils.g.replace("[eIdSub]", paramEmoticon.eId.substring(0, 2)).replace("[eId]", paramEmoticon.eId);
    if (bool)
    {
      str1 = String.valueOf(paramEmoticon.extensionWidth);
      label198:
      str2 = str2.replace("[width]", str1);
      if (!bool) {
        break label242;
      }
    }
    label242:
    for (str1 = String.valueOf(paramEmoticon.extensionHeight);; str1 = "200")
    {
      str1 = str2.replace("[height]", str1);
      break;
      str1 = "200";
      break label198;
    }
  }
  
  private void b(EmoticonPackage paramEmoticonPackage, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramEmoticonPackage.childEpId)) || ("0".equals(paramEmoticonPackage.childEpId)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handleEmotionPackage| handle h5magic chiled emotion and childEpId = " + paramEmoticonPackage.childEpId);
    }
    if (paramBoolean)
    {
      localObject = (EmoticonHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12);
      if (localObject != null) {
        ((EmoticonHandler)localObject).a(paramEmoticonPackage.childEpId);
      }
    }
    EmoticonPackage localEmoticonPackage = a().b(paramEmoticonPackage.childEpId);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handleEmotionPackage| old childEp = " + localEmoticonPackage);
    }
    Object localObject = localEmoticonPackage;
    if (localEmoticonPackage == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handleEmotionPackage| childEpId = " + paramEmoticonPackage.childEpId);
      }
      localObject = new EmoticonPackage();
      ((EmoticonPackage)localObject).epId = paramEmoticonPackage.childEpId;
      ((EmoticonPackage)localObject).wordingId = -1L;
      ((EmoticonPackage)localObject).jobType = 5;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handleEmotionPackage| auto download childEp = " + localObject);
    }
    a((EmoticonPackage)localObject, paramBoolean);
  }
  
  private void b(DownloadTask paramDownloadTask)
  {
    if (paramDownloadTask == null) {
      return;
    }
    Object localObject1 = paramDownloadTask.a();
    int i1 = ((Bundle)localObject1).getInt(paramDownloadTask.c);
    EmoticonPackage localEmoticonPackage = (EmoticonPackage)((Bundle)localObject1).getSerializable("emoticonPackage");
    localObject1 = (File)paramDownloadTask.jdField_a_of_type_JavaUtilMap.get(paramDownloadTask.c);
    switch (i1)
    {
    default: 
      return;
    case 2: 
      jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a(localEmoticonPackage, 2, 0, 0);
      return;
    case 21: 
      try
      {
        FileUtils.a(((File)localObject1).getAbsolutePath(), EmoticonUtils.j.replace("[epId]", localEmoticonPackage.epId), false);
        ((File)localObject1).delete();
        return;
      }
      catch (IOException localIOException1)
      {
        for (;;)
        {
          paramDownloadTask.jdField_a_of_type_Boolean = true;
          localIOException1.printStackTrace();
        }
      }
    case 16: 
      try
      {
        FileUtils.a(((File)localObject1).getAbsolutePath(), EmoticonUtils.t.replace("[epId]", localIOException1.epId), false);
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager.b(localIOException1.epId);
        ((File)localObject1).delete();
        return;
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          paramDownloadTask.jdField_a_of_type_Boolean = true;
          localIOException2.printStackTrace();
        }
      }
    }
    Object localObject2;
    Object localObject3;
    try
    {
      localObject2 = EmoticonUtils.p.replace("[epId]", localIOException2.epId);
      FileUtils.a(((File)localObject1).getAbsolutePath(), (String)localObject2, false);
      localObject3 = FileUtils.a((String)localObject2);
      if ((localObject3 != null) && (((ArrayList)localObject3).size() > 0))
      {
        if (this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap != null) {
          this.jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put(localIOException2.epId, localObject3);
        }
        localObject2 = new JSONArray();
        localObject3 = ((ArrayList)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          String str = (String)((Iterator)localObject3).next();
          if (!TextUtils.isEmpty(str))
          {
            ((JSONArray)localObject2).put(str);
            continue;
            ((File)localObject1).delete();
          }
        }
      }
    }
    catch (Exception localException)
    {
      paramDownloadTask.jdField_a_of_type_Boolean = true;
      QLog.e(this.jdField_a_of_type_JavaLangString, 1, "emotionDownloadListener | onDoneFile STEP_H5_MAGIC_ZIP exception:" + MsfSdkUtils.getStackTraceString(localException));
    }
    for (;;)
    {
      return;
      localObject3 = new JSONObject();
      ((JSONObject)localObject3).put("fileList", localObject2);
      FileUtils.a(EmoticonUtils.r.replace("[epId]", localException.epId), ((JSONObject)localObject3).toString());
      continue;
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_a_of_type_JavaLangString, 2, "emotionDownloadListener | onDoneFile h5 magic, childFiles is null");
      }
    }
  }
  
  private void b(List paramList, Map paramMap, EmoticonPackage paramEmoticonPackage, Bundle paramBundle)
  {
    if (paramEmoticonPackage.jobType == 4) {}
    for (int i1 = 19;; i1 = 2)
    {
      if (paramEmoticonPackage.jobType == 2) {}
      for (String str = paramEmoticonPackage.kinId;; str = paramEmoticonPackage.epId)
      {
        str = EmosmUtils.b(i1, str);
        paramEmoticonPackage = EmosmUtils.a(2, paramEmoticonPackage.epId);
        if (!FileUtils.a(paramEmoticonPackage))
        {
          paramList.add(str);
          paramMap.put(str, new File(paramEmoticonPackage));
          paramBundle.putInt(str, 2);
        }
        return;
      }
    }
  }
  
  private boolean b(String paramString, Boolean paramBoolean)
  {
    if (paramString == null) {
      return false;
    }
    if (paramBoolean.booleanValue())
    {
      paramBoolean = (ArrayList)a().a(paramString);
      if (paramBoolean != null)
      {
        paramBoolean = paramBoolean.iterator();
        if (paramBoolean.hasNext())
        {
          paramBoolean = (Emoticon)paramBoolean.next();
          if (paramBoolean == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_a_of_type_JavaLangString, 2, "one of encrypts is null!" + paramString);
            }
            return false;
          }
          if ((paramBoolean.jobType == 2) && ((paramBoolean.encryptKey == null) || (paramBoolean.encryptKey.length() == 0)))
          {
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_a_of_type_JavaLangString, 2, "encrypt isn't exist.epId=" + paramString + " eId=" + paramBoolean.eId);
            }
            return false;
          }
          if (!new File(EmoticonUtils.l.replace("[epId]", paramString).replace("[eId]", paramBoolean.eId)).exists())
          {
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_a_of_type_JavaLangString, 2, "emo img preview do not be exist! epId=" + paramString + " eId=" + paramBoolean.eId);
            }
            return false;
          }
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "emoticons do not be exist.epId=" + paramString);
        }
        return false;
      }
    }
    String str1 = MagicfaceResLoader.a();
    String str3 = EmoticonUtils.j.replace("[epId]", paramString);
    String str2 = str3 + str1 + File.separator + "video.ini";
    File localFile = new File(str2);
    paramBoolean = localFile;
    if (!localFile.exists())
    {
      str1 = "big";
      str2 = str3 + "big" + File.separator + "video.ini";
      localFile = new File(str2);
      paramBoolean = localFile;
      if (!localFile.exists()) {
        return false;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_a_of_type_JavaLangString, 2, "videoConfigPath ==" + str2);
    }
    paramBoolean = FileUtils.a(paramBoolean);
    int i2;
    if (paramBoolean != null)
    {
      paramBoolean = paramBoolean.split("&");
      i2 = paramBoolean.length;
      i1 = 0;
      while (i1 < i2)
      {
        str2 = paramBoolean[i1];
        if (!new File(str3 + str1 + File.separator + str2).exists()) {
          return false;
        }
        i1 += 1;
      }
    }
    paramBoolean = new File(str3 + "audio" + File.separator + "audio.ini");
    if (!paramBoolean.exists()) {
      return false;
    }
    paramBoolean = FileUtils.a(paramBoolean);
    if (paramBoolean != null)
    {
      paramBoolean = paramBoolean.split("&");
      i2 = paramBoolean.length;
      i1 = 0;
      while (i1 < i2)
      {
        str1 = paramBoolean[i1];
        if (!new File(str3 + "audio" + File.separator + str1).exists()) {
          return false;
        }
        i1 += 1;
      }
    }
    if (!a(paramString, h)) {
      return false;
    }
    paramBoolean = a().a(paramString);
    if (paramBoolean != null) {}
    for (int i1 = paramBoolean.rscType;; i1 = 0)
    {
      if (1 == i1) {
        return PngFrameUtil.a(EmoticonUtils.t.replace("[epId]", paramString));
      }
      paramBoolean = (ArrayList)a().a(paramString);
      if ((paramBoolean != null) && (paramBoolean.size() > 0) && (!new File(EmoticonUtils.o.replace("[epId]", paramString).replace("[eId]", ((Emoticon)paramBoolean.get(0)).eId)).exists()))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "emo img encrypt file do not be exist! epId=" + paramString + " eId=" + ((Emoticon)paramBoolean.get(0)).eId);
        }
        return false;
      }
      return true;
    }
  }
  
  private String[] b(Emoticon paramEmoticon)
  {
    Object localObject = null;
    String str;
    if (paramEmoticon.jobType != 1)
    {
      boolean bool = a(paramEmoticon);
      str = EmoticonUtils.h.replace("[eIdSub]", paramEmoticon.eId.substring(0, 2)).replace("[eId]", paramEmoticon.eId);
      if (bool)
      {
        localObject = String.valueOf(paramEmoticon.extensionWidth);
        str = str.replace("[width]", (CharSequence)localObject);
        if (!bool) {
          break label134;
        }
        localObject = String.valueOf(paramEmoticon.extensionHeight);
        label81:
        localObject = str.replace("[height]", (CharSequence)localObject);
        paramEmoticon = EmoticonUtils.m.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId);
      }
    }
    for (;;)
    {
      return new String[] { localObject, paramEmoticon };
      localObject = "200";
      break;
      label134:
      localObject = "200";
      break label81;
      str = null;
      paramEmoticon = (Emoticon)localObject;
      localObject = str;
    }
  }
  
  private void c(DownloadTask paramDownloadTask)
  {
    long l1 = paramDownloadTask.jdField_h_of_type_Long;
    long l2 = paramDownloadTask.g;
    Object localObject = paramDownloadTask.a();
    int i2 = ((Bundle)localObject).getInt(paramDownloadTask.c);
    boolean bool1 = ((Bundle)localObject).getBoolean("newPkgAdd", false);
    boolean bool2 = ((Bundle)localObject).getBoolean("isUpdate", false);
    EmoticonPackage localEmoticonPackage = (EmoticonPackage)((Bundle)localObject).getSerializable("emoticonPackage");
    if (localEmoticonPackage == null) {
      return;
    }
    if ((localEmoticonPackage.jobType == 3) || (localEmoticonPackage.jobType == 5)) {}
    for (int i1 = 1;; i1 = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onDone:epId=" + localEmoticonPackage.epId + " task:" + paramDownloadTask + " localVersion=" + localEmoticonPackage.localVersion + ",latestVersion=" + localEmoticonPackage.latestVersion + ",updateFlag=" + localEmoticonPackage.updateFlag);
      }
      if (paramDownloadTask.a() == 3) {
        break;
      }
      i1 = EmosmUtils.a(paramDownloadTask.z);
      QLog.e(this.jdField_a_of_type_JavaLangString, 1, "handleEmoticonPackageDownloaded : download error ,reportCode = " + paramDownloadTask.z);
      QLog.e(this.jdField_a_of_type_JavaLangString, 1, "commonOnDone : downloa error ,status = " + paramDownloadTask.z);
      if (a(i2)) {
        jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a(localEmoticonPackage, i2, -1, i1);
      }
      jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a(localEmoticonPackage, i1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      VasReportUtils.a("emotionType", "emotionActionDownload", "11", localEmoticonPackage.epId, "", "", paramDownloadTask.z + "", "", "", "");
      a(localEmoticonPackage, i1, 0L, paramDownloadTask.d);
      return;
    }
    if ((bool2) && (i1 == 0))
    {
      localObject = (ArrayList)((Bundle)localObject).getSerializable("emoticonList");
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        a().a(localEmoticonPackage.epId, (List)localObject);
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "update package:" + localEmoticonPackage.epId + ",newEmoticons:" + ((ArrayList)localObject).size());
        }
      }
    }
    for (;;)
    {
      localEmoticonPackage.updateFlag &= 0xFFFFFFFE;
      localEmoticonPackage.status = 2;
      localEmoticonPackage.valid = true;
      localObject = a();
      ((EmoticonManager)localObject).a(localEmoticonPackage);
      if (bool1) {}
      try
      {
        ((EmoticonManager)localObject).c(localEmoticonPackage.epId);
        jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a(localEmoticonPackage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.d(localEmoticonPackage);
        a(localEmoticonPackage, 0, l1 - l2, paramDownloadTask.d);
        return;
      }
      finally {}
      if (localEmoticonPackage.latestVersion > localEmoticonPackage.localVersion) {
        localEmoticonPackage.localVersion = localEmoticonPackage.latestVersion;
      }
      localEmoticonPackage.hasReadUpdatePage = false;
    }
  }
  
  private void c(List paramList, Map paramMap, EmoticonPackage paramEmoticonPackage, Bundle paramBundle)
  {
    if (!a(paramEmoticonPackage.epId, h))
    {
      String str = EmosmUtils.a(paramEmoticonPackage.epId, 1);
      paramEmoticonPackage = EmoticonUtils.s.replace("[epId]", paramEmoticonPackage.epId);
      if (!FileUtils.a(paramEmoticonPackage))
      {
        paramList.add(str);
        paramMap.put(str, new File(paramEmoticonPackage));
        paramBundle.putInt(str, 21);
      }
    }
  }
  
  private String[] c(Emoticon paramEmoticon)
  {
    String str;
    if (paramEmoticon.jobType == 3) {
      str = EmoticonUtils.c.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId);
    }
    for (paramEmoticon = EmoticonUtils.l.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId);; paramEmoticon = EmoticonUtils.l.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId))
    {
      return new String[] { str, paramEmoticon };
      str = EmoticonUtils.f.replace("[eIdSub]", paramEmoticon.eId.substring(0, 2)).replace("[eId]", paramEmoticon.eId);
    }
  }
  
  private void d(List paramList, Map paramMap, EmoticonPackage paramEmoticonPackage, Bundle paramBundle)
  {
    if (!a(paramEmoticonPackage.epId, g))
    {
      String str = EmosmUtils.a(paramEmoticonPackage.epId, 0);
      paramEmoticonPackage = EmoticonUtils.s.replace("[epId]", paramEmoticonPackage.epId);
      if (!FileUtils.a(paramEmoticonPackage))
      {
        paramList.add(str);
        paramMap.put(str, new File(paramEmoticonPackage));
        paramBundle.putInt(str, 21);
      }
    }
  }
  
  private void e(List paramList, Map paramMap, EmoticonPackage paramEmoticonPackage, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handleEmotionPackage|add magic task ");
    }
    c(paramList, paramMap, paramEmoticonPackage, paramBundle);
    d(paramList, paramMap, paramEmoticonPackage, paramBundle);
  }
  
  private void f(List paramList, Map paramMap, EmoticonPackage paramEmoticonPackage, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handleEmotionPackage|add h5magic task ");
    }
    if (!b(paramEmoticonPackage.epId, true, false))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handleEmotionPackage| add h5 zip url");
      }
      String str = EmosmUtils.b(paramEmoticonPackage.epId);
      paramEmoticonPackage = EmosmUtils.c(paramEmoticonPackage.epId);
      if (paramEmoticonPackage != null)
      {
        paramList.add(str);
        paramMap.put(str, new File(paramEmoticonPackage));
        paramBundle.putInt(str, 20);
      }
    }
  }
  
  public float a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    do
    {
      return -1.0F;
      paramString = a().a("vipEmoticonKey_" + paramString);
    } while (paramString == null);
    return paramString.jdField_a_of_type_Float;
  }
  
  public Bundle a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = (ArrayList)a().a();
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        EmoticonPackage localEmoticonPackage = (EmoticonPackage)((Iterator)localObject).next();
        if (localEmoticonPackage.jobType == 0) {
          localArrayList.add(a(localEmoticonPackage.epId, 1));
        } else if (localEmoticonPackage.jobType == 3) {
          localArrayList.add(a(localEmoticonPackage.epId, 3));
        } else if (localEmoticonPackage.jobType == 5) {
          localArrayList.add(a(localEmoticonPackage.epId, 4));
        } else if (localEmoticonPackage.jobType == 4) {
          localArrayList.add(a(localEmoticonPackage.epId, 5));
        }
      }
    }
    localObject = new Bundle();
    ((Bundle)localObject).putParcelableArrayList("pkgStatusList", localArrayList);
    return (Bundle)localObject;
  }
  
  public Bundle a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    Bundle localBundle = new Bundle();
    String str = String.valueOf(paramBundle.getInt("id"));
    int i1 = paramBundle.getInt("businessType");
    if (a().a("vipEmoticonKey_" + str) != null)
    {
      localBundle.putInt("result", 0);
      localBundle.putString("messge", "");
      return localBundle;
    }
    paramBundle = a().b(str);
    if ((paramBundle != null) && (paramBundle.status != 0))
    {
      switch (paramBundle.status)
      {
      default: 
        i1 = 1;
      }
      for (;;)
      {
        if ((paramBundle != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "Clk_updatepkg_detail", 0, 0, paramBundle.epId, "" + paramBundle.localVersion, "" + paramBundle.latestVersion, "");
        }
        localBundle.putInt("result", i1);
        localBundle.putString("messge", "");
        return localBundle;
        if (EmoticonUtils.a(paramBundle.updateFlag))
        {
          a(paramBundle, true);
          i1 = 0;
        }
        else
        {
          i1 = 3;
          continue;
          i1 = 4;
        }
      }
    }
    EmoticonPackage localEmoticonPackage = a().a(str);
    paramBundle = localEmoticonPackage;
    if (localEmoticonPackage == null)
    {
      paramBundle = new EmoticonPackage();
      paramBundle.epId = str;
      paramBundle.wordingId = -1L;
      if (i1 != 2) {
        break label372;
      }
      paramBundle.jobType = 1;
    }
    for (;;)
    {
      paramBundle.isMagicFaceDownloading = false;
      if (i1 == 4) {
        paramBundle.jobType = 5;
      }
      a(paramBundle, true);
      localBundle.putInt("result", 0);
      localBundle.putString("messge", "");
      return localBundle;
      label372:
      if (i1 == 3) {
        paramBundle.jobType = 3;
      } else if (i1 == 4) {
        paramBundle.jobType = 5;
      } else if (i1 == 5) {
        paramBundle.jobType = 4;
      } else {
        paramBundle.jobType = 0;
      }
    }
  }
  
  public Bundle a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramString = a().a("vipEmoticonKey_" + paramString);
    if (paramString != null)
    {
      paramString.a(true);
      paramString = (EmoticonPackage)paramString.a().getSerializable("emoticonPackage");
      if (paramString != null) {
        jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a(paramString, 11007, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
    paramString = new Bundle();
    paramString.putInt("result", 0);
    paramString.putString("messge", "");
    return paramString;
  }
  
  public EmoticonManager a()
  {
    return (EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
  }
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("emoticonPackage", paramEmoticonPackage);
    a(localArrayList, localHashMap, paramEmoticonPackage, localBundle);
    b(localArrayList, localHashMap, paramEmoticonPackage, localBundle);
    paramEmoticonPackage = new DownloadTask(localArrayList, localHashMap, "vipEmoticonKey_cover_" + paramEmoticonPackage.epId);
    paramEmoticonPackage.e = this.i;
    paramEmoticonPackage.l = true;
    a().a(paramEmoticonPackage, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, localBundle);
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt, long paramLong, String paramString)
  {
    if (paramEmoticonPackage == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_a_of_type_JavaLangString, 2, "download emoji report actionResult=" + paramInt + ",epId=" + paramEmoticonPackage.epId + ",downloadTime=" + paramLong);
    }
    int i1 = 0;
    if (paramInt != 0) {
      i1 = 1;
    }
    paramInt = NetworkUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext());
    if (paramString == null) {
      paramString = "";
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "EMOJI_DOWN", "actEmoPackage", 0, i1, paramEmoticonPackage.epId + "", paramInt + "", paramString, String.valueOf(paramLong));
      return;
    }
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, DownloadListener paramDownloadListener, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "package download epId:" + paramEmoticonPackage.epId);
    }
    if ((paramEmoticonPackage == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null))
    {
      QLog.e(this.jdField_a_of_type_JavaLangString, 1, "ep or mApp = null");
      return;
    }
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      QLog.e(this.jdField_a_of_type_JavaLangString, 1, "netUnSupport epId=" + paramEmoticonPackage.epId);
      jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a(paramEmoticonPackage, 11003, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      VasReportUtils.a("emotionType", "emotionActionDownload", "2", paramEmoticonPackage.epId, "", "", "", "", "", "");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("emoticonPackage", paramEmoticonPackage);
    localBundle.putBoolean("newPkgAdd", paramBoolean);
    if ((paramEmoticonPackage.jobType == 3) && (paramEmoticonPackage.isMagicFaceDownloading)) {}
    String str;
    for (Object localObject = "vipEmoticonKey_auto_" + paramEmoticonPackage.epId;; localObject = str)
    {
      if (paramEmoticonPackage.jobType == 3)
      {
        e(localArrayList, localHashMap, paramEmoticonPackage, localBundle);
        localObject = new DownloadTask(localArrayList, localHashMap, (String)localObject);
        ((DownloadTask)localObject).l = true;
        if (localArrayList.size() != 0) {
          break label809;
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handleEmotionPackage| urlList is empty");
        }
        ((DownloadTask)localObject).a(localBundle);
        ((DownloadTask)localObject).a(3);
        paramDownloadListener.onDone((DownloadTask)localObject);
      }
      for (;;)
      {
        if (paramEmoticonPackage.jobType != 5) {
          break label841;
        }
        b(paramEmoticonPackage, paramBoolean);
        return;
        str = "vipEmoticonKey_" + paramEmoticonPackage.epId;
        localObject = EmosmUtils.a(paramEmoticonPackage.epId);
        if (paramEmoticonPackage.jobType == 4) {
          localObject = EmoticonUtils.b.replace("[epId]", paramEmoticonPackage.epId);
        }
        File localFile = new File(EmoticonUtils.n.replace("[epId]", paramEmoticonPackage.epId));
        localObject = new DownloadTask((String)localObject, localFile);
        ((DownloadTask)localObject).jdField_h_of_type_Boolean = true;
        ((DownloadTask)localObject).l = true;
        int i1 = DownloaderFactory.a((DownloadTask)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a(paramEmoticonPackage, i1);
        if (i1 != 0)
        {
          QLog.e(this.jdField_a_of_type_JavaLangString, 1, "json download faile : resultCode = " + i1);
          i1 = EmosmUtils.a(i1);
          jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a(paramEmoticonPackage, i1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          VasReportUtils.a("emotionType", "emotionActionDownload", "3", paramEmoticonPackage.epId, "", NetworkUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication()) + "", i1 + "", "", "", "");
          return;
        }
        boolean bool = EmoticonUtils.a(paramEmoticonPackage);
        if (((paramEmoticonPackage.jobType == 0) || (paramEmoticonPackage.jobType == 4)) && (!bool)) {
          a(localArrayList, localHashMap, paramEmoticonPackage, localBundle);
        }
        b(localArrayList, localHashMap, paramEmoticonPackage, localBundle);
        i1 = 14;
        if (paramEmoticonPackage.jobType == 5) {
          i1 = 6;
        }
        for (;;)
        {
          i1 = a(localFile, paramEmoticonPackage, bool, localArrayList, localHashMap, localBundle, i1);
          if (i1 == 0) {
            break;
          }
          QLog.e(this.jdField_a_of_type_JavaLangString, 1, "handleEmotionPackage|addEmotionsTask fail : resultCode = " + i1);
          jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a(paramEmoticonPackage, i1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          VasReportUtils.a("emotionType", "emotionActionDownload", "5", paramEmoticonPackage.epId, "", "", i1 + "", "", "", "");
          return;
          if (paramEmoticonPackage.jobType == 3) {
            i1 = 15;
          }
        }
        if (paramEmoticonPackage.jobType != 5) {
          break;
        }
        f(localArrayList, localHashMap, paramEmoticonPackage, localBundle);
        break;
        label809:
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handleEmotionPackage| startDownload");
        }
        a().a((DownloadTask)localObject, paramDownloadListener, localBundle);
      }
      label841:
      break;
    }
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, boolean paramBoolean)
  {
    if ((paramEmoticonPackage == null) || (paramEmoticonPackage.epId == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    while (a().a("vipEmoticonKey_" + paramEmoticonPackage.epId) != null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "try to pullEmoticonPackage ep:" + paramEmoticonPackage.epId);
    }
    if (!EmosmUtils.a(paramEmoticonPackage.epId))
    {
      QLog.e(this.jdField_a_of_type_JavaLangString, 1, "ep.epId=" + paramEmoticonPackage.epId + " isNumeral false.");
      VasReportUtils.a("emotionType", "emotionActionDownload", "1", paramEmoticonPackage.epId, "", "", "", "", "", "");
      return;
    }
    if (!paramEmoticonPackage.isMagicFaceDownloading) {
      if ((paramEmoticonPackage.status != 2) || (!EmoticonUtils.a(paramEmoticonPackage.updateFlag))) {
        break label286;
      }
    }
    for (;;)
    {
      paramEmoticonPackage.valid = true;
      a().a(paramEmoticonPackage);
      File localFile = new File(AppConstants.bU);
      if (!localFile.exists())
      {
        boolean bool = localFile.mkdirs();
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "mkdirs success:" + bool);
        }
      }
      ThreadManager.a(new rjg(this, paramEmoticonPackage, paramBoolean), 5, null, true);
      return;
      label286:
      paramEmoticonPackage.status = 0;
    }
  }
  
  public void a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return;
      paramString = a().a("vipEmoticonKey_" + paramString);
    } while (paramString == null);
    paramString.a(true);
  }
  
  public void a(String paramString, int paramInt)
  {
    a(paramString, paramInt, null, false);
  }
  
  public void a(String paramString, int paramInt, Bundle paramBundle, boolean paramBoolean)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return;
    }
    if (paramBoolean)
    {
      localObject1 = EmoticonUtils.b.replace("[epId]", paramString);
      label29:
      localObject2 = a().a((String)localObject1);
      if ((localObject2 == null) || (((DownloadTask)localObject2).b())) {
        break label107;
      }
    }
    label107:
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 == 0) {
        break label113;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "startDownloadEmosmJson|epId is in downloading:" + paramString);
      return;
      localObject1 = EmosmUtils.a(paramString);
      break label29;
    }
    label113:
    EmoticonPackage localEmoticonPackage = a().a(paramString);
    Object localObject2 = localEmoticonPackage;
    if (localEmoticonPackage == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "startDownloadEmosmJson|emoPackage is not exist:" + paramString);
      }
      localObject2 = new EmoticonPackage();
      ((EmoticonPackage)localObject2).epId = paramString;
      ((EmoticonPackage)localObject2).status = 0;
      a().a((EmoticonPackage)localObject2);
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "startDownloadEmosmJson epId:" + ((EmoticonPackage)localObject2).epId);
    }
    paramString = new DownloadTask((String)localObject1, new File(EmoticonUtils.n.replace("[epId]", paramString)));
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("jsonType", paramInt);
    ((Bundle)localObject1).putSerializable("emoticonPackage", (Serializable)localObject2);
    ((Bundle)localObject1).putBoolean("isSmallEmotion", paramBoolean);
    if (paramBundle != null) {
      ((Bundle)localObject1).putBundle("jsonReqParams", paramBundle);
    }
    paramString.e = this.i;
    paramString.l = true;
    a().a(paramString, this.c, (Bundle)localObject1);
  }
  
  public void a(String paramString, ArrayList paramArrayList)
  {
    int i1 = EmosmUtils.a(paramString);
    if ((paramArrayList == null) || (paramArrayList.size() == 0) || (i1 == -1)) {
      return;
    }
    int i2 = this.j;
    this.j = (i2 + 1);
    paramString = Integer.toString(i2);
    ((EmoticonHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12)).a(i1, paramArrayList, paramString);
  }
  
  public void a(String paramString, ArrayList paramArrayList, ReqInfo paramReqInfo)
  {
    int i1 = EmosmUtils.a(paramString);
    if ((paramArrayList == null) || (paramArrayList.size() == 0) || (paramReqInfo == null) || (i1 == -1)) {
      return;
    }
    paramString = new Object();
    EmoticonHandler localEmoticonHandler = (EmoticonHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12);
    localEmoticonHandler.a(new rjh(this, localEmoticonHandler, paramReqInfo, paramString));
    int i2 = this.j;
    this.j = (i2 + 1);
    String str = Integer.toString(i2);
    paramReqInfo.jdField_a_of_type_JavaLangString = str;
    paramReqInfo.jdField_a_of_type_Int = 11022;
    localEmoticonHandler.a(i1, paramArrayList, str);
    try
    {
      try
      {
        paramString.wait(35000L);
        return;
      }
      finally {}
      return;
    }
    catch (InterruptedException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("h5magic_sp_name", 4).getBoolean("h5magic_sp_isplay_key", false);
    boolean bool4 = b();
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "canPlayH5Magic isPlay = " + bool3 + ";isDPCSupport = " + bool4);
    }
    boolean bool1 = bool2;
    if (!bool3)
    {
      bool1 = bool2;
      if (bool4) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean a(int paramInt)
  {
    return (paramInt == 3) || (paramInt == 4) || (paramInt == 2);
  }
  
  public boolean a(Emoticon paramEmoticon)
  {
    return (paramEmoticon != null) && (paramEmoticon.extensionWidth != 0) && (paramEmoticon.extensionHeight != 0);
  }
  
  public boolean a(Emoticon paramEmoticon, int paramInt)
  {
    if ((paramEmoticon == null) || (paramEmoticon.epId == null) || (paramEmoticon.eId == null)) {}
    while (a().a("vipEmoticonKey_" + paramEmoticon.epId) == null) {
      return false;
    }
    return true;
  }
  
  public boolean a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    do
    {
      return false;
      paramString = EmosmUtils.a(paramString);
      paramString = a().a(paramString);
    } while ((paramString == null) || (paramString.b()));
    return true;
  }
  
  public boolean a(String paramString, int paramInt)
  {
    String str3 = EmoticonUtils.j.replace("[epId]", paramString);
    String str1;
    int i1;
    if (paramInt == h)
    {
      String str2 = MagicfaceResLoader.a();
      str1 = str3 + str2 + File.separator + "video.ini";
      File localFile = new File(str1);
      paramString = localFile;
      if (!localFile.exists())
      {
        str2 = "big";
        str1 = str3 + "big" + File.separator + "video.ini";
        localFile = new File(str1);
        paramString = localFile;
        if (!localFile.exists()) {
          return false;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_a_of_type_JavaLangString, 2, "videoConfigPath ==" + str1);
      }
      paramString = FileUtils.a(paramString).split("&");
      i1 = paramString.length;
      paramInt = 0;
      while (paramInt < i1)
      {
        str1 = paramString[paramInt];
        if (!new File(str3 + str2 + File.separator + str1).exists()) {
          return false;
        }
        paramInt += 1;
      }
    }
    if (paramInt == g)
    {
      paramString = new File(str3 + "audio" + File.separator + "audio.ini");
      if (!paramString.exists()) {
        return false;
      }
      paramString = FileUtils.a(paramString).split("&");
      i1 = paramString.length;
      paramInt = 0;
      while (paramInt < i1)
      {
        str1 = paramString[paramInt];
        if (!new File(str3 + "audio" + File.separator + str1).exists()) {
          return false;
        }
        paramInt += 1;
      }
    }
    return true;
  }
  
  public boolean a(String paramString, Boolean paramBoolean)
  {
    boolean bool = b(paramString, paramBoolean);
    a(paramString, bool);
    return bool;
  }
  
  public boolean a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (a().a(paramString) != null) {}
    for (int i1 = 1;; i1 = 0) {
      return (i1 != 0) && (b(paramString, paramBoolean1, paramBoolean2));
    }
  }
  
  public Bundle b(Bundle paramBundle)
  {
    int i1 = 1;
    int i2;
    if (paramBundle == null)
    {
      paramBundle = "";
      i1 = 0;
      i2 = -1;
    }
    Object localObject;
    for (;;)
    {
      localObject = new Bundle();
      if (i1 == 0) {
        break;
      }
      paramBundle = a(paramBundle, i2);
      ((Bundle)localObject).putInt("result", paramBundle.getInt("result"));
      ((Bundle)localObject).putString("messge", "");
      ((Bundle)localObject).putInt("id", -1);
      ((Bundle)localObject).putInt("status", paramBundle.getInt("status"));
      ((Bundle)localObject).putInt("pluginStatus", paramBundle.getInt("pluginStatus"));
      ((Bundle)localObject).putLong("pluginSize", paramBundle.getLong("pluginSize"));
      ((Bundle)localObject).putInt("progress", paramBundle.getInt("progress"));
      ((Bundle)localObject).putInt("dynamicEmojiId", paramBundle.getInt("dEmojiId"));
      ((Bundle)localObject).putStringArrayList("dynamicEmojiList", paramBundle.getStringArrayList("srcList"));
      ((Bundle)localObject).putStringArrayList("urlParamsList", paramBundle.getStringArrayList("urlParamsList"));
      return (Bundle)localObject;
      localObject = paramBundle.getString("id");
      int i3 = paramBundle.getInt("businessType");
      if (((String)localObject).length() == 0)
      {
        i1 = 0;
        i2 = i3;
        paramBundle = (Bundle)localObject;
      }
      else
      {
        i2 = i3;
        paramBundle = (Bundle)localObject;
        if (EmosmUtils.a((String)localObject) == -1)
        {
          i1 = 0;
          i2 = i3;
          paramBundle = (Bundle)localObject;
        }
      }
    }
    ((Bundle)localObject).putInt("result", 0);
    ((Bundle)localObject).putString("messge", "");
    ((Bundle)localObject).putInt("id", -1);
    ((Bundle)localObject).putInt("status", 0);
    ((Bundle)localObject).putInt("pluginStatus", 0);
    ((Bundle)localObject).putLong("pluginSize", 0L);
    ((Bundle)localObject).putInt("progress", 0);
    ((Bundle)localObject).putInt("dynamicEmojiId", -1);
    ((Bundle)localObject).putStringArrayList("dynamicEmojiList", null);
    ((Bundle)localObject).putStringArrayList("urlParamsList", null);
    return (Bundle)localObject;
  }
  
  public boolean b()
  {
    return DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.h5magic_support.name());
  }
  
  public boolean b(Emoticon paramEmoticon, int paramInt)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramEmoticon == null)
    {
      bool1 = false;
      return bool1;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "downloadAIOEmoticon|taskvalue:" + paramInt + "，epid:" + paramEmoticon.epId + "，eid=" + paramEmoticon.eId);
    }
    if (Utils.b())
    {
      if (Utils.b() < 1048576L)
      {
        QLog.d(this.jdField_a_of_type_JavaLangString, 1, "sdcard check, sdcard full .return.");
        VasReportUtils.a("emotionType", "emotionActionAIO", "1", paramEmoticon.epId, paramEmoticon.eId, "", "", "", "", "");
        return false;
      }
    }
    else
    {
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "sdcard check, has sdcard FALSE .return.");
      VasReportUtils.a("emotionType", "emotionActionAIO", "2", paramEmoticon.epId, paramEmoticon.eId, "", "", "", "", "");
      return false;
    }
    Object localObject1;
    int i1;
    if ((paramInt & 0x2) == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "downloadAIOEmoticon| Emoticon download emo imgPreview.pid=" + paramEmoticon.epId + " eid=" + paramEmoticon.eId + " type=" + paramInt + " time:" + System.currentTimeMillis() + ",jobType:" + paramEmoticon.jobType);
      }
      localObject1 = c(paramEmoticon);
      if (!FileUtils.a(localObject1[1]))
      {
        localObject1 = new DownloadTask(localObject1[0], new File(localObject1[1]));
        ((DownloadTask)localObject1).l = true;
        i1 = DownloaderFactory.a((DownloadTask)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (i1 != 0)
        {
          QLog.e(this.jdField_a_of_type_JavaLangString, 1, "task preview down fail :epid = " + paramEmoticon.epId + ";eid = " + paramEmoticon.eId);
          VasReportUtils.a("emotionType", "emotionActionAIO", "3", paramEmoticon.epId, paramEmoticon.eId, NetworkUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication()) + "", i1 + "", "", "", "");
          return false;
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "ret:" + i1);
        }
      }
    }
    Object localObject2;
    Object localObject4;
    if ((paramInt & 0x4) == 4)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "downloadAIOEmoticon| Emoticon download emo gif.pid=" + paramEmoticon.epId + " eid=" + paramEmoticon.eId + " type=" + paramInt + " time:" + System.currentTimeMillis());
      }
      if (paramEmoticon.jobType == 1) {
        break label2061;
      }
      localObject1 = a(paramEmoticon, 0);
      localObject2 = new ReqInfo();
      if ((paramEmoticon.jobType != 3) && (TextUtils.isEmpty(paramEmoticon.encryptKey)))
      {
        localObject4 = new ArrayList();
        ((ArrayList)localObject4).add(paramEmoticon);
        a(paramEmoticon.epId, (ArrayList)localObject4, (ReqInfo)localObject2);
        if (TextUtils.isEmpty(paramEmoticon.encryptKey))
        {
          QLog.i(this.jdField_a_of_type_JavaLangString, 1, "Emoticon don't have encryptKey,epId=" + paramEmoticon.epId + ", eid=" + paramEmoticon.eId + " type=" + 4);
          VasReportUtils.a("emotionType", "emotionActionAIO", "4", paramEmoticon.epId, paramEmoticon.eId, "", "", "", "", "");
          return false;
        }
      }
    }
    for (;;)
    {
      if (localObject1 == null) {
        return false;
      }
      bool1 = FileUtils.a(localObject1[1]);
      if (!bool1)
      {
        localObject2 = new File(localObject1[1]);
        localObject1 = new DownloadTask(localObject1[0], (File)localObject2);
        ((DownloadTask)localObject1).l = true;
        i1 = DownloaderFactory.a((DownloadTask)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (i1 != 0)
        {
          QLog.e(this.jdField_a_of_type_JavaLangString, 1, "task gif down fail :epid = " + paramEmoticon.epId + ";eid = " + paramEmoticon.eId + ":ret = " + i1);
          VasReportUtils.a("emotionType", "emotionActionAIO", "5", paramEmoticon.epId, paramEmoticon.eId, NetworkUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication()) + "", i1 + "", "", "", "");
          return false;
        }
      }
      for (;;)
      {
        if ((!bool1) && (paramEmoticon.jobType != 1)) {}
        for (;;)
        {
          try
          {
            localObject4 = FileUtils.a((File)localObject2);
            String str = ((File)localObject2).getAbsolutePath();
            ((File)localObject2).delete();
            if (localObject4 == null)
            {
              QLog.e(this.jdField_a_of_type_JavaLangString, 1, "task gif 2 fail :epid = " + paramEmoticon.epId + ";eid = " + paramEmoticon.eId);
              VasReportUtils.a("emotionType", "emotionActionAIO", "6", paramEmoticon.epId, paramEmoticon.eId, "", "", "", "", "");
              return false;
            }
            if (paramEmoticon.jobType != 3)
            {
              i1 = EmosmUtils.a((byte[])localObject4, paramEmoticon.encryptKey, str);
              if (i1 != 0)
              {
                if (QLog.isColorLevel()) {
                  QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onProgress download encrypt exception, url=" + ((DownloadTask)localObject1).c);
                }
                if ((Utils.b()) && (Utils.b() > 1048576L)) {
                  FileUtils.a(AppConstants.bj + "err" + File.separator + String.valueOf(paramEmoticon.epId) + "_" + paramEmoticon.encryptKey + "_" + ((File)localObject2).getName(), (byte[])localObject4, false);
                }
                QLog.e(this.jdField_a_of_type_JavaLangString, 1, "task gif save fail :epid = " + paramEmoticon.epId + ";eid = " + paramEmoticon.eId + ";emosmCode = " + i1);
                VasReportUtils.a("emotionType", "emotionActionAIO", "7", paramEmoticon.epId, paramEmoticon.eId, "", i1 + "", "", "", "");
                return false;
              }
            }
            else
            {
              if (paramEmoticon.jobType != 3) {
                break label2047;
              }
              i1 = EmosmUtils.a((byte[])localObject4, str);
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onProgress| Emotiocon encode resource done.result=" + i1 + " time:" + System.currentTimeMillis() + " url=" + ((DownloadTask)localObject1).c);
            }
            if ((paramInt & 0x1) == 1)
            {
              if (QLog.isColorLevel()) {
                QLog.d(this.jdField_a_of_type_JavaLangString, 2, "downloadAIOEmoticon| Emoticon download emo AIO preview static.pid=" + paramEmoticon.epId + " eid=" + paramEmoticon.eId + " type=" + paramInt);
              }
              localObject1 = b(paramEmoticon);
              if (!FileUtils.a(localObject1[1]))
              {
                localObject1 = new DownloadTask(localObject1[0], new File(localObject1[1]));
                ((DownloadTask)localObject1).l = true;
                i1 = DownloaderFactory.a((DownloadTask)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                if (i1 != 0)
                {
                  QLog.e(this.jdField_a_of_type_JavaLangString, 1, "task aio static down fail :epid = " + paramEmoticon.epId + ";eid = " + paramEmoticon.eId + ";ret = " + i1);
                  VasReportUtils.a("emotionType", "emotionActionAIO", "9", paramEmoticon.epId, paramEmoticon.eId, NetworkUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication()) + "", i1 + "", "", "", "");
                  return false;
                }
              }
            }
          }
          catch (Throwable localThrowable)
          {
            localThrowable.printStackTrace();
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onProgress Emotiocon encode resource fail .EXCEPTION:" + localThrowable.toString() + " time:" + System.currentTimeMillis() + " url=" + ((DownloadTask)localObject1).c);
            }
            VasReportUtils.a("emotionType", "emotionActionAIO", "8", paramEmoticon.epId, paramEmoticon.eId, "", "", "", "", "");
            return false;
          }
          bool1 = bool2;
          if (!paramEmoticon.isSound) {
            break;
          }
          bool1 = bool2;
          if ((paramInt & 0x8) != 8) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "downloadAIOEmoticon| Emoticon download emo sound.pid=" + paramEmoticon.epId + " eid=" + paramEmoticon.eId + " type=" + paramInt + " time:" + System.currentTimeMillis());
          }
          localObject1 = a(paramEmoticon);
          bool1 = bool2;
          if (FileUtils.a(localObject1[1])) {
            break;
          }
          localObject1 = new DownloadTask(localObject1[0], new File(localObject1[1]));
          ((DownloadTask)localObject1).l = true;
          paramInt = DownloaderFactory.a((DownloadTask)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          bool1 = bool2;
          if (paramInt == 0) {
            break;
          }
          QLog.e(this.jdField_a_of_type_JavaLangString, 1, "task sound down fail :epid = " + paramEmoticon.epId + ";eid = " + paramEmoticon.eId + ";ret = " + paramInt);
          VasReportUtils.a("emotionType", "emotionActionAIO", "10", paramEmoticon.epId, paramEmoticon.eId, NetworkUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication()) + "", paramInt + "", "", "", "");
          return false;
          label2047:
          i1 = 0;
        }
        localObject1 = null;
        Object localObject3 = null;
      }
      label2061:
      localObject1 = null;
    }
  }
  
  public boolean b(String paramString)
  {
    boolean bool = e(paramString);
    a(paramString, bool);
    return bool;
  }
  
  public boolean b(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool1 = true;
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "isH5MagicFacePackageIntact, epId = " + paramString + ", needKey = " + paramBoolean1 + ", needCheckChild = " + paramBoolean2);
    }
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    boolean bool2 = a(paramString, paramBoolean1);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "isH5MagicFacePackageIntact, result = " + bool2);
    }
    EmoticonPackage localEmoticonPackage = a().a(paramString);
    if (localEmoticonPackage != null) {
      if ((paramBoolean2) && (!TextUtils.isEmpty(localEmoticonPackage.childEpId)))
      {
        paramBoolean1 = a(localEmoticonPackage.childEpId, paramBoolean1);
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "isH5MagicFacePackageIntact, childEpId = " + localEmoticonPackage.childEpId + ", childResult = " + paramBoolean1);
        }
        a(localEmoticonPackage.childEpId, paramBoolean1);
        if ((bool2) && (paramBoolean1))
        {
          paramBoolean1 = bool1;
          label220:
          a(paramString, paramBoolean1);
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "isH5MagicFacePackageIntact, epId=" + paramString + ", result=" + paramBoolean1);
      }
      return paramBoolean1;
      paramBoolean1 = false;
      break label220;
      paramBoolean1 = true;
      break;
      paramBoolean1 = bool2;
    }
  }
  
  public boolean c()
  {
    if (jdField_a_of_type_Int == 4) {
      if (System.currentTimeMillis() - jdField_a_of_type_Long > 15000L)
      {
        jdField_a_of_type_Int = 0;
        jdField_a_of_type_Boolean = false;
      }
    }
    do
    {
      return true;
      return false;
      jdField_a_of_type_Int += 1;
    } while ((jdField_a_of_type_Int != 4) || (jdField_a_of_type_Boolean));
    jdField_a_of_type_Boolean = true;
    jdField_a_of_type_Long = System.currentTimeMillis();
    return true;
  }
  
  public boolean c(Emoticon paramEmoticon, int paramInt)
  {
    boolean bool2;
    if (paramEmoticon == null)
    {
      bool2 = true;
      return bool2;
    }
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool1;
    if ((paramInt & 0x1) == 1)
    {
      if (paramEmoticon.jobType != 1) {
        localObject1 = EmoticonUtils.m.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId);
      }
      bool1 = FileUtil.a((String)localObject1);
    }
    for (;;)
    {
      if ((bool1) && ((paramInt & 0x4) == 4)) {
        if (paramEmoticon.jobType != 1) {
          localObject1 = EmoticonUtils.o.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId);
        }
      }
      for (bool2 = FileUtil.a((String)localObject1);; bool2 = bool1)
      {
        bool1 = bool2;
        if (bool2)
        {
          bool1 = bool2;
          if ((paramInt & 0x2) == 2) {
            bool1 = FileUtil.a(EmoticonUtils.l.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId));
          }
        }
        bool2 = bool1;
        if (!bool1) {
          break;
        }
        bool2 = bool1;
        if (!paramEmoticon.isSound) {
          break;
        }
        bool2 = bool1;
        if ((paramInt & 0x8) != 8) {
          break;
        }
        return FileUtil.a(EmoticonUtils.k.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId));
      }
      bool1 = true;
      localObject1 = localObject2;
    }
  }
  
  public boolean c(String paramString)
  {
    boolean bool = d(paramString);
    a(paramString, bool);
    return bool;
  }
  
  public boolean d(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    Object localObject = EmosmUtils.a(2, paramString);
    if (!new File((String)localObject).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkSmallEmoticonPackageIntact, cover_pkg_thumb isn't exist." + (String)localObject);
      }
      return false;
    }
    localObject = EmosmUtils.a(3, paramString);
    if (!new File((String)localObject).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkSmallEmoticonPackageIntact, cover_pkg_color isn't exist." + (String)localObject);
      }
      return false;
    }
    localObject = EmosmUtils.a(4, paramString);
    if (!new File((String)localObject).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkSmallEmoticonPackageIntact, cover_pkg_gray isn't exist." + (String)localObject);
      }
      return false;
    }
    localObject = (ArrayList)a().a(paramString);
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      Emoticon localEmoticon;
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localEmoticon = (Emoticon)((Iterator)localObject).next();
        if (localEmoticon == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "one of encrypts is null!" + paramString);
          }
          return false;
        }
        if (!new File(EmoticonUtils.l.replace("[epId]", paramString).replace("[eId]", localEmoticon.eId)).exists())
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkSmallEmoticonPackageIntact, emo img preview do not be exist! epId=" + paramString + " eId=" + localEmoticon.eId);
          }
          return false;
        }
      } while (new File(EmoticonUtils.o.replace("[epId]", paramString).replace("[eId]", localEmoticon.eId)).exists());
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkSmallEmoticonPackageIntact, emo img encrypt file do not be exist! epId=" + paramString + " eId=" + localEmoticon.eId);
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkSmallEmoticonPackageIntact, emoticons do not be exist.epId=" + paramString);
    }
    return true;
  }
  
  public boolean e(String paramString)
  {
    if (paramString == null) {}
    do
    {
      do
      {
        do
        {
          return false;
          localObject1 = EmosmUtils.a(2, paramString);
          if (new File((String)localObject1).exists()) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "cover_pkg_thumb isn't exist." + (String)localObject1);
        return false;
        localObject1 = EmosmUtils.a(3, paramString);
        if (new File((String)localObject1).exists()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "cover_pkg_color isn't exist." + (String)localObject1);
      return false;
      localObject1 = EmosmUtils.a(4, paramString);
      if (new File((String)localObject1).exists()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.jdField_a_of_type_JavaLangString, 2, "cover_pkg_gray isn't exist." + (String)localObject1);
    return false;
    Object localObject1 = (ArrayList)a().a(paramString, true);
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = a().a(paramString);
      if (localObject2 == null) {
        break label567;
      }
    }
    label567:
    for (int i1 = ((EmoticonPackage)localObject2).rscType;; i1 = 0)
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Emoticon)((Iterator)localObject1).next();
          if (localObject2 == null)
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "one of encrypts is null!" + paramString);
            return false;
          }
          if ((((Emoticon)localObject2).jobType == 0) && ((((Emoticon)localObject2).encryptKey == null) || (((Emoticon)localObject2).encryptKey.length() == 0)))
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "encrypt isn't exist.epId=" + paramString + " eId=" + ((Emoticon)localObject2).eId);
            return false;
          }
          if (!new File(EmoticonUtils.l.replace("[epId]", paramString).replace("[eId]", ((Emoticon)localObject2).eId)).exists())
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "emo img preview do not be exist! epId=" + paramString + " eId=" + ((Emoticon)localObject2).eId);
            return false;
          }
          if (1 == i1) {
            return PngFrameUtil.a(EmoticonUtils.t.replace("[epId]", paramString));
          }
          if (!new File(EmoticonUtils.o.replace("[epId]", paramString).replace("[eId]", ((Emoticon)localObject2).eId)).exists())
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "emo img encrypt file do not be exist! epId=" + paramString + " eId=" + ((Emoticon)localObject2).eId);
            return false;
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_a_of_type_JavaLangString, 2, "emoticons do not be exist.epId=" + paramString);
            }
          }
        }
      }
      return true;
    }
  }
  
  public boolean f(String paramString)
  {
    return new File(EmoticonUtils.j.replace("[epId]", paramString) + "audio" + File.separator + "audio.ini").exists();
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "clear History. uin:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount() + " app=" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    }
    jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a();
    if (a() != null) {
      a().a();
    }
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      this.jdField_a_of_type_JavaUtilMap.clear();
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\emoticon\EmojiManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */