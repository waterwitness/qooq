package com.tencent.av.guild;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.app.SessionInfo.HeroDetail;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.BitmapTools;
import com.tencent.av.utils.UITools;
import com.tencent.av.widget.stageview.MemberEffect;
import com.tencent.av.widget.stageview.StageEffectView.StageMember;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import giq;
import gis;

public class GameHeroesUi
  implements giq
{
  static final String jdField_a_of_type_JavaLangString = "GameHeroesUi";
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  Resources jdField_a_of_type_AndroidContentResResources;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  RelativeLayout.LayoutParams jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public SessionInfo.HeroDetail a;
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  GameHeroesProtocol jdField_a_of_type_ComTencentAvGuildGameHeroesProtocol;
  StageEffectView.StageMember jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember;
  boolean jdField_a_of_type_Boolean;
  ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  Button jdField_b_of_type_AndroidWidgetButton;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  RelativeLayout.LayoutParams jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public boolean b;
  public Button c;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  RelativeLayout.LayoutParams jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  public TextView c;
  long jdField_d_of_type_Long;
  ImageView jdField_d_of_type_AndroidWidgetImageView;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  ImageView jdField_e_of_type_AndroidWidgetImageView;
  TextView jdField_e_of_type_AndroidWidgetTextView;
  ImageView jdField_f_of_type_AndroidWidgetImageView;
  TextView jdField_f_of_type_AndroidWidgetTextView;
  TextView g;
  TextView h;
  TextView i;
  TextView j;
  TextView k;
  TextView l;
  TextView m;
  TextView n;
  TextView o;
  TextView p;
  TextView q;
  
  GameHeroesUi(VideoAppInterface paramVideoAppInterface, GuildMultiActivity paramGuildMultiActivity, ViewGroup paramViewGroup1, ViewGroup paramViewGroup2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_AndroidContentResResources = null;
    this.jdField_a_of_type_AndroidViewViewGroup = null;
    this.jdField_b_of_type_AndroidViewViewGroup = null;
    this.jdField_a_of_type_ComTencentAvGuildGameHeroesProtocol = null;
    this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail = null;
    this.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    if (QLog.isDevelopLevel()) {
      QLog.d("GameHeroesUi", 2, "GameHeroesUi init");
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramGuildMultiActivity;
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup1;
    this.jdField_b_of_type_AndroidViewViewGroup = paramViewGroup2;
    this.jdField_a_of_type_ComTencentAvGuildGameHeroesProtocol = new GameHeroesProtocol(paramVideoAppInterface);
    this.jdField_a_of_type_ComTencentAvGuildGameHeroesProtocol.a(this);
  }
  
  BitmapDrawable a()
  {
    BitmapDrawable localBitmapDrawable = null;
    Object localObject1 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
    BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentResResources, 2130839236, (BitmapFactory.Options)localObject1);
    int i1 = ((BitmapFactory.Options)localObject1).outWidth / UITools.a(this.jdField_a_of_type_AndroidContentContext);
    int i2 = ((BitmapFactory.Options)localObject1).outHeight / UITools.b(this.jdField_a_of_type_AndroidContentContext);
    if (i1 < i2) {
      ((BitmapFactory.Options)localObject1).inSampleSize = i1;
    }
    for (;;)
    {
      if (((BitmapFactory.Options)localObject1).inSampleSize <= 0) {
        ((BitmapFactory.Options)localObject1).inSampleSize = 1;
      }
      ((BitmapFactory.Options)localObject1).inJustDecodeBounds = false;
      try
      {
        localObject1 = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentResResources, 2130839236, (BitmapFactory.Options)localObject1);
        if (localObject1 != null) {
          localBitmapDrawable = BitmapTools.a((Bitmap)localObject1, 20);
        }
        return localBitmapDrawable;
        ((BitmapFactory.Options)localObject1).inSampleSize = i2;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("GameHeroesUi", 2, "bg = null !");
          }
          Object localObject2 = null;
        }
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(new gis(this));
    }
  }
  
  void a(int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.jdField_a_of_type_JavaLangString;
    if (QLog.isColorLevel()) {
      QLog.d("GameHeroesUi", 2, "setShadeStatus uin :" + (String)localObject1 + ",pos" + paramInt);
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup.getBackground() == null) {
      this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundDrawable(a());
    }
    localObject1 = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131299222);
    Object localObject2 = (RelativeLayout.LayoutParams)((RelativeLayout)localObject1).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject2).topMargin = (paramInt - 54);
    ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131299226)).setImageDrawable(this.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getConstantState().newDrawable());
    ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131299225)).setContentDescription(this.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_AndroidContentResResources.getString(2131363796));
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131299227);
    localObject2 = this.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.jdField_b_of_type_JavaLangString;
    if (this.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.jdField_a_of_type_ComTencentAvWidgetStageviewMemberEffect != null)
    {
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.jdField_a_of_type_ComTencentAvWidgetStageviewMemberEffect.jdField_a_of_type_JavaLangString))
      {
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) || (!this.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.jdField_a_of_type_ComTencentAvWidgetStageviewMemberEffect.jdField_a_of_type_JavaLangString.contains("%s "))) {
          break label365;
        }
        localObject1 = this.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.jdField_a_of_type_ComTencentAvWidgetStageviewMemberEffect.jdField_a_of_type_JavaLangString.replace("%s ", "");
      }
    }
    for (paramInt = this.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.jdField_a_of_type_ComTencentAvWidgetStageviewMemberEffect.jdField_a_of_type_Int;; paramInt = -1)
    {
      localTextView.setTextColor(paramInt);
      localTextView.setText((CharSequence)localObject1);
      localTextView.setContentDescription((CharSequence)localObject1);
      localTextView.setTextSize(20.0F);
      if ((this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail == null) || ((this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.jdField_a_of_type_Int <= 0) && (this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.jdField_a_of_type_Int > -2))) {
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
      return;
      label365:
      localObject1 = String.format(this.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.jdField_a_of_type_ComTencentAvWidgetStageviewMemberEffect.jdField_a_of_type_JavaLangString, new Object[] { localObject2 });
      break;
      localObject1 = localObject2;
    }
  }
  
  public void a(int paramInt, long paramLong)
  {
    if ((paramInt == 0) && (this.jdField_c_of_type_AndroidWidgetButton != null))
    {
      this.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
      if (paramLong >= 30L)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetButton.setEnabled(true);
        this.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams.width = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131494051);
        this.jdField_c_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_AndroidContentResResources.getString(2131363798));
        this.jdField_c_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_AndroidContentResResources.getString(2131363798));
      }
    }
    else
    {
      return;
    }
    this.jdField_c_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentResResources.getString(2131363805));
    this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidContentResResources.getString(2131363805));
    this.jdField_c_of_type_AndroidWidgetButton.setText(2131363797);
    this.jdField_c_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_AndroidContentResResources.getString(2131363798));
  }
  
  void a(StageEffectView.StageMember paramStageMember, long paramLong1, SessionInfo.HeroDetail paramHeroDetail, int paramInt1, long paramLong2, int paramInt2)
  {
    if (this.jdField_a_of_type_Boolean) {}
    String str;
    do
    {
      return;
      str = paramStageMember.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember = paramStageMember;
      this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail = paramHeroDetail;
      this.jdField_a_of_type_Int = paramInt1;
      this.jdField_d_of_type_Long = paramLong2;
      this.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().equalsIgnoreCase(str);
      if (this.jdField_a_of_type_AndroidContentResResources == null) {
        d();
      }
    } while (this.jdField_a_of_type_AndroidContentResResources == null);
    f();
    if ((this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail == null) || (this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.jdField_a_of_type_Int <= 0))
    {
      a(paramInt2);
      label98:
      if (!this.jdField_b_of_type_Boolean) {
        break label166;
      }
      this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvGuildGameHeroesProtocol.a(str, paramLong1, this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail);
      return;
      e();
      break label98;
      label166:
      g();
    }
  }
  
  boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  void b()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
  }
  
  void b(int paramInt, long paramLong)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_d_of_type_Long = paramLong;
    g();
  }
  
  void c()
  {
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_AndroidViewViewGroup = null;
    this.jdField_b_of_type_AndroidViewViewGroup = null;
    this.jdField_a_of_type_AndroidContentResResources = null;
    if (this.jdField_a_of_type_ComTencentAvGuildGameHeroesProtocol != null)
    {
      this.jdField_a_of_type_ComTencentAvGuildGameHeroesProtocol.a(null);
      this.jdField_a_of_type_ComTencentAvGuildGameHeroesProtocol = null;
    }
  }
  
  void d()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("GameHeroesUi", 2, "initUI");
    }
    this.jdField_a_of_type_AndroidContentResResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131299229));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams = ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetButton.getLayoutParams());
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131299224));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131299230));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299219));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams = ((RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetButton.getLayoutParams());
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299190));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299220));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131299228));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299194));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299197));
    this.g = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299196));
    this.h = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299199));
    this.i = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299198));
    this.j = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299201));
    this.k = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299200));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299204));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299206));
    this.l = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299207));
    this.m = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299208));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299209));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299211));
    this.n = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299212));
    this.o = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299213));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299214));
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299216));
    this.p = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299217));
    this.q = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299218));
  }
  
  public void e()
  {
    ((ImageView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299192)).setImageDrawable(this.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getConstantState().newDrawable());
    String str2 = this.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.jdField_b_of_type_JavaLangString;
    ((RelativeLayout)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299191)).setContentDescription(str2 + this.jdField_a_of_type_AndroidContentResResources.getString(2131363796));
    TextView localTextView = (TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299193);
    String str1;
    if (this.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.jdField_a_of_type_ComTencentAvWidgetStageviewMemberEffect != null)
    {
      str1 = str2;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.jdField_a_of_type_ComTencentAvWidgetStageviewMemberEffect.jdField_a_of_type_JavaLangString))
      {
        if ((!TextUtils.isEmpty(str2)) || (!this.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.jdField_a_of_type_ComTencentAvWidgetStageviewMemberEffect.jdField_a_of_type_JavaLangString.contains("%s "))) {
          break label621;
        }
        str1 = this.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.jdField_a_of_type_ComTencentAvWidgetStageviewMemberEffect.jdField_a_of_type_JavaLangString.replace("%s ", "");
      }
    }
    for (int i1 = this.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.jdField_a_of_type_ComTencentAvWidgetStageviewMemberEffect.jdField_a_of_type_Int;; i1 = -1)
    {
      localTextView.setTextColor(i1);
      localTextView.setText(str1);
      localTextView.setContentDescription(str1);
      if (this.jdField_b_of_type_AndroidViewViewGroup.getBackground() == null) {
        this.jdField_b_of_type_AndroidViewViewGroup.setBackgroundDrawable(a());
      }
      if (this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail != null)
      {
        this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.jdField_a_of_type_JavaLangString + "：" + this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.jdField_b_of_type_JavaLangString);
        this.jdField_f_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.c);
        this.g.setText(this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.d);
        this.h.setText(this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.e);
        this.i.setText(this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.f);
        this.j.setText(this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.g);
        this.k.setText(this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.h);
        if (this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap == null) {
          break label717;
        }
      }
      label455:
      label529:
      label621:
      label687:
      label706:
      label717:
      for (i1 = this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap.length;; i1 = 0)
      {
        if ((i1 > 0) && (this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[0] != null))
        {
          this.jdField_d_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[0]);
          this.l.setText(this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.jdField_a_of_type_ArrayOfJavaLangString[0]);
          this.m.setText(this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.jdField_b_of_type_ArrayOfJavaLangString[0]);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299202).setVisibility(0);
          if ((i1 <= 1) || (this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[1] == null)) {
            break label687;
          }
          this.jdField_e_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[1]);
          this.n.setText(this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.jdField_a_of_type_ArrayOfJavaLangString[1]);
          this.o.setText(this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.jdField_b_of_type_ArrayOfJavaLangString[1]);
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          if ((i1 <= 2) || (this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[2] == null)) {
            break label706;
          }
          this.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[2]);
          this.p.setText(this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.jdField_a_of_type_ArrayOfJavaLangString[2]);
          this.q.setText(this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.jdField_b_of_type_ArrayOfJavaLangString[2]);
          this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        }
        for (;;)
        {
          this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
          this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
          return;
          str1 = String.format(this.jdField_a_of_type_ComTencentAvWidgetStageviewStageEffectView$StageMember.jdField_a_of_type_ComTencentAvWidgetStageviewMemberEffect.jdField_a_of_type_JavaLangString, new Object[] { str2 });
          break;
          this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131299202).setVisibility(4);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(4);
          this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(4);
          break label455;
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(4);
          this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(4);
          break label529;
          this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(4);
        }
      }
      str1 = str2;
    }
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail == null) || (this.jdField_a_of_type_ComTencentAvAppSessionInfo$HeroDetail.jdField_a_of_type_Int <= 0))
    {
      this.jdField_c_of_type_AndroidWidgetButton = this.jdField_a_of_type_AndroidWidgetButton;
      this.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams = this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams;
      this.jdField_c_of_type_AndroidWidgetImageView = this.jdField_a_of_type_AndroidWidgetImageView;
      this.jdField_c_of_type_AndroidWidgetTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      return;
    }
    this.jdField_c_of_type_AndroidWidgetButton = this.jdField_b_of_type_AndroidWidgetButton;
    this.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams = this.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams;
    this.jdField_c_of_type_AndroidWidgetImageView = this.jdField_b_of_type_AndroidWidgetImageView;
    this.jdField_c_of_type_AndroidWidgetTextView = this.jdField_b_of_type_AndroidWidgetTextView;
  }
  
  public void g()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      localObject1 = localObject2;
    }
    while (localObject1 != null)
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      return;
      localObject1 = this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130838975);
      this.jdField_c_of_type_AndroidWidgetButton.setEnabled(true);
      this.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams.width = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131494052);
      this.jdField_c_of_type_AndroidWidgetButton.setLayoutParams(this.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams);
      this.jdField_c_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_AndroidContentResResources.getString(2131363803));
      this.jdField_c_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_AndroidContentResResources.getString(2131363803));
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentResResources.getString(2131363802));
      this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidContentResResources.getString(2131363802));
      continue;
      localObject1 = this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130838979);
      this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentResResources.getString(2131363801));
      this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidContentResResources.getString(2131363801));
      continue;
      localObject1 = this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130838977);
      this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentResResources.getString(2131363804));
      this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidContentResResources.getString(2131363804));
      continue;
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
      if (this.jdField_d_of_type_Long >= 30L)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetButton.setEnabled(true);
        this.jdField_c_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_AndroidContentResResources.getString(2131363798));
        this.jdField_c_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_AndroidContentResResources.getString(2131363798));
      }
      for (;;)
      {
        this.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams.width = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131494051);
        this.jdField_c_of_type_AndroidWidgetButton.setLayoutParams(this.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams);
        localObject1 = localObject2;
        break;
        this.jdField_c_of_type_AndroidWidgetButton.setEnabled(false);
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentResResources.getString(2131363805));
        this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidContentResResources.getString(2131363805));
        this.jdField_c_of_type_AndroidWidgetButton.setText(2131363797);
        this.jdField_c_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_AndroidContentResResources.getString(2131363798));
      }
    }
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\guild\GameHeroesUi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */