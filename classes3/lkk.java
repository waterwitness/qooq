import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;

public class lkk
  implements View.OnLongClickListener
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private DataTag jdField_a_of_type_ComTencentMobileqqProfileDataTag;
  
  public lkk(FriendProfileCardActivity paramFriendProfileCardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new lkn(this);
  }
  
  public boolean onLongClick(View paramView)
  {
    if ((paramView == null) || (!(paramView.getTag() instanceof DataTag))) {
      return false;
    }
    Object localObject = (DataTag)paramView.getTag();
    switch (((DataTag)localObject).ah)
    {
    }
    for (;;)
    {
      return true;
      if (ProfileActivity.AllInOne.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a.a))
      {
        paramView.setSelected(true);
        this.jdField_a_of_type_ComTencentMobileqqProfileDataTag = ((DataTag)localObject);
        localObject = new QQCustomMenu();
        ((QQCustomMenu)localObject).a(2131305407, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.getString(2131369291));
        BubbleContextMenu.a(paramView, (QQCustomMenu)localObject, this.jdField_a_of_type_AndroidViewView$OnClickListener, new lkl(this, paramView));
        continue;
        paramView.setSelected(true);
        this.jdField_a_of_type_ComTencentMobileqqProfileDataTag = ((DataTag)localObject);
        localObject = new QQCustomMenu();
        ((QQCustomMenu)localObject).a(2131305407, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.getString(2131369291));
        BubbleContextMenu.a(paramView, (QQCustomMenu)localObject, this.jdField_a_of_type_AndroidViewView$OnClickListener, new lkm(this, paramView));
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lkk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */