package com.tencent.mobileqq.troop.utils;

import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;
import java.util.List;

public class NearbyTroopMemMgr
{
  protected static HashMap a;
  protected long a;
  protected NearbyTroopMemMgr.RadarInstanceState a;
  protected String a;
  protected boolean a;
  protected long b;
  
  private NearbyTroopMemMgr(String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Long = 900000L;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyTroopMemMgr$RadarInstanceState = new NearbyTroopMemMgr.RadarInstanceState(this);
  }
  
  public static NearbyTroopMemMgr a(String paramString)
  {
    try
    {
      if (jdField_a_of_type_JavaUtilHashMap == null) {
        jdField_a_of_type_JavaUtilHashMap = new HashMap();
      }
      NearbyTroopMemMgr localNearbyTroopMemMgr2 = (NearbyTroopMemMgr)jdField_a_of_type_JavaUtilHashMap.get(paramString);
      NearbyTroopMemMgr localNearbyTroopMemMgr1 = localNearbyTroopMemMgr2;
      if (localNearbyTroopMemMgr2 == null)
      {
        localNearbyTroopMemMgr1 = new NearbyTroopMemMgr(paramString);
        jdField_a_of_type_JavaUtilHashMap.put(paramString, localNearbyTroopMemMgr1);
      }
      return localNearbyTroopMemMgr1;
    }
    finally {}
  }
  
  public static void a()
  {
    try
    {
      if (jdField_a_of_type_JavaUtilHashMap == null) {
        return;
      }
      jdField_a_of_type_JavaUtilHashMap.clear();
      return;
    }
    finally {}
  }
  
  public NearbyTroopMemMgr.RadarInstanceState a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyTroopMemMgr$RadarInstanceState;
  }
  
  public void a(String paramString, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    ((BizTroopHandler)paramQQAppInterface.a(22)).d(paramString, paramBoolean);
    if (paramBoolean) {
      this.b = System.currentTimeMillis();
    }
  }
  
  public void a(List paramList1, List paramList2, int paramInt, long paramLong, double paramDouble1, double paramDouble2, boolean paramBoolean, double paramDouble3, double paramDouble4)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyTroopMemMgr$RadarInstanceState.jdField_a_of_type_JavaUtilList = paramList1;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyTroopMemMgr$RadarInstanceState.jdField_b_of_type_JavaUtilList = paramList2;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyTroopMemMgr$RadarInstanceState.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyTroopMemMgr$RadarInstanceState.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyTroopMemMgr$RadarInstanceState.jdField_a_of_type_Double = paramDouble1;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyTroopMemMgr$RadarInstanceState.jdField_b_of_type_Double = paramDouble2;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyTroopMemMgr$RadarInstanceState.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyTroopMemMgr$RadarInstanceState.c = paramDouble3;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyTroopMemMgr$RadarInstanceState.d = paramDouble4;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public boolean a()
  {
    if (System.currentTimeMillis() - this.b > this.jdField_a_of_type_Long) {}
    while (!this.jdField_a_of_type_Boolean) {
      return true;
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\utils\NearbyTroopMemMgr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */