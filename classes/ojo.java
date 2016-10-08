import com.tencent.mobileqq.activity.contact.troop.NotificationAdapter;
import com.tencent.mobileqq.activity.contact.troop.NotificationView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.widget.SlideDetectListView.OnScrollToTopListener;
import com.tencent.widget.AbsListView;

public class ojo
  implements SlideDetectListView.OnScrollToTopListener
{
  public ojo(NotificationView paramNotificationView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a() {}
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter != null) && (paramInt == 0) && (this.a.r == this.a.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter.getCount())) {
      NotificationView.b(this.a);
    }
    this.a.q = paramInt;
    if (paramInt != 0)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a();
      this.a.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.c();
    }
    while (!this.a.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b()) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b();
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a.r = (paramInt1 + paramInt2 - 1);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ojo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */