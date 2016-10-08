package com.tencent.open.business.viareport;

import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.APNUtil;

public class BatchReportInfo
{
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  
  public BatchReportInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = "";
    this.b = "";
    this.c = "";
    this.d = "";
    this.e = "";
    this.f = "";
    this.g = "";
    this.h = "";
    this.i = "";
    this.j = "";
    this.k = "";
    this.l = "";
  }
  
  public String a()
  {
    if (TextUtils.isEmpty(this.f)) {
      return APNUtil.a(CommonDataAdapter.a().a());
    }
    return this.f;
  }
  
  public boolean a()
  {
    return (!TextUtils.isEmpty(this.c)) && (!TextUtils.isEmpty(this.a)) && (!TextUtils.isEmpty(this.f)) && (!TextUtils.isEmpty(this.g)) && (!TextUtils.isEmpty(this.d)) && (!TextUtils.isEmpty(this.b));
  }
  
  public String toString()
  {
    return this.d + "_" + this.a + "_" + this.b + "_" + this.c + "_" + this.f + "_" + this.g;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\business\viareport\BatchReportInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */