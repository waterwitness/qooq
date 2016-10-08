import com.tencent.mobileqq.ark.ArkAppCGI;
import com.tencent.mobileqq.ark.ArkAppCGI.ArkAppCGICallback;
import com.tencent.mobileqq.ark.ArkAppCGI.QueryAppInfoByAppNameBatchResult;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;

public class qpv
  extends ArkAppCGI.ArkAppCGICallback
{
  public qpv(ArkAppCGI paramArkAppCGI)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(ArkAppCGI.QueryAppInfoByAppNameBatchResult paramQueryAppInfoByAppNameBatchResult, Object paramObject)
  {
    paramObject = (qqg)paramObject;
    ((qqg)paramObject).b += 1;
    if (paramQueryAppInfoByAppNameBatchResult != null)
    {
      if (((qqg)paramObject).jdField_a_of_type_ComTencentMobileqqArkArkAppCGI$QueryAppInfoByAppNameBatchResult.jdField_a_of_type_Int < paramQueryAppInfoByAppNameBatchResult.jdField_a_of_type_Int) {
        ((qqg)paramObject).jdField_a_of_type_ComTencentMobileqqArkArkAppCGI$QueryAppInfoByAppNameBatchResult.jdField_a_of_type_Int = paramQueryAppInfoByAppNameBatchResult.jdField_a_of_type_Int;
      }
      ((qqg)paramObject).jdField_a_of_type_ComTencentMobileqqArkArkAppCGI$QueryAppInfoByAppNameBatchResult.jdField_a_of_type_JavaUtilHashMap.putAll(paramQueryAppInfoByAppNameBatchResult.jdField_a_of_type_JavaUtilHashMap);
    }
    if (((qqg)paramObject).b < ((qqg)paramObject).jdField_a_of_type_Int) {}
    while (((qqg)paramObject).jdField_a_of_type_ComTencentMobileqqArkArkAppCGI$ArkAppCGICallback == null) {
      return;
    }
    ((qqg)paramObject).jdField_a_of_type_ComTencentMobileqqArkArkAppCGI$ArkAppCGICallback.a(((qqg)paramObject).jdField_a_of_type_ComTencentMobileqqArkArkAppCGI$QueryAppInfoByAppNameBatchResult, ((qqg)paramObject).jdField_a_of_type_JavaLangObject);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qpv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */