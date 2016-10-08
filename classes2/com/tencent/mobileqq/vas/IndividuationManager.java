package com.tencent.mobileqq.vas;

import VipRecommend.MQQ.CommPayInfo;
import VipRecommend.MQQ.UserInfo;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.mobileqq.app.ClubContentUpdateHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.VIPRecommendPayHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import weq;

public class IndividuationManager
  implements Manager
{
  public static final int a = 3600000;
  public static final String a = "IndividuationManager";
  public static final int b = 3600000;
  public static final String b = "mvip.gexinghua.android.zbcenter_qianbao";
  public static final String c = "mvip.gexinghua.android.zbcenter_h5";
  public static final String d = "mvip.gexinghua.android.zbcenter_h5recall";
  public static final String e = "http://i.gtimg.cn/qqshow/admindata/comdata/vipList_dressup_data/xydata.v4.json";
  public static final String f = "IndividuationMainpageConfig4.json";
  public static final String g = "IndividuationConfigJsonVersion4";
  public static final String h = "individuation_mainpage_config2";
  public static final String i = "VIPRecommendPayFile.txt";
  public static final String j = "sp_individuation_mainpage2";
  public static final String k = "individuationLastJsonTimeSpKey";
  public static final String l = "individuationLastVIPRecommendSpKey";
  public static final String m = "sp_key_last_festival_animation_zip_url";
  public static final String n = "IndividuationAnimation";
  public static final String o = "individuationIsForcePullSpKey";
  public QQAppInterface a;
  public IndividuationConfigInfo a;
  public IndividuationManager.IndividUpdateLisener a;
  DownloadListener a;
  private String p;
  private String q;
  
  public IndividuationManager(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.p = "";
    this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new weq(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.p = paramQQAppInterface.a();
    "insertPluginsArray".hashCode();
  }
  
  /* Error */
  private String b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 102	com/tencent/mobileqq/vas/IndividuationManager:q	Ljava/lang/String;
    //   6: invokestatic 108	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifne +12 -> 21
    //   12: aload_0
    //   13: getfield 102	com/tencent/mobileqq/vas/IndividuationManager:q	Ljava/lang/String;
    //   16: astore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_1
    //   20: areturn
    //   21: aload_0
    //   22: getfield 84	com/tencent/mobileqq/vas/IndividuationManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   25: invokevirtual 112	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   28: pop
    //   29: new 114	java/io/File
    //   32: dup
    //   33: invokestatic 120	mqq/app/MobileQQ:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   36: invokevirtual 126	com/tencent/qphone/base/util/BaseApplication:getFilesDir	()Ljava/io/File;
    //   39: ldc 27
    //   41: invokespecial 129	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   44: astore_1
    //   45: aload_1
    //   46: ifnull +18 -> 64
    //   49: aload_1
    //   50: invokevirtual 133	java/io/File:exists	()Z
    //   53: ifeq +11 -> 64
    //   56: aload_0
    //   57: aload_1
    //   58: invokestatic 138	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/io/File;)Ljava/lang/String;
    //   61: putfield 102	com/tencent/mobileqq/vas/IndividuationManager:q	Ljava/lang/String;
    //   64: aload_0
    //   65: getfield 102	com/tencent/mobileqq/vas/IndividuationManager:q	Ljava/lang/String;
    //   68: astore_1
    //   69: goto -52 -> 17
    //   72: astore_1
    //   73: aload_1
    //   74: invokevirtual 141	java/io/IOException:printStackTrace	()V
    //   77: aload_0
    //   78: ldc 73
    //   80: putfield 102	com/tencent/mobileqq/vas/IndividuationManager:q	Ljava/lang/String;
    //   83: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   86: ifeq -22 -> 64
    //   89: ldc 12
    //   91: iconst_2
    //   92: ldc -108
    //   94: invokestatic 151	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   97: goto -33 -> 64
    //   100: astore_1
    //   101: aload_0
    //   102: monitorexit
    //   103: aload_1
    //   104: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	this	IndividuationManager
    //   16	53	1	localObject1	Object
    //   72	2	1	localIOException	java.io.IOException
    //   100	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   49	64	72	java/io/IOException
    //   2	17	100	finally
    //   21	45	100	finally
    //   49	64	100	finally
    //   64	69	100	finally
    //   73	97	100	finally
  }
  
  private boolean b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication();
    File localFile = new File(MobileQQ.getContext().getFilesDir(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "_" + "VIPRecommendPayFile.txt");
    return (localFile != null) && (localFile.exists());
  }
  
  public CommPayInfo a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
    {
      QLog.e("IndividuationManager", 1, "getLocalVIPRecommendInfo : app empty");
      return null;
    }
    Object localObject = FileUtils.a(this.p + "_" + "VIPRecommendPayFile.txt");
    if (localObject != null) {}
    for (localObject = (CommPayInfo)localObject;; localObject = null) {
      return (CommPayInfo)localObject;
    }
  }
  
  /* Error */
  public IndividuationConfigInfo a(boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +28 -> 35
    //   10: ldc 12
    //   12: iconst_2
    //   13: new 153	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   20: ldc -80
    //   22: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: iload_1
    //   26: invokevirtual 179	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   29: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 151	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   35: iload_1
    //   36: ifne +19 -> 55
    //   39: aload_0
    //   40: getfield 181	com/tencent/mobileqq/vas/IndividuationManager:jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo	Lcom/tencent/mobileqq/vas/IndividuationConfigInfo;
    //   43: ifnull +12 -> 55
    //   46: aload_0
    //   47: getfield 181	com/tencent/mobileqq/vas/IndividuationManager:jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo	Lcom/tencent/mobileqq/vas/IndividuationConfigInfo;
    //   50: astore_2
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_2
    //   54: areturn
    //   55: iload_1
    //   56: ifeq +8 -> 64
    //   59: aload_0
    //   60: aconst_null
    //   61: putfield 102	com/tencent/mobileqq/vas/IndividuationManager:q	Ljava/lang/String;
    //   64: aload_0
    //   65: invokespecial 183	com/tencent/mobileqq/vas/IndividuationManager:b	()Ljava/lang/String;
    //   68: astore 4
    //   70: aload_3
    //   71: astore_2
    //   72: aload 4
    //   74: ifnull -23 -> 51
    //   77: aload_3
    //   78: astore_2
    //   79: ldc 73
    //   81: aload 4
    //   83: invokevirtual 187	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   86: ifne -35 -> 51
    //   89: aload_0
    //   90: aload_0
    //   91: getfield 84	com/tencent/mobileqq/vas/IndividuationManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   94: aload 4
    //   96: invokestatic 192	com/tencent/mobileqq/vas/IndividuationConfigInfo:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Lcom/tencent/mobileqq/vas/IndividuationConfigInfo;
    //   99: putfield 181	com/tencent/mobileqq/vas/IndividuationManager:jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo	Lcom/tencent/mobileqq/vas/IndividuationConfigInfo;
    //   102: aload_0
    //   103: getfield 181	com/tencent/mobileqq/vas/IndividuationManager:jdField_a_of_type_ComTencentMobileqqVasIndividuationConfigInfo	Lcom/tencent/mobileqq/vas/IndividuationConfigInfo;
    //   106: astore_2
    //   107: goto -56 -> 51
    //   110: astore_2
    //   111: aload_0
    //   112: monitorexit
    //   113: aload_2
    //   114: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	this	IndividuationManager
    //   0	115	1	paramBoolean	boolean
    //   50	57	2	localObject1	Object
    //   110	4	2	localObject2	Object
    //   1	77	3	localObject3	Object
    //   68	27	4	str	String
    // Exception table:
    //   from	to	target	type
    //   4	35	110	finally
    //   39	51	110	finally
    //   59	64	110	finally
    //   64	70	110	finally
    //   79	107	110	finally
  }
  
  public String a()
  {
    try
    {
      InetAddress localInetAddress;
      do
      {
        localObject = NetworkInterface.getNetworkInterfaces();
        Enumeration localEnumeration;
        while (!localEnumeration.hasMoreElements())
        {
          if (!((Enumeration)localObject).hasMoreElements()) {
            break;
          }
          localEnumeration = ((NetworkInterface)((Enumeration)localObject).nextElement()).getInetAddresses();
        }
        localInetAddress = (InetAddress)localEnumeration.nextElement();
      } while (localInetAddress.isLoopbackAddress());
      Object localObject = localInetAddress.getHostAddress().toString();
      return (String)localObject;
    }
    catch (SocketException localSocketException)
    {
      return "";
    }
    return "";
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVasIndividuationManager$IndividUpdateLisener != null) {
      this.jdField_a_of_type_ComTencentMobileqqVasIndividuationManager$IndividUpdateLisener = null;
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      QLog.e("IndividuationManager", 1, "downloadJSON, app null");
    }
    do
    {
      return;
      Object localObject = (DownloaderFactory)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46);
      if (localObject == null)
      {
        QLog.e("IndividuationManager", 1, "downloadJSON, downloaderFactory null");
        return;
      }
      localObject = ((DownloaderFactory)localObject).a(1);
      if (localObject == null)
      {
        QLog.e("IndividuationManager", 1, "downloadJSON, downloader null");
        return;
      }
      if (((DownloaderInterface)localObject).a("http://i.gtimg.cn/qqshow/admindata/comdata/vipList_dressup_data/xydata.v4.json") != null)
      {
        QLog.e("IndividuationManager", 1, "downloadJSON, already downloading");
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication();
      DownloadTask localDownloadTask = new DownloadTask("http://i.gtimg.cn/qqshow/admindata/comdata/vipList_dressup_data/xydata.v4.json", new File(MobileQQ.getContext().getFilesDir(), "IndividuationMainpageConfig4.json"));
      localDownloadTask.b = true;
      Bundle localBundle = new Bundle();
      localBundle.putInt("jsonVersion", paramInt);
      ((DownloaderInterface)localObject).a(localDownloadTask, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, localBundle);
    } while (!QLog.isColorLevel());
    QLog.d("IndividuationManager", 2, "startdownload json");
  }
  
  public void a(IndividuationManager.IndividUpdateLisener paramIndividUpdateLisener)
  {
    this.jdField_a_of_type_ComTencentMobileqqVasIndividuationManager$IndividUpdateLisener = paramIndividUpdateLisener;
  }
  
  public boolean a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication();
    File localFile = new File(MobileQQ.getContext().getFilesDir(), "IndividuationMainpageConfig4.json");
    return (localFile != null) && (localFile.exists());
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    SharedPreferences localSharedPreferences;
    long l1;
    boolean bool;
    do
    {
      return;
      localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("sp_individuation_mainpage2", 0);
      l1 = localSharedPreferences.getLong("individuationLastJsonTimeSpKey", 0L);
      bool = a();
      if (QLog.isColorLevel()) {
        QLog.d("IndividuationManager", 2, "sendCheckUpdateReq, lastRequestTime=" + l1 + ", isLocalJsonFileExist=" + bool + ", AppSetting.isDebugVersion=" + false);
      }
    } while ((System.currentTimeMillis() - l1 <= 3600000L) && (bool));
    if (!bool) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("clubContentVersion", 0).edit().remove("IndividuationConfigJsonVersion4").commit();
    }
    ClubContentUpdateHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    localSharedPreferences.edit().putLong("individuationLastJsonTimeSpKey", System.currentTimeMillis()).commit();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    SharedPreferences localSharedPreferences;
    long l1;
    boolean bool;
    do
    {
      return;
      localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("sp_individuation_mainpage2", 0);
      l1 = localSharedPreferences.getLong("individuationLastVIPRecommendSpKey", 0L);
      bool = b();
    } while ((System.currentTimeMillis() - l1 <= 3600000L) && (bool));
    d();
    localSharedPreferences.edit().putLong("individuationLastVIPRecommendSpKey", System.currentTimeMillis()).commit();
  }
  
  public void d()
  {
    UserInfo localUserInfo = new UserInfo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "android", a(), "mvip.gexinghua.android.zbcenter_qianbao", "6.5.5", 0, "");
    ((VIPRecommendPayHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(73)).a(localUserInfo);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vas\IndividuationManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */