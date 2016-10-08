package com.tencent.mobileqq.shortvideo;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicPreDownloadUtils;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.manager.Manager;
import mqq.manager.ServerConfigManager.ConfigType;
import uqf;
import uqg;
import uqh;
import uqi;
import uqj;

public class ShortVideoPreDownloader
  implements Manager
{
  static final int jdField_a_of_type_Int = 1;
  static long jdField_a_of_type_Long = 86400000L;
  static final String jdField_a_of_type_JavaLangString;
  static final int jdField_b_of_type_Int = 2;
  public static final String b = "shortvideo_predownload_strategy";
  static final int jdField_c_of_type_Int = 3;
  static final int jdField_d_of_type_Int = 4;
  static final int e = 5;
  static final int f = 6;
  static final int g = 1;
  public QQAppInterface a;
  UiCallBack jdField_a_of_type_ComTencentMobileqqShortvideoUiCallBack;
  List jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new LinkedList());
  public Map a;
  Timer jdField_a_of_type_JavaUtilTimer;
  public PriorityBlockingQueue a;
  public AtomicBoolean a;
  public AtomicInteger a;
  List jdField_b_of_type_JavaUtilList = Collections.synchronizedList(new LinkedList());
  public PriorityBlockingQueue b;
  public AtomicInteger b;
  List jdField_c_of_type_JavaUtilList;
  List jdField_d_of_type_JavaUtilList;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = ShortVideoPreDownloader.class.getSimpleName();
  }
  
  public ShortVideoPreDownloader(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new HashMap());
    this.c = Collections.synchronizedList(new LinkedList());
    this.d = Collections.synchronizedList(new LinkedList());
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue = new PriorityBlockingQueue();
    this.jdField_b_of_type_JavaUtilConcurrentPriorityBlockingQueue = new PriorityBlockingQueue();
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoUiCallBack = new uqf(this);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      String str = paramString2;
      if (paramString2 == null) {
        str = "";
      }
      paramString1 = new StringBuilder().append(paramString1).append("(): ").append(str);
      QLog.d(jdField_a_of_type_JavaLangString, 2, paramString1.toString());
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, MessageForShortVideo paramMessageForShortVideo)
  {
    int i = PicPreDownloadUtils.a(paramQQAppInterface, paramMessageForShortVideo.istroop, paramMessageForShortVideo.frienduin);
    if ((i == 0) || (i == 1))
    {
      int j = paramQQAppInterface.b(paramMessageForShortVideo.frienduin);
      if ((j == 2) || (j == 3) || (j == 4)) {
        return false;
      }
    }
    if (i == 2)
    {
      DiscussionManager localDiscussionManager = (DiscussionManager)paramQQAppInterface.getManager(52);
      if (localDiscussionManager != null)
      {
        paramQQAppInterface = localDiscussionManager.a(paramMessageForShortVideo.frienduin, paramQQAppInterface.a());
        if ((paramQQAppInterface != null) && ((paramQQAppInterface.flag & 0x1) != 0)) {
          return false;
        }
      }
    }
    return true;
  }
  
  ShortVideoReq a()
  {
    int i;
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      i = this.jdField_a_of_type_JavaUtilList.size();
      ShortVideoReq localShortVideoReq1;
      if (i > 0)
      {
        a("getShortVideoRequest", "get a short video request from AIORequests");
        localShortVideoReq1 = (ShortVideoReq)this.jdField_a_of_type_JavaUtilList.get(i - 1);
        this.jdField_a_of_type_JavaUtilList.remove(i - 1);
        return localShortVideoReq1;
      }
      synchronized (this.jdField_b_of_type_JavaUtilList)
      {
        i = this.jdField_b_of_type_JavaUtilList.size();
        if (i > 0)
        {
          a("getShortVideoRequest", "get a short video request from C2CRequests");
          localShortVideoReq1 = (ShortVideoReq)this.jdField_b_of_type_JavaUtilList.get(i - 1);
          this.jdField_b_of_type_JavaUtilList.remove(i - 1);
          return localShortVideoReq1;
        }
      }
    }
    synchronized (this.c)
    {
      i = this.c.size();
      if (i > 0)
      {
        a("getShortVideoRequest", "get a short video request from DiscussionRequests");
        ShortVideoReq localShortVideoReq2 = (ShortVideoReq)this.c.get(i - 1);
        this.c.remove(i - 1);
        return localShortVideoReq2;
      }
    }
    synchronized (this.d)
    {
      i = this.d.size();
      if (i > 0)
      {
        a("getShortVideoRequest", "get a short video request from GroupRequests");
        ShortVideoReq localShortVideoReq3 = (ShortVideoReq)this.d.get(i - 1);
        this.d.remove(i - 1);
        return localShortVideoReq3;
      }
    }
    a("getShortVideoRequest", "cannot get any request");
    return null;
  }
  
  Collection a(int paramInt)
  {
    a("getRequestsByPriority", "priority=" + paramInt);
    switch (paramInt)
    {
    default: 
      return null;
    case 6: 
      return this.jdField_b_of_type_JavaUtilConcurrentPriorityBlockingQueue;
    case 5: 
      return this.jdField_a_of_type_JavaUtilList;
    case 4: 
      return this.jdField_b_of_type_JavaUtilList;
    case 3: 
      return this.c;
    }
    return this.d;
  }
  
  public void a()
  {
    a("off", "mIsPreDownloaderOpen=" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer.purge();
    }
    this.jdField_a_of_type_JavaUtilTimer = new Timer();
    this.jdField_a_of_type_JavaUtilTimer.schedule(new uqg(this), 60000L);
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo)
  {
    a("productFromMsg", "uniseq=" + paramMessageForShortVideo.uniseq + " md5=" + paramMessageForShortVideo.md5);
    boolean bool = a(paramMessageForShortVideo, false);
    if (bool) {
      a(paramMessageForShortVideo, 1);
    }
    if ((!bool) && (a(paramMessageForShortVideo))) {
      b(paramMessageForShortVideo);
    }
  }
  
  void a(MessageForShortVideo paramMessageForShortVideo, int paramInt)
  {
    a("add", "uniseq=" + paramMessageForShortVideo.uniseq + " md5=" + paramMessageForShortVideo.md5 + " priority=" + paramInt);
    if ((paramMessageForShortVideo.uuid == null) && (paramMessageForShortVideo.md5 == null))
    {
      a("add", "msg.uuid and md5 are null");
      return;
    }
    if (paramMessageForShortVideo.isSendFromLocal())
    {
      a("add", "MessageRecord isSendFromLocal");
      return;
    }
    if (a(paramMessageForShortVideo, paramInt))
    {
      a("add", "skip uniseq:" + paramMessageForShortVideo.uniseq + "priority:" + paramInt);
      return;
    }
    Object localObject;
    int i;
    if ((paramMessageForShortVideo.isMultiMsg) && (!paramMessageForShortVideo.isSend()))
    {
      localObject = MultiMsgManager.a().a();
      if (localObject != null)
      {
        i = ((SessionInfo)localObject).jdField_a_of_type_Int;
        localObject = ((SessionInfo)localObject).jdField_a_of_type_JavaLangString;
      }
    }
    for (;;)
    {
      i = PicPreDownloadUtils.a();
      int j = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b((String)localObject);
      if ((i == 0) || (j != 2)) {
        break;
      }
      a("add", "MSG_FILTER_NUM, no need to pre download short video");
      return;
      i = paramMessageForShortVideo.istroop;
      localObject = paramMessageForShortVideo.frienduin;
      continue;
      i = paramMessageForShortVideo.istroop;
      localObject = paramMessageForShortVideo.frienduin;
    }
    b(paramMessageForShortVideo, paramInt);
  }
  
  public void a(ShortVideoReq paramShortVideoReq)
  {
    ShortVideoBusiManager.a(paramShortVideoReq, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "launchRequest:" + paramShortVideoReq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.busiType);
    }
  }
  
  public boolean a(MessageForShortVideo paramMessageForShortVideo)
  {
    if (paramMessageForShortVideo.videoFileStatus == 5002) {
      a("isNeedPredownloadThumb", "short video has expired");
    }
    for (;;)
    {
      return false;
      if (System.currentTimeMillis() - paramMessageForShortVideo.time * 1000L > jdField_a_of_type_Long)
      {
        a("isNeedPredownloadThumb", "out of validity, no need to pre download");
        return false;
      }
      boolean bool = SettingCloneUtil.readValue(BaseApplication.getContext(), null, BaseApplication.getContext().getString(2131367826), "qqsetting_auto_receive_pic_key", true);
      if ((NetworkUtil.b(BaseApplication.getContext()) == 1) || (bool)) {}
      for (int i = 1; ("1".equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ServerConfigManager.ConfigType.common, "UseLocalFlowSet"))) || (i != 0); i = 0) {
        return true;
      }
    }
  }
  
  boolean a(MessageForShortVideo paramMessageForShortVideo, int paramInt)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    a("filter", "uuid=" + paramMessageForShortVideo.uuid + " uniseq=" + paramMessageForShortVideo.uniseq + " priority=" + paramInt);
    Integer localInteger = (Integer)this.jdField_a_of_type_JavaUtilMap.get(paramMessageForShortVideo.uuid);
    if (localInteger == null)
    {
      a("filter", "msg cannot be found in the PriorityMap");
      return bool2;
    }
    Collection localCollection = a(localInteger.intValue());
    if (localCollection == null)
    {
      a("filter", "originalRequests == null");
      return false;
    }
    Object localObject1 = null;
    label293:
    for (;;)
    {
      try
      {
        Iterator localIterator = localCollection.iterator();
        if (localIterator.hasNext())
        {
          localObject2 = (ShortVideoReq)localIterator.next();
          if (((ShortVideoReq)localObject2).jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoDownloadInfo.jdField_a_of_type_Long != paramMessageForShortVideo.uniseq) {
            break label293;
          }
          bool1 = true;
          localObject1 = localObject2;
          break label293;
        }
        if ((!bool1) || (paramInt <= localInteger.intValue()))
        {
          a("filter", "No need to update the short video request");
          return bool1;
        }
      }
      finally {}
      Object localObject2 = a(paramInt);
      bool2 = bool1;
      if (localObject2 == null) {
        break;
      }
      ((ShortVideoReq)localObject1).i = ((ShortVideoReq)localObject1).h;
      ((ShortVideoReq)localObject1).h = paramInt;
      localCollection.remove(localObject1);
      ((Collection)localObject2).add(localObject1);
      this.jdField_a_of_type_JavaUtilMap.put(paramMessageForShortVideo.uuid, Integer.valueOf(paramInt));
      a("filter", "Updated the short video request");
      return bool1;
    }
  }
  
  public boolean a(MessageForShortVideo paramMessageForShortVideo, boolean paramBoolean)
  {
    if (paramMessageForShortVideo.videoFileStatus == 5002)
    {
      a("isNeedPredownload", "short video has expired");
      return false;
    }
    if (paramMessageForShortVideo.busiType == 0) {}
    for (AtomicInteger localAtomicInteger = ShortVideoUtils.a(); (!paramBoolean) && (localAtomicInteger.get() == 1); localAtomicInteger = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger)
    {
      a("isNeedPredownload", "isFromAIO=false and mIsNotPreDownloadEvenWhenEnterAIO=true");
      return false;
    }
    if (localAtomicInteger.get() == 2)
    {
      a("isNeedPredownload", "mIsNotPreDownloadEvenWhenEnterAIO=true");
      return false;
    }
    if (System.currentTimeMillis() - paramMessageForShortVideo.time * 1000L > jdField_a_of_type_Long)
    {
      a("isNeedPredownload", "out of validity, no need to pre download");
      return false;
    }
    int i = PicPreDownloadUtils.a();
    if (i != 0)
    {
      a("isNeedPredownload", "Not Wifi, networkType=" + i + ", no need to predownload");
      return false;
    }
    return a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForShortVideo);
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    a("on", "ShortVideoPreDownloader is on, mIsPreDownloaderOpen=" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
    c();
  }
  
  void b(MessageForShortVideo paramMessageForShortVideo)
  {
    a("consumeShortVideoThumb", null);
    Object localObject = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
    if (FileUtils.b((String)localObject))
    {
      a("consumeShortVideoThumb", (String)localObject + " exists");
      return;
    }
    ShortVideoReq localShortVideoReq = ShortVideoBusiManager.a(2, paramMessageForShortVideo.busiType);
    ShortVideoDownloadInfo localShortVideoDownloadInfo = paramMessageForShortVideo.getDownloadInfo(localShortVideoReq.g);
    localShortVideoDownloadInfo.i = ((String)localObject);
    if (paramMessageForShortVideo.istroop == 0)
    {
      localShortVideoDownloadInfo.g = 1002;
      localShortVideoDownloadInfo.h = 2;
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if ((!((QQMessageFacade)localObject).a()) || (!((QQMessageFacade)localObject).a().equals(paramMessageForShortVideo.frienduin))) {
        break label236;
      }
    }
    label236:
    for (localShortVideoDownloadInfo.k = 2;; localShortVideoDownloadInfo.k = 1)
    {
      localShortVideoReq.a(localShortVideoDownloadInfo);
      localShortVideoReq.a(paramMessageForShortVideo);
      int i = PicPreDownloadUtils.a();
      if ((PicPreDownloader.a) || (i == 0)) {
        break label244;
      }
      a("consumeShortVideoThumb", "screenOFF, no preDownload, networkType: " + i);
      this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.add(localShortVideoReq);
      return;
      if (paramMessageForShortVideo.istroop == 3000)
      {
        localShortVideoDownloadInfo.g = 1006;
        break;
      }
      if (paramMessageForShortVideo.istroop != 1) {
        break;
      }
      localShortVideoDownloadInfo.g = 1004;
      break;
    }
    label244:
    ThreadManager.a(new uqh(this, localShortVideoDownloadInfo, paramMessageForShortVideo, localShortVideoReq), 5, null, false);
  }
  
  void b(MessageForShortVideo paramMessageForShortVideo, int paramInt)
  {
    a("handleShortVideo", " START uniseq=" + paramMessageForShortVideo.uniseq + ", uuid=" + paramMessageForShortVideo.uuid + ", priority=" + paramInt);
    Object localObject = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
    if (FileUtils.b((String)localObject)) {
      a("handleShortVideo", "Video has already existed, path=" + (String)localObject);
    }
    ShortVideoReq localShortVideoReq;
    do
    {
      return;
      localShortVideoReq = ShortVideoBusiManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForShortVideo, 2);
    } while (localShortVideoReq == null);
    localObject = null;
    String str = "";
    int i = PicPreDownloadUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForShortVideo.istroop, paramMessageForShortVideo.frienduin);
    if (paramInt == 5)
    {
      localObject = this.jdField_a_of_type_JavaUtilList;
      localShortVideoReq.h = 5;
      paramMessageForShortVideo = "AIORequests";
      switch (i)
      {
      default: 
        localShortVideoReq.i = 2;
      }
    }
    for (;;)
    {
      if (localObject != null)
      {
        a("handleShortVideo", "successfully to add the short video request to " + paramMessageForShortVideo);
        ((List)localObject).add(localShortVideoReq);
        this.jdField_a_of_type_JavaUtilMap.put(localShortVideoReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoDownloadInfo.jdField_a_of_type_JavaLangString, Integer.valueOf(localShortVideoReq.h));
      }
      paramInt = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
      if (paramInt >= 1) {
        break;
      }
      c();
      return;
      localShortVideoReq.i = 4;
      continue;
      localShortVideoReq.i = 3;
      continue;
      paramMessageForShortVideo = str;
      if (paramInt == 1) {
        switch (i)
        {
        default: 
          localObject = this.d;
          localShortVideoReq.h = 2;
          localShortVideoReq.i = localShortVideoReq.h;
          paramMessageForShortVideo = "GroupRequests";
          break;
        case 3: 
          localObject = this.jdField_b_of_type_JavaUtilList;
          localShortVideoReq.h = 4;
          localShortVideoReq.i = localShortVideoReq.h;
          paramMessageForShortVideo = "C2CRequests";
          break;
        case 2: 
          localObject = this.c;
          localShortVideoReq.h = 3;
          localShortVideoReq.i = localShortVideoReq.h;
          paramMessageForShortVideo = "DiscussionRequests";
        }
      }
    }
    a("handleShortVideo", "mHandlingNum(" + paramInt + ") >= MAX_HANDLING_THREADS(" + 1 + ")");
  }
  
  public void c()
  {
    a("consumeShortVideo", null);
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      Logger.a("PIC_TAG_PRELOAD", "consume", "!mIsPreDownloaderOpen.get() failed");
    }
    ShortVideoReq localShortVideoReq;
    do
    {
      return;
      int i = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
      if (i >= 1)
      {
        a("consumeShortVideo", "handlingNum(" + i + ") >= MAX_HANDLING_THREADS(" + 1 + ")");
        return;
      }
      localShortVideoReq = a();
    } while (localShortVideoReq == null);
    if (localShortVideoReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoDownloadInfo == null)
    {
      a("consumeShortVideo", "req.downinfo == null");
      return;
    }
    this.jdField_a_of_type_JavaUtilMap.remove(localShortVideoReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoDownloadInfo.jdField_a_of_type_JavaLangString);
    this.jdField_b_of_type_JavaUtilConcurrentPriorityBlockingQueue.add(localShortVideoReq);
    localShortVideoReq.i = localShortVideoReq.h;
    localShortVideoReq.h = 6;
    this.jdField_a_of_type_JavaUtilMap.put(localShortVideoReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoDownloadInfo.jdField_a_of_type_JavaLangString, Integer.valueOf(6));
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
    localShortVideoReq.jdField_a_of_type_ComTencentMobileqqShortvideoUiCallBack = this.jdField_a_of_type_ComTencentMobileqqShortvideoUiCallBack;
    ThreadManager.a(new uqi(this, localShortVideoReq), 5, null, false);
  }
  
  public void d()
  {
    a("consumeAllThumbsInPendingQueue", null);
    int i = PicPreDownloadUtils.a();
    if ((!PicPreDownloader.a) && (i != 0))
    {
      a("consumeAllThumbsInPendingQueue", "screenOFF, no preDownload, networkType: " + i);
      return;
    }
    ThreadManager.a(new uqj(this), 5, null, false);
  }
  
  public void onDestroy()
  {
    a("onDestroy", null);
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer.purge();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\ShortVideoPreDownloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */