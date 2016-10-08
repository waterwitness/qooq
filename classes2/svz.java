import android.os.Bundle;
import com.tencent.biz.now.CgiHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.intervideo.LoginKeyHelper;
import com.tencent.mobileqq.intervideo.now.JumpConfigUpdater;
import com.tencent.mobileqq.intervideo.now.NowFromData;
import com.tencent.mobileqq.intervideo.now.NowPerfUtil;
import com.tencent.mobileqq.intervideo.now.NowPlugin;
import com.tencent.mobileqq.intervideo.now.NowProxy.ListNameData;
import com.tencent.qphone.base.util.QLog;

public class svz
  implements svs
{
  public svz(NowPlugin paramNowPlugin, long paramLong, NowFromData paramNowFromData, int paramInt, NowProxy.ListNameData paramListNameData, Bundle paramBundle)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("XProxy_Perf", 2, "拉取撑量开关完成");
    }
    NowPerfUtil.b("get server config finish");
    if (paramBoolean)
    {
      QLog.i("XProxy|NowProxy", 2, "后台已经撑不住量 需要跳转h5");
      NowPlugin.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowPlugin, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowPlugin.jdField_a_of_type_ComTencentMobileqqIntervideoNowJumpConfigUpdater.a());
      return;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowFromData.b.equals("story"))
    {
      if (QLog.isColorLevel()) {
        QLog.i("XProxy_Perf", 2, "开始判断是否是录播 time = " + System.currentTimeMillis());
      }
      this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowPlugin.jdField_a_of_type_ComTencentBizNowCgiHelper.a(this.jdField_a_of_type_Long, new swa(this));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowPlugin.jdField_a_of_type_ComTencentMobileqqIntervideoLoginKeyHelper.a(NowPlugin.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowPlugin).getAccount(), "Live", "com.tencent.now", "1600000615", new swc(this), false);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\svz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */