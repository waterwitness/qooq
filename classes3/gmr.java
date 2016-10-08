import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.GAudioFriends;
import com.tencent.av.random.RandomController;
import com.tencent.av.random.ui.RandomMultiActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.Iterator;

public class gmr
  extends BaseAdapter
{
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  
  public gmr(RandomMultiActivity paramRandomMultiActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(8);
  }
  
  public void a(String paramString, ArrayList paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        VideoController.GAudioFriends localGAudioFriends = (VideoController.GAudioFriends)paramArrayList.next();
        if (!String.valueOf(localGAudioFriends.a).equals(paramString)) {
          this.jdField_a_of_type_JavaUtilArrayList.add(localGAudioFriends);
        }
      }
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      return this.jdField_a_of_type_JavaUtilArrayList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > paramInt)) {
      return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    String str = String.valueOf(((VideoController.GAudioFriends)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).a);
    if (paramView == null)
    {
      paramViewGroup = new gms(this);
      paramView = this.jdField_a_of_type_ComTencentAvRandomUiRandomMultiActivity.getLayoutInflater().inflate(2130903607, null);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131296844));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131298715));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      Bitmap localBitmap = this.jdField_a_of_type_ComTencentAvRandomUiRandomMultiActivity.jdField_a_of_type_ComTencentAvVideoController.a(str, this.jdField_a_of_type_ComTencentAvRandomUiRandomMultiActivity.jdField_a_of_type_ComTencentAvRandomRandomController.a);
      if (localBitmap != null) {
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
      }
      str = this.jdField_a_of_type_ComTencentAvRandomUiRandomMultiActivity.a(str, this.jdField_a_of_type_ComTencentAvRandomUiRandomMultiActivity.jdField_a_of_type_ComTencentAvRandomRandomController.a);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      paramView.setContentDescription(String.format(this.jdField_a_of_type_ComTencentAvRandomUiRandomMultiActivity.getString(2131363835), new Object[] { str }));
      return paramView;
      paramViewGroup = (gms)paramView.getTag();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gmr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */