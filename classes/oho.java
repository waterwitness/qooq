import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchFragment;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment.ArticleItemViewHolder;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment.ItemViewHolder;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.List;

public class oho
  extends BaseAdapter
{
  private List jdField_a_of_type_JavaUtilList;
  
  private oho(ClassificationSearchFragment paramClassificationSearchFragment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public int getCount()
  {
    int j = this.jdField_a_of_type_JavaUtilList.size();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.jdField_a_of_type_Int != 0) {}
    for (int i = 1;; i = 0) {
      return i + j;
    }
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size())
    {
      if (((AccountSearchPb.record)this.jdField_a_of_type_JavaUtilList.get(paramInt)).account_id.has()) {
        return 2;
      }
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    switch (getItemViewType(paramInt))
    {
    }
    Object localObject1;
    do
    {
      do
      {
        do
        {
          return paramView;
          localObject1 = paramView;
          if (paramView == null)
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.a().getLayoutInflater().inflate(2130904056, paramViewGroup, false);
            ((View)localObject1).setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment);
            paramView = new SearchBaseFragment.ItemViewHolder();
            paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131296907));
            paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131296908));
            paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131301214));
            paramView.jdField_c_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131299988));
            paramView.d = ((TextView)((View)localObject1).findViewById(2131299989));
            paramView.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record = ((AccountSearchPb.record)getItem(paramInt));
            paramView.jdField_b_of_type_Int = ClassificationSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment);
            ((View)localObject1).setTag(2131297389, Integer.valueOf(paramInt));
            ((View)localObject1).setTag(paramView);
          }
          paramView = (SearchBaseFragment.ItemViewHolder)((View)localObject1).getTag();
          paramView.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record = ((AccountSearchPb.record)getItem(paramInt));
          paramView.jdField_c_of_type_Int = (paramInt + 1);
          paramViewGroup = ClassificationSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment, paramView, (AccountSearchPb.record)this.jdField_a_of_type_JavaUtilList.get(paramInt));
          paramView = (View)localObject1;
        } while (!AppSetting.j);
        ((View)localObject1).setContentDescription(paramViewGroup);
        return (View)localObject1;
        localObject1 = (AccountSearchPb.record)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        paramViewGroup = paramView;
        if (paramView == null)
        {
          paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.a().getLayoutInflater().inflate(2130904330, null);
          paramView = new SearchBaseFragment.ArticleItemViewHolder();
          paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131296907));
          paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131296908));
          paramView.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131302346));
          paramView.d = ((TextView)paramViewGroup.findViewById(2131302345));
          paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131302344));
          paramView.jdField_a_of_type_Long = ((AccountSearchPb.record)localObject1).account_id.get();
          paramViewGroup.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment);
          paramViewGroup.setTag(paramView);
        }
        paramView = (SearchBaseFragment.ArticleItemViewHolder)paramViewGroup.getTag();
        paramView.jdField_c_of_type_AndroidWidgetTextView.setText(((AccountSearchPb.record)localObject1).article_create_time.get());
        if ((((AccountSearchPb.record)localObject1).article_author.has()) && (!"".equals(((AccountSearchPb.record)localObject1).article_author.get()))) {
          paramView.d.setText(((AccountSearchPb.record)localObject1).article_author.get());
        }
        int i = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.getResources().getDimensionPixelSize(2131493586);
        if (!TextUtils.isEmpty(((AccountSearchPb.record)localObject1).title_image.get())) {}
        try
        {
          Object localObject2 = URLDrawable.getDrawable(((AccountSearchPb.record)localObject1).title_image.get(), i, i);
          paramView.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
          paramView.jdField_a_of_type_JavaLangString = ((AccountSearchPb.record)localObject1).article_short_url.get();
          if (((AccountSearchPb.record)localObject1).name.has()) {
            paramView.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.a(80000003, ((AccountSearchPb.record)localObject1).name.get()));
          }
          if ((((AccountSearchPb.record)localObject1).brief.has()) && (!"".equals(((AccountSearchPb.record)localObject1).brief.get()))) {
            if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.a(paramView.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.a()) > 1)
            {
              paramView.jdField_b_of_type_AndroidWidgetTextView.setMaxLines(1);
              paramView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
              paramView.jdField_b_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
              localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.a(80000003, ((AccountSearchPb.record)localObject1).brief.get());
              if (QLog.isColorLevel()) {
                QLog.d("ClassificationSearchFragment", 2, "brief = " + localObject2);
              }
              paramView.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
              paramViewGroup.setLayoutParams(new AbsListView.LayoutParams(new AbsListView.LayoutParams(-1, AIOUtils.a(110.0F, this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.a().getResources()))));
              localObject2 = (ImageView)paramViewGroup.findViewById(2131302342);
              ((ImageView)localObject2).setVisibility(4);
              ImageView localImageView = (ImageView)paramViewGroup.findViewById(2131298138);
              localImageView.setVisibility(4);
              if ((((AccountSearchPb.record)localObject1).video_article.has()) && (((AccountSearchPb.record)localObject1).video_article.get() == 11))
              {
                ((ImageView)localObject2).setVisibility(0);
                localImageView.getBackground().setAlpha(25);
                localImageView.setVisibility(0);
              }
              paramView.jdField_a_of_type_Int = (paramInt + 1);
              return paramViewGroup;
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QLog.d("ClassificationSearchFragment", 1, "classification urldrawable error:" + localException.toString());
            continue;
            paramView.jdField_b_of_type_AndroidWidgetTextView.setMaxLines(2);
            continue;
            if (QLog.isColorLevel()) {
              QLog.d("ClassificationSearchFragment", 2, "brief = gone");
            }
            paramView.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
            paramViewGroup.setLayoutParams(new AbsListView.LayoutParams(new AbsListView.LayoutParams(-1, AIOUtils.a(90.0F, this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.a().getResources()))));
          }
        }
        paramViewGroup = paramView;
        if (paramView == null)
        {
          paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.a().getLayoutInflater().inflate(2130903408, null);
          paramViewGroup.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment);
          paramView = new ohn();
          paramViewGroup.setTag(paramView);
          paramView.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramViewGroup.findViewById(2131297005));
          paramViewGroup.findViewById(2131298469).setVisibility(8);
          paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131298457));
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.b();
        localObject1 = (ohn)paramViewGroup.getTag();
        if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.jdField_a_of_type_Int != 3) {
          break;
        }
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.jdField_a_of_type_Boolean = true;
          ((ohn)localObject1).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          ((ohn)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText("获取失败，请稍后再试");
          return paramViewGroup;
        }
        paramView = paramViewGroup;
      } while (!NetworkUtil.e(BaseApplicationImpl.getContext()));
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.jdField_a_of_type_Boolean = false;
      ((ohn)localObject1).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      ((ohn)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText("载入中，请稍候...");
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.d, true);
      return paramViewGroup;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.jdField_a_of_type_Int == 2)
      {
        ((ohn)localObject1).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        ((ohn)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText("载入中，请稍候...");
        return paramViewGroup;
      }
      paramView = paramViewGroup;
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.jdField_a_of_type_Int != 4);
    ((ohn)localObject1).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    ((ohn)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText("获取失败，请检查网络连接");
    return paramViewGroup;
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oho.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */