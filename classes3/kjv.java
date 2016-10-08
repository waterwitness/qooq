import android.widget.TextView;
import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.activity.AutoRemarkActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import tencent.mobileim.structmsg.structmsg.FriendInfo;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class kjv
  extends FriendListObserver
{
  public kjv(AddRequestActivity paramAddRequestActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    Card localCard;
    if ((paramBoolean) && (AddRequestActivity.a(this.a) != null) && (AddRequestActivity.a(this.a).equals(paramString)))
    {
      localCard = ((FriendsManager)this.a.app.getManager(50)).a(paramString);
      if (localCard != null)
      {
        if ((AddRequestActivity.a(this.a) == null) || (AddRequestActivity.a(this.a).msg == null) || (!AddRequestActivity.a(this.a).msg.friend_info.has()) || (AddRequestActivity.a(this.a).msg.friend_info.msg_joint_friend.has() != true)) {
          break label213;
        }
        AddRequestActivity.b(this.a).setText(AddRequestActivity.a(this.a).msg.friend_info.msg_joint_friend.get());
        AddRequestActivity.b(this.a).setVisibility(0);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.systemmsg.AddRequestActivity", 2, "Card find Uin :" + paramString + "age:" + localCard.age + "gender:" + localCard.shGender);
      }
      return;
      label213:
      AddRequestActivity.b(this.a).setVisibility(8);
      this.a.a();
    }
  }
  
  protected void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (AddRequestActivity.a(this.a))
    {
      if (!paramBoolean) {
        this.a.a(2130838442, this.a.getString(2131368656));
      }
    }
    else {
      return;
    }
    AutoRemarkActivity.a(this.a, 0, paramString, 0L);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kjv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */