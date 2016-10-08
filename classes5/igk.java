import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class igk
  implements Runnable
{
  igk(igj paramigj, Object paramObject)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaLangObject instanceof OpenID))
    {
      OpenID localOpenID = (OpenID)this.jdField_a_of_type_JavaLangObject;
      if (PublicAccountUtil.a(this.jdField_a_of_type_Igj.jdField_a_of_type_AndroidAppActivity, localOpenID, this.jdField_a_of_type_Igj.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Igj.jdField_a_of_type_ComTencentBizPubaccountUtilProfileParams)) {
        break label77;
      }
    }
    label77:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        PublicAccountUtil.b(this.jdField_a_of_type_Igj.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Igj.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Igj.jdField_a_of_type_ComTencentBizPubaccountUtilProfileParams);
      }
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\igk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */