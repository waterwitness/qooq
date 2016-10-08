import EncounterSvc.RespGetEncounterV2;
import EncounterSvc.UserData;
import NeighborComm.RespHeader;
import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
import android.widget.TextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.NearbyCmdHelper;
import com.tencent.mobileqq.app.NearbyObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.NearbyDataManager;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.fragment.NearbyFragment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearpeople.mytab.NearbyMyTabCard;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.util.ThreadPriorityManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x683.cmd0x683.RankListInfo;

public class snz
  extends NearbyObserver
{
  public snz(NearbyFragment paramNearbyFragment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("NearbyFragment", 2, "onGetCharmEvent() uin=" + this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a() + " new charm=" + paramInt3 + " level=" + paramInt4);
      }
      String str = StringUtil.a(paramString, "<head>", "</head>");
      paramString = StringUtil.a(paramString, "<body>", "</body>");
      soc localsoc = new soc(this);
      paramString = QQUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, str, paramString, paramInt3 - paramInt1, localsoc, localsoc);
    } while (this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.isFinishing());
    paramString.show();
  }
  
  protected void a(boolean paramBoolean, RespHeader paramRespHeader, RespGetEncounterV2 paramRespGetEncounterV2, cmd0x683.RankListInfo paramRankListInfo, ToServiceMsg paramToServiceMsg, List paramList)
  {
    boolean bool = paramToServiceMsg.extraData.getBoolean("first");
    int i = paramToServiceMsg.extraData.getInt("classChild");
    long l = paramToServiceMsg.extraData.getLong("requestId");
    ThreadPriorityManager.a(true);
    this.a.jdField_a_of_type_ComTencentMobileqqConfigNearbyDataManager.a(false);
    if ((paramBoolean) && (this.a.g)) {
      this.a.g = false;
    }
    if (paramBoolean) {
      this.a.i = paramToServiceMsg.extraData.getBoolean("hasEditInterest", false);
    }
    int j = paramToServiceMsg.extraData.getByte("interest", (byte)0).byteValue();
    if (QLog.isColorLevel())
    {
      if (paramRespHeader != null)
      {
        paramList = Integer.valueOf(paramRespHeader.eReplyCode);
        NearbyUtils.a("onUpdateGetEncounter isSuccess:", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool), Integer.valueOf(i), paramList, Long.valueOf(l), Long.valueOf(this.a.c) });
      }
    }
    else {
      if (l == this.a.c) {
        break label210;
      }
    }
    label210:
    label628:
    label829:
    label840:
    for (;;)
    {
      return;
      paramList = "null";
      break;
      if (!this.a.e) {
        this.a.e = true;
      }
      if ((bool) && (this.a.l)) {
        this.a.l = false;
      }
      if ((paramBoolean) && (paramRespGetEncounterV2 != null))
      {
        this.a.s = paramRespGetEncounterV2.stUserData.iLat;
        this.a.t = paramRespGetEncounterV2.stUserData.iLon;
        this.a.d = (MessageCache.a() * 1000L);
        this.a.b = System.currentTimeMillis();
        if ((paramRespGetEncounterV2.stUserData.lNextGrid != -1L) && ((j == 0) || (this.a.i)))
        {
          this.a.h = true;
          this.a.jdField_a_of_type_ComTencentMobileqqConfigNearbyDataManager.a(this.a.jdField_a_of_type_JavaUtilList);
          if (QLog.isColorLevel()) {
            QLog.d("NearbyFragment", 2, "onUpdateGetEncounter mShowFindSchoolMatePB = " + this.a.jdField_a_of_type_ComTencentMobileqqConfigNearbyDataManager.a);
          }
          if (this.a.jdField_a_of_type_ComTencentMobileqqConfigNearbyDataManager.a) {
            this.a.jdField_a_of_type_ComTencentMobileqqConfigNearbyDataManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity);
          }
          if ((!StringUtil.b(paramRespGetEncounterV2.strSecurityTips)) && (!StringUtil.b(paramRespGetEncounterV2.strSecurityDetailUrl)))
          {
            paramRespHeader = DialogUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, 230);
            paramRespHeader.setTitle("交友小提示");
            paramRespHeader.getMessageTextView().setVisibility(8);
            paramList = paramRespHeader.getMessageTextView_Plain_Text();
            paramList.setVisibility(0);
            SpannableString localSpannableString = new SpannableString(paramRespGetEncounterV2.strSecurityTips + "了解更多");
            localSpannableString.setSpan(new URLSpan(paramRespGetEncounterV2.strSecurityDetailUrl), paramRespGetEncounterV2.strSecurityTips.length(), localSpannableString.length(), 18);
            localSpannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#00a5e0")), paramRespGetEncounterV2.strSecurityTips.length(), localSpannableString.length(), 33);
            paramList.setText(localSpannableString);
            paramList.setMovementMethod(LinkMovementMethod.getInstance());
            paramRespHeader.setNegativeButton("我知道了", new soa(this, paramRespHeader));
            paramRespHeader.show();
          }
          if ((bool) && (paramBoolean))
          {
            this.a.jdField_a_of_type_TencentImOidbCmd0x683Cmd0x683$RankListInfo = paramRankListInfo;
            this.a.a(paramRankListInfo, false);
            if (this.a.jdField_a_of_type_JavaUtilArrayList != null) {
              this.a.jdField_a_of_type_JavaUtilArrayList.clear();
            }
          }
          this.a.a(bool, paramBoolean, this.a.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters);
          if ((paramBoolean) || (!paramToServiceMsg.extraData.getBoolean("isLbsInfoNull", false))) {
            break label829;
          }
          paramRespHeader = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(5);
          if (DatingUtil.a())
          {
            if (QLog.isColorLevel()) {
              QLog.d("NearbyFragment", 2, "onUpdateGetEncounter.lbsinfo is null and permission is denied");
            }
            paramRespHeader.arg1 = 1;
          }
          this.a.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramRespHeader, 1000L);
        }
      }
      for (;;)
      {
        if ((!bool) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityNearPeopleFilterActivity$NearPeopleFilters == null)) {
          break label840;
        }
        ThreadManager.a(new sob(this, paramBoolean), 2, null, true);
        return;
        this.a.h = false;
        break;
        if ((paramRespHeader == null) || (paramRespHeader.eReplyCode != 7)) {
          break label628;
        }
        this.a.a(true);
        return;
        this.a.b(paramBoolean, bool);
      }
    }
  }
  
  protected void a(boolean paramBoolean, NearbyMyTabCard paramNearbyMyTabCard)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyFragment", 2, "onGetNearbyMyTabCard isSuccess=" + paramBoolean);
    }
    if ((paramBoolean) && (paramNearbyMyTabCard != null) && (NearbyCmdHelper.a(this.a.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter, this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, paramNearbyMyTabCard.likeTotalNum, paramNearbyMyTabCard.newLikeNum))) {
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, List paramList, String paramString2, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyFragment", 2, "onSetPersonalInterestTags");
    }
    if (paramBoolean)
    {
      this.a.l = true;
      this.a.a(1, "添加成功", 300);
      this.a.c(true, false);
      return;
    }
    this.a.a(2, "添加失败 " + paramString2, 300);
  }
  
  public void b(boolean paramBoolean, NearbyMyTabCard paramNearbyMyTabCard)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyFragment", 2, "onNearbyMyTabDataChanged isSuccess=" + paramBoolean);
    }
    if ((paramBoolean) && (paramNearbyMyTabCard != null) && (NearbyCmdHelper.a(this.a.jdField_a_of_type_ComTencentMobileqqAdapterPeopleAroundAdapter, this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, paramNearbyMyTabCard.likeTotalNum, paramNearbyMyTabCard.newLikeNum))) {
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\snz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */