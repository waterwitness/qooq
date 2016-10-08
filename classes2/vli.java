import NearbyGroup.GroupInfo;
import android.text.TextUtils.EllipsizeCallback;
import android.widget.TextView;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.data.NearbyTroops.CustomViewHolder;

public final class vli
  implements TextUtils.EllipsizeCallback
{
  public vli(NearbyTroops.CustomViewHolder paramCustomViewHolder, GroupInfo paramGroupInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void ellipsized(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroops$CustomViewHolder.h.setText(HttpUtil.b(HttpUtil.c(this.jdField_a_of_type_NearbyGroupGroupInfo.strIntro)));
      return;
    }
    String str = this.jdField_a_of_type_NearbyGroupGroupInfo.strIntro.substring(0, paramInt1);
    this.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroops$CustomViewHolder.h.setText(new QQText(HttpUtil.b(HttpUtil.c(str + "...")), 3, 14));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vli.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */