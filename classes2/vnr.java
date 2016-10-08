import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.webkit.URLUtil;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopAioTips;
import com.tencent.mobileqq.troop.data.TroopAioTopADInfo;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager;
import com.tencent.mobileqq.troop.logic.TroopFeedsCenterLogic;
import com.tencent.mobileqq.troop.utils.TroopAioADManager;
import com.tencent.mobileqq.troop.widget.TroopAioFeedsCenterView;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.ref.WeakReference;

public class vnr
  implements Animation.AnimationListener
{
  public vnr(TroopFeedsCenterLogic paramTroopFeedsCenterLogic)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.i = false;
    if (this.a.jdField_b_of_type_AndroidViewAnimationTranslateAnimation == paramAnimation)
    {
      this.a.jdField_a_of_type_AndroidViewView.setVisibility(4);
      if (this.a.jdField_a_of_type_AndroidViewView != null)
      {
        if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
          this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a(this.a.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
        }
        this.a.jdField_a_of_type_AndroidViewView.clearAnimation();
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.d = false;
      }
      if (this.a.jdField_b_of_type_Boolean)
      {
        this.a.e(true);
        this.a.jdField_b_of_type_Boolean = false;
      }
      if ((!this.a.k) && (this.a.jdField_b_of_type_AndroidWidgetImageView != null) && (!this.a.l))
      {
        if (this.a.j) {
          this.a.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130839789);
        }
      }
      else if (this.a.e)
      {
        if (NetworkUtil.e(BaseApplication.getContext())) {
          break label293;
        }
        QQToast.a((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), 1, ((FragmentActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).getString(2131364378), 1).b(((FragmentActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getDimensionPixelSize(2131492908) - (int)DisplayUtils.a((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), 5.0F));
      }
    }
    label293:
    label476:
    label485:
    label749:
    label808:
    label822:
    for (;;)
    {
      return;
      this.a.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130839774);
      break;
      TroopAioADManager localTroopAioADManager = (TroopAioADManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(132);
      String str = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
      if (!TextUtils.isEmpty(str))
      {
        TroopAioTopADInfo localTroopAioTopADInfo = localTroopAioADManager.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
        Object localObject;
        if (localTroopAioTopADInfo != null)
        {
          if (!TextUtils.isEmpty(localTroopAioTopADInfo.jumpUrl)) {
            break label476;
          }
          paramAnimation = localTroopAioTopADInfo.backgroundUrl;
          localObject = JumpParser.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), paramAnimation);
          if (localObject == null) {
            break label485;
          }
          ((JumpAction)localObject).b();
        }
        for (;;)
        {
          ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "Clk_Promote", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, localTroopAioTopADInfo.adId + "", "", "");
          localTroopAioADManager.a(str);
          this.a.d = false;
          return;
          paramAnimation = localTroopAioTopADInfo.jumpUrl;
          break;
          if (paramAnimation.startsWith("http"))
          {
            localObject = new Intent((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), QQBrowserActivity.class);
            ((Intent)localObject).putExtra("url", URLUtil.guessUrl(paramAnimation));
            ((FragmentActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).startActivity((Intent)localObject);
          }
        }
        if (this.a.jdField_a_of_type_AndroidViewAnimationTranslateAnimation == paramAnimation)
        {
          if ((this.a.jdField_a_of_type_AndroidViewView != null) && (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null))
          {
            this.a.jdField_a_of_type_AndroidViewView.setVisibility(0);
            this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a(this.a.jdField_a_of_type_AndroidWidgetRelativeLayout, true);
            this.a.jdField_a_of_type_AndroidViewView.clearAnimation();
            if ((this.a.c) && (this.a.jdField_a_of_type_AndroidViewView != null) && ((this.a.jdField_a_of_type_AndroidViewView instanceof TroopAioFeedsCenterView)))
            {
              if (!this.a.d) {
                break label749;
              }
              this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.b();
            }
          }
          if ((!this.a.k) && (!this.a.l) && (this.a.jdField_b_of_type_AndroidWidgetImageView != null))
          {
            if (!this.a.j) {
              break label808;
            }
            this.a.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130839790);
          }
          for (;;)
          {
            if (this.a.jdField_a_of_type_AndroidViewView == null) {
              break label822;
            }
            this.a.jdField_a_of_type_AndroidViewView.requestFocus();
            return;
            if (this.a.f)
            {
              ((TroopAioFeedsCenterView)this.a.jdField_a_of_type_AndroidViewView).a();
              this.a.f = false;
              break;
            }
            this.a.c = false;
            ((TroopAioFeedsCenterView)this.a.jdField_a_of_type_AndroidViewView).a(true);
            break;
            this.a.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130839775);
          }
        }
      }
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.i = true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vnr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */