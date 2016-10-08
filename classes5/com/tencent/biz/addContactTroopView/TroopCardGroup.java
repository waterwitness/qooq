package com.tencent.biz.addContactTroopView;

import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.widgets.ListViewForListview;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.contact.addcontact.ContactBaseView.IAddContactContext;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import hgd;
import hge;
import java.util.List;
import tencent.im.troop_search_searchtab.searchtab.Card;
import tencent.im.troop_search_searchtab.searchtab.Item1;
import tencent.im.troop_search_searchtab.searchtab.TitleBar;

public class TroopCardGroup
  extends BaseTroopCardView
{
  protected ImageView a;
  protected TextView a;
  protected TroopCardGroup.CMyAdapter a;
  protected ListViewForListview a;
  public List a;
  public searchtab.Card a;
  protected TextView b;
  
  public TroopCardGroup(ContactBaseView.IAddContactContext paramIAddContactContext)
  {
    super(paramIAddContactContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void a(searchtab.Item1 paramItem1)
  {
    if (paramItem1 == null) {}
    do
    {
      return;
      if (!TextUtils.isEmpty(paramItem1.str_transfer_url.get()))
      {
        String str = paramItem1.str_transfer_url.get();
        if (this.jdField_a_of_type_TencentImTroop_search_searchtabSearchtab$Card.title_bar.str_desc.get().contains("附近")) {
          paramItem1 = str + "&jump_from_group_search=" + String.valueOf(20);
        }
        for (;;)
        {
          a(paramItem1);
          return;
          paramItem1 = str;
          if (this.jdField_a_of_type_TencentImTroop_search_searchtabSearchtab$Card.title_bar.str_desc.get().contains("推荐")) {
            paramItem1 = str + "&jump_from_group_search=" + String.valueOf(21);
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("TroopCardGroup", 2, "goto groupInfoCard scheme is empty");
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299531));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131299528));
    this.b = ((TextView)findViewById(2131299529));
    this.jdField_a_of_type_ComTencentBizWidgetsListViewForListview = ((ListViewForListview)findViewById(2131299530));
    this.jdField_a_of_type_ComTencentBizAddContactTroopViewTroopCardGroup$CMyAdapter = new TroopCardGroup.CMyAdapter(this, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizWidgetsListViewForListview);
    this.jdField_a_of_type_ComTencentBizWidgetsListViewForListview.setAdapter(this.jdField_a_of_type_ComTencentBizAddContactTroopViewTroopCardGroup$CMyAdapter);
    this.jdField_a_of_type_ComTencentBizWidgetsListViewForListview.setOnItemClickListener(new hgd(this));
  }
  
  private void h()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private void i()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_TencentImTroop_search_searchtabSearchtab$Card.str_transfer_desc.get());
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new hge(this));
  }
  
  public void a()
  {
    setContentView(2130903637);
    g();
  }
  
  public void a(searchtab.Card paramCard)
  {
    if (paramCard != null)
    {
      this.jdField_a_of_type_TencentImTroop_search_searchtabSearchtab$Card = paramCard;
      this.jdField_a_of_type_JavaUtilList = ((searchtab.Card)this.jdField_a_of_type_TencentImTroop_search_searchtabSearchtab$Card.get()).rpt_item1.get();
      this.b.setText(((searchtab.TitleBar)this.jdField_a_of_type_TencentImTroop_search_searchtabSearchtab$Card.title_bar.get()).str_desc.get());
      int i = DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext.a(), 17.0F);
      int j = DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext.a(), 15.0F);
      paramCard = new LinearLayout.LayoutParams(i, i);
      paramCard.leftMargin = j;
      this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramCard);
      if (!TextUtils.isEmpty(((searchtab.TitleBar)this.jdField_a_of_type_TencentImTroop_search_searchtabSearchtab$Card.title_bar.get()).str_icon_url.get())) {
        break label196;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843486);
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_TencentImTroop_search_searchtabSearchtab$Card.str_transfer_desc.get())) && (!TextUtils.isEmpty(this.jdField_a_of_type_TencentImTroop_search_searchtabSearchtab$Card.str_transfer_url.get()))) {
        break label229;
      }
      h();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizAddContactTroopViewTroopCardGroup$CMyAdapter.notifyDataSetChanged();
      return;
      label196:
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getDrawable(((searchtab.TitleBar)this.jdField_a_of_type_TencentImTroop_search_searchtabSearchtab$Card.title_bar.get()).str_icon_url.get(), null));
      break;
      label229:
      i();
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentBizAddContactTroopViewTroopCardGroup$CMyAdapter != null) {
      this.jdField_a_of_type_ComTencentBizAddContactTroopViewTroopCardGroup$CMyAdapter.b();
    }
    super.f();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\addContactTroopView\TroopCardGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */