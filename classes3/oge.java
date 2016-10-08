import android.content.res.Resources;
import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.bless.BlessTypeActivity;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.mobileqq.widget.ToastStyleDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class oge
  extends PagerAdapter
  implements ViewPager.OnPageChangeListener, FaceDecoder.DecodeTaskCompletionListener
{
  final int jdField_a_of_type_Int;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  private ToastStyleDialog jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  final int[] jdField_a_of_type_ArrayOfInt;
  private int b;
  
  public oge(BlessTypeActivity paramBlessTypeActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ArrayOfInt = new int[] { 2131297146, 2131297147, 2131297148, 2131297149, 2131297150, 2131297151, 2131297152, 2131297153 };
    this.jdField_a_of_type_Int = (this.jdField_a_of_type_ArrayOfInt.length - 1);
    this.b = 0;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ogf(this);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(paramBlessTypeActivity, paramBlessTypeActivity.app);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
  }
  
  private Bitmap a(String paramString, int paramInt)
  {
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramInt, paramString);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b()) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramString, paramInt, true);
    }
    return ImageUtil.a();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b()) && (this.b == 0))
    {
      paramString = (ImageView)this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTypeActivity.a.findViewWithTag(paramString);
      if (paramString != null) {
        paramString.setImageBitmap(paramBitmap);
      }
    }
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    View localView = (View)paramObject;
    Iterator localIterator = ((ogj)localView.getTag()).jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      ogi localogi = (ogi)localIterator.next();
      localogi.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
      localogi.jdField_a_of_type_AndroidWidgetTextView.setText("");
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(localView);
    paramViewGroup.removeView((View)paramObject);
    if (QLog.isColorLevel()) {
      QLog.d("BlessTyeActivity", 2, "viewpager destroy page");
    }
  }
  
  public int getCount()
  {
    int i = 0;
    if (BlessTypeActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTypeActivity) != null)
    {
      j = BlessTypeActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTypeActivity).size() / this.jdField_a_of_type_Int;
      i = j;
      if (BlessTypeActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTypeActivity).size() % 7 != 0) {
        i = j + 1;
      }
    }
    int j = i;
    if (i == 0) {
      j = i + 1;
    }
    return j;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    View localView;
    Object localObject1;
    Object localObject2;
    int j;
    int i;
    Object localObject3;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
    {
      localView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTypeActivity).inflate(2130903107, null);
      localObject1 = new ogj(this);
      localObject2 = this.jdField_a_of_type_ArrayOfInt;
      j = localObject2.length;
      i = 0;
      while (i < j)
      {
        int k = localObject2[i];
        localObject3 = new ogi(this);
        ((ogi)localObject3).jdField_a_of_type_AndroidViewView = localView.findViewById(k);
        ((ogi)localObject3).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((ogi)localObject3).jdField_a_of_type_AndroidViewView.findViewById(2131297143));
        ((ogi)localObject3).b = ((ImageView)((ogi)localObject3).jdField_a_of_type_AndroidViewView.findViewById(2131297144));
        ((ogi)localObject3).jdField_a_of_type_AndroidWidgetTextView = ((TextView)((ogi)localObject3).jdField_a_of_type_AndroidViewView.findViewById(2131297145));
        ((ogj)localObject1).jdField_a_of_type_JavaUtilArrayList.add(localObject3);
        i += 1;
      }
      localView.setTag(localObject1);
      if (!QLog.isColorLevel()) {
        break label516;
      }
      QLog.d("BlessTyeActivity", 2, "viewpager inflate page");
    }
    label516:
    for (;;)
    {
      i = paramInt * this.jdField_a_of_type_Int;
      paramInt = 0;
      for (;;)
      {
        if ((paramInt >= this.jdField_a_of_type_Int) || (i + paramInt > BlessTypeActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTypeActivity).size() - 1))
        {
          localObject1 = (ogi)((ogj)localObject1).jdField_a_of_type_JavaUtilArrayList.get(paramInt);
          ((ogi)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837962);
          ((ogi)localObject1).b.setVisibility(8);
          ((ogi)localObject1).jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTypeActivity.getResources().getColorStateList(2131428131));
          ((ogi)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(2131368676);
          ((ogi)localObject1).jdField_a_of_type_AndroidViewView.setOnLongClickListener(null);
          ((ogi)localObject1).jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          paramViewGroup.addView(localView);
          return localView;
          localView = (View)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
          this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
          localObject1 = (ogj)localView.getTag();
          if (QLog.isColorLevel()) {
            QLog.d("BlessTyeActivity", 2, "viewpager reuse page");
          }
          break;
        }
        localObject2 = (ogi)((ogj)localObject1).jdField_a_of_type_JavaUtilArrayList.get(paramInt);
        j = i + paramInt;
        localObject3 = (ResultRecord)BlessTypeActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTypeActivity).get(j);
        ((ogi)localObject2).jdField_a_of_type_AndroidWidgetImageView.setTag(((ResultRecord)localObject3).jdField_a_of_type_JavaLangString);
        ((ogi)localObject2).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(((ResultRecord)localObject3).jdField_a_of_type_JavaLangString, 1));
        ((ogi)localObject2).b.setVisibility(0);
        ((ogi)localObject2).jdField_a_of_type_AndroidWidgetTextView.setText(((ResultRecord)localObject3).b);
        ((ogi)localObject2).jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTypeActivity.getResources().getColor(2131427409));
        ((ogi)localObject2).jdField_a_of_type_AndroidViewView.setOnClickListener(new ogg(this, j));
        ((ogi)localObject2).jdField_a_of_type_JavaLangString = ((ResultRecord)localObject3).jdField_a_of_type_JavaLangString;
        paramInt += 1;
      }
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTypeActivity.a == null) {}
    do
    {
      for (;;)
      {
        return;
        this.b = paramInt;
        if (paramInt != 0) {
          break;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b()) {
          this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b();
        }
        paramInt = 0;
        while (paramInt < this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTypeActivity.a.getChildCount())
        {
          Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessTypeActivity.a.getChildAt(paramInt).getTag();
          if ((localObject != null) && ((localObject instanceof ogj)))
          {
            localObject = ((ogj)localObject).jdField_a_of_type_JavaUtilArrayList.iterator();
            while (((Iterator)localObject).hasNext())
            {
              ogi localogi = (ogi)((Iterator)localObject).next();
              if ((localogi != null) && (localogi.jdField_a_of_type_JavaLangString != null)) {
                localogi.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(localogi.jdField_a_of_type_JavaLangString, 1));
              }
            }
          }
          paramInt += 1;
        }
      }
    } while (paramInt != 1);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a();
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.c();
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\oge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */