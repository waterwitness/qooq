import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.HotChatShare;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;

public class pyu
  extends FriendListObserver
{
  public pyu(HotChatShare paramHotChatShare)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HotChatShare", 2, "onStrangerHeadReady.isSuccess=" + paramBoolean + ",id=" + paramString1 + ",idType=" + paramInt + ",downloadUrl=" + paramString2);
    }
    if ((paramInt != 200) || (TextUtils.isEmpty(paramString1)) || (this.a.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo == null) || (!paramString1.equals(this.a.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.ownerUin))) {}
    for (;;)
    {
      return;
      this.a.c = paramString2;
      if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
      {
        if (this.a.jdField_a_of_type_Int == 0) {
          this.a.jdField_a_of_type_Int = 2;
        }
        while (this.a.jdField_a_of_type_Int == 3)
        {
          this.a.c();
          HotChatShare.a(this.a);
          return;
          if (this.a.jdField_a_of_type_Int == 1) {
            this.a.jdField_a_of_type_Int = 3;
          }
        }
      }
    }
  }
  
  protected void b(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HotChatShare", 2, "onGetFriendDateNick.isSuccess=" + paramBoolean + ",uin=" + paramString1 + ",nick=" + paramString2);
    }
    if ((TextUtils.isEmpty(paramString1)) || (this.a.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo == null) || (!paramString1.equals(this.a.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.ownerUin)) || (!TextUtils.isEmpty(this.a.b))) {}
    for (;;)
    {
      return;
      if (paramBoolean) {
        this.a.b = paramString2;
      }
      if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
      {
        if (this.a.jdField_a_of_type_Int == 0) {
          this.a.jdField_a_of_type_Int = 1;
        }
        while (this.a.jdField_a_of_type_Int == 3)
        {
          this.a.c();
          HotChatShare.a(this.a);
          return;
          if (this.a.jdField_a_of_type_Int == 2) {
            this.a.jdField_a_of_type_Int = 3;
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pyu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */