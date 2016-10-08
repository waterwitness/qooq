import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;

public class lga
  extends FriendListObserver
{
  public lga(DiscussionInfoCardActivity paramDiscussionInfoCardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      if ((this.a.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.ownerUin != null))
      {
        paramString = ((FriendsManager)this.a.app.getManager(50)).c(this.a.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.ownerUin + "");
        if (paramString != null) {
          this.a.e = paramString.name;
        }
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("DiscussionInfoCardActivity", 2, "onUpdateFriendInfo get owner name failed");
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    if (paramBoolean)
    {
      this.a.a();
      DiscussionInfoCardActivity.a(this.a).setRightText(DiscussionInfoCardActivity.b(this.a));
      DiscussionInfoCardActivity.a(this.a).notifyDataSetChanged();
    }
    while ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) || (!this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) || (this.a.isFinishing())) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lga.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */