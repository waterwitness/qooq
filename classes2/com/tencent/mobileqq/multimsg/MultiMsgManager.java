package com.tencent.mobileqq.multimsg;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.DeviceProfileManager.StringToIntParser;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForQQStoryComment;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.pic.DownCallBack;
import com.tencent.mobileqq.pic.PicBusiManager;
import com.tencent.mobileqq.pic.PicPreDownloadUtils;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import mqq.manager.ServerConfigManager.ConfigType;
import tfl;
import tfm;
import tfn;
import tfo;
import tfp;

public class MultiMsgManager
  implements Comparator
{
  public static final int a = 192;
  private static MultiMsgManager jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgManager;
  public static final String a = "MultiMsg";
  private static byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  public static final int b = 242;
  public static final String b = "MultiMsg_time";
  public static final String c;
  private long jdField_a_of_type_Long;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  public ArrayList a;
  public HashMap a;
  private boolean jdField_a_of_type_Boolean = true;
  public HashMap b = new HashMap();
  private int jdField_c_of_type_Int = 100;
  private HashMap jdField_c_of_type_JavaUtilHashMap = new HashMap();
  private int d = 20;
  private int e = 100;
  private int f = 10;
  private int g;
  private int h;
  private int i;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_c_of_type_JavaLangString = AppConstants.bj + "fight/pic_expire.png";
  }
  
  public MultiMsgManager()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static long a()
  {
    File localFile = new File(jdField_c_of_type_JavaLangString);
    if (localFile.exists()) {
      return localFile.length();
    }
    return 0L;
  }
  
  public static MultiMsgManager a()
  {
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgManager == null) {
        jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgManager = new MultiMsgManager();
      }
      return jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgManager;
    }
  }
  
  public static String a(QQAppInterface paramQQAppInterface)
  {
    if (!new File(jdField_c_of_type_JavaLangString).exists())
    {
      FileUtils.a(paramQQAppInterface.a(), 2130838735, jdField_c_of_type_JavaLangString);
      paramQQAppInterface = FileUtils.b(jdField_c_of_type_JavaLangString);
      paramQQAppInterface = "chatthumb:" + paramQQAppInterface;
      paramQQAppInterface = URLDrawableHelper.a + "/" + AbsDownloader.c(paramQQAppInterface) + "_hd";
      FileUtils.d(jdField_c_of_type_JavaLangString, paramQQAppInterface);
    }
    return jdField_c_of_type_JavaLangString;
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, HashMap paramHashMap, MessageRecord paramMessageRecord, MessageObserver paramMessageObserver, ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    paramMessageObserver = PicBusiManager.a(8, 7);
    paramMessageObserver.a(paramArrayList2);
    paramMessageObserver.a(new tfn(this, paramArrayList1, paramMessageRecord, paramQQAppInterface, paramString, paramInt, paramHashMap));
    PicBusiManager.a(paramMessageObserver, paramQQAppInterface);
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, HashMap paramHashMap, MessageRecord paramMessageRecord, MessageObserver paramMessageObserver, ArrayList paramArrayList, boolean paramBoolean)
  {
    if (QLog.isDevelopLevel())
    {
      QLog.d("MultiMsg", 4, "pack multi msg start.............................");
      QLog.d("MultiMsg", 4, paramArrayList.toString());
    }
    paramHashMap = paramQQAppInterface.a().a().a(paramMessageRecord, paramArrayList, paramHashMap, paramBoolean);
    if (paramHashMap == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg", 2, "pack multi msg failed.............................");
      }
      paramMessageRecord.extraflag = 32768;
      paramQQAppInterface.a().a(paramString, paramInt, paramMessageRecord.uniseq);
      long l = paramMessageRecord.uniseq;
      ((MessageHandler)paramQQAppInterface.a(0)).a(MessageHandler.c(paramInt), false, new Object[] { paramString, Integer.valueOf(paramInt), Integer.valueOf(-1), null, Long.valueOf(0L), Long.valueOf(l) });
    }
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg", 2, "pack multi msg done.............................");
        }
        if (!a(paramQQAppInterface, paramHashMap, paramQQAppInterface.a(), paramString, paramString, paramInt, paramMessageRecord.uniseq, 1035, new tfo(this, paramMessageRecord, paramQQAppInterface, paramString, paramInt))) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("MultiMsg", 2, "sendMultiMsg successful, upload multi msg pack start.......................");
      return;
    } while (!QLog.isColorLevel());
    QLog.d("MultiMsg", 2, "sendMultiMsg failed.......................");
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, String paramString1, String paramString2, String paramString3, int paramInt1, long paramLong, int paramInt2, UpCallBack paramUpCallBack)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg", 2, "[sendMultiMsg]data.length = " + paramArrayOfByte.length);
    }
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.jdField_a_of_type_Boolean = true;
    localTransferRequest.jdField_b_of_type_Int = 131078;
    localTransferRequest.h = 0;
    localTransferRequest.jdField_b_of_type_ArrayOfByte = paramArrayOfByte;
    localTransferRequest.jdField_b_of_type_JavaLangString = paramString1;
    localTransferRequest.jdField_c_of_type_JavaLangString = paramString2;
    localTransferRequest.d = paramString3;
    localTransferRequest.jdField_a_of_type_Int = paramInt1;
    localTransferRequest.jdField_a_of_type_Long = paramLong;
    localTransferRequest.e = paramInt2;
    localTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack = paramUpCallBack;
    paramQQAppInterface.a().a(localTransferRequest);
    return true;
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public int a(ChatMessage paramChatMessage1, ChatMessage paramChatMessage2)
  {
    if ((paramChatMessage1.istroop == 1) || (paramChatMessage1.istroop == 3000)) {
      if (paramChatMessage1.shmsgseq == paramChatMessage2.shmsgseq) {
        if (paramChatMessage1.getId() <= paramChatMessage2.getId()) {}
      }
    }
    do
    {
      do
      {
        do
        {
          return 1;
          if (paramChatMessage1.getId() < paramChatMessage2.getId()) {
            return -1;
          }
          return 0;
        } while (paramChatMessage1.shmsgseq > paramChatMessage2.shmsgseq);
        return -1;
        if (paramChatMessage1.time != paramChatMessage2.time) {
          break;
        }
      } while (paramChatMessage1.getId() > paramChatMessage2.getId());
      if (paramChatMessage1.getId() < paramChatMessage2.getId()) {
        return -1;
      }
      return 0;
    } while (paramChatMessage1.time > paramChatMessage2.time);
    return -1;
  }
  
  public int a(Collection paramCollection)
  {
    paramCollection = paramCollection.iterator();
    int j = 0;
    Object localObject1;
    if (paramCollection.hasNext())
    {
      localObject1 = (ChatMessage)paramCollection.next();
      if ((localObject1 instanceof MessageForPic)) {
        j += 1;
      }
    }
    for (;;)
    {
      break;
      if ((localObject1 instanceof MessageForMixedMsg))
      {
        localObject1 = ((MessageForMixedMsg)localObject1).msgElemList.iterator();
        while (((Iterator)localObject1).hasNext()) {
          if (((MessageRecord)((Iterator)localObject1).next() instanceof MessageForPic)) {
            j += 1;
          }
        }
      }
      else
      {
        int k = j;
        if (((ChatMessage)localObject1).msgtype == 64500)
        {
          localObject1 = ((MessageForLongMsg)localObject1).longMsgFragmentList.iterator();
          do
          {
            k = j;
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            localObject2 = (MessageRecord)((Iterator)localObject1).next();
          } while (!(localObject2 instanceof MessageForMixedMsg));
          Object localObject2 = ((MessageForMixedMsg)localObject2).msgElemList.iterator();
          k = j;
          for (;;)
          {
            j = k;
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            if (((MessageRecord)((Iterator)localObject2).next() instanceof MessageForPic)) {
              k += 1;
            }
          }
          return j;
        }
        j = k;
      }
    }
  }
  
  public SessionInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  }
  
  public String a(String paramString, long paramLong, QQAppInterface paramQQAppInterface)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramLong == 0L)) {}
    Object localObject;
    do
    {
      while (!paramQQAppInterface.hasNext())
      {
        do
        {
          return null;
          if (this.jdField_c_of_type_JavaUtilHashMap.size() > 0)
          {
            localObject = (List)this.jdField_c_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
            if ((localObject != null) && (((List)localObject).size() > 0))
            {
              localObject = ((List)localObject).iterator();
              while (((Iterator)localObject).hasNext())
              {
                MultiMsgNick localMultiMsgNick = (MultiMsgNick)((Iterator)localObject).next();
                if ((localMultiMsgNick != null) && (paramString.equals(localMultiMsgNick.uin)) && (paramLong == localMultiMsgNick.uniseq)) {
                  return localMultiMsgNick.nick;
                }
              }
            }
          }
          this.jdField_c_of_type_JavaUtilHashMap.clear();
          paramQQAppInterface = paramQQAppInterface.a().createEntityManager().a(MultiMsgNick.class, new MultiMsgNick().getTableName(), false, "uniseq = ?", new String[] { String.valueOf(paramLong) }, null, null, null, null);
        } while ((paramQQAppInterface == null) || (paramQQAppInterface.size() <= 0));
        this.jdField_c_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong), paramQQAppInterface);
        paramQQAppInterface = paramQQAppInterface.iterator();
      }
      localObject = (MultiMsgNick)paramQQAppInterface.next();
    } while ((localObject == null) || (!paramString.equals(((MultiMsgNick)localObject).uin)) || (paramLong != ((MultiMsgNick)localObject).uniseq));
    return ((MultiMsgNick)localObject).nick;
  }
  
  public List a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((Boolean)localEntry.getValue()).booleanValue()) {
        localArrayList.add(localEntry.getKey());
      }
    }
    return localArrayList;
  }
  
  public List a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    Object localObject1 = paramQQAppInterface.a().a().a(paramLong);
    paramQQAppInterface = new ArrayList();
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (MessageRecord)((Iterator)localObject1).next();
      if ((localObject2 instanceof MessageForStructing))
      {
        MessageForStructing localMessageForStructing = (MessageForStructing)localObject2;
        if (localMessageForStructing.structingMsg == null) {
          localMessageForStructing.structingMsg = StructMsgFactory.a(((MessageRecord)localObject2).msgData);
        }
      }
      if ((localObject2 instanceof MessageForQQStoryComment)) {
        ((MessageForQQStoryComment)localObject2).displayType = 1;
      }
      paramQQAppInterface.add((ChatMessage)localObject2);
      if ((QLog.isColorLevel()) && ((localObject2 instanceof MessageForPic)))
      {
        localObject2 = (MessageForPic)localObject2;
        QLog.d("MultiMsg", 2, "[chatPie.getMultiMsgList] = " + ((MessageForPic)localObject2).toLogString() + " mr = " + ((MessageForPic)localObject2).toString());
      }
    }
    return paramQQAppInterface;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  public void a(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void a(SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = ((SessionInfo)paramSessionInfo.clone());
      return;
    }
    catch (CloneNotSupportedException paramSessionInfo) {}
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = null;
    return;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    Object localObject;
    String str;
    if (paramQQAppInterface != null)
    {
      localObject = paramQQAppInterface.a(ServerConfigManager.ConfigType.user, "MMF_enable");
      str = paramQQAppInterface.a(ServerConfigManager.ConfigType.user, "MMF_maxMsgNum");
      paramQQAppInterface = paramQQAppInterface.a(ServerConfigManager.ConfigType.user, "MMF_maxPicNum");
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg", 2, "initLimitCount enable = " + (String)localObject + " maxMsgNum = " + str + " maxPicNum " + paramQQAppInterface);
      }
      if (TextUtils.isEmpty(str)) {}
    }
    try
    {
      this.jdField_c_of_type_Int = Integer.parseInt(str);
      if (TextUtils.isEmpty(paramQQAppInterface)) {}
    }
    catch (NumberFormatException localNumberFormatException)
    {
      try
      {
        this.d = Integer.parseInt(paramQQAppInterface);
        paramQQAppInterface = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.MultiMsgConfig.name(), "100|10|0|0");
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg", 2, "initLimitCount delayConfi = " + paramQQAppInterface);
        }
        if (!TextUtils.isEmpty(paramQQAppInterface))
        {
          localObject = new Integer[4];
          Arrays.fill((Object[])localObject, Integer.valueOf(0));
          if (DeviceProfileManager.a(paramQQAppInterface, (Object[])localObject, new DeviceProfileManager.StringToIntParser()) >= localObject.length)
          {
            if (localObject[0].intValue() >= 0)
            {
              this.e = localObject[0].intValue();
              if (localObject[1].intValue() <= 0) {
                break label318;
              }
              j = localObject[1].intValue();
              this.f = j;
            }
            if (localObject[2].intValue() < 0) {
              break label327;
            }
            j = localObject[2].intValue();
            this.g = j;
            if (localObject[3].intValue() < 0) {
              break label336;
            }
            j = localObject[3].intValue();
            this.h = j;
          }
        }
        this.jdField_a_of_type_Boolean = true;
        return;
        localNumberFormatException = localNumberFormatException;
        this.jdField_c_of_type_Int = 100;
      }
      catch (NumberFormatException paramQQAppInterface)
      {
        for (;;)
        {
          this.d = 20;
          continue;
          label318:
          int j = this.f;
          continue;
          label327:
          j = this.g;
          continue;
          label336:
          j = this.h;
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    paramQQAppInterface.a(new tfl(this, paramArrayList, paramSessionInfo, paramQQAppInterface));
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    paramQQAppInterface.a(new tfp(this, paramQQAppInterface, paramString, paramInt, paramLong, paramBoolean));
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2, long paramLong, DownCallBack paramDownCallBack)
  {
    a(paramQQAppInterface, paramString2, paramQQAppInterface.a(), paramString1, paramString1, paramInt, paramLong, 1035, paramDownCallBack);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2, AbsStructMsg paramAbsStructMsg, long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg", 4, " sendMultiMsg start uniseq =  " + paramLong);
    }
    Object localObject2;
    Object localObject1;
    Object localObject3;
    Object localObject4;
    int j;
    if (paramLong == 0L)
    {
      localObject2 = this.jdField_a_of_type_JavaUtilArrayList;
      localObject1 = this.b;
      localObject3 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      k = 1;
      do
      {
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject4 = (ChatMessage)((Iterator)localObject3).next();
        j = k;
        if (!(localObject4 instanceof MessageForText))
        {
          j = k;
          if (!(localObject4 instanceof MessageForLongMsg)) {
            j = 0;
          }
        }
        k = j;
      } while (((ChatMessage)localObject4).isSend());
    }
    label299:
    label490:
    int m;
    for (int k = 0;; k = m)
    {
      if (j != 0) {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800662C", "0X800662C", 0, 1, 0, "", "", "", "");
      }
      if (k != 0)
      {
        paramAbsStructMsg = new SessionInfo();
        paramAbsStructMsg.jdField_a_of_type_Int = paramInt;
        paramAbsStructMsg.jdField_a_of_type_JavaLangString = paramString1;
        paramAbsStructMsg.jdField_b_of_type_JavaLangString = paramString2;
        a(paramQQAppInterface, paramAbsStructMsg, this.jdField_a_of_type_JavaUtilArrayList);
      }
      do
      {
        return;
        paramString2 = (String)localObject2;
        paramAbsStructMsg = ShareMsgHelper.a(paramQQAppInterface, paramString1, paramInt, paramAbsStructMsg);
      } while (paramAbsStructMsg == null);
      paramAbsStructMsg.isReMultiMsg = true;
      if (paramBoolean) {
        paramQQAppInterface.a().b(paramString1, paramInt, paramLong);
      }
      a().a(paramQQAppInterface, paramString1, paramInt, paramString2, (HashMap)localObject1, paramAbsStructMsg, null);
      return;
      paramString2 = new ArrayList();
      localObject1 = paramQQAppInterface.a().a().a(paramLong).iterator();
      j = 1;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MessageRecord)((Iterator)localObject1).next();
        if ((localObject2 instanceof ChatMessage)) {
          paramString2.add((ChatMessage)localObject2);
        }
        if (((localObject2 instanceof MessageForText)) || ((localObject2 instanceof MessageForLongMsg))) {
          break label490;
        }
        j = 0;
      }
      for (;;)
      {
        break label299;
        if (j != 0) {
          ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800662C", "0X800662C", 0, 1, 0, "", "", "", "");
        }
        localObject1 = new HashMap();
        localObject2 = paramString2.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (MessageRecord)((Iterator)localObject2).next();
          if (!((HashMap)localObject1).containsKey(((MessageRecord)localObject3).senderuin))
          {
            localObject4 = a().a(((MessageRecord)localObject3).senderuin, ((MessageRecord)localObject3).msgseq, paramQQAppInterface);
            ((HashMap)localObject1).put(((MessageRecord)localObject3).senderuin, localObject4);
          }
        }
        break;
      }
      m = 1;
      j = k;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, ArrayList paramArrayList, HashMap paramHashMap, MessageRecord paramMessageRecord, MessageObserver paramMessageObserver)
  {
    if (paramMessageRecord == null) {}
    while ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    paramQQAppInterface.a(new tfm(this, paramArrayList, paramHashMap, paramMessageRecord, paramQQAppInterface, paramString, paramInt));
  }
  
  public void a(QQAppInterface paramQQAppInterface, List paramList, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramBoolean) {}
    for (int j = 0;; j = 1)
    {
      localHashMap.put("result", j + "");
      if (paramList == null) {
        break;
      }
      j = paramList.size();
      int k = a().a(paramList);
      localHashMap.put("msgCount", j + "");
      localHashMap.put("picCount", k + "");
      StatisticCollector.a(BaseApplication.getContext()).a(paramQQAppInterface.a(), "multiMsgReceive", paramBoolean, 0L, 0L, localHashMap, "");
      return;
    }
    StatisticCollector.a(BaseApplication.getContext()).a(paramQQAppInterface.a(), "multiMsgReceive", paramBoolean, 0L, 0L, localHashMap, "");
  }
  
  public void a(ChatMessage paramChatMessage, boolean paramBoolean)
  {
    if (paramChatMessage == null) {
      return;
    }
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForLongMsg)))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        ChatMessage localChatMessage = (ChatMessage)localIterator.next();
        if (paramChatMessage.uniseq == localChatMessage.uniseq)
        {
          this.jdField_a_of_type_JavaUtilHashMap.put(localChatMessage, Boolean.valueOf(paramBoolean));
          return;
        }
      }
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramChatMessage, Boolean.valueOf(paramBoolean));
  }
  
  public void a(MessageForStructing paramMessageForStructing, QQAppInterface paramQQAppInterface)
  {
    if (this.h != 0) {}
    while ((this.g != 0) && (PicPreDownloadUtils.a(paramQQAppInterface, paramMessageForStructing.istroop, paramMessageForStructing.frienduin) == 1)) {
      return;
    }
    String str1 = ((StructMsgForGeneralShare)paramMessageForStructing.structingMsg).mResid;
    String str2 = paramMessageForStructing.frienduin;
    int j = paramMessageForStructing.istroop;
    long l = paramMessageForStructing.uniseq;
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg", 2, "preDownloadRes begin! touin:" + str2 + ",touinType:" + j + ",uniseq:" + l + ",fileKey:" + str1);
    }
    a().a(paramQQAppInterface, str1, paramQQAppInterface.a(), str2, str2, j, l, 1035, null);
  }
  
  /* Error */
  public void a(HashMap paramHashMap, long paramLong, QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +184 -> 185
    //   4: aload_1
    //   5: invokevirtual 358	java/util/HashMap:size	()I
    //   8: ifle +177 -> 185
    //   11: new 82	java/util/ArrayList
    //   14: dup
    //   15: invokespecial 83	java/util/ArrayList:<init>	()V
    //   18: astore 5
    //   20: aload_1
    //   21: invokevirtual 413	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   24: invokeinterface 416 1 0
    //   29: astore_1
    //   30: aload_1
    //   31: invokeinterface 322 1 0
    //   36: ifeq +78 -> 114
    //   39: aload_1
    //   40: invokeinterface 326 1 0
    //   45: checkcast 418	java/util/Map$Entry
    //   48: astore 7
    //   50: aload 7
    //   52: invokeinterface 429 1 0
    //   57: checkcast 370	java/lang/String
    //   60: astore 6
    //   62: aload 7
    //   64: invokeinterface 421 1 0
    //   69: checkcast 370	java/lang/String
    //   72: astore 7
    //   74: new 365	com/tencent/mobileqq/multimsg/MultiMsgNick
    //   77: dup
    //   78: invokespecial 391	com/tencent/mobileqq/multimsg/MultiMsgNick:<init>	()V
    //   81: astore 8
    //   83: aload 8
    //   85: aload 6
    //   87: putfield 368	com/tencent/mobileqq/multimsg/MultiMsgNick:uin	Ljava/lang/String;
    //   90: aload 8
    //   92: lload_2
    //   93: putfield 375	com/tencent/mobileqq/multimsg/MultiMsgNick:uniseq	J
    //   96: aload 8
    //   98: aload 7
    //   100: putfield 378	com/tencent/mobileqq/multimsg/MultiMsgNick:nick	Ljava/lang/String;
    //   103: aload 5
    //   105: aload 8
    //   107: invokevirtual 613	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   110: pop
    //   111: goto -81 -> 30
    //   114: aload 4
    //   116: invokevirtual 384	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   119: invokevirtual 390	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   122: astore 4
    //   124: aload 4
    //   126: invokevirtual 691	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   129: astore_1
    //   130: aload_1
    //   131: invokevirtual 695	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   134: aload 5
    //   136: invokevirtual 568	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   139: astore 5
    //   141: aload 5
    //   143: invokeinterface 322 1 0
    //   148: ifeq +38 -> 186
    //   151: aload 4
    //   153: aload 5
    //   155: invokeinterface 326 1 0
    //   160: checkcast 365	com/tencent/mobileqq/multimsg/MultiMsgNick
    //   163: invokevirtual 698	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   166: goto -25 -> 141
    //   169: astore 5
    //   171: aload 5
    //   173: invokevirtual 701	java/lang/Exception:printStackTrace	()V
    //   176: aload_1
    //   177: invokevirtual 703	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   180: aload 4
    //   182: invokevirtual 704	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   185: return
    //   186: aload_1
    //   187: invokevirtual 706	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   190: aload_1
    //   191: invokevirtual 703	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   194: goto -14 -> 180
    //   197: astore 4
    //   199: aload_1
    //   200: invokevirtual 703	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   203: aload 4
    //   205: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	this	MultiMsgManager
    //   0	206	1	paramHashMap	HashMap
    //   0	206	2	paramLong	long
    //   0	206	4	paramQQAppInterface	QQAppInterface
    //   18	136	5	localObject1	Object
    //   169	3	5	localException	Exception
    //   60	26	6	str	String
    //   48	51	7	localObject2	Object
    //   81	25	8	localMultiMsgNick	MultiMsgNick
    // Exception table:
    //   from	to	target	type
    //   130	141	169	java/lang/Exception
    //   141	166	169	java/lang/Exception
    //   186	190	169	java/lang/Exception
    //   130	141	197	finally
    //   141	166	197	finally
    //   171	176	197	finally
    //   186	190	197	finally
  }
  
  public void a(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      if (((ChatMessage)paramList.get(0)).isLongMsg()) {
        break;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (ChatMessage)paramList.next();
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject)) {
          this.jdField_a_of_type_JavaUtilHashMap.remove(localObject);
        }
      }
    }
    Object localObject = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      ChatMessage localChatMessage1 = (ChatMessage)((Map.Entry)((Iterator)localObject).next()).getKey();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        ChatMessage localChatMessage2 = (ChatMessage)localIterator.next();
        if ((localChatMessage2.shmsgseq == localChatMessage1.shmsgseq) && (localChatMessage2.msgUid == localChatMessage1.msgUid)) {
          ((Iterator)localObject).remove();
        }
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8006628", "0X8006628", 0, 1, 0, "", "", "", "");
    return a(paramQQAppInterface, paramLong).size() > 0;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, long paramLong, int paramInt2, DownCallBack paramDownCallBack)
  {
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.jdField_a_of_type_Boolean = false;
    localTransferRequest.jdField_b_of_type_Int = 131078;
    localTransferRequest.l = paramString1;
    localTransferRequest.jdField_b_of_type_JavaLangString = paramString2;
    localTransferRequest.jdField_c_of_type_JavaLangString = paramString3;
    localTransferRequest.d = paramString4;
    localTransferRequest.jdField_a_of_type_Int = paramInt1;
    localTransferRequest.jdField_a_of_type_Long = paramLong;
    localTransferRequest.e = paramInt2;
    localTransferRequest.jdField_a_of_type_ComTencentMobileqqPicDownCallBack = paramDownCallBack;
    paramQQAppInterface.a().a(localTransferRequest);
    return true;
  }
  
  public boolean a(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForLongMsg)))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        ChatMessage localChatMessage = (ChatMessage)localIterator.next();
        if ((localChatMessage != null) && (paramChatMessage.uniseq == localChatMessage.uniseq) && (this.jdField_a_of_type_JavaUtilHashMap.get(localChatMessage) != null)) {
          return ((Boolean)this.jdField_a_of_type_JavaUtilHashMap.get(localChatMessage)).booleanValue();
        }
      }
      return false;
    }
    if ((paramChatMessage != null) && (this.jdField_a_of_type_JavaUtilHashMap.get(paramChatMessage) != null)) {
      return ((Boolean)this.jdField_a_of_type_JavaUtilHashMap.get(paramChatMessage)).booleanValue();
    }
    return false;
  }
  
  public int b()
  {
    return this.d;
  }
  
  public void b(List paramList)
  {
    if ((paramList != null) && (paramList.size() > 0)) {
      Collections.sort(paramList, jdField_a_of_type_ComTencentMobileqqMultimsgMultiMsgManager);
    }
  }
  
  public boolean b()
  {
    boolean bool = false;
    if (a().d() >= a().a()) {
      bool = true;
    }
    return bool;
  }
  
  public boolean b(QQAppInterface paramQQAppInterface, long paramLong)
  {
    paramQQAppInterface = a(paramQQAppInterface, paramLong);
    if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0))
    {
      Iterator localIterator1 = paramQQAppInterface.iterator();
      if (localIterator1.hasNext())
      {
        paramQQAppInterface = (ChatMessage)localIterator1.next();
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg", 4, " isContainedNotExistPic ChatMessage = " + paramQQAppInterface.getClass().getName());
        }
        if ((paramQQAppInterface instanceof MessageForPic)) {
          paramQQAppInterface = (MessageForPic)paramQQAppInterface;
        }
        label99:
        Iterator localIterator2;
        Object localObject;
        for (;;)
        {
          if ((paramQQAppInterface != null) && (!URLDrawableHelper.a(null, paramQQAppInterface, 65537)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("MultiMsg", 4, " isContainedNotExistPic is = true ");
            }
            return true;
            if ((paramQQAppInterface instanceof MessageForMixedMsg))
            {
              localIterator2 = ((MessageForMixedMsg)paramQQAppInterface).msgElemList.iterator();
              localObject = null;
              label155:
              paramQQAppInterface = (QQAppInterface)localObject;
              if (!localIterator2.hasNext()) {
                continue;
              }
              paramQQAppInterface = (MessageRecord)localIterator2.next();
              if (!(paramQQAppInterface instanceof MessageForPic)) {
                break label406;
              }
            }
          }
        }
        label272:
        label403:
        label404:
        label406:
        for (paramQQAppInterface = (MessageForPic)paramQQAppInterface;; paramQQAppInterface = (QQAppInterface)localObject)
        {
          localObject = paramQQAppInterface;
          break label155;
          if (paramQQAppInterface.msgtype == 64500)
          {
            localIterator2 = ((MessageForLongMsg)paramQQAppInterface).longMsgFragmentList.iterator();
            localObject = null;
            Iterator localIterator3;
            do
            {
              do
              {
                paramQQAppInterface = (QQAppInterface)localObject;
                if (!localIterator2.hasNext()) {
                  break;
                }
                paramQQAppInterface = (MessageRecord)localIterator2.next();
              } while (!(paramQQAppInterface instanceof MessageForMixedMsg));
              localIterator3 = ((MessageForMixedMsg)paramQQAppInterface).msgElemList.iterator();
              paramQQAppInterface = (QQAppInterface)localObject;
              localObject = paramQQAppInterface;
            } while (!localIterator3.hasNext());
            localObject = (MessageRecord)localIterator3.next();
            if (!(localObject instanceof MessageForPic)) {
              break label403;
            }
            paramQQAppInterface = (MessageForPic)localObject;
          }
          for (;;)
          {
            break label272;
            if (!(paramQQAppInterface instanceof MessageForStructing)) {
              break label404;
            }
            paramQQAppInterface = ((MessageForStructing)paramQQAppInterface).structingMsg;
            if ((paramQQAppInterface != null) && ((paramQQAppInterface instanceof StructMsgForImageShare)))
            {
              localObject = ((StructMsgForImageShare)paramQQAppInterface).getFirstImageElement();
              if ((localObject != null) && (((StructMsgItemImage)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForPic == null))
              {
                if (((StructMsgItemImage)localObject).jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare == null) {
                  ((StructMsgItemImage)localObject).jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare = ((StructMsgForImageShare)paramQQAppInterface);
                }
                ((StructMsgItemImage)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForPic = ((StructMsgItemImage)localObject).a();
                paramQQAppInterface = ((StructMsgItemImage)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
                break label99;
              }
            }
            paramQQAppInterface = null;
            break label99;
            break;
          }
          break;
        }
      }
    }
    return false;
  }
  
  public int c()
  {
    return this.i;
  }
  
  public boolean c()
  {
    boolean bool = false;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    int j = 0;
    Object localObject1;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localObject1 = (ChatMessage)localIterator.next();
        if (((Boolean)this.jdField_a_of_type_JavaUtilHashMap.get(localObject1)).booleanValue()) {
          if ((localObject1 instanceof MessageForPic)) {
            j += 1;
          }
        }
      }
    }
    for (;;)
    {
      break;
      if ((localObject1 instanceof MessageForMixedMsg))
      {
        localObject1 = ((MessageForMixedMsg)localObject1).msgElemList.iterator();
        while (((Iterator)localObject1).hasNext()) {
          if (((MessageRecord)((Iterator)localObject1).next() instanceof MessageForPic)) {
            j += 1;
          }
        }
      }
      else
      {
        int k = j;
        if (((ChatMessage)localObject1).msgtype == 64500)
        {
          localObject1 = ((MessageForLongMsg)localObject1).longMsgFragmentList.iterator();
          do
          {
            k = j;
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            localObject2 = (MessageRecord)((Iterator)localObject1).next();
          } while (!(localObject2 instanceof MessageForMixedMsg));
          Object localObject2 = ((MessageForMixedMsg)localObject2).msgElemList.iterator();
          k = j;
          for (;;)
          {
            j = k;
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            if (((MessageRecord)((Iterator)localObject2).next() instanceof MessageForPic)) {
              k += 1;
            }
          }
          if (j >= a().b()) {
            bool = true;
          }
          return bool;
        }
        j = k;
      }
    }
  }
  
  public int d()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    int j = 0;
    if (localIterator.hasNext())
    {
      ChatMessage localChatMessage = (ChatMessage)localIterator.next();
      if (!((Boolean)this.jdField_a_of_type_JavaUtilHashMap.get(localChatMessage)).booleanValue()) {
        break label60;
      }
      j += 1;
    }
    label60:
    for (;;)
    {
      break;
      return j;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\multimsg\MultiMsgManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */