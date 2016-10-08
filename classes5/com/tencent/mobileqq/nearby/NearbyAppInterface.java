package com.tencent.mobileqq.nearby;

import EncounterSvc.RespEncounterInfo;
import EncounterSvc.UserDetailLocalInfo;
import QQService.VipBaseInfo;
import QQService.VipOpenInfo;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.FaceHandler;
import com.tencent.mobileqq.app.NearbyHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarInfoHandler;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager;
import com.tencent.mobileqq.config.NearbyDataManager;
import com.tencent.mobileqq.dating.AnchorageManager;
import com.tencent.mobileqq.dating.DatingHandler;
import com.tencent.mobileqq.dating.DatingManager;
import com.tencent.mobileqq.dating.RankEventManager;
import com.tencent.mobileqq.freshnews.FreshNewsHandler;
import com.tencent.mobileqq.freshnews.FreshNewsManager;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.nearby.flat.async.UIElementCache;
import com.tencent.mobileqq.nearby.ipc.NearbyProcManager;
import com.tencent.mobileqq.nearby.ipc.NearbyProcObserver;
import com.tencent.mobileqq.nearby.rn.NearbyRNAppManager;
import com.tencent.mobileqq.nearpeople.mytab.NearbyMineHelper;
import com.tencent.mobileqq.nearpeople.mytab.NearbyMyTabCard;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.rn.RNAppManager;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.NetEngineFactory;
import com.tencent.mobileqq.util.FaceManager;
import com.tencent.mobileqq.util.IIconDecoder;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import mqq.app.AccountManagerImpl;
import mqq.app.IToolProcEventListener;
import mqq.app.ProxyIpManagerImpl;
import mqq.app.TicketManagerImpl;
import mqq.app.WtloginManagerImpl;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import thi;
import thj;
import thk;
import thl;

public class NearbyAppInterface
  extends AppInterface
  implements IToolProcEventListener
{
  public static UIElementCache a;
  public static final String a;
  public static boolean a;
  public static boolean b;
  public int a;
  public long a;
  public RespEncounterInfo a;
  public UserDetailLocalInfo a;
  private AnchorageManager jdField_a_of_type_ComTencentMobileqqDatingAnchorageManager;
  private RankEventManager jdField_a_of_type_ComTencentMobileqqDatingRankEventManager;
  public NearbyEntityManagerFactory a;
  private NearbyIconDecoder jdField_a_of_type_ComTencentMobileqqNearbyNearbyIconDecoder;
  public NearbyService a;
  private NearbyTransFileController jdField_a_of_type_ComTencentMobileqqNearbyNearbyTransFileController;
  NearbyMyTabCard jdField_a_of_type_ComTencentMobileqqNearpeopleMytabNearbyMyTabCard;
  private NetEngineFactory jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory;
  public Object a;
  HashMap jdField_a_of_type_JavaUtilHashMap;
  public List a;
  Map jdField_a_of_type_JavaUtilMap = new HashMap(20);
  thl jdField_a_of_type_Thl = null;
  int jdField_b_of_type_Int = Integer.MIN_VALUE;
  private Object jdField_b_of_type_JavaLangObject = new Object();
  String jdField_b_of_type_JavaLangString = null;
  public List b;
  int jdField_c_of_type_Int = 0;
  private Object jdField_c_of_type_JavaLangObject = new Object();
  public List c;
  public boolean c;
  int jdField_d_of_type_Int = 0;
  private Object jdField_d_of_type_JavaLangObject = new Object();
  public boolean d;
  boolean e = false;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = NearbyAppInterface.class.getSimpleName();
    jdField_a_of_type_Boolean = true;
    jdField_b_of_type_Boolean = true;
    jdField_a_of_type_ComTencentMobileqqNearbyFlatAsyncUIElementCache = new UIElementCache();
  }
  
  public NearbyAppInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    super(paramBaseApplicationImpl, paramString);
    this.jdField_a_of_type_Int = 0;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_d_of_type_Boolean = false;
  }
  
  /* Error */
  private String a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +13 -> 14
    //   4: aload 4
    //   6: ifnull +8 -> 14
    //   9: aload 5
    //   11: ifnonnull +6 -> 17
    //   14: ldc 107
    //   16: areturn
    //   17: aload_1
    //   18: ldc 109
    //   20: invokevirtual 115	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   23: ifeq +13 -> 36
    //   26: aload_2
    //   27: invokevirtual 119	java/lang/String:length	()I
    //   30: ifle +6 -> 36
    //   33: ldc 121
    //   35: areturn
    //   36: aload_1
    //   37: ldc 109
    //   39: invokevirtual 115	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   42: ifeq +31 -> 73
    //   45: aload 8
    //   47: invokestatic 127	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   50: ifne +9 -> 59
    //   53: aload 8
    //   55: invokestatic 133	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   58: pop2
    //   59: aload 9
    //   61: invokestatic 127	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   64: ifne +9 -> 73
    //   67: aload 9
    //   69: invokestatic 133	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   72: pop2
    //   73: aconst_null
    //   74: areturn
    //   75: astore_1
    //   76: ldc -121
    //   78: areturn
    //   79: astore_1
    //   80: ldc -119
    //   82: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	NearbyAppInterface
    //   0	83	1	paramString1	String
    //   0	83	2	paramString2	String
    //   0	83	3	paramString3	String
    //   0	83	4	paramString4	String
    //   0	83	5	paramString5	String
    //   0	83	6	paramInt1	int
    //   0	83	7	paramInt2	int
    //   0	83	8	paramString6	String
    //   0	83	9	paramString7	String
    //   0	83	10	paramString8	String
    //   0	83	11	paramString9	String
    // Exception table:
    //   from	to	target	type
    //   53	59	75	java/lang/Exception
    //   67	73	79	java/lang/Exception
  }
  
  public static void b()
  {
    if (BaseApplicationImpl.a != null)
    {
      int i = BaseApplicationImpl.a.size() * 3 / 4;
      BaseApplicationImpl.a.trimToSize(i);
    }
  }
  
  public int a()
  {
    return AppSetting.jdField_a_of_type_Int;
  }
  
  public long a()
  {
    a();
    return this.jdField_a_of_type_EncounterSvcRespEncounterInfo.tiny_id;
  }
  
  public RespEncounterInfo a()
  {
    if (this.jdField_a_of_type_EncounterSvcRespEncounterInfo == null)
    {
      this.jdField_a_of_type_EncounterSvcRespEncounterInfo = new RespEncounterInfo();
      this.jdField_a_of_type_EncounterSvcRespEncounterInfo.tiny_id = ((Long)NearbySPUtil.a(getAccount(), "self_tinnyid", Long.valueOf(0L))).longValue();
      int i = ((Integer)NearbySPUtil.a(getAccount(), "self_age", Integer.valueOf(0))).intValue();
      this.jdField_a_of_type_EncounterSvcRespEncounterInfo.cAge = ((byte)i);
      i = ((Integer)NearbySPUtil.a(getAccount(), "self_gender", Integer.valueOf(0))).intValue();
      this.jdField_a_of_type_EncounterSvcRespEncounterInfo.cSex = ((byte)(i - 1));
      this.jdField_a_of_type_EncounterSvcRespEncounterInfo.strNick = ((String)NearbySPUtil.a(getAccount(), "self_nick", String.valueOf("")));
      this.jdField_a_of_type_EncounterSvcRespEncounterInfo.strSchoolName = ((String)NearbySPUtil.a(getAccount(), "self_school_name", String.valueOf("")));
    }
    return this.jdField_a_of_type_EncounterSvcRespEncounterInfo;
  }
  
  public BusinessHandler a(int paramInt)
  {
    BusinessHandler localBusinessHandler = (BusinessHandler)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    if (localBusinessHandler == null) {}
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        localBusinessHandler = (BusinessHandler)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
        if (localBusinessHandler == null) {
          break label137;
        }
        return localBusinessHandler;
        if (localBusinessHandler != null) {
          this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localBusinessHandler);
        }
        return localBusinessHandler;
      }
      Object localObject2 = new NearbyHandler(this);
      continue;
      localObject2 = new FreshNewsHandler(this);
      continue;
      localObject2 = new DatingHandler(this);
      continue;
      localObject2 = new FaceHandler(this);
      continue;
      localObject2 = new DynamicAvatarInfoHandler(this);
      continue;
      return (BusinessHandler)localObject2;
      label137:
      switch (paramInt)
      {
      }
    }
  }
  
  public AnchorageManager a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDatingAnchorageManager != null) {
      return this.jdField_a_of_type_ComTencentMobileqqDatingAnchorageManager;
    }
    synchronized (this.jdField_c_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDatingAnchorageManager == null) {
        this.jdField_a_of_type_ComTencentMobileqqDatingAnchorageManager = new AnchorageManager();
      }
      return this.jdField_a_of_type_ComTencentMobileqqDatingAnchorageManager;
    }
  }
  
  public RankEventManager a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDatingRankEventManager != null) {
      return this.jdField_a_of_type_ComTencentMobileqqDatingRankEventManager;
    }
    synchronized (this.jdField_d_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDatingRankEventManager == null) {
        this.jdField_a_of_type_ComTencentMobileqqDatingRankEventManager = new RankEventManager(this);
      }
      return this.jdField_a_of_type_ComTencentMobileqqDatingRankEventManager;
    }
  }
  
  public NearbyTransFileController a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyTransFileController == null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyTransFileController = new NearbyTransFileController(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyTransFileController;
  }
  
  public NearbyProcManager a()
  {
    return (NearbyProcManager)getManager(213);
  }
  
  public NearbyMyTabCard a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqNearpeopleMytabNearbyMyTabCard;
  }
  
  public EntityManagerFactory a()
  {
    return a(getAccount());
  }
  
  public EntityManagerFactory a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!paramString.equals(getAccount()))) {
      throw new IllegalStateException("Can not create a entity factory, the account is not match." + paramString + "!=" + getAccount());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyEntityManagerFactory != null) {
      return this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyEntityManagerFactory;
    }
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyEntityManagerFactory == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyEntityManagerFactory = new NearbyEntityManagerFactory(paramString);
        ThreadManager.b().postDelayed(new thi(this), 1000L);
      }
      return this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyEntityManagerFactory;
    }
  }
  
  public INetEngine a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory == null) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory = ((NetEngineFactory)getManager(210));
    }
    return this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory.a(this, paramInt);
  }
  
  public IIconDecoder a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyIconDecoder == null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyIconDecoder = new NearbyIconDecoder(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyIconDecoder;
  }
  
  public BaseApplication a()
  {
    return this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
  }
  
  public String a()
  {
    return getAccount();
  }
  
  public List a(int paramInt)
  {
    if (paramInt == 1) {
      return this.jdField_a_of_type_JavaUtilList;
    }
    if (paramInt == 2) {
      return this.jdField_b_of_type_JavaUtilList;
    }
    if (paramInt == 0) {
      return this.jdField_c_of_type_JavaUtilList;
    }
    return this.jdField_c_of_type_JavaUtilList;
  }
  
  public void a()
  {
    NearbyMyTabCard localNearbyMyTabCard = b();
    if (localNearbyMyTabCard != null)
    {
      localNearbyMyTabCard.visitors.clear();
      NearbyMineHelper.a(this, localNearbyMyTabCard);
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt)) != null) {
      this.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(paramInt));
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      NearbyUtils.a("updatePerfState", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(this.jdField_c_of_type_Int) });
    }
    if (paramInt1 > this.jdField_c_of_type_Int)
    {
      this.jdField_c_of_type_Int = paramInt1;
      if (this.jdField_c_of_type_Int == 1)
      {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        this.jdField_d_of_type_Int = paramInt2;
      }
    }
  }
  
  public void a(RespEncounterInfo paramRespEncounterInfo)
  {
    if (paramRespEncounterInfo == null) {
      return;
    }
    this.jdField_a_of_type_EncounterSvcRespEncounterInfo = paramRespEncounterInfo;
    if (paramRespEncounterInfo.tiny_id != 0L) {
      NearbySPUtil.a(getAccount(), "self_tinnyid", Long.valueOf(paramRespEncounterInfo.tiny_id));
    }
    if (!TextUtils.isEmpty(paramRespEncounterInfo.strNick)) {
      NearbySPUtil.a(getAccount(), "self_nick", paramRespEncounterInfo.strNick);
    }
    if (paramRespEncounterInfo.cAge != -1) {
      NearbySPUtil.a(getAccount(), "self_age", Integer.valueOf(paramRespEncounterInfo.cAge));
    }
    int i;
    if (paramRespEncounterInfo.cSex != -1) {
      switch (paramRespEncounterInfo.cSex)
      {
      default: 
        i = 0;
      }
    }
    for (;;)
    {
      NearbySPUtil.a(getAccount(), "self_gender", Integer.valueOf(i));
      a().a(paramRespEncounterInfo);
      return;
      i = 1;
      continue;
      i = 2;
    }
  }
  
  public void a(BusinessObserver paramBusinessObserver)
  {
    a(paramBusinessObserver, false);
  }
  
  public void a(BusinessObserver paramBusinessObserver, boolean paramBoolean)
  {
    if (paramBoolean) {
      if (!this.jdField_b_of_type_JavaUtilList.contains(paramBusinessObserver)) {
        this.jdField_b_of_type_JavaUtilList.add(paramBusinessObserver);
      }
    }
    while (this.jdField_a_of_type_JavaUtilList.contains(paramBusinessObserver)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.add(paramBusinessObserver);
  }
  
  public void a(NearbyProcObserver paramNearbyProcObserver)
  {
    NearbyProcManager localNearbyProcManager = (NearbyProcManager)getManager(213);
    if (localNearbyProcManager != null) {
      localNearbyProcManager.a(paramNearbyProcObserver);
    }
  }
  
  public void a(NearbyMyTabCard paramNearbyMyTabCard)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearpeopleMytabNearbyMyTabCard != paramNearbyMyTabCard) {
      this.jdField_a_of_type_ComTencentMobileqqNearpeopleMytabNearbyMyTabCard = paramNearbyMyTabCard;
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyService.a(paramToServiceMsg);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyService.a(paramFromServiceMsg.isSuccess(), paramToServiceMsg, paramFromServiceMsg, null);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    String str = a(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
    if (!TextUtils.isEmpty(str)) {
      throw new IllegalArgumentException(str);
    }
    a().a(false, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
  }
  
  public boolean a()
  {
    Object localObject = this.jdField_a_of_type_EncounterSvcRespEncounterInfo;
    if ((localObject == null) || (((RespEncounterInfo)localObject).vipBaseInfo == null) || (((RespEncounterInfo)localObject).vipBaseInfo.mOpenInfo == null)) {
      return false;
    }
    localObject = (VipOpenInfo)((RespEncounterInfo)localObject).vipBaseInfo.mOpenInfo.get(Integer.valueOf(3));
    return (localObject != null) && (((VipOpenInfo)localObject).bOpen);
  }
  
  protected void addManager(int paramInt, Manager paramManager)
  {
    if (this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt)) != null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), paramManager);
  }
  
  public int b()
  {
    if (this.jdField_b_of_type_Int == Integer.MIN_VALUE) {
      this.jdField_b_of_type_Int = ((Integer)NearbySPUtil.a(getAccount(), "sp_nearby_mytab", 0, "key_nearby_mytab_zan_check", Integer.valueOf(0))).intValue();
    }
    return this.jdField_b_of_type_Int;
  }
  
  public NearbyMyTabCard b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearpeopleMytabNearbyMyTabCard == null) {
      this.jdField_a_of_type_ComTencentMobileqqNearpeopleMytabNearbyMyTabCard = NearbyMineHelper.a(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqNearpeopleMytabNearbyMyTabCard;
  }
  
  public String b()
  {
    RespEncounterInfo localRespEncounterInfo = this.jdField_a_of_type_EncounterSvcRespEncounterInfo;
    if (localRespEncounterInfo == null) {
      return getAccount();
    }
    return localRespEncounterInfo.strNick;
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    NearbySPUtil.a(getAccount(), "sp_nearby_mytab", 0, "key_nearby_mytab_zan_check", Integer.valueOf(this.jdField_b_of_type_Int));
  }
  
  public void b(BusinessObserver paramBusinessObserver)
  {
    this.jdField_a_of_type_JavaUtilList.remove(paramBusinessObserver);
    this.jdField_b_of_type_JavaUtilList.remove(paramBusinessObserver);
    this.jdField_c_of_type_JavaUtilList.remove(paramBusinessObserver);
  }
  
  public void b(NearbyProcObserver paramNearbyProcObserver)
  {
    NearbyProcManager localNearbyProcManager = (NearbyProcManager)getManager(213);
    if (localNearbyProcManager != null) {
      localNearbyProcManager.b(paramNearbyProcObserver);
    }
  }
  
  public void b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    String str = a(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
    if (!TextUtils.isEmpty(str)) {
      throw new IllegalArgumentException(str);
    }
    a().a(true, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
  }
  
  public boolean b()
  {
    Object localObject = this.jdField_a_of_type_EncounterSvcRespEncounterInfo;
    if ((localObject == null) || (((RespEncounterInfo)localObject).vipBaseInfo == null) || (((RespEncounterInfo)localObject).vipBaseInfo.mOpenInfo == null)) {
      return false;
    }
    localObject = (VipOpenInfo)((RespEncounterInfo)localObject).vipBaseInfo.mOpenInfo.get(Integer.valueOf(1));
    return (localObject != null) && (((VipOpenInfo)localObject).bOpen);
  }
  
  public void c()
  {
    try
    {
      AccessibilityManager localAccessibilityManager = (AccessibilityManager)this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getSystemService("accessibility");
      boolean bool1 = localAccessibilityManager.isEnabled();
      boolean bool2 = localAccessibilityManager.isTouchExplorationEnabled();
      if ((bool1) && (bool2)) {}
      for (bool1 = true;; bool1 = false)
      {
        AppSetting.j = bool1;
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "set talkback enable: " + AppSetting.j);
        }
        return;
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public void c(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    String str = a(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
    if (!TextUtils.isEmpty(str)) {
      throw new IllegalArgumentException(str);
    }
    ThreadManager.a(new thk(this, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9), 2, null, false);
  }
  
  public boolean c()
  {
    boolean bool = true;
    String[] arrayOfString;
    if (this.jdField_b_of_type_JavaLangString == null)
    {
      this.jdField_b_of_type_JavaLangString = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.nearby_react_native_config.name(), "0");
      if (NearbyUtils.b()) {
        NearbyUtils.a(jdField_a_of_type_JavaLangString, new Object[] { "isCloseRn", this.jdField_b_of_type_JavaLangString });
      }
      if (this.jdField_b_of_type_JavaLangString != null)
      {
        arrayOfString = this.jdField_b_of_type_JavaLangString.split("\\|");
        if ((arrayOfString == null) || (arrayOfString.length <= 0)) {}
      }
    }
    for (;;)
    {
      try
      {
        if (Integer.parseInt(arrayOfString[0]) != 1) {
          continue;
        }
        this.e = bool;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      return this.e;
      bool = false;
    }
  }
  
  protected void finalize()
  {
    super.finalize();
    NearbyEntityManagerFactory localNearbyEntityManagerFactory = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyEntityManagerFactory;
    if (localNearbyEntityManagerFactory != null) {
      localNearbyEntityManagerFactory.close();
    }
  }
  
  public Manager getManager(int paramInt)
  {
    if ((paramInt == 217) && (RNAppManager.a(this)))
    {
      RNAppManager.a();
      a(217);
    }
    Object localObject1 = (Manager)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
    Object localObject3;
    if (localObject1 == null)
    {
      Map localMap = this.jdField_a_of_type_JavaUtilMap;
      switch (paramInt)
      {
      }
      for (;;)
      {
        try
        {
          if (this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt)) == null) {
            break label411;
          }
          localObject4 = (Manager)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
          return (Manager)localObject4;
        }
        finally {}
        localObject1 = new AccountManagerImpl(this);
        continue;
        localObject3 = new WtloginManagerImpl(this);
        continue;
        localObject3 = new TicketManagerImpl(this);
        continue;
        localObject3 = new ProxyIpManagerImpl(this);
        continue;
        localObject3 = new NearbyDataManager(this);
        continue;
        localObject3 = new NetEngineFactory();
        continue;
        localObject3 = new FreshNewsManager(this);
        continue;
        localObject3 = new DatingManager(this);
        continue;
        localObject3 = new NearbyProcManager(this);
        continue;
        localObject3 = new DeviceProfileManager.AccountDpcManager(this);
        continue;
        localObject3 = new FaceManager(this);
        continue;
        localObject3 = new OldBigDataChannelManager(this);
        continue;
        localObject3 = new NearbyRNAppManager(this);
        continue;
        localObject3 = new NearbyReportManager(this);
        continue;
        localObject3 = new DynamicAvatarManager(this);
        continue;
        label411:
        Object localObject4 = localObject3;
        if (localObject3 != null)
        {
          this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), localObject3);
          localObject4 = localObject3;
        }
      }
    }
    return (Manager)localObject3;
  }
  
  public String getModuleId()
  {
    return "module_nearby";
  }
  
  public void onBeforeExitProc() {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyService = new NearbyService(this);
    this.jdField_a_of_type_JavaUtilList = new Vector();
    this.jdField_b_of_type_JavaUtilList = new Vector();
    this.jdField_c_of_type_JavaUtilList = new Vector();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap(20);
    ((NearbyProcManager)getManager(213)).a();
    ThreadManager.a(new thj(this), 8, null, true);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqHighwayHwEngine != null) {
      this.jdField_a_of_type_ComTencentMobileqqHighwayHwEngine.closeEngine();
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_d_of_type_Boolean)
      {
        DeviceProfileManager.a(this, 214).b(this);
        synchronized (this.jdField_a_of_type_JavaUtilMap)
        {
          Object localObject2 = this.jdField_a_of_type_JavaUtilMap.keySet();
          if ((localObject2 == null) || (((Set)localObject2).size() <= 0)) {
            break label182;
          }
          localObject2 = ((Set)localObject2).iterator();
          do
          {
            for (;;)
            {
              boolean bool = ((Iterator)localObject2).hasNext();
              if (!bool) {
                break label182;
              }
              try
              {
                Manager localManager = (Manager)this.jdField_a_of_type_JavaUtilMap.get(((Iterator)localObject2).next());
                if (localManager != null) {
                  localManager.onDestroy();
                }
              }
              catch (Exception localException)
              {
                localException.printStackTrace();
              }
            }
          } while (!QLog.isColorLevel());
          NearbyUtils.a(jdField_a_of_type_JavaLangString, new Object[] { "onDestroy", localException.toString() });
        }
      }
      this.jdField_d_of_type_Boolean = true;
    }
    label182:
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
  
  public boolean onReceiveAccountAction(String paramString, Intent paramIntent)
  {
    NearbyUtils.a("onReceiveAccountAction", new Object[0]);
    return false;
  }
  
  public boolean onReceiveLegalExitProcAction()
  {
    NearbyUtils.a("onReceiveLegalExitProcAction", new Object[0]);
    return false;
  }
  
  public void start(boolean paramBoolean)
  {
    this.jdField_a_of_type_Thl = new thl(this, null);
    AppNetConnInfo.registerConnectionChangeReceiver(getApplication(), this.jdField_a_of_type_Thl);
    super.start(paramBoolean);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\NearbyAppInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */