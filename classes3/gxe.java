import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.VideoController.GAudioFriends;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.MultiVideoMembersListviewAvtivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public class gxe
  extends BaseAdapter
{
  private boolean jdField_a_of_type_Boolean;
  
  public gxe(MultiVideoMembersListviewAvtivity paramMultiVideoMembersListviewAvtivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  Bitmap a()
  {
    return ((BitmapDrawable)MultiVideoMembersListviewAvtivity.d(this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersListviewAvtivity).getDrawable(2130838582)).getBitmap();
  }
  
  Bitmap a(String paramString)
  {
    int i = -1;
    if (this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersListviewAvtivity.jdField_a_of_type_Int == 3000) {
      i = 1004;
    }
    for (;;)
    {
      return this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersListviewAvtivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i, paramString, String.valueOf(this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersListviewAvtivity.jdField_a_of_type_Long), true, false);
      if (this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersListviewAvtivity.jdField_a_of_type_Int == 1) {
        i = 1000;
      }
    }
  }
  
  String a(String paramString)
  {
    int i = -1;
    if (this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersListviewAvtivity.jdField_a_of_type_Int == 3000) {
      i = 1004;
    }
    for (;;)
    {
      return this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersListviewAvtivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i, paramString, String.valueOf(this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersListviewAvtivity.jdField_a_of_type_Long));
      if (this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersListviewAvtivity.jdField_a_of_type_Int == 1) {
        i = 1000;
      }
    }
  }
  
  void a(VideoController.GAudioFriends paramGAudioFriends, gxh paramgxh)
  {
    if ((this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersListviewAvtivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) || (paramGAudioFriends == null) || (paramgxh == null)) {
      return;
    }
    if (paramGAudioFriends.jdField_a_of_type_AndroidGraphicsBitmap == null)
    {
      paramgxh.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a());
      this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersListviewAvtivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(new gxf(this, paramgxh, paramGAudioFriends));
      return;
    }
    paramgxh.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramGAudioFriends.jdField_a_of_type_AndroidGraphicsBitmap);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersListviewAvtivity.jdField_a_of_type_JavaUtilArrayList == null) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersListviewAvtivity.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersListviewAvtivity.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    label28:
    label117:
    VideoController.GAudioFriends localGAudioFriends;
    String str;
    if (paramView == null) {
      if (this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersListviewAvtivity.jdField_a_of_type_Boolean)
      {
        paramView = this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersListviewAvtivity.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903563, null);
        paramViewGroup = new gxh(this);
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131299253));
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131299254));
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131299258));
        paramViewGroup.c = ((ImageView)paramView.findViewById(2131299257));
        if (this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersListviewAvtivity.jdField_a_of_type_Boolean) {
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131299255));
        }
        paramView.setTag(paramViewGroup);
        localGAudioFriends = (VideoController.GAudioFriends)this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersListviewAvtivity.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
        paramViewGroup.jdField_a_of_type_Long = localGAudioFriends.jdField_a_of_type_Long;
        a(localGAudioFriends, paramViewGroup);
        localGAudioFriends.jdField_a_of_type_JavaLangString = a(String.valueOf(localGAudioFriends.jdField_a_of_type_Long));
        if (localGAudioFriends.jdField_a_of_type_JavaLangString != null) {
          break label366;
        }
        str = "";
        label178:
        localGAudioFriends.jdField_a_of_type_JavaLangString = str;
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localGAudioFriends.jdField_a_of_type_JavaLangString);
        if ((localGAudioFriends.jdField_a_of_type_Int <= 0) && (!localGAudioFriends.b) && (!localGAudioFriends.c)) {
          break label376;
        }
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        label229:
        if (!localGAudioFriends.jdField_a_of_type_Boolean) {
          break label388;
        }
        paramViewGroup.c.setVisibility(0);
      }
    }
    for (;;)
    {
      int i;
      if (this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersListviewAvtivity.jdField_a_of_type_Boolean)
      {
        paramInt = localGAudioFriends.e;
        i = localGAudioFriends.g;
        if (paramInt < 0) {
          break label462;
        }
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText("Lv." + paramInt);
      }
      switch (i)
      {
      default: 
        return paramView;
        paramView = this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersListviewAvtivity.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903576, null);
        break label28;
        paramViewGroup = (gxh)paramView.getTag();
        break label117;
        label366:
        str = localGAudioFriends.jdField_a_of_type_JavaLangString;
        break label178;
        label376:
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        break label229;
        label388:
        paramViewGroup.c.setVisibility(4);
      }
    }
    paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setTextColor(MultiVideoMembersListviewAvtivity.a(this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersListviewAvtivity).getColor(2131427822));
    return paramView;
    paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setTextColor(MultiVideoMembersListviewAvtivity.b(this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersListviewAvtivity).getColor(2131427823));
    return paramView;
    paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setTextColor(MultiVideoMembersListviewAvtivity.c(this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersListviewAvtivity).getColor(2131427824));
    return paramView;
    label462:
    paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    return paramView;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gxe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */