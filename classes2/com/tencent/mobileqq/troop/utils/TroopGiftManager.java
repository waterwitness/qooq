package com.tencent.mobileqq.troop.utils;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.av.utils.TroopMemberUtil;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.common.util.GCCommon;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.data.MessageForTroopGift;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.magicface.service.MagicfaceActionManager;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.surfaceviewaction.FrameSprite.OnFrameEndListener;
import com.tencent.mobileqq.troop.data.TroopGiftBagInfo;
import com.tencent.mobileqq.troop.data.TroopGiftBagPlayer;
import com.tencent.mobileqq.troopgift.TroopGiftAnimationController;
import com.tencent.mobileqq.troopgift.TroopGiftAnimationController.OnCleanAnimationListener;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import mqq.manager.TicketManager;
import tencent.im.oidb.cmd0x6b5.oidb_0x6b5.LoginSig;
import tencent.im.oidb.cmd0x6b5.oidb_0x6b5.ReqBody;
import tencent.im.oidb.cmd0x6b6.oidb_0x6b6.ExtParam;
import tencent.im.oidb.cmd0x6b6.oidb_0x6b6.LoginSig;
import tencent.im.oidb.cmd0x6b6.oidb_0x6b6.ReqBody;
import tencent.im.oidb.cmd0x6b6.oidb_0x6b6.SendFlowerReq;
import tencent.im.oidb.cmd0x6b6.oidb_0x6b6.ThrowFlowerReq;
import tencent.im.oidb.cmd0x6c2.oidb_0x6c2.LoginSig;
import tencent.im.oidb.cmd0x6c2.oidb_0x6c2.ReqBody;
import tencent.im.oidb.cmd0x6c3.oidb_0x6c3.ExtParam;
import tencent.im.oidb.cmd0x6c3.oidb_0x6c3.GetExtraDataReq;
import tencent.im.oidb.cmd0x6c3.oidb_0x6c3.GetStockReq;
import tencent.im.oidb.cmd0x6c3.oidb_0x6c3.LoginSig;
import tencent.im.oidb.cmd0x6c3.oidb_0x6c3.ReqBody;
import vqw;
import vqx;
import vqy;
import vra;
import vrd;
import vre;
import vrf;
import vri;
import vrj;
import vrk;

public class TroopGiftManager
  extends Observable
  implements Manager
{
  public static final int a = 1;
  public static final String a = ".troop.send_gift";
  public static volatile boolean a = false;
  public static final int b = 2;
  public static final String b = "http://pay.qun.qq.com/cgi-bin/group_pay/good_feeds/get_goods_count";
  public static final int c = 3;
  public static final String c = "gift_list_version";
  public static final int d = 4;
  public static final int e = 1;
  public static final int f = 2;
  public static final int g = 3;
  public static final int h = 0;
  public static final int i = 1;
  public static final int j = 0;
  public static final int k = 1;
  public static final int l = 0;
  public static final int m = 0;
  public static final int n = 1;
  public static final int p = 2;
  public static final int q = 10;
  public Activity a;
  public Handler a;
  public AppInterface a;
  public TroopChatPie a;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  FrameSprite.OnFrameEndListener jdField_a_of_type_ComTencentMobileqqSurfaceviewactionFrameSprite$OnFrameEndListener;
  TroopGiftAnimationController.OnCleanAnimationListener jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$OnCleanAnimationListener;
  public TroopGiftAnimationController a;
  DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener;
  public Comparator a;
  public HashMap a;
  public ConcurrentHashMap a;
  public HashMap b;
  public volatile boolean b;
  public String d;
  public int o;
  
  public TroopGiftManager(AppInterface paramAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
    this.o = 1;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilComparator = new vqw(this);
    this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new vqy(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$OnCleanAnimationListener = new vre(this);
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionFrameSprite$OnFrameEndListener = new vrf(this);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramAppInterface.a().createEntityManager();
    }
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    g();
  }
  
  private void a(String paramString, int paramInt, oidb_0x6b6.SendFlowerReq paramSendFlowerReq, oidb_0x6b6.ThrowFlowerReq paramThrowFlowerReq, long paramLong, TroopGiftCallback paramTroopGiftCallback)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramTroopGiftCallback == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e(".troop.send_gift", 2, "send_oidb_0x6b6. troopUin is null. callback=" + paramTroopGiftCallback);
      }
      return;
    }
    oidb_0x6b6.ReqBody localReqBody = new oidb_0x6b6.ReqBody();
    for (;;)
    {
      try
      {
        long l1 = Long.valueOf(paramString).longValue();
        localReqBody.uint64_group.set(l1, true);
        paramString = localReqBody.uint32_portal;
        if (!(this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
          break label180;
        }
        paramString.set(paramInt, true);
        paramInt = -1;
        if (paramSendFlowerReq == null) {
          break label186;
        }
        paramInt = 0;
        localReqBody.msg_send_flower = paramSendFlowerReq;
        if (paramInt != -1) {
          break label203;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e(".troop.send_gift", 2, "send_oidb_0x6b6. serviceType=" + paramInt);
        return;
      }
      catch (NumberFormatException paramSendFlowerReq) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e(".troop.send_gift", 2, "send_oidb_0x6b6. NumberFormatException troopUin=" + paramString);
      return;
      label180:
      paramInt = 10;
      continue;
      label186:
      if (paramThrowFlowerReq != null)
      {
        paramInt = 1;
        localReqBody.msg_throw_flower = paramThrowFlowerReq;
      }
    }
    label203:
    paramSendFlowerReq = GCCommon.d();
    paramString = paramSendFlowerReq;
    if (TextUtils.isEmpty(paramSendFlowerReq)) {
      paramString = "0.0.0.0";
    }
    int i1 = AppSetting.a;
    localReqBody.bytes_user_ip.set(ByteStringMicro.copyFrom(paramString.getBytes()), true);
    localReqBody.bytes_version.set(ByteStringMicro.copyFrom("V 6.5.5.2880".getBytes()), true);
    localReqBody.uint32_client.set(1, true);
    localReqBody.uint32_instance_id.set(i1, true);
    localReqBody.setHasFlag(true);
    paramSendFlowerReq = new oidb_0x6b6.ExtParam();
    paramString = (TicketManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(2);
    if (paramString != null)
    {
      paramString = paramString.getSkey(this.jdField_a_of_type_ComTencentCommonAppAppInterface.a());
      paramThrowFlowerReq = new oidb_0x6b6.LoginSig();
      paramThrowFlowerReq.uint32_type.set(1);
      paramThrowFlowerReq.uint32_appid.set(0);
      if (!TextUtils.isEmpty(paramString)) {
        paramThrowFlowerReq.bytes_sig.set(ByteStringMicro.copyFromUtf8(paramString));
      }
      paramSendFlowerReq.msg_login_sig.set(paramThrowFlowerReq);
      paramString = paramSendFlowerReq.uint32_business_id;
      if (!(this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
        break label514;
      }
    }
    label514:
    for (i1 = 1;; i1 = 2)
    {
      paramString.set(i1);
      localReqBody.msg_ext_param.set(paramSendFlowerReq);
      paramString = new Bundle();
      paramString.putInt("subCmd", paramInt);
      if (QLog.isColorLevel()) {
        QLog.i(".troop.send_gift", 2, "send_oidb_0x6b6. serviceType=" + paramInt);
      }
      ProtoUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, new vri(this, paramTroopGiftCallback), localReqBody.toByteArray(), "OidbSvc.0x6b6_" + paramInt, 1718, paramInt, paramString, paramLong);
      return;
      paramString = "";
      break;
    }
  }
  
  private void a(String paramString, int paramInt, oidb_0x6c3.GetStockReq paramGetStockReq, oidb_0x6c3.GetExtraDataReq paramGetExtraDataReq, long paramLong, TroopGiftCallback paramTroopGiftCallback)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramTroopGiftCallback == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e(".troop.send_gift", 2, "send_oidb_0x6c3. troopUin is null. callback=" + paramTroopGiftCallback);
      }
      return;
    }
    oidb_0x6c3.ReqBody localReqBody = new oidb_0x6c3.ReqBody();
    for (;;)
    {
      try
      {
        long l1 = Long.valueOf(paramString).longValue();
        localReqBody.uint64_group.set(l1, true);
        localReqBody.uint32_portal.set(paramInt, true);
        paramInt = -1;
        if (paramGetStockReq == null) {
          break label171;
        }
        paramInt = 0;
        localReqBody.msg_get_stock = paramGetStockReq;
        if (paramInt != -1) {
          break label188;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e(".troop.send_gift", 2, "send_oidb_0x6c3. serviceType=" + paramInt);
        return;
      }
      catch (NumberFormatException paramGetStockReq) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e(".troop.send_gift", 2, "send_oidb_0x6c3. NumberFormatException troopUin=" + paramString);
      return;
      label171:
      if (paramGetExtraDataReq != null)
      {
        paramInt = 1;
        localReqBody.msg_extra_data = paramGetExtraDataReq;
      }
    }
    label188:
    paramGetStockReq = GCCommon.d();
    paramString = paramGetStockReq;
    if (TextUtils.isEmpty(paramGetStockReq)) {
      paramString = "0.0.0.0";
    }
    int i1 = AppSetting.a;
    localReqBody.bytes_user_ip.set(ByteStringMicro.copyFrom(paramString.getBytes()), true);
    localReqBody.bytes_version.set(ByteStringMicro.copyFrom("V 6.5.5.2880".getBytes()), true);
    localReqBody.uint32_client.set(1, true);
    localReqBody.uint32_instance_id.set(i1, true);
    localReqBody.setHasFlag(true);
    paramGetStockReq = new oidb_0x6c3.ExtParam();
    paramString = (TicketManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(2);
    if (paramString != null) {}
    for (paramString = paramString.getSkey(this.jdField_a_of_type_ComTencentCommonAppAppInterface.a());; paramString = "")
    {
      paramGetExtraDataReq = new oidb_0x6c3.LoginSig();
      paramGetExtraDataReq.uint32_type.set(1);
      paramGetExtraDataReq.uint32_appid.set(0);
      if (!TextUtils.isEmpty(paramString)) {
        paramGetExtraDataReq.bytes_sig.set(ByteStringMicro.copyFromUtf8(paramString));
      }
      paramGetStockReq.msg_login_sig.set(paramGetExtraDataReq);
      localReqBody.msg_ext_param.set(paramGetStockReq);
      paramString = new Bundle();
      paramString.putInt("subCmd", paramInt);
      if (QLog.isColorLevel()) {
        QLog.i(".troop.send_gift", 2, "send_oidb_0x6c3. serviceType=" + paramInt);
      }
      ProtoUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, new vrj(this, paramTroopGiftCallback), localReqBody.toByteArray(), "OidbSvc.0x6c3_" + paramInt, 1731, paramInt, paramString, paramLong);
      return;
    }
  }
  
  private void a(String paramString, MessageForDeliverGiftTips paramMessageForDeliverGiftTips)
  {
    if ((!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)) || (((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).intValue() == 4))
    {
      Object localObject = new File(TroopGiftUtil.b(paramString));
      Bundle localBundle = new Bundle();
      localBundle.putString("GiftAnimationId", paramString);
      localBundle.putString("TroopUin", paramMessageForDeliverGiftTips.frienduin);
      localObject = new DownloadTask(TroopGiftUtil.a(TroopGiftUtil.a(paramMessageForDeliverGiftTips), paramMessageForDeliverGiftTips.isToAll()), (File)localObject);
      ((DownloadTask)localObject).A = 2;
      if ((paramMessageForDeliverGiftTips instanceof MessageForTroopGift)) {
        ((MessageForTroopGift)paramMessageForDeliverGiftTips).isLoading = true;
      }
      a().a((DownloadTask)localObject, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, localBundle);
      if (QLog.isColorLevel()) {
        QLog.d(".troop.send_gift", 2, "start Download PackageId:" + TroopGiftUtil.a(paramMessageForDeliverGiftTips));
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Integer.valueOf(2));
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    paramString1 = (List)this.jdField_b_of_type_JavaUtilHashMap.get(paramString1);
    if ((paramString2 == null) || (paramString1 == null)) {}
    for (;;)
    {
      return;
      int i1 = 0;
      while (i1 < paramString1.size())
      {
        if (paramString2.equals(TroopGiftUtil.a((MessageForDeliverGiftTips)paramString1.get(i1)))) {
          paramString1.remove(i1);
        }
        i1 += 1;
      }
    }
  }
  
  private void a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, long paramLong, TroopGiftCallback paramTroopGiftCallback)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (paramTroopGiftCallback == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e(".troop.send_gift", 2, "send_oidb_0x6c2. troopUin=" + paramString1 + " giftBagID=" + paramString2 + " callback=" + paramTroopGiftCallback);
      }
      return;
    }
    oidb_0x6c2.ReqBody localReqBody = new oidb_0x6c2.ReqBody();
    for (;;)
    {
      try
      {
        long l1 = Long.valueOf(paramString1).longValue();
        localReqBody.uint64_group_id.set(l1, true);
        localReqBody.bytes_gift_bagid.set(ByteStringMicro.copyFrom(paramString2.getBytes()));
        localReqBody.uint32_channel.set(1, true);
        localReqBody.setHasFlag(true);
        localObject = (TicketManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(2);
        if (localObject == null) {
          break label385;
        }
        localObject = ((TicketManager)localObject).getSkey(this.jdField_a_of_type_ComTencentCommonAppAppInterface.a());
        oidb_0x6c2.LoginSig localLoginSig = new oidb_0x6c2.LoginSig();
        localLoginSig.uint32_type.set(1);
        localLoginSig.uint32_appid.set(0);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localLoginSig.bytes_sig.set(ByteStringMicro.copyFromUtf8((String)localObject));
        }
        localReqBody.msg_login_sig.set(localLoginSig);
        switch (paramInt3)
        {
        default: 
          localObject = new Bundle();
          ((Bundle)localObject).putInt("subCmd", paramInt3);
          if (QLog.isColorLevel()) {
            QLog.i(".troop.send_gift", 2, "send_oidb_0x6c2. serviceType=" + paramInt3);
          }
          ProtoUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, new vqx(this, paramTroopGiftCallback, paramString1, paramString2), localReqBody.toByteArray(), "OidbSvc.0x6c2_" + paramInt3, 1730, paramInt3, (Bundle)localObject, paramLong);
          return;
        }
      }
      catch (NumberFormatException paramString2) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e(".troop.send_gift", 2, "send_oidb_0x6c2. NumberFormatException troopUin=" + paramString1);
      return;
      label385:
      Object localObject = "";
      continue;
      localReqBody.int32_page_index.set(paramInt1, true);
      localReqBody.int32_page_size.set(paramInt2, true);
    }
  }
  
  private void b(String paramString1, String paramString2, long paramLong, TroopGiftCallback paramTroopGiftCallback)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (paramTroopGiftCallback == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e(".troop.send_gift", 2, "send_oidb_0x6b5. troopUin=" + paramString1 + " giftBagID=" + paramString2 + " callback=" + paramTroopGiftCallback);
      }
      return;
    }
    oidb_0x6b5.ReqBody localReqBody = new oidb_0x6b5.ReqBody();
    for (;;)
    {
      try
      {
        long l1 = Long.valueOf(paramString1).longValue();
        localReqBody.uint64_group_id.set(l1, true);
        localObject = localReqBody.uint32_portal;
        if (!(this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
          break label383;
        }
        i1 = 7;
        ((PBUInt32Field)localObject).set(i1, true);
        localObject = localReqBody.uint32_business_id;
        if (!(this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
          break label390;
        }
        i1 = 1;
        ((PBUInt32Field)localObject).set(i1);
        localReqBody.bytes_gift_bagid.set(ByteStringMicro.copyFrom(paramString2.getBytes()));
        localReqBody.uint32_channel.set(1, true);
        localReqBody.setHasFlag(true);
        localObject = (TicketManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(2);
        if (localObject == null) {
          break label396;
        }
        localObject = ((TicketManager)localObject).getSkey(this.jdField_a_of_type_ComTencentCommonAppAppInterface.a());
        oidb_0x6b5.LoginSig localLoginSig = new oidb_0x6b5.LoginSig();
        localLoginSig.uint32_type.set(1);
        localLoginSig.uint32_appid.set(0);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localLoginSig.bytes_sig.set(ByteStringMicro.copyFromUtf8((String)localObject));
        }
        localReqBody.msg_login_sig.set(localLoginSig);
        localObject = new Bundle();
        ((Bundle)localObject).putInt("subCmd", 0);
        if (QLog.isColorLevel()) {
          QLog.i(".troop.send_gift", 2, "send_oidb_0x6b5. serviceType=0");
        }
        ProtoUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, new vrk(this, paramTroopGiftCallback, paramString1, paramString2), localReqBody.toByteArray(), "OidbSvc.0x6b5_0", 1717, 0, (Bundle)localObject, paramLong);
        return;
      }
      catch (NumberFormatException paramString2) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e(".troop.send_gift", 2, "send_oidb_0x6b5. NumberFormatException troopUin=" + paramString1);
      return;
      label383:
      int i1 = 10;
      continue;
      label390:
      i1 = 2;
      continue;
      label396:
      Object localObject = "";
    }
  }
  
  private void g()
  {
    h();
  }
  
  private void h()
  {
    Object localObject = new File(AppConstants.cW);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = ((File)localObject).listFiles();
    if (localObject != null)
    {
      int i1 = 0;
      if (i1 < localObject.length)
      {
        if ((localObject[i1].exists()) && (localObject[i1].isDirectory()))
        {
          if (!TroopGiftUtil.a(localObject[i1].getName())) {
            break label132;
          }
          this.jdField_a_of_type_JavaUtilHashMap.put(localObject[i1].getName(), Integer.valueOf(3));
          if (QLog.isColorLevel()) {
            QLog.d(".troop.send_gift", 2, "Package Downloaded:" + localObject[i1].getName());
          }
        }
        for (;;)
        {
          i1 += 1;
          break;
          label132:
          FileUtils.a(localObject[i1].getAbsolutePath());
        }
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentCommonAppAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentCommonAppAppInterface.a() + "_troop_gift", 0).getInt("gift_list_version", 0);
  }
  
  public long a(String paramString)
  {
    paramString = (List)this.jdField_b_of_type_JavaUtilHashMap.get(paramString);
    long l1 = 0L;
    long l2 = l1;
    if (paramString != null)
    {
      paramString = paramString.iterator();
      l2 = l1;
      if (paramString.hasNext())
      {
        MessageForDeliverGiftTips localMessageForDeliverGiftTips = (MessageForDeliverGiftTips)paramString.next();
        if (localMessageForDeliverGiftTips.shmsgseq <= l1) {
          break label70;
        }
        l1 = localMessageForDeliverGiftTips.shmsgseq;
      }
    }
    label70:
    for (;;)
    {
      break;
      return l2;
    }
  }
  
  public TroopChatPie a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie;
  }
  
  public TroopGiftBagInfo a(String paramString1, String paramString2, TroopGiftCallback paramTroopGiftCallback)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.e(".troop.send_gift .troop.send_gift", 2, "getGrabBagInfo. troopUin:" + paramString1 + " bagID:" + paramString2);
      }
      return null;
    }
    String str = paramString1 + "_" + paramString2;
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str) != null) {
      return (TroopGiftBagInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
    }
    TroopGiftBagInfo localTroopGiftBagInfo = (TroopGiftBagInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(TroopGiftBagInfo.class, paramString2);
    if (localTroopGiftBagInfo != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, localTroopGiftBagInfo);
      return localTroopGiftBagInfo;
    }
    a(paramString1, paramString2, 0, 0, 1000L, paramTroopGiftCallback);
    return null;
  }
  
  public DownloaderInterface a()
  {
    return ((DownloaderFactory)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(46)).a(1);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie != null) {}
    for (Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;; localObject = this.d)
    {
      localObject = (List)this.jdField_b_of_type_JavaUtilHashMap.get(localObject);
      if ((!this.jdField_b_of_type_Boolean) || (TroopGiftUtil.a((List)localObject))) {
        break;
      }
      int i2;
      for (int i1 = 0; i1 < ((List)localObject).size(); i1 = i2 + 1)
      {
        MessageForDeliverGiftTips localMessageForDeliverGiftTips = (MessageForDeliverGiftTips)((List)localObject).get(i1);
        i2 = i1;
        if (localMessageForDeliverGiftTips.isread)
        {
          i2 = i1;
          if (localMessageForDeliverGiftTips.senderUin != this.jdField_a_of_type_ComTencentCommonAppAppInterface.getLongAccountUin())
          {
            ((List)localObject).remove(i1);
            i2 = i1 - 1;
          }
        }
      }
    }
    Collections.sort((List)localObject, this.jdField_a_of_type_JavaUtilComparator);
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentCommonAppAppInterface.a() + "_troop_gift", 0).edit().putInt("gift_list_version", paramInt).commit();
  }
  
  public void a(TroopChatPie paramTroopChatPie)
  {
    if (QLog.isColorLevel()) {
      QLog.d(".troop.send_gift", 2, "set TroopChatPie ,troopUin:" + paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie = paramTroopChatPie;
    addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie);
    this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController = paramTroopChatPie.a();
    this.o = 1;
  }
  
  public void a(MessageForDeliverGiftTips paramMessageForDeliverGiftTips)
  {
    if (!TroopGiftUtil.a(paramMessageForDeliverGiftTips)) {
      return;
    }
    String str = TroopGiftUtil.a(paramMessageForDeliverGiftTips);
    int i1;
    if ((this.jdField_a_of_type_JavaUtilHashMap.containsKey(str)) && (((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(str)).intValue() == 3)) {
      if (!TroopGiftUtil.a(str))
      {
        this.jdField_a_of_type_JavaUtilHashMap.remove(str);
        FileUtils.a(TroopGiftUtil.a(str));
        a(str, paramMessageForDeliverGiftTips);
        i1 = 2;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(".troop.send_gift", 2, "giftRealAnimationId:" + TroopGiftUtil.a(paramMessageForDeliverGiftTips) + ",state:" + i1);
      }
      a(paramMessageForDeliverGiftTips, false);
      return;
      i1 = 3;
      continue;
      a(str, paramMessageForDeliverGiftTips);
      i1 = 4;
    }
  }
  
  public void a(MessageForDeliverGiftTips paramMessageForDeliverGiftTips, boolean paramBoolean)
  {
    if (paramMessageForDeliverGiftTips == null) {}
    for (;;)
    {
      return;
      if (!TroopGiftUtil.a(paramMessageForDeliverGiftTips)) {
        continue;
      }
      List localList = (List)this.jdField_b_of_type_JavaUtilHashMap.get(paramMessageForDeliverGiftTips.frienduin);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        this.jdField_b_of_type_JavaUtilHashMap.put(paramMessageForDeliverGiftTips.frienduin, localObject);
      }
      try
      {
        ((List)localObject).add(paramMessageForDeliverGiftTips);
        if (!paramBoolean) {
          continue;
        }
        setChanged();
        notifyObservers(paramMessageForDeliverGiftTips);
        return;
      }
      finally {}
    }
  }
  
  public void a(TroopGiftAnimationController paramTroopGiftAnimationController, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController = paramTroopGiftAnimationController;
    this.jdField_a_of_type_AndroidAppActivity = this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController.a();
    this.d = paramString;
  }
  
  public void a(String paramString)
  {
    paramString = (List)this.jdField_b_of_type_JavaUtilHashMap.remove(paramString);
    if (paramString != null) {
      paramString.clear();
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, TroopGiftCallback paramTroopGiftCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.e(".troop.send_gift .troop.send_gift", 2, "throwGift. troopUin:" + paramString + " entranceID:" + paramInt1 + " count:" + paramInt2 + " playRule:" + paramInt3 + " productID:" + paramInt4);
    }
    oidb_0x6b6.ThrowFlowerReq localThrowFlowerReq = new oidb_0x6b6.ThrowFlowerReq();
    localThrowFlowerReq.int32_count.set(paramInt2, true);
    localThrowFlowerReq.uint32_play_rule.set(paramInt3, true);
    localThrowFlowerReq.uint32_product_id.set(paramInt4, true);
    localThrowFlowerReq.setHasFlag(true);
    a(paramString, paramInt1, null, localThrowFlowerReq, 0L, paramTroopGiftCallback);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, int paramInt5, TroopGiftCallback paramTroopGiftCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.e(".troop.send_gift .troop.send_gift", 2, "sendGift. troopUin:" + paramString + " entranceID:" + paramInt1 + " count:" + paramInt2 + " toUin:" + paramLong + " playRule:" + paramInt3 + " customFlag:" + paramInt4);
    }
    oidb_0x6b6.SendFlowerReq localSendFlowerReq = new oidb_0x6b6.SendFlowerReq();
    localSendFlowerReq.int32_count.set(paramInt2, true);
    localSendFlowerReq.uint64_to_uin.set(paramLong, true);
    localSendFlowerReq.uint32_play_rule.set(paramInt3, true);
    localSendFlowerReq.uint32_custom_flag.set(paramInt4, true);
    localSendFlowerReq.uint32_product_id.set(paramInt5);
    localSendFlowerReq.setHasFlag(true);
    a(paramString, paramInt1, localSendFlowerReq, null, 0L, paramTroopGiftCallback);
  }
  
  public void a(String paramString, int paramInt, TroopGiftCallback paramTroopGiftCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.e(".troop.send_gift .troop.send_gift", 2, "fetchGiftStock. troopUin:" + paramString + " entranceID:" + paramInt);
    }
    oidb_0x6c3.GetStockReq localGetStockReq = new oidb_0x6c3.GetStockReq();
    localGetStockReq.setHasFlag(true);
    a(paramString, paramInt, localGetStockReq, null, 0L, paramTroopGiftCallback);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, long paramLong, TroopGiftCallback paramTroopGiftCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.e(".troop.send_gift .troop.send_gift", 2, "fetchGrabBagInfo. troopUin:" + paramString1 + " bagID:" + paramString2 + " pageIndex" + paramInt1 + " pageSize:" + paramInt2);
    }
    a(paramString1, paramString2, paramInt1, paramInt2, 0, paramLong, paramTroopGiftCallback);
  }
  
  public void a(String paramString1, String paramString2, long paramLong, TroopGiftCallback paramTroopGiftCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.e(".troop.send_gift .troop.send_gift", 2, "grabGift. troopUin:" + paramString1 + " bagID:" + paramString2);
    }
    b(paramString1, paramString2, paramLong, paramTroopGiftCallback);
  }
  
  public void a(String paramString1, String paramString2, TroopGiftCallback paramTroopGiftCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.e(".troop.send_gift .troop.send_gift", 2, "fetchGrabMemberCount. troopUin:" + paramString1 + " bagID:" + paramString2);
    }
    a(paramString1, paramString2, 0, 0, 1, 0L, paramTroopGiftCallback);
  }
  
  public void a(String paramString, long[] paramArrayOfLong)
  {
    List localList = (List)this.jdField_b_of_type_JavaUtilHashMap.get(paramString);
    if (localList != null)
    {
      if ((paramArrayOfLong != null) && (paramArrayOfLong.length != 0)) {
        break label31;
      }
      a(paramString);
    }
    label31:
    while (paramArrayOfLong.length == localList.size()) {
      return;
    }
    paramString = new ArrayList();
    int i1 = 0;
    while (i1 < paramArrayOfLong.length)
    {
      paramString.add(Long.valueOf(paramArrayOfLong[i1]));
      i1 += 1;
    }
    i1 = 0;
    label86:
    label112:
    int i3;
    if (i1 < localList.size())
    {
      paramArrayOfLong = (MessageForDeliverGiftTips)localList.get(i1);
      i2 = 0;
      if (i2 >= paramString.size()) {
        break label203;
      }
      if (paramArrayOfLong.getId() != ((Long)paramString.get(i2)).longValue()) {
        break label194;
      }
      i3 = 1;
      paramString.remove(i2);
    }
    label194:
    label203:
    for (int i2 = i3;; i2 = 0)
    {
      i3 = i1;
      if (i2 == 0)
      {
        localList.remove(i1);
        i3 = i1 - 1;
      }
      i1 = i3 + 1;
      break label86;
      break;
      i2 += 1;
      break label112;
    }
  }
  
  public void a(Observer paramObserver)
  {
    TroopGiftManager.DownloadGiftResStateObservable.a().addObserver(paramObserver);
  }
  
  public boolean a(Entity paramEntity)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) || (paramEntity == null)) {}
    do
    {
      do
      {
        return false;
        if (paramEntity.getStatus() != 1000) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramEntity);
      } while (paramEntity.getStatus() != 1001);
      return true;
    } while ((paramEntity.getStatus() != 1001) && (paramEntity.getStatus() != 1002));
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramEntity);
  }
  
  public boolean a(String paramString)
  {
    paramString = (List)this.jdField_b_of_type_JavaUtilHashMap.get(paramString);
    return (paramString != null) && (paramString.size() != 0);
  }
  
  public long[] a(String paramString)
  {
    Object localObject = (List)this.jdField_b_of_type_JavaUtilHashMap.get(paramString);
    paramString = new ArrayList();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramString.add(Long.valueOf(((MessageForDeliverGiftTips)((Iterator)localObject).next()).getId()));
      }
    }
    localObject = new long[paramString.size()];
    int i1 = 0;
    while (i1 < paramString.size())
    {
      localObject[i1] = ((Long)paramString.get(i1)).longValue();
      i1 += 1;
    }
    return (long[])localObject;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(".troop.send_gift", 2, "release TroopChatPie ,troopUin:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      }
      deleteObserver(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie);
      TroopGiftManager.DownloadGiftResStateObservable.a().deleteObservers();
      this.jdField_b_of_type_JavaUtilHashMap.remove(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController = null;
    this.o = 1;
  }
  
  public void b(String paramString, int paramInt, TroopGiftCallback paramTroopGiftCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.e(".troop.send_gift .troop.send_gift", 2, "fetchExtraInfo. troopUin:" + paramString + " entranceID:" + paramInt);
    }
    oidb_0x6c3.GetExtraDataReq localGetExtraDataReq = new oidb_0x6c3.GetExtraDataReq();
    localGetExtraDataReq.setHasFlag(true);
    a(paramString, paramInt, null, localGetExtraDataReq, 0L, paramTroopGiftCallback);
  }
  
  public void b(Observer paramObserver)
  {
    TroopGiftManager.DownloadGiftResStateObservable.a().deleteObserver(paramObserver);
  }
  
  public boolean b(String paramString)
  {
    return (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)) || (((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).intValue() != 3);
  }
  
  public void c()
  {
    TroopGiftManager.DownloadGiftResStateObservable.a().deleteObservers();
    this.jdField_a_of_type_AndroidAppActivity = null;
    this.jdField_b_of_type_JavaUtilHashMap.remove(this.d);
    this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController = null;
    this.o = 1;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d(".troop.send_gift", 2, "releaseAnimationList");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie != null) {}
    for (String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;; str = this.d)
    {
      this.jdField_b_of_type_JavaUtilHashMap.remove(str);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController.d();
        this.o = 1;
      }
      return;
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_AndroidAppActivity = null;
    this.o = 1;
  }
  
  public void f()
  {
    if (((this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie == null) && (this.jdField_a_of_type_AndroidAppActivity == null)) || (this.o != 1)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie != null) {}
    Object localObject;
    MessageForDeliverGiftTips localMessageForDeliverGiftTips;
    for (String str1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;; str1 = this.d)
    {
      localObject = (List)this.jdField_b_of_type_JavaUtilHashMap.get(str1);
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController == null) || (TroopGiftUtil.a((List)localObject))) {
        break;
      }
      this.o = 2;
      localMessageForDeliverGiftTips = (MessageForDeliverGiftTips)((List)localObject).get(0);
      if ((!localMessageForDeliverGiftTips.isToAll()) || (localMessageForDeliverGiftTips.hasFetchButFailed)) {
        break label228;
      }
      localObject = a(str1, localMessageForDeliverGiftTips.bagId, new vra(this, localMessageForDeliverGiftTips, str1));
      if (localObject != null) {
        break label140;
      }
      this.o = 1;
      return;
    }
    label140:
    if ((((TroopGiftBagInfo)localObject).hasGrab()) && (((TroopGiftBagInfo)localObject).myGrabResult != null))
    {
      localMessageForDeliverGiftTips.showButton = false;
      localMessageForDeliverGiftTips.resultText = ((TroopGiftBagInfo)localObject).myGrabResult.a;
      localMessageForDeliverGiftTips.resultType = 0;
    }
    label228:
    String str2;
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
        localMessageForDeliverGiftTips.senderName = ContactUtils.f((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, str1, "" + localMessageForDeliverGiftTips.senderUin);
      }
      str2 = TroopGiftUtil.a(localMessageForDeliverGiftTips);
      if ((!this.jdField_a_of_type_JavaUtilHashMap.containsKey(str2)) || (((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(str2)).intValue() != 3)) {
        break label540;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController.a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionFrameSprite$OnFrameEndListener);
      if (QLog.isColorLevel()) {
        QLog.d(".troop.send_gift", 2, "Playing! playMaigface id:" + TroopGiftUtil.a(localMessageForDeliverGiftTips));
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a() == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a().a == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a().a.a())) {
        break;
      }
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new vrd(this), 500L);
      return;
      if (((TroopGiftBagInfo)localObject).myGrabResult != null)
      {
        localMessageForDeliverGiftTips.showButton = false;
        localMessageForDeliverGiftTips.resultText = ((TroopGiftBagInfo)localObject).myGrabResult.a;
        localMessageForDeliverGiftTips.resultType = 1;
      }
      else
      {
        localMessageForDeliverGiftTips.showButton = true;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie != null)
    {
      localObject = "0";
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie == null) {
        break label535;
      }
    }
    label535:
    for (QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;; localQQAppInterface = null)
    {
      ReportController.b(localQQAppInterface, "P_CliOper", "Grp_flower", "", "cartoon", "show", 0, 0, str1, str2, (String)localObject, "" + TroopMemberUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentCommonAppAppInterface.a(), str1));
      this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController.a(localMessageForDeliverGiftTips);
      this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$OnCleanAnimationListener = this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController$OnCleanAnimationListener;
      return;
      localObject = "1";
      break;
    }
    label540:
    if ((this.jdField_a_of_type_JavaUtilHashMap.containsKey(str2)) && (((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(str2)).intValue() == 4))
    {
      a(str1, str2);
      this.o = 1;
      f();
      return;
    }
    this.o = 3;
  }
  
  public void onDestroy()
  {
    TroopGiftManager.DownloadGiftResStateObservable.a().deleteObservers();
    if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) && (QLog.isColorLevel())) {
      QLog.d(".troop.send_gift", 2, "clear History. uin:" + this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount() + " app=" + String.valueOf(this.jdField_a_of_type_ComTencentCommonAppAppInterface));
    }
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie = null;
    this.jdField_a_of_type_AndroidAppActivity = null;
    this.jdField_a_of_type_AndroidOsHandler = null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\utils\TroopGiftManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */