import android.os.Bundle;
import com.tencent.bitapp.BitAppBundleDownload;
import com.tencent.bitapp.bundle.BundleStruct;
import com.tencent.bitapp.module.IDownloadListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mp.mobileqq_mp.LolaUpdateResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.UpdateResponseItem;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.observer.BusinessObserver;

public class hdi
  implements BusinessObserver
{
  public hdi(BitAppBundleDownload paramBitAppBundleDownload, IDownloadListener paramIDownloadListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean) {}
    try
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle != null)
      {
        Object localObject = new mobileqq_mp.LolaUpdateResponse();
        ((mobileqq_mp.LolaUpdateResponse)localObject).mergeFrom(paramBundle);
        if ((((mobileqq_mp.LolaUpdateResponse)localObject).ret_info.has()) && (((mobileqq_mp.LolaUpdateResponse)localObject).ret_info.ret_code.get() == 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d("BitAppBundleDownload", 2, "BITAPP MSG UPDATE SUCCESSFUL ...");
          }
          if (((mobileqq_mp.LolaUpdateResponse)localObject).response_item.has())
          {
            paramBundle = ((mobileqq_mp.LolaUpdateResponse)localObject).response_item.get().iterator();
            if (paramBundle.hasNext())
            {
              paramBundle = (mobileqq_mp.UpdateResponseItem)paramBundle.next();
              localObject = new BundleStruct();
              ((BundleStruct)localObject).module_id = paramBundle.module_id.get();
              ((BundleStruct)localObject).module_version = paramBundle.module_version.get();
              ((BundleStruct)localObject).module_state = paramBundle.module_state.get();
              ((BundleStruct)localObject).download_url = paramBundle.download_url.get();
              ((BundleStruct)localObject).md5 = paramBundle.md5.get();
              ((BundleStruct)localObject).decrypt = paramBundle.decrypt.get();
              ((BundleStruct)localObject).pwd = paramBundle.pwd.get();
              this.jdField_a_of_type_ComTencentBitappModuleIDownloadListener.downloadSuccessful((BundleStruct)localObject);
              return;
            }
          }
        }
      }
      this.jdField_a_of_type_ComTencentBitappModuleIDownloadListener.downloadFailure();
      if (QLog.isColorLevel())
      {
        QLog.d("BitAppBundleDownload", 2, "BITAPP MSG UPDATE FAILURE ...");
        return;
      }
    }
    catch (Exception paramBundle)
    {
      this.jdField_a_of_type_ComTencentBitappModuleIDownloadListener.downloadFailure();
      if (QLog.isColorLevel())
      {
        QLog.d("BitAppBundleDownload", 2, "BITAPP MSG UPDATE EXCEPTION ...");
        paramBundle.printStackTrace();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\hdi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */