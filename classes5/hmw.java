import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;

public class hmw
  implements Runnable
{
  public hmw(AccountDetailActivity paramAccountDetailActivity, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      int i = DisplayUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity, 110.0F);
      Bitmap localBitmap = ImageUtil.a(this.jdField_a_of_type_JavaLangString, i, i);
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(ImageUtil.b(localBitmap, i, i));
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, localException.toString());
      }
      localException.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hmw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */