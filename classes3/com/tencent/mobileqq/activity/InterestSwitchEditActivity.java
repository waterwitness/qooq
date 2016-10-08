package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import lpn;

public class InterestSwitchEditActivity
  extends IphoneTitleBarActivity
{
  public static final String a = "param_interest_switch";
  public static final String b = "param_music_switch";
  public static final String c = "param_recent_activity_switch";
  public static final String d = "param_star_switch";
  public static final String e = "param_joined_group_switch";
  public static final String f = "param_ktv_switch";
  public static final String g = "param_eat_switch";
  public static final String h = "param_reader_switch";
  public static final String i = "param_radio_switch";
  public static final String j = "param_now_switch";
  public static final String k = "param_comic_switch";
  public static final String l = "param_interest_switch_changed";
  public static final String m = "param_music_switch_changed";
  public static final String n = "param_recent_activity_switch_changed";
  public static final String o = "param_star_switch_changed";
  public static final String p = "param_joined_group_switch_changed";
  public static final String q = "param_ktv_switch_changed";
  public static final String r = "param_eat_switch_changed";
  public static final String s = "param_reader_switch_changed";
  public static final String t = "param_radio_switch_changed";
  public static final String u = "param_now_switch_changed";
  public static final String v = "param_comic_switch_changed";
  private CardHandler jdField_a_of_type_ComTencentMobileqqAppCardHandler;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver;
  private Card jdField_a_of_type_ComTencentMobileqqDataCard;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private FormSwitchItem b;
  private FormSwitchItem c;
  private FormSwitchItem d;
  private FormSwitchItem e;
  private FormSwitchItem f;
  private FormSwitchItem g;
  private FormSwitchItem h;
  private FormSwitchItem i;
  private FormSwitchItem j;
  private FormSwitchItem k;
  
  public InterestSwitchEditActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqAppCardObserver = new lpn(this);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_interest == 0) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
    }
    label36:
    label54:
    label72:
    label90:
    label108:
    label126:
    label144:
    label162:
    label198:
    label243:
    label265:
    label287:
    label309:
    label331:
    label353:
    label375:
    label397:
    label419:
    do
    {
      break label198;
      if (this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_music == 0)
      {
        this.b.setChecked(true);
        if (this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_recent_activity != 0) {
          break label243;
        }
        this.c.setChecked(true);
        if (this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_star != 0) {
          break label265;
        }
        this.d.setChecked(true);
        if (this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_joined_troop != 0) {
          break label287;
        }
        this.e.setChecked(true);
        if (this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_now != 0) {
          break label309;
        }
        this.f.setChecked(true);
        if (this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_ktv != 0) {
          break label331;
        }
        this.g.setChecked(true);
        if (this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_eat != 0) {
          break label353;
        }
        this.h.setChecked(true);
        if (this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_reader != 0) {
          break label375;
        }
        this.i.setChecked(true);
        if (this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_radio != 0) {
          break label397;
        }
        this.j.setChecked(true);
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_comic != 0) {
          break label419;
        }
        this.k.setChecked(true);
        return;
        if (1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_interest) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(false);
        break;
        if (1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_music) {
          break label36;
        }
        this.b.setChecked(false);
        break label36;
        if (1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_recent_activity) {
          break label54;
        }
        this.c.setChecked(false);
        break label54;
        if (1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_star) {
          break label72;
        }
        this.d.setChecked(false);
        break label72;
        if (1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_joined_troop) {
          break label90;
        }
        this.e.setChecked(false);
        break label90;
        if (1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_now) {
          break label108;
        }
        this.f.setChecked(false);
        break label108;
        if (1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_ktv) {
          break label126;
        }
        this.g.setChecked(false);
        break label126;
        if (1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_eat) {
          break label144;
        }
        this.h.setChecked(false);
        break label144;
        if (1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_reader) {
          break label162;
        }
        this.i.setChecked(false);
        break label162;
        if (1 == this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_radio) {
          this.j.setChecked(false);
        }
      }
    } while (1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_comic);
    this.k.setChecked(false);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130904292);
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    setTitle("兴趣爱好展示设置");
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131302204));
    this.b = ((FormSwitchItem)findViewById(2131302205));
    this.c = ((FormSwitchItem)findViewById(2131302206));
    this.d = ((FormSwitchItem)findViewById(2131302208));
    this.e = ((FormSwitchItem)findViewById(2131302209));
    this.g = ((FormSwitchItem)findViewById(2131302210));
    this.h = ((FormSwitchItem)findViewById(2131302211));
    this.i = ((FormSwitchItem)findViewById(2131302207));
    this.j = ((FormSwitchItem)findViewById(2131302212));
    this.f = ((FormSwitchItem)findViewById(2131302213));
    this.k = ((FormSwitchItem)findViewById(2131302214));
    int i2 = getIntent().getIntExtra("param_eat_switch", -1);
    int i3 = getIntent().getIntExtra("param_interest_switch", -1);
    int i4 = getIntent().getIntExtra("param_joined_group_switch", -1);
    int i5 = getIntent().getIntExtra("param_ktv_switch", -1);
    int i6 = getIntent().getIntExtra("param_music_switch", -1);
    int i7 = getIntent().getIntExtra("param_recent_activity_switch", -1);
    int i8 = getIntent().getIntExtra("param_star_switch", -1);
    int i9 = getIntent().getIntExtra("param_reader_switch", -1);
    int i10 = getIntent().getIntExtra("param_radio_switch", -1);
    int i11 = getIntent().getIntExtra("param_now_switch", -1);
    int i12 = getIntent().getIntExtra("param_comic_switch", -1);
    int i1 = 0;
    if ((-1 != i2) || (-1 != i3) || (-1 != i4) || (-1 != i5) || (-1 != i6) || (-1 != i7) || (-1 != i8) || (-1 != i9) || (-1 != i10) || (-1 != i11) || (-1 != i12)) {
      i1 = 1;
    }
    if (i1 != 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataCard = new Card();
      this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_eat = ((short)i2);
      this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_interest = ((short)i3);
      this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_joined_troop = ((short)i4);
      this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_ktv = ((short)i5);
      this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_music = ((short)i6);
      this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_recent_activity = ((short)i7);
      this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_star = ((short)i8);
      this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_reader = ((short)i9);
      this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_radio = ((short)i10);
      this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_now = ((short)i11);
      this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_comic = ((short)i12);
      a();
    }
    for (;;)
    {
      return true;
      if (!NetworkUtil.e(BaseApplication.getContext()))
      {
        QQToast.a(BaseApplicationImpl.a, 2131367481, 0).b(getTitleBarHeight());
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqAppCardHandler = ((CardHandler)this.app.a(2));
        this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.f();
      }
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.b(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
  }
  
  public void finish()
  {
    int i2 = 0;
    Intent localIntent = new Intent();
    if (this.jdField_a_of_type_ComTencentMobileqqDataCard != null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {
        break label589;
      }
      i1 = 0;
      localIntent.putExtra("param_interest_switch", i1);
      if (!this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {
        break label594;
      }
      i1 = 0;
      label49:
      if (i1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_interest) {
        localIntent.putExtra("param_interest_switch_changed", true);
      }
      if (!this.b.a()) {
        break label599;
      }
      i1 = 0;
      label80:
      localIntent.putExtra("param_music_switch", i1);
      if (!this.b.a()) {
        break label604;
      }
      i1 = 0;
      label100:
      if (i1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_music) {
        localIntent.putExtra("param_music_switch_changed", true);
      }
      if (!this.c.a()) {
        break label609;
      }
      i1 = 0;
      label131:
      localIntent.putExtra("param_recent_activity_switch", i1);
      if (!this.c.a()) {
        break label614;
      }
      i1 = 0;
      label151:
      if (i1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_recent_activity) {
        localIntent.putExtra("param_recent_activity_switch_changed", true);
      }
      if (!this.d.a()) {
        break label619;
      }
      i1 = 0;
      label182:
      localIntent.putExtra("param_star_switch", i1);
      if (!this.d.a()) {
        break label624;
      }
      i1 = 0;
      label202:
      if (i1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_star) {
        localIntent.putExtra("param_star_switch_changed", true);
      }
      if (!this.e.a()) {
        break label629;
      }
      i1 = 0;
      label233:
      localIntent.putExtra("param_joined_group_switch", i1);
      if (!this.e.a()) {
        break label634;
      }
      i1 = 0;
      label253:
      if (i1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_joined_troop) {
        localIntent.putExtra("param_joined_group_switch_changed", true);
      }
      if (!this.f.a()) {
        break label639;
      }
      i1 = 0;
      label284:
      localIntent.putExtra("param_now_switch", i1);
      if (!this.f.a()) {
        break label644;
      }
      i1 = 0;
      label304:
      if (i1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_now) {
        localIntent.putExtra("param_now_switch_changed", true);
      }
      if (!this.g.a()) {
        break label649;
      }
      i1 = 0;
      label335:
      localIntent.putExtra("param_ktv_switch", i1);
      if (!this.g.a()) {
        break label654;
      }
      i1 = 0;
      label355:
      if (i1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_ktv) {
        localIntent.putExtra("param_ktv_switch_changed", true);
      }
      if (!this.h.a()) {
        break label659;
      }
      i1 = 0;
      label386:
      localIntent.putExtra("param_eat_switch", i1);
      if (!this.h.a()) {
        break label664;
      }
      i1 = 0;
      label406:
      if (i1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_eat) {
        localIntent.putExtra("param_eat_switch_changed", true);
      }
      if (!this.i.a()) {
        break label669;
      }
      i1 = 0;
      label437:
      localIntent.putExtra("param_reader_switch", i1);
      if (!this.i.a()) {
        break label674;
      }
      i1 = 0;
      label457:
      if (i1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_reader) {
        localIntent.putExtra("param_reader_switch_changed", true);
      }
      if (!this.j.a()) {
        break label679;
      }
      i1 = 0;
      label488:
      localIntent.putExtra("param_radio_switch", i1);
      if (!this.j.a()) {
        break label684;
      }
      i1 = 0;
      label508:
      if (i1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_radio) {
        localIntent.putExtra("param_radio_switch_changed", true);
      }
      if (!this.k.a()) {
        break label689;
      }
      i1 = 0;
      label539:
      localIntent.putExtra("param_comic_switch", i1);
      if (!this.k.a()) {
        break label694;
      }
    }
    label589:
    label594:
    label599:
    label604:
    label609:
    label614:
    label619:
    label624:
    label629:
    label634:
    label639:
    label644:
    label649:
    label654:
    label659:
    label664:
    label669:
    label674:
    label679:
    label684:
    label689:
    label694:
    for (int i1 = i2;; i1 = 1)
    {
      if (i1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_comic) {
        localIntent.putExtra("param_comic_switch_changed", true);
      }
      setResult(-1, localIntent);
      super.finish();
      return;
      i1 = 1;
      break;
      i1 = 1;
      break label49;
      i1 = 1;
      break label80;
      i1 = 1;
      break label100;
      i1 = 1;
      break label131;
      i1 = 1;
      break label151;
      i1 = 1;
      break label182;
      i1 = 1;
      break label202;
      i1 = 1;
      break label233;
      i1 = 1;
      break label253;
      i1 = 1;
      break label284;
      i1 = 1;
      break label304;
      i1 = 1;
      break label335;
      i1 = 1;
      break label355;
      i1 = 1;
      break label386;
      i1 = 1;
      break label406;
      i1 = 1;
      break label437;
      i1 = 1;
      break label457;
      i1 = 1;
      break label488;
      i1 = 1;
      break label508;
      i1 = 1;
      break label539;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\InterestSwitchEditActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */