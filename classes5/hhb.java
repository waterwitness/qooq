import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.offline.util.ILog;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class hhb
  implements AsyncBack
{
  hhb(hha paramhha)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt)
  {
    this.a.jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack.a(paramInt);
  }
  
  public void a(String paramString, int paramInt)
  {
    long l = System.currentTimeMillis() - this.a.jdField_a_of_type_Long;
    if (HtmlOffline.a.a()) {
      HtmlOffline.a.a("HtmlCheckUpdate", 2, "js call downloadUpdate callback:" + paramInt + ", time:" + l);
    }
    if (paramInt == 0) {
      if (HtmlOffline.d(this.a.b)) {
        this.a.jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack.a(null, 0);
      }
    }
    for (;;)
    {
      hgp.b(this.a.b);
      HtmlOffline.a(this.a.b, paramInt, l, NetworkUtil.a(this.a.jdField_a_of_type_AndroidContentContext));
      return;
      this.a.jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack.a(null, 6);
      continue;
      this.a.jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack.a(null, 2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hhb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */