import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richmedia.dc.DCShortVideo;
import com.tencent.mobileqq.richmedia.dc.DataReport;
import com.tencent.qphone.base.util.QLog;

public class ugl
  implements Runnable
{
  public ugl(DCShortVideo paramDCShortVideo, QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = new ugr();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaDcDCShortVideo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_JavaLangString, (ugs)localObject);
    ((ugr)localObject).jdField_a_of_type_Int = this.c;
    if (QLog.isDevelopLevel()) {
      QLog.d(DCShortVideo.jdField_a_of_type_JavaLangString, 4, "[reportPreview]shortVideoType=" + ((ugr)localObject).f + ",uinType = " + ((ugr)localObject).b + ",groupMemCount = " + ((ugr)localObject).c + ",age = " + ((ugr)localObject).d + ",gender = " + ((ugr)localObject).e + ",reprotHour = " + ((ugr)localObject).g + ",netType = " + ((ugr)localObject).h + ",playAction = " + ((ugr)localObject).jdField_a_of_type_Int);
    }
    localObject = new ugy("ShortVideo.Preview", ((ugr)localObject).a("ShortVideo.Preview"));
    DataReport.a().a((ugy)localObject);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ugl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */