import com.tencent.biz.qqstory.pgc.model.UserInfo;
import com.tencent.biz.qqstory.pgc.view.InfoCardDialog;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;

public class imh
  extends FriendListObserver
{
  public imh(InfoCardDialog paramInfoCardDialog)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, String[] paramArrayOfString)
  {
    super.a(paramBoolean, paramArrayOfString);
    int j;
    int i;
    if ((paramBoolean) && (paramArrayOfString != null))
    {
      j = paramArrayOfString.length;
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        if ((paramArrayOfString[i] == null) || (!paramArrayOfString[i].equals(String.valueOf(this.a.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo.uid)))) {
          break label110;
        }
        paramArrayOfString = ((FriendsManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).a(String.valueOf(this.a.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo.uid));
        if (paramArrayOfString != null)
        {
          paramArrayOfString = paramArrayOfString.getRichStatus();
          this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setText(paramArrayOfString.getPlainText());
        }
      }
      return;
      label110:
      i += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\imh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */