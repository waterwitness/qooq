import android.os.SystemClock;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.BaseTransProcessor.StepInfo;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.HashMap;

public class vbe
  implements ITransactionCallback
{
  public vbe(NearbyPeoplePhotoUploadProcessor paramNearbyPeoplePhotoUploadProcessor, long paramLong)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap paramHashMap)
  {
    long l1 = SystemClock.uptimeMillis();
    long l2 = Long.valueOf((String)paramHashMap.get("upFlow_WiFi")).longValue();
    long l3 = Long.valueOf((String)paramHashMap.get("dwFlow_WiFi")).longValue();
    long l4 = Long.valueOf((String)paramHashMap.get("upFlow_Xg")).longValue();
    long l5 = Long.valueOf((String)paramHashMap.get("dwFlow_Xg")).longValue();
    paramArrayOfByte = (String)paramHashMap.get("tc_p:");
    String str1 = (String)paramHashMap.get("rep_bdhTrans");
    String str2 = (String)paramHashMap.get("segspercnt");
    String str3 = (String)paramHashMap.get("param_conf_segSize");
    String str4 = (String)paramHashMap.get("param_conf_segNum");
    paramHashMap = (String)paramHashMap.get("param_conf_connNum");
    if (QLog.isColorLevel()) {
      QLog.i("NearbyPeoplePhotoUploadProcessor", 2, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (l1 - this.jdField_a_of_type_Long) + "ms");
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("X-piccachetime", paramArrayOfByte);
    this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_BdhTrans", str1);
    this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_segspercnt", str2);
    this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_conf_segSize", str3);
    this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_conf_segNum", str4);
    this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_conf_connNum", paramHashMap);
    this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.a(l2, l3, l4, l5);
    this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.a(paramInt, "OnFailed.", "", this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.b);
    this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.b();
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap paramHashMap)
  {
    long l1 = SystemClock.uptimeMillis();
    long l2 = Long.valueOf((String)paramHashMap.get("upFlow_WiFi")).longValue();
    long l3 = Long.valueOf((String)paramHashMap.get("dwFlow_WiFi")).longValue();
    long l4 = Long.valueOf((String)paramHashMap.get("upFlow_Xg")).longValue();
    long l5 = Long.valueOf((String)paramHashMap.get("dwFlow_Xg")).longValue();
    String str1 = (String)paramHashMap.get("tc_p:");
    String str2 = (String)paramHashMap.get("rep_bdhTrans");
    String str3 = (String)paramHashMap.get("segspercnt");
    String str4 = (String)paramHashMap.get("param_conf_segSize");
    String str5 = (String)paramHashMap.get("param_conf_segNum");
    paramHashMap = (String)paramHashMap.get("param_conf_connNum");
    if (QLog.isColorLevel()) {
      QLog.i("NearbyPeoplePhotoUploadProcessor", 2, "<BDH_LOG> Transaction End : Success. New : SendTotalCost:" + (l1 - this.jdField_a_of_type_Long) + "ms" + " ,fileSize:" + this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long + " transInfo:" + str2);
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("X-piccachetime", str1);
    this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_BdhTrans", str2);
    this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_segspercnt", str3);
    this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_conf_segSize", str4);
    this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_conf_segNum", str5);
    this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_conf_connNum", paramHashMap);
    this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.b.b();
    this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.b.a = 1;
    this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.c = this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_Long;
    paramHashMap = ByteBuffer.wrap(paramArrayOfByte);
    int i = paramHashMap.get();
    if (QLog.isColorLevel()) {
      QLog.i("NearbyPeoplePhotoUploadProcessor", 2, "NearbyPeoplePhotoUploadProcessor.ITransactionCallback.onSuccess(), business result code = " + i);
    }
    if (i == 0) {
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.e == 8)
      {
        NearbyPeoplePhotoUploadProcessor.aH = Integer.parseInt(new String(paramArrayOfByte, 2, paramHashMap.get() & 0xFF));
        this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.c();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.a(l2, l3, l4, l5);
      this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b();
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.e == 21)
      {
        i = paramHashMap.get();
        this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_k_of_type_JavaLangString = new String(paramArrayOfByte, 2, i & 0xFF);
        break;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.e == 22)
      {
        i = paramHashMap.get();
        this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_k_of_type_JavaLangString = new String(paramArrayOfByte, 2, i & 0xFF);
        break;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.e == 35)
      {
        this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
        break;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.e == 36) || (this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.e == 37) || (this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.e == 38) || (this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.e == 39) || (this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.e == 40) || (this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.e == 41))
      {
        i = paramHashMap.get();
        int j = paramHashMap.get();
        int k = paramHashMap.get();
        int m = paramHashMap.get();
        this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.l = new String(paramArrayOfByte, 5, (m & 0xFF) << 24 | 0x0 | i | (j & 0xFF) << 8 | (k & 0xFF) << 16);
        break;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.e != 48) {
        break;
      }
      i = paramHashMap.get();
      this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_k_of_type_JavaLangString = new String(paramArrayOfByte, 2, i & 0xFF);
      break;
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.e == 34)
      {
        paramArrayOfByte = new String(paramArrayOfByte);
        this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_k_of_type_JavaLangString = paramArrayOfByte;
        this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.c();
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.d(1005);
        this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.b();
      }
    }
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart()
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.c("<BDH_LOG> onTransStart()");
    this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.b.a();
  }
  
  public void onUpdateProgress(int paramInt)
  {
    NearbyPeoplePhotoUploadProcessor localNearbyPeoplePhotoUploadProcessor = this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor;
    FileMsg localFileMsg = this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg;
    long l = paramInt;
    localFileMsg.f = l;
    localNearbyPeoplePhotoUploadProcessor.c = l;
    if ((paramInt <= this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_Long) && (!this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.o) && (!this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_k_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.h();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vbe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */