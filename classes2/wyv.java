import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qidian.QidianProfileCardActivity.PaGroupStruct;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

public class wyv
  extends FriendListObserver
{
  public wyv(QidianProfileCardActivity paramQidianProfileCardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.jdField_a_of_type_JavaLangString.equals(String.valueOf(paramObject)))) {
      this.a.b();
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    super.a(paramBoolean, paramString);
    if (paramBoolean)
    {
      if (!paramString.equals(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.jdField_a_of_type_JavaLangString)) {
        break label57;
      }
      this.a.jdField_a_of_type_AndroidGraphicsBitmap = this.a.app.a(paramString, false);
      this.a.c();
    }
    label57:
    do
    {
      return;
      paramString = (QidianProfileCardActivity.PaGroupStruct)this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    } while (paramString == null);
    this.a.a(paramString.jdField_a_of_type_Int, (URLImageView)paramString.jdField_a_of_type_JavaLangRefWeakReference.get(), paramString.jdField_a_of_type_JavaLangString, true);
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2) && (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.jdField_a_of_type_JavaLangString != null) && (!ProfileActivity.AllInOne.b(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a)) && (this.a.jdField_a_of_type_ComTencentMobileqqAppFriendsManager != null) && (this.a.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.jdField_a_of_type_JavaLangString)) && (!this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.jdField_a_of_type_JavaLangString.equals(this.a.app.a())))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.jdField_a_of_type_Int = 1;
      this.a.b();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wyv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */