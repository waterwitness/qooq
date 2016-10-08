package com.tencent.mobileqq.pic;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.FlashPicHelper;
import com.tencent.mobileqq.app.HotChatHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.ChatImageDownloader;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.ActionMsgUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakUtils;
import java.io.File;
import java.net.URL;
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
import tsx;
import tsy;
import tsz;
import tta;
import ttb;
import ttc;
import ttd;
import tte;

public class PicPreDownloader
  implements Manager
{
  public static final int a = 1;
  public static boolean a = false;
  public static final int b = 2;
  public static boolean b = false;
  public static final int c = 3;
  public static final int d = 0;
  public static final int e = 1;
  public static final int f = 2;
  public static final int g = 3;
  static final int h = 1;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  public QQAppInterface a;
  PicStatisticsManager jdField_a_of_type_ComTencentMobileqqPicPicStatisticsManager;
  public PreDownloadStrategyBeta a;
  public List a;
  public Map a;
  Timer jdField_a_of_type_JavaUtilTimer;
  PriorityBlockingQueue jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue = new PriorityBlockingQueue();
  public AtomicBoolean a;
  public AtomicInteger a;
  public List b;
  public PriorityBlockingQueue b;
  public List c = Collections.synchronizedList(new LinkedList());
  public List d = Collections.synchronizedList(new LinkedList());
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_Boolean = true;
  }
  
  public PicPreDownloader(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_JavaUtilConcurrentPriorityBlockingQueue = new PriorityBlockingQueue();
    this.jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new HashMap());
    this.jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new LinkedList());
    this.jdField_b_of_type_JavaUtilList = Collections.synchronizedList(new LinkedList());
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    localIntentFilter.addAction("android.intent.action.SCREEN_ON");
    localIntentFilter.addAction("android.intent.action.USER_PRESENT");
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new tte(paramQQAppInterface.a());
    paramQQAppInterface.a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    this.jdField_a_of_type_ComTencentMobileqqPicPreDownloadStrategyBeta = new PreDownloadStrategyBeta();
    DeviceProfileManager.a(this.jdField_a_of_type_ComTencentMobileqqPicPreDownloadStrategyBeta);
    ThreadManager.a(new tsx(this, paramQQAppInterface), 5, null, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPicPicStatisticsManager = ((PicStatisticsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(72));
    Logger.a("PIC_TAG_PRELOAD", "onInit", "Finished");
  }
  
  public int a(MessageForPic paramMessageForPic)
  {
    Integer localInteger = (Integer)this.jdField_a_of_type_JavaUtilMap.get(paramMessageForPic.uuid);
    if (localInteger == null) {
      return -1;
    }
    Collection localCollection = a(localInteger.intValue());
    if (localCollection != null) {
      try
      {
        Iterator localIterator = localCollection.iterator();
        while (localIterator.hasNext())
        {
          PicReq localPicReq = (PicReq)localIterator.next();
          if (paramMessageForPic.subMsgId == localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.i)
          {
            Logger.a("PIC_TAG_PRELOAD", "getPriority", "uuid: " + paramMessageForPic.uuid + " subMsgId: " + paramMessageForPic.subMsgId);
            int i = localInteger.intValue();
            return i;
          }
        }
      }
      finally {}
    }
    return -1;
  }
  
  PicReq a()
  {
    int i;
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      i = this.jdField_a_of_type_JavaUtilList.size();
      PicReq localPicReq1;
      if (i > 0)
      {
        Logger.a("PIC_TAG_PRELOAD", "getPicRequest", "get a pic request from AIORequests");
        localPicReq1 = (PicReq)this.jdField_a_of_type_JavaUtilList.get(i - 1);
        this.jdField_a_of_type_JavaUtilList.remove(i - 1);
        return localPicReq1;
      }
      synchronized (this.jdField_b_of_type_JavaUtilList)
      {
        i = this.jdField_b_of_type_JavaUtilList.size();
        if (i > 0)
        {
          Logger.a("PIC_TAG_PRELOAD", "getPicRequest", "get a pic request from C2CRequests");
          localPicReq1 = (PicReq)this.jdField_b_of_type_JavaUtilList.get(i - 1);
          this.jdField_b_of_type_JavaUtilList.remove(i - 1);
          return localPicReq1;
        }
      }
    }
    synchronized (this.c)
    {
      i = this.c.size();
      if (i > 0)
      {
        Logger.a("PIC_TAG_PRELOAD", "getPicRequest", "get a pic request from DiscussionRequests");
        PicReq localPicReq2 = (PicReq)this.c.get(i - 1);
        this.c.remove(i - 1);
        return localPicReq2;
      }
    }
    synchronized (this.d)
    {
      i = this.d.size();
      if (i > 0)
      {
        Logger.a("PIC_TAG_PRELOAD", "getPicRequest", "get a pic request from GroupRequests");
        PicReq localPicReq3 = (PicReq)this.d.get(i - 1);
        this.d.remove(i - 1);
        return localPicReq3;
      }
    }
    Logger.a("PIC_TAG_PRELOAD", "getPicRequest", "cannot get any request");
    return null;
  }
  
  PicReq a(String paramString, Collection paramCollection)
  {
    for (;;)
    {
      try
      {
        Iterator localIterator = paramCollection.iterator();
        if (localIterator.hasNext())
        {
          PicReq localPicReq = (PicReq)localIterator.next();
          if (localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo == null) {
            continue;
          }
          if (localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_f_of_type_Int == 1)
          {
            bool = true;
            int i = URLDrawableHelper.a(localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.e, bool);
            String str = TransFileController.a(localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_f_of_type_JavaLangString, localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.g, i);
            if ((paramString == null) || (!paramString.equals(str))) {
              continue;
            }
            paramCollection.remove(localPicReq);
            this.jdField_a_of_type_JavaUtilMap.remove(localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.g);
            a(localPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic, -5);
            return localPicReq;
          }
        }
        else
        {
          return null;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  Collection a(int paramInt)
  {
    Logger.a("PIC_TAG_PRELOAD", "getRequestsByPriority", "priority=" + paramInt);
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
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    Logger.a("PIC_TAG_PRELOAD", "picPreDownloadOff", "mIsPicPreloadSuitable:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer.purge();
    }
    this.jdField_a_of_type_JavaUtilTimer = new Timer();
    this.jdField_a_of_type_JavaUtilTimer.schedule(new tsy(this), 60000L);
  }
  
  void a(MessageForPic paramMessageForPic)
  {
    if (paramMessageForPic.hasThumbFile()) {}
    PicReq localPicReq;
    for (;;)
    {
      return;
      if ((ActionMsgUtil.a(paramMessageForPic.msgtype)) || (paramMessageForPic.msgtype == 62535) || (paramMessageForPic.msgtype == 35534) || (paramMessageForPic.msgtype == 35533)) {}
      for (int i = 1; i == 0; i = 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqPicPicStatisticsManager.a(paramMessageForPic);
        localPicReq = PicBusiManager.a(5, 1536, 2);
        PicDownloadInfo localPicDownloadInfo = paramMessageForPic.getPicDownloadInfo();
        if (localPicDownloadInfo != null) {
          localPicDownloadInfo.j = 1;
        }
        localPicReq.a(paramMessageForPic, localPicDownloadInfo);
        i = PicPreDownloadUtils.a();
        if ((jdField_a_of_type_Boolean) || (i == 0)) {
          break label155;
        }
        Logger.a("PIC_TAG_PRELOAD", "screenOFF", "no preDownload,networkType:" + i);
        this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.add(localPicReq);
        return;
      }
    }
    label155:
    ThreadManager.a(new ttb(this, localPicReq), 5, null, false);
    Logger.a("PIC_TAG_PRELOAD", "run picreq thumb", "uniseq:" + paramMessageForPic.uniseq + ",subMsgId:" + paramMessageForPic.subMsgId);
  }
  
  public void a(MessageForPic paramMessageForPic, int paramInt)
  {
    a(paramMessageForPic);
    if ((BaseStrategy.h != 2L) && (BaseStrategy.h != 0L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD", 2, "productFromAIO(): PicAuDownTimePoint is not DOWNLOAD_POINT_AIO or DOWNLOAD_POINT_ALL");
      }
      a(paramMessageForPic, -2);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PIC_TAG_PRELOAD", 2, "productFromAIO(): ");
    }
    a(paramMessageForPic, paramInt, 5);
  }
  
  void a(MessageForPic paramMessageForPic, int paramInt1, int paramInt2)
  {
    ThreadManager.a(new tsz(this, paramMessageForPic, paramInt1, paramInt2), 5, null, false);
  }
  
  public void a(MessageForPic paramMessageForPic, long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPicPreDownloadStrategyBeta instanceof PreDownloadStrategyBeta)) {
      this.jdField_a_of_type_ComTencentMobileqqPicPreDownloadStrategyBeta.a(paramMessageForPic, paramLong);
    }
  }
  
  void a(MessageRecord paramMessageRecord)
  {
    int i = PicPreDownloadUtils.a();
    Logger.a("PIC_TAG_PRELOAD", "setMessageRecordNetworkType", "network=" + i);
    if ((paramMessageRecord instanceof MessageForPic)) {
      ((MessageForPic)paramMessageRecord).preDownNetworkType = i;
    }
    for (;;)
    {
      return;
      if ((paramMessageRecord instanceof MessageForMixedMsg))
      {
        paramMessageRecord = ((MessageForMixedMsg)paramMessageRecord).msgElemList.iterator();
        while (paramMessageRecord.hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)paramMessageRecord.next();
          if ((localMessageRecord instanceof MessageForPic)) {
            ((MessageForPic)localMessageRecord).preDownNetworkType = i;
          }
        }
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord, int paramInt)
  {
    Logger.a("PIC_TAG_PRELOAD", "setNotPredownloadReason", "Reson=" + paramInt);
    if ((paramMessageRecord instanceof MessageForPic)) {
      ((MessageForPic)paramMessageRecord).mNotPredownloadReason = paramInt;
    }
    for (;;)
    {
      return;
      if ((paramMessageRecord instanceof MessageForMixedMsg))
      {
        paramMessageRecord = ((MessageForMixedMsg)paramMessageRecord).msgElemList.iterator();
        while (paramMessageRecord.hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)paramMessageRecord.next();
          if ((localMessageRecord instanceof MessageForPic)) {
            ((MessageForPic)localMessageRecord).mNotPredownloadReason = paramInt;
          }
        }
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord, int paramInt1, int paramInt2)
  {
    if ((paramMessageRecord instanceof MessageForPic)) {
      b((MessageForPic)paramMessageRecord, paramInt1, paramInt2);
    }
    for (;;)
    {
      return;
      if ((paramMessageRecord instanceof MessageForMixedMsg))
      {
        paramMessageRecord = (MessageForMixedMsg)paramMessageRecord;
        int i = 0;
        while (i < paramMessageRecord.msgElemList.size())
        {
          MessageRecord localMessageRecord = (MessageRecord)paramMessageRecord.msgElemList.get(i);
          if ((localMessageRecord instanceof MessageForPic))
          {
            MessageForPic localMessageForPic = (MessageForPic)localMessageRecord;
            if (localMessageForPic.time == 0L) {
              MessageForMixedMsg.copyBaseInfoFromMixedToPic((MessageForPic)localMessageRecord, paramMessageRecord);
            }
            b(localMessageForPic, paramInt1, paramInt2);
          }
          i += 1;
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    PicReq localPicReq = a(paramString, this.jdField_a_of_type_JavaUtilList);
    if (localPicReq != null)
    {
      Logger.a("PIC_TAG_PRELOAD", "", "drop", "From AIORequests, uniseq:" + localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.a + ",key:" + paramString + ",cmd:" + localPicReq.n);
      return;
    }
    localPicReq = a(paramString, this.jdField_b_of_type_JavaUtilList);
    if (localPicReq != null)
    {
      Logger.a("PIC_TAG_PRELOAD", "", "drop", "From AIORequests, uniseq:" + localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.a + ",key:" + paramString + ",cmd:" + localPicReq.n);
      return;
    }
    localPicReq = a(paramString, this.c);
    if (localPicReq != null)
    {
      Logger.a("PIC_TAG_PRELOAD", "", "drop", "From AIORequests, uniseq:" + localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.a + ",key:" + paramString + ",cmd:" + localPicReq.n);
      return;
    }
    localPicReq = a(paramString, this.d);
    if (localPicReq != null)
    {
      Logger.a("PIC_TAG_PRELOAD", "", "drop", "From AIORequests, uniseq:" + localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.a + ",key:" + paramString + ",cmd:" + localPicReq.n);
      return;
    }
    Logger.a("PIC_TAG_PRELOAD", "", "drop", "Cannot be found in the request stacks");
  }
  
  public boolean a()
  {
    boolean bool1 = false;
    boolean bool2 = SettingCloneUtil.readValue(BaseApplication.getContext(), null, BaseApplication.getContext().getString(2131367826), "qqsetting_auto_receive_pic_key", true);
    if ((NetworkUtil.b(BaseApplication.getContext()) == 1) || (bool2)) {}
    for (int i = 1;; i = 0)
    {
      if (("1".equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ServerConfigManager.ConfigType.common, "UseLocalFlowSet"))) || (i != 0)) {
        bool1 = true;
      }
      return bool1;
    }
  }
  
  boolean a(MessageForPic paramMessageForPic, int paramInt)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    Integer localInteger = (Integer)this.jdField_a_of_type_JavaUtilMap.get(paramMessageForPic.uuid);
    if (localInteger == null)
    {
      Logger.a("PIC_TAG_PRELOAD", "filter", "uuid=" + paramMessageForPic.uuid + ", priority=" + paramInt + ", cannot be found in the PriorityMap");
      return bool2;
    }
    Collection localCollection = a(localInteger.intValue());
    Logger.a("PIC_TAG_PRELOAD", "filter", "priority: " + paramInt + ", uniseq: " + paramMessageForPic.uniseq + ", subMsgId:" + paramMessageForPic.subMsgId);
    if (localCollection == null)
    {
      Logger.a("PIC_TAG_PRELOAD", "filter", "originalRequests == null");
      return false;
    }
    Object localObject1 = null;
    label338:
    for (;;)
    {
      try
      {
        Iterator localIterator = localCollection.iterator();
        if (localIterator.hasNext())
        {
          localObject2 = (PicReq)localIterator.next();
          if (paramMessageForPic.subMsgId != ((PicReq)localObject2).jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.i) {
            break label338;
          }
          bool1 = true;
          localObject1 = localObject2;
          break label338;
        }
        if ((!bool1) || (paramInt <= localInteger.intValue()))
        {
          Logger.a("PIC_TAG_PRELOAD", "filter", "No need to update the picReq");
          return bool1;
        }
      }
      finally {}
      Object localObject2 = a(paramInt);
      bool2 = bool1;
      if (localObject2 == null) {
        break;
      }
      ((PicReq)localObject1).r = ((PicReq)localObject1).q;
      ((PicReq)localObject1).q = paramInt;
      localCollection.remove(localObject1);
      ((Collection)localObject2).add(localObject1);
      this.jdField_a_of_type_JavaUtilMap.put(paramMessageForPic.uuid, Integer.valueOf(paramInt));
      Logger.a("PIC_TAG_PRELOAD", "filter", "update the picReq");
      return bool1;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    Logger.a("PIC_TAG_PRELOAD", "picPreDownloadOn", "mIsPicPreloadSuitable:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
    f();
  }
  
  void b(MessageForPic paramMessageForPic, int paramInt1, int paramInt2)
  {
    if ((paramMessageForPic.path == null) && (paramMessageForPic.uuid == null) && (paramMessageForPic.md5 == null))
    {
      Logger.a("PIC_TAG_PRELOAD", "add", "pic.path == null && pic.uuid == null && pic.md5 == null");
      a(paramMessageForPic, -3);
      return;
    }
    if (paramMessageForPic.isSendFromLocal())
    {
      Logger.a("PIC_TAG_PRELOAD", "add", "MessageRecord isSendFromLocal");
      return;
    }
    Logger.a("PIC_TAG_PRELOAD", "add", "START uniseq:" + paramMessageForPic.uniseq + ",suMsgId:" + paramMessageForPic.subMsgId + ",priority:" + paramInt2);
    if (a(paramMessageForPic, paramInt2))
    {
      Logger.a("PIC_TAG_PRELOAD", "filter", "skip uniseq:" + paramMessageForPic.uniseq + ",suMsgId:" + paramMessageForPic.subMsgId + "priority:" + paramInt2);
      return;
    }
    int i;
    if ((paramMessageForPic.isMultiMsg) && (!paramMessageForPic.isSend()))
    {
      localObject = MultiMsgManager.a().a();
      if (localObject != null)
      {
        i = ((SessionInfo)localObject).jdField_a_of_type_Int;
        localObject = ((SessionInfo)localObject).jdField_a_of_type_JavaLangString;
      }
    }
    int j;
    int k;
    for (;;)
    {
      i = PicPreDownloadUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, (String)localObject);
      j = PicPreDownloadUtils.a();
      k = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b((String)localObject);
      if ((j == 0) || (k != 2)) {
        break;
      }
      Logger.a("PIC_TAG_PRELOAD", "add", "num group skip, uniseq:" + paramMessageForPic.uniseq + ",suMsgId:" + paramMessageForPic.subMsgId + "priority:" + paramInt2);
      return;
      i = paramMessageForPic.istroop;
      localObject = paramMessageForPic.frienduin;
      continue;
      i = paramMessageForPic.istroop;
      localObject = paramMessageForPic.frienduin;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqPicPreDownloadStrategyBeta.a(i, j);
    boolean bool;
    int m;
    if ((localObject[0] != 0) && ((paramInt1 & 0x1) == 1))
    {
      bool = true;
      m = localObject[1];
      Logger.a("PIC_TAG_PRELOAD", "add", "preDownThumb=" + bool + " preDownBig=" + m);
      if (bool) {
        a(paramMessageForPic);
      }
      if ((paramInt1 & 0x2) == 2)
      {
        if (k == 1) {
          break label521;
        }
        Logger.a("PIC_TAG_PRELOAD", "add", "The troop is not MSG_FILTER_VALUE.MSG_FILTER_OPEN");
        a(paramMessageForPic, -7);
      }
    }
    for (;;)
    {
      Logger.a("PIC_TAG_PRELOAD", "add", "FINISH uniseq:" + paramMessageForPic.uniseq + ",suMsgId:" + paramMessageForPic.subMsgId + ",priority:" + paramInt2);
      return;
      bool = false;
      break;
      label521:
      if (this.jdField_a_of_type_ComTencentMobileqqPicPreDownloadStrategyBeta.a(paramMessageForPic))
      {
        if ((b(paramMessageForPic, paramInt2)) && (m != 0)) {
          if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() < 1) {
            f();
          } else {
            Logger.a("PIC_TAG_PRELOAD", "add", "handlingNum.get() >= MAX_HANDLING_THREADS");
          }
        }
      }
      else {
        a(paramMessageForPic, -6);
      }
    }
  }
  
  public void b(MessageRecord paramMessageRecord, int paramInt)
  {
    a(paramMessageRecord);
    if (!a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD", 2, "productFromMsg(): cannot predownload");
      }
      a(paramMessageRecord, -1);
    }
    Object localObject;
    do
    {
      return;
      if ((BaseStrategy.h != 1L) && (BaseStrategy.h != 0L))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PIC_TAG_PRELOAD", 2, "productFromMsg(): PicAuDownTimePoint is not DOWNLOAD_POINT_MSG or DOWNLOAD_POINT_ALL");
        }
        a(paramMessageRecord, -2);
        return;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if ((!((QQMessageFacade)localObject).a()) || (!((QQMessageFacade)localObject).a().equals(paramMessageRecord.frienduin))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "The AIO is opening, does not need to predownload the thumb picture");
    return;
    if (QLog.isColorLevel()) {
      QLog.d("PIC_TAG_PRELOAD", 2, "productFromMsg(): ");
    }
    if ((paramMessageRecord instanceof MessageForPic))
    {
      localObject = (MessageForPic)paramMessageRecord;
      ((MessageForPic)localObject).getReportInfo().jdField_f_of_type_Int = PicPreDownloadUtils.a();
      ((MessageForPic)localObject).getReportInfo().a = System.currentTimeMillis();
      ((MessageForPic)localObject).getReportInfo().e = 0;
    }
    a(paramMessageRecord, paramInt, 1);
    ChatImageDownloader.a(paramMessageRecord);
  }
  
  boolean b(MessageForPic paramMessageForPic, int paramInt)
  {
    if (paramMessageForPic.hasBigFile())
    {
      Logger.a("PIC_TAG_PRELOAD", "addBigPicRequest", "hasBigFile, uniseq: " + paramMessageForPic.uniseq + ", priority: " + paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "try to download, but the big picture already exists");
      }
      PicPreDownloadUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPic);
    }
    do
    {
      return false;
      if (((!HotChatHelper.a(paramMessageForPic)) && (!FlashPicHelper.a(paramMessageForPic))) || (AbsDownloader.b(URLDrawableHelper.a(paramMessageForPic, 1, null).toString()) == null)) {
        break;
      }
      Logger.a("PIC_TAG_PRELOAD", "addBigPicRequest", "hasFlashPicFile, uniseq: " + paramMessageForPic.uniseq + ", priority: " + paramInt);
    } while (!QLog.isColorLevel());
    QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "try to download, but the picture already exists");
    return false;
    if (QLog.isColorLevel()) {
      QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "real download a big picture");
    }
    Logger.a("PIC_TAG_PRELOAD", "addBigPicRequest", " START uniseq: " + paramMessageForPic.uniseq + ", suMsgId: " + paramMessageForPic.subMsgId + ", priority:" + paramInt);
    int i;
    PicReq localPicReq;
    Object localObject;
    List localList;
    if (PicPreDownloadUtils.a() == 0)
    {
      i = 1536;
      localPicReq = PicBusiManager.a(6, i, 2);
      localObject = paramMessageForPic.getPicDownloadInfo();
      if (localObject != null)
      {
        ((PicDownloadInfo)localObject).j = 1;
        ((PicDownloadInfo)localObject).e = "chatimg";
      }
      localPicReq.a(paramMessageForPic, (PicDownloadInfo)localObject);
      localList = null;
      localObject = "";
      i = PicPreDownloadUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPic.istroop, paramMessageForPic.frienduin);
      if (paramInt != 5) {
        break label513;
      }
      localList = this.jdField_a_of_type_JavaUtilList;
      localPicReq.q = 5;
      localObject = "AIORequests";
      switch (i)
      {
      default: 
        localPicReq.r = 2;
      }
    }
    for (;;)
    {
      if (localList != null)
      {
        Logger.a("PIC_TAG_PRELOAD", "addBigPicRequest", "successfully to add the pic request to " + (String)localObject);
        localList.add(localPicReq);
        d();
        this.jdField_a_of_type_JavaUtilMap.put(localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.g, Integer.valueOf(localPicReq.q));
      }
      Logger.a("PIC_TAG_PRELOAD", "addBigPicRequest", "END uniseq: " + paramMessageForPic.uniseq + ", suMsgId: " + paramMessageForPic.subMsgId + ", priority: " + paramInt);
      return true;
      i = 1537;
      break;
      localPicReq.r = 4;
      continue;
      localPicReq.r = 3;
      continue;
      label513:
      if (paramInt == 1) {
        switch (i)
        {
        default: 
          localList = this.d;
          localPicReq.q = 2;
          localPicReq.r = localPicReq.q;
          localObject = "GroupRequests";
          break;
        case 3: 
          localList = this.jdField_b_of_type_JavaUtilList;
          localPicReq.q = 4;
          localPicReq.r = localPicReq.q;
          localObject = "C2CRequests";
          break;
        case 2: 
          localList = this.c;
          localPicReq.q = 3;
          localPicReq.r = localPicReq.q;
          localObject = "DiscussionRequests";
        }
      }
    }
  }
  
  public void c()
  {
    try
    {
      int i = this.jdField_a_of_type_JavaUtilList.size();
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD", 2, "clearAIORequests(): AIORequests size=" + i);
      }
      ThreadManager.a(new tta(this, i), 5, null, false);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("PIC_TAG_PRELOAD", 2, "clearAIORequests(): exception=" + localException.getMessage());
    }
  }
  
  void d()
  {
    Object localObject1;
    if (this.jdField_a_of_type_JavaUtilList.size() + this.jdField_b_of_type_JavaUtilList.size() + this.c.size() + this.d.size() > this.jdField_a_of_type_ComTencentMobileqqPicPreDownloadStrategyBeta.jdField_a_of_type_Int) {
      localObject1 = null;
    }
    for (;;)
    {
      synchronized (this.d)
      {
        if (this.d.size() > 0)
        {
          localObject1 = (PicReq)this.d.remove(0);
          if (localObject1 != null)
          {
            this.jdField_a_of_type_JavaUtilMap.remove(((PicReq)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.g);
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqPicPreDownloadStrategyBeta;
            ((PreDownloadStrategyBeta)localObject1).T += 1L;
            Logger.a("PIC_TAG_PRELOAD", "checkRequestListSize", "over max request list size: " + this.jdField_a_of_type_ComTencentMobileqqPicPreDownloadStrategyBeta.jdField_a_of_type_Int + ", remove a request");
          }
          return;
        }
        synchronized (this.c)
        {
          if (this.c.size() > 0) {
            localObject1 = (PicReq)this.c.remove(0);
          }
        }
      }
      synchronized (this.jdField_b_of_type_JavaUtilList)
      {
        if (this.jdField_b_of_type_JavaUtilList.size() > 0) {
          PicReq localPicReq1 = (PicReq)this.jdField_b_of_type_JavaUtilList.remove(0);
        }
      }
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        if (this.jdField_a_of_type_JavaUtilList.size() > 0) {
          PicReq localPicReq2 = (PicReq)this.jdField_a_of_type_JavaUtilList.remove(0);
        }
      }
    }
  }
  
  public void e()
  {
    Logger.a("PIC_TAG_PRELOAD", "consumeThumb", "START");
    int i = PicPreDownloadUtils.a();
    if ((!jdField_a_of_type_Boolean) && (i != 0))
    {
      Logger.a("PIC_TAG_PRELOAD", "screenOFF", "no preDownload,networkType:" + i);
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.iterator();
    if (localIterator.hasNext())
    {
      localObject = (PicReq)localIterator.next();
      ThreadManager.a(new ttc(this, (PicReq)localObject), 5, null, false);
      if (((PicReq)localObject).jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo == null) {
        break label161;
      }
    }
    label161:
    for (Object localObject = "uniseq:" + ((PicReq)localObject).jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.a;; localObject = "")
    {
      Logger.a("PIC_TAG_PRELOAD", "run picreq thumb", (String)localObject);
      break;
      this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.clear();
      Logger.a("PIC_TAG_PRELOAD", "consumeThumb", "END");
      return;
    }
  }
  
  public void f()
  {
    Logger.a("PIC_TAG_PRELOAD", "consume", "START");
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      Logger.a("PIC_TAG_PRELOAD", "consume", "!mIsPicPreloadSuitable.get() failed");
    }
    int k;
    PicReq localPicReq;
    int i;
    int j;
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() >= 1)
        {
          Logger.a("PIC_TAG_PRELOAD", "consume", "handlingNum.get() >= MAX_HANDLING_THREADS");
          return;
        }
        k = PicPreDownloadUtils.a();
        if ((!jdField_a_of_type_Boolean) && (k != 0))
        {
          Logger.a("PIC_TAG_PRELOAD", "screenOFF", "no preDownload,networkType:" + k);
          return;
        }
        localPicReq = a();
        if (localPicReq == null) {
          break label708;
        }
        if (localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo == null)
        {
          Logger.b("PIC_TAG_PRELOAD", "consume", "picReq.downinfo == null");
          a(localPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic, -4);
          return;
        }
        this.jdField_a_of_type_JavaUtilMap.remove(localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.g);
        i = PicPreDownloadUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.b, localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.c);
        j = this.jdField_a_of_type_ComTencentMobileqqPicPreDownloadStrategyBeta.a(localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.d, i, k, PeakUtils.a(localPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.imageType));
        a(localPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic, j);
        if (j >= 0) {
          break;
        }
        Logger.a("PIC_TAG_PRELOAD", "consume", "overLimit and put request back to list, uinType=" + i + " networkType=" + k);
        localObject = a(localPicReq.q);
      } while (localObject == null);
      ((Collection)localObject).add(localPicReq);
      this.jdField_a_of_type_JavaUtilMap.put(localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.g, Integer.valueOf(localPicReq.q));
      d();
      return;
      if ((localPicReq.n != 6) || (this.jdField_a_of_type_ComTencentMobileqqPicPreDownloadStrategyBeta.a(i, k)[1] != 0)) {
        break;
      }
      Logger.a("PIC_TAG_PRELOAD", "consume", "Network changed, put the picReq back to list, uintype:" + localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.b + ", networkType:" + k + ", uniseq:" + localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.a);
      localObject = a(localPicReq.q);
    } while (localObject == null);
    ((Collection)localObject).add(localPicReq);
    this.jdField_a_of_type_JavaUtilMap.put(localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.g, Integer.valueOf(localPicReq.q));
    d();
    return;
    this.jdField_b_of_type_JavaUtilConcurrentPriorityBlockingQueue.add(localPicReq);
    localPicReq.r = localPicReq.q;
    localPicReq.q = 6;
    this.jdField_a_of_type_JavaUtilMap.put(localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.g, Integer.valueOf(6));
    if (localPicReq.n == 6) {}
    for (Object localObject = " big";; localObject = " thumb")
    {
      Logger.a("PIC_TAG_PRELOAD", "run picreq" + (String)localObject, "uniseq:" + localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.a + "subMsgId:" + localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.i + ",priority:" + localPicReq.q);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
      if ((localPicReq.n == 6) && (!new File(localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.b()).exists()))
      {
        this.jdField_a_of_type_ComTencentMobileqqPicPreDownloadStrategyBeta.a(localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.d, k);
        j = Integer.MIN_VALUE;
        i = j;
        if (localPicReq != null)
        {
          i = j;
          if (localPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null) {
            i = PicPreDownloadUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.istroop, localPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.frienduin);
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqPicPicStatisticsManager.b(k, i);
      }
      ThreadManager.a(new ttd(this, localPicReq), 5, null, false);
      label708:
      Logger.a("PIC_TAG_PRELOAD", "consume", "END");
      return;
    }
  }
  
  public void onDestroy()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD", 2, "onDestroy, receiver:" + this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
      if (this.jdField_a_of_type_JavaUtilTimer != null)
      {
        this.jdField_a_of_type_JavaUtilTimer.cancel();
        this.jdField_a_of_type_JavaUtilTimer.purge();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PIC_TAG_PRELOAD", 2, localException.getMessage());
        }
        localException.printStackTrace();
      }
    }
    DeviceProfileManager.b(this.jdField_a_of_type_ComTencentMobileqqPicPreDownloadStrategyBeta);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\pic\PicPreDownloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */