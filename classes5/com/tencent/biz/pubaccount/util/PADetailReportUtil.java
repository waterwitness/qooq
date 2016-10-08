package com.tencent.biz.pubaccount.util;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.HashMap;

public class PADetailReportUtil
{
  public static final int a = 100;
  static PADetailReportUtil jdField_a_of_type_ComTencentBizPubaccountUtilPADetailReportUtil;
  public static final String a = "PADetailReportUtil";
  static ByteBuffer jdField_a_of_type_JavaNioByteBuffer = ByteBuffer.allocate(8);
  public static final int b = 200;
  public static final String b = "1.0";
  public static final int c = 300;
  public static final String c = "actSearchExposure";
  public static final int d = 400;
  public static final String d = "actSearchNet";
  public static final int e = 1;
  public static final String e = "actSearchNetClick";
  public static final int f = 2;
  public static final String f = "actSearchSubscribe";
  public static final int g = 3;
  public static final String g = "pubacc_class";
  public static final int h = 4;
  static final String h = "sVer";
  static final String jdField_i_of_type_JavaLangString = "sSearch";
  static final String jdField_j_of_type_JavaLangString = "sKey";
  static final String jdField_k_of_type_JavaLangString = "sCurTime";
  static final String jdField_l_of_type_JavaLangString = "sPScene";
  static final String jdField_m_of_type_JavaLangString = "sScene";
  static final String jdField_n_of_type_JavaLangString = "sItemListPage";
  static final String jdField_o_of_type_JavaLangString = "sItemListStart";
  static final String jdField_p_of_type_JavaLangString = "sItemlist";
  static final String jdField_q_of_type_JavaLangString = "sItem";
  static final String r = "sItemPos";
  static final String s = "sDirect";
  static final String t = "sFolder";
  static final String u = "sFrom";
  long jdField_a_of_type_Long;
  int jdField_i_of_type_Int;
  int jdField_j_of_type_Int;
  int jdField_k_of_type_Int;
  int jdField_l_of_type_Int;
  int jdField_m_of_type_Int;
  int jdField_n_of_type_Int;
  int jdField_o_of_type_Int;
  int jdField_p_of_type_Int;
  int jdField_q_of_type_Int;
  String v;
  String w;
  String x;
  String y;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private PADetailReportUtil()
  {
    this.q = 1;
  }
  
  public static PADetailReportUtil a()
  {
    if (jdField_a_of_type_ComTencentBizPubaccountUtilPADetailReportUtil == null) {
      jdField_a_of_type_ComTencentBizPubaccountUtilPADetailReportUtil = new PADetailReportUtil();
    }
    return jdField_a_of_type_ComTencentBizPubaccountUtilPADetailReportUtil;
  }
  
  public String a(String paramString1, String paramString2)
  {
    try
    {
      if ((!this.w.equals(paramString2)) || (this.v == null))
      {
        paramString1 = MD5.toMD5Byte(paramString1 + String.valueOf(System.currentTimeMillis()) + Math.random());
        jdField_a_of_type_JavaNioByteBuffer.put(paramString1, 0, 8);
        jdField_a_of_type_JavaNioByteBuffer.flip();
        this.q = 0;
        long l1 = jdField_a_of_type_JavaNioByteBuffer.getLong();
        return String.valueOf(l1);
      }
    }
    catch (Exception paramString1) {}
    return null;
  }
  
  public void a()
  {
    this.v = null;
    this.w = null;
    this.k = 0;
    this.l = 0;
    this.m = 0;
    this.n = 0;
  }
  
  public void a(int paramInt)
  {
    a();
    long l1 = System.currentTimeMillis();
    HashMap localHashMap = new HashMap();
    localHashMap.put("sVer", "1.0");
    localHashMap.put("sScene", String.valueOf(paramInt));
    localHashMap.put("sCurTime", String.valueOf(l1));
    a("actSearchExposure", localHashMap);
    this.l = paramInt;
    this.i = paramInt;
    this.q = 0;
    if (QLog.isDevelopLevel()) {
      QLog.d("PADetailReportUtil", 4, "start report entrance event cur view:" + paramInt + ", time:" + l1);
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    long l1 = System.currentTimeMillis();
    HashMap localHashMap = new HashMap();
    localHashMap.put("sVer", "1.0");
    localHashMap.put("sSearch", this.v);
    localHashMap.put("sKey", this.w);
    localHashMap.put("sCurTime", String.valueOf(l1));
    localHashMap.put("sItem", paramString);
    localHashMap.put("sPScene", String.valueOf(this.l));
    localHashMap.put("sScene", String.valueOf(this.i + paramInt1));
    localHashMap.put("sItemPos", String.valueOf(paramInt2));
    if (paramInt3 == 12) {
      localHashMap.put("sFolder", "1");
    }
    for (;;)
    {
      a("actSearchNetClick", localHashMap);
      this.k = this.l;
      this.l = (this.i + paramInt1);
      this.o = paramInt2;
      this.y = paramString;
      if (QLog.isDevelopLevel()) {
        QLog.d("PADetailReportUtil", 4, "start report click event searchID:" + this.v + ", superview:" + this.k + ", thisview:" + this.l + ", itemPos:" + this.o + ", time:" + l1 + ", itemID:" + this.y + ", from:" + paramInt3);
      }
      return;
      localHashMap.put("sFolder", "0");
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    HashMap localHashMap = new HashMap();
    localHashMap.put("sVer", "1.0");
    localHashMap.put("sSearch", this.v);
    localHashMap.put("sKey", this.w);
    localHashMap.put("sCurTime", String.valueOf(l1));
    localHashMap.put("sPScene", String.valueOf(this.l));
    localHashMap.put("sScene", String.valueOf(this.i + paramInt1));
    localHashMap.put("sDirect", String.valueOf(paramInt2));
    localHashMap.put("sItem", paramString);
    if (paramInt3 == 12)
    {
      localHashMap.put("sFolder", "1");
      if (!paramBoolean) {
        break label308;
      }
      localHashMap.put("sFrom", "1");
    }
    for (;;)
    {
      a("actSearchSubscribe", localHashMap);
      this.k = this.l;
      this.l = (this.i + paramInt1);
      this.y = paramString;
      this.p = paramInt2;
      if (QLog.isDevelopLevel()) {
        QLog.d("PADetailReportUtil", 4, "start report attention event searchID:" + this.v + ", superview:" + this.k + ", thisview:" + this.l + ", itemID:" + this.y + ", isDirectClick:" + this.p + ", time" + l1 + ", from:" + paramInt3 + ", isoffline:" + paramBoolean);
      }
      return;
      localHashMap.put("sFolder", "0");
      break;
      label308:
      localHashMap.put("sFrom", "0");
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, boolean paramBoolean, int paramInt2, String paramString3)
  {
    long l1;
    HashMap localHashMap;
    if (paramInt1 == 3)
    {
      this.q += 1;
      this.n = ((this.q - 1) * paramInt2);
      l1 = System.currentTimeMillis();
      localHashMap = new HashMap();
      localHashMap.put("sVer", "1.0");
      if (paramString1 == null) {
        break label371;
      }
      localHashMap.put("sSearch", paramString1);
      label65:
      localHashMap.put("sCurTime", String.valueOf(l1));
      localHashMap.put("sKey", paramString2);
      localHashMap.put("sPScene", String.valueOf(this.l));
      localHashMap.put("sScene", String.valueOf(this.i + paramInt1));
      if (this.q == 0) {
        break label386;
      }
      localHashMap.put("sItemListPage", String.valueOf(this.q));
      localHashMap.put("sItemListStart", String.valueOf((this.q - 1) * paramInt2));
    }
    for (;;)
    {
      localHashMap.put("sItemlist", paramString3);
      a("actSearchNet", localHashMap);
      this.k = this.l;
      this.l = (this.i + paramInt1);
      if (paramString1 != null) {
        this.v = paramString1;
      }
      this.w = paramString2;
      this.m = this.q;
      this.x = paramString3;
      if (QLog.isDevelopLevel())
      {
        QLog.d("PADetailReportUtil", 4, "start report searchpage searchID:" + this.v + " superview:" + this.k + ", thisview:" + this.l + ", search:" + this.w);
        QLog.d("PADetailReportUtil", 4, "pagenum:" + this.m + ", startPos:" + this.n + ", itemList:" + this.x + ", time:" + l1);
      }
      return;
      this.q = 0;
      break;
      label371:
      localHashMap.put("sSearch", this.v);
      break label65;
      label386:
      localHashMap.put("sItemListPage", "1");
      localHashMap.put("sItemListStart", "0");
    }
  }
  
  public void a(String paramString, HashMap paramHashMap)
  {
    StatisticCollector.a(BaseApplicationImpl.a()).a(null, paramString, true, 0L, 0L, paramHashMap, null);
  }
  
  public void b()
  {
    this.q = 0;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\util\PADetailReportUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */