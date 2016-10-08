package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;

public class NetReq
{
  public static final int d = 0;
  public static final int e = 1;
  public static final int f = 2;
  public static final int g = 0;
  public static final int h = 1;
  public static final int i = 2;
  public long a;
  public INetEngine.IBreakDownFix a;
  public INetEngine.INetEngineListener a;
  public NetResp a;
  public OutputStream a;
  public Object a;
  public HashMap a;
  public List a;
  public byte[] a;
  public long b;
  private Object b;
  public String b;
  public long c;
  public String c;
  public long d;
  public String d;
  public boolean d;
  public String e;
  public boolean e;
  public boolean f;
  public boolean g;
  public boolean h;
  public boolean i;
  int j;
  public boolean j;
  public int k;
  public int l;
  public int m;
  public int n;
  public int o;
  
  public NetReq()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.j = 1;
    this.e = true;
    this.d = 480000L;
    this.k = 8;
    this.l = 5;
    this.m = 1;
    this.g = true;
    this.h = true;
    this.i = true;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public Object a()
  {
    try
    {
      Object localObject1 = this.jdField_b_of_type_JavaLangObject;
      return localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
  }
  
  public void a(Object paramObject)
  {
    try
    {
      this.jdField_b_of_type_JavaLangObject = paramObject;
      return;
    }
    finally
    {
      paramObject = finally;
      throw ((Throwable)paramObject);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_b_of_type_JavaLangString != null) || (this.jdField_a_of_type_JavaIoOutputStream != null);
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_JavaLangString != null;
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_JavaIoOutputStream != null;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\transfile\NetReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */