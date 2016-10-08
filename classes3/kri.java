import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.activity.C2CCallToGroupCall;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class kri
  extends DiscussionObserver
{
  public kri(C2CCallToGroupCall paramC2CCallToGroupCall)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong, String paramString)
  {
    if (paramBoolean)
    {
      localArrayList = new ArrayList();
      localResultRecord = new ResultRecord();
      localResultRecord.jdField_a_of_type_JavaLangString = this.a.jdField_b_of_type_JavaLangString;
      localResultRecord.jdField_b_of_type_JavaLangString = this.a.c;
      localResultRecord.jdField_a_of_type_Int = this.a.jdField_a_of_type_Int;
      localResultRecord.c = this.a.d;
      localResultRecord.d = this.a.e;
      this.a.jdField_a_of_type_AndroidContentIntent.putExtra("roomId", String.valueOf(paramLong));
      this.a.jdField_a_of_type_AndroidContentIntent.putExtra("discussName", paramString);
      this.a.jdField_a_of_type_AndroidContentIntent.putExtra("qqPhoneUserList", localArrayList);
      this.a.jdField_a_of_type_AndroidContentIntent.putExtra("audioType", 2);
      this.a.jdField_a_of_type_AndroidContentIntent.putExtra("callType", 2);
      this.a.jdField_a_of_type_AndroidContentIntent.putExtra("reportType", C2CCallToGroupCall.a(this.a));
      this.a.jdField_a_of_type_AndroidContentIntent.putExtra("from", this.a.jdField_b_of_type_Int);
      this.a.a(String.valueOf(paramLong), paramString);
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(C2CCallToGroupCall.a(this.a));
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      }
      this.a.jdField_a_of_type_AndroidAppActivity.finish();
    }
    while (!QLog.isColorLevel())
    {
      ArrayList localArrayList;
      ResultRecord localResultRecord;
      return;
    }
    QLog.d("C2CCallToGroupCall", 2, "create discussion fail");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kri.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */