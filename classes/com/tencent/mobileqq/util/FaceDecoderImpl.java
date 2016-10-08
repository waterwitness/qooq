package com.tencent.mobileqq.util;

import AvatarInfo.QQHeadInfo;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionIconHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import vxx;
import vxz;
import vya;

public class FaceDecoderImpl
  extends FaceDecoderBase
  implements FaceDecodeTask.DecodeCompletionListener
{
  private static final String b = "Q.qqhead.FaceDecoderImpl";
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private vxz jdField_a_of_type_Vxz;
  private vya jdField_a_of_type_Vya;
  
  public FaceDecoderImpl(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_Int = 4;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public Bitmap a(int paramInt1, String paramString, int paramInt2, byte paramByte)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.FaceDecoderImpl", 2, "getBitmapFromCache, mApp is null");
      }
      return null;
    }
    if ((paramInt1 == 1001) && (paramString != null) && (!DiscussionIconHelper.a(paramString))) {}
    for (Object localObject = DiscussionIconHelper.a(paramString);; localObject = paramString)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1, (String)localObject, paramByte, paramInt2, true);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a((String)localObject);
      if ((localObject != null) && (paramInt1 == 1001))
      {
        DiscussionHandler localDiscussionHandler = (DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(6);
        if ((localDiscussionHandler != null) && (localDiscussionHandler.a() != null)) {
          localDiscussionHandler.a().g(paramString);
        }
        if (this.jdField_a_of_type_Vxz == null)
        {
          this.jdField_a_of_type_Vxz = new vxz(this, null);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_Vxz);
        }
      }
      return (Bitmap)localObject;
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramLong <= 0L) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    do
    {
      do
      {
        return;
      } while ((paramInt1 == 32) && (paramInt2 != 200) && (paramInt2 != 202) && (paramInt2 != 204));
      if (paramInt1 == 32) {}
      for (byte b1 = 1;; b1 = 0)
      {
        FaceInfo localFaceInfo = new FaceInfo(paramInt1, paramString, false, b1, 3, false, paramInt2);
        String str = FaceInfo.a(paramInt1, paramString, paramInt2);
        if (this.jdField_b_of_type_JavaUtilHashtable.get(str) == null) {
          this.jdField_b_of_type_JavaUtilHashtable.put(str, localFaceInfo);
        }
        if (this.jdField_a_of_type_Vya == null)
        {
          this.jdField_a_of_type_Vya = new vya(this, null);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_Vya);
        }
        if (paramInt1 != 32) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramString, paramInt2, paramLong);
        return;
      }
    } while (paramInt1 != 16);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(paramString, paramInt2, paramLong);
  }
  
  public void a(AppInterface paramAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != paramAppInterface)
    {
      d();
      if ((paramAppInterface instanceof QQAppInterface)) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramAppInterface);
      }
    }
  }
  
  public void a(AppInterface paramAppInterface, FaceInfo paramFaceInfo)
  {
    if ((paramFaceInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.FaceDecoderImpl", 2, "onDecodeTaskCompletedNeedDownload, faceInfo=" + paramFaceInfo.toString());
      }
      this.c -= 1;
      paramAppInterface = (FaceInfo)this.jdField_a_of_type_JavaUtilHashtable.get(paramFaceInfo.b());
      if (paramAppInterface != null)
      {
        if (this.jdField_a_of_type_Vya == null)
        {
          this.jdField_a_of_type_Vya = new vya(this, null);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_Vya);
        }
        FaceDecoder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramAppInterface);
      }
    } while ((this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) || (this.c >= this.jdField_b_of_type_Int));
    e();
  }
  
  public void a(FaceInfo paramFaceInfo, Bitmap paramBitmap)
  {
    if ((paramFaceInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.FaceDecoderImpl", 2, "onDecodeTaskCompleted, faceInfo=" + paramFaceInfo.toString());
    }
    this.c -= 1;
    if ((!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) && (!this.jdField_a_of_type_Boolean)) {
      e();
    }
    FaceInfo localFaceInfo = (FaceInfo)this.jdField_a_of_type_JavaUtilHashtable.remove(paramFaceInfo.b());
    int j;
    if (localFaceInfo != null)
    {
      j = FaceInfo.q;
      if (paramBitmap == null) {
        break label160;
      }
    }
    label160:
    for (int i = FaceInfo.e;; i = FaceInfo.f)
    {
      localFaceInfo.a(j, i);
      if ((this.jdField_a_of_type_Vxx == null) || (paramBitmap == null)) {
        break;
      }
      this.jdField_a_of_type_Vxx.a(this.c + this.jdField_a_of_type_JavaUtilLinkedList.size(), paramFaceInfo.jdField_a_of_type_Int, paramFaceInfo.jdField_a_of_type_JavaLangString, paramBitmap);
      return;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, String paramString, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    label184:
    do
    {
      Object localObject;
      do
      {
        Bitmap localBitmap;
        do
        {
          return;
          localObject = FaceInfo.a(paramInt1, paramString, paramInt2);
          byte b1 = 3;
          if (paramInt1 == 101) {
            b1 = 1;
          }
          if ((!paramBoolean) || (this.jdField_a_of_type_Boolean)) {
            break label184;
          }
          localBitmap = a(paramInt1, paramString, paramInt2, b1);
          if (localBitmap == null) {
            break;
          }
          localObject = (FaceInfo)this.jdField_a_of_type_JavaUtilHashtable.remove(localObject);
          if (localObject != null) {
            ((FaceInfo)localObject).a(FaceInfo.q, FaceInfo.e);
          }
        } while (this.jdField_a_of_type_Vxx == null);
        this.jdField_a_of_type_Vxx.a(this.c + this.jdField_a_of_type_JavaUtilLinkedList.size(), paramInt1, paramString, localBitmap);
        return;
        paramString = (FaceInfo)this.jdField_a_of_type_JavaUtilHashtable.get(localObject);
        if (paramString != null)
        {
          a(paramString);
          return;
        }
        paramString = (FaceInfo)this.jdField_b_of_type_JavaUtilHashtable.remove(localObject);
      } while (paramString == null);
      paramString.a(FaceInfo.i);
      this.jdField_a_of_type_JavaUtilHashtable.put(localObject, paramString);
      a(paramString);
      return;
      paramString = (FaceInfo)this.jdField_a_of_type_JavaUtilHashtable.remove(localObject);
    } while (paramString == null);
    paramInt2 = FaceInfo.q;
    if (!paramBoolean) {}
    for (paramInt1 = FaceInfo.f;; paramInt1 = FaceInfo.g)
    {
      paramString.a(paramInt2, paramInt1);
      return;
    }
  }
  
  public boolean a(String paramString, int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, byte paramByte, int paramInt3)
  {
    if ((paramString == null) || (paramString.length() < 5))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.FaceDecoderImpl", 2, "requestDecodeFace fail. type=" + paramInt2 + ", uin=" + paramString);
      }
      return false;
    }
    String str = FaceInfo.a(paramInt2, paramString, paramInt1);
    FaceInfo localFaceInfo = (FaceInfo)this.jdField_a_of_type_JavaUtilHashtable.get(str);
    if ((localFaceInfo != null) && (!localFaceInfo.a(FaceInfo.i, 300000L)))
    {
      if ((localFaceInfo.b) && (!paramBoolean2)) {
        localFaceInfo.b = false;
      }
      return true;
    }
    int i = 3;
    if (paramInt3 == 0) {
      if (paramInt2 != 101)
      {
        paramInt3 = i;
        if (paramInt2 != 1001) {
          break label148;
        }
      }
    }
    for (paramInt3 = 1;; paramInt3 = (byte)paramInt3)
    {
      label148:
      paramString = new FaceInfo(paramInt2, paramString, paramBoolean2, paramByte, paramInt3, false, paramInt1);
      paramString.a(FaceInfo.i);
      this.jdField_a_of_type_JavaUtilHashtable.put(str, paramString);
      a(paramString);
      return true;
    }
  }
  
  public boolean a(String paramString, int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, byte paramByte, int paramInt3, QQHeadInfo paramQQHeadInfo)
  {
    return false;
  }
  
  public boolean a(ArrayList paramArrayList)
  {
    return false;
  }
  
  public void d()
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    vxz localvxz = this.jdField_a_of_type_Vxz;
    vya localvya = this.jdField_a_of_type_Vya;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_Vxz = null;
    this.jdField_a_of_type_Vya = null;
    if (localQQAppInterface != null)
    {
      if (localvxz != null) {
        localQQAppInterface.b(localvxz);
      }
      if (localvya != null) {
        localQQAppInterface.b(localvya);
      }
    }
    super.d();
  }
  
  public void e()
  {
    localObject1 = null;
    do
    {
      try
      {
        FaceInfo localFaceInfo = (FaceInfo)this.jdField_a_of_type_JavaUtilLinkedList.removeFirst();
        if (localObject1 == null) {
          continue;
        }
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.qqhead.FaceDecoderImpl", 2, " runNextTask, faceinfo=" + localFaceInfo.toString());
          }
          if (((localFaceInfo.jdField_a_of_type_Int == 101) || (localFaceInfo.jdField_a_of_type_Int == 1001)) && (this.jdField_a_of_type_Vxz == null))
          {
            this.jdField_a_of_type_Vxz = new vxz(this, null);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_Vxz);
          }
          this.c += 1;
          FaceDecodeTask.a(FaceDecodeTask.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFaceInfo, this));
          return;
        }
        catch (Throwable localThrowable2)
        {
          for (;;)
          {
            localObject1 = localThrowable1;
            Object localObject2 = localThrowable2;
          }
        }
        localThrowable1 = localThrowable1;
      }
      this.c -= 1;
    } while (!QLog.isColorLevel());
    NearbyUtils.a("Q.qqhead.FaceDecoderImpl", new Object[] { "runNextTask", localThrowable1, localObject1 });
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\util\FaceDecoderImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */