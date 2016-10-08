import android.content.Context;
import com.tencent.av.service.LBSInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.c2b.C2BLBSUtil;
import cooperation.c2b.C2BLBSUtil.C2BLBSObserver;

public class xyt
  extends C2BLBSUtil.C2BLBSObserver
{
  public xyt(C2BLBSUtil paramC2BLBSUtil, Context paramContext, AppInterface paramAppInterface, String paramString, C2BLBSUtil.C2BLBSObserver paramC2BLBSObserver)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, LBSInfo paramLBSInfo)
  {
    if ((paramInt == 0) && (paramLBSInfo != null))
    {
      this.jdField_a_of_type_CooperationC2bC2BLBSUtil.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_CooperationC2bC2BLBSUtil$C2BLBSObserver, paramLBSInfo);
      return;
    }
    this.jdField_a_of_type_CooperationC2bC2BLBSUtil$C2BLBSObserver.a(paramInt, null, null);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xyt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */