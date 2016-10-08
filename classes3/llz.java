import NS_MOBILE_MAIN_PAGE.mobile_sub_get_cover_rsp;
import NS_MOBILE_MAIN_PAGE.mobile_sub_get_photo_wall_rsp;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.AccountDetail.activity.EqqAccountDetailActivity;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.enterpriseqq.EnterpriseQQManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.musicpendant.MusicPendantManager;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.profile.ProfileShoppingPhotoInfo;
import com.tencent.mobileqq.profile.view.ProfileBaseView;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.TimeTraceUtil;
import com.tencent.mobileqq.utils.UIThreadPool;
import com.tencent.mobileqq.widget.OnGetPhotoWallListener;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ProfilePerformanceReport;
import com.tencent.util.WeakReferenceHandler;
import java.util.List;

public class llz
  extends CardObserver
{
  public llz(FriendProfileCardActivity paramFriendProfileCardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo == null) {}
    do
    {
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("FriendProfileCardActivity", 2, "shoppingNo=" + paramString1 + "seq=" + paramInt);
          }
        } while ((!paramBoolean) || (!this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(paramString2)));
        if (!"0".equals(paramString1)) {
          break;
        }
        paramString1 = this.a.getSharedPreferences("is_binding_shop", 1).edit();
        paramString1.putBoolean(this.a.e, false);
        paramString1.commit();
      } while ((this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null) || (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId != ProfileCardTemplate.h));
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = null;
      this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = null;
      this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView = new ProfileBaseView(this.a, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo, this.a.jdField_a_of_type_ComTencentWidgetPullToZoomListView, this.a.jdField_a_of_type_AndroidWidgetTextView);
      FriendProfileCardActivity.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView, 0L, 0L);
    } while (this.a.isFinishing());
    FriendProfileCardActivity.b(this.a);
    FriendProfileCardActivity.c(this.a);
    return;
    paramString2 = ProfileShoppingPhotoInfo.getPhotoInfo(this.a.app, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    if (paramString2 != null)
    {
      this.a.j = paramString2.followType;
      this.a.c = paramString2.bindShoppingNo;
    }
    paramString2 = (CardHandler)this.a.app.a(2);
    if (paramString2 != null)
    {
      this.a.c = paramString1;
      paramString2.a(paramInt, paramString1, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    }
    paramString1 = this.a.getSharedPreferences("is_binding_shop", 1).edit();
    paramString1.putBoolean(this.a.e, true);
    paramString1.commit();
  }
  
  protected void a(boolean paramBoolean, Card paramCard, long paramLong)
  {
    super.a(paramBoolean, paramCard, paramLong);
    if (QLog.isColorLevel()) {
      QLog.d("zivzhou", 2, "set the status of label = " + paramBoolean);
    }
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "onCardDownload() isSuccess = " + paramBoolean);
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
      return;
    }
    Object localObject = ProfilePerformanceReport.a;
    if ((localObject != null) && (((ProfilePerformanceReport)localObject).b())) {
      ((ProfilePerformanceReport)localObject).b(6);
    }
    if (CrmUtils.c(this.a.app, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
    {
      localObject = new Intent(this.a, EqqAccountDetailActivity.class);
      ((Intent)localObject).putExtra("uin", this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      ((Intent)localObject).putExtra("need_finish", false);
      ((Intent)localObject).putExtra("uintype", 1024);
      ((Intent)localObject).addFlags(536870912);
      this.a.startActivity((Intent)localObject);
      this.a.finish();
    }
    boolean bool2 = ProfileActivity.AllInOne.f(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    boolean bool1 = bool2;
    if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 41) {
      if (!TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
      {
        bool1 = bool2;
        if (!this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals("0")) {}
      }
      else
      {
        bool1 = false;
      }
    }
    if (((paramObject instanceof Card)) && (bool1))
    {
      localObject = (Card)paramObject;
      bool2 = Utils.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, ((Card)localObject).uin);
      bool1 = bool2;
      paramObject = localObject;
      if ((((Card)localObject).lUserFlag & 1L) == 0L) {
        break label708;
      }
      EnterpriseQQManager.a(this.a.app).a(this.a.app, ((Card)localObject).uin, false);
      paramObject = localObject;
      localObject = null;
      bool1 = bool2;
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a("initCardBySSOEnd", "initCardBySSOStart", false);
      if ((bool1) && (paramObject != null) && (paramBoolean))
      {
        localObject = (FriendListHandler)this.a.app.a(1);
        if ((this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.e == null) && (localObject != null))
        {
          if (ProfileActivity.AllInOne.f(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
            ((FriendListHandler)localObject).c(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
          }
          label456:
          this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard = ((Card)paramObject);
          if (this.a.jdField_a_of_type_ComTencentUtilWeakReferenceHandler != null)
          {
            paramObject = this.a.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage();
            ((Message)paramObject).what = 8;
            this.a.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage((Message)paramObject);
          }
        }
      }
      for (;;)
      {
        this.a.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(100);
        this.a.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(100, 100L);
        return;
        if (((paramObject instanceof ContactCard)) && (!bool1))
        {
          localObject = (ContactCard)paramObject;
          bool1 = Utils.a(((ContactCard)localObject).mobileNo, FriendProfileCardActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne));
          paramObject = null;
          break;
        }
        if ((paramObject instanceof String))
        {
          paramObject = (String)paramObject;
          if (bool1) {}
          for (bool1 = Utils.a(paramObject, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);; bool1 = Utils.a(paramObject, FriendProfileCardActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)))
          {
            localObject = null;
            paramObject = null;
            break;
          }
        }
        if ((!(paramObject instanceof Card)) || (bool1)) {
          break label979;
        }
        paramObject = (Card)paramObject;
        bool1 = Utils.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.o, ((Card)paramObject).encId);
        this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString = ((Card)paramObject).uin;
        this.a.jdField_b_of_type_Boolean = true;
        label708:
        localObject = null;
        break;
        if (localObject == null) {
          break label456;
        }
        ((FriendListHandler)localObject).c(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        break label456;
        if ((bool1) && (localObject != null) && (paramBoolean))
        {
          paramObject = (FriendListHandler)this.a.app.a(1);
          String str = FriendProfileCardActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
          if ((paramObject != null) && (!TextUtils.isEmpty(str))) {
            ((FriendListHandler)paramObject).e(str);
          }
          paramObject = Message.obtain();
          ((Message)paramObject).what = 4;
          ((Message)paramObject).obj = localObject;
          ((Message)paramObject).arg1 = 1;
          this.a.jdField_b_of_type_ComTencentUtilWeakReferenceHandler.sendMessage((Message)paramObject);
        }
        else if ((!paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId == -1L))
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.profilecard.FrdProfileCard", 2, "onCardDownload isSuccess = " + paramBoolean + ",lCurrentStyleId=-1");
          }
          this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId = ProfileCardTemplate.a;
          this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.templateRet = 0;
          if (this.a.jdField_a_of_type_ComTencentUtilWeakReferenceHandler != null)
          {
            paramObject = this.a.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage();
            ((Message)paramObject).what = 8;
            this.a.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage((Message)paramObject);
          }
        }
      }
      label979:
      bool1 = false;
      localObject = null;
      paramObject = null;
    }
  }
  
  protected void a(boolean paramBoolean, String paramString, mobile_sub_get_cover_rsp parammobile_sub_get_cover_rsp)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (!Utils.a(paramString, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {}
    while (this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(paramBoolean, paramString, parammobile_sub_get_cover_rsp);
  }
  
  protected void a(boolean paramBoolean, String paramString1, mobile_sub_get_photo_wall_rsp parammobile_sub_get_photo_wall_rsp, String paramString2)
  {
    this.a.a(false);
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, "onGetQZonePhotoWall isSuc:" + paramBoolean + " uin:" + paramString2);
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(paramString2)) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetOnGetPhotoWallListener != null)) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetOnGetPhotoWallListener.a(paramBoolean, paramString1, parammobile_sub_get_photo_wall_rsp);
    }
  }
  
  protected void a(boolean paramBoolean, String paramString, Card paramCard)
  {
    d(paramBoolean, paramString, paramCard);
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1)) || (Utils.a(paramString2, paramString1))) {}
    do
    {
      do
      {
        return;
      } while ((!Utils.a(paramString2, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) || (!Utils.a(paramString1, this.a.app.a())));
      if (!paramBoolean) {
        break;
      }
    } while (this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null);
    this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo, -1L, false);
    return;
    UIThreadPool.a(new lma(this));
  }
  
  protected void a(boolean paramBoolean, String paramString, List paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, "shopName=" + paramString + ",accountFlag=" + paramInt1 + "follow_type=" + paramInt2 + ",certifiedGrade:" + paramInt3);
    }
    if (paramBoolean)
    {
      this.a.i = paramInt1;
      this.a.j = paramInt2;
      this.a.d = paramString;
      if (this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(paramString, paramInt3, paramList);
        if (paramList.size() != 0) {
          this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.setShoppingBgBlur(true);
        }
      }
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard, true);
    }
  }
  
  protected void b(boolean paramBoolean, Card paramCard)
  {
    super.b(paramBoolean, paramCard);
    if ((paramBoolean) && (MusicPendantManager.a() != null)) {
      MusicPendantManager.a().a(paramCard);
    }
  }
  
  protected void b(boolean paramBoolean, Object paramObject)
  {
    this.a.x();
    FriendProfileCardActivity localFriendProfileCardActivity = this.a;
    if (paramBoolean) {}
    for (Object localObject = "上传成功";; localObject = "上传失败")
    {
      localFriendProfileCardActivity.a((String)localObject, 0);
      localObject = (CardHandler)this.a.app.a(2);
      if (paramBoolean) {
        break;
      }
      paramObject = (String)((Object[])(Object[])paramObject)[0];
      this.a.runOnUiThread(new lmc(this, (CardHandler)localObject, (String)paramObject));
      return;
    }
    ((CardHandler)localObject).a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, "");
  }
  
  protected void b(boolean paramBoolean, String paramString)
  {
    if (!this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(paramString)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.FrdProfileCard", 2, "onUpdateAvatar " + paramBoolean);
      }
      if (!paramBoolean) {
        this.a.a(2131368750, 1);
      }
    } while (this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null);
    this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
  }
  
  protected void c(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (paramObject != null)) {}
    for (;;)
    {
      try
      {
        if (!(paramObject instanceof Bundle))
        {
          QLog.e("FriendProfileCardActivity", 1, "onUpdateMusicPendantSongs data is null or is not Bundle:" + paramBoolean);
          return;
        }
        paramObject = (Bundle)paramObject;
        if (((Bundle)paramObject).containsKey("songList"))
        {
          paramObject = (SongInfo[])((Bundle)paramObject).getSerializable("songList");
          if (MusicPendantManager.a() == null) {
            break;
          }
          MusicPendantManager.a().a((SongInfo[])paramObject);
          return;
        }
      }
      catch (Exception paramObject)
      {
        QLog.e("FriendProfileCardActivity", 1, "onUpdateMusicPendantSongs：" + paramBoolean);
        return;
      }
      paramObject = null;
    }
  }
  
  protected void c(boolean paramBoolean, String paramString, Card paramCard)
  {
    d(paramBoolean, paramString, paramCard);
  }
  
  protected void d(boolean paramBoolean, String paramString)
  {
    FriendProfileCardActivity localFriendProfileCardActivity = this.a;
    if (paramBoolean) {}
    for (paramString = "删除成功";; paramString = "删除失败")
    {
      localFriendProfileCardActivity.a(paramString, 0);
      ((CardHandler)this.a.app.a(2)).a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, "");
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\llz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */