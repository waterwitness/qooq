import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.data.QZoneCover;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.qcall.QCallCardManager;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.TimeTraceUtil;
import com.tencent.util.ProfilePerformanceReport;
import com.tencent.util.WeakReferenceHandler;
import cooperation.qzone.model.CoverCacheData;

public class llb
  implements Handler.Callback
{
  public llb(FriendProfileCardActivity paramFriendProfileCardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject1 = null;
    Object localObject2 = (FriendsManager)this.a.app.getManager(50);
    Object localObject3;
    switch (paramMessage.what)
    {
    default: 
    case 1: 
      do
      {
        return true;
        localObject3 = ProfilePerformanceReport.a;
        if ((localObject3 != null) && (((ProfilePerformanceReport)localObject3).b()))
        {
          ((ProfilePerformanceReport)localObject3).b(4);
          ((ProfilePerformanceReport)localObject3).a(5);
          ((ProfilePerformanceReport)localObject3).a(8);
        }
        paramMessage = (String)paramMessage.obj;
        this.a.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a("initCardByDbStart", true);
        localObject1 = ProfileCardUtil.a(this.a.app, paramMessage);
        this.a.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a("initCardByDbEnd", "initCardByDbStart", false);
      } while ((localObject1 == null) || (localObject2 == null));
      if ((((FriendsManager)localObject2).b(((Card)localObject1).uin)) && (!this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(this.a.app.a())) && (!ProfileActivity.AllInOne.b(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))) {
        this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int = 1;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard = ((Card)localObject1);
      if ((localObject3 != null) && (((ProfilePerformanceReport)localObject3).b()))
      {
        ((ProfilePerformanceReport)localObject3).b(5);
        ((ProfilePerformanceReport)localObject3).a(6);
        ((ProfilePerformanceReport)localObject3).a(9);
      }
      this.a.a((Card)localObject1, false, 1);
      this.a.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a("initCardBySSOStart", true);
      localObject2 = ((Card)localObject1).vSeed;
      if ((this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 56) || (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 57)) {
        paramMessage = this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b;
      }
      break;
    }
    for (;;)
    {
      FriendProfileCardActivity.a(this.a, ((Card)localObject1).feedPreviewTime, (byte[])localObject2, paramMessage, false);
      return true;
      if ((this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 35) || (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 37) || (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 36))
      {
        paramMessage = this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.b;
        continue;
        localObject1 = FriendProfileCardActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
        if ((localObject2 == null) || (localObject1 == null) || (((String)localObject1).length() <= 0)) {
          break;
        }
        paramMessage = ProfilePerformanceReport.a;
        if ((paramMessage != null) && (paramMessage.b()))
        {
          paramMessage.b(4);
          paramMessage.a(8);
          paramMessage.a(5);
        }
        localObject1 = ((FriendsManager)localObject2).b((String)localObject1);
        localObject3 = FriendProfileCardActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
        if (localObject3 != null)
        {
          ((ContactCard)localObject1).nationCode = ((ProfileActivity.CardContactInfo)localObject3).b;
          ((ContactCard)localObject1).mobileCode = ((ProfileActivity.CardContactInfo)localObject3).c;
          ((ContactCard)localObject1).strContactName = ((ProfileActivity.CardContactInfo)localObject3).jdField_a_of_type_JavaLangString;
        }
        if ((((ContactCard)localObject1).nickName == null) || (((ContactCard)localObject1).nickName.length() == 0)) {
          ((ContactCard)localObject1).nickName = this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h;
        }
        ((FriendsManager)localObject2).a((ContactCard)localObject1);
        FriendProfileCardActivity.a(this.a, (ContactCard)localObject1, false);
        FriendProfileCardActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
        localObject2 = Message.obtain();
        ((Message)localObject2).what = 4;
        ((Message)localObject2).obj = localObject1;
        ((Message)localObject2).arg1 = 0;
        this.a.b.sendMessage((Message)localObject2);
        if ((paramMessage != null) && (paramMessage.b()))
        {
          paramMessage.b(5);
          paramMessage.a(6);
          paramMessage.a(9);
          paramMessage.a(7);
          paramMessage.b(7);
        }
        FriendProfileCardActivity.a(this.a, 0L, null, null, false);
        return true;
        localObject2 = (QCallCardManager)this.a.app.getManager(139);
        paramMessage = (Message)localObject1;
        if (localObject2 != null)
        {
          paramMessage = ((QCallCardManager)localObject2).a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
          if (paramMessage != null) {
            this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqQcallQCallCardInfo = paramMessage;
          }
          ((QCallCardManager)localObject2).a(paramMessage);
        }
        localObject1 = Message.obtain();
        ((Message)localObject1).what = 6;
        ((Message)localObject1).obj = paramMessage;
        ((Message)localObject1).arg1 = 0;
        this.a.b.sendMessage((Message)localObject1);
        return true;
        if (paramMessage.arg1 == 0) {
          this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId = ProfileCardTemplate.a;
        }
        this.a.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard, false, 7);
        return true;
        this.a.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard, true, 8);
        return true;
        localObject2 = (CoverCacheData)paramMessage.obj;
        localObject3 = this.a.app.a().createEntityManager();
        if (localObject3 == null)
        {
          paramMessage = null;
          localObject1 = paramMessage;
          if (paramMessage == null)
          {
            localObject1 = new QZoneCover();
            ((QZoneCover)localObject1).uin = Long.toString(((CoverCacheData)localObject2).a);
          }
          ((QZoneCover)localObject1).updateQzoneCover((CoverCacheData)localObject2);
          if (((QZoneCover)localObject1).getStatus() != 1000) {
            break label973;
          }
          ((EntityManager)localObject3).a((Entity)localObject1);
        }
        for (;;)
        {
          ((EntityManager)localObject3).a();
          return true;
          paramMessage = (QZoneCover)((EntityManager)localObject3).a(QZoneCover.class, Long.toString(((CoverCacheData)localObject2).a));
          break;
          label973:
          ((EntityManager)localObject3).a((Entity)localObject1);
        }
        if ((this.a.app == null) || (localObject2 == null)) {
          break;
        }
        paramMessage = ((FriendsManager)localObject2).a(this.a.app.a());
        if (paramMessage == null) {
          break;
        }
        FriendProfileCardActivity.a(this.a, paramMessage.feedPreviewTime, paramMessage.vSeed, null, false);
        return true;
        localObject1 = this.a.app.a().createEntityManager();
        ((EntityManager)localObject1).a((Card)paramMessage.obj);
        ((EntityManager)localObject1).a();
        return true;
        localObject1 = this.a.app.a().createEntityManager();
        ((EntityManager)localObject1).a((Card)paramMessage.obj);
        ((EntityManager)localObject1).a();
        return true;
        FriendProfileCardActivity.h(this.a);
        return true;
      }
      paramMessage = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\llb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */