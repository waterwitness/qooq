import com.tencent.mobileqq.avatar.dynamicavatar.DynamicUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel;
import com.tencent.widget.CustomImgView;
import java.io.File;

class toc
  implements Runnable
{
  toc(tob paramtob)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = (PicInfo)this.a.a.jdField_a_of_type_ComTencentWidgetCustomImgView.getTag();
    String str = DynamicUtils.a(((PicInfo)localObject).e, 200);
    DynamicUtils.a(((PicInfo)localObject).e, str, 200, this.a.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
    localObject = new File(str);
    if ((localObject != null) && (((File)localObject).exists())) {
      DynamicUtils.a(this.a.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, str, 40, this.a.a.m, 200);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\toc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */