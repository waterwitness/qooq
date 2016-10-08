import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyRequestParams.Request0x68bParams;
import java.util.List;

public class hyo
  implements Runnable
{
  /* Error */
  public hyo(ArticleInfoModule paramArticleInfoModule, List paramList, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: putfield 18	hyo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule	Lcom/tencent/biz/pubaccount/readinjoy/model/ArticleInfoModule;
    //   5: aload_0
    //   6: aload_2
    //   7: putfield 20	hyo:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   10: aload_0
    //   11: iload_3
    //   12: putfield 22	hyo:jdField_a_of_type_Int	I
    //   15: aload_0
    //   16: iload 4
    //   18: putfield 24	hyo:jdField_b_of_type_Int	I
    //   21: aload_0
    //   22: iload 5
    //   24: putfield 26	hyo:c	I
    //   27: aload_0
    //   28: iload 6
    //   30: putfield 28	hyo:jdField_a_of_type_Boolean	Z
    //   33: aload_0
    //   34: lload 7
    //   36: putfield 30	hyo:jdField_a_of_type_Long	J
    //   39: aload_0
    //   40: invokespecial 33	java/lang/Object:<init>	()V
    //   43: getstatic 38	com/tencent/mobileqq/hotpatch/NotVerifyClass:DO_VERIFY_CLASS	Z
    //   46: istore 6
    //   48: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	hyo
    //   0	49	1	paramArticleInfoModule	ArticleInfoModule
    //   0	49	2	paramList	List
    //   0	49	3	paramInt1	int
    //   0	49	4	paramInt2	int
    //   0	49	5	paramInt3	int
    //   0	49	6	paramBoolean	boolean
    //   0	49	7	paramLong	long
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_Int != this.jdField_a_of_type_JavaUtilList.size()))
    {
      localObject = new ReadInJoyRequestParams.Request0x68bParams();
      ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_b_of_type_Int = this.jdField_b_of_type_Int;
      ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_b_of_type_Boolean = false;
      ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_a_of_type_JavaUtilList = null;
      ((ReadInJoyRequestParams.Request0x68bParams)localObject).c = false;
      ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_b_of_type_JavaUtilList = null;
      ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_d_of_type_Boolean = true;
      ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_b_of_type_ArrayOfByte = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a();
      ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_d_of_type_Int = this.c;
      if (this.jdField_a_of_type_Boolean)
      {
        ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_a_of_type_Long = this.jdField_a_of_type_Long;
        ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_b_of_type_Long = -1L;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a((ReadInJoyRequestParams.Request0x68bParams)localObject);
        return;
      }
      ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_a_of_type_Long = -1L;
      ((ReadInJoyRequestParams.Request0x68bParams)localObject).jdField_b_of_type_Long = this.jdField_a_of_type_Long;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a((ReadInJoyRequestParams.Request0x68bParams)localObject);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(Integer.valueOf(this.jdField_b_of_type_Int), this.jdField_a_of_type_JavaUtilList, false);
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(Integer.valueOf(this.jdField_b_of_type_Int));
    ReadInJoyLogicEngineEventDispatcher.a().a(true, this.jdField_b_of_type_Int, (List)localObject, false);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hyo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */