package com.tencent.mobileqq.util;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.WeakReference;

public class FaceDrawableImpl$InternalFriendListObserver
  implements FaceDrawableImpl.FaceObserver
{
  public WeakReference a;
  
  FaceDrawableImpl$InternalFriendListObserver(FaceDrawableImpl paramFaceDrawableImpl, FaceDrawable paramFaceDrawable)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramFaceDrawable);
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDrawableImpl.a(paramBoolean, 11, paramString, this.jdField_a_of_type_ComTencentMobileqqUtilFaceDrawableImpl.jdField_a_of_type_ComTencentMobileqqUtilFaceDrawableImpl$InternalFriendListObserver);
  }
  
  public void a(boolean paramBoolean1, String paramString, int paramInt, boolean paramBoolean2)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDrawableImpl.a(paramBoolean1, 32, paramString, this.jdField_a_of_type_ComTencentMobileqqUtilFaceDrawableImpl.jdField_a_of_type_ComTencentMobileqqUtilFaceDrawableImpl$InternalFriendListObserver);
  }
  
  public void b(boolean paramBoolean, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDrawableImpl.a(paramBoolean, 1, paramString, this.jdField_a_of_type_ComTencentMobileqqUtilFaceDrawableImpl.jdField_a_of_type_ComTencentMobileqqUtilFaceDrawableImpl$InternalFriendListObserver);
  }
  
  public void b(boolean paramBoolean1, String paramString, int paramInt, boolean paramBoolean2)
  {
    if (paramInt != this.jdField_a_of_type_ComTencentMobileqqUtilFaceDrawableImpl.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.b) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDrawableImpl.a(paramBoolean1, 16, paramString, this.jdField_a_of_type_ComTencentMobileqqUtilFaceDrawableImpl.jdField_a_of_type_ComTencentMobileqqUtilFaceDrawableImpl$InternalFriendListObserver);
  }
  
  public void c(boolean paramBoolean, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDrawableImpl.a(paramBoolean, 4, paramString, this.jdField_a_of_type_ComTencentMobileqqUtilFaceDrawableImpl.jdField_a_of_type_ComTencentMobileqqUtilFaceDrawableImpl$InternalFriendListObserver);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\util\FaceDrawableImpl$InternalFriendListObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */