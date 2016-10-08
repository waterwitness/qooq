package com.tencent.mfsdk.LeakInspector;

import android.text.TextUtils;
import com.tencent.commonsdk.pool.RecyclablePool.Recyclable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.WeakReference;

public class LeakInspector$InspectUUID
  extends RecyclablePool.Recyclable
{
  public String a;
  public WeakReference a;
  char[] a;
  String b;
  String c;
  
  public LeakInspector$InspectUUID()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = "";
    this.b = "";
    this.jdField_a_of_type_ArrayOfChar = null;
    this.c = "";
  }
  
  public void recycle()
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.b = "";
    this.jdField_a_of_type_ArrayOfChar = null;
    this.jdField_a_of_type_JavaLangString = "";
    this.c = "";
  }
  
  public String toString()
  {
    if (TextUtils.isEmpty(this.c))
    {
      StringBuilder localStringBuilder = new StringBuilder(64);
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append("@");
      if (this.jdField_a_of_type_ArrayOfChar != null) {
        localStringBuilder.append(this.jdField_a_of_type_ArrayOfChar);
      }
      if (!TextUtils.isEmpty(this.b))
      {
        localStringBuilder.append("_");
        localStringBuilder.append(this.b);
      }
      this.c = localStringBuilder.toString();
    }
    return this.c;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mfsdk\LeakInspector\LeakInspector$InspectUUID.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */