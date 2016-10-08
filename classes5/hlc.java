import com.tencent.biz.pubaccount.AccountDetail.bean.AccountDetailDynamicInfo;
import com.tencent.biz.pubaccount.AccountDetail.bean.DynamicInfoEntity;
import com.tencent.biz.pubaccount.AccountDetail.model.AccountDetailDynamicDataManager;
import com.tencent.biz.pubaccount.AccountDetail.model.AccountDetailDynamicListModel;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class hlc
  implements Runnable
{
  public hlc(AccountDetailDynamicDataManager paramAccountDetailDynamicDataManager, long paramLong, QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = (DynamicInfoEntity)AccountDetailDynamicDataManager.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailModelAccountDetailDynamicDataManager).a(DynamicInfoEntity.class, this.jdField_a_of_type_Long);
    if ((localObject != null) && (this.jdField_a_of_type_Long == Long.parseLong(((DynamicInfoEntity)localObject).puin)) && (((DynamicInfoEntity)localObject).dynamicInfoData != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d(AccountDetailDynamicDataManager.a(), 2, "getDynamicListForFirstEnterFromDB null != dynamicInfoEntity");
      }
      int i = AccountDetailDynamicListModel.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, ((DynamicInfoEntity)localObject).dynamicInfoData, true);
      localObject = AccountDetailDynamicDataManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_Long);
      if ((i == 0) && (localObject != null) && (!((AccountDetailDynamicInfo)localObject).a().isEmpty())) {
        ((PublicAccountHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(11)).a(107, true, Integer.valueOf(i));
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hlc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */