import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFilePicTabView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.LinkedHashMap;

class rtw
  implements Runnable
{
  rtw(rtv paramrtv, LinkedHashMap paramLinkedHashMap, int paramInt1, int paramInt2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_Rtv.a.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    this.jdField_a_of_type_Rtv.a.jdField_a_of_type_JavaUtilLinkedHashMap.putAll(this.jdField_a_of_type_JavaUtilLinkedHashMap);
    this.jdField_a_of_type_Rtv.a.j();
    if ((this.jdField_a_of_type_Int == -1) || (this.b == -1))
    {
      this.jdField_a_of_type_Rtv.a.setSelect(0);
      return;
    }
    if ((this.jdField_a_of_type_Rtv.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.g()) || (this.jdField_a_of_type_Rtv.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.h()))
    {
      this.jdField_a_of_type_Rtv.a.setPos(this.jdField_a_of_type_Int, this.b);
      return;
    }
    this.jdField_a_of_type_Rtv.a.setSelect(0);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rtw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */