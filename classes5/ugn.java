import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richmedia.dc.DCShortVideo;
import com.tencent.mobileqq.richmedia.dc.DataReport;
import com.tencent.qphone.base.util.QLog;

public class ugn
  implements Runnable
{
  public ugn(DCShortVideo paramDCShortVideo, AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = new ugt();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaDcDCShortVideo.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_JavaLangString, (ugs)localObject);
    if (QLog.isDevelopLevel()) {
      QLog.d(DCShortVideo.jdField_a_of_type_JavaLangString, 4, "[reportSave]shortVideoType=" + ((ugt)localObject).f + ",uinType = " + ((ugt)localObject).b + ",groupMemCount = " + ((ugt)localObject).c + ",age = " + ((ugt)localObject).d + ",gender = " + ((ugt)localObject).e + ",reprotHour = " + ((ugt)localObject).g + ",netType = " + ((ugt)localObject).h);
    }
    localObject = new ugy("ShortVideo.Save", ((ugt)localObject).a("ShortVideo.Save"));
    DataReport.a().a((ugy)localObject);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ugn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */