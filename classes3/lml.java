import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.ApolloRenderInterfaceImpl;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.IRenderCallback;
import com.tencent.mobileqq.apollo.OnApolloViewListener;
import com.tencent.mobileqq.apollo.store.ApolloBoxEnterView;
import com.tencent.mobileqq.apollo.store.ApolloGuestsStateActivity;
import com.tencent.mobileqq.apollo.store.ApolloResDownloader;
import com.tencent.mobileqq.apollo.task.ApolloActionManager;
import com.tencent.mobileqq.apollo.task.ApolloActionTask;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.VipUtils;
import java.lang.ref.SoftReference;

public class lml
  implements View.OnClickListener, IRenderCallback, OnApolloViewListener, Runnable
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private SoftReference jdField_a_of_type_JavaLangRefSoftReference;
  private boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt;
  private boolean b;
  
  public lml(FriendProfileCardActivity paramFriendProfileCardActivity, int paramInt, int[] paramArrayOfInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangRefSoftReference = new SoftReference(paramFriendProfileCardActivity);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
  }
  
  public void a(int paramInt)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long < 1500L) {}
    FriendProfileCardActivity localFriendProfileCardActivity;
    do
    {
      return;
      this.jdField_a_of_type_Long = l;
      localFriendProfileCardActivity = (FriendProfileCardActivity)this.jdField_a_of_type_JavaLangRefSoftReference.get();
    } while ((localFriendProfileCardActivity == null) || (localFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo == null) || (localFriendProfileCardActivity.app == null));
    if (!this.b)
    {
      float f = (float)Math.max(DeviceInfoUtil.g(), DeviceInfoUtil.f()) * 0.2F / 368.0F;
      localObject1 = localFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.a();
      if (localObject1 != null)
      {
        ((ApolloRenderInterfaceImpl)localObject1).g();
        ((ApolloRenderInterfaceImpl)localObject1).a(1, this.jdField_a_of_type_Int, f, localFriendProfileCardActivity.c, 0.0F);
        ((ApolloRenderInterfaceImpl)localObject1).a(1, localFriendProfileCardActivity.b, null);
        ((ApolloRenderInterfaceImpl)localObject1).a(1000L);
      }
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null)
    {
      localObject1 = localObject2;
      if (localFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) {
        localObject1 = localFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      }
    }
    if ((TextUtils.isEmpty((CharSequence)localObject1)) && (localFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null) && (localFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null)) {}
    for (localObject2 = localFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.uin;; localObject2 = localObject1)
    {
      if ((FriendProfileCardActivity.a(localFriendProfileCardActivity)) || ((localFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) && (localFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)) || ((localFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (localFriendProfileCardActivity.app.f().equals(localFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.uin))))
      {
        localFriendProfileCardActivity.f = true;
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("extra_key_box_uin", (String)localObject2);
        boolean bool;
        if (localFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView != null)
        {
          if (localFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.getVisibility() == 0)
          {
            bool = true;
            ((Intent)localObject1).putExtra("extra_key_open_box", bool);
          }
        }
        else
        {
          ((Intent)localObject1).putExtra("extra_key_url_append", "&tab=interactive&suin=" + (String)localObject2);
          ((Intent)localObject1).putExtra("extra_key_box_from", "friendcard");
          if ((TextUtils.isEmpty((CharSequence)localObject2)) || (!((String)localObject2).equals(localFriendProfileCardActivity.app.f()))) {
            break label501;
          }
          ApolloUtil.a(localFriendProfileCardActivity, (Intent)localObject1, "mineprofile");
          VipUtils.a(localFriendProfileCardActivity.app, "cmshow", "Apollo", "file_clk", 0, 0, new String[0]);
          label426:
          localObject2 = localFriendProfileCardActivity.app;
          if (!FriendProfileCardActivity.b(localFriendProfileCardActivity)) {
            break label580;
          }
        }
        label465:
        label501:
        label580:
        for (localObject1 = "1";; localObject1 = "0")
        {
          VipUtils.a((AppInterface)localObject2, "cmshow", "Apollo", "0X80065C0", 1, 0, new String[] { localObject1 });
          if ((localFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView == null) || (localFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.getVisibility() != 0)) {
            break label797;
          }
          localFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setVisibility(8);
          return;
          bool = false;
          break;
          ApolloUtil.a(localFriendProfileCardActivity, (Intent)localObject1, "guestprofile");
          VipUtils.a(localFriendProfileCardActivity.app, "cmshow", "Apollo", "guest_file_clk", localFriendProfileCardActivity.n, 0, new String[] { "" + ApolloManager.a(localFriendProfileCardActivity.app), "0", "0", localObject2 });
          break label426;
        }
      }
      Intent localIntent = new Intent(localFriendProfileCardActivity, ApolloGuestsStateActivity.class);
      Object localObject3 = null;
      localObject1 = localObject3;
      if (localFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null)
      {
        localObject1 = localObject3;
        if (localFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) {
          localObject1 = localFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h;
        }
      }
      if ((TextUtils.isEmpty((CharSequence)localObject1)) && (localFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null) && (localFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null)) {
        localObject1 = localFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.strNick;
      }
      for (;;)
      {
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localIntent.putExtra("extra_guest_uin", (String)localObject2);
          VipUtils.a(localFriendProfileCardActivity.app, "cmshow", "Apollo", "guest_file_clk", localFriendProfileCardActivity.n, 0, new String[] { "" + ApolloManager.a(localFriendProfileCardActivity.app), "0", "0", localObject2 });
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localIntent.putExtra("extra_guest_nick", (String)localObject1);
        }
        localFriendProfileCardActivity.startActivity(localIntent);
        localFriendProfileCardActivity.overridePendingTransition(2130968620, 0);
        break label465;
        label797:
        break;
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    FriendProfileCardActivity localFriendProfileCardActivity = (FriendProfileCardActivity)this.jdField_a_of_type_JavaLangRefSoftReference.get();
    if (localFriendProfileCardActivity == null) {}
    QQAppInterface localQQAppInterface;
    ApolloSurfaceView localApolloSurfaceView;
    do
    {
      return;
      localQQAppInterface = localFriendProfileCardActivity.app;
      localApolloSurfaceView = localFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView;
    } while ((localQQAppInterface == null) || (localApolloSurfaceView == null));
    localFriendProfileCardActivity.c = ((float)DeviceInfoUtil.f() / DeviceInfoUtil.a() / 2.0F - 74.0F);
    float f = (float)Math.max(DeviceInfoUtil.g(), DeviceInfoUtil.f()) * 0.2F / 368.0F;
    localApolloSurfaceView.a().a(1, this.jdField_a_of_type_Int, f, localFriendProfileCardActivity.c, 0.0F);
    if (this.jdField_a_of_type_Int == 0) {
      localApolloSurfaceView.a().a(1, ApolloResDownloader.a(this.jdField_a_of_type_Int), null);
    }
    for (;;)
    {
      localApolloSurfaceView.a().a(1000L);
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
      localApolloSurfaceView.postDelayed(this, 250L);
      this.jdField_a_of_type_Boolean = false;
      return;
      if ((this.jdField_a_of_type_Int > 0) && (this.jdField_a_of_type_ArrayOfInt != null)) {
        localApolloSurfaceView.a().a(1, this.jdField_a_of_type_ArrayOfInt, null);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    paramString = (FriendProfileCardActivity)this.jdField_a_of_type_JavaLangRefSoftReference.get();
    if ((paramString == null) || (paramString.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView == null)) {
      return;
    }
    this.b = true;
    paramString.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.a().a(0L);
  }
  
  public void a(int paramInt, String paramString) {}
  
  public void onClick(View paramView)
  {
    a(0);
  }
  
  public void run()
  {
    Object localObject = (FriendProfileCardActivity)this.jdField_a_of_type_JavaLangRefSoftReference.get();
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((FriendProfileCardActivity)localObject).jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView;
    } while (localObject == null);
    ((ApolloSurfaceView)localObject).a().b();
    String[] arrayOfString = ApolloActionTask.a(5, this.jdField_a_of_type_Int, true);
    ((ApolloSurfaceView)localObject).a().a(1, 5, ApolloActionManager.a().b(), arrayOfString[0], arrayOfString[1]);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lml.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */