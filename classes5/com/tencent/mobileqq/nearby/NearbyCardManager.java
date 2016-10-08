package com.tencent.mobileqq.nearby;

import EncounterSvc.RespEncounterInfo;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.hotchat.PttShowRoomMng;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0x686.Oidb_0x686.CharmEvent;
import tencent.im.oidb.cmd0x686.Oidb_0x686.NearbyCharmNotify;
import thm;

public class NearbyCardManager
  implements Manager
{
  static final long jdField_a_of_type_Long = 300000L;
  static final long jdField_b_of_type_Long = 300000L;
  int jdField_a_of_type_Int;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  public boolean a;
  int jdField_b_of_type_Int;
  public ConcurrentHashMap b;
  
  public NearbyCardManager(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = Integer.MIN_VALUE;
    this.jdField_b_of_type_Int = Integer.MIN_VALUE;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.nearby_people_card.", 4, "updateNearbyProfileCardHead");
    }
    paramQQAppInterface.a(paramQQAppInterface.a(), 200);
    EntityManager localEntityManager = paramQQAppInterface.a(paramQQAppInterface.getAccount()).createEntityManager();
    if (localEntityManager != null)
    {
      NearbyPeopleCard localNearbyPeopleCard = (NearbyPeopleCard)localEntityManager.a(NearbyPeopleCard.class, "uin=?", new String[] { paramQQAppInterface.a() });
      if ((localNearbyPeopleCard != null) && (localNearbyPeopleCard.tinyId > 0L)) {
        paramQQAppInterface.a(String.valueOf(localNearbyPeopleCard.tinyId), 202);
      }
      localEntityManager.a();
    }
    ThreadManager.b().postDelayed(new thm(paramQQAppInterface), 2000L);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, Oidb_0x686.CharmEvent paramCharmEvent, Oidb_0x686.NearbyCharmNotify paramNearbyCharmNotify)
  {
    NearbyUtils.a("Q.nearby", "updateNearbyPeopleCard", new Object[] { paramString, paramCharmEvent, paramNearbyCharmNotify });
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString)) || ((paramCharmEvent == null) && (paramNearbyCharmNotify == null))) {}
    EntityManager localEntityManager;
    do
    {
      return;
      Object localObject = null;
      localEntityManager = paramQQAppInterface.a().createEntityManager();
      paramQQAppInterface = (QQAppInterface)localObject;
      if (!StringUtil.b(paramString)) {
        paramQQAppInterface = (NearbyPeopleCard)localEntityManager.a(NearbyPeopleCard.class, "uin=?", new String[] { paramString });
      }
    } while (paramQQAppInterface == null);
    if ((paramCharmEvent != null) && (paramCharmEvent.uint32_new_charm.get() > 0) && (paramCharmEvent.uint32_cur_level_threshold.get() > paramCharmEvent.uint32_next_level_threshold.get()))
    {
      paramQQAppInterface.charm = paramCharmEvent.uint32_new_charm.get();
      paramQQAppInterface.charmLevel = paramCharmEvent.uint32_new_charm_level.get();
      paramQQAppInterface.curThreshold = paramCharmEvent.uint32_cur_level_threshold.get();
      paramQQAppInterface.nextThreshold = paramCharmEvent.uint32_next_level_threshold.get();
    }
    for (;;)
    {
      localEntityManager.a(paramQQAppInterface);
      localEntityManager.a();
      return;
      if (paramNearbyCharmNotify != null)
      {
        paramQQAppInterface.charm = paramNearbyCharmNotify.uint32_new_charm.get();
        paramQQAppInterface.charmLevel = paramNearbyCharmNotify.uint32_new_charm_level.get();
        paramQQAppInterface.curThreshold = paramNearbyCharmNotify.uint32_cur_level_threshold.get();
        paramQQAppInterface.nextThreshold = paramNearbyCharmNotify.uint32_next_level_threshold.get();
        paramQQAppInterface.profPercent = paramNearbyCharmNotify.uint32_new_prof_percent.get();
      }
    }
  }
  
  public int a()
  {
    Card localCard;
    if (this.jdField_b_of_type_Int == Integer.MIN_VALUE)
    {
      localCard = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      if ((localCard != null) && ((localCard.age != 0) || (!TextUtils.isEmpty(localCard.strNick)))) {}
    }
    else
    {
      return this.jdField_b_of_type_Int;
    }
    if (Integer.MIN_VALUE != localCard.age) {}
    for (int i = localCard.age;; i = Integer.MIN_VALUE)
    {
      a(i);
      break;
    }
  }
  
  public int a(int paramInt)
  {
    int k = 0;
    int i = -1;
    int j;
    if (paramInt != 0)
    {
      j = k;
      if (paramInt != 1) {}
    }
    else
    {
      j = b();
      if (j != 1) {
        break label55;
      }
      i = 0;
    }
    for (;;)
    {
      if (i != 0)
      {
        j = k;
        if (i != 1) {}
      }
      else
      {
        if (i != 1) {
          break label67;
        }
        if (paramInt != 1) {
          break;
        }
        j = 3;
      }
      return j;
      label55:
      if (j == 2) {
        i = 1;
      }
    }
    return 2;
    label67:
    if (paramInt == 1) {
      return 1;
    }
    return 4;
  }
  
  public void a(int paramInt)
  {
    if (paramInt != this.jdField_b_of_type_Int)
    {
      this.jdField_b_of_type_Int = paramInt;
      NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "self_age", Integer.valueOf(this.jdField_b_of_type_Int));
    }
  }
  
  public void a(RespEncounterInfo paramRespEncounterInfo)
  {
    if (paramRespEncounterInfo == null) {
      return;
    }
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).createEntityManager();
    Object localObject2;
    Object localObject1;
    if (localEntityManager != null)
    {
      localObject2 = (NearbyPeopleCard)localEntityManager.a(NearbyPeopleCard.class, "uin=?", new String[] { this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() });
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (paramRespEncounterInfo.tiny_id > 0L) {
          localObject1 = (NearbyPeopleCard)localEntityManager.a(NearbyPeopleCard.class, "tinyId=?", new String[] { String.valueOf(paramRespEncounterInfo.tiny_id) });
        }
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new NearbyPeopleCard();
      }
      if (paramRespEncounterInfo.tiny_id > 0L)
      {
        ((NearbyPeopleCard)localObject2).tinyId = paramRespEncounterInfo.tiny_id;
        ((NearbyPeopleCard)localObject2).uin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      }
      ((NearbyPeopleCard)localObject2).likeCount = paramRespEncounterInfo.iVoteNum;
      ((NearbyPeopleCard)localObject2).likeCountInc = paramRespEncounterInfo.iVoteIncrement;
      ((NearbyPeopleCard)localObject2).gender = paramRespEncounterInfo.cSex;
      ((NearbyPeopleCard)localObject2).nickname = paramRespEncounterInfo.strNick;
      ((NearbyPeopleCard)localObject2).age = paramRespEncounterInfo.cAge;
      ((NearbyPeopleCard)localObject2).constellation = paramRespEncounterInfo.constellation;
      ((NearbyPeopleCard)localObject2).job = paramRespEncounterInfo.profession_id;
      ((NearbyPeopleCard)localObject2).maritalStatus = paramRespEncounterInfo.marriage;
      if (((NearbyPeopleCard)localObject2).getStatus() != 1000) {
        break label325;
      }
      localEntityManager.b((Entity)localObject2);
    }
    for (;;)
    {
      localObject1 = (Card)localEntityManager.a(Card.class, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      if (localObject1 != null)
      {
        ((Card)localObject1).iVoteIncrement = paramRespEncounterInfo.iVoteIncrement;
        ((Card)localObject1).lVoteCount = paramRespEncounterInfo.iVoteNum;
        ((Card)localObject1).vContent = paramRespEncounterInfo.vIntroContent;
        ((Card)localObject1).shType = paramRespEncounterInfo.shIntroType;
        NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), ((Card)localObject1).lVoteCount, ((Card)localObject1).iVoteIncrement);
        localEntityManager.a((Entity)localObject1);
      }
      localEntityManager.a();
      b(paramRespEncounterInfo.cSex);
      a(paramRespEncounterInfo.cAge);
      return;
      label325:
      if ((((NearbyPeopleCard)localObject2).getStatus() == 1001) || (((NearbyPeopleCard)localObject2).getStatus() == 1002)) {
        localEntityManager.a((Entity)localObject2);
      }
    }
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (!TextUtils.isEmpty(paramString))) {
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Integer.valueOf(1));
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramLong > 0L)) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Long.valueOf(paramLong));
    }
  }
  
  public boolean a()
  {
    return ((Boolean)NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "self_god_flag", Boolean.valueOf(false))).booleanValue();
  }
  
  public boolean a(NearbyPeopleCard paramNearbyPeopleCard)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramNearbyPeopleCard != null)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramNearbyPeopleCard.uin))
      {
        bool1 = bool2;
        if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramNearbyPeopleCard.uin))
        {
          this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramNearbyPeopleCard.uin);
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean a(NearbyPeopleCard paramNearbyPeopleCard, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    boolean bool = this.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Boolean = false;
    if (paramNearbyPeopleCard == null) {
      return true;
    }
    if (a(paramNearbyPeopleCard)) {
      return true;
    }
    if (TextUtils.isEmpty(paramNearbyPeopleCard.uin)) {
      return true;
    }
    if ((bool) && (paramString.equals(paramNearbyPeopleCard.uin))) {
      return true;
    }
    if (!paramBoolean3) {
      return true;
    }
    if ((paramBoolean1) || (paramBoolean2)) {
      return true;
    }
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramNearbyPeopleCard.uin)) {
      return true;
    }
    long l = ((Long)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramNearbyPeopleCard.uin)).longValue();
    l = SystemClock.elapsedRealtime() - l;
    if (Utils.a(paramString, paramNearbyPeopleCard.uin))
    {
      if (l >= 300000L) {
        return true;
      }
    }
    else if (l >= 300000L) {
      return true;
    }
    return false;
  }
  
  public int b()
  {
    Object localObject;
    int i;
    if (this.jdField_a_of_type_Int == Integer.MIN_VALUE)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).createEntityManager();
      Card localCard = (Card)((EntityManager)localObject).a(Card.class, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      if (localCard == null) {
        break label63;
      }
      i = localCard.shGender;
    }
    for (;;)
    {
      b(i);
      return this.jdField_a_of_type_Int;
      label63:
      localObject = (NearbyPeopleCard)((EntityManager)localObject).a(NearbyPeopleCard.class, "uin=?", new String[] { this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() });
      if (localObject != null) {
        i = ((NearbyPeopleCard)localObject).gender;
      } else {
        i = -1;
      }
    }
  }
  
  public void b(int paramInt)
  {
    int i = this.jdField_a_of_type_Int;
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_Int = 0;
    }
    for (;;)
    {
      if (i != this.jdField_a_of_type_Int)
      {
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(false);
        if (localObject != null)
        {
          localObject = ((HotChatManager)localObject).a(false);
          if (localObject != null) {
            ((PttShowRoomMng)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), null, paramInt, NetConnInfoCenter.getServerTime());
          }
        }
        NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "self_gender", Integer.valueOf(this.jdField_a_of_type_Int));
      }
      return;
      this.jdField_a_of_type_Int = 1;
      continue;
      this.jdField_a_of_type_Int = 2;
    }
  }
  
  public void b(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) || (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty())) {}
    while (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = null;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\NearbyCardManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */