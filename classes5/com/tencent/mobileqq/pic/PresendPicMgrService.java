package com.tencent.mobileqq.pic;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager.DpcAccountNames;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.BaseUploadProcessor;
import com.tencent.mobileqq.transfile.TranDbRecord.PicDbRecord;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.LogTag;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakUtils;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AccountNotMatchException;
import tti;

public class PresendPicMgrService
  extends IPresendPicMgr.Stub
{
  public static final long a = 209715200L;
  private static PresendPicMgrService jdField_a_of_type_ComTencentMobileqqPicPresendPicMgrService;
  public static final String a = "presend_lastDayTime";
  public static final long b = 157286400L;
  public static final String b = "presend_FlowWaste";
  public static final long c = 73400320L;
  private static final String jdField_c_of_type_JavaLangString = "PresendPicMgrService";
  public static final long d = 52428800L;
  private static final String jdField_d_of_type_JavaLangString = "1|1|1|1|1|1|1|1|104857600|104857600|104857600|104857600|0|90|70|50";
  public static final int h = 3;
  public static final int i = 4;
  static int jdField_j_of_type_Int = 0;
  private static final int jdField_k_of_type_Int = 1;
  private static final int l = 2;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean;
  private ArrayList jdField_b_of_type_JavaUtilArrayList;
  private boolean jdField_b_of_type_Boolean;
  private boolean jdField_c_of_type_Boolean;
  private boolean jdField_d_of_type_Boolean;
  private long jdField_e_of_type_Long;
  private String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean;
  private long jdField_f_of_type_Long;
  private String jdField_f_of_type_JavaLangString;
  private boolean jdField_f_of_type_Boolean;
  private long jdField_g_of_type_Long;
  private String jdField_g_of_type_JavaLangString;
  private boolean jdField_g_of_type_Boolean;
  private long jdField_h_of_type_Long;
  private boolean jdField_h_of_type_Boolean;
  private long jdField_i_of_type_Long;
  private boolean jdField_i_of_type_Boolean;
  private long jdField_j_of_type_Long;
  private boolean jdField_j_of_type_Boolean;
  private boolean jdField_k_of_type_Boolean;
  private int m;
  private int n;
  private int o;
  private int p;
  private int q;
  private int r;
  private int s;
  private int t;
  
  public PresendPicMgrService(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.b = new ArrayList();
    this.jdField_g_of_type_Long = 209715200L;
    this.jdField_h_of_type_Long = 157286400L;
    this.jdField_i_of_type_Long = 73400320L;
    this.jdField_j_of_type_Long = 52428800L;
    this.q = 90;
    this.r = 70;
    this.s = 50;
    this.t = paramInt;
    this.jdField_e_of_type_JavaLangString = paramString1;
    this.jdField_f_of_type_JavaLangString = paramString2;
    this.jdField_g_of_type_JavaLangString = paramString3;
    long l1 = PicPreDownloadUtils.a("presend_lastDayTime", 0L);
    long l2 = System.currentTimeMillis();
    Logger.a("PresendPicMgrService", "[@]PresendPicMgrService", "currentTime = " + l2 + ", lastDayTime = " + l1 + ", curFriendUin = " + paramString1 + ",troopUin = " + paramString2 + ",myUin = " + paramString3);
    d();
    if (l2 - l1 > 86400000L)
    {
      Logger.a("PresendPicMgrService", "PresendPicMgrService", "more than one day, clear wastesize");
      StatisticConstants.a(PicPreDownloadUtils.a("presend_FlowWaste", 0L));
      PicPreDownloadUtils.a("presend_lastDayTime", l2);
      PicPreDownloadUtils.a("presend_FlowWaste", 0L);
    }
    this.jdField_f_of_type_Long = PicPreDownloadUtils.a("presend_FlowWaste", 0L);
    jdField_a_of_type_ComTencentMobileqqPicPresendPicMgrService = this;
  }
  
  private PicReq a(ArrayList paramArrayList, String paramString)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return null;
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      PicReq localPicReq = (PicReq)paramArrayList.next();
      if (localPicReq.jdField_a_of_type_JavaLangString.equals(paramString)) {
        return localPicReq;
      }
    }
    return null;
  }
  
  private PicUploadInfo a(String paramString, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    Object localObject = new PicUploadInfo.Builder();
    Logger.a("PresendPicMgrService", "[@]buildPicUploadInfo", "curFriendUin = " + this.jdField_e_of_type_JavaLangString);
    ((PicUploadInfo.Builder)localObject).d(this.jdField_e_of_type_JavaLangString);
    ((PicUploadInfo.Builder)localObject).a(paramString);
    ((PicUploadInfo.Builder)localObject).e(this.t);
    ((PicUploadInfo.Builder)localObject).e(this.jdField_f_of_type_JavaLangString);
    ((PicUploadInfo.Builder)localObject).d(paramInt1);
    ((PicUploadInfo.Builder)localObject).i(0);
    ((PicUploadInfo.Builder)localObject).n(paramInt2);
    localObject = ((PicUploadInfo.Builder)localObject).a();
    ((PicUploadInfo)localObject).jdField_c_of_type_Boolean = true;
    if (PeakUtils.a(paramString)) {
      LogTag.a();
    }
    try
    {
      ((PicUploadInfo)localObject).jdField_a_of_type_JavaUtilArrayList = PeakUtils.a(paramString);
      if ((((PicUploadInfo)localObject).jdField_a_of_type_JavaUtilArrayList != null) && (QLog.isColorLevel())) {
        QLog.d("peak_pgjpeg", 2, "PresendPicMgrService.buildPicUploadInfo:" + ((PicUploadInfo)localObject).jdField_a_of_type_JavaUtilArrayList.toString());
      }
      LogTag.a("peak_pgjpeg", "PeakUtils.getSliceInfos(" + paramString + ")");
      if (paramBoolean)
      {
        ((PicUploadInfo)localObject).h = 1;
        Logger.a(localObject, "fixProtocolType", "sendReq.upInfo.protocolType");
        return (PicUploadInfo)localObject;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("peak_pgjpeg", 2, "OutOfMemoryError occurred in PeakUtils.getSliceInfos， " + paramString + "'s size is " + FileUtils.a(paramString));
        }
      }
      ((PicUploadInfo)localObject).h = ((PicUploadInfo)localObject).a();
    }
    return (PicUploadInfo)localObject;
  }
  
  public static PresendPicMgrService a()
  {
    return jdField_a_of_type_ComTencentMobileqqPicPresendPicMgrService;
  }
  
  private void a(long paramLong, int paramInt)
  {
    this.jdField_f_of_type_Long += paramLong;
    PicPreDownloadUtils.a("presend_FlowWaste", this.jdField_f_of_type_Long);
    StatisticConstants.a(paramLong, paramInt);
    Logger.a("PresendPicMgrService", "calcWasteFlow ", "PresendStatus:  wastesize = " + paramLong + ",mWastedUploadFlow = " + this.jdField_f_of_type_Long + ",cancelType = " + paramInt);
  }
  
  private void a(MessageForPic paramMessageForPic)
  {
    Logger.a("PresendPicMgrService", "reuploadPhoto", " ");
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.a.getAppRuntime(this.jdField_g_of_type_JavaLangString);
      localQQAppInterface.a().b(paramMessageForPic.frienduin, paramMessageForPic.istroop, paramMessageForPic.uniseq);
      if (paramMessageForPic.isSendFromLocal()) {
        localQQAppInterface.a().a(localQQAppInterface.a().a(paramMessageForPic.frienduin, paramMessageForPic.uniseq));
      }
      PicUploadInfo.Builder localBuilder = new PicUploadInfo.Builder();
      localBuilder.a(paramMessageForPic.path);
      localBuilder.d(5);
      localBuilder.d(paramMessageForPic.frienduin);
      if (paramMessageForPic.fileSizeFlag == 1) {
        localBuilder.c(TranDbRecord.PicDbRecord.f);
      }
      for (;;)
      {
        localBuilder.e(paramMessageForPic.senderuin);
        localBuilder.c(paramMessageForPic.selfuin);
        localBuilder.e(paramMessageForPic.istroop);
        localBuilder.j = paramMessageForPic.extLong;
        localBuilder.i = paramMessageForPic.extStr;
        PicUploadInfo.RetryInfo localRetryInfo = new PicUploadInfo.RetryInfo();
        localRetryInfo.a = paramMessageForPic.msgseq;
        localRetryInfo.b = paramMessageForPic.shmsgseq;
        localRetryInfo.a = paramMessageForPic.msgseq;
        localBuilder.a(localRetryInfo);
        paramMessageForPic = PicBusiManager.a(4, 5);
        paramMessageForPic.a(localBuilder.a());
        PicBusiManager.a(paramMessageForPic, localQQAppInterface);
        return;
        localBuilder.c(TranDbRecord.PicDbRecord.e);
      }
      return;
    }
    catch (AccountNotMatchException paramMessageForPic)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PresendPicMgrService", 2, "no appRuntime");
      }
    }
  }
  
  private void a(MessageRecord paramMessageRecord)
  {
    Logger.a("PresendPicMgrService", "addMsg", "MessageRecord = " + paramMessageRecord);
    try
    {
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.a.getAppRuntime(this.jdField_g_of_type_JavaLangString);
      ((SVIPHandler)localQQAppInterface.a(13)).a(paramMessageRecord);
      str = localQQAppInterface.a();
      if (TextUtils.isEmpty(str))
      {
        if (QLog.isColorLevel()) {
          QLog.e("PresendPicMgrService", 2, "[addMsg] empty current uin");
        }
      }
      else if ((PicItemBuilder.i == 1) || (PicItemBuilder.i == 2))
      {
        localQQAppInterface.a().b(paramMessageRecord, str);
        return;
      }
    }
    catch (AccountNotMatchException paramMessageRecord)
    {
      QQAppInterface localQQAppInterface;
      String str;
      if (QLog.isColorLevel())
      {
        QLog.d("PresendPicMgrService", 2, "no appRuntime");
        return;
        localQQAppInterface.a().a(paramMessageRecord, str);
      }
    }
  }
  
  private void a(PicReq paramPicReq, int paramInt)
  {
    synchronized (paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo)
    {
      paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.d = true;
      if (paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_JavaLangObject == null)
      {
        Logger.b("PresendPicMgrService", "doCancel", " req.upInfo.picExtraObject == null!");
        return;
      }
    }
    ??? = (MessageRecord)paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_JavaLangObject;
    for (;;)
    {
      BaseUploadProcessor localBaseUploadProcessor;
      long l1;
      try
      {
        localBaseUploadProcessor = (BaseUploadProcessor)((QQAppInterface)BaseApplicationImpl.a.getAppRuntime(this.jdField_g_of_type_JavaLangString)).a().a(((MessageRecord)???).frienduin, ((MessageRecord)???).uniseq);
        if (localBaseUploadProcessor != null) {
          break label234;
        }
        Logger.a("PresendPicMgrService", "doCancel", " processor == null!");
        l1 = ((MessageForPic)???).mPresendTransferedSize;
        long l2 = FileUtils.a(((MessageForPic)???).path);
        Logger.a("PresendPicMgrService", "doCancel", "picSize = " + l2);
        a(l1, paramInt);
        Logger.a("PresendPicMgrService", "doCancel ", "PresendStatus: Path:" + paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_g_of_type_JavaLangString + ",uuid:" + paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_JavaLangString + ",canceled:true, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:true");
        return;
      }
      catch (AccountNotMatchException paramPicReq) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("PresendPicMgrService", 2, "no appRuntime");
      return;
      label234:
      int i1 = b();
      if (localBaseUploadProcessor.g() < i1)
      {
        Logger.a("PresendPicMgrService", "doCancel", " processor upload less than cancelPercent:" + i1 + ", do cancel! ");
        localBaseUploadProcessor.b();
        l1 = localBaseUploadProcessor.b();
      }
      else
      {
        Logger.a("PresendPicMgrService", "doCancel", " processor upload more than cancelPercent:" + i1 + ", do not cancel!");
        l1 = localBaseUploadProcessor.a();
      }
    }
  }
  
  private int b()
  {
    int i1 = 0;
    int i2 = NetworkUtil.a(BaseApplication.getContext());
    switch (i2)
    {
    }
    for (;;)
    {
      Logger.a("PresendPicMgrService", "getCancelPercent", " NetType = " + i2 + ", cancelpercent = " + i1);
      return i1;
      i1 = this.p;
      continue;
      i1 = this.q;
      continue;
      i1 = this.r;
      continue;
      i1 = this.s;
    }
  }
  
  private boolean b()
  {
    boolean bool = true;
    int i1 = NetworkUtil.a(BaseApplication.getContext());
    switch (i1)
    {
    default: 
      bool = false;
    }
    for (;;)
    {
      Logger.a("PresendPicMgrService", "isOverWasteLimit", "PresendStatus : nettype = " + i1 + " result =  " + bool + ",mWastedUploadFlow = " + this.jdField_f_of_type_Long);
      return bool;
      if (this.jdField_f_of_type_Long <= this.jdField_g_of_type_Long) {
        break;
      }
      continue;
      if (this.jdField_f_of_type_Long <= this.jdField_j_of_type_Long) {
        break;
      }
      continue;
      if (this.jdField_f_of_type_Long <= this.jdField_i_of_type_Long) {
        break;
      }
      continue;
      if (this.jdField_f_of_type_Long <= this.jdField_h_of_type_Long) {
        break;
      }
    }
  }
  
  private void d()
  {
    Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.pic_presend.name());
    if (DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.picpredownload_whitelist.name()))
    {
      localObject = "1|1|1|1|1|1|1|1|104857600|104857600|104857600|104857600|0|90|70|50";
      Logger.a("PresendPicMgrService", "getServerConfig", "In VIP list, presendConfigString " + "1|1|1|1|1|1|1|1|104857600|104857600|104857600|104857600|0|90|70|50");
    }
    Logger.a("PresendPicMgrService", "getServerConfig", "presendConfigString = " + (String)localObject);
    if ((localObject != null) && (((String)localObject).length() > 0))
    {
      localObject = ((String)localObject).split("\\|");
      if (localObject.length >= 16)
      {
        this.jdField_c_of_type_Boolean = localObject[0].equals("1");
        this.d = localObject[1].equals("1");
        this.jdField_e_of_type_Boolean = localObject[2].equals("1");
        this.jdField_f_of_type_Boolean = localObject[3].equals("1");
        this.jdField_g_of_type_Boolean = localObject[4].equals("1");
        this.jdField_h_of_type_Boolean = localObject[5].equals("1");
        this.jdField_i_of_type_Boolean = localObject[6].equals("1");
        this.jdField_j_of_type_Boolean = localObject[7].equals("1");
      }
    }
    try
    {
      this.jdField_g_of_type_Long = Long.valueOf(localObject[8]).longValue();
      this.jdField_j_of_type_Long = Long.valueOf(localObject[9]).longValue();
      this.jdField_i_of_type_Long = Long.valueOf(localObject[10]).longValue();
      this.jdField_h_of_type_Long = Long.valueOf(localObject[11]).longValue();
      this.p = Integer.parseInt(localObject[12]);
      this.q = Integer.parseInt(localObject[13]);
      this.r = Integer.parseInt(localObject[14]);
      this.s = Integer.parseInt(localObject[15]);
      Logger.a("PresendPicMgrService", "getServerConfig", "mEnablePreCompress_WIFI = " + this.jdField_c_of_type_Boolean + "mEnablePreCompress_2G = " + this.d + "mEnablePreCompress_3G = " + this.jdField_e_of_type_Boolean + "mEnablePreCompress_4G = " + this.jdField_f_of_type_Boolean + "mEnablePreUpload_WIFI = " + this.jdField_g_of_type_Boolean + ",mEnablePreUpload_2G = " + this.jdField_h_of_type_Boolean + ",mEnablePreUpload_3G = " + this.jdField_i_of_type_Boolean + ",mEnablePreUpload_4G = " + this.jdField_j_of_type_Boolean + "mPreUpMaxWasteSizeWIFI = " + this.jdField_g_of_type_Long + ", mPreUpMaxWasteSize2G = " + this.jdField_j_of_type_Long + ",mPreUpMaxWasteSize3G = " + this.jdField_i_of_type_Long + ",mPreUpMaxWasteSize4G = " + this.jdField_h_of_type_Long + ",mCancelPercentWIFI = " + this.p + ",mCancelPercent2G = " + this.q + ",mCancelPercent3G = " + this.r + ",mCancelPercent4G = " + this.s);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        localNumberFormatException.printStackTrace();
      }
    }
  }
  
  public int a()
  {
    return this.t;
  }
  
  public void a()
  {
    Logger.a("PresendPicMgrService", "sendMsg__ start!", " ");
    jdField_a_of_type_ComTencentMobileqqPicPresendPicMgrService = null;
    Object localObject4;
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.a.getAppRuntime(this.jdField_g_of_type_JavaLangString);
      ??? = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      for (;;)
      {
        if (((Iterator)???).hasNext())
        {
          localObject4 = (PicReq)((Iterator)???).next();
          if (((PicReq)localObject4).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_c_of_type_Int == 4)
          {
            Logger.a("PresendPicMgrService", "sendMsg", "FLAG_UPLOADINFO_ERROR do not send! uuid = " + ((PicReq)localObject4).jdField_a_of_type_JavaLangString);
            continue;
            Logger.a("PresendPicMgrService", "sendMsg__ end!", " ");
          }
        }
      }
    }
    catch (AccountNotMatchException localAccountNotMatchException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PresendPicMgrService", 2, "no appRuntime");
      }
    }
    for (;;)
    {
      return;
      synchronized (((PicReq)localObject4).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo)
      {
        Object localObject6 = ((PicReq)localObject4).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_JavaLangObject;
        if (localObject6 == null) {}
        try
        {
          Logger.a("PresendPicMgrService", "sendMsg", "start wait! uuid = " + ((PicReq)localObject4).jdField_a_of_type_JavaLangString);
          ((PicReq)localObject4).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_e_of_type_Boolean = true;
          ((PicReq)localObject4).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.wait();
          Logger.a("PresendPicMgrService", "sendMsg", "finish wait! uuid = " + ((PicReq)localObject4).jdField_a_of_type_JavaLangString);
          if (((PicReq)localObject4).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_JavaLangObject == null) {
            Logger.b("PresendPicMgrService", "sendMsg", "get MR failed! uuid = " + ((PicReq)localObject4).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_JavaLangString);
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            localInterruptedException.printStackTrace();
          }
        }
      }
      ??? = (MessageRecord)((PicReq)localObject4).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_JavaLangObject;
      a((MessageRecord)???);
      if (((PicReq)localObject4).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_c_of_type_Int != 3) {
        break;
      }
      Logger.a("PresendPicMgrService", "sendMsg", "Pic not upload,reupload! mr = " + ???);
      a((MessageForPic)???);
      break;
      for (;;)
      {
        MessageRecord localMessageRecord;
        synchronized (this.b)
        {
          this.k = true;
          localObject4 = this.b.iterator();
          if (!((Iterator)localObject4).hasNext()) {
            break;
          }
          ??? = (PicReq)((Iterator)localObject4).next();
          int i1 = ((PicReq)???).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_c_of_type_Int;
          localMessageRecord = (MessageRecord)((PicReq)???).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_JavaLangObject;
          if (!this.jdField_a_of_type_JavaUtilArrayList.contains(???)) {
            break label534;
          }
          if (i1 == 1)
          {
            Logger.a("PresendPicMgrService", "sendMsg", "preupload success,dosend! mr =  " + localMessageRecord);
            ((QQAppInterface)localObject1).a().b(localMessageRecord, null);
          }
        }
        Logger.a("PresendPicMgrService", "sendMsg", "preupload failed,reupload! mr =  " + localMessageRecord);
        a((MessageForPic)localMessageRecord);
        continue;
        label534:
        Logger.a("PresendPicMgrService", "sendMsg", "unselect,do not send mr =  " + localMessageRecord);
      }
    }
  }
  
  public void a(int paramInt)
  {
    Logger.a("PresendPicMgrService", "cancelAll", "cancelType = " + paramInt);
    c();
  }
  
  public void a(String paramString, int paramInt)
  {
    Logger.a("PresendPicMgrService", "cancelUploadReq", " start,localUUID = " + paramString + ", cancelType = " + paramInt);
    PicReq localPicReq = a(this.jdField_a_of_type_JavaUtilArrayList, paramString);
    if (localPicReq == null)
    {
      Logger.a("PresendPicMgrService", "cancelUploadReq", " find req failed ");
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.remove(localPicReq);
    a(localPicReq, paramInt);
    Logger.a("PresendPicMgrService", "cancelUploadReq", " end,localUUID = " + paramString);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgVia", 2, "presendPic in main process " + paramInt2);
    }
    Logger.a("PresendPicMgrService", "presendPic", "PresendStatus : path = " + paramString1 + ", localUUID = " + paramString2 + ",fileSize = " + FileUtils.a(paramString1) + ",entrance = " + paramInt2);
    PicReq localPicReq = PicBusiManager.a(2, 1007);
    paramString1 = a(paramString1, paramBoolean, paramInt1, paramInt2);
    localPicReq.a(paramString1);
    localPicReq.a(paramString2);
    if (!paramString1.a())
    {
      Logger.b("PresendPicMgrService", paramString2, paramString1.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.jdField_a_of_type_JavaLangString, paramString1.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.b);
      paramString1.jdField_c_of_type_Int = 4;
      this.jdField_a_of_type_JavaUtilArrayList.add(localPicReq);
    }
    do
    {
      return;
      localPicReq.a(new tti(this, localPicReq));
      if ((!a()) || (b()) || (FileUtils.a(localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_g_of_type_JavaLangString) > 512000L))
      {
        Logger.a("PresendPicMgrService", "presendPic", "set FLAG_NOT_UPLOAD!");
        localPicReq.a(null);
        localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_c_of_type_Int = 3;
      }
      try
      {
        PicBusiManager.a(localPicReq, (QQAppInterface)BaseApplicationImpl.a.getAppRuntime(this.jdField_g_of_type_JavaLangString));
        this.jdField_a_of_type_JavaUtilArrayList.add(localPicReq);
        return;
      }
      catch (AccountNotMatchException paramString1) {}
    } while (!QLog.isColorLevel());
    QLog.d("PresendPicMgrService", 2, "no appRuntime");
  }
  
  boolean a()
  {
    int i1 = NetworkUtil.a(BaseApplication.getContext());
    boolean bool = false;
    switch (i1)
    {
    }
    for (;;)
    {
      Logger.a("PresendPicMgrService", "isPreuploadEnable", "nettype = " + i1 + " result =  " + bool);
      return bool;
      bool = this.jdField_g_of_type_Boolean;
      continue;
      bool = this.jdField_h_of_type_Boolean;
      continue;
      bool = this.jdField_i_of_type_Boolean;
      continue;
      bool = this.jdField_j_of_type_Boolean;
    }
  }
  
  public int[] a()
  {
    try
    {
      int[] arrayOfInt = PicBusiManager.a((QQAppInterface)BaseApplicationImpl.a.getAppRuntime(this.jdField_g_of_type_JavaLangString));
      return arrayOfInt;
    }
    catch (AccountNotMatchException localAccountNotMatchException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PresendPicMgrService", 2, "getPicCompressArgConfig no appRuntime");
      }
    }
    return null;
  }
  
  public boolean[] a()
  {
    return new boolean[] { this.jdField_c_of_type_Boolean, this.d, this.jdField_e_of_type_Boolean, this.jdField_f_of_type_Boolean };
  }
  
  public void b()
  {
    int i1 = NetworkUtil.a(BaseApplication.getContext());
    Logger.a("PresendPicMgrService", "handletWifi2Mobile", "netType = " + i1);
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {
      Logger.a("PresendPicMgrService", "handletWifi2Mobile", "mUploadReqList is Null! ");
    }
    for (;;)
    {
      return;
      Iterator localIterator;
      PicReq localPicReq;
      if (i1 == 2)
      {
        Logger.a("PresendPicMgrService", "handletWifi2Mobile", "switch to G2,cancel upload! ");
        localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          localPicReq = (PicReq)localIterator.next();
          a(localPicReq, 1001);
          localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_c_of_type_Int = 3;
        }
      }
      if (((i1 == 3) || (i1 == 4)) && (b()))
      {
        Logger.a("PresendPicMgrService", "handletWifi2Mobile", "switch to G3/G4,overWastLimit,cancel upload! ");
        localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          localPicReq = (PicReq)localIterator.next();
          a(localPicReq, 1002);
          localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_c_of_type_Int = 3;
        }
      }
    }
  }
  
  void c()
  {
    Logger.a("PresendPicMgrService", "resetStatus", "");
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.b.clear();
    this.k = false;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\pic\PresendPicMgrService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */