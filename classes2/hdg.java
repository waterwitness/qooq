import com.tencent.bitapp.BitAppBaseViewCache;
import com.tencent.bitapp.BitAppBaseViewCache.BitAppGetViewListener;
import com.tencent.bitapp.view.BitAppBaseView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

class hdg
  implements Runnable
{
  hdg(hdf paramhdf, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(BitAppBaseViewCache.jdField_a_of_type_JavaLangString, 2, "CreateViewListener onLoadSuccess: " + this.jdField_a_of_type_JavaLangString + " | msgId: " + this.jdField_a_of_type_Hdf.jdField_a_of_type_JavaLangString);
    }
    BitAppBaseView localBitAppBaseView = this.jdField_a_of_type_Hdf.jdField_a_of_type_ComTencentBitappBitAppBaseViewCache$BitAppGetViewListener.a();
    if (localBitAppBaseView != null)
    {
      this.jdField_a_of_type_Hdf.jdField_a_of_type_ComTencentBitappBitAppBaseViewCache$BitAppGetViewListener.a(this.jdField_a_of_type_Hdf.jdField_a_of_type_JavaLangString, localBitAppBaseView);
      return;
    }
    this.jdField_a_of_type_Hdf.jdField_a_of_type_ComTencentBitappBitAppBaseViewCache$BitAppGetViewListener.a(this.jdField_a_of_type_Hdf.jdField_a_of_type_JavaLangString, -1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\hdg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */