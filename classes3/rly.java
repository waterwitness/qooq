import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class rly
  implements Runnable
{
  public rly(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.a.e) && (this.a.f))
    {
      if (QLog.isColorLevel()) {
        QLog.d(Face2FaceAddFriendActivity.jdField_a_of_type_JavaLangString, 2, "clearSystemMsgData");
      }
      this.a.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager.f();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\rly.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */