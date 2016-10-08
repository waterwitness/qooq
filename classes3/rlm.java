import android.text.TextUtils;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.NearFieldTroopHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class rlm
  implements Runnable
{
  public rlm(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity, NearFieldTroopHandler paramNearFieldTroopHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.b == 1) {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.e)) {}
    }
    do
    {
      for (;;)
      {
        return;
        try
        {
          long l = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.e).longValue();
          boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppNearFieldTroopHandler.a(l, 1);
          if (!bool)
          {
            Face2FaceAddFriendActivity.a(this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity).sendEmptyMessageDelayed(6, 0L);
            this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.A = 2;
            return;
          }
        }
        catch (Exception localException) {}
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqAppNearFieldTroopHandler.a(0L, 1))
      {
        Face2FaceAddFriendActivity.a(this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity).sendEmptyMessageDelayed(6, 0L);
        this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.A = 2;
        return;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.a.a(this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.app.a(), false));
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.z = 2;
    Face2FaceAddFriendActivity.a(this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity).sendEmptyMessageDelayed(6, 0L);
    return;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\rlm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */