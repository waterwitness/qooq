import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.profile.ProfileShoppingPhotoInfo;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import com.tencent.mobileqq.qcall.QCallCardInfo;
import com.tencent.mobileqq.utils.TimeTraceUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class lky
  implements Handler.Callback
{
  public lky(FriendProfileCardActivity paramFriendProfileCardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject2 = null;
    boolean bool2 = false;
    boolean bool1 = false;
    Object localObject1;
    if (paramMessage.what == 3) {
      if ((paramMessage.obj instanceof Card))
      {
        localObject1 = (Card)paramMessage.obj;
        String str = ((Card)localObject1).uin;
        localObject2 = localObject1;
        localObject1 = str;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.FrdProfileCard", 2, "MSG_SWITCH_TO_FRIEND, uin = " + (String)localObject1 + ", obj: " + paramMessage.obj + "");
      }
      if ((localObject1 != null) && (((String)localObject1).length() > 0)) {
        this.a.a((Card)localObject2, (String)localObject1);
      }
      label228:
      label257:
      label317:
      label382:
      label559:
      label673:
      label691:
      label914:
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            int i;
                            do
                            {
                              return true;
                              if (!(paramMessage.obj instanceof String)) {
                                break label932;
                              }
                              localObject1 = (String)paramMessage.obj;
                              break;
                              if (paramMessage.what != 5) {
                                break label257;
                              }
                              if (paramMessage.arg1 == 1) {}
                              for (bool1 = true;; bool1 = false)
                              {
                                i = paramMessage.arg2;
                                if (!(paramMessage.obj instanceof Card)) {
                                  break;
                                }
                                paramMessage = (Card)paramMessage.obj;
                                this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard = paramMessage;
                                this.a.a(paramMessage, bool1);
                                if (i != 1) {
                                  break label228;
                                }
                                this.a.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a("updateCardByDbEnd", false);
                                return true;
                              }
                            } while ((i != 7) && (i != 8));
                            this.a.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a("updateCardBySSOEnd", false);
                            return true;
                            if (paramMessage.what != 4) {
                              break label317;
                            }
                            if (paramMessage.arg1 == 1) {
                              bool1 = true;
                            }
                          } while (!(paramMessage.obj instanceof ContactCard));
                          paramMessage = (ContactCard)paramMessage.obj;
                          this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataContactCard = paramMessage;
                          this.a.a(paramMessage, bool1);
                          return true;
                          if (paramMessage.what != 6) {
                            break label382;
                          }
                          bool1 = bool2;
                          if (paramMessage.arg1 == 1) {
                            bool1 = true;
                          }
                        } while (!(paramMessage.obj instanceof QCallCardInfo));
                        paramMessage = (QCallCardInfo)paramMessage.obj;
                        this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqQcallQCallCardInfo = paramMessage;
                        this.a.a(paramMessage, bool1);
                        return true;
                        if (paramMessage.what != 10) {
                          break label559;
                        }
                        if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null)
                        {
                          if (QLog.isColorLevel()) {
                            QLog.i("Q.profilecard.FrdProfileCard", 2, "initHeaderView timeout");
                          }
                          this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_Boolean = true;
                          this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId = ProfileCardTemplate.a;
                          this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.templateRet = 0;
                          this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = null;
                          this.a.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard, false);
                          return true;
                        }
                      } while (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqQcallQCallCardInfo == null);
                      if (QLog.isColorLevel()) {
                        QLog.i("Q.profilecard.FrdProfileCard", 2, "initHeaderView timeout");
                      }
                      this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_Boolean = true;
                      this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = null;
                      this.a.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqQcallQCallCardInfo, false);
                      return true;
                      if (paramMessage.what != 13) {
                        break label691;
                      }
                      if (!((Boolean)paramMessage.obj).booleanValue()) {
                        break label673;
                      }
                      paramMessage = new ProfileActivity.AllInOne(this.a.app.a(), 0);
                      paramMessage.h = this.a.app.b();
                      paramMessage.f = 1;
                      paramMessage.g = 5;
                    } while ((this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo == null) || (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a.equals(this.a.app.a())));
                    ProfileActivity.a(this.a, paramMessage);
                    return true;
                    Toast.makeText(this.a.getApplicationContext(), 2131370897, 0).show();
                    return true;
                    if (paramMessage.what != 12) {
                      break label914;
                    }
                  } while ((this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null) || ((ProfileCardTemplate.f != this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId) && (ProfileCardTemplate.h != this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId)) || (!(paramMessage.obj instanceof Bitmap)));
                  paramMessage = (Bitmap)paramMessage.obj;
                  localObject1 = (FrameLayout)this.a.findViewById(16908290);
                } while ((localObject1 == null) || (((FrameLayout)localObject1).getChildCount() <= 0));
                localObject1 = ((FrameLayout)localObject1).getChildAt(0);
              } while (localObject1 == null);
              paramMessage = new BitmapDrawable(this.a.getResources(), paramMessage);
              paramMessage.setAlpha(0);
              ((View)localObject1).setBackgroundDrawable(paramMessage);
            } while (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId != ProfileCardTemplate.h);
            if (QLog.isColorLevel()) {
              QLog.i("setShoppingBgBlur", 2, "setShoppingBgBlur");
            }
          } while (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileShoppingPhotoInfo == null);
          new ArrayList();
        } while (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileShoppingPhotoInfo.getPhotoFromRawData().size() <= 0);
        this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.setShoppingBgBlur(true);
        return true;
      } while (paramMessage.what != 100);
      this.a.e();
      return true;
      label932:
      localObject1 = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lky.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */