import com.tencent.mobileqq.dating.DatingDestinationActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.ipc.NearbyProcManager;
import com.tencent.mobileqq.nearby.ipc.NearbyProcObserver;

public class rdh
  extends NearbyProcObserver
{
  public rdh(DatingDestinationActivity paramDatingDestinationActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.jdField_h_of_type_Boolean = true;
      String[] arrayOfString;
      if (this.a.j)
      {
        arrayOfString = this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().a(this.a.g);
        this.a.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo = this.a.a(arrayOfString);
        this.a.b();
        this.a.a(this.a.g, arrayOfString, true);
      }
      if (this.a.i)
      {
        arrayOfString = this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().a(this.a.jdField_h_of_type_JavaLangString);
        this.a.f = this.a.a(arrayOfString);
        this.a.a(this.a.jdField_h_of_type_JavaLangString, arrayOfString, false);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rdh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */