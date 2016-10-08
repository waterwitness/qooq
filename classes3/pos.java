import android.graphics.Bitmap;
import android.support.v4.util.MQLruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.adapter.LebaListViewAdapter;
import com.tencent.mobileqq.adapter.LebaListViewAdapter.CornerListItemHolder;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.LebaUtil;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class pos
  implements Runnable
{
  public pos(LebaListViewAdapter paramLebaListViewAdapter, File paramFile, LebaViewItem paramLebaViewItem, String paramString, LebaListViewAdapter.CornerListItemHolder paramCornerListItemHolder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaIoFile.exists())
    {
      Bitmap localBitmap = LebaUtil.a(this.jdField_a_of_type_JavaIoFile);
      if (localBitmap == null) {
        break label105;
      }
      if (QLog.isColorLevel()) {
        QLog.d("LebaListViewAdapter", 2, "found bitmap from sdcard, info=" + this.jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strResName);
      }
      BaseApplicationImpl.a.put(this.jdField_a_of_type_JavaLangString, localBitmap);
      this.jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem.jdField_a_of_type_AndroidGraphicsBitmap = localBitmap;
      ((BaseActivity)this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter.a).runOnUiThread(new pot(this, localBitmap));
    }
    label105:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("LebaListViewAdapter", 2, "can't find bitmap form cache & sdcard" + this.jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strResName);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */