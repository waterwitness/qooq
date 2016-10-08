import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.FontSettingActivity;
import com.tencent.mobileqq.activity.recent.RecentFaceDecoder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.widget.ListView;
import java.util.ArrayList;

public class ljd
  extends BaseAdapter
  implements FaceDecoder.DecodeTaskCompletionListener
{
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private RecentFaceDecoder jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder;
  
  public ljd(FontSettingActivity paramFontSettingActivity, Context paramContext, QQAppInterface paramQQAppInterface, ListView paramListView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramFontSettingActivity.getLayoutInflater();
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder = new RecentFaceDecoder(paramQQAppInterface, this);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a();
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    Object localObject1 = null;
    paramInt2 = FontSettingActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityFontSettingActivity).getChildCount();
    Object localObject2;
    if (paramBitmap != null)
    {
      paramInt1 = 0;
      if (paramInt1 >= paramInt2) {
        break label105;
      }
      localObject2 = FontSettingActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityFontSettingActivity).getChildAt(paramInt1).getTag();
      if ((localObject2 == null) || (!(localObject2 instanceof lje))) {
        break label98;
      }
      localObject2 = (lje)localObject2;
      localObject1 = localObject2;
      if (!((lje)localObject2).jdField_a_of_type_JavaLangString.equals(paramString)) {
        break label98;
      }
    }
    for (;;)
    {
      if (localObject2 != null)
      {
        ((lje)localObject2).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
        notifyDataSetChanged();
      }
      return;
      label98:
      paramInt1 += 1;
      break;
      label105:
      localObject2 = localObject1;
    }
  }
  
  public int getCount()
  {
    return FontSettingActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityFontSettingActivity).size();
  }
  
  public Object getItem(int paramInt)
  {
    return FontSettingActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityFontSettingActivity).get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130904905, paramViewGroup, false);
    paramViewGroup = (ljc)FontSettingActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityFontSettingActivity).get(paramInt);
    ImageView localImageView = (ImageView)paramView.findViewById(2131296790);
    localImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a(paramViewGroup.jdField_b_of_type_Int, paramViewGroup.d));
    ((TextView)paramView.findViewById(16908308)).setText(paramViewGroup.jdField_a_of_type_JavaLangString);
    ((TextView)paramView.findViewById(16908309)).setText(paramViewGroup.jdField_b_of_type_JavaLangString);
    ((TextView)paramView.findViewById(2131298399)).setText(paramViewGroup.c);
    lje locallje = new lje(this);
    locallje.jdField_a_of_type_JavaLangString = paramViewGroup.d;
    locallje.jdField_a_of_type_AndroidWidgetImageView = localImageView;
    locallje.jdField_a_of_type_Ljc = paramViewGroup;
    paramView.setTag(locallje);
    if ((FontSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFontSettingActivity)) && (paramInt == FontSettingActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityFontSettingActivity).size() - 1))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityFontSettingActivity.b = true;
      this.jdField_a_of_type_ComTencentMobileqqActivityFontSettingActivity.a();
    }
    return paramView;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ljd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */