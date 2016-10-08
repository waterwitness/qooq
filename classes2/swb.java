import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.intervideo.LoginKeyHelper.GetLoginKeyListener;
import com.tencent.mobileqq.intervideo.now.NowFromData;
import com.tencent.mobileqq.intervideo.now.NowPerfUtil;
import com.tencent.mobileqq.intervideo.now.NowPlugin;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.qphone.base.util.QLog;

class swb
  implements LoginKeyHelper.GetLoginKeyListener
{
  swb(swa paramswa)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    if (!paramBoolean)
    {
      QLog.i("XProxy|NowProxy", 2, "更新A1票据失败 time = " + System.currentTimeMillis());
      Toast.makeText(BaseApplicationImpl.getContext(), "获取登录票据失败", 0);
    }
    do
    {
      return;
      NowPerfUtil.b("get A1 finish");
      if (this.a.a.jdField_a_of_type_Int == 1)
      {
        if (PackageUtil.a(BaseApplicationImpl.getContext(), "com.tencent.now"))
        {
          QLog.i("XProxy|NowProxy", 2, "已安装了独立app，直接跳转");
          NowPlugin.a(this.a.a.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowPlugin, this.a.a.jdField_a_of_type_Long);
          return;
        }
        NowPlugin.a(this.a.a.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowPlugin, this.a.a.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowProxy$ListNameData, this.a.a.jdField_a_of_type_Long, this.a.a.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowFromData.a, this.a.a.jdField_a_of_type_AndroidOsBundle);
        return;
      }
    } while (this.a.a.jdField_a_of_type_Int != 2);
    NowPlugin.a(this.a.a.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowPlugin, this.a.a.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowProxy$ListNameData, this.a.a.jdField_a_of_type_Long, this.a.a.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowFromData.a, this.a.a.jdField_a_of_type_AndroidOsBundle);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\swb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */