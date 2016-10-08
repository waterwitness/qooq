package com.tencent.mobileqq.service.message;

import android.util.SparseArray;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class DecodeProtoPkgContext
  extends PBDecodeContext
{
  public static final int b = 1000;
  public static final int c = 1001;
  public int a;
  public long a;
  private SparseArray a;
  public boolean a;
  public long b;
  public boolean b;
  public long c;
  public boolean c;
  public long d;
  public boolean d;
  public boolean e;
  public boolean f;
  public boolean g;
  public boolean h;
  
  public DecodeProtoPkgContext(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.g = true;
    this.jdField_a_of_type_Long = paramLong1;
    this.e = paramLong2;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.b = paramBoolean2;
    this.c = paramBoolean3;
    this.d = paramBoolean4;
  }
  
  public Object a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray != null) {
      return this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    }
    return null;
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
      this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    }
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramObject);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\service\message\DecodeProtoPkgContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */