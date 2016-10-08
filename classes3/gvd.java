import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.GAudioFriends;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo.TelInfo;
import com.tencent.av.ui.MultiMembersAudioUI;
import com.tencent.av.ui.MultiMembersUI.Holder;
import com.tencent.av.ui.MultiMembersUI.MVMembersInfo;
import com.tencent.av.utils.PstnUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class gvd
  extends PagerAdapter
{
  public static final String a = "MemberPagerAdapter";
  
  public gvd(MultiMembersAudioUI paramMultiMembersAudioUI)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    int i = 0;
    if (this.a.jdField_a_of_type_JavaUtilArrayList == null) {
      return 0;
    }
    int j = this.a.c / 8;
    if (this.a.c % 8 == 0) {}
    for (;;)
    {
      return i + j;
      i = 1;
    }
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if ((this.a.jdField_a_of_type_JavaUtilArrayList == null) || (this.a.c == 0)) {
      return null;
    }
    View localView1 = View.inflate(paramViewGroup.getContext(), 2130903583, null);
    if (paramInt == getCount() - 1) {}
    for (int i = this.a.c - paramInt * 8;; i = 8)
    {
      this.a.a(localView1, i);
      int j = 0;
      int k;
      if (j < i)
      {
        k = paramInt * 8 + j;
        if (k <= this.a.c - 1) {}
      }
      else
      {
        localView1.setTag("MemberPagerAdapter_" + paramInt);
        paramViewGroup.addView(localView1);
        return localView1;
      }
      MultiMembersUI.MVMembersInfo localMVMembersInfo = (MultiMembersUI.MVMembersInfo)this.a.jdField_a_of_type_JavaUtilArrayList.get(k);
      if (localMVMembersInfo == null) {}
      for (;;)
      {
        j += 1;
        break;
        int m = this.a.a(i, j);
        View localView2;
        MultiMembersUI.Holder localHolder;
        Object localObject1;
        Object localObject2;
        if (m != -1)
        {
          localView2 = localView1.findViewById(m);
          if (localView2 != null)
          {
            localHolder = this.a.a(localView2);
            localView2.setTag(localHolder);
            if (this.a.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
              localView2.setOnClickListener(this.a.jdField_a_of_type_AndroidViewView$OnClickListener);
            }
            if ((localMVMembersInfo.jdField_a_of_type_JavaLangString == null) || (localMVMembersInfo.jdField_a_of_type_AndroidGraphicsBitmap == null) || (!localMVMembersInfo.jdField_d_of_type_Boolean))
            {
              if (localMVMembersInfo.jdField_b_of_type_Int != 0) {
                break label751;
              }
              localObject1 = String.valueOf(localMVMembersInfo.jdField_a_of_type_Long);
              if (this.a.jdField_b_of_type_Int != 7) {
                break label657;
              }
              localObject2 = this.a.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject1);
              if (localObject2 != null)
              {
                if (!this.a.jdField_b_of_type_Boolean) {
                  break label644;
                }
                localMVMembersInfo.jdField_a_of_type_JavaLangString = ((VideoController.GAudioFriends)localObject2).jdField_b_of_type_JavaLangString;
                label330:
                if ((((String)localObject1).equals(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a())) && (localMVMembersInfo.jdField_a_of_type_JavaLangString != null)) {
                  localMVMembersInfo.jdField_a_of_type_JavaLangString += this.a.getResources().getString(2131363810);
                }
              }
              label393:
              if (localMVMembersInfo.jdField_a_of_type_JavaLangString == null) {
                localMVMembersInfo.jdField_a_of_type_JavaLangString = ((String)localObject1);
              }
              if (localMVMembersInfo.jdField_a_of_type_JavaLangString.compareTo((String)localObject1) == 0) {
                break label693;
              }
              localMVMembersInfo.jdField_d_of_type_Boolean = true;
              label425:
              if (this.a.jdField_b_of_type_Int != 7) {
                break label702;
              }
              localObject2 = this.a.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject1, this.a.jdField_b_of_type_Boolean);
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                localObject2 = new BitmapFactory.Options();
                ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
                localObject1 = BitmapFactory.decodeResource(this.a.getResources(), 2130839235, (BitmapFactory.Options)localObject2);
                ((BitmapFactory.Options)localObject2).inJustDecodeBounds = false;
              }
            }
          }
        }
        try
        {
          localObject2 = BitmapFactory.decodeResource(this.a.getResources(), 2130839235, (BitmapFactory.Options)localObject2);
          localObject1 = localObject2;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          long l;
          for (;;) {}
        }
        localMVMembersInfo.jdField_d_of_type_Boolean = false;
        label526:
        if (localObject1 != null) {
          localMVMembersInfo.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject1);
        }
        for (;;)
        {
          if (((this.a.jdField_b_of_type_Int != 1) && (this.a.jdField_b_of_type_Int != 2) && (this.a.jdField_b_of_type_Int != 7)) || (k != 17) || (this.a.jdField_a_of_type_JavaUtilArrayList.size() <= 18)) {
            break label991;
          }
          localHolder.jdField_b_of_type_Boolean = false;
          localHolder.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130839217);
          localHolder.jdField_a_of_type_AndroidWidgetTextView.setText("更多成员");
          localHolder.jdField_c_of_type_Boolean = true;
          localView2.setContentDescription(this.a.getResources().getString(2131363413));
          break;
          label644:
          localMVMembersInfo.jdField_a_of_type_JavaLangString = ((VideoController.GAudioFriends)localObject2).jdField_a_of_type_JavaLangString;
          break label330;
          label657:
          localMVMembersInfo.jdField_a_of_type_JavaLangString = this.a.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject1, String.valueOf(this.a.jdField_a_of_type_Long), this.a.jdField_b_of_type_Int);
          break label393;
          label693:
          localMVMembersInfo.jdField_d_of_type_Boolean = false;
          break label425;
          label702:
          localObject1 = this.a.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject1, String.valueOf(this.a.jdField_a_of_type_Long), this.a.jdField_b_of_type_Int, false, true);
          break label526;
          localMVMembersInfo.jdField_a_of_type_AndroidGraphicsBitmap = null;
          localMVMembersInfo.jdField_d_of_type_Boolean = false;
        }
        label751:
        l = localMVMembersInfo.jdField_a_of_type_Long;
        if (localMVMembersInfo.jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo != null)
        {
          localObject1 = localMVMembersInfo.jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo;
          label772:
          if ((localObject1 == null) || (((AVPhoneUserInfo)localObject1).telInfo.mobile == null)) {
            break label925;
          }
          localMVMembersInfo.jdField_a_of_type_JavaLangString = ((AVPhoneUserInfo)localObject1).telInfo.mobile;
          localObject2 = this.a.jdField_a_of_type_ComTencentAvVideoController.a(((AVPhoneUserInfo)localObject1).telInfo.mobile);
          if (localObject2 == null) {
            break label900;
          }
          localMVMembersInfo.jdField_b_of_type_JavaLangString = ContactUtils.a((String)localObject2);
          localMVMembersInfo.jdField_a_of_type_JavaLangString = ((String)localObject2);
        }
        for (;;)
        {
          localMVMembersInfo.jdField_a_of_type_AndroidGraphicsBitmap = ((BitmapDrawable)this.a.getResources().getDrawable(2130839141)).getBitmap();
          localMVMembersInfo.jdField_d_of_type_Boolean = true;
          break;
          localObject1 = this.a.jdField_a_of_type_ComTencentAvVideoController.a(l, this.a.jdField_a_of_type_ComTencentAvVideoController.a().f);
          break label772;
          label900:
          localMVMembersInfo.jdField_b_of_type_JavaLangString = null;
          localMVMembersInfo.jdField_a_of_type_JavaLangString = PstnUtils.a(((AVPhoneUserInfo)localObject1).telInfo.mobile, 4);
          continue;
          label925:
          if ((localObject1 != null) && (QLog.isColorLevel())) {
            QLog.d("MemberPagerAdapter", 2, "getView --> can not get Open Id. PhoneInfo = " + ((AVPhoneUserInfo)localObject1).toString());
          }
          localMVMembersInfo.jdField_b_of_type_JavaLangString = null;
          localMVMembersInfo.jdField_a_of_type_JavaLangString = this.a.getResources().getString(2131363414);
        }
        label991:
        if (this.a.jdField_b_of_type_Int == 7) {
          localHolder.jdField_b_of_type_Int = localMVMembersInfo.jdField_d_of_type_Int;
        }
        switch (localHolder.jdField_b_of_type_Int)
        {
        case 3: 
        default: 
          label1048:
          if (localHolder.jdField_b_of_type_Int != 0) {
            localHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          }
          if (String.valueOf(localMVMembersInfo.jdField_a_of_type_Long).endsWith(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()))
          {
            localHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColor(2131427657));
            label1110:
            localHolder.jdField_b_of_type_Boolean = true;
            localHolder.jdField_a_of_type_Long = localMVMembersInfo.jdField_a_of_type_Long;
            localObject1 = String.valueOf(localMVMembersInfo.jdField_a_of_type_Long);
            if (localMVMembersInfo.jdField_a_of_type_JavaLangString == null) {
              break label1517;
            }
            localHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localMVMembersInfo.jdField_a_of_type_JavaLangString);
            if ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().F == 7) && (!localHolder.jdField_a_of_type_AndroidWidgetTextView.isShown()) && (!localMVMembersInfo.jdField_a_of_type_JavaLangString.equals(localObject1))) {
              localHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
            }
            label1206:
            if (localMVMembersInfo.jdField_a_of_type_AndroidGraphicsBitmap == null) {
              break label1612;
            }
            if ((localMVMembersInfo.jdField_b_of_type_Int == 0) || (localMVMembersInfo.jdField_b_of_type_JavaLangString == null)) {
              break label1586;
            }
            localHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
            localHolder.jdField_b_of_type_AndroidWidgetTextView.setText(localMVMembersInfo.jdField_b_of_type_JavaLangString);
            localObject1 = ((BitmapDrawable)this.a.getResources().getDrawable(2130839106)).getBitmap();
            localHolder.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject1);
            label1281:
            if (((this.a.jdField_a_of_type_ComTencentAvVideoController.a().F == 1) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().D == 10)) || (this.a.jdField_a_of_type_ComTencentAvVideoController.a().F == 2) || (this.a.jdField_a_of_type_ComTencentAvVideoController.a().F == 7))
            {
              if (!localMVMembersInfo.e) {
                break label1636;
              }
              if (localHolder.d.getVisibility() != 0) {
                localHolder.d.setVisibility(0);
              }
              if (localHolder.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0) {
                localHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
              }
              localMVMembersInfo.jdField_a_of_type_Boolean = false;
            }
            label1406:
            localHolder.jdField_a_of_type_Boolean = localMVMembersInfo.jdField_a_of_type_Boolean;
            if (!localHolder.jdField_a_of_type_Boolean) {
              break label1660;
            }
            localHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          }
          break;
        }
        for (;;)
        {
          if (localMVMembersInfo.jdField_a_of_type_Int != 2) {
            break label1673;
          }
          localHolder.jdField_a_of_type_Int = 5;
          break;
          localHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838974);
          break label1048;
          localHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838978);
          break label1048;
          localHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838976);
          break label1048;
          localHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColor(2131427407));
          break label1110;
          label1517:
          if ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().F == 7) && (localHolder.jdField_a_of_type_AndroidWidgetTextView.isShown()) && (localMVMembersInfo.jdField_a_of_type_JavaLangString.equals(localObject1))) {
            localHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
          }
          localHolder.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(localMVMembersInfo.jdField_a_of_type_Long));
          break label1206;
          label1586:
          localHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          localHolder.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(localMVMembersInfo.jdField_a_of_type_AndroidGraphicsBitmap);
          break label1281;
          label1612:
          localHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          localHolder.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130838582);
          break label1281;
          label1636:
          if (localHolder.d.getVisibility() != 0) {
            break label1406;
          }
          localHolder.d.setVisibility(8);
          break label1406;
          label1660:
          localHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        }
        label1673:
        if (localMVMembersInfo.jdField_c_of_type_Boolean) {
          localHolder.jdField_a_of_type_Int = 3;
        } else if (localMVMembersInfo.jdField_a_of_type_Int == 1) {
          localHolder.jdField_a_of_type_Int = 2;
        } else if (localMVMembersInfo.jdField_b_of_type_Boolean) {
          localHolder.jdField_a_of_type_Int = 1;
        } else {
          localHolder.jdField_a_of_type_Int = 0;
        }
      }
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gvd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */