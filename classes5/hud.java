import android.os.Handler;
import android.os.Message;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class hud
  implements Runnable
{
  hud(huc paramhuc)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    EcShopAssistantManager.jdField_a_of_type_ArrayOfComTencentBizPubaccountEcshopassitEcShopAssistantManager$BannerConfig = null;
    if (this.a.a.jdField_a_of_type_AndroidOsHandler != null) {
      this.a.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(10003).sendToTarget();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hud.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */