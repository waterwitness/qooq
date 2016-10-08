import NS_MOBILE_MAIN_PAGE.mobile_sub_get_cover_rsp;
import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.business.NearbyCardObserver;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.profile.view.QzonePhotoView.PhotoInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ProfilePerformanceReport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import tencent.im.oidb.cmd0x5ea.UpdatePhotoList.HeadInfo;

public class tlm
  extends NearbyCardObserver
{
  public tlm(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, String paramString)
  {
    NearbyPeopleProfileActivity.a(this.a).charm = paramInt3;
    NearbyPeopleProfileActivity.a(this.a).charmLevel = paramInt4;
    NearbyPeopleProfileActivity.a(this.a).curThreshold = paramInt5;
    NearbyPeopleProfileActivity.a(this.a).nextThreshold = paramInt6;
    NearbyPeopleProfileActivity.a(this.a).b(NearbyPeopleProfileActivity.a(this.a));
    if (QLog.isColorLevel()) {
      QLog.d("Charm", 2, "onGetCharmNotify() uin=" + this.a.app.a());
    }
    String str = "   " + StringUtil.a(paramString, "<head>", "</head>") + "   ";
    paramString = StringUtil.a(paramString, "<body>", "</body>");
    tlo localtlo = new tlo(this, paramInt3, paramInt1);
    if (this.a.isResume()) {
      QQUtils.a(this.a, str, paramString, paramInt3 - paramInt1, localtlo, localtlo).show();
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt, List paramList1, List paramList2)
  {
    if (NearbyPeopleProfileActivity.a(this.a) != null) {
      NearbyPeopleProfileActivity.a(this.a).a(paramBoolean, paramInt, paramList1);
    }
  }
  
  public void a(boolean paramBoolean1, long paramLong, boolean paramBoolean2, boolean paramBoolean3, byte[] paramArrayOfByte, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ongetShowLove ").append("issuccess = ").append(paramBoolean1).append(" uin = ").append(paramLong).append(" canChat = ").append(paramBoolean2).append(" can ShowLove = ").append(paramBoolean3).append("sig:").append(paramArrayOfByte).append(paramString);
    DatingUtil.c("profileCard", new Object[] { ((StringBuilder)localObject).toString() });
    localObject = this.a;
    if (this.a.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(204);
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(205);
    }
    if (paramBoolean1) {
      if (paramBoolean2)
      {
        DatingUtil.c(NearbyPeopleProfileActivity.class.getSimpleName(), new Object[] { "onGetShowLoveLimit , can chat, someting is wrong" });
        NearbyPeopleProfileActivity.a(this.a).g();
      }
    }
    for (;;)
    {
      this.a.m = false;
      return;
      if (paramBoolean3)
      {
        if (NearbyPeopleProfileActivity.a(this.a) != null)
        {
          paramString = NearbyPeopleProfileActivity.a(this.a).uin;
          String str = NearbyPeopleProfileActivity.a(this.a).nickname;
          int i = NearbyPeopleProfileActivity.a(this.a).gender;
          int j = ProfileCardUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
          this.a.runOnUiThread(new tln(this, (Activity)localObject, paramString, str, i, paramArrayOfByte, j));
        }
      }
      else
      {
        DatingUtil.c(NearbyPeopleProfileActivity.class.getSimpleName(), new Object[] { "cant show love, wording is " + paramString });
        paramArrayOfByte = paramString;
        if (TextUtils.isEmpty(paramString)) {
          paramArrayOfByte = ((Activity)localObject).getResources().getString(2131372111);
        }
        DatingUtil.a(this.a, paramArrayOfByte);
        continue;
        DatingUtil.a((Activity)localObject, ((Activity)localObject).getString(2131372112));
      }
    }
  }
  
  protected void a(boolean paramBoolean1, NearbyPeopleCard paramNearbyPeopleCard, boolean paramBoolean2)
  {
    if ((paramNearbyPeopleCard != null) && (paramNearbyPeopleCard.tinyId != this.a.jdField_b_of_type_Long) && ((paramNearbyPeopleCard.uin == null) || (!paramNearbyPeopleCard.uin.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)))) {}
    label329:
    label807:
    label824:
    label837:
    label850:
    do
    {
      return;
      this.a.a();
      Object localObject = ProfilePerformanceReport.b;
      if ((localObject != null) && (((ProfilePerformanceReport)localObject).b())) {
        ((ProfilePerformanceReport)localObject).b(6);
      }
      StringBuilder localStringBuilder1;
      StringBuilder localStringBuilder2;
      if ((paramNearbyPeopleCard != null) && (QLog.isColorLevel()))
      {
        localStringBuilder1 = new StringBuilder();
        localStringBuilder2 = localStringBuilder1.append("tinyid=").append(paramNearbyPeopleCard.tinyId).append(", uin=").append(paramNearbyPeopleCard.uin).append(", nickname=").append(paramNearbyPeopleCard.nickname).append(", gender=").append(paramNearbyPeopleCard.gender).append(", age=").append(paramNearbyPeopleCard.age).append(", birthday=").append(paramNearbyPeopleCard.birthday).append(", constellation=").append(paramNearbyPeopleCard.constellation).append(", distance=").append(paramNearbyPeopleCard.distance).append(", timeDiff=").append(paramNearbyPeopleCard.timeDiff).append(", photoInfoes=").append(paramNearbyPeopleCard.picInfo).append(", photoInfo_length=");
        if (paramNearbyPeopleCard.picList != null) {
          break label807;
        }
        localObject = "null";
        localStringBuilder2 = localStringBuilder2.append(localObject).append(", likeCount=").append(paramNearbyPeopleCard.likeCount).append(",likeCountInc=").append(paramNearbyPeopleCard.likeCountInc).append(", oldPhotoCount=").append(paramNearbyPeopleCard.oldPhotoCount).append(", dateInfo=").append(paramNearbyPeopleCard.dateInfo).append(", dateInfo_length=");
        if (paramNearbyPeopleCard.dateInfo != null) {
          break label824;
        }
        localObject = "null";
        localStringBuilder2 = localStringBuilder2.append(localObject).append(", xuanYan=").append(paramNearbyPeopleCard.xuanYan).append(", xuanYan_length=");
        if (paramNearbyPeopleCard.xuanYan != null) {
          break label837;
        }
      }
      for (localObject = "null";; localObject = Integer.valueOf(paramNearbyPeopleCard.xuanYan.length))
      {
        localStringBuilder2.append(localObject).append(", maritalStatus=").append(paramNearbyPeopleCard.maritalStatus).append(", job=").append(paramNearbyPeopleCard.job).append(", charm=").append(paramNearbyPeopleCard.charm).append(",level=").append(paramNearbyPeopleCard.charmLevel).append(",next=").append(paramNearbyPeopleCard.nextThreshold).append(", company=").append(paramNearbyPeopleCard.company).append(", college=").append(paramNearbyPeopleCard.college).append(", hometownCountry=").append(paramNearbyPeopleCard.hometownCountry).append(", hometownProvice=").append(paramNearbyPeopleCard.hometownProvice).append(", hometownCity=").append(paramNearbyPeopleCard.hometownCity).append(", hometownDistrict=").append(paramNearbyPeopleCard.hometownDistrict).append(", bVoted=").append(paramNearbyPeopleCard.bVoted).append(", feedPreviewTime=").append(paramNearbyPeopleCard.feedPreviewTime).append(", qzoneFeed=").append(paramNearbyPeopleCard.qzoneFeed).append(", qzoneName=").append(paramNearbyPeopleCard.qzoneName).append(", qzonePicUrl_1=").append(paramNearbyPeopleCard.qzonePicUrl_1).append(", qzonePicUrl_2=").append(paramNearbyPeopleCard.qzonePicUrl_2).append(", qzonePicUrl_3=").append(paramNearbyPeopleCard.qzonePicUrl_3).append(", isPhotoUseCache=").append(paramNearbyPeopleCard.isPhotoUseCache).append(", switchQzone=").append(paramNearbyPeopleCard.switchQzone).append(", switchHobby=").append(paramNearbyPeopleCard.switchHobby).append(", uiShowControl=").append(paramNearbyPeopleCard.uiShowControl).append(", userFlag=").append(paramNearbyPeopleCard.userFlag).append(", strProfileUrl=").append(paramNearbyPeopleCard.strProfileUrl).append(", strVoteLimitedNotice=").append(paramNearbyPeopleCard.strVoteLimitedNotice).append(", bHaveVotedCnt=").append(paramNearbyPeopleCard.bHaveVotedCnt).append(", bAvailVoteCnt=").append(paramNearbyPeopleCard.bAvailVoteCnt);
        QLog.d("Q.nearby_people_card.", 2, "Q.nearby_people_card..onNearbyCardDownload(), isSuccess: " + paramBoolean1 + ", card = " + localStringBuilder1.toString());
        if ((!paramBoolean1) || (paramNearbyPeopleCard == null)) {
          break label850;
        }
        this.a.jdField_E_of_type_JavaLangString = paramNearbyPeopleCard.uin;
        this.a.jdField_a_of_type_Boolean = true;
        NearbyPeopleProfileActivity.a(this.a, paramNearbyPeopleCard, false, paramBoolean2);
        return;
        localObject = Integer.valueOf(paramNearbyPeopleCard.picList.size());
        break;
        localObject = Integer.valueOf(paramNearbyPeopleCard.dateInfo.length);
        break label329;
      }
    } while (paramBoolean2);
    this.a.b("加载失败");
  }
  
  public void a(boolean paramBoolean1, NearbyPeopleCard paramNearbyPeopleCard, boolean paramBoolean2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.update_profile", 2, "onEditNearbyProfileCard");
    }
    if (this.a.D != 1) {
      return;
    }
    if (paramBoolean1)
    {
      if (this.a.jdField_a_of_type_JavaUtilArrayList.size() > 1) {
        this.a.g = true;
      }
      NearbyPeopleProfileActivity.a(this.a);
    }
    this.a.a(paramBoolean1, paramNearbyPeopleCard, paramBoolean2, paramString);
  }
  
  protected void a(boolean paramBoolean, String paramString, mobile_sub_get_cover_rsp parammobile_sub_get_cover_rsp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.nearby_people_card.", 2, "onGetQZoneCover. isSuc : " + paramBoolean);
    }
    if ((paramBoolean) && (NearbyPeopleProfileActivity.a(this.a) != null) && (paramString.equals(NearbyPeopleProfileActivity.a(this.a).uin)) && (parammobile_sub_get_cover_rsp != null))
    {
      paramString = parammobile_sub_get_cover_rsp.vecUrls;
      if ((paramString != null) && (paramString.size() > 0) && (1 != this.a.D))
      {
        int i = 0;
        while ((i < paramString.size()) && (i < NearbyPeopleProfileActivity.r))
        {
          parammobile_sub_get_cover_rsp = new QzonePhotoView.PhotoInfo(i, 100, (Map)paramString.get(i));
          PicInfo localPicInfo = new PicInfo();
          localPicInfo.jdField_a_of_type_JavaLangString = parammobile_sub_get_cover_rsp.a();
          localPicInfo.b = parammobile_sub_get_cover_rsp.a(this.a.jdField_E_of_type_Int);
          this.a.jdField_a_of_type_JavaUtilArrayList.add(localPicInfo);
          if (QLog.isColorLevel()) {
            QLog.i("Q.nearby_people_card.", 2, "onGetQZoneCover. pic is: " + localPicInfo.jdField_a_of_type_JavaLangString);
          }
          i += 1;
        }
        if (NearbyPeopleProfileActivity.a(this.a) != null) {
          NearbyPeopleProfileActivity.a(this.a).a();
        }
      }
    }
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if ((NearbyPeopleProfileActivity.a(this.a) == null) || (TextUtils.isEmpty(NearbyPeopleProfileActivity.a(this.a).uin)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1)) || (Utils.a(paramString2, paramString1))) {}
    while ((!Utils.a(paramString2, NearbyPeopleProfileActivity.a(this.a).uin)) || (!Utils.a(paramString1, this.a.app.a())) || (paramBoolean)) {
      return;
    }
    this.a.b(this.a.getResources().getString(2131370016));
    paramString1 = NearbyPeopleProfileActivity.a(this.a);
    paramString1.likeCount -= 1;
    NearbyPeopleProfileActivity.a(this.a).bVoted = 0;
    paramString1 = NearbyPeopleProfileActivity.a(this.a);
    paramString1.bAvailVoteCnt = ((short)(paramString1.bAvailVoteCnt + paramInt1));
    NearbyPeopleProfileActivity.a(this.a).b(false);
  }
  
  public void a(boolean paramBoolean, String paramString1, List paramList, String paramString2, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.update_profile", 2, "onSetPersonalInterestTags");
    }
    if (paramBoolean)
    {
      this.a.a();
      this.a.a(2, "添加成功。");
      return;
    }
    this.a.a();
    this.a.a(1, "添加失败," + paramString2);
  }
  
  protected void a(boolean paramBoolean, ArrayList paramArrayList, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.a.D != 1) {}
    do
    {
      return;
      if ((!paramBoolean) || ((paramInt1 != 0) && (paramInt1 != 1))) {
        break;
      }
      if (paramInt1 == 0)
      {
        this.a.a();
        if ((paramArrayList != null) && (paramArrayList.size() > 0))
        {
          if (paramArrayList.size() > NearbyPeopleProfileActivity.r) {}
          ArrayList localArrayList;
          for (paramInt1 = NearbyPeopleProfileActivity.r;; paramInt1 = paramArrayList.size())
          {
            localArrayList = new ArrayList(paramInt1);
            paramInt2 = 0;
            while (paramInt2 < paramInt1)
            {
              UpdatePhotoList.HeadInfo localHeadInfo = (UpdatePhotoList.HeadInfo)paramArrayList.get(paramInt2);
              PicInfo localPicInfo = new PicInfo();
              localPicInfo.jdField_a_of_type_Int = localHeadInfo.uint32_headid.get();
              localPicInfo.jdField_a_of_type_JavaLangString = localHeadInfo.str_headurl.get();
              localPicInfo.b = (localPicInfo.jdField_a_of_type_JavaLangString + "250");
              localArrayList.add(localPicInfo);
              paramInt2 += 1;
            }
          }
          this.a.jdField_a_of_type_JavaUtilArrayList.addAll(0, localArrayList);
          if (this.a.jdField_a_of_type_JavaUtilArrayList.size() > 13)
          {
            paramInt1 = this.a.jdField_a_of_type_JavaUtilArrayList.size() - 1;
            while (paramInt1 >= NearbyPeopleProfileActivity.r)
            {
              this.a.jdField_a_of_type_JavaUtilArrayList.remove(paramInt1);
              paramInt1 -= 1;
            }
            this.a.jdField_a_of_type_JavaUtilArrayList.add(this.a.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo);
          }
          NearbyPeopleProfileActivity.a(this.a).c();
          NearbyPeopleProfileActivity.a(this.a).a(8);
          this.a.jdField_b_of_type_Boolean = true;
          if (paramInt4 > 0)
          {
            paramArrayList = DialogUtil.a(this.a, "最多可同步12张照片，精选照片，展示最好的自己吧。", 0, 0, null, null);
            paramArrayList.setPositiveButton(2131367263, new tlp(this, paramArrayList));
            paramArrayList.show();
          }
        }
        ReportController.b(this.a.app, "CliOper", "", "", "0X800481C", "0X800481C", 0, 0, "", "", "", "");
        return;
      }
    } while (paramInt1 != 1);
    this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(1001);
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1001, 2000L);
    return;
    this.a.a();
    this.a.b("导入失败");
  }
  
  protected void b(boolean paramBoolean, ArrayList paramArrayList, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.a.D != 1) {}
    do
    {
      return;
      if ((!paramBoolean) || ((paramInt1 != 0) && (paramInt1 != 1))) {
        break;
      }
      if (paramInt1 == 0)
      {
        this.a.a();
        if ((paramArrayList != null) && (paramArrayList.size() > 0))
        {
          if (paramArrayList.size() > NearbyPeopleProfileActivity.r) {}
          ArrayList localArrayList;
          for (paramInt1 = NearbyPeopleProfileActivity.r;; paramInt1 = paramArrayList.size())
          {
            localArrayList = new ArrayList(paramInt1);
            paramInt2 = 0;
            while (paramInt2 < paramInt1)
            {
              UpdatePhotoList.HeadInfo localHeadInfo = (UpdatePhotoList.HeadInfo)paramArrayList.get(paramInt2);
              PicInfo localPicInfo = new PicInfo();
              localPicInfo.jdField_a_of_type_Int = localHeadInfo.uint32_headid.get();
              localPicInfo.jdField_a_of_type_JavaLangString = localHeadInfo.str_headurl.get();
              localPicInfo.b = (localPicInfo.jdField_a_of_type_JavaLangString + "250");
              localArrayList.add(localPicInfo);
              paramInt2 += 1;
            }
          }
          this.a.jdField_a_of_type_JavaUtilArrayList.addAll(0, localArrayList);
          if (this.a.jdField_a_of_type_JavaUtilArrayList.size() > 13)
          {
            paramInt1 = this.a.jdField_a_of_type_JavaUtilArrayList.size() - 1;
            while (paramInt1 >= NearbyPeopleProfileActivity.r)
            {
              this.a.jdField_a_of_type_JavaUtilArrayList.remove(paramInt1);
              paramInt1 -= 1;
            }
            this.a.jdField_a_of_type_JavaUtilArrayList.add(this.a.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicInfo);
          }
          NearbyPeopleProfileActivity.a(this.a).c();
          NearbyPeopleProfileActivity.a(this.a).a(8);
          this.a.jdField_b_of_type_Boolean = true;
          if (paramInt4 > 0)
          {
            paramArrayList = DialogUtil.a(this.a, "最多可同步12张照片，精选照片，展示最好的自己吧。", 0, 0, null, null);
            paramArrayList.setPositiveButton(2131367263, new tlq(this, paramArrayList));
            paramArrayList.show();
          }
        }
        ReportController.b(this.a.app, "CliOper", "", "", "0X800481C", "0X800481C", 0, 0, "", "", "", "");
        return;
      }
    } while (paramInt1 != 1);
    this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(1001);
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1001, 2000L);
    return;
    this.a.a();
    this.a.b("导入失败");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tlm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */