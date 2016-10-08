import android.os.Handler;
import com.tencent.biz.common.offline.util.IOfflineDownloader;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

class hgt
  implements Runnable
{
  hgt(hgp paramhgp)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = hgp.jdField_a_of_type_ComTencentBizCommonOfflineUtilIOfflineDownloader.a(hgp.jdField_a_of_type_AndroidContentContext, this.a.c);
    if (QLog.isColorLevel()) {
      QLog.i(hgp.a(), 2, "state = " + i);
    }
    if (i != 2) {
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hgt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */