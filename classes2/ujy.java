import android.os.Bundle;
import com.tencent.bitapp.bundle.BundleFacade;
import com.tencent.bitapp.bundle.BundleStruct;
import com.tencent.bitapp.preDownload.RNPreDownloadFacade;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mp.mobileqq_mp.LolaUpdateResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.UpdateResponseItem;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.rn.RNAppManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import mqq.observer.BusinessObserver;

public class ujy
  implements BusinessObserver
{
  public ujy(RNAppManager paramRNAppManager, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean) {
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle != null)
        {
          localObject = new mobileqq_mp.LolaUpdateResponse();
          ((mobileqq_mp.LolaUpdateResponse)localObject).mergeFrom(paramBundle);
          if ((((mobileqq_mp.LolaUpdateResponse)localObject).ret_info.has()) && (((mobileqq_mp.LolaUpdateResponse)localObject).ret_info.ret_code.get() == 0))
          {
            if (QLog.isColorLevel()) {
              QLog.d(RNAppManager.b, 2, "BITAPP MSG UPDATE SUCCESSFUL ...");
            }
            if (!((mobileqq_mp.LolaUpdateResponse)localObject).response_item.has()) {
              break label346;
            }
            paramBundle = ((mobileqq_mp.LolaUpdateResponse)localObject).response_item.get().iterator();
            while (paramBundle.hasNext())
            {
              localObject = (mobileqq_mp.UpdateResponseItem)paramBundle.next();
              localBundleStruct = new BundleStruct();
              localBundleStruct.module_id = ((mobileqq_mp.UpdateResponseItem)localObject).module_id.get();
              localBundleStruct.module_version = ((mobileqq_mp.UpdateResponseItem)localObject).module_version.get();
              localBundleStruct.module_state = ((mobileqq_mp.UpdateResponseItem)localObject).module_state.get();
              localBundleStruct.download_url = ((mobileqq_mp.UpdateResponseItem)localObject).download_url.get();
              localBundleStruct.md5 = ((mobileqq_mp.UpdateResponseItem)localObject).md5.get();
              localBundleStruct.decrypt = ((mobileqq_mp.UpdateResponseItem)localObject).decrypt.get();
              localBundleStruct.pwd = ((mobileqq_mp.UpdateResponseItem)localObject).pwd.get();
              if (QLog.isColorLevel()) {
                QLog.d(RNAppManager.b, 2, "isPush: " + this.jdField_a_of_type_Boolean + ", Bitapp server result: " + localBundleStruct.toString());
              }
              if (!RNPreDownloadFacade.a()) {
                break label328;
              }
              if (!this.jdField_a_of_type_Boolean) {
                break label320;
              }
              BundleFacade.loadBundle(localBundleStruct, new WeakReference(new ujz()));
            }
          }
        }
        return;
      }
      catch (Exception paramBundle)
      {
        if (QLog.isColorLevel())
        {
          QLog.d(RNAppManager.b, 2, "BITAPP MSG UPDATE EXCEPTION ...");
          paramBundle.printStackTrace();
        }
      }
    }
    label320:
    label328:
    label346:
    while (!QLog.isColorLevel())
    {
      do
      {
        for (;;)
        {
          Object localObject;
          BundleStruct localBundleStruct;
          BundleFacade.updateBundle(localBundleStruct);
          continue;
          if (QLog.isColorLevel()) {
            QLog.d(RNAppManager.b, 2, "bitapp not ready");
          }
        }
      } while (!QLog.isColorLevel());
      QLog.d(RNAppManager.b, 2, "BITAPP MSG no response_item");
      return;
    }
    QLog.d(RNAppManager.b, 2, "BITAPP MSG UPDATE FAILURE ...");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ujy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */