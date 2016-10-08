import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.app.HotChatObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotchat.HotChatFavoriteHelper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.widget.QQToast;

public class ssz
  extends HotChatObserver
{
  public ssz(HotChatFavoriteHelper paramHotChatFavoriteHelper)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, int paramInt, String paramString2)
  {
    if (paramBoolean1)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isFavorite = paramBoolean2;
      if (paramBoolean2) {
        if (!((Boolean)NearbySPUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "favorite_tutorial_ever", Boolean.valueOf(false))).booleanValue())
        {
          NearbySPUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "favorite_tutorial_ever", Boolean.valueOf(true));
          paramString1 = new QQToast(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
          paramString1.a("√已收藏\n请在 热聊-我的收藏 中查看");
          paramString1.c(1);
          paramString1.b(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
        }
      }
      for (;;)
      {
        HotChatFavoriteHelper.a(this.a, false);
        HotChatFavoriteHelper.a(this.a).sendEmptyMessageDelayed(2, 100L);
        return;
        QQToast.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2, 2131372422, 0).b(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
        continue;
        QQToast.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2, 2131372423, 0).b(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
      }
    }
    if (paramBoolean2) {}
    for (paramString1 = this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131372424);; paramString1 = this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131372425))
    {
      String str = paramString1;
      if (!TextUtils.isEmpty(paramString2)) {
        str = paramString1 + paramString2;
      }
      QQToast.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, str, 0).b(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ssz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */