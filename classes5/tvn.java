import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Message;
import android.support.v4.util.MQLruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.VipProfileCardPreviewActivity;

public class tvn
  implements Runnable
{
  public tvn(VipProfileCardPreviewActivity paramVipProfileCardPreviewActivity, String paramString, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = VipProfileCardPreviewActivity.a(this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity, this.jdField_a_of_type_JavaLangString, false);
    if (localObject != null)
    {
      localObject = new BitmapDrawable(this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.getResources(), (Bitmap)localObject);
      BaseApplicationImpl.a.put(this.jdField_a_of_type_JavaLangString, localObject);
      localObject = this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.a.obtainMessage();
      ((Message)localObject).what = 28;
      ((Message)localObject).arg1 = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.a.sendMessage((Message)localObject);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tvn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */