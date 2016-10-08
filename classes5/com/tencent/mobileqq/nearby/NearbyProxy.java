package com.tencent.mobileqq.nearby;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import appoint.define.appoint_define.InterestTag;
import com.tencent.bitapp.preDownload.RNPreDownloadFacade;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ShieldListObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager;
import com.tencent.mobileqq.data.DatingConfig;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.interestTag.InterestTag;
import com.tencent.mobileqq.nearby.ipc.ConnectNearbyProcService;
import com.tencent.mobileqq.nearby.ipc.NearbyProxyObserver;
import com.tencent.mobileqq.nearpeople.mytab.NearbyMineHelper;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.util.IPCFaceHelper;
import com.tencent.mobileqq.util.IPCIconHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0x686.Oidb_0x686.CharmEvent;
import tencent.im.oidb.cmd0x686.Oidb_0x686.NearbyCharmNotify;
import tencent.im.oidb.cmd0x686.Oidb_0x686.NearbyFeedConfig;
import tencent.im.oidb.cmd0x686.Oidb_0x686.NearbyRankConfig;
import tencent.im.oidb.cmd0x9c7.cmd0x9c7.RspBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.AppointmentNotify;
import tia;
import tic;
import tid;
import tie;
import tif;
import tig;
import tih;
import tii;

public class NearbyProxy
  implements Manager
{
  public static final String a;
  int jdField_a_of_type_Int = 0;
  ConditionSearchManager.IConfigListener jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener;
  ConditionSearchManager jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager;
  MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new tii(this);
  public QQAppInterface a;
  public ShieldListObserver a;
  NearbyConfigUtil jdField_a_of_type_ComTencentMobileqqNearbyNearbyConfigUtil;
  IPCFaceHelper jdField_a_of_type_ComTencentMobileqqUtilIPCFaceHelper;
  IPCIconHelper jdField_a_of_type_ComTencentMobileqqUtilIPCIconHelper;
  public ArrayList a;
  List jdField_a_of_type_JavaUtilList = new ArrayList();
  MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  int jdField_b_of_type_Int = Integer.MIN_VALUE;
  List jdField_b_of_type_JavaUtilList = new ArrayList();
  MqqHandler jdField_b_of_type_MqqOsMqqHandler;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = NearbyProxy.class.getSimpleName();
  }
  
  public NearbyProxy(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppShieldListObserver = new tih(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_MqqOsMqqHandler = ThreadManager.c();
    this.jdField_b_of_type_MqqOsMqqHandler = ThreadManager.b();
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    ThreadManager.a(new tig(paramQQAppInterface), 5, null, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    boolean bool2 = "1".equals(paramString);
    paramString = paramQQAppInterface.getAccount();
    if (!bool2) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      NearbySPUtil.a(paramString, "hotchat_tab_switch", Boolean.valueOf(bool1));
      if (bool2) {
        NearbyMineHelper.a(paramQQAppInterface, -1, 10011, com.tencent.mobileqq.activity.NearbyActivity.a[2], "", true);
      }
      return;
    }
  }
  
  public static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      NearbyUtils.a("delAccountRecord", new Object[] { paramString });
    }
    BaseApplicationImpl.a().getSharedPreferences("nearpeople_filters" + paramString, 4).edit().clear().commit();
    BaseApplicationImpl.getContext().getFileStreamPath(paramString + "v5.8.gods").delete();
    BaseApplicationImpl.getContext().getFileStreamPath(paramString + "v5.3.nb").delete();
    NearbySPUtil.a(paramString, "history_valid", Boolean.valueOf(false));
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt2 == 3)
    {
      bool1 = bool2;
      if (paramInt1 == 5) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private Object[] a(int paramInt)
  {
    return ConnectNearbyProcService.a(paramInt);
  }
  
  private Object[] a(int paramInt, Object... paramVarArgs)
  {
    return ConnectNearbyProcService.a(paramInt, paramVarArgs);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    boolean bool2 = "1".equals(paramString);
    paramString = paramQQAppInterface.getAccount();
    if (!bool2) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      NearbySPUtil.a(paramString, "ShowFreshNews", Boolean.valueOf(bool1));
      if (bool2) {
        NearbyMineHelper.a(paramQQAppInterface, -1, 10011, com.tencent.mobileqq.activity.NearbyActivity.a[1], "", true);
      }
      return;
    }
  }
  
  public static void c()
  {
    if (ConnectNearbyProcService.a()) {
      ConnectNearbyProcService.a(4128);
    }
  }
  
  public Message a(Context paramContext, Message paramMessage)
  {
    if (paramMessage == null) {
      return null;
    }
    paramContext = paramMessage.getData();
    switch (paramMessage.what)
    {
    default: 
      return null;
    case 4120: 
      if (paramContext == null) {
        return null;
      }
      paramContext = a().a(paramContext);
      paramMessage = Message.obtain();
      paramMessage.setData(paramContext);
      return paramMessage;
    case 4135: 
      paramContext = paramContext.getString("key");
      paramContext = a(true).a(paramContext);
      paramMessage = Message.obtain();
      localObject = new Bundle();
      ((Bundle)localObject).putParcelable("setting", paramContext);
      paramMessage.setData((Bundle)localObject);
      return paramMessage;
    case 4136: 
      paramContext.setClassLoader(Setting.class.getClassLoader());
      paramContext = (Setting)paramContext.getParcelable("setting");
      a(true).a(paramContext);
      return null;
    case 4137: 
      paramMessage = paramContext.getStringArrayList("faceKeyList");
      long l = paramContext.getLong("faceTimestamp", 0L);
      a(true).a(paramMessage, l);
      return null;
    case 4139: 
      paramContext = a(true).a();
      paramMessage = Message.obtain();
      localObject = new Bundle();
      ((Bundle)localObject).putString("IP", paramContext);
      paramMessage.setData((Bundle)localObject);
      return paramMessage;
    case 4140: 
      paramContext = a(true).b();
      paramMessage = Message.obtain();
      localObject = new Bundle();
      ((Bundle)localObject).putString("IP", paramContext);
      paramMessage.setData((Bundle)localObject);
      return paramMessage;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.dynamicAvatar", 2, "handle ipc msg get dynamic_avatar_info.");
    }
    paramContext = Message.obtain();
    paramMessage = paramMessage.getData();
    int i = paramMessage.getInt("type");
    Object localObject = paramMessage.getString("id");
    localObject = ((DynamicAvatarManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(179)).b(i, (String)localObject);
    if (localObject == null) {
      return null;
    }
    Bundle localBundle = new Bundle();
    paramMessage.putParcelable("avatarInfo", (Parcelable)localObject);
    paramContext.setData(localBundle);
    return paramContext;
  }
  
  public NearbyConfigUtil a()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyConfigUtil == null) {
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyConfigUtil = new NearbyConfigUtil();
      }
      NearbyConfigUtil localNearbyConfigUtil = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyConfigUtil;
      return localNearbyConfigUtil;
    }
    finally {}
  }
  
  public IPCFaceHelper a(boolean paramBoolean)
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqUtilIPCFaceHelper == null) && (paramBoolean)) {
        this.jdField_a_of_type_ComTencentMobileqqUtilIPCFaceHelper = new IPCFaceHelper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      IPCFaceHelper localIPCFaceHelper = this.jdField_a_of_type_ComTencentMobileqqUtilIPCFaceHelper;
      return localIPCFaceHelper;
    }
    finally {}
  }
  
  public IPCIconHelper a()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqUtilIPCIconHelper == null) {
        this.jdField_a_of_type_ComTencentMobileqqUtilIPCIconHelper = new IPCIconHelper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      IPCIconHelper localIPCIconHelper = this.jdField_a_of_type_ComTencentMobileqqUtilIPCIconHelper;
      return localIPCIconHelper;
    }
    finally {}
  }
  
  public String a()
  {
    String str = null;
    Object localObject = a().a();
    if (localObject != null) {
      str = ((DatingConfig)localObject).aioTravelProfileSendMsgTip;
    }
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = BaseApplication.getContext().getResources().getString(2131371855);
    }
    return (String)localObject;
  }
  
  public String a(String paramString)
  {
    String str = null;
    Object localObject = a().a();
    if (localObject != null) {
      str = ((DatingConfig)localObject).aioFirstTips;
    }
    for (;;)
    {
      localObject = str;
      if (str == null) {
        localObject = BaseApplication.getContext().getResources().getString(2131371806);
      }
      return ((String)localObject).replace("%", paramString);
      DatingUtil.b("getFirstAIOTips", new Object[] { "datingConfig is null" });
    }
  }
  
  public void a()
  {
    a(4126, null);
  }
  
  public void a(int paramInt)
  {
    if (ConnectNearbyProcService.a()) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(4100, new Object[] { Integer.valueOf(paramInt) });
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        NearbyUtils.a("realHasUnreadMsg", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(ConnectNearbyProcService.a()) });
      }
      return;
      NearbyProcessMonitor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 3);
      tie localtie = new tie(this, paramInt);
      localtie.a = true;
      a(localtie);
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    int j = 0;
    List localList = this.jdField_a_of_type_JavaUtilList;
    int i = 0;
    Object localObject;
    try
    {
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        localObject = (NearbyProxyObserver)this.jdField_a_of_type_JavaUtilList.get(i);
        this.jdField_a_of_type_MqqOsMqqHandler.post(new tic(this, (NearbyProxyObserver)localObject, paramInt, paramVarArgs));
        i += 1;
      }
      if (paramInt == 4126)
      {
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          NearbyProxyObserver localNearbyProxyObserver = (NearbyProxyObserver)((Iterator)localObject).next();
          if ((localNearbyProxyObserver != null) && (localNearbyProxyObserver.a)) {
            ((Iterator)localObject).remove();
          }
        }
      }
    }
    finally {}
    localList = this.jdField_b_of_type_JavaUtilList;
    i = j;
    try
    {
      while (i < this.jdField_b_of_type_JavaUtilList.size())
      {
        localObject = (NearbyProxyObserver)this.jdField_b_of_type_JavaUtilList.get(i);
        this.jdField_b_of_type_MqqOsMqqHandler.post(new tid(this, (NearbyProxyObserver)localObject, paramInt, paramVarArgs));
        i += 1;
      }
      if (paramInt == 4126)
      {
        paramVarArgs = this.jdField_b_of_type_JavaUtilList.iterator();
        while (paramVarArgs.hasNext())
        {
          localObject = (NearbyProxyObserver)paramVarArgs.next();
          if ((localObject != null) && (((NearbyProxyObserver)localObject).a)) {
            paramVarArgs.remove();
          }
        }
      }
    }
    finally {}
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "updateNearbyProfileCardRecord,tinyID = " + paramLong + ",visitDuration = " + paramInt1 + ",visitPicCount = " + paramInt2 + ",opflag = " + paramInt3 + "|" + Integer.toBinaryString(paramInt3));
    }
    a(4145, new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
  }
  
  public void a(NearbyProxyObserver paramNearbyProxyObserver)
  {
    a(paramNearbyProxyObserver, false);
  }
  
  public void a(NearbyProxyObserver paramNearbyProxyObserver, boolean paramBoolean)
  {
    if (paramNearbyProxyObserver == null) {
      return;
    }
    if (paramBoolean) {
      synchronized (this.jdField_b_of_type_JavaUtilList)
      {
        if (!this.jdField_b_of_type_JavaUtilList.contains(paramNearbyProxyObserver)) {
          this.jdField_b_of_type_JavaUtilList.add(paramNearbyProxyObserver);
        }
        return;
      }
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(paramNearbyProxyObserver)) {
        this.jdField_a_of_type_JavaUtilList.add(paramNearbyProxyObserver);
      }
      return;
    }
  }
  
  public void a(String paramString, Oidb_0x686.NearbyRankConfig paramNearbyRankConfig, Oidb_0x686.NearbyFeedConfig paramNearbyFeedConfig, Oidb_0x686.CharmEvent paramCharmEvent, Oidb_0x686.NearbyCharmNotify paramNearbyCharmNotify)
  {
    Object localObject = null;
    NearbyCardManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramCharmEvent, paramNearbyCharmNotify);
    int i;
    if (paramCharmEvent != null) {
      i = paramCharmEvent.uint32_new_charm_level.get();
    }
    for (;;)
    {
      if (ConnectNearbyProcService.a())
      {
        if (paramNearbyRankConfig != null) {
          break label96;
        }
        paramString = null;
        label42:
        if (paramNearbyFeedConfig != null) {
          break label104;
        }
      }
      label96:
      label104:
      for (paramNearbyRankConfig = (Oidb_0x686.NearbyRankConfig)localObject;; paramNearbyRankConfig = paramNearbyFeedConfig.toByteArray())
      {
        a(4124, new Object[] { Integer.valueOf(i), paramString, paramNearbyRankConfig });
        return;
        if (paramNearbyCharmNotify == null) {
          break label112;
        }
        i = paramNearbyCharmNotify.uint32_new_charm_level.get();
        break;
        paramString = paramNearbyRankConfig.toByteArray();
        break label42;
      }
      label112:
      i = 0;
    }
  }
  
  public void a(cmd0x9c7.RspBody paramRspBody)
  {
    NearbyUtils.a("Q.nearby", "updateNearbyCard", new Object[] { paramRspBody });
    if (paramRspBody == null) {}
    Object localObject1;
    EntityManager localEntityManager;
    do
    {
      return;
      if (paramRspBody.rpt_msg_tags.has()) {}
      for (paramRspBody = paramRspBody.rpt_msg_tags.get();; paramRspBody = null)
      {
        localObject1 = new ArrayList();
        if ((paramRspBody == null) || (paramRspBody.size() <= 0)) {
          break;
        }
        int i = 0;
        while (i < paramRspBody.size())
        {
          localObject2 = InterestTag.a((appoint_define.InterestTag)paramRspBody.get(i));
          if (localObject2 != null) {
            ((List)localObject1).add(localObject2);
          }
          i += 1;
        }
      }
      localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).createEntityManager();
      Object localObject2 = (NearbyPeopleCard)localEntityManager.a(NearbyPeopleCard.class, "uin=?", new String[] { this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() });
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new NearbyPeopleCard();
        ((NearbyPeopleCard)localObject1).uin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      }
      ((NearbyPeopleCard)localObject1).updateInterestTags(((NearbyPeopleCard)localObject1).tagFlag, paramRspBody);
      if (((NearbyPeopleCard)localObject1).getStatus() == 1000)
      {
        localEntityManager.b((Entity)localObject1);
        return;
      }
    } while ((((NearbyPeopleCard)localObject1).getStatus() != 1001) && (((NearbyPeopleCard)localObject1).getStatus() != 1002));
    localEntityManager.a((Entity)localObject1);
  }
  
  public void a(SubMsgType0x27.AppointmentNotify paramAppointmentNotify)
  {
    if (paramAppointmentNotify == null) {
      return;
    }
    if (paramAppointmentNotify.uint32_notifytype.get() == 6) {}
    for (boolean bool = b();; bool = true)
    {
      if (bool)
      {
        if (!ConnectNearbyProcService.a()) {
          break label97;
        }
        a(4101, new Object[] { paramAppointmentNotify.toByteArray() });
      }
      while (QLog.isColorLevel())
      {
        NearbyUtils.a("hasOnLinePush", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramAppointmentNotify.uint32_notifytype.get()), Boolean.valueOf(ConnectNearbyProcService.a()) });
        return;
        label97:
        NearbyProcessMonitor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 4);
        tif localtif = new tif(this, paramAppointmentNotify);
        localtif.a = true;
        a(localtif);
      }
      break;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    boolean bool = false;
    int i = 1;
    DatingUtil.b("setNearbyDatingMsg", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(this.jdField_a_of_type_Int) });
    if ((this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 3)) {
      bool = true;
    }
    if ((this.jdField_a_of_type_Int == 0) || (bool != paramBoolean)) {
      NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "dating_recv_msg", Boolean.valueOf(paramBoolean));
    }
    if (paramBoolean) {}
    for (;;)
    {
      this.jdField_a_of_type_Int = i;
      return;
      i = 2;
    }
  }
  
  void a(boolean paramBoolean, Object... paramVarArgs)
  {
    if (paramVarArgs == null) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b((String)paramVarArgs[0], (String)paramVarArgs[1], (String)paramVarArgs[2], (String)paramVarArgs[3], (String)paramVarArgs[4], ((Integer)paramVarArgs[5]).intValue(), ((Integer)paramVarArgs[6]).intValue(), (String)paramVarArgs[7], (String)paramVarArgs[8], (String)paramVarArgs[9], (String)paramVarArgs[10]);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a((String)paramVarArgs[0], (String)paramVarArgs[1], (String)paramVarArgs[2], (String)paramVarArgs[3], (String)paramVarArgs[4], ((Integer)paramVarArgs[5]).intValue(), ((Integer)paramVarArgs[6]).intValue(), (String)paramVarArgs[7], (String)paramVarArgs[8], (String)paramVarArgs[9], (String)paramVarArgs[10]);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Int == 0) {
      if (!NearbySPUtil.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) {
        break label45;
      }
    }
    label45:
    for (int i = 3;; i = 4)
    {
      this.jdField_a_of_type_Int = i;
      if ((this.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_Int != 3)) {
        break;
      }
      return true;
    }
    return false;
  }
  
  /* Error */
  public Object[] a(Context paramContext, int paramInt, Object... paramVarArgs)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 8
    //   3: iload_2
    //   4: tableswitch	default:+208->212, 4098:+270->274, 4099:+278->282, 4100:+208->212, 4101:+208->212, 4102:+286->290, 4103:+506->510, 4104:+467->471, 4105:+304->308, 4106:+431->435, 4107:+402->406, 4108:+208->212, 4109:+210->214, 4110:+1072->1076, 4111:+1130->1134, 4112:+732->736, 4113:+810->814, 4114:+876->880, 4115:+208->212, 4116:+208->212, 4117:+208->212, 4118:+208->212, 4119:+208->212, 4120:+208->212, 4121:+592->596, 4122:+622->626, 4123:+690->694, 4124:+918->922, 4125:+1021->1025, 4126:+208->212, 4127:+208->212, 4128:+208->212, 4129:+1114->1118, 4130:+1219->1223, 4131:+1275->1279, 4132:+1321->1325, 4133:+208->212, 4134:+1356->1360, 4135:+208->212, 4136:+208->212, 4137:+208->212, 4138:+1374->1378, 4139:+208->212, 4140:+208->212, 4141:+208->212, 4142:+208->212, 4143:+1454->1458, 4144:+1486->1490, 4145:+1638->1642
    //   212: aconst_null
    //   213: areturn
    //   214: aload_3
    //   215: ifnull -3 -> 212
    //   218: aload_3
    //   219: arraylength
    //   220: iconst_3
    //   221: if_icmpne -9 -> 212
    //   224: iconst_1
    //   225: anewarray 4	java/lang/Object
    //   228: dup
    //   229: iconst_0
    //   230: aload_0
    //   231: getfield 68	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   234: bipush 70
    //   236: invokevirtual 324	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   239: checkcast 633	com/tencent/mobileqq/dating/DatingProxyManager
    //   242: invokevirtual 636	com/tencent/mobileqq/dating/DatingProxyManager:a	()Lcom/tencent/mobileqq/dating/StrangerHdHeadUrlFetcher;
    //   245: aload_3
    //   246: iconst_0
    //   247: aaload
    //   248: checkcast 92	java/lang/String
    //   251: aload_3
    //   252: iconst_1
    //   253: aaload
    //   254: checkcast 397	java/lang/Integer
    //   257: invokevirtual 618	java/lang/Integer:intValue	()I
    //   260: aload_3
    //   261: iconst_2
    //   262: aaload
    //   263: checkcast 105	java/lang/Boolean
    //   266: invokevirtual 639	java/lang/Boolean:booleanValue	()Z
    //   269: invokevirtual 644	com/tencent/mobileqq/dating/StrangerHdHeadUrlFetcher:a	(Ljava/lang/String;IZ)Ljava/lang/String;
    //   272: aastore
    //   273: areturn
    //   274: aload_0
    //   275: iconst_0
    //   276: aload_3
    //   277: invokevirtual 646	com/tencent/mobileqq/nearby/NearbyProxy:a	(Z[Ljava/lang/Object;)V
    //   280: aconst_null
    //   281: areturn
    //   282: aload_0
    //   283: iconst_1
    //   284: aload_3
    //   285: invokevirtual 646	com/tencent/mobileqq/nearby/NearbyProxy:a	(Z[Ljava/lang/Object;)V
    //   288: aconst_null
    //   289: areturn
    //   290: aload_0
    //   291: getfield 80	com/tencent/mobileqq/nearby/NearbyProxy:jdField_b_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   294: new 648	thz
    //   297: dup
    //   298: aload_0
    //   299: invokespecial 649	thz:<init>	(Lcom/tencent/mobileqq/nearby/NearbyProxy;)V
    //   302: invokevirtual 440	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   305: pop
    //   306: aconst_null
    //   307: areturn
    //   308: aload_3
    //   309: ifnull -97 -> 212
    //   312: aload_3
    //   313: iconst_0
    //   314: aaload
    //   315: checkcast 92	java/lang/String
    //   318: astore_1
    //   319: aload_0
    //   320: getfield 68	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   323: bipush 35
    //   325: invokevirtual 324	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   328: checkcast 651	com/tencent/mobileqq/redtouch/RedTouchManager
    //   331: astore 4
    //   333: aload_1
    //   334: ldc_w 652
    //   337: invokestatic 654	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   340: invokevirtual 96	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   343: ifne +35 -> 378
    //   346: aload 4
    //   348: aload_1
    //   349: invokevirtual 656	com/tencent/mobileqq/redtouch/RedTouchManager:b	(Ljava/lang/String;)V
    //   352: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   355: ifeq -143 -> 212
    //   358: iconst_2
    //   359: getstatic 37	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   362: ldc_w 658
    //   365: iconst_1
    //   366: anewarray 4	java/lang/Object
    //   369: dup
    //   370: iconst_0
    //   371: aload_1
    //   372: aastore
    //   373: invokestatic 661	com/tencent/mobileqq/nearby/NearbyUtils:a	(ILjava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   376: aconst_null
    //   377: areturn
    //   378: aload 4
    //   380: iconst_0
    //   381: putfield 662	com/tencent/mobileqq/redtouch/RedTouchManager:a	Z
    //   384: aload_0
    //   385: sipush 4105
    //   388: iconst_1
    //   389: anewarray 4	java/lang/Object
    //   392: dup
    //   393: iconst_0
    //   394: aload_3
    //   395: iconst_0
    //   396: aaload
    //   397: checkcast 92	java/lang/String
    //   400: aastore
    //   401: invokevirtual 391	com/tencent/mobileqq/nearby/NearbyProxy:a	(I[Ljava/lang/Object;)V
    //   404: aconst_null
    //   405: areturn
    //   406: aload_3
    //   407: ifnull -195 -> 212
    //   410: aload_0
    //   411: getfield 68	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   414: aload_3
    //   415: invokestatic 665	com/tencent/mobileqq/nearpeople/mytab/NearbyMineHelper:a	(Lcom/tencent/mobileqq/app/QQAppInterface;[Ljava/lang/Object;)Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   418: astore_1
    //   419: aload_1
    //   420: ifnull -208 -> 212
    //   423: iconst_1
    //   424: anewarray 4	java/lang/Object
    //   427: dup
    //   428: iconst_0
    //   429: aload_1
    //   430: invokevirtual 668	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:toByteArray	()[B
    //   433: aastore
    //   434: areturn
    //   435: aload_3
    //   436: ifnull -224 -> 212
    //   439: iconst_1
    //   440: anewarray 4	java/lang/Object
    //   443: dup
    //   444: iconst_0
    //   445: aload_0
    //   446: getfield 68	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   449: bipush 35
    //   451: invokevirtual 324	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   454: checkcast 651	com/tencent/mobileqq/redtouch/RedTouchManager
    //   457: aload_3
    //   458: iconst_0
    //   459: aaload
    //   460: checkcast 92	java/lang/String
    //   463: invokevirtual 671	com/tencent/mobileqq/redtouch/RedTouchManager:a	(Ljava/lang/String;)Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   466: invokevirtual 668	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:toByteArray	()[B
    //   469: aastore
    //   470: areturn
    //   471: aload_3
    //   472: ifnull -260 -> 212
    //   475: iconst_1
    //   476: anewarray 4	java/lang/Object
    //   479: dup
    //   480: iconst_0
    //   481: aload_0
    //   482: getfield 68	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   485: bipush 35
    //   487: invokevirtual 324	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   490: checkcast 651	com/tencent/mobileqq/redtouch/RedTouchManager
    //   493: aload_3
    //   494: iconst_0
    //   495: aaload
    //   496: checkcast 397	java/lang/Integer
    //   499: invokevirtual 618	java/lang/Integer:intValue	()I
    //   502: invokevirtual 674	com/tencent/mobileqq/redtouch/RedTouchManager:a	(I)Z
    //   505: invokestatic 109	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   508: aastore
    //   509: areturn
    //   510: aload_3
    //   511: ifnull -299 -> 212
    //   514: aload_3
    //   515: arraylength
    //   516: bipush 6
    //   518: if_icmplt +1211 -> 1729
    //   521: aload_3
    //   522: iconst_5
    //   523: aaload
    //   524: checkcast 105	java/lang/Boolean
    //   527: invokevirtual 639	java/lang/Boolean:booleanValue	()Z
    //   530: istore 8
    //   532: aload_0
    //   533: getfield 68	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   536: aload_3
    //   537: iconst_0
    //   538: aaload
    //   539: checkcast 397	java/lang/Integer
    //   542: invokevirtual 618	java/lang/Integer:intValue	()I
    //   545: aload_3
    //   546: iconst_1
    //   547: aaload
    //   548: checkcast 397	java/lang/Integer
    //   551: invokevirtual 618	java/lang/Integer:intValue	()I
    //   554: aload_3
    //   555: iconst_2
    //   556: aaload
    //   557: checkcast 92	java/lang/String
    //   560: aload_3
    //   561: iconst_3
    //   562: aaload
    //   563: checkcast 92	java/lang/String
    //   566: aload_3
    //   567: iconst_4
    //   568: aaload
    //   569: checkcast 105	java/lang/Boolean
    //   572: invokevirtual 639	java/lang/Boolean:booleanValue	()Z
    //   575: invokestatic 126	com/tencent/mobileqq/nearpeople/mytab/NearbyMineHelper:a	(Lcom/tencent/common/app/AppInterface;IILjava/lang/String;Ljava/lang/String;Z)Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   578: astore_1
    //   579: iload 8
    //   581: ifeq -369 -> 212
    //   584: iconst_1
    //   585: anewarray 4	java/lang/Object
    //   588: dup
    //   589: iconst_0
    //   590: aload_1
    //   591: invokevirtual 668	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:toByteArray	()[B
    //   594: aastore
    //   595: areturn
    //   596: aload_3
    //   597: ifnull -385 -> 212
    //   600: aload_3
    //   601: iconst_0
    //   602: aaload
    //   603: checkcast 92	java/lang/String
    //   606: astore_1
    //   607: iconst_1
    //   608: anewarray 4	java/lang/Object
    //   611: dup
    //   612: iconst_0
    //   613: aload_0
    //   614: getfield 68	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   617: aload_1
    //   618: invokestatic 679	com/tencent/mobileqq/activity/recent/RecentUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Z
    //   621: invokestatic 109	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   624: aastore
    //   625: areturn
    //   626: aload_3
    //   627: ifnull -415 -> 212
    //   630: aload_3
    //   631: iconst_0
    //   632: aaload
    //   633: checkcast 92	java/lang/String
    //   636: astore_1
    //   637: aload_3
    //   638: iconst_1
    //   639: aaload
    //   640: checkcast 92	java/lang/String
    //   643: astore 4
    //   645: aload_3
    //   646: iconst_2
    //   647: aaload
    //   648: checkcast 397	java/lang/Integer
    //   651: invokevirtual 618	java/lang/Integer:intValue	()I
    //   654: istore_2
    //   655: aload_3
    //   656: iconst_3
    //   657: aaload
    //   658: checkcast 105	java/lang/Boolean
    //   661: invokevirtual 639	java/lang/Boolean:booleanValue	()Z
    //   664: istore 8
    //   666: aload_3
    //   667: iconst_4
    //   668: aaload
    //   669: checkcast 105	java/lang/Boolean
    //   672: invokevirtual 639	java/lang/Boolean:booleanValue	()Z
    //   675: istore 9
    //   677: aload_0
    //   678: getfield 68	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   681: aload_1
    //   682: aload 4
    //   684: iload_2
    //   685: iload 8
    //   687: iload 9
    //   689: invokestatic 684	com/tencent/mobileqq/app/message/AddMessageHelper:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;IZZ)V
    //   692: aconst_null
    //   693: areturn
    //   694: aload_3
    //   695: ifnull -483 -> 212
    //   698: aload_3
    //   699: iconst_0
    //   700: aaload
    //   701: checkcast 92	java/lang/String
    //   704: astore_1
    //   705: aload_3
    //   706: iconst_1
    //   707: aaload
    //   708: checkcast 92	java/lang/String
    //   711: astore 4
    //   713: aload_3
    //   714: iconst_2
    //   715: aaload
    //   716: checkcast 397	java/lang/Integer
    //   719: invokevirtual 618	java/lang/Integer:intValue	()I
    //   722: istore_2
    //   723: aload_0
    //   724: getfield 68	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   727: aload_1
    //   728: aload 4
    //   730: iload_2
    //   731: invokestatic 687	com/tencent/mobileqq/app/message/AddMessageHelper:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;I)V
    //   734: aconst_null
    //   735: areturn
    //   736: aload_3
    //   737: ifnull +9 -> 746
    //   740: aload_3
    //   741: arraylength
    //   742: iconst_2
    //   743: if_icmpge +15 -> 758
    //   746: iconst_1
    //   747: anewarray 4	java/lang/Object
    //   750: dup
    //   751: iconst_0
    //   752: iconst_0
    //   753: invokestatic 109	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   756: aastore
    //   757: areturn
    //   758: aload_0
    //   759: getfield 68	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   762: aload_0
    //   763: getfield 66	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppMessageObserver	Lcom/tencent/mobileqq/app/MessageObserver;
    //   766: invokevirtual 690	com/tencent/mobileqq/app/QQAppInterface:a	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   769: aload_0
    //   770: getfield 68	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   773: iconst_0
    //   774: invokevirtual 693	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   777: checkcast 695	com/tencent/mobileqq/app/MessageHandler
    //   780: aload_3
    //   781: iconst_0
    //   782: aaload
    //   783: checkcast 484	java/lang/Long
    //   786: invokevirtual 699	java/lang/Long:longValue	()J
    //   789: aload_3
    //   790: iconst_1
    //   791: aaload
    //   792: checkcast 397	java/lang/Integer
    //   795: invokevirtual 618	java/lang/Integer:intValue	()I
    //   798: iconst_1
    //   799: invokevirtual 702	com/tencent/mobileqq/app/MessageHandler:b	(JII)V
    //   802: iconst_1
    //   803: anewarray 4	java/lang/Object
    //   806: dup
    //   807: iconst_0
    //   808: iconst_1
    //   809: invokestatic 109	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   812: aastore
    //   813: areturn
    //   814: aload_3
    //   815: ifnull +9 -> 824
    //   818: aload_3
    //   819: arraylength
    //   820: iconst_1
    //   821: if_icmpge +15 -> 836
    //   824: iconst_1
    //   825: anewarray 4	java/lang/Object
    //   828: dup
    //   829: iconst_0
    //   830: iconst_0
    //   831: invokestatic 109	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   834: aastore
    //   835: areturn
    //   836: aload_0
    //   837: getfield 68	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   840: aload_0
    //   841: getfield 66	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppMessageObserver	Lcom/tencent/mobileqq/app/MessageObserver;
    //   844: invokevirtual 690	com/tencent/mobileqq/app/QQAppInterface:a	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   847: aload_0
    //   848: getfield 68	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   851: iconst_0
    //   852: invokevirtual 693	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   855: checkcast 695	com/tencent/mobileqq/app/MessageHandler
    //   858: aload_3
    //   859: iconst_0
    //   860: aaload
    //   861: checkcast 92	java/lang/String
    //   864: iconst_1
    //   865: invokevirtual 703	com/tencent/mobileqq/app/MessageHandler:a	(Ljava/lang/String;I)V
    //   868: iconst_1
    //   869: anewarray 4	java/lang/Object
    //   872: dup
    //   873: iconst_0
    //   874: iconst_1
    //   875: invokestatic 109	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   878: aastore
    //   879: areturn
    //   880: aload_3
    //   881: ifnull -669 -> 212
    //   884: aload_3
    //   885: arraylength
    //   886: iconst_1
    //   887: if_icmplt -675 -> 212
    //   890: iconst_1
    //   891: anewarray 4	java/lang/Object
    //   894: dup
    //   895: iconst_0
    //   896: aload_0
    //   897: getfield 68	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   900: bipush 15
    //   902: invokevirtual 324	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   905: checkcast 705	com/tencent/mobileqq/managers/ShieldMsgManger
    //   908: aload_3
    //   909: iconst_0
    //   910: aaload
    //   911: checkcast 92	java/lang/String
    //   914: invokevirtual 707	com/tencent/mobileqq/managers/ShieldMsgManger:a	(Ljava/lang/String;)Z
    //   917: invokestatic 109	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   920: aastore
    //   921: areturn
    //   922: aload_3
    //   923: ifnull -711 -> 212
    //   926: aload_3
    //   927: arraylength
    //   928: iconst_3
    //   929: if_icmplt -717 -> 212
    //   932: aload_3
    //   933: iconst_0
    //   934: aaload
    //   935: checkcast 92	java/lang/String
    //   938: astore 5
    //   940: aload_3
    //   941: iconst_1
    //   942: aaload
    //   943: ifnull +780 -> 1723
    //   946: aload_3
    //   947: iconst_1
    //   948: aaload
    //   949: checkcast 709	[B
    //   952: checkcast 709	[B
    //   955: astore_1
    //   956: new 504	tencent/im/oidb/cmd0x686/Oidb_0x686$CharmEvent
    //   959: dup
    //   960: invokespecial 710	tencent/im/oidb/cmd0x686/Oidb_0x686$CharmEvent:<init>	()V
    //   963: astore 4
    //   965: aload 4
    //   967: aload_1
    //   968: invokevirtual 714	tencent/im/oidb/cmd0x686/Oidb_0x686$CharmEvent:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   971: pop
    //   972: aload_3
    //   973: iconst_2
    //   974: aaload
    //   975: ifnull +743 -> 1718
    //   978: aload_3
    //   979: iconst_2
    //   980: aaload
    //   981: checkcast 709	[B
    //   984: checkcast 709	[B
    //   987: astore_3
    //   988: new 514	tencent/im/oidb/cmd0x686/Oidb_0x686$NearbyCharmNotify
    //   991: dup
    //   992: invokespecial 715	tencent/im/oidb/cmd0x686/Oidb_0x686$NearbyCharmNotify:<init>	()V
    //   995: astore_1
    //   996: aload_1
    //   997: aload_3
    //   998: invokevirtual 716	tencent/im/oidb/cmd0x686/Oidb_0x686$NearbyCharmNotify:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1001: pop
    //   1002: aload_0
    //   1003: getfield 68	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1006: aload 5
    //   1008: aload 4
    //   1010: aload_1
    //   1011: invokestatic 502	com/tencent/mobileqq/nearby/NearbyCardManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ltencent/im/oidb/cmd0x686/Oidb_0x686$CharmEvent;Ltencent/im/oidb/cmd0x686/Oidb_0x686$NearbyCharmNotify;)V
    //   1014: aconst_null
    //   1015: areturn
    //   1016: astore_1
    //   1017: aconst_null
    //   1018: astore_1
    //   1019: aload_1
    //   1020: astore 4
    //   1022: goto -50 -> 972
    //   1025: aload_3
    //   1026: ifnull -814 -> 212
    //   1029: aload_3
    //   1030: arraylength
    //   1031: iconst_1
    //   1032: if_icmplt -820 -> 212
    //   1035: aload_3
    //   1036: iconst_0
    //   1037: aaload
    //   1038: checkcast 709	[B
    //   1041: checkcast 709	[B
    //   1044: astore_3
    //   1045: new 534	tencent/im/oidb/cmd0x9c7/cmd0x9c7$RspBody
    //   1048: dup
    //   1049: invokespecial 717	tencent/im/oidb/cmd0x9c7/cmd0x9c7$RspBody:<init>	()V
    //   1052: astore_1
    //   1053: aload_1
    //   1054: aload_3
    //   1055: invokevirtual 718	tencent/im/oidb/cmd0x9c7/cmd0x9c7$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1058: pop
    //   1059: aload_0
    //   1060: aload_1
    //   1061: invokevirtual 720	com/tencent/mobileqq/nearby/NearbyProxy:a	(Ltencent/im/oidb/cmd0x9c7/cmd0x9c7$RspBody;)V
    //   1064: aconst_null
    //   1065: areturn
    //   1066: astore_3
    //   1067: aconst_null
    //   1068: astore_1
    //   1069: aload_3
    //   1070: invokevirtual 723	java/lang/Exception:printStackTrace	()V
    //   1073: goto -14 -> 1059
    //   1076: aload_3
    //   1077: ifnull -865 -> 212
    //   1080: aload_3
    //   1081: arraylength
    //   1082: iconst_1
    //   1083: if_icmplt -871 -> 212
    //   1086: aload_3
    //   1087: iconst_0
    //   1088: aaload
    //   1089: instanceof 725
    //   1092: ifeq -880 -> 212
    //   1095: aload_3
    //   1096: iconst_0
    //   1097: aaload
    //   1098: checkcast 725	java/lang/Byte
    //   1101: invokevirtual 729	java/lang/Byte:byteValue	()B
    //   1104: ifne +6 -> 1110
    //   1107: iconst_1
    //   1108: istore 8
    //   1110: aload_0
    //   1111: iload 8
    //   1113: invokevirtual 731	com/tencent/mobileqq/nearby/NearbyProxy:a	(Z)V
    //   1116: aconst_null
    //   1117: areturn
    //   1118: aload_0
    //   1119: getfield 334	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqNearbyNearbyConfigUtil	Lcom/tencent/mobileqq/nearby/NearbyConfigUtil;
    //   1122: ifnull -910 -> 212
    //   1125: aload_0
    //   1126: getfield 334	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqNearbyNearbyConfigUtil	Lcom/tencent/mobileqq/nearby/NearbyConfigUtil;
    //   1129: invokevirtual 733	com/tencent/mobileqq/nearby/NearbyConfigUtil:a	()V
    //   1132: aconst_null
    //   1133: areturn
    //   1134: aload_3
    //   1135: ifnull -923 -> 212
    //   1138: aload_3
    //   1139: arraylength
    //   1140: iconst_1
    //   1141: if_icmpne -929 -> 212
    //   1144: aload_3
    //   1145: iconst_0
    //   1146: aaload
    //   1147: instanceof 709
    //   1150: ifeq -938 -> 212
    //   1153: aload_3
    //   1154: iconst_0
    //   1155: aaload
    //   1156: checkcast 709	[B
    //   1159: checkcast 709	[B
    //   1162: astore_3
    //   1163: aload_3
    //   1164: ifnull -952 -> 212
    //   1167: aload_3
    //   1168: arraylength
    //   1169: ifle -957 -> 212
    //   1172: new 735	EncounterSvc/RespEncounterInfo
    //   1175: dup
    //   1176: invokespecial 736	EncounterSvc/RespEncounterInfo:<init>	()V
    //   1179: astore_1
    //   1180: aload_1
    //   1181: new 738	com/qq/taf/jce/JceInputStream
    //   1184: dup
    //   1185: aload_3
    //   1186: invokespecial 741	com/qq/taf/jce/JceInputStream:<init>	([B)V
    //   1189: invokevirtual 745	EncounterSvc/RespEncounterInfo:readFrom	(Lcom/qq/taf/jce/JceInputStream;)V
    //   1192: aload_0
    //   1193: getfield 68	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1196: bipush 105
    //   1198: invokevirtual 324	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1201: checkcast 499	com/tencent/mobileqq/nearby/NearbyCardManager
    //   1204: astore_3
    //   1205: aload_3
    //   1206: ifnull -994 -> 212
    //   1209: aload_3
    //   1210: aload_1
    //   1211: invokevirtual 748	com/tencent/mobileqq/nearby/NearbyCardManager:a	(LEncounterSvc/RespEncounterInfo;)V
    //   1214: aconst_null
    //   1215: areturn
    //   1216: astore_1
    //   1217: aload_1
    //   1218: invokevirtual 723	java/lang/Exception:printStackTrace	()V
    //   1221: aconst_null
    //   1222: areturn
    //   1223: aload_0
    //   1224: getfield 750	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager	Lcom/tencent/mobileqq/app/ConditionSearchManager;
    //   1227: ifnonnull +19 -> 1246
    //   1230: aload_0
    //   1231: aload_0
    //   1232: getfield 68	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1235: bipush 58
    //   1237: invokevirtual 324	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1240: checkcast 752	com/tencent/mobileqq/app/ConditionSearchManager
    //   1243: putfield 750	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager	Lcom/tencent/mobileqq/app/ConditionSearchManager;
    //   1246: aload_0
    //   1247: new 754	tib
    //   1250: dup
    //   1251: aload_0
    //   1252: invokespecial 755	tib:<init>	(Lcom/tencent/mobileqq/nearby/NearbyProxy;)V
    //   1255: putfield 757	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener	Lcom/tencent/mobileqq/app/ConditionSearchManager$IConfigListener;
    //   1258: aload_0
    //   1259: getfield 750	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager	Lcom/tencent/mobileqq/app/ConditionSearchManager;
    //   1262: aload_0
    //   1263: invokevirtual 760	com/tencent/mobileqq/app/ConditionSearchManager:a	(Ljava/lang/Object;)V
    //   1266: aload_0
    //   1267: getfield 750	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager	Lcom/tencent/mobileqq/app/ConditionSearchManager;
    //   1270: aload_0
    //   1271: getfield 757	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener	Lcom/tencent/mobileqq/app/ConditionSearchManager$IConfigListener;
    //   1274: invokevirtual 762	com/tencent/mobileqq/app/ConditionSearchManager:c	(Ljava/lang/Object;)V
    //   1277: aconst_null
    //   1278: areturn
    //   1279: aload_3
    //   1280: ifnull -1068 -> 212
    //   1283: aload_3
    //   1284: arraylength
    //   1285: iconst_1
    //   1286: if_icmpne -1074 -> 212
    //   1289: aload_3
    //   1290: iconst_0
    //   1291: aaload
    //   1292: checkcast 92	java/lang/String
    //   1295: astore_1
    //   1296: aload_0
    //   1297: getfield 750	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager	Lcom/tencent/mobileqq/app/ConditionSearchManager;
    //   1300: ifnull +25 -> 1325
    //   1303: iconst_1
    //   1304: anewarray 4	java/lang/Object
    //   1307: dup
    //   1308: iconst_0
    //   1309: aload_0
    //   1310: getfield 750	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager	Lcom/tencent/mobileqq/app/ConditionSearchManager;
    //   1313: aload_1
    //   1314: ldc_w 764
    //   1317: invokevirtual 768	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1320: invokevirtual 771	com/tencent/mobileqq/app/ConditionSearchManager:a	([Ljava/lang/String;)[Ljava/lang/String;
    //   1323: aastore
    //   1324: areturn
    //   1325: aload_0
    //   1326: getfield 750	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager	Lcom/tencent/mobileqq/app/ConditionSearchManager;
    //   1329: ifnull -1117 -> 212
    //   1332: aload_0
    //   1333: getfield 750	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager	Lcom/tencent/mobileqq/app/ConditionSearchManager;
    //   1336: aload_0
    //   1337: invokevirtual 773	com/tencent/mobileqq/app/ConditionSearchManager:b	(Ljava/lang/Object;)V
    //   1340: aload_0
    //   1341: getfield 757	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener	Lcom/tencent/mobileqq/app/ConditionSearchManager$IConfigListener;
    //   1344: ifnull -1132 -> 212
    //   1347: aload_0
    //   1348: getfield 750	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager	Lcom/tencent/mobileqq/app/ConditionSearchManager;
    //   1351: aload_0
    //   1352: getfield 757	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener	Lcom/tencent/mobileqq/app/ConditionSearchManager$IConfigListener;
    //   1355: invokevirtual 775	com/tencent/mobileqq/app/ConditionSearchManager:d	(Ljava/lang/Object;)V
    //   1358: aconst_null
    //   1359: areturn
    //   1360: aload_0
    //   1361: getfield 68	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1364: bipush 105
    //   1366: invokevirtual 324	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1369: checkcast 499	com/tencent/mobileqq/nearby/NearbyCardManager
    //   1372: iconst_1
    //   1373: putfield 776	com/tencent/mobileqq/nearby/NearbyCardManager:a	Z
    //   1376: aconst_null
    //   1377: areturn
    //   1378: aload_3
    //   1379: ifnull -1167 -> 212
    //   1382: aload_3
    //   1383: arraylength
    //   1384: bipush 6
    //   1386: if_icmpne -1174 -> 212
    //   1389: aload_3
    //   1390: iconst_0
    //   1391: aaload
    //   1392: checkcast 397	java/lang/Integer
    //   1395: invokevirtual 618	java/lang/Integer:intValue	()I
    //   1398: istore_2
    //   1399: aload_3
    //   1400: iconst_1
    //   1401: aaload
    //   1402: checkcast 92	java/lang/String
    //   1405: astore 4
    //   1407: aload_3
    //   1408: iconst_2
    //   1409: aaload
    //   1410: checkcast 92	java/lang/String
    //   1413: astore 5
    //   1415: aload_3
    //   1416: iconst_3
    //   1417: aaload
    //   1418: checkcast 92	java/lang/String
    //   1421: astore 6
    //   1423: aload_3
    //   1424: iconst_4
    //   1425: aaload
    //   1426: checkcast 92	java/lang/String
    //   1429: astore 7
    //   1431: aload_3
    //   1432: iconst_5
    //   1433: aaload
    //   1434: checkcast 92	java/lang/String
    //   1437: astore_3
    //   1438: aload_1
    //   1439: aload_0
    //   1440: getfield 68	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1443: iload_2
    //   1444: aload 4
    //   1446: aload 5
    //   1448: aload 6
    //   1450: aload 7
    //   1452: aload_3
    //   1453: invokestatic 781	com/tencent/biz/webviewplugin/ReportPlugin:a	(Landroid/content/Context;Lcom/tencent/mobileqq/app/QQAppInterface;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1456: aconst_null
    //   1457: areturn
    //   1458: aload_3
    //   1459: ifnull -1247 -> 212
    //   1462: aload_3
    //   1463: arraylength
    //   1464: iconst_1
    //   1465: if_icmpne -1253 -> 212
    //   1468: aload_0
    //   1469: aload_3
    //   1470: iconst_0
    //   1471: aaload
    //   1472: checkcast 105	java/lang/Boolean
    //   1475: invokevirtual 639	java/lang/Boolean:booleanValue	()Z
    //   1478: invokevirtual 783	com/tencent/mobileqq/nearby/NearbyProxy:c	(Z)V
    //   1481: aconst_null
    //   1482: areturn
    //   1483: astore_1
    //   1484: aload_1
    //   1485: invokevirtual 723	java/lang/Exception:printStackTrace	()V
    //   1488: aconst_null
    //   1489: areturn
    //   1490: aload_3
    //   1491: ifnull -1279 -> 212
    //   1494: aload_3
    //   1495: arraylength
    //   1496: iconst_1
    //   1497: if_icmpne -1285 -> 212
    //   1500: aload_0
    //   1501: getfield 68	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1504: sipush 159
    //   1507: invokevirtual 324	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1510: checkcast 785	com/tencent/mobileqq/nearby/redtouch/LocalRedTouchManager
    //   1513: aload_3
    //   1514: iconst_0
    //   1515: aaload
    //   1516: checkcast 397	java/lang/Integer
    //   1519: invokevirtual 618	java/lang/Integer:intValue	()I
    //   1522: invokevirtual 788	com/tencent/mobileqq/nearby/redtouch/LocalRedTouchManager:a	(I)Lcom/tencent/mobileqq/nearby/redtouch/RedTouchItem;
    //   1525: astore_1
    //   1526: aload_1
    //   1527: ifnull -1315 -> 212
    //   1530: bipush 11
    //   1532: anewarray 4	java/lang/Object
    //   1535: dup
    //   1536: iconst_0
    //   1537: aload_1
    //   1538: getfield 793	com/tencent/mobileqq/nearby/redtouch/RedTouchItem:taskId	I
    //   1541: invokestatic 400	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1544: aastore
    //   1545: dup
    //   1546: iconst_1
    //   1547: aload_1
    //   1548: getfield 796	com/tencent/mobileqq/nearby/redtouch/RedTouchItem:curSeq	J
    //   1551: invokestatic 487	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1554: aastore
    //   1555: dup
    //   1556: iconst_2
    //   1557: aload_1
    //   1558: getfield 799	com/tencent/mobileqq/nearby/redtouch/RedTouchItem:redtouchType	I
    //   1561: invokestatic 400	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1564: aastore
    //   1565: dup
    //   1566: iconst_3
    //   1567: aload_1
    //   1568: getfield 802	com/tencent/mobileqq/nearby/redtouch/RedTouchItem:count	I
    //   1571: invokestatic 400	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1574: aastore
    //   1575: dup
    //   1576: iconst_4
    //   1577: aload_1
    //   1578: getfield 805	com/tencent/mobileqq/nearby/redtouch/RedTouchItem:icon	Ljava/lang/String;
    //   1581: aastore
    //   1582: dup
    //   1583: iconst_5
    //   1584: aload_1
    //   1585: getfield 808	com/tencent/mobileqq/nearby/redtouch/RedTouchItem:tips	Ljava/lang/String;
    //   1588: aastore
    //   1589: dup
    //   1590: bipush 6
    //   1592: aload_1
    //   1593: getfield 811	com/tencent/mobileqq/nearby/redtouch/RedTouchItem:receiveTime	J
    //   1596: invokestatic 487	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1599: aastore
    //   1600: dup
    //   1601: bipush 7
    //   1603: aload_1
    //   1604: getfield 814	com/tencent/mobileqq/nearby/redtouch/RedTouchItem:validTimeRemained	I
    //   1607: invokestatic 400	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1610: aastore
    //   1611: dup
    //   1612: bipush 8
    //   1614: aload_1
    //   1615: getfield 817	com/tencent/mobileqq/nearby/redtouch/RedTouchItem:unReadFlag	Z
    //   1618: invokestatic 109	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1621: aastore
    //   1622: dup
    //   1623: bipush 9
    //   1625: aload_1
    //   1626: getfield 820	com/tencent/mobileqq/nearby/redtouch/RedTouchItem:passThroughLevel	I
    //   1629: invokestatic 400	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1632: aastore
    //   1633: dup
    //   1634: bipush 10
    //   1636: aload_1
    //   1637: getfield 823	com/tencent/mobileqq/nearby/redtouch/RedTouchItem:configVersion	Ljava/lang/String;
    //   1640: aastore
    //   1641: areturn
    //   1642: aload_3
    //   1643: ifnull -1431 -> 212
    //   1646: aload_3
    //   1647: arraylength
    //   1648: iconst_1
    //   1649: if_icmpne -1437 -> 212
    //   1652: aload_3
    //   1653: iconst_0
    //   1654: aaload
    //   1655: checkcast 709	[B
    //   1658: checkcast 709	[B
    //   1661: astore_1
    //   1662: aload_0
    //   1663: getfield 68	com/tencent/mobileqq/nearby/NearbyProxy:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1666: sipush 179
    //   1669: invokevirtual 324	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1672: checkcast 326	com/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarManager
    //   1675: aload_1
    //   1676: invokevirtual 825	com/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarManager:a	([B)V
    //   1679: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1682: ifeq -1470 -> 212
    //   1685: ldc_w 306
    //   1688: iconst_2
    //   1689: ldc_w 827
    //   1692: invokestatic 312	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1695: aconst_null
    //   1696: areturn
    //   1697: astore_3
    //   1698: goto -629 -> 1069
    //   1701: astore_1
    //   1702: aconst_null
    //   1703: astore_1
    //   1704: goto -702 -> 1002
    //   1707: astore_3
    //   1708: goto -706 -> 1002
    //   1711: astore_1
    //   1712: aload 4
    //   1714: astore_1
    //   1715: goto -696 -> 1019
    //   1718: aconst_null
    //   1719: astore_1
    //   1720: goto -718 -> 1002
    //   1723: aconst_null
    //   1724: astore 4
    //   1726: goto -754 -> 972
    //   1729: iconst_0
    //   1730: istore 8
    //   1732: goto -1200 -> 532
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1735	0	this	NearbyProxy
    //   0	1735	1	paramContext	Context
    //   0	1735	2	paramInt	int
    //   0	1735	3	paramVarArgs	Object[]
    //   331	1394	4	localObject	Object
    //   938	509	5	str1	String
    //   1421	28	6	str2	String
    //   1429	22	7	str3	String
    //   1	1730	8	bool1	boolean
    //   675	13	9	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   946	965	1016	java/lang/Throwable
    //   1035	1053	1066	java/lang/Exception
    //   1172	1205	1216	java/lang/Exception
    //   1209	1214	1216	java/lang/Exception
    //   1468	1481	1483	java/lang/Exception
    //   1053	1059	1697	java/lang/Exception
    //   978	996	1701	java/lang/Throwable
    //   996	1002	1707	java/lang/Throwable
    //   965	972	1711	java/lang/Throwable
  }
  
  public void b()
  {
    if (ConnectNearbyProcService.a()) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(4100, new Object[] { Integer.valueOf(7) });
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        NearbyUtils.a("hasUnreadMsg", new Object[] { Boolean.valueOf(ConnectNearbyProcService.a()) });
      }
      return;
      NearbyRelevantHandler localNearbyRelevantHandler = (NearbyRelevantHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(66);
      if (localNearbyRelevantHandler != null) {
        localNearbyRelevantHandler.b();
      }
    }
  }
  
  public void b(NearbyProxyObserver paramNearbyProxyObserver)
  {
    synchronized (this.jdField_b_of_type_JavaUtilList)
    {
      if (this.jdField_b_of_type_JavaUtilList.contains(paramNearbyProxyObserver)) {
        this.jdField_b_of_type_JavaUtilList.remove(paramNearbyProxyObserver);
      }
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (this.jdField_a_of_type_JavaUtilList.contains(paramNearbyProxyObserver)) {
        this.jdField_a_of_type_JavaUtilList.remove(paramNearbyProxyObserver);
      }
      return;
      paramNearbyProxyObserver = finally;
      throw paramNearbyProxyObserver;
    }
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramString)) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.jdField_b_of_type_Int = i;
      NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramBoolean);
      if ((!paramBoolean) && (ConnectNearbyProcService.a())) {
        a(4127);
      }
      return;
    }
  }
  
  public boolean b()
  {
    if (this.jdField_b_of_type_Int == Integer.MIN_VALUE) {
      if (!NearbySPUtil.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) {
        break label39;
      }
    }
    label39:
    for (int i = 1;; i = 0)
    {
      this.jdField_b_of_type_Int = i;
      if (this.jdField_b_of_type_Int != 1) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public void c(boolean paramBoolean)
  {
    boolean bool = RNPreDownloadFacade.a();
    if (NearbyUtils.b()) {
      NearbyUtils.a(jdField_a_of_type_JavaLangString, new Object[] { "checkAndPreDownloadRn", Boolean.valueOf(bool), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface });
    }
    if (bool)
    {
      a(4143, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L) });
      return;
    }
    RNPreDownloadFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, paramBoolean, new tia(this), true);
  }
  
  public void d()
  {
    a(4142);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppShieldListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\NearbyProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */