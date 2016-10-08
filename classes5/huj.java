import com.tencent.biz.pubaccount.ecshopassit.EcShopRecommendAdapter;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class huj
  extends PublicAccountObserver
{
  huk jdField_a_of_type_Huk;
  
  public huj(EcShopRecommendAdapter paramEcShopRecommendAdapter, huk paramhuk)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Huk = null;
    this.jdField_a_of_type_Huk = paramhuk;
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.d("EcShopRecommendAdapter", 2, "onFollowPublicAccount isSuccess: " + paramBoolean + " | uin: " + paramString + " | mRecommendItem: " + this.jdField_a_of_type_Huk);
    }
    huk localhuk;
    if (this.jdField_a_of_type_Huk != null)
    {
      paramString = this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopRecommendAdapter;
      localhuk = this.jdField_a_of_type_Huk;
      if (!paramBoolean) {
        break label84;
      }
    }
    for (;;)
    {
      paramString.a(localhuk, i);
      return;
      label84:
      i = 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\huj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */