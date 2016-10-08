package com.tencent.av.service;

import android.content.Intent;
import android.content.res.Resources;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.bitapp.BitAppMsg;
import com.tencent.bitapp.BitAppMsgFactory;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousExtInfo;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.NearbyFlowerManager;
import com.tencent.mobileqq.app.NearbyFlowerManager.NearbyFlowerListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyFlowerAnimationController;
import com.tencent.mobileqq.nearby.NearbyFlowerMessage;
import com.tencent.mobileqq.nearby.business.NearbyCardObserver;
import com.tencent.mobileqq.qcall.QCallCardHandler.OnGetQCallCardListener;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import gne;
import gng;
import gni;
import gnk;
import gnl;
import gnm;
import gnn;
import gno;
import gnp;
import gnq;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import mqq.app.AppRuntime;
import mqq.app.AppService;

public class QQServiceForAV
  extends AppService
  implements Observer
{
  static final long jdField_a_of_type_Long = -1L;
  public static IBinder a;
  static final String jdField_a_of_type_JavaLangString = "QQServiceForAV";
  public int a;
  public final RemoteCallbackList a;
  final IQQServiceForAV.Stub jdField_a_of_type_ComTencentAvServiceIQQServiceForAV$Stub;
  public FriendListObserver a;
  private final MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver;
  public NearbyFlowerManager.NearbyFlowerListener a;
  public QQAppInterface a;
  public TroopObserver a;
  public NearbyFlowerAnimationController a;
  public NearbyCardObserver a;
  public QCallCardHandler.OnGetQCallCardListener a;
  public FaceDecoder.DecodeTaskCompletionListener a;
  public FaceDecoder a;
  private gno jdField_a_of_type_Gno;
  private gnp jdField_a_of_type_Gnp;
  public ArrayList a;
  public boolean a;
  public int b;
  long b;
  public String b;
  public ArrayList b;
  public boolean b;
  public long c;
  public String c;
  public String d;
  public String e;
  
  public QQServiceForAV()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_c_of_type_JavaLangString = null;
    this.d = null;
    this.e = null;
    this.jdField_b_of_type_Long = -1L;
    this.jdField_c_of_type_Long = Long.MAX_VALUE;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder$DecodeTaskCompletionListener = new gne(this);
    this.jdField_a_of_type_ComTencentMobileqqQcallQCallCardHandler$OnGetQCallCardListener = new gng(this);
    this.jdField_a_of_type_AndroidOsRemoteCallbackList = new RemoteCallbackList();
    this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV$Stub = new gnq(this);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new gni(this);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardObserver = new gnk(this);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new gnl(this);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new gnm(this);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFlowerAnimationController = null;
    this.jdField_a_of_type_ComTencentMobileqqAppNearbyFlowerManager$NearbyFlowerListener = new gnn(this);
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_AndroidOsIBinder != null;
  }
  
  private boolean a(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      switch (i)
      {
      }
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("QQServiceForAV", 2, "isTroopGiftGrayMsg: serviceType(" + paramString + ") cannot be parse to int");
    }
    return false;
    return true;
    return false;
  }
  
  public AppRuntime a()
  {
    return this.app;
  }
  
  void a(int paramInt, String paramString1, String paramString2, MessageRecord paramMessageRecord)
  {
    synchronized (this.jdField_a_of_type_AndroidOsRemoteCallbackList)
    {
      int j = this.jdField_a_of_type_AndroidOsRemoteCallbackList.beginBroadcast();
      try
      {
        RecvMsg localRecvMsg = new RecvMsg();
        int i = 0;
        if (i < j)
        {
          localRecvMsg.a(paramInt);
          localRecvMsg.a(this.d);
          localRecvMsg.d(this.jdField_c_of_type_JavaLangString);
          localRecvMsg.b(paramString2);
          localRecvMsg.e(paramString1);
          localRecvMsg.c = paramMessageRecord.longMsgCount;
          localRecvMsg.d = paramMessageRecord.longMsgId;
          localRecvMsg.jdField_b_of_type_Int = paramMessageRecord.longMsgIndex;
          localRecvMsg.a = paramMessageRecord.msgUid;
          String str1;
          label139:
          String str2;
          if (this.jdField_a_of_type_Int == 1) {
            if (AnonymousChatHelper.a(paramMessageRecord))
            {
              str1 = AnonymousChatHelper.a(paramMessageRecord).jdField_b_of_type_JavaLangString;
              str2 = str1;
              if (paramMessageRecord.msgtype == 2024)
              {
                str2 = str1;
                if (a(paramMessageRecord.getExtInfoFromExtStr("gray_tips_serviceType")))
                {
                  localRecvMsg.f = 3;
                  str2 = str1;
                }
              }
            }
          }
          for (;;)
          {
            localRecvMsg.c(str2);
            localRecvMsg.e = paramMessageRecord.msgtype;
            ((IQQServiceCallback)this.jdField_a_of_type_AndroidOsRemoteCallbackList.getBroadcastItem(i)).a(localRecvMsg);
            i += 1;
            break;
            str1 = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV$Stub.a(this.jdField_a_of_type_Int, paramString2, this.e);
            break label139;
            if (this.jdField_a_of_type_Int == 3000) {
              str2 = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV$Stub.a(1004, paramString2, this.jdField_c_of_type_JavaLangString);
            } else {
              str2 = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV$Stub.a(this.jdField_a_of_type_Int, paramString2, this.e);
            }
          }
        }
        paramString1 = finally;
      }
      catch (RemoteException paramString1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQServiceForAV", 2, "callBack RemoteException", paramString1);
        }
        this.jdField_a_of_type_AndroidOsRemoteCallbackList.finishBroadcast();
        return;
      }
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("tencent.video.q2v.GroupSystemMsg");
    localIntent.putExtra("type", 3);
    localIntent.putExtra("relationType", 1);
    localIntent.putExtra("relationId", paramLong1);
    localIntent.putExtra("userUin", paramLong2);
    localIntent.putExtra("needSendCmd", false);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)a());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().sendBroadcast(localIntent);
    }
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_JavaUtilArrayList.size() + this.jdField_a_of_type_JavaUtilArrayList.size() == 0;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "onBind");
    }
    this.jdField_b_of_type_Boolean = true;
    return this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV$Stub;
  }
  
  public void onCreate()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "onCreate");
    }
    if ((a() instanceof QQAppInterface))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)a());
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        this.d = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      }
    }
    super.onCreate();
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "onDestroy");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)a());
    }
    NearbyFlowerManager localNearbyFlowerManager = (NearbyFlowerManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(123);
    if ((localNearbyFlowerManager != null) && (localNearbyFlowerManager.b != null)) {
      localNearbyFlowerManager.b.clear();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = null;
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    jdField_a_of_type_AndroidOsIBinder = null;
    super.onDestroy();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "onStartCommand");
    }
    if ((a() instanceof QQAppInterface))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)a());
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        this.d = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      }
    }
    return super.onStartCommand(paramIntent, 3, paramInt2);
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "onUnbind");
    }
    this.jdField_b_of_type_Boolean = false;
    return super.onUnbind(paramIntent);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (paramObject == null) {
      if (QLog.isColorLevel()) {
        QLog.d("QQServiceForAV", 2, "update invalid data!");
      }
    }
    MessageRecord localMessageRecord;
    List localList;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (QLog.isColorLevel()) {
              QLog.d("QQServiceForAV", 2, "update data: " + paramObject + ", mLastUniseq: " + this.jdField_b_of_type_Long + ",mStartTime:" + this.jdField_c_of_type_Long);
            }
          } while (!(paramObject instanceof MessageRecord));
          localMessageRecord = (MessageRecord)paramObject;
        } while ((localMessageRecord == null) || (localMessageRecord.isSendFromLocal()));
        if ((this.d == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() == null))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)a());
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
            this.d = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
          }
        }
      } while ((TextUtils.isEmpty(this.d)) || (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)));
      localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Int);
    } while (localList == null);
    int i = 0;
    label202:
    if (i < localList.size())
    {
      paramObservable = (MessageRecord)localList.get(i);
      if (paramObservable != null) {
        break label240;
      }
    }
    label240:
    long l1;
    long l2;
    label380:
    label386:
    String str2;
    String str1;
    int j;
    do
    {
      for (;;)
      {
        i += 1;
        break label202;
        break;
        if ((!this.d.equals(paramObservable.senderuin)) && ((paramObservable.isSend()) || (paramObservable.isread)) && (paramObservable.msgtype != 63501) && (paramObservable.msgtype != 63498) && ((paramObservable.msgtype != 2024) || (!a(paramObservable.getExtInfoFromExtStr("gray_tips_serviceType")))))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQServiceForAV", 2, "update  continue 1");
          }
        }
        else
        {
          l1 = paramObservable.time;
          l2 = paramObservable.uniseq;
          if (this.jdField_b_of_type_Long != -1L) {
            break label386;
          }
          if (l1 >= this.jdField_c_of_type_Long) {
            break label380;
          }
          if (QLog.isColorLevel()) {
            QLog.d("QQServiceForAV", 2, "update  continue 2");
          }
        }
      }
      this.jdField_b_of_type_Long = l2;
      paramObject = paramObservable.selfuin;
      str2 = paramObservable.frienduin;
      str1 = paramObservable.senderuin;
      j = (int)paramObservable.vipBubbleID;
    } while ((l2 < this.jdField_b_of_type_Long) || (paramObject == null) || (str2 == null) || (str1 == null) || (!this.d.equals(paramObject)) || (!this.jdField_c_of_type_JavaLangString.equals(str2)));
    int k = paramObservable.msgtype;
    switch (k)
    {
    default: 
      paramObservable = null;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQServiceForAV", 2, "pos: " + i + ", vipBubbleId: " + j + ", senderUin: " + str1 + ", msgtype: " + k + ", msg: " + paramObservable + ", time: " + l1 + ", uinseq: " + l2 + ", mLastUniseq: " + this.jdField_b_of_type_Long);
      }
      if (paramObservable != null) {
        a(j, paramObservable, str1, localMessageRecord);
      }
      this.jdField_b_of_type_Long = (1L + l2);
      break;
      paramObject = paramObservable.msg;
      paramObservable = (Observable)paramObject;
      if (paramObject != null)
      {
        paramObservable = (Observable)paramObject;
        if (((String)paramObject).indexOf("http://maps.google.com/maps?q=") != -1)
        {
          paramObservable = getResources().getString(2131363333);
          continue;
          paramObservable = getResources().getString(2131363330);
          continue;
          paramObservable = getResources().getString(2131363331);
          continue;
          paramObservable = getResources().getString(2131363332);
          continue;
          paramObservable = getResources().getString(2131363334);
          continue;
          paramObservable = getResources().getString(2131363335);
          continue;
          paramObservable = (String)MessageForMixedMsg.getTextFromMixedMsg((MessageForMixedMsg)paramObservable);
          continue;
          try
          {
            if ((MsgProxyUtils.s(paramObservable.istroop)) && ((paramObservable instanceof MessageForStructing)))
            {
              paramObservable = (MessageForStructing)paramObservable;
              if (paramObservable.structingMsg.mMsgServiceID != 52) {
                break label1103;
              }
              paramObservable = new NearbyFlowerMessage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramObservable);
              if (!QLog.isColorLevel()) {
                break label1103;
              }
              QLog.d("QQServiceForAV", 2, "flower message version: " + paramObservable.version);
              break label1103;
            }
            paramObservable = StructMsgFactory.a(localMessageRecord.msgData);
            if (paramObservable == null)
            {
              if (!QLog.isColorLevel()) {
                break label1108;
              }
              QLog.d("QQServiceForAV", 2, "QQServiceForAV:getStructMsg is null");
              break label1108;
            }
            paramObservable = paramObservable.mMsgBrief;
          }
          catch (Exception paramObservable)
          {
            if (QLog.isColorLevel()) {
              QLog.d("StructMsg", 2, "QQServiceForAV:getStructMsg error", paramObservable);
            }
            paramObservable = null;
          }
          continue;
          try
          {
            paramObservable = BitAppMsgFactory.a(localMessageRecord.msgData);
            if (paramObservable == null)
            {
              if (!QLog.isColorLevel()) {
                break label1113;
              }
              QLog.d("QQServiceForAV", 2, "QQServiceForAV:getBitAppMsg is null");
              break label1113;
            }
            paramObservable = paramObservable.mMsgBrief;
          }
          catch (Exception paramObservable)
          {
            if (QLog.isColorLevel()) {
              QLog.d("StructMsg", 2, "QQServiceForAV:getBitAppMsg error", paramObservable);
            }
            paramObservable = null;
          }
          continue;
          paramObservable = getResources().getString(2131363336);
          continue;
          if ((localMessageRecord instanceof MessageForGrayTips))
          {
            paramObservable = MessageForGrayTips.getOrginMsg(((MessageForGrayTips)localMessageRecord).getSummaryMsg());
          }
          else
          {
            paramObservable = null;
            continue;
            label1103:
            paramObservable = null;
            continue;
            label1108:
            paramObservable = null;
            continue;
            label1113:
            paramObservable = null;
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\service\QQServiceForAV.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */