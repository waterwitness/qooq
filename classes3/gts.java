import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo.TelInfo;
import com.tencent.av.ui.GAudioMemberListCtrl;
import com.tencent.av.utils.PstnUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class gts
  extends BaseAdapter
{
  private gts(GAudioMemberListCtrl paramGAudioMemberListCtrl)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  gtt a(View paramView)
  {
    gtt localgtt = new gtt(this.a, null);
    localgtt.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131299159));
    localgtt.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131299161));
    localgtt.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131299160));
    localgtt.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131299165));
    localgtt.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this.a.jdField_a_of_type_AndroidViewView$OnClickListener);
    return localgtt;
  }
  
  public int getCount()
  {
    return this.a.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    gtr localgtr = (gtr)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    Object localObject;
    if (paramView == null)
    {
      paramView = this.a.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903549, null);
      paramViewGroup = a(paramView);
      paramView.setTag(paramViewGroup);
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setTag(localgtr);
      if ((localgtr.jdField_a_of_type_JavaLangString == null) || (localgtr.jdField_a_of_type_AndroidGraphicsBitmap == null) || (!localgtr.jdField_b_of_type_Boolean))
      {
        if (localgtr.jdField_a_of_type_Int != 0) {
          break label443;
        }
        localObject = String.valueOf(localgtr.jdField_a_of_type_Long);
        localgtr.jdField_a_of_type_JavaLangString = this.a.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject, String.valueOf(this.a.jdField_a_of_type_Long), this.a.jdField_a_of_type_Int);
        if (localgtr.jdField_a_of_type_JavaLangString.compareTo((String)localObject) == 0) {
          break label419;
        }
        localgtr.jdField_b_of_type_Boolean = true;
        label149:
        localObject = this.a.jdField_a_of_type_ComTencentAvVideoController.a((String)localObject, String.valueOf(this.a.jdField_a_of_type_Long), this.a.jdField_a_of_type_Int, false, true);
        if (localObject == null) {
          break label428;
        }
        localgtr.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject);
      }
      label194:
      paramViewGroup.jdField_b_of_type_Boolean = true;
      paramViewGroup.jdField_a_of_type_Long = localgtr.jdField_a_of_type_Long;
      if (localgtr.jdField_a_of_type_JavaLangString == null) {
        break label709;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localgtr.jdField_a_of_type_JavaLangString);
      label228:
      if (localgtr.jdField_a_of_type_AndroidGraphicsBitmap == null) {
        break label751;
      }
      if ((localgtr.jdField_a_of_type_Int == 0) || (localgtr.jdField_b_of_type_JavaLangString == null)) {
        break label727;
      }
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(localgtr.jdField_b_of_type_JavaLangString);
      localObject = ((BitmapDrawable)((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getDrawable(2130839106)).getBitmap();
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject);
      label310:
      if (!localgtr.c) {
        break label773;
      }
      if ((paramViewGroup.jdField_a_of_type_Int == -1) || (paramViewGroup.jdField_a_of_type_Int == 0))
      {
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130839030);
        paramViewGroup.jdField_a_of_type_Int = 1;
      }
      localgtr.jdField_a_of_type_Boolean = false;
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_Boolean = localgtr.jdField_a_of_type_Boolean;
      if (!paramViewGroup.jdField_a_of_type_Boolean) {
        break label807;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null);
      return paramView;
      localObject = (gtt)paramView.getTag();
      paramViewGroup = (ViewGroup)localObject;
      if (localObject == null)
      {
        paramViewGroup = a(paramView);
        paramView.setTag(paramViewGroup);
      }
      break;
      label419:
      localgtr.jdField_b_of_type_Boolean = false;
      break label149;
      label428:
      localgtr.jdField_a_of_type_AndroidGraphicsBitmap = null;
      localgtr.jdField_b_of_type_Boolean = false;
      break label194;
      label443:
      long l = localgtr.jdField_a_of_type_Long;
      if (localgtr.jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo != null)
      {
        localObject = localgtr.jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo;
        label465:
        if ((localObject == null) || (((AVPhoneUserInfo)localObject).telInfo.mobile == null)) {
          break label633;
        }
        localgtr.jdField_a_of_type_JavaLangString = ((AVPhoneUserInfo)localObject).telInfo.mobile;
        String str = this.a.jdField_a_of_type_ComTencentAvVideoController.a(((AVPhoneUserInfo)localObject).telInfo.mobile);
        if (str == null) {
          break label607;
        }
        localgtr.jdField_b_of_type_JavaLangString = ContactUtils.a(str);
        localgtr.jdField_a_of_type_JavaLangString = str;
      }
      for (;;)
      {
        localgtr.jdField_a_of_type_AndroidGraphicsBitmap = ((BitmapDrawable)((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getDrawable(2130839141)).getBitmap();
        localgtr.jdField_b_of_type_Boolean = true;
        break;
        localObject = this.a.jdField_a_of_type_ComTencentAvVideoController.a(l, this.a.jdField_a_of_type_ComTencentAvVideoController.a().f);
        break label465;
        label607:
        localgtr.jdField_b_of_type_JavaLangString = null;
        localgtr.jdField_a_of_type_JavaLangString = PstnUtils.a(((AVPhoneUserInfo)localObject).telInfo.mobile, 4);
        continue;
        label633:
        if ((localObject != null) && (QLog.isColorLevel())) {
          QLog.d("GAudioMemberListCtrl", 2, "getView --> can not get Open Id. PhoneInfo = " + ((AVPhoneUserInfo)localObject).toString());
        }
        localgtr.jdField_b_of_type_JavaLangString = null;
        localgtr.jdField_a_of_type_JavaLangString = ((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources().getString(2131363414);
      }
      label709:
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(localgtr.jdField_a_of_type_Long));
      break label228;
      label727:
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localgtr.jdField_a_of_type_AndroidGraphicsBitmap);
      break label310;
      label751:
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838582);
      break label310;
      label773:
      if ((paramViewGroup.jdField_a_of_type_Int == -1) || (paramViewGroup.jdField_a_of_type_Int == 1))
      {
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130839031);
        paramViewGroup.jdField_a_of_type_Int = 0;
      }
    }
    label807:
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    return paramView;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */