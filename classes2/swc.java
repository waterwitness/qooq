import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.intervideo.LoginKeyHelper.GetLoginKeyListener;
import com.tencent.mobileqq.intervideo.now.NowFromData;
import com.tencent.mobileqq.intervideo.now.NowPerfUtil;
import com.tencent.mobileqq.intervideo.now.NowPlugin;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.qphone.base.util.QLog;

class swc
  implements LoginKeyHelper.GetLoginKeyListener
{
  swc(svz paramsvz)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    if (!paramBoolean) {
      QLog.i("XProxy|NowProxy", 2, "更新A1票据失败 time = " + System.currentTimeMillis());
    }
    do
    {
      return;
      NowPerfUtil.b("get A1 finish");
      if (this.a.jdField_a_of_type_Int == 1)
      {
        if (PackageUtil.a(BaseApplicationImpl.getContext(), "com.tencent.now"))
        {
          NowPlugin.a(this.a.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowPlugin, this.a.jdField_a_of_type_Long);
          return;
        }
        NowPlugin.a(this.a.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowPlugin, this.a.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowProxy$ListNameData, this.a.jdField_a_of_type_Long, this.a.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowFromData.a, this.a.jdField_a_of_type_AndroidOsBundle);
        return;
      }
    } while (this.a.jdField_a_of_type_Int != 2);
    NowPlugin.a(this.a.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowPlugin, this.a.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowProxy$ListNameData, this.a.jdField_a_of_type_Long, this.a.jdField_a_of_type_ComTencentMobileqqIntervideoNowNowFromData.a, this.a.jdField_a_of_type_AndroidOsBundle);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\swc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */