package com.tencent.biz.addContactTroopView;

import android.text.TextUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.widgets.GridViewForScrollView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.contact.addcontact.ContactBaseView.IAddContactContext;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.util.DisplayUtil;
import hgg;
import hgh;
import hgi;
import java.util.List;
import tencent.im.troop_search_searchtab.searchtab.Card;
import tencent.im.troop_search_searchtab.searchtab.TitleBar;

public class TroopCardSameCity
  extends BaseTroopCardView
{
  protected BaseAdapter a;
  protected ImageView a;
  protected TextView a;
  protected GridViewForScrollView a;
  public List a;
  public searchtab.Card a;
  protected TextView b;
  
  public TroopCardSameCity(ContactBaseView.IAddContactContext paramIAddContactContext)
  {
    super(paramIAddContactContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidWidgetBaseAdapter = new hgi(this);
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131299528));
    this.b = ((TextView)findViewById(2131299531));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299529));
    this.jdField_a_of_type_ComTencentBizWidgetsGridViewForScrollView = ((GridViewForScrollView)findViewById(2131299533));
    this.jdField_a_of_type_ComTencentBizWidgetsGridViewForScrollView.setAdapter(this.jdField_a_of_type_AndroidWidgetBaseAdapter);
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentBizWidgetsGridViewForScrollView.setOnItemClickListener(new hgg(this));
  }
  
  private void i()
  {
    this.b.setVisibility(8);
  }
  
  private void j()
  {
    this.b.setVisibility(0);
    this.b.setText(this.jdField_a_of_type_TencentImTroop_search_searchtabSearchtab$Card.str_transfer_desc.get());
    this.b.setOnClickListener(new hgh(this));
  }
  
  public void a()
  {
    super.a();
    setContentView(2130903638);
    g();
    h();
  }
  
  public void a(searchtab.Card paramCard)
  {
    if (paramCard != null)
    {
      this.jdField_a_of_type_TencentImTroop_search_searchtabSearchtab$Card = paramCard;
      this.jdField_a_of_type_JavaUtilList = paramCard.rpt_item2.get();
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_TencentImTroop_search_searchtabSearchtab$Card.title_bar.str_desc.get());
      int i = DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext.a(), 17.0F);
      int j = DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext.a(), 15.0F);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i, i);
      localLayoutParams.leftMargin = j;
      this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
      if (!TextUtils.isEmpty(((searchtab.TitleBar)this.jdField_a_of_type_TencentImTroop_search_searchtabSearchtab$Card.title_bar.get()).str_icon_url.get())) {
        break label177;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843486);
      if ((!TextUtils.isEmpty(paramCard.str_transfer_desc.get())) && (!TextUtils.isEmpty(paramCard.str_transfer_url.get()))) {
        break label210;
      }
      i();
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
      return;
      label177:
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getDrawable(((searchtab.TitleBar)this.jdField_a_of_type_TencentImTroop_search_searchtabSearchtab$Card.title_bar.get()).str_icon_url.get(), null));
      break;
      label210:
      j();
    }
  }
  
  public void f()
  {
    super.f();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\addContactTroopView\TroopCardSameCity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */