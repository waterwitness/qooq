package com.tencent.mobileqq.util;

import AvatarInfo.QQHeadInfo;
import android.graphics.Bitmap;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import vxx;

public abstract class FaceDecoderBase
{
  static final int jdField_a_of_type_Int = 5;
  static final long jdField_a_of_type_Long = 300000L;
  static final String jdField_a_of_type_JavaLangString = FaceDecoderBase.class.getSimpleName();
  Hashtable jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  public LinkedList a;
  public vxx a;
  public boolean a;
  public int b;
  Hashtable jdField_b_of_type_JavaUtilHashtable = new Hashtable();
  boolean jdField_b_of_type_Boolean = false;
  public int c;
  boolean c;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public FaceDecoderBase()
  {
    this.jdField_b_of_type_Int = 10;
    this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
    this.jdField_a_of_type_Vxx = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
  }
  
  public abstract Bitmap a(int paramInt1, String paramString, int paramInt2, byte paramByte);
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      NearbyUtils.a(2, jdField_a_of_type_JavaLangString, "cancelPendingRequests", new Object[0]);
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  public abstract void a(int paramInt1, String paramString, int paramInt2, long paramLong);
  
  public abstract void a(AppInterface paramAppInterface);
  
  protected void a(FaceInfo paramFaceInfo)
  {
    if (paramFaceInfo == null) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "enqueueDecode, iRunningRequests=" + this.jdField_c_of_type_Int + ", pause=" + this.jdField_a_of_type_Boolean + ",faceinfo=" + paramFaceInfo.toString());
      }
      try
      {
        this.jdField_a_of_type_JavaUtilLinkedList.remove(paramFaceInfo);
        if (paramFaceInfo.jdField_b_of_type_Boolean)
        {
          this.jdField_a_of_type_JavaUtilLinkedList.addLast(paramFaceInfo);
          paramFaceInfo.a(FaceInfo.j);
          if ((this.jdField_c_of_type_Int >= this.jdField_b_of_type_Int) || (this.jdField_a_of_type_Boolean)) {
            continue;
          }
          e();
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel())
          {
            QLog.e(jdField_a_of_type_JavaLangString, 2, "enqueueDecode", localException);
            continue;
            this.jdField_a_of_type_JavaUtilLinkedList.addFirst(paramFaceInfo);
          }
        }
      }
    }
  }
  
  public void a(vxx paramvxx)
  {
    this.jdField_a_of_type_Vxx = paramvxx;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(String paramString, int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, byte paramByte, int paramInt3)
  {
    return a(paramString, paramInt1, paramBoolean1, paramInt2, paramBoolean2, paramByte, paramInt3, false);
  }
  
  public abstract boolean a(String paramString, int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, byte paramByte, int paramInt3, QQHeadInfo paramQQHeadInfo);
  
  public boolean a(String paramString, int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, byte paramByte, int paramInt3, boolean paramBoolean3)
  {
    if ((paramString == null) || (paramString.length() < 5))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "requestDecodeFace fail. type=" + paramInt2 + ", uin=" + paramString);
      }
      return false;
    }
    String str = FaceInfo.a(paramInt2, paramString, paramInt1);
    FaceInfo localFaceInfo = (FaceInfo)this.jdField_a_of_type_JavaUtilHashtable.get(str);
    if ((localFaceInfo != null) && (!localFaceInfo.a(FaceInfo.i, 300000L)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "requestDecodeFace, uin repeat. uin=" + paramString);
      }
      if ((localFaceInfo.jdField_b_of_type_Boolean) && (!paramBoolean2)) {
        localFaceInfo.jdField_b_of_type_Boolean = false;
      }
      return true;
    }
    int i = 3;
    if (paramInt3 == 0) {
      if (paramInt2 != 101)
      {
        paramInt3 = i;
        if (paramInt2 != 1001) {
          break label181;
        }
      }
    }
    for (paramInt3 = 1;; paramInt3 = (byte)paramInt3)
    {
      label181:
      paramString = new FaceInfo(paramInt2, paramString, paramBoolean2, paramByte, paramInt3, false, paramInt1, paramBoolean3);
      paramString.a(FaceInfo.i);
      this.jdField_a_of_type_JavaUtilHashtable.put(str, paramString);
      a(paramString);
      return true;
    }
  }
  
  public abstract boolean a(ArrayList paramArrayList);
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "resume");
    }
    this.jdField_a_of_type_Boolean = false;
    while ((this.jdField_c_of_type_Int < this.jdField_b_of_type_Int) && (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty())) {
      e();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      NearbyUtils.a(2, jdField_a_of_type_JavaLangString, "cancelPendingRequests", new Object[0]);
    }
    this.jdField_a_of_type_JavaUtilHashtable.clear();
    this.jdField_a_of_type_JavaUtilLinkedList.clear();
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      NearbyUtils.a(2, jdField_a_of_type_JavaLangString, "destory", new Object[0]);
    }
    c();
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_Vxx = null;
    this.jdField_a_of_type_Boolean = false;
  }
  
  protected abstract void e();
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\util\FaceDecoderBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */