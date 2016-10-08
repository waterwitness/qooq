import com.tencent.biz.now.CgiHelper.cigHelperCallback;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.intervideo.LoginKeyHelper;
import com.tencent.mobileqq.intervideo.now.NowPerfUtil;
import com.tencent.mobileqq.intervideo.now.NowPlugin;
import com.tencent.qphone.base.util.QLog;

class swa
  implements CgiHelper.cigHelperCallback
{
  swa(svz paramsvz)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    NowPerfUtil.b("get record cgi finish");
    if (paramBoolean)
    {
      QLog.i("XProxy|NowProxy", 2, "跳转录播页面 URL = " + paramString);
      NowPlugin.a(this.a.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowPlugin, this.a.jdField_a_of_type_Long, paramString);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("XProxy_Perf", 4, "开始拉取A1 key time = " + System.currentTimeMillis());
    }
    this.a.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowPlugin.a.a(NowPlugin.a(this.a.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowPlugin).getAccount(), "Live", "com.tencent.now", "1600000615", new swb(this), false);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\swa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */