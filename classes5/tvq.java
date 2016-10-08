import android.os.Handler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.VipProfileCardPreviewActivity;
import com.tencent.mobileqq.profile.upload.task.VipBaseUpsImageUploadTask;
import com.tencent.upload.uinterface.data.UpsImageUploadResult;

public class tvq
  extends VipBaseUpsImageUploadTask
{
  public tvq(VipProfileCardPreviewActivity paramVipProfileCardPreviewActivity, long paramLong, String paramString1, byte[] paramArrayOfByte, String paramString2, String paramString3)
  {
    super(paramLong, paramString1, paramArrayOfByte, paramString2);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
    case 1001: 
      do
      {
        return;
        VipProfileCardPreviewActivity.a(this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity);
      } while (a() == null);
      VipProfileCardPreviewActivity.a(this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity, this.jdField_a_of_type_JavaLangString, (UpsImageUploadResult)a());
      return;
    }
    VipProfileCardPreviewActivity.a(this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity);
    paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.a.obtainMessage(24, a());
    this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.a.sendMessage(paramVarArgs);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tvq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */