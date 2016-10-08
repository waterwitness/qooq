import com.tencent.biz.qqstory.share.StoryAccountShare;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;

public class iqg
  implements WXShareHelper.WXShareListener
{
  public iqg(StoryAccountShare paramStoryAccountShare, String paramString, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(BaseResp paramBaseResp)
  {
    if ((this.jdField_a_of_type_JavaLangString == null) || (!this.jdField_a_of_type_JavaLangString.equals(paramBaseResp.transaction)))
    {
      WXShareHelper.a().b(this);
      return;
    }
    switch (paramBaseResp.errCode)
    {
    case -1: 
    default: 
      QRUtils.a(1, 2131369518);
    case -2: 
      WXShareHelper.a().b(this);
      return;
    }
    if (this.jdField_a_of_type_Int == 2) {}
    for (paramBaseResp = "wechat_suc";; paramBaseResp = "moment_suc")
    {
      StoryReportor.a("share_uin", paramBaseResp, 0, this.jdField_a_of_type_ComTencentBizQqstoryShareStoryAccountShare.jdField_a_of_type_Int, new String[] { this.jdField_a_of_type_ComTencentBizQqstoryShareStoryAccountShare.c });
      QRUtils.a(2, 2131369517);
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iqg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */