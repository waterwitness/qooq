import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.ShortVideoUploadProcessor;
import com.tencent.mobileqq.transfile.VideoSliceInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class vcd
  implements Runnable
{
  public vcd(ShortVideoUploadProcessor paramShortVideoUploadProcessor, VideoSliceInfo paramVideoSliceInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "<BDH_LOG> submitFollowedSlice");
    }
    synchronized (this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor)
    {
      if (ShortVideoUploadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor) != 3)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUploadProcessor", 2, "<BDH_LOG> submitFollowedSlice mSwitch != SWITCH_PRE_UPLOAD  mSwitch : " + ShortVideoUploadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor));
        }
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileVideoSliceInfo == null) {
        return;
      }
    }
    if ((ShortVideoUploadProcessor.b(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor) == 1) || (ShortVideoUploadProcessor.b(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor) == 2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUploadProcessor", 2, "<BDH_LOG> submitFollowedSlice mVideoPreUpStatus = " + ShortVideoUploadProcessor.b(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor) + " mVideoRecordStatus = " + ShortVideoUploadProcessor.c(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor));
      }
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileVideoSliceInfo.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqTransfileVideoSliceInfo.jdField_a_of_type_JavaLangString.length() != 0) && (this.jdField_a_of_type_ComTencentMobileqqTransfileVideoSliceInfo.jdField_b_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqTransfileVideoSliceInfo.jdField_b_of_type_JavaLangString.length() != 0))
    {
      str = this.jdField_a_of_type_ComTencentMobileqqTransfileVideoSliceInfo.jdField_a_of_type_JavaLangString;
      int i = (int)new File(str).length();
      int j = this.jdField_a_of_type_ComTencentMobileqqTransfileVideoSliceInfo.jdField_b_of_type_Int;
      int k = this.jdField_a_of_type_ComTencentMobileqqTransfileVideoSliceInfo.jdField_a_of_type_Int;
      int m = this.jdField_a_of_type_ComTencentMobileqqTransfileVideoSliceInfo.d;
      int n = this.jdField_a_of_type_ComTencentMobileqqTransfileVideoSliceInfo.c;
      byte[] arrayOfByte = HexUtil.hexStr2Bytes(this.jdField_a_of_type_ComTencentMobileqqTransfileVideoSliceInfo.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.a(str, i, this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_b_of_type_ArrayOfByte, arrayOfByte, k, m, n, j);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileVideoSliceInfo.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileVideoSliceInfo.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "<BDH_LOG> submitFollowedSlice  info.mEncodeFinish = " + this.jdField_a_of_type_ComTencentMobileqqTransfileVideoSliceInfo.jdField_a_of_type_Boolean + " info.mSendClicked = " + this.jdField_a_of_type_ComTencentMobileqqTransfileVideoSliceInfo.jdField_b_of_type_Boolean + " mEncodeFinish = " + this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() + " mSendClicked = " + this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() + " mVideoPreUpStatus = " + ShortVideoUploadProcessor.b(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      if (ShortVideoUploadProcessor.b(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor) == 0)
      {
        if (!ShortVideoUploadProcessor.f) {
          break label594;
        }
        this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.o, this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_ComTencentMobileqqHighwayProtocolBdh_extinfo$PicInfo, this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_b_of_type_JavaUtilList);
        ShortVideoUploadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor, 3);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
      {
        if ((!this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.c.isEmpty()) || (ShortVideoUploadProcessor.b(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor) != 0)) {
          break label649;
        }
        this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.o, this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_ComTencentMobileqqHighwayProtocolBdh_extinfo$PicInfo, this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_b_of_type_JavaUtilList);
        ShortVideoUploadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor, 3);
      }
    }
    label594:
    label649:
    while (ShortVideoUploadProcessor.b(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor) != 4)
    {
      return;
      if (!this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.c.isEmpty()) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.o, this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_ComTencentMobileqqHighwayProtocolBdh_extinfo$PicInfo, this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_b_of_type_JavaUtilList);
      ShortVideoUploadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor, 3);
      break;
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.d(1007);
    this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.d(false);
    long l = 0L;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.get("param_cost_s_store") != null) {
      l = Long.valueOf((String)this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.get("param_cost_s_store")).longValue();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.get("param_cost_s_store") != null) {}
    for (String str = (String)this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.get("param_cost_s_store");; str = String.valueOf(0))
    {
      ShortVideoUploadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadProcessor, true, l, str);
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vcd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */