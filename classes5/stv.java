import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter.FaceInfo;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotchat.HotChatMemberListActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.FaceDecoder;
import java.util.List;

public class stv
  extends FacePreloadBaseAdapter
{
  private List jdField_a_of_type_JavaUtilList;
  
  public stv(HotChatMemberListActivity paramHotChatMemberListActivity, List paramList)
  {
    super(paramHotChatMemberListActivity, paramHotChatMemberListActivity.app, paramHotChatMemberListActivity.a, 1, true);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  protected Bitmap a(int paramInt, String paramString)
  {
    Object localObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatMemberListActivity.app.getManager(50);
    if ((localObject != null) && (((FriendsManager)localObject).b(paramString)) && (!this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatMemberListActivity.app.a().equals(paramString))) {
      localObject = super.a(paramInt, paramString);
    }
    Bitmap localBitmap;
    do
    {
      return (Bitmap)localObject;
      localBitmap = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(32, paramString, 200);
      localObject = localBitmap;
    } while (localBitmap != null);
    if (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b()) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramString, 200, true, false);
    }
    return a();
  }
  
  protected Object a(int paramInt)
  {
    sts localsts = (sts)getItem(paramInt);
    FacePreloadBaseAdapter.FaceInfo localFaceInfo = new FacePreloadBaseAdapter.FaceInfo(this);
    if (localsts != null) {
      localFaceInfo.a = localsts.a;
    }
    return localFaceInfo;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    sts localsts;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatMemberListActivity.getLayoutInflater().inflate(2130904981, paramViewGroup, false);
      paramViewGroup = new stz(null);
      paramViewGroup.d = ((ImageView)paramView.findViewById(2131298136));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131297466));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297467));
      paramView.setTag(paramViewGroup);
      localsts = (sts)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if ((localsts.e == null) || (localsts.e.length() <= 0) || (localsts.e.equals(localsts.jdField_b_of_type_JavaLangString))) {
        break label204;
      }
      paramViewGroup.c.setText(localsts.jdField_b_of_type_JavaLangString + "(" + localsts.e + ")");
    }
    for (;;)
    {
      paramViewGroup.jdField_b_of_type_JavaLangString = localsts.a;
      paramViewGroup.d.setImageBitmap(a(1, localsts.a));
      return paramView;
      paramViewGroup = (stz)paramView.getTag();
      break;
      label204:
      paramViewGroup.c.setText(localsts.jdField_b_of_type_JavaLangString);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\stv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */