package com.tencent.biz.pubaccount.readinjoy.struct;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;

public class ReadinjoyVideoReportData
{
  public static final int c = 0;
  public static final int d = 1;
  public static final int e = 2;
  public float a;
  public int a;
  public long a;
  public Long a;
  public String a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public boolean b;
  public long c;
  public long d;
  public long e;
  public int f;
  public long f;
  public int g;
  public long g;
  public long h;
  public long i;
  public long j;
  public long k;
  public long l;
  public long m;
  
  public ReadinjoyVideoReportData()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_f_of_type_Int = 0;
  }
  
  public HashMap a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_articleID", String.valueOf(this.jdField_a_of_type_JavaLangLong));
    localHashMap.put("param_vid", this.jdField_a_of_type_JavaLangString);
    localHashMap.put("param_busiType", String.valueOf(this.jdField_a_of_type_Int));
    localHashMap.put("param_success", String.valueOf(this.jdField_a_of_type_Boolean).toLowerCase());
    localHashMap.put("param_playDuration", String.valueOf(this.jdField_b_of_type_Long));
    localHashMap.put("param_prepareDuration", String.valueOf(this.d));
    localHashMap.put("param_bufferTime", String.valueOf(this.jdField_f_of_type_Long));
    localHashMap.put("param_errCode", this.jdField_b_of_type_JavaLangString);
    localHashMap.put("param_playCompleteRate", String.valueOf(this.jdField_a_of_type_Float));
    localHashMap.put("param_bufferCount", String.valueOf(this.jdField_b_of_type_Int));
    localHashMap.put("param_sceneType", String.valueOf(this.jdField_f_of_type_Int));
    localHashMap.put("param_httpDNSTime", String.valueOf(this.g));
    localHashMap.put("param_httpRedirectTime", String.valueOf(this.h));
    localHashMap.put("param_cacheFrameTime", String.valueOf(this.i));
    localHashMap.put("param_vid2UrlTime", String.valueOf(this.j));
    localHashMap.put("param_firstRecvTime", String.valueOf(this.k));
    localHashMap.put("param_mp4HeaderTime", String.valueOf(this.l));
    localHashMap.put("param_httpConnectTime", String.valueOf(this.m));
    return localHashMap;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\readinjoy\struct\ReadinjoyVideoReportData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */