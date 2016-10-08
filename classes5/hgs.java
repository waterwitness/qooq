import com.tencent.biz.common.offline.util.IOfflineDownloader;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;

class hgs
  implements Runnable
{
  hgs(hgp paramhgp)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("Accept-Encoding", "gzip");
    hgp.jdField_a_of_type_ComTencentBizCommonOfflineUtilIOfflineDownloader.a(hgp.jdField_a_of_type_AndroidContentContext, this.a.c, this.a.jdField_a_of_type_JavaLangString, this.a.b, this.a.jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack, localHashMap);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hgs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */