import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class hxy
  implements Runnable
{
  public hxy(ArticleInfoModule paramArticleInfoModule, long paramLong1, int paramInt, byte[] paramArrayOfByte, boolean paramBoolean1, List paramList1, boolean paramBoolean2, long paramLong2, List paramList2)
  {
    paramBoolean1 = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    boolean bool3 = false;
    if (this.jdField_a_of_type_Long == -1L) {}
    StringBuilder localStringBuilder;
    int i;
    for (boolean bool1 = true;; bool1 = false)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_ArrayOfByte);
      if (!this.jdField_a_of_type_Boolean) {
        break label408;
      }
      localStringBuilder = new StringBuilder("\n");
      if (this.jdField_a_of_type_JavaUtilList == null) {
        break label261;
      }
      localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
      i = 0;
      if (!((Iterator)localObject1).hasNext()) {
        break label261;
      }
      localObject2 = (ArticleInfo)((Iterator)localObject1).next();
      localStringBuilder.append("article【" + i + "】 id : " + ((ArticleInfo)localObject2).mArticleID + " seq : " + ((ArticleInfo)localObject2).mRecommendSeq + " title : " + ReadInJoyUtils.c(((ArticleInfo)localObject2).mTitle));
      if ((!QLog.isColorLevel()) || (((ArticleInfo)localObject2).mDislikeInfos == null) || (((ArticleInfo)localObject2).mDislikeInfos.size() <= 0)) {
        break label251;
      }
      localStringBuilder.append(" dislik【 ");
      localObject2 = ((ArticleInfo)localObject2).mDislikeInfos.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localStringBuilder.append(((DislikeInfo)((Iterator)localObject2).next()).b);
        localStringBuilder.append(",");
      }
    }
    localStringBuilder.append("】\n");
    for (;;)
    {
      i += 1;
      break;
      label251:
      localStringBuilder.append("\n");
    }
    label261:
    Object localObject1 = ArticleInfoModule.jdField_a_of_type_JavaLangString;
    Object localObject2 = new StringBuilder().append("handleRefreshChannel success=").append(this.jdField_a_of_type_Boolean).append(" channelId=").append(this.jdField_a_of_type_Int).append(" noMoreData=").append(this.jdField_b_of_type_Boolean).append(" beginRecommendSeq=").append(this.jdField_a_of_type_Long).append(" endRecommendSeq=").append(this.jdField_b_of_type_Long).append(" isInMsgTab : ");
    boolean bool2 = bool3;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.jdField_a_of_type_ComTencentCommonAppAppInterface != null)
    {
      bool2 = bool3;
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
        bool2 = true;
      }
    }
    QLog.i((String)localObject1, 1, bool2 + " isRefresh : " + bool1 + ", " + localStringBuilder.toString());
    label408:
    if (bool1)
    {
      ArticleInfoModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int, this.jdField_b_of_type_Boolean, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Long, this.jdField_b_of_type_Long, this.jdField_b_of_type_JavaUtilList);
      return;
    }
    ArticleInfoModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int, this.jdField_b_of_type_Boolean, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Long, this.jdField_b_of_type_Long);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */