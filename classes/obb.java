import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.FaceDrawable;

public class obb
  extends FriendListObserver
{
  public obb(PublicAccountChatPie paramPublicAccountChatPie, ImageView paramImageView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie.a().a))) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie.a, paramString, (byte)3));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\obb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */