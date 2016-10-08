import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.EmosmActivity;
import com.tencent.mobileqq.app.EmoticonHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.view.DragSortListView.RemoveListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

public class lib
  implements DragSortListView.RemoveListener
{
  public lib(EmosmActivity paramEmosmActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt)
  {
    Object localObject = (EmoticonPackage)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if (!NetworkUtil.e(this.a))
    {
      localObject = new QQToast(this.a);
      ((QQToast)localObject).a(2130838420);
      ((QQToast)localObject).c(1500);
      ((QQToast)localObject).a("无网络连接，删除失败");
      ((QQToast)localObject).b(0);
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(this.a.getString(2131370293));
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    ((EmoticonHandler)this.a.app.a(12)).a(Integer.parseInt(((EmoticonPackage)localObject).epId));
    URLDrawable.clearMemoryCache();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lib.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */