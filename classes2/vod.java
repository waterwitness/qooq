import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare.GeneralClickHandler;
import com.tencent.mobileqq.troop.logic.VideoPlayLogic;
import com.tencent.mobileqq.troop.utils.TVKTroopVideoManager;
import com.tencent.mobileqq.troop.widget.MessageSubtitleView;
import com.tencent.mobileqq.troop.widget.VideoViewX;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import java.util.Iterator;
import java.util.List;

public class vod
  extends BizTroopObserver
{
  public vod(VideoPlayLogic paramVideoPlayLogic)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(String paramString, List paramList, int paramInt)
  {
    this.a.d = paramInt;
    if (paramString.compareToIgnoreCase(this.a.jdField_b_of_type_JavaLangString) != 0) {}
    do
    {
      return;
      if ((paramString.compareToIgnoreCase(this.a.jdField_b_of_type_JavaLangString) != 0) || (paramList == null) || (paramList.size() <= 0)) {
        break;
      }
      this.a.jdField_a_of_type_JavaUtilList.clear();
      paramString = paramList.iterator();
      while (paramString.hasNext())
      {
        paramList = (String)paramString.next();
        if (!TextUtils.isEmpty(paramList)) {
          this.a.jdField_a_of_type_JavaUtilList.add(paramList);
        }
      }
      if (this.a.jdField_a_of_type_JavaUtilList.size() <= 0)
      {
        if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing() == true)) {
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        }
        if ((this.a.i) && (this.a.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare != null))
        {
          new StructMsgForGeneralShare.GeneralClickHandler(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidViewView, this.a.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare).a(this.a.jdField_b_of_type_JavaLangString);
          return;
        }
        this.a.a(this.a.jdField_b_of_type_JavaLangString);
        return;
      }
      this.a.jdField_a_of_type_Int = 0;
    } while ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) || (!this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()));
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    this.a.f();
    if (this.a.jdField_b_of_type_AndroidWidgetRelativeLayout == null)
    {
      this.a.jdField_b_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this.a.jdField_a_of_type_AndroidContentContext);
      this.a.jdField_b_of_type_AndroidWidgetRelativeLayout.setId(2131296473);
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.a.jdField_b_of_type_AndroidWidgetRelativeLayout, -1, 0);
    }
    this.a.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(-16777216);
    if (TVK_SDKMgr.isInstalled(this.a.jdField_a_of_type_AndroidContentContext.getApplicationContext()))
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTVKTroopVideoManager == null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTVKTroopVideoManager = new TVKTroopVideoManager((BaseActivity)this.a.jdField_a_of_type_AndroidContentContext);
        paramString = this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTVKTroopVideoManager.jdField_a_of_type_AndroidViewView;
        paramString.setId(2131296472);
        this.a.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(paramString, -1, -1);
        paramList = (RelativeLayout.LayoutParams)paramString.getLayoutParams();
        paramList.addRule(13);
        paramString.setLayoutParams(paramList);
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetMessageSubtitleView == null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetMessageSubtitleView = new MessageSubtitleView(this.a.jdField_a_of_type_AndroidContentContext);
        paramString = new RelativeLayout.LayoutParams(-1, -2);
        paramString.leftMargin = this.a.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131493284);
        paramString.rightMargin = this.a.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131493285);
        paramString.topMargin = this.a.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131493287);
        paramString.addRule(10);
        this.a.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetMessageSubtitleView, paramString);
      }
      if (this.a.c()) {
        break label707;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetMessageSubtitleView.setVisibility(8);
    }
    for (;;)
    {
      VideoPlayLogic.a(this.a, true);
      return;
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX != null) {
        break;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX = new VideoViewX(this.a.jdField_a_of_type_AndroidContentContext);
      this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX.setId(2131296472);
      this.a.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX, -1, -1);
      paramString = (RelativeLayout.LayoutParams)this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX.getLayoutParams();
      paramString.addRule(13);
      this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX.setLayoutParams(paramString);
      break;
      label707:
      this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().addFlags(1024);
      ChatFragment.a(false, this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing() == true)) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    if ((this.a.i) && (this.a.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare != null))
    {
      new StructMsgForGeneralShare.GeneralClickHandler(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidViewView, this.a.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare).a(this.a.jdField_b_of_type_JavaLangString);
      return;
    }
    this.a.a(this.a.jdField_b_of_type_JavaLangString);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */