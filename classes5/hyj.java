import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeResult;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class hyj
  implements Runnable
{
  public hyj(ArticleInfoModule paramArticleInfoModule, int paramInt, List paramList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
    Object localObject1;
    Object localObject2;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (DislikeResult)((Iterator)localObject1).next();
        if (((DislikeResult)localObject2).jdField_a_of_type_Int != 0) {
          QLog.e(ArticleInfoModule.jdField_a_of_type_JavaLangString, 2, "dislike fail ,articleID : " + ((DislikeResult)localObject2).jdField_a_of_type_Long + ", failCode : " + ((DislikeResult)localObject2).jdField_a_of_type_Int + ",fialMessage : " + ((DislikeResult)localObject2).jdField_a_of_type_JavaLangString);
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.jdField_a_of_type_Int == 0)
    {
      localObject1 = ArticleInfoModule.jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder().append("dislike upload successful ! count : ");
      if (this.jdField_a_of_type_JavaUtilList == null) {
        break label187;
      }
    }
    label187:
    for (int i = this.jdField_a_of_type_JavaUtilList.size();; i = 0)
    {
      QLog.d((String)localObject1, 2, i);
      ReadInJoyLogicEngine.a().a(2, 1);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hyj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */