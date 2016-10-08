import android.os.SystemClock;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.transaction.TransReport;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.BaseTransProcessor.StepInfo;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.SnapChatPicUpProcessor;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.HashMap;

public class vcj
  implements ITransactionCallback
{
  public vcj(SnapChatPicUpProcessor paramSnapChatPicUpProcessor, long paramLong)
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
    String str5 = (String)paramHashMap.get("param_conf_connNum");
    String str6 = (String)paramHashMap.get("param_fin_lost");
    if (QLog.isColorLevel()) {
      QLog.d("SnapChatPicUpProcessor", 2, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (l1 - this.jdField_a_of_type_Long) + "ms");
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileSnapChatPicUpProcessor.jdField_a_of_type_JavaUtilHashMap.put("X-piccachetime", paramArrayOfByte);
    this.jdField_a_of_type_ComTencentMobileqqTransfileSnapChatPicUpProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_BdhTrans", str1);
    this.jdField_a_of_type_ComTencentMobileqqTransfileSnapChatPicUpProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_segspercnt", str2);
    this.jdField_a_of_type_ComTencentMobileqqTransfileSnapChatPicUpProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_conf_segSize", str3);
    this.jdField_a_of_type_ComTencentMobileqqTransfileSnapChatPicUpProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_conf_segNum", str4);
    this.jdField_a_of_type_ComTencentMobileqqTransfileSnapChatPicUpProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_conf_connNum", str5);
    this.jdField_a_of_type_ComTencentMobileqqTransfileSnapChatPicUpProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_fin_lost", str6);
    this.jdField_a_of_type_ComTencentMobileqqTransfileSnapChatPicUpProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_retry_seg_count", paramHashMap.get("param_retry_seg_count"));
    this.jdField_a_of_type_ComTencentMobileqqTransfileSnapChatPicUpProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_max_retry_times", paramHashMap.get("param_max_retry_times"));
    this.jdField_a_of_type_ComTencentMobileqqTransfileSnapChatPicUpProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_total_retry_times", paramHashMap.get("param_total_retry_times"));
    this.jdField_a_of_type_ComTencentMobileqqTransfileSnapChatPicUpProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_retry_code", paramHashMap.get("param_retry_code"));
    this.jdField_a_of_type_ComTencentMobileqqTransfileSnapChatPicUpProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_heart_resp", paramHashMap.get("param_heart_resp"));
    this.jdField_a_of_type_ComTencentMobileqqTransfileSnapChatPicUpProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_ip_index", paramHashMap.get("param_ip_index"));
    this.jdField_a_of_type_ComTencentMobileqqTransfileSnapChatPicUpProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_Ip_ConnCost", paramHashMap.get("param_Ip_ConnCost"));
    this.jdField_a_of_type_ComTencentMobileqqTransfileSnapChatPicUpProcessor.a(l2, l3, l4, l5);
    this.jdField_a_of_type_ComTencentMobileqqTransfileSnapChatPicUpProcessor.a(paramInt, "OnFailed.", "", this.jdField_a_of_type_ComTencentMobileqqTransfileSnapChatPicUpProcessor.b);
    this.jdField_a_of_type_ComTencentMobileqqTransfileSnapChatPicUpProcessor.b();
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap paramHashMap)
  {
    long l1 = SystemClock.uptimeMillis();
    long l2 = Long.valueOf((String)paramHashMap.get("upFlow_WiFi")).longValue();
    long l3 = Long.valueOf((String)paramHashMap.get("dwFlow_WiFi")).longValue();
    long l4 = Long.valueOf((String)paramHashMap.get("upFlow_Xg")).longValue();
    long l5 = Long.valueOf((String)paramHashMap.get("dwFlow_Xg")).longValue();
    String str1 = (String)paramHashMap.get("rep_bdhTrans");
    String str2 = (String)paramHashMap.get("segspercnt");
    String str3 = (String)paramHashMap.get("param_conf_segSize");
    String str4 = (String)paramHashMap.get("param_conf_segNum");
    String str5 = (String)paramHashMap.get("param_conf_connNum");
    String str6 = (String)paramHashMap.get("param_fin_lost");
    if (QLog.isColorLevel()) {
      QLog.d("SnapChatPicUpProcessor", 2, "<BDH_LOG> Transaction End : Success. New : SendTotalCost:" + (l1 - this.jdField_a_of_type_Long) + "ms" + " ,fileSize:" + this.jdField_a_of_type_ComTencentMobileqqTransfileSnapChatPicUpProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long + " transInfo:" + str1);
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileSnapChatPicUpProcessor.f = this.jdField_a_of_type_ComTencentMobileqqTransfileSnapChatPicUpProcessor.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.mTransReport.timeCost_Ht;
    this.jdField_a_of_type_ComTencentMobileqqTransfileSnapChatPicUpProcessor.h = this.jdField_a_of_type_ComTencentMobileqqTransfileSnapChatPicUpProcessor.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.mTransReport.timeCost_Cache;
    this.jdField_a_of_type_ComTencentMobileqqTransfileSnapChatPicUpProcessor.jdField_a_of_type_JavaUtilHashMap.put("X-piccachetime", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileSnapChatPicUpProcessor.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.mTransReport.timeCost_Cache));
    this.jdField_a_of_type_ComTencentMobileqqTransfileSnapChatPicUpProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_BdhTrans", str1);
    this.jdField_a_of_type_ComTencentMobileqqTransfileSnapChatPicUpProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_segspercnt", str2);
    this.jdField_a_of_type_ComTencentMobileqqTransfileSnapChatPicUpProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_conf_segSize", str3);
    this.jdField_a_of_type_ComTencentMobileqqTransfileSnapChatPicUpProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_conf_segNum", str4);
    this.jdField_a_of_type_ComTencentMobileqqTransfileSnapChatPicUpProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_conf_connNum", str5);
    this.jdField_a_of_type_ComTencentMobileqqTransfileSnapChatPicUpProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_fin_lost", str6);
    this.jdField_a_of_type_ComTencentMobileqqTransfileSnapChatPicUpProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_retry_seg_count", paramHashMap.get("param_retry_seg_count"));
    this.jdField_a_of_type_ComTencentMobileqqTransfileSnapChatPicUpProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_max_retry_times", paramHashMap.get("param_max_retry_times"));
    this.jdField_a_of_type_ComTencentMobileqqTransfileSnapChatPicUpProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_total_retry_times", paramHashMap.get("param_total_retry_times"));
    this.jdField_a_of_type_ComTencentMobileqqTransfileSnapChatPicUpProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_retry_code", paramHashMap.get("param_retry_code"));
    this.jdField_a_of_type_ComTencentMobileqqTransfileSnapChatPicUpProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_heart_resp", paramHashMap.get("param_heart_resp"));
    this.jdField_a_of_type_ComTencentMobileqqTransfileSnapChatPicUpProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_ip_index", paramHashMap.get("param_ip_index"));
    this.jdField_a_of_type_ComTencentMobileqqTransfileSnapChatPicUpProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_Ip_ConnCost", paramHashMap.get("param_Ip_ConnCost"));
    this.jdField_a_of_type_ComTencentMobileqqTransfileSnapChatPicUpProcessor.b.b();
    this.jdField_a_of_type_ComTencentMobileqqTransfileSnapChatPicUpProcessor.b.a = 1;
    this.jdField_a_of_type_ComTencentMobileqqTransfileSnapChatPicUpProcessor.c = this.jdField_a_of_type_ComTencentMobileqqTransfileSnapChatPicUpProcessor.jdField_a_of_type_Long;
    int i = 0;
    if (paramArrayOfByte.length > 0)
    {
      int j = ByteBuffer.wrap(paramArrayOfByte).get();
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.d("SnapChatPicUpProcessor", 2, "ret > 0" + j);
        i = j;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("SnapChatPicUpProcessor", 2, "SnapChatPicUpProcessor.ITransactionCallback.onSuccess(), business result code = " + i);
    }
    if (i == 0) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileSnapChatPicUpProcessor.c();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqTransfileSnapChatPicUpProcessor.a(l2, l3, l4, l5);
      this.jdField_a_of_type_ComTencentMobileqqTransfileSnapChatPicUpProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b();
      return;
      this.jdField_a_of_type_ComTencentMobileqqTransfileSnapChatPicUpProcessor.d(1005);
    }
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart()
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileSnapChatPicUpProcessor.c("<BDH_LOG> onTransStart()");
    this.jdField_a_of_type_ComTencentMobileqqTransfileSnapChatPicUpProcessor.b.a();
  }
  
  public void onUpdateProgress(int paramInt)
  {
    SnapChatPicUpProcessor localSnapChatPicUpProcessor = this.jdField_a_of_type_ComTencentMobileqqTransfileSnapChatPicUpProcessor;
    FileMsg localFileMsg = this.jdField_a_of_type_ComTencentMobileqqTransfileSnapChatPicUpProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg;
    long l = paramInt;
    localFileMsg.f = l;
    localSnapChatPicUpProcessor.c = l;
    if ((paramInt < this.jdField_a_of_type_ComTencentMobileqqTransfileSnapChatPicUpProcessor.jdField_a_of_type_Long) && (!this.jdField_a_of_type_ComTencentMobileqqTransfileSnapChatPicUpProcessor.o) && (!this.jdField_a_of_type_ComTencentMobileqqTransfileSnapChatPicUpProcessor.k)) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileSnapChatPicUpProcessor.h();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vcj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */