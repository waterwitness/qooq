import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.agent.AuthorityActivity;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.qphone.base.util.QLog;

public class wpt
  implements Runnable
{
  public wpt(AuthorityActivity paramAuthorityActivity, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Bitmap localBitmap3 = null;
    try
    {
      Bitmap localBitmap1 = BitmapFactory.decodeResource(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.getResources(), 2130838582);
      localBitmap3 = AuthorityUtil.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity, localBitmap1, 63, 63);
      if (localBitmap1 != null) {
        localBitmap1.recycle();
      }
      this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity.runOnUiThread(new wpu(this, localBitmap3));
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        Bitmap localBitmap2 = localBitmap3;
        if (QLog.isColorLevel())
        {
          QLog.d("AuthorityActivity", 2, "initUI decodeResource has OutOfMemoryError!");
          localBitmap2 = localBitmap3;
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wpt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */