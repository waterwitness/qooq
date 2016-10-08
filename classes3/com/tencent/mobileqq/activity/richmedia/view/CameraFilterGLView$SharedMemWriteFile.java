package com.tencent.mobileqq.activity.richmedia.view;

import com.tencent.maxvideo.common.AVIOStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.util.PtvFilterUtils;
import com.tencent.mobileqq.shortvideo.util.SVFilterEncodeDoubleCache;
import com.tencent.mobileqq.shortvideo.util.SVFilterEncodeDoubleCache.SharedMemoryCache;
import com.tencent.qphone.base.util.QLog;

public class CameraFilterGLView$SharedMemWriteFile
  implements Runnable
{
  public int a;
  public AVIOStruct a;
  public CameraFilterGLView.CameraGlFilterListener a;
  public SVFilterEncodeDoubleCache.SharedMemoryCache a;
  public SVFilterEncodeDoubleCache a;
  public boolean a;
  public int b;
  public boolean b;
  public int c;
  public int d;
  
  public CameraFilterGLView$SharedMemWriteFile()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    QLog.d("PtvFilterUtils", 4, "PtvFilterUtils_onDrawFrame[writeSharedMemtoFileDegree]frameIndex=" + this.jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct.pFrameIndex);
    int i = PtvFilterUtils.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 4, true, false, this.c, this.jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct, this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVFilterEncodeDoubleCache$SharedMemoryCache.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean, this.d);
    if ((i != 0) && (QLog.isColorLevel())) {
      QLog.d("PtvFilterUtils", 2, "PtvFilterUtils_onDrawFrame[writeSharedMemtoFileDegree]err=" + i);
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVFilterEncodeDoubleCache$SharedMemoryCache.a();
    if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVFilterEncodeDoubleCache.a()) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$CameraGlFilterListener != null)) {}
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\richmedia\view\CameraFilterGLView$SharedMemWriteFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */