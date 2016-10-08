import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.QZoneShareData;
import cooperation.qzone.share.QZoneShareActivity;

public class ypd
  implements BusinessObserver
{
  public ypd(QZoneShareActivity paramQZoneShareActivity, String paramString, QZoneShareData paramQZoneShareData)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramInt == 1) && ((paramObject instanceof OpenID)))
    {
      paramObject = (OpenID)paramObject;
      if ((((OpenID)paramObject).openID != null) && (!((OpenID)paramObject).openID.equals(this.jdField_a_of_type_JavaLangString))) {
        this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity.a(this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity, this.jdField_a_of_type_CooperationQzoneQZoneShareData);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ypd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */