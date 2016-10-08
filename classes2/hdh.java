import com.tencent.bitapp.BitAppBaseViewCache;
import com.tencent.bitapp.BitAppBaseViewCache.BitAppGetViewListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

class hdh
  implements Runnable
{
  hdh(hdf paramhdf, String paramString, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(BitAppBaseViewCache.jdField_a_of_type_JavaLangString, 2, "CreateViewListener onLoadFail: " + this.jdField_a_of_type_JavaLangString + " | msgId: " + this.jdField_a_of_type_Hdf.jdField_a_of_type_JavaLangString + " | errorCode: " + this.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_Hdf.jdField_a_of_type_ComTencentBitappBitAppBaseViewCache$BitAppGetViewListener.a(this.jdField_a_of_type_Hdf.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\hdh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */