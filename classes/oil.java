import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.addContactTroopView.GroupViewAdapter;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment.ArticleItemViewHolder;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment.ItemViewHolder;
import com.tencent.mobileqq.activity.contact.addcontact.SearchContactsFragment;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.search.activity.GroupSearchActivity;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.NearbyTroops.CustomViewHolder;
import com.tencent.pb.addcontacts.AccountSearchPb.hotwordrecord;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Map;

public class oil
  extends FacePreloadBaseAdapter
{
  private String jdField_a_of_type_JavaLangString;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean;
  
  public oil(SearchContactsFragment paramSearchContactsFragment, Context paramContext, QQAppInterface paramQQAppInterface, ListView paramListView, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramQQAppInterface, paramListView, paramInt, paramBoolean);
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  private int a(int paramInt)
  {
    if (paramInt >= 1)
    {
      if (getItemViewType(paramInt - 1) == 0) {
        return 1;
      }
      if ((paramInt >= 2) && (getItemViewType(paramInt - 2) == 0)) {
        return 2;
      }
    }
    return 3;
  }
  
  protected Object a(int paramInt)
  {
    return null;
  }
  
  public void a(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    SearchContactsFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment).clear();
    int i = 0;
    int k;
    for (int j = 0; i < this.jdField_a_of_type_JavaUtilArrayList.size(); j = k)
    {
      k = j;
      if (((oik)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Int == 0)
      {
        paramArrayList = SearchContactsFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment);
        int m = ((oik)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_b_of_type_Int;
        k = j + 1;
        paramArrayList.put(Integer.valueOf(m), Integer.valueOf(k));
      }
      i += 1;
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (((oik)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int == 2) {}
    switch (((oik)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_b_of_type_Int)
    {
    case 80000002: 
    default: 
      return ((oik)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int;
    case 80000001: 
      return 3;
    }
    return 4;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    Object localObject2;
    SearchBaseFragment.ArticleItemViewHolder localArticleItemViewHolder;
    oik localoik;
    switch (getItemViewType(paramInt))
    {
    default: 
    case 0: 
      do
      {
        return paramView;
        localObject1 = paramView;
        if (paramView == null) {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a().getLayoutInflater().inflate(2130903375, paramViewGroup, false);
        }
        paramView = (TextView)((View)localObject1).findViewById(2131297123);
        if (GroupSearchActivity.e == 12) {
          if (((oik)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString.equals("公众号")) {
            paramView.setText(PublicAccountConfigUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.a().getApplicationContext()));
          }
        }
        for (;;)
        {
          this.jdField_a_of_type_JavaLangString = ((oik)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString;
          if (AppSetting.j)
          {
            ((View)localObject1).setFocusable(true);
            ((View)localObject1).setContentDescription(paramView.getText() + "搜索结果");
          }
          paramViewGroup = ((View)localObject1).findViewById(2131298342);
          if (paramInt <= 0) {
            break;
          }
          paramViewGroup.setVisibility(0);
          return (View)localObject1;
          paramView.setText(((oik)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString);
          continue;
          paramView.setText(((oik)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString);
        }
        paramView = (View)localObject1;
      } while (paramInt != 0);
      paramViewGroup.setVisibility(8);
      return (View)localObject1;
    case 3: 
      localObject2 = (oik)getItem(paramInt);
      localObject1 = paramView;
      if (paramView == null) {
        localObject1 = GroupViewAdapter.b(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a(), paramViewGroup, 5, false, 1);
      }
      paramView = ((oik)getItem(paramInt)).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record;
      GroupViewAdapter.a((View)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a(), ((oik)localObject2).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record);
      paramViewGroup = (NearbyTroops.CustomViewHolder)((View)localObject1).getTag();
      paramViewGroup.f.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a().getResources().getColor(2131428265));
      paramViewGroup.f.setText(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a(80000001, String.valueOf(paramView.name.get())));
      paramViewGroup.jdField_b_of_type_JavaLangString = Long.toString(((oik)localObject2).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.code.get());
      paramViewGroup.jdField_c_of_type_Int = 4;
      paramViewGroup.d.setImageBitmap(a(4, paramViewGroup.jdField_b_of_type_JavaLangString));
      paramViewGroup.jdField_a_of_type_Int = a(paramInt);
      ((View)localObject1).setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment);
      return (View)localObject1;
    case 4: 
      paramViewGroup = paramView;
      if (paramView == null)
      {
        paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a().getLayoutInflater().inflate(2130904329, null);
        paramView = new SearchBaseFragment.ArticleItemViewHolder();
        paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131296907));
        paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131296908));
        paramView.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131302346));
        paramView.d = ((TextView)paramViewGroup.findViewById(2131302345));
        paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131302344));
        paramViewGroup.setTag(paramView);
      }
      localArticleItemViewHolder = (SearchBaseFragment.ArticleItemViewHolder)paramViewGroup.getTag();
      paramViewGroup.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment);
      localoik = (oik)getItem(paramInt);
      if (localoik.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord != null) {
        ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F29", "0X8006F29", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.d, localoik.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword.get(), String.valueOf(localoik.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword_type.get()), "");
      }
      break;
    }
    for (paramInt = 1;; paramInt = 0)
    {
      String str2 = "";
      String str1;
      Object localObject3;
      label763:
      int i;
      if (paramInt != 0)
      {
        localObject2 = localoik.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword.get();
        str1 = localoik.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword_description.get();
        localObject1 = localoik.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword_title.get();
        localObject3 = localoik.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword_cover_url.get();
        paramView = localoik.jdField_b_of_type_JavaLangString;
        SearchContactsFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment, (String)localObject2);
        SearchContactsFragment.b(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment, String.valueOf(localoik.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword_type.get()));
        localArticleItemViewHolder.jdField_b_of_type_JavaLangString = SearchContactsFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment);
        localArticleItemViewHolder.jdField_c_of_type_JavaLangString = SearchContactsFragment.b(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment);
        if (!TextUtils.isEmpty(localoik.jdField_b_of_type_JavaLangString)) {
          SearchContactsFragment.c(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment, localoik.jdField_b_of_type_JavaLangString);
        }
        localArticleItemViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(str2);
        i = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.getResources().getDimensionPixelSize(2131493586);
        if (TextUtils.isEmpty((CharSequence)localObject3)) {}
      }
      try
      {
        localObject3 = URLDrawable.getDrawable((String)localObject3, i, i);
        localArticleItemViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject3);
        localArticleItemViewHolder.jdField_a_of_type_JavaLangString = paramView;
        if (!"".equals(str1)) {
          localArticleItemViewHolder.d.setText(str1);
        }
        paramViewGroup.setTag(localArticleItemViewHolder);
        if (!"".equals(localObject2)) {
          localArticleItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a(80000003, (String)localObject2));
        }
        if (paramInt == 0) {
          if (!"".equals(localObject1)) {
            if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a(localArticleItemViewHolder.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a()) > 1)
            {
              localArticleItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setMaxLines(1);
              label949:
              localArticleItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a(80000003, (String)localObject1));
            }
          }
        }
        for (;;)
        {
          paramView = (ImageView)paramViewGroup.findViewById(2131302342);
          paramView.setVisibility(4);
          localObject1 = (ImageView)paramViewGroup.findViewById(2131298138);
          ((ImageView)localObject1).setVisibility(4);
          if ((localoik.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record != null) && (localoik.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.video_article.has()) && (localoik.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.video_article.get() == SearchUtils.e))
          {
            paramView.setVisibility(0);
            ((ImageView)localObject1).getBackground().setAlpha(25);
            ((ImageView)localObject1).setVisibility(0);
          }
          localObject1 = (TextView)paramViewGroup.findViewById(2131302343);
          ((TextView)localObject1).setVisibility(4);
          paramView = paramViewGroup;
          if (paramInt == 0) {
            break;
          }
          ((TextView)localObject1).setVisibility(0);
          return paramViewGroup;
          localObject2 = localoik.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.name.get();
          str1 = localoik.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.article_author.get();
          localObject1 = localoik.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.brief.get();
          localObject3 = localoik.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.title_image.get();
          str2 = localoik.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.article_create_time.get();
          paramView = localoik.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.article_short_url.get();
          localArticleItemViewHolder.jdField_a_of_type_Long = localoik.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.account_id.get();
          localArticleItemViewHolder.jdField_a_of_type_Int = localoik.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.number.get();
          break label763;
          localArticleItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setMaxLines(2);
          break label949;
          localArticleItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          continue;
          if (!"".equals(localObject1))
          {
            localArticleItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setMaxLines(1);
            localArticleItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a(80000003, (String)localObject1));
          }
          localArticleItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(AIOUtils.a(190.0F, paramViewGroup.getResources()));
          localArticleItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(1);
          localArticleItemViewHolder.d.setMaxLines(1);
        }
        localObject1 = paramView;
        if (paramView == null) {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a().getLayoutInflater().inflate(2130904056, paramViewGroup, false);
        }
        ((View)localObject1).setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment);
        paramView = new SearchBaseFragment.ItemViewHolder();
        paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131296907));
        paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131296908));
        paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131301214));
        paramView.jdField_c_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131299988));
        paramView.d = ((TextView)((View)localObject1).findViewById(2131299989));
        paramView.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record = ((oik)getItem(paramInt)).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record;
        paramView.jdField_b_of_type_Int = ((oik)getItem(paramInt)).jdField_b_of_type_Int;
        ((View)localObject1).setTag(paramView);
        paramView = (SearchBaseFragment.ItemViewHolder)((View)localObject1).getTag();
        paramView.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record = ((oik)getItem(paramInt)).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record;
        paramView.jdField_b_of_type_Int = ((oik)getItem(paramInt)).jdField_b_of_type_Int;
        paramView.jdField_c_of_type_Int = a(paramInt);
        paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a(paramView, (oik)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
        paramView = (View)localObject1;
        if (!AppSetting.j) {
          break;
        }
        ((View)localObject1).setContentDescription(paramViewGroup);
        return (View)localObject1;
        localObject1 = paramView;
        if (paramView == null) {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a().getLayoutInflater().inflate(2130904057, paramViewGroup, false);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.jdField_a_of_type_Oij == null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.jdField_a_of_type_Oij = new oij(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment);
        }
        ((View)localObject1).setTag(this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
        ((View)localObject1).setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.jdField_a_of_type_Oij);
        paramView = (View)localObject1;
        if (!AppSetting.j) {
          break;
        }
        ((View)localObject1).setContentDescription("查看更多" + this.jdField_a_of_type_JavaLangString + "搜索结果按钮");
        return (View)localObject1;
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 5;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */