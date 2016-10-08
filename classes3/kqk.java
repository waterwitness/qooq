import android.content.SharedPreferences;
import android.content.res.Resources;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.task.ApolloActionManager;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class kqk
  extends GestureDetector.SimpleOnGestureListener
{
  public kqk(BaseChatPie paramBaseChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    ApolloActionManager localApolloActionManager = ApolloActionManager.a();
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {}
    for (boolean bool = AnonymousChatHelper.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "onDoubleTap, isAnonymousChat:" + bool);
      }
      if ((1 != localApolloActionManager.e) || (bool)) {
        return super.onDoubleTap(paramMotionEvent);
      }
      SharedPreferences localSharedPreferences = localApolloActionManager.a;
      if ((localSharedPreferences != null) && (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {}
      for (bool = localSharedPreferences.getBoolean("is_apollo_hide" + this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), false);; bool = false)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.BaseChatPie", 2, "isHide:" + bool);
        }
        if (!bool)
        {
          localApolloActionManager.b = true;
          localApolloActionManager.a(true, true, this.a.f());
          VipUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "aio_double_disappear_clk", 0, 0, new String[] { Integer.toString(ApolloUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) });
          QQToast.a(BaseApplicationImpl.getContext(), BaseApplicationImpl.getContext().getResources().getString(2131372341), 1).a();
        }
        for (;;)
        {
          return super.onDoubleTap(paramMotionEvent);
          localApolloActionManager.b = false;
          localApolloActionManager.a(false, true, this.a.f());
          VipUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "aio_double_show_clk", 0, 0, new String[] { Integer.toString(ApolloUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)), "0" });
        }
      }
    }
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return super.onDown(paramMotionEvent);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((BaseChatPie.h() == 1) && (!BaseChatPie.a(this.a).booleanValue())) {
      if (this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.d_() != 0) {}
    }
    do
    {
      return false;
      if ((this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null) && (this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.t() >= this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.d_() - 1))
      {
        paramMotionEvent1 = new int[2];
        this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount() - 1).getLocationOnScreen(paramMotionEvent1);
        int i = paramMotionEvent1[1];
        if (BaseChatPie.i(this.a) == i)
        {
          this.a.o(1);
          BaseChatPie.a(this.a, Boolean.valueOf(true));
          BaseChatPie.g(this.a, -1);
        }
        BaseChatPie.g(this.a, i);
      }
      if (BaseChatPie.c(this.a)) {
        BaseChatPie.b(this.a, true);
      }
    } while (paramFloat2 >= 0.0F);
    this.a.D = false;
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "onShowPress");
    }
    this.a.e(false);
    BaseChatPie.b(this.a, true);
    super.onShowPress(paramMotionEvent);
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "onSingleTapConfirmed, isPlaying:" + ApolloActionManager.a().c);
    }
    this.a.e(false);
    BaseChatPie.b(this.a, true);
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kqk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */